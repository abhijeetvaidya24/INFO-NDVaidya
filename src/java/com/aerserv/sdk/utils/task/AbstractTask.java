/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.Thread
 *  java.util.concurrent.atomic.AtomicBoolean
 */
package com.aerserv.sdk.utils.task;

import com.aerserv.sdk.utils.VerySimpleTimer;
import com.aerserv.sdk.utils.task.AbstractTask;
import com.aerserv.sdk.utils.task.Task;
import com.aerserv.sdk.utils.task.TaskListener;
import com.aerserv.sdk.utils.task.TaskResult;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class AbstractTask<P, R>
implements Task<P, R> {
    private static final long RESULT_POLLING_FREQUENCY = 50L;
    private final AtomicBoolean hasRun = new AtomicBoolean(false);
    private TaskListener<R> listener = null;
    private TaskResult<R> taskResult = null;
    private final Object taskResultLock = new Object();
    protected long timeout = 1000L;

    static /* synthetic */ TaskResult access$000(AbstractTask abstractTask) {
        return abstractTask.taskResult;
    }

    static /* synthetic */ TaskListener access$100(AbstractTask abstractTask) {
        return abstractTask.listener;
    }

    @Override
    public boolean cancel() {
        this.setResult(TaskResult.canceled());
        return true;
    }

    protected /* varargs */ abstract void doWork(P ... var1);

    public boolean isRunning() {
        return this.hasRun.get() && this.taskResult == null;
    }

    @Override
    public final /* varargs */ void run(P ... arrP) {
        if (!this.hasRun.compareAndSet(false, true)) {
            this.setResult(TaskResult.failed("This task has already been run"));
            return;
        }
        new VerySimpleTimer(new Runnable(this){
            final /* synthetic */ AbstractTask this$0;
            {
                this.this$0 = abstractTask;
            }

            public void run() {
                if (AbstractTask.access$000(this.this$0) == null) {
                    this.this$0.setResult(TaskResult.<T>timedOut());
                }
            }
        }, this.timeout).start();
        new Thread(new Runnable(this, arrP){
            final /* synthetic */ AbstractTask this$0;
            final /* synthetic */ Object[] val$params;
            {
                this.this$0 = abstractTask;
                this.val$params = arrobject;
            }

            public void run() {
                this.this$0.doWork(this.val$params);
            }
        }).start();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected TaskResult<R> setResult(TaskResult<R> taskResult) {
        Object object;
        Object object2 = object = this.taskResultLock;
        synchronized (object2) {
            if (this.taskResult != null) return this.taskResult;
            this.taskResult = taskResult;
            if (this.listener == null) return this.taskResult;
            new Thread(new Runnable(this){
                final /* synthetic */ AbstractTask this$0;
                {
                    this.this$0 = abstractTask;
                }

                public void run() {
                    AbstractTask.access$100(this.this$0).onTaskResult(AbstractTask.access$000(this.this$0));
                }
            }).start();
            return this.taskResult;
        }
    }

    /*
     * Exception decompiling
     */
    @Override
    public TaskResult<R> waitForResult() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl1 : ALOAD_0 : trying to set 1 previously set to 0
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:919)
        throw new IllegalStateException("Decompilation failed");
    }

    @Override
    public Task<P, R> withListener(TaskListener<R> taskListener) {
        this.listener = taskListener;
        return this;
    }

    @Override
    public Task<P, R> withTimeout(long l2) {
        this.timeout = l2;
        return this;
    }
}


/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Service
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.os.AsyncTask
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.IBinder
 *  com.onesignal.JobIntentService$CompatWorkEnqueuer
 *  com.onesignal.JobIntentService$CompatWorkItem
 *  com.onesignal.JobIntentService$JobServiceEngineImpl
 *  com.onesignal.JobIntentService$JobWorkEnqueuer
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Void
 *  java.util.ArrayList
 *  java.util.HashMap
 *  java.util.concurrent.Executor
 */
package com.onesignal;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.IBinder;
import com.onesignal.JobIntentService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Executor;

/*
 * Exception performing whole class analysis.
 */
abstract class JobIntentService
extends Service {
    static final HashMap<ComponentNameWithWakeful, WorkEnqueuer> sClassWorkEnqueuer;
    static final Object sLock;
    final ArrayList<CompatWorkItem> mCompatQueue;
    WorkEnqueuer mCompatWorkEnqueuer;
    CommandProcessor mCurProcessor;
    boolean mDestroyed;
    boolean mInterruptIfStopped;
    CompatJobEngine mJobImpl;
    boolean mStopped;

    static {
        sLock = new Object();
        sClassWorkEnqueuer = new HashMap();
    }

    public JobIntentService() {
        this.mInterruptIfStopped = false;
        this.mStopped = false;
        this.mDestroyed = false;
        this.mCompatQueue = new ArrayList();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void enqueueWork(Context context, ComponentName componentName, int n2, Intent intent, boolean bl2) {
        Object object;
        if (intent == null) {
            throw new IllegalArgumentException("work must not be null");
        }
        Object object2 = object = sLock;
        synchronized (object2) {
            IllegalStateException illegalStateException2;
            block5 : {
                WorkEnqueuer workEnqueuer = JobIntentService.getWorkEnqueuer(context, componentName, true, n2, bl2);
                workEnqueuer.ensureJobId(n2);
                try {
                    workEnqueuer.enqueueWork(intent);
                }
                catch (IllegalStateException illegalStateException2) {
                    if (!bl2) break block5;
                    JobIntentService.getWorkEnqueuer(context, componentName, true, n2, false).enqueueWork(intent);
                }
                return;
            }
            throw illegalStateException2;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    static WorkEnqueuer getWorkEnqueuer(Context context, ComponentName componentName, boolean bl2, int n2, boolean bl3) {
        CompatWorkEnqueuer compatWorkEnqueuer;
        ComponentNameWithWakeful componentNameWithWakeful = new ComponentNameWithWakeful(componentName, bl3);
        WorkEnqueuer workEnqueuer = (WorkEnqueuer)sClassWorkEnqueuer.get((Object)componentNameWithWakeful);
        if (workEnqueuer != null) return workEnqueuer;
        if (Build.VERSION.SDK_INT >= 26 && !bl3) {
            if (!bl2) throw new IllegalArgumentException("Can't be here without a job id");
            compatWorkEnqueuer = new /* Unavailable Anonymous Inner Class!! */;
        } else {
            compatWorkEnqueuer = new /* Unavailable Anonymous Inner Class!! */;
        }
        workEnqueuer = compatWorkEnqueuer;
        sClassWorkEnqueuer.put((Object)componentNameWithWakeful, (Object)workEnqueuer);
        return workEnqueuer;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    GenericWorkItem dequeueWork() {
        GenericWorkItem genericWorkItem;
        ArrayList<CompatWorkItem> arrayList;
        CompatJobEngine compatJobEngine = this.mJobImpl;
        if (compatJobEngine != null && (genericWorkItem = compatJobEngine.dequeueWork()) != null) {
            return genericWorkItem;
        }
        ArrayList<CompatWorkItem> arrayList2 = arrayList = this.mCompatQueue;
        synchronized (arrayList2) {
            if (this.mCompatQueue.size() <= 0) return null;
            return (GenericWorkItem)this.mCompatQueue.remove(0);
        }
    }

    boolean doStopCurrentWork() {
        CommandProcessor commandProcessor = this.mCurProcessor;
        if (commandProcessor != null) {
            commandProcessor.cancel(this.mInterruptIfStopped);
        }
        this.mStopped = true;
        return this.onStopCurrentWork();
    }

    void ensureProcessorRunningLocked(boolean bl2) {
        if (this.mCurProcessor == null) {
            this.mCurProcessor = new CommandProcessor();
            WorkEnqueuer workEnqueuer = this.mCompatWorkEnqueuer;
            if (workEnqueuer != null && bl2) {
                workEnqueuer.serviceProcessingStarted();
            }
            this.mCurProcessor.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (Object[])new Void[0]);
        }
    }

    public IBinder onBind(Intent intent) {
        CompatJobEngine compatJobEngine = this.mJobImpl;
        if (compatJobEngine != null) {
            return compatJobEngine.compatGetBinder();
        }
        return null;
    }

    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 26) {
            this.mJobImpl = new /* Unavailable Anonymous Inner Class!! */;
            this.mCompatWorkEnqueuer = null;
        }
        this.mCompatWorkEnqueuer = JobIntentService.getWorkEnqueuer((Context)this, new ComponentName((Context)this, this.getClass()), false, 0, true);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onDestroy() {
        ArrayList<CompatWorkItem> arrayList;
        super.onDestroy();
        this.doStopCurrentWork();
        ArrayList<CompatWorkItem> arrayList2 = arrayList = this.mCompatQueue;
        synchronized (arrayList2) {
            this.mDestroyed = true;
            this.mCompatWorkEnqueuer.serviceProcessingFinished();
            return;
        }
    }

    protected abstract void onHandleWork(Intent var1);

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int onStartCommand(Intent intent, int n2, int n3) {
        ArrayList<CompatWorkItem> arrayList;
        this.mCompatWorkEnqueuer.serviceStartReceived();
        ArrayList<CompatWorkItem> arrayList2 = arrayList = this.mCompatQueue;
        synchronized (arrayList2) {
            ArrayList<CompatWorkItem> arrayList3 = this.mCompatQueue;
            if (intent == null) {
                intent = new Intent();
            }
            arrayList3.add((Object)new /* Unavailable Anonymous Inner Class!! */);
            this.ensureProcessorRunningLocked(true);
            return 3;
        }
    }

    public boolean onStopCurrentWork() {
        return true;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    void processorFinished() {
        ArrayList<CompatWorkItem> arrayList = this.mCompatQueue;
        if (arrayList == null) {
            return;
        }
        ArrayList<CompatWorkItem> arrayList2 = arrayList;
        synchronized (arrayList2) {
            this.mCurProcessor = null;
            if (this.mCompatQueue != null && this.mCompatQueue.size() > 0) {
                this.ensureProcessorRunningLocked(false);
            } else if (!this.mDestroyed) {
                this.mCompatWorkEnqueuer.serviceProcessingFinished();
            }
            return;
        }
    }

    final class CommandProcessor
    extends AsyncTask<Void, Void, Void> {
        CommandProcessor() {
        }

        protected /* varargs */ Void doInBackground(Void ... arrvoid) {
            GenericWorkItem genericWorkItem;
            while ((genericWorkItem = JobIntentService.this.dequeueWork()) != null) {
                JobIntentService.this.onHandleWork(genericWorkItem.getIntent());
                genericWorkItem.complete();
            }
            return null;
        }

        protected void onCancelled(Void void_) {
            JobIntentService.this.processorFinished();
        }

        protected void onPostExecute(Void void_) {
            JobIntentService.this.processorFinished();
        }
    }

    static interface CompatJobEngine {
        public IBinder compatGetBinder();

        public GenericWorkItem dequeueWork();
    }

    private static class ComponentNameWithWakeful {
        private ComponentName componentName;
        private boolean useWakefulService;

        ComponentNameWithWakeful(ComponentName componentName, boolean bl2) {
            this.componentName = componentName;
            this.useWakefulService = bl2;
        }
    }

    static interface GenericWorkItem {
        public void complete();

        public Intent getIntent();
    }

    static abstract class WorkEnqueuer {
        final ComponentName mComponentName;
        boolean mHasJobId;
        int mJobId;

        WorkEnqueuer(ComponentName componentName) {
            this.mComponentName = componentName;
        }

        abstract void enqueueWork(Intent var1);

        void ensureJobId(int n2) {
            if (!this.mHasJobId) {
                this.mHasJobId = true;
                this.mJobId = n2;
                return;
            }
            if (this.mJobId == n2) {
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Given job ID ");
            stringBuilder.append(n2);
            stringBuilder.append(" is different than previous ");
            stringBuilder.append(this.mJobId);
            throw new IllegalArgumentException(stringBuilder.toString());
        }

        public void serviceProcessingFinished() {
        }

        public void serviceProcessingStarted() {
        }

        public void serviceStartReceived() {
        }
    }

}


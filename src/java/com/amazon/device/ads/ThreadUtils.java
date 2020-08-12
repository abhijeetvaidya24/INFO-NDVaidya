/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.AsyncTask
 *  android.os.Looper
 *  com.amazon.device.ads.MobileAdsLogger
 *  com.amazon.device.ads.ThreadUtils$BackgroundThreadRunner
 *  com.amazon.device.ads.ThreadUtils$MainThreadRunner
 *  com.amazon.device.ads.ThreadUtils$MainThreadScheduler
 *  com.amazon.device.ads.ThreadUtils$ThreadPoolScheduler
 *  java.lang.Enum
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Thread
 *  java.util.HashMap
 */
package com.amazon.device.ads;

import android.os.AsyncTask;
import android.os.Looper;
import com.amazon.device.ads.AndroidTargetUtils;
import com.amazon.device.ads.MobileAdsLogger;
import com.amazon.device.ads.MobileAdsLoggerFactory;
import com.amazon.device.ads.ThreadUtils;
import java.util.HashMap;

class ThreadUtils {
    private static ThreadRunner threadRunner = new ThreadRunner();

    ThreadUtils() {
    }

    public static final /* varargs */ <T> void executeAsyncTask(MobileAdsAsyncTask<T, ?, ?> mobileAdsAsyncTask, T ... arrT) {
        threadRunner.executeAsyncTask(ExecutionStyle.RUN_ASAP, ExecutionThread.MAIN_THREAD, mobileAdsAsyncTask, arrT);
    }

    public static final /* varargs */ <T> void executeAsyncTask(ThreadRunner threadRunner, ExecutionStyle executionStyle, ExecutionThread executionThread, MobileAdsAsyncTask<T, ?, ?> mobileAdsAsyncTask, T ... arrT) {
        threadRunner.executeAsyncTask(executionStyle, executionThread, mobileAdsAsyncTask, arrT);
    }

    public static void executeOnMainThread(Runnable runnable) {
        ThreadUtils.executeOnMainThread(runnable, threadRunner);
    }

    public static void executeOnMainThread(Runnable runnable, ThreadRunner threadRunner) {
        threadRunner.execute(runnable, ExecutionStyle.RUN_ASAP, ExecutionThread.MAIN_THREAD);
    }

    public static void executeRunnableWithThreadCheck(Runnable runnable) {
        ThreadUtils.executeRunnableWithThreadCheck(runnable, threadRunner);
    }

    public static void executeRunnableWithThreadCheck(Runnable runnable, ThreadRunner threadRunner) {
        threadRunner.execute(runnable, ExecutionStyle.RUN_ASAP, ExecutionThread.BACKGROUND_THREAD);
    }

    public static ThreadRunner getThreadRunner() {
        return threadRunner;
    }

    public static boolean isOnMainThread() {
        return ThreadVerify.getInstance().isOnMainThread();
    }

    public static void scheduleOnMainThread(Runnable runnable) {
        ThreadUtils.scheduleOnMainThread(runnable, threadRunner);
    }

    public static void scheduleOnMainThread(Runnable runnable, ThreadRunner threadRunner) {
        threadRunner.execute(runnable, ExecutionStyle.SCHEDULE, ExecutionThread.MAIN_THREAD);
    }

    public static void scheduleRunnable(Runnable runnable) {
        ThreadUtils.scheduleRunnable(runnable, threadRunner);
    }

    public static void scheduleRunnable(Runnable runnable, ThreadRunner threadRunner) {
        threadRunner.execute(runnable, ExecutionStyle.SCHEDULE, ExecutionThread.BACKGROUND_THREAD);
    }

    static void setThreadRunner(ThreadRunner threadRunner) {
        ThreadUtils.threadRunner = threadRunner;
    }

    public static final class ExecutionStyle
    extends Enum<ExecutionStyle> {
        private static final /* synthetic */ ExecutionStyle[] $VALUES;
        public static final /* enum */ ExecutionStyle RUN_ASAP = new ExecutionStyle();
        public static final /* enum */ ExecutionStyle SCHEDULE = new ExecutionStyle();

        static {
            ExecutionStyle[] arrexecutionStyle = new ExecutionStyle[]{RUN_ASAP, SCHEDULE};
            $VALUES = arrexecutionStyle;
        }

        public static ExecutionStyle valueOf(String string) {
            return (ExecutionStyle)Enum.valueOf(ExecutionStyle.class, (String)string);
        }

        public static ExecutionStyle[] values() {
            return (ExecutionStyle[])$VALUES.clone();
        }
    }

    public static final class ExecutionThread
    extends Enum<ExecutionThread> {
        private static final /* synthetic */ ExecutionThread[] $VALUES;
        public static final /* enum */ ExecutionThread BACKGROUND_THREAD;
        public static final /* enum */ ExecutionThread MAIN_THREAD;

        static {
            MAIN_THREAD = new ExecutionThread();
            BACKGROUND_THREAD = new ExecutionThread();
            ExecutionThread[] arrexecutionThread = new ExecutionThread[]{MAIN_THREAD, BACKGROUND_THREAD};
            $VALUES = arrexecutionThread;
        }

        public static ExecutionThread valueOf(String string) {
            return (ExecutionThread)Enum.valueOf(ExecutionThread.class, (String)string);
        }

        public static ExecutionThread[] values() {
            return (ExecutionThread[])$VALUES.clone();
        }
    }

    static abstract class MobileAdsAsyncTask<Params, Progress, Result>
    extends AsyncTask<Params, Progress, Result> {
        MobileAdsAsyncTask() {
        }

        protected /* varargs */ abstract Result doInBackground(Params ... var1);

        protected void onPostExecute(Result Result) {
            super.onPostExecute(Result);
        }

        protected void onPreExecute() {
            super.onPreExecute();
        }
    }

    public static abstract class RunnableExecutor {
        private final ExecutionStyle executionStyle;
        private final ExecutionThread executionThread;

        public RunnableExecutor(ExecutionStyle executionStyle, ExecutionThread executionThread) {
            this.executionStyle = executionStyle;
            this.executionThread = executionThread;
        }

        static /* synthetic */ ExecutionThread access$100(RunnableExecutor runnableExecutor) {
            return runnableExecutor.executionThread;
        }

        public abstract void execute(Runnable var1);

        public ExecutionStyle getExecutionStyle() {
            return this.executionStyle;
        }

        public ExecutionThread getExecutionThread() {
            return this.executionThread;
        }
    }

    /*
     * Exception performing whole class analysis.
     */
    public static class ThreadRunner {
        private static final String LOGTAG = "ThreadRunner";
        private final HashMap<ExecutionStyle, HashMap<ExecutionThread, RunnableExecutor>> executors;
        private final MobileAdsLogger logger;

        ThreadRunner() {
            this(new MobileAdsLoggerFactory());
            ThreadVerify threadVerify = new ThreadVerify();
            this.withExecutor((RunnableExecutor)new /* Unavailable Anonymous Inner Class!! */);
            this.withExecutor((RunnableExecutor)new /* Unavailable Anonymous Inner Class!! */);
            this.withExecutor((RunnableExecutor)new /* Unavailable Anonymous Inner Class!! */);
            this.withExecutor((RunnableExecutor)new /* Unavailable Anonymous Inner Class!! */);
        }

        ThreadRunner(MobileAdsLoggerFactory mobileAdsLoggerFactory) {
            this.executors = new HashMap();
            this.logger = mobileAdsLoggerFactory.createMobileAdsLogger(LOGTAG);
        }

        public void execute(Runnable runnable, ExecutionStyle executionStyle, ExecutionThread executionThread) {
            HashMap hashMap = (HashMap)this.executors.get((Object)executionStyle);
            if (hashMap == null) {
                this.logger.e("No executor available for %s execution style.", new Object[]{executionStyle});
                return;
            }
            RunnableExecutor runnableExecutor = (RunnableExecutor)hashMap.get((Object)executionThread);
            if (runnableExecutor == null) {
                this.logger.e("No executor available for %s execution style on % execution thread.", new Object[]{executionStyle, executionThread});
            }
            runnableExecutor.execute(runnable);
        }

        public /* varargs */ <T> void executeAsyncTask(ExecutionStyle executionStyle, ExecutionThread executionThread, final MobileAdsAsyncTask<T, ?, ?> mobileAdsAsyncTask, final T ... arrT) {
            threadRunner.execute(new Runnable(){

                public void run() {
                    AndroidTargetUtils.executeAsyncTask(mobileAdsAsyncTask, arrT);
                }
            }, executionStyle, executionThread);
        }

        public /* varargs */ <T> void executeAsyncTask(MobileAdsAsyncTask<T, ?, ?> mobileAdsAsyncTask, T ... arrT) {
            this.executeAsyncTask(ExecutionStyle.RUN_ASAP, ExecutionThread.MAIN_THREAD, mobileAdsAsyncTask, arrT);
        }

        public ThreadRunner withExecutor(RunnableExecutor runnableExecutor) {
            HashMap hashMap = (HashMap)this.executors.get((Object)runnableExecutor.getExecutionStyle());
            if (hashMap == null) {
                hashMap = new HashMap();
                this.executors.put((Object)runnableExecutor.getExecutionStyle(), (Object)hashMap);
            }
            hashMap.put((Object)runnableExecutor.getExecutionThread(), (Object)runnableExecutor);
            return this;
        }

    }

    static class ThreadVerify {
        private static ThreadVerify instance = new ThreadVerify();

        ThreadVerify() {
        }

        static ThreadVerify getInstance() {
            return instance;
        }

        boolean isOnMainThread() {
            return Looper.getMainLooper().getThread() == Thread.currentThread();
        }
    }

}


/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.os.Handler
 *  android.os.HandlerThread
 *  android.os.Looper
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.onesignal;

import android.app.Activity;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.onesignal.OneSignal;

class ActivityLifecycleHandler {
    static Activity curActivity;
    static FocusHandlerThread focusHandlerThread;
    private static ActivityAvailableListener mActivityAvailableListener;
    static boolean nextResumeIsFirstActivity;

    static {
        focusHandlerThread = new FocusHandlerThread();
    }

    private static void handleFocus() {
        if (!focusHandlerThread.hasBackgrounded() && !nextResumeIsFirstActivity) {
            focusHandlerThread.stopScheduledRunnable();
            return;
        }
        nextResumeIsFirstActivity = false;
        focusHandlerThread.resetBackgroundState();
        OneSignal.onAppFocus();
    }

    private static void handleLostFocus() {
        focusHandlerThread.runRunnable(new AppFocusRunnable());
    }

    private static void logCurActivity() {
        String string2;
        OneSignal.LOG_LEVEL lOG_LEVEL = OneSignal.LOG_LEVEL.DEBUG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("curActivity is NOW: ");
        if (curActivity != null) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("");
            stringBuilder2.append(curActivity.getClass().getName());
            stringBuilder2.append(":");
            stringBuilder2.append((Object)curActivity);
            string2 = stringBuilder2.toString();
        } else {
            string2 = "null";
        }
        stringBuilder.append(string2);
        OneSignal.Log(lOG_LEVEL, stringBuilder.toString());
    }

    static void onActivityCreated(Activity activity) {
    }

    static void onActivityDestroyed(Activity activity) {
        OneSignal.LOG_LEVEL lOG_LEVEL = OneSignal.LOG_LEVEL.DEBUG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onActivityDestroyed: ");
        stringBuilder.append(activity.getClass().getName());
        OneSignal.Log(lOG_LEVEL, stringBuilder.toString());
        if (activity == curActivity) {
            curActivity = null;
            ActivityLifecycleHandler.handleLostFocus();
        }
        ActivityLifecycleHandler.logCurActivity();
    }

    static void onActivityPaused(Activity activity) {
        if (activity == curActivity) {
            curActivity = null;
            ActivityLifecycleHandler.handleLostFocus();
        }
        ActivityLifecycleHandler.logCurActivity();
    }

    static void onActivityResumed(Activity activity) {
        ActivityLifecycleHandler.setCurActivity(activity);
        ActivityLifecycleHandler.logCurActivity();
        ActivityLifecycleHandler.handleFocus();
    }

    static void onActivityStarted(Activity activity) {
    }

    static void onActivityStopped(Activity activity) {
        OneSignal.LOG_LEVEL lOG_LEVEL = OneSignal.LOG_LEVEL.DEBUG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onActivityStopped: ");
        stringBuilder.append(activity.getClass().getName());
        OneSignal.Log(lOG_LEVEL, stringBuilder.toString());
        if (activity == curActivity) {
            curActivity = null;
            ActivityLifecycleHandler.handleLostFocus();
        }
        ActivityLifecycleHandler.logCurActivity();
    }

    public static void removeActivityAvailableListener(ActivityAvailableListener activityAvailableListener) {
        mActivityAvailableListener = null;
    }

    static void setActivityAvailableListener(ActivityAvailableListener activityAvailableListener) {
        Activity activity = curActivity;
        if (activity != null) {
            activityAvailableListener.available(activity);
            mActivityAvailableListener = activityAvailableListener;
            return;
        }
        mActivityAvailableListener = activityAvailableListener;
    }

    private static void setCurActivity(Activity activity) {
        curActivity = activity;
        ActivityAvailableListener activityAvailableListener = mActivityAvailableListener;
        if (activityAvailableListener != null) {
            activityAvailableListener.available(curActivity);
        }
    }

    static interface ActivityAvailableListener {
        public void available(Activity var1);
    }

    private static class AppFocusRunnable
    implements Runnable {
        private boolean backgrounded;
        private boolean completed;

        private AppFocusRunnable() {
        }

        public void run() {
            if (ActivityLifecycleHandler.curActivity != null) {
                return;
            }
            this.backgrounded = true;
            OneSignal.onAppLostFocus();
            this.completed = true;
        }
    }

    static class FocusHandlerThread
    extends HandlerThread {
        private AppFocusRunnable appFocusRunnable;
        Handler mHandler = null;

        FocusHandlerThread() {
            super("FocusHandlerThread");
            this.start();
            this.mHandler = new Handler(this.getLooper());
        }

        boolean hasBackgrounded() {
            AppFocusRunnable appFocusRunnable = this.appFocusRunnable;
            return appFocusRunnable != null && appFocusRunnable.backgrounded;
        }

        void resetBackgroundState() {
            AppFocusRunnable appFocusRunnable = this.appFocusRunnable;
            if (appFocusRunnable != null) {
                appFocusRunnable.backgrounded = false;
            }
        }

        void runRunnable(AppFocusRunnable appFocusRunnable) {
            AppFocusRunnable appFocusRunnable2 = this.appFocusRunnable;
            if (appFocusRunnable2 != null && appFocusRunnable2.backgrounded && !this.appFocusRunnable.completed) {
                return;
            }
            this.appFocusRunnable = appFocusRunnable;
            this.mHandler.removeCallbacksAndMessages(null);
            this.mHandler.postDelayed((Runnable)appFocusRunnable, 2000L);
        }

        void stopScheduledRunnable() {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

}


/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.os.Bundle
 *  java.lang.Object
 */
package com.onesignal;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.onesignal.ActivityLifecycleHandler;

class ActivityLifecycleListener
implements Application.ActivityLifecycleCallbacks {
    ActivityLifecycleListener() {
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        ActivityLifecycleHandler.onActivityCreated(activity);
    }

    public void onActivityDestroyed(Activity activity) {
        ActivityLifecycleHandler.onActivityDestroyed(activity);
    }

    public void onActivityPaused(Activity activity) {
        ActivityLifecycleHandler.onActivityPaused(activity);
    }

    public void onActivityResumed(Activity activity) {
        ActivityLifecycleHandler.onActivityResumed(activity);
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
        ActivityLifecycleHandler.onActivityStarted(activity);
    }

    public void onActivityStopped(Activity activity) {
        ActivityLifecycleHandler.onActivityStopped(activity);
    }
}


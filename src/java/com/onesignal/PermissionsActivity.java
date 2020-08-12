/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  com.onesignal.PermissionsActivity$1
 *  java.lang.String
 */
package com.onesignal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import com.onesignal.ActivityLifecycleHandler;
import com.onesignal.AndroidSupportV4Compat;
import com.onesignal.LocationGMS;
import com.onesignal.OneSignal;
import com.onesignal.PermissionsActivity;

public class PermissionsActivity
extends Activity {
    private static ActivityLifecycleHandler.ActivityAvailableListener activityAvailableListener;
    static boolean answered;
    static boolean waiting;

    private void requestPermission() {
        if (Build.VERSION.SDK_INT < 23) {
            this.finish();
            return;
        }
        if (!waiting) {
            waiting = true;
            String[] arrstring = new String[]{LocationGMS.requestPermission};
            AndroidSupportV4Compat.ActivityCompat.requestPermissions(this, arrstring, 2);
        }
    }

    static void startPrompt() {
        if (!waiting) {
            if (answered) {
                return;
            }
            activityAvailableListener = new 1();
            ActivityLifecycleHandler.setActivityAvailableListener(activityAvailableListener);
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        OneSignal.setAppContext((Context)this);
        if (bundle != null && bundle.getBoolean("android:hasCurrentPermissionsRequest", false)) {
            waiting = true;
            return;
        }
        this.requestPermission();
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (OneSignal.initDone) {
            this.requestPermission();
        }
    }

    public void onRequestPermissionsResult(int n2, String[] arrstring, int[] arrn) {
        answered = true;
        waiting = false;
        if (n2 == 2) {
            if (arrn.length > 0 && arrn[0] == 0) {
                LocationGMS.startGetLocation();
            } else {
                LocationGMS.fireFailedComplete();
            }
        }
        ActivityLifecycleHandler.removeActivityAvailableListener(activityAvailableListener);
        this.finish();
    }
}


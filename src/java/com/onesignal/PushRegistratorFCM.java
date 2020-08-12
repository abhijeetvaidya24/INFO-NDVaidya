/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.pm.PackageManager
 *  com.google.firebase.FirebaseApp
 *  com.google.firebase.FirebaseOptions
 *  com.google.firebase.FirebaseOptions$Builder
 *  com.google.firebase.iid.FirebaseInstanceId
 *  com.google.firebase.iid.FirebaseInstanceIdService
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.NoClassDefFoundError
 *  java.lang.String
 *  java.lang.Throwable
 */
package com.onesignal;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.onesignal.OSUtils;
import com.onesignal.OneSignal;
import com.onesignal.PushRegistratorAbstractGoogle;

class PushRegistratorFCM
extends PushRegistratorAbstractGoogle {
    private FirebaseApp firebaseApp;

    PushRegistratorFCM() {
    }

    static void disableFirebaseInstanceIdService(Context context) {
        int n2 = OSUtils.getResourceString(context, "gcm_defaultSenderId", null) == null ? 2 : 1;
        PackageManager packageManager = context.getPackageManager();
        try {
            packageManager.setComponentEnabledSetting(new ComponentName(context, FirebaseInstanceIdService.class), n2, 1);
        }
        catch (IllegalArgumentException | NoClassDefFoundError throwable) {}
    }

    private void initFirebaseApp(String string) {
        if (this.firebaseApp != null) {
            return;
        }
        FirebaseOptions firebaseOptions = new FirebaseOptions.Builder().setGcmSenderId(string).setApplicationId("OMIT_ID").setApiKey("OMIT_KEY").build();
        this.firebaseApp = FirebaseApp.initializeApp((Context)OneSignal.appContext, (FirebaseOptions)firebaseOptions, (String)"ONESIGNAL_SDK_FCM_APP_NAME");
    }

    @Override
    String getProviderName() {
        return "FCM";
    }

    @Override
    String getToken(String string) throws Throwable {
        this.initFirebaseApp(string);
        return FirebaseInstanceId.getInstance((FirebaseApp)this.firebaseApp).getToken(string, "FCM");
    }
}


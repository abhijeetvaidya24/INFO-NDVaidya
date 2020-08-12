/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.gcm.GoogleCloudMessaging
 *  java.lang.String
 *  java.lang.Throwable
 */
package com.onesignal;

import android.content.Context;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.onesignal.OneSignal;
import com.onesignal.PushRegistratorAbstractGoogle;

class PushRegistratorGCM
extends PushRegistratorAbstractGoogle {
    PushRegistratorGCM() {
    }

    @Override
    String getProviderName() {
        return "GCM";
    }

    @Override
    String getToken(String string) throws Throwable {
        return GoogleCloudMessaging.getInstance((Context)OneSignal.appContext).register(new String[]{string});
    }
}


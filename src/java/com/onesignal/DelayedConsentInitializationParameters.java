/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Object
 *  java.lang.String
 */
package com.onesignal;

import android.content.Context;
import com.onesignal.OneSignal;

class DelayedConsentInitializationParameters {
    public String appId;
    public Context context;
    public String googleProjectNumber;
    public OneSignal.NotificationOpenedHandler openedHandler;
    public OneSignal.NotificationReceivedHandler receivedHandler;

    DelayedConsentInitializationParameters(Context context, String string2, String string3, OneSignal.NotificationOpenedHandler notificationOpenedHandler, OneSignal.NotificationReceivedHandler notificationReceivedHandler) {
        this.context = context;
        this.googleProjectNumber = string2;
        this.appId = string3;
        this.openedHandler = notificationOpenedHandler;
        this.receivedHandler = notificationReceivedHandler;
    }
}


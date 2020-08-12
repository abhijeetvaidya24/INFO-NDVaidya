/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.appsgeyser.sdk.push.OneSignalNotificationOpenedHandler
 *  com.appsgeyser.sdk.push.OneSignalNotificationReceivedHandler
 *  java.lang.Object
 *  java.lang.String
 */
package com.appsgeyser.sdk.push;

import android.content.Context;
import com.appsgeyser.sdk.push.OneSignalNotificationOpenedHandler;
import com.appsgeyser.sdk.push.OneSignalNotificationReceivedHandler;
import com.onesignal.OneSignal;

public class OneSignalCreator {
    public static void init(String string2, Context context) {
        new OneSignalNotificationOpenedHandler(context);
        OneSignal.init(context, null, string2, null, (OneSignal.NotificationReceivedHandler)new OneSignalNotificationReceivedHandler());
        OneSignal.setInFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification);
    }
}


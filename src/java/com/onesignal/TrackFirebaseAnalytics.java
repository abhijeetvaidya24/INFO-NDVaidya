/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  java.lang.Class
 *  java.lang.Math
 *  java.lang.NoSuchMethodException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.lang.reflect.Method
 *  java.util.concurrent.atomic.AtomicLong
 */
package com.onesignal;

import android.content.Context;
import android.os.Bundle;
import com.onesignal.OSNotification;
import com.onesignal.OSNotificationOpenResult;
import com.onesignal.OSNotificationPayload;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicLong;

class TrackFirebaseAnalytics {
    private static Class<?> FirebaseAnalyticsClass;
    private static AtomicLong lastOpenedTime;
    private static OSNotificationPayload lastReceivedPayload;
    private static AtomicLong lastReceivedTime;
    private Context appContext;
    private Object mFirebaseAnalyticsInstance;

    TrackFirebaseAnalytics(Context context) {
        this.appContext = context;
    }

    static boolean CanTrack() {
        try {
            FirebaseAnalyticsClass = Class.forName((String)"com.google.firebase.analytics.FirebaseAnalytics");
            return true;
        }
        catch (Throwable throwable) {
            return false;
        }
    }

    private String getCampaignNameFromPayload(OSNotificationPayload oSNotificationPayload) {
        if (!oSNotificationPayload.templateName.isEmpty() && !oSNotificationPayload.templateId.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(oSNotificationPayload.templateName);
            stringBuilder.append(" - ");
            stringBuilder.append(oSNotificationPayload.templateId);
            return stringBuilder.toString();
        }
        if (oSNotificationPayload.title != null) {
            return oSNotificationPayload.title.substring(0, Math.min((int)10, (int)oSNotificationPayload.title.length()));
        }
        return "";
    }

    private Object getFirebaseAnalyticsInstance(Context context) {
        if (this.mFirebaseAnalyticsInstance == null) {
            Method method = TrackFirebaseAnalytics.getInstanceMethod(FirebaseAnalyticsClass);
            try {
                this.mFirebaseAnalyticsInstance = method.invoke(null, new Object[]{context});
            }
            catch (Throwable throwable) {
                throwable.printStackTrace();
                return null;
            }
        }
        return this.mFirebaseAnalyticsInstance;
    }

    private static Method getInstanceMethod(Class class_) {
        try {
            Method method = class_.getMethod("getInstance", new Class[]{Context.class});
            return method;
        }
        catch (NoSuchMethodException noSuchMethodException) {
            noSuchMethodException.printStackTrace();
            return null;
        }
    }

    private static Method getTrackMethod(Class class_) {
        try {
            Method method = class_.getMethod("logEvent", new Class[]{String.class, Bundle.class});
            return method;
        }
        catch (NoSuchMethodException noSuchMethodException) {
            noSuchMethodException.printStackTrace();
            return null;
        }
    }

    void trackInfluenceOpenEvent() {
        if (lastReceivedTime != null) {
            if (lastReceivedPayload == null) {
                return;
            }
            long l2 = System.currentTimeMillis();
            if (l2 - lastReceivedTime.get() > 120000L) {
                return;
            }
            AtomicLong atomicLong = lastOpenedTime;
            if (atomicLong != null && l2 - atomicLong.get() < 30000L) {
                return;
            }
            try {
                Object object = this.getFirebaseAnalyticsInstance(this.appContext);
                Method method = TrackFirebaseAnalytics.getTrackMethod(FirebaseAnalyticsClass);
                Bundle bundle = new Bundle();
                bundle.putString("source", "OneSignal");
                bundle.putString("medium", "notification");
                bundle.putString("notification_id", TrackFirebaseAnalytics.lastReceivedPayload.notificationID);
                bundle.putString("campaign", this.getCampaignNameFromPayload(lastReceivedPayload));
                method.invoke(object, new Object[]{"os_notification_influence_open", bundle});
                return;
            }
            catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
    }

    void trackOpenedEvent(OSNotificationOpenResult oSNotificationOpenResult) {
        if (lastOpenedTime == null) {
            lastOpenedTime = new AtomicLong();
        }
        lastOpenedTime.set(System.currentTimeMillis());
        try {
            Object object = this.getFirebaseAnalyticsInstance(this.appContext);
            Method method = TrackFirebaseAnalytics.getTrackMethod(FirebaseAnalyticsClass);
            Bundle bundle = new Bundle();
            bundle.putString("source", "OneSignal");
            bundle.putString("medium", "notification");
            bundle.putString("notification_id", oSNotificationOpenResult.notification.payload.notificationID);
            bundle.putString("campaign", this.getCampaignNameFromPayload(oSNotificationOpenResult.notification.payload));
            method.invoke(object, new Object[]{"os_notification_opened", bundle});
            return;
        }
        catch (Throwable throwable) {
            throwable.printStackTrace();
            return;
        }
    }

    void trackReceivedEvent(OSNotificationOpenResult oSNotificationOpenResult) {
        try {
            Object object = this.getFirebaseAnalyticsInstance(this.appContext);
            Method method = TrackFirebaseAnalytics.getTrackMethod(FirebaseAnalyticsClass);
            Bundle bundle = new Bundle();
            bundle.putString("source", "OneSignal");
            bundle.putString("medium", "notification");
            bundle.putString("notification_id", oSNotificationOpenResult.notification.payload.notificationID);
            bundle.putString("campaign", this.getCampaignNameFromPayload(oSNotificationOpenResult.notification.payload));
            method.invoke(object, new Object[]{"os_notification_received", bundle});
            if (lastReceivedTime == null) {
                lastReceivedTime = new AtomicLong();
            }
            lastReceivedTime.set(System.currentTimeMillis());
            lastReceivedPayload = oSNotificationOpenResult.notification.payload;
            return;
        }
        catch (Throwable throwable) {
            throwable.printStackTrace();
            return;
        }
    }
}


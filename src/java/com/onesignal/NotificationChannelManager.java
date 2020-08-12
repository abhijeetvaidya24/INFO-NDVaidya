/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.NotificationChannel
 *  android.app.NotificationChannelGroup
 *  android.app.NotificationManager
 *  android.content.Context
 *  android.media.AudioAttributes
 *  android.net.Uri
 *  android.os.Build
 *  android.os.Build$VERSION
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.math.BigInteger
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.List
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.onesignal;

import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.content.Context;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import com.onesignal.NotificationGenerationJob;
import com.onesignal.OSUtils;
import com.onesignal.OneSignal;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class NotificationChannelManager {
    private static String createChannel(Context context, NotificationManager notificationManager, JSONObject jSONObject) throws JSONException {
        int n2;
        String string2;
        JSONObject jSONObject2;
        long[] arrl;
        String string3;
        Object object = jSONObject.opt("chnl");
        JSONObject jSONObject3 = object instanceof String ? new JSONObject((String)object) : (JSONObject)object;
        String string4 = jSONObject3.optString("id", string3 = "fcm_fallback_notification_channel");
        if (!string4.equals((Object)"miscellaneous")) {
            string3 = string4;
        }
        JSONObject jSONObject4 = jSONObject3.has("langs") && (jSONObject2 = jSONObject3.getJSONObject("langs")).has(string2 = OSUtils.getCorrectedLanguage()) ? jSONObject2.optJSONObject(string2) : jSONObject3;
        NotificationChannel notificationChannel = new NotificationChannel(string3, (CharSequence)jSONObject4.optString("nm", "Miscellaneous"), NotificationChannelManager.priorityToImportance(jSONObject.optInt("pri", 6)));
        notificationChannel.setDescription(jSONObject4.optString("dscr", null));
        if (jSONObject3.has("grp_id")) {
            String string5 = jSONObject3.optString("grp_id");
            notificationManager.createNotificationChannelGroup(new NotificationChannelGroup(string5, (CharSequence)jSONObject4.optString("grp_nm")));
            notificationChannel.setGroup(string5);
        }
        if (jSONObject.has("ledc")) {
            notificationChannel.setLightColor(new BigInteger(jSONObject.optString("ledc"), 16).intValue());
        }
        boolean bl2 = jSONObject.optInt("led", n2 = 1) == n2;
        notificationChannel.enableLights(bl2);
        if (jSONObject.has("vib_pt") && (arrl = OSUtils.parseVibrationPattern(jSONObject)) != null) {
            notificationChannel.setVibrationPattern(arrl);
        }
        boolean bl3 = jSONObject.optInt("vib", n2) == n2;
        notificationChannel.enableVibration(bl3);
        if (jSONObject.has("sound")) {
            String string6 = jSONObject.optString("sound", null);
            Uri uri = OSUtils.getSoundUri(context, string6);
            if (uri != null) {
                notificationChannel.setSound(uri, null);
            } else if ("null".equals((Object)string6) || "nil".equals((Object)string6)) {
                notificationChannel.setSound(null, null);
            }
        }
        notificationChannel.setLockscreenVisibility(jSONObject.optInt("vis", 0));
        boolean bl4 = jSONObject.optInt("bdg", n2) == n2;
        notificationChannel.setShowBadge(bl4);
        if (jSONObject.optInt("bdnd", 0) != n2) {
            n2 = 0;
        }
        notificationChannel.setBypassDnd((boolean)n2);
        notificationManager.createNotificationChannel(notificationChannel);
        return string3;
    }

    private static String createDefaultChannel(NotificationManager notificationManager) {
        NotificationChannel notificationChannel = new NotificationChannel("fcm_fallback_notification_channel", (CharSequence)"Miscellaneous", 3);
        notificationChannel.enableLights(true);
        notificationChannel.enableVibration(true);
        notificationManager.createNotificationChannel(notificationChannel);
        return "fcm_fallback_notification_channel";
    }

    static String createNotificationChannel(NotificationGenerationJob notificationGenerationJob) {
        String string2;
        if (Build.VERSION.SDK_INT < 26) {
            return "fcm_fallback_notification_channel";
        }
        Context context = notificationGenerationJob.context;
        JSONObject jSONObject = notificationGenerationJob.jsonPayload;
        NotificationManager notificationManager = (NotificationManager)context.getSystemService("notification");
        if (notificationGenerationJob.restoring) {
            return NotificationChannelManager.createRestoreChannel(notificationManager);
        }
        if (jSONObject.has("oth_chnl") && notificationManager.getNotificationChannel(string2 = jSONObject.optString("oth_chnl")) != null) {
            return string2;
        }
        if (!jSONObject.has("chnl")) {
            return NotificationChannelManager.createDefaultChannel(notificationManager);
        }
        try {
            String string3 = NotificationChannelManager.createChannel(context, notificationManager, jSONObject);
            return string3;
        }
        catch (JSONException jSONException) {
            OneSignal.Log(OneSignal.LOG_LEVEL.ERROR, "Could not create notification channel due to JSON payload error!", jSONException);
            return "fcm_fallback_notification_channel";
        }
    }

    private static String createRestoreChannel(NotificationManager notificationManager) {
        notificationManager.createNotificationChannel(new NotificationChannel("restored_OS_notifications", (CharSequence)"Restored", 2));
        return "restored_OS_notifications";
    }

    private static int priorityToImportance(int n2) {
        if (n2 > 9) {
            return 5;
        }
        if (n2 > 7) {
            return 4;
        }
        if (n2 > 5) {
            return 3;
        }
        if (n2 > 3) {
            return 2;
        }
        return n2 > 1;
    }

    static void processChannelList(Context context, JSONArray jSONArray) {
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        if (jSONArray == null) {
            return;
        }
        NotificationManager notificationManager = (NotificationManager)context.getSystemService("notification");
        HashSet hashSet = new HashSet();
        int n2 = jSONArray.length();
        for (int i2 = 0; i2 < n2; ++i2) {
            try {
                hashSet.add((Object)NotificationChannelManager.createChannel(context, notificationManager, jSONArray.getJSONObject(i2)));
                continue;
            }
            catch (JSONException jSONException) {
                OneSignal.Log(OneSignal.LOG_LEVEL.ERROR, "Could not create notification channel due to JSON payload error!", jSONException);
            }
        }
        Iterator iterator = notificationManager.getNotificationChannels().iterator();
        while (iterator.hasNext()) {
            String string2 = ((NotificationChannel)iterator.next()).getId();
            if (!string2.startsWith("OS_") || hashSet.contains((Object)string2)) continue;
            notificationManager.deleteNotificationChannel(string2);
        }
    }
}


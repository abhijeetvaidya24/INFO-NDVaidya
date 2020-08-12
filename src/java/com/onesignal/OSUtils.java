/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.res.Resources
 *  android.net.ConnectivityManager
 *  android.net.NetworkInfo
 *  android.net.Uri
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.telephony.TelephonyManager
 *  androidx.core.app.NotificationManagerCompat
 *  java.lang.Class
 *  java.lang.ClassNotFoundException
 *  java.lang.Integer
 *  java.lang.InterruptedException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.util.Locale
 *  java.util.UUID
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.onesignal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.telephony.TelephonyManager;
import androidx.core.app.NotificationManagerCompat;
import com.onesignal.OneSignal;
import java.util.Locale;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class OSUtils {
    OSUtils() {
    }

    static boolean areNotificationsEnabled(Context context) {
        try {
            boolean bl2 = NotificationManagerCompat.from((Context)OneSignal.appContext).areNotificationsEnabled();
            return bl2;
        }
        catch (Throwable throwable) {
            return true;
        }
    }

    private Integer checkAndroidSupportLibrary(Context context) {
        boolean bl2 = OSUtils.hasWakefulBroadcastReceiver();
        boolean bl3 = OSUtils.hasNotificationManagerCompat();
        if (!bl2 && !bl3) {
            OneSignal.Log(OneSignal.LOG_LEVEL.FATAL, "Could not find the Android Support Library. Please make sure it has been correctly added to your project.");
            return -3;
        }
        if (bl2 && bl3) {
            if (Build.VERSION.SDK_INT >= 26 && OSUtils.getTargetSdkVersion(context) >= 26 && !OSUtils.hasJobIntentService()) {
                OneSignal.Log(OneSignal.LOG_LEVEL.FATAL, "The included Android Support Library is to old or incomplete. Please update to the 26.0.0 revision or newer.");
                return -5;
            }
            return null;
        }
        OneSignal.Log(OneSignal.LOG_LEVEL.FATAL, "The included Android Support Library is to old or incomplete. Please update to the 26.0.0 revision or newer.");
        return -5;
    }

    static String getCorrectedLanguage() {
        String string2 = Locale.getDefault().getLanguage();
        if (string2.equals((Object)"iw")) {
            return "he";
        }
        if (string2.equals((Object)"in")) {
            return "id";
        }
        if (string2.equals((Object)"ji")) {
            return "yi";
        }
        if (string2.equals((Object)"zh")) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append("-");
            stringBuilder.append(Locale.getDefault().getCountry());
            string2 = stringBuilder.toString();
        }
        return string2;
    }

    static String getManifestMeta(Context context, String string2) {
        try {
            String string3 = context.getPackageManager().getApplicationInfo((String)context.getPackageName(), (int)128).metaData.getString(string2);
            return string3;
        }
        catch (Throwable throwable) {
            OneSignal.Log(OneSignal.LOG_LEVEL.ERROR, "", throwable);
            return null;
        }
    }

    static String getResourceString(Context context, String string2, String string3) {
        Resources resources = context.getResources();
        int n2 = resources.getIdentifier(string2, "string", context.getPackageName());
        if (n2 != 0) {
            return resources.getString(n2);
        }
        return string3;
    }

    static Uri getSoundUri(Context context, String string2) {
        int n2;
        Resources resources = context.getResources();
        String string3 = context.getPackageName();
        if (OSUtils.isValidResourceName(string2) && (n2 = resources.getIdentifier(string2, "raw", string3)) != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("android.resource://");
            stringBuilder.append(string3);
            stringBuilder.append("/");
            stringBuilder.append(n2);
            return Uri.parse((String)stringBuilder.toString());
        }
        int n3 = resources.getIdentifier("onesignal_default_sound", "raw", string3);
        if (n3 != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("android.resource://");
            stringBuilder.append(string3);
            stringBuilder.append("/");
            stringBuilder.append(n3);
            return Uri.parse((String)stringBuilder.toString());
        }
        return null;
    }

    static int getTargetSdkVersion(Context context) {
        String string2 = context.getPackageName();
        PackageManager packageManager = context.getPackageManager();
        try {
            int n2 = packageManager.getApplicationInfo((String)string2, (int)0).targetSdkVersion;
            return n2;
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            nameNotFoundException.printStackTrace();
            return 15;
        }
    }

    static boolean hasFCMLibrary() {
        return true;
    }

    private static boolean hasGCMLibrary() {
        return true;
    }

    private static boolean hasJobIntentService() {
        return true;
    }

    private static boolean hasNotificationManagerCompat() {
        return true;
    }

    private static boolean hasWakefulBroadcastReceiver() {
        return true;
    }

    static boolean isValidResourceName(String string2) {
        return string2 != null && !string2.matches("^[0-9]");
    }

    static long[] parseVibrationPattern(JSONObject jSONObject) {
        int n2;
        JSONArray jSONArray;
        long[] arrl;
        try {
            Object object = jSONObject.opt("vib_pt");
            jSONArray = object instanceof String ? new JSONArray((String)object) : (JSONArray)object;
            arrl = new long[jSONArray.length()];
            n2 = 0;
        }
        catch (JSONException jSONException) {
            return null;
        }
        do {
            if (n2 >= jSONArray.length()) break;
            arrl[n2] = jSONArray.optLong(n2);
            ++n2;
        } while (true);
        return arrl;
    }

    static void runOnMainUIThread(Runnable runnable) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            runnable.run();
            return;
        }
        new Handler(Looper.getMainLooper()).post(runnable);
    }

    static void sleep(int n2) {
        long l2 = n2;
        try {
            Thread.sleep((long)l2);
            return;
        }
        catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
            return;
        }
    }

    Integer checkForGooglePushLibrary() {
        boolean bl2 = OSUtils.hasFCMLibrary();
        boolean bl3 = OSUtils.hasGCMLibrary();
        if (!bl2 && !bl3) {
            OneSignal.Log(OneSignal.LOG_LEVEL.FATAL, "The Firebase FCM library is missing! Please make sure to include it in your project.");
            return -4;
        }
        if (bl3 && !bl2) {
            OneSignal.Log(OneSignal.LOG_LEVEL.WARN, "GCM Library detected, please upgrade to Firebase FCM library as GCM is deprecated!");
        }
        if (bl3 && bl2) {
            OneSignal.Log(OneSignal.LOG_LEVEL.WARN, "Both GCM & FCM Libraries detected! Please remove the deprecated GCM library.");
        }
        return null;
    }

    String getCarrierName() {
        try {
            String string2 = ((TelephonyManager)OneSignal.appContext.getSystemService("phone")).getNetworkOperatorName();
            boolean bl2 = "".equals((Object)string2);
            if (bl2) {
                return null;
            }
            return string2;
        }
        catch (Throwable throwable) {
            throwable.printStackTrace();
            return null;
        }
    }

    int getDeviceType() {
        try {
            Class.forName((String)"com.amazon.device.messaging.ADM");
            return 2;
        }
        catch (ClassNotFoundException classNotFoundException) {
            return 1;
        }
    }

    Integer getNetType() {
        NetworkInfo networkInfo = ((ConnectivityManager)OneSignal.appContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (networkInfo != null) {
            int n2 = networkInfo.getType();
            if (n2 != 1 && n2 != 9) {
                return 1;
            }
            return 0;
        }
        return null;
    }

    int initializationChecker(Context context, int n2, String string2) {
        int n3;
        Integer n4;
        Integer n5;
        try {
            UUID.fromString((String)string2);
        }
        catch (Throwable throwable) {
            OneSignal.Log(OneSignal.LOG_LEVEL.FATAL, "OneSignal AppId format is invalid.\nExample: 'b2f7f966-d8cc-11e4-bed1-df8f05be55ba'\n", throwable);
            return -999;
        }
        if ("b2f7f966-d8cc-11e4-bed1-df8f05be55ba".equals((Object)string2) || "5eb5a37e-b458-11e3-ac11-000c2940e62c".equals((Object)string2)) {
            OneSignal.Log(OneSignal.LOG_LEVEL.ERROR, "OneSignal Example AppID detected, please update to your app's id found on OneSignal.com");
        }
        if (n2 == (n3 = 1) && (n5 = this.checkForGooglePushLibrary()) != null) {
            n3 = n5;
        }
        if ((n4 = this.checkAndroidSupportLibrary(context)) != null) {
            n3 = n4;
        }
        return n3;
    }
}


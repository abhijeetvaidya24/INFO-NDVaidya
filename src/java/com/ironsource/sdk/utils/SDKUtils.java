/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Environment
 *  android.text.TextUtils
 *  android.util.DisplayMetrics
 *  android.view.View
 *  java.io.File
 *  java.io.UnsupportedEncodingException
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.math.BigInteger
 *  java.net.URLEncoder
 *  java.security.MessageDigest
 *  java.security.NoSuchAlgorithmException
 *  java.util.concurrent.atomic.AtomicInteger
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.ironsource.sdk.utils;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import com.ironsource.environment.DeviceStatus;
import com.ironsource.sdk.data.SSAEnums;
import com.ironsource.sdk.utils.Logger;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

public class SDKUtils {
    private static final String TAG = "SDKUtils";
    private static String mAdvertisingId;
    private static String mControllerConfig;
    private static String mControllerUrl;
    private static int mDebugMode = 0;
    private static boolean mIsLimitedTrackingEnabled = true;
    private static String mUserGroup = "";
    private static final AtomicInteger sNextGeneratedId;

    static {
        sNextGeneratedId = new AtomicInteger(1);
    }

    public static String createErrorMessage(String string, String string2) {
        return String.format((String)"%s Failure occurred during initiation at: %s", (Object[])new Object[]{string, string2});
    }

    public static int dpToPx(long l2) {
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        return (int)(0.5f + (float)l2 * displayMetrics.density);
    }

    public static String encodeString(String string) {
        try {
            String string2 = URLEncoder.encode((String)string, (String)"UTF-8").replace((CharSequence)"+", (CharSequence)"%20");
            return string2;
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            return "";
        }
    }

    public static int generateViewId() {
        if (Build.VERSION.SDK_INT < 17) {
            return SDKUtils.generateViewIdForOldOS();
        }
        return View.generateViewId();
    }

    private static int generateViewIdForOldOS() {
        int n2;
        int n3;
        do {
            if ((n2 = (n3 = sNextGeneratedId.get()) + 1) <= 16777215) continue;
            n2 = 1;
        } while (!sNextGeneratedId.compareAndSet(n3, n2));
        return n3;
    }

    public static int getActivityUIFlags(boolean bl2) {
        int n2 = Build.VERSION.SDK_INT >= 14 ? 2 : 0;
        if (Build.VERSION.SDK_INT >= 16) {
            n2 |= 1796;
        }
        if (Build.VERSION.SDK_INT >= 19 && bl2) {
            n2 |= 4096;
        }
        return n2;
    }

    public static String getAdvertiserId() {
        return mAdvertisingId;
    }

    public static String getControllerConfig() {
        return mControllerConfig;
    }

    public static JSONObject getControllerConfigAsJSONObject() {
        String string = SDKUtils.getControllerConfig();
        try {
            JSONObject jSONObject = new JSONObject(string);
            return jSONObject;
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
            return new JSONObject();
        }
    }

    public static String getControllerUrl() {
        if (!TextUtils.isEmpty((CharSequence)mControllerUrl)) {
            return mControllerUrl;
        }
        return "";
    }

    public static Long getCurrentTimeMillis() {
        return System.currentTimeMillis();
    }

    public static int getDebugMode() {
        return mDebugMode;
    }

    public static String getFileName(String string) {
        String[] arrstring = string.split(File.separator);
        String string2 = arrstring[-1 + arrstring.length].split("\\?")[0];
        try {
            String string3 = URLEncoder.encode((String)string2, (String)"UTF-8");
            return string3;
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            unsupportedEncodingException.printStackTrace();
            return null;
        }
    }

    public static String getMD5(String string) {
        try {
            String string2 = new BigInteger(1, MessageDigest.getInstance((String)"MD5").digest(string.getBytes())).toString(16);
            while (string2.length() < 32) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("0");
                stringBuilder.append(string2);
                string2 = stringBuilder.toString();
            }
            return string2;
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            RuntimeException runtimeException;
            runtimeException = new RuntimeException((Throwable)noSuchAlgorithmException);
            throw runtimeException;
        }
    }

    public static JSONObject getOrientation(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("orientation", (Object)SDKUtils.translateOrientation(DeviceStatus.getDeviceOrientation(context)));
            return jSONObject;
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
            return jSONObject;
        }
    }

    public static SSAEnums.ProductType getProductType(String string) {
        if (string.equalsIgnoreCase(SSAEnums.ProductType.RewardedVideo.toString())) {
            return SSAEnums.ProductType.RewardedVideo;
        }
        if (string.equalsIgnoreCase(SSAEnums.ProductType.Interstitial.toString())) {
            return SSAEnums.ProductType.Interstitial;
        }
        if (string.equalsIgnoreCase(SSAEnums.ProductType.OfferWall.toString())) {
            return SSAEnums.ProductType.OfferWall;
        }
        return null;
    }

    public static String getSDKVersion() {
        return "5.53";
    }

    public static String getTesterParameters() {
        return mUserGroup;
    }

    public static String getValueFromJsonObject(String string, String string2) {
        try {
            String string3 = new JSONObject(string).getString(string2);
            return string3;
        }
        catch (Exception exception) {
            return null;
        }
    }

    public static boolean isExternalStorageAvailable() {
        String string = Environment.getExternalStorageState();
        return "mounted".equals((Object)string) || "mounted_ro".equals((Object)string);
        {
        }
    }

    public static boolean isLimitAdTrackingEnabled() {
        return mIsLimitedTrackingEnabled;
    }

    public static void loadGoogleAdvertiserInfo(Context context) {
        try {
            String[] arrstring = DeviceStatus.getAdvertisingIdInfo(context);
            mAdvertisingId = arrstring[0];
            mIsLimitedTrackingEnabled = Boolean.valueOf((String)arrstring[1]);
            return;
        }
        catch (Throwable throwable) {
            throw throwable;
        }
        catch (Exception exception) {
            if (exception.getMessage() != null) {
                String string = TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(exception.getClass().getSimpleName());
                stringBuilder.append(": ");
                stringBuilder.append(exception.getMessage());
                Logger.i(string, stringBuilder.toString());
            }
            if (exception.getCause() != null) {
                String string = TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(exception.getClass().getSimpleName());
                stringBuilder.append(": ");
                stringBuilder.append((Object)exception.getCause());
                Logger.i(string, stringBuilder.toString());
            }
            return;
        }
    }

    public static void setControllerConfig(String string) {
        mControllerConfig = string;
    }

    public static void setControllerUrl(String string) {
        mControllerUrl = string;
    }

    public static void setDebugMode(int n2) {
        mDebugMode = n2;
    }

    public static String translateOrientation(int n2) {
        if (n2 != 1) {
            if (n2 != 2) {
                return "none";
            }
            return "landscape";
        }
        return "portrait";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String translateRequestedOrientation(int n2) {
        if (n2 == 0) return "landscape";
        if (n2 == 1) return "portrait";
        if (n2 == 11) return "landscape";
        if (n2 == 12) return "portrait";
        switch (n2) {
            default: {
                return "none";
            }
            case 7: 
            case 9: {
                return "portrait";
            }
            case 6: 
            case 8: 
        }
        return "landscape";
    }
}


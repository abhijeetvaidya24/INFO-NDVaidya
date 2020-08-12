/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.net.ConnectivityManager
 *  android.net.NetworkInfo
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.telephony.TelephonyManager
 *  android.util.DisplayMetrics
 *  android.view.Display
 *  android.view.WindowManager
 *  java.io.UnsupportedEncodingException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.net.URLEncoder
 *  java.util.HashMap
 */
package com.appsgeyser.sdk.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

public abstract class DeviceInfoGetter {
    private static int getAndroidOsVersionInt() {
        return Build.VERSION.SDK_INT;
    }

    private static String getConnectType(Context context) {
        NetworkInfo networkInfo = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            int n2 = networkInfo.getType();
            if (n2 == 1) {
                return "wifi";
            }
            if (n2 == 0) {
                return networkInfo.getSubtypeName();
            }
        }
        return "unknowntype";
    }

    public static String getDeviceInfo(Context context) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("&dpi=");
            stringBuilder.append(URLEncoder.encode((String)String.valueOf((int)DeviceInfoGetter.getScreenSizeDpi(context)), (String)"utf-8"));
            stringBuilder.append("&");
            stringBuilder.append("screenresolution");
            stringBuilder.append("=");
            stringBuilder.append(URLEncoder.encode((String)DeviceInfoGetter.getScreenResolution(context), (String)"utf-8"));
            stringBuilder.append("&");
            stringBuilder.append("androidversion");
            stringBuilder.append("=");
            stringBuilder.append(URLEncoder.encode((String)String.valueOf((int)DeviceInfoGetter.getAndroidOsVersionInt()), (String)"utf-8"));
            stringBuilder.append("&");
            stringBuilder.append("istablet");
            stringBuilder.append("=");
            stringBuilder.append(URLEncoder.encode((String)String.valueOf((boolean)DeviceInfoGetter.isTablet(context)), (String)"utf-8"));
            stringBuilder.append("&");
            stringBuilder.append("manufacturer");
            stringBuilder.append("=");
            stringBuilder.append(URLEncoder.encode((String)DeviceInfoGetter.getManufacturer(), (String)"utf-8"));
            stringBuilder.append("&");
            stringBuilder.append("devicename");
            stringBuilder.append("=");
            stringBuilder.append(URLEncoder.encode((String)DeviceInfoGetter.getDeviceName(), (String)"utf-8"));
            stringBuilder.append("&");
            stringBuilder.append("connectiontype");
            stringBuilder.append("=");
            stringBuilder.append(URLEncoder.encode((String)DeviceInfoGetter.getConnectType(context), (String)"utf-8"));
            stringBuilder.append("&");
            stringBuilder.append("operator");
            stringBuilder.append("=");
            stringBuilder.append(URLEncoder.encode((String)DeviceInfoGetter.getOperatorName(context), (String)"utf-8"));
            String string2 = stringBuilder.toString();
            return string2;
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            unsupportedEncodingException.printStackTrace();
            return "";
        }
    }

    public static HashMap<String, String> getDeviceInfoMap(Context context) {
        HashMap hashMap = new HashMap(9);
        try {
            hashMap.put((Object)"dpi", (Object)URLEncoder.encode((String)String.valueOf((int)DeviceInfoGetter.getScreenSizeDpi(context)), (String)"utf-8"));
            hashMap.put((Object)"screenresolution", (Object)URLEncoder.encode((String)DeviceInfoGetter.getScreenResolution(context), (String)"utf-8"));
            hashMap.put((Object)"androidversion", (Object)URLEncoder.encode((String)String.valueOf((int)DeviceInfoGetter.getAndroidOsVersionInt()), (String)"utf-8"));
            hashMap.put((Object)"istablet", (Object)URLEncoder.encode((String)String.valueOf((boolean)DeviceInfoGetter.isTablet(context)), (String)"utf-8"));
            hashMap.put((Object)"manufacturer", (Object)URLEncoder.encode((String)DeviceInfoGetter.getManufacturer(), (String)"utf-8"));
            hashMap.put((Object)"devicename", (Object)URLEncoder.encode((String)DeviceInfoGetter.getDeviceName(), (String)"utf-8"));
            hashMap.put((Object)"connectiontype", (Object)URLEncoder.encode((String)DeviceInfoGetter.getConnectType(context), (String)"utf-8"));
            hashMap.put((Object)"operator", (Object)URLEncoder.encode((String)DeviceInfoGetter.getOperatorName(context), (String)"utf-8"));
            return hashMap;
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            unsupportedEncodingException.printStackTrace();
            return null;
        }
    }

    private static String getDeviceName() {
        return Build.DEVICE;
    }

    private static String getManufacturer() {
        return Build.MANUFACTURER;
    }

    private static String getOperatorName(Context context) {
        return ((TelephonyManager)context.getSystemService("phone")).getNetworkOperatorName();
    }

    private static String getScreenResolution(Context context) {
        Display display = ((WindowManager)context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        display.getMetrics(displayMetrics);
        int n2 = displayMetrics.widthPixels;
        int n3 = displayMetrics.heightPixels;
        Object[] arrobject = new Object[]{n2, n3};
        return String.format((String)"%sx%s", (Object[])arrobject);
    }

    private static int getScreenSizeDpi(Context context) {
        return context.getResources().getDisplayMetrics().densityDpi;
    }

    @TargetApi(value=9)
    private static boolean isTablet(Context context) {
        int n2 = 15 & context.getResources().getConfiguration().screenLayout;
        boolean bl = true;
        boolean bl2 = n2 == 4;
        boolean bl3 = (15 & context.getResources().getConfiguration().screenLayout) == 3;
        if (!bl2) {
            if (bl3) {
                return bl;
            }
            bl = false;
        }
        return bl;
    }
}


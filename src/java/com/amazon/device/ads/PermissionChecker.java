/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Object
 *  java.lang.String
 */
package com.amazon.device.ads;

import android.content.Context;

class PermissionChecker {
    PermissionChecker() {
    }

    public boolean hasInternetPermission(Context context) {
        return this.hasPermission(context, "android.permission.INTERNET");
    }

    public boolean hasLocationPermission(Context context) {
        return this.hasPermission(context, "android.permission.ACCESS_FINE_LOCATION") || this.hasPermission(context, "android.permission.ACCESS_COARSE_LOCATION");
        {
        }
    }

    public boolean hasPermission(Context context, String string) {
        return context.checkCallingOrSelfPermission(string) == 0;
    }

    public boolean hasPhonePermission(Context context) {
        return this.hasPermission(context, "android.permission.CALL_PHONE");
    }

    public boolean hasReadCalendarPermission(Context context) {
        return this.hasPermission(context, "android.permission.READ_CALENDAR");
    }

    public boolean hasSmsPermission(Context context) {
        return this.hasPermission(context, "android.permission.SEND_SMS");
    }

    public boolean hasWriteCalendarPermission(Context context) {
        return this.hasPermission(context, "android.permission.WRITE_CALENDAR");
    }

    public boolean hasWriteExternalStoragePermission(Context context) {
        return this.hasPermission(context, "android.permission.WRITE_EXTERNAL_STORAGE");
    }
}


/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.content.SharedPreferences
 *  android.content.pm.ActivityInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.ResolveInfo
 *  android.text.TextUtils
 *  com.chartboost.sdk.Tracking.a
 *  com.chartboost.sdk.c
 *  com.chartboost.sdk.h
 *  com.chartboost.sdk.i
 *  com.chartboost.sdk.impl.s
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.util.List
 *  java.util.concurrent.atomic.AtomicReference
 *  org.json.JSONObject
 */
package com.chartboost.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.chartboost.sdk.CBImpressionActivity;
import com.chartboost.sdk.Chartboost;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.j;
import com.chartboost.sdk.Model.e;
import com.chartboost.sdk.Tracking.a;
import com.chartboost.sdk.c;
import com.chartboost.sdk.h;
import com.chartboost.sdk.i;
import com.chartboost.sdk.impl.s;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

public final class b {
    public static String a(e e2) {
        if (!e2.y) {
            return "native";
        }
        return "web";
    }

    static void a(String string2) {
        if (i.d == null) {
            CBLogging.b("CBConfig", "Set a valid CBFramework first");
            return;
        }
        if (TextUtils.isEmpty((CharSequence)string2)) {
            CBLogging.b("CBConfig", "Invalid Version String");
            return;
        }
        i.b = string2;
    }

    public static boolean a() {
        return b.b() && b.c();
    }

    static boolean a(Activity activity) {
        if (activity != null) {
            return true;
        }
        try {
            throw new Exception("Invalid activity context: Host Activity object is null, Please send a valid activity object");
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static boolean a(Context context) {
        if (context == null) throw new RuntimeException("Invalid activity context passed during intitalization");
        try {
            int n2;
            int n3;
            int n4;
            int n5;
            int n6;
            boolean bl = s.a().a(23);
            if (bl) {
                n3 = context.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE");
                n5 = context.checkSelfPermission("android.permission.ACCESS_NETWORK_STATE");
                n6 = context.checkSelfPermission("android.permission.INTERNET");
                n4 = context.checkSelfPermission("android.permission.READ_PHONE_STATE");
                n2 = context.checkSelfPermission("android.permission.ACCESS_WIFI_STATE");
            } else {
                n3 = context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE");
                n5 = context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE");
                n6 = context.checkCallingOrSelfPermission("android.permission.INTERNET");
                n4 = context.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE");
                n2 = context.checkCallingOrSelfPermission("android.permission.ACCESS_WIFI_STATE");
            }
            boolean bl2 = n3 != 0;
            i.n = bl2;
            boolean bl3 = n6 != 0;
            i.o = bl3;
            boolean bl4 = n5 != 0;
            i.p = bl4;
            boolean bl5 = n4 != 0;
            i.q = bl5;
            boolean bl6 = n2 != 0;
            i.r = bl6;
            if (i.o) throw new RuntimeException("Please add the permission : android.permission.INTERNET in your android manifest.xml");
            if (i.p) throw new RuntimeException("Please add the permission : android.permission.ACCESS_NETWORK_STATE in your android manifest.xml");
            return true;
        }
        catch (Exception exception) {}
        exception.printStackTrace();
        return false;
    }

    public static boolean a(AtomicReference<e> atomicReference, JSONObject jSONObject, SharedPreferences sharedPreferences) {
        try {
            atomicReference.set((Object)new e(jSONObject));
            return true;
        }
        catch (Exception exception) {
            a.a(b.class, (String)"updateConfig", (Exception)exception);
            return false;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    static boolean b() {
        block3 : {
            try {
                if (h.a() == null) throw new Exception("SDK Initialization error. SDK seems to be not initialized properly, check for any integration issues");
                if (i.m == null) throw new Exception("SDK Initialization error. Activity context seems to be not initialized properly, host activity or application context is being sent as null");
                if (TextUtils.isEmpty((CharSequence)i.k)) throw new Exception("SDK Initialization error. AppId is missing");
                if (TextUtils.isEmpty((CharSequence)i.l)) break block3;
                return true;
            }
            catch (Exception exception) {
                exception.printStackTrace();
                return false;
            }
        }
        throw new Exception("SDK Initialization error. AppSignature is missing");
    }

    public static boolean b(Context context) {
        List list = context.getPackageManager().queryIntentActivities(new Intent(context, CBImpressionActivity.class), 0);
        if (list.isEmpty()) {
            return false;
        }
        ActivityInfo activityInfo = ((ResolveInfo)list.get((int)0)).activityInfo;
        int n2 = 512 & activityInfo.flags;
        boolean bl = false;
        if (n2 != 0) {
            int n3 = 32 & activityInfo.flags;
            bl = false;
            if (n3 != 0) {
                int n4 = 128 & activityInfo.configChanges;
                bl = false;
                if (n4 != 0) {
                    int n5 = 32 & activityInfo.configChanges;
                    bl = false;
                    if (n5 != 0) {
                        int n6 = 1024 & activityInfo.configChanges;
                        bl = false;
                        if (n6 != 0) {
                            bl = true;
                        }
                    }
                }
            }
        }
        return bl;
    }

    private static boolean c() {
        h h2 = h.a();
        if (h2 == null) {
            return false;
        }
        if (h2.q.d != null) {
            return true;
        }
        try {
            throw new Exception("Chartboost Weak Activity reference is null");
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }
}


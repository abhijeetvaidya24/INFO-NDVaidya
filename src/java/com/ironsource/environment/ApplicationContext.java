/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Arrays
 *  java.util.List
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.ironsource.environment;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class ApplicationContext {
    static PackageInfo getAppPackageInfo(Context context) throws PackageManager.NameNotFoundException {
        return context.getPackageManager().getPackageInfo(ApplicationContext.getPackageName(context), 0);
    }

    public static String getApplicationVersionName(Context context) {
        try {
            String string = ApplicationContext.getAppPackageInfo((Context)context).versionName;
            return string;
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            nameNotFoundException.printStackTrace();
            return "";
        }
    }

    public static long getFirstInstallTime(Context context) {
        try {
            long l2 = ApplicationContext.getAppPackageInfo((Context)context).firstInstallTime;
            return l2;
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            nameNotFoundException.printStackTrace();
            return -1L;
        }
    }

    public static long getLastUpdateTime(Context context) {
        try {
            long l2 = ApplicationContext.getAppPackageInfo((Context)context).lastUpdateTime;
            return l2;
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            nameNotFoundException.printStackTrace();
            return -1L;
        }
    }

    public static String getPackageName(Context context) {
        return context.getPackageName();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static JSONObject getPermissions(Context context, JSONArray jSONArray) {
        JSONObject jSONObject;
        int n2;
        PackageInfo packageInfo;
        List list;
        block8 : {
            block7 : {
                jSONObject = new JSONObject();
                if (Build.VERSION.SDK_INT < 16) return jSONObject;
                try {
                    packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096);
                    int n3 = jSONArray.length();
                    if (n3 == 0) break block7;
                    list = Arrays.asList((Object[])packageInfo.requestedPermissions);
                    break block8;
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                    return jSONObject;
                }
            }
            for (n2 = 0; n2 < packageInfo.requestedPermissions.length; ++n2) {
                String string = (2 & packageInfo.requestedPermissionsFlags[n2]) != 0 ? "Granted" : "Rejected";
                jSONObject.put(packageInfo.requestedPermissions[n2], (Object)string);
            }
            return jSONObject;
        }
        while (n2 < jSONArray.length()) {
            String string = jSONArray.getString(n2);
            int n4 = list.indexOf((Object)string);
            if (n4 != -1) {
                String string2 = (2 & packageInfo.requestedPermissionsFlags[n4]) != 0 ? "Granted" : "Rejected";
                jSONObject.put(string, (Object)string2);
            } else {
                jSONObject.put(string, (Object)"notFoundInManifest");
            }
            ++n2;
        }
        return jSONObject;
    }

    public static String getPublisherApplicationVersion(Context context, String string) {
        try {
            String string2 = context.getPackageManager().getPackageInfo((String)string, (int)0).versionName;
            return string2;
        }
        catch (Exception exception) {
            return "";
        }
    }

    public static boolean isPermissionGranted(Context context, String string) {
        return context.checkCallingOrSelfPermission(string) == 0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean isValidPermission(Context context, String string) {
        int n2;
        block6 : {
            boolean bl2 = TextUtils.isEmpty((CharSequence)string);
            n2 = 0;
            if (!bl2) {
                void var4_9;
                block7 : {
                    PackageInfo packageInfo;
                    int n3;
                    try {
                        packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096);
                        String[] arrstring = packageInfo.requestedPermissions;
                        if (arrstring == null) break block6;
                        n3 = 0;
                    }
                    catch (Exception exception) {
                        // empty catch block
                        break block7;
                    }
                    try {
                        for (n2 = 0; n2 < packageInfo.requestedPermissions.length && n3 == 0; ++n2) {
                            n3 = string.equals((Object)packageInfo.requestedPermissions[n2]) ? 1 : 0;
                        }
                        return (boolean)n3;
                    }
                    catch (Exception exception) {
                        n2 = n3;
                    }
                }
                var4_9.printStackTrace();
            }
        }
        return (boolean)n2;
    }
}


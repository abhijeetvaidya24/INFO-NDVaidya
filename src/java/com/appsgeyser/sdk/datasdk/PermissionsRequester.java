/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.pm.PackageManager
 *  android.os.Build
 *  android.os.Build$VERSION
 *  androidx.core.content.ContextCompat
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashSet
 *  java.util.Set
 */
package com.appsgeyser.sdk.datasdk;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.core.content.ContextCompat;
import com.appsgeyser.sdk.configuration.models.ConfigPhp;
import java.util.HashSet;
import java.util.Set;

class PermissionsRequester {
    private static final String[] oneAudiencePermissions = new String[]{"android.permission.GET_ACCOUNTS"};
    private static final String[] predicioPermissions = new String[]{"android.permission.ACCESS_FINE_LOCATION"};

    private static String[] getNeedRequestPermissions(Activity activity, Set<String> set) {
        HashSet hashSet = new HashSet();
        for (String string2 : set) {
            if (ContextCompat.checkSelfPermission((Context)activity, (String)string2) == 0) continue;
            hashSet.add((Object)string2);
        }
        if (hashSet.size() > 0) {
            return (String[])hashSet.toArray((Object[])new String[hashSet.size()]);
        }
        return null;
    }

    private static Set<String> getPermissionRequiredFromConfig(ConfigPhp configPhp) {
        return new HashSet();
    }

    static boolean isPermissionsRequired(ConfigPhp configPhp, Context context) {
        if (Build.VERSION.SDK_INT < 23) {
            return false;
        }
        HashSet hashSet = new HashSet();
        PackageManager packageManager = context.getPackageManager();
        for (String string2 : PermissionsRequester.getPermissionRequiredFromConfig(configPhp)) {
            if (packageManager.checkPermission(string2, context.getPackageName()) == 0) continue;
            hashSet.add((Object)string2);
        }
        int n2 = hashSet.size();
        boolean bl = false;
        if (n2 > 0) {
            bl = true;
        }
        return bl;
    }

    static void requestAllActiveByDefaultPermissions(Activity activity, ConfigPhp configPhp, int n2) {
        String[] arrstring = PermissionsRequester.getNeedRequestPermissions(activity, (Set<String>)new HashSet());
        if (arrstring != null) {
            activity.requestPermissions(arrstring, n2);
            return;
        }
        activity.onRequestPermissionsResult(78, new String[0], new int[0]);
    }

    static void requestAllActivePermissions(Activity activity, ConfigPhp configPhp, int n2) {
        String[] arrstring = PermissionsRequester.getNeedRequestPermissions(activity, PermissionsRequester.getPermissionRequiredFromConfig(configPhp));
        if (arrstring != null) {
            activity.requestPermissions(arrstring, n2);
            return;
        }
        activity.onRequestPermissionsResult(78, new String[0], new int[0]);
    }
}


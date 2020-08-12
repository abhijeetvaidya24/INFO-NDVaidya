/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.ActivityInfo
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.pm.ResolveInfo
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Iterator
 *  java.util.List
 */
package io.presage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import io.presage.cl;
import java.util.Iterator;
import java.util.List;

public final class VacherinduhautDoubsMontdOr {
    public static final VacherinduhautDoubsMontdOr a = new VacherinduhautDoubsMontdOr();

    private VacherinduhautDoubsMontdOr() {
    }

    public static boolean a(Context context, String string2) {
        try {
            context.getPackageManager().getApplicationInfo(string2, 0);
            return true;
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            return false;
        }
    }

    public static void b(Context context, String string2) {
        context.startActivity(context.getPackageManager().getLaunchIntentForPackage(string2));
    }

    public static void c(Context context, String string2) {
        Intent intent = Intent.parseUri((String)string2, (int)0);
        intent.addFlags(268435456);
        Iterator iterator = context.getPackageManager().queryIntentActivities(intent, 0).iterator();
        while (iterator.hasNext()) {
            ActivityInfo activityInfo = ((ResolveInfo)iterator.next()).activityInfo;
            if (!cl.a((Object)activityInfo.applicationInfo.packageName, (Object)"com.android.vending")) continue;
            ComponentName componentName = new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name);
            cl.a((Object)intent, "intent");
            intent.setComponent(componentName);
            break;
        }
        context.startActivity(intent);
    }
}


/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.ActivityManager
 *  android.app.ActivityManager$RunningAppProcessInfo
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.os.Process
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package io.presage;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import io.presage.ak;
import io.presage.cl;
import java.util.List;

public final class MoelleuxduRevard {
    public static final boolean a(Context context) {
        String string2;
        String string3;
        block3 : {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4);
                string3 = MoelleuxduRevard.b(context);
                string2 = packageInfo.applicationInfo.processName;
                if (string3 != null) break block3;
                return true;
            }
            catch (Exception exception) {
                return true;
            }
        }
        boolean bl2 = cl.a((Object)string3, (Object)string2);
        return bl2;
    }

    private static final String b(Context context) {
        ak ak2;
        int n2 = Process.myPid();
        Object object = context.getSystemService("activity");
        if (object != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager)object).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid != n2) continue;
                return runningAppProcessInfo.processName;
            }
            return null;
        }
        ak2 = new ak("null cannot be cast to non-null type android.app.ActivityManager");
        throw ak2;
    }
}


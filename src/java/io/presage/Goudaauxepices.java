/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.ActivityManager
 *  android.app.ActivityManager$RunningAppProcessInfo
 *  android.content.Context
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package io.presage;

import android.app.ActivityManager;
import android.content.Context;
import io.presage.ak;
import io.presage.cl;
import java.util.List;

public final class Goudaauxepices {
    public static boolean a(Context context) {
        ak ak2;
        Object object = context.getSystemService("activity");
        if (object != null) {
            List list = ((ActivityManager)object).getRunningAppProcesses();
            if (list == null) {
                return false;
            }
            String string2 = context.getPackageName();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : list) {
                if (runningAppProcessInfo.importance != 100 || !cl.a((Object)runningAppProcessInfo.processName, (Object)string2)) continue;
                return false;
            }
            return true;
        }
        ak2 = new ak("null cannot be cast to non-null type android.app.ActivityManager");
        throw ak2;
    }
}


/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.ActivityManager
 *  android.app.ActivityManager$MemoryInfo
 *  android.content.Context
 *  com.startapp.android.publish.adsCommon.f.e
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 */
package com.startapp.android.publish.adsCommon.f;

import android.app.ActivityManager;
import android.content.Context;
import com.startapp.android.publish.adsCommon.Utils.i;
import com.startapp.android.publish.adsCommon.f.a;
import com.startapp.android.publish.adsCommon.f.d;
import com.startapp.android.publish.adsCommon.f.e;
import com.startapp.android.publish.adsCommon.f.g;
import com.startapp.android.publish.common.metaData.MetaData;
import com.startapp.android.publish.common.model.AdPreferences;
import com.startapp.common.a.c;

public class f {
    public static void a(Context context, d d2, String string, String string2, String string3) {
        f.a(context, new e(d2, string, string2), string3, null);
    }

    public static void a(Context context, d d2, String string, String string2, String string3, g.a a2) {
        f.a(context, new e(d2, string, string2), string3, a2);
    }

    public static void a(Context context, e e2, String string) {
        f.a(context, e2, string, null);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void a(Context context, e e2, String string, g.a a2) {
        if (MetaData.getInstance().getAnalyticsConfig().c()) {
            return;
        }
        e2.e(string);
        e2.a(context);
        try {
            e2.f(i.b(context));
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager)context.getSystemService("activity")).getMemoryInfo(memoryInfo);
            e2.h(Long.toString((long)(memoryInfo.availMem / 0x100000L)));
            Long l2 = c.a(memoryInfo);
            if (l2 != null) {
                e2.g(Long.toString((long)((l2 - memoryInfo.availMem) / 0x100000L)));
            }
        }
        catch (Throwable throwable) {
            com.startapp.common.a.g.a("InfoEventsManager", 6, "Error filling infoEvent", throwable);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Sending ");
        stringBuilder.append((Object)e2);
        com.startapp.common.a.g.a("InfoEventsManager", 3, stringBuilder.toString());
        new g(context, new AdPreferences(), e2, a2).a();
    }
}


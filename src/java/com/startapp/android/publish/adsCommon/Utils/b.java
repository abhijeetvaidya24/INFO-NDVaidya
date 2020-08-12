/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.SystemClock
 *  com.startapp.android.publish.adsCommon.Utils.b$1
 *  com.startapp.android.publish.adsCommon.Utils.b$a
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.startapp.android.publish.adsCommon.Utils;

import android.content.Context;
import android.os.SystemClock;
import com.startapp.android.publish.adsCommon.Utils.b;
import com.startapp.android.publish.adsCommon.f.d;
import com.startapp.android.publish.adsCommon.f.f;
import com.startapp.android.publish.adsCommon.k;
import com.startapp.android.publish.common.metaData.MetaData;
import com.startapp.common.a.g;
import com.startapp.common.b.a.c;
import com.startapp.common.b.b;

/*
 * Exception performing whole class analysis.
 */
public class b {
    private static volatile boolean a;

    public static long a() {
        return SystemClock.elapsedRealtime() + 60000L * (long)MetaData.getInstance().getPeriodicMetaDataInterval();
    }

    public static void a(int n2) {
        com.startapp.common.b.a.a(n2, false);
    }

    public static void a(Context context) {
        if (!a) {
            a = true;
            com.startapp.common.b.a.a((c)new 1());
            com.startapp.common.b.a.a(context);
            com.startapp.common.b.a.a((com.startapp.common.b.a.a)new /* Unavailable Anonymous Inner Class!! */);
        }
    }

    private static void a(Context context, int n2, long l2, String string) {
        if (com.startapp.common.b.a.a(new b.a(n2).a(l2).a())) {
            k.b(context, string, l2 + SystemClock.elapsedRealtime());
            return;
        }
        d d2 = d.b;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Util.setPeriodicAlarm - failed setting alarm ");
        stringBuilder.append(n2);
        f.a(context, d2, stringBuilder.toString(), "", "");
    }

    public static void a(Context context, long l2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("setInfoEventPeriodicAlarm executes ");
        stringBuilder.append(l2);
        g.a("StartAppWall.DataUtils", 3, stringBuilder.toString());
        if (!k.a(context, "periodicInfoEventPaused", false).booleanValue() && MetaData.getInstance().isPeriodicInfoEventEnabled()) {
            b.a(context, 786564404, l2 - SystemClock.elapsedRealtime(), "periodicInfoEventTriggerTime");
        }
    }

    public static void a(Context context, Long l2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("setMetaDataPeriodicAlarm executes ");
        stringBuilder.append((Object)l2);
        g.a("StartAppWall.DataUtils", 3, stringBuilder.toString());
        if (!k.a(context, "periodicMetadataPaused", false).booleanValue() && MetaData.getInstance().isPeriodicMetaDataEnabled()) {
            b.a(context, 586482792, l2 - SystemClock.elapsedRealtime(), "periodicMetadataTriggerTime");
        }
    }

    public static long b(Context context) {
        return SystemClock.elapsedRealtime() + 60000L * (long)MetaData.getInstance().getPeriodicInfoEventIntervalInMinutes(context);
    }

    public static void c(Context context) {
        b.a(context, (Long)b.b(context));
    }

    public static void d(Context context) {
        b.a(context, b.b(context));
    }
}


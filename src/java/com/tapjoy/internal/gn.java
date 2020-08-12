/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.SystemClock
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 */
package com.tapjoy.internal;

import android.os.SystemClock;
import com.tapjoy.internal.el;

public abstract class gn {
    protected static a a;
    private static gn b;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected static void a(gn gn2) {
        Class<gn> class_ = gn.class;
        synchronized (gn.class) {
            b = gn2;
            a a2 = a;
            if (a2 != null) {
                a = null;
                gn2.a(a2);
            }
            // ** MonitorExit[var3_1] (shouldn't be in output)
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void a(String string2, String string3) {
        Class<gn> class_ = gn.class;
        synchronized (gn.class) {
            a a2 = new a(string2, string3);
            if (b != null) {
                a = null;
                b.a(a2);
            } else {
                a = a2;
            }
            // ** MonitorExit[var4_2] (shouldn't be in output)
            return;
        }
    }

    public static boolean c() {
        gn gn2 = b;
        if (gn2 != null && gn2.b()) {
            return true;
        }
        a a2 = a;
        return a2 != null && !a2.d.a();
    }

    public abstract void a(a var1);

    public abstract boolean b();

    public static final class a {
        public final String a;
        public final String b;
        public final long c;
        public final el d;

        public a(String string2, String string3) {
            this.a = string2;
            this.b = string3;
            this.c = SystemClock.elapsedRealtime();
            this.d = new el(60000L);
        }
    }

}


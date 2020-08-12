/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 */
package com.tappx.a.a.a.d;

import android.content.Context;
import com.tappx.a.a.a.h.g;
import com.tappx.a.a.a.h.h;
import com.tappx.a.a.a.h.i;
import com.tappx.a.a.a.h.l;

public class z {
    public final String a;
    public final int b;
    public final long c;

    public z(String string2, int n2, long l2) {
        this.a = string2;
        this.b = n2;
        this.c = l2;
    }

    public static class a {
        private static final int a = -1;
        private static final int b = 0;
        private static final int c = 1;
        private static final int d = -2;
        private static final int e = -3;
        private static volatile a f;
        private final Context g;

        public a(Context context) {
            this.g = context;
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public static final a a(Context context) {
            if (f != null) return f;
            Class<a> class_ = a.class;
            synchronized (a.class) {
                if (f != null) return f;
                f = new a(context.getApplicationContext());
                // ** MonitorExit[var2_1] (shouldn't be in output)
                return f;
            }
        }

        public z a() {
            int n2;
            l l2 = h.a(this.g).a().g();
            Boolean bl2 = l2.a();
            i i2 = l2.b();
            long l3 = l2.d();
            if (i2.c()) {
                n2 = 0;
            } else if (i2.b()) {
                n2 = 1;
            } else {
                l3 = 0L;
                n2 = Boolean.FALSE.equals((Object)bl2) ? -1 : (Boolean.TRUE.equals((Object)bl2) ? -2 : -3);
            }
            return new z(l2.c(), n2, l3);
        }
    }

}


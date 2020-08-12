/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.database.sqlite.SQLiteDatabase
 *  java.lang.Class
 *  java.lang.Enum
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.Throwable
 *  java.util.concurrent.atomic.AtomicInteger
 */
package com.appnext.base.a.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.appnext.base.a.b;
import com.appnext.base.b.e;
import java.util.concurrent.atomic.AtomicInteger;

public class a {
    private static a dB;
    private static b dC;
    private AtomicInteger dA = new AtomicInteger(0);
    private SQLiteDatabase dD;

    private a(Context context) {
        dC = b.c(context);
    }

    public static void a(int n2, Throwable throwable) {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static a ac() {
        if (dB != null) return dB;
        Class<a> class_ = a.class;
        synchronized (a.class) {
            if (dB != null) return dB;
            dB = new a(e.getContext().getApplicationContext());
            // ** MonitorExit[var1] (shouldn't be in output)
            return dB;
        }
    }

    public final SQLiteDatabase ad() {
        if (this.dA.incrementAndGet() == 1) {
            this.dD = dC.getWritableDatabase();
        }
        return this.dD;
    }

    public final void ae() {
        if (this.dA.decrementAndGet() == 0) {
            this.dD.close();
        }
    }

    public static final class a
    extends Enum<a> {
        private static final /* synthetic */ int[] $VALUES$40a167d9;
        public static final int DatabaseOrDiskFull$53629b42 = 2;
        public static final int Global$53629b42 = 1;

        static {
            int[] arrn = new int[]{Global$53629b42, DatabaseOrDiskFull$53629b42};
            $VALUES$40a167d9 = arrn;
        }

        public static int[] af() {
            return (int[])$VALUES$40a167d9.clone();
        }
    }

}


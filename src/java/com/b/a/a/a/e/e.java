/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  com.b.a.a.a.b.i
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 */
package com.b.a.a.a.e;

import android.text.TextUtils;
import com.b.a.a.a.a;
import com.b.a.a.a.b.f;
import com.b.a.a.a.b.i;

public class e {
    public static void a() {
        if (a.b()) {
            return;
        }
        throw new IllegalStateException("Method called before OMID activation");
    }

    public static void a(f f2) {
        if (!f2.equals((Object)f.c)) {
            return;
        }
        throw new IllegalArgumentException("Impression owner is none");
    }

    public static void a(i i2) {
        if (!i2.j()) {
            return;
        }
        throw new IllegalStateException("AdSession is started");
    }

    public static void a(Object object, String string2) {
        if (object != null) {
            return;
        }
        throw new IllegalArgumentException(string2);
    }

    public static void a(String string2, int n2, String string3) {
        if (string2.length() <= n2) {
            return;
        }
        throw new IllegalArgumentException(string3);
    }

    public static void a(String string2, String string3) {
        if (!TextUtils.isEmpty((CharSequence)string2)) {
            return;
        }
        throw new IllegalArgumentException(string3);
    }

    public static void b(i i2) {
        if (!i2.k()) {
            return;
        }
        throw new IllegalStateException("AdSession is finished");
    }

    public static void c(i i2) {
        e.h(i2);
        e.b(i2);
    }

    public static void d(i i2) {
        if (i2.f().d() == null) {
            return;
        }
        throw new IllegalStateException("AdEvents already exists for AdSession");
    }

    public static void e(i i2) {
        if (i2.f().e() == null) {
            return;
        }
        throw new IllegalStateException("VideoEvents already exists for AdSession");
    }

    public static void f(i i2) {
        if (i2.l()) {
            return;
        }
        throw new IllegalStateException("Impression event is not expected from the Native AdSession");
    }

    public static void g(i i2) {
        if (i2.m()) {
            return;
        }
        throw new IllegalStateException("Cannot create VideoEvents for JavaScript AdSession");
    }

    private static void h(i i2) {
        if (i2.j()) {
            return;
        }
        throw new IllegalStateException("AdSession is not started");
    }
}


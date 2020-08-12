/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.tapjoy.internal;

import android.os.Looper;
import com.tapjoy.internal.ac;

public final class fz {
    public static boolean a;

    public static void a(String string2) {
        if (a) {
            ac.a(4, "Tapjoy", string2, null);
        }
    }

    public static void a(String string2, String string3, String string4) {
        if (a) {
            ac.a("Tapjoy", "{}: {} {}", string2, string3, string4);
        }
    }

    public static /* varargs */ void a(String string2, Object ... arrobject) {
        if (a) {
            ac.a(4, "Tapjoy", string2, arrobject);
        }
    }

    public static boolean a(Object object, String string2) {
        if (object == null) {
            if (a) {
                fz.b(string2);
            }
            return false;
        }
        return true;
    }

    public static boolean a(boolean bl2, String string2) {
        if (a) {
            if (bl2) {
                return bl2;
            }
            fz.b(string2);
            throw new IllegalStateException(string2);
        }
        return bl2;
    }

    public static void b(String string2) {
        if (a) {
            ac.a(6, "Tapjoy", string2, null);
        }
    }

    public static /* varargs */ void b(String string2, Object ... arrobject) {
        if (a) {
            ac.a("Tapjoy", string2, arrobject);
        }
    }

    public static boolean c(String string2) {
        boolean bl2 = Looper.myLooper() == Looper.getMainLooper();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(": Must be called on the main/ui thread");
        return fz.a(bl2, stringBuilder.toString());
    }
}


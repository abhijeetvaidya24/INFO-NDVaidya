/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.StackTraceElement
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.Arrays
 *  java.util.List
 */
package io.presage;

import io.presage.ad;
import io.presage.am;
import java.util.Arrays;
import java.util.List;

public class cl {
    private cl() {
    }

    private static <T extends Throwable> T a(T t2) {
        return cl.a(t2, cl.class.getName());
    }

    static <T extends Throwable> T a(T t2, String string2) {
        Object[] arrobject = t2.getStackTrace();
        int n2 = arrobject.length;
        int n3 = -1;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (!string2.equals((Object)arrobject[i2].getClassName())) continue;
            n3 = i2;
        }
        List list = Arrays.asList((Object[])arrobject).subList(n3 + 1, n2);
        t2.setStackTrace((StackTraceElement[])list.toArray((Object[])new StackTraceElement[list.size()]));
        return t2;
    }

    public static void a() {
        throw cl.a(new ad());
    }

    public static void a(Object object, String string2) {
        if (object != null) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(" must not be null");
        throw cl.a(new IllegalStateException(stringBuilder.toString()));
    }

    public static void a(String string2) {
        StringBuilder stringBuilder = new StringBuilder("lateinit property ");
        stringBuilder.append(string2);
        stringBuilder.append(" has not been initialized");
        cl.b(stringBuilder.toString());
    }

    public static boolean a(Object object, Object object2) {
        if (object == null) {
            return object2 == null;
        }
        return object.equals(object2);
    }

    private static void b(String string2) {
        throw cl.a(new am(string2));
    }
}


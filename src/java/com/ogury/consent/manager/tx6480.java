/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.StackTraceElement
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.util.Arrays
 *  java.util.List
 */
package com.ogury.consent.manager;

import com.ogury.consent.manager.viewh8400;
import java.util.Arrays;
import java.util.List;

public class tx6480 {
    private tx6480() {
    }

    private static <T extends Throwable> T a(T t2) {
        return tx6480.a(t2, tx6480.class.getName());
    }

    private static <T extends Throwable> T a(T t2, String string2) {
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

    public static void a(Object object, String string2) {
        if (object != null) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(" must not be null");
        throw tx6480.a(new IllegalStateException(stringBuilder.toString()));
    }

    public static void a(String string2) {
        StringBuilder stringBuilder = new StringBuilder("lateinit property ");
        stringBuilder.append(string2);
        stringBuilder.append(" has not been initialized");
        throw tx6480.a(new viewh8400(stringBuilder.toString()));
    }

    public static boolean a(Object object, Object object2) {
        if (object == null) {
            return object2 == null;
        }
        return object.equals(object2);
    }

    public static void b(Object object, String string2) {
        if (object != null) {
            return;
        }
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
        String string3 = stackTraceElement.getClassName();
        String string4 = stackTraceElement.getMethodName();
        StringBuilder stringBuilder = new StringBuilder("Parameter specified as non-null is null: method ");
        stringBuilder.append(string3);
        stringBuilder.append(".");
        stringBuilder.append(string4);
        stringBuilder.append(", parameter ");
        stringBuilder.append(string2);
        throw tx6480.a(new IllegalArgumentException(stringBuilder.toString()));
    }
}


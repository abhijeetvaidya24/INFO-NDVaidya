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
package a.a.b.b;

import a.a.b;
import java.util.Arrays;
import java.util.List;

public class h {
    private h() {
    }

    private static <T extends Throwable> T a(T t2) {
        return h.a(t2, h.class.getName());
    }

    static <T extends Throwable> T a(T t2, String string) {
        Object[] arrobject = t2.getStackTrace();
        int n2 = arrobject.length;
        int n3 = -1;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (!string.equals((Object)arrobject[i2].getClassName())) continue;
            n3 = i2;
        }
        List list = Arrays.asList((Object[])arrobject).subList(n3 + 1, n2);
        t2.setStackTrace((StackTraceElement[])list.toArray((Object[])new StackTraceElement[list.size()]));
        return t2;
    }

    public static void a() {
        throw h.a(new b());
    }

    public static void a(Object object, String string) {
        if (object != null) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(" must not be null");
        throw h.a(new IllegalStateException(stringBuilder.toString()));
    }

    private static void a(String string) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
        String string2 = stackTraceElement.getClassName();
        String string3 = stackTraceElement.getMethodName();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Parameter specified as non-null is null: method ");
        stringBuilder.append(string2);
        stringBuilder.append(".");
        stringBuilder.append(string3);
        stringBuilder.append(", parameter ");
        stringBuilder.append(string);
        throw h.a(new IllegalArgumentException(stringBuilder.toString()));
    }

    public static boolean a(Object object, Object object2) {
        if (object == null) {
            return object2 == null;
        }
        return object.equals(object2);
    }

    public static void b(Object object, String string) {
        if (object == null) {
            h.a(string);
        }
    }
}


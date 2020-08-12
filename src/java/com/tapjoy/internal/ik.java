/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.PrintStream
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuffer
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.util.Map
 */
package com.tapjoy.internal;

import java.io.PrintStream;
import java.util.Map;

public final class ik {
    public static void a(StringBuffer stringBuffer, Object object, Map map) {
        if (object == null) {
            stringBuffer.append("null");
            return;
        }
        if (!object.getClass().isArray()) {
            try {
                stringBuffer.append(object.toString());
                return;
            }
            catch (Throwable throwable) {
                PrintStream printStream = System.err;
                StringBuilder stringBuilder = new StringBuilder("SLF4J: Failed toString() invocation on an object of type [");
                stringBuilder.append(object.getClass().getName());
                stringBuilder.append("]");
                printStream.println(stringBuilder.toString());
                throwable.printStackTrace();
                stringBuffer.append("[FAILED toString()]");
                return;
            }
        }
        if (object instanceof boolean[]) {
            ik.a(stringBuffer, (boolean[])object);
            return;
        }
        if (object instanceof byte[]) {
            ik.a(stringBuffer, (byte[])object);
            return;
        }
        if (object instanceof char[]) {
            ik.a(stringBuffer, (char[])object);
            return;
        }
        if (object instanceof short[]) {
            ik.a(stringBuffer, (short[])object);
            return;
        }
        if (object instanceof int[]) {
            ik.a(stringBuffer, (int[])object);
            return;
        }
        if (object instanceof long[]) {
            ik.a(stringBuffer, (long[])object);
            return;
        }
        if (object instanceof float[]) {
            ik.a(stringBuffer, (float[])object);
            return;
        }
        if (object instanceof double[]) {
            ik.a(stringBuffer, (double[])object);
            return;
        }
        ik.a(stringBuffer, (Object[])object, map);
    }

    private static void a(StringBuffer stringBuffer, byte[] arrby) {
        stringBuffer.append('[');
        int n2 = arrby.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            stringBuffer.append((int)arrby[i2]);
            if (i2 == n2 - 1) continue;
            stringBuffer.append(", ");
        }
        stringBuffer.append(']');
    }

    private static void a(StringBuffer stringBuffer, char[] arrc) {
        stringBuffer.append('[');
        int n2 = arrc.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            stringBuffer.append(arrc[i2]);
            if (i2 == n2 - 1) continue;
            stringBuffer.append(", ");
        }
        stringBuffer.append(']');
    }

    private static void a(StringBuffer stringBuffer, double[] arrd) {
        stringBuffer.append('[');
        int n2 = arrd.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            stringBuffer.append(arrd[i2]);
            if (i2 == n2 - 1) continue;
            stringBuffer.append(", ");
        }
        stringBuffer.append(']');
    }

    private static void a(StringBuffer stringBuffer, float[] arrf) {
        stringBuffer.append('[');
        int n2 = arrf.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            stringBuffer.append(arrf[i2]);
            if (i2 == n2 - 1) continue;
            stringBuffer.append(", ");
        }
        stringBuffer.append(']');
    }

    private static void a(StringBuffer stringBuffer, int[] arrn) {
        stringBuffer.append('[');
        int n2 = arrn.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            stringBuffer.append(arrn[i2]);
            if (i2 == n2 - 1) continue;
            stringBuffer.append(", ");
        }
        stringBuffer.append(']');
    }

    private static void a(StringBuffer stringBuffer, long[] arrl) {
        stringBuffer.append('[');
        int n2 = arrl.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            stringBuffer.append(arrl[i2]);
            if (i2 == n2 - 1) continue;
            stringBuffer.append(", ");
        }
        stringBuffer.append(']');
    }

    private static void a(StringBuffer stringBuffer, Object[] arrobject, Map map) {
        stringBuffer.append('[');
        if (!map.containsKey((Object)arrobject)) {
            map.put((Object)arrobject, null);
            int n2 = arrobject.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                ik.a(stringBuffer, arrobject[i2], map);
                if (i2 == n2 - 1) continue;
                stringBuffer.append(", ");
            }
            map.remove((Object)arrobject);
        } else {
            stringBuffer.append("...");
        }
        stringBuffer.append(']');
    }

    private static void a(StringBuffer stringBuffer, short[] arrs) {
        stringBuffer.append('[');
        int n2 = arrs.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            stringBuffer.append((int)arrs[i2]);
            if (i2 == n2 - 1) continue;
            stringBuffer.append(", ");
        }
        stringBuffer.append(']');
    }

    private static void a(StringBuffer stringBuffer, boolean[] arrbl) {
        stringBuffer.append('[');
        int n2 = arrbl.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            stringBuffer.append(arrbl[i2]);
            if (i2 == n2 - 1) continue;
            stringBuffer.append(", ");
        }
        stringBuffer.append(']');
    }
}


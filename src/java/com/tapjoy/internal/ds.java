/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Collections
 *  java.util.List
 */
package com.tapjoy.internal;

import com.tapjoy.internal.dr;
import com.tapjoy.internal.dt;
import java.util.Collections;
import java.util.List;

public final class ds {
    public static /* varargs */ IllegalStateException a(Object ... arrobject) {
        IllegalStateException illegalStateException;
        StringBuilder stringBuilder = new StringBuilder();
        int n2 = arrobject.length;
        String string2 = "";
        for (int i2 = 0; i2 < n2; i2 += 2) {
            if (arrobject[i2] != null) continue;
            if (stringBuilder.length() > 0) {
                string2 = "s";
            }
            stringBuilder.append("\n  ");
            stringBuilder.append(arrobject[i2 + 1]);
        }
        StringBuilder stringBuilder2 = new StringBuilder("Required field");
        stringBuilder2.append(string2);
        stringBuilder2.append(" not set:");
        stringBuilder2.append((Object)stringBuilder);
        illegalStateException = new IllegalStateException(stringBuilder2.toString());
        throw illegalStateException;
    }

    public static List a() {
        return new dt(Collections.emptyList());
    }

    public static List a(String string2, List list) {
        if (list != null) {
            if (list instanceof dt) {
                list = ((dt)list).a;
            }
            if (list != Collections.emptyList()) {
                if (list instanceof dr) {
                    return list;
                }
                dr dr2 = new dr(list);
                if (!dr2.contains(null)) {
                    return dr2;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string2);
                stringBuilder.append(".contains(null)");
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            return list;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(" == null");
        throw new NullPointerException(stringBuilder.toString());
    }

    public static boolean a(Object object, Object object2) {
        return object == object2 || object != null && object.equals(object2);
        {
        }
    }
}


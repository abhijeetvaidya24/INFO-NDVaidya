/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Float
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 */
package com.tapjoy.internal;

import com.tapjoy.internal.ct;

public final class he {
    public float a;
    public int b;

    public static he a(String string2) {
        char c2;
        he he2;
        int n2;
        block7 : {
            if (ct.c(string2)) {
                return null;
            }
            try {
                he2 = new he();
                n2 = string2.length() - 1;
                c2 = string2.charAt(n2);
                if (c2 != 'w') break block7;
            }
            catch (NumberFormatException numberFormatException) {
                return null;
            }
            he2.a = Float.valueOf((String)string2.substring(0, n2)).floatValue();
            he2.b = 1;
            return he2;
        }
        if (c2 == 'h') {
            he2.a = Float.valueOf((String)string2.substring(0, n2)).floatValue();
            he2.b = 2;
            return he2;
        }
        he2.a = Float.valueOf((String)string2).floatValue();
        he2.b = 0;
        return he2;
    }

    public final float a(float f2, float f3) {
        int n2 = this.b;
        if (n2 == 1) {
            return f2 * this.a / 100.0f;
        }
        if (n2 == 2) {
            return f3 * this.a / 100.0f;
        }
        return this.a;
    }
}


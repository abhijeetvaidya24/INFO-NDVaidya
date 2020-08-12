/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.tapjoy.internal;

public final class co {
    private final String[] a = new String[512];

    public final String a(char[] arrc, int n2, int n3) {
        String string2;
        int n4 = 0;
        for (int i2 = n2; i2 < n2 + n3; ++i2) {
            n4 = n4 * 31 + arrc[i2];
        }
        String[] arrstring = this.a;
        int n5 = n4 ^ (n4 >>> 20 ^ n4 >>> 12);
        int n6 = n5 ^ (n5 >>> 7 ^ n5 >>> 4);
        int n7 = n6 & arrstring.length - 1;
        String string3 = arrstring[n7];
        if (string3 != null) {
            boolean bl2;
            block6 : {
                if (string3.length() != n3) {
                    bl2 = false;
                } else {
                    for (int i3 = 0; i3 < n3; ++i3) {
                        if (arrc[n2 + i3] == string3.charAt(i3)) continue;
                        bl2 = false;
                        break block6;
                    }
                    bl2 = true;
                }
            }
            if (bl2) {
                return string3;
            }
        }
        this.a[n7] = string2 = new String(arrc, n2, n3);
        return string2;
    }
}


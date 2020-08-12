/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Arrays
 *  java.util.List
 */
package com.startapp.android.publish.adsCommon.g.c;

import java.util.Arrays;
import java.util.List;

public final class a {
    private static final List<String> c = Arrays.asList((Object[])new String[]{"portrait", "landscape", "none"});
    public boolean a;
    public int b;

    public a() {
        this(true, 2);
    }

    public a(boolean bl, int n2) {
        this.a = bl;
        this.b = n2;
    }

    public static int a(String string) {
        int n2 = c.indexOf((Object)string);
        if (n2 != -1) {
            return n2;
        }
        return 2;
    }
}


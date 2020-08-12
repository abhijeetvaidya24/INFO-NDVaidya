/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Object
 *  java.util.Date
 *  java.util.HashSet
 *  java.util.Set
 */
package com.adincube.sdk.util.g;

import com.adincube.sdk.util.g.a;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public final class e {
    public static Date a(a a2) {
        return new Date(100L * a2.a(36));
    }

    public static Set<Integer> a(a a2, int n2) {
        HashSet hashSet = new HashSet();
        for (int i2 = 1; i2 <= n2; ++i2) {
            if (a2.a() != 1) continue;
            hashSet.add((Object)i2);
        }
        return hashSet;
    }
}


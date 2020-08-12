/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.adincube.sdk.h.a.a.a
 *  com.adincube.sdk.h.a.a.b
 *  com.adincube.sdk.h.a.e
 *  java.lang.Object
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.List
 */
package com.adincube.sdk.util;

import com.adincube.sdk.h.a.a.a;
import com.adincube.sdk.h.a.a.b;
import com.adincube.sdk.h.a.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class c {
    public static a a(e e2, b b2) {
        List<a> list = c.a(e2, b2, true);
        if (!list.isEmpty()) {
            return (a)list.get(0);
        }
        return null;
    }

    public static List<a> a(e e2, b b2, boolean bl) {
        ArrayList arrayList = new ArrayList();
        for (a a2 : e2.g()) {
            if (a2.b != b2 || a2.c != bl) continue;
            arrayList.add((Object)a2);
        }
        return arrayList;
    }
}


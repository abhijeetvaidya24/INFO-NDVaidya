/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Deprecated
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collections
 *  java.util.Comparator
 *  java.util.List
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 *  java.util.TreeMap
 */
package com.tappx.b;

import com.tappx.b.g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class k {
    public final int a;
    public final byte[] b;
    public final Map<String, String> c;
    public final List<g> d;
    public final boolean e;
    public final long f;

    private k(int n2, byte[] arrby, Map<String, String> map, List<g> list, boolean bl, long l2) {
        this.a = n2;
        this.b = arrby;
        this.c = map;
        this.d = list == null ? null : Collections.unmodifiableList(list);
        this.e = bl;
        this.f = l2;
    }

    @Deprecated
    public k(int n2, byte[] arrby, Map<String, String> map, boolean bl) {
        this(n2, arrby, map, bl, 0L);
    }

    @Deprecated
    public k(int n2, byte[] arrby, Map<String, String> map, boolean bl, long l2) {
        this(n2, arrby, map, k.a(map), bl, l2);
    }

    public k(int n2, byte[] arrby, boolean bl, long l2, List<g> list) {
        this(n2, arrby, k.a(list), list, bl, l2);
    }

    public k(byte[] arrby) {
        this(200, arrby, false, 0L, (List<g>)Collections.emptyList());
    }

    @Deprecated
    public k(byte[] arrby, Map<String, String> map) {
        this(200, arrby, map, false, 0L);
    }

    private static List<g> a(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        if (map.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry entry : map.entrySet()) {
            arrayList.add((Object)new g((String)entry.getKey(), (String)entry.getValue()));
        }
        return arrayList;
    }

    private static Map<String, String> a(List<g> list) {
        if (list == null) {
            return null;
        }
        if (list.isEmpty()) {
            return Collections.emptyMap();
        }
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (g g2 : list) {
            treeMap.put((Object)g2.a(), (Object)g2.b());
        }
        return treeMap;
    }
}


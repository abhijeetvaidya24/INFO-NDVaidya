/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.List
 *  java.util.Map
 */
package com.applovin.impl.sdk.e;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class n {
    public static final n a = new n();
    protected String b;
    protected final List<n> c;
    private final n d;
    private final String e;
    private final Map<String, String> f;

    private n() {
        this.d = null;
        this.e = "";
        this.f = Collections.emptyMap();
        this.b = "";
        this.c = Collections.emptyList();
    }

    public n(String string2, Map<String, String> map, n n2) {
        this.d = n2;
        this.e = string2;
        this.f = Collections.unmodifiableMap(map);
        this.c = new ArrayList();
    }

    public String a() {
        return this.e;
    }

    public List<n> a(String string2) {
        IllegalArgumentException illegalArgumentException;
        if (string2 != null) {
            ArrayList arrayList = new ArrayList(this.c.size());
            for (n n2 : this.c) {
                if (!string2.equalsIgnoreCase(n2.a())) continue;
                arrayList.add((Object)n2);
            }
            return arrayList;
        }
        illegalArgumentException = new IllegalArgumentException("No name specified.");
        throw illegalArgumentException;
    }

    public n b(String string2) {
        IllegalArgumentException illegalArgumentException;
        if (string2 != null) {
            for (n n2 : this.c) {
                if (!string2.equalsIgnoreCase(n2.a())) continue;
                return n2;
            }
            return null;
        }
        illegalArgumentException = new IllegalArgumentException("No name specified.");
        throw illegalArgumentException;
    }

    public Map<String, String> b() {
        return this.f;
    }

    public n c(String string2) {
        IllegalArgumentException illegalArgumentException;
        if (string2 != null) {
            if (this.c.size() > 0) {
                ArrayList arrayList = new ArrayList();
                arrayList.add((Object)this);
                while (!arrayList.isEmpty()) {
                    n n2 = (n)arrayList.get(0);
                    arrayList.remove(0);
                    if (string2.equalsIgnoreCase(n2.a())) {
                        return n2;
                    }
                    arrayList.addAll(n2.d());
                }
            }
            return null;
        }
        illegalArgumentException = new IllegalArgumentException("No name specified.");
        throw illegalArgumentException;
    }

    public String c() {
        return this.b;
    }

    public List<n> d() {
        return Collections.unmodifiableList(this.c);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("XmlNode{, elementName='");
        stringBuilder.append(this.e);
        stringBuilder.append('\'');
        stringBuilder.append(", text='");
        stringBuilder.append(this.b);
        stringBuilder.append('\'');
        stringBuilder.append(", attributes=");
        stringBuilder.append(this.f);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}


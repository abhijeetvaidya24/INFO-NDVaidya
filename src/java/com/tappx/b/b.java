/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.util.Collections
 *  java.util.List
 *  java.util.Map
 */
package com.tappx.b;

import com.tappx.b.g;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public interface b {
    public a a(String var1);

    public void a();

    public void a(String var1, a var2);

    public void a(String var1, boolean var2);

    public void b();

    public void b(String var1);

    public static class a {
        public byte[] a;
        public String b;
        public long c;
        public long d;
        public long e;
        public long f;
        public Map<String, String> g = Collections.emptyMap();
        public List<g> h;

        public boolean a() {
            return this.e < System.currentTimeMillis();
        }

        public boolean b() {
            return this.f < System.currentTimeMillis();
        }
    }

}


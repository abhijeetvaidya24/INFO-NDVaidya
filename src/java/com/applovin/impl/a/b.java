/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  com.applovin.impl.sdk.e.j
 *  com.applovin.impl.sdk.e.n
 *  com.applovin.impl.sdk.j
 *  com.applovin.impl.sdk.p
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.HashMap
 *  java.util.HashSet
 *  java.util.List
 *  java.util.Map
 *  java.util.Set
 */
package com.applovin.impl.a;

import android.net.Uri;
import com.applovin.impl.a.c;
import com.applovin.impl.a.e;
import com.applovin.impl.a.g;
import com.applovin.impl.a.i;
import com.applovin.impl.sdk.e.j;
import com.applovin.impl.sdk.e.n;
import com.applovin.impl.sdk.p;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class b {
    private int a;
    private int b;
    private Uri c;
    private e d;
    private Set<g> e = new HashSet();
    private Map<String, Set<g>> f = new HashMap();

    private b() {
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static b a(n var0, b var1_1, c var2_2, com.applovin.impl.sdk.j var3_3) {
        if (var0 == null) throw new IllegalArgumentException("No node specified.");
        if (var3_3 == null) throw new IllegalArgumentException("No sdk specified.");
        if (var1_1 != null) ** GOTO lbl6
        try {
            var1_1 = new b();
lbl6: // 2 sources:
            if (var1_1.a == 0 && var1_1.b == 0) {
                var7_4 = j.a((String)((String)var0.b().get((Object)"width")));
                var8_5 = j.a((String)((String)var0.b().get((Object)"height")));
                if (var7_4 > 0 && var8_5 > 0) {
                    var1_1.a = var7_4;
                    var1_1.b = var8_5;
                }
            }
            var1_1.d = e.a(var0, var1_1.d, var3_3);
            if (var1_1.c == null && (var5_6 = var0.b("CompanionClickThrough")) != null && j.b((String)(var6_7 = var5_6.c()))) {
                var1_1.c = Uri.parse((String)var6_7);
            }
            i.a((List<n>)var0.a("CompanionClickTracking"), var1_1.e, var2_2, var3_3);
            i.a(var0, var1_1.f, var2_2, var3_3);
            return var1_1;
        }
        catch (Throwable var4_8) {
            var3_3.u().b("VastCompanionAd", "Error occurred while initializing", var4_8);
            return null;
        }
    }

    public Uri a() {
        return this.c;
    }

    public e b() {
        return this.d;
    }

    public Set<g> c() {
        return this.e;
    }

    public Map<String, Set<g>> d() {
        return this.f;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof b)) {
            return false;
        }
        b b2 = (b)object;
        if (this.a != b2.a) {
            return false;
        }
        if (this.b != b2.b) {
            return false;
        }
        Uri uri = this.c;
        if (uri != null ? !uri.equals((Object)b2.c) : b2.c != null) {
            return false;
        }
        e e2 = this.d;
        if (e2 != null ? !e2.equals(b2.d) : b2.d != null) {
            return false;
        }
        Set<g> set = this.e;
        if (set != null ? !set.equals(b2.e) : b2.e != null) {
            return false;
        }
        Map<String, Set<g>> map = this.f;
        if (map != null) {
            return map.equals(b2.f);
        }
        return b2.f == null;
    }

    public int hashCode() {
        int n2 = 31 * (31 * this.a + this.b);
        Uri uri = this.c;
        int n3 = uri != null ? uri.hashCode() : 0;
        int n4 = 31 * (n2 + n3);
        e e2 = this.d;
        int n5 = e2 != null ? e2.hashCode() : 0;
        int n6 = 31 * (n4 + n5);
        Set<g> set = this.e;
        int n7 = set != null ? set.hashCode() : 0;
        int n8 = 31 * (n6 + n7);
        Map<String, Set<g>> map = this.f;
        int n9 = 0;
        if (map != null) {
            n9 = map.hashCode();
        }
        return n8 + n9;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("VastCompanionAd{width=");
        stringBuilder.append(this.a);
        stringBuilder.append(", height=");
        stringBuilder.append(this.b);
        stringBuilder.append(", destinationUri=");
        stringBuilder.append((Object)this.c);
        stringBuilder.append(", nonVideoResource=");
        stringBuilder.append((Object)this.d);
        stringBuilder.append(", clickTrackers=");
        stringBuilder.append(this.e);
        stringBuilder.append(", eventTrackers=");
        stringBuilder.append(this.f);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}


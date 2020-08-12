/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.HashMap
 *  java.util.LinkedHashSet
 *  java.util.List
 *  java.util.Locale
 *  java.util.Map
 *  java.util.Set
 *  org.json.JSONObject
 */
package com.applovin.impl.sdk.ad;

import android.text.TextUtils;
import com.applovin.impl.sdk.ad.e;
import com.applovin.impl.sdk.b.b;
import com.applovin.impl.sdk.e.g;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.p;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public final class d {
    private static final Map<String, d> a = new HashMap();
    private static final Object b = new Object();
    private j c;
    private p d;
    private JSONObject e;
    private final String f;
    private String g;
    private AppLovinAdSize h;
    private AppLovinAdType i;

    private d(AppLovinAdSize appLovinAdSize, AppLovinAdType appLovinAdType, String string2, j j2) {
        if (TextUtils.isEmpty((CharSequence)string2) && (appLovinAdType == null || appLovinAdSize == null)) {
            throw new IllegalArgumentException("No zone identifier or type or size specified");
        }
        this.c = j2;
        p p2 = j2 != null ? j2.u() : null;
        this.d = p2;
        this.h = appLovinAdSize;
        this.i = appLovinAdType;
        if (!TextUtils.isEmpty((CharSequence)string2)) {
            this.f = string2.toLowerCase(Locale.ENGLISH);
            this.g = string2.toLowerCase(Locale.ENGLISH);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(appLovinAdSize.getLabel());
        stringBuilder.append("_");
        stringBuilder.append(appLovinAdType.getLabel());
        this.f = stringBuilder.toString().toLowerCase(Locale.ENGLISH);
    }

    public static d a(AppLovinAdSize appLovinAdSize, AppLovinAdType appLovinAdType, j j2) {
        return d.a(appLovinAdSize, appLovinAdType, null, j2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static d a(AppLovinAdSize appLovinAdSize, AppLovinAdType appLovinAdType, String string2, j j2) {
        Object object;
        d d2 = new d(appLovinAdSize, appLovinAdType, string2, j2);
        Object object2 = object = b;
        synchronized (object2) {
            String string3 = d2.f;
            if (a.containsKey((Object)string3)) {
                return (d)a.get((Object)string3);
            }
            a.put((Object)string3, (Object)d2);
            return d2;
        }
    }

    public static d a(String string2, j j2) {
        return d.a(null, null, string2, j2);
    }

    public static d a(String string2, JSONObject jSONObject, j j2) {
        d d2 = d.a(string2, j2);
        d2.e = jSONObject;
        return d2;
    }

    private <ST> b<ST> a(String string2, b<ST> b2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(this.f);
        String string3 = stringBuilder.toString();
        return this.c.a(string3, b2);
    }

    private boolean a(b<String> b2, AppLovinAdSize appLovinAdSize) {
        return this.c.a(b2).toUpperCase(Locale.ENGLISH).contains((CharSequence)appLovinAdSize.getLabel());
    }

    public static d b(String string2, j j2) {
        return d.a(AppLovinAdSize.NATIVE, AppLovinAdType.NATIVE, string2, j2);
    }

    public static Collection<d> b(j j2) {
        LinkedHashSet linkedHashSet = new LinkedHashSet(8);
        Object[] arrobject = new d[]{d.c(j2), d.d(j2), d.e(j2), d.f(j2), d.g(j2), d.h(j2)};
        Collections.addAll((Collection)linkedHashSet, (Object[])arrobject);
        return Collections.unmodifiableSet((Set)linkedHashSet);
    }

    public static d c(j j2) {
        return d.a(AppLovinAdSize.BANNER, AppLovinAdType.REGULAR, j2);
    }

    public static d c(String string2, j j2) {
        return d.a(AppLovinAdSize.INTERSTITIAL, AppLovinAdType.INCENTIVIZED, string2, j2);
    }

    public static d d(j j2) {
        return d.a(AppLovinAdSize.MREC, AppLovinAdType.REGULAR, j2);
    }

    public static d e(j j2) {
        return d.a(AppLovinAdSize.LEADER, AppLovinAdType.REGULAR, j2);
    }

    public static d f(j j2) {
        return d.a(AppLovinAdSize.INTERSTITIAL, AppLovinAdType.REGULAR, j2);
    }

    public static d g(j j2) {
        return d.a(AppLovinAdSize.INTERSTITIAL, AppLovinAdType.INCENTIVIZED, j2);
    }

    public static d h(j j2) {
        return d.a(AppLovinAdSize.NATIVE, AppLovinAdType.NATIVE, j2);
    }

    private boolean m() {
        block4 : {
            try {
                if (TextUtils.isEmpty((CharSequence)this.g)) break block4;
                return true;
            }
            catch (Throwable throwable) {
                this.d.b("AdZone", "Unable to safely test preload merge capability", throwable);
                return false;
            }
        }
        if (AppLovinAdType.INCENTIVIZED.equals(this.c())) {
            return this.c.a(b.aP);
        }
        boolean bl = this.a(b.aO, this.b());
        return bl;
    }

    public String a() {
        return this.f;
    }

    void a(j j2) {
        this.c = j2;
        this.d = j2.u();
    }

    public AppLovinAdSize b() {
        if (this.h == null && g.a(this.e, "ad_size")) {
            this.h = AppLovinAdSize.fromString(g.a(this.e, "ad_size", null, this.c));
        }
        return this.h;
    }

    public AppLovinAdType c() {
        if (this.i == null && g.a(this.e, "ad_type")) {
            this.i = new AppLovinAdType(g.a(this.e, "ad_type", null, this.c));
        }
        return this.i;
    }

    public boolean d() {
        return AppLovinAdSize.NATIVE.equals((Object)this.b()) && AppLovinAdType.NATIVE.equals(this.c());
    }

    public int e() {
        if (g.a(this.e, "capacity")) {
            return g.a(this.e, "capacity", 0, this.c);
        }
        if (!TextUtils.isEmpty((CharSequence)this.g)) {
            if (this.d()) {
                return this.c.a(b.be);
            }
            return this.c.a(b.bd);
        }
        b<Integer> b2 = this.a("preload_capacity_", b.aS);
        return this.c.a(b2);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null && this.getClass() == object.getClass()) {
            d d2 = (d)object;
            return this.f.equalsIgnoreCase(d2.f);
        }
        return false;
    }

    public int f() {
        if (g.a(this.e, "extended_capacity")) {
            return g.a(this.e, "extended_capacity", 0, this.c);
        }
        if (!TextUtils.isEmpty((CharSequence)this.g)) {
            if (this.d()) {
                return 0;
            }
            return this.c.a(b.bf);
        }
        b<Integer> b2 = this.a("extended_preload_capacity_", b.aY);
        return this.c.a(b2);
    }

    public int g() {
        return g.a(this.e, "preload_count", 0, this.c);
    }

    /*
     * Enabled aggressive block sorting
     */
    public boolean h() {
        b<Boolean> b2;
        j j2;
        Boolean bl;
        if (g.a(this.e, "refresh_enabled")) {
            bl = g.a(this.e, "refresh_enabled", false, this.c);
            return bl;
        }
        if (AppLovinAdSize.BANNER.equals((Object)this.b())) {
            j2 = this.c;
            b2 = b.cx;
        } else if (AppLovinAdSize.MREC.equals((Object)this.b())) {
            j2 = this.c;
            b2 = b.cz;
        } else {
            if (!AppLovinAdSize.LEADER.equals((Object)this.b())) return false;
            j2 = this.c;
            b2 = b.cB;
        }
        bl = j2.a(b2);
        return bl;
    }

    public int hashCode() {
        return this.f.hashCode();
    }

    public long i() {
        if (g.a(this.e, "refresh_seconds")) {
            return g.a(this.e, "refresh_seconds", 0, this.c);
        }
        if (AppLovinAdSize.BANNER.equals((Object)this.b())) {
            return this.c.a(b.cy);
        }
        if (AppLovinAdSize.MREC.equals((Object)this.b())) {
            return this.c.a(b.cA);
        }
        if (AppLovinAdSize.LEADER.equals((Object)this.b())) {
            return this.c.a(b.cC);
        }
        return -1L;
    }

    public boolean j() {
        if (!this.c.a(b.aN).booleanValue()) {
            return false;
        }
        if (!this.m()) {
            return false;
        }
        if (!TextUtils.isEmpty((CharSequence)this.g)) {
            if (this.e != null && this.g() == 0) {
                return false;
            }
            String string2 = this.c.a(b.aO).toUpperCase(Locale.ENGLISH);
            if (!(string2.contains((CharSequence)AppLovinAdSize.INTERSTITIAL.getLabel()) || string2.contains((CharSequence)AppLovinAdSize.BANNER.getLabel()) || string2.contains((CharSequence)AppLovinAdSize.MREC.getLabel()) || string2.contains((CharSequence)AppLovinAdSize.LEADER.getLabel()))) {
                return this.c.O().a(this) && this.g() > 0 && this.c.a(b.ea) != false;
            }
            return this.c.a(b.bm);
        }
        b<ST> b2 = this.a("preload_merge_init_tasks_", null);
        boolean bl = false;
        if (b2 != null) {
            boolean bl2 = (Boolean)this.c.a(b2);
            bl = false;
            if (bl2) {
                int n2 = this.e();
                bl = false;
                if (n2 > 0) {
                    bl = true;
                }
            }
        }
        return bl;
    }

    public boolean k() {
        if (g.a(this.e, "wrapped_ads_enabled")) {
            return g.a(this.e, "wrapped_ads_enabled", false, this.c);
        }
        if (this.b() != null) {
            return this.c.b(b.ca).contains((Object)this.b().getLabel());
        }
        return this.c.a(b.bZ);
    }

    public boolean l() {
        return d.b(this.c).contains((Object)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AdZone{identifier=");
        stringBuilder.append(this.f);
        stringBuilder.append(", zoneObject=");
        stringBuilder.append((Object)this.e);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}


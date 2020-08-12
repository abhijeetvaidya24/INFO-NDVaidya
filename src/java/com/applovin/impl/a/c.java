/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.applovin.impl.sdk.ad.b
 *  com.applovin.impl.sdk.ad.d
 *  com.applovin.impl.sdk.e.d
 *  com.applovin.impl.sdk.e.g
 *  com.applovin.impl.sdk.e.m
 *  com.applovin.impl.sdk.e.n
 *  com.applovin.impl.sdk.j
 *  com.applovin.sdk.AppLovinAdSize
 *  com.applovin.sdk.AppLovinAdType
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.List
 *  org.json.JSONObject
 */
package com.applovin.impl.a;

import com.applovin.impl.sdk.ad.b;
import com.applovin.impl.sdk.ad.d;
import com.applovin.impl.sdk.e.g;
import com.applovin.impl.sdk.e.m;
import com.applovin.impl.sdk.e.n;
import com.applovin.impl.sdk.j;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

public class c {
    private static final List<String> c = Arrays.asList((Object[])new String[]{"video/mp4", "video/webm", "video/3gpp", "video/x-matroska"});
    protected List<n> a;
    private final j b;
    private final JSONObject d;
    private final JSONObject e;
    private final b f;
    private final long g;

    public c(JSONObject jSONObject, JSONObject jSONObject2, b b2, j j2) {
        this.b = j2;
        this.d = jSONObject;
        this.e = jSONObject2;
        this.f = b2;
        this.a = new ArrayList();
        this.g = System.currentTimeMillis();
    }

    public int a() {
        return this.a.size();
    }

    public List<n> b() {
        return this.a;
    }

    public JSONObject c() {
        return this.d;
    }

    public JSONObject d() {
        return this.e;
    }

    public b e() {
        return this.f;
    }

    public long f() {
        return this.g;
    }

    public d g() {
        String string = g.a((JSONObject)this.e, (String)"zone_id", null, (j)this.b);
        AppLovinAdType appLovinAdType = AppLovinAdType.fromString((String)g.a((JSONObject)this.e, (String)"ad_type", null, (j)this.b));
        return d.a((AppLovinAdSize)AppLovinAdSize.fromString((String)g.a((JSONObject)this.e, (String)"ad_size", null, (j)this.b)), (AppLovinAdType)appLovinAdType, (String)string, (j)this.b);
    }

    public List<String> h() {
        List list = com.applovin.impl.sdk.e.d.a((String)g.a((JSONObject)this.d, (String)"vast_preferred_video_types", null, null));
        if (!list.isEmpty()) {
            return list;
        }
        return c;
    }

    public int i() {
        return m.a((JSONObject)this.d);
    }
}


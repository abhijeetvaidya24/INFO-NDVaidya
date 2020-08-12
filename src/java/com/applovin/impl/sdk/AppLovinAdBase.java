/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  com.applovin.impl.sdk.ad.h
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.util.Arrays
 *  org.json.JSONObject
 */
package com.applovin.impl.sdk;

import android.text.TextUtils;
import com.applovin.impl.sdk.ad.d;
import com.applovin.impl.sdk.ad.h;
import com.applovin.impl.sdk.ad.j;
import com.applovin.impl.sdk.b.b;
import com.applovin.impl.sdk.e.g;
import com.applovin.impl.sdk.p;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import java.util.Arrays;
import org.json.JSONObject;

public abstract class AppLovinAdBase
implements j,
AppLovinAd {
    private final int a;
    protected final JSONObject adObject;
    protected final Object adObjectLock;
    private d b;
    private final long c;
    private h d;
    protected final JSONObject fullResponse;
    protected final com.applovin.impl.sdk.j sdk;
    protected final com.applovin.impl.sdk.ad.b source;

    protected AppLovinAdBase(JSONObject jSONObject, JSONObject jSONObject2, com.applovin.impl.sdk.ad.b b2, com.applovin.impl.sdk.j j2) {
        if (jSONObject != null) {
            if (jSONObject2 != null) {
                if (j2 != null) {
                    this.adObject = jSONObject;
                    this.fullResponse = jSONObject2;
                    this.source = b2;
                    this.sdk = j2;
                    this.adObjectLock = new Object();
                    this.c = System.currentTimeMillis();
                    char[] arrc = jSONObject.toString().toCharArray();
                    Arrays.sort((char[])arrc);
                    this.a = new String(arrc).hashCode();
                    return;
                }
                throw new IllegalArgumentException("No sdk specified");
            }
            throw new IllegalArgumentException("No response specified");
        }
        throw new IllegalArgumentException("No ad object specified");
    }

    public boolean equals(Object object) {
        AppLovinAd appLovinAd;
        if (object instanceof h && (appLovinAd = ((h)object).b()) != null) {
            object = appLovinAd;
        }
        if (this == object) {
            return true;
        }
        if (object != null) {
            if (this.getClass() != object.getClass()) {
                return false;
            }
            AppLovinAdBase appLovinAdBase = (AppLovinAdBase)object;
            d d2 = this.b;
            if (d2 != null ? !d2.equals(appLovinAdBase.b) : appLovinAdBase.b != null) {
                return false;
            }
            if (this.source != appLovinAdBase.source) {
                return false;
            }
            return this.a == appLovinAdBase.a;
        }
        return false;
    }

    @Override
    public long getAdIdNumber() {
        return this.getLongFromAdObject("ad_id", -1L);
    }

    @Override
    public String getAdValue(String string) {
        if (TextUtils.isEmpty((CharSequence)string)) {
            return null;
        }
        JSONObject jSONObject = this.getJsonObjectFromAdObject("ad_values", null);
        if (jSONObject != null && jSONObject.length() > 0) {
            return g.a(jSONObject, string, null, this.sdk);
        }
        return null;
    }

    public d getAdZone() {
        d d2 = this.b;
        if (d2 != null) {
            return d2;
        }
        String string = g.a(this.fullResponse, "zone_id", null, this.sdk);
        this.b = d.a(this.getSize(), this.getType(), string, this.sdk);
        return this.b;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected boolean getBooleanFromAdObject(String string, Boolean bl) {
        Object object;
        if (this.sdk.a(b.fn) == false) return g.a(this.adObject, string, bl, this.sdk);
        Object object2 = object = this.adObjectLock;
        synchronized (object2) {
            return g.a(this.adObject, string, bl, this.sdk);
        }
    }

    public String getClCode() {
        String string = this.getStringFromAdObject("clcode", "");
        if (com.applovin.impl.sdk.e.j.b(string)) {
            return string;
        }
        return g.a(this.fullResponse, "clcode", "", this.sdk);
    }

    public long getCreatedAtMillis() {
        return this.c;
    }

    public h getDummyAd() {
        return this.d;
    }

    public long getFetchLatencyMillis() {
        return g.a(this.fullResponse, "ad_fetch_latency_millis", -1L, this.sdk);
    }

    public long getFetchResponseSize() {
        return g.a(this.fullResponse, "ad_fetch_response_size", -1L, this.sdk);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected float getFloatFromAdObject(String string, float f2) {
        Object object;
        if (this.sdk.a(b.fn) == false) return g.a(this.adObject, string, f2, this.sdk);
        Object object2 = object = this.adObjectLock;
        synchronized (object2) {
            return g.a(this.adObject, string, f2, this.sdk);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected int getIntFromAdObject(String string, int n2) {
        Object object;
        if (this.sdk.a(b.fn) == false) return g.a(this.adObject, string, n2, this.sdk);
        Object object2 = object = this.adObjectLock;
        synchronized (object2) {
            return g.a(this.adObject, string, n2, this.sdk);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected JSONObject getJsonObjectFromAdObject(String string, JSONObject jSONObject) {
        Object object;
        if (this.sdk.a(b.fn) == false) return g.a(this.adObject, string, jSONObject, this.sdk);
        Object object2 = object = this.adObjectLock;
        synchronized (object2) {
            return g.a(this.adObject, string, jSONObject, this.sdk);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected long getLongFromAdObject(String string, long l2) {
        Object object;
        if (this.sdk.a(b.fn) == false) return g.a(this.adObject, string, l2, this.sdk);
        Object object2 = object = this.adObjectLock;
        synchronized (object2) {
            return g.a(this.adObject, string, l2, this.sdk);
        }
    }

    public String getPrimaryKey() {
        return this.getStringFromAdObject("pk", "NA");
    }

    public String getSecondaryKey1() {
        return this.getStringFromAdObject("sk1", null);
    }

    public String getSecondaryKey2() {
        return this.getStringFromAdObject("sk2", null);
    }

    @Override
    public AppLovinAdSize getSize() {
        return AppLovinAdSize.fromString(g.a(this.fullResponse, "ad_size", null, this.sdk));
    }

    public com.applovin.impl.sdk.ad.b getSource() {
        return this.source;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected String getStringFromAdObject(String string, String string2) {
        Object object;
        if (this.sdk.a(b.fn) == false) return g.a(this.adObject, string, string2, this.sdk);
        Object object2 = object = this.adObjectLock;
        synchronized (object2) {
            return g.a(this.adObject, string, string2, this.sdk);
        }
    }

    @Override
    public AppLovinAdType getType() {
        return AppLovinAdType.fromString(g.a(this.fullResponse, "ad_type", null, this.sdk));
    }

    @Override
    public String getZoneId() {
        if (this.getAdZone().l()) {
            return null;
        }
        return g.a(this.fullResponse, "zone_id", null, this.sdk);
    }

    public boolean hasShown() {
        return this.getBooleanFromAdObject("shown", false);
    }

    public boolean hasVideoUrl() {
        this.sdk.u().d("AppLovinAdBase", "Attempting to invoke hasVideoUrl() from base ad class");
        return false;
    }

    public int hashCode() {
        return this.a;
    }

    @Override
    public boolean isVideoAd() {
        if (this.adObject.has("is_video_ad")) {
            return this.getBooleanFromAdObject("is_video_ad", false);
        }
        return this.hasVideoUrl();
    }

    public void setDummyAd(h h2) {
        this.d = h2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void setHasShown(boolean bl) {
        try {
            Object object;
            Object object2 = object = this.adObjectLock;
            // MONITORENTER : object2
        }
        catch (Throwable throwable) {
            return;
        }
        this.adObject.put("shown", bl);
        // MONITOREXIT : object2
    }

    public boolean shouldCancelHtmlCachingIfShown() {
        return this.getBooleanFromAdObject("chcis", false);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public String toString() {
        String string;
        Object object;
        Object object2 = object = this.adObjectLock;
        synchronized (object2) {
            string = g.a(this.adObject, this.sdk);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        stringBuilder.append(this.getClass().getSimpleName());
        stringBuilder.append(" #");
        stringBuilder.append(this.getAdIdNumber());
        stringBuilder.append(" source=");
        stringBuilder.append((Object)this.getSource());
        stringBuilder.append(", zoneId=");
        stringBuilder.append(this.getZoneId());
        stringBuilder.append(", adObject=");
        stringBuilder.append(string);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}


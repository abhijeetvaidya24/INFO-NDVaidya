/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.util.Iterator
 *  java.util.Set
 */
package com.amazon.device.ads;

import com.amazon.device.ads.AAXCreative;
import com.amazon.device.ads.AdProperties;
import java.util.Iterator;
import java.util.Set;

class AdData
implements Iterable<AAXCreative> {
    private int adHeight;
    private int adWidth;
    private String creative;
    private Set<AAXCreative> creativeTypes;
    private long expirationTimeMs = -1L;
    private boolean fetched;
    private String impPixelUrl;
    private String instrPixelUrl;
    private AdProperties properties;

    protected String getCreative() {
        return this.creative;
    }

    protected Set<AAXCreative> getCreativeTypes() {
        return this.creativeTypes;
    }

    public int getHeight() {
        return this.adHeight;
    }

    protected String getImpressionPixelUrl() {
        return this.impPixelUrl;
    }

    protected String getInstrumentationPixelUrl() {
        return this.instrPixelUrl;
    }

    public boolean getIsFetched() {
        return this.fetched;
    }

    protected AdProperties getProperties() {
        return this.properties;
    }

    public long getTimeToExpire() {
        long l2 = System.currentTimeMillis();
        return this.expirationTimeMs - l2;
    }

    public int getWidth() {
        return this.adWidth;
    }

    public boolean isExpired() {
        if (this.expirationTimeMs < 0L) {
            return false;
        }
        long l2 = System.currentTimeMillis() LCMP this.expirationTimeMs;
        boolean bl = false;
        if (l2 > 0) {
            bl = true;
        }
        return bl;
    }

    public Iterator<AAXCreative> iterator() {
        return this.creativeTypes.iterator();
    }

    protected void setCreative(String string) {
        this.creative = string;
    }

    protected void setCreativeTypes(Set<AAXCreative> set) {
        this.creativeTypes = set;
    }

    protected void setExpirationTimeMillis(long l2) {
        this.expirationTimeMs = l2;
    }

    public void setFetched(boolean bl) {
        this.fetched = bl;
    }

    protected void setHeight(int n) {
        this.adHeight = n;
    }

    protected void setImpressionPixelUrl(String string) {
        this.impPixelUrl = string;
    }

    protected void setInstrumentationPixelUrl(String string) {
        this.instrPixelUrl = string;
    }

    protected void setProperties(AdProperties adProperties) {
        this.properties = adProperties;
    }

    protected void setWidth(int n) {
        this.adWidth = n;
    }
}


/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.startapp.android.publish.adsCommon.StartAppAd
 *  java.io.Serializable
 *  java.lang.Enum
 *  java.lang.Object
 *  java.util.EnumSet
 *  java.util.Set
 *  java.util.concurrent.TimeUnit
 */
package com.startapp.android.publish.cache;

import com.startapp.android.publish.adsCommon.StartAppAd;
import com.startapp.android.publish.cache.FailuresHandler;
import com.startapp.common.c.f;
import java.io.Serializable;
import java.util.EnumSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class ACMConfig
implements Serializable {
    public static final int DEFAULT_CACHE_SIZE = 7;
    private static final long serialVersionUID = 1L;
    private long adCacheTTL = 3600L;
    @f(b="Ljava/util/EnumSet;", c="Lcom/startapp/android/publish/adsCommon/StartAppAd$AdMode;")
    private Set<StartAppAd.AdMode> autoLoad = EnumSet.of((Enum)StartAppAd.AdMode.FULLPAGE);
    @f(a=true)
    private FailuresHandler failuresHandler = new FailuresHandler();
    private boolean localCache = true;
    private int maxCacheSize = 7;
    private long returnAdCacheTTL = 3600L;
    private boolean returnAdShouldLoadInBg = true;

    public long getAdCacheTtl() {
        return TimeUnit.SECONDS.toMillis(this.adCacheTTL);
    }

    public Set<StartAppAd.AdMode> getAutoLoad() {
        return this.autoLoad;
    }

    public FailuresHandler getFailuresHandler() {
        return this.failuresHandler;
    }

    public int getMaxCacheSize() {
        return this.maxCacheSize;
    }

    public long getReturnAdCacheTTL() {
        return TimeUnit.SECONDS.toMillis(this.returnAdCacheTTL);
    }

    public boolean isLocalCache() {
        return this.localCache;
    }

    public void setMaxCacheSize(int n2) {
        this.maxCacheSize = n2;
    }

    public boolean shouldReturnAdLoadInBg() {
        return this.returnAdShouldLoadInBg;
    }
}


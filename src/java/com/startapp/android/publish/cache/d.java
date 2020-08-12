/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.io.Serializable
 *  java.lang.Object
 *  java.lang.String
 */
package com.startapp.android.publish.cache;

import android.content.Context;
import com.startapp.android.publish.adsCommon.AdsConstants;
import com.startapp.android.publish.adsCommon.Utils.i;
import com.startapp.android.publish.adsCommon.f.f;
import com.startapp.android.publish.cache.ACMConfig;
import com.startapp.common.a.e;
import java.io.Serializable;

public class d
implements Serializable {
    private static transient d a = new d();
    private static final long serialVersionUID = 1L;
    @com.startapp.common.c.f(a=true)
    private ACMConfig ACM = new ACMConfig();
    private String cacheMetaDataUpdateVersion = AdsConstants.h;
    private float sendCacheSizeProb = 20.0f;

    private d() {
    }

    public static d a() {
        return a;
    }

    public static void a(Context context) {
        d d2 = e.a(context, "StartappCacheMetadata", d.class);
        d d3 = new d();
        if (d2 != null) {
            boolean bl = i.a(d2, d3);
            if (!d2.d() && bl) {
                f.a(context, com.startapp.android.publish.adsCommon.f.d.k, "CacheMetaData", "", "");
            }
            a = d2;
            return;
        }
        a = d3;
    }

    public static void a(Context context, d d2) {
        d2.cacheMetaDataUpdateVersion = AdsConstants.h;
        a = d2;
        e.a(context, "StartappCacheMetadata", (Serializable)d2);
    }

    private boolean d() {
        return true ^ AdsConstants.h.equals((Object)this.cacheMetaDataUpdateVersion);
    }

    public ACMConfig b() {
        return this.ACM;
    }

    public float c() {
        return this.sendCacheSizeProb;
    }
}


/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.applovin.impl.sdk.j
 *  com.applovin.impl.sdk.p
 *  com.applovin.mediation.MaxAdListener
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 */
package com.applovin.impl.mediation.ads.a;

import com.applovin.impl.mediation.f;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.p;
import com.applovin.mediation.MaxAdListener;

public abstract class a {
    protected MaxAdListener adListener = null;
    protected final String adUnitId;
    protected final f.a loadRequestBuilder;
    protected final p logger;
    protected final j sdk;
    protected final String tag;

    protected a(String string, String string2, j j2) {
        this.adUnitId = string;
        this.sdk = j2;
        this.tag = string2;
        this.logger = j2.u();
        this.loadRequestBuilder = new f.a();
    }

    public String getAdUnitId() {
        return this.adUnitId;
    }

    public void setExtraParameter(String string, String string2) {
        if (string != null) {
            this.loadRequestBuilder.a(string, string2);
            return;
        }
        throw new IllegalArgumentException("No key specified");
    }

    public void setListener(MaxAdListener maxAdListener) {
        this.adListener = maxAdListener;
    }
}


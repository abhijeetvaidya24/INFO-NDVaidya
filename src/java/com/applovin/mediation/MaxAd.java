/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.applovin.mediation;

import com.applovin.mediation.MaxAdFormat;

public interface MaxAd {
    public String getAdUnitId();

    public MaxAdFormat getFormat();

    public boolean isReady();
}


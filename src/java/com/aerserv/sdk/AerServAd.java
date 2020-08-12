/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.aerserv.sdk;

import com.aerserv.sdk.AerServAdType;

public interface AerServAd {
    public AerServAdType getAerServAdType();

    public void kill();

    public void pause();

    public void play();

    public void show();
}


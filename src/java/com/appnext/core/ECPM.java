/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.appnext.core;

public class ECPM {
    private String banner;
    private float ecpm;
    private float ppr;

    public ECPM(float f2, float f3, String string2) {
        this.ecpm = f2;
        this.ppr = f3;
        this.banner = string2;
    }

    protected final void a(float f2) {
        this.ecpm = f2;
    }

    protected final void ad(String string2) {
        this.banner = string2;
    }

    protected final void b(float f2) {
        this.ppr = f2;
    }

    public String getBanner() {
        return this.banner;
    }

    public float getEcpm() {
        return this.ecpm;
    }

    public float getPpr() {
        return this.ppr;
    }
}


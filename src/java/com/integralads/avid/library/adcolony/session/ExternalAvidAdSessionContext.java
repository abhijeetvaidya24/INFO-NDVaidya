/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.integralads.avid.library.adcolony.session;

public class ExternalAvidAdSessionContext {
    private String a;
    private boolean b;

    public ExternalAvidAdSessionContext(String string, boolean bl2) {
        this.a = string;
        this.b = bl2;
    }

    public String getPartnerVersion() {
        return this.a;
    }

    public boolean isDeferred() {
        return this.b;
    }
}


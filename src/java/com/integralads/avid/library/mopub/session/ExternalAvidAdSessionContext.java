/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.integralads.avid.library.mopub.session;

public class ExternalAvidAdSessionContext {
    private boolean isDeferred;
    private String partnerVersion;

    public ExternalAvidAdSessionContext(String string) {
        this(string, false);
    }

    public ExternalAvidAdSessionContext(String string, boolean bl2) {
        this.partnerVersion = string;
        this.isDeferred = bl2;
    }

    public String getPartnerVersion() {
        return this.partnerVersion;
    }

    public boolean isDeferred() {
        return this.isDeferred;
    }
}


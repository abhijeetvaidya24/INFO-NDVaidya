/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Object
 *  java.lang.String
 */
package com.startapp.android.publish.adsCommon.a;

import java.io.Serializable;

public class f
implements Serializable {
    private static final long serialVersionUID = 1L;
    private String reason;
    private boolean shouldDisplayAd;

    public f(boolean bl) {
        this(bl, "");
    }

    public f(boolean bl, String string) {
        this.shouldDisplayAd = bl;
        this.reason = string;
    }

    public boolean a() {
        return this.shouldDisplayAd;
    }

    public String b() {
        return this.reason;
    }

    public String c() {
        String string = this.reason;
        if (string != null) {
            return string.split(" ")[0];
        }
        return "";
    }
}


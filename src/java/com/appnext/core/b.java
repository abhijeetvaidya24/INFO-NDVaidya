/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 */
package com.appnext.core;

import com.appnext.core.Ad;

public final class b {
    private String cat = "";
    private int cnt;
    private String fP = "";
    private int fQ;
    private int fR;
    private String pbk = "";

    public b(Ad ad) {
        this.fP = ad.getPlacementID();
        this.cat = ad.getCategories();
        this.pbk = ad.getPostback();
        this.fQ = ad.getMinVideoLength();
        this.fR = ad.getMaxVideoLength();
        this.cnt = ad.getCount();
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (!this.getClass().isInstance(object) && !object.getClass().isInstance((Object)this)) {
            return false;
        }
        if (object instanceof b) {
            b b2 = (b)object;
            return b2.fP.equals((Object)this.fP) && b2.cat.equals((Object)this.cat) && b2.pbk.equals((Object)this.pbk) && b2.fQ == this.fQ && b2.fR == this.fR && b2.cnt == this.cnt;
        }
        return super.equals(object);
    }

    public final int hashCode() {
        return 31 * (31 * (31 * (31 * (31 * this.fP.hashCode() + this.cat.hashCode()) + this.pbk.hashCode()) + this.fQ) + this.fR) + this.cnt;
    }
}


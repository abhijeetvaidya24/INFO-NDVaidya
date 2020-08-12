/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Comparable
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 */
package com.aerserv.sdk.model.vast;

import com.aerserv.sdk.model.vast.SequenceEnabled;
import java.io.Serializable;

public abstract class Ad
implements SequenceEnabled,
Serializable,
Comparable<Ad> {
    public static final String ELEMENT_NAME = "Ad";
    private static final long serialVersionUID = -7017030056751844442L;
    protected String id;
    protected Integer sequencePosition;

    public int compareTo(Ad ad) {
        if (this.sequencePosition == null && ad.sequencePosition == null) {
            return 0;
        }
        Integer n2 = this.sequencePosition;
        if (n2 == null) {
            return 1;
        }
        Integer n3 = ad.sequencePosition;
        if (n3 == null) {
            return -1;
        }
        return n2.compareTo(n3);
    }

    public String getId() {
        return this.id;
    }

    @Override
    public Integer getSequencePosition() {
        return this.sequencePosition;
    }
}


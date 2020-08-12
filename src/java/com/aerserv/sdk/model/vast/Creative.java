/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.aerserv.sdk.model.vast.CompanionAdsCreative
 *  com.aerserv.sdk.model.vast.LinearCreative
 *  java.io.Serializable
 *  java.lang.Comparable
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 */
package com.aerserv.sdk.model.vast;

import com.aerserv.sdk.model.vast.CompanionAdsCreative;
import com.aerserv.sdk.model.vast.LinearCreative;
import com.aerserv.sdk.model.vast.SequenceEnabled;
import java.io.Serializable;

public abstract class Creative
implements SequenceEnabled,
Serializable,
Comparable<Creative> {
    public static final String ELEMENT_NAME = "Creative";
    private static final long serialVersionUID = -8609947788072885225L;
    protected String adId;
    protected String creativeId;
    protected Integer sequencePosition;

    public int compareTo(Creative creative) {
        if (this instanceof CompanionAdsCreative && creative instanceof LinearCreative) {
            return 1;
        }
        if (this instanceof LinearCreative && creative instanceof CompanionAdsCreative) {
            return -1;
        }
        if (this.sequencePosition == null && creative.sequencePosition == null) {
            return -1;
        }
        Integer n2 = this.sequencePosition;
        if (n2 == null) {
            return 1;
        }
        Integer n3 = creative.sequencePosition;
        if (n3 == null) {
            return -1;
        }
        return n2.compareTo(n3);
    }

    public String getAdId() {
        return this.adId;
    }

    public String getCreativeId() {
        return this.creativeId;
    }

    @Override
    public Integer getSequencePosition() {
        return this.sequencePosition;
    }
}


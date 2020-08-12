/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.startapp.android.publish.ads.video.tracking;

import com.startapp.android.publish.ads.video.tracking.VideoTrackingLink;
import com.startapp.common.c.e;
import java.io.Serializable;

@e(c=true)
public class FractionTrackingLink
extends VideoTrackingLink
implements Serializable {
    private static final long serialVersionUID = 1L;
    private int fraction;

    public int getFraction() {
        return this.fraction;
    }

    public void setFraction(int n2) {
        this.fraction = n2;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        stringBuilder.append(", fraction=");
        stringBuilder.append(this.fraction);
        return stringBuilder.toString();
    }
}


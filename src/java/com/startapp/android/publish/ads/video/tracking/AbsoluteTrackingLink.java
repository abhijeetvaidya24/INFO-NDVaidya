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
public class AbsoluteTrackingLink
extends VideoTrackingLink
implements Serializable {
    private static final long serialVersionUID = 1L;
    private int videoOffsetMillis;

    public int getVideoOffsetMillis() {
        return this.videoOffsetMillis;
    }

    public void setVideoOffsetMillis(int n2) {
        this.videoOffsetMillis = n2;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        stringBuilder.append(", videoOffsetMillis=");
        stringBuilder.append(this.videoOffsetMillis);
        return stringBuilder.toString();
    }
}


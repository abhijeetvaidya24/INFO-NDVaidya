/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Boolean
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 */
package com.appnext.ads.fullscreen;

import com.appnext.ads.fullscreen.c;
import com.appnext.core.Configuration;
import com.appnext.core.p;
import java.io.Serializable;

public class VideoConfig
extends Configuration
implements Serializable {
    private static final long serialVersionUID = 1L;
    public int rollCaptionTime = -2;
    public Boolean showCta;
    public String videoLength = "15";

    public int getRollCaptionTime() {
        return this.rollCaptionTime;
    }

    public String getVideoLength() {
        return this.videoLength;
    }

    public boolean isShowCta() {
        Boolean bl = this.showCta;
        if (bl == null) {
            return true;
        }
        return bl;
    }

    @Override
    protected p l() {
        return c.m();
    }

    public void setRollCaptionTime(int n2) {
        this.rollCaptionTime = n2;
    }

    public void setShowCta(boolean bl) {
        this.showCta = bl;
    }

    public void setVideoLength(String string2) {
        if (!string2.equals((Object)"15") && !string2.equals((Object)"30")) {
            throw new IllegalArgumentException("Wrong video length");
        }
        this.videoLength = string2;
    }

    protected final boolean t() {
        return this.mute != null;
    }

    protected final boolean u() {
        return this.showCta != null;
    }
}


/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Color
 *  java.io.Serializable
 *  java.lang.Boolean
 *  java.lang.Deprecated
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 */
package com.appnext.ads.interstitial;

import android.graphics.Color;
import com.appnext.ads.interstitial.c;
import com.appnext.core.Configuration;
import com.appnext.core.p;
import java.io.Serializable;

public class InterstitialConfig
extends Configuration
implements Serializable {
    private static final long serialVersionUID = 1L;
    public Boolean autoPlay;
    public String buttonColor = "";
    protected boolean cm = false;
    public String creativeType = "managed";
    public String skipText = "";

    protected final boolean H() {
        return this.autoPlay != null;
    }

    protected final boolean I() {
        return this.backButtonCanClose != null;
    }

    public String getButtonColor() {
        return this.buttonColor;
    }

    public String getCreativeType() {
        return this.creativeType;
    }

    public String getSkipText() {
        return this.skipText;
    }

    public boolean isAutoPlay() {
        Boolean bl = this.autoPlay;
        if (bl == null) {
            return Boolean.parseBoolean((String)c.K().get("auto_play"));
        }
        return bl;
    }

    @Override
    protected final p l() {
        return c.K();
    }

    public void setAutoPlay(boolean bl) {
        this.autoPlay = bl;
    }

    @Deprecated
    public void setBackButtonCanClose(boolean bl) {
        this.backButtonCanClose = bl;
    }

    public void setButtonColor(String string2) {
        if (string2 == null) {
            this.buttonColor = "";
            return;
        }
        if (!string2.startsWith("#")) {
            StringBuilder stringBuilder = new StringBuilder("#");
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
        }
        try {
            Color.parseColor((String)string2);
            this.buttonColor = string2;
            this.cm = true;
            return;
        }
        catch (Throwable throwable) {
            throw new IllegalArgumentException("Unknown color");
        }
    }

    public void setCreativeType(String string2) {
        if (!(string2.equals((Object)"managed") || string2.equals((Object)"static") || string2.equals((Object)"video"))) {
            throw new IllegalArgumentException("Wrong creative type");
        }
        this.creativeType = string2;
    }

    @Deprecated
    @Override
    public void setOrientation(String string2) {
    }

    public void setSkipText(String string2) {
        if (string2 == null) {
            string2 = "";
        }
        this.skipText = string2;
    }

    protected final boolean t() {
        return this.mute != null;
    }
}


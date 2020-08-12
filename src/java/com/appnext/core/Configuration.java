/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.appnext.core.p
 *  java.io.Serializable
 *  java.io.UnsupportedEncodingException
 *  java.lang.Boolean
 *  java.lang.Deprecated
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.net.URLDecoder
 *  java.net.URLEncoder
 */
package com.appnext.core;

import com.appnext.core.p;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public abstract class Configuration
implements Serializable {
    private static final long serialVersionUID = 1L;
    public Boolean backButtonCanClose;
    public String categories = "";
    public String language = "";
    public int maxVideoLength = 0;
    public int minVideoLength = 0;
    public Boolean mute;
    public String orientation = "not_set";
    public String postback = "";

    public String getCategories() {
        return this.categories;
    }

    public String getLanguage() {
        return this.language;
    }

    public int getMaxVideoLength() {
        return this.maxVideoLength;
    }

    public int getMinVideoLength() {
        return this.minVideoLength;
    }

    public boolean getMute() {
        Boolean bl = this.mute;
        if (bl == null) {
            return Boolean.parseBoolean((String)this.l().get("mute"));
        }
        return bl;
    }

    public String getOrientation() {
        return this.orientation;
    }

    public String getPostback() {
        return this.postback;
    }

    @Deprecated
    public boolean isBackButtonCanClose() {
        Boolean bl = this.backButtonCanClose;
        if (bl == null) {
            return Boolean.parseBoolean((String)this.l().get("can_close"));
        }
        return bl;
    }

    protected abstract p l();

    public void setCategories(String string2) {
        String string3;
        string3 = "";
        if (string2 == null) {
            string2 = string3;
        }
        try {
            if (string2.equals((Object)URLDecoder.decode((String)string2, (String)"UTF-8"))) {
                string2 = URLEncoder.encode((String)string2, (String)"UTF-8");
            }
            string3 = string2;
        }
        catch (Throwable throwable) {}
        this.categories = string3;
    }

    public void setLanguage(String string2) {
        this.language = string2;
    }

    public void setMaxVideoLength(int n2) {
        if (n2 >= 0) {
            if (n2 > 0 && this.getMinVideoLength() > 0 && n2 < this.getMinVideoLength()) {
                throw new IllegalArgumentException("Max Length cannot be lower than min length");
            }
            this.maxVideoLength = n2;
            return;
        }
        throw new IllegalArgumentException("Max Length must be higher than 0");
    }

    public void setMinVideoLength(int n2) {
        if (n2 >= 0) {
            if (n2 > 0 && this.getMaxVideoLength() > 0 && n2 > this.getMaxVideoLength()) {
                throw new IllegalArgumentException("Min Length cannot be higher than max length");
            }
            this.minVideoLength = n2;
            return;
        }
        throw new IllegalArgumentException("Min Length must be higher than 0");
    }

    public void setMute(boolean bl) {
        this.mute = bl;
    }

    public void setOrientation(String string2) {
        if (string2 != null) {
            if (!(string2.equals((Object)"automatic") || string2.equals((Object)"not_set") || string2.equals((Object)"landscape") || string2.equals((Object)"portrait"))) {
                throw new IllegalArgumentException("Wrong orientation type");
            }
            this.orientation = string2;
            return;
        }
        throw new IllegalArgumentException("orientation type");
    }

    public void setPostback(String string2) {
        String string3;
        string3 = "";
        if (string2 == null) {
            string2 = string3;
        }
        try {
            if (string2.equals((Object)URLDecoder.decode((String)string2, (String)"UTF-8"))) {
                string2 = URLEncoder.encode((String)string2, (String)"UTF-8");
            }
            string3 = string2;
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {}
        this.postback = string3;
    }
}


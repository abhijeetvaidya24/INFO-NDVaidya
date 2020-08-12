/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.aerserv.sdk.model.vast.Ad
 *  com.aerserv.sdk.model.vast.Creative
 *  com.aerserv.sdk.model.vast.InLine
 *  com.aerserv.sdk.model.vast.LinearCreative
 *  java.io.Serializable
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 */
package com.aerserv.sdk.model.vast;

import com.aerserv.sdk.model.vast.Ad;
import com.aerserv.sdk.model.vast.Creative;
import com.aerserv.sdk.model.vast.InLine;
import com.aerserv.sdk.model.vast.LinearCreative;
import com.aerserv.sdk.model.vast.MediaFile;
import java.io.Serializable;

public final class Vpaid
implements Serializable {
    private InLine ad;
    private LinearCreative creative;
    private MediaFile mediaFile;

    public Vpaid(Ad ad, Creative creative, MediaFile mediaFile) {
        if (ad instanceof InLine && creative instanceof LinearCreative && mediaFile != null && mediaFile.getMediaUri() != null && !mediaFile.getMediaUri().equals((Object)"")) {
            this.ad = (InLine)ad;
            this.creative = (LinearCreative)creative;
            this.mediaFile = mediaFile;
            return;
        }
        throw new IllegalArgumentException("could not create vpaid.  creative or mediaFile was invalid");
    }

    public InLine getAd() {
        return this.ad;
    }

    public LinearCreative getCreative() {
        return this.creative;
    }

    public MediaFile getMediaFile() {
        return this.mediaFile;
    }
}


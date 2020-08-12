/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.aerserv.sdk.model.vast.Ad
 *  com.aerserv.sdk.model.vast.InLine
 *  com.aerserv.sdk.model.vast.PlayableVastCreative
 *  java.lang.Comparable
 *  java.lang.Object
 *  java.util.Collections
 *  java.util.LinkedList
 */
package com.aerserv.sdk.view.vastplayer;

import com.aerserv.sdk.model.vast.Ad;
import com.aerserv.sdk.model.vast.Creatives;
import com.aerserv.sdk.model.vast.InLine;
import com.aerserv.sdk.model.vast.PlayableVastCreative;
import com.aerserv.sdk.utils.VASTUtils;
import java.util.Collections;
import java.util.LinkedList;

public class PlayableAd
implements Comparable<PlayableAd> {
    private InLine inlineAd;
    private LinkedList<PlayableVastCreative> playableVastCreatives = new LinkedList();

    public PlayableAd(InLine inLine) {
        this.inlineAd = inLine;
        this.buildLinearCreativesToShow();
    }

    private void buildLinearCreativesToShow() {
        this.playableVastCreatives = VASTUtils.normalizeSequenceEnabled(this.inlineAd.getCreatives(), PlayableVastCreative.class);
        Collections.sort(this.playableVastCreatives);
    }

    public int compareTo(PlayableAd playableAd) {
        return this.inlineAd.compareTo((Ad)playableAd.getInlineAd());
    }

    public InLine getInlineAd() {
        return this.inlineAd;
    }

    public LinkedList<PlayableVastCreative> getPlayableVastCreatives() {
        return this.playableVastCreatives;
    }
}


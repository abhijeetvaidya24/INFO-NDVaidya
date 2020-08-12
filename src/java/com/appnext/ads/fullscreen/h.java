/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.appnext.core.AppnextAd
 *  com.appnext.core.p
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 */
package com.appnext.ads.fullscreen;

import com.appnext.core.AppnextAd;
import com.appnext.core.p;
import java.util.ArrayList;

public interface h {
    public void closeClicked();

    public p getConfigManager();

    public String getCtaText();

    public String getLanguage();

    public ArrayList<AppnextAd> getPostRollAds();

    public int getTemplate(String var1);

    public void installClicked(AppnextAd var1);

    public boolean isRewarded();

    public void privacyClicked();

    public void report(String var1, String var2);
}


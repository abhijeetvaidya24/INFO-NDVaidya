/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  com.appnext.core.AppnextAd
 *  com.appnext.core.p
 *  java.lang.Object
 *  java.lang.String
 */
package com.appnext.ads.fullscreen;

import android.net.Uri;
import com.appnext.core.AppnextAd;
import com.appnext.core.p;

public interface j {
    public void closeClicked();

    public long closeDelay();

    public int getCaptionTextTime();

    public p getConfigManager();

    public String getCtaText();

    public String getLanguage();

    public boolean getMute();

    public AppnextAd getSelectedAd();

    public Uri getSelectedVideoUri();

    public int getTemplate(String var1);

    public void installClicked(AppnextAd var1);

    public boolean isInstalled();

    public boolean isRewarded();

    public void privacyClicked();

    public void report(String var1, String var2);

    public boolean showClose();

    public void videoEnded();

    public void videoStarted();
}


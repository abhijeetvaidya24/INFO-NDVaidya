/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Deprecated
 *  java.lang.Object
 *  java.lang.String
 */
package com.adcolony.sdk;

import com.adcolony.sdk.AdColonyInterstitial;
import com.adcolony.sdk.AdColonyZone;

public abstract class AdColonyInterstitialListener {
    @Deprecated
    public void onAudioStarted(AdColonyInterstitial adColonyInterstitial) {
    }

    @Deprecated
    public void onAudioStopped(AdColonyInterstitial adColonyInterstitial) {
    }

    public void onClicked(AdColonyInterstitial adColonyInterstitial) {
    }

    public void onClosed(AdColonyInterstitial adColonyInterstitial) {
    }

    public void onExpiring(AdColonyInterstitial adColonyInterstitial) {
    }

    public void onIAPEvent(AdColonyInterstitial adColonyInterstitial, String string, int n2) {
    }

    public void onLeftApplication(AdColonyInterstitial adColonyInterstitial) {
    }

    public void onOpened(AdColonyInterstitial adColonyInterstitial) {
    }

    public abstract void onRequestFilled(AdColonyInterstitial var1);

    public void onRequestNotFilled(AdColonyZone adColonyZone) {
    }
}


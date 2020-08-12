/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 */
package com.tappx.sdk.android;

import android.app.Activity;

public interface TappxPrivacyManager {
    public void checkAndShowPrivacyDisclaimer(Activity var1);

    public void checkAndShowPrivacyDisclaimer(Activity var1, Runnable var2);

    public void denyPersonalInfoConsent();

    public void grantPersonalInfoConsent();

    public void renewPrivacyConsent(Activity var1);

    public void setAutoPrivacyDisclaimerEnabled(boolean var1);

    public void setGDPRConsent(String var1);
}


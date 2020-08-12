/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 */
package com.applovin.sdk;

import android.content.Intent;
import java.util.Map;

public interface AppLovinEventService {
    public void trackCheckout(String var1, Map<String, String> var2);

    public void trackEvent(String var1);

    public void trackEvent(String var1, Map<String, String> var2);

    public void trackInAppPurchase(Intent var1, Map<String, String> var2);
}


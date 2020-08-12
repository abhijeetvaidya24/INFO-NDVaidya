/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  com.ironsource.mediationsdk.sdk.InternalOfferwallListener
 *  java.lang.Object
 *  java.lang.String
 *  org.json.JSONObject
 */
package com.ironsource.mediationsdk.sdk;

import android.app.Activity;
import com.ironsource.mediationsdk.sdk.InternalOfferwallListener;
import org.json.JSONObject;

public interface OfferwallAdapterApi {
    public void getOfferwallCredits();

    public void initOfferwall(Activity var1, String var2, String var3, JSONObject var4);

    public void setInternalOfferwallListener(InternalOfferwallListener var1);

    public void showOfferwall(String var1, JSONObject var2);
}


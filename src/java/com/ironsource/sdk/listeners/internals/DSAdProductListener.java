/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.ironsource.sdk.data.AdUnitsReady
 *  java.lang.Object
 *  java.lang.String
 *  org.json.JSONObject
 */
package com.ironsource.sdk.listeners.internals;

import com.ironsource.sdk.data.AdUnitsReady;
import com.ironsource.sdk.data.SSAEnums;
import org.json.JSONObject;

public interface DSAdProductListener {
    public void onAdProductClick(SSAEnums.ProductType var1, String var2);

    public void onAdProductClose(SSAEnums.ProductType var1, String var2);

    public void onAdProductEventNotificationReceived(SSAEnums.ProductType var1, String var2, String var3, JSONObject var4);

    public void onAdProductInitFailed(SSAEnums.ProductType var1, String var2, String var3);

    public void onAdProductInitSuccess(SSAEnums.ProductType var1, String var2, AdUnitsReady var3);

    public void onAdProductOpen(SSAEnums.ProductType var1, String var2);
}


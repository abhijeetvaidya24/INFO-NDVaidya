/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  org.json.JSONObject
 */
package com.ironsource.sdk.listeners;

import org.json.JSONObject;

public interface OnOfferWallListener {
    public void onGetOWCreditsFailed(String var1);

    public void onOWAdClosed();

    public boolean onOWAdCredited(int var1, int var2, boolean var3);

    public void onOWGeneric(String var1, String var2);

    public void onOWShowFail(String var1);

    public void onOWShowSuccess(String var1);

    public void onOfferwallEventNotificationReceived(String var1, JSONObject var2);

    public void onOfferwallInitFail(String var1);

    public void onOfferwallInitSuccess();
}


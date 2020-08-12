/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.ironsource.mediationsdk.sdk;

import com.ironsource.mediationsdk.logger.IronSourceError;

public interface OfferwallListener {
    public void onGetOfferwallCreditsFailed(IronSourceError var1);

    public boolean onOfferwallAdCredited(int var1, int var2, boolean var3);

    public void onOfferwallAvailable(boolean var1);

    public void onOfferwallClosed();

    public void onOfferwallOpened();

    public void onOfferwallShowFailed(IronSourceError var1);
}


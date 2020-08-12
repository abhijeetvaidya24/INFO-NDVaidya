/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.tapjoy;

import com.tapjoy.TJActionRequest;
import com.tapjoy.TJError;
import com.tapjoy.TJPlacement;

public interface TJPlacementListener {
    public void onContentDismiss(TJPlacement var1);

    public void onContentReady(TJPlacement var1);

    public void onContentShow(TJPlacement var1);

    public void onPurchaseRequest(TJPlacement var1, TJActionRequest var2, String var3);

    public void onRequestFailure(TJPlacement var1, TJError var2);

    public void onRequestSuccess(TJPlacement var1);

    public void onRewardRequest(TJPlacement var1, TJActionRequest var2, String var3, int var4);
}


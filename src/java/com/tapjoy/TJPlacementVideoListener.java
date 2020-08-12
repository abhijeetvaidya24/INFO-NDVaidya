/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.tapjoy;

import com.tapjoy.TJPlacement;

public interface TJPlacementVideoListener {
    public void onVideoComplete(TJPlacement var1);

    public void onVideoError(TJPlacement var1, String var2);

    public void onVideoStart(TJPlacement var1);
}


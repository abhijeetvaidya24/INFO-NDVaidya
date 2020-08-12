/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.aerserv.sdk.controller.listener;

import com.aerserv.sdk.model.Placement;

public interface FetchPlacementListener {
    public void onPlacementError(String var1);

    public void onPlacementSuccess(Placement var1);
}


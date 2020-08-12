/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.aerserv.sdk.controller.listener;

import com.aerserv.sdk.controller.listener.PlayPauseListener;
import com.aerserv.sdk.model.Placement;

public interface ExecutePlacementListener {
    public void onAdManagerCreated(String var1);

    public void onPlacementAvailable(Placement var1);

    public void onPlayPauseListenerCreated(PlayPauseListener var1);

    public void removeOnPlayPauseListener();
}


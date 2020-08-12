/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.aerserv.sdk.view.vastplayer;

import com.aerserv.sdk.controller.listener.PlayPauseListener;
import com.aerserv.sdk.model.vast.MediaFile;

public interface VastPlayerListener {
    public void onFailure(String var1);

    public void onMediaFileFound(MediaFile var1);

    public void onPlayPauseListenerCreated(PlayPauseListener var1);

    public void onPrepared();

    public void onSuccess(boolean var1);

    public void onTime(int var1, int var2);

    public void onTouch();
}


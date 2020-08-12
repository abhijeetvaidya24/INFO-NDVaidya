/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.media.MediaPlayer
 *  android.media.MediaPlayer$OnCompletionListener
 *  android.media.MediaPlayer$OnErrorListener
 *  android.media.MediaPlayer$OnPreparedListener
 *  android.net.Uri
 *  android.view.View
 *  android.view.View$OnTouchListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  java.lang.Object
 */
package com.applovin.impl.adview;

import android.media.MediaPlayer;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;

interface r {
    public int getCurrentPosition();

    public int getDuration();

    public int getHeight();

    public int getWidth();

    public boolean isPlaying();

    public void pause();

    public void seekTo(int var1);

    public void setLayoutParams(ViewGroup.LayoutParams var1);

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener var1);

    public void setOnErrorListener(MediaPlayer.OnErrorListener var1);

    public void setOnPreparedListener(MediaPlayer.OnPreparedListener var1);

    public void setOnTouchListener(View.OnTouchListener var1);

    public void setVideoSize(int var1, int var2);

    public void setVideoURI(Uri var1);

    public void start();

    public void stopPlayback();
}


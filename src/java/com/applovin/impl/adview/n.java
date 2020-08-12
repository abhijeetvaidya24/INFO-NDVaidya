/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Matrix
 *  android.graphics.SurfaceTexture
 *  android.media.MediaPlayer
 *  android.media.MediaPlayer$OnCompletionListener
 *  android.media.MediaPlayer$OnErrorListener
 *  android.media.MediaPlayer$OnPreparedListener
 *  android.net.Uri
 *  android.view.Surface
 *  android.view.TextureView
 *  android.view.TextureView$SurfaceTextureListener
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 */
package com.applovin.impl.adview;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.applovin.impl.adview.r;
import com.applovin.impl.sdk.e.m;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.p;
import com.applovin.sdk.AppLovinSdkUtils;

class n
extends FrameLayout
implements TextureView.SurfaceTextureListener,
r {
    private final p a;
    private final TextureView b;
    private final MediaPlayer c;
    private final Runnable d;
    private int e;
    private int f;
    private int g;

    n(j j2, Context context, Runnable runnable) {
        super(context);
        this.a = j2.u();
        this.c = new MediaPlayer();
        this.d = runnable;
        this.b = new TextureView(context);
        this.b.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1, 17));
        this.b.setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
        this.addView((View)this.b);
    }

    private void a() {
        AppLovinSdkUtils.runOnUiThreadDelayed(this.d, 250L);
    }

    @Override
    public int getCurrentPosition() {
        return this.c.getCurrentPosition();
    }

    @Override
    public int getDuration() {
        return this.c.getDuration();
    }

    @Override
    public boolean isPlaying() {
        return this.c.isPlaying();
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int n2, int n3) {
        Surface surface = new Surface(surfaceTexture);
        try {
            this.c.setSurface(surface);
            this.c.setAudioStreamType(3);
            this.c.prepareAsync();
            return;
        }
        catch (Throwable throwable) {
            this.a.b("TextureVideoView", "Failed to prepare media player", throwable);
            surface.release();
            this.a();
            return;
        }
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return true;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int n2, int n3) {
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override
    public void pause() {
        this.c.pause();
    }

    @Override
    public void seekTo(int n2) {
        this.c.seekTo(n2);
    }

    @Override
    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.c.setOnCompletionListener(onCompletionListener);
    }

    @Override
    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.c.setOnErrorListener(onErrorListener);
    }

    @Override
    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.c.setOnPreparedListener(onPreparedListener);
    }

    @Override
    public void setVideoSize(int n2, int n3) {
        int n4;
        int n5;
        int n6;
        int n7 = m.e(this.getContext());
        int n8 = this.e;
        if (n8 == 0) {
            n5 = this.b.getWidth();
            n6 = this.b.getHeight();
            this.e = n7;
            this.f = n5;
            this.g = n6;
        } else if (n7 == n8) {
            n5 = this.f;
            n6 = this.g;
        } else {
            n5 = this.g;
            n6 = this.f;
        }
        float f2 = (float)n3 / (float)n2;
        float f3 = n5;
        int n9 = (int)(f3 * f2);
        if (n6 >= n9) {
            n4 = n5;
        } else {
            n4 = (int)((float)n6 / f2);
            n9 = n6;
        }
        int n10 = n5 - n4;
        try {
            int n11 = n10 / 2;
            int n12 = (n6 - n9) / 2;
            Matrix matrix = new Matrix();
            this.b.getTransform(matrix);
            matrix.setScale((float)n4 / f3, (float)n9 / (float)n6);
            matrix.postTranslate((float)n11, (float)n12);
            this.b.setTransform(matrix);
            this.invalidate();
            this.requestLayout();
            return;
        }
        catch (Throwable throwable) {
            p p2 = this.a;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to set video size to width: ");
            stringBuilder.append(n2);
            stringBuilder.append(" height: ");
            stringBuilder.append(n3);
            p2.d("TextureVideoView", stringBuilder.toString());
            this.a();
            return;
        }
    }

    @Override
    public void setVideoURI(Uri uri) {
        try {
            this.c.setDataSource(uri.toString());
            return;
        }
        catch (Throwable throwable) {
            p p2 = this.a;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to set video URI: ");
            stringBuilder.append((Object)uri);
            p2.b("TextureVideoView", stringBuilder.toString(), throwable);
            this.a();
            return;
        }
    }

    @Override
    public void start() {
        this.c.start();
    }

    @Override
    public void stopPlayback() {
        this.c.stop();
    }
}


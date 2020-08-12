/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.media.MediaPlayer
 *  android.media.MediaPlayer$OnBufferingUpdateListener
 *  android.media.MediaPlayer$OnCompletionListener
 *  android.media.MediaPlayer$OnErrorListener
 *  android.media.MediaPlayer$OnPreparedListener
 *  android.widget.VideoView
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.startapp.android.publish.ads.video.b;

import android.media.MediaPlayer;
import android.widget.VideoView;
import com.startapp.android.publish.ads.video.b.b;
import com.startapp.android.publish.ads.video.b.c;
import com.startapp.android.publish.ads.video.c;
import com.startapp.common.a.g;

public class b
extends com.startapp.android.publish.ads.video.b.a
implements MediaPlayer.OnCompletionListener,
MediaPlayer.OnErrorListener,
MediaPlayer.OnPreparedListener {
    private MediaPlayer h;
    private VideoView i;

    public b(VideoView videoView) {
        g.a("NativeVideoPlayer", 4, "Ctor");
        this.i = videoView;
        this.i.setOnPreparedListener((MediaPlayer.OnPreparedListener)this);
        this.i.setOnCompletionListener((MediaPlayer.OnCompletionListener)this);
        this.i.setOnErrorListener((MediaPlayer.OnErrorListener)this);
    }

    private c.g a(int n2, int n3, int n4) {
        c.h h2 = b.a(n2) == b.b ? c.h.b : c.h.a;
        return new c.g(h2, a.a(n3).toString(), n4);
    }

    @Override
    public void a() {
        g.a("NativeVideoPlayer", 4, "start");
        this.i.start();
    }

    @Override
    public void a(int n2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("seekTo(");
        stringBuilder.append(n2);
        stringBuilder.append(")");
        g.a("NativeVideoPlayer", 4, stringBuilder.toString());
        this.i.seekTo(n2);
    }

    @Override
    public void a(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("setVideoLocation(");
        stringBuilder.append(string);
        stringBuilder.append(")");
        g.a("NativeVideoPlayer", 4, stringBuilder.toString());
        super.a(string);
        this.i.setVideoPath(this.a);
    }

    @Override
    public void a(boolean bl) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("setMute(");
        stringBuilder.append(bl);
        stringBuilder.append(")");
        g.a("NativeVideoPlayer", 4, stringBuilder.toString());
        MediaPlayer mediaPlayer = this.h;
        if (mediaPlayer != null) {
            if (bl) {
                mediaPlayer.setVolume(0.0f, 0.0f);
                return;
            }
            mediaPlayer.setVolume(1.0f, 1.0f);
        }
    }

    @Override
    public void b() {
        g.a("NativeVideoPlayer", 4, "pause");
        this.i.pause();
    }

    @Override
    public void c() {
        g.a("NativeVideoPlayer", 4, "stop");
        this.i.stopPlayback();
    }

    @Override
    public int d() {
        return this.i.getCurrentPosition();
    }

    @Override
    public int e() {
        return this.i.getDuration();
    }

    @Override
    public boolean f() {
        return this.h != null;
    }

    @Override
    public void g() {
        if (this.h != null) {
            this.h = null;
        }
        c.a().a((c.c)null);
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        g.a("NativeVideoPlayer", 4, "onCompletion");
        if (this.d != null) {
            g.a("NativeVideoPlayer", 3, "Dispatching onCompletion");
            this.d.a();
        }
    }

    public boolean onError(MediaPlayer mediaPlayer, int n2, int n3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onError(");
        stringBuilder.append(n2);
        stringBuilder.append(", ");
        stringBuilder.append(n3);
        stringBuilder.append(")");
        g.a("NativeVideoPlayer", 6, stringBuilder.toString());
        if (this.c != null) {
            g.a("NativeVideoPlayer", 3, "Dispatching onError");
            int n4 = mediaPlayer != null ? mediaPlayer.getCurrentPosition() : -1;
            return this.c.a(this.a(n2, n3, n4));
        }
        return false;
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        MediaPlayer mediaPlayer2;
        g.a("NativeVideoPlayer", 4, "onPrepared");
        this.h = mediaPlayer;
        if (this.b != null) {
            g.a("NativeVideoPlayer", 3, "Dispatching onPrepared");
            this.b.a();
        }
        if (com.startapp.android.publish.adsCommon.c.d(this.a) && (mediaPlayer2 = this.h) != null) {
            mediaPlayer2.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener(this){
                final /* synthetic */ b a;
                {
                    this.a = b2;
                }

                public void onBufferingUpdate(MediaPlayer mediaPlayer, int n2) {
                    if (this.a.f != null) {
                        g.a("NativeVideoPlayer", 4, "onBufferingUpdate");
                        this.a.f.a(n2);
                    }
                }
            });
            return;
        }
        if (!com.startapp.android.publish.adsCommon.c.d(this.a)) {
            c.a().a(this.f);
        }
    }

}


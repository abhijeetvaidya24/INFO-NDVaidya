/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.media.AudioManager
 *  android.media.MediaPlayer
 *  android.media.MediaPlayer$OnCompletionListener
 *  android.media.MediaPlayer$OnErrorListener
 *  android.media.MediaPlayer$OnPreparedListener
 *  android.net.Uri
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewParent
 *  android.widget.ImageButton
 *  android.widget.MediaController
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  android.widget.TextView
 *  android.widget.VideoView
 *  com.tapjoy.mraid.controller.Abstract$PlayerProperties
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.tapjoy.mraid.util;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;
import com.tapjoy.TapjoyLog;
import com.tapjoy.mraid.controller.Abstract;
import com.tapjoy.mraid.listener.Player;
import com.tapjoy.mraid.util.Utils;

public class MraidPlayer
extends VideoView
implements MediaPlayer.OnCompletionListener,
MediaPlayer.OnErrorListener,
MediaPlayer.OnPreparedListener {
    private static String h = "Loading. Please Wait..";
    private static String i = "MRAID Player";
    private Abstract.PlayerProperties a;
    private AudioManager b = (AudioManager)this.getContext().getSystemService("audio");
    private Player c;
    private int d;
    private String e;
    private RelativeLayout f;
    private ImageButton g;
    private boolean j;

    public MraidPlayer(Context context) {
        super(context);
    }

    private void a() {
        this.e = this.e.trim();
        this.e = Utils.convert(this.e);
        if (this.e == null && this.c != null) {
            this.b();
            this.c.onError();
            return;
        }
        this.setVideoURI(Uri.parse((String)this.e));
        TapjoyLog.d("player", Uri.parse((String)this.e).toString());
        if (this.a.showControl()) {
            MediaController mediaController = new MediaController(this.getContext());
            this.setMediaController(mediaController);
            mediaController.setAnchorView((View)this);
        }
        this.setOnCompletionListener((MediaPlayer.OnCompletionListener)this);
        this.setOnErrorListener((MediaPlayer.OnErrorListener)this);
        this.setOnPreparedListener((MediaPlayer.OnPreparedListener)this);
        if (!this.a.inline && !this.a.inline) {
            this.f = new RelativeLayout(this.getContext());
            this.f.setLayoutParams(this.getLayoutParams());
            TextView textView = new TextView(this.getContext());
            textView.setText((CharSequence)h);
            textView.setTextColor(-1);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            this.f.addView((View)textView, (ViewGroup.LayoutParams)layoutParams);
            ((ViewGroup)this.getParent()).addView((View)this.f);
        }
        if (this.a.isAutoPlay()) {
            this.start();
        }
    }

    private void b() {
        ViewGroup viewGroup = (ViewGroup)this.getParent();
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
    }

    private void c() {
        if (this.f != null) {
            ((ViewGroup)this.getParent()).removeView((View)this.f);
        }
    }

    public ImageButton getCloseImageButton() {
        return this.g;
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        if (this.a.doLoop()) {
            this.start();
            return;
        }
        if (this.a.exitOnComplete() || this.a.inline) {
            this.releasePlayer();
        }
    }

    public boolean onError(MediaPlayer mediaPlayer, int n2, int n3) {
        String string2 = i;
        StringBuilder stringBuilder = new StringBuilder("Player error : ");
        stringBuilder.append(n2);
        TapjoyLog.i(string2, stringBuilder.toString());
        this.c();
        this.b();
        Player player = this.c;
        if (player != null) {
            player.onError();
        }
        return false;
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        this.c();
        Player player = this.c;
        if (player != null) {
            player.onPrepared();
        }
    }

    public void playAudio() {
        this.a();
    }

    public void playVideo() {
        if (this.a.doMute()) {
            this.d = this.b.getStreamVolume(3);
            this.b.setStreamVolume(3, 0, 4);
        }
        this.a();
    }

    public void releasePlayer() {
        Player player;
        if (this.j) {
            return;
        }
        this.j = true;
        this.stopPlayback();
        this.b();
        Abstract.PlayerProperties playerProperties = this.a;
        if (playerProperties != null && playerProperties.doMute()) {
            this.b.setStreamVolume(3, this.d, 4);
        }
        if ((player = this.c) != null) {
            player.onComplete();
        }
    }

    public void setListener(Player player) {
        this.c = player;
    }

    public void setPlayData(Abstract.PlayerProperties playerProperties, String string2) {
        this.j = false;
        this.a = playerProperties;
        this.e = string2;
    }
}


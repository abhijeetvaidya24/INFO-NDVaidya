/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Configuration
 *  android.os.Bundle
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  java.lang.Object
 *  java.lang.String
 */
package com.amazon.device.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.amazon.device.ads.AdActivity;
import com.amazon.device.ads.AdVideoPlayer;

class VideoActionHandler
implements AdActivity.AdActivityAdapter {
    private Activity activity;
    private RelativeLayout layout;
    private AdVideoPlayer player;

    VideoActionHandler(AdVideoPlayer adVideoPlayer, Activity activity) {
        this.player = adVideoPlayer;
        this.activity = activity;
    }

    private void initPlayer(Bundle bundle) {
        this.player = new AdVideoPlayer((Context)this.activity);
        this.player.setPlayData(bundle.getString("url"));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        this.player.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
        this.player.setViewGroup((ViewGroup)this.layout);
        this.setPlayerListener(this.player);
    }

    private void setPlayerListener(AdVideoPlayer adVideoPlayer) {
        adVideoPlayer.setListener(new AdVideoPlayer.AdVideoPlayerListener(){

            @Override
            public void onComplete() {
                VideoActionHandler.this.activity.finish();
            }

            @Override
            public void onError() {
                VideoActionHandler.this.activity.finish();
            }
        });
    }

    @Override
    public boolean onBackPressed() {
        return false;
    }

    @Override
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override
    public void onCreate() {
        Bundle bundle = this.activity.getIntent().getExtras();
        this.layout = new RelativeLayout((Context)this.activity);
        this.layout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.activity.setContentView((View)this.layout);
        this.initPlayer(bundle);
        this.player.playVideo();
    }

    @Override
    public void onDestroy() {
        AdVideoPlayer adVideoPlayer = this.player;
        if (adVideoPlayer != null) {
            adVideoPlayer.releasePlayer();
            this.player = null;
        }
        this.activity.finish();
    }

    @Override
    public void onPause() {
    }

    @Override
    public void onResume() {
    }

    @Override
    public void onStop() {
        AdVideoPlayer adVideoPlayer = this.player;
        if (adVideoPlayer != null) {
            adVideoPlayer.releasePlayer();
            this.player = null;
        }
        this.activity.finish();
    }

    @Override
    public void onWindowFocusChanged() {
    }

    @Override
    public void preOnCreate() {
        this.activity.requestWindowFeature(1);
    }

    @Override
    public void setActivity(Activity activity) {
        this.activity = activity;
    }

}


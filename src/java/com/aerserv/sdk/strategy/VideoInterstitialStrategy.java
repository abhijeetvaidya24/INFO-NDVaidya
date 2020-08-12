/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.media.MediaPlayer
 *  android.media.MediaPlayer$OnCompletionListener
 *  android.net.Uri
 *  android.os.Bundle
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.MediaController
 *  android.widget.RelativeLayout
 *  android.widget.VideoView
 *  com.aerserv.sdk.view.ASWebviewInterstitialActivity
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 */
package com.aerserv.sdk.strategy;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.VideoView;
import com.aerserv.sdk.controller.listener.PlayPauseListener;
import com.aerserv.sdk.controller.listener.ProviderListener;
import com.aerserv.sdk.model.ad.HTMLProviderAd;
import com.aerserv.sdk.strategy.InterstitialStrategy;
import com.aerserv.sdk.strategy.VideoInterstitialStrategy;
import com.aerserv.sdk.utils.AerServLog;
import com.aerserv.sdk.view.ASWebviewInterstitialActivity;
import com.aerserv.sdk.view.component.CloseButton;

public final class VideoInterstitialStrategy
implements InterstitialStrategy {
    private static final String LOG_TAG = "com.aerserv.sdk.strategy.VideoInterstitialStrategy";
    private ASWebviewInterstitialActivity activity;
    private HTMLProviderAd ad;
    private CloseButton closeButton;
    private int position = 0;
    private ProviderListener providerListener;
    private RelativeLayout relativeLayout;
    private String videoUrl;
    private VideoView videoView;
    private RelativeLayout videoViewContainer;

    public VideoInterstitialStrategy(ASWebviewInterstitialActivity aSWebviewInterstitialActivity, ProviderListener providerListener, HTMLProviderAd hTMLProviderAd, Bundle bundle) {
        this.activity = aSWebviewInterstitialActivity;
        this.providerListener = providerListener;
        this.ad = hTMLProviderAd;
        this.videoUrl = bundle.getString("mraidPlayVideoUrl");
    }

    static /* synthetic */ void access$000(VideoInterstitialStrategy videoInterstitialStrategy) {
        videoInterstitialStrategy.close();
    }

    private void close() {
        this.activity.finish();
    }

    @Override
    public void buildInterstitialPlayer() {
        this.relativeLayout = new RelativeLayout((Context)this.activity);
        this.relativeLayout.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
        this.relativeLayout.setBackgroundColor(-16777216);
        this.videoViewContainer = new RelativeLayout((Context)this.activity);
        this.videoViewContainer.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
        this.videoViewContainer.setBackgroundColor(-16777216);
        this.videoViewContainer.setGravity(17);
        this.videoView = new VideoView((Context)this.activity);
        this.videoView.setVideoURI(Uri.parse((String)this.videoUrl));
        MediaController mediaController = new MediaController((Context)this.activity);
        mediaController.setVisibility(8);
        this.videoView.setMediaController(mediaController);
        this.videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener(this){
            final /* synthetic */ VideoInterstitialStrategy this$0;
            {
                this.this$0 = videoInterstitialStrategy;
            }

            public void onCompletion(MediaPlayer mediaPlayer) {
                try {
                    mediaPlayer.setDisplay(null);
                    mediaPlayer.reset();
                    VideoInterstitialStrategy.access$000(this.this$0);
                }
                catch (Exception exception) {}
            }
        });
        this.videoView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.closeButton = new CloseButton((Context)this.activity);
        this.videoViewContainer.addView((View)this.videoView);
        this.relativeLayout.addView((View)this.videoViewContainer);
        this.relativeLayout.addView((View)this.closeButton);
        this.activity.setContentView((View)this.relativeLayout);
        PlayPauseListener playPauseListener = new PlayPauseListener(){
            private int position = 0;

            @Override
            public void onPause() {
                try {
                    this.position = VideoInterstitialStrategy.this.videoView.getCurrentPosition();
                    VideoInterstitialStrategy.this.videoView.pause();
                }
                catch (Exception exception) {}
            }

            @Override
            public void onPlay() {
                try {
                    VideoInterstitialStrategy.this.videoView.seekTo(this.position);
                    VideoInterstitialStrategy.this.videoView.start();
                }
                catch (Exception exception) {}
            }
        };
        this.providerListener.onPlayPauseListenerCreated(playPauseListener);
    }

    @Override
    public void onDestroy() {
        try {
            this.videoView.stopPlayback();
            this.videoView = null;
        }
        catch (Exception exception) {}
    }

    @Override
    public void onPause() {
        try {
            this.position = this.videoView.getCurrentPosition();
            return;
        }
        catch (Exception exception) {
            AerServLog.e(LOG_TAG, "Exception caught", exception);
            return;
        }
    }

    @Override
    public void onResume() {
        try {
            if (this.position > 0) {
                this.videoView.seekTo(this.position);
                this.videoView.start();
                return;
            }
        }
        catch (Exception exception) {
            AerServLog.e(LOG_TAG, "Exception caught", exception);
        }
    }

    @Override
    public void playInterstitial() {
        this.providerListener.onProviderAttempt();
        this.providerListener.onProviderImpression();
        this.videoView.requestFocus();
        this.videoView.start();
    }

    @Override
    public void registerEvents() {
        this.closeButton.setOnClickListener(new View.OnClickListener(this){
            final /* synthetic */ VideoInterstitialStrategy this$0;
            {
                this.this$0 = videoInterstitialStrategy;
            }

            public void onClick(View view) {
                VideoInterstitialStrategy.access$000(this.this$0);
            }
        });
    }

}


/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.media.MediaPlayer
 *  android.media.MediaPlayer$OnCompletionListener
 *  android.media.MediaPlayer$OnErrorListener
 *  android.net.Uri
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.MediaController
 *  android.widget.VideoView
 *  com.amazon.device.ads.MobileAdsLogger
 *  java.lang.Object
 *  java.lang.String
 */
package com.amazon.device.ads;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;
import com.amazon.device.ads.MobileAdsLogger;
import com.amazon.device.ads.MobileAdsLoggerFactory;

class AdVideoPlayer
implements MediaPlayer.OnCompletionListener,
MediaPlayer.OnErrorListener {
    private static String LOGTAG = "AdVideoPlayer";
    private String contentUrl_;
    private Context context_;
    private ViewGroup.LayoutParams layoutParams_ = null;
    private AdVideoPlayerListener listener_;
    private final MobileAdsLogger logger = new MobileAdsLoggerFactory().createMobileAdsLogger(LOGTAG);
    private boolean released_ = false;
    private VideoView videoView_ = null;
    private ViewGroup viewGroup_ = null;

    public AdVideoPlayer(Context context) {
        this.context_ = context;
    }

    private void displayPlayerControls() {
        this.logger.d("in displayPlayerControls");
        MediaController mediaController = new MediaController(this.context_);
        this.videoView_.setMediaController(mediaController);
        mediaController.setAnchorView((View)this.videoView_);
        mediaController.requestFocus();
    }

    private void initializeVideoView() {
        VideoView videoView = new VideoView(this.context_);
        videoView.setOnCompletionListener((MediaPlayer.OnCompletionListener)this);
        videoView.setOnErrorListener((MediaPlayer.OnErrorListener)this);
        videoView.setLayoutParams(this.layoutParams_);
        this.videoView_ = videoView;
        this.viewGroup_.addView((View)this.videoView_);
    }

    private void loadPlayerContent() {
        Uri uri = Uri.parse((String)this.contentUrl_);
        this.videoView_.setVideoURI(uri);
    }

    private void removePlayerFromParent() {
        this.logger.d("in removePlayerFromParent");
        this.viewGroup_.removeView((View)this.videoView_);
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        this.releasePlayer();
        AdVideoPlayerListener adVideoPlayerListener = this.listener_;
        if (adVideoPlayerListener != null) {
            adVideoPlayerListener.onComplete();
        }
    }

    public boolean onError(MediaPlayer mediaPlayer, int n, int n2) {
        this.removePlayerFromParent();
        AdVideoPlayerListener adVideoPlayerListener = this.listener_;
        if (adVideoPlayerListener != null) {
            adVideoPlayerListener.onError();
        }
        return false;
    }

    public void playVideo() {
        this.logger.d("in playVideo");
        this.initializeVideoView();
        this.loadPlayerContent();
        this.startPlaying();
    }

    public void releasePlayer() {
        this.logger.d("in releasePlayer");
        if (this.released_) {
            return;
        }
        this.released_ = true;
        this.videoView_.stopPlayback();
        this.removePlayerFromParent();
    }

    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        this.layoutParams_ = layoutParams;
    }

    public void setListener(AdVideoPlayerListener adVideoPlayerListener) {
        this.listener_ = adVideoPlayerListener;
    }

    public void setPlayData(String string) {
        this.released_ = false;
        this.contentUrl_ = string;
    }

    public void setViewGroup(ViewGroup viewGroup) {
        this.viewGroup_ = viewGroup;
    }

    public void startPlaying() {
        this.logger.d("in startPlaying");
        this.displayPlayerControls();
        this.videoView_.start();
    }

    public static interface AdVideoPlayerListener {
        public void onComplete();

        public void onError();
    }

}


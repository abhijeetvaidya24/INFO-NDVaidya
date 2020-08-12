/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.media.MediaPlayer
 *  android.media.MediaPlayer$OnErrorListener
 *  android.media.MediaPlayer$OnPreparedListener
 *  android.media.MediaPlayer$OnVideoSizeChangedListener
 *  android.net.Uri
 *  android.os.Bundle
 *  android.view.View
 *  android.widget.MediaController
 *  android.widget.ProgressBar
 *  android.widget.VideoView
 *  java.lang.Object
 *  java.lang.String
 */
package com.appsgeyser.multiTabApp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.VideoView;
import com.appsgeyser.multiTabApp.utils.ThemeUtils;

public class VideoPlayerActivity
extends Activity {
    private VideoView mVideo = null;
    private ProgressBar progressBar;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Uri uri = this.getIntent().getData();
        ThemeUtils.setCurrentThemeWithActionBar(this);
        this.setContentView(2131493003);
        this.mVideo = (VideoView)this.findViewById(2131296670);
        this.progressBar = (ProgressBar)this.findViewById(2131296671);
        this.mVideo.setVideoURI(uri);
        this.mVideo.setOnErrorListener(new MediaPlayer.OnErrorListener(){

            public boolean onError(MediaPlayer mediaPlayer, int n2, int n3) {
                VideoPlayerActivity.this.mVideo.setOnErrorListener(null);
                Intent intent = VideoPlayerActivity.this.getIntent();
                if (intent != null) {
                    Intent intent2 = new Intent("android.intent.action.VIEW", intent.getData());
                    intent2.setFlags(268435456);
                    VideoPlayerActivity.this.getApplicationContext().startActivity(intent2);
                    VideoPlayerActivity.this.finish();
                }
                return false;
            }
        });
        MediaController mediaController = new MediaController((Context)this);
        mediaController.setAnchorView((View)this.mVideo);
        this.mVideo.setMediaController(mediaController);
        this.mVideo.start();
        this.progressBar.setVisibility(0);
        this.mVideo.setOnPreparedListener(new MediaPlayer.OnPreparedListener(){

            public void onPrepared(MediaPlayer mediaPlayer) {
                VideoPlayerActivity.this.progressBar.setVisibility(8);
                mediaPlayer.start();
                mediaPlayer.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener(){

                    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int n2, int n3) {
                        VideoPlayerActivity.this.progressBar.setVisibility(8);
                        mediaPlayer.start();
                    }
                });
            }

        });
    }

}


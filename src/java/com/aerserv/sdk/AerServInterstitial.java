/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 */
package com.aerserv.sdk;

import android.os.Looper;
import com.aerserv.sdk.AerServAd;
import com.aerserv.sdk.AerServAdType;
import com.aerserv.sdk.AerServConfig;
import com.aerserv.sdk.AerServInterstitial;
import com.aerserv.sdk.controller.listener.ExecutePlacementListener;
import com.aerserv.sdk.controller.listener.PlayPauseListener;
import com.aerserv.sdk.controller.listener.SaveShowListener;
import com.aerserv.sdk.controller.listener.ShowListener;
import com.aerserv.sdk.model.Placement;
import com.aerserv.sdk.utils.AerServLog;

public class AerServInterstitial
implements AerServAd {
    private static final AerServAdType AD_TYPE = AerServAdType.INTERSTITIAL;
    private static final String LOG_TAG = "com.aerserv.sdk.AerServInterstitial";
    private AerServConfig config;
    private ExecutePlacementListener executePlacementListener = new ExecutePlacementListener(){

        @Override
        public void onAdManagerCreated(String string) {
        }

        @Override
        public void onPlacementAvailable(Placement placement) {
            if (AerServInterstitial.this.looper != null) {
                AerServInterstitial.this.looper.quit();
            }
        }

        @Override
        public void onPlayPauseListenerCreated(PlayPauseListener playPauseListener) {
            AerServInterstitial.this.playPauseListener = playPauseListener;
        }

        @Override
        public void removeOnPlayPauseListener() {
            AerServInterstitial.this.playPauseListener = null;
        }
    };
    private boolean isPreload = false;
    private Looper looper = null;
    private PlayPauseListener playPauseListener;
    private SaveShowListener saveShowListener = new SaveShowListener(){

        @Override
        public void onSaveShow(ShowListener showListener) {
            AerServInterstitial.this.showListener = showListener;
        }
    };
    private ShowListener showListener;

    public AerServInterstitial(AerServConfig aerServConfig) {
        this.isPreload = aerServConfig.isPreload();
        try {
            String string = LOG_TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("AerServInterstitial constructed with config ");
            stringBuilder.append((Object)aerServConfig);
            AerServLog.d(string, stringBuilder.toString());
            this.config = aerServConfig;
            new Thread(new Runnable(this, aerServConfig){
                final /* synthetic */ AerServInterstitial this$0;
                final /* synthetic */ AerServConfig val$config;
                {
                    this.this$0 = aerServInterstitial;
                    this.val$config = aerServConfig;
                }

                public void run() {
                    try {
                        com.aerserv.sdk.notification.NotificationCenter.fireEvent(com.aerserv.sdk.notification.NotificationType.AD_REQUESTED_FOR_PLC, this.val$config.getPlc());
                        new com.aerserv.sdk.controller.command.ExecutePlacementCommand(this.val$config, AerServInterstitial.access$300(), AerServInterstitial.access$400(this.this$0), AerServInterstitial.access$500(this.this$0)).execute();
                        return;
                    }
                    catch (Exception exception) {
                        AerServLog.e(AerServInterstitial.access$600(), "Exception caught", exception);
                        return;
                    }
                }
            }).start();
            return;
        }
        catch (Exception exception) {
            AerServLog.e(LOG_TAG, "Exception caught in constructor", exception);
            return;
        }
    }

    static /* synthetic */ ShowListener access$000(AerServInterstitial aerServInterstitial) {
        return aerServInterstitial.showListener;
    }

    static /* synthetic */ AerServAdType access$300() {
        return AD_TYPE;
    }

    static /* synthetic */ ExecutePlacementListener access$400(AerServInterstitial aerServInterstitial) {
        return aerServInterstitial.executePlacementListener;
    }

    static /* synthetic */ SaveShowListener access$500(AerServInterstitial aerServInterstitial) {
        return aerServInterstitial.saveShowListener;
    }

    static /* synthetic */ String access$600() {
        return LOG_TAG;
    }

    static /* synthetic */ boolean access$700(AerServInterstitial aerServInterstitial) {
        return aerServInterstitial.isPreload;
    }

    @Override
    public AerServAdType getAerServAdType() {
        return AD_TYPE;
    }

    @Override
    public void kill() {
    }

    @Override
    public void pause() {
        try {
            if (this.playPauseListener != null) {
                this.playPauseListener.onPause();
                return;
            }
        }
        catch (Exception exception) {
            AerServLog.e(LOG_TAG, "Exception caught in pause()", exception);
        }
    }

    @Override
    public void play() {
        try {
            if (this.playPauseListener != null) {
                this.playPauseListener.onPlay();
                return;
            }
        }
        catch (Exception exception) {
            AerServLog.e(LOG_TAG, "Exception caught in play()", exception);
        }
    }

    @Override
    public void show() {
        if (this.config == null) {
            AerServLog.w(LOG_TAG, "You must call config before calling show");
            return;
        }
        new Thread(new Runnable(this){
            final /* synthetic */ AerServInterstitial this$0;
            {
                this.this$0 = aerServInterstitial;
            }

            /*
             * Exception decompiling
             */
            public void run(}
        java.lang.IllegalStateException: Parameters not created
        
        
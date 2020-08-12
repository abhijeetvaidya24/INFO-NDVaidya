/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  com.google.android.gms.ads.mediation.MediationAdRequest
 *  com.google.android.gms.ads.reward.RewardItem
 *  com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter
 *  com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
 *  java.lang.Object
 *  java.lang.String
 */
package com.startapp.android.mediation.admob;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener;
import com.startapp.android.mediation.admob.StartAppRewardedVideo;
import com.startapp.android.publish.adsCommon.StartAppAd;
import com.startapp.android.publish.adsCommon.VideoListener;
import com.startapp.android.publish.adsCommon.adListeners.AdDisplayListener;
import com.startapp.android.publish.adsCommon.adListeners.AdEventListener;

public class StartAppRewardedVideo
implements MediationRewardedVideoAdAdapter {
    private static final String TAG = "StartAppRewardedVideo";
    private static MediationRewardedVideoAdListener listener;
    private StartAppAd ad;
    private boolean mInitialized;

    static /* synthetic */ MediationRewardedVideoAdListener access$000() {
        return listener;
    }

    public void initialize(Context context, MediationAdRequest mediationAdRequest, String string, MediationRewardedVideoAdListener mediationRewardedVideoAdListener, Bundle bundle, Bundle bundle2) {
        listener = mediationRewardedVideoAdListener;
        if (!this.mInitialized) {
            this.ad = new StartAppAd(context);
            this.ad.setVideoListener(new VideoListener(this){
                final /* synthetic */ StartAppRewardedVideo this$0;
                {
                    this.this$0 = startAppRewardedVideo;
                }

                public void onVideoCompleted() {
                    StartAppRewardedVideo.access$000().onVideoCompleted((MediationRewardedVideoAdAdapter)this.this$0);
                    MediationRewardedVideoAdListener mediationRewardedVideoAdListener = StartAppRewardedVideo.access$000();
                    StartAppRewardedVideo startAppRewardedVideo = this.this$0;
                    mediationRewardedVideoAdListener.onRewarded((MediationRewardedVideoAdAdapter)startAppRewardedVideo, new RewardItem("startapp", 1){
                        private final int mAmount;
                        private final String mType;
                        {
                            this.mType = string;
                            this.mAmount = n2;
                        }

                        public int getAmount() {
                            return this.mAmount;
                        }

                        public String getType() {
                            return this.mType;
                        }
                    });
                }
            });
            this.mInitialized = true;
        }
        listener.onInitializationSucceeded((MediationRewardedVideoAdAdapter)this);
    }

    public boolean isInitialized() {
        return this.mInitialized;
    }

    public void loadAd(MediationAdRequest mediationAdRequest, Bundle bundle, Bundle bundle2) {
        this.ad.loadAd(StartAppAd.AdMode.REWARDED_VIDEO, new AdEventListener(this){
            final /* synthetic */ StartAppRewardedVideo this$0;
            {
                this.this$0 = startAppRewardedVideo;
            }

            public void onFailedToReceiveAd(com.startapp.android.publish.adsCommon.Ad ad2) {
                StartAppRewardedVideo.access$000().onAdFailedToLoad((MediationRewardedVideoAdAdapter)this.this$0, 0);
            }

            public void onReceiveAd(com.startapp.android.publish.adsCommon.Ad ad2) {
                StartAppRewardedVideo.access$000().onAdLoaded((MediationRewardedVideoAdAdapter)this.this$0);
            }
        });
    }

    public void onDestroy() {
        this.mInitialized = false;
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public void showVideo() {
        this.ad.showAd(new AdDisplayListener(this){
            final /* synthetic */ StartAppRewardedVideo this$0;
            {
                this.this$0 = startAppRewardedVideo;
            }

            public void adClicked(com.startapp.android.publish.adsCommon.Ad ad2) {
                StartAppRewardedVideo.access$000().onAdClicked((MediationRewardedVideoAdAdapter)this.this$0);
            }

            public void adDisplayed(com.startapp.android.publish.adsCommon.Ad ad2) {
                StartAppRewardedVideo.access$000().onAdOpened((MediationRewardedVideoAdAdapter)this.this$0);
                StartAppRewardedVideo.access$000().onVideoStarted((MediationRewardedVideoAdAdapter)this.this$0);
            }

            public void adHidden(com.startapp.android.publish.adsCommon.Ad ad2) {
                StartAppRewardedVideo.access$000().onAdClosed((MediationRewardedVideoAdAdapter)this.this$0);
            }

            public void adNotDisplayed(com.startapp.android.publish.adsCommon.Ad ad2) {
            }
        });
    }

}


/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.RelativeLayout
 *  com.aerserv.sdk.view.ASWebviewInterstitialActivity
 *  java.lang.Exception
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Properties
 */
package com.aerserv.sdk.strategy;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.aerserv.sdk.AerServTransactionInformation;
import com.aerserv.sdk.AerServVirtualCurrency;
import com.aerserv.sdk.controller.listener.PlayPauseListener;
import com.aerserv.sdk.controller.listener.ProviderListener;
import com.aerserv.sdk.model.ad.HTMLProviderAd;
import com.aerserv.sdk.strategy.HtmlInterstitialStrategy;
import com.aerserv.sdk.strategy.InterstitialStrategy;
import com.aerserv.sdk.utils.MoatUtils;
import com.aerserv.sdk.view.ASWebviewInterstitialActivity;
import com.aerserv.sdk.view.component.ASWebView;
import com.aerserv.sdk.view.component.CloseButton;
import java.util.Properties;

public final class HtmlInterstitialStrategy
implements InterstitialStrategy {
    private static final String LOG_TAG = "com.aerserv.sdk.strategy.HtmlInterstitialStrategy";
    private ASWebviewInterstitialActivity activity;
    private HTMLProviderAd ad;
    private CloseButton closeButton;
    private String controllerId;
    private ProviderListener providerListener;
    private RelativeLayout relativeLayout;
    private Long showAdTimeout;
    private ASWebView webView;
    private RelativeLayout webViewContainer;

    public HtmlInterstitialStrategy(ASWebviewInterstitialActivity aSWebviewInterstitialActivity, ProviderListener providerListener, HTMLProviderAd hTMLProviderAd, Bundle bundle) {
        this.activity = aSWebviewInterstitialActivity;
        this.providerListener = providerListener;
        this.ad = hTMLProviderAd;
        this.controllerId = bundle.getString("controllerId");
        if (bundle.containsKey("showAdTimeout")) {
            this.showAdTimeout = bundle.getLong("showAdTimeout", 8000L);
        }
    }

    static /* synthetic */ String access$200(HtmlInterstitialStrategy htmlInterstitialStrategy) {
        return htmlInterstitialStrategy.controllerId;
    }

    static /* synthetic */ String access$300() {
        return LOG_TAG;
    }

    @Override
    public void buildInterstitialPlayer() {
        this.relativeLayout = new RelativeLayout((Context)this.activity);
        this.relativeLayout.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
        this.relativeLayout.setBackgroundColor(-16777216);
        this.webViewContainer = new RelativeLayout((Context)this.activity);
        this.webViewContainer.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
        this.webViewContainer.setBackgroundColor(-16777216);
        this.webViewContainer.setGravity(17);
        this.webView = new ASWebView((Context)this.activity, this.controllerId, this.showAdTimeout, this.ad.getVirtualCurrency().getAerServTransactionInformation());
        this.webView.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
        this.webView.registerProviderListener(new ProviderListener(){

            @Override
            public void onExpand(Properties properties, String string) {
                HtmlInterstitialStrategy.this.providerListener.onExpand(properties, string);
            }

            @Override
            public void onPlayPauseListenerCreated(PlayPauseListener playPauseListener) {
                HtmlInterstitialStrategy.this.providerListener.onPlayPauseListenerCreated(playPauseListener);
            }

            @Override
            public void onProviderAdReturned() {
                HtmlInterstitialStrategy.this.providerListener.onProviderAdReturned();
            }

            @Override
            public void onProviderAttempt() {
                HtmlInterstitialStrategy.this.providerListener.onProviderAttempt();
            }

            @Override
            public void onProviderConnectionError() {
                HtmlInterstitialStrategy.this.providerListener.onProviderConnectionError();
            }

            @Override
            public void onProviderFailShow() {
                HtmlInterstitialStrategy.this.providerListener.onProviderFailShow();
                HtmlInterstitialStrategy.this.activity.finish();
            }

            @Override
            public void onProviderFailure() {
                HtmlInterstitialStrategy.this.providerListener.onProviderFailure();
            }

            @Override
            public void onProviderFinished() {
                HtmlInterstitialStrategy.this.providerListener.onProviderFinished();
            }

            @Override
            public void onProviderImpression() {
                HtmlInterstitialStrategy.this.providerListener.onProviderImpression();
            }

            @Override
            public void onProviderNoAd() {
                HtmlInterstitialStrategy.this.providerListener.onProviderNoAd();
            }

            @Override
            public void removeOnPlayPauseListener() {
                HtmlInterstitialStrategy.this.providerListener.removeOnPlayPauseListener();
            }
        });
        this.closeButton = new CloseButton((Context)this.activity);
        this.webViewContainer.addView((View)this.webView);
        this.relativeLayout.addView((View)this.webViewContainer);
        this.relativeLayout.addView((View)this.closeButton);
        this.activity.setContentView((View)this.relativeLayout);
    }

    @Override
    public void onDestroy() {
        try {
            this.webView.cleanup();
            this.webViewContainer.removeView((View)this.webView);
            this.webView.removeAllViews();
            this.webView.destroy();
            this.webView = null;
            this.providerListener.removeOnPlayPauseListener();
        }
        catch (Exception exception) {}
        MoatUtils.cleanup(this.controllerId);
    }

    @Override
    public void onPause() {
        this.webView.pause();
    }

    @Override
    public void onResume() {
        this.webView.resume();
    }

    @Override
    public void playInterstitial() {
        this.providerListener.onProviderAttempt();
        this.webView.loadData(this.ad.getHTML());
    }

    @Override
    public void registerEvents() {
        this.closeButton.setOnClickListener(new View.OnClickListener(this){
            final /* synthetic */ HtmlInterstitialStrategy this$0;
            {
                this.this$0 = htmlInterstitialStrategy;
            }

            public void onClick(View view) {
                try {
                    com.aerserv.sdk.controller.listener.AerServEventListenerLocator.fireEvent(HtmlInterstitialStrategy.access$200(this.this$0), com.aerserv.sdk.AerServEvent.AD_DISMISSED);
                    HtmlInterstitialStrategy.access$000(this.this$0).onProviderFinished();
                }
                catch (Exception exception) {
                    com.aerserv.sdk.utils.AerServLog.e(HtmlInterstitialStrategy.access$300(), "Exception caught", exception);
                }
                HtmlInterstitialStrategy.access$100(this.this$0).finish();
            }
        });
    }

}


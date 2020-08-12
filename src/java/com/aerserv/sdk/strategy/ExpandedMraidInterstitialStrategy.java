/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewParent
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.RelativeLayout
 *  com.aerserv.sdk.model.ad.MraidProviderAd
 *  com.aerserv.sdk.view.ASWebviewInterstitialActivity
 *  com.aerserv.sdk.view.component.ASMraidWebView
 *  java.lang.Exception
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.util.Properties
 */
package com.aerserv.sdk.strategy;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.aerserv.sdk.AerServTransactionInformation;
import com.aerserv.sdk.AerServVirtualCurrency;
import com.aerserv.sdk.adapter.asaerserv.mraid.MraidState;
import com.aerserv.sdk.controller.listener.MraidBannerJavascriptInterfaceListener;
import com.aerserv.sdk.controller.listener.MraidJavascriptInterfaceListener;
import com.aerserv.sdk.controller.listener.OnCloseListener;
import com.aerserv.sdk.controller.listener.OnSetOrientationPropertiesListener;
import com.aerserv.sdk.controller.listener.ProviderListener;
import com.aerserv.sdk.controller.listener.SetVisibilityListener;
import com.aerserv.sdk.model.ad.MraidProviderAd;
import com.aerserv.sdk.strategy.ExpandedMraidInterstitialStrategy;
import com.aerserv.sdk.strategy.InterstitialStrategy;
import com.aerserv.sdk.utils.AerServLog;
import com.aerserv.sdk.view.ASWebviewInterstitialActivity;
import com.aerserv.sdk.view.View;
import com.aerserv.sdk.view.ViewLocator;
import com.aerserv.sdk.view.component.ASMraidWebView;
import com.aerserv.sdk.view.component.CloseButton;
import java.util.Properties;

public final class ExpandedMraidInterstitialStrategy
implements InterstitialStrategy {
    private static final String LOG_TAG = "com.aerserv.sdk.strategy.ExpandedMraidInterstitialStrategy";
    private ASWebviewInterstitialActivity activity;
    private MraidProviderAd ad;
    private ASMraidWebView bannerWebView;
    private CloseButton closeButton;
    private String controllerId;
    private String expandUrl;
    private boolean firstOnResume = true;
    private ViewGroup mraidBannerContainer;
    private ProviderListener providerListener;
    private RelativeLayout relativeLayout;
    private Long showAdTimeout;
    private boolean useCustomClose;
    private boolean useNewWebView = true;
    private ASMraidWebView webView;
    private RelativeLayout webViewContainer;

    public ExpandedMraidInterstitialStrategy(ASWebviewInterstitialActivity aSWebviewInterstitialActivity, ProviderListener providerListener, MraidProviderAd mraidProviderAd, Bundle bundle) {
        this.activity = aSWebviewInterstitialActivity;
        this.providerListener = providerListener;
        this.ad = mraidProviderAd;
        this.controllerId = bundle.getString("controllerId");
        this.showAdTimeout = bundle.getLong("showAdTimeout");
        String string = bundle.getString("mraidBannerViewId");
        this.useCustomClose = bundle.getBoolean("mraidExpandCustomClose", false);
        this.expandUrl = bundle.getString("mraidExpandUrl");
        this.bannerWebView = (ASMraidWebView)ViewLocator.getInstance().locateView(string);
        if (this.expandUrl == null) {
            this.useNewWebView = false;
            this.webView = this.bannerWebView;
            this.mraidBannerContainer = (ViewGroup)this.webView.getParent();
            this.mraidBannerContainer.removeView((android.view.View)this.webView);
        }
    }

    static /* synthetic */ ASWebviewInterstitialActivity access$300(ExpandedMraidInterstitialStrategy expandedMraidInterstitialStrategy) {
        return expandedMraidInterstitialStrategy.activity;
    }

    static /* synthetic */ String access$400() {
        return LOG_TAG;
    }

    static /* synthetic */ boolean access$500(ExpandedMraidInterstitialStrategy expandedMraidInterstitialStrategy) {
        return expandedMraidInterstitialStrategy.useNewWebView;
    }

    static /* synthetic */ ASMraidWebView access$600(ExpandedMraidInterstitialStrategy expandedMraidInterstitialStrategy) {
        return expandedMraidInterstitialStrategy.webView;
    }

    static /* synthetic */ ASMraidWebView access$602(ExpandedMraidInterstitialStrategy expandedMraidInterstitialStrategy, ASMraidWebView aSMraidWebView) {
        expandedMraidInterstitialStrategy.webView = aSMraidWebView;
        return aSMraidWebView;
    }

    static /* synthetic */ ViewGroup access$700(ExpandedMraidInterstitialStrategy expandedMraidInterstitialStrategy) {
        return expandedMraidInterstitialStrategy.mraidBannerContainer;
    }

    static /* synthetic */ ASMraidWebView access$800(ExpandedMraidInterstitialStrategy expandedMraidInterstitialStrategy) {
        return expandedMraidInterstitialStrategy.bannerWebView;
    }

    private void close() {
        this.activity.runOnUiThread(new Runnable(this){
            final /* synthetic */ ExpandedMraidInterstitialStrategy this$0;
            {
                this.this$0 = expandedMraidInterstitialStrategy;
            }

            public void run() {
                try {
                    if (ExpandedMraidInterstitialStrategy.access$500(this.this$0)) {
                        ExpandedMraidInterstitialStrategy.access$600(this.this$0).updateMraidState(MraidState.HIDDEN);
                        ExpandedMraidInterstitialStrategy.access$600(this.this$0).loadData("", "text/html", "UTF-8");
                        ExpandedMraidInterstitialStrategy.access$600(this.this$0).destroy();
                        ExpandedMraidInterstitialStrategy.access$602(this.this$0, null);
                    } else {
                        ExpandedMraidInterstitialStrategy.access$600(this.this$0).setOnSetOrientationPropertiesListener(null);
                        ((MraidBannerJavascriptInterfaceListener)ExpandedMraidInterstitialStrategy.access$600(this.this$0).getMraidJavascriptInterfaceListener()).revertOnCloseListener();
                        ((ViewGroup)ExpandedMraidInterstitialStrategy.access$600(this.this$0).getParent()).removeView((android.view.View)ExpandedMraidInterstitialStrategy.access$600(this.this$0));
                        ExpandedMraidInterstitialStrategy.access$700(this.this$0).addView((android.view.View)ExpandedMraidInterstitialStrategy.access$600(this.this$0), 0);
                    }
                    ExpandedMraidInterstitialStrategy.access$800(this.this$0).onExpandedBannerClose();
                }
                catch (Exception exception) {
                    AerServLog.e(ExpandedMraidInterstitialStrategy.access$400(), "Exception caught", exception);
                }
                ExpandedMraidInterstitialStrategy.access$300(this.this$0).finish();
            }
        });
    }

    private void setOrientationProperties(boolean bl, String string) {
        this.activity.runOnUiThread(new Runnable(this, bl, string){
            final /* synthetic */ ExpandedMraidInterstitialStrategy this$0;
            final /* synthetic */ boolean val$allowOrientationChange;
            final /* synthetic */ String val$forceOrientation;
            {
                this.this$0 = expandedMraidInterstitialStrategy;
                this.val$allowOrientationChange = bl;
                this.val$forceOrientation = string;
            }

            public void run() {
                try {
                    if (this.val$allowOrientationChange) {
                        ExpandedMraidInterstitialStrategy.access$300(this.this$0).setRequestedOrientation(10);
                    }
                    if (this.val$forceOrientation.equals((Object)"landscape")) {
                        ExpandedMraidInterstitialStrategy.access$300(this.this$0).setRequestedOrientation(6);
                    } else if (this.val$forceOrientation.equals((Object)"portrait")) {
                        ExpandedMraidInterstitialStrategy.access$300(this.this$0).setRequestedOrientation(7);
                    }
                    if (!this.val$allowOrientationChange) {
                        ExpandedMraidInterstitialStrategy.access$300(this.this$0).setRequestedOrientation(14);
                        return;
                    }
                }
                catch (Exception exception) {
                    AerServLog.e(ExpandedMraidInterstitialStrategy.access$400(), "Exception caught", exception);
                }
            }
        });
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
        OnCloseListener onCloseListener = new OnCloseListener(){

            @Override
            public void onClose() {
                ExpandedMraidInterstitialStrategy.this.close();
            }
        };
        this.closeButton = new CloseButton((Context)this.activity);
        SetVisibilityListener setVisibilityListener = new SetVisibilityListener(){

            @Override
            public void setVisibility(boolean bl) {
                ExpandedMraidInterstitialStrategy.this.closeButton.setVisibility(bl);
            }
        };
        if (this.useNewWebView) {
            ASMraidWebView aSMraidWebView;
            Properties properties = new Properties();
            properties.put((Object)"providerAd", (Object)this.ad);
            properties.put((Object)"controllerId", (Object)this.controllerId);
            MraidBannerJavascriptInterfaceListener mraidBannerJavascriptInterfaceListener = new MraidBannerJavascriptInterfaceListener((Context)this.activity, properties, this.providerListener, setVisibilityListener);
            mraidBannerJavascriptInterfaceListener.setOnCloseListener(onCloseListener);
            this.webView = aSMraidWebView = new ASMraidWebView((Context)this.activity, (MraidJavascriptInterfaceListener)mraidBannerJavascriptInterfaceListener, this.providerListener, this.controllerId, this.showAdTimeout, this.ad.getVirtualCurrency().getAerServTransactionInformation());
            this.webView.setIsExpandedBannerWithUrl();
        } else {
            ((MraidBannerJavascriptInterfaceListener)this.webView.getMraidJavascriptInterfaceListener()).setOnCloseListener(onCloseListener);
        }
        this.webView.updateMraidState(MraidState.EXPANDED);
        this.webView.setBackgroundColor(-16777216);
        this.webView.setOnSetOrientationPropertiesListener(new OnSetOrientationPropertiesListener(){

            @Override
            public void onSetOrientationProperties(boolean bl, String string) {
                ExpandedMraidInterstitialStrategy.this.setOrientationProperties(bl, string);
            }
        });
        boolean bl = this.useCustomClose;
        if (bl) {
            this.closeButton.setVisibility(bl ^ true);
        }
        this.webViewContainer.addView((android.view.View)this.webView);
        this.relativeLayout.addView((android.view.View)this.webViewContainer);
        this.relativeLayout.addView((android.view.View)this.closeButton);
        this.activity.setContentView((android.view.View)this.relativeLayout);
    }

    @Override
    public void onDestroy() {
    }

    @Override
    public void onPause() {
        try {
            this.webView.fireViewableChange(false);
            if (Build.VERSION.SDK_INT >= 11) {
                this.webView.onPause();
                return;
            }
        }
        catch (Exception exception) {
            AerServLog.e(LOG_TAG, "Exception caught", exception);
        }
    }

    @Override
    public void onResume() {
        try {
            if (this.firstOnResume) {
                this.firstOnResume = false;
            } else {
                this.webView.fireViewableChange(true);
            }
            if (Build.VERSION.SDK_INT >= 11) {
                this.webView.onResume();
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
        if (this.useNewWebView) {
            this.webView.loadDataWithBaseURL(this.expandUrl, this.ad.getHTML());
            this.bannerWebView.updateMraidState(MraidState.EXPANDED);
        }
    }

    @Override
    public void registerEvents() {
        this.closeButton.setOnClickListener(new View.OnClickListener(this){
            final /* synthetic */ ExpandedMraidInterstitialStrategy this$0;
            {
                this.this$0 = expandedMraidInterstitialStrategy;
            }

            public void onClick(android.view.View view) {
                ExpandedMraidInterstitialStrategy.access$000(this.this$0);
            }
        });
    }

}


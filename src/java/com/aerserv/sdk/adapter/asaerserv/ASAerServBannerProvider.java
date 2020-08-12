/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  android.view.ViewGroup
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.util.Properties
 *  org.json.JSONException
 */
package com.aerserv.sdk.adapter.asaerserv;

import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import com.aerserv.sdk.adapter.Provider;
import com.aerserv.sdk.adapter.asaerserv.ASAerServBannerProvider;
import com.aerserv.sdk.adapter.asaerserv.ASAerServConfig;
import com.aerserv.sdk.view.component.VideoControls;
import com.aerserv.sdk.view.component.VpaidWebView;
import com.aerserv.sdk.view.vastplayer.VastPlayer;
import java.util.Properties;
import org.json.JSONException;

public class ASAerServBannerProvider
implements Provider {
    private static final String LOG_TAG = "ASAerServBannerProvider";
    private ASAerServConfig asAerServConfig;
    private Properties properties;
    private VastPlayer vastPlayer;
    private ViewGroup viewGroup;
    private VideoControls vpaidVideoControls;
    private VpaidWebView vpaidWebView;

    private ASAerServBannerProvider(Properties properties) throws JSONException {
        this.properties = properties;
        if (properties.get((Object)"viewGroup") != null) {
            this.viewGroup = (ViewGroup)properties.get((Object)"viewGroup");
            this.asAerServConfig = new ASAerServConfig(properties);
            return;
        }
        throw new IllegalArgumentException("properties does not contain viewGroup");
    }

    static /* synthetic */ ASAerServConfig access$000(ASAerServBannerProvider aSAerServBannerProvider) {
        return aSAerServBannerProvider.asAerServConfig;
    }

    static /* synthetic */ ViewGroup access$100(ASAerServBannerProvider aSAerServBannerProvider) {
        return aSAerServBannerProvider.viewGroup;
    }

    static /* synthetic */ Properties access$200(ASAerServBannerProvider aSAerServBannerProvider) {
        return aSAerServBannerProvider.properties;
    }

    static /* synthetic */ VpaidWebView access$300(ASAerServBannerProvider aSAerServBannerProvider) {
        return aSAerServBannerProvider.vpaidWebView;
    }

    static /* synthetic */ VpaidWebView access$302(ASAerServBannerProvider aSAerServBannerProvider, VpaidWebView vpaidWebView) {
        aSAerServBannerProvider.vpaidWebView = vpaidWebView;
        return vpaidWebView;
    }

    static /* synthetic */ VideoControls access$400(ASAerServBannerProvider aSAerServBannerProvider) {
        return aSAerServBannerProvider.vpaidVideoControls;
    }

    static /* synthetic */ VideoControls access$402(ASAerServBannerProvider aSAerServBannerProvider, VideoControls videoControls) {
        aSAerServBannerProvider.vpaidVideoControls = videoControls;
        return videoControls;
    }

    static /* synthetic */ String access$500() {
        return LOG_TAG;
    }

    static /* synthetic */ VastPlayer access$600(ASAerServBannerProvider aSAerServBannerProvider) {
        return aSAerServBannerProvider.vastPlayer;
    }

    static /* synthetic */ VastPlayer access$602(ASAerServBannerProvider aSAerServBannerProvider, VastPlayer vastPlayer) {
        aSAerServBannerProvider.vastPlayer = vastPlayer;
        return vastPlayer;
    }

    public static Provider getInstance(Properties properties) throws JSONException {
        return new ASAerServBannerProvider(properties);
    }

    @Override
    public void requestAd() {
        Runnable runnable = new Runnable(this){
            final /* synthetic */ ASAerServBannerProvider this$0;
            {
                this.this$0 = aSAerServBannerProvider;
            }

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            public void run() {
                try {
                    com.aerserv.sdk.model.ad.ProviderAd providerAd = ASAerServBannerProvider.access$000(this.this$0).getProviderAd();
                    boolean bl = providerAd.getAdType().equals((Object)((Object)com.aerserv.sdk.model.ad.AdType.HTML));
                    if (bl) {
                        com.aerserv.sdk.view.component.ASWebView aSWebView = new com.aerserv.sdk.view.component.ASWebView(ASAerServBannerProvider.access$000(this.this$0).getContext(), ASAerServBannerProvider.access$000(this.this$0).getControllerId(), ASAerServBannerProvider.access$000(this.this$0).getShowAdTimeout(), providerAd.getVirtualCurrency().getAerServTransactionInformation());
                        aSWebView.registerProviderListener(ASAerServBannerProvider.access$000(this.this$0).getProviderListener());
                        ASAerServBannerProvider.access$100(this.this$0).addView((android.view.View)aSWebView);
                        aSWebView.loadData(((com.aerserv.sdk.model.ad.HTMLProviderAd)providerAd).getHTML(), "text/html", "UTF-8");
                    } else if (providerAd.getAdType() == com.aerserv.sdk.model.ad.AdType.MRAID) {
                        com.aerserv.sdk.controller.listener.MraidBannerJavascriptInterfaceListener mraidBannerJavascriptInterfaceListener = new com.aerserv.sdk.controller.listener.MraidBannerJavascriptInterfaceListener(ASAerServBannerProvider.access$000(this.this$0).getContext(), ASAerServBannerProvider.access$200(this.this$0), ASAerServBannerProvider.access$000(this.this$0).getProviderListener(), null);
                        com.aerserv.sdk.view.component.ASMraidWebView aSMraidWebView = new com.aerserv.sdk.view.component.ASMraidWebView(ASAerServBannerProvider.access$000(this.this$0).getContext(), (com.aerserv.sdk.controller.listener.MraidJavascriptInterfaceListener)mraidBannerJavascriptInterfaceListener, ASAerServBannerProvider.access$000(this.this$0).getProviderListener(), ASAerServBannerProvider.access$000(this.this$0).getControllerId(), ASAerServBannerProvider.access$000(this.this$0).getShowAdTimeout(), providerAd.getVirtualCurrency().getAerServTransactionInformation());
                        String string = ((com.aerserv.sdk.model.ad.MraidProviderAd)providerAd).getHTML();
                        ASAerServBannerProvider.access$100(this.this$0).addView((android.view.View)aSMraidWebView);
                        aSMraidWebView.loadData(string, "text/html", "UTF-8");
                    } else if (providerAd.getAdType().equals((Object)((Object)com.aerserv.sdk.model.ad.AdType.VAST))) {
                        if (((com.aerserv.sdk.model.ad.VASTProviderAd)providerAd).getVpaid() != null) {
                            com.aerserv.sdk.utils.AerServLog.d(this.getClass().getName(), "Banner VAST is a VPAID creative");
                            ASAerServBannerProvider.access$302(this.this$0, VpaidWebView.create(ASAerServBannerProvider.access$000(this.this$0).getContext(), new com.aerserv.sdk.view.vastplayer.VpaidPlayerListener(this, providerAd){
                                final /* synthetic */ 1 this$1;
                                final /* synthetic */ com.aerserv.sdk.model.ad.ProviderAd val$ad;
                                {
                                    this.this$1 = var1_1;
                                    this.val$ad = providerAd;
                                }

                                public void onAerServEvent(com.aerserv.sdk.AerServEvent aerServEvent) {
                                    com.aerserv.sdk.controller.listener.AerServEventListenerLocator.fireEvent(ASAerServBannerProvider.access$000(this.this$1.this$0).getControllerId(), aerServEvent);
                                    if (aerServEvent == com.aerserv.sdk.AerServEvent.AD_IMPRESSION) {
                                        com.aerserv.sdk.controller.listener.AerServEventListenerLocator.fireEvent(ASAerServBannerProvider.access$000(this.this$1.this$0).getControllerId(), com.aerserv.sdk.AerServEvent.SHOW_TRANSACTION, this.val$ad.getVirtualCurrency().getAerServTransactionInformation());
                                    }
                                }

                                public void onComplete() {
                                    new Handler(Looper.getMainLooper()).post(new Runnable(this){
                                        final /* synthetic */ com.aerserv.sdk.adapter.asaerserv.ASAerServBannerProvider$1$1 this$2;
                                        {
                                            this.this$2 = var1_1;
                                        }

                                        public void run() {
                                            ASAerServBannerProvider.access$100(this.this$2.this$1.this$0).removeView((android.view.View)ASAerServBannerProvider.access$300(this.this$2.this$1.this$0));
                                            ASAerServBannerProvider.access$100(this.this$2.this$1.this$0).removeView((android.view.View)ASAerServBannerProvider.access$400(this.this$2.this$1.this$0));
                                        }
                                    });
                                    ASAerServBannerProvider.access$300(this.this$1.this$0).stop();
                                }

                                public void onFailure() {
                                    ASAerServBannerProvider.access$000(this.this$1.this$0).getProviderListener().onProviderFailShow();
                                    ASAerServBannerProvider.access$300(this.this$1.this$0).stop();
                                }

                                public void onPlayPauseListenerCreated(com.aerserv.sdk.controller.listener.PlayPauseListener playPauseListener) {
                                    ASAerServBannerProvider.access$000(this.this$1.this$0).getProviderListener().onPlayPauseListenerCreated(playPauseListener);
                                }

                                public void onStop() {
                                    new Handler(Looper.getMainLooper()).post(new Runnable(this){
                                        final /* synthetic */ com.aerserv.sdk.adapter.asaerserv.ASAerServBannerProvider$1$1 this$2;
                                        {
                                            this.this$2 = var1_1;
                                        }

                                        public void run() {
                                            ASAerServBannerProvider.access$100(this.this$2.this$1.this$0).removeView((android.view.View)ASAerServBannerProvider.access$300(this.this$2.this$1.this$0));
                                            ASAerServBannerProvider.access$100(this.this$2.this$1.this$0).removeView((android.view.View)ASAerServBannerProvider.access$400(this.this$2.this$1.this$0));
                                        }
                                    });
                                    ASAerServBannerProvider.access$300(this.this$1.this$0).stop();
                                }

                                public void onTime(int n2, int n3, java.lang.Integer n4) {
                                    if (ASAerServBannerProvider.access$400(this.this$1.this$0) != null) {
                                        ASAerServBannerProvider.access$400(this.this$1.this$0).onTime(n2, n3);
                                    }
                                }
                            }, (com.aerserv.sdk.model.ad.VASTProviderAd)providerAd, ASAerServBannerProvider.access$000(this.this$0).getControllerId()));
                            if (ASAerServBannerProvider.access$300(this.this$0).getParent() != null) {
                                ((ViewGroup)ASAerServBannerProvider.access$300(this.this$0).getParent()).removeView((android.view.View)ASAerServBannerProvider.access$300(this.this$0));
                            }
                            ASAerServBannerProvider.access$100(this.this$0).addView((android.view.View)ASAerServBannerProvider.access$300(this.this$0));
                            ASAerServBannerProvider.access$402(this.this$0, new VideoControls(ASAerServBannerProvider.access$000(this.this$0).getContext(), ASAerServBannerProvider.access$100(this.this$0).getHeight(), ((com.aerserv.sdk.model.ad.VASTProviderAd)providerAd).isMuted(), new com.aerserv.sdk.controller.listener.VolumeControlListener(this){
                                final /* synthetic */ 1 this$1;
                                {
                                    this.this$1 = var1_1;
                                }

                                public void onMuted() {
                                    if (ASAerServBannerProvider.access$300(this.this$1.this$0) != null) {
                                        ASAerServBannerProvider.access$300(this.this$1.this$0).mute();
                                    }
                                }

                                public void onUnmuted() {
                                    if (ASAerServBannerProvider.access$300(this.this$1.this$0) != null) {
                                        ASAerServBannerProvider.access$300(this.this$1.this$0).unmute();
                                    }
                                }
                            }));
                            ASAerServBannerProvider.access$100(this.this$0).addView((android.view.View)ASAerServBannerProvider.access$400(this.this$0));
                            ASAerServBannerProvider.access$300(this.this$0).load();
                        } else {
                            if (!(ASAerServBannerProvider.access$000(this.this$0).getContext() instanceof android.app.Activity)) {
                                com.aerserv.sdk.utils.AerServLog.w(ASAerServBannerProvider.access$500(), "Cannot request ad because context is not of type Activity");
                                ASAerServBannerProvider.access$000(this.this$0).getProviderListener().onProviderFailShow();
                                return;
                            }
                            if (com.aerserv.sdk.utils.VASTUtils.mustShowCompanionAds((com.aerserv.sdk.model.ad.VASTProviderAd)providerAd)) {
                                com.aerserv.sdk.utils.AerServLog.d(ASAerServBannerProvider.access$500(), "Required companion ad detected, but banners cannot display them.  Failing over.");
                                ASAerServBannerProvider.access$000(this.this$0).getProviderListener().onProviderFailShow();
                                return;
                            }
                            ASAerServBannerProvider aSAerServBannerProvider = this.this$0;
                            VastPlayer vastPlayer = new VastPlayer((android.app.Activity)ASAerServBannerProvider.access$000(this.this$0).getContext(), (com.aerserv.sdk.model.ad.VASTProviderAd)providerAd, new com.aerserv.sdk.view.vastplayer.VastPlayerListener(this, providerAd){
                                final /* synthetic */ 1 this$1;
                                final /* synthetic */ com.aerserv.sdk.model.ad.ProviderAd val$ad;
                                {
                                    this.this$1 = var1_1;
                                    this.val$ad = providerAd;
                                }

                                public void onFailure(String string) {
                                    if (ASAerServBannerProvider.access$600(this.this$1.this$0) != null) {
                                        ASAerServBannerProvider.access$600(this.this$1.this$0).kill();
                                        ASAerServBannerProvider.access$602(this.this$1.this$0, null);
                                    }
                                    ASAerServBannerProvider.access$100(this.this$1.this$0).removeAllViews();
                                    ASAerServBannerProvider.access$000(this.this$1.this$0).getProviderListener().onProviderFailShow();
                                }

                                public void onMediaFileFound(com.aerserv.sdk.model.vast.MediaFile mediaFile) {
                                }

                                public void onPlayPauseListenerCreated(com.aerserv.sdk.controller.listener.PlayPauseListener playPauseListener) {
                                    ASAerServBannerProvider.access$000(this.this$1.this$0).getProviderListener().onPlayPauseListenerCreated(playPauseListener);
                                }

                                public void onPrepared() {
                                    com.aerserv.sdk.controller.listener.AerServEventListenerLocator.fireEvent(ASAerServBannerProvider.access$000(this.this$1.this$0).getControllerId(), com.aerserv.sdk.AerServEvent.AD_LOADED);
                                    com.aerserv.sdk.controller.listener.AerServEventListenerLocator.fireEvent(ASAerServBannerProvider.access$000(this.this$1.this$0).getControllerId(), com.aerserv.sdk.AerServEvent.AD_IMPRESSION);
                                    com.aerserv.sdk.controller.listener.AerServEventListenerLocator.fireEvent(ASAerServBannerProvider.access$000(this.this$1.this$0).getControllerId(), com.aerserv.sdk.AerServEvent.SHOW_TRANSACTION, this.val$ad.getVirtualCurrency().getAerServTransactionInformation());
                                }

                                public void onSuccess(boolean bl) {
                                    ASAerServBannerProvider.access$000(this.this$1.this$0).getProviderListener().onProviderFinished();
                                }

                                public void onTime(int n2, int n3) {
                                }

                                public void onTouch() {
                                    com.aerserv.sdk.controller.listener.AerServEventListenerLocator.fireEvent(ASAerServBannerProvider.access$000(this.this$1.this$0).getControllerId(), com.aerserv.sdk.AerServEvent.AD_CLICKED);
                                }
                            }, ASAerServBannerProvider.access$000(this.this$0).getControllerId(), true);
                            ASAerServBannerProvider.access$602(aSAerServBannerProvider, vastPlayer);
                            ASAerServBannerProvider.access$100(this.this$0).addView((android.view.View)ASAerServBannerProvider.access$600(this.this$0).getMasterFrameLayout());
                            ASAerServBannerProvider.access$600(this.this$0).play();
                        }
                    }
                    ASAerServBannerProvider.access$000(this.this$0).getProviderListener().onProviderAttempt();
                    return;
                }
                catch (java.lang.Exception exception) {
                    com.aerserv.sdk.utils.AerServLog.e(ASAerServBannerProvider.access$500(), "Exception caught", exception);
                    return;
                }
            }
        };
        new Handler(Looper.getMainLooper()).post(runnable);
    }
}


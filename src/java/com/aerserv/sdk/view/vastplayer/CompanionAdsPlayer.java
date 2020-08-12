/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.graphics.Paint
 *  android.graphics.Point
 *  android.os.Handler
 *  android.os.Looper
 *  android.view.MotionEvent
 *  android.view.OrientationEventListener
 *  android.view.View
 *  android.view.View$OnTouchListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.webkit.WebChromeClient
 *  android.webkit.WebSettings
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  com.aerserv.sdk.controller.command.FireEventCommand
 *  com.aerserv.sdk.controller.command.LaunchBrowserCommand
 *  com.aerserv.sdk.model.vast.CompanionAdsCreative
 *  com.aerserv.sdk.model.vast.HTMLAdResource
 *  com.aerserv.sdk.model.vast.IFrameAdResource
 *  com.aerserv.sdk.model.vast.StaticAdResource
 *  com.aerserv.sdk.view.vastplayer.CompanionAdsPlayer$3
 *  com.aerserv.sdk.view.vastplayer.CompanionAdsPlayer$4
 *  java.lang.Long
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Comparator
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Timer
 *  java.util.TimerTask
 */
package com.aerserv.sdk.view.vastplayer;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.aerserv.sdk.controller.command.FireEventCommand;
import com.aerserv.sdk.controller.command.LaunchBrowserCommand;
import com.aerserv.sdk.controller.listener.SkipVideoListener;
import com.aerserv.sdk.model.vast.AdResource;
import com.aerserv.sdk.model.vast.CompanionAd;
import com.aerserv.sdk.model.vast.CompanionAdsCreative;
import com.aerserv.sdk.model.vast.CompanionAdsRequirement;
import com.aerserv.sdk.model.vast.HTMLAdResource;
import com.aerserv.sdk.model.vast.IFrameAdResource;
import com.aerserv.sdk.model.vast.StaticAdResource;
import com.aerserv.sdk.model.vast.TrackingEvents;
import com.aerserv.sdk.utils.DisplayUtils;
import com.aerserv.sdk.utils.VastErrorHandler;
import com.aerserv.sdk.utils.VersionUtils;
import com.aerserv.sdk.view.component.SkipButton;
import com.aerserv.sdk.view.vastplayer.CompanionAdListener;
import com.aerserv.sdk.view.vastplayer.CompanionAdsPlayer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class CompanionAdsPlayer
extends RelativeLayout {
    private boolean adPlayed;
    private Comparator<AdResource> adResourceComparator;
    private SkipButton autocloseView;
    private Timer closeAdTimer;
    private SkipButton closeButton;
    private Comparator<CompanionAd> companionAdComparator;
    private CompanionAdsRequirement companionAdsRequirement;
    private boolean creativeViewEventsFired;
    private int deviceOrientation;
    private long elapsedTime;
    private CompanionAdListener listener;
    private OrientationEventListener orientationEventListener;
    private WebView webView;

    public CompanionAdsPlayer(final Context context, CompanionAdsCreative companionAdsCreative, final CompanionAdListener companionAdListener) {
        SkipButton skipButton;
        SkipButton skipButton2;
        super(context);
        CompanionAd companionAd = null;
        this.closeAdTimer = null;
        Long l2 = 0L;
        this.elapsedTime = 0L;
        this.webView = null;
        this.closeButton = null;
        this.autocloseView = null;
        this.adPlayed = false;
        this.deviceOrientation = this.getResources().getConfiguration().orientation;
        this.creativeViewEventsFired = false;
        this.adResourceComparator = new Comparator<AdResource>(){

            public int compare(AdResource adResource, AdResource adResource2) {
                if (adResource instanceof HTMLAdResource) {
                    return -1;
                }
                if (adResource instanceof StaticAdResource) {
                    return -1;
                }
                return 1;
            }
        };
        this.companionAdComparator = new Comparator<CompanionAd>(){

            public int compare(CompanionAd companionAd, CompanionAd companionAd2) {
                Point point = DisplayUtils.getScreenSizeInDip(CompanionAdsPlayer.this.getContext());
                int n = point.x;
                int n2 = point.y;
                if (CompanionAdsPlayer.this.matchesDeviceOrientation(n, n2, companionAd) && !CompanionAdsPlayer.this.matchesDeviceOrientation(n, n2, companionAd2)) {
                    return -1;
                }
                if (!CompanionAdsPlayer.this.matchesDeviceOrientation(n, n2, companionAd) && CompanionAdsPlayer.this.matchesDeviceOrientation(n, n2, companionAd2)) {
                    return 1;
                }
                if (companionAd.getWidth() <= n && companionAd2.getWidth() > n) {
                    return -1;
                }
                if (companionAd2.getWidth() <= n && companionAd.getWidth() > n) {
                    return 1;
                }
                return n - companionAd.getWidth() - (n - companionAd2.getWidth());
            }
        };
        this.listener = companionAdListener;
        this.companionAdsRequirement = companionAdsCreative.getCompanionAdsRequirement();
        if (companionAdsCreative.getCompanionAds().size() < 1) {
            this.closeCompanionAd();
            return;
        }
        this.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1, 17));
        this.setBackgroundColor(-14540254);
        ArrayList arrayList = new ArrayList((Collection)companionAdsCreative.getCompanionAds());
        Collections.sort((List)arrayList, this.companionAdComparator);
        Iterator iterator = arrayList.iterator();
        final AdResource adResource = null;
        while (iterator.hasNext()) {
            CompanionAd companionAd2 = (CompanionAd)iterator.next();
            ArrayList arrayList2 = new ArrayList(companionAd2.getResourceList());
            Collections.sort((List)arrayList2, this.adResourceComparator);
            for (AdResource adResource2 : arrayList2) {
                if (!this.isSupportedAdResource(adResource2)) continue;
                companionAd = companionAd2;
                adResource = adResource2;
                break;
            }
            if (adResource == null) continue;
        }
        final CompanionAd companionAd3 = companionAd;
        if (adResource == null) {
            this.closeCompanionAd();
            return;
        }
        this.closeButton = skipButton = new SkipButton(this.getContext(), l2, l2, -1, SkipButton.Position.TOP_RIGHT, "\nClose\n", "\nClose\n", (SkipVideoListener)new 3(this));
        this.closeButton.onTime(0L);
        this.autocloseView = skipButton2 = new SkipButton(this.getContext(), 10000L, 10000L, -1, SkipButton.Position.BOTTOM_LEFT, "Ad will close in %s seconds", "Ad will close in 0 seconds", (SkipVideoListener)new 4(this));
        Handler handler = new Handler(this.getContext().getMainLooper());
        Runnable runnable = new Runnable(){

            public void run() {
                CompanionAdsPlayer.this.webView = new WebView(context);
                CompanionAdsPlayer.this.webView.setHorizontalScrollBarEnabled(false);
                CompanionAdsPlayer.this.webView.setVerticalScrollBarEnabled(false);
                CompanionAdsPlayer.this.webView.getSettings().setJavaScriptEnabled(true);
                CompanionAdsPlayer.this.webView.setWebChromeClient(new WebChromeClient());
                CompanionAdsPlayer.this.webView.setBackgroundColor(-14540254);
                if (VersionUtils.checkVersion(11)) {
                    CompanionAdsPlayer.this.webView.setLayerType(1, null);
                }
                CompanionAdsPlayer.this.webView.setWebViewClient(new WebViewClient(){

                    public void onPageFinished(WebView webView, String string) {
                        super.onPageFinished(webView, string);
                        CompanionAdsPlayer.this.adPlayed = true;
                        if (!CompanionAdsPlayer.this.creativeViewEventsFired) {
                            CompanionAdsPlayer.this.creativeViewEventsFired = true;
                            new FireEventCommand(companionAd3.getCreativeViewTrackingEvents()).execute();
                        }
                    }
                });
                CompanionAdsPlayer.this.webView.setOnTouchListener(new View.OnTouchListener(){

                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        if (motionEvent.getAction() == 1) {
                            companionAdListener.onTouched();
                            new FireEventCommand(companionAd3.getClickTrackingUris()).execute();
                            new LaunchBrowserCommand(CompanionAdsPlayer.this.getContext(), companionAd3.getClickThrough()).execute();
                        }
                        return true;
                    }
                });
                CompanionAdsPlayer companionAdsPlayer = CompanionAdsPlayer.this;
                companionAdsPlayer.setWebViewLayout(companionAdsPlayer.webView, adResource, companionAd3);
                AdResource adResource2 = adResource;
                if (adResource2 instanceof HTMLAdResource) {
                    CompanionAdsPlayer.this.webView.loadData(((HTMLAdResource)adResource).getHtml(), "text/html", "UTF-8");
                } else if (adResource2 instanceof StaticAdResource) {
                    CompanionAdsPlayer.this.webView.loadData(CompanionAdsPlayer.this.getHtml((StaticAdResource)adResource, companionAd3), "text/html", "UTF-8");
                } else if (adResource2 instanceof IFrameAdResource) {
                    CompanionAdsPlayer.this.webView.loadUrl(((IFrameAdResource)adResource).getiFrameUri());
                }
                CompanionAdsPlayer companionAdsPlayer2 = CompanionAdsPlayer.this;
                companionAdsPlayer2.orientationEventListener = new OrientationEventListener(companionAdsPlayer2.getContext()){

                    public void onOrientationChanged(int n) {
                        if (CompanionAdsPlayer.this.getResources().getConfiguration().orientation != CompanionAdsPlayer.this.deviceOrientation) {
                            CompanionAdsPlayer.this.deviceOrientation = CompanionAdsPlayer.this.getResources().getConfiguration().orientation;
                            if (adResource instanceof HTMLAdResource) {
                                CompanionAdsPlayer.this.setWebViewLayout(CompanionAdsPlayer.this.webView, adResource, companionAd3);
                                CompanionAdsPlayer.this.webView.loadData(((HTMLAdResource)adResource).getHtml(), "text/html", "UTF-8");
                                return;
                            }
                            if (adResource instanceof StaticAdResource) {
                                CompanionAdsPlayer.this.webView.loadData(CompanionAdsPlayer.this.getHtml((StaticAdResource)adResource, companionAd3), "text/html", "UTF-8");
                                return;
                            }
                            if (adResource instanceof IFrameAdResource) {
                                CompanionAdsPlayer.this.setWebViewLayout(CompanionAdsPlayer.this.webView, adResource, companionAd3);
                                CompanionAdsPlayer.this.webView.loadUrl(((IFrameAdResource)adResource).getiFrameUri());
                            }
                        }
                    }
                };
                CompanionAdsPlayer.this.orientationEventListener.enable();
                CompanionAdsPlayer companionAdsPlayer3 = CompanionAdsPlayer.this;
                companionAdsPlayer3.addView((View)companionAdsPlayer3.webView);
                CompanionAdsPlayer companionAdsPlayer4 = CompanionAdsPlayer.this;
                companionAdsPlayer4.addView((View)companionAdsPlayer4.closeButton);
                CompanionAdsPlayer companionAdsPlayer5 = CompanionAdsPlayer.this;
                companionAdsPlayer5.addView((View)companionAdsPlayer5.autocloseView);
            }

        };
        handler.post(runnable);
        this.startCloseAdTimer();
    }

    private void closeCompanionAd() {
        CompanionAdListener companionAdListener;
        OrientationEventListener orientationEventListener;
        Timer timer = this.closeAdTimer;
        if (timer != null) {
            timer.cancel();
            this.closeAdTimer = null;
        }
        if ((orientationEventListener = this.orientationEventListener) != null) {
            orientationEventListener.disable();
        }
        if (!this.isRequiredNumberOfAdsDisplayed()) {
            VastErrorHandler.fireError(VastErrorHandler.Error.GENERAL_COMPANION_ADS_ERROR);
        }
        if ((companionAdListener = this.listener) != null) {
            companionAdListener.onComplete();
        }
    }

    private String getHtml(StaticAdResource staticAdResource, CompanionAd companionAd) {
        Object[] arrobject = new Object[]{this.getLimitingDimension(companionAd.getWidth(), companionAd.getHeight()), this.getLimitingSize(companionAd.getWidth(), companionAd.getHeight()), staticAdResource.getResourceUri()};
        return String.format((String)"<!doctype html>\n<html lang=\"en\">\n  <head>\n    <style type=\"text/css\">\n      body {margin: 0; padding: 0; background-color: black;}\n      img {margin: auto; position: absolute; top: 0; left: 0; bottom: 0; right: 0;}\n    </style>\n  </head>\n  <body>\n    <img %s=\"%s\" src=\"%s\">\n  </body>\n</html>", (Object[])arrobject);
    }

    private String getLimitingDimension(int n, int n2) {
        Point point = DisplayUtils.getScreenSizeInDip(this.getContext());
        int n3 = point.x;
        int n4 = point.y;
        if ((float)n / (float)n2 < (float)n3 / (float)n4) {
            return "height";
        }
        return "width";
    }

    private int getLimitingSize(int n, int n2) {
        Point point = DisplayUtils.getScreenSizeInDip(this.getContext());
        int n3 = point.x;
        int n4 = point.y;
        if ("height".equals((Object)this.getLimitingDimension(n, n2))) {
            return Math.min((int)n2, (int)n4);
        }
        return Math.min((int)n, (int)n3);
    }

    private boolean isRequiredNumberOfAdsDisplayed() {
        CompanionAdsRequirement companionAdsRequirement = this.companionAdsRequirement;
        if (companionAdsRequirement != null && companionAdsRequirement != CompanionAdsRequirement.NONE) {
            return this.adPlayed;
        }
        return true;
    }

    private boolean isSupportedAdResource(AdResource adResource) {
        boolean bl;
        block8 : {
            block7 : {
                block4 : {
                    boolean bl2;
                    block6 : {
                        block5 : {
                            if (!(adResource instanceof StaticAdResource)) break block4;
                            String string = ((StaticAdResource)adResource).getMimeType();
                            if ("image/gif".equals((Object)string) || "image/jpeg".equals((Object)string)) break block5;
                            boolean bl3 = "image/png".equals((Object)string);
                            bl2 = false;
                            if (!bl3) break block6;
                        }
                        bl2 = true;
                    }
                    return bl2;
                }
                if (adResource instanceof HTMLAdResource) break block7;
                boolean bl4 = adResource instanceof IFrameAdResource;
                bl = false;
                if (!bl4) break block8;
            }
            bl = true;
        }
        return bl;
    }

    private boolean matchesDeviceOrientation(int n, int n2, CompanionAd companionAd) {
        return n > n2 ? companionAd.getWidth() > companionAd.getHeight() : companionAd.getWidth() <= companionAd.getHeight();
    }

    private void setWebViewLayout(WebView webView, AdResource adResource, CompanionAd companionAd) {
        RelativeLayout.LayoutParams layoutParams;
        int n = companionAd.getWidth();
        int n2 = companionAd.getHeight();
        if (adResource instanceof StaticAdResource) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        } else if (!(adResource instanceof HTMLAdResource) && !(adResource instanceof IFrameAdResource)) {
            layoutParams = null;
        } else {
            int n3;
            String string = this.getLimitingDimension(n, n2);
            int n4 = this.getLimitingSize(n, n2);
            if ("height".equals((Object)string)) {
                n3 = Math.round((float)((float)n * (float)n4 / (float)n2));
            } else {
                int n5 = Math.round((float)((float)n2 * (float)n4 / (float)n));
                int n6 = n4;
                n4 = n5;
                n3 = n6;
            }
            layoutParams = new RelativeLayout.LayoutParams(DisplayUtils.convertDipToPx(this.getContext(), n3), DisplayUtils.convertDipToPx(this.getContext(), n4));
        }
        layoutParams.addRule(13);
        webView.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    }

    private void startCloseAdTimer() {
        if (this.closeAdTimer == null) {
            this.closeAdTimer = new Timer();
            this.closeAdTimer.schedule(new TimerTask(){

                public void run() {
                    CompanionAdsPlayer companionAdsPlayer = CompanionAdsPlayer.this;
                    companionAdsPlayer.elapsedTime = 250L + companionAdsPlayer.elapsedTime;
                    if (CompanionAdsPlayer.this.autocloseView != null) {
                        CompanionAdsPlayer.this.autocloseView.onTime(CompanionAdsPlayer.this.elapsedTime);
                        if (CompanionAdsPlayer.this.elapsedTime >= 10000L) {
                            CompanionAdsPlayer.this.closeCompanionAd();
                        }
                    }
                }
            }, 0L, 250L);
        }
    }

    private void stopCloseAdTimer() {
        Timer timer = this.closeAdTimer;
        if (timer != null) {
            timer.cancel();
            this.closeAdTimer = null;
        }
    }

    public void pause() {
        this.stopCloseAdTimer();
        OrientationEventListener orientationEventListener = this.orientationEventListener;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
    }

    public void resume() {
        OrientationEventListener orientationEventListener;
        if (this.autocloseView != null) {
            this.startCloseAdTimer();
        }
        if ((orientationEventListener = this.orientationEventListener) != null) {
            orientationEventListener.enable();
        }
    }

}


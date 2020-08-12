/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.app.Activity
 *  android.content.Context
 *  android.media.MediaPlayer
 *  android.media.MediaPlayer$OnCompletionListener
 *  android.media.MediaPlayer$OnErrorListener
 *  android.media.MediaPlayer$OnPreparedListener
 *  android.net.Uri
 *  android.text.TextUtils
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnTouchListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewParent
 *  android.webkit.WebSettings
 *  android.webkit.WebView
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  com.aerserv.sdk.controller.command.FireEventCommand
 *  com.aerserv.sdk.controller.command.LaunchBrowserCommand
 *  com.aerserv.sdk.model.ad.VASTProviderAd
 *  com.aerserv.sdk.model.vast.Ad
 *  com.aerserv.sdk.model.vast.CompanionAdsCreative
 *  com.aerserv.sdk.model.vast.Creative
 *  com.aerserv.sdk.model.vast.InLine
 *  com.aerserv.sdk.model.vast.LinearCreative
 *  com.aerserv.sdk.model.vast.PlayableVastCreative
 *  com.aerserv.sdk.view.vastplayer.VastPlayer$1
 *  com.aerserv.sdk.view.vastplayer.VastPlayer$2
 *  com.aerserv.sdk.view.vastplayer.VastPlayer$4$1
 *  com.aerserv.sdk.view.vastplayer.VastPlayer$4$2
 *  com.aerserv.sdk.view.vastplayer.VastPlayer$7
 *  com.aerserv.sdk.view.vastplayer.VastPlayer$8
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.LinkedList
 *  java.util.List
 *  java.util.Set
 *  java.util.Stack
 *  java.util.TreeSet
 */
package com.aerserv.sdk.view.vastplayer;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.aerserv.sdk.AerServEvent;
import com.aerserv.sdk.AerServVirtualCurrency;
import com.aerserv.sdk.controller.command.FireEventCommand;
import com.aerserv.sdk.controller.command.LaunchBrowserCommand;
import com.aerserv.sdk.controller.listener.AerServEventListenerLocator;
import com.aerserv.sdk.controller.listener.PlayPauseListener;
import com.aerserv.sdk.controller.listener.SkipVideoListener;
import com.aerserv.sdk.controller.listener.VolumeControlListener;
import com.aerserv.sdk.dao.VideoFileCache;
import com.aerserv.sdk.model.ad.VASTProviderAd;
import com.aerserv.sdk.model.vast.Ad;
import com.aerserv.sdk.model.vast.Banner;
import com.aerserv.sdk.model.vast.CompanionAdsCreative;
import com.aerserv.sdk.model.vast.Creative;
import com.aerserv.sdk.model.vast.EventType;
import com.aerserv.sdk.model.vast.Icons;
import com.aerserv.sdk.model.vast.InLine;
import com.aerserv.sdk.model.vast.LinearCreative;
import com.aerserv.sdk.model.vast.MediaFile;
import com.aerserv.sdk.model.vast.PlayableVastCreative;
import com.aerserv.sdk.model.vast.SequenceEnabled;
import com.aerserv.sdk.model.vast.Supplement;
import com.aerserv.sdk.model.vast.TrackingEvents;
import com.aerserv.sdk.model.vast.VAST;
import com.aerserv.sdk.utils.AerServLog;
import com.aerserv.sdk.utils.DisplayUtils;
import com.aerserv.sdk.utils.MoatUtils;
import com.aerserv.sdk.utils.VASTUtils;
import com.aerserv.sdk.view.component.SkipButton;
import com.aerserv.sdk.view.component.VastVideoView;
import com.aerserv.sdk.view.component.VastVideoViewSizeChangedEventHandler;
import com.aerserv.sdk.view.component.VideoControls;
import com.aerserv.sdk.view.vastplayer.CompanionAdListener;
import com.aerserv.sdk.view.vastplayer.CompanionAdsPlayer;
import com.aerserv.sdk.view.vastplayer.IconsListener;
import com.aerserv.sdk.view.vastplayer.IconsPlayer;
import com.aerserv.sdk.view.vastplayer.PlayableAd;
import com.aerserv.sdk.view.vastplayer.VastPlayer;
import com.aerserv.sdk.view.vastplayer.VastPlayerListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public final class VastPlayer {
    private static final String LOG_TAG = "VastPlayer";
    public static final Set<String> supportedMimeTypesSet = new HashSet((Collection)Arrays.asList((Object[])new String[]{"video/3gpp", "video/mp4", "text/html", "application/javascript"}));
    private Activity activity;
    private VASTProviderAd ad;
    private int adCount = 0;
    private int adSequence = 0;
    private LinkedList<PlayableAd> adsToPlay = new LinkedList();
    private List<String> allImpressionEvents;
    private TrackingEvents allProgressEvents;
    private boolean atLeastOneAdPlayed = false;
    private CompanionAdsPlayer companionAdsPlayer = null;
    private String controllerId;
    private int currVidPos = 0;
    private PlayableAd currentAd;
    private Creative currentCreative;
    private LinearCreative currentLinearCreative;
    private boolean hasPassed0Percent = false;
    private boolean hasPassedCloseOffset = false;
    private IconsPlayer iconsPlayer = null;
    private boolean isBanner;
    private Boolean isMuted = null;
    private volatile boolean killTimer = false;
    private WebView linearWebView;
    private RelativeLayout masterFrameLayout;
    private MediaPlayer mediaPlayer;
    private WebView nonLinearWebView;
    private boolean onPreparedFired = false;
    private Stack<AerServEvent> quartiles = new Stack();
    private boolean showSkipButton;
    private SkipButton skipButton;
    private VastPlayerListener vastPlayerListener;
    private VastVideoView vastVideoView;
    private VastVideoViewSizeChangedEventHandler vastVideoViewSizeChangedEventHandler;
    private VideoControls videoControls;
    private final Object videoTimerMonitor = new Object();
    private boolean wasAtLeastOneAdSkipped = false;

    public VastPlayer(Activity activity, VASTProviderAd vASTProviderAd, VastPlayerListener vastPlayerListener, String string, boolean bl) {
        this.ad = vASTProviderAd;
        this.vastPlayerListener = vastPlayerListener;
        this.activity = activity;
        this.controllerId = string;
        this.isBanner = bl;
        this.showSkipButton = bl ^ true;
        this.configureMasterFrameLayout();
        this.configureVideoView();
        this.configureLinearWebView();
        this.configureNonLinearWebView();
        this.masterFrameLayout.addView((View)this.vastVideoView);
        this.masterFrameLayout.addView((View)this.linearWebView);
        this.registerVideoPlayerListeners();
        this.buildAdsToShow();
        vastPlayerListener.onPlayPauseListenerCreated((PlayPauseListener)new 1(this));
    }

    static /* synthetic */ void access$100(VastPlayer vastPlayer) {
        vastPlayer.pauseVastVideoView();
    }

    static /* synthetic */ boolean access$1702(VastPlayer vastPlayer, boolean bl) {
        vastPlayer.wasAtLeastOneAdSkipped = bl;
        return bl;
    }

    static /* synthetic */ IconsPlayer access$1800(VastPlayer vastPlayer) {
        return vastPlayer.iconsPlayer;
    }

    static /* synthetic */ void access$200(VastPlayer vastPlayer) {
        vastPlayer.startVastVideoView();
    }

    static /* synthetic */ Object access$2500(VastPlayer vastPlayer) {
        return vastPlayer.videoTimerMonitor;
    }

    static /* synthetic */ boolean access$2600(VastPlayer vastPlayer) {
        return vastPlayer.killTimer;
    }

    static /* synthetic */ boolean access$2700(VastPlayer vastPlayer) {
        return vastPlayer.hasPassedCloseOffset;
    }

    static /* synthetic */ boolean access$2702(VastPlayer vastPlayer, boolean bl) {
        vastPlayer.hasPassedCloseOffset = bl;
        return bl;
    }

    static /* synthetic */ boolean access$2800(VastPlayer vastPlayer) {
        return vastPlayer.hasPassed0Percent;
    }

    static /* synthetic */ boolean access$2802(VastPlayer vastPlayer, boolean bl) {
        vastPlayer.hasPassed0Percent = bl;
        return bl;
    }

    static /* synthetic */ boolean access$2902(VastPlayer vastPlayer, boolean bl) {
        vastPlayer.atLeastOneAdPlayed = bl;
        return bl;
    }

    static /* synthetic */ Stack access$3000(VastPlayer vastPlayer) {
        return vastPlayer.quartiles;
    }

    static /* synthetic */ TrackingEvents access$3100(VastPlayer vastPlayer) {
        return vastPlayer.allProgressEvents;
    }

    static /* synthetic */ boolean access$3200(VastPlayer vastPlayer) {
        return vastPlayer.stillPlaying();
    }

    static /* synthetic */ String access$400() {
        return LOG_TAG;
    }

    static /* synthetic */ FrameLayout.LayoutParams access$500(VastPlayer vastPlayer, Banner banner) {
        return vastPlayer.getBannerAsOverlayLayoutParams(banner);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private void buildAdsToShow() {
        Object object;
        if (this.ad.getFirstPlayableVAST() != null && this.ad.getFirstPlayableVAST().getAds().size() != 0) {
            Iterator iterator = VASTUtils.normalizeSequenceEnabled(this.ad.getFirstPlayableVAST().getAds(), InLine.class).iterator();
            do {
                if (!iterator.hasNext()) {
                    this.adCount = this.adsToPlay.size();
                    Collections.sort(this.adsToPlay);
                    return;
                }
                SequenceEnabled sequenceEnabled = (SequenceEnabled)iterator.next();
                this.adsToPlay.add((Object)new PlayableAd((InLine)sequenceEnabled));
            } while (true);
        }
        Object object2 = object = this.videoTimerMonitor;
        // MONITORENTER : object2
        this.killTimer = true;
        // MONITOREXIT : object2
        {
            catch (Throwable throwable) {}
            {
                // MONITOREXIT : object2
                throw throwable;
            }
        }
        this.vastVideoView.removeVastVideoViewSizeChangedEventHandler(this.vastVideoViewSizeChangedEventHandler);
        this.vastPlayerListener.onFailure("Either there was no playable VASt or there was an invalid VAST received.");
    }

    private void configureLinearWebView() {
        this.linearWebView = new WebView((Context)this.activity);
        this.linearWebView.setHorizontalScrollBarEnabled(false);
        this.linearWebView.setVerticalScrollBarEnabled(false);
        this.linearWebView.setVisibility(4);
        this.configureWebViewWebSettings(this.linearWebView);
    }

    private void configureMasterFrameLayout() {
        this.masterFrameLayout = new RelativeLayout((Context)this.activity);
        this.masterFrameLayout.setLayoutParams((ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
    }

    private void configureNonLinearWebView() {
        this.nonLinearWebView = new WebView((Context)this.activity);
        this.nonLinearWebView.setHorizontalScrollBarEnabled(false);
        this.nonLinearWebView.setVerticalScrollBarEnabled(false);
        this.nonLinearWebView.setVisibility(4);
        this.configureWebViewWebSettings(this.nonLinearWebView);
    }

    private void configureVideoView() {
        this.vastVideoView = new VastVideoView(this.activity.getApplicationContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13, -1);
        this.vastVideoView.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
        this.vastVideoViewSizeChangedEventHandler = new 2(this);
        this.vastVideoView.addVastVideoViewSizeChangedEventHandler(this.vastVideoViewSizeChangedEventHandler);
    }

    @SuppressLint(value={"SetJavaScriptEnabled"})
    private void configureWebViewWebSettings(WebView webView) {
        webView.getSettings().setJavaScriptEnabled(true);
    }

    private FrameLayout.LayoutParams getBannerAsOverlayLayoutParams(Banner banner) {
        return new FrameLayout.LayoutParams(DisplayUtils.convertDipToPx((Context)this.activity, banner.getWidth()), DisplayUtils.convertDipToPx((Context)this.activity, banner.getHeight()), 49);
    }

    private FrameLayout.LayoutParams getLinearWebViewEndCardLayoutParams(MediaFile mediaFile) {
        int n;
        int n2;
        block3 : {
            float f2;
            float f3;
            block4 : {
                block5 : {
                    block2 : {
                        f3 = (float)mediaFile.getWidth() / (float)mediaFile.getHeight();
                        n2 = DisplayUtils.convertDipToPx((Context)this.activity, mediaFile.getHeight());
                        n = DisplayUtils.convertDipToPx((Context)this.activity, mediaFile.getWidth());
                        if (n <= this.masterFrameLayout.getWidth() || n2 <= this.masterFrameLayout.getHeight()) break block2;
                        n = this.masterFrameLayout.getWidth();
                        n2 = (int)((float)n / f3);
                        if (n2 <= this.masterFrameLayout.getHeight()) break block3;
                        n2 = this.masterFrameLayout.getHeight();
                        f2 = n2;
                        break block4;
                    }
                    if (n <= this.masterFrameLayout.getWidth()) break block5;
                    n = this.masterFrameLayout.getWidth();
                    n2 = (int)((float)n / f3);
                    break block3;
                }
                if (n2 <= this.masterFrameLayout.getHeight()) break block3;
                n2 = this.masterFrameLayout.getHeight();
                f2 = n;
            }
            n = (int)(f2 * f3);
        }
        return new FrameLayout.LayoutParams(n, n2, 17);
    }

    private Integer getSkipOffsetMillis() {
        Integer n = VASTUtils.calculateMillisBeforeSkippable(this.currentLinearCreative.getSkipOffset(), this.vastVideoView.getVideoDuration());
        if (n == null) {
            n = VASTUtils.calculateMillisecondsBeforeClosable(this.ad, this.vastVideoView.getVideoDuration());
        }
        return n;
    }

    private void pauseVastVideoView() {
        this.vastVideoView.pause();
    }

    private void registerVideoPlayerListeners() {
        this.vastVideoView.setOnErrorListener(new MediaPlayer.OnErrorListener(){

            public boolean onError(MediaPlayer mediaPlayer, int n, int n2) {
                VastPlayer.this.showNextCreative();
                return true;
            }
        });
        this.vastVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener(){

            public void onPrepared(MediaPlayer mediaPlayer) {
                Banner banner;
                MoatUtils.createTracker(VastPlayer.this.controllerId, VastPlayer.this.activity, (View)VastPlayer.this.vastVideoView, mediaPlayer, true);
                MoatUtils.startTracking(VastPlayer.this.controllerId);
                if (VastPlayer.this.currentLinearCreative.getSupplement() != null && VastPlayer.this.currentLinearCreative.getSupplement().getBanner() != null && "text/html".equals((Object)(banner = VastPlayer.this.currentLinearCreative.getSupplement().getBanner()).getMimeType())) {
                    ViewParent viewParent = VastPlayer.this.nonLinearWebView.getParent();
                    if (viewParent != null) {
                        ((FrameLayout)viewParent).removeView((View)VastPlayer.this.nonLinearWebView);
                    }
                    VastPlayer.this.masterFrameLayout.addView((View)VastPlayer.this.nonLinearWebView);
                    VastPlayer.this.nonLinearWebView.setVisibility(0);
                    VastPlayer.this.nonLinearWebView.loadUrl(banner.getBannerUri());
                    VastPlayer.this.nonLinearWebView.bringToFront();
                }
                VastPlayer.this.vastVideoView.setVideoDuration(mediaPlayer.getDuration());
                if (!VastPlayer.this.onPreparedFired) {
                    VastPlayer.this.onPreparedFired = true;
                    if (VastPlayer.this.masterFrameLayout.indexOfChild((View)VastPlayer.this.videoControls) >= 0) {
                        VastPlayer.this.masterFrameLayout.removeView((View)VastPlayer.this.videoControls);
                    }
                    VastPlayer vastPlayer = VastPlayer.this;
                    VideoControls videoControls = new VideoControls((Context)vastPlayer.activity, VastPlayer.this.adSequence, VastPlayer.this.adCount, VastPlayer.this.masterFrameLayout.getHeight(), VastPlayer.this.ad.isMuted(), (VolumeControlListener)new 1(this));
                    vastPlayer.videoControls = videoControls;
                    VastPlayer.this.masterFrameLayout.addView((View)VastPlayer.this.videoControls);
                    Integer n = VastPlayer.this.getSkipOffsetMillis();
                    if (VastPlayer.this.masterFrameLayout.indexOfChild((View)VastPlayer.this.skipButton) >= 0) {
                        VastPlayer.this.masterFrameLayout.removeView((View)VastPlayer.this.skipButton);
                    }
                    VastPlayer vastPlayer2 = VastPlayer.this;
                    Activity activity = vastPlayer2.activity;
                    Long l2 = n == null ? null : Long.valueOf((long)n.longValue());
                    SkipButton skipButton = new SkipButton((Context)activity, l2, (long)mediaPlayer.getDuration(), -1, (SkipVideoListener)new 2(this));
                    vastPlayer2.skipButton = skipButton;
                    if (VastPlayer.this.showSkipButton) {
                        VastPlayer.this.masterFrameLayout.addView((View)VastPlayer.this.skipButton);
                    }
                    VastPlayer.this.vastPlayerListener.onPrepared();
                }
                VastPlayer.this.mediaPlayer = mediaPlayer;
                Iterator iterator = VastPlayer.this.allImpressionEvents.iterator();
                while (iterator.hasNext()) {
                    new FireEventCommand((String)iterator.next()).execute();
                    iterator.remove();
                }
                if (VastPlayer.this.isMuted == null) {
                    if (VastPlayer.this.ad.isMuted()) {
                        VastPlayer.this.mute();
                    }
                } else if (VastPlayer.this.isMuted.booleanValue()) {
                    VastPlayer.this.mute();
                } else {
                    VastPlayer.this.unmute();
                }
                VastPlayer.this.startVideoTimer();
            }
        });
        this.vastVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener(){

            public void onCompletion(MediaPlayer mediaPlayer) {
                MoatUtils.cleanup(VastPlayer.this.controllerId);
                new FireEventCommand(VastPlayer.this.currentLinearCreative.getTrackingEventsByEventType(EventType.COMPLETE)).execute();
                new FireEventCommand(VastPlayer.this.ad.getAllWrapperLinearCreativeTrackingEventsByType(EventType.COMPLETE)).execute();
                AerServEventListenerLocator.fireEvent(VastPlayer.this.controllerId, AerServEvent.VIDEO_COMPLETED);
                if (VastPlayer.this.ad.isVirtualCurrencyEnabled()) {
                    String string = VastPlayer.this.ad.getVirtualCurrency().getEventUrl();
                    if (!TextUtils.isEmpty((CharSequence)string)) {
                        new FireEventCommand(string).execute();
                    }
                    AerServEventListenerLocator.fireEvent(VastPlayer.this.controllerId, AerServEvent.VC_REWARDED, VastPlayer.this.ad.getVirtualCurrency());
                }
                VastPlayer.this.showNextCreative();
            }
        });
        this.vastVideoView.setOnTouchListener(new View.OnTouchListener(){

            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    VastPlayer.this.vastPlayerListener.onTouch();
                    new FireEventCommand(VastPlayer.this.currentLinearCreative.getClickTrackingUris()).execute();
                    new FireEventCommand(VastPlayer.this.ad.getAllWrapperLinearClickTrackingUris()).execute();
                    new LaunchBrowserCommand((Context)VastPlayer.this.activity, VastPlayer.this.currentLinearCreative.getClickThroughUri()).execute();
                }
                return true;
            }
        });
    }

    private void showNextCompanionAdsCreative(CompanionAdsCreative companionAdsCreative) {
        this.vastVideoView.setVisibility(4);
        this.nonLinearWebView.setVisibility(4);
        this.companionAdsPlayer = new CompanionAdsPlayer((Context)this.activity, companionAdsCreative, (CompanionAdListener)new 7(this));
        this.masterFrameLayout.addView((View)this.companionAdsPlayer);
    }

    private void startVastVideoView() {
        this.vastVideoView.start();
    }

    private void startVideoTimer() {
        new Thread(new Runnable(){

            /*
             * Exception decompiling
             */
            public void run() {
                // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl243.3 : FAKE_TRY : trying to set 1 previously set to 0
                // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
                // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
                // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
                // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
                // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
                // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
                // org.benf.cfr.reader.entities.g.p(Method.java:396)
                // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
                // org.benf.cfr.reader.entities.d.c(ClassFile.java:773)
                // org.benf.cfr.reader.entities.d.e(ClassFile.java:870)
                // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
                // org.benf.cfr.reader.b.a(Driver.java:128)
                // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
                // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
                // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
                // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
                // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
                // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
                // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
                // java.lang.Thread.run(Thread.java:919)
                throw new IllegalStateException("Decompilation failed");
            }
        }).start();
    }

    private boolean stillPlaying() {
        boolean bl;
        bl = true;
        try {
            int n = this.vastVideoView.getCurrentPosition();
            int n2 = this.vastVideoView.getDuration();
            if (n < n2) {
                return bl;
            }
            bl = false;
        }
        catch (Exception exception) {}
        return bl;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void close() {
        if (this.vastVideoView != null) {
            Object object;
            Object object2 = object = this.videoTimerMonitor;
            synchronized (object2) {
                this.killTimer = true;
            }
            new FireEventCommand(this.currentLinearCreative.getTrackingEventsByEventType(EventType.CLOSE)).execute();
            new FireEventCommand(this.ad.getAllWrapperLinearCreativeTrackingEventsByType(EventType.CLOSE)).execute();
        }
        MoatUtils.cleanup(this.controllerId);
    }

    public VASTProviderAd getAd() {
        return this.ad;
    }

    public LinearCreative getCurrentLinearCreative() {
        return this.currentLinearCreative;
    }

    public RelativeLayout getMasterFrameLayout() {
        return this.masterFrameLayout;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void kill() {
        if (this.vastVideoView != null) {
            Object object;
            Object object2 = object = this.videoTimerMonitor;
            synchronized (object2) {
                this.killTimer = true;
            }
        }
        this.masterFrameLayout.removeAllViews();
        SkipButton skipButton = this.skipButton;
        if (skipButton != null) {
            skipButton.cleanup();
            this.skipButton = null;
        }
        this.videoControls = null;
        IconsPlayer iconsPlayer = this.iconsPlayer;
        if (iconsPlayer != null) {
            iconsPlayer.destroy();
            this.iconsPlayer = null;
        }
        this.vastPlayerListener = null;
        this.mediaPlayer = null;
        MoatUtils.cleanup(this.controllerId);
    }

    public void mute() {
        if (this.mediaPlayer != null) {
            this.isMuted = true;
            this.mediaPlayer.setVolume(0.0f, 0.0f);
            try {
                this.mediaPlayer.setVolume(0.0f, 0.0f);
                return;
            }
            catch (Exception exception) {
                String string = LOG_TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Exception setting volumn to 0: ");
                stringBuilder.append(exception.getMessage());
                AerServLog.e(string, stringBuilder.toString());
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void pause() {
        CompanionAdsPlayer companionAdsPlayer;
        if (this.vastVideoView != null) {
            Object object;
            Object object2 = object = this.videoTimerMonitor;
            synchronized (object2) {
                this.killTimer = true;
            }
            this.currVidPos = this.vastVideoView.getCurrentPosition();
            this.pauseVastVideoView();
            new FireEventCommand(this.currentLinearCreative.getTrackingEventsByEventType(EventType.PAUSE)).execute();
            new FireEventCommand(this.ad.getAllWrapperLinearCreativeTrackingEventsByType(EventType.PAUSE)).execute();
        }
        if ((companionAdsPlayer = this.companionAdsPlayer) != null) {
            companionAdsPlayer.pause();
        }
    }

    public void play() {
        this.showNextCreative();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void resume() {
        CompanionAdsPlayer companionAdsPlayer;
        if (this.vastVideoView != null) {
            Object object;
            Object object2 = object = this.videoTimerMonitor;
            synchronized (object2) {
                this.killTimer = false;
            }
            this.vastVideoView.seekTo(this.currVidPos);
            this.startVastVideoView();
            this.startVideoTimer();
            new FireEventCommand(this.currentLinearCreative.getTrackingEventsByEventType(EventType.RESUME)).execute();
            new FireEventCommand(this.ad.getAllWrapperLinearCreativeTrackingEventsByType(EventType.RESUME)).execute();
        }
        if ((companionAdsPlayer = this.companionAdsPlayer) != null) {
            companionAdsPlayer.resume();
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void showNextCreative() {
        MediaFile mediaFile;
        block20 : {
            MediaFile mediaFile2;
            Object object;
            this.hasPassedCloseOffset = false;
            this.onPreparedFired = false;
            Object object2 = object = this.videoTimerMonitor;
            // MONITORENTER : object2
            if (this.killTimer) {
                // MONITOREXIT : object2
                return;
            }
            // MONITOREXIT : object2
            PlayableAd playableAd = this.currentAd;
            if ((playableAd == null || playableAd.getPlayableVastCreatives().size() == 0) && this.adsToPlay.size() == 0) {
                Object object3;
                if (this.atLeastOneAdPlayed) {
                    this.vastPlayerListener.onSuccess(this.wasAtLeastOneAdSkipped);
                } else {
                    this.vastPlayerListener.onFailure("No ads played");
                }
                Object object4 = object3 = this.videoTimerMonitor;
                // MONITORENTER : object4
                this.killTimer = true;
                // MONITOREXIT : object4
                return;
            }
            PlayableAd playableAd2 = this.currentAd;
            if (playableAd2 == null || playableAd2.getPlayableVastCreatives().size() == 0) {
                this.currentAd = (PlayableAd)this.adsToPlay.pop();
                this.adSequence = this.adCount - this.adsToPlay.size();
            }
            if (this.currentAd.getPlayableVastCreatives().isEmpty()) {
                this.showNextCreative();
                return;
            }
            this.currentCreative = (Creative)this.currentAd.getPlayableVastCreatives().pop();
            Creative creative = this.currentCreative;
            if (creative instanceof CompanionAdsCreative) {
                if (this.isBanner) {
                    AerServLog.d(LOG_TAG, "Banner does not support companion ads.  Showing next creative.");
                    this.showNextCreative();
                    return;
                }
                if (this.adsToPlay.size() > 0) {
                    AerServLog.d(LOG_TAG, "Cannot show companion ads between ad pods.  Showing next creative.");
                    this.showNextCreative();
                    return;
                }
                this.showNextCompanionAdsCreative((CompanionAdsCreative)this.currentCreative);
                return;
            }
            this.currentLinearCreative = (LinearCreative)creative;
            Iterator iterator = this.currentLinearCreative.getMediaFiles().iterator();
            do {
                boolean bl = iterator.hasNext();
                mediaFile = null;
                if (!bl) break block20;
                mediaFile2 = (MediaFile)iterator.next();
                String string = LOG_TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("MediaFile mime type found: ");
                stringBuilder.append(mediaFile2.getMimeType());
                AerServLog.v(string, stringBuilder.toString());
            } while (!supportedMimeTypesSet.contains((Object)mediaFile2.getMimeType()));
            mediaFile = mediaFile2;
        }
        if (mediaFile == null) {
            String string = this.getClass().getName();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Could not find a playable mimetype in MediaFiles for this Creative.  Supported are: ");
            stringBuilder.append(supportedMimeTypesSet);
            AerServLog.d(string, stringBuilder.toString());
            this.showNextCreative();
            return;
        }
        this.vastPlayerListener.onMediaFileFound(mediaFile);
        if ("text/html".equals((Object)mediaFile.getMimeType())) {
            this.vastVideoView.setVisibility(4);
            this.nonLinearWebView.setVisibility(4);
            FrameLayout.LayoutParams layoutParams = this.getLinearWebViewEndCardLayoutParams(mediaFile);
            this.linearWebView.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
            this.linearWebView.setVisibility(0);
            this.linearWebView.loadUrl(mediaFile.getMediaUri());
            this.linearWebView.bringToFront();
            return;
        }
        this.allProgressEvents = new TrackingEvents();
        this.allProgressEvents.addAll((Collection)this.currentLinearCreative.getTrackingEventsByEventType(EventType.START));
        this.allProgressEvents.addAll((Collection)this.currentLinearCreative.getTrackingEventsByEventType(EventType.FIRST_QUARTILE));
        this.allProgressEvents.addAll((Collection)this.currentLinearCreative.getTrackingEventsByEventType(EventType.MID_POINT));
        this.allProgressEvents.addAll((Collection)this.currentLinearCreative.getTrackingEventsByEventType(EventType.THIRD_QUARTILE));
        this.allProgressEvents.addAll((Collection)this.currentLinearCreative.getTrackingEventsByEventType(EventType.PROGRESS));
        this.allProgressEvents.addAll((Collection)this.ad.getAllWrapperLinearCreativeTrackingEventsByType(EventType.START));
        this.allProgressEvents.addAll((Collection)this.ad.getAllWrapperLinearCreativeTrackingEventsByType(EventType.FIRST_QUARTILE));
        this.allProgressEvents.addAll((Collection)this.ad.getAllWrapperLinearCreativeTrackingEventsByType(EventType.MID_POINT));
        this.allProgressEvents.addAll((Collection)this.ad.getAllWrapperLinearCreativeTrackingEventsByType(EventType.THIRD_QUARTILE));
        this.allProgressEvents.addAll((Collection)this.ad.getAllWrapperLinearCreativeTrackingEventsByType(EventType.PROGRESS));
        this.allImpressionEvents = new ArrayList();
        this.allImpressionEvents.addAll((Collection)this.currentAd.getInlineAd().getImpressionUris());
        this.allImpressionEvents.addAll((Collection)this.ad.getAllWrapperImpressionUris());
        this.nonLinearWebView.setVisibility(4);
        this.linearWebView.setVisibility(4);
        String string = VideoFileCache.getCachedPath((Context)this.activity, mediaFile.getMediaUri());
        if (string != null) {
            String string2 = this.getClass().getName();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Using local file for VAST video at ");
            stringBuilder.append(string);
            AerServLog.d(string2, stringBuilder.toString());
            this.vastVideoView.setVideoPath(string);
        } else {
            AerServLog.d(this.getClass().getName(), "Using remote file for VAST video");
            this.vastVideoView.setVideoURI(Uri.parse((String)mediaFile.getMediaUri()));
        }
        this.quartiles.clear();
        this.quartiles.push((Object)AerServEvent.VIDEO_75);
        this.quartiles.push((Object)AerServEvent.VIDEO_50);
        this.quartiles.push((Object)AerServEvent.VIDEO_25);
        this.quartiles.push((Object)AerServEvent.VIDEO_START);
        this.vastVideoView.bringToFront();
        this.iconsPlayer = new IconsPlayer((Context)this.activity, this.currentLinearCreative.getIcons(), (IconsListener)new 8(this));
        this.masterFrameLayout.addView((View)this.iconsPlayer);
        this.startVastVideoView();
        return;
        {
            catch (Throwable throwable) {}
            {
                // MONITOREXIT : object2
                throw throwable;
            }
        }
    }

    public void unmute() {
        if (this.mediaPlayer != null) {
            this.isMuted = false;
            this.mediaPlayer.setVolume(1.0f, 1.0f);
            try {
                this.mediaPlayer.setVolume(1.0f, 1.0f);
                return;
            }
            catch (Exception exception) {
                String string = LOG_TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Exception setting volumn to 1: ");
                stringBuilder.append(exception.getMessage());
                AerServLog.e(string, stringBuilder.toString());
            }
        }
    }

}


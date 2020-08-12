/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.annotation.TargetApi
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.ColorStateList
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.media.MediaPlayer
 *  android.media.MediaPlayer$OnCompletionListener
 *  android.media.MediaPlayer$OnErrorListener
 *  android.media.MediaPlayer$OnPreparedListener
 *  android.net.Uri
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.StrictMode
 *  android.os.StrictMode$ThreadPolicy
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.view.Display
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnTouchListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewParent
 *  android.view.Window
 *  android.view.WindowManager
 *  android.view.animation.AlphaAnimation
 *  android.view.animation.Animation
 *  android.view.animation.Animation$AnimationListener
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.ImageView
 *  android.widget.ImageView$ScaleType
 *  android.widget.ProgressBar
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  com.applovin.impl.a.a
 *  com.applovin.impl.sdk.ad.a
 *  com.applovin.impl.sdk.ad.g
 *  java.lang.Boolean
 *  java.lang.Double
 *  java.lang.Exception
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.lang.ref.WeakReference
 *  java.util.concurrent.TimeUnit
 *  java.util.concurrent.atomic.AtomicBoolean
 */
package com.applovin.impl.adview;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.applovin.adview.AdViewController;
import com.applovin.adview.AppLovinAdView;
import com.applovin.impl.a.j;
import com.applovin.impl.adview.AdViewControllerImpl;
import com.applovin.impl.adview.AppLovinTouchToClickListener;
import com.applovin.impl.adview.AppLovinVideoView;
import com.applovin.impl.adview.a;
import com.applovin.impl.adview.c;
import com.applovin.impl.adview.e;
import com.applovin.impl.adview.g;
import com.applovin.impl.adview.h;
import com.applovin.impl.adview.i;
import com.applovin.impl.adview.k;
import com.applovin.impl.adview.l;
import com.applovin.impl.adview.n;
import com.applovin.impl.adview.q;
import com.applovin.impl.adview.r;
import com.applovin.impl.adview.s;
import com.applovin.impl.adview.t;
import com.applovin.impl.sdk.AppLovinAdServiceImpl;
import com.applovin.impl.sdk.ad.g;
import com.applovin.impl.sdk.b.b;
import com.applovin.impl.sdk.c.d;
import com.applovin.impl.sdk.d.aa;
import com.applovin.impl.sdk.d.q;
import com.applovin.impl.sdk.e.m;
import com.applovin.impl.sdk.o;
import com.applovin.impl.sdk.p;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkSettings;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class k
extends Activity
implements i {
    public static final String KEY_WRAPPER_ID = "com.applovin.interstitial.wrapper_id";
    public static volatile l lastKnownWrapper;
    private g A;
    private View B;
    private g C;
    private View D;
    private e E;
    private ImageView F;
    private WeakReference<MediaPlayer> G = new WeakReference(null);
    private com.applovin.impl.sdk.a.d H;
    private s I;
    private ProgressBar J;
    private t.a K;
    private a L;
    private com.applovin.impl.sdk.e.k M;
    private AppLovinAdView a;
    private l b;
    private volatile boolean c = false;
    protected int computedLengthSeconds = 0;
    protected h countdownManager;
    public volatile com.applovin.impl.sdk.ad.g currentAd;
    public String currentPlacement;
    private d d;
    private volatile boolean e = false;
    private volatile boolean f = false;
    private volatile boolean g = false;
    private volatile boolean h = false;
    private volatile boolean i = false;
    private volatile boolean j = false;
    private volatile boolean k = false;
    private volatile boolean l = false;
    public p logger;
    private boolean m = false;
    private volatile boolean n = false;
    private boolean o = true;
    private boolean p = false;
    protected volatile boolean poststitialWasDisplayed = false;
    private boolean q = false;
    private long r = 0L;
    private long s = 0L;
    public com.applovin.impl.sdk.j sdk;
    private int t = 0;
    private int u = Integer.MIN_VALUE;
    private AtomicBoolean v = new AtomicBoolean(false);
    protected volatile boolean videoMuted = false;
    public r videoView;
    private AtomicBoolean w = new AtomicBoolean(false);
    private Handler x;
    private Handler y;
    private FrameLayout z;

    private void A() {
        a a2 = this.L;
        if (a2 != null) {
            a2.b();
        }
    }

    private void B() {
        if (this.D()) {
            this.N();
            this.pauseReportRewardTask();
            this.logger.a("InterActivity", "Prompting incentivized ad close warning");
            this.H.b();
            return;
        }
        this.skipVideo();
    }

    static /* synthetic */ s C(k k2) {
        return k2.I;
    }

    private void C() {
        if (this.E()) {
            this.logger.a("InterActivity", "Prompting incentivized non-video ad close warning");
            this.H.c();
            return;
        }
        this.dismiss();
    }

    private boolean D() {
        return this.H() && !this.isFullyWatched() && this.sdk.a(b.bM) != false && this.H != null;
    }

    private boolean E() {
        return this.I() && !this.G() && this.sdk.a(b.bR) != false && this.H != null;
    }

    private int F() {
        if (this.currentAd instanceof com.applovin.impl.sdk.ad.a) {
            float f2 = ((com.applovin.impl.sdk.ad.a)this.currentAd).i();
            if (!(f2 > 0.0f)) {
                f2 = this.currentAd.o();
            }
            double d2 = m.a(System.currentTimeMillis() - this.r);
            double d3 = f2;
            Double.isNaN((double)d3);
            return (int)Math.min((double)(100.0 * (d2 / d3)), (double)100.0);
        }
        return 0;
    }

    static /* synthetic */ AppLovinAdView F(k k2) {
        return k2.a;
    }

    static /* synthetic */ void G(k k2) {
        k2.P();
    }

    private boolean G() {
        return this.F() >= this.currentAd.Q();
    }

    private boolean H() {
        return AppLovinAdType.INCENTIVIZED.equals(this.currentAd.getType());
    }

    private boolean I() {
        return !this.currentAd.hasVideoUrl() && this.H();
    }

    /*
     * Enabled aggressive block sorting
     */
    private void J() {
        block7 : {
            long l2;
            block9 : {
                long l3;
                block11 : {
                    long l4;
                    block14 : {
                        int n2;
                        block12 : {
                            com.applovin.impl.sdk.ad.a a2;
                            block13 : {
                                block10 : {
                                    block8 : {
                                        long l5;
                                        if (this.currentAd == null || (l5 = this.currentAd.aa()) < (l3 = 0L) && this.currentAd.ab() < 0 || this.M != null) break block7;
                                        if (this.currentAd.aa() < l3) break block8;
                                        l2 = this.currentAd.aa();
                                        break block9;
                                    }
                                    if (!this.isVastAd()) break block10;
                                    com.applovin.impl.a.a a3 = (com.applovin.impl.a.a)this.currentAd;
                                    j j2 = a3.a();
                                    if (j2 != null && j2.b() > 0) {
                                        l3 += TimeUnit.SECONDS.toMillis((long)j2.b());
                                    } else {
                                        int n3 = this.videoView.getDuration();
                                        if (n3 > 0) {
                                            l3 += (long)n3;
                                        }
                                    }
                                    if (!a3.ac() || (n2 = (int)a3.o()) <= 0) break block11;
                                    break block12;
                                }
                                if (!(this.currentAd instanceof com.applovin.impl.sdk.ad.a)) break block11;
                                a2 = (com.applovin.impl.sdk.ad.a)this.currentAd;
                                int n4 = this.videoView.getDuration();
                                if (n4 > 0) {
                                    l3 += (long)n4;
                                }
                                if (!a2.ac()) break block11;
                                int n5 = (int)a2.i();
                                if (n5 <= 0) break block13;
                                l4 = TimeUnit.SECONDS.toMillis((long)n5);
                                break block14;
                            }
                            n2 = (int)a2.o();
                            if (n2 <= 0) break block11;
                        }
                        l4 = TimeUnit.SECONDS.toMillis((long)n2);
                    }
                    l3 += l4;
                }
                double d2 = l3;
                double d3 = this.currentAd.ab();
                Double.isNaN((double)d3);
                double d4 = d3 / 100.0;
                Double.isNaN((double)d2);
                l2 = (long)(d2 * d4);
            }
            p p2 = this.logger;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Scheduling report reward in ");
            stringBuilder.append(TimeUnit.MILLISECONDS.toSeconds(l2));
            stringBuilder.append(" seconds...");
            p2.a("InterActivity", stringBuilder.toString());
            this.M = com.applovin.impl.sdk.e.k.a(l2, this.sdk, new Runnable(this){
                final /* synthetic */ k a;
                {
                    this.a = k2;
                }

                public void run() {
                    if (this.a.currentAd != null && !this.a.currentAd.ad().getAndSet(true)) {
                        com.applovin.impl.sdk.d.x x2 = new com.applovin.impl.sdk.d.x(this.a.currentAd, this.a.sdk);
                        this.a.sdk.C().a((com.applovin.impl.sdk.d.a)x2, q.a.h);
                    }
                }
            });
        }
    }

    private void K() {
        if (!this.c || this.q) {
            AppLovinAdView appLovinAdView = this.a;
            if (appLovinAdView != null) {
                g g2;
                View view;
                appLovinAdView.setAdDisplayListener(new AppLovinAdDisplayListener(){

                    @Override
                    public void adDisplayed(AppLovinAd appLovinAd) {
                        if (!k.this.g) {
                            k.this.a(appLovinAd);
                        }
                    }

                    @Override
                    public void adHidden(AppLovinAd appLovinAd) {
                        k.this.b(appLovinAd);
                    }
                });
                this.a.setAdClickListener(new AppLovinAdClickListener(){

                    @Override
                    public void adClicked(AppLovinAd appLovinAd) {
                        com.applovin.impl.sdk.e.h.a(k.this.b.e(), appLovinAd, k.this.sdk);
                    }
                });
                this.currentAd = (com.applovin.impl.sdk.ad.g)this.b.b();
                if (this.w.compareAndSet(false, true)) {
                    this.sdk.n().trackImpression(this.currentAd, this.currentPlacement);
                    this.currentAd.setHasShown(true);
                }
                this.a(this.currentAd);
                this.k();
                if (this.currentAd.isVideoAd()) {
                    StringBuilder stringBuilder;
                    p p2;
                    String string;
                    this.n = this.currentAd.b();
                    if (this.n) {
                        p2 = this.logger;
                        stringBuilder = new StringBuilder();
                        string = "Preparing stream for ";
                    } else {
                        p2 = this.logger;
                        stringBuilder = new StringBuilder();
                        string = "Preparing cached video playback for ";
                    }
                    stringBuilder.append(string);
                    stringBuilder.append((Object)this.currentAd.e());
                    p2.a("InterActivity", stringBuilder.toString());
                    d d2 = this.d;
                    if (d2 != null) {
                        long l2 = this.n ? 1L : 0L;
                        d2.b(l2);
                    }
                }
                this.videoMuted = this.j();
                Uri uri = this.currentAd.e();
                this.a(uri);
                if (uri == null) {
                    this.J();
                }
                this.A.bringToFront();
                if (this.o() && (view = this.B) != null) {
                    view.bringToFront();
                }
                if ((g2 = this.C) != null) {
                    g2.bringToFront();
                }
                if (!this.currentAd.al() && !this.currentAd.am()) {
                    this.a.renderAd((AppLovinAd)this.currentAd, this.currentPlacement);
                }
                this.b.a(true);
                if (!this.currentAd.hasVideoUrl()) {
                    if (this.I() && this.sdk.a(b.bY).booleanValue()) {
                        this.d((AppLovinAd)this.currentAd);
                    }
                    this.showPoststitial();
                    return;
                }
            } else {
                this.exitWithError("AdView was null");
            }
        }
    }

    private void L() {
        if (this.videoView != null) {
            this.t = this.getVideoPercentViewed();
            this.videoView.stopPlayback();
        }
    }

    private boolean M() {
        return this.videoMuted;
    }

    private void N() {
        r r2 = this.videoView;
        int n2 = r2 != null ? r2.getCurrentPosition() : 0;
        this.sdk.a(com.applovin.impl.sdk.b.d.n, n2);
        this.sdk.a(com.applovin.impl.sdk.b.d.o, true);
        try {
            this.countdownManager.c();
        }
        catch (Throwable throwable) {
            this.logger.b("InterActivity", "Unable to pause countdown timers", throwable);
        }
        this.videoView.pause();
    }

    private void O() {
        long l2 = Math.max((long)0L, (long)this.sdk.a(b.dy));
        if (l2 > 0L) {
            p p2 = this.sdk.u();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Resuming video with delay of ");
            stringBuilder.append(l2);
            p2.a("InterActivity", stringBuilder.toString());
            this.y.postDelayed(new Runnable(this){
                final /* synthetic */ k a;
                {
                    this.a = k2;
                }

                public void run() {
                    k.G(this.a);
                }
            }, l2);
            return;
        }
        this.sdk.u().a("InterActivity", "Resuming video immediately");
        this.P();
    }

    private void P() {
        r r2;
        if (!this.poststitialWasDisplayed && (r2 = this.videoView) != null && !r2.isPlaying()) {
            int n2 = this.videoView.getDuration();
            int n3 = this.sdk.b(com.applovin.impl.sdk.b.d.n, n2);
            this.videoView.seekTo(n3);
            this.videoView.start();
            this.countdownManager.a();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private void Q() {
        boolean bl;
        if (this.j) {
            return;
        }
        if (this.currentAd.hasVideoUrl()) {
            int n2 = this.getVideoPercentViewed();
            this.sdk.n().trackVideoEnd(this.currentAd, this.currentPlacement, n2, this.n);
            this.a((AppLovinAd)this.currentAd, n2, this.isFullyWatched());
            if (this.d == null) return;
            this.d.c(n2);
            return;
        }
        if (!(this.currentAd instanceof com.applovin.impl.sdk.ad.a)) return;
        if (!this.I()) return;
        if (this.sdk.a(b.bY) == false) return;
        int n3 = this.F();
        p p2 = this.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Rewarded playable engaged at ");
        stringBuilder.append(n3);
        stringBuilder.append(" percent");
        p2.a("InterActivity", stringBuilder.toString());
        com.applovin.impl.sdk.ad.g g2 = this.currentAd;
        double d2 = n3;
        try {
            bl = n3 >= this.currentAd.Q();
        }
        catch (Throwable throwable) {
            p p3 = this.logger;
            if (p3 == null) return;
            p3.b("InterActivity", "Failed to notify end listener.", throwable);
        }
        return;
        this.a((AppLovinAd)g2, d2, bl);
    }

    private int a(int n2) {
        return AppLovinSdkUtils.dpToPx((Context)this, n2);
    }

    private int a(int n2, boolean bl) {
        if (bl) {
            if (n2 == 0) {
                return 0;
            }
            if (n2 == 1) {
                return 9;
            }
            if (n2 == 2) {
                return 8;
            }
            if (n2 == 3) {
                return 1;
            }
        } else {
            if (n2 == 0) {
                return 1;
            }
            if (n2 == 1) {
                return 0;
            }
            if (n2 == 2) {
                return 9;
            }
            if (n2 == 3) {
                return 8;
            }
        }
        return -1;
    }

    private static int a(Display display) {
        if (display.getWidth() == display.getHeight()) {
            return 3;
        }
        if (display.getWidth() < display.getHeight()) {
            return 1;
        }
        return 2;
    }

    static /* synthetic */ WeakReference a(k k2, WeakReference weakReference) {
        k2.G = weakReference;
        return weakReference;
    }

    private void a(long l2, g g2) {
        this.y.postDelayed(new Runnable(this, g2){
            final /* synthetic */ g a;
            final /* synthetic */ k b;
            {
                this.b = k2;
                this.a = g2;
            }

            public void run() {
                if (this.a.equals((Object)((Object)k.q(this.b)))) {
                    k.x(this.b);
                    return;
                }
                if (this.a.equals((Object)((Object)k.r(this.b)))) {
                    k.y(this.b);
                }
            }
        }, l2);
    }

    private void a(Uri uri) {
        r r2 = this.currentAd.au() ? new n(this.sdk, (Context)this, new Runnable(this){
            final /* synthetic */ k a;
            {
                this.a = k2;
            }

            public void run() {
                this.a.handleMediaError();
            }
        }) : new AppLovinVideoView((Context)this, this.sdk);
        this.videoView = r2;
        if (uri != null) {
            this.videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener(this){
                final /* synthetic */ k a;
                {
                    this.a = k2;
                }

                public void onPrepared(MediaPlayer mediaPlayer) {
                    k.a(this.a, new WeakReference((Object)mediaPlayer));
                    boolean bl = k.b(this.a);
                    float f2 = (float)(bl ^ true);
                    mediaPlayer.setVolume(f2, f2);
                    if (k.c(this.a) != null) {
                        d d2 = k.c(this.a);
                        long l2 = bl ? 1L : 0L;
                        d2.e(l2);
                    }
                    int n2 = mediaPlayer.getVideoWidth();
                    int n3 = mediaPlayer.getVideoHeight();
                    this.a.computedLengthSeconds = (int)TimeUnit.MILLISECONDS.toSeconds((long)mediaPlayer.getDuration());
                    this.a.videoView.setVideoSize(n2, n3);
                    if (this.a.videoView instanceof AppLovinVideoView) {
                        mediaPlayer.setDisplay(((AppLovinVideoView)this.a.videoView).getHolder());
                    }
                    mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener(this){
                        final /* synthetic */ 22 a;
                        {
                            this.a = var1_1;
                        }

                        public boolean onError(MediaPlayer mediaPlayer, int n2, int n3) {
                            k.d(this.a.a).post(new Runnable(this, n2, n3){
                                final /* synthetic */ int a;
                                final /* synthetic */ int b;
                                final /* synthetic */ com.applovin.impl.adview.k$22$1 c;
                                {
                                    this.c = var1_1;
                                    this.a = n2;
                                    this.b = n3;
                                }

                                public void run() {
                                    p p2 = this.c.a.a.logger;
                                    StringBuilder stringBuilder = new StringBuilder();
                                    stringBuilder.append("Media player error (");
                                    stringBuilder.append(this.a);
                                    stringBuilder.append(",");
                                    stringBuilder.append(this.b);
                                    stringBuilder.append(").");
                                    p2.d("InterActivity", stringBuilder.toString());
                                    this.c.a.a.handleMediaError();
                                }
                            });
                            return true;
                        }
                    });
                    mediaPlayer.setOnInfoListener(new android.media.MediaPlayer$OnInfoListener(this){
                        final /* synthetic */ 22 a;
                        {
                            this.a = var1_1;
                        }

                        /*
                         * Enabled aggressive block sorting
                         */
                        public boolean onInfo(MediaPlayer mediaPlayer, int n2, int n3) {
                            if (n2 != 3) {
                                if (n2 == 701) {
                                    k.f(this.a.a);
                                    return false;
                                }
                                if (n2 != 702) return false;
                            }
                            k.e(this.a.a);
                            return false;
                        }
                    });
                    if (k.g(this.a) == 0L) {
                        k.h(this.a);
                        k.i(this.a);
                        k.j(this.a);
                        k.k(this.a);
                        this.a.playVideo();
                        k.l(this.a);
                    }
                }
            });
            this.videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener(this){
                final /* synthetic */ k a;
                {
                    this.a = k2;
                }

                public void onCompletion(MediaPlayer mediaPlayer) {
                    k.m(this.a);
                }
            });
            this.videoView.setOnErrorListener(new MediaPlayer.OnErrorListener(this){
                final /* synthetic */ k a;
                {
                    this.a = k2;
                }

                public boolean onError(MediaPlayer mediaPlayer, int n2, int n3) {
                    k.d(this.a).post(new Runnable(this, n2, n3){
                        final /* synthetic */ int a;
                        final /* synthetic */ int b;
                        final /* synthetic */ 24 c;
                        {
                            this.c = var1_1;
                            this.a = n2;
                            this.b = n3;
                        }

                        public void run() {
                            p p2 = this.c.a.logger;
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Video view error (");
                            stringBuilder.append(this.a);
                            stringBuilder.append(",");
                            stringBuilder.append(this.b);
                            stringBuilder.append(").");
                            p2.d("InterActivity", stringBuilder.toString());
                            this.c.a.handleMediaError();
                        }
                    });
                    return true;
                }
            });
            if (this.sdk.a(b.fq).booleanValue()) {
                aa aa2 = new aa(this.sdk, new Runnable(this, uri){
                    final /* synthetic */ Uri a;
                    final /* synthetic */ k b;
                    {
                        this.b = k2;
                        this.a = uri;
                    }

                    public void run() {
                        this.b.videoView.setVideoURI(this.a);
                    }
                });
                this.sdk.C().a(aa2, q.a.a);
            } else {
                StrictMode.ThreadPolicy threadPolicy = StrictMode.allowThreadDiskReads();
                this.videoView.setVideoURI(uri);
                StrictMode.setThreadPolicy((StrictMode.ThreadPolicy)threadPolicy);
            }
        }
        this.videoView.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1, 17));
        this.videoView.setOnTouchListener(new AppLovinTouchToClickListener((Context)this, new View.OnClickListener(this){
            final /* synthetic */ k a;
            {
                this.a = k2;
            }

            public void onClick(View view) {
                k.n(this.a);
            }
        }));
        this.z.addView((View)this.videoView);
        this.setContentView((View)this.z);
        this.q();
        this.y();
    }

    private void a(View view, boolean bl, long l2) {
        float f2 = bl ? 0.0f : 1.0f;
        float f3 = 0.0f;
        if (bl) {
            f3 = 1.0f;
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(f2, f3);
        alphaAnimation.setDuration(l2);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener(this, view, bl){
            final /* synthetic */ View a;
            final /* synthetic */ boolean b;
            final /* synthetic */ k c;
            {
                this.c = k2;
                this.a = view;
                this.b = bl;
            }

            public void onAnimationEnd(Animation animation) {
                if (!this.b) {
                    this.a.setVisibility(4);
                }
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
                this.a.setVisibility(0);
            }
        });
        view.startAnimation((Animation)alphaAnimation);
    }

    static /* synthetic */ void a(k k2) {
        k2.b();
    }

    static /* synthetic */ void a(k k2, View view, boolean bl, long l2) {
        k2.a(view, bl, l2);
    }

    private void a(com.applovin.impl.sdk.ad.g g2) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.z = new FrameLayout((Context)this);
        this.z.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
        this.z.setBackgroundColor(g2.D());
        this.y = new Handler();
        this.x = new Handler();
        this.countdownManager = new h(this.x, this.sdk);
    }

    private void a(AppLovinAd appLovinAd) {
        com.applovin.impl.sdk.e.h.a(this.b.d(), appLovinAd, this.sdk);
        this.g = true;
        this.sdk.R().c();
        AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable(this){
            final /* synthetic */ k a;
            {
                this.a = k2;
            }

            public void run() {
                k k2 = this.a;
                k.d(k2, k2.videoMuted);
            }
        }, this.sdk.a(b.dC));
    }

    private void a(AppLovinAd appLovinAd, double d2, boolean bl) {
        this.j = true;
        com.applovin.impl.sdk.e.h.a(this.b.c(), appLovinAd, d2, bl, this.sdk);
    }

    private void a(boolean bl) {
        Uri uri = bl ? this.currentAd.av() : this.currentAd.aw();
        int n2 = this.a(this.sdk.a(b.dr));
        StrictMode.ThreadPolicy threadPolicy = StrictMode.allowThreadDiskReads();
        AppLovinSdkUtils.safePopulateImageView(this.F, uri, n2);
        StrictMode.setThreadPolicy((StrictMode.ThreadPolicy)threadPolicy);
    }

    private boolean a() {
        int n2 = this.getResources().getIdentifier(this.sdk.a(b.dk), "bool", "android");
        return n2 > 0 && this.getResources().getBoolean(n2);
    }

    static /* synthetic */ boolean a(k k2, boolean bl) {
        k2.k = bl;
        return bl;
    }

    @TargetApi(value=16)
    private void b() {
        this.getWindow().getDecorView().setSystemUiVisibility(5894);
    }

    private void b(int n2) {
        try {
            this.setRequestedOrientation(n2);
            return;
        }
        catch (Throwable throwable) {
            this.sdk.u().b("InterActivity", "Failed to set requested orientation", throwable);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private void b(int n2, boolean bl) {
        block16 : {
            int n3;
            block18 : {
                block22 : {
                    boolean bl2;
                    block23 : {
                        block21 : {
                            block20 : {
                                block13 : {
                                    block19 : {
                                        block17 : {
                                            block15 : {
                                                block14 : {
                                                    bl2 = this.sdk.a(b.di);
                                                    if (this.b.f() != g.b.b) break block13;
                                                    n3 = 9;
                                                    if (!bl) break block14;
                                                    if (n2 != 1 && n2 != 3) break block15;
                                                    if (!bl2) break block16;
                                                    if (n2 != 1) break block17;
                                                    break block18;
                                                }
                                                if (n2 == 0 || n2 == 2) break block19;
                                            }
                                            this.c = true;
                                        }
                                        this.b(1);
                                        return;
                                    }
                                    if (!bl2) break block16;
                                    if (n2 == 0) {
                                        n3 = 1;
                                    }
                                    break block18;
                                }
                                if (this.b.f() != g.b.c) break block16;
                                n3 = 8;
                                if (!bl) break block20;
                                if (n2 != 0 && n2 != 2) break block21;
                                if (!bl2) break block16;
                                if (n2 != 2) break block22;
                                break block18;
                            }
                            if (n2 == 1 || n2 == 3) break block23;
                        }
                        this.c = true;
                        this.b(0);
                        return;
                    }
                    if (!bl2) break block16;
                    if (n2 != 1) break block18;
                }
                n3 = 0;
            }
            this.b(n3);
            return;
        }
    }

    private void b(AppLovinAd appLovinAd) {
        this.dismiss();
        this.c(appLovinAd);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void b(boolean bl) {
        c c2;
        if (this.currentAd.S() && (c2 = ((AdViewControllerImpl)this.a.getAdViewController()).getAdWebView()) != null) {
            String string = bl ? "javascript:al_mute();" : "javascript:al_unmute();";
            try {
                c2.a(string);
                return;
            }
            catch (Throwable throwable) {
                this.logger.b("InterActivity", "Unable to forward mute setting to template.", throwable);
            }
        }
    }

    static /* synthetic */ boolean b(k k2) {
        return k2.j();
    }

    static /* synthetic */ boolean b(k k2, boolean bl) {
        k2.l = bl;
        return bl;
    }

    static /* synthetic */ d c(k k2) {
        return k2.d;
    }

    private void c(AppLovinAd appLovinAd) {
        if (!this.h) {
            this.h = true;
            l l2 = this.b;
            if (l2 != null) {
                com.applovin.impl.sdk.e.h.b(l2.d(), appLovinAd, this.sdk);
            }
            this.sdk.R().d();
        }
    }

    private void c(boolean bl) {
        this.videoMuted = bl;
        MediaPlayer mediaPlayer = (MediaPlayer)this.G.get();
        if (mediaPlayer != null) {
            boolean bl2 = !bl;
            float f2 = (float)bl2;
            try {
                mediaPlayer.setVolume(f2, f2);
                return;
            }
            catch (IllegalStateException illegalStateException) {
                p p2 = this.logger;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Failed to set MediaPlayer muted: ");
                stringBuilder.append(bl);
                p2.b("InterActivity", stringBuilder.toString(), illegalStateException);
            }
        }
    }

    private boolean c() {
        if (this.b != null) {
            com.applovin.impl.sdk.j j2 = this.sdk;
            if (j2 == null) {
                return true;
            }
            if (j2.a(b.dc).booleanValue()) {
                return true;
            }
            if (this.sdk.a(b.dd).booleanValue() && this.k) {
                return true;
            }
            return this.sdk.a(b.de) != false && this.poststitialWasDisplayed;
        }
        return true;
    }

    static /* synthetic */ Handler d(k k2) {
        return k2.y;
    }

    @SuppressLint(value={"WrongConstant"})
    private void d() {
        int n2;
        com.applovin.impl.sdk.j j2 = this.sdk;
        if (j2 != null && j2.a(b.fm).booleanValue() && this.isFinishing()) {
            return;
        }
        if (this.currentAd != null && this.currentAd.af() && (n2 = this.u) != Integer.MIN_VALUE) {
            this.setRequestedOrientation(n2);
        }
        this.finish();
    }

    static /* synthetic */ void d(k k2, boolean bl) {
        k2.b(bl);
    }

    private void d(AppLovinAd appLovinAd) {
        if (!this.i) {
            this.i = true;
            com.applovin.impl.sdk.e.h.a(this.b.c(), appLovinAd, this.sdk);
        }
    }

    private void e() {
        if (this.currentAd.v() && this.currentAd.h() != null) {
            this.sdk.u().a("InterActivity", "Clicking through video...");
            this.clickThroughFromVideo();
            return;
        }
        this.f();
        this.g();
    }

    static /* synthetic */ void e(k k2) {
        k2.A();
    }

    private void f() {
        e e2;
        if (this.sdk.a(b.dl).booleanValue() && (e2 = this.E) != null && e2.getVisibility() != 8) {
            boolean bl = this.E.getVisibility() == 4;
            this.a(this.E, bl, 750L);
        }
    }

    static /* synthetic */ void f(k k2) {
        k2.z();
    }

    static /* synthetic */ long g(k k2) {
        return k2.s;
    }

    private void g() {
        s s2;
        q q2 = this.currentAd.u();
        if (q2 != null && q2.e() && !this.poststitialWasDisplayed && (s2 = this.I) != null) {
            boolean bl = s2.getVisibility() == 4;
            this.a((View)this.I, bl, q2.f());
        }
    }

    private void h() {
        com.applovin.impl.sdk.j j2 = this.sdk;
        if (j2 != null) {
            j2.a(com.applovin.impl.sdk.b.d.o, false);
            this.sdk.a(com.applovin.impl.sdk.b.d.n, 0);
        }
    }

    static /* synthetic */ void h(k k2) {
        k2.r();
    }

    private void i() {
        this.f = true;
        this.showPoststitial();
    }

    static /* synthetic */ void i(k k2) {
        k2.l();
    }

    static /* synthetic */ void j(k k2) {
        k2.w();
    }

    private boolean j() {
        if (this.sdk.b(com.applovin.impl.sdk.b.d.n, 0) > 0) {
            return this.videoMuted;
        }
        if (this.sdk.a(b.dq).booleanValue()) {
            return this.sdk.l().isMuted();
        }
        return this.sdk.a(b.do);
    }

    private void k() {
        this.A = g.a(this.sdk, (Context)this, this.currentAd.p());
        this.A.setVisibility(8);
        this.A.setOnClickListener(new View.OnClickListener(this){
            final /* synthetic */ k a;
            {
                this.a = k2;
            }

            public void onClick(View view) {
                k.o(this.a);
            }
        });
        int n2 = this.a(this.currentAd.T());
        boolean bl = this.currentAd.W();
        int n3 = 3;
        int n4 = bl ? 3 : 5;
        int n5 = n4 | 48;
        if (!this.currentAd.X()) {
            n3 = 5;
        }
        int n6 = n3 | 48;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(n2, n2, n5 | 48);
        this.A.a(n2);
        int n7 = this.a(this.currentAd.U());
        int n8 = this.a(this.currentAd.V());
        layoutParams.setMargins(n8, n7, n8, n7);
        this.z.addView((View)this.A, (ViewGroup.LayoutParams)layoutParams);
        this.C = g.a(this.sdk, (Context)this, this.currentAd.q());
        this.C.setVisibility(8);
        this.C.setOnClickListener(new View.OnClickListener(this){
            final /* synthetic */ k a;
            {
                this.a = k2;
            }

            public void onClick(View view) {
                k.p(this.a);
            }
        });
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(n2, n2, n6);
        layoutParams2.setMargins(n8, n7, n8, n7);
        this.C.a(n2);
        this.z.addView((View)this.C, (ViewGroup.LayoutParams)layoutParams2);
        this.C.bringToFront();
        if (this.o()) {
            int n9 = this.a(this.sdk.a(b.cf));
            this.B = new View((Context)this);
            this.B.setBackgroundColor(0);
            this.B.setVisibility(8);
            this.D = new View((Context)this);
            this.D.setBackgroundColor(0);
            this.D.setVisibility(8);
            int n10 = n2 + n9;
            int n11 = n7 - this.a(5);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(n10, n10, n5);
            layoutParams3.setMargins(n11, n11, n11, n11);
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(n10, n10, n6);
            layoutParams4.setMargins(n11, n11, n11, n11);
            this.B.setOnClickListener(new View.OnClickListener(this){
                final /* synthetic */ k a;
                {
                    this.a = k2;
                }

                public void onClick(View view) {
                    k.q(this.a).performClick();
                }
            });
            this.D.setOnClickListener(new View.OnClickListener(this){
                final /* synthetic */ k a;
                {
                    this.a = k2;
                }

                public void onClick(View view) {
                    k.r(this.a).performClick();
                }
            });
            this.z.addView(this.B, (ViewGroup.LayoutParams)layoutParams3);
            this.B.bringToFront();
            this.z.addView(this.D, (ViewGroup.LayoutParams)layoutParams4);
            this.D.bringToFront();
        }
    }

    static /* synthetic */ void k(k k2) {
        k2.v();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void l() {
        if (this.F == null) {
            try {
                this.videoMuted = this.j();
                this.F = new ImageView((Context)this);
                if (this.m()) {
                    this.sdk.u().a("InterActivity", "Mute button should be hidden");
                    return;
                }
                int n2 = this.a(this.sdk.a(b.dr));
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(n2, n2, this.sdk.a(b.dt).intValue());
                this.F.setScaleType(ImageView.ScaleType.FIT_CENTER);
                int n3 = this.a(this.sdk.a(b.ds));
                layoutParams.setMargins(n3, n3, n3, n3);
                Uri uri = this.videoMuted ? this.currentAd.av() : this.currentAd.aw();
                if (uri != null) {
                    p p2 = this.sdk.u();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Added mute button with params: ");
                    stringBuilder.append((Object)layoutParams);
                    p2.a("InterActivity", stringBuilder.toString());
                    this.a(this.videoMuted);
                    this.F.setClickable(true);
                    this.F.setOnClickListener(new View.OnClickListener(this){
                        final /* synthetic */ k a;
                        {
                            this.a = k2;
                        }

                        public void onClick(View view) {
                            this.a.toggleMute();
                        }
                    });
                    this.z.addView((View)this.F, (ViewGroup.LayoutParams)layoutParams);
                    this.F.bringToFront();
                    return;
                }
                this.sdk.u().d("InterActivity", "Attempting to add mute button but could not find uri");
                return;
            }
            catch (Exception exception) {
                this.sdk.u().a("InterActivity", "Failed to attach mute button", exception);
            }
        }
    }

    static /* synthetic */ void l(k k2) {
        k2.J();
    }

    static /* synthetic */ void m(k k2) {
        k2.i();
    }

    private boolean m() {
        if (!this.sdk.a(b.dm).booleanValue()) {
            return true;
        }
        if (this.sdk.a(b.dn).booleanValue()) {
            if (this.j()) {
                return false;
            }
            return true ^ this.sdk.a(b.dp);
        }
        return false;
    }

    private void n() {
        this.runOnUiThread(new Runnable(this){
            final /* synthetic */ k a;
            {
                this.a = k2;
            }

            public void run() {
                try {
                    if (k.s(this.a)) {
                        k.q(this.a).setVisibility(0);
                        return;
                    }
                    k.a(this.a, true);
                    if (k.t(this.a) && k.u(this.a) != null) {
                        k.u(this.a).setVisibility(0);
                        k.u(this.a).bringToFront();
                    }
                    k.q(this.a).setVisibility(0);
                    k.q(this.a).bringToFront();
                    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                    alphaAnimation.setDuration((long)this.a.sdk.a(b.cT).intValue());
                    alphaAnimation.setRepeatCount(0);
                    k.q(this.a).startAnimation((Animation)alphaAnimation);
                    return;
                }
                catch (Throwable throwable) {
                    this.a.dismiss();
                    return;
                }
            }
        });
    }

    static /* synthetic */ void n(k k2) {
        k2.e();
    }

    static /* synthetic */ void o(k k2) {
        k2.C();
    }

    private boolean o() {
        return this.sdk.a(b.cf) > 0;
    }

    private void p() {
        this.runOnUiThread(new Runnable(this){
            final /* synthetic */ k a;
            {
                this.a = k2;
            }

            public void run() {
                try {
                    if (!k.v(this.a) && k.r(this.a) != null) {
                        k.b(this.a, true);
                        k.r(this.a).setVisibility(0);
                        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                        alphaAnimation.setDuration((long)this.a.sdk.a(b.cT).intValue());
                        alphaAnimation.setRepeatCount(0);
                        k.r(this.a).startAnimation((Animation)alphaAnimation);
                        if (k.t(this.a) && k.w(this.a) != null) {
                            k.w(this.a).setVisibility(0);
                            k.w(this.a).bringToFront();
                            return;
                        }
                    }
                }
                catch (Throwable throwable) {
                    p p2 = this.a.logger;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unable to show skip button: ");
                    stringBuilder.append((Object)((Object)throwable));
                    p2.c("InterActivity", stringBuilder.toString());
                }
            }
        });
    }

    static /* synthetic */ void p(k k2) {
        k2.B();
    }

    static /* synthetic */ g q(k k2) {
        return k2.A;
    }

    private void q() {
        if (this.currentAd.n() >= 0.0f) {
            g g2;
            if (!this.m || (g2 = this.C) == null) {
                g2 = this.A;
            }
            this.a(m.b(this.currentAd.n()), g2);
        }
    }

    static /* synthetic */ g r(k k2) {
        return k2.C;
    }

    private void r() {
        boolean bl = this.sdk.a(b.db) != false && this.u() > 0;
        if (this.E == null && bl) {
            this.E = new e((Context)this);
            int n2 = this.currentAd.C();
            this.E.setTextColor(n2);
            this.E.setTextSize(this.sdk.a(b.cZ).intValue());
            this.E.setFinishedStrokeColor(n2);
            this.E.setFinishedStrokeWidth(this.sdk.a(b.cY).intValue());
            this.E.setMax(this.u());
            this.E.setProgress(this.u());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.a(this.sdk.a(b.cX)), this.a(this.sdk.a(b.cX)), this.sdk.a(b.cW).intValue());
            int n3 = this.a(this.sdk.a(b.cV));
            layoutParams.setMargins(n3, n3, n3, n3);
            this.z.addView((View)this.E, (ViewGroup.LayoutParams)layoutParams);
            this.E.bringToFront();
            this.E.setVisibility(0);
            final long l2 = this.t();
            this.countdownManager.a("COUNTDOWN_CLOCK", 1000L, new h.a(){

                @Override
                public void a() {
                    if (k.this.E != null) {
                        long l22 = TimeUnit.MILLISECONDS.toSeconds(l2 - (long)k.this.videoView.getCurrentPosition());
                        if (l22 <= 0L) {
                            k.this.E.setVisibility(8);
                            k.this.p = true;
                            return;
                        }
                        if (k.this.s()) {
                            k.this.E.setProgress((int)l22);
                        }
                    }
                }

                @Override
                public boolean b() {
                    return k.this.s();
                }
            });
        }
    }

    private boolean s() {
        return !this.p && !this.poststitialWasDisplayed && this.videoView.isPlaying();
    }

    static /* synthetic */ boolean s(k k2) {
        return k2.k;
    }

    private long t() {
        return TimeUnit.SECONDS.toMillis((long)this.u());
    }

    static /* synthetic */ boolean t(k k2) {
        return k2.o();
    }

    private int u() {
        int n2 = this.currentAd.B();
        if (n2 > 0) {
            return n2;
        }
        if (this.sdk.a(b.dB).booleanValue()) {
            n2 = 1 + this.computedLengthSeconds;
        }
        return n2;
    }

    static /* synthetic */ View u(k k2) {
        return k2.B;
    }

    @SuppressLint(value={"NewApi"})
    private void v() {
        if (this.J == null && this.currentAd.I()) {
            this.logger.b("InterActivity", "Attaching video progress bar...");
            this.J = new ProgressBar((Context)this, null, 16842872);
            this.J.setMax(this.sdk.a(b.dw).intValue());
            this.J.setPadding(0, 0, 0, 0);
            if (com.applovin.impl.sdk.e.e.f()) {
                try {
                    ColorStateList colorStateList = ColorStateList.valueOf((int)this.currentAd.J());
                    this.J.setProgressTintList(colorStateList);
                }
                catch (Throwable throwable) {
                    this.logger.b("InterActivity", "Unable to update progress bar color.", throwable);
                }
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.videoView.getWidth(), 20, 80);
            layoutParams.setMargins(0, 0, 0, this.sdk.a(b.dx).intValue());
            this.z.addView((View)this.J, (ViewGroup.LayoutParams)layoutParams);
            this.J.bringToFront();
            long l2 = this.sdk.a(b.dv);
            this.countdownManager.a("PROGRESS_BAR", l2, new h.a(){

                @Override
                public void a() {
                    if (k.this.J != null) {
                        if (k.this.shouldContinueFullLengthVideoCountdown()) {
                            int n2 = k.this.sdk.a(b.dw);
                            int n3 = (int)((float)k.this.videoView.getCurrentPosition() / (float)k.this.videoView.getDuration() * (float)n2);
                            k.this.J.setProgress(n3);
                            return;
                        }
                        k.this.J.setVisibility(8);
                    }
                }

                @Override
                public boolean b() {
                    return k.this.shouldContinueFullLengthVideoCountdown();
                }
            });
        }
    }

    static /* synthetic */ boolean v(k k2) {
        return k2.l;
    }

    static /* synthetic */ View w(k k2) {
        return k2.D;
    }

    private void w() {
        q q2 = this.currentAd.u();
        if (com.applovin.impl.sdk.e.j.b(this.currentAd.t()) && q2 != null && this.I == null) {
            this.logger.b("InterActivity", "Attaching video button...");
            this.I = this.x();
            double d2 = q2.a();
            Double.isNaN((double)d2);
            double d3 = d2 / 100.0;
            double d4 = q2.b();
            Double.isNaN((double)d4);
            double d5 = d4 / 100.0;
            int n2 = this.videoView.getWidth();
            int n3 = this.videoView.getHeight();
            double d6 = n2;
            Double.isNaN((double)d6);
            int n4 = (int)(d3 * d6);
            double d7 = n3;
            Double.isNaN((double)d7);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(n4, (int)(d5 * d7), q2.d());
            int n5 = this.a(q2.c());
            layoutParams.setMargins(n5, n5, n5, n5);
            this.z.addView((View)this.I, (ViewGroup.LayoutParams)layoutParams);
            this.I.bringToFront();
            if (q2.i() > 0.0f) {
                this.I.setVisibility(4);
                long l2 = m.b(q2.i());
                this.y.postDelayed(new Runnable(this, q2){
                    final /* synthetic */ q a;
                    final /* synthetic */ k b;
                    {
                        this.b = k2;
                        this.a = q2;
                    }

                    public void run() {
                        long l2 = this.a.g();
                        k k2 = this.b;
                        k.a(k2, (View)k.C(k2), true, l2);
                    }
                }, l2);
            }
            if (q2.j() > 0.0f) {
                long l3 = m.b(q2.j());
                this.y.postDelayed(new Runnable(this, q2){
                    final /* synthetic */ q a;
                    final /* synthetic */ k b;
                    {
                        this.b = k2;
                        this.a = q2;
                    }

                    public void run() {
                        long l2 = this.a.h();
                        k k2 = this.b;
                        k.a(k2, (View)k.C(k2), false, l2);
                    }
                }, l3);
            }
        }
    }

    private s x() {
        p p2 = this.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Create video button with HTML = ");
        stringBuilder.append(this.currentAd.t());
        p2.a("InterActivity", stringBuilder.toString());
        t t2 = new t(this.sdk);
        this.K = new t.a(){

            @Override
            public void a(s s2) {
                k.this.logger.a("InterActivity", "Clicking through from video button...");
                k.this.clickThroughFromVideo();
            }

            @Override
            public void b(s s2) {
                k.this.logger.a("InterActivity", "Closing ad from video button...");
                k.this.dismiss();
            }

            @Override
            public void c(s s2) {
                k.this.logger.a("InterActivity", "Skipping video from video button...");
                k.this.skipVideo();
            }
        };
        t2.a((WeakReference<t.a>)new WeakReference((Object)this.K));
        s s2 = new s(t2, this.getApplicationContext());
        s2.a(this.currentAd.t());
        return s2;
    }

    static /* synthetic */ void x(k k2) {
        k2.n();
    }

    private void y() {
        if (this.n && this.currentAd.K()) {
            int n2 = this.currentAd.M();
            this.L = new a(this, this.sdk.a(b.dA), n2);
            this.L.setColor(this.currentAd.N());
            this.L.setBackgroundColor(this.currentAd.O());
            this.L.setVisibility(8);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1, 17);
            this.z.addView((View)this.L, (ViewGroup.LayoutParams)layoutParams);
            this.z.bringChildToFront((View)this.L);
        }
    }

    static /* synthetic */ void y(k k2) {
        k2.p();
    }

    private void z() {
        a a2 = this.L;
        if (a2 != null) {
            a2.a();
        }
    }

    public void clickThroughFromVideo() {
        try {
            if (this.currentAd.ae() && this.m) {
                this.p();
            }
            this.sdk.n().trackAndLaunchVideoClick((AppLovinAd)this.currentAd, this.currentPlacement, this.a, this.currentAd.h());
            com.applovin.impl.sdk.e.h.a(this.b.e(), (AppLovinAd)this.currentAd, this.sdk);
            if (this.d != null) {
                this.d.b();
                return;
            }
        }
        catch (Throwable throwable) {
            this.sdk.u().b("InterActivity", "Encountered error while clicking through video.", throwable);
        }
    }

    public void continueVideo() {
        this.P();
    }

    @Override
    public void dismiss() {
        block4 : {
            AppLovinAdView appLovinAdView;
            block5 : {
                block3 : {
                    long l2 = System.currentTimeMillis() - this.r;
                    p p2 = this.logger;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Dismissing ad after ");
                    stringBuilder.append(l2);
                    stringBuilder.append(" milliseconds elapsed");
                    p2.b("InterActivity", stringBuilder.toString());
                    if (!this.sdk.a(b.fh).booleanValue()) break block3;
                    appLovinAdView = this.a;
                    if (appLovinAdView == null) break block4;
                    break block5;
                }
                appLovinAdView = this.a;
            }
            ((AdViewControllerImpl)appLovinAdView.getAdViewController()).setIsForegroundClickInvalidated(true);
        }
        this.h();
        this.Q();
        if (this.b != null) {
            if (this.currentAd != null) {
                this.c((AppLovinAd)this.currentAd);
                d d2 = this.d;
                if (d2 != null) {
                    d2.c();
                    this.d = null;
                }
            }
            this.b.a(false);
            this.b.h();
        }
        this.d();
    }

    public void exitWithError(String string) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Initialized = ");
            stringBuilder.append(l.b);
            stringBuilder.append("; CleanedUp = ");
            stringBuilder.append(l.c);
            String string2 = stringBuilder.toString();
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Failed to properly render an Interstitial Activity, due to error: ");
            stringBuilder2.append(string);
            Log.e((String)"InterActivity", (String)stringBuilder2.toString(), (Throwable)new Throwable(string2));
            this.c(new com.applovin.impl.sdk.ad.i());
        }
        catch (Exception exception) {
            Log.e((String)"InterActivity", (String)"Failed to show a video ad due to error:", (Throwable)exception);
        }
        this.d();
    }

    public boolean getPoststitialWasDisplayed() {
        return this.poststitialWasDisplayed;
    }

    public int getVideoPercentViewed() {
        if (this.f) {
            return 100;
        }
        r r2 = this.videoView;
        if (r2 != null) {
            int n2 = r2.getDuration();
            if (n2 > 0) {
                double d2 = this.videoView.getCurrentPosition();
                double d3 = n2;
                Double.isNaN((double)d2);
                Double.isNaN((double)d3);
                return (int)(100.0 * (d2 / d3));
            }
            return this.t;
        }
        this.logger.d("InterActivity", "No video view detected on video end");
        return 0;
    }

    public void handleMediaError() {
        String string;
        p p2;
        if (this.v.compareAndSet(false, true)) {
            if (this.sdk.a(b.da).booleanValue()) {
                this.logger.d("InterActivity", "Handling media player error - Finishing activity...");
                this.d();
            } else {
                this.logger.d("InterActivity", "Handling media player error - Showing poststitial...");
                this.showPoststitial();
            }
            p2 = this.logger;
            string = "Finished handling media player error.";
        } else {
            p2 = this.logger;
            string = "Already handled media player error. Doing nothing...";
        }
        p2.d("InterActivity", string);
    }

    protected boolean isFullyWatched() {
        return this.getVideoPercentViewed() >= this.currentAd.Q();
    }

    protected boolean isVastAd() {
        return this.currentAd instanceof com.applovin.impl.a.a;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onBackPressed() {
        block5 : {
            block4 : {
                if (!this.c()) break block4;
                this.logger.a("InterActivity", "Back button was pressed; forwarding to Android for handling...");
                break block5;
            }
            try {
                block8 : {
                    g g2;
                    block7 : {
                        block6 : {
                            if (!this.m || this.C == null || this.C.getVisibility() != 0 || !(this.C.getAlpha() > 0.0f) || this.k) break block6;
                            this.logger.a("InterActivity", "Back button was pressed; forwarding as a click to skip button.");
                            g2 = this.C;
                            break block7;
                        }
                        if (this.A == null || this.A.getVisibility() != 0 || !(this.A.getAlpha() > 0.0f)) break block8;
                        this.logger.a("InterActivity", "Back button was pressed; forwarding as a click to close button.");
                        g2 = this.A;
                    }
                    g2.performClick();
                    return;
                }
                this.logger.a("InterActivity", "Back button was pressed, but was not eligible for dismissal.");
                return;
            }
            catch (Exception exception) {}
        }
        super.onBackPressed();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation != 0 && this.videoView instanceof n && this.G.get() != null) {
            MediaPlayer mediaPlayer = (MediaPlayer)this.G.get();
            this.videoView.setVideoSize(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected void onCreate(Bundle bundle) {
        Throwable throwable22;
        StrictMode.ThreadPolicy threadPolicy;
        block12 : {
            super.onCreate(bundle);
            if (bundle != null) {
                boolean bl = bundle.getBoolean("instance_impression_tracked");
                this.w.set(bl);
            }
            int n2 = 1;
            this.requestWindowFeature(n2);
            threadPolicy = StrictMode.allowThreadDiskReads();
            try {
                try {
                    String string;
                    block18 : {
                        block15 : {
                            block21 : {
                                int n3;
                                block22 : {
                                    block19 : {
                                        block20 : {
                                            com.applovin.impl.sdk.ad.g g2;
                                            block16 : {
                                                int n4;
                                                block17 : {
                                                    block13 : {
                                                        block14 : {
                                                            String string2 = this.getIntent().getStringExtra(KEY_WRAPPER_ID);
                                                            if (string2 == null || string2.isEmpty()) break block13;
                                                            this.b = l.a(string2);
                                                            if (this.b == null && lastKnownWrapper != null) {
                                                                this.b = lastKnownWrapper;
                                                            }
                                                            if (this.b == null) break block14;
                                                            AppLovinAd appLovinAd = this.b.b();
                                                            this.sdk = this.b.a();
                                                            this.logger = this.b.a().u();
                                                            this.currentPlacement = this.b.g();
                                                            this.d = new d(appLovinAd, this.sdk);
                                                            if (appLovinAd == null) break block15;
                                                            g2 = (com.applovin.impl.sdk.ad.g)appLovinAd;
                                                            View view = this.findViewById(16908290);
                                                            if (view != null) {
                                                                int n5 = g2.hasVideoUrl() ? g2.D() : g2.E();
                                                                view.setBackgroundColor(n5);
                                                            }
                                                            this.r = System.currentTimeMillis();
                                                            if (g2.w()) {
                                                                this.getWindow().setFlags(16777216, 16777216);
                                                            }
                                                            if (g2.x()) {
                                                                this.getWindow().addFlags(128);
                                                            }
                                                            Display display = ((WindowManager)this.getSystemService("window")).getDefaultDisplay();
                                                            n4 = k.a(display);
                                                            n3 = display.getRotation();
                                                            if (n4 == 2 && n3 == 0) break block16;
                                                            break block17;
                                                        }
                                                        StringBuilder stringBuilder = new StringBuilder();
                                                        stringBuilder.append("Wrapper is null; initialized state: ");
                                                        stringBuilder.append(Boolean.toString((boolean)l.b));
                                                        string = stringBuilder.toString();
                                                        break block18;
                                                    }
                                                    string = "Wrapper ID is null";
                                                    break block18;
                                                }
                                                if (!(n4 == 2 && n3 == 2 || n4 == n2 && n3 == n2 || n4 == n2 && n3 == 3)) {
                                                    n2 = 0;
                                                }
                                            }
                                            int n6 = this.a(n3, (boolean)n2);
                                            this.u = bundle == null ? n6 : bundle.getInt("original_orientation", n6);
                                            if (!g2.A()) break block19;
                                            if (n6 == -1) break block20;
                                            p p2 = this.logger;
                                            StringBuilder stringBuilder = new StringBuilder();
                                            stringBuilder.append("Locking activity orientation to current orientation: ");
                                            stringBuilder.append(n6);
                                            p2.a("InterActivity", stringBuilder.toString());
                                            this.b(n6);
                                            break block21;
                                        }
                                        this.logger.d("InterActivity", "Unable to detect current orientation. Locking to targeted orientation...");
                                        break block22;
                                    }
                                    this.logger.a("InterActivity", "Locking activity orientation to targeted orientation...");
                                }
                                this.b(n3, (boolean)n2);
                            }
                            this.a = new AppLovinAdView(this.sdk.K(), AppLovinAdSize.INTERSTITIAL, (Context)this);
                            this.a.setAutoDestroy(false);
                            ((AdViewControllerImpl)this.a.getAdViewController()).setStatsManagerHelper(this.d);
                            this.b.a(this);
                            this.m = this.sdk.a(b.dz);
                            this.q = com.applovin.impl.sdk.e.e.b(this.getApplicationContext());
                            this.H = new com.applovin.impl.sdk.a.d(this, this.sdk);
                            break block12;
                        }
                        string = "No current ad found.";
                    }
                    this.exitWithError(string);
                }
                catch (Throwable throwable3) {
                    if (this.logger != null) {
                        this.logger.b("InterActivity", "Encountered error during onCreate.", throwable3);
                    }
                    this.exitWithError("An error was encountered during interstitial ad creation.");
                }
            }
            catch (Throwable throwable22) {}
        }
        StrictMode.setThreadPolicy((StrictMode.ThreadPolicy)threadPolicy);
        this.h();
        d d2 = this.d;
        if (d2 != null) {
            d2.a();
        }
        this.K();
        return;
        StrictMode.setThreadPolicy((StrictMode.ThreadPolicy)threadPolicy);
        throw throwable22;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    protected void onDestroy() {
        Throwable throwable2222;
        block13 : {
            block12 : {
                MediaPlayer mediaPlayer;
                if (this.a != null) {
                    ViewParent viewParent = this.a.getParent();
                    if (viewParent != null && viewParent instanceof ViewGroup) {
                        ((ViewGroup)viewParent).removeView((View)this.a);
                    }
                    this.a.destroy();
                    this.a = null;
                }
                if (this.videoView != null) {
                    this.videoView.pause();
                    this.videoView.stopPlayback();
                }
                if (this.sdk != null && this.sdk.a(b.fi).booleanValue() && (mediaPlayer = (MediaPlayer)this.G.get()) != null) {
                    mediaPlayer.release();
                }
                if (this.countdownManager != null) {
                    this.countdownManager.b();
                }
                if (this.y != null) {
                    this.y.removeCallbacksAndMessages(null);
                }
                if (this.x != null) {
                    this.x.removeCallbacksAndMessages(null);
                }
                if (this.currentAd == null) break block12;
                {
                    catch (Throwable throwable2222) {
                        break block13;
                    }
                    catch (Throwable throwable3) {}
                    {
                        if (this.logger != null) {
                            this.logger.a("InterActivity", "Unable to destroy video view", throwable3);
                        }
                        if (this.currentAd == null) break block12;
                    }
                }
                this.Q();
                this.c((AppLovinAd)this.currentAd);
            }
            super.onDestroy();
            return;
        }
        if (this.currentAd == null) throw throwable2222;
        this.Q();
        this.c((AppLovinAd)this.currentAd);
        throw throwable2222;
    }

    /*
     * Enabled aggressive block sorting
     */
    protected void onPause() {
        this.logger.a("InterActivity", "App paused...");
        this.s = System.currentTimeMillis();
        if (!(this.e || !this.q && this.c)) {
            this.N();
        }
        this.b.a(false);
        this.H.a();
        this.pauseReportRewardTask();
        super.onPause();
    }

    protected void onResume() {
        block6 : {
            block8 : {
                g g2;
                block9 : {
                    boolean bl;
                    block7 : {
                        super.onResume();
                        this.logger.a("InterActivity", "App resumed...");
                        l l2 = this.b;
                        bl = true;
                        l2.a(bl);
                        if (this.o) break block6;
                        d d2 = this.d;
                        if (d2 != null) {
                            d2.d(System.currentTimeMillis() - this.s);
                        }
                        if (!this.sdk.b(com.applovin.impl.sdk.b.d.o, false).booleanValue() || this.H.d() || this.poststitialWasDisplayed) break block7;
                        this.O();
                        this.z();
                        if (this.currentAd == null || !this.sdk.a(b.cU).booleanValue() || this.currentAd.z() || this.poststitialWasDisplayed || !this.m || (g2 = this.C) == null) break block8;
                        break block9;
                    }
                    if (!(this.currentAd instanceof com.applovin.impl.sdk.ad.a) || !((com.applovin.impl.sdk.ad.a)this.currentAd).j()) {
                        bl = false;
                    }
                    if (this.currentAd == null || !this.sdk.a(b.cU).booleanValue() || this.currentAd.y() || !this.poststitialWasDisplayed || (g2 = this.A) == null || bl) break block8;
                }
                this.a(0L, g2);
            }
            this.resumeReportRewardTask();
            return;
        }
        if (!this.H.d() && !this.poststitialWasDisplayed && this.currentAd != null && this.currentAd.L()) {
            this.z();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean("instance_impression_tracked", this.w.get());
        bundle.putInt("original_orientation", this.u);
        super.onSaveInstanceState(bundle);
    }

    public void onWindowFocusChanged(boolean bl) {
        super.onWindowFocusChanged(bl);
        if (bl) {
            this.logger.a("InterActivity", "Window gained focus");
            try {
                if (com.applovin.impl.sdk.e.e.e() && this.sdk.a(b.du).booleanValue() && this.a()) {
                    this.b();
                    if (this.sdk.a(b.df) > 0L) {
                        this.y.postDelayed(new Runnable(this){
                            final /* synthetic */ k a;
                            {
                                this.a = k2;
                            }

                            public void run() {
                                k.a(this.a);
                            }
                        }, this.sdk.a(b.df).longValue());
                    }
                } else {
                    this.getWindow().setFlags(1024, 1024);
                }
                if (this.sdk.a(b.dg).booleanValue() && !this.poststitialWasDisplayed) {
                    this.O();
                    this.resumeReportRewardTask();
                }
            }
            catch (Throwable throwable) {
                this.logger.b("InterActivity", "Setting window flags failed.", throwable);
            }
        } else {
            this.logger.a("InterActivity", "Window lost focus");
            if (this.sdk.a(b.dg).booleanValue() && !this.poststitialWasDisplayed) {
                this.N();
                this.pauseReportRewardTask();
            }
        }
        this.o = false;
    }

    public void pauseReportRewardTask() {
        com.applovin.impl.sdk.e.k k2 = this.M;
        if (k2 != null) {
            k2.b();
        }
    }

    protected void playVideo() {
        this.d((AppLovinAd)this.currentAd);
        this.videoView.start();
        this.countdownManager.a();
    }

    public void resumeReportRewardTask() {
        com.applovin.impl.sdk.e.k k2 = this.M;
        if (k2 != null) {
            k2.c();
        }
    }

    protected boolean shouldContinueFullLengthVideoCountdown() {
        return !this.f && !this.poststitialWasDisplayed;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public void showPoststitial() {
        block20 : {
            block18 : {
                block19 : {
                    try {
                        if (this.d != null) {
                            this.d.g();
                        }
                        if (!this.currentAd.Y()) {
                            this.L();
                        }
                        if (this.a != null) {
                            var6_1 = this.a.getParent();
                            if (var6_1 instanceof ViewGroup) {
                                ((ViewGroup)var6_1).removeView((View)this.a);
                            }
                            var7_2 = new FrameLayout((Context)this);
                            var7_2.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
                            var7_2.setBackgroundColor(this.currentAd.E());
                            var7_2.addView((View)this.a);
                            if (this.currentAd.al()) {
                                this.a.renderAd((AppLovinAd)this.currentAd, this.currentPlacement);
                            }
                            if (this.currentAd.Y()) {
                                this.L();
                            }
                            if (this.z != null) {
                                this.z.removeAllViewsInLayout();
                            }
                            if (this.o() && this.B != null) {
                                if (this.B.getParent() instanceof ViewGroup) {
                                    ((ViewGroup)this.B.getParent()).removeView(this.B);
                                }
                                var7_2.addView(this.B);
                                this.B.bringToFront();
                            }
                            if (this.A != null) {
                                var10_3 = this.A.getParent();
                                if (var10_3 instanceof ViewGroup) {
                                    ((ViewGroup)var10_3).removeView((View)this.A);
                                }
                                var7_2.addView((View)this.A);
                                this.A.bringToFront();
                            }
                            this.setContentView((View)var7_2);
                            if (this.currentAd.am()) {
                                this.a.renderAd((AppLovinAd)this.currentAd, this.currentPlacement);
                            }
                            if (this.sdk.a(b.fe).booleanValue()) {
                                this.a.setVisibility(4);
                                this.a.setVisibility(0);
                            }
                            if ((var8_4 = this.currentAd.R()) >= 0) {
                                this.y.postDelayed(new Runnable(this){
                                    final /* synthetic */ k a;
                                    {
                                        this.a = k2;
                                    }

                                    public void run() {
                                        c c2 = ((AdViewControllerImpl)k.F(this.a).getAdViewController()).getAdWebView();
                                        if (c2 != null) {
                                            c2.a("javascript:al_onPoststitialShow();");
                                        }
                                    }
                                }, (long)var8_4);
                            }
                        }
                    }
                    catch (Throwable var1_8) {
                        this.logger.b("InterActivity", "Encountered error while showing poststitial. Dismissing...", var1_8);
                        this.dismiss();
                        return;
                    }
                    if (var2_5 = this.currentAd instanceof com.applovin.impl.sdk.ad.a != false && ((com.applovin.impl.sdk.ad.a)this.currentAd).j() != false) break block18;
                    if (!(this.currentAd.o() >= 0.0f)) break block19;
                    var3_6 = m.b(this.currentAd.o());
                    var5_7 = this.A;
                    ** GOTO lbl55
                }
                if (this.currentAd.o() == -2.0f) {
                    this.A.setVisibility(0);
                } else {
                    var3_6 = 0L;
                    var5_7 = this.A;
lbl55: // 2 sources:
                    this.a(var3_6, var5_7);
                }
                break block20;
            }
            this.logger.a("InterActivity", "Skip showing of close button");
        }
        this.poststitialWasDisplayed = true;
    }

    public void skipVideo() {
        d d2 = this.d;
        if (d2 != null) {
            d2.f();
        }
        if (this.currentAd.r()) {
            this.dismiss();
            return;
        }
        this.showPoststitial();
    }

    public void toggleMute() {
        boolean bl = true ^ this.M();
        d d2 = this.d;
        if (d2 != null) {
            d2.h();
        }
        try {
            this.c(bl);
            this.a(bl);
            this.b(bl);
            return;
        }
        catch (Throwable throwable) {
            p p2 = this.logger;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to set volume to ");
            stringBuilder.append(bl);
            p2.b("InterActivity", stringBuilder.toString(), throwable);
            return;
        }
    }

}


/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.os.Handler
 *  android.text.TextUtils
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.webkit.WebView
 *  android.widget.ProgressBar
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  android.widget.TextView
 *  android.widget.VideoView
 *  com.startapp.android.publish.ads.video.e
 *  java.io.Serializable
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Double
 *  java.lang.Enum
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.ArrayList
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Set
 *  java.util.concurrent.TimeUnit
 */
package com.startapp.android.publish.ads.video;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;
import com.startapp.android.publish.ads.video.VideoAdDetails;
import com.startapp.android.publish.ads.video.VideoJsInterface;
import com.startapp.android.publish.ads.video.b.c;
import com.startapp.android.publish.ads.video.e;
import com.startapp.android.publish.ads.video.f;
import com.startapp.android.publish.ads.video.h;
import com.startapp.android.publish.ads.video.tracking.AbsoluteTrackingLink;
import com.startapp.android.publish.ads.video.tracking.ActionTrackingLink;
import com.startapp.android.publish.ads.video.tracking.FractionTrackingLink;
import com.startapp.android.publish.ads.video.tracking.VideoClickedTrackingParams;
import com.startapp.android.publish.ads.video.tracking.VideoPausedTrackingParams;
import com.startapp.android.publish.ads.video.tracking.VideoProgressTrackingParams;
import com.startapp.android.publish.ads.video.tracking.VideoTrackingDetails;
import com.startapp.android.publish.ads.video.tracking.VideoTrackingLink;
import com.startapp.android.publish.ads.video.tracking.VideoTrackingParams;
import com.startapp.android.publish.adsCommon.Ad;
import com.startapp.android.publish.adsCommon.AdsConstants;
import com.startapp.android.publish.adsCommon.adListeners.AdDisplayListener;
import com.startapp.android.publish.adsCommon.f.d;
import com.startapp.android.publish.adsCommon.n;
import com.startapp.android.publish.common.metaData.MetaData;
import com.startapp.android.publish.html.JsInterface;
import com.startapp.android.publish.omsdk.AdVerification;
import com.startapp.android.publish.omsdk.VerificationDetails;
import com.startapp.common.a.c;
import com.startapp.common.a.g;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class f
extends com.startapp.android.publish.ads.a.c {
    protected int A;
    protected String B = null;
    protected Handler C = new Handler();
    protected Handler D = new Handler();
    protected Handler E = new Handler();
    protected Handler F = new Handler();
    private RelativeLayout G;
    private RelativeLayout H;
    private int I = 0;
    private int J = 0;
    private boolean K = false;
    private HashMap<Integer, Boolean> L = new HashMap();
    private HashMap<Integer, Boolean> M = new HashMap();
    private int N = 1;
    private boolean O = false;
    private boolean P = false;
    private Map<Integer, List<FractionTrackingLink>> Q = new HashMap();
    private Map<Integer, List<AbsoluteTrackingLink>> R = new HashMap();
    private long S;
    private VideoClickedTrackingParams.ClickOrigin T;
    private long U;
    private long V;
    private com.b.a.a.a.b.a.a W;
    protected com.startapp.android.publish.ads.video.b.c i;
    protected VideoView j;
    protected ProgressBar k;
    protected boolean l = false;
    protected int m = 0;
    protected int n = 0;
    protected boolean o;
    protected boolean p = false;
    protected boolean q = false;
    protected boolean r = false;
    protected boolean s = false;
    protected boolean t = false;
    protected int u = 0;
    protected boolean v = false;
    protected boolean w = false;
    protected boolean x = false;
    protected boolean y = false;
    protected int z = 0;

    private RelativeLayout a(Context context) {
        this.U = System.currentTimeMillis();
        this.H = (RelativeLayout)this.b().findViewById(1475346432);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.j = new VideoView(context);
        this.j.setId(100);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams2.addRule(13);
        this.k = new ProgressBar(context, null, 16843399);
        this.k.setVisibility(4);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(14);
        layoutParams3.addRule(15);
        this.G = new RelativeLayout(context);
        this.G.setId(1475346436);
        this.b().setContentView((View)this.G);
        this.G.addView((View)this.j, (ViewGroup.LayoutParams)layoutParams2);
        this.G.addView((View)this.H, (ViewGroup.LayoutParams)layoutParams);
        this.G.addView((View)this.k, (ViewGroup.LayoutParams)layoutParams3);
        if (AdsConstants.a().booleanValue()) {
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams4.addRule(12);
            layoutParams4.addRule(14);
            this.G.addView(this.b(context), (ViewGroup.LayoutParams)layoutParams4);
        }
        this.a.a().setVisibility(4);
        return this.G;
    }

    static /* synthetic */ com.b.a.a.a.b.a.a a(f f2) {
        return f2.W;
    }

    private void a(int n2, Handler handler, Runnable runnable) {
        int n3 = this.n;
        if (n3 < n2) {
            handler.postDelayed(runnable, (long)(n2 - n3));
        }
    }

    private void a(View view) {
        Object[] arrobject = new Object[]{com.startapp.android.publish.adsCommon.Utils.h.b((Context)this.b(), view.getLeft()), com.startapp.android.publish.adsCommon.Utils.h.b((Context)this.b(), view.getTop()), com.startapp.android.publish.adsCommon.Utils.h.b((Context)this.b(), view.getWidth()), com.startapp.android.publish.adsCommon.Utils.h.b((Context)this.b(), view.getHeight())};
        this.a("videoApi.setVideoFrame", arrobject);
    }

    private void a(com.startapp.android.publish.ads.video.c.a.a a2) {
        g.a("VideoMode", 3, "Sending internal video event");
        com.startapp.android.publish.ads.video.a.a a3 = new com.startapp.android.publish.ads.video.a.b(this.U().getVideoTrackingDetails().getInlineErrorTrackingUrls(), new VideoTrackingParams(this.n(), this.h(this.I), this.m, this.B), this.U().getVideoUrl(), this.I).a(a2).a("error").a();
        h.a((Context)this.b(), a3);
    }

    static /* synthetic */ void a(f f2, String string, Object[] arrobject) {
        f2.a(string, arrobject);
    }

    private void a(VideoClickedTrackingParams.ClickOrigin clickOrigin) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Sending video clicked event with origin: ");
        stringBuilder.append(clickOrigin.toString());
        g.a("VideoMode", 3, stringBuilder.toString());
        VideoTrackingLink[] arrvideoTrackingLink = this.U().getVideoTrackingDetails().getVideoClickTrackingUrls();
        VideoClickedTrackingParams videoClickedTrackingParams = new VideoClickedTrackingParams(this.n(), this.h(this.I), this.m, clickOrigin, this.B);
        this.a(arrvideoTrackingLink, videoClickedTrackingParams, this.I, "clicked");
    }

    private void a(VideoPausedTrackingParams.PauseOrigin pauseOrigin) {
        com.startapp.android.publish.ads.video.b.c c2 = this.i;
        if (c2 != null) {
            int n2;
            this.n = n2 = c2.d();
            this.I = n2;
            this.i.b();
            com.b.a.a.a.b.a.a a2 = this.W;
            if (a2 != null) {
                a2.e();
            }
        }
        this.c(pauseOrigin);
    }

    private void a(VideoTrackingLink[] arrvideoTrackingLink, VideoTrackingParams videoTrackingParams, int n2, String string) {
        com.startapp.android.publish.ads.video.a.a a2 = new com.startapp.android.publish.ads.video.a.b(arrvideoTrackingLink, videoTrackingParams, this.U().getVideoUrl(), n2).a(string).a();
        h.a((Context)this.b(), a2);
    }

    private void aA() {
        g.a("VideoMode", 3, "Sending rewarded event");
        this.a(this.U().getVideoTrackingDetails().getVideoRewardedUrls(), new VideoTrackingParams(this.n(), com.startapp.android.publish.adsCommon.b.a().H().d(), this.m, this.B), this.e(com.startapp.android.publish.adsCommon.b.a().H().d()), "rewarded");
    }

    private void aB() {
        g.a("VideoMode", 3, "Sending skip event");
        this.a(this.U().getVideoTrackingDetails().getVideoSkippedUrls(), new VideoTrackingParams(this.n(), this.h(this.I), this.m, this.B), this.I, "skipped");
    }

    private void aC() {
        g.a("VideoMode", 3, "Sending postroll closed event");
        this.a(this.U().getVideoTrackingDetails().getVideoPostRollClosedUrls(), new VideoTrackingParams(this.n(), this.h(this.I), this.m, this.B), this.I, "postrollClosed");
    }

    private void aD() {
        g.a("VideoMode", 3, "Sending video closed event");
        this.a(this.U().getVideoTrackingDetails().getVideoClosedUrls(), new VideoTrackingParams(this.n(), this.h(this.i.d()), this.m, this.B), this.i.d(), "closed");
    }

    private void aa() {
        if (this.j == null) {
            this.a(this.b().getApplicationContext());
        }
        if (this.i == null) {
            this.i = new com.startapp.android.publish.ads.video.b.b(this.j);
        }
        this.q = false;
        this.G.setBackgroundColor(-16777216);
        this.H();
        if (this.S()) {
            this.a.a().setVisibility(0);
            this.j.setVisibility(4);
        } else {
            int n2 = this.n;
            if (n2 != 0) {
                this.i.a(n2);
                this.b(VideoPausedTrackingParams.PauseOrigin.EXTERNAL);
            }
        }
        this.i.a(new c.f(this){
            final /* synthetic */ f a;
            {
                this.a = f2;
            }

            public void a() {
                f f2 = this.a;
                f2.w = true;
                if (f2.p && this.a.q) {
                    this.a.G();
                }
                if (this.a.Y()) {
                    this.a.K();
                }
            }
        });
        this.i.a(new c.d(this){
            final /* synthetic */ f a;
            {
                this.a = f2;
            }

            public void a() {
                if (!this.a.S()) {
                    this.a.a(c.a);
                }
                this.a.i.c();
            }
        });
        c.c c2 = new c.c(this){
            final /* synthetic */ f a;
            {
                this.a = f2;
            }

            public void a(int n2) {
                if (this.a.v && this.a.w && this.a.i != null && this.a.i.e() != 0) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("buffered percent = [");
                    stringBuilder.append(n2);
                    stringBuilder.append("]");
                    g.a("VideoMode", 3, stringBuilder.toString());
                    f f2 = this.a;
                    f2.u = n2;
                    int n3 = 100 * f2.i.d() / this.a.i.e();
                    if (this.a.N()) {
                        if (!this.a.x && this.a.Y()) {
                            this.a.K();
                            return;
                        }
                        if (this.a.u == 100 || this.a.u - n3 > com.startapp.android.publish.adsCommon.b.a().H().j()) {
                            this.a.I();
                            return;
                        }
                    } else if (this.a.u < 100 && this.a.u - n3 <= com.startapp.android.publish.adsCommon.b.a().H().k()) {
                        this.a.J();
                    }
                }
            }
        };
        this.i.a(new c.e(this){
            final /* synthetic */ f a;
            {
                this.a = f2;
            }

            public boolean a(c.g g2) {
                f f2 = this.a;
                f2.w = false;
                if (f2.v && this.a.z <= this.a.A && g2.c() > 0 && g2.b().equals((Object)com.startapp.android.publish.ads.video.b.b$a.a.toString())) {
                    f f3 = this.a;
                    f3.z = 1 + f3.z;
                    this.a.L();
                    this.a.i.a(this.a.U().getLocalVideoPath());
                    this.a.i.a(g2.c());
                    return true;
                }
                this.a.a(g2);
                return true;
            }
        });
        this.i.a(new c.b(this){
            final /* synthetic */ f a;
            {
                this.a = f2;
            }
        });
        this.i.a(c2);
        this.i.a(new c.a(this){
            final /* synthetic */ f a;
            {
                this.a = f2;
            }
        });
        com.startapp.common.a.c.a((View)this.j, new c.a(this){
            final /* synthetic */ f a;
            {
                this.a = f2;
            }

            public void a(View view, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9) {
                f f2 = this.a;
                f2.q = true;
                if (f2.p && this.a.X()) {
                    this.a.G();
                }
            }
        });
    }

    private void ab() {
        boolean bl = this.U().isVideoMuted() || com.startapp.android.publish.adsCommon.b.a().H().m().equals((Object)"muted");
        this.l = bl;
    }

    private void ac() {
        if (this.g().equals((Object)"back")) {
            if (com.startapp.android.publish.adsCommon.b.a().H().a().equals((Object)n.a.d)) {
                this.O = true;
                this.P = true;
                return;
            }
            if (com.startapp.android.publish.adsCommon.b.a().H().a().equals((Object)n.a.b)) {
                this.O = true;
                this.P = false;
                return;
            }
            if (com.startapp.android.publish.adsCommon.b.a().H().a().equals((Object)n.a.c)) {
                this.O = false;
                this.P = true;
                return;
            }
            if (com.startapp.android.publish.adsCommon.b.a().H().a().equals((Object)n.a.a)) {
                this.O = false;
                this.P = false;
                return;
            }
            this.O = false;
            this.P = false;
        }
    }

    private long ad() {
        long l2 = System.currentTimeMillis() - this.S;
        if (this.n == 0 && this.m == 0 && l2 < 500L) {
            return Math.max((long)200L, (long)(500L - l2));
        }
        return 0L;
    }

    private void ae() {
        Object[] arrobject = new Object[1];
        boolean bl = this.i != null;
        arrobject[0] = bl;
        this.a("videoApi.setReplayEnabled", arrobject);
        Object[] arrobject2 = new Object[1];
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((Object)a.b);
        stringBuilder.append("_");
        stringBuilder.append((Object)this.U().getPostRollType());
        arrobject2[0] = stringBuilder.toString();
        this.a("videoApi.setMode", arrobject2);
        Object[] arrobject3 = new Object[]{true};
        this.a("videoApi.setCloseable", arrobject3);
    }

    private void af() {
        Object[] arrobject = new Object[]{this.U().isClickable()};
        this.a("videoApi.setClickableVideo", arrobject);
        Object[] arrobject2 = new Object[]{a.a.toString()};
        this.a("videoApi.setMode", arrobject2);
        Object[] arrobject3 = new Object[1];
        boolean bl = this.U().isCloseable() || this.P;
        arrobject3[0] = bl;
        this.a("videoApi.setCloseable", arrobject3);
        boolean bl2 = this.aw();
        Object[] arrobject4 = new Object[]{bl2};
        this.a("videoApi.setSkippable", arrobject4);
    }

    private void ag() {
        Object[] arrobject = new Object[]{this.i.e() / 1000};
        this.a("videoApi.setVideoDuration", arrobject);
        this.P();
        this.aj();
        Object[] arrobject2 = new Object[]{this.n / 1000};
        this.a("videoApi.setVideoCurrentPosition", arrobject2);
    }

    private void ah() {
        this.D.post(new Runnable(this){
            final /* synthetic */ f a;
            {
                this.a = f2;
            }

            public void run() {
                int n2 = this.a.P();
                if (n2 >= 1000) {
                    this.a.D.postDelayed((Runnable)this, this.a.c(n2));
                }
            }
        });
    }

    private void ai() {
        this.aj();
        this.D.post(new Runnable(this){
            final /* synthetic */ f a;
            private boolean b;
            private final int c;
            {
                this.a = f2;
                this.c = this.a.e(com.startapp.android.publish.adsCommon.b.a().H().d());
            }

            /*
             * Exception decompiling
             */
            public void run(}
        java.lang.IllegalStateException: Parameters not created
        
        
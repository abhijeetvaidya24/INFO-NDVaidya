/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.annotation.TargetApi
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Paint$Align
 *  android.graphics.Paint$FontMetrics
 *  android.graphics.Paint$Style
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.graphics.SurfaceTexture
 *  android.media.MediaPlayer
 *  android.media.MediaPlayer$OnCompletionListener
 *  android.media.MediaPlayer$OnErrorListener
 *  android.media.MediaPlayer$OnPreparedListener
 *  android.media.MediaPlayer$OnSeekCompleteListener
 *  android.view.MotionEvent
 *  android.view.Surface
 *  android.view.TextureView
 *  android.view.TextureView$SurfaceTextureListener
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.ProgressBar
 *  java.io.FileDescriptor
 *  java.io.FileInputStream
 *  java.io.IOException
 *  java.lang.Class
 *  java.lang.Double
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.InterruptedException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.lang.reflect.Method
 *  java.util.ArrayList
 *  java.util.HashMap
 *  java.util.concurrent.ExecutorService
 *  java.util.concurrent.Executors
 *  java.util.concurrent.Future
 *  java.util.concurrent.RejectedExecutionException
 *  org.json.JSONObject
 */
package com.adcolony.sdk;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.adcolony.sdk.AdColonyInterstitial;
import com.adcolony.sdk.ad;
import com.adcolony.sdk.af;
import com.adcolony.sdk.au;
import com.adcolony.sdk.av;
import com.adcolony.sdk.ax;
import com.adcolony.sdk.c;
import com.adcolony.sdk.d;
import com.adcolony.sdk.l;
import com.adcolony.sdk.n;
import com.adcolony.sdk.w;
import com.adcolony.sdk.y;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import org.json.JSONObject;

@TargetApi(value=14)
class av
extends TextureView
implements MediaPlayer.OnCompletionListener,
MediaPlayer.OnErrorListener,
MediaPlayer.OnPreparedListener,
MediaPlayer.OnSeekCompleteListener,
TextureView.SurfaceTextureListener {
    private boolean A;
    private boolean B;
    private boolean C;
    private boolean D;
    private boolean E;
    private String F;
    private String G;
    private FileInputStream H;
    private ad I;
    private c J;
    private Surface K;
    private SurfaceTexture L;
    private RectF M = new RectF();
    private a N;
    private ProgressBar O;
    private MediaPlayer P;
    private JSONObject Q = w.a();
    private ExecutorService R = Executors.newSingleThreadExecutor();
    private ad S;
    private float a;
    private float b;
    private float c;
    private float d;
    private float e;
    private float f;
    private int g;
    private boolean h = true;
    private Paint i = new Paint();
    private Paint j = new Paint(1);
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;
    private int r;
    private double s;
    private double t;
    private long u;
    private boolean v;
    private boolean w;
    private boolean x;
    private boolean y;
    private boolean z;

    av(Context context, ad ad2, int n2, c c2) {
        super(context);
        this.J = c2;
        this.I = ad2;
        this.o = n2;
        this.setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    }

    static /* synthetic */ double a(av av2, double d2) {
        av2.s = d2;
        return d2;
    }

    static /* synthetic */ long a(av av2, long l2) {
        av2.u = l2;
        return l2;
    }

    private boolean a(ad ad2) {
        JSONObject jSONObject = ad2.c();
        return w.c(jSONObject, "id") == this.o && w.c(jSONObject, "container_id") == this.J.d() && w.b(jSONObject, "ad_session_id").equals((Object)this.J.b());
    }

    static /* synthetic */ boolean a(av av2, ad ad2) {
        return av2.a(ad2);
    }

    static /* synthetic */ boolean a(av av2, boolean bl) {
        av2.x = bl;
        return bl;
    }

    static /* synthetic */ double b(av av2, double d2) {
        av2.t = d2;
        return d2;
    }

    private void b(ad ad2) {
        JSONObject jSONObject = ad2.c();
        this.k = w.c(jSONObject, "x");
        this.l = w.c(jSONObject, "y");
        this.m = w.c(jSONObject, "width");
        this.n = w.c(jSONObject, "height");
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)this.getLayoutParams();
        layoutParams.setMargins(this.k, this.l, 0, 0);
        layoutParams.width = this.m;
        layoutParams.height = this.n;
        this.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
        if (this.C && this.N != null) {
            float f2 = this.c;
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int)(f2 * 4.0f), (int)(f2 * 4.0f));
            layoutParams2.setMargins(0, this.J.o() - (int)(4.0f * this.c), 0, 0);
            layoutParams2.gravity = 0;
            this.N.setLayoutParams((ViewGroup.LayoutParams)layoutParams2);
        }
    }

    static /* synthetic */ void b(av av2, ad ad2) {
        av2.b(ad2);
    }

    static /* synthetic */ boolean b(av av2, boolean bl) {
        av2.D = bl;
        return bl;
    }

    private void c(ad ad2) {
        if (w.d(ad2.c(), "visible")) {
            a a2;
            this.setVisibility(0);
            if (this.C && (a2 = this.N) != null) {
                a2.setVisibility(0);
                return;
            }
        } else {
            a a3;
            this.setVisibility(4);
            if (this.C && (a3 = this.N) != null) {
                a3.setVisibility(4);
            }
        }
    }

    static /* synthetic */ void c(av av2, ad ad2) {
        av2.c(ad2);
    }

    static /* synthetic */ boolean c(av av2, boolean bl) {
        av2.w = bl;
        return bl;
    }

    private boolean d(ad ad2) {
        if (!this.z) {
            return false;
        }
        float f2 = (float)w.e(ad2.c(), "volume");
        AdColonyInterstitial adColonyInterstitial = com.adcolony.sdk.a.a().u();
        if (adColonyInterstitial != null) {
            double d2 = (double)f2 DCMPG 0.0;
            boolean bl = false;
            if (d2 <= 0) {
                bl = true;
            }
            adColonyInterstitial.b(bl);
        }
        this.P.setVolume(f2, f2);
        JSONObject jSONObject = w.a();
        w.a(jSONObject, "success", true);
        ad2.a(jSONObject).b();
        return true;
    }

    static /* synthetic */ boolean d(av av2) {
        return av2.v;
    }

    static /* synthetic */ boolean d(av av2, ad ad2) {
        return av2.e(ad2);
    }

    private boolean e(ad ad2) {
        if (!this.z) {
            return false;
        }
        if (this.v) {
            this.v = false;
        }
        this.S = ad2;
        int n2 = w.c(ad2.c(), "time");
        int n3 = n2 * 1000;
        int n4 = this.P.getDuration() / 1000;
        this.P.setOnSeekCompleteListener((MediaPlayer.OnSeekCompleteListener)this);
        this.P.seekTo(n3);
        if (n4 == n2) {
            this.v = true;
        }
        return true;
    }

    static /* synthetic */ boolean e(av av2) {
        return av2.y;
    }

    static /* synthetic */ boolean e(av av2, ad ad2) {
        return av2.d(ad2);
    }

    static /* synthetic */ boolean f(av av2) {
        return av2.A;
    }

    static /* synthetic */ MediaPlayer g(av av2) {
        return av2.P;
    }

    static /* synthetic */ long h(av av2) {
        return av2.u;
    }

    static /* synthetic */ boolean i(av av2) {
        return av2.D;
    }

    static /* synthetic */ double j(av av2) {
        return av2.s;
    }

    private void k() {
        double d2 = this.m;
        double d3 = this.p;
        Double.isNaN((double)d2);
        Double.isNaN((double)d3);
        double d4 = d2 / d3;
        double d5 = this.n;
        double d6 = this.q;
        Double.isNaN((double)d5);
        Double.isNaN((double)d6);
        double d7 = d5 / d6;
        if (d4 > d7) {
            d4 = d7;
        }
        double d8 = this.p;
        Double.isNaN((double)d8);
        int n2 = (int)(d8 * d4);
        double d9 = this.q;
        Double.isNaN((double)d9);
        int n3 = (int)(d9 * d4);
        new y.a().a("setMeasuredDimension to ").a(n2).a(" by ").a(n3).a(y.d);
        this.setMeasuredDimension(n2, n3);
        if (this.B) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)this.getLayoutParams();
            layoutParams.width = n2;
            layoutParams.height = n3;
            layoutParams.gravity = 17;
            layoutParams.setMargins(0, 0, 0, 0);
            this.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
        }
    }

    static /* synthetic */ void k(av av2) {
        av2.l();
    }

    private void l() {
        JSONObject jSONObject = w.a();
        w.a(jSONObject, "id", this.G);
        new ad("AdSession.on_error", this.J.c(), jSONObject).b();
        this.v = true;
    }

    static /* synthetic */ boolean l(av av2) {
        return av2.C;
    }

    private void m() {
        Runnable runnable = new Runnable(){

            /*
             * Exception decompiling
             */
            public void run() {
                // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl6 : ALOAD_0 : trying to set 1 previously set to 0
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
        };
        try {
            this.R.submit(runnable);
            return;
        }
        catch (RejectedExecutionException rejectedExecutionException) {
            this.l();
            return;
        }
    }

    static /* synthetic */ boolean m(av av2) {
        return av2.x;
    }

    static /* synthetic */ JSONObject n(av av2) {
        return av2.Q;
    }

    static /* synthetic */ double p(av av2) {
        return av2.t;
    }

    static /* synthetic */ boolean q(av av2) {
        return av2.w;
    }

    void a() {
        if (this.L != null) {
            this.A = true;
        }
        this.R.shutdown();
    }

    void b() {
        Context context;
        JSONObject jSONObject = this.I.c();
        this.G = w.b(jSONObject, "ad_session_id");
        this.k = w.c(jSONObject, "x");
        this.l = w.c(jSONObject, "y");
        this.m = w.c(jSONObject, "width");
        this.n = w.c(jSONObject, "height");
        this.C = w.d(jSONObject, "enable_timer");
        this.E = w.d(jSONObject, "enable_progress");
        this.F = w.b(jSONObject, "filepath");
        this.p = w.c(jSONObject, "video_width");
        this.q = w.c(jSONObject, "video_height");
        this.f = com.adcolony.sdk.a.a().c.o();
        new y.a().a("Original video dimensions = ").a(this.p).a("x").a(this.q).a(y.b);
        this.setVisibility(4);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.m, this.n);
        layoutParams.setMargins(this.k, this.l, 0, 0);
        layoutParams.gravity = 0;
        this.J.addView((View)this, (ViewGroup.LayoutParams)layoutParams);
        if (this.E && (context = com.adcolony.sdk.a.c()) != null) {
            this.O = new ProgressBar(context);
            c c2 = this.J;
            ProgressBar progressBar = this.O;
            float f2 = this.f;
            c2.addView((View)progressBar, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams((int)(f2 * 100.0f), (int)(f2 * 100.0f), 17));
        }
        this.P = new MediaPlayer();
        this.z = false;
        try {
            if (!this.F.startsWith("http")) {
                this.H = new FileInputStream(this.F);
                this.P.setDataSource(this.H.getFD());
            } else {
                this.B = true;
                this.P.setDataSource(this.F);
            }
            this.P.setOnErrorListener((MediaPlayer.OnErrorListener)this);
            this.P.setOnPreparedListener((MediaPlayer.OnPreparedListener)this);
            this.P.setOnCompletionListener((MediaPlayer.OnCompletionListener)this);
            this.P.prepareAsync();
        }
        catch (IOException iOException) {
            new y.a().a("Failed to create/prepare MediaPlayer: ").a(iOException.toString()).a(y.g);
            this.l();
        }
        this.J.m().add((Object)com.adcolony.sdk.a.a("VideoView.play", new af(this){
            final /* synthetic */ av a;
            {
                this.a = av2;
            }

            public void a(ad ad2) {
                if (av.a(this.a, ad2)) {
                    this.a.e();
                }
            }
        }, true));
        this.J.m().add((Object)com.adcolony.sdk.a.a("VideoView.set_bounds", new af(this){
            final /* synthetic */ av a;
            {
                this.a = av2;
            }

            public void a(ad ad2) {
                if (av.a(this.a, ad2)) {
                    av.b(this.a, ad2);
                }
            }
        }, true));
        this.J.m().add((Object)com.adcolony.sdk.a.a("VideoView.set_visible", new af(this){
            final /* synthetic */ av a;
            {
                this.a = av2;
            }

            public void a(ad ad2) {
                if (av.a(this.a, ad2)) {
                    av.c(this.a, ad2);
                }
            }
        }, true));
        this.J.m().add((Object)com.adcolony.sdk.a.a("VideoView.pause", new af(this){
            final /* synthetic */ av a;
            {
                this.a = av2;
            }

            public void a(ad ad2) {
                if (av.a(this.a, ad2)) {
                    this.a.f();
                }
            }
        }, true));
        this.J.m().add((Object)com.adcolony.sdk.a.a("VideoView.seek_to_time", new af(this){
            final /* synthetic */ av a;
            {
                this.a = av2;
            }

            public void a(ad ad2) {
                if (av.a(this.a, ad2)) {
                    av.d(this.a, ad2);
                }
            }
        }, true));
        this.J.m().add((Object)com.adcolony.sdk.a.a("VideoView.set_volume", new af(this){
            final /* synthetic */ av a;
            {
                this.a = av2;
            }

            public void a(ad ad2) {
                if (av.a(this.a, ad2)) {
                    av.e(this.a, ad2);
                }
            }
        }, true));
        this.J.n().add((Object)"VideoView.play");
        this.J.n().add((Object)"VideoView.set_bounds");
        this.J.n().add((Object)"VideoView.set_visible");
        this.J.n().add((Object)"VideoView.pause");
        this.J.n().add((Object)"VideoView.seek_to_time");
        this.J.n().add((Object)"VideoView.set_volume");
    }

    void c() {
        if (this.h) {
            this.e = (float)(360.0 / this.t);
            this.j.setColor(-3355444);
            this.j.setShadowLayer((float)((int)(2.0f * this.f)), 0.0f, 0.0f, -16777216);
            this.j.setTextAlign(Paint.Align.CENTER);
            this.j.setLinearText(true);
            this.j.setTextSize(12.0f * this.f);
            this.i.setStyle(Paint.Style.STROKE);
            float f2 = this.f;
            float f3 = f2 * 2.0f;
            float f4 = 6.0f;
            if (!(f3 > f4)) {
                f4 = f2 * 2.0f;
            }
            float f5 = 4.0f;
            if (!(f4 < f5)) {
                f5 = f4;
            }
            this.i.setStrokeWidth(f5);
            this.i.setShadowLayer((float)((int)(3.0f * this.f)), 0.0f, 0.0f, -16777216);
            this.i.setColor(-3355444);
            Rect rect = new Rect();
            this.j.getTextBounds("0123456789", 0, 9, rect);
            this.c = rect.height();
            final Context context = com.adcolony.sdk.a.c();
            if (context != null) {
                au.a(new Runnable(){

                    public void run() {
                        av av2 = av.this;
                        av2.N = av2.new a(context);
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int)(4.0f * av.this.c), (int)(4.0f * av.this.c));
                        layoutParams.setMargins(0, av.this.J.o() - (int)(4.0f * av.this.c), 0, 0);
                        layoutParams.gravity = 0;
                        av.this.J.addView((View)av.this.N, (ViewGroup.LayoutParams)layoutParams);
                    }
                });
            }
            this.h = false;
        }
        this.g = (int)(this.t - this.s);
        float f6 = this.c;
        this.a = (int)f6;
        this.b = (int)(3.0f * f6);
        RectF rectF = this.M;
        float f7 = this.a;
        float f8 = f7 - f6 / 2.0f;
        float f9 = this.b;
        rectF.set(f8, f9 - f6 * 2.0f, f7 + f6 * 2.0f, f9 + f6 / 2.0f);
        double d2 = this.e;
        double d3 = this.t - this.s;
        Double.isNaN((double)d2);
        this.d = (float)(d2 * d3);
    }

    /*
     * Exception decompiling
     */
    void d() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl29 : ALOAD_0 : trying to set 1 previously set to 0
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
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

    boolean e() {
        if (!this.z) {
            return false;
        }
        if (!this.y && com.adcolony.sdk.a.b) {
            this.P.start();
            this.m();
            new y.a().a("MediaPlayer is prepared - ADCVideoView play() called.").a(y.b);
        } else if (!this.v && com.adcolony.sdk.a.b) {
            a a2;
            this.P.start();
            this.y = false;
            if (!this.R.isShutdown()) {
                this.m();
            }
            if ((a2 = this.N) != null) {
                a2.invalidate();
            }
        }
        this.setWillNotDraw(false);
        return true;
    }

    boolean f() {
        if (!this.z) {
            new y.a().a("ADCVideoView pause() called while MediaPlayer is not prepared.").a(y.f);
            return false;
        }
        if (!this.x) {
            new y.a().a("Ignoring ADCVideoView pause due to invalid MediaPlayer state.").a(y.d);
            return false;
        }
        this.r = this.P.getCurrentPosition();
        this.t = this.P.getDuration();
        this.P.pause();
        this.y = true;
        new y.a().a("Video view paused").a(y.b);
        return true;
    }

    void g() {
        this.w = true;
    }

    boolean h() {
        return this.P != null;
    }

    MediaPlayer i() {
        return this.P;
    }

    boolean j() {
        return this.v;
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        this.v = true;
        this.s = this.t;
        w.b(this.Q, "id", this.o);
        w.b(this.Q, "container_id", this.J.d());
        w.a(this.Q, "ad_session_id", this.G);
        w.a(this.Q, "elapsed", this.s);
        w.a(this.Q, "duration", this.t);
        new ad("VideoView.on_progress", this.J.c(), this.Q).b();
    }

    public boolean onError(MediaPlayer mediaPlayer, int n2, int n3) {
        this.l();
        y.a a2 = new y.a();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MediaPlayer error: ");
        stringBuilder.append(n2);
        stringBuilder.append(",");
        stringBuilder.append(n3);
        a2.a(stringBuilder.toString()).a(y.g);
        return true;
    }

    public void onMeasure(int n2, int n3) {
        this.k();
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        this.z = true;
        if (this.E) {
            this.J.removeView((View)this.O);
        }
        if (this.B) {
            this.p = mediaPlayer.getVideoWidth();
            this.q = mediaPlayer.getVideoHeight();
            this.k();
            new y.a().a("MediaPlayer getVideoWidth = ").a(mediaPlayer.getVideoWidth()).a(y.d);
            new y.a().a("MediaPlayer getVideoHeight = ").a(mediaPlayer.getVideoHeight()).a(y.d);
        }
        JSONObject jSONObject = w.a();
        w.b(jSONObject, "id", this.o);
        w.b(jSONObject, "container_id", this.J.d());
        w.a(jSONObject, "ad_session_id", this.G);
        new y.a().a("ADCVideoView is prepared").a(y.b);
        new ad("VideoView.on_ready", this.J.c(), jSONObject).b();
    }

    /*
     * Exception decompiling
     */
    public void onSeekComplete(MediaPlayer var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl20 : RETURN : trying to set 0 previously set to 1
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
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

    /*
     * Exception decompiling
     */
    public void onSurfaceTextureAvailable(SurfaceTexture var1, int var2, int var3) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl28 : ALOAD_0 : trying to set 1 previously set to 0
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
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

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.L = surfaceTexture;
        if (!this.A) {
            return false;
        }
        surfaceTexture.release();
        return true;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int n2, int n3) {
        this.L = surfaceTexture;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.L = surfaceTexture;
    }

    @SuppressLint(value={"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        l l2 = com.adcolony.sdk.a.a();
        d d2 = l2.l();
        int n2 = 255 & motionEvent.getAction();
        if (n2 != 0 && n2 != 1 && n2 != 3 && n2 != 2 && n2 != 5 && n2 != 6) {
            return false;
        }
        int n3 = (int)motionEvent.getX();
        int n4 = (int)motionEvent.getY();
        JSONObject jSONObject = w.a();
        w.b(jSONObject, "view_id", this.o);
        w.a(jSONObject, "ad_session_id", this.G);
        w.b(jSONObject, "container_x", n3 + this.k);
        w.b(jSONObject, "container_y", n4 + this.l);
        w.b(jSONObject, "view_x", n3);
        w.b(jSONObject, "view_y", n4);
        w.b(jSONObject, "id", this.J.d());
        if (n2 != 0) {
            if (n2 != 1) {
                if (n2 != 2) {
                    if (n2 != 3) {
                        if (n2 != 5) {
                            if (n2 != 6) {
                                return true;
                            }
                            int n5 = (65280 & motionEvent.getAction()) >> 8;
                            w.b(jSONObject, "container_x", (int)motionEvent.getX(n5) + this.k);
                            w.b(jSONObject, "container_y", (int)motionEvent.getY(n5) + this.l);
                            w.b(jSONObject, "view_x", (int)motionEvent.getX(n5));
                            w.b(jSONObject, "view_y", (int)motionEvent.getY(n5));
                            if (!this.J.q()) {
                                l2.a((ax)((Object)d2.f().get((Object)this.G)));
                            }
                            new ad("AdContainer.on_touch_ended", this.J.c(), jSONObject).b();
                            return true;
                        }
                        int n6 = (65280 & motionEvent.getAction()) >> 8;
                        w.b(jSONObject, "container_x", (int)motionEvent.getX(n6) + this.k);
                        w.b(jSONObject, "container_y", (int)motionEvent.getY(n6) + this.l);
                        w.b(jSONObject, "view_x", (int)motionEvent.getX(n6));
                        w.b(jSONObject, "view_y", (int)motionEvent.getY(n6));
                        new ad("AdContainer.on_touch_began", this.J.c(), jSONObject).b();
                        return true;
                    }
                    new ad("AdContainer.on_touch_cancelled", this.J.c(), jSONObject).b();
                    return true;
                }
                new ad("AdContainer.on_touch_moved", this.J.c(), jSONObject).b();
                return true;
            }
            if (!this.J.q()) {
                l2.a((ax)((Object)d2.f().get((Object)this.G)));
            }
            new ad("AdContainer.on_touch_ended", this.J.c(), jSONObject).b();
            return true;
        }
        new ad("AdContainer.on_touch_began", this.J.c(), jSONObject).b();
        return true;
    }

    private class a
    extends View {
        a(Context context) {
            super(context);
            this.setWillNotDraw(false);
            try {
                Class class_ = this.getClass();
                Class[] arrclass = new Class[]{Integer.TYPE, Paint.class};
                Method method = class_.getMethod("setLayerType", arrclass);
                Object[] arrobject = new Object[]{1, null};
                method.invoke((Object)this, arrobject);
            }
            catch (Exception exception) {}
        }

        public void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawArc(av.this.M, 270.0f, av.this.d, false, av.this.i);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("");
            stringBuilder.append(av.this.g);
            String string = stringBuilder.toString();
            float f2 = av.this.M.centerX();
            double d2 = av.this.M.centerY();
            double d3 = av.x((av)av.this).getFontMetrics().bottom;
            Double.isNaN((double)d3);
            double d4 = d3 * 1.35;
            Double.isNaN((double)d2);
            canvas.drawText(string, f2, (float)(d2 + d4), av.this.j);
            this.invalidate();
        }
    }

}


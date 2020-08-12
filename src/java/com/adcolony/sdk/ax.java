/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.BitmapFactory
 *  android.media.MediaPlayer
 *  android.media.SoundPool
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.ImageView
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.concurrent.ExecutorService
 *  java.util.concurrent.Executors
 *  java.util.concurrent.Future
 *  java.util.concurrent.RejectedExecutionException
 *  org.json.JSONObject
 */
package com.adcolony.sdk;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.adcolony.sdk.a;
import com.adcolony.sdk.ac;
import com.adcolony.sdk.ad;
import com.adcolony.sdk.ao;
import com.adcolony.sdk.c;
import com.adcolony.sdk.d;
import com.adcolony.sdk.e;
import com.adcolony.sdk.f;
import com.adcolony.sdk.w;
import com.adcolony.sdk.y;
import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import org.json.JSONObject;

class ax
extends FrameLayout {
    float a = 1.0f;
    int b = 2;
    private c c;
    private c d;
    private e e;
    private String f;
    private String g;
    private boolean h;
    private boolean i;
    private boolean j;
    private boolean k;
    private ImageView l;
    private String m = "";
    private String n = "";
    private String o = "";
    private String p = "";
    private ExecutorService q = Executors.newSingleThreadExecutor();

    ax(Context context, ad ad2, e e2) {
        super(context);
        this.e = e2;
        this.p = e2.a;
        this.f = w.b(ad2.c(), "id");
        new y.a().a("Retrieving container tied to ad session id: ").a(this.f).a(y.b);
        this.c = (c)((Object)a.a().l().b().get((Object)this.f));
        this.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(this.c.p(), this.c.o()));
        this.addView((View)this.c);
        this.d();
    }

    static /* synthetic */ String a(ax ax2) {
        return ax2.f;
    }

    static /* synthetic */ boolean a(ax ax2, boolean bl) {
        ax2.k = bl;
        return bl;
    }

    static /* synthetic */ boolean b(ax ax2) {
        return ax2.i;
    }

    static /* synthetic */ boolean b(ax ax2, boolean bl) {
        ax2.h = bl;
        return bl;
    }

    static /* synthetic */ c c(ax ax2) {
        return ax2.c;
    }

    private void d() {
        Runnable runnable = new Runnable(){

            /*
             * Exception decompiling
             */
            public void run() {
                // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                // org.benf.cfr.reader.util.ConfusedCFRException: Underrun type stack
                // org.benf.cfr.reader.b.a.c.e.a(StackSim.java:35)
                // org.benf.cfr.reader.b.b.af.a(OperationFactoryPop.java:20)
                // org.benf.cfr.reader.b.b.e.a(JVMInstr.java:315)
                // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:195)
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
            this.q.submit(runnable);
            return;
        }
        catch (RejectedExecutionException rejectedExecutionException) {
            JSONObject jSONObject = w.a();
            w.a(jSONObject, "id", this.f);
            new ad("AdSession.on_error", this.c.c(), jSONObject).b();
            return;
        }
    }

    static /* synthetic */ boolean d(ax ax2) {
        return ax2.k;
    }

    static /* synthetic */ boolean e(ax ax2) {
        return ax2.h;
    }

    static /* synthetic */ boolean f(ax ax2) {
        return ax2.j;
    }

    boolean a() {
        f f2;
        d d2 = a.a().l();
        d2.a(this.c);
        c c2 = this.d;
        if (c2 != null) {
            d2.a(c2);
        }
        if ((f2 = (f)d2.g().remove((Object)this.f)) != null) {
            for (MediaPlayer mediaPlayer : f2.c().c().values()) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                }
                mediaPlayer.release();
            }
            f2.d().a().autoPause();
            f2.d().a().release();
        }
        d2.f().remove((Object)this.f);
        this.c = null;
        this.e = null;
        this.removeAllViews();
        this.q.shutdown();
        return true;
    }

    boolean b() {
        Context context;
        if (!this.g.equals((Object)"") && (context = a.c()) != null) {
            this.l = new ImageView(context);
            this.l.setImageBitmap(BitmapFactory.decodeFile((String)this.g));
            return true;
        }
        return false;
    }

    boolean c() {
        return this.i;
    }

    String getAdSessionId() {
        return this.f;
    }

    String getAdvertiserName() {
        return this.m;
    }

    c getContainer() {
        return this.c;
    }

    String getDescription() {
        return this.o;
    }

    c getExpandedContainer() {
        return this.d;
    }

    ImageView getIcon() {
        return this.l;
    }

    e getListener() {
        return this.e;
    }

    String getTitle() {
        return this.n;
    }

    public String getZoneID() {
        if (this.i) {
            new y.a().a("Ignoring call to getZoneID() as view has been destroyed").a(y.e);
            return "";
        }
        return this.p;
    }

    void setAdvertiserName(String string) {
        this.m = string;
    }

    void setDescription(String string) {
        this.o = string;
    }

    void setExpandedContainer(c c2) {
        this.d = c2;
    }

    void setImageFilepath(String string) {
        this.g = string;
    }

    void setNative(boolean bl) {
        this.j = bl;
    }

    void setTitle(String string) {
        this.n = string;
    }

}


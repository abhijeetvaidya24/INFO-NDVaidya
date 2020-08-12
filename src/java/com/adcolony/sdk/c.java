/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewParent
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.TextView
 *  android.widget.VideoView
 *  java.lang.Boolean
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Thread
 *  java.util.ArrayList
 *  java.util.HashMap
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 *  org.json.JSONObject
 */
package com.adcolony.sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.VideoView;
import com.adcolony.sdk.AdColonyAppOptions;
import com.adcolony.sdk.a;
import com.adcolony.sdk.ad;
import com.adcolony.sdk.ae;
import com.adcolony.sdk.af;
import com.adcolony.sdk.ag;
import com.adcolony.sdk.as;
import com.adcolony.sdk.au;
import com.adcolony.sdk.av;
import com.adcolony.sdk.aw;
import com.adcolony.sdk.ax;
import com.adcolony.sdk.ba;
import com.adcolony.sdk.c;
import com.adcolony.sdk.d;
import com.adcolony.sdk.h;
import com.adcolony.sdk.l;
import com.adcolony.sdk.n;
import com.adcolony.sdk.r;
import com.adcolony.sdk.u;
import com.adcolony.sdk.w;
import com.adcolony.sdk.y;
import com.integralads.avid.library.adcolony.session.AvidManagedVideoAdSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

class c
extends FrameLayout {
    boolean a;
    boolean b;
    Context c;
    VideoView d;
    private HashMap<Integer, av> e;
    private HashMap<Integer, as> f;
    private HashMap<Integer, aw> g;
    private HashMap<Integer, h> h;
    private HashMap<Integer, r> i;
    private HashMap<Integer, u> j;
    private HashMap<Integer, Boolean> k;
    private HashMap<Integer, View> l;
    private int m;
    private int n;
    private int o;
    private int p;
    private String q;
    private float r = 0.0f;
    private double s = 0.0;
    private long t = 0L;
    private ArrayList<af> u;
    private ArrayList<String> v;
    private boolean w;
    private boolean x;
    private boolean y;
    private AvidManagedVideoAdSession z;

    c(Context context, String string) {
        super(context);
        this.c = context;
        this.q = string;
        this.setBackgroundColor(-16777216);
    }

    private void a(float f2, double d2) {
        JSONObject jSONObject = w.a();
        w.b(jSONObject, "id", this.o);
        w.a(jSONObject, "ad_session_id", this.q);
        w.a(jSONObject, "exposure", f2);
        w.a(jSONObject, "volume", d2);
        new ad("AdContainer.on_exposure_change", this.p, jSONObject).b();
    }

    private void d(final boolean bl) {
        new Thread(new Runnable(new Runnable(){

            public void run() {
                if (c.this.t == 0L) {
                    c.this.t = System.currentTimeMillis();
                }
                View view = (View)c.this.getParent();
                Context context = a.c();
                float f2 = ba.a(view, context, true, bl, true);
                double d2 = context == null ? 0.0 : au.b(au.a(context));
                long l2 = System.currentTimeMillis();
                if (200L + c.this.t < l2) {
                    c.this.t = l2;
                    if (c.this.r != f2 || c.this.s != d2) {
                        c.this.a(f2, d2);
                    }
                    c.this.r = f2;
                    c.this.s = d2;
                }
            }
        }){
            final /* synthetic */ Runnable a;
            {
                this.a = runnable;
            }

            /*
             * Exception decompiling
             */
            public void run() {
                // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl1 : ALOAD_0 : trying to set 1 previously set to 0
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

    void a(int n2) {
        this.n = n2;
    }

    void a(View view) {
        AvidManagedVideoAdSession avidManagedVideoAdSession = this.z;
        if (avidManagedVideoAdSession != null && view != null) {
            avidManagedVideoAdSession.registerFriendlyObstruction(view);
        }
    }

    void a(AvidManagedVideoAdSession avidManagedVideoAdSession) {
        this.z = avidManagedVideoAdSession;
        this.a((Map)this.l);
    }

    void a(Map map) {
        if (this.z != null) {
            if (map == null) {
                return;
            }
            for (Map.Entry entry : map.entrySet()) {
                this.z.registerFriendlyObstruction((View)entry.getValue());
            }
        }
    }

    void a(boolean bl) {
        this.w = bl;
    }

    boolean a(ad ad2) {
        JSONObject jSONObject = ad2.c();
        return w.c(jSONObject, "container_id") == this.o && w.b(jSONObject, "ad_session_id").equals((Object)this.q);
    }

    String b() {
        return this.q;
    }

    void b(int n2) {
        this.m = n2;
    }

    void b(ad ad2) {
        this.e = new HashMap();
        this.f = new HashMap();
        this.g = new HashMap();
        this.h = new HashMap();
        this.i = new HashMap();
        this.j = new HashMap();
        this.k = new HashMap();
        this.l = new HashMap();
        this.u = new ArrayList();
        this.v = new ArrayList();
        JSONObject jSONObject = ad2.c();
        this.o = w.c(jSONObject, "id");
        this.m = w.c(jSONObject, "width");
        this.n = w.c(jSONObject, "height");
        this.p = w.c(jSONObject, "module_id");
        this.b = w.d(jSONObject, "viewability_enabled");
        boolean bl = this.o == 1;
        this.w = bl;
        l l2 = a.a();
        if (this.m == 0 && this.n == 0) {
            this.m = l2.c.p();
            int n2 = l2.d().getMultiWindowEnabled() ? l2.c.q() - au.c(a.c()) : l2.c.q();
            this.n = n2;
        } else {
            this.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(this.m, this.n));
        }
        this.u.add((Object)a.a("VideoView.create", new af(this){
            final /* synthetic */ c a;
            {
                this.a = c2;
            }

            public void a(ad ad2) {
                if (this.a.a(ad2)) {
                    c c2 = this.a;
                    c2.a((View)c2.g(ad2));
                }
            }
        }, true));
        this.u.add((Object)a.a("VideoView.destroy", new af(this){
            final /* synthetic */ c a;
            {
                this.a = c2;
            }

            public void a(ad ad2) {
                if (this.a.a(ad2)) {
                    this.a.h(ad2);
                }
            }
        }, true));
        this.u.add((Object)a.a("WebView.create", new af(this){
            final /* synthetic */ c a;
            {
                this.a = c2;
            }

            public void a(ad ad2) {
                if (this.a.a(ad2)) {
                    c c2 = this.a;
                    c2.a((View)c2.i(ad2));
                }
            }
        }, true));
        this.u.add((Object)a.a("WebView.destroy", new af(this){
            final /* synthetic */ c a;
            {
                this.a = c2;
            }

            public void a(ad ad2) {
                if (this.a.a(ad2)) {
                    this.a.j(ad2);
                }
            }
        }, true));
        this.u.add((Object)a.a("TextView.create", new af(this){
            final /* synthetic */ c a;
            {
                this.a = c2;
            }

            public void a(ad ad2) {
                if (this.a.a(ad2)) {
                    c c2 = this.a;
                    c2.a(c2.k(ad2));
                }
            }
        }, true));
        this.u.add((Object)a.a("TextView.destroy", new af(this){
            final /* synthetic */ c a;
            {
                this.a = c2;
            }

            public void a(ad ad2) {
                if (this.a.a(ad2)) {
                    this.a.l(ad2);
                }
            }
        }, true));
        this.u.add((Object)a.a("ImageView.create", new af(this){
            final /* synthetic */ c a;
            {
                this.a = c2;
            }

            public void a(ad ad2) {
                if (this.a.a(ad2)) {
                    c c2 = this.a;
                    c2.a((View)c2.e(ad2));
                }
            }
        }, true));
        this.u.add((Object)a.a("ImageView.destroy", new af(this){
            final /* synthetic */ c a;
            {
                this.a = c2;
            }

            public void a(ad ad2) {
                if (this.a.a(ad2)) {
                    this.a.f(ad2);
                }
            }
        }, true));
        this.u.add((Object)a.a("ColorView.create", new af(this){
            final /* synthetic */ c a;
            {
                this.a = c2;
            }

            public void a(ad ad2) {
                if (this.a.a(ad2)) {
                    c c2 = this.a;
                    c2.a(c2.c(ad2));
                }
            }
        }, true));
        this.u.add((Object)a.a("ColorView.destroy", new af(this){
            final /* synthetic */ c a;
            {
                this.a = c2;
            }

            public void a(ad ad2) {
                if (this.a.a(ad2)) {
                    this.a.d(ad2);
                }
            }
        }, true));
        this.v.add((Object)"VideoView.create");
        this.v.add((Object)"VideoView.destroy");
        this.v.add((Object)"WebView.create");
        this.v.add((Object)"WebView.destroy");
        this.v.add((Object)"TextView.create");
        this.v.add((Object)"TextView.destroy");
        this.v.add((Object)"ImageView.create");
        this.v.add((Object)"ImageView.destroy");
        this.v.add((Object)"ColorView.create");
        this.v.add((Object)"ColorView.destroy");
        this.d = new VideoView(this.c);
        this.d.setVisibility(8);
        this.addView((View)this.d);
        this.setClipToPadding(false);
        if (this.b) {
            this.d(w.d(ad2.c(), "advanced_viewability"));
        }
    }

    void b(boolean bl) {
        this.y = bl;
    }

    int c() {
        return this.p;
    }

    h c(ad ad2) {
        int n2 = w.c(ad2.c(), "id");
        h h2 = new h(this.c, ad2, n2, this);
        h2.a();
        this.h.put((Object)n2, (Object)h2);
        this.l.put((Object)n2, (Object)h2);
        return h2;
    }

    void c(boolean bl) {
        this.x = bl;
    }

    int d() {
        return this.o;
    }

    boolean d(ad ad2) {
        int n2 = w.c(ad2.c(), "id");
        View view = (View)this.l.remove((Object)n2);
        h h2 = (h)((Object)this.h.remove((Object)n2));
        if (view != null && h2 != null) {
            this.removeView((View)h2);
            return true;
        }
        d d2 = a.a().l();
        String string = ad2.d();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("");
        stringBuilder.append(n2);
        d2.a(string, stringBuilder.toString());
        return false;
    }

    u e(ad ad2) {
        int n2 = w.c(ad2.c(), "id");
        u u2 = new u(this.c, ad2, n2, this);
        u2.a();
        this.j.put((Object)n2, (Object)u2);
        this.l.put((Object)n2, (Object)u2);
        return u2;
    }

    HashMap<Integer, av> e() {
        return this.e;
    }

    HashMap<Integer, as> f() {
        return this.f;
    }

    boolean f(ad ad2) {
        int n2 = w.c(ad2.c(), "id");
        View view = (View)this.l.remove((Object)n2);
        u u2 = (u)((Object)this.j.remove((Object)n2));
        if (view != null && u2 != null) {
            this.removeView((View)u2);
            return true;
        }
        d d2 = a.a().l();
        String string = ad2.d();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("");
        stringBuilder.append(n2);
        d2.a(string, stringBuilder.toString());
        return false;
    }

    av g(ad ad2) {
        int n2 = w.c(ad2.c(), "id");
        av av2 = new av(this.c, ad2, n2, this);
        av2.b();
        this.e.put((Object)n2, (Object)av2);
        this.l.put((Object)n2, (Object)av2);
        return av2;
    }

    HashMap<Integer, aw> g() {
        return this.g;
    }

    boolean h(ad ad2) {
        int n2 = w.c(ad2.c(), "id");
        View view = (View)this.l.remove((Object)n2);
        av av2 = (av)((Object)this.e.remove((Object)n2));
        if (view != null && av2 != null) {
            if (av2.h()) {
                av2.d();
            }
            av2.a();
            this.removeView((View)av2);
            return true;
        }
        d d2 = a.a().l();
        String string = ad2.d();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("");
        stringBuilder.append(n2);
        d2.a(string, stringBuilder.toString());
        return false;
    }

    aw i(ad ad2) {
        aw aw2;
        JSONObject jSONObject = ad2.c();
        int n2 = w.c(jSONObject, "id");
        boolean bl = w.d(jSONObject, "is_module");
        l l2 = a.a();
        if (bl) {
            aw2 = (aw)l2.x().get((Object)w.c(jSONObject, "module_id"));
            if (aw2 == null) {
                new y.a().a("Module WebView created with invalid id").a(y.g);
                return null;
            }
            aw2.a(ad2, n2, this);
        } else {
            Context context = this.c;
            int n3 = l2.p().d();
            aw2 = new aw(context, ad2, n2, n3, this);
        }
        this.g.put((Object)n2, (Object)aw2);
        this.l.put((Object)n2, (Object)aw2);
        JSONObject jSONObject2 = w.a();
        w.b(jSONObject2, "module_id", aw2.a());
        ad2.a(jSONObject2).b();
        return aw2;
    }

    HashMap<Integer, r> i() {
        return this.i;
    }

    HashMap<Integer, u> j() {
        return this.j;
    }

    boolean j(ad ad2) {
        int n2 = w.c(ad2.c(), "id");
        l l2 = a.a();
        View view = (View)this.l.remove((Object)n2);
        aw aw2 = (aw)this.g.remove((Object)n2);
        if (aw2 != null && view != null) {
            l2.p().a(aw2.a());
            this.removeView((View)aw2);
            return true;
        }
        d d2 = l2.l();
        String string = ad2.d();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("");
        stringBuilder.append(n2);
        d2.a(string, stringBuilder.toString());
        return false;
    }

    @SuppressLint(value={"InlinedApi"})
    View k(ad ad2) {
        JSONObject jSONObject = ad2.c();
        int n2 = w.c(jSONObject, "id");
        if (w.d(jSONObject, "editable")) {
            r r2 = new r(this.c, ad2, n2, this);
            r2.a();
            this.i.put((Object)n2, (Object)r2);
            this.l.put((Object)n2, (Object)r2);
            this.k.put((Object)n2, (Object)true);
            return r2;
        }
        if (!w.d(jSONObject, "button")) {
            as as2 = new as(this.c, ad2, n2, this);
            as2.a();
            this.f.put((Object)n2, (Object)as2);
            this.l.put((Object)n2, (Object)as2);
            this.k.put((Object)n2, (Object)false);
            return as2;
        }
        as as3 = new as(this.c, 16974145, ad2, n2, this);
        as3.a();
        this.f.put((Object)n2, (Object)as3);
        this.l.put((Object)n2, (Object)as3);
        this.k.put((Object)n2, (Object)false);
        return as3;
    }

    HashMap<Integer, Boolean> k() {
        return this.k;
    }

    HashMap<Integer, View> l() {
        return this.l;
    }

    boolean l(ad ad2) {
        int n2 = w.c(ad2.c(), "id");
        View view = (View)this.l.remove((Object)n2);
        TextView textView = (Boolean)this.k.remove((Object)this.o) != false ? (TextView)this.i.remove((Object)n2) : (TextView)this.f.remove((Object)n2);
        if (view != null && textView != null) {
            this.removeView((View)textView);
            return true;
        }
        d d2 = a.a().l();
        String string = ad2.d();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("");
        stringBuilder.append(n2);
        d2.a(string, stringBuilder.toString());
        return false;
    }

    ArrayList<af> m() {
        return this.u;
    }

    ArrayList<String> n() {
        return this.v;
    }

    int o() {
        return this.n;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @SuppressLint(value={"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int n2 = 255 & motionEvent.getAction();
        if (n2 != 0 && n2 != 1 && n2 != 3 && n2 != 2 && n2 != 5 && n2 != 6) {
            return false;
        }
        l l2 = a.a();
        d d2 = l2.l();
        int n3 = (int)motionEvent.getX();
        int n4 = (int)motionEvent.getY();
        JSONObject jSONObject = w.a();
        w.b(jSONObject, "view_id", -1);
        w.a(jSONObject, "ad_session_id", this.q);
        w.b(jSONObject, "container_x", n3);
        w.b(jSONObject, "container_y", n4);
        w.b(jSONObject, "view_x", n3);
        w.b(jSONObject, "view_y", n4);
        w.b(jSONObject, "id", this.o);
        if (n2 != 0) {
            if (n2 != 1) {
                if (n2 != 2) {
                    if (n2 != 3) {
                        if (n2 != 5) {
                            if (n2 != 6) {
                                return true;
                            }
                            int n5 = (65280 & motionEvent.getAction()) >> 8;
                            w.b(jSONObject, "container_x", (int)motionEvent.getX(n5));
                            w.b(jSONObject, "container_y", (int)motionEvent.getY(n5));
                            w.b(jSONObject, "view_x", (int)motionEvent.getX(n5));
                            w.b(jSONObject, "view_y", (int)motionEvent.getY(n5));
                            w.b(jSONObject, "x", (int)motionEvent.getX(n5));
                            w.b(jSONObject, "y", (int)motionEvent.getY(n5));
                            if (!this.w) {
                                l2.a((ax)((Object)d2.f().get((Object)this.q)));
                            }
                            new ad("AdContainer.on_touch_ended", this.p, jSONObject).b();
                            return true;
                        }
                        int n6 = (65280 & motionEvent.getAction()) >> 8;
                        w.b(jSONObject, "container_x", (int)motionEvent.getX(n6));
                        w.b(jSONObject, "container_y", (int)motionEvent.getY(n6));
                        w.b(jSONObject, "view_x", (int)motionEvent.getX(n6));
                        w.b(jSONObject, "view_y", (int)motionEvent.getY(n6));
                        new ad("AdContainer.on_touch_began", this.p, jSONObject).b();
                        return true;
                    }
                    new ad("AdContainer.on_touch_cancelled", this.p, jSONObject).b();
                    return true;
                }
                new ad("AdContainer.on_touch_moved", this.p, jSONObject).b();
                return true;
            }
            if (!this.w) {
                l2.a((ax)((Object)d2.f().get((Object)this.q)));
            }
            new ad("AdContainer.on_touch_ended", this.p, jSONObject).b();
            return true;
        }
        new ad("AdContainer.on_touch_began", this.p, jSONObject).b();
        return true;
    }

    int p() {
        return this.m;
    }

    boolean q() {
        return this.w;
    }

    boolean r() {
        return this.y;
    }

    boolean s() {
        return this.x;
    }

}


/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.SharedPreferences
 *  android.os.Handler
 *  android.view.View
 *  android.view.ViewParent
 *  com.chartboost.sdk.Tracking.a
 *  com.chartboost.sdk.c
 *  com.chartboost.sdk.d
 *  com.chartboost.sdk.e
 *  com.chartboost.sdk.e$a
 *  com.chartboost.sdk.i
 *  com.chartboost.sdk.impl.ad
 *  com.chartboost.sdk.impl.ah
 *  com.chartboost.sdk.impl.aj
 *  com.chartboost.sdk.impl.aj$a
 *  com.chartboost.sdk.impl.ak
 *  com.chartboost.sdk.impl.al
 *  com.chartboost.sdk.impl.ap
 *  com.chartboost.sdk.impl.bc
 *  com.chartboost.sdk.impl.bf
 *  com.chartboost.sdk.impl.c
 *  com.chartboost.sdk.impl.c$a
 *  com.chartboost.sdk.impl.s
 *  com.chartboost.sdk.impl.u
 *  com.chartboost.sdk.impl.v
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Float
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.util.Locale
 *  org.json.JSONObject
 */
package com.chartboost.sdk.Model;

import android.content.SharedPreferences;
import android.os.Handler;
import android.view.View;
import android.view.ViewParent;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.f;
import com.chartboost.sdk.Model.CBError;
import com.chartboost.sdk.a;
import com.chartboost.sdk.d;
import com.chartboost.sdk.e;
import com.chartboost.sdk.i;
import com.chartboost.sdk.impl.ad;
import com.chartboost.sdk.impl.ah;
import com.chartboost.sdk.impl.aj;
import com.chartboost.sdk.impl.ak;
import com.chartboost.sdk.impl.al;
import com.chartboost.sdk.impl.ap;
import com.chartboost.sdk.impl.bc;
import com.chartboost.sdk.impl.bf;
import com.chartboost.sdk.impl.c;
import com.chartboost.sdk.impl.s;
import com.chartboost.sdk.impl.u;
import com.chartboost.sdk.impl.v;
import java.util.Locale;
import org.json.JSONObject;

public class c {
    private boolean A;
    private Boolean B = null;
    private e C;
    private Runnable D;
    public final com.chartboost.sdk.impl.c a;
    public final f b;
    public final ah c;
    public final ap d;
    public final com.chartboost.sdk.Tracking.a e;
    public final Handler f;
    public final com.chartboost.sdk.c g;
    public final ak h;
    public final d i;
    public final al j;
    public final com.chartboost.sdk.Model.d k;
    public int l;
    public final String m;
    public int n;
    public final String o;
    public final com.chartboost.sdk.Model.a p;
    public final SharedPreferences q;
    public boolean r;
    public bc s;
    public boolean t = false;
    public boolean u = false;
    public boolean v = false;
    public aj w;
    public boolean x;
    public boolean y = false;
    public boolean z = false;

    public c(com.chartboost.sdk.Model.a a2, com.chartboost.sdk.Model.d d2, f f2, ah ah2, ap ap2, SharedPreferences sharedPreferences, com.chartboost.sdk.Tracking.a a3, Handler handler, com.chartboost.sdk.c c2, ak ak2, d d3, al al2, com.chartboost.sdk.impl.c c3, String string2, String string3) {
        this.p = a2;
        this.a = c3;
        this.b = f2;
        this.c = ah2;
        this.d = ap2;
        this.e = a3;
        this.f = handler;
        this.g = c2;
        this.h = ak2;
        this.i = d3;
        this.j = al2;
        this.k = d2;
        this.l = 0;
        this.r = false;
        this.x = false;
        this.z = true;
        this.n = 3;
        this.m = string2;
        this.o = string3;
        this.A = true;
        this.q = sharedPreferences;
    }

    private boolean x() {
        return this.B != null;
    }

    private boolean y() {
        return this.B;
    }

    public void a(CBError.CBImpressionError cBImpressionError) {
        this.k.a(this, cBImpressionError);
    }

    public void a(Runnable runnable) {
        this.D = runnable;
    }

    void a(String string2, JSONObject jSONObject) {
        d d2;
        Handler handler = this.f;
        com.chartboost.sdk.impl.c c2 = this.a;
        c2.getClass();
        handler.post((Runnable)new c.a(c2, 1, this.m, null));
        if (this.b() && this.l == 2 && (d2 = this.g.c()) != null) {
            d2.b(this);
        }
        if (true ^ s.a().a((CharSequence)string2)) {
            Object object;
            int n2;
            aj aj2 = new aj("/api/click", this.d, this.e, 2, null);
            if (!this.p.f.isEmpty()) {
                aj2.a("ad_id", (Object)this.p.f);
            }
            if (!this.p.m.isEmpty()) {
                aj2.a("to", (Object)this.p.m);
            }
            if (!this.p.g.isEmpty()) {
                aj2.a("cgn", (Object)this.p.g);
            }
            if (!this.p.h.isEmpty()) {
                aj2.a("creative", (Object)this.p.h);
            }
            if (((n2 = this.n) == 1 || n2 == 2) && (object = this.p.b == 0 && this.k() != null ? (v)this.u() : (this.p.b == 1 && this.k() != null ? (bf)this.u() : null)) != null) {
                float f2 = object.k();
                float f3 = object.j();
                String string3 = this.getClass().getSimpleName();
                Locale locale = Locale.US;
                Object[] arrobject = new Object[]{Float.valueOf((float)f3), Float.valueOf((float)f2)};
                CBLogging.a(string3, String.format((Locale)locale, (String)"TotalDuration: %f PlaybackTime: %f", (Object[])arrobject));
                float f4 = f3 / 1000.0f;
                aj2.a("total_time", (Object)Float.valueOf((float)f4));
                if (f2 <= 0.0f) {
                    aj2.a("playback_time", (Object)Float.valueOf((float)f4));
                } else {
                    aj2.a("playback_time", (Object)Float.valueOf((float)(f2 / 1000.0f)));
                }
            }
            if (jSONObject != null) {
                aj2.a("click_coordinates", (Object)jSONObject);
            }
            aj2.a("location", (Object)this.m);
            if (this.x()) {
                aj2.a("retarget_reinstall", (Object)this.y());
            }
            this.w = aj2;
            this.h.a(this, string2, null);
        } else {
            this.h.a(this, false, string2, CBError.CBClickError.URI_INVALID, null);
        }
        this.e.c(this.a.a(this.p.b), this.m, this.o());
    }

    public boolean a() {
        this.l = 0;
        if (this.p.b == 0) {
            int n2 = this.a.a;
            if (n2 != 0) {
                if (n2 == 1) {
                    this.n = 2;
                    this.C = new v(this, this.b, this.f, this.g);
                    this.A = false;
                }
            } else if (this.p.p.equals((Object)"video")) {
                this.n = 1;
                this.C = new v(this, this.b, this.f, this.g);
                this.A = false;
            } else {
                this.n = 0;
                this.C = new u(this, this.f, this.g);
            }
        } else {
            int n3 = this.a.a;
            if (n3 != 0) {
                if (n3 == 1) {
                    this.n = 2;
                    this.A = false;
                }
            } else if (this.p.p.equals((Object)"video")) {
                this.n = 1;
                this.A = false;
            } else {
                this.n = 0;
            }
            bf bf2 = new bf(this, this.b, this.c, this.q, this.e, this.f, this.g, this.i);
            this.C = bf2;
        }
        return this.C.a(this.p.a);
    }

    public boolean a(JSONObject jSONObject) {
        if (this.l == 2) {
            String string2;
            block10 : {
                if (this.t) {
                    return false;
                }
                string2 = this.p.j;
                String string3 = this.p.i;
                if (!string3.isEmpty()) {
                    Exception exception;
                    block11 : {
                        block9 : {
                            boolean bl = this.h.a(string3);
                            if (!bl) break block9;
                            try {
                                this.B = Boolean.TRUE;
                                string2 = string3;
                                break block10;
                            }
                            catch (Exception exception2) {
                                exception = exception2;
                                string2 = string3;
                                break block11;
                            }
                        }
                        try {
                            this.B = Boolean.FALSE;
                            break block10;
                        }
                        catch (Exception exception3) {
                            // empty catch block
                        }
                    }
                    com.chartboost.sdk.Tracking.a.a((Class)this.getClass(), (String)"onClick", (Exception)exception);
                }
            }
            if (this.x) {
                return false;
            }
            this.x = true;
            this.z = false;
            this.a(string2, jSONObject);
            return true;
        }
        return false;
    }

    public boolean b() {
        return this.A;
    }

    public void c() {
        this.z = true;
        this.g.b(this);
        this.k.b(this);
    }

    public void d() {
        this.k.a(this);
    }

    public void e() {
        this.u = true;
        this.A = true;
        if (this.a.a == 1 && i.c != null) {
            i.c.didCompleteRewardedVideo(this.m, this.p.k);
        }
        this.w();
    }

    public void f() {
        this.v = true;
    }

    public boolean g() {
        e e2 = this.C;
        if (e2 != null) {
            e2.b();
            if (this.C.e() != null) {
                return true;
            }
        } else {
            CBLogging.b("CBImpression", "reinitializing -- no view protocol exists!!");
        }
        CBLogging.e("CBImpression", "reinitializing -- view not yet created");
        return false;
    }

    public void h() {
        this.i();
        if (!this.r) {
            return;
        }
        e e2 = this.C;
        if (e2 != null) {
            e2.d();
        }
        this.C = null;
        CBLogging.e("CBImpression", "Destroying the view and view data");
    }

    public void i() {
        e e2;
        bc bc2 = this.s;
        if (bc2 != null) {
            bc2.b();
            try {
                if (this.C != null && this.C.e() != null && this.C.e().getParent() != null) {
                    this.s.removeView((View)this.C.e());
                }
            }
            catch (Exception exception) {
                CBLogging.a("CBImpression", "Exception raised while cleaning up views", exception);
                com.chartboost.sdk.Tracking.a.a((Class)this.getClass(), (String)"cleanUpViews", (Exception)exception);
            }
            this.s = null;
        }
        if ((e2 = this.C) != null) {
            e2.f();
        }
        CBLogging.e("CBImpression", "Destroying the view");
    }

    public CBError.CBImpressionError j() {
        try {
            if (this.C != null) {
                CBError.CBImpressionError cBImpressionError = this.C.c();
                return cBImpressionError;
            }
        }
        catch (Exception exception) {
            com.chartboost.sdk.Tracking.a.a((Class)this.getClass(), (String)"tryCreatingView", (Exception)exception);
        }
        return CBError.CBImpressionError.ERROR_CREATING_VIEW;
    }

    public e.a k() {
        e e2 = this.C;
        if (e2 != null) {
            return e2.e();
        }
        return null;
    }

    public void l() {
        e e2 = this.C;
        if (e2 != null && e2.e() != null) {
            this.C.e().setVisibility(8);
        }
    }

    public void m() {
        this.t = true;
    }

    public void n() {
        Runnable runnable = this.D;
        if (runnable != null) {
            runnable.run();
            this.D = null;
        }
        this.t = false;
    }

    public String o() {
        return this.p.f;
    }

    public void p() {
        this.k.c(this);
    }

    public boolean q() {
        e e2 = this.C;
        if (e2 != null) {
            return e2.l();
        }
        return false;
    }

    public void r() {
        this.x = false;
        e e2 = this.C;
        if (e2 != null && this.y) {
            this.y = false;
            e2.m();
        }
    }

    public void s() {
        this.x = false;
    }

    public void t() {
        e e2 = this.C;
        if (e2 != null && !this.y) {
            this.y = true;
            e2.n();
        }
    }

    public e u() {
        return this.C;
    }

    public boolean v() {
        return this.z;
    }

    public void w() {
        e e2;
        aj aj2 = new aj("/api/video-complete", this.d, this.e, 2, null);
        aj2.a("location", (Object)this.m);
        aj2.a("reward", (Object)this.p.k);
        aj2.a("currency-name", (Object)this.p.l);
        aj2.a("ad_id", (Object)this.o());
        aj2.a("force_close", (Object)false);
        if (!this.p.g.isEmpty()) {
            aj2.a("cgn", (Object)this.p.g);
        }
        if ((e2 = this.k() != null ? this.u() : null) != null) {
            float f2 = e2.k();
            float f3 = e2.j();
            String string2 = this.getClass().getSimpleName();
            Locale locale = Locale.US;
            Object[] arrobject = new Object[]{Float.valueOf((float)f3), Float.valueOf((float)f2)};
            CBLogging.a(string2, String.format((Locale)locale, (String)"TotalDuration: %f PlaybackTime: %f", (Object[])arrobject));
            float f4 = f3 / 1000.0f;
            aj2.a("total_time", (Object)Float.valueOf((float)f4));
            if (f2 <= 0.0f) {
                aj2.a("playback_time", (Object)Float.valueOf((float)f4));
            } else {
                aj2.a("playback_time", (Object)Float.valueOf((float)(f2 / 1000.0f)));
            }
        }
        this.c.a((ad)aj2);
        this.e.b(this.a.a(this.p.b), this.o());
    }
}


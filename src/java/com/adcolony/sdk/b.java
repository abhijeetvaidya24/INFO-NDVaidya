/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.AlertDialog
 *  android.content.res.Configuration
 *  android.media.MediaPlayer
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewParent
 *  android.view.Window
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 *  java.util.concurrent.ConcurrentHashMap
 *  org.json.JSONObject
 */
package com.adcolony.sdk;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import com.adcolony.sdk.AdColonyAppOptions;
import com.adcolony.sdk.AdColonyInterstitial;
import com.adcolony.sdk.a;
import com.adcolony.sdk.ad;
import com.adcolony.sdk.af;
import com.adcolony.sdk.am;
import com.adcolony.sdk.au;
import com.adcolony.sdk.av;
import com.adcolony.sdk.ax;
import com.adcolony.sdk.b;
import com.adcolony.sdk.c;
import com.adcolony.sdk.d;
import com.adcolony.sdk.f;
import com.adcolony.sdk.g;
import com.adcolony.sdk.l;
import com.adcolony.sdk.n;
import com.adcolony.sdk.o;
import com.adcolony.sdk.w;
import com.adcolony.sdk.y;
import com.integralads.avid.library.adcolony.session.AvidManagedVideoAdSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

class b
extends Activity {
    final int a = 0;
    final int b = 1;
    c c;
    int d = -1;
    String e;
    int f;
    boolean g;
    boolean h;
    boolean i;
    boolean j;
    boolean k;
    boolean l;
    f m;

    b() {
    }

    void a() {
        c c2;
        l l2 = a.a();
        if (this.c == null) {
            this.c = l2.s();
        }
        if ((c2 = this.c) == null) {
            return;
        }
        c2.b(false);
        if (au.g()) {
            this.c.b(true);
        }
        int n2 = l2.c.p();
        int n3 = this.j ? l2.c.q() - au.c(a.c()) : l2.c.q();
        if (n2 > 0 && n3 > 0) {
            JSONObject jSONObject = w.a();
            w.b(jSONObject, "screen_width", n2);
            w.b(jSONObject, "screen_height", n3);
            w.a(jSONObject, "ad_session_id", this.c.b());
            w.b(jSONObject, "id", this.c.d());
            this.c.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(n2, n3));
            this.c.b(n2);
            this.c.a(n3);
            new ad("AdContainer.on_orientation_change", this.c.c(), jSONObject).b();
        }
    }

    void a(int n2) {
        if (n2 != 0) {
            if (n2 != 1) {
                this.setRequestedOrientation(4);
            } else {
                this.setRequestedOrientation(6);
            }
        } else {
            this.setRequestedOrientation(7);
        }
        this.d = n2;
    }

    void a(ad ad2) {
        int n2 = w.c(ad2.c(), "status");
        if (n2 != 5 && n2 != 0 && n2 != 6 && n2 != 1 || this.g) {
            return;
        }
        l l2 = a.a();
        o o2 = l2.q();
        l2.b(ad2);
        if (o2.b() != null) {
            o2.b().dismiss();
            o2.a((AlertDialog)null);
        }
        if (!this.i) {
            this.finish();
        }
        this.g = true;
        ((ViewGroup)this.getWindow().getDecorView()).removeAllViews();
        l2.c(false);
        JSONObject jSONObject = w.a();
        w.a(jSONObject, "id", this.c.b());
        new ad("AdSession.on_close", this.c.c(), jSONObject).b();
        l2.a((c)null);
        l2.a((AdColonyInterstitial)null);
        l2.a((ax)null);
        a.a().l().c().remove((Object)this.c.b());
    }

    void a(boolean bl) {
        AdColonyInterstitial adColonyInterstitial;
        this.m = (f)a.a().l().g().get((Object)this.e);
        Iterator iterator = this.c.e().entrySet().iterator();
        while (iterator.hasNext() && !this.isFinishing()) {
            av av2 = (av)((Object)((Map.Entry)iterator.next()).getValue());
            if (av2.j() || !av2.i().isPlaying()) continue;
            av2.f();
        }
        f f2 = this.m;
        if (f2 != null) {
            f2.a();
        }
        if ((adColonyInterstitial = a.a().u()) != null && adColonyInterstitial.g() && adColonyInterstitial.h().e() != null && bl && this.k) {
            adColonyInterstitial.h().b("pause");
        }
    }

    void b(boolean bl) {
        AdColonyInterstitial adColonyInterstitial;
        Iterator iterator = this.c.e().entrySet().iterator();
        while (iterator.hasNext()) {
            av av2 = (av)((Object)((Map.Entry)iterator.next()).getValue());
            if (av2.j() || av2.i().isPlaying() || a.a().q().c()) continue;
            av2.e();
        }
        f f2 = this.m;
        if (f2 != null) {
            f2.b();
        }
        if ((adColonyInterstitial = a.a().u()) != null && adColonyInterstitial.g() && adColonyInterstitial.h().e() != null && (!bl || bl && !this.k) && this.l) {
            adColonyInterstitial.h().b("resume");
        }
    }

    public void onBackPressed() {
        JSONObject jSONObject = w.a();
        w.a(jSONObject, "id", this.c.b());
        new ad("AdSession.on_back_button", this.c.c(), jSONObject).b();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.a();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (a.b() && a.a().s() != null) {
            ViewParent viewParent;
            l l2 = a.a();
            this.i = false;
            this.c = l2.s();
            this.c.b(false);
            if (au.g()) {
                this.c.b(true);
            }
            this.e = this.c.b();
            this.f = this.c.c();
            this.m = (f)a.a().l().g().get((Object)this.e);
            this.j = l2.d().getMultiWindowEnabled();
            if (this.j) {
                this.getWindow().addFlags(2048);
                this.getWindow().clearFlags(1024);
            } else {
                this.getWindow().addFlags(1024);
                this.getWindow().clearFlags(2048);
            }
            this.requestWindowFeature(1);
            this.getWindow().getDecorView().setBackgroundColor(-16777216);
            if (l2.d().getKeepScreenOn()) {
                this.getWindow().addFlags(128);
            }
            if ((viewParent = this.c.getParent()) != null) {
                ((ViewGroup)viewParent).removeView((View)this.c);
            }
            this.setContentView((View)this.c);
            this.c.m().add((Object)a.a("AdSession.finish_fullscreen_ad", new af(this){
                final /* synthetic */ b a;
                {
                    this.a = b2;
                }

                public void a(ad ad2) {
                    this.a.a(ad2);
                }
            }, true));
            this.c.m().add((Object)a.a("AdSession.change_orientation", new af(this){
                final /* synthetic */ b a;
                {
                    this.a = b2;
                }

                public void a(ad ad2) {
                    JSONObject jSONObject = ad2.c();
                    if (w.b(jSONObject, "id").equals((Object)this.a.e)) {
                        this.a.a(w.c(jSONObject, "orientation"));
                    }
                }
            }, true));
            this.c.n().add((Object)"AdSession.finish_fullscreen_ad");
            this.c.n().add((Object)"AdSession.change_orientation");
            this.a(this.d);
            if (!this.c.s()) {
                JSONObject jSONObject = w.a();
                w.a(jSONObject, "id", this.c.b());
                w.b(jSONObject, "screen_width", this.c.p());
                w.b(jSONObject, "screen_height", this.c.o());
                new y.a().a("AdSession.on_fullscreen_ad_started").a(y.b);
                new ad("AdSession.on_fullscreen_ad_started", this.c.c(), jSONObject).b();
                this.c.c(true);
                return;
            }
            this.a();
            return;
        }
        this.finish();
    }

    public void onDestroy() {
        super.onDestroy();
        if (a.b()) {
            if (this.c == null) {
                return;
            }
            if (!(this.g || Build.VERSION.SDK_INT >= 24 && au.g() || this.c.r())) {
                JSONObject jSONObject = w.a();
                w.a(jSONObject, "id", this.c.b());
                new ad("AdSession.on_error", this.c.c(), jSONObject).b();
                this.i = true;
            }
        }
    }

    public void onPause() {
        super.onPause();
        this.a(this.h);
        this.h = false;
    }

    public void onResume() {
        super.onResume();
        this.a();
        this.b(this.h);
        this.h = true;
        this.l = true;
    }

    public void onWindowFocusChanged(boolean bl) {
        if (bl && this.h) {
            a.a().k().c(true);
            this.b(this.h);
            this.k = true;
            return;
        }
        if (!bl && this.h) {
            new y.a().a("Activity is active but window does not have focus, pausing.").a(y.d);
            a.a().k().b(true);
            this.a(this.h);
            this.k = false;
        }
    }
}


/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.os.Bundle
 *  android.os.Handler
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.webkit.WebView
 *  com.startapp.android.publish.ads.splash.h$2$1
 *  com.startapp.android.publish.ads.splash.h$3
 *  com.startapp.android.publish.ads.splash.h$a
 *  com.startapp.android.publish.adsCommon.StartAppAd
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.Long
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.startapp.android.publish.ads.splash;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.startapp.android.publish.ads.splash.SplashConfig;
import com.startapp.android.publish.ads.splash.c;
import com.startapp.android.publish.ads.splash.d;
import com.startapp.android.publish.ads.splash.e;
import com.startapp.android.publish.ads.splash.h;
import com.startapp.android.publish.adsCommon.StartAppAd;
import com.startapp.android.publish.adsCommon.adListeners.AdEventListener;
import com.startapp.android.publish.adsCommon.f.f;
import com.startapp.android.publish.common.model.AdPreferences;
import com.startapp.common.a.g;

/*
 * Exception performing whole class analysis.
 */
public class h {
    Activity a;
    c b;
    com.startapp.android.publish.cache.c c;
    d d;
    boolean e;
    a f;
    Runnable g;
    private SplashConfig h;
    private Handler i;
    private AdPreferences j;
    private Runnable k;
    private AdEventListener l;

    public h(Activity activity, SplashConfig splashConfig, AdPreferences adPreferences) {
        this.d = null;
        this.i = new Handler();
        this.e = false;
        this.k = new Runnable(){

            public void run() {
                if (h.this.c()) {
                    h.this.d();
                    h.this.e();
                    return;
                }
                h.this.a.finish();
            }
        };
        this.g = new Runnable(){

            public void run() {
                h.this.b.a(h.this.d, (e)new 1(this));
            }
        };
        this.l = new 3(this);
        this.a = activity;
        this.h = splashConfig;
        this.j = adPreferences;
        try {
            this.h();
            this.b = new c(activity, this.d);
            return;
        }
        catch (Exception exception) {
            this.b = new c(activity);
            this.b.a();
            this.b.b();
            f.a((Context)activity, com.startapp.android.publish.adsCommon.f.d.b, "SplashScreen.constructor - WebView failed", exception.getMessage(), "");
            return;
        }
    }

    private void h() {
        this.h.initSplashLogo(this.a);
        if (!this.k()) {
            this.d = this.h.initSplashHtml(this.a);
        }
    }

    private boolean i() {
        boolean bl;
        int n2;
        int n3 = this.a.getResources().getConfiguration().orientation;
        if (this.h.getOrientation() == SplashConfig.Orientation.AUTO) {
            if (n3 == 2) {
                this.h.setOrientation(SplashConfig.Orientation.LANDSCAPE);
            } else {
                this.h.setOrientation(SplashConfig.Orientation.PORTRAIT);
            }
        }
        if ((n2 = 7.a[this.h.getOrientation().ordinal()]) != 1) {
            if (n2 != 2) {
                bl = false;
            } else {
                bl = false;
                if (n3 == 1) {
                    bl = true;
                }
                com.startapp.common.a.c.b(this.a);
            }
        } else {
            bl = false;
            if (n3 == 2) {
                bl = true;
            }
            com.startapp.common.a.c.a(this.a);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Set Orientation: [");
        stringBuilder.append(this.h.getOrientation().toString());
        stringBuilder.append("]");
        g.a("Splash", 4, stringBuilder.toString());
        return bl;
    }

    private View j() {
        if (this.k()) {
            return this.h.getLayout((Context)this.a);
        }
        d d2 = this.d;
        if (d2 != null) {
            return d2.c();
        }
        return null;
    }

    private boolean k() {
        return !this.h.isHtmlSplash() || this.h.isUserDefinedSplash();
        {
        }
    }

    public void a() {
    }

    public void a(Bundle bundle) {
        g.a("Splash", 4, "========= Splash Screen Feature =========");
        this.b.j();
        if (!this.i()) {
            this.i.post(this.k);
            return;
        }
        this.i.postDelayed(this.k, 100L);
        g.a("Splash", 4, "Splash screen orientation is being modified");
    }

    public void b() {
        this.i.removeCallbacks(this.k);
        this.b.e();
    }

    boolean c() {
        g.a("Splash", 4, "Displaying Splash screen");
        if (this.h.validate((Context)this.a)) {
            View view = this.j();
            if (view != null) {
                ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
                this.a.setContentView(view, layoutParams);
                return true;
            }
            return false;
        }
        throw new IllegalArgumentException(this.h.getErrorMessage());
    }

    void d() {
        g.a("Splash", 4, "Loading Splash Ad");
        this.f = new /* Unavailable Anonymous Inner Class!! */;
        this.c = this.f.loadSplash(this.j, this.l);
    }

    void e() {
        g.a("Splash", 4, "Started Splash Loading Timer");
        this.i.postDelayed(new Runnable(){

            public void run() {
                if (h.this.b.b(h.this.g, h.this.c)) {
                    h h2 = h.this;
                    h2.f = null;
                    h2.c = null;
                }
            }
        }, this.h.getMaxLoadAdTimeout().longValue());
        this.i.postDelayed(new Runnable(){

            public void run() {
                h.this.b.a(h.this.g, h.this.c);
            }
        }, this.h.getMinSplashTime().getIndex());
    }

    void f() {
        g.a("Splash", 4, "Started Splash Display Timer");
        if (this.h.getMaxAdDisplayTime() != SplashConfig.MaxAdDisplayTime.FOR_EVER) {
            this.i.postDelayed(new Runnable(){

                public void run() {
                    h.this.b.a((StartAppAd)h.this.f);
                }
            }, this.h.getMaxAdDisplayTime().getIndex());
        }
    }

    public void g() {
        this.e = true;
        this.b.h();
    }

}


/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.view.View
 *  android.view.View$OnLongClickListener
 *  android.view.View$OnTouchListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.Window
 *  android.webkit.WebChromeClient
 *  android.webkit.WebSettings
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  com.startapp.android.publish.ads.b.c
 *  com.startapp.android.publish.ads.splash.b
 *  java.io.Serializable
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Double
 *  java.lang.Exception
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.concurrent.TimeUnit
 */
package com.startapp.android.publish.ads.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import com.startapp.android.publish.ads.a.b;
import com.startapp.android.publish.ads.a.c;
import com.startapp.android.publish.adsCommon.Ad;
import com.startapp.android.publish.adsCommon.f.d;
import com.startapp.android.publish.adsCommon.f.f;
import com.startapp.android.publish.adsCommon.i;
import com.startapp.android.publish.adsCommon.m;
import com.startapp.android.publish.common.metaData.MetaData;
import com.startapp.android.publish.common.model.AdPreferences;
import com.startapp.android.publish.html.JsInterface;
import com.startapp.common.a.g;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;

public class c
extends b {
    protected WebView d;
    protected com.b.a.a.a.b.b e;
    protected RelativeLayout f;
    protected Runnable g = new Runnable(this){
        final /* synthetic */ c a;
        {
            this.a = c2;
        }

        public void run() {
            this.a.B();
            this.a.p();
        }
    };
    protected Runnable h = new Runnable(this){
        final /* synthetic */ c a;
        {
            this.a = c2;
        }

        public void run() {
            c.a(this.a, true);
            c c2 = this.a;
            c2.b(c2.d);
        }
    };
    private Long i;
    private Long j;
    private long k = 0L;
    private long l = 0L;
    private i m;
    private boolean n = true;
    private boolean o = false;

    private boolean G() {
        if (this.w() instanceof com.startapp.android.publish.ads.b.c) {
            return ((com.startapp.android.publish.ads.b.c)this.w()).hasAdCacheTtlPassed();
        }
        return false;
    }

    private void a(String string, int n2, boolean bl) {
        Activity activity = this.b();
        String string2 = n2 < this.i().length ? this.i()[n2] : null;
        int n3 = this.j().length;
        String string3 = null;
        if (n2 < n3) {
            string3 = this.j()[n2];
        }
        com.startapp.android.publish.adsCommon.c.a((Context)activity, string, string2, string3, this.C(), com.startapp.android.publish.adsCommon.b.a().A(), com.startapp.android.publish.adsCommon.b.a().B(), this.a(n2), this.b(n2), bl, new Runnable(this){
            final /* synthetic */ c a;
            {
                this.a = c2;
            }

            public void run() {
                this.a.p();
            }
        });
    }

    static /* synthetic */ boolean a(c c2, boolean bl) {
        c2.n = bl;
        return bl;
    }

    private void b(String string, int n2, boolean bl) {
        Intent intent = new Intent("com.startapp.android.OnClickCallback");
        com.startapp.common.b.a((Context)this.b()).a(intent);
        boolean bl2 = com.startapp.android.publish.adsCommon.c.a(this.b().getApplicationContext(), this.b);
        Activity activity = this.b();
        String string2 = n2 < this.i().length ? this.i()[n2] : null;
        String string3 = string2;
        com.startapp.android.publish.adsCommon.d.b b2 = this.C();
        boolean bl3 = this.a(n2) && !bl2;
        com.startapp.android.publish.adsCommon.c.a((Context)activity, string, string3, b2, bl3, bl);
        this.p();
    }

    private boolean b(Ad ad) {
        return com.startapp.android.publish.adsCommon.Utils.i.a(8L) && ad instanceof com.startapp.android.publish.ads.splash.b;
    }

    protected void A() {
        if (MetaData.getInstance().isOmsdkEnabled() && this.e == null) {
            this.e = com.startapp.android.publish.omsdk.a.a(this.d);
            if (this.e != null && this.d != null) {
                View view;
                if (this.a != null && (view = this.a.a()) != null) {
                    this.e.b(view);
                }
                this.e.a((View)this.d);
                this.e.a();
                com.b.a.a.a.b.a.a(this.e).a();
            }
        }
    }

    protected void B() {
        String[] arrstring = this.l();
        if (arrstring != null && arrstring.length > 0 && this.l()[0] != null) {
            com.startapp.android.publish.adsCommon.c.b((Context)this.b(), this.l()[0], this.C());
        }
    }

    protected com.startapp.android.publish.adsCommon.d.b C() {
        return new com.startapp.android.publish.adsCommon.d.a(this.E(), this.n());
    }

    protected com.startapp.android.publish.adsCommon.d.b D() {
        return new com.startapp.android.publish.adsCommon.d.b(this.n());
    }

    protected String E() {
        this.l = System.currentTimeMillis();
        double d2 = this.l - this.k;
        Double.isNaN((double)d2);
        return String.valueOf((double)(d2 / 1000.0));
    }

    protected long F() {
        if (this.o() != null) {
            return TimeUnit.SECONDS.toMillis(this.o().longValue());
        }
        return TimeUnit.SECONDS.toMillis(MetaData.getInstance().getIABDisplayImpressionDelayInSeconds());
    }

    @Override
    public void a(Bundle bundle) {
        super.a(bundle);
        if (bundle == null) {
            if (this.a().hasExtra("lastLoadTime")) {
                this.i = (Long)this.a().getSerializableExtra("lastLoadTime");
            }
            if (this.a().hasExtra("adCacheTtl")) {
                this.j = (Long)this.a().getSerializableExtra("adCacheTtl");
                return;
            }
        } else {
            if (bundle.containsKey("postrollHtml")) {
                this.a(bundle.getString("postrollHtml"));
            }
            if (bundle.containsKey("lastLoadTime")) {
                this.i = (Long)bundle.getSerializable("lastLoadTime");
            }
            if (bundle.containsKey("adCacheTtl")) {
                this.j = (Long)bundle.getSerializable("adCacheTtl");
            }
        }
    }

    public void a(WebView webView) {
        this.n = false;
        webView.setOnTouchListener(new View.OnTouchListener(this){
            final /* synthetic */ c a;
            {
                this.a = c2;
            }

            public boolean onTouch(View view, android.view.MotionEvent motionEvent) {
                c.a(this.a, true);
                return motionEvent.getAction() == 2;
            }
        });
    }

    protected /* varargs */ void a(String string, Object ... arrobject) {
        com.startapp.android.publish.adsCommon.Utils.i.a(this.d, string, arrobject);
    }

    protected boolean a(String string, boolean bl) {
        this.m.a(true);
        Ad ad = this.w();
        boolean bl2 = com.startapp.android.publish.adsCommon.c.a(this.b().getApplicationContext(), this.b) && !this.b(ad);
        if (this.b(string)) {
            int n2;
            block6 : {
                try {
                    n2 = com.startapp.android.publish.adsCommon.c.a(string);
                    if (!this.d()[n2] || bl2) break block6;
                }
                catch (Exception exception) {
                    g.a(6, "Error while trying parsing index from url");
                    return false;
                }
                g.a(6, "forceExternal -interMode - smartredirect");
                this.a(string, n2, bl);
                return true;
            }
            g.a(6, "forceExternal - interMode - redirect");
            this.b(string, n2, bl);
            return true;
        }
        if (this.d()[0] && !bl2) {
            g.a(6, "forceExternal - interMode - redirectr");
            this.a(string, 0, bl);
            return true;
        }
        g.a(6, "forceExternal - interMode - smartredirect");
        this.b(string, 0, bl);
        return true;
    }

    @Override
    public void b(Bundle bundle) {
        Long l2;
        Long l3;
        super.b(bundle);
        if (this.f() != null) {
            bundle.putString("postrollHtml", this.f());
        }
        if ((l2 = this.i) != null) {
            bundle.putLong("lastLoadTime", l2.longValue());
        }
        if ((l3 = this.j) != null) {
            bundle.putLong("adCacheTtl", l3.longValue());
        }
    }

    public void b(WebView webView) {
        if (webView != null) {
            webView.setOnTouchListener(null);
        }
    }

    protected boolean b(String string) {
        return !this.o && string.contains((CharSequence)"index=");
    }

    protected void c(WebView webView) {
    }

    @Override
    public void p() {
        super.p();
        m.a().a(false);
        i i2 = this.m;
        if (i2 != null) {
            i2.a(false);
        }
        this.b().runOnUiThread(new Runnable(this){
            final /* synthetic */ c a;
            {
                this.a = c2;
            }

            public void run() {
                if (this.a.d != null) {
                    com.startapp.common.a.c.b(this.a.d);
                }
            }
        });
    }

    @Override
    public boolean r() {
        this.B();
        m.a().a(false);
        this.m.a(false);
        return false;
    }

    @Override
    public void s() {
        WebView webView;
        i i2 = this.m;
        if (i2 != null) {
            i2.b();
        }
        if (this.a != null && this.a.b()) {
            this.a.d();
        }
        if ((webView = this.d) != null) {
            com.startapp.common.a.c.b(webView);
        }
        if (this.g().equals((Object)"back")) {
            this.p();
        }
    }

    @Override
    public void u() {
        WebView webView;
        if (this.G()) {
            g.a("InterstitialMode", 3, "Ad Cache TTL passed, finishing");
            this.p();
            return;
        }
        m.a().a(true);
        if (this.m == null) {
            i i2;
            this.m = i2 = new i((Context)this.b(), this.h(), this.D(), this.F());
        }
        if ((webView = this.d) == null) {
            this.f = new RelativeLayout((Context)this.b());
            this.f.setContentDescription((CharSequence)"StartApp Ad");
            this.f.setId(1475346432);
            this.b().setContentView((View)this.f);
            try {
                this.d = new WebView(this.b().getApplicationContext());
                this.d.setBackgroundColor(-16777216);
                this.b().getWindow().getDecorView().findViewById(16908290).setBackgroundColor(7829367);
                this.d.setVerticalScrollBarEnabled(false);
                this.d.setHorizontalScrollBarEnabled(false);
                this.d.getSettings().setJavaScriptEnabled(true);
                com.startapp.common.a.c.a(this.d);
                if (this.c) {
                    com.startapp.common.a.c.a(this.d, null);
                }
                this.d.setOnLongClickListener(new View.OnLongClickListener(this){
                    final /* synthetic */ c a;
                    {
                        this.a = c2;
                    }

                    public boolean onLongClick(View view) {
                        return true;
                    }
                });
                this.d.setLongClickable(false);
                this.d.addJavascriptInterface((Object)this.y(), "startappwall");
                this.z();
                this.a(this.d);
                com.startapp.android.publish.adsCommon.Utils.i.a((Context)this.b(), this.d, this.f());
                this.o = "true".equals((Object)com.startapp.android.publish.adsCommon.Utils.i.a(this.f(), "@jsTag@", "@jsTag@"));
                this.x();
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                this.f.addView((View)this.d, (ViewGroup.LayoutParams)layoutParams);
                this.a(this.f);
            }
            catch (Exception exception) {
                f.a((Context)this.b(), d.b, "InterstitialMode.onResume - WebView failed", exception.getMessage(), "");
                this.p();
            }
        } else {
            com.startapp.common.a.c.c(webView);
            this.m.a();
        }
        this.k = System.currentTimeMillis();
    }

    @Override
    public void v() {
        super.v();
        com.b.a.a.a.b.b b2 = this.e;
        if (b2 != null) {
            b2.b();
            this.e = null;
        }
        com.startapp.android.publish.adsCommon.Utils.i.a((Object)this.d, 1000L);
    }

    protected void x() {
        this.d.setWebViewClient(new WebViewClient(){

            public void onPageFinished(WebView webView, String string) {
                c.this.c(webView);
                c c2 = c.this;
                Object[] arrobject = new Object[]{c2.g()};
                c2.a("gClientInterface.setMode", arrobject);
                c.this.a("enableScheme", "externalLinks");
                c.this.A();
            }

            public boolean shouldOverrideUrlLoading(WebView webView, String string) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("MyWebViewClient::shouldOverrideUrlLoading - [");
                stringBuilder.append(string);
                stringBuilder.append("]");
                g.a(2, stringBuilder.toString());
                if (c.this.o && !c.this.n) {
                    return false;
                }
                return c.this.a(string, false);
            }
        });
        this.d.setWebChromeClient(new WebChromeClient());
    }

    protected JsInterface y() {
        Activity activity = this.b();
        Runnable runnable = this.g;
        JsInterface jsInterface = new JsInterface((Context)activity, runnable, runnable, this.h, this.C(), this.a(0));
        return jsInterface;
    }

    protected void z() {
        this.m.a();
    }

}


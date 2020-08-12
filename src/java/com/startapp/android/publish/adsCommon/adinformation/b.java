/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Dialog
 *  android.content.Context
 *  android.graphics.Point
 *  android.os.Handler
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.Window
 *  android.view.WindowManager
 *  android.view.WindowManager$LayoutParams
 *  android.webkit.WebChromeClient
 *  android.webkit.WebSettings
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  com.startapp.android.publish.adsCommon.f.e
 *  java.lang.Enum
 *  java.lang.Exception
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.startapp.android.publish.adsCommon.adinformation;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import com.startapp.android.publish.adsCommon.Utils.i;
import com.startapp.android.publish.adsCommon.adinformation.AdInformationConfig;
import com.startapp.android.publish.adsCommon.adinformation.AdInformationJsInterface;
import com.startapp.android.publish.adsCommon.adinformation.AdInformationPositions;
import com.startapp.android.publish.adsCommon.adinformation.d;
import com.startapp.android.publish.adsCommon.c;
import com.startapp.android.publish.adsCommon.f.e;
import com.startapp.android.publish.adsCommon.f.f;
import com.startapp.android.publish.adsCommon.k;
import com.startapp.android.publish.adsCommon.l;
import com.startapp.android.publish.common.metaData.MetaData;
import com.startapp.android.publish.common.metaData.h;
import com.startapp.android.publish.common.model.AdPreferences;

public class b
implements View.OnClickListener {
    Context a;
    RelativeLayout b;
    RelativeLayout c;
    AdInformationConfig d;
    h e;
    private d f;
    private WebView g;
    private Dialog h = null;
    private AdPreferences.Placement i;
    private Handler j = new Handler();
    private a k = a.a;
    private boolean l = false;
    private com.startapp.android.publish.adsCommon.adinformation.c m;
    private Runnable n = new Runnable(){

        public void run() {
            try {
                b.this.d();
                b.this.e.a(b.this.a, true);
                b.this.d.a(b.this.a, true);
                b.this.a(false);
                return;
            }
            catch (Exception exception) {
                f.a(b.this.a, new e(com.startapp.android.publish.adsCommon.f.d.b, "AdInformationObject.acceptRunnable failed", exception.getMessage()), "");
                return;
            }
        }
    };
    private Runnable o = new Runnable(){

        public void run() {
            try {
                b.this.d();
                l.b();
                b.this.e.a(b.this.a, false);
                b.this.d.a(b.this.a, true);
                b.this.a(false);
                return;
            }
            catch (Exception exception) {
                f.a(b.this.a, new e(com.startapp.android.publish.adsCommon.f.d.b, "AdInformationObject.declineRunnable failed", exception.getMessage()), "");
                return;
            }
        }
    };
    private Runnable p = new Runnable(){

        public void run() {
            try {
                b.this.d();
                b.this.c();
                b.this.a(false);
                return;
            }
            catch (Exception exception) {
                f.a(b.this.a, new e(com.startapp.android.publish.adsCommon.f.d.b, "AdInformationObject.fullPrivacyPolicy failed", exception.getMessage()), "");
                return;
            }
        }
    };

    public b(Context context, b b2, AdPreferences.Placement placement, com.startapp.android.publish.adsCommon.adinformation.c c2) {
        d d2;
        this.a = context;
        this.i = placement;
        this.m = c2;
        this.d = this.e();
        this.e = MetaData.getInstance().getSimpleTokenConfig();
        this.f = d2 = new d(context, b2, placement, c2, this);
    }

    public static AdInformationConfig a(Context context) {
        return com.startapp.android.publish.adsCommon.adinformation.a.b().a();
    }

    private String a(String string) {
        StringBuilder stringBuilder = new StringBuilder(string);
        if (b.b(this.a)) {
            stringBuilder.append("?le=true");
        }
        return stringBuilder.toString();
    }

    private void a(ViewGroup viewGroup, Point point) {
        this.l = true;
        this.h = new Dialog(this.a);
        this.h.requestWindowFeature(1);
        this.h.setContentView((View)viewGroup);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(this.h.getWindow().getAttributes());
        layoutParams.width = (int)(0.9f * (float)point.x);
        layoutParams.height = (int)(0.85f * (float)point.y);
        this.h.show();
        this.h.getWindow().setAttributes(layoutParams);
    }

    private void b(final ViewGroup viewGroup, Point point) {
        this.l = true;
        final RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int)(0.9f * (float)point.x), (int)(0.85f * (float)point.y));
        layoutParams.addRule(13);
        this.j.post(new Runnable(){

            public void run() {
                b.this.c.addView((View)viewGroup, (ViewGroup.LayoutParams)layoutParams);
            }
        });
    }

    public static boolean b(Context context) {
        return k.a(context, "shared_prefs_using_location", false);
    }

    private AdInformationConfig e() {
        return com.startapp.android.publish.adsCommon.adinformation.a.b().a();
    }

    private com.startapp.android.publish.adsCommon.adinformation.c f() {
        return this.m;
    }

    private void g() {
        String string = c.a(this.a, null);
        if (string != null) {
            WebView webView = this.g;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("javascript:window.onload=function(){document.getElementById('titlePlacement').innerText='");
            stringBuilder.append(string);
            stringBuilder.append("';}");
            webView.loadUrl(stringBuilder.toString());
        }
    }

    public View a() {
        return this.f;
    }

    public void a(RelativeLayout relativeLayout) {
        boolean bl = this.f() != null && this.f().e() ? this.f().b() : this.e().a(this.a);
        if (bl) {
            this.c = relativeLayout;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            if (this.f() != null && this.f().d()) {
                this.f().c().addRules(layoutParams);
            } else {
                this.e().a(this.i).addRules(layoutParams);
            }
            this.c.addView((View)this.f, (ViewGroup.LayoutParams)layoutParams);
        }
    }

    void a(boolean bl) {
        Context context;
        if (!this.i.isInterstitial() && (context = this.a) instanceof Activity) {
            i.a((Activity)context, bl);
        }
    }

    public boolean b() {
        return this.l;
    }

    protected void c() {
        if (i.a(256L) && MetaData.getInstance().isInAppBrowser()) {
            c.b(this.a, this.d.b(), "");
            return;
        }
        c.c(this.a, this.d.b());
    }

    public void d() {
        this.l = false;
        int n2 = 6.a[this.k.ordinal()];
        if (n2 != 1) {
            if (n2 != 2) {
                return;
            }
            this.h.dismiss();
            return;
        }
        this.j.post(new Runnable(){

            public void run() {
                b.this.c.removeView((View)b.this.b);
            }
        });
    }

    public void onClick(View view) {
        if (this.e.b(this.a) && this.a instanceof Activity) {
            this.a(true);
            this.b = new RelativeLayout(this.a);
            try {
                this.g = new WebView(this.a);
            }
            catch (Exception exception) {
                f.a(this.a, com.startapp.android.publish.adsCommon.f.d.b, "AdInformationObject.onClick - webview instantiation failed", exception.getMessage(), "");
                this.a(false);
                return;
            }
            this.g.setWebViewClient(new WebViewClient());
            this.g.setWebChromeClient(new WebChromeClient());
            this.g.getSettings().setJavaScriptEnabled(true);
            this.g.setHorizontalScrollBarEnabled(false);
            this.g.setVerticalScrollBarEnabled(false);
            this.g.loadUrl(this.a(this.d.f()));
            this.g.addJavascriptInterface((Object)new AdInformationJsInterface(this.a, this.n, this.o, this.p), "startappwall");
            Point point = new Point(1, 1);
            try {
                com.startapp.android.publish.adsCommon.Utils.h.a((WindowManager)this.a.getSystemService("window"), point);
            }
            catch (Exception exception) {
                f.a(this.a, com.startapp.android.publish.adsCommon.f.d.b, "AdInformationObject.onClick - system service failed", exception.getMessage(), "");
                this.a(false);
                return;
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.g.setPadding(0, 0, 0, 0);
            layoutParams.setMargins(0, 0, 0, 0);
            this.b.addView((View)this.g, (ViewGroup.LayoutParams)layoutParams);
            this.g();
            int n2 = 6.a[this.k.ordinal()];
            if (n2 != 1) {
                if (n2 != 2) {
                    return;
                }
                this.a((ViewGroup)this.b, point);
                return;
            }
            this.b((ViewGroup)this.b, point);
            return;
        }
        this.c();
    }

    public static final class a
    extends Enum<a> {
        public static final /* enum */ a a = new a();
        public static final /* enum */ a b = new a();
        private static final /* synthetic */ a[] c;

        static {
            a[] arra = new a[]{a, b};
            c = arra;
        }

        public static a valueOf(String string) {
            return (a)Enum.valueOf(a.class, (String)string);
        }

        public static a[] values() {
            return (a[])c.clone();
        }
    }

    public static final class b
    extends Enum<b> {
        public static final /* enum */ b a = new b(AdInformationConfig.ImageResourceType.INFO_S, AdInformationConfig.ImageResourceType.INFO_EX_S);
        public static final /* enum */ b b = new b(AdInformationConfig.ImageResourceType.INFO_L, AdInformationConfig.ImageResourceType.INFO_EX_L);
        private static final /* synthetic */ b[] c;
        private AdInformationConfig.ImageResourceType infoExtendedType;
        private AdInformationConfig.ImageResourceType infoType;

        static {
            b[] arrb = new b[]{a, b};
            c = arrb;
        }

        private b(AdInformationConfig.ImageResourceType imageResourceType, AdInformationConfig.ImageResourceType imageResourceType2) {
            this.infoType = imageResourceType;
            this.infoExtendedType = imageResourceType2;
        }

        public static b valueOf(String string) {
            return (b)Enum.valueOf(b.class, (String)string);
        }

        public static b[] values() {
            return (b[])c.clone();
        }

        public AdInformationConfig.ImageResourceType a() {
            return this.infoType;
        }
    }

}


/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.DisplayMetrics
 *  android.webkit.WebView
 *  java.lang.Double
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Locale
 */
package com.adincube.sdk.i;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import android.webkit.WebView;
import com.adincube.sdk.h.a.e;
import com.adincube.sdk.i.a;
import com.adincube.sdk.util.b.j;
import java.util.Locale;

public final class g {
    Context a;
    e b;
    WebView c;
    boolean d = false;
    private a e;
    private boolean f = false;

    public g(Context context, e e2, WebView webView, a a2) {
        this.a = context;
        this.b = e2;
        this.c = webView;
        this.e = a2;
    }

    static boolean b() {
        return Build.VERSION.SDK_INT >= 26;
    }

    public final void a() {
        if (!g.b()) {
            return;
        }
        if (this.c.getMeasuredHeight() != 0) {
            if (this.c.getMeasuredWidth() == 0) {
                return;
            }
            if (!this.d) {
                return;
            }
            if (!this.f) {
                this.f = true;
                String string = this.b.t != null ? this.b.t.toString() : "device-width";
                double d2 = 1.0;
                if (this.b.t != null || this.b.s != null) {
                    int n2 = j.b(this.a, this.b.t);
                    int n3 = j.b(this.a, this.b.s);
                    if (n2 > this.c.getMeasuredWidth() || n3 > this.c.getMeasuredHeight()) {
                        double d3 = this.c.getMeasuredWidth();
                        double d4 = n2;
                        Double.isNaN((double)d3);
                        Double.isNaN((double)d4);
                        double d5 = d3 / d4;
                        double d6 = this.c.getMeasuredHeight();
                        double d7 = n3;
                        Double.isNaN((double)d6);
                        Double.isNaN((double)d7);
                        d2 = Math.min((double)d5, (double)(d6 / d7));
                    }
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("(function() {");
                stringBuilder.append("var hasViewportMetaTag = document.querySelector('meta[name=\"viewport\"]');");
                stringBuilder.append("if (hasViewportMetaTag) return;");
                stringBuilder.append("var metaTag = document.createElement('meta');");
                stringBuilder.append("metaTag.name = 'viewport';");
                Locale locale = Locale.US;
                Object[] arrobject = new Object[]{string, d2, d2};
                stringBuilder.append(String.format((Locale)locale, (String)"metaTag.content = 'width=%s, initial-scale=%.2f, maximum-scale=%.2f, user-scalable=0';", (Object[])arrobject));
                stringBuilder.append("document.head.appendChild(metaTag);");
                stringBuilder.append("})();");
                this.e.a(stringBuilder.toString());
            }
        }
    }

    final void a(int n2, int n3) {
        if (this.b.s != null) {
            if (this.b.t == null) {
                return;
            }
            DisplayMetrics displayMetrics = this.a.getResources().getDisplayMetrics();
            double d2 = this.c.getWidth();
            double d3 = j.b(this.a, n2);
            Double.isNaN((double)d2);
            Double.isNaN((double)d3);
            double d4 = d2 / d3;
            double d5 = this.c.getHeight();
            double d6 = j.b(this.a, n3);
            Double.isNaN((double)d5);
            Double.isNaN((double)d6);
            double d7 = Math.min((double)d4, (double)(d5 / d6));
            WebView webView = this.c;
            double d8 = displayMetrics.density;
            Double.isNaN((double)d8);
            webView.setInitialScale((int)Math.round((double)(100.0 * (d7 * d8))));
        }
    }
}


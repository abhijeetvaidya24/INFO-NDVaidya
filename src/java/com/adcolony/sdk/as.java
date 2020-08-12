/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.graphics.Typeface
 *  android.util.AttributeSet
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.Button
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.HashMap
 *  org.json.JSONObject
 */
package com.adcolony.sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import com.adcolony.sdk.a;
import com.adcolony.sdk.ad;
import com.adcolony.sdk.af;
import com.adcolony.sdk.as;
import com.adcolony.sdk.au;
import com.adcolony.sdk.ax;
import com.adcolony.sdk.c;
import com.adcolony.sdk.d;
import com.adcolony.sdk.l;
import com.adcolony.sdk.n;
import com.adcolony.sdk.w;
import com.adcolony.sdk.y;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;

@SuppressLint(value={"AppCompatCustomView"})
class as
extends Button {
    private c A;
    private ad B;
    private final int a = 0;
    private final int b = 1;
    private final int c = 2;
    private final int d = 3;
    private final int e = 1;
    private final int f = 2;
    private final int g = 3;
    private final int h = 0;
    private final int i = 1;
    private final int j = 2;
    private final int k = 1;
    private final int l = 2;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private int t;
    private int u;
    private int v;
    private String w;
    private String x;
    private String y;
    private String z;

    as(Context context, int n2, ad ad2, int n3, c c2) {
        super(context, null, n2);
        this.m = n3;
        this.B = ad2;
        this.A = c2;
    }

    as(Context context, ad ad2, int n2, c c2) {
        super(context);
        this.m = n2;
        this.B = ad2;
        this.A = c2;
    }

    int a(boolean bl, int n2) {
        if (n2 != 0) {
            if (n2 != 1) {
                if (n2 != 2) {
                    return 17;
                }
                if (bl) {
                    return 8388613;
                }
                return 80;
            }
            if (bl) {
                return 8388611;
            }
            return 48;
        }
        if (bl) {
            return 1;
        }
        return 16;
    }

    void a() {
        int n2;
        int n3;
        JSONObject jSONObject = this.B.c();
        this.z = w.b(jSONObject, "ad_session_id");
        this.n = w.c(jSONObject, "x");
        this.o = w.c(jSONObject, "y");
        this.p = w.c(jSONObject, "width");
        this.q = w.c(jSONObject, "height");
        this.s = w.c(jSONObject, "font_family");
        this.r = w.c(jSONObject, "font_style");
        this.t = w.c(jSONObject, "font_size");
        this.w = w.b(jSONObject, "background_color");
        this.x = w.b(jSONObject, "font_color");
        this.y = w.b(jSONObject, "text");
        this.u = w.c(jSONObject, "align_x");
        this.v = w.c(jSONObject, "align_y");
        l l2 = a.a();
        if (this.y.equals((Object)"")) {
            this.y = "Learn More";
        }
        this.setVisibility(4);
        FrameLayout.LayoutParams layoutParams = w.d(jSONObject, "wrap_content") ? new FrameLayout.LayoutParams(-2, -2) : new FrameLayout.LayoutParams(this.p, this.q);
        layoutParams.gravity = 0;
        this.setText((CharSequence)this.y);
        this.setTextSize((float)this.t);
        if (w.d(jSONObject, "overlay")) {
            this.n = 0;
            this.o = 0;
            n2 = (int)(6.0f * l2.c.o());
            n3 = (int)(6.0f * l2.c.o());
            int n4 = (int)(4.0f * l2.c.o());
            this.setPadding(n4, n4, n4, n4);
            layoutParams.gravity = 8388693;
        } else {
            n2 = 0;
            n3 = 0;
        }
        layoutParams.setMargins(this.n, this.o, n2, n3);
        this.A.addView((View)this, (ViewGroup.LayoutParams)layoutParams);
        int n5 = this.s;
        if (n5 != 0) {
            if (n5 != 1) {
                if (n5 != 2) {
                    if (n5 == 3) {
                        this.setTypeface(Typeface.MONOSPACE);
                    }
                } else {
                    this.setTypeface(Typeface.SANS_SERIF);
                }
            } else {
                this.setTypeface(Typeface.SERIF);
            }
        } else {
            this.setTypeface(Typeface.DEFAULT);
        }
        int n6 = this.r;
        if (n6 != 0) {
            if (n6 != 1) {
                if (n6 != 2) {
                    if (n6 == 3) {
                        this.setTypeface(this.getTypeface(), 3);
                    }
                } else {
                    this.setTypeface(this.getTypeface(), 2);
                }
            } else {
                this.setTypeface(this.getTypeface(), 1);
            }
        } else {
            this.setTypeface(this.getTypeface(), 0);
        }
        this.setGravity(this.a(true, this.u) | this.a(false, this.v));
        if (!this.w.equals((Object)"")) {
            this.setBackgroundColor(au.g(this.w));
        }
        if (!this.x.equals((Object)"")) {
            this.setTextColor(au.g(this.x));
        }
        this.A.m().add((Object)a.a("TextView.set_visible", new af(this){
            final /* synthetic */ as a;
            {
                this.a = as2;
            }

            public void a(ad ad2) {
                if (this.a.c(ad2)) {
                    this.a.k(ad2);
                }
            }
        }, true));
        this.A.m().add((Object)a.a("TextView.set_bounds", new af(this){
            final /* synthetic */ as a;
            {
                this.a = as2;
            }

            public void a(ad ad2) {
                if (this.a.c(ad2)) {
                    this.a.d(ad2);
                }
            }
        }, true));
        this.A.m().add((Object)a.a("TextView.set_font_color", new af(this){
            final /* synthetic */ as a;
            {
                this.a = as2;
            }

            public void a(ad ad2) {
                if (this.a.c(ad2)) {
                    this.a.f(ad2);
                }
            }
        }, true));
        this.A.m().add((Object)a.a("TextView.set_background_color", new af(this){
            final /* synthetic */ as a;
            {
                this.a = as2;
            }

            public void a(ad ad2) {
                if (this.a.c(ad2)) {
                    this.a.e(ad2);
                }
            }
        }, true));
        this.A.m().add((Object)a.a("TextView.set_typeface", new af(this){
            final /* synthetic */ as a;
            {
                this.a = as2;
            }

            public void a(ad ad2) {
                if (this.a.c(ad2)) {
                    this.a.j(ad2);
                }
            }
        }, true));
        this.A.m().add((Object)a.a("TextView.set_font_size", new af(this){
            final /* synthetic */ as a;
            {
                this.a = as2;
            }

            public void a(ad ad2) {
                if (this.a.c(ad2)) {
                    this.a.g(ad2);
                }
            }
        }, true));
        this.A.m().add((Object)a.a("TextView.set_font_style", new af(this){
            final /* synthetic */ as a;
            {
                this.a = as2;
            }

            public void a(ad ad2) {
                if (this.a.c(ad2)) {
                    this.a.h(ad2);
                }
            }
        }, true));
        this.A.m().add((Object)a.a("TextView.get_text", new af(this){
            final /* synthetic */ as a;
            {
                this.a = as2;
            }

            public void a(ad ad2) {
                if (this.a.c(ad2)) {
                    this.a.b(ad2);
                }
            }
        }, true));
        this.A.m().add((Object)a.a("TextView.set_text", new af(this){
            final /* synthetic */ as a;
            {
                this.a = as2;
            }

            public void a(ad ad2) {
                if (this.a.c(ad2)) {
                    this.a.i(ad2);
                }
            }
        }, true));
        this.A.m().add((Object)a.a("TextView.align", new af(this){
            final /* synthetic */ as a;
            {
                this.a = as2;
            }

            public void a(ad ad2) {
                if (this.a.c(ad2)) {
                    this.a.a(ad2);
                }
            }
        }, true));
        this.A.n().add((Object)"TextView.set_visible");
        this.A.n().add((Object)"TextView.set_bounds");
        this.A.n().add((Object)"TextView.set_font_color");
        this.A.n().add((Object)"TextView.set_background_color");
        this.A.n().add((Object)"TextView.set_typeface");
        this.A.n().add((Object)"TextView.set_font_size");
        this.A.n().add((Object)"TextView.set_font_style");
        this.A.n().add((Object)"TextView.get_text");
        this.A.n().add((Object)"TextView.set_text");
        this.A.n().add((Object)"TextView.align");
        new y.a().a("TextView added to layout").a(y.d);
    }

    void a(ad ad2) {
        JSONObject jSONObject = ad2.c();
        this.u = w.c(jSONObject, "x");
        this.v = w.c(jSONObject, "y");
        this.setGravity(this.a(true, this.u) | this.a(false, this.v));
    }

    void b(ad ad2) {
        JSONObject jSONObject = w.a();
        w.a(jSONObject, "text", this.getText().toString());
        ad2.a(jSONObject).b();
    }

    boolean c(ad ad2) {
        JSONObject jSONObject = ad2.c();
        return w.c(jSONObject, "id") == this.m && w.c(jSONObject, "container_id") == this.A.d() && w.b(jSONObject, "ad_session_id").equals((Object)this.A.b());
    }

    void d(ad ad2) {
        JSONObject jSONObject = ad2.c();
        this.n = w.c(jSONObject, "x");
        this.o = w.c(jSONObject, "y");
        this.p = w.c(jSONObject, "width");
        this.q = w.c(jSONObject, "height");
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)this.getLayoutParams();
        layoutParams.setMargins(this.n, this.o, 0, 0);
        layoutParams.width = this.p;
        layoutParams.height = this.q;
        this.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    }

    void e(ad ad2) {
        this.w = w.b(ad2.c(), "background_color");
        this.setBackgroundColor(au.g(this.w));
    }

    void f(ad ad2) {
        this.x = w.b(ad2.c(), "font_color");
        this.setTextColor(au.g(this.x));
    }

    void g(ad ad2) {
        this.t = w.c(ad2.c(), "font_size");
        this.setTextSize((float)this.t);
    }

    void h(ad ad2) {
        int n2;
        this.r = n2 = w.c(ad2.c(), "font_style");
        if (n2 != 0) {
            if (n2 != 1) {
                if (n2 != 2) {
                    if (n2 != 3) {
                        return;
                    }
                    this.setTypeface(this.getTypeface(), 3);
                    return;
                }
                this.setTypeface(this.getTypeface(), 2);
                return;
            }
            this.setTypeface(this.getTypeface(), 1);
            return;
        }
        this.setTypeface(this.getTypeface(), 0);
    }

    void i(ad ad2) {
        this.y = w.b(ad2.c(), "text");
        this.setText((CharSequence)this.y);
    }

    void j(ad ad2) {
        int n2;
        this.s = n2 = w.c(ad2.c(), "font_family");
        if (n2 != 0) {
            if (n2 != 1) {
                if (n2 != 2) {
                    if (n2 != 3) {
                        return;
                    }
                    this.setTypeface(Typeface.MONOSPACE);
                    return;
                }
                this.setTypeface(Typeface.SANS_SERIF);
                return;
            }
            this.setTypeface(Typeface.SERIF);
            return;
        }
        this.setTypeface(Typeface.DEFAULT);
    }

    void k(ad ad2) {
        if (w.d(ad2.c(), "visible")) {
            this.setVisibility(0);
            return;
        }
        this.setVisibility(4);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @SuppressLint(value={"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        l l2 = a.a();
        d d2 = l2.l();
        int n2 = 255 & motionEvent.getAction();
        if (n2 != 0 && n2 != 1 && n2 != 3 && n2 != 2 && n2 != 5 && n2 != 6) {
            return false;
        }
        int n3 = (int)motionEvent.getX();
        int n4 = (int)motionEvent.getY();
        JSONObject jSONObject = w.a();
        w.b(jSONObject, "view_id", this.m);
        w.a(jSONObject, "ad_session_id", this.z);
        w.b(jSONObject, "container_x", n3 + this.n);
        w.b(jSONObject, "container_y", n4 + this.o);
        w.b(jSONObject, "view_x", n3);
        w.b(jSONObject, "view_y", n4);
        w.b(jSONObject, "id", this.A.getId());
        if (n2 != 0) {
            if (n2 != 1) {
                if (n2 != 2) {
                    if (n2 != 3) {
                        if (n2 != 5) {
                            if (n2 != 6) {
                                do {
                                    return true;
                                    break;
                                } while (true);
                            }
                            int n5 = (65280 & motionEvent.getAction()) >> 8;
                            int n6 = (int)motionEvent.getX(n5);
                            int n7 = (int)motionEvent.getY(n5);
                            w.b(jSONObject, "container_x", (int)motionEvent.getX(n5) + this.n);
                            w.b(jSONObject, "container_y", (int)motionEvent.getY(n5) + this.o);
                            w.b(jSONObject, "view_x", (int)motionEvent.getX(n5));
                            w.b(jSONObject, "view_y", (int)motionEvent.getY(n5));
                            if (!this.A.q()) {
                                l2.a((ax)((Object)d2.f().get((Object)this.z)));
                            }
                            if (n6 > 0 && n6 < this.getWidth() && n7 > 0 && n7 < this.getHeight()) {
                                new ad("AdContainer.on_touch_ended", this.A.c(), jSONObject).b();
                                return true;
                            }
                            new ad("AdContainer.on_touch_cancelled", this.A.c(), jSONObject).b();
                            return true;
                        }
                        int n8 = (65280 & motionEvent.getAction()) >> 8;
                        w.b(jSONObject, "container_x", (int)motionEvent.getX(n8) + this.n);
                        w.b(jSONObject, "container_y", (int)motionEvent.getY(n8) + this.o);
                        w.b(jSONObject, "view_x", (int)motionEvent.getX(n8));
                        w.b(jSONObject, "view_y", (int)motionEvent.getY(n8));
                        new ad("AdContainer.on_touch_began", this.A.c(), jSONObject).b();
                        return true;
                    }
                    new ad("AdContainer.on_touch_cancelled", this.A.c(), jSONObject).b();
                    return true;
                }
                new ad("AdContainer.on_touch_moved", this.A.c(), jSONObject).b();
                return true;
            }
            if (!this.A.q()) {
                l2.a((ax)((Object)d2.f().get((Object)this.z)));
            }
            if (n3 > 0 && n3 < this.getWidth() && n4 > 0 && n4 < this.getHeight()) {
                new ad("AdContainer.on_touch_ended", this.A.c(), jSONObject).b();
                return true;
            }
            new ad("AdContainer.on_touch_cancelled", this.A.c(), jSONObject).b();
            return true;
        }
        new ad("AdContainer.on_touch_began", this.A.c(), jSONObject).b();
        return true;
    }
}


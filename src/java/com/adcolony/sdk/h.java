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
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.HashMap
 *  org.json.JSONObject
 */
package com.adcolony.sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.adcolony.sdk.a;
import com.adcolony.sdk.ad;
import com.adcolony.sdk.af;
import com.adcolony.sdk.au;
import com.adcolony.sdk.ax;
import com.adcolony.sdk.c;
import com.adcolony.sdk.d;
import com.adcolony.sdk.h;
import com.adcolony.sdk.l;
import com.adcolony.sdk.w;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;

class h
extends View {
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private String f;
    private String g;
    private c h;
    private ad i;

    h(Context context, ad ad2, int n2, c c2) {
        super(context);
        this.h = c2;
        this.i = ad2;
        this.a = n2;
    }

    void a() {
        JSONObject jSONObject = this.i.c();
        this.g = w.b(jSONObject, "ad_session_id");
        this.b = w.c(jSONObject, "x");
        this.c = w.c(jSONObject, "y");
        this.d = w.c(jSONObject, "width");
        this.e = w.c(jSONObject, "height");
        this.f = w.b(jSONObject, "color");
        this.setVisibility(4);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.d, this.e);
        layoutParams.setMargins(this.b, this.c, 0, 0);
        layoutParams.gravity = 0;
        this.h.addView((View)this, (ViewGroup.LayoutParams)layoutParams);
        this.setBackgroundColor(au.g(this.f));
        this.h.m().add((Object)a.a("ColorView.set_bounds", new af(this){
            final /* synthetic */ h a;
            {
                this.a = h2;
            }

            public void a(ad ad2) {
                if (this.a.a(ad2)) {
                    this.a.b(ad2);
                }
            }
        }, true));
        this.h.m().add((Object)a.a("ColorView.set_visible", new af(this){
            final /* synthetic */ h a;
            {
                this.a = h2;
            }

            public void a(ad ad2) {
                if (this.a.a(ad2)) {
                    this.a.d(ad2);
                }
            }
        }, true));
        this.h.m().add((Object)a.a("ColorView.set_color", new af(this){
            final /* synthetic */ h a;
            {
                this.a = h2;
            }

            public void a(ad ad2) {
                if (this.a.a(ad2)) {
                    this.a.c(ad2);
                }
            }
        }, true));
        this.h.n().add((Object)"ColorView.set_bounds");
        this.h.n().add((Object)"ColorView.set_visible");
        this.h.n().add((Object)"ColorView.set_color");
    }

    boolean a(ad ad2) {
        JSONObject jSONObject = ad2.c();
        return w.c(jSONObject, "id") == this.a && w.c(jSONObject, "container_id") == this.h.d() && w.b(jSONObject, "ad_session_id").equals((Object)this.h.b());
    }

    void b(ad ad2) {
        JSONObject jSONObject = ad2.c();
        this.b = w.c(jSONObject, "x");
        this.c = w.c(jSONObject, "y");
        this.d = w.c(jSONObject, "width");
        this.e = w.c(jSONObject, "height");
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)this.getLayoutParams();
        layoutParams.setMargins(this.b, this.c, 0, 0);
        layoutParams.width = this.d;
        layoutParams.height = this.e;
        this.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    }

    void c(ad ad2) {
        this.setBackgroundColor(au.g(w.b(ad2.c(), "color")));
    }

    void d(ad ad2) {
        if (w.d(ad2.c(), "visible")) {
            this.setVisibility(0);
            return;
        }
        this.setVisibility(4);
    }

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
        w.b(jSONObject, "view_id", this.a);
        w.a(jSONObject, "ad_session_id", this.g);
        w.b(jSONObject, "container_x", n3 + this.b);
        w.b(jSONObject, "container_y", n4 + this.c);
        w.b(jSONObject, "view_x", n3);
        w.b(jSONObject, "view_y", n4);
        w.b(jSONObject, "id", this.h.d());
        if (n2 != 0) {
            if (n2 != 1) {
                if (n2 != 2) {
                    if (n2 != 3) {
                        if (n2 != 5) {
                            if (n2 != 6) {
                                return true;
                            }
                            int n5 = (65280 & motionEvent.getAction()) >> 8;
                            w.b(jSONObject, "container_x", (int)motionEvent.getX(n5) + this.b);
                            w.b(jSONObject, "container_y", (int)motionEvent.getY(n5) + this.c);
                            w.b(jSONObject, "view_x", (int)motionEvent.getX(n5));
                            w.b(jSONObject, "view_y", (int)motionEvent.getY(n5));
                            if (!this.h.q()) {
                                l2.a((ax)((Object)d2.f().get((Object)this.g)));
                            }
                            new ad("AdContainer.on_touch_ended", this.h.c(), jSONObject).b();
                            return true;
                        }
                        int n6 = (65280 & motionEvent.getAction()) >> 8;
                        w.b(jSONObject, "container_x", (int)motionEvent.getX(n6) + this.b);
                        w.b(jSONObject, "container_y", (int)motionEvent.getY(n6) + this.c);
                        w.b(jSONObject, "view_x", (int)motionEvent.getX(n6));
                        w.b(jSONObject, "view_y", (int)motionEvent.getY(n6));
                        new ad("AdContainer.on_touch_began", this.h.c(), jSONObject).b();
                        return true;
                    }
                    new ad("AdContainer.on_touch_cancelled", this.h.c(), jSONObject).b();
                    return true;
                }
                new ad("AdContainer.on_touch_moved", this.h.c(), jSONObject).b();
                return true;
            }
            if (!this.h.q()) {
                l2.a((ax)((Object)d2.f().get((Object)this.g)));
            }
            new ad("AdContainer.on_touch_ended", this.h.c(), jSONObject).b();
            return true;
        }
        new ad("AdContainer.on_touch_began", this.h.c(), jSONObject).b();
        return true;
    }
}


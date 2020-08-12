/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.net.Uri
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.ImageView
 *  java.io.File
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.HashMap
 *  org.json.JSONObject
 */
package com.adcolony.sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.adcolony.sdk.a;
import com.adcolony.sdk.ad;
import com.adcolony.sdk.af;
import com.adcolony.sdk.ax;
import com.adcolony.sdk.c;
import com.adcolony.sdk.d;
import com.adcolony.sdk.l;
import com.adcolony.sdk.n;
import com.adcolony.sdk.u;
import com.adcolony.sdk.w;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;

@SuppressLint(value={"AppCompatCustomView"})
class u
extends ImageView {
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private boolean f;
    private boolean g;
    private boolean h;
    private String i;
    private String j;
    private ad k;
    private c l;

    u(Context context, ad ad2, int n2, c c2) {
        super(context);
        this.a = n2;
        this.k = ad2;
        this.l = c2;
    }

    private boolean a(ad ad2) {
        JSONObject jSONObject = ad2.c();
        return w.c(jSONObject, "id") == this.a && w.c(jSONObject, "container_id") == this.l.d() && w.b(jSONObject, "ad_session_id").equals((Object)this.l.b());
    }

    static /* synthetic */ boolean a(u u2, ad ad2) {
        return u2.a(ad2);
    }

    private void b(ad ad2) {
        JSONObject jSONObject = ad2.c();
        this.b = w.c(jSONObject, "x");
        this.c = w.c(jSONObject, "y");
        this.d = w.c(jSONObject, "width");
        this.e = w.c(jSONObject, "height");
        if (this.f) {
            float f2 = a.a().m().o() * (float)this.e / (float)this.getDrawable().getIntrinsicHeight();
            this.e = (int)(f2 * (float)this.getDrawable().getIntrinsicHeight());
            this.d = (int)(f2 * (float)this.getDrawable().getIntrinsicWidth());
            this.b -= this.d;
            this.c -= this.e;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)this.getLayoutParams();
        layoutParams.setMargins(this.b, this.c, 0, 0);
        layoutParams.width = this.d;
        layoutParams.height = this.e;
        this.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    }

    static /* synthetic */ void b(u u2, ad ad2) {
        u2.d(ad2);
    }

    private void c(ad ad2) {
        this.i = w.b(ad2.c(), "filepath");
        this.setImageURI(Uri.fromFile((File)new File(this.i)));
    }

    static /* synthetic */ void c(u u2, ad ad2) {
        u2.b(ad2);
    }

    private void d(ad ad2) {
        if (w.d(ad2.c(), "visible")) {
            this.setVisibility(0);
            return;
        }
        this.setVisibility(4);
    }

    static /* synthetic */ void d(u u2, ad ad2) {
        u2.c(ad2);
    }

    void a() {
        JSONObject jSONObject = this.k.c();
        this.j = w.b(jSONObject, "ad_session_id");
        this.b = w.c(jSONObject, "x");
        this.c = w.c(jSONObject, "y");
        this.d = w.c(jSONObject, "width");
        this.e = w.c(jSONObject, "height");
        this.i = w.b(jSONObject, "filepath");
        this.f = w.d(jSONObject, "dpi");
        this.g = w.d(jSONObject, "invert_y");
        this.h = w.d(jSONObject, "wrap_content");
        this.setImageURI(Uri.fromFile((File)new File(this.i)));
        if (this.f) {
            float f2 = a.a().m().o() * (float)this.e / (float)this.getDrawable().getIntrinsicHeight();
            this.e = (int)(f2 * (float)this.getDrawable().getIntrinsicHeight());
            this.d = (int)(f2 * (float)this.getDrawable().getIntrinsicWidth());
            this.b -= this.d;
            int n2 = this.g ? this.c + this.e : this.c - this.e;
            this.c = n2;
        }
        this.setVisibility(4);
        FrameLayout.LayoutParams layoutParams = this.h ? new FrameLayout.LayoutParams(-2, -2) : new FrameLayout.LayoutParams(this.d, this.e);
        layoutParams.setMargins(this.b, this.c, 0, 0);
        layoutParams.gravity = 0;
        this.l.addView((View)this, (ViewGroup.LayoutParams)layoutParams);
        this.l.m().add((Object)a.a("ImageView.set_visible", new af(this){
            final /* synthetic */ u a;
            {
                this.a = u2;
            }

            public void a(ad ad2) {
                if (u.a(this.a, ad2)) {
                    u.b(this.a, ad2);
                }
            }
        }, true));
        this.l.m().add((Object)a.a("ImageView.set_bounds", new af(this){
            final /* synthetic */ u a;
            {
                this.a = u2;
            }

            public void a(ad ad2) {
                if (u.a(this.a, ad2)) {
                    u.c(this.a, ad2);
                }
            }
        }, true));
        this.l.m().add((Object)a.a("ImageView.set_image", new af(this){
            final /* synthetic */ u a;
            {
                this.a = u2;
            }

            public void a(ad ad2) {
                if (u.a(this.a, ad2)) {
                    u.d(this.a, ad2);
                }
            }
        }, true));
        this.l.n().add((Object)"ImageView.set_visible");
        this.l.n().add((Object)"ImageView.set_bounds");
        this.l.n().add((Object)"ImageView.set_image");
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
        w.b(jSONObject, "view_id", this.a);
        w.a(jSONObject, "ad_session_id", this.j);
        w.b(jSONObject, "container_x", n3 + this.b);
        w.b(jSONObject, "container_y", n4 + this.c);
        w.b(jSONObject, "view_x", n3);
        w.b(jSONObject, "view_y", n4);
        w.b(jSONObject, "id", this.l.getId());
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
                            w.b(jSONObject, "container_x", (int)motionEvent.getX(n5) + this.b);
                            w.b(jSONObject, "container_y", (int)motionEvent.getY(n5) + this.c);
                            w.b(jSONObject, "view_x", (int)motionEvent.getX(n5));
                            w.b(jSONObject, "view_y", (int)motionEvent.getY(n5));
                            if (!this.l.q()) {
                                l2.a((ax)((Object)d2.f().get((Object)this.j)));
                            }
                            if (n6 > 0 && n6 < this.d && n7 > 0 && n7 < this.e) {
                                new ad("AdContainer.on_touch_ended", this.l.c(), jSONObject).b();
                                return true;
                            }
                            new ad("AdContainer.on_touch_cancelled", this.l.c(), jSONObject).b();
                            return true;
                        }
                        int n8 = (65280 & motionEvent.getAction()) >> 8;
                        w.b(jSONObject, "container_x", (int)motionEvent.getX(n8) + this.b);
                        w.b(jSONObject, "container_y", (int)motionEvent.getY(n8) + this.c);
                        w.b(jSONObject, "view_x", (int)motionEvent.getX(n8));
                        w.b(jSONObject, "view_y", (int)motionEvent.getY(n8));
                        new ad("AdContainer.on_touch_began", this.l.c(), jSONObject).b();
                        return true;
                    }
                    new ad("AdContainer.on_touch_cancelled", this.l.c(), jSONObject).b();
                    return true;
                }
                new ad("AdContainer.on_touch_moved", this.l.c(), jSONObject).b();
                return true;
            }
            if (!this.l.q()) {
                l2.a((ax)((Object)d2.f().get((Object)this.j)));
            }
            if (n3 > 0 && n3 < this.d && n4 > 0 && n4 < this.e) {
                new ad("AdContainer.on_touch_ended", this.l.c(), jSONObject).b();
                return true;
            }
            new ad("AdContainer.on_touch_cancelled", this.l.c(), jSONObject).b();
            return true;
        }
        new ad("AdContainer.on_touch_began", this.l.c(), jSONObject).b();
        return true;
    }
}


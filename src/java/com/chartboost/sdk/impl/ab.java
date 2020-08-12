/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Point
 *  android.media.MediaPlayer
 *  android.media.MediaPlayer$OnCompletionListener
 *  android.media.MediaPlayer$OnErrorListener
 *  android.media.MediaPlayer$OnPreparedListener
 *  android.net.Uri
 *  android.os.Handler
 *  android.util.DisplayMetrics
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.animation.AlphaAnimation
 *  android.view.animation.Animation
 *  android.widget.ImageView
 *  android.widget.ImageView$ScaleType
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  android.widget.TextView
 *  com.chartboost.sdk.impl.ab$1
 *  com.chartboost.sdk.impl.v
 *  com.chartboost.sdk.impl.v$a
 *  com.chartboost.sdk.impl.x
 *  java.lang.CharSequence
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.util.Locale
 *  org.json.JSONObject
 */
package com.chartboost.sdk.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.Libraries.h;
import com.chartboost.sdk.g;
import com.chartboost.sdk.impl.aa;
import com.chartboost.sdk.impl.ab;
import com.chartboost.sdk.impl.av;
import com.chartboost.sdk.impl.az;
import com.chartboost.sdk.impl.v;
import com.chartboost.sdk.impl.x;
import java.util.Locale;
import org.json.JSONObject;

@SuppressLint(value={"ViewConstructor"})
public class ab
extends RelativeLayout
implements MediaPlayer.OnCompletionListener,
MediaPlayer.OnErrorListener,
MediaPlayer.OnPreparedListener {
    private static final CharSequence k = "00:00";
    final RelativeLayout a;
    final aa b;
    final aa c;
    final az d;
    final TextView e;
    final x f;
    final av g;
    final v h;
    final Handler i;
    final Runnable j = new Runnable(){
        private int b = 0;

        public void run() {
            v.a a2 = ab.this.h.q();
            if (a2 != null) {
                az az2;
                if (ab.this.g.a().e()) {
                    int n2;
                    int n3 = ab.this.g.a().d();
                    if (n3 > 0) {
                        ab.this.h.v = n3;
                        if ((float)ab.this.h.v / 1000.0f > 0.0f && !ab.this.h.t()) {
                            ab.this.h.r();
                            ab.this.h.a(true);
                        }
                    }
                    float f2 = (float)n3 / (float)ab.this.g.a().c();
                    if (ab.this.h.M) {
                        ab.this.f.a(f2);
                    }
                    if (this.b != (n2 = n3 / 1000)) {
                        this.b = n2;
                        int n4 = n2 / 60;
                        int n5 = n2 % 60;
                        TextView textView = ab.this.e;
                        Locale locale = Locale.US;
                        Object[] arrobject = new Object[]{n4, n5};
                        textView.setText((CharSequence)String.format((Locale)locale, (String)"%02d:%02d", (Object[])arrobject));
                    }
                }
                if (a2.f() && (az2 = a2.d(true)).getVisibility() == 8) {
                    ab.this.h.a(true, (View)az2);
                    az2.setEnabled(true);
                }
                ab.this.i.removeCallbacks(ab.this.j);
                ab.this.i.postDelayed(ab.this.j, 16L);
            }
        }
    };
    private boolean l = false;
    private boolean m = false;
    private final Runnable n = new Runnable(){

        public void run() {
            ab.this.a(false);
        }
    };
    private final Runnable o = new Runnable(){

        public void run() {
            if (ab.this.b != null) {
                ab.this.b.setVisibility(8);
            }
            if (ab.this.h.M) {
                ab.this.f.setVisibility(8);
            }
            ab.this.c.setVisibility(8);
            if (ab.this.d != null) {
                ab.this.d.setEnabled(false);
            }
        }
    };

    public ab(Context context, v v2) {
        super(context);
        this.h = v2;
        this.i = v2.a;
        JSONObject jSONObject = v2.g();
        float f2 = context.getResources().getDisplayMetrics().density;
        float f3 = 10.0f * f2;
        int n2 = Math.round((float)f3);
        g g2 = g.a();
        this.g = g2.a(new av(context));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        this.addView((View)this.g, (ViewGroup.LayoutParams)layoutParams);
        this.a = g2.a(new RelativeLayout(context));
        if (jSONObject != null && !jSONObject.isNull("video-click-button")) {
            this.b = g2.a(new aa(context));
            this.b.setVisibility(8);
            this.d = new 1(this, context);
            this.d.a(ImageView.ScaleType.FIT_CENTER);
            h h2 = v2.I;
            Point point = v2.b("video-click-button");
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.leftMargin = Math.round((float)((float)point.x / h2.f()));
            layoutParams2.topMargin = Math.round((float)((float)point.y / h2.f()));
            v2.a((ViewGroup.LayoutParams)layoutParams2, h2, 1.0f);
            this.d.a(h2);
            this.b.addView((View)this.d, (ViewGroup.LayoutParams)layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, Math.round((float)(f3 + (float)layoutParams2.height)));
            layoutParams3.addRule(10);
            this.a.addView((View)this.b, (ViewGroup.LayoutParams)layoutParams3);
        } else {
            this.b = null;
            this.d = null;
        }
        this.c = g2.a(new aa(context));
        this.c.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, Math.round((float)(f2 * 32.5f)));
        layoutParams4.addRule(12);
        this.a.addView((View)this.c, (ViewGroup.LayoutParams)layoutParams4);
        this.c.setGravity(16);
        this.c.setPadding(n2, n2, n2, n2);
        this.e = g2.a(new TextView(context));
        this.e.setTextColor(-1);
        this.e.setTextSize(2, 11.0f);
        this.e.setText(k);
        this.e.setPadding(0, 0, n2, 0);
        this.e.setSingleLine();
        this.e.measure(0, 0);
        int n3 = this.e.getMeasuredWidth();
        this.e.setGravity(17);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(n3, -1);
        this.c.addView((View)this.e, (ViewGroup.LayoutParams)layoutParams5);
        this.f = g2.a(new x(context));
        this.f.setVisibility(8);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, Math.round((float)f3));
        layoutParams6.setMargins(0, CBUtility.a(1, context), 0, 0);
        this.c.addView((View)this.f, (ViewGroup.LayoutParams)layoutParams6);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams7.addRule(6, this.g.getId());
        layoutParams7.addRule(8, this.g.getId());
        layoutParams7.addRule(5, this.g.getId());
        layoutParams7.addRule(7, this.g.getId());
        this.addView((View)this.a, (ViewGroup.LayoutParams)layoutParams7);
        this.a();
    }

    public void a() {
        this.c(CBUtility.a(CBUtility.a()));
    }

    public void a(int n2) {
        aa aa2 = this.b;
        if (aa2 != null) {
            aa2.setBackgroundColor(n2);
        }
        this.c.setBackgroundColor(n2);
    }

    public void a(String string) {
        this.g.a().a(this);
        this.g.a().a(this);
        this.g.a().a(this);
        this.g.a().a(Uri.parse((String)string));
    }

    void a(boolean bl) {
        this.a(true ^ this.l, bl);
    }

    protected void a(boolean bl, boolean bl2) {
        this.i.removeCallbacks(this.n);
        this.i.removeCallbacks(this.o);
        if (this.h.y) {
            aa aa2;
            if (!this.h.p()) {
                return;
            }
            if (bl == this.l) {
                return;
            }
            this.l = bl;
            AlphaAnimation alphaAnimation = this.l ? new AlphaAnimation(0.0f, 1.0f) : new AlphaAnimation(1.0f, 0.0f);
            long l2 = bl2 ? 100L : 200L;
            alphaAnimation.setDuration(l2);
            alphaAnimation.setFillAfter(true);
            if (!this.m && (aa2 = this.b) != null) {
                aa2.setVisibility(0);
                this.b.startAnimation((Animation)alphaAnimation);
                az az2 = this.d;
                if (az2 != null) {
                    az2.setEnabled(true);
                }
            }
            if (this.h.M) {
                this.f.setVisibility(0);
            }
            this.c.setVisibility(0);
            this.c.startAnimation((Animation)alphaAnimation);
            if (this.l) {
                this.i.postDelayed(this.n, 3000L);
                return;
            }
            this.i.postDelayed(this.o, alphaAnimation.getDuration());
        }
    }

    public av.a b() {
        return this.g.a();
    }

    public void b(boolean bl) {
        this.i.removeCallbacks(this.n);
        this.i.removeCallbacks(this.o);
        if (bl) {
            aa aa2;
            if (!this.m && (aa2 = this.b) != null) {
                aa2.setVisibility(0);
            }
            if (this.h.M) {
                this.f.setVisibility(0);
            }
            this.c.setVisibility(0);
            az az2 = this.d;
            if (az2 != null) {
                az2.setEnabled(true);
            }
        } else {
            aa aa3 = this.b;
            if (aa3 != null) {
                aa3.clearAnimation();
                this.b.setVisibility(8);
            }
            this.c.clearAnimation();
            if (this.h.M) {
                this.f.setVisibility(8);
            }
            this.c.setVisibility(8);
            az az3 = this.d;
            if (az3 != null) {
                az3.setEnabled(false);
            }
        }
        this.l = bl;
    }

    public x c() {
        return this.f;
    }

    public void c(boolean bl) {
        int n2 = bl ? -16777216 : 0;
        this.setBackgroundColor(n2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (!bl) {
            layoutParams.addRule(6, this.g.getId());
            layoutParams.addRule(8, this.g.getId());
            layoutParams.addRule(5, this.g.getId());
            layoutParams.addRule(7, this.g.getId());
        }
        this.a.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
        aa aa2 = this.b;
        if (aa2 != null) {
            aa2.setGravity(8388627);
            this.b.requestLayout();
        }
    }

    public void d() {
        aa aa2 = this.b;
        if (aa2 != null) {
            aa2.setVisibility(8);
        }
        this.m = true;
        az az2 = this.d;
        if (az2 != null) {
            az2.setEnabled(false);
        }
    }

    public void d(boolean bl) {
        TextView textView = this.e;
        int n2 = bl ? 0 : 8;
        textView.setVisibility(n2);
    }

    public void e() {
        this.i.postDelayed(new Runnable(){

            public void run() {
                ab.this.g.setVisibility(0);
            }
        }, 500L);
        this.g.a().a();
        this.i.removeCallbacks(this.j);
        this.i.postDelayed(this.j, 16L);
    }

    public void f() {
        if (this.g.a().e()) {
            this.h.v = this.g.a().d();
            this.g.a().b();
        }
        if (this.h.q().e.getVisibility() == 0) {
            this.h.q().e.postInvalidate();
        }
        this.i.removeCallbacks(this.j);
    }

    public void g() {
        if (this.g.a().e()) {
            this.h.v = this.g.a().d();
        }
        this.g.a().b();
        this.i.removeCallbacks(this.j);
    }

    public void h() {
        this.g.setVisibility(8);
        this.invalidate();
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        this.h.v = this.g.a().c();
        if (this.h.q() != null) {
            this.h.q().e();
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.i.removeCallbacks(this.j);
    }

    public boolean onError(MediaPlayer mediaPlayer, int n2, int n3) {
        this.h.v();
        return false;
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        this.h.w = this.g.a().c();
        this.h.q().a(true);
    }

    @SuppressLint(value={"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.g.a().e() && motionEvent.getActionMasked() == 0) {
            if (this.h != null) {
                this.a(true);
            }
            return true;
        }
        return false;
    }

    public void setEnabled(boolean bl) {
        super.setEnabled(bl);
        az az2 = this.d;
        if (az2 != null) {
            az2.setEnabled(bl);
        }
        if (bl) {
            this.b(false);
        }
    }

}


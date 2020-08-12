/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Configuration
 *  android.os.Bundle
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  android.widget.VideoView
 *  java.lang.Object
 */
package com.tappx.a.a.b;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.VideoView;
import com.tappx.a.a.a.h.g;
import com.tappx.a.a.a.h.h;
import com.tappx.a.a.b.aa;

public abstract class e {
    private final Context a;
    private final RelativeLayout b;
    private final a c;
    private final g d;
    private View e;

    protected e(Context context, a a2) {
        this.a = context;
        this.d = h.a(context).a();
        this.c = a2;
        this.b = new RelativeLayout(this.a);
    }

    private void k() {
        if (!this.d.h()) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 83);
        View view = this.l();
        this.b.addView(view, (ViewGroup.LayoutParams)layoutParams);
    }

    private View l() {
        return com.tappx.a.a.a.k.a.b(this.a);
    }

    public void a() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        this.b.addView((View)this.b(), 0, (ViewGroup.LayoutParams)layoutParams);
        this.k();
        this.c.onSetContentView((View)this.b);
    }

    public void a(int n2, int n3, Intent intent) {
    }

    public abstract void a(Configuration var1);

    public abstract void a(Bundle var1);

    protected void a(boolean bl) {
        aa.f("Video cannot be played.");
        if (bl) {
            this.c.onFinish();
        }
    }

    protected abstract VideoView b();

    protected void b(boolean bl) {
        if (bl) {
            this.c.onFinish();
        }
    }

    public abstract void c();

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public boolean g() {
        return true;
    }

    protected a h() {
        return this.c;
    }

    protected Context i() {
        return this.a;
    }

    public ViewGroup j() {
        return this.b;
    }

    public static interface a {
        public void onFinish();

        public void onSetContentView(View var1);
    }

}


/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.animation.Animation
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  java.lang.Class
 *  java.lang.Deprecated
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.tappx.a.a.a.g;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import com.tappx.a.a.a.d;
import com.tappx.a.a.a.d.d;
import com.tappx.a.a.a.e.c;
import com.tappx.a.a.a.g.b;
import com.tappx.a.a.a.h;
import com.tappx.a.a.a.h.g;
import com.tappx.a.a.a.j.e;
import com.tappx.sdk.android.AdRequest;
import com.tappx.sdk.android.TappxAdError;
import com.tappx.sdk.android.TappxBanner;
import com.tappx.sdk.android.TappxBannerListener;

public class b
extends com.tappx.a.a.a.g.a {
    private final TappxBanner d;
    private final com.tappx.a.a.a.d.d e;
    private final e f;
    private View g;
    private TappxBannerListener h;
    private boolean i;
    private boolean j;
    private com.tappx.a.a.a.e.b k;
    private boolean l;
    private int m;
    private final d.a n = new d.a(this){
        final /* synthetic */ b a;
        {
            this.a = b2;
        }

        public Context a() {
            return b.a(this.a).getContext();
        }

        public void a(com.tappx.a.a.a.e.b b2) {
            b.d(this.a).c();
            if (b.e(this.a) != null) {
                b.e(this.a).onBannerExpanded(b.a(this.a));
            }
        }

        public void a(com.tappx.a.a.a.e.b b2, View view) {
            if (this.a.c) {
                return;
            }
            b.a(this.a, false);
            b.a(this.a, b2);
            b.a(this.a, view);
            this.a.g();
            b.b(this.a);
            b.b(this.a, b2);
            b.c(this.a);
        }

        public void a(com.tappx.a.a.a.e.h h2) {
            if (this.a.c) {
                return;
            }
            TappxAdError tappxAdError = this.a.b(h2);
            b.a(this.a, tappxAdError);
            this.a.g();
        }

        public void b(com.tappx.a.a.a.e.b b2) {
            b.d(this.a).d();
            if (b.e(this.a) != null) {
                b.e(this.a).onBannerCollapsed(b.a(this.a));
            }
        }

        public void c(com.tappx.a.a.a.e.b b2) {
            if (b.e(this.a) != null) {
                b.e(this.a).onBannerClicked(b.a(this.a));
            }
            this.a.c(b2.b());
        }
    };
    private final e.a o = new e.a(this){
        final /* synthetic */ b a;
        {
            this.a = b2;
        }

        public void a() {
            this.a.f();
        }
    };

    b(TappxBanner tappxBanner) {
        super(tappxBanner.getContext(), c.a);
        this.d = tappxBanner;
        d d2 = d.a(tappxBanner.getContext());
        this.e = d2.a();
        this.e.a(this.n);
        this.f = d2.b();
        this.f.a(this.o);
    }

    b(TappxBanner tappxBanner, g g2) {
        super(tappxBanner.getContext(), c.a, g2);
        this.d = tappxBanner;
        d d2 = d.a(tappxBanner.getContext());
        this.e = d2.a();
        this.e.a(this.n);
        this.f = d2.b();
        this.f.a(this.o);
    }

    static /* synthetic */ com.tappx.a.a.a.e.b a(b b2, com.tappx.a.a.a.e.b b3) {
        b2.k = b3;
        return b3;
    }

    static /* synthetic */ TappxBanner a(b b2) {
        return b2.d;
    }

    private void a(View view) {
        this.d.removeAllViews();
        this.d.addView(view, 0);
        this.h();
    }

    private void a(com.tappx.a.a.a.e.b b2) {
        Animation animation = com.tappx.a.a.b.d.a(com.tappx.a.a.a.j.a.a(b2.e()));
        if (animation != null) {
            this.d.startAnimation(animation);
        }
    }

    static /* synthetic */ void a(b b2, View view) {
        b2.a(view);
    }

    static /* synthetic */ void a(b b2, TappxAdError tappxAdError) {
        b2.b(tappxAdError);
    }

    static /* synthetic */ boolean a(b b2, boolean bl) {
        b2.j = bl;
        return bl;
    }

    private String b(TappxBanner.AdSize adSize) {
        if (adSize == TappxBanner.AdSize.SMART_BANNER) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(adSize.getWidth());
        stringBuilder.append("x");
        stringBuilder.append(adSize.getHeight());
        return stringBuilder.toString();
    }

    static /* synthetic */ void b(b b2) {
        b2.j();
    }

    static /* synthetic */ void b(b b2, com.tappx.a.a.a.e.b b3) {
        b2.a(b3);
    }

    private void b(TappxAdError tappxAdError) {
        TappxBannerListener tappxBannerListener = this.h;
        if (tappxBannerListener != null) {
            tappxBannerListener.onBannerLoadFailed(this.d, tappxAdError);
        }
    }

    private void c(int n2) {
        if (n2 == 0) {
            com.tappx.a.a.a.c.a.e("Rfk0iXqG1NksAriLhvTIFrKC3X10rpfR3hyZYQqfkTdNYvQAOBsj6pQCdtEQgCZY", new Object[0]);
            this.f.b();
            this.f.a(false);
            return;
        }
        this.f.a(true);
        if (n2 > 0) {
            this.f.a(n2);
            return;
        }
        this.f.e();
    }

    static /* synthetic */ void c(b b2) {
        b2.k();
    }

    static /* synthetic */ e d(b b2) {
        return b2.f;
    }

    static /* synthetic */ TappxBannerListener e(b b2) {
        return b2.h;
    }

    private void h() {
        if (!this.a.h()) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 83);
        this.d.addView(this.i(), (ViewGroup.LayoutParams)layoutParams);
    }

    private View i() {
        if (this.g == null) {
            this.g = com.tappx.a.a.a.k.a.a(this.d.getContext());
        }
        return this.g;
    }

    private void j() {
        TappxBannerListener tappxBannerListener = this.h;
        if (tappxBannerListener != null) {
            tappxBannerListener.onBannerLoaded(this.d);
        }
    }

    private void k() {
        com.tappx.a.a.a.e.b b2;
        boolean bl = this.m >= 50;
        if (!this.j && (b2 = this.k) != null && this.l) {
            if (!bl) {
                return;
            }
            this.j = true;
            this.c(b2.d());
        }
    }

    public void a(int n2) {
        boolean bl = n2 > 0;
        this.i = bl;
        this.c(n2);
    }

    @Override
    public void a(AdRequest adRequest) {
        if (this.a.e()) {
            this.a.a(this.d.getContext(), null);
        }
        super.a(adRequest);
    }

    @Override
    protected void a(TappxAdError tappxAdError) {
        TappxBannerListener tappxBannerListener = this.h;
        if (tappxBannerListener != null) {
            tappxBannerListener.onBannerLoadFailed(this.d, tappxAdError);
        }
    }

    public void a(TappxBanner.AdSize adSize) {
        if (adSize == null) {
            adSize = TappxBanner.AdSize.SMART_BANNER;
        }
        this.b(this.b(adSize));
    }

    public void a(TappxBannerListener tappxBannerListener) {
        this.h = tappxBannerListener;
    }

    public void a(boolean bl) {
        this.f.a(bl);
    }

    @Override
    public void b() {
        super.b();
        this.a((TappxBannerListener)null);
        this.d.removeAllViews();
        this.e.c();
        this.f.b();
        this.k = null;
    }

    public void b(int n2) {
        this.m = n2;
        this.k();
    }

    @Override
    protected void b(com.tappx.a.a.a.e.d d2) {
        this.c(d2);
        this.e.a(this.d.getContext(), d2);
    }

    public void b(boolean bl) {
        Object[] arrobject = new Object[]{String.valueOf((boolean)bl)};
        com.tappx.a.a.a.c.a.e("r+UiUzt9REOhqndIQXQTv4xLHJ5RqFQyDLMKVsbc2y8", arrobject);
        this.l = bl;
        if (bl) {
            this.k();
            this.f.d();
            return;
        }
        this.f.c();
    }

    void c(com.tappx.a.a.a.e.d d2) {
        if (!this.i) {
            this.c(d2.c());
        }
    }

    @Override
    protected void d() {
        super.d();
        this.e.d();
    }

    void f() {
        if (!this.c) {
            if (!this.l) {
                return;
            }
            com.tappx.a.a.a.c.a.a(h.a("WYP3IlFsQbao/nmzk+V5+EDTMrEq8ygXRWqwiT3aXVk"), new Object[0]);
            com.tappx.a.a.a.c.a.e("fhrgFfJqgVZoVNjzyS7CzU1i9AA4GyPqlAJ20RCAJlg", new Object[0]);
            this.c();
        }
    }

    void g() {
        if (!this.l) {
            return;
        }
        this.f.a();
    }

}


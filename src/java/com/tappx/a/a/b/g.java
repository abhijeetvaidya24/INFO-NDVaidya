/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Typeface
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.StateListDrawable
 *  android.util.StateSet
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.TextView
 *  com.tappx.a.a.b.g$1
 *  java.lang.Enum
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.String
 */
package com.tappx.a.a.b;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.StateSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tappx.a.a.b.g;
import com.tappx.a.a.b.h;
import com.tappx.a.a.b.j;
import com.tappx.a.a.b.v;

public class g
extends FrameLayout {
    public static final int a = 18;
    private final j b;
    private boolean c;
    private boolean d;
    private StateListDrawable e;
    private b f = b.a;
    private a g = a.c;
    private c h;
    private TextView i;
    private boolean j = true;
    private boolean k = true;
    private final j.a l = new 1(this);
    private View.OnClickListener m = new View.OnClickListener(){

        public void onClick(View view) {
            g.this.e();
        }
    };

    public g(Context context) {
        this(context, new j());
    }

    public g(Context context, j j2) {
        super(context);
        this.b = j2;
        j2.a(this.l);
        this.c();
    }

    private void a(b b2) {
        int n2;
        int n3 = 3.a[b2.ordinal()];
        StateListDrawable stateListDrawable = null;
        if (n3 != 1) {
            stateListDrawable = null;
            n2 = 0;
            if (n3 != 2) {
                stateListDrawable = this.e;
                n2 = 0;
            }
        } else {
            n2 = 8;
        }
        this.i.setBackgroundDrawable(stateListDrawable);
        this.i.setVisibility(n2);
    }

    static /* synthetic */ void a(g g2, boolean bl) {
        g2.setCloseVisible(bl);
    }

    static /* synthetic */ boolean a(g g2) {
        return g2.c;
    }

    static /* synthetic */ TextView b(g g2) {
        return g2.i;
    }

    private void c() {
        this.i = new TextView(this.getContext());
        this.e = new StateListDrawable();
        this.e.addState(SELECTED_STATE_SET, v.c.a(this.getContext()));
        this.e.addState(ENABLED_STATE_SET, v.a.a(this.getContext()));
        this.e.addState(StateSet.WILD_CARD, v.b.a(this.getContext()));
        this.i.setBackgroundDrawable((Drawable)this.e);
        this.i.setOnClickListener(this.m);
        this.i.setTextColor(-1);
        this.i.setTypeface(Typeface.SANS_SERIF);
        this.i.setTextSize(18.0f);
        this.i.setGravity(17);
        this.d();
    }

    private void d() {
        FrameLayout.LayoutParams layoutParams = this.getCloseButtonLayoutParams();
        this.addView((View)this.i, (ViewGroup.LayoutParams)layoutParams);
    }

    private void e() {
        if (!this.b.a()) {
            return;
        }
        this.playSoundEffect(0);
        c c2 = this.h;
        if (c2 != null) {
            c2.a();
        }
    }

    private void f() {
        boolean bl = this.j && this.k;
        boolean bl2 = this.d;
        b b2 = bl ? (bl2 ? b.b : b.a) : b.c;
        if (b2 == this.f) {
            return;
        }
        this.f = b2;
        this.a(b2);
    }

    private void g() {
        for (int i2 = 0; i2 < this.getChildCount(); ++i2) {
            View view = this.getChildAt(i2);
            if (view == this.i) continue;
            this.removeView(view);
        }
    }

    private FrameLayout.LayoutParams getCloseButtonLayoutParams() {
        int n2 = h.f(10.0f, this.getContext());
        int n3 = h.f(30.0f, this.getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(n3, n3, this.g.a());
        layoutParams.setMargins(n2, n2, n2, n2);
        return layoutParams;
    }

    private void setCloseVisible(boolean bl) {
        this.k = bl;
        this.f();
    }

    public void a(int n2, boolean bl) {
        if (n2 <= 0) {
            return;
        }
        this.c = bl;
        this.b.a(n2);
    }

    public void a(View view, FrameLayout.LayoutParams layoutParams) {
        this.g();
        this.addView(view, 0, (ViewGroup.LayoutParams)layoutParams);
    }

    public boolean a() {
        return this.getVisibility() == 0 && this.b.a();
    }

    public boolean b() {
        return this.j;
    }

    public void setCloseEnabled(boolean bl) {
        this.j = bl;
        this.f();
    }

    public void setCloseListener(c c2) {
        this.h = c2;
    }

    public void setClosePosition(a a2) {
        this.g = a2;
        this.i.setLayoutParams((ViewGroup.LayoutParams)this.getCloseButtonLayoutParams());
    }

    public void setInvisibleClose(boolean bl) {
        this.d = bl;
        this.f();
    }

    public static final class a
    extends Enum<a> {
        public static final /* enum */ a a = new a(51);
        public static final /* enum */ a b = new a(49);
        public static final /* enum */ a c = new a(53);
        public static final /* enum */ a d = new a(17);
        public static final /* enum */ a e = new a(83);
        public static final /* enum */ a f = new a(81);
        public static final /* enum */ a g = new a(85);
        private static final /* synthetic */ a[] i;
        private final int h;

        static {
            a[] arra = new a[]{a, b, c, d, e, f, g};
            i = arra;
        }

        private a(int n3) {
            this.h = n3;
        }

        public static a valueOf(String string2) {
            return (a)Enum.valueOf(a.class, (String)string2);
        }

        public static a[] values() {
            return (a[])i.clone();
        }

        int a() {
            return this.h;
        }
    }

    private static final class b
    extends Enum<b> {
        public static final /* enum */ b a = new b();
        public static final /* enum */ b b = new b();
        public static final /* enum */ b c = new b();
        private static final /* synthetic */ b[] d;

        static {
            b[] arrb = new b[]{a, b, c};
            d = arrb;
        }

        public static b valueOf(String string2) {
            return (b)Enum.valueOf(b.class, (String)string2);
        }

        public static b[] values() {
            return (b[])d.clone();
        }
    }

    public static interface c {
        public void a();
    }

}


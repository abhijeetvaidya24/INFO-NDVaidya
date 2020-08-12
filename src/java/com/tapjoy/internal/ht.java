/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.Point
 *  android.graphics.Rect
 *  android.graphics.drawable.BitmapDrawable
 *  android.graphics.drawable.Drawable
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.ImageView
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  com.tapjoy.internal.gx
 *  java.lang.Math
 *  java.lang.Object
 *  java.util.ArrayList
 */
package com.tapjoy.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tapjoy.internal.ag;
import com.tapjoy.internal.ah;
import com.tapjoy.internal.gv;
import com.tapjoy.internal.gx;
import com.tapjoy.internal.gy;
import com.tapjoy.internal.ha;
import com.tapjoy.internal.hq;
import java.util.ArrayList;

public final class ht
extends RelativeLayout
implements View.OnClickListener {
    private boolean a;
    private float b = 1.0f;
    private View c;
    private View d;
    private FrameLayout e;
    private ImageView f;
    private hq g;
    private gx h;
    private a i;

    public ht(Context context, gx gx2, a a2) {
        super(context);
        this.h = gx2;
        this.i = a2;
        Context context2 = this.getContext();
        View view = this.c = new View(context2);
        int n2 = 1;
        view.setId(n2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(0, 0);
        layoutParams.addRule(13);
        this.addView(this.c, (ViewGroup.LayoutParams)layoutParams);
        this.d = new View(context2);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(0, 0);
        layoutParams2.addRule(13);
        this.addView(this.d, (ViewGroup.LayoutParams)layoutParams2);
        this.e = new FrameLayout(context2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(0, 0);
        layoutParams3.addRule(13);
        this.addView((View)this.e, (ViewGroup.LayoutParams)layoutParams3);
        this.f = new ImageView(context2);
        this.f.setOnClickListener((View.OnClickListener)this);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(0, 0);
        layoutParams4.addRule(7, this.c.getId());
        layoutParams4.addRule(6, this.c.getId());
        this.addView((View)this.f, (ViewGroup.LayoutParams)layoutParams4);
        if (this.h.m != null) {
            gy gy2 = this.h.m;
            if (gy2.a == null || gy2.b == null && gy2.c == null) {
                n2 = 0;
            }
            if (n2 != 0) {
                this.g = new hq(context2);
                this.g.setOnClickListener((View.OnClickListener)this);
                RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(0, 0);
                layoutParams5.addRule(5, this.d.getId());
                layoutParams5.addRule(8, this.d.getId());
                this.addView((View)this.g, (ViewGroup.LayoutParams)layoutParams5);
            }
        }
        this.f.setImageBitmap(gx2.c.b);
        if (this.g != null && gx2.m != null && gx2.m.a != null) {
            this.g.setImageBitmap(gx2.m.a.b);
        }
    }

    private int a(int n2) {
        return (int)((float)n2 * this.b);
    }

    public final void onClick(View view) {
        hq hq2;
        if (view == this.f) {
            this.i.a();
            return;
        }
        if (view != null && view == (hq2 = this.g)) {
            hq2.a = true ^ hq2.a;
            hq2.a();
            hq2.invalidate();
            this.i.b();
            return;
        }
        if (view.getTag() instanceof gv) {
            this.i.a((gv)view.getTag());
        }
    }

    protected final void onLayout(boolean bl2, int n2, int n3, int n4, int n5) {
        super.onLayout(bl2, n2, n3, n4, n5);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    protected final void onMeasure(int var1_1, int var2_2) {
        block8 : {
            var3_3 = View.MeasureSpec.getSize((int)var1_1);
            var4_4 = View.MeasureSpec.getSize((int)var2_2);
            this.b = this.a != false ? Math.min((float)((float)var3_3 / 480.0f), (float)((float)var4_4 / 320.0f)) : Math.min((float)((float)var3_3 / 320.0f), (float)((float)var4_4 / 480.0f));
            var5_5 = (RelativeLayout.LayoutParams)this.c.getLayoutParams();
            var6_6 = this.a;
            var7_7 = 480;
            var8_8 = var6_6 != false ? 480 : 320;
            var5_5.width = this.a(var8_8);
            if (this.a) {
                var7_7 = 320;
            }
            var5_5.height = this.a(var7_7);
            var9_9 = (RelativeLayout.LayoutParams)this.d.getLayoutParams();
            var10_10 = this.a;
            var11_11 = 448;
            var12_12 = var10_10 != false ? 448 : 290;
            var9_9.width = this.a(var12_12);
            if (this.a) {
                var11_11 = 290;
            }
            var9_9.height = this.a(var11_11);
            var13_13 = (RelativeLayout.LayoutParams)this.e.getLayoutParams();
            var13_13.width = var9_9.width;
            var13_13.height = var9_9.height;
            for (View var29_15 : ah.a((ViewGroup)this.e)) {
                var30_16 = (FrameLayout.LayoutParams)var29_15.getLayoutParams();
                var31_17 = ((gv)var29_15.getTag()).a;
                var30_16.width = this.a(var31_17.width());
                var30_16.height = this.a(var31_17.height());
                var30_16.leftMargin = this.a(var31_17.left);
                var30_16.topMargin = this.a(var31_17.top);
            }
            var15_18 = 0;
            var16_19 = this.a(0);
            this.f.setPadding(var16_19, var16_19, var16_19, var16_19);
            var17_20 = (RelativeLayout.LayoutParams)this.f.getLayoutParams();
            var17_20.height = var17_20.width = this.a(30);
            var18_21 = -var16_19;
            var17_20.rightMargin = var18_21 + this.a(this.h.d.x);
            var17_20.topMargin = var18_21 + this.a(this.h.d.y);
            if (this.g == null) break block8;
            var19_22 = this.a;
            var20_23 = 16;
            var21_24 = var19_22 != false ? 16 : 15;
            var22_25 = this.a(var21_24);
            if (this.a) {
                var20_23 = 15;
            }
            var23_26 = this.a(var20_23);
            this.g.setPadding(var16_19, var16_19, var16_19, var16_19);
            var24_27 = (RelativeLayout.LayoutParams)this.g.getLayoutParams();
            var24_27.height = var24_27.width = this.a(26);
            if (this.h.m == null) ** GOTO lbl-1000
            if (this.a) {
                var28_28 = this.h.m;
                var27_29 = var28_28.b == null ? var28_28.c : var28_28.b;
            } else {
                var26_30 = this.h.m;
                var27_29 = var26_30.c == null ? var26_30.b : var26_30.c;
            }
            if (var27_29 != null) {
                var15_18 = var27_29.x;
                var25_31 = var27_29.y;
            } else lbl-1000: // 2 sources:
            {
                var25_31 = 0;
            }
            var24_27.leftMargin = var22_25 + this.a(var15_18);
            var24_27.topMargin = var23_26 + this.a(var25_31);
        }
        super.onMeasure(var1_1, var2_2);
    }

    public final void setLandscape(boolean bl2) {
        Bitmap bitmap;
        Bitmap bitmap2;
        ArrayList arrayList;
        this.a = bl2;
        if (bl2) {
            bitmap = this.h.b.b;
            bitmap2 = this.h.f.b;
            arrayList = this.h.j;
        } else {
            bitmap = this.h.a.b;
            bitmap2 = this.h.e.b;
            arrayList = this.h.i;
        }
        ag.a(this.c, (Drawable)new BitmapDrawable(null, bitmap));
        ag.a(this.d, (Drawable)new BitmapDrawable(null, bitmap2));
        if (this.e.getChildCount() > 0) {
            this.e.removeAllViews();
        }
        Context context = this.getContext();
        for (gv gv2 : arrayList) {
            View view = new View(context);
            view.setTag((Object)gv2);
            view.setOnClickListener((View.OnClickListener)this);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(0, 0, 51);
            this.e.addView(view, (ViewGroup.LayoutParams)layoutParams);
        }
    }

    public static interface a {
        public void a();

        public void a(gv var1);

        public void b();
    }

}


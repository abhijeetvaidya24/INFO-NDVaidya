/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.PointF
 *  android.graphics.drawable.BitmapDrawable
 *  android.graphics.drawable.Drawable
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.View$OnClickListener
 *  android.view.View$OnTouchListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.ImageView
 *  android.widget.ImageView$ScaleType
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  com.tapjoy.internal.gu
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.ref.WeakReference
 *  java.util.ArrayList
 *  java.util.Iterator
 */
package com.tapjoy.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tapjoy.internal.af;
import com.tapjoy.internal.ag;
import com.tapjoy.internal.ah;
import com.tapjoy.internal.gu;
import com.tapjoy.internal.ha;
import com.tapjoy.internal.hc;
import com.tapjoy.internal.hd;
import com.tapjoy.internal.he;
import com.tapjoy.internal.hh;
import com.tapjoy.internal.hj;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public final class hr
extends RelativeLayout {
    private gu a;
    private a b;
    private af c = af.a;
    private int d = 0;
    private int e = 0;
    private hd f = null;
    private ArrayList g = null;
    private ArrayList h = null;

    public hr(Context context, gu gu2, a a2) {
        super(context);
        this.a = gu2;
        this.b = a2;
    }

    private void a() {
        ArrayList arrayList;
        Iterator iterator = this.a.a.iterator();
        hd hd2 = null;
        while (iterator.hasNext()) {
            hd hd3 = (hd)iterator.next();
            if (hd3.a == this.c) {
                hd2 = hd3;
                break;
            }
            if (hd3.a != af.a) continue;
            hd2 = hd3;
        }
        this.removeAllViews();
        ArrayList arrayList2 = this.g;
        if (arrayList2 != null) {
            Iterator iterator2 = arrayList2.iterator();
            while (iterator2.hasNext()) {
                hj hj2 = (hj)((Object)((WeakReference)iterator2.next()).get());
                if (hj2 == null) continue;
                hj2.c();
            }
            this.g.clear();
        }
        if ((arrayList = this.h) != null) {
            Iterator iterator3 = arrayList.iterator();
            while (iterator3.hasNext()) {
                hj hj3 = (hj)((Object)((WeakReference)iterator3.next()).get());
                if (hj3 == null) continue;
                hj3.c();
            }
            this.h.clear();
        }
        if (hd2 != null) {
            this.f = hd2;
            Context context = this.getContext();
            for (final hc hc2 : hd2.c) {
                hj hj4;
                hj hj5;
                final RelativeLayout relativeLayout = new RelativeLayout(context);
                if (hc2.l.c != null) {
                    hj hj6 = new hj(context);
                    hj6.setScaleType(ImageView.ScaleType.FIT_XY);
                    hj6.a(hc2.l.d, hc2.l.c);
                    if (this.g == null) {
                        this.g = new ArrayList();
                    }
                    this.g.add((Object)new WeakReference((Object)hj6));
                    hj4 = hj6;
                } else {
                    hj4 = null;
                }
                if (hc2.m != null && hc2.m.c != null) {
                    hj hj7 = new hj(context);
                    hj7.setScaleType(ImageView.ScaleType.FIT_XY);
                    hj7.a(hc2.m.d, hc2.m.c);
                    if (this.h == null) {
                        this.h = new ArrayList();
                    }
                    this.h.add((Object)new WeakReference((Object)hj7));
                    hj5 = hj7;
                } else {
                    hj5 = null;
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(0, 0);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
                Bitmap bitmap = hc2.l.b;
                Bitmap bitmap2 = hc2.m != null ? hc2.m.b : null;
                final BitmapDrawable bitmapDrawable = bitmap != null ? new BitmapDrawable(null, bitmap) : null;
                final BitmapDrawable bitmapDrawable2 = bitmap2 != null ? new BitmapDrawable(null, bitmap2) : null;
                if (bitmapDrawable != null) {
                    ag.a((View)relativeLayout, (Drawable)bitmapDrawable);
                }
                if (hj4 != null) {
                    relativeLayout.addView((View)hj4, (ViewGroup.LayoutParams)layoutParams2);
                    hj4.a();
                }
                if (hj5 != null) {
                    relativeLayout.addView((View)hj5, (ViewGroup.LayoutParams)layoutParams2);
                    hj5.setVisibility(4);
                }
                final hj hj8 = hj5;
                final hj hj9 = hj4;
                View.OnTouchListener onTouchListener = new View.OnTouchListener(){

                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        if (motionEvent.getAction() == 0) {
                            BitmapDrawable bitmapDrawable3;
                            if (hj8 != null || bitmapDrawable2 != null) {
                                hj hj2 = hj9;
                                if (hj2 != null) {
                                    hj2.b();
                                    hj9.setVisibility(4);
                                }
                                ag.a(view, null);
                            }
                            if ((bitmapDrawable3 = bitmapDrawable2) != null) {
                                ag.a(view, (Drawable)bitmapDrawable3);
                                return false;
                            }
                            hj hj3 = hj8;
                            if (hj3 != null) {
                                hj3.setVisibility(0);
                                hj8.a();
                                return false;
                            }
                        } else {
                            int n2;
                            int n3 = motionEvent.getAction();
                            if (n3 == (n2 = 1)) {
                                hj hj4;
                                hj hj5;
                                float f2 = motionEvent.getX();
                                float f3 = motionEvent.getY();
                                if (!(f2 < 0.0f || f2 >= (float)view.getWidth() || f3 < 0.0f || f3 >= (float)view.getHeight())) {
                                    n2 = 0;
                                }
                                if (n2 != 0) {
                                    BitmapDrawable bitmapDrawable4 = bitmapDrawable;
                                    if (bitmapDrawable4 != null) {
                                        ag.a(view, (Drawable)bitmapDrawable4);
                                    } else if (bitmapDrawable2 != null) {
                                        ag.a(view, null);
                                    }
                                }
                                if ((hj4 = hj8) != null) {
                                    hj4.b();
                                    hj8.setVisibility(4);
                                }
                                if ((hj8 != null || bitmapDrawable2 != null) && (hj5 = hj9) != null && n2 != 0) {
                                    hj5.setVisibility(0);
                                    hj9.a();
                                }
                            }
                        }
                        return false;
                    }
                };
                relativeLayout.setOnTouchListener(onTouchListener);
                View.OnClickListener onClickListener = new View.OnClickListener(){

                    public final void onClick(View view) {
                        hj hj2;
                        hj hj3 = hj8;
                        if (hj3 != null) {
                            hj3.b();
                            relativeLayout.removeView((View)hj8);
                        }
                        if ((hj2 = hj9) != null) {
                            hj2.b();
                            relativeLayout.removeView((View)hj9);
                        }
                        hr.this.b.a(hc2);
                    }
                };
                relativeLayout.setOnClickListener(onClickListener);
                relativeLayout.setTag((Object)hc2);
                this.addView((View)relativeLayout, (ViewGroup.LayoutParams)layoutParams);
            }
        }
    }

    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.b.a();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    protected final void onMeasure(int var1_1, int var2_2) {
        block14 : {
            var3_3 = View.MeasureSpec.getSize((int)var1_1);
            if (var3_3 >= (var4_4 = View.MeasureSpec.getSize((int)var2_2))) {
                if (this.c != af.c) {
                    this.c = af.c;
                    this.a();
                }
            } else if (this.c != af.b) {
                this.c = af.b;
                this.a();
            }
            if (this.d == var3_3 && this.e == var4_4) break block14;
            this.d = var3_3;
            this.e = var4_4;
            var5_5 = var3_3;
            var6_6 = var4_4;
            var7_7 = this.f;
            var8_8 = 0.0f;
            if (var7_7 == null) ** GOTO lbl33
            var21_9 = var7_7.b;
            var8_8 = 0.0f;
            if (var21_9 == null) ** GOTO lbl33
            var22_10 = var5_5 * this.f.b.y / this.f.b.x / var6_6;
            if (var22_10 < 1.0f) {
                var9_11 = var5_5 * this.f.b.y / this.f.b.x;
                var10_12 = (var6_6 - var9_11) / 2.0f;
                var8_8 = 0.0f;
            } else {
                var23_13 = var22_10 FCMPL 1.0f;
                var8_8 = 0.0f;
                if (var23_13 > 0) {
                    var24_14 = var6_6 * this.f.b.x / this.f.b.y;
                    var8_8 = (var5_5 - var24_14) / 2.0f;
                    var5_5 = var24_14;
                }
lbl33: // 5 sources:
                var9_11 = var6_6;
                var10_12 = 0.0f;
            }
            for (View var12_16 : ah.a((ViewGroup)this)) {
                var13_17 = (RelativeLayout.LayoutParams)var12_16.getLayoutParams();
                var14_18 = (hc)var12_16.getTag();
                var15_19 = var14_18.a.a(var5_5, var9_11);
                var16_20 = var14_18.b.a(var5_5, var9_11);
                var17_21 = var14_18.c.a(var5_5, var9_11);
                var18_22 = var14_18.d.a(var5_5, var9_11);
                var19_23 = var14_18.e;
                var20_24 = var14_18.f;
                if (var19_23 == 14) {
                    var15_19 += (var5_5 - var17_21) / 2.0f;
                    var19_23 = 9;
                }
                if (var20_24 == 15) {
                    var16_20 += (var9_11 - var18_22) / 2.0f;
                    var20_24 = 10;
                }
                var13_17.addRule(var19_23, -1);
                var13_17.addRule(var20_24, -1);
                var13_17.width = Math.round((float)var17_21);
                var13_17.height = Math.round((float)var18_22);
                if (var19_23 == 9) {
                    var13_17.leftMargin = Math.round((float)(var15_19 + var8_8));
                } else if (var19_23 == 11) {
                    var13_17.rightMargin = Math.round((float)(var15_19 + var8_8));
                }
                if (var20_24 == 10) {
                    var13_17.topMargin = Math.round((float)(var16_20 + var10_12));
                    continue;
                }
                if (var20_24 != 12) continue;
                var13_17.bottomMargin = Math.round((float)(var16_20 + var10_12));
            }
        }
        super.onMeasure(var1_1, var2_2);
    }

    protected final void onVisibilityChanged(View view, int n2) {
        super.onVisibilityChanged(view, n2);
        if (n2 == 0) {
            ArrayList arrayList;
            ArrayList arrayList2 = this.h;
            if (arrayList2 != null) {
                Iterator iterator = arrayList2.iterator();
                while (iterator.hasNext()) {
                    hj hj2 = (hj)((Object)((WeakReference)iterator.next()).get());
                    if (hj2 == null) continue;
                    hj2.setVisibility(4);
                    hj2.b();
                }
            }
            if ((arrayList = this.g) != null) {
                Iterator iterator = arrayList.iterator();
                while (iterator.hasNext()) {
                    hj hj3 = (hj)((Object)((WeakReference)iterator.next()).get());
                    if (hj3 == null) continue;
                    hj3.setVisibility(0);
                    hj3.a();
                }
                return;
            }
        } else {
            ArrayList arrayList;
            ArrayList arrayList3 = this.g;
            if (arrayList3 != null) {
                Iterator iterator = arrayList3.iterator();
                while (iterator.hasNext()) {
                    hj hj4 = (hj)((Object)((WeakReference)iterator.next()).get());
                    if (hj4 == null) continue;
                    hj4.b();
                }
            }
            if ((arrayList = this.h) != null) {
                Iterator iterator = arrayList.iterator();
                while (iterator.hasNext()) {
                    hj hj5 = (hj)((Object)((WeakReference)iterator.next()).get());
                    if (hj5 == null) continue;
                    hj5.b();
                }
            }
        }
    }

    public static interface a {
        public void a();

        public void a(hc var1);
    }

}


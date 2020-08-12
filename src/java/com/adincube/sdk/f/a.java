/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$Callback
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  java.lang.Double
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.Throwable
 */
package com.adincube.sdk.f;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.adincube.sdk.h.c.b;
import com.adincube.sdk.util.ErrorReportingHelper;
import com.adincube.sdk.util.b.i;

@SuppressLint(value={"NewApi"})
public final class a
extends ViewGroup {
    public com.adincube.sdk.c.a a = null;
    public a b = null;
    public final Drawable.Callback c = new Drawable.Callback(){

        public final void invalidateDrawable(Drawable drawable) {
            a.this.invalidate();
        }

        public final void scheduleDrawable(Drawable drawable, Runnable runnable, long l2) {
        }

        public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        }
    };
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private boolean i;
    private Double j;
    private boolean k = false;

    public a(Context context) {
        super(context);
        this.setClipToPadding(false);
        this.setDrawingCacheEnabled(true);
        this.setClickable(true);
        this.j = null;
        this.i = false;
        this.h = i.a(this.getContext(), 45);
        this.d = i.a(this.getContext(), -7);
        this.f = i.a(this.getContext(), 7);
    }

    private int a() {
        return this.getMeasuredWidth() - this.getPaddingLeft() - this.a.getBounds().width() / 2 + this.d + this.e;
    }

    /*
     * Enabled aggressive block sorting
     */
    private boolean a(MotionEvent motionEvent) {
        block7 : {
            block10 : {
                block9 : {
                    double d2;
                    int n2;
                    block8 : {
                        n2 = 255 & motionEvent.getAction();
                        if (n2 != 1 && n2 != 0) break block7;
                        d2 = Math.sqrt((double)(Math.pow((double)(motionEvent.getX() - (float)this.a()), (double)2.0) + Math.pow((double)(motionEvent.getY() - (float)this.b()), (double)2.0)));
                        if (n2 != 0) break block8;
                        if (d2 < (double)this.h) {
                            this.k = true;
                            return true;
                        }
                        break block9;
                    }
                    if (n2 != 1) break block7;
                    if (this.k && d2 < (double)this.h) break block10;
                }
                this.k = false;
                return false;
            }
            if (this.a.a()) {
                this.playSoundEffect(0);
                a a2 = this.b;
                if (a2 != null) {
                    a2.a();
                }
            }
            return true;
        }
        return false;
    }

    private int b() {
        return this.a.getBounds().height() / 2 + this.getPaddingTop() + this.f + this.g;
    }

    public final void a(int n2) {
        if (this.g != n2) {
            this.g = n2;
            this.requestLayout();
            this.invalidate();
        }
    }

    public final void a(Double d2) {
        if (this.j != d2) {
            this.j = d2;
            this.requestLayout();
            this.invalidate();
        }
    }

    public final void a(boolean bl) {
        if (this.a.a() != bl) {
            if (bl) {
                this.a.setState(new int[]{16842910});
            } else {
                this.a.setState(new int[0]);
            }
            this.invalidate();
        }
    }

    protected final void dispatchDraw(Canvas canvas) {
        try {
            super.dispatchDraw(canvas);
            if (this.getChildCount() > 0) {
                canvas.save();
                canvas.translate((float)(this.a() - this.a.getBounds().width() / 2), (float)(this.b() - this.a.getBounds().height() / 2));
                this.a.draw(canvas);
                canvas.restore();
                if (this.i) {
                    Paint paint = new Paint();
                    paint.setColor(-65536);
                    paint.setAlpha(127);
                    canvas.drawCircle((float)this.a(), (float)this.b(), (float)this.h, paint);
                }
            }
            return;
        }
        catch (Throwable throwable) {
            ErrorReportingHelper.report("ABInterstitialAdLayout.dispatchDraw", b.a, throwable);
            com.adincube.sdk.util.a.c("ABInterstitialLayout.dispatchDraw()", new Object[]{throwable});
            return;
        }
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        try {
            boolean bl = this.a(motionEvent);
            return bl;
        }
        catch (Throwable throwable) {
            ErrorReportingHelper.report("ABInterstitialAdLayout.onInterceptTouchEvent", b.a, throwable);
            com.adincube.sdk.util.a.c("ABInterstitialLayout.onInterceptTouchEvent()", new Object[]{throwable});
            return false;
        }
    }

    protected final void onLayout(boolean bl, int n2, int n3, int n4, int n5) {
        block5 : {
            int n6;
            if (this.getChildCount() <= 0) break block5;
            View view = this.getChildAt(0);
            int n7 = n4 - n2;
            int n8 = n5 - n3;
            try {
                int n9 = (n7 - view.getMeasuredWidth() - this.getPaddingRight() - this.getPaddingLeft()) / 2;
                int n10 = (n8 - view.getMeasuredHeight() - this.getPaddingTop() - this.getPaddingBottom()) / 2;
                view.layout(n2 + n9 + this.getPaddingLeft(), n3 + n10 + this.getPaddingTop(), n4 - n9 - this.getPaddingLeft(), n5 - n10 - this.getPaddingBottom());
                n6 = 1;
            }
            catch (Throwable throwable) {
                com.adincube.sdk.util.a.c("ABInterstitialLayout.onLayout()", new Object[]{throwable});
                return;
            }
            do {
                if (n6 >= this.getChildCount()) break;
                this.getChildAt(n6).layout(n2, n5 - this.getChildAt(n6).getMeasuredHeight(), n4, n5);
                ++n6;
            } while (true);
        }
        return;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    protected final void onMeasure(int var1_1, int var2_2) {
        block13 : {
            block14 : {
                block11 : {
                    block12 : {
                        var4_3 = View.MeasureSpec.getSize((int)var1_1);
                        var5_4 = View.MeasureSpec.getSize((int)var2_2);
                        var6_5 = var4_3 - this.getPaddingRight() - this.getPaddingLeft();
                        var7_6 = var5_4 - this.getPaddingBottom() - this.getPaddingTop();
                        if (this.getChildCount() <= 0) ** GOTO lbl51
                        var8_7 = this.getChildAt(0);
                        if (this.j == null) break block11;
                        var9_8 = var6_5;
                        var11_9 = this.j;
                        Double.isNaN((double)var9_8);
                        if (var9_8 / var11_9 < (double)var7_6) {
                            var29_10 = this.j;
                            Double.isNaN((double)var9_8);
                            var32_11 = var9_8 / var29_10;
                            var7_6 = (int)Math.floor((double)var32_11);
                        }
                        var14_12 = var7_6;
                        try {
                            var16_13 = this.j;
                        }
                        catch (Throwable var3_21) {
                            ErrorReportingHelper.report("ABInterstitialAdLayout.onMeasure", b.a, var3_21);
                            com.adincube.sdk.util.a.c("ABInterstitialLayout.onMeasure()", new Object[]{var3_21});
                        }
                        Double.isNaN((double)var14_12);
                        if (var16_13 * var14_12 < var9_8) {
                            var24_14 = this.j;
                            Double.isNaN((double)var14_12);
                            var27_15 = var14_12 * var24_14;
                            var6_5 = (int)Math.floor((double)var27_15);
                            break block12;
                        }
                        break block12;
                        break block13;
                    }
                    var19_16 = 1073741824;
                    var20_17 = 1073741824;
                    break block14;
                }
                var19_16 = Integer.MIN_VALUE;
                var20_17 = Integer.MIN_VALUE;
            }
            var8_7.measure(View.MeasureSpec.makeMeasureSpec((int)var6_5, (int)var19_16), View.MeasureSpec.makeMeasureSpec((int)var7_6, (int)var20_17));
            for (var21_18 = 1; var21_18 < this.getChildCount(); ++var21_18) {
                var22_19 = View.MeasureSpec.makeMeasureSpec((int)var4_3, (int)1073741824);
                var23_20 = View.MeasureSpec.makeMeasureSpec((int)var5_4, (int)Integer.MIN_VALUE);
                this.getChildAt(var21_18).measure(var22_19, var23_20);
            }
        }
        super.onMeasure(var1_1, var2_2);
    }

    @SuppressLint(value={"ClickableViewAccessibility"})
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            boolean bl = this.a(motionEvent);
            return bl;
        }
        catch (Throwable throwable) {
            ErrorReportingHelper.report("ABInterstitialAdLayout.onTouchEvent", b.a, throwable);
            com.adincube.sdk.util.a.c("ABInterstitialAdLayout.onTouchEvent()", new Object[]{throwable});
            return super.onTouchEvent(motionEvent);
        }
    }

    public static interface a {
        public void a();
    }

}


/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.graphics.Rect
 *  android.util.AttributeSet
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnTouchListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.Button
 *  android.widget.ImageView
 *  android.widget.ImageView$ScaleType
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  android.widget.TextView
 *  com.chartboost.sdk.impl.az$a
 *  java.lang.CharSequence
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 */
package com.chartboost.sdk.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.chartboost.sdk.Libraries.h;
import com.chartboost.sdk.impl.az;

/*
 * Exception performing whole class analysis.
 */
public abstract class az
extends RelativeLayout {
    private final Rect a;
    final a c;
    protected Button d;
    boolean e;

    public az(Context context) {
        this(context, null);
    }

    @SuppressLint(value={"ClickableViewAccessibility"})
    public az(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new Rect();
        this.d = null;
        this.e = true;
        this.c = new /* Unavailable Anonymous Inner Class!! */;
        this.c.setOnTouchListener(new View.OnTouchListener(){

            public boolean onTouch(View view, MotionEvent motionEvent) {
                boolean bl = az.this.a(view, motionEvent);
                int n2 = motionEvent.getActionMasked();
                if (n2 != 0) {
                    if (n2 != 1) {
                        if (n2 != 2) {
                            if (n2 != 3 && n2 != 4) {
                                return true;
                            }
                            az.this.c.a(false);
                            return true;
                        }
                        az.this.c.a(bl);
                        return true;
                    }
                    if (az.this.getVisibility() == 0 && az.this.isEnabled() && bl) {
                        az.this.a(motionEvent);
                    }
                    az.this.c.a(false);
                    return true;
                }
                az.this.c.a(bl);
                return bl;
            }
        });
        this.addView((View)this.c, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
    }

    public TextView a() {
        if (this.d == null) {
            this.d = new Button(this.getContext());
            this.d.setGravity(17);
        }
        this.d.postInvalidate();
        return this.d;
    }

    protected abstract void a(MotionEvent var1);

    public void a(ImageView.ScaleType scaleType) {
        this.c.setScaleType(scaleType);
    }

    public void a(h h2) {
        if (h2 != null && h2.d()) {
            this.c.a(h2);
            this.a((String)null);
        }
    }

    public void a(String string) {
        if (string != null) {
            this.a().setText((CharSequence)string);
            this.addView((View)this.a(), (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
            this.c.setVisibility(8);
            this.a(false);
            this.d.setOnClickListener(new View.OnClickListener(){

                public void onClick(View view) {
                    az.this.a((MotionEvent)null);
                }
            });
            return;
        }
        if (this.d != null) {
            this.removeView((View)this.a());
            this.d = null;
            this.c.setVisibility(0);
            this.a(true);
        }
    }

    public void a(boolean bl) {
        this.e = bl;
    }

    boolean a(View view, MotionEvent motionEvent) {
        view.getLocalVisibleRect(this.a);
        Rect rect = this.a;
        rect.left += view.getPaddingLeft();
        Rect rect2 = this.a;
        rect2.top += view.getPaddingTop();
        Rect rect3 = this.a;
        rect3.right -= view.getPaddingRight();
        Rect rect4 = this.a;
        rect4.bottom -= view.getPaddingBottom();
        return this.a.contains(Math.round((float)motionEvent.getX()), Math.round((float)motionEvent.getY()));
    }

}


/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  java.lang.Math
 */
package com.tapjoy.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class ao
extends ViewGroup {
    public ao(Context context) {
        super(context);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.LayoutParams(this.getContext(), attributeSet);
    }

    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ViewGroup.LayoutParams(layoutParams);
    }

    protected void onLayout(boolean bl2, int n2, int n3, int n4, int n5) {
        int n6 = this.getPaddingLeft();
        int n7 = this.getPaddingTop();
        int n8 = this.getChildCount();
        for (int i2 = 0; i2 < n8; ++i2) {
            View view = this.getChildAt(i2);
            if (view.getVisibility() == 8) continue;
            view.layout(n6, n7, n6 + view.getMeasuredWidth(), n7 + view.getMeasuredHeight());
        }
    }

    public void onMeasure(int n2, int n3) {
        int n4 = this.getChildCount();
        this.measureChildren(n2, n3);
        int n5 = 0;
        int n6 = 0;
        for (int i2 = 0; i2 < n4; ++i2) {
            View view = this.getChildAt(i2);
            if (view.getVisibility() == 8) continue;
            n5 = Math.max((int)n5, (int)view.getMeasuredWidth());
            n6 = Math.max((int)n6, (int)view.getMeasuredHeight());
        }
        int n7 = n5 + (this.getPaddingLeft() + this.getPaddingRight());
        int n8 = Math.max((int)(n6 + (this.getPaddingTop() + this.getPaddingBottom())), (int)this.getSuggestedMinimumHeight());
        this.setMeasuredDimension(ao.resolveSize((int)Math.max((int)n7, (int)this.getSuggestedMinimumWidth()), (int)n2), ao.resolveSize((int)n8, (int)n3));
    }
}


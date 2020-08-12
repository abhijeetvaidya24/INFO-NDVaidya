/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.text.TextUtils
 *  android.util.AttributeSet
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.ImageView
 *  android.widget.ImageView$ScaleType
 *  com.tappx.b.a.n$d
 *  com.tappx.b.a.s$1
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 */
package com.tappx.b.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tappx.b.a.n;
import com.tappx.b.a.s;

public class s
extends ImageView {
    private String a;
    private int b;
    private int c;
    private n d;
    private n.c e;

    public s(Context context) {
        this(context, null);
    }

    public s(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public s(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
    }

    static /* synthetic */ int a(s s2) {
        return s2.c;
    }

    private void a() {
        int n2 = this.b;
        if (n2 != 0) {
            this.setImageResource(n2);
            return;
        }
        this.setImageBitmap(null);
    }

    static /* synthetic */ int b(s s2) {
        return s2.b;
    }

    public void a(String string2, n n2) {
        this.a = string2;
        this.d = n2;
        this.a(false);
    }

    void a(boolean bl) {
        boolean bl2;
        boolean bl3;
        int n2;
        boolean bl4;
        ImageView.ScaleType scaleType;
        int n3;
        block9 : {
            block8 : {
                block7 : {
                    n3 = this.getWidth();
                    n2 = this.getHeight();
                    scaleType = this.getScaleType();
                    ViewGroup.LayoutParams layoutParams = this.getLayoutParams();
                    bl2 = true;
                    if (layoutParams == null) break block7;
                    bl3 = this.getLayoutParams().width == -2;
                    if (this.getLayoutParams().height != -2) break block8;
                    bl4 = true;
                    break block9;
                }
                bl3 = false;
            }
            bl4 = false;
        }
        if (!bl3 || !bl4) {
            bl2 = false;
        }
        if (n3 == 0 && n2 == 0 && !bl2) {
            return;
        }
        if (TextUtils.isEmpty((CharSequence)this.a)) {
            n.c c2 = this.e;
            if (c2 != null) {
                c2.a();
                this.e = null;
            }
            this.a();
            return;
        }
        n.c c3 = this.e;
        if (c3 != null && c3.c() != null) {
            if (this.e.c().equals((Object)this.a)) {
                return;
            }
            this.e.a();
            this.a();
        }
        if (bl3) {
            n3 = 0;
        }
        int n4 = bl4 ? 0 : n2;
        this.e = this.d.a(this.a, new 1(this, bl), n3, n4, scaleType);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        this.invalidate();
    }

    protected void onDetachedFromWindow() {
        n.c c2 = this.e;
        if (c2 != null) {
            c2.a();
            this.setImageBitmap(null);
            this.e = null;
        }
        super.onDetachedFromWindow();
    }

    protected void onLayout(boolean bl, int n2, int n3, int n4, int n5) {
        super.onLayout(bl, n2, n3, n4, n5);
        this.a(true);
    }

    public void setDefaultImageResId(int n2) {
        this.b = n2;
    }

    public void setErrorImageResId(int n2) {
        this.c = n2;
    }
}


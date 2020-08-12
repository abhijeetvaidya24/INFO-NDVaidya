/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.SurfaceHolder
 *  android.widget.VideoView
 *  java.lang.Boolean
 *  java.lang.Exception
 *  java.lang.Object
 */
package com.applovin.impl.adview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.widget.VideoView;
import com.applovin.impl.adview.r;
import com.applovin.impl.sdk.b.b;
import com.applovin.impl.sdk.j;

public class AppLovinVideoView
extends VideoView
implements r {
    private final j a;
    private int b = 0;
    private int c = 0;
    private float d = 0.0f;

    public AppLovinVideoView(Context context, j j2) {
        super(context, null, 0);
        this.a = j2;
    }

    protected void onMeasure(int n2, int n3) {
        if (this.b > 0 && this.c > 0 && !this.a.a(b.ff).booleanValue()) {
            int n4;
            int n5;
            int n6 = AppLovinVideoView.getDefaultSize((int)this.b, (int)n2);
            int n7 = AppLovinVideoView.getDefaultSize((int)this.c, (int)n3);
            if (n7 > (n5 = (int)((float)n6 / this.d))) {
                n7 = n5;
            }
            if (n6 > (n4 = (int)((float)n7 * this.d))) {
                n6 = n4;
            }
            this.setMeasuredDimension(n6, n7);
            return;
        }
        super.onMeasure(n2, n3);
    }

    @Override
    public void setVideoSize(int n2, int n3) {
        this.b = n2;
        this.c = n3;
        this.d = (float)this.b / (float)this.c;
        try {
            this.getHolder().setFixedSize(n2, n3);
            this.requestLayout();
            this.invalidate();
        }
        catch (Exception exception) {}
    }
}


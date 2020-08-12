/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.media.MediaPlayer
 *  android.media.MediaPlayer$OnCompletionListener
 *  android.media.MediaPlayer$OnErrorListener
 *  android.media.MediaPlayer$OnPreparedListener
 *  android.net.Uri
 *  android.view.SurfaceView
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  com.chartboost.sdk.impl.at
 *  com.chartboost.sdk.impl.au
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.chartboost.sdk.impl;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.g;
import com.chartboost.sdk.impl.at;
import com.chartboost.sdk.impl.au;

public class av
extends FrameLayout {
    private View a;
    private boolean b;

    public av(Context context) {
        super(context);
        this.b();
    }

    private void b() {
        this.b = true;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Choosing ");
        String string = this.b ? "texture" : "surface";
        stringBuilder.append(string);
        stringBuilder.append(" solution for video playback");
        CBLogging.e("VideoInit", stringBuilder.toString());
        g g2 = g.a();
        this.a = this.b ? (View)g2.a(new au(this.getContext())) : (View)g2.a(new at(this.getContext()));
        this.a.setContentDescription((CharSequence)"CBVideo");
        this.addView(this.a, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
        if (!this.b) {
            ((SurfaceView)this.a).setZOrderMediaOverlay(true);
        }
    }

    public a a() {
        return (a)this.a;
    }

    public void onSizeChanged(int n2, int n3, int n4, int n5) {
        super.onSizeChanged(n2, n3, n4, n5);
        this.a().a(n2, n3);
    }

    public static interface a {
        public void a();

        public void a(int var1);

        public void a(int var1, int var2);

        public void a(MediaPlayer.OnCompletionListener var1);

        public void a(MediaPlayer.OnErrorListener var1);

        public void a(MediaPlayer.OnPreparedListener var1);

        public void a(Uri var1);

        public void b();

        public int c();

        public int d();

        public boolean e();
    }

}


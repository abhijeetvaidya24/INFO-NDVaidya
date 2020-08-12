/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.StateListDrawable
 *  android.media.MediaPlayer
 *  android.media.MediaPlayer$OnCompletionListener
 *  android.media.MediaPlayer$OnErrorListener
 *  android.os.Bundle
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  android.widget.VideoView
 *  java.lang.String
 */
package com.tappx.a.a.b;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.VideoView;
import com.tappx.a.a.b.ag;
import com.tappx.a.a.b.e;
import com.tappx.a.a.b.h;
import com.tappx.a.a.b.v;

public class ag
extends e {
    private final VideoView a;
    private View b;

    public ag(Context context, Bundle bundle, Bundle bundle2, e.a a2) {
        super(context, a2);
        this.a = new VideoView(context);
        this.a.setOnCompletionListener(new MediaPlayer.OnCompletionListener(this){
            final /* synthetic */ ag a;
            {
                this.a = ag2;
            }

            public void onCompletion(MediaPlayer mediaPlayer) {
                if (ag.a(this.a) != null) {
                    ag.a(this.a).setVisibility(0);
                }
                this.a.b(true);
            }
        });
        this.a.setOnErrorListener(new MediaPlayer.OnErrorListener(this){
            final /* synthetic */ ag a;
            {
                this.a = ag2;
            }

            public boolean onError(MediaPlayer mediaPlayer, int n2, int n3) {
                if (ag.a(this.a) != null) {
                    ag.a(this.a).setVisibility(0);
                }
                this.a.a(false);
                return false;
            }
        });
        this.a.setVideoPath(bundle.getString("video_url"));
    }

    static /* synthetic */ View a(ag ag2) {
        return ag2.b;
    }

    private void k() {
        this.b = new View(this.i());
        int n2 = h.f(30.0f, this.i());
        int n3 = h.f(10.0f, this.i());
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{-16842919}, v.a.a(this.i()));
        stateListDrawable.addState(new int[]{16842919}, v.c.a(this.i()));
        this.b.setBackgroundDrawable((Drawable)stateListDrawable);
        this.b.setOnClickListener(new View.OnClickListener(this){
            final /* synthetic */ ag a;
            {
                this.a = ag2;
            }

            public void onClick(View view) {
                this.a.h().onFinish();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(n2, n2);
        layoutParams.addRule(11);
        layoutParams.setMargins(n3, n3, n3, n3);
        this.j().addView(this.b, (ViewGroup.LayoutParams)layoutParams);
    }

    @Override
    public void a() {
        super.a();
        this.k();
        this.b.setVisibility(8);
        this.a.start();
    }

    @Override
    public void a(Configuration configuration) {
    }

    @Override
    public void a(Bundle bundle) {
    }

    @Override
    protected VideoView b() {
        return this.a;
    }

    @Override
    public void c() {
    }

    @Override
    public void d() {
    }

    @Override
    public void e() {
    }

    @Override
    public void f() {
    }
}


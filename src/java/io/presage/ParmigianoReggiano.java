/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.ImageButton
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 */
package io.presage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import io.presage.BoulettedAvesnes;
import io.presage.PavedAremberg;
import io.presage.R;

public final class ParmigianoReggiano {
    private ImageButton a;
    private final Handler b;
    private final PavedAremberg c;
    private final ViewGroup d;
    private final BoulettedAvesnes e;
    private final String f;

    public ParmigianoReggiano(PavedAremberg pavedAremberg, ViewGroup viewGroup, BoulettedAvesnes boulettedAvesnes, String string2) {
        this.c = pavedAremberg;
        this.d = viewGroup;
        this.e = boulettedAvesnes;
        this.f = string2;
        this.a = new ImageButton(this.d.getContext());
        this.b = new Handler();
        this.d();
    }

    @SuppressLint(value={"RtlHardcoded"})
    private final void d() {
        this.f();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 5;
        ImageButton imageButton = this.a;
        ViewGroup.LayoutParams layoutParams2 = (ViewGroup.LayoutParams)layoutParams;
        imageButton.setLayoutParams(layoutParams2);
        this.a.setOnClickListener(new View.OnClickListener(){

            public final void onClick(View view) {
                this.c.d();
                this.e();
            }
        });
        this.a.setVisibility(8);
        this.d.addView((View)this.a, layoutParams2);
    }

    private final void e() {
        boolean bl2 = ((CharSequence)this.f).length() > 0;
        if (bl2) {
            this.e.b(this.f);
        }
    }

    private final void f() {
        if (Build.VERSION.SDK_INT >= 16) {
            this.a.setBackground(null);
        } else {
            this.a.setBackgroundResource(0);
        }
        this.a.setImageResource(R.drawable.btn_presage_mraid_close);
    }

    public final void a() {
        this.a.setVisibility(0);
    }

    public final void a(long l2) {
        this.b.postDelayed(new Runnable(){

            public final void run() {
                this.a();
            }
        }, l2);
    }

    public final void b() {
        this.b.removeCallbacksAndMessages(null);
        this.a.setVisibility(8);
    }

    public final void c() {
        this.b.removeCallbacksAndMessages(null);
    }

}


/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 */
package com.applovin.impl.adview;

import android.annotation.SuppressLint;
import android.content.Context;
import com.applovin.impl.adview.g;
import com.applovin.impl.sdk.j;

@SuppressLint(value={"ViewConstructor"})
public final class m
extends g {
    private float c = 1.0f;

    public m(j j2, Context context) {
        super(j2, context);
    }

    @Override
    public void a(int n2) {
        this.setViewScale((float)n2 / 30.0f);
    }

    @Override
    public g.a getStyle() {
        return g.a.c;
    }

    @Override
    public float getViewScale() {
        return this.c;
    }

    @Override
    public void setViewScale(float f2) {
        this.c = f2;
    }
}


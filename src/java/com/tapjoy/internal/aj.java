/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.animation.Animation
 *  android.view.animation.AnimationSet
 */
package com.tapjoy.internal;

import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import com.tapjoy.internal.ai;

public final class aj
extends ai {
    private final AnimationSet b;

    public aj() {
        super((Animation)new AnimationSet(true));
        this.b = (AnimationSet)this.a;
    }

    public final aj a(Animation animation) {
        this.b.addAnimation(animation);
        return this;
    }
}


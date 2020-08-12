/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Camera
 *  android.graphics.Matrix
 *  android.view.animation.Animation
 *  android.view.animation.Transformation
 */
package com.tapjoy.internal;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public final class ak
extends Animation {
    private final boolean a;
    private final float b;
    private final float c;
    private final int d;
    private final float e;
    private final int f;
    private final float g;
    private float h;
    private float i;
    private Camera j;

    public ak(boolean bl2, float f2, float f3, int n2, float f4, int n3, float f5) {
        this.a = bl2;
        this.b = f2;
        this.c = f3;
        this.d = n2;
        this.e = f4;
        this.f = n3;
        this.g = f5;
    }

    protected final void applyTransformation(float f2, Transformation transformation) {
        float f3 = this.b;
        float f4 = f3 + f2 * (this.c - f3);
        Matrix matrix = transformation.getMatrix();
        Camera camera = this.j;
        camera.save();
        if (this.a) {
            camera.rotateX(f4);
        } else {
            camera.rotateY(f4);
        }
        camera.getMatrix(matrix);
        camera.restore();
        float f5 = this.h;
        float f6 = this.i;
        matrix.preTranslate(-f5, -f6);
        matrix.postTranslate(f5, f6);
    }

    public final void initialize(int n2, int n3, int n4, int n5) {
        super.initialize(n2, n3, n4, n5);
        this.h = this.resolveSize(this.d, this.e, n2, n4);
        this.i = this.resolveSize(this.f, this.g, n3, n5);
        this.j = new Camera();
    }
}


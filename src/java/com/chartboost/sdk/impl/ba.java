/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Camera
 *  android.graphics.Matrix
 *  android.view.animation.Animation
 *  android.view.animation.Transformation
 */
package com.chartboost.sdk.impl;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public final class ba
extends Animation {
    private final float a;
    private final float b;
    private final float c;
    private final float d;
    private boolean e = true;
    private Camera f;

    public ba(float f2, float f3, float f4, float f5, boolean bl) {
        this.a = f2;
        this.b = f3;
        this.c = f4;
        this.d = f5;
        this.e = bl;
    }

    protected void applyTransformation(float f2, Transformation transformation) {
        float f3 = this.a;
        float f4 = f3 + f2 * (this.b - f3);
        Camera camera = this.f;
        Matrix matrix = transformation.getMatrix();
        camera.save();
        if (this.e) {
            camera.rotateY(f4);
        } else {
            camera.rotateX(f4);
        }
        camera.getMatrix(matrix);
        camera.restore();
        matrix.preTranslate(-this.c, -this.d);
        matrix.postTranslate(this.c, this.d);
    }

    public void initialize(int n2, int n3, int n4, int n5) {
        super.initialize(n2, n3, n4, n5);
        this.f = new Camera();
    }
}


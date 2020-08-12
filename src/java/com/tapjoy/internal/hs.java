/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 */
package com.tapjoy.internal;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tapjoy.internal.af;
import com.tapjoy.internal.an;
import com.tapjoy.internal.gx;
import com.tapjoy.internal.ht;

public final class hs
extends an {
    private final gx a;
    private final ht b;
    private af c;

    public hs(Context context, gx gx2, ht ht2) {
        super(context);
        this.a = gx2;
        this.b = ht2;
        this.addView((View)ht2, new ViewGroup.LayoutParams(-1, -1));
        this.c = null;
    }

    @Override
    protected final void onMeasure(int n2, int n3) {
        af af2;
        af af3 = af.a(this.getContext());
        if (this.a.a()) {
            if (this.a.b()) {
                af af4 = af3.a() ? af.b : (!af3.b() && af.b(this.getContext()).a() ? af.b : af.c);
                this.setRotationCount(0);
                af2 = af4;
            } else {
                af2 = af.b;
                if (af3.b()) {
                    if (af3.c() == 3) {
                        this.setRotationCount(1);
                    } else {
                        this.setRotationCount(3);
                    }
                } else {
                    this.setRotationCount(0);
                }
            }
        } else {
            af2 = af.c;
            if (af3.a()) {
                if (af3.c() == 3) {
                    this.setRotationCount(1);
                } else {
                    this.setRotationCount(1);
                }
            } else {
                this.setRotationCount(0);
            }
        }
        if (this.c != af2) {
            this.c = af2;
            this.b.setLandscape(this.c.b());
        }
        super.onMeasure(n2, n3);
    }
}


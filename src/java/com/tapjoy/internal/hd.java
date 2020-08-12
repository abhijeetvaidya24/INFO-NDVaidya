/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.PointF
 *  com.tapjoy.internal.bs
 *  com.tapjoy.internal.hd$1
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 */
package com.tapjoy.internal;

import android.graphics.PointF;
import com.tapjoy.internal.af;
import com.tapjoy.internal.bn;
import com.tapjoy.internal.bs;
import com.tapjoy.internal.bx;
import com.tapjoy.internal.hc;
import com.tapjoy.internal.hd;
import java.util.ArrayList;
import java.util.List;

public final class hd {
    public static final bn d = new 1();
    public af a = af.a;
    public PointF b;
    public ArrayList c = new ArrayList();

    public hd(bs bs2) {
        bs2.h();
        while (bs2.j()) {
            String string2 = bs2.l();
            if ("buttons".equals((Object)string2)) {
                boolean bl2 = bs2.k() == bx.a;
                if (bl2) {
                    bs2.a((List)this.c, hc.n);
                    continue;
                }
                bs2.s();
                continue;
            }
            if ("window_aspect_ratio".equals((Object)string2)) {
                if (bs2.a()) {
                    PointF pointF = new PointF();
                    bs2.h();
                    while (bs2.j()) {
                        String string3 = bs2.l();
                        if ("width".equals((Object)string3)) {
                            pointF.x = (float)bs2.p();
                            continue;
                        }
                        if ("height".equals((Object)string3)) {
                            pointF.y = (float)bs2.p();
                            continue;
                        }
                        bs2.s();
                    }
                    bs2.i();
                    if (pointF.x == 0.0f || pointF.y == 0.0f) continue;
                    this.b = pointF;
                    continue;
                }
                bs2.s();
                continue;
            }
            if ("orientation".equals((Object)string2)) {
                String string4 = bs2.m();
                if ("landscape".equals((Object)string4)) {
                    this.a = af.c;
                    continue;
                }
                if (!"portrait".equals((Object)string4)) continue;
                this.a = af.b;
                continue;
            }
            bs2.s();
        }
        bs2.i();
    }
}


/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 *  java.util.Map
 */
package com.tapjoy.internal;

import android.content.Context;
import com.tapjoy.internal.bn;
import com.tapjoy.internal.br;
import com.tapjoy.internal.bs;
import com.tapjoy.internal.dx;
import com.tapjoy.internal.ed;
import com.tapjoy.internal.ek;
import com.tapjoy.internal.fy;
import com.tapjoy.internal.gc;
import com.tapjoy.internal.gh;
import com.tapjoy.internal.gi;
import com.tapjoy.internal.gj;
import com.tapjoy.internal.gs;
import com.tapjoy.internal.gu;
import com.tapjoy.internal.gx;
import com.tapjoy.internal.hl;
import java.util.List;
import java.util.Map;

public final class hm
extends hl {
    public final String c;
    public boolean d;
    private final gc e;
    private final ed f;
    private final dx g;
    private final ek h;
    private Context i;

    public hm(gc gc2, ed ed2, dx dx2, ek ek2, String string, Context context) {
        this.e = gc2;
        this.f = ed2;
        this.g = dx2;
        this.h = ek2;
        this.c = string;
        this.d = false;
        this.i = context;
    }

    @Override
    protected final /* synthetic */ Object a(bs bs2) {
        bs2.h();
        gx gx2 = null;
        gu gu2 = null;
        List list = null;
        while (bs2.j()) {
            String string = bs2.l();
            if ("interstitial".equals((Object)string)) {
                gx2 = (gx)bs2.a(gx.n);
                continue;
            }
            if ("contextual_button".equals((Object)string)) {
                gu2 = (gu)bs2.a(gu.d);
                continue;
            }
            if ("enabled_placements".equals((Object)string)) {
                list = bs2.c();
                continue;
            }
            bs2.s();
        }
        bs2.i();
        if (gx2 != null && (gx2.a() || gx2.b())) {
            return new Object(new gh(this.e, this.c, gx2, this.i), list){
                public gj a;
                public final List b;
                {
                    this.a = gj2;
                    this.b = list;
                }
            };
        }
        if (gu2 != null) {
            return new /* invalid duplicate definition of identical inner class */;
        }
        return new /* invalid duplicate definition of identical inner class */;
    }

    @Override
    public final String c() {
        return "placement";
    }

    @Override
    public final Map e() {
        Map map = super.e();
        map.put((Object)"info", (Object)new br(gs.a(this.f)));
        map.put((Object)"app", (Object)new br(gs.a(this.g)));
        map.put((Object)"user", (Object)new br(gs.a(this.h)));
        map.put((Object)"placement", (Object)this.c);
        return map;
    }

    @Override
    protected final /* synthetic */ Object f() {
        a a2 = super.f();
        if (!(a2.a instanceof gi)) {
            a2.a.b();
            if (!a2.a.c()) {
                new Object[1][0] = this.c;
                a2.a = new gi();
            }
        }
        return a2;
    }

}


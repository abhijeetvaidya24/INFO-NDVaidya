/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 *  java.util.Map
 */
package com.tapjoy.internal;

import com.tapjoy.internal.br;
import com.tapjoy.internal.dy;
import com.tapjoy.internal.dz;
import com.tapjoy.internal.eb;
import com.tapjoy.internal.gs;
import com.tapjoy.internal.hl;
import java.util.List;
import java.util.Map;

public final class hn
extends hl {
    private final dz.a c = new dz.a();
    private eb d = null;

    public final boolean a(dy dy2) {
        if (this.d == null) {
            this.d = dy2.n;
        } else if (dy2.n != this.d) {
            return false;
        }
        this.c.c.add((Object)dy2);
        return true;
    }

    @Override
    public final String c() {
        if (this.d == eb.USAGES) {
            return "api/v1/usages";
        }
        return "api/v1/cevs";
    }

    @Override
    public final Map e() {
        Map map = super.e();
        map.put((Object)"events", (Object)new br(gs.a(this.c.b())));
        return map;
    }

    public final int g() {
        return this.c.c.size();
    }
}


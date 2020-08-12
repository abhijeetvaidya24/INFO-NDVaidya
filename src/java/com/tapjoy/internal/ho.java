/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 */
package com.tapjoy.internal;

import com.tapjoy.internal.aq;
import com.tapjoy.internal.br;
import com.tapjoy.internal.dx;
import com.tapjoy.internal.ed;
import com.tapjoy.internal.ee;
import com.tapjoy.internal.ek;
import com.tapjoy.internal.gs;
import com.tapjoy.internal.hl;
import java.util.Map;

public final class ho
extends hl {
    private final ed c;
    private final dx d;
    private final ek e;
    private final String f;

    private ho(ed ed2, dx dx2, ek ek2, String string) {
        this.c = ed2;
        this.d = dx2;
        this.e = ek2;
        this.f = string;
    }

    public ho(ee ee2, String string) {
        this(ee2.d, ee2.e, ee2.f, string);
    }

    @Override
    public final String c() {
        return "api/v1/tokens";
    }

    @Override
    public final Map e() {
        Map map = super.e();
        map.put((Object)"info", (Object)new br(gs.a(this.c)));
        map.put((Object)"app", (Object)new br(gs.a(this.d)));
        map.put((Object)"user", (Object)new br(gs.a(this.e)));
        if (!aq.a(this.f)) {
            map.put((Object)"push_token", (Object)this.f);
        }
        return map;
    }
}


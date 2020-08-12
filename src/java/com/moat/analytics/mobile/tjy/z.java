/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  com.moat.analytics.mobile.tjy.ah
 *  java.lang.Object
 *  java.lang.String
 */
package com.moat.analytics.mobile.tjy;

import android.util.Log;
import com.moat.analytics.mobile.tjy.ah;
import com.moat.analytics.mobile.tjy.ap;
import com.moat.analytics.mobile.tjy.ba;
import com.moat.analytics.mobile.tjy.base.functional.a;
import com.moat.analytics.mobile.tjy.v;

class z
implements ba {
    final /* synthetic */ ap a;
    final /* synthetic */ String b;
    final /* synthetic */ v c;

    z(v v2, ap ap2, String string) {
        this.c = v2;
        this.a = ap2;
        this.b = string;
    }

    @Override
    public a a() {
        if (this.a.b()) {
            Log.d((String)"MoatFactory", (String)"Creating NativeVideo tracker.");
        }
        return a.a((Object)new ah(this.b, v.a(this.c), this.a));
    }
}


/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.adincube.sdk.mediation.n.a
 *  com.adincube.sdk.mediation.n.b
 *  com.adincube.sdk.mediation.v.a
 *  com.adincube.sdk.mediation.v.b
 *  java.lang.Object
 *  java.lang.String
 */
package com.adincube.sdk.mediation.g;

import com.adincube.sdk.mediation.a;
import com.adincube.sdk.mediation.b;
import com.adincube.sdk.mediation.j;

public final class d {
    a a = null;
    boolean b = false;
    com.adincube.sdk.mediation.n.b c = null;
    com.adincube.sdk.mediation.v.b d = null;
    private b e = null;

    public d(b b2) {
        this.e = b2;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public final void a(String var1_1) {
        var2_2 = j.a.d;
        if ("Connection Error".equals((Object)var1_1)) ** GOTO lbl-1000
        if ("No Ads".equals((Object)var1_1)) ** GOTO lbl-1000
        if ("Internal error".equals((Object)var1_1)) {
            var2_2 = j.a.d;
        } else if ("No market installed on the device".equals((Object)var1_1)) lbl-1000: // 2 sources:
        {
            var2_2 = j.a.b;
        } else if ("Timeout".equals((Object)var1_1) || "Too Slow Connection".equals((Object)var1_1)) lbl-1000: // 2 sources:
        {
            var2_2 = j.a.c;
        } else if ("Ad Not Ready".equals((Object)var1_1)) {
            var2_2 = j.a.a;
        }
        if (!this.b) {
            if (this.a == null) return;
            var6_3 = new j(this.e, var2_2, var1_1);
            this.a.a(var6_3);
            return;
        }
        var3_4 = new j(this.e, var2_2, var1_1);
        var4_5 = this.c;
        if (var4_5 != null) {
            var4_5.a((com.adincube.sdk.mediation.n.a)this.e, var3_4);
        }
        if ((var5_6 = this.d) == null) return;
        var5_6.a((com.adincube.sdk.mediation.v.a)this.e, var3_4);
    }
}


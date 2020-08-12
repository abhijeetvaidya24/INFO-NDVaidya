/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  android.view.View
 *  android.webkit.WebView
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.moat.analytics.mobile.tjy;

import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import com.moat.analytics.mobile.tjy.WebAdTracker;
import com.moat.analytics.mobile.tjy.ap;
import com.moat.analytics.mobile.tjy.base.exception.b;
import com.moat.analytics.mobile.tjy.base.functional.a;
import com.moat.analytics.mobile.tjy.bh;
import com.moat.analytics.mobile.tjy.bi;

class bj
implements WebAdTracker {
    private final a a;
    private final ap b;

    /*
     * Enabled aggressive block sorting
     */
    bj(WebView webView, com.moat.analytics.mobile.tjy.a a2, ap ap2) {
        a a3;
        this.b = ap2;
        if (ap2.b()) {
            Log.d((String)"MoatWebAdTracker", (String)"In initialization method.");
        }
        if (webView == null) {
            if (ap2.b()) {
                Log.e((String)"MoatWebAdTracker", (String)"WebView is null. Will not track.");
            }
            a3 = a.a();
        } else {
            bi bi2 = new bi((View)webView, webView, false, a2, ap2);
            a3 = a.a(bi2);
        }
        this.a = a3;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    @Override
    public boolean track() {
        var1_1 = this.b.b();
        var2_2 = false;
        if (!var1_1) ** GOTO lbl6
        try {
            Log.d((String)"MoatWebAdTracker", (String)"In track method.");
lbl6: // 2 sources:
            if (!this.a.c()) {
                var2_2 = false;
                if (var1_1) {
                    Log.e((String)"MoatWebAdTracker", (String)"Internal tracker not available. Not tracking.");
                    var2_2 = false;
                }
            } else {
                var2_2 = ((bh)this.a.b()).c();
            }
        }
        catch (b var3_3) {
            com.moat.analytics.mobile.tjy.base.exception.a.a(var3_3);
        }
        if (var1_1 == false) return var2_2;
        var4_4 = new StringBuilder("Attempt to start tracking ad was ");
        var5_5 = var2_2 != false ? "" : "un";
        var4_4.append(var5_5);
        var4_4.append("successful.");
        Log.d((String)"MoatWebAdTracker", (String)var4_4.toString());
        return var2_2;
    }
}


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
package com.moat.analytics.mobile.aer;

import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import com.moat.analytics.mobile.aer.WebAdTracker;
import com.moat.analytics.mobile.aer.al;
import com.moat.analytics.mobile.aer.ba;
import com.moat.analytics.mobile.aer.base.exception.a;
import com.moat.analytics.mobile.aer.base.exception.b;
import com.moat.analytics.mobile.aer.bb;

class bc
implements WebAdTracker {
    private final com.moat.analytics.mobile.aer.base.functional.a<? extends ba> a;
    private final al b;

    bc(WebView webView, com.moat.analytics.mobile.aer.a a2, al al2) {
        com.moat.analytics.mobile.aer.base.functional.a<Object> a3;
        this.b = al2;
        if (al2.b()) {
            Log.d((String)"MoatWebAdTracker", (String)"In initialization method.");
        }
        if (webView == null) {
            if (al2.b()) {
                Log.e((String)"MoatWebAdTracker", (String)"WebView is null. Will not track.");
            }
            a3 = com.moat.analytics.mobile.aer.base.functional.a.a();
        } else {
            bb bb2 = new bb((View)webView, webView, false, a2, al2);
            a3 = com.moat.analytics.mobile.aer.base.functional.a.a(bb2);
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
                var2_2 = this.a.b().b();
            }
        }
        catch (b var3_3) {
            a.a(var3_3);
        }
        if (var1_1 == false) return var2_2;
        var4_4 = new StringBuilder();
        var4_4.append("Attempt to start tracking ad was ");
        var6_5 = var2_2 != false ? "" : "un";
        var4_4.append(var6_5);
        var4_4.append("successful.");
        Log.d((String)"MoatWebAdTracker", (String)var4_4.toString());
        return var2_2;
    }
}


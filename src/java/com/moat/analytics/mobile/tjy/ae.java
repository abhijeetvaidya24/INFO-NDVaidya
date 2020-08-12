/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  com.moat.analytics.mobile.tjy.bi
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 */
package com.moat.analytics.mobile.tjy;

import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.moat.analytics.mobile.tjy.ad;
import com.moat.analytics.mobile.tjy.ap;
import com.moat.analytics.mobile.tjy.base.exception.a;
import com.moat.analytics.mobile.tjy.bh;
import com.moat.analytics.mobile.tjy.bi;

class ae
extends WebViewClient {
    final /* synthetic */ ad a;

    ae(ad ad2) {
        this.a = ad2;
    }

    public void onPageFinished(WebView webView, String string2) {
        if (!ad.a(this.a)) {
            try {
                ad.a(this.a, true);
                ad ad2 = this.a;
                bi bi2 = new bi((View)ad.b(this.a).get(), ad.c(this.a), true, this.a.a, this.a.b);
                ad2.c = bi2;
                this.a.c.c();
                this.a.a();
                return;
            }
            catch (Exception exception) {
                a.a(exception);
            }
        }
    }
}


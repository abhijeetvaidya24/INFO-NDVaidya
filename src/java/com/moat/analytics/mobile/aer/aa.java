/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  com.moat.analytics.mobile.aer.bb
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 */
package com.moat.analytics.mobile.aer;

import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.moat.analytics.mobile.aer.al;
import com.moat.analytics.mobile.aer.ba;
import com.moat.analytics.mobile.aer.base.exception.a;
import com.moat.analytics.mobile.aer.bb;
import com.moat.analytics.mobile.aer.z;

class aa
extends WebViewClient {
    final /* synthetic */ z a;

    aa(z z2) {
        this.a = z2;
    }

    public void onPageFinished(WebView webView, String string) {
        if (!z.a(this.a)) {
            try {
                z.a(this.a, true);
                z z2 = this.a;
                bb bb2 = new bb((View)z.b(this.a).get(), z.c(this.a), true, this.a.a, this.a.b);
                z2.c = bb2;
                this.a.c.b();
                this.a.a();
                return;
            }
            catch (Exception exception) {
                a.a(exception);
            }
        }
    }
}


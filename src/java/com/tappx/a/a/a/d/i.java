/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  com.google.android.gms.ads.AdListener
 *  com.google.android.gms.ads.AdRequest
 *  com.google.android.gms.ads.AdRequest$Builder
 *  com.google.android.gms.ads.AdSize
 *  com.google.android.gms.ads.AdView
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Throwable
 */
package com.tappx.a.a.a.d;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.tappx.a.a.a.c.a;
import com.tappx.a.a.a.d.c;
import com.tappx.a.a.a.d.g;
import com.tappx.a.a.a.e.h;

public class i
implements g {
    private static final AdSize[] a;
    private final AdView b;
    private boolean c = false;
    private c.b d;

    static {
        AdSize[] arradSize = new AdSize[]{AdSize.BANNER, AdSize.FULL_BANNER, AdSize.LARGE_BANNER, AdSize.LEADERBOARD, AdSize.MEDIUM_RECTANGLE, AdSize.WIDE_SKYSCRAPER};
        a = arradSize;
    }

    public i(Context context) {
        this.b = new AdView(context);
    }

    private AdSize a(int n2, int n3) {
        for (AdSize adSize : a) {
            if (adSize.getWidth() != n2 || adSize.getHeight() != n3) continue;
            return adSize;
        }
        return AdSize.BANNER;
    }

    @Override
    public void a() {
        AdView adView = this.b;
        if (adView != null) {
            adView.destroy();
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    @Override
    public void a(final c.b var1_1, final Runnable var2_2) {
        this.d = var1_1;
        if (var1_1 != null) ** GOTO lbl6
        try {
            this.b.setAdListener(null);
            return;
lbl6: // 1 sources:
            this.b.setAdListener(new AdListener(){

                public void onAdClosed() {
                }

                public void onAdFailedToLoad(int n2) {
                    a.e("1HPYA2lkbaNURYCXsP4iRrPA2bcLu2GoZBfTi2x2iws", new Object[0]);
                    c.b b2 = var1_1;
                    if (b2 != null) {
                        b2.a(h.a);
                    }
                }

                public void onAdLeftApplication() {
                    c.b b2 = var1_1;
                    if (b2 != null) {
                        b2.d();
                    }
                }

                public void onAdLoaded() {
                    a.e("sQBMFfIvnZat9SH496KzHfKib626NzkhHKkXIfYGxxc", new Object[0]);
                    var2_2.run();
                    c.b b2 = var1_1;
                    if (b2 != null) {
                        b2.a((View)i.this.b);
                    }
                }

                public void onAdOpened() {
                    c.b b2 = var1_1;
                    if (b2 != null) {
                        b2.c();
                    }
                }
            });
            return;
        }
        catch (Throwable v0) {
            this.c = true;
            return;
        }
    }

    @Override
    public void a(String string, int n2, int n3) {
        try {
            AdSize adSize = this.a(n2, n3);
            this.b.setAdSize(adSize);
            this.b.setAdUnitId(string);
            return;
        }
        catch (Throwable throwable) {
            this.c = true;
            return;
        }
    }

    @Override
    public void b() {
        if (this.c) {
            c.b b2 = this.d;
            if (b2 != null) {
                b2.a(h.d);
            }
            return;
        }
        try {
            AdRequest adRequest = new AdRequest.Builder().build();
            this.b.loadAd(adRequest);
        }
        catch (Throwable throwable) {}
    }

    @Override
    public View c() {
        return this.b;
    }

}


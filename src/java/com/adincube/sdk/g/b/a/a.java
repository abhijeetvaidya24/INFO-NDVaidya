/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.adincube.sdk.AdinCubeBannerEventListener
 *  com.adincube.sdk.BannerView
 *  com.adincube.sdk.g.a
 *  com.adincube.sdk.g.b.a.b
 *  com.adincube.sdk.g.b.c.c
 *  com.adincube.sdk.g.b.c.c$a
 *  com.adincube.sdk.g.b.d
 *  com.adincube.sdk.h.b.b
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.HashSet
 *  java.util.Set
 */
package com.adincube.sdk.g.b.a;

import com.adincube.sdk.AdinCubeBannerEventListener;
import com.adincube.sdk.BannerView;
import com.adincube.sdk.g.b.a.b;
import com.adincube.sdk.g.b.c.c;
import com.adincube.sdk.g.b.d;
import com.adincube.sdk.util.o;
import java.util.HashSet;
import java.util.Set;

public final class a
implements d {
    BannerView a = null;
    public AdinCubeBannerEventListener b = null;
    int c = 0;
    private com.adincube.sdk.g.a d = null;
    private Set<b> e = new HashSet();
    private boolean f = false;

    public a(BannerView bannerView, com.adincube.sdk.g.a a2) {
        this.a = bannerView;
        this.d = a2;
    }

    public final void a(b b2) {
        this.e.add((Object)b2);
    }

    public final void a(final boolean bl) {
        o.a("BannerEventListenerManager.onAdCached", this.e, new com.adincube.sdk.util.c.a<b>(){

            @Override
            public final /* synthetic */ void a(Object object) {
                b b2 = (b)object;
                if (a.this.c == c.a.a) {
                    b2.a(bl);
                    return;
                }
                if (a.this.c == c.a.b) {
                    b2.b(bl);
                }
            }
        });
        if (!this.f && !bl) {
            this.f = true;
            o.b(this.b, new com.adincube.sdk.util.c.a<AdinCubeBannerEventListener>(){

                @Override
                public final /* synthetic */ void a(Object object) {
                    ((AdinCubeBannerEventListener)object).onAdLoaded(a.this.a);
                }
            });
        }
    }

    public final void a(boolean bl, com.adincube.sdk.d.a.c c2) {
        this.b(bl, c2);
    }

    public final void b(boolean bl) {
        if (!bl || this.d.a((boolean)true, (boolean)true).G) {
            o.b(this.b, new com.adincube.sdk.util.c.a<AdinCubeBannerEventListener>(){

                @Override
                public final /* synthetic */ void a(Object object) {
                    ((AdinCubeBannerEventListener)object).onAdShown(a.this.a);
                }
            });
        }
    }

    public final void b(final boolean bl, final com.adincube.sdk.d.a.c c2) {
        new StringBuilder("onLoadError - ").append(c2.a);
        o.a("BannerEventListenerManager.onLoadError", this.e, new com.adincube.sdk.util.c.a<b>(){});
        if (!bl) {
            o.b(this.b, new com.adincube.sdk.util.c.a<AdinCubeBannerEventListener>(){

                @Override
                public final /* synthetic */ void a(Object object) {
                    ((AdinCubeBannerEventListener)object).onLoadError(a.this.a, c2.a);
                }
            });
        }
    }

}


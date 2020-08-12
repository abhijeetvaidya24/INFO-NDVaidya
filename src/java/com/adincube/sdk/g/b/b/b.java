/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.adincube.sdk.AdinCubeInterstitialEventListener
 *  com.adincube.sdk.g.b.d
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.HashSet
 *  java.util.Set
 */
package com.adincube.sdk.g.b.b;

import com.adincube.sdk.AdinCubeInterstitialEventListener;
import com.adincube.sdk.d.a.c;
import com.adincube.sdk.g.b.d;
import com.adincube.sdk.util.c.a;
import com.adincube.sdk.util.o;
import java.util.HashSet;
import java.util.Set;

public class b
implements d {
    private static b c;
    public AdinCubeInterstitialEventListener a = null;
    public Set<AdinCubeInterstitialEventListener> b = new HashSet();

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static b b() {
        if (c != null) return c;
        Class<b> class_ = b.class;
        synchronized (b.class) {
            if (c != null) return c;
            c = new b();
            // ** MonitorExit[var1] (shouldn't be in output)
            return c;
        }
    }

    public final void a(final c c2) {
        new StringBuilder("onError - ").append(c2.a);
        o.a("InterstitialEventListenerManager.onInterstitialError", this.b, new a<AdinCubeInterstitialEventListener>(){

            @Override
            public final /* synthetic */ void a(Object object) {
                ((AdinCubeInterstitialEventListener)object).onError(c2.a);
            }
        });
        o.b(this.a, new a<AdinCubeInterstitialEventListener>(){

            @Override
            public final /* synthetic */ void a(Object object) {
                ((AdinCubeInterstitialEventListener)object).onError(c2.a);
            }
        });
    }

    public final void a(boolean bl) {
        o.a("InterstitialEventListenerManager.onAdCached", this.b, new a<AdinCubeInterstitialEventListener>(){

            @Override
            public final /* synthetic */ void a(Object object) {
                ((AdinCubeInterstitialEventListener)object).onAdCached();
            }
        });
        o.b(this.a, new a<AdinCubeInterstitialEventListener>(){

            @Override
            public final /* synthetic */ void a(Object object) {
                ((AdinCubeInterstitialEventListener)object).onAdCached();
            }
        });
    }

    public final void a(boolean bl, c c2) {
        c2.a();
    }

    public final void b(boolean bl, c c2) {
        new Object[1][0] = c2.a;
    }

    public final void c() {
        o.a("InterstitialEventListenerManager.onInterstitialAdHidden", this.b, new a<AdinCubeInterstitialEventListener>(){

            @Override
            public final /* synthetic */ void a(Object object) {
                ((AdinCubeInterstitialEventListener)object).onAdHidden();
            }
        });
        o.b(this.a, new a<AdinCubeInterstitialEventListener>(){

            @Override
            public final /* synthetic */ void a(Object object) {
                ((AdinCubeInterstitialEventListener)object).onAdHidden();
            }
        });
    }

}


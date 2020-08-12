/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  com.startapp.android.publish.ads.b.d
 *  com.startapp.android.publish.ads.b.e
 *  com.startapp.android.publish.ads.c.a.b
 *  com.startapp.android.publish.ads.c.b.b
 *  com.startapp.android.publish.ads.splash.b
 *  com.startapp.android.publish.ads.video.e
 *  com.startapp.android.publish.adsCommon.StartAppAd
 *  com.startapp.android.publish.adsCommon.adListeners.b
 *  com.startapp.android.publish.cache.b
 *  com.startapp.android.publish.cache.f
 *  com.startapp.android.publish.cache.g$1
 *  com.startapp.android.publish.cache.g$2
 *  com.startapp.android.publish.cache.g$a
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.ArrayList
 *  java.util.List
 *  java.util.Map
 *  java.util.Random
 *  java.util.concurrent.ConcurrentHashMap
 *  java.util.concurrent.atomic.AtomicBoolean
 */
package com.startapp.android.publish.cache;

import android.app.Activity;
import android.content.Context;
import com.startapp.android.publish.ads.b.d;
import com.startapp.android.publish.ads.video.e;
import com.startapp.android.publish.adsCommon.Ad;
import com.startapp.android.publish.adsCommon.AdsConstants;
import com.startapp.android.publish.adsCommon.StartAppAd;
import com.startapp.android.publish.adsCommon.adListeners.AdEventListener;
import com.startapp.android.publish.adsCommon.b.c;
import com.startapp.android.publish.cache.f;
import com.startapp.android.publish.cache.g;
import com.startapp.android.publish.cache.i;
import com.startapp.android.publish.common.metaData.MetaData;
import com.startapp.android.publish.common.model.AdPreferences;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/*
 * Exception performing whole class analysis.
 */
public class g {
    public static boolean h;
    protected com.startapp.android.publish.adsCommon.g a;
    protected AtomicBoolean b;
    protected long c;
    protected f d;
    protected com.startapp.android.publish.cache.b e;
    protected Map<AdEventListener, List<StartAppAd>> f;
    protected b g;
    private final AdPreferences.Placement i;
    private Context j;
    private com.startapp.android.publish.adsCommon.a k;
    private AdPreferences l;
    private String m;
    private boolean n;
    private int o;
    private boolean p;

    public g(Context context, AdPreferences.Placement placement, AdPreferences adPreferences) {
        this.a = null;
        this.b = new AtomicBoolean(false);
        this.m = null;
        this.n = false;
        this.d = null;
        this.e = null;
        this.f = new ConcurrentHashMap();
        this.p = true;
        this.i = placement;
        this.l = adPreferences;
        this.a(context);
        this.o();
    }

    public g(Context context, AdPreferences.Placement placement, AdPreferences adPreferences, boolean bl) {
        this(context, placement, adPreferences);
        this.p = bl;
    }

    static /* synthetic */ AdPreferences.Placement a(g g2) {
        return g2.i;
    }

    private void a(Context context) {
        if (context instanceof Activity) {
            this.j = context.getApplicationContext();
            this.k = new com.startapp.android.publish.adsCommon.a((Activity)context);
            return;
        }
        this.j = context;
        this.k = null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(StartAppAd startAppAd, AdEventListener adEventListener, boolean bl) {
        Map<AdEventListener, List<StartAppAd>> map;
        Map<AdEventListener, List<StartAppAd>> map2 = map = this.f;
        synchronized (map2) {
            boolean bl2 = !this.g() || this.u() || bl;
            if (bl2) {
                if (startAppAd != null && adEventListener != null) {
                    List list = (List)this.f.get((Object)adEventListener);
                    if (list == null) {
                        list = new ArrayList();
                        this.f.put((Object)adEventListener, (Object)list);
                    }
                    list.add((Object)startAppAd);
                }
                if (!this.b.compareAndSet(false, true)) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append((Object)this.i);
                    stringBuilder.append(" ad is currently loading");
                    com.startapp.common.a.g.a("CachedAd", 3, stringBuilder.toString());
                    return;
                }
                this.d.g();
                this.e.g();
                this.p();
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append((Object)this.i);
                stringBuilder.append(" ad already loaded");
                com.startapp.common.a.g.a("CachedAd", 3, stringBuilder.toString());
                if (startAppAd != null && adEventListener != null) {
                    new com.startapp.android.publish.adsCommon.adListeners.b(adEventListener).onReceiveAd((Ad)startAppAd);
                }
            }
            return;
        }
    }

    private void o() {
        this.d = new f(this);
        this.e = new com.startapp.android.publish.cache.b(this);
    }

    private void p() {
        com.startapp.android.publish.adsCommon.g g2 = this.a;
        if (g2 != null) {
            g2.setVideoCancelCallBack(false);
        }
        if (this.q()) {
            this.a(false);
            this.r();
            return;
        }
        this.n();
    }

    private boolean q() {
        return this.n && this.m != null;
    }

    private void r() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Loading ");
        stringBuilder.append((Object)this.i);
        stringBuilder.append(" from disk ");
        stringBuilder.append("file name: ");
        stringBuilder.append(this.m);
        com.startapp.common.a.g.a("CachedAd", 4, stringBuilder.toString());
        1 var7_2 = new 1(this, new /* Unavailable Anonymous Inner Class!! */);
        i.a(this.j, this.m, (i.a)new 2(this), (AdEventListener)var7_2);
    }

    private boolean s() {
        return this.o < MetaData.getInstance().getStopAutoLoadAmount();
    }

    private void t() {
        this.o = 1 + this.o;
    }

    private boolean u() {
        com.startapp.android.publish.adsCommon.g g2 = this.a;
        if (g2 == null) {
            return false;
        }
        return g2.hasAdCacheTtlPassed();
    }

    private com.startapp.android.publish.adsCommon.g v() {
        int n2 = com.startapp.android.publish.adsCommon.b.a().d();
        boolean bl = new Random().nextInt(100) < n2;
        boolean bl2 = com.startapp.android.publish.adsCommon.Utils.i.a(this.l, "forceOfferWall3D");
        boolean bl3 = true ^ com.startapp.android.publish.adsCommon.Utils.i.a(this.l, "forceOfferWall2D");
        boolean bl4 = com.startapp.android.publish.adsCommon.Utils.i.a(64L);
        if (!(this.w() || bl4 && (bl || bl2) && bl3)) {
            return new com.startapp.android.publish.ads.c.a.b(this.j);
        }
        return new com.startapp.android.publish.ads.c.b.b(this.j);
    }

    private boolean w() {
        return com.startapp.android.publish.adsCommon.Utils.i.a(64L) && !com.startapp.android.publish.adsCommon.Utils.i.a(128L);
    }

    public AdPreferences a() {
        return this.l;
    }

    public void a(int n2) {
        this.o = n2;
    }

    public void a(StartAppAd startAppAd, AdEventListener adEventListener) {
        this.a(startAppAd, adEventListener, false);
    }

    public void a(b b2) {
        this.g = b2;
    }

    protected void a(AdPreferences adPreferences) {
        this.l = adPreferences;
    }

    protected void a(String string) {
        this.m = string;
    }

    protected void a(boolean bl) {
        this.n = bl;
    }

    public com.startapp.android.publish.adsCommon.g b() {
        return this.a;
    }

    protected void b(boolean bl) {
        this.a(null, null, bl);
    }

    protected AdPreferences.Placement c() {
        return this.i;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    protected void d() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalidating: ");
        stringBuilder.append((Object)this.i);
        com.startapp.common.a.g.a("CachedAd", 4, stringBuilder.toString());
        if (this.g()) {
            if (!c.a(this.j, (Ad)((Object)this.a)) && !this.u()) {
                if (this.b.get()) return;
                this.d.f();
                return;
            }
            com.startapp.common.a.g.a("CachedAd", 3, "App present or cache TTL passed, reloading");
            this.b(true);
            return;
        }
        if (this.b.get()) return;
        this.e.f();
    }

    protected void e() {
        this.e.h();
    }

    protected void f() {
        this.d.h();
    }

    public boolean g() {
        com.startapp.android.publish.adsCommon.g g2 = this.a;
        return g2 != null && g2.isReady();
    }

    public boolean h() {
        return this.p;
    }

    public com.startapp.android.publish.adsCommon.g i() {
        com.startapp.android.publish.adsCommon.g g2;
        if (this.g()) {
            g2 = this.a;
            this.m();
            if (!AdsConstants.OVERRIDE_NETWORK.booleanValue() && this.h()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Ad shown, reloading ");
                stringBuilder.append((Object)this.i);
                com.startapp.common.a.g.a("CachedAd", 3, stringBuilder.toString());
                this.b(true);
                return g2;
            }
            if (!this.h()) {
                f f2;
                b b2 = this.g;
                if (b2 != null) {
                    b2.a(this);
                }
                if ((f2 = this.d) != null) {
                    f2.a();
                    return g2;
                }
            }
        } else {
            g2 = null;
        }
        return g2;
    }

    public com.startapp.android.publish.adsCommon.g j() {
        com.startapp.android.publish.adsCommon.Utils.i.a(this.j, this.l);
        int n2 = 3.a[this.i.ordinal()];
        Object object = n2 != 1 ? (n2 != 2 ? (n2 != 3 ? (n2 != 4 ? (n2 != 5 ? new d(this.j) : new com.startapp.android.publish.ads.splash.b(this.j)) : new com.startapp.android.publish.ads.b.e(this.j)) : this.v()) : (com.startapp.android.publish.adsCommon.Utils.i.a(4L) ? new e(this.j) : new d(this.j))) : new d(this.j);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ad Type: [");
        stringBuilder.append(object.getClass().toString());
        stringBuilder.append("]");
        com.startapp.common.a.g.a("CachedAd", 4, stringBuilder.toString());
        return object;
    }

    public boolean k() {
        if (this.s()) {
            this.b(true);
            this.t();
            return true;
        }
        b b2 = this.g;
        if (b2 != null) {
            b2.a(this);
        }
        return false;
    }

    public int l() {
        return this.o;
    }

    protected void m() {
        this.o = 0;
    }

    protected void n() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Loading ");
        stringBuilder.append((Object)this.i);
        stringBuilder.append(" from server");
        com.startapp.common.a.g.a("CachedAd", 4, stringBuilder.toString());
        this.a = this.j();
        this.a.setActivityExtra(this.k);
        this.a.load(this.l, (AdEventListener)new /* Unavailable Anonymous Inner Class!! */);
        this.c = System.currentTimeMillis();
    }

    public static interface b {
        public void a(g var1);
    }

}


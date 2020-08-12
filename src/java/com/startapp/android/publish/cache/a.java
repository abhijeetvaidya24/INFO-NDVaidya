/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.startapp.android.publish.ads.b.e
 *  com.startapp.android.publish.adsCommon.StartAppAd
 *  com.startapp.android.publish.adsCommon.f.e
 *  com.startapp.android.publish.cache.a$1
 *  com.startapp.android.publish.cache.a$2
 *  com.startapp.android.publish.cache.a$3
 *  com.startapp.android.publish.cache.a$5
 *  java.lang.Exception
 *  java.lang.Math
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Queue
 *  java.util.Random
 *  java.util.Set
 *  java.util.UUID
 *  java.util.WeakHashMap
 *  java.util.concurrent.ConcurrentHashMap
 *  java.util.concurrent.ConcurrentLinkedQueue
 */
package com.startapp.android.publish.cache;

import android.content.Context;
import com.startapp.android.publish.ads.b.e;
import com.startapp.android.publish.adsCommon.Ad;
import com.startapp.android.publish.adsCommon.StartAppAd;
import com.startapp.android.publish.adsCommon.adListeners.AdEventListener;
import com.startapp.android.publish.adsCommon.b;
import com.startapp.android.publish.adsCommon.f.f;
import com.startapp.android.publish.adsCommon.k;
import com.startapp.android.publish.adsCommon.m;
import com.startapp.android.publish.cache.ACMConfig;
import com.startapp.android.publish.cache.a;
import com.startapp.android.publish.cache.c;
import com.startapp.android.publish.cache.d;
import com.startapp.android.publish.cache.g;
import com.startapp.android.publish.cache.i;
import com.startapp.android.publish.common.metaData.MetaData;
import com.startapp.android.publish.common.model.AdPreferences;
import com.startapp.common.g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class a {
    private static a c = new a();
    final Map<c, g> a = new ConcurrentHashMap();
    protected boolean b = false;
    private Map<String, String> d = new WeakHashMap();
    private boolean e = false;
    private Queue<a> f = new ConcurrentLinkedQueue();
    private g.b g;
    private Context h;

    private a() {
    }

    public static a a() {
        return c;
    }

    private AdPreferences.Placement a(AdPreferences adPreferences) {
        int n2 = b.a().c();
        if ((new Random().nextInt(100) < n2 || com.startapp.android.publish.adsCommon.Utils.i.a(adPreferences, "forceFullpage")) && !com.startapp.android.publish.adsCommon.Utils.i.a(adPreferences, "forceOverlay")) {
            return AdPreferences.Placement.INAPP_FULL_SCREEN;
        }
        return AdPreferences.Placement.INAPP_OVERLAY;
    }

    private void a(StartAppAd.AdMode adMode, AdPreferences adPreferences) {
        if (adMode.equals((Object)StartAppAd.AdMode.REWARDED_VIDEO)) {
            com.startapp.android.publish.adsCommon.c.a(adPreferences, "type", Ad.AdType.REWARDED_VIDEO);
        }
        if (adMode.equals((Object)StartAppAd.AdMode.VIDEO)) {
            com.startapp.android.publish.adsCommon.c.a(adPreferences, "type", Ad.AdType.VIDEO);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(c c2, g g2, Context context) {
        Map<c, g> map;
        Map<c, g> map2 = map = this.a;
        synchronized (map2) {
            int n2 = d.a().b().getMaxCacheSize();
            if (n2 != 0 && this.c() >= n2) {
                long l2 = Long.MAX_VALUE;
                c c3 = null;
                for (c c4 : this.a.keySet()) {
                    g g3 = (g)this.a.get((Object)c4);
                    if (g3.c() != g2.c() || g3.c >= l2) continue;
                    l2 = g3.c;
                    c3 = c4;
                }
                if (c3 != null) {
                    this.a.remove(c3);
                }
            }
            this.a.put((Object)c2, (Object)g2);
            if (!(100.0 * Math.random() < (double)d.a().c())) return;
            f.a(context, new com.startapp.android.publish.adsCommon.f.e(com.startapp.android.publish.adsCommon.f.d.d, "Cache Size", String.valueOf((int)this.c())), "");
            return;
        }
    }

    private void a(boolean bl) {
        for (g g2 : this.a.values()) {
            if (g2.b() != null && com.startapp.android.publish.adsCommon.Utils.i.a(2L) && g2.b() instanceof e && !bl) {
                if (!d.a().b().shouldReturnAdLoadInBg()) {
                    g2.f();
                }
            } else {
                g2.f();
            }
            g2.e();
        }
    }

    static /* synthetic */ boolean a(a a2, AdPreferences.Placement placement) {
        return a2.b(placement);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private AdPreferences.Placement b(StartAppAd.AdMode var1_1, AdPreferences var2_2) {
        block14 : {
            block13 : {
                switch (6.b[var1_1.ordinal()]) {
                    default: {
                        return AdPreferences.Placement.INAPP_FULL_SCREEN;
                    }
                    case 6: {
                        if (com.startapp.android.publish.adsCommon.Utils.i.a(128L)) ** GOTO lbl9
                        var9_3 = com.startapp.android.publish.adsCommon.Utils.i.a(64L);
                        var5_4 = false;
                        if (!var9_3) ** GOTO lbl10
lbl9: // 2 sources:
                        var5_4 = true;
lbl10: // 2 sources:
                        var6_5 = com.startapp.android.publish.adsCommon.Utils.i.a(4L);
                        var7_6 = com.startapp.android.publish.adsCommon.Utils.i.a(2L);
                        if (var6_5 && var7_6 && var5_4) {
                            var8_7 = b.a().b();
                            if (new Random().nextInt(100) >= var8_7) return AdPreferences.Placement.INAPP_FULL_SCREEN;
                            return this.a(var2_2);
                        }
                        if (var6_5 != false) return AdPreferences.Placement.INAPP_OVERLAY;
                        if (var7_6) {
                            return AdPreferences.Placement.INAPP_OVERLAY;
                        }
                        if (var5_4 == false) return AdPreferences.Placement.INAPP_FULL_SCREEN;
                        return AdPreferences.Placement.INAPP_OFFER_WALL;
                    }
                    case 2: 
                    case 3: 
                    case 4: 
                    case 5: {
                        return AdPreferences.Placement.INAPP_OVERLAY;
                    }
                    case 1: 
                }
                if (com.startapp.android.publish.adsCommon.Utils.i.a(128L)) break block13;
                var4_8 = com.startapp.android.publish.adsCommon.Utils.i.a(64L);
                var3_9 = false;
                if (!var4_8) break block14;
            }
            var3_9 = true;
        }
        if (var3_9 != true) return AdPreferences.Placement.INAPP_FULL_SCREEN;
        return AdPreferences.Placement.INAPP_OFFER_WALL;
    }

    private boolean b(AdPreferences.Placement placement) {
        int n2 = 6.a[placement.ordinal()];
        if (n2 != 1) {
            if (n2 != 2) {
                return true;
            }
            boolean bl = m.a().h();
            boolean bl2 = false;
            if (bl) {
                boolean bl3 = b.a().y();
                bl2 = false;
                if (!bl3) {
                    bl2 = true;
                }
            }
            return bl2;
        }
        boolean bl = m.a().k();
        boolean bl4 = false;
        if (bl) {
            boolean bl5 = b.a().z();
            bl4 = false;
            if (!bl5) {
                bl4 = true;
            }
        }
        return bl4;
    }

    private void e(final Context context) {
        com.startapp.common.a.g.a("AdCacheManager", 3, "Saving to disk: eneter save to disk ");
        if (this.e()) {
            com.startapp.common.a.g.a("AdCacheManager", 3, "Saving to disk: cache to disk is enebaled ");
            com.startapp.common.g.a(g.a.a, new Runnable(){

                /*
                 * Enabled aggressive block sorting
                 * Enabled unnecessary exception pruning
                 * Enabled aggressive exception aggregation
                 */
                public void run() {
                    try {
                        com.startapp.common.a.e.a(context, i.b());
                        com.startapp.common.a.e.a(context, i.c());
                        c c2 = null;
                        Iterator iterator = a.this.a.entrySet().iterator();
                        do {
                            if (!iterator.hasNext()) {
                                if (c2 == null) return;
                                a.this.a.remove(c2);
                                return;
                            }
                            Map.Entry entry = (Map.Entry)iterator.next();
                            c c3 = (c)entry.getKey();
                            if (c3.a() == AdPreferences.Placement.INAPP_SPLASH) {
                                c2 = c3;
                                continue;
                            }
                            g g2 = (g)entry.getValue();
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Saving to disk: ");
                            stringBuilder.append(c3.toString());
                            com.startapp.common.a.g.a("AdCacheManager", 3, stringBuilder.toString());
                            i.a(context, c3.a(), g2.a(), a.this.c(c3), g2.l());
                            i.a(context, g2, a.this.c(c3));
                        } while (true);
                    }
                    catch (Exception exception) {
                        com.startapp.common.a.g.a("AdCacheManager", 3, "Saving to disk: exception caught");
                        f.a(context, com.startapp.android.publish.adsCommon.f.d.b, "AdCacheManager.saveToDisk - Unexpected Thread Exception", exception.getMessage(), "");
                    }
                }
            });
        }
    }

    private boolean e() {
        return !this.b && d.a().b().isLocalCache();
    }

    private g.b f() {
        if (this.g == null) {
            this.g = new 5(this);
        }
        return this.g;
    }

    public com.startapp.android.publish.adsCommon.g a(c c2) {
        if (c2 == null) {
            com.startapp.common.a.g.a("AdCacheManager", 3, "Cache key is null");
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Retrieving ad with ");
        stringBuilder.append((Object)c2);
        com.startapp.common.a.g.a("AdCacheManager", 3, stringBuilder.toString());
        g g2 = (g)this.a.get((Object)c2);
        if (g2 != null) {
            return g2.i();
        }
        return null;
    }

    public c a(Context context, StartAppAd startAppAd, StartAppAd.AdMode adMode, AdPreferences adPreferences, AdEventListener adEventListener) {
        if (adPreferences == null) {
            adPreferences = new AdPreferences();
        }
        AdPreferences adPreferences2 = adPreferences;
        AdPreferences.Placement placement = this.b(adMode, adPreferences2);
        this.a(adMode, adPreferences2);
        return this.a(context, startAppAd, placement, adPreferences2, adEventListener, false, 0);
    }

    public c a(Context context, StartAppAd startAppAd, AdPreferences.Placement placement, AdPreferences adPreferences, AdEventListener adEventListener) {
        return this.a(context, startAppAd, placement, adPreferences, adEventListener, false, 0);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected c a(Context context, StartAppAd startAppAd, AdPreferences.Placement placement, AdPreferences adPreferences, AdEventListener adEventListener, boolean bl, int n2) {
        g g2;
        Map<c, g> map;
        this.h = context.getApplicationContext();
        if (adPreferences == null) {
            adPreferences = new AdPreferences();
        }
        AdPreferences adPreferences2 = adPreferences;
        c c2 = new c(placement, adPreferences2);
        if (this.e && !bl) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Adding to pending queue: ");
            stringBuilder.append((Object)placement);
            com.startapp.common.a.g.a("AdCacheManager", 4, stringBuilder.toString());
            Queue<a> queue = this.f;
            a a2 = new a(startAppAd, placement, adPreferences2, adEventListener);
            queue.add((Object)a2);
            return c2;
        }
        AdPreferences adPreferences3 = new AdPreferences(adPreferences2);
        Map<c, g> map2 = map = this.a;
        synchronized (map2) {
            g2 = (g)this.a.get((Object)c2);
            if (g2 == null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("CachedAd for ");
                stringBuilder.append((Object)placement);
                stringBuilder.append(" not found. Adding new CachedAd with ");
                stringBuilder.append((Object)c2);
                com.startapp.common.a.g.a("AdCacheManager", 3, stringBuilder.toString());
                g2 = 6.a[placement.ordinal()] != 1 ? new g(context, placement, adPreferences3) : new g(context, placement, adPreferences3, false);
                g2.a(this.f());
                if (bl) {
                    g2.a(this.c(c2));
                    g2.a(true);
                    g2.a(n2);
                }
                this.a(c2, g2, context);
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("CachedAd for ");
                stringBuilder.append((Object)placement);
                stringBuilder.append(" already exists.");
                com.startapp.common.a.g.a("AdCacheManager", 3, stringBuilder.toString());
                g2.a(adPreferences3);
            }
        }
        g2.a(startAppAd, adEventListener);
        return c2;
    }

    public c a(Context context, StartAppAd startAppAd, AdPreferences adPreferences, AdEventListener adEventListener) {
        if (this.b(AdPreferences.Placement.INAPP_SPLASH)) {
            com.startapp.common.a.g.a("AdCacheManager", 3, "Loading splash");
            return this.a(context, startAppAd, AdPreferences.Placement.INAPP_SPLASH, adPreferences, adEventListener);
        }
        return null;
    }

    public c a(Context context, AdPreferences adPreferences) {
        if (this.b(AdPreferences.Placement.INAPP_RETURN)) {
            com.startapp.common.a.g.a("AdCacheManager", 3, "Loading return ad");
            return this.a(context, null, AdPreferences.Placement.INAPP_RETURN, adPreferences, null);
        }
        return null;
    }

    public String a(StartAppAd.AdMode adMode) {
        if (adMode != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("autoLoadNotShownAdPrefix");
            stringBuilder.append(adMode.name());
            return stringBuilder.toString();
        }
        return null;
    }

    public String a(String string) {
        return this.a(string, UUID.randomUUID().toString());
    }

    public String a(String string, String string2) {
        this.d.put((Object)string2, (Object)string);
        return string2;
    }

    protected Set<StartAppAd.AdMode> a(Set<StartAppAd.AdMode> set) {
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            StartAppAd.AdMode adMode = (StartAppAd.AdMode)((Object)iterator.next());
            int n2 = k.a(this.h, this.a(adMode), 0);
            int n3 = MetaData.getInstance().getStopAutoLoadPreCacheAmount();
            boolean bl = false;
            if (n2 >= n3) {
                bl = true;
            }
            if (!bl) continue;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("preCacheAds.remove ");
            stringBuilder.append(adMode.name());
            com.startapp.common.a.g.a("preCache", 3, stringBuilder.toString());
            iterator.remove();
        }
        if (!com.startapp.android.publish.adsCommon.Utils.i.a(128L) && !com.startapp.android.publish.adsCommon.Utils.i.a(64L)) {
            set.remove((Object)StartAppAd.AdMode.OFFERWALL);
        }
        if (!com.startapp.android.publish.adsCommon.Utils.i.a(2L) && !com.startapp.android.publish.adsCommon.Utils.i.a(4L)) {
            set.remove((Object)StartAppAd.AdMode.FULLPAGE);
        }
        if (!com.startapp.android.publish.adsCommon.Utils.i.a(4L)) {
            set.remove((Object)StartAppAd.AdMode.REWARDED_VIDEO);
            set.remove((Object)StartAppAd.AdMode.VIDEO);
        }
        return set;
    }

    public void a(Context context) {
        this.h = context.getApplicationContext();
        if (this.e()) {
            this.e = true;
            i.a(context, (i.c)new 1(this, context));
        }
    }

    public void a(Context context, boolean bl) {
        this.e(context);
        this.a(bl);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(AdPreferences.Placement placement) {
        Map<c, g> map;
        Map<c, g> map2 = map = this.a;
        synchronized (map2) {
            Iterator iterator = this.a.entrySet().iterator();
            while (iterator.hasNext()) {
                if (((c)((Map.Entry)iterator.next()).getKey()).a() != placement) continue;
                iterator.remove();
            }
            return;
        }
    }

    public com.startapp.android.publish.adsCommon.g b(c c2) {
        g g2 = c2 != null ? (g)this.a.get((Object)c2) : null;
        if (g2 != null) {
            return g2.b();
        }
        return null;
    }

    public String b(String string) {
        return (String)this.d.get((Object)string);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void b() {
        Map<c, g> map;
        if (this.e) {
            return;
        }
        Map<c, g> map2 = map = this.a;
        synchronized (map2) {
            Iterator iterator = this.a.values().iterator();
            while (iterator.hasNext()) {
                ((g)iterator.next()).d();
            }
            return;
        }
    }

    public void b(Context context) {
        this.b = true;
        i.a(context, (i.e)new 2(this));
    }

    public int c() {
        return this.a.size();
    }

    protected String c(c c2) {
        return String.valueOf((int)c2.hashCode()).replace('-', '_');
    }

    public String c(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("cache size: ");
        stringBuilder.append(this.d.size());
        stringBuilder.append(" - removing ");
        stringBuilder.append(string);
        com.startapp.common.a.g.a("AdCacheManager", 3, stringBuilder.toString());
        return (String)this.d.remove((Object)string);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void c(Context context) {
        Object object;
        3 var2_2 = new 3(this, context);
        Object object2 = object = MetaData.getLock();
        synchronized (object2) {
            if (MetaData.getInstance().isReady()) {
                var2_2.a();
            } else {
                MetaData.getInstance().addMetaDataListener((com.startapp.android.publish.common.metaData.d)var2_2);
            }
            return;
        }
    }

    public List<g> d() {
        a a2 = this;
        synchronized (a2) {
            ArrayList arrayList = new ArrayList(this.a.values());
            return arrayList;
        }
    }

    protected void d(Context context) {
        this.e = false;
        for (a a2 : this.f) {
            if (!this.b(a2.b)) continue;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Loading pending request for: ");
            stringBuilder.append((Object)a2.b);
            com.startapp.common.a.g.a("AdCacheManager", 4, stringBuilder.toString());
            this.a(context, a2.a, a2.b, a2.c, a2.d);
        }
        this.f.clear();
    }

    private class a {
        StartAppAd a;
        AdPreferences.Placement b;
        AdPreferences c;
        AdEventListener d;

        a(StartAppAd startAppAd, AdPreferences.Placement placement, AdPreferences adPreferences, AdEventListener adEventListener) {
            this.a = startAppAd;
            this.b = placement;
            this.c = adPreferences;
            this.d = adEventListener;
        }
    }

}


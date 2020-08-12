/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Handler
 *  android.os.Looper
 *  com.startapp.android.publish.ads.b.c
 *  com.startapp.android.publish.ads.c.b.b
 *  com.startapp.android.publish.adsCommon.e
 *  com.startapp.android.publish.cache.i$4
 *  java.io.File
 *  java.io.Serializable
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Set
 */
package com.startapp.android.publish.cache;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.startapp.android.publish.ads.list3d.f;
import com.startapp.android.publish.adsCommon.Ad;
import com.startapp.android.publish.adsCommon.Utils.i;
import com.startapp.android.publish.adsCommon.adListeners.AdEventListener;
import com.startapp.android.publish.cache.g;
import com.startapp.android.publish.cache.i;
import com.startapp.android.publish.common.model.AdDetails;
import com.startapp.android.publish.common.model.AdPreferences;
import com.startapp.common.g;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class i {
    protected static String a() {
        return "startapp_ads";
    }

    private static void a(Context context, com.startapp.android.publish.ads.b.c c2, String string, AdEventListener adEventListener) {
        com.startapp.android.publish.adsCommon.Utils.i.a(context, string, (i.a)new 4(adEventListener, c2));
    }

    private static void a(Context context, com.startapp.android.publish.ads.b.c c2, String string, a a2, AdEventListener adEventListener) {
        if (string != null && !string.equals((Object)"")) {
            if (!i.a(c2)) {
                com.startapp.common.a.g.a("DiskAdCacheManager", 3, "Missing video file");
                adEventListener.onFailedToReceiveAd(null);
                return;
            }
            if (!i.a(context, string)) {
                com.startapp.common.a.g.a("DiskAdCacheManager", 3, "App is present");
                adEventListener.onFailedToReceiveAd(null);
                return;
            }
            com.startapp.android.publish.cache.a.a().a(string, c2.g());
            a2.a((com.startapp.android.publish.adsCommon.g)c2);
            i.a(context, c2, string, adEventListener);
            return;
        }
        com.startapp.common.a.g.a("DiskAdCacheManager", 3, "Missing Html");
        adEventListener.onFailedToReceiveAd(null);
    }

    private static void a(Context context, com.startapp.android.publish.ads.c.b.b b2, a a2, AdEventListener adEventListener) {
        List<AdDetails> list = b2.d();
        if (list == null) {
            com.startapp.common.a.g.a("DiskAdCacheManager", 4, "No ad details");
            adEventListener.onFailedToReceiveAd(null);
            return;
        }
        if (com.startapp.android.publish.adsCommon.b.a().E()) {
            list = com.startapp.android.publish.adsCommon.b.c.a(context, list, 0, (Set<String>)new HashSet());
        }
        if (list != null && list.size() > 0) {
            a2.a((com.startapp.android.publish.adsCommon.g)b2);
            i.a(b2, adEventListener, list);
            return;
        }
        com.startapp.common.a.g.a("DiskAdCacheManager", 4, "App presence - no interstitials to display");
        adEventListener.onFailedToReceiveAd(null);
    }

    protected static void a(Context context, g g2, String string) {
        d d2 = new d(g2.b());
        com.startapp.common.a.e.b(context, i.c(), string, d2);
    }

    protected static void a(final Context context, final c c2) {
        com.startapp.common.g.a(g.a.b, new Runnable(){

            public void run() {
                try {
                    final List<b> list = com.startapp.common.a.e.b(context, i.b(), b.class);
                    new Handler(Looper.getMainLooper()).post(new Runnable(){

                        public void run() {
                            c2.a((List<b>)list);
                        }
                    });
                    return;
                }
                catch (Exception exception) {
                    com.startapp.android.publish.adsCommon.f.f.a(context, com.startapp.android.publish.adsCommon.f.d.b, " DiskAdCacheManager.loadCacheKeysAsync - Unexpected Thread Exception", exception.getMessage(), "");
                    return;
                }
            }

        });
    }

    protected static void a(Context context, d d2, a a2, AdEventListener adEventListener) {
        com.startapp.android.publish.adsCommon.g g2 = d2.a();
        g2.setContext(context);
        if (com.startapp.android.publish.adsCommon.Utils.i.a(2L) && g2 instanceof com.startapp.android.publish.ads.b.c) {
            i.a(context, (com.startapp.android.publish.ads.b.c)g2, d2.b(), a2, adEventListener);
            return;
        }
        if (com.startapp.android.publish.adsCommon.Utils.i.a(64L) && g2 instanceof com.startapp.android.publish.ads.c.b.b) {
            i.a(context, (com.startapp.android.publish.ads.c.b.b)g2, a2, adEventListener);
            return;
        }
        com.startapp.common.a.g.a("DiskAdCacheManager", 4, "Unsupported disk ad type");
        adEventListener.onFailedToReceiveAd(null);
    }

    protected static void a(final Context context, final e e2) {
        com.startapp.common.g.a(g.a.a, new Runnable(){

            public void run() {
                try {
                    com.startapp.common.a.e.a(context, i.a());
                    new Handler(Looper.getMainLooper()).post(new Runnable(){

                        public void run() {
                            e2.a();
                        }
                    });
                    return;
                }
                catch (Exception exception) {
                    com.startapp.android.publish.adsCommon.f.f.a(context, com.startapp.android.publish.adsCommon.f.d.b, " DiskAdCacheManager.deleteDiskCacheAsync - Unexpected Thread Exception", exception.getMessage(), "");
                    return;
                }
            }

        });
    }

    protected static void a(Context context, AdPreferences.Placement placement, AdPreferences adPreferences, String string, int n2) {
        b b2 = new b(placement, adPreferences);
        b2.a(n2);
        com.startapp.common.a.e.b(context, i.b(), string, b2);
    }

    protected static void a(final Context context, final String string, final a a2, final AdEventListener adEventListener) {
        com.startapp.common.g.a(g.a.b, new Runnable(){

            public void run() {
                try {
                    final d d2 = com.startapp.common.a.e.b(context, i.c(), string, d.class);
                    new Handler(Looper.getMainLooper()).post(new Runnable(){

                        /*
                         * Enabled aggressive block sorting
                         * Enabled unnecessary exception pruning
                         * Enabled aggressive exception aggregation
                         */
                        public void run() {
                            try {
                                d d22 = d2;
                                if (d22 == null) {
                                    StringBuilder stringBuilder = new StringBuilder();
                                    stringBuilder.append("File not found or error: ");
                                    stringBuilder.append(string);
                                    com.startapp.common.a.g.a("DiskAdCacheManager", 4, stringBuilder.toString());
                                    adEventListener.onFailedToReceiveAd(null);
                                    return;
                                }
                                if (d2.a() != null && d2.a().isReady()) {
                                    if (d2.a().hasAdCacheTtlPassed()) {
                                        com.startapp.common.a.g.a("DiskAdCacheManager", 3, "Disk ad TTL has passed");
                                        adEventListener.onFailedToReceiveAd(null);
                                        return;
                                    }
                                    i.a(context, d2, a2, adEventListener);
                                    return;
                                }
                                com.startapp.common.a.g.a("DiskAdCacheManager", 3, "Disk ad is not ready or null");
                                adEventListener.onFailedToReceiveAd(null);
                                return;
                            }
                            catch (Exception exception) {
                                com.startapp.android.publish.adsCommon.f.f.a(context, com.startapp.android.publish.adsCommon.f.d.b, "DiskAdCacheManager.loadCachedAdAsync - Unexpected Thread Exception", exception.getMessage(), "");
                                adEventListener.onFailedToReceiveAd(null);
                                return;
                            }
                        }
                    });
                    return;
                }
                catch (Exception exception) {
                    com.startapp.android.publish.adsCommon.f.f.a(context, com.startapp.android.publish.adsCommon.f.d.b, "DiskAdCacheManager.loadCachedAdAsync - Unexpected Thread Exception", exception.getMessage(), "");
                    adEventListener.onFailedToReceiveAd(null);
                    return;
                }
            }

        });
    }

    private static void a(com.startapp.android.publish.ads.c.b.b b2, AdEventListener adEventListener, List<AdDetails> list) {
        com.startapp.android.publish.ads.list3d.e e2 = f.a().a(b2.a());
        e2.a();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            e2.a((AdDetails)iterator.next());
        }
        adEventListener.onReceiveAd((Ad)b2);
    }

    private static boolean a(Context context, String string) {
        ArrayList arrayList;
        List<com.startapp.android.publish.adsCommon.b.a> list;
        if (com.startapp.android.publish.adsCommon.b.a().E() && (list = com.startapp.android.publish.adsCommon.b.c.a(string, 0)) != null && com.startapp.android.publish.adsCommon.b.c.a(context, list, 0, (Set<String>)new HashSet(), (List<com.startapp.android.publish.adsCommon.b.a>)(arrayList = new ArrayList())).booleanValue()) {
            new com.startapp.android.publish.adsCommon.b.b(context, (List<com.startapp.android.publish.adsCommon.b.a>)arrayList).a();
            return false;
        }
        return true;
    }

    private static boolean a(com.startapp.android.publish.ads.b.c c2) {
        return true;
    }

    protected static String b() {
        return i.a().concat(File.separator).concat("keys");
    }

    protected static String c() {
        return i.a().concat(File.separator).concat("interstitials");
    }

    protected static interface a {
        public void a(com.startapp.android.publish.adsCommon.g var1);
    }

    protected static class b
    implements Serializable {
        private static final long serialVersionUID = 1L;
        protected AdPreferences adPreferences;
        private int numberOfLoadedAd;
        protected AdPreferences.Placement placement;

        protected b(AdPreferences.Placement placement, AdPreferences adPreferences) {
            this.placement = placement;
            this.adPreferences = adPreferences;
        }

        protected AdPreferences.Placement a() {
            return this.placement;
        }

        protected void a(int n2) {
            this.numberOfLoadedAd = n2;
        }

        protected AdPreferences b() {
            return this.adPreferences;
        }

        protected int c() {
            return this.numberOfLoadedAd;
        }
    }

    protected static interface c {
        public void a(List<b> var1);
    }

    protected static class d
    implements Serializable {
        private static final long serialVersionUID = 1L;
        private com.startapp.android.publish.adsCommon.g ad;
        private String html;

        protected d(com.startapp.android.publish.adsCommon.g g2) {
            this.a(g2);
            this.c();
        }

        private void a(com.startapp.android.publish.adsCommon.g g2) {
            this.ad = g2;
        }

        private void c() {
            com.startapp.android.publish.adsCommon.g g2 = this.ad;
            if (g2 != null && g2 instanceof com.startapp.android.publish.adsCommon.e) {
                this.html = ((com.startapp.android.publish.adsCommon.e)g2).f();
            }
        }

        protected com.startapp.android.publish.adsCommon.g a() {
            return this.ad;
        }

        protected String b() {
            return this.html;
        }
    }

    protected static interface e {
        public void a();
    }

}


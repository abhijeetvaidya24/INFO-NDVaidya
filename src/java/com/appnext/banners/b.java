/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.Pair
 *  com.appnext.banners.BannerAdData
 *  com.appnext.banners.MediumRectangleAd
 *  com.appnext.core.AppnextAd
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 */
package com.appnext.banners;

import android.content.Context;
import android.util.Pair;
import com.appnext.banners.BannerAd;
import com.appnext.banners.BannerAdData;
import com.appnext.banners.BannerAdRequest;
import com.appnext.banners.MediumRectangleAd;
import com.appnext.banners.d;
import com.appnext.core.Ad;
import com.appnext.core.AppnextAd;
import com.appnext.core.a;
import com.appnext.core.c;
import com.appnext.core.d;
import com.appnext.core.f;
import com.appnext.core.g;
import com.appnext.core.p;
import java.util.ArrayList;

final class b
extends com.appnext.core.d {
    private static b de;
    private final int aM = 50;

    private b() {
    }

    public static b R() {
        Class<b> class_ = b.class;
        synchronized (b.class) {
            if (de == null) {
                de = new b();
            }
            b b2 = de;
            // ** MonitorExit[var2] (shouldn't be in output)
            return b2;
        }
    }

    /*
     * Exception decompiling
     */
    private static int a(Context var0, BannerAdData var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl39.1 : ICONST_0 : trying to set 0 previously set to 1
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:919)
        throw new IllegalStateException("Decompilation failed");
    }

    private static boolean a(Ad ad, AppnextAd appnextAd, String string2) {
        if (ad instanceof MediumRectangleAd) {
            int n2 = -1;
            int n3 = string2.hashCode();
            if (n3 != -892481938) {
                if (n3 != 96673) {
                    if (n3 == 112202875 && string2.equals((Object)"video")) {
                        n2 = 2;
                    }
                } else if (string2.equals((Object)"all")) {
                    n2 = 0;
                }
            } else if (string2.equals((Object)"static")) {
                n2 = 1;
            }
            if (n2 != 0) {
                if (n2 != 1) {
                    if (n2 != 2) {
                        return false;
                    }
                    return b.hasVideo(appnextAd);
                }
                return b.c(appnextAd);
            }
            if (!b.c(appnextAd)) {
                return b.hasVideo(appnextAd);
            }
        }
        return true;
    }

    static boolean c(AppnextAd appnextAd) {
        return !appnextAd.getWideImageURL().equals((Object)"");
    }

    static boolean hasVideo(AppnextAd appnextAd) {
        return !appnextAd.getVideoUrl().equals((Object)"") || !appnextAd.getVideoUrlHigh().equals((Object)"") || !appnextAd.getVideoUrl30Sec().equals((Object)"") || !appnextAd.getVideoUrlHigh30Sec().equals((Object)"");
        {
        }
    }

    @Override
    protected final int a(Context context, g g2) {
        BannerAdData bannerAdData = new BannerAdData((AppnextAd)g2);
        int n2 = b.a(context, bannerAdData);
        if (n2 != 0) {
            return n2;
        }
        if (bannerAdData.getCampaignGoal().equals((Object)"new") && f.c(context, bannerAdData.getAdPackage())) {
            return 2;
        }
        return bannerAdData.getCampaignGoal().equals((Object)"existing") && !f.c(context, bannerAdData.getAdPackage());
    }

    protected final AppnextAd a(Context context, Ad ad, String string2) {
        if (this.k(ad) == null) {
            return null;
        }
        ArrayList<?> arrayList = this.k(ad).getAds();
        if (arrayList == null) {
            return null;
        }
        return this.a(context, ad, arrayList, string2);
    }

    protected final AppnextAd a(Context context, Ad ad, ArrayList<?> arrayList, String string2) {
        return this.a(context, ad, arrayList, string2, (ArrayList<String>)new ArrayList());
    }

    protected final AppnextAd a(Context context, Ad ad, ArrayList<?> arrayList, String string2, ArrayList<String> arrayList2) {
        if (arrayList == null) {
            return null;
        }
        for (AppnextAd appnextAd : arrayList) {
            boolean bl;
            block15 : {
                block13 : {
                    block14 : {
                        if (!(ad instanceof MediumRectangleAd)) break block13;
                        int n2 = -1;
                        int n3 = string2.hashCode();
                        if (n3 != -892481938) {
                            if (n3 != 96673) {
                                if (n3 == 112202875 && string2.equals((Object)"video")) {
                                    n2 = 2;
                                }
                            } else if (string2.equals((Object)"all")) {
                                n2 = 0;
                            }
                        } else if (string2.equals((Object)"static")) {
                            n2 = 1;
                        }
                        if (n2 == 0) break block14;
                        bl = n2 != 1 ? (n2 != 2 ? false : b.hasVideo(appnextAd)) : b.c(appnextAd);
                        break block15;
                    }
                    if (b.c(appnextAd)) break block13;
                    boolean bl2 = b.hasVideo(appnextAd);
                    bl = false;
                    if (!bl2) break block15;
                }
                bl = true;
            }
            if (!bl || b.a(appnextAd.getBannerID(), ad.getPlacementID()) || arrayList2.contains((Object)appnextAd.getBannerID())) continue;
            return appnextAd;
        }
        return null;
    }

    @Override
    protected final String a(Context context, Ad ad, String string2, ArrayList<Pair<String, String>> arrayList) {
        StringBuilder stringBuilder = new StringBuilder("&auid=");
        String string3 = ad != null ? ad.getAUID() : "1000";
        stringBuilder.append(string3);
        return stringBuilder.toString();
    }

    @Override
    protected final void a(Context context, Ad ad, a a2) throws Exception {
        AppnextAd appnextAd = this.a(context, ad, ((BannerAdRequest)((BannerAd)ad).getAdRequest()).getCreativeType());
        if (appnextAd != null) {
            f.Z(appnextAd.getImageURL());
            if (ad instanceof MediumRectangleAd) {
                f.Z(appnextAd.getWideImageURL());
            }
            return;
        }
        throw new Exception("No Ads");
    }

    public final void a(Context context, Ad ad, String string2, d.a a2, BannerAdRequest bannerAdRequest) {
        ((BannerAd)ad).setAdRequest(new BannerAdRequest(bannerAdRequest));
        super.a(context, ad, string2, a2);
    }

    @Override
    protected final void a(Ad ad, String string2, String string3) {
        new StringBuilder("error ").append(string2);
    }

    @Override
    protected final <T> void a(String string2, Ad ad, T t2) {
    }

    @Override
    protected final boolean a(Context context, Ad ad, ArrayList<?> arrayList) {
        return this.a(context, ad, arrayList, ((BannerAdRequest)((BannerAd)ad).getAdRequest()).getCreativeType()) != null;
    }

    @Override
    protected final p c(Ad ad) {
        return d.S();
    }

    public final ArrayList<AppnextAd> f(Ad ad) {
        return this.k(ad).getAds();
    }
}


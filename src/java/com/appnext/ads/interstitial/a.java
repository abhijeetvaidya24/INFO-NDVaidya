/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.Pair
 *  com.appnext.ads.interstitial.InterstitialAd
 *  com.appnext.core.AppnextAd
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.ArrayList
 *  java.util.HashMap
 */
package com.appnext.ads.interstitial;

import android.content.Context;
import android.util.Pair;
import com.appnext.ads.interstitial.Interstitial;
import com.appnext.ads.interstitial.InterstitialAd;
import com.appnext.ads.interstitial.c;
import com.appnext.core.Ad;
import com.appnext.core.AppnextAd;
import com.appnext.core.b;
import com.appnext.core.d;
import com.appnext.core.f;
import com.appnext.core.g;
import com.appnext.core.p;
import com.appnext.core.webview.AppnextWebView;
import java.util.ArrayList;
import java.util.HashMap;

public final class a
extends d {
    private static final int aM = 30;
    private static a cl;
    private String bT;

    private a() {
    }

    public static a G() {
        Class<a> class_ = a.class;
        synchronized (a.class) {
            if (cl == null) {
                cl = new a();
            }
            a a2 = cl;
            // ** MonitorExit[var2] (shouldn't be in output)
            return a2;
        }
    }

    private static int a(Context context, AppnextAd appnextAd) {
        InterstitialAd interstitialAd = new InterstitialAd(appnextAd);
        if (interstitialAd.getCampaignGoal().equals((Object)"new") && f.c(context, interstitialAd.getAdPackage())) {
            return 1;
        }
        if (interstitialAd.getCampaignGoal().equals((Object)"existing") && !f.c(context, interstitialAd.getAdPackage())) {
            return 2;
        }
        return 0;
    }

    private static ArrayList<AppnextAd> a(ArrayList<AppnextAd> arrayList, AppnextAd appnextAd) {
        arrayList.remove((Object)appnextAd);
        arrayList.add(0, (Object)appnextAd);
        return arrayList;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean a(AppnextAd appnextAd, String string2, Ad ad) {
        int n2;
        int n3 = string2.hashCode();
        if (n3 != -892481938) {
            if (n3 != 112202875) {
                if (n3 != 835260319) return false;
                if (!string2.equals((Object)"managed")) return false;
                n2 = 0;
            } else {
                if (!string2.equals((Object)"video")) return false;
                n2 = 1;
            }
        } else {
            if (!string2.equals((Object)"static")) return false;
            n2 = 2;
        }
        if (n2 != 0) {
            if (n2 != 1) {
                if (n2 != 2) {
                    return false;
                }
                if (!a.c(appnextAd)) return false;
                if (a.a(appnextAd.getBannerID(), ad.getPlacementID())) return false;
                return true;
            }
            if (!a.hasVideo(appnextAd)) return false;
            if (a.a(appnextAd.getBannerID(), ad.getPlacementID())) return false;
            return true;
        }
        if (!a.c(appnextAd)) {
            if (!a.hasVideo(appnextAd)) return false;
        }
        if (a.a(appnextAd.getBannerID(), ad.getPlacementID())) return false;
        return true;
    }

    /*
     * Exception decompiling
     */
    private static int b(Context var0, AppnextAd var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl44.1 : ICONST_0 : trying to set 0 previously set to 1
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

    private static boolean c(AppnextAd appnextAd) {
        return !appnextAd.getWideImageURL().equals((Object)"");
    }

    private static boolean hasVideo(AppnextAd appnextAd) {
        return !appnextAd.getVideoUrl().equals((Object)"") || !appnextAd.getVideoUrlHigh().equals((Object)"") || !appnextAd.getVideoUrl30Sec().equals((Object)"") || !appnextAd.getVideoUrlHigh30Sec().equals((Object)"");
        {
        }
    }

    @Override
    protected final int a(Context context, g g2) {
        AppnextAd appnextAd = (AppnextAd)g2;
        InterstitialAd interstitialAd = new InterstitialAd(appnextAd);
        int n2 = interstitialAd.getCampaignGoal().equals((Object)"new") && f.c(context, interstitialAd.getAdPackage()) ? 1 : (interstitialAd.getCampaignGoal().equals((Object)"existing") && !f.c(context, interstitialAd.getAdPackage()) ? 2 : 0);
        int n3 = a.b(context, appnextAd);
        if (n2 == 0 && n3 == 0) {
            return 0;
        }
        if (n2 != 0) {
            return n2;
        }
        return n3;
    }

    protected final AppnextAd a(Context context, ArrayList<AppnextAd> arrayList, String string2, Ad ad) {
        for (AppnextAd appnextAd : arrayList) {
            if (!this.a(appnextAd, string2, ad)) continue;
            return appnextAd;
        }
        return null;
    }

    @Override
    protected final String a(Context context, Ad ad, String string2, ArrayList<Pair<String, String>> arrayList) {
        StringBuilder stringBuilder = new StringBuilder("&auid=");
        String string3 = ad != null ? ad.getAUID() : "600";
        stringBuilder.append(string3);
        stringBuilder.append("&vidmin=");
        String string4 = "";
        String string5 = ad == null ? string4 : Integer.valueOf((int)ad.getMinVideoLength());
        stringBuilder.append((Object)string5);
        stringBuilder.append("&vidmax=");
        String string6 = ad == null ? string4 : Integer.valueOf((int)ad.getMaxVideoLength());
        stringBuilder.append((Object)string6);
        if (this.bT.equals((Object)"static")) {
            string4 = "&creative=0";
        }
        stringBuilder.append(string4);
        return stringBuilder.toString();
    }

    @Override
    protected final String a(ArrayList<AppnextAd> arrayList) {
        return super.a(arrayList);
    }

    @Override
    protected final void a(Context context, Ad ad, com.appnext.core.a a2) throws Exception {
        AppnextWebView.u(context).a(((Interstitial)ad).getPageUrl(), null);
        if (a2 != null && a2.getAds() != null && a2.getAds().size() > 0) {
            f.Z(((AppnextAd)a2.getAds().get(0)).getImageURL());
        }
    }

    public final void a(Context context, Ad ad, String string2, d.a a2, String string3) {
        this.bT = string3;
        super.a(context, ad, string2, a2);
    }

    @Override
    protected final void a(Ad ad, String string2, String string3) {
        new StringBuilder("error ").append(string2);
    }

    @Override
    protected final void a(String string2, Ad ad) {
        super.a(string2, ad);
    }

    @Override
    protected final <T> void a(String string2, Ad ad, T t2) {
    }

    @Override
    protected final boolean a(Context context, Ad ad, ArrayList<?> arrayList) {
        return this.a(context, arrayList, ((Interstitial)ad).getCreativeType(), ad) != null;
    }

    protected final ArrayList<AppnextAd> b(Context context, Ad ad, String string2) {
        if (this.k(ad) == null) {
            return null;
        }
        ArrayList<?> arrayList = this.k(ad).getAds();
        if (arrayList == null) {
            return null;
        }
        AppnextAd appnextAd = this.a(context, arrayList, string2, ad);
        if (appnextAd == null) {
            return null;
        }
        arrayList.remove((Object)appnextAd);
        arrayList.add(0, (Object)appnextAd);
        return arrayList;
    }

    @Override
    protected final p c(Ad ad) {
        return c.K();
    }

    protected final boolean d(Ad ad) {
        return this.h(ad) && this.k(ad).getAds() != null && this.k(ad).getAds().size() > 0 && 300000L + this.k(ad).aS() > System.currentTimeMillis();
    }

    protected final void g(Ad ad) {
        if (ad != null && this.j(ad) == 0L) {
            this.aU().remove((Object)new b(ad));
        }
    }
}


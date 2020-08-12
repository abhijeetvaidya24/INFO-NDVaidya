/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.Pair
 *  com.appnext.ads.fullscreen.FullscreenAd
 *  com.appnext.ads.fullscreen.RewardedVideo
 *  com.appnext.core.AppnextAd
 *  java.io.BufferedInputStream
 *  java.io.File
 *  java.io.FileOutputStream
 *  java.io.InputStream
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.net.URL
 *  java.net.URLConnection
 *  java.util.ArrayList
 *  java.util.HashMap
 */
package com.appnext.ads.fullscreen;

import android.content.Context;
import android.util.Pair;
import com.appnext.ads.fullscreen.FullscreenAd;
import com.appnext.ads.fullscreen.RewardedVideo;
import com.appnext.ads.fullscreen.Video;
import com.appnext.ads.fullscreen.c;
import com.appnext.ads.fullscreen.f;
import com.appnext.core.Ad;
import com.appnext.core.AppnextAd;
import com.appnext.core.a;
import com.appnext.core.d;
import com.appnext.core.g;
import com.appnext.core.p;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;

public final class b
extends d {
    private static b aL;
    private final int aM = 30;
    private HashMap<Ad, String> aN = new HashMap();

    private b() {
    }

    private static int a(Context context, AppnextAd appnextAd) {
        FullscreenAd fullscreenAd = new FullscreenAd(appnextAd);
        if (fullscreenAd.getCampaignGoal().equals((Object)"new") && com.appnext.core.f.c(context, fullscreenAd.getAdPackage())) {
            return 1;
        }
        if (fullscreenAd.getCampaignGoal().equals((Object)"existing") && !com.appnext.core.f.c(context, fullscreenAd.getAdPackage())) {
            return 2;
        }
        return 0;
    }

    /*
     * Exception decompiling
     */
    private void a(Context var1, Ad var2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl69.1 : RETURN : trying to set 1 previously set to 0
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

    private void a(Context context, Ad ad, AppnextAd appnextAd) throws Exception {
        int n2;
        String string2;
        if (!appnextAd.getImageURL().equals((Object)"")) {
            com.appnext.core.f.Z(appnextAd.getImageURL());
        }
        if (!appnextAd.getWideImageURL().equals((Object)"")) {
            com.appnext.core.f.Z(appnextAd.getWideImageURL());
        }
        Video video = (Video)ad;
        String string3 = b.getVideoUrl(appnextAd, video.getVideoLength());
        String string4 = b.c(string3);
        if (Video.getCacheVideo()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(context.getFilesDir().getAbsolutePath());
            stringBuilder.append("/data/appnext/videos/");
            string2 = stringBuilder.toString();
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(context.getFilesDir().getAbsolutePath());
            stringBuilder.append("/data/appnext/videos/");
            stringBuilder.append("tmp/vid");
            stringBuilder.append(video.rnd);
            stringBuilder.append("/");
            string2 = stringBuilder.toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(string4);
        File file = new File(stringBuilder.toString());
        if (file.exists()) {
            file.setLastModified(System.currentTimeMillis());
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(file.getPath());
            stringBuilder2.append(" exists");
            this.aN.put((Object)ad, (Object)file.getAbsolutePath());
            return;
        }
        if (Video.isStreamingModeEnabled()) {
            return;
        }
        new File(string2).mkdirs();
        URL uRL = new URL(string3);
        uRL.openConnection().connect();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(uRL.openStream(), 1024);
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(string2);
        stringBuilder3.append(string4);
        stringBuilder3.append(".tmp");
        FileOutputStream fileOutputStream = new FileOutputStream(stringBuilder3.toString());
        byte[] arrby = new byte[1024];
        while ((n2 = bufferedInputStream.read(arrby)) != -1) {
            fileOutputStream.write(arrby, 0, n2);
        }
        StringBuilder stringBuilder4 = new StringBuilder("downloaded ");
        stringBuilder4.append(string2);
        stringBuilder4.append(string4);
        fileOutputStream.flush();
        fileOutputStream.close();
        bufferedInputStream.close();
        StringBuilder stringBuilder5 = new StringBuilder();
        stringBuilder5.append(string2);
        stringBuilder5.append(string4);
        stringBuilder5.append(".tmp");
        File file2 = new File(stringBuilder5.toString());
        StringBuilder stringBuilder6 = new StringBuilder();
        stringBuilder6.append(string2);
        stringBuilder6.append(string4);
        file2.renameTo(new File(stringBuilder6.toString()));
        file2.delete();
        this.aN.put((Object)ad, (Object)file.getAbsolutePath());
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

    private static boolean b(AppnextAd appnextAd) {
        return !appnextAd.getVideoUrlHigh().equals((Object)"") || !appnextAd.getVideoUrlHigh30Sec().equals((Object)"");
        {
        }
    }

    /*
     * Exception decompiling
     */
    protected static String c(String var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Underrun type stack
        // org.benf.cfr.reader.b.a.c.e.a(StackSim.java:35)
        // org.benf.cfr.reader.b.b.af.a(OperationFactoryPop.java:20)
        // org.benf.cfr.reader.b.b.e.a(JVMInstr.java:315)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:195)
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

    private boolean e(Ad ad) {
        if (Video.isStreamingModeEnabled()) {
            return true;
        }
        if (!this.aN.containsKey((Object)ad)) {
            return false;
        }
        return new File((String)this.aN.get((Object)ad)).exists();
    }

    protected static String getVideoUrl(AppnextAd appnextAd, String string2) {
        String string3;
        if (string2.equals((Object)"30")) {
            string3 = appnextAd.getVideoUrlHigh30Sec();
            if (string3.equals((Object)"")) {
                string3 = appnextAd.getVideoUrlHigh();
            }
        } else {
            string3 = appnextAd.getVideoUrlHigh();
            if (string3.equals((Object)"")) {
                string3 = appnextAd.getVideoUrlHigh30Sec();
            }
        }
        StringBuilder stringBuilder = new StringBuilder("returning video url for: ");
        stringBuilder.append(appnextAd.getBannerID());
        stringBuilder.append(" with len: ");
        stringBuilder.append(string2);
        stringBuilder.append(" url: ");
        stringBuilder.append(string3);
        return string3;
    }

    public static b j() {
        Class<b> class_ = b.class;
        synchronized (b.class) {
            if (aL == null) {
                aL = new b();
            }
            b b2 = aL;
            // ** MonitorExit[var2] (shouldn't be in output)
            return b2;
        }
    }

    @Override
    protected final int a(Context context, g g2) {
        AppnextAd appnextAd = (AppnextAd)g2;
        FullscreenAd fullscreenAd = new FullscreenAd(appnextAd);
        int n2 = fullscreenAd.getCampaignGoal().equals((Object)"new") && com.appnext.core.f.c(context, fullscreenAd.getAdPackage()) ? 1 : (fullscreenAd.getCampaignGoal().equals((Object)"existing") && !com.appnext.core.f.c(context, fullscreenAd.getAdPackage()) ? 2 : 0);
        int n3 = b.b(context, appnextAd);
        if (n2 == 0 && n3 == 0) {
            return 0;
        }
        if (n2 != 0) {
            return n2;
        }
        return n3;
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

    protected final AppnextAd a(Context context, Ad ad, ArrayList<AppnextAd> arrayList, String string2) {
        for (AppnextAd appnextAd : arrayList) {
            if (!b.b(appnextAd) || b.a(appnextAd.getBannerID(), ad.getPlacementID()) || appnextAd.getBannerID().equals((Object)string2)) continue;
            return appnextAd;
        }
        return null;
    }

    @Override
    protected final String a(Context context, Ad ad, String string2, ArrayList<Pair<String, String>> arrayList) {
        StringBuilder stringBuilder = new StringBuilder("&auid=");
        String string3 = ad != null ? ad.getAUID() : "700";
        stringBuilder.append(string3);
        stringBuilder.append("&vidmin=");
        String string4 = "";
        String string5 = ad == null ? string4 : Integer.valueOf((int)ad.getMinVideoLength());
        stringBuilder.append((Object)string5);
        stringBuilder.append("&vidmax=");
        if (ad != null) {
            string4 = Integer.valueOf((int)ad.getMaxVideoLength());
        }
        stringBuilder.append((Object)string4);
        return stringBuilder.toString();
    }

    /*
     * Exception decompiling
     */
    @Override
    protected final void a(Context var1, Ad var2, a var3) throws Exception {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl69.1 : ACONST_NULL : trying to set 1 previously set to 0
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

    @Override
    protected final void a(Ad ad, String string2, String string3) {
        if (ad != null) {
            com.appnext.core.f.a(ad.getTID(), ad.getVID(), ad.getAUID(), string3, string2, "caching_error", "sdk", "", "");
        } else {
            com.appnext.core.f.a("300", "2.5.0.472", "700", string3, string2, "caching_error", "sdk", "", "");
        }
        new StringBuilder("error ").append(string2);
    }

    @Override
    protected final void a(String string2, Ad ad) {
        super.a(string2, ad);
        if (this.aN.containsKey((Object)ad)) {
            this.aN.remove((Object)ad);
        }
    }

    @Override
    protected final <T> void a(String string2, Ad ad, T t2) {
        com.appnext.core.f.a(ad.getTID(), ad.getVID(), ad.getAUID(), string2, ((Video)ad).getSessionId(), "cache_ready", "sdk", "", "");
    }

    @Override
    protected final boolean a(Context context, Ad ad, ArrayList<?> arrayList) {
        return this.a(context, ad, arrayList, "") != null;
    }

    @Override
    protected final boolean a(Ad ad) {
        return super.a(ad) && this.e(ad);
    }

    protected final AppnextAd b(Context context, Ad ad) {
        return this.a(context, ad, "");
    }

    /*
     * Exception decompiling
     */
    protected final boolean b(Ad var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl27.1 : ICONST_0 : trying to set 1 previously set to 0
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

    @Override
    protected final p c(Ad ad) {
        if (ad instanceof RewardedVideo) {
            return f.q();
        }
        return c.m();
    }

    /*
     * Exception decompiling
     */
    protected final boolean d(Ad var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl13.1 : ICONST_0 : trying to set 1 previously set to 0
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

    protected final ArrayList<AppnextAd> f(Ad ad) {
        return this.k(ad).getAds();
    }
}


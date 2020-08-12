/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.applovin.impl.mediation.a.a
 *  com.applovin.impl.mediation.e
 *  com.applovin.impl.sdk.b.a
 *  com.applovin.impl.sdk.b.b
 *  com.applovin.impl.sdk.d.q
 *  com.applovin.impl.sdk.d.q$a
 *  com.applovin.impl.sdk.j
 *  com.applovin.mediation.MaxAd
 *  com.applovin.mediation.MaxAdFormat
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 *  java.util.Set
 */
package com.applovin.impl.mediation.c;

import com.applovin.impl.mediation.e;
import com.applovin.impl.sdk.b.b;
import com.applovin.impl.sdk.d.q;
import com.applovin.impl.sdk.j;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class c {
    private static final List<String> a = new ArrayList();

    static {
        a.add((Object)"com.applovin.mediation.adapters.AdColonyMediationAdapter");
        a.add((Object)"com.applovin.mediation.adapters.AmazonMediationAdapter");
        a.add((Object)"com.applovin.mediation.adapters.AppLovinMediationAdapter");
        a.add((Object)"com.applovin.mediation.adapters.ChartboostMediationAdapter");
        a.add((Object)"com.applovin.mediation.adapters.DuAdMediationAdapter");
        a.add((Object)"com.applovin.mediation.adapters.FacebookMediationAdapter");
        a.add((Object)"com.applovin.mediation.adapters.FlurryMediationAdapter");
        a.add((Object)"com.applovin.mediation.adapters.GoogleMediationAdapter");
        a.add((Object)"com.applovin.mediation.adapters.InMobiMediationAdapter");
        a.add((Object)"com.applovin.mediation.adapters.InneractiveMediationAdapter");
        a.add((Object)"com.applovin.mediation.adapters.IronSourceMediationAdapter");
        a.add((Object)"com.applovin.mediation.adapters.MiaoMediationAdapter");
        a.add((Object)"com.applovin.mediation.adapters.MillennialMediaMediationAdapter");
        a.add((Object)"com.applovin.mediation.adapters.MintegralMediationAdapter");
        a.add((Object)"com.applovin.mediation.adapters.MoPubMediationAdapter");
        a.add((Object)"com.applovin.mediation.adapters.MyTargetMediationAdapter");
        a.add((Object)"com.applovin.mediation.adapters.NendMediationAdapter");
        a.add((Object)"com.applovin.mediation.adapters.OguryMediationAdapter");
        a.add((Object)"com.applovin.mediation.adapters.TapjoyMediationAdapter");
        a.add((Object)"com.applovin.mediation.adapters.UnityAdsMediationAdapter");
        a.add((Object)"com.applovin.mediation.adapters.VungleMediationAdapter");
        a.add((Object)"com.applovin.mediation.adapters.YandexMediationAdapter");
    }

    /*
     * Exception decompiling
     */
    public static a a() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl16 : ALOAD_2 : trying to set 1 previously set to 0
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

    public static q.a a(MaxAdFormat maxAdFormat, q.a a2, j j2) {
        if (((Boolean)j2.a(com.applovin.impl.sdk.b.a.N)).booleanValue()) {
            if (maxAdFormat != MaxAdFormat.BANNER && maxAdFormat != MaxAdFormat.LEADER) {
                if (maxAdFormat == MaxAdFormat.INTERSTITIAL) {
                    return q.a.o;
                }
                if (maxAdFormat == MaxAdFormat.REWARDED) {
                    return q.a.p;
                }
            } else {
                return q.a.n;
            }
        }
        return a2;
    }

    public static q.a a(MaxAdFormat maxAdFormat, j j2) {
        return c.a(maxAdFormat, q.a.i, j2);
    }

    public static MaxAd a(MaxAd maxAd) {
        if (maxAd instanceof e) {
            maxAd = ((e)maxAd).a();
        }
        return maxAd;
    }

    public static class a {
        private final Set<String> a;
        private final Set<String> b;

        private a(Set<String> set, Set<String> set2) {
            this.a = set;
            this.b = set2;
        }

        public Set<String> a() {
            return this.a;
        }

        public Set<String> b() {
            return this.b;
        }
    }

}


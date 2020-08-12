/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.amazon.device.ads.MobileAdsLogger
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  org.json.JSONArray
 */
package com.amazon.device.ads;

import com.amazon.device.ads.MobileAdsLogger;
import com.amazon.device.ads.MobileAdsLoggerFactory;
import org.json.JSONArray;

public class AdProperties {
    public static final int CAN_EXPAND1 = 1003;
    public static final int CAN_EXPAND2 = 1004;
    public static final int CAN_PLAY_AUDIO1 = 1001;
    public static final int CAN_PLAY_AUDIO2 = 1002;
    public static final int CAN_PLAY_VIDEO = 1014;
    public static final int HTML = 1007;
    public static final int INTERSTITIAL = 1008;
    private static final String LOGTAG = "AdProperties";
    public static final int MRAID1 = 1016;
    public static final int MRAID2 = 1017;
    public static final int REQUIRES_TRANSPARENCY = 1031;
    public static final int VIDEO_INTERSTITIAL = 1030;
    private AdType adType_;
    private boolean canExpand_;
    private boolean canPlayAudio_;
    private boolean canPlayVideo_;
    private final MobileAdsLogger logger;

    AdProperties(JSONArray jSONArray) {
        this(jSONArray, new MobileAdsLoggerFactory());
    }

    /*
     * Exception decompiling
     */
    AdProperties(JSONArray var1_1, MobileAdsLoggerFactory var2_2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Extractable last case doesn't follow previous
        // org.benf.cfr.reader.b.a.a.b.as.a(SwitchReplacer.java:478)
        // org.benf.cfr.reader.b.a.a.b.as.a(SwitchReplacer.java:328)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:462)
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

    public boolean canExpand() {
        return this.canExpand_;
    }

    public boolean canPlayAudio() {
        return this.canPlayAudio_;
    }

    public boolean canPlayVideo() {
        return this.canPlayVideo_;
    }

    public AdType getAdType() {
        return this.adType_;
    }

    void setAdType(AdType adType) {
        this.adType_ = adType;
    }

    void setCanExpand(boolean bl) {
        this.canExpand_ = bl;
    }

    void setCanPlayAudio(boolean bl) {
        this.canPlayAudio_ = bl;
    }

    void setCanPlayVideo(boolean bl) {
        this.canPlayVideo_ = bl;
    }

    public static final class AdType
    extends Enum<AdType> {
        private static final /* synthetic */ AdType[] $VALUES;
        public static final /* enum */ AdType IMAGE_BANNER = new AdType("Image Banner");
        public static final /* enum */ AdType INTERSTITIAL;
        public static final /* enum */ AdType MODELESS_INTERSTITIAL;
        public static final /* enum */ AdType MRAID_1;
        public static final /* enum */ AdType MRAID_2;
        private final String adTypeMetricTag;
        private final String type;

        static {
            MRAID_1 = new AdType("MRAID 1.0");
            MRAID_2 = new AdType("MRAID 2.0");
            INTERSTITIAL = new AdType("Interstitial", "i");
            MODELESS_INTERSTITIAL = new AdType("Modeless Interstitial", "mi");
            AdType[] arradType = new AdType[]{IMAGE_BANNER, MRAID_1, MRAID_2, INTERSTITIAL, MODELESS_INTERSTITIAL};
            $VALUES = arradType;
        }

        private AdType(String string2) {
            this(string2, null);
        }

        private AdType(String string2, String string3) {
            this.type = string2;
            this.adTypeMetricTag = string3;
        }

        public static AdType valueOf(String string) {
            return (AdType)Enum.valueOf(AdType.class, (String)string);
        }

        public static AdType[] values() {
            return (AdType[])$VALUES.clone();
        }

        String getAdTypeMetricTag() {
            return this.adTypeMetricTag;
        }

        public String toString() {
            return this.type;
        }
    }

}


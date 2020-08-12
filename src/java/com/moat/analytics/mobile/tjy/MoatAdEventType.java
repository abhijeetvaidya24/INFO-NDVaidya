/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.moat.analytics.mobile.tjy;

public final class MoatAdEventType
extends Enum {
    public static final /* enum */ MoatAdEventType AD_EVT_COMPLETE;
    public static final /* enum */ MoatAdEventType AD_EVT_ENTER_FULLSCREEN;
    public static final /* enum */ MoatAdEventType AD_EVT_EXIT_FULLSCREEN;
    public static final /* enum */ MoatAdEventType AD_EVT_FIRST_QUARTILE;
    public static final /* enum */ MoatAdEventType AD_EVT_MID_POINT;
    public static final /* enum */ MoatAdEventType AD_EVT_PAUSED;
    public static final /* enum */ MoatAdEventType AD_EVT_PLAYING;
    public static final /* enum */ MoatAdEventType AD_EVT_SKIPPED;
    public static final /* enum */ MoatAdEventType AD_EVT_START;
    public static final /* enum */ MoatAdEventType AD_EVT_STOPPED;
    public static final /* enum */ MoatAdEventType AD_EVT_THIRD_QUARTILE;
    public static final /* enum */ MoatAdEventType AD_EVT_VOLUME_CHANGE;
    private static final /* synthetic */ MoatAdEventType[] b;
    private final String a;

    static {
        AD_EVT_FIRST_QUARTILE = new MoatAdEventType("AD_EVT_FIRST_QUARTILE", 0, "AdVideoFirstQuartile");
        AD_EVT_MID_POINT = new MoatAdEventType("AD_EVT_MID_POINT", 1, "AdVideoMidpoint");
        AD_EVT_THIRD_QUARTILE = new MoatAdEventType("AD_EVT_THIRD_QUARTILE", 2, "AdVideoThirdQuartile");
        AD_EVT_COMPLETE = new MoatAdEventType("AD_EVT_COMPLETE", 3, "AdVideoComplete");
        AD_EVT_PAUSED = new MoatAdEventType("AD_EVT_PAUSED", 4, "AdPaused");
        AD_EVT_PLAYING = new MoatAdEventType("AD_EVT_PLAYING", 5, "AdPlaying");
        AD_EVT_START = new MoatAdEventType("AD_EVT_START", 6, "AdVideoStart");
        AD_EVT_STOPPED = new MoatAdEventType("AD_EVT_STOPPED", 7, "AdStopped");
        AD_EVT_SKIPPED = new MoatAdEventType("AD_EVT_SKIPPED", 8, "AdSkipped");
        AD_EVT_VOLUME_CHANGE = new MoatAdEventType("AD_EVT_VOLUME_CHANGE", 9, "AdVolumeChange");
        AD_EVT_ENTER_FULLSCREEN = new MoatAdEventType("AD_EVT_ENTER_FULLSCREEN", 10, "fullScreen");
        AD_EVT_EXIT_FULLSCREEN = new MoatAdEventType("AD_EVT_EXIT_FULLSCREEN", 11, "exitFullscreen");
        MoatAdEventType[] arrmoatAdEventType = new MoatAdEventType[]{AD_EVT_FIRST_QUARTILE, AD_EVT_MID_POINT, AD_EVT_THIRD_QUARTILE, AD_EVT_COMPLETE, AD_EVT_PAUSED, AD_EVT_PLAYING, AD_EVT_START, AD_EVT_STOPPED, AD_EVT_SKIPPED, AD_EVT_VOLUME_CHANGE, AD_EVT_ENTER_FULLSCREEN, AD_EVT_EXIT_FULLSCREEN};
        b = arrmoatAdEventType;
    }

    /*
     * Exception decompiling
     */
    private MoatAdEventType() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // java.lang.IllegalStateException
        // org.benf.cfr.reader.b.a.f.g.a(VariableFactory.java:53)
        // org.benf.cfr.reader.b.a.a.g.b(Op02WithProcessedDataAndRefs.java:911)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:959)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:56)
        // org.benf.cfr.reader.b.a.a.g$3.a(Op02WithProcessedDataAndRefs.java:2010)
        // org.benf.cfr.reader.b.a.a.g$3.a(Op02WithProcessedDataAndRefs.java:2007)
        // org.benf.cfr.reader.util.d.a.d(AbstractGraphVisitorFI.java:60)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:2019)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:340)
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

    public static MoatAdEventType fromString(String string2) {
        if (string2 != null) {
            for (MoatAdEventType moatAdEventType : MoatAdEventType.values()) {
                if (!string2.equalsIgnoreCase(moatAdEventType.toString())) continue;
                return moatAdEventType;
            }
        }
        return null;
    }

    public static MoatAdEventType valueOf(String string2) {
        return (MoatAdEventType)Enum.valueOf(MoatAdEventType.class, (String)string2);
    }

    public static MoatAdEventType[] values() {
        return (MoatAdEventType[])b.clone();
    }

    public final String toString() {
        return this.a;
    }
}


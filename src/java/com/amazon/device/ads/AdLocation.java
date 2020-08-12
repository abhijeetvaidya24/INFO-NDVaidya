/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.location.Location
 *  com.amazon.device.ads.MobileAdsLogger
 *  java.lang.Double
 *  java.lang.Enum
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 */
package com.amazon.device.ads;

import android.content.Context;
import android.location.Location;
import com.amazon.device.ads.Configuration;
import com.amazon.device.ads.MobileAdsLogger;
import com.amazon.device.ads.MobileAdsLoggerFactory;

class AdLocation {
    private static final int ARCMINUTE_PRECISION = 6;
    private static final String LOGTAG = "AdLocation";
    private static final float MAX_DISTANCE_IN_KILOMETERS = 3.0f;
    private final Configuration configuration;
    private final Context context;
    private final MobileAdsLogger logger = new MobileAdsLoggerFactory().createMobileAdsLogger(LOGTAG);

    public AdLocation(Context context) {
        this(context, Configuration.getInstance());
    }

    AdLocation(Context context, Configuration configuration) {
        this.context = context;
        this.configuration = configuration;
    }

    private LocationAwareness getLocationAwareness() {
        if (this.configuration.getBoolean(Configuration.ConfigOption.TRUNCATE_LAT_LON)) {
            return LocationAwareness.LOCATION_AWARENESS_TRUNCATED;
        }
        return LocationAwareness.LOCATION_AWARENESS_NORMAL;
    }

    private static double roundToArcminutes(double d2) {
        double d3 = Math.round((double)(d2 * 60.0));
        Double.isNaN((double)d3);
        return d3 / 60.0;
    }

    /*
     * Exception decompiling
     */
    public Location getLocation() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl48 : ALOAD_3 : trying to set 1 previously set to 0
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

    private static final class LocationAwareness
    extends Enum<LocationAwareness> {
        private static final /* synthetic */ LocationAwareness[] $VALUES;
        public static final /* enum */ LocationAwareness LOCATION_AWARENESS_DISABLED;
        public static final /* enum */ LocationAwareness LOCATION_AWARENESS_NORMAL;
        public static final /* enum */ LocationAwareness LOCATION_AWARENESS_TRUNCATED;

        static {
            LOCATION_AWARENESS_NORMAL = new LocationAwareness();
            LOCATION_AWARENESS_TRUNCATED = new LocationAwareness();
            LOCATION_AWARENESS_DISABLED = new LocationAwareness();
            LocationAwareness[] arrlocationAwareness = new LocationAwareness[]{LOCATION_AWARENESS_NORMAL, LOCATION_AWARENESS_TRUNCATED, LOCATION_AWARENESS_DISABLED};
            $VALUES = arrlocationAwareness;
        }

        public static LocationAwareness valueOf(String string) {
            return (LocationAwareness)Enum.valueOf(LocationAwareness.class, (String)string);
        }

        public static LocationAwareness[] values() {
            return (LocationAwareness[])$VALUES.clone();
        }
    }

}


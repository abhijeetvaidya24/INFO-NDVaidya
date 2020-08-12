/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.amazon.device.ads.AdvertisingIdentifierAAXParameter
 *  com.amazon.device.ads.DirectedIdAAXParameter
 *  com.amazon.device.ads.MobileAdsLogger
 *  com.amazon.device.ads.SHA1UDIDAAXParameter
 *  com.amazon.device.ads.SISDeviceIdentifierAAXParameter
 *  java.lang.Object
 *  java.lang.String
 *  org.json.JSONObject
 */
package com.amazon.device.ads;

import com.amazon.device.ads.AAXParameter;
import com.amazon.device.ads.AdvertisingIdentifierAAXParameter;
import com.amazon.device.ads.DebugProperties;
import com.amazon.device.ads.DirectedIdAAXParameter;
import com.amazon.device.ads.MobileAdsLogger;
import com.amazon.device.ads.MobileAdsLoggerFactory;
import com.amazon.device.ads.SHA1UDIDAAXParameter;
import com.amazon.device.ads.SISDeviceIdentifierAAXParameter;
import org.json.JSONObject;

abstract class AAXParameterGroupParameter {
    static final AdvertisingIdentifierAAXParameter ADVERTISING_IDENTIFIER = new AdvertisingIdentifierAAXParameter();
    static final DirectedIdAAXParameter DIRECTED_ID;
    private static final String LOG_TAG = "AAXParameterGroupParameter";
    static final SHA1UDIDAAXParameter SHA1_UDID;
    static final SISDeviceIdentifierAAXParameter SIS_DEVICE_IDENTIFIER;
    private final String debugName;
    protected final DebugProperties debugProperties;
    private final String key;
    private final MobileAdsLogger logger;

    static {
        SIS_DEVICE_IDENTIFIER = new SISDeviceIdentifierAAXParameter();
        SHA1_UDID = new SHA1UDIDAAXParameter();
        DIRECTED_ID = new DirectedIdAAXParameter();
    }

    AAXParameterGroupParameter(DebugProperties debugProperties, String string, String string2, MobileAdsLoggerFactory mobileAdsLoggerFactory) {
        this.debugProperties = debugProperties;
        this.key = string;
        this.debugName = string2;
        this.logger = mobileAdsLoggerFactory.createMobileAdsLogger(LOG_TAG);
    }

    boolean evaluate(AAXParameter.ParameterData parameterData, JSONObject jSONObject) {
        String string = this.debugProperties.getDebugPropertyAsString(this.debugName, this.getDerivedValue(parameterData));
        return this.putIntoJSON(jSONObject, this.key, string);
    }

    protected abstract String getDerivedValue(AAXParameter.ParameterData var1);

    /*
     * Exception decompiling
     */
    protected boolean putIntoJSON(JSONObject var1, String var2, String var3) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl25 : ICONST_0 : trying to set 0 previously set to 1
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
}


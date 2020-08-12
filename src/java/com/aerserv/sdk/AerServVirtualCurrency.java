/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.math.BigDecimal
 *  org.json.JSONObject
 */
package com.aerserv.sdk;

import com.aerserv.sdk.AerServTransactionInformation;
import java.io.Serializable;
import java.math.BigDecimal;
import org.json.JSONObject;

public class AerServVirtualCurrency
implements Serializable {
    public static final AerServVirtualCurrency EMPTY_INSTANCE = new AerServVirtualCurrency();
    private static final String LOG_TAG = "AerServVirtualCurrency";
    public static final String VIRTUAL_CURRENCY_HEADER = "vc";
    private AerServTransactionInformation aerServTransactionInformation;
    private BigDecimal amount;
    private String eventUrl;
    private boolean isEnabled;
    private String name;

    public AerServVirtualCurrency() {
        this.name = "";
        this.amount = new BigDecimal(0);
        this.isEnabled = false;
        this.eventUrl = "";
        this.aerServTransactionInformation = new AerServTransactionInformation();
    }

    /*
     * Exception decompiling
     */
    public AerServVirtualCurrency(JSONObject var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl58 : RETURN : trying to set 1 previously set to 0
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

    public AerServTransactionInformation getAerServTransactionInformation() {
        return this.aerServTransactionInformation;
    }

    public BigDecimal getAmount() {
        return this.amount;
    }

    public String getBuyerName() {
        return this.aerServTransactionInformation.getBuyerName();
    }

    public BigDecimal getBuyerPrice() {
        return this.aerServTransactionInformation.getBuyerPrice();
    }

    public String getEventUrl() {
        return this.eventUrl;
    }

    public String getName() {
        return this.name;
    }

    public boolean isEnabled() {
        return this.isEnabled;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AerServVirtualCurrency(name: \"");
        stringBuilder.append(this.name);
        stringBuilder.append("\", amount: ");
        stringBuilder.append((Object)this.amount);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void updateTransactionInformation(JSONObject jSONObject) {
        this.aerServTransactionInformation.updateInformation(jSONObject);
    }
}


/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.HashSet
 *  java.util.Iterator
 *  org.json.JSONObject
 */
package com.ironsource.mediationsdk.model;

import android.text.TextUtils;
import com.ironsource.mediationsdk.model.ProviderSettings;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONObject;

public class ProviderSettingsHolder {
    private static ProviderSettingsHolder mInstance;
    private ArrayList<ProviderSettings> mProviderSettingsArrayList = new ArrayList();

    private ProviderSettingsHolder() {
    }

    public static ProviderSettingsHolder getProviderSettingsHolder() {
        Class<ProviderSettingsHolder> class_ = ProviderSettingsHolder.class;
        synchronized (ProviderSettingsHolder.class) {
            if (mInstance == null) {
                mInstance = new ProviderSettingsHolder();
            }
            ProviderSettingsHolder providerSettingsHolder = mInstance;
            // ** MonitorExit[var2] (shouldn't be in output)
            return providerSettingsHolder;
        }
    }

    public void addProviderSettings(ProviderSettings providerSettings) {
        if (providerSettings != null) {
            this.mProviderSettingsArrayList.add((Object)providerSettings);
        }
    }

    public boolean containsProviderSettings(String string) {
        Iterator iterator = this.mProviderSettingsArrayList.iterator();
        while (iterator.hasNext()) {
            if (!((ProviderSettings)iterator.next()).getProviderName().equals((Object)string)) continue;
            return true;
        }
        return false;
    }

    public void fillSubProvidersDetails() {
        for (ProviderSettings providerSettings : this.mProviderSettingsArrayList) {
            boolean bl2 = providerSettings.isMultipleInstances() && !TextUtils.isEmpty((CharSequence)providerSettings.getProviderTypeForReflection());
            if (!bl2) continue;
            ProviderSettings providerSettings2 = this.getProviderSettings(providerSettings.getProviderTypeForReflection());
            providerSettings.setInterstitialSettings(IronSourceUtils.mergeJsons(providerSettings.getInterstitialSettings(), providerSettings2.getInterstitialSettings()));
            providerSettings.setRewardedVideoSettings(IronSourceUtils.mergeJsons(providerSettings.getRewardedVideoSettings(), providerSettings2.getRewardedVideoSettings()));
            providerSettings.setBannerSettings(IronSourceUtils.mergeJsons(providerSettings.getBannerSettings(), providerSettings2.getBannerSettings()));
        }
    }

    public ProviderSettings getProviderSettings(String string) {
        for (ProviderSettings providerSettings : this.mProviderSettingsArrayList) {
            if (!providerSettings.getProviderName().equals((Object)string)) continue;
            return providerSettings;
        }
        ProviderSettings providerSettings = new ProviderSettings(string);
        this.addProviderSettings(providerSettings);
        return providerSettings;
    }

    /*
     * Exception decompiling
     */
    public HashSet<String> getProviderSettingsByReflectionName(String var1, String var2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl82.1 : ALOAD_3 : trying to set 1 previously set to 0
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


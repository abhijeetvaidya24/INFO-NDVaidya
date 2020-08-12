/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  co.ogury.crashreport.CrashReport
 *  io.presage.Entrammes
 *  io.presage.EtivazGruyereSuisse
 *  io.presage.FourmedAmbert
 *  io.presage.du
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package io.presage;

import co.ogury.crashreport.CrashReport;
import io.presage.Entrammes;
import io.presage.EtivazGruyereSuisse;
import io.presage.FourmedAmbert;
import io.presage.FourmedeMontbrison;
import io.presage.FourmedeRochefort;
import io.presage.Machecoulais;
import io.presage.Montbriac;
import io.presage.cl;
import io.presage.du;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class FourmedeHauteLoire {
    public static final FourmedeHauteLoire a = new FourmedeHauteLoire();

    private FourmedeHauteLoire() {
    }

    /*
     * Exception decompiling
     */
    public static FourmedAmbert a(String var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl26 : ACONST_NULL : trying to set 1 previously set to 0
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

    public static FourmedeRochefort a(JSONObject jSONObject) {
        if (jSONObject.optBoolean("force")) {
            return (FourmedeRochefort)Entrammes.a;
        }
        if (Machecoulais.a(jSONObject)) {
            return (FourmedeRochefort)EtivazGruyereSuisse.a;
        }
        try {
            FourmedeRochefort fourmedeRochefort = (FourmedeRochefort)FourmedeHauteLoire.b(jSONObject);
            return fourmedeRochefort;
        }
        catch (JSONException jSONException) {
            CrashReport.logException((Exception)((Exception)((Object)jSONException)));
            Montbriac.a();
            return (FourmedeRochefort)EtivazGruyereSuisse.a;
        }
    }

    private static void a(JSONObject jSONObject, FourmedAmbert fourmedAmbert) {
        JSONObject jSONObject2 = jSONObject.optJSONObject("timing_finder");
        fourmedAmbert.b(FourmedeMontbrison.a(Machecoulais.a(jSONObject2, "profig", 43200L)));
        fourmedAmbert.a(FourmedeMontbrison.a(Machecoulais.a(jSONObject2, "no_internet_retry", 7200L)));
        fourmedAmbert.e(FourmedeMontbrison.a(Machecoulais.a(jSONObject2, "show_close_button", 2L)));
    }

    private static FourmedAmbert b(JSONObject jSONObject) {
        FourmedAmbert fourmedAmbert = new FourmedAmbert();
        JSONObject jSONObject2 = jSONObject.optJSONObject("profig");
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        FourmedeHauteLoire.a(jSONObject2, fourmedAmbert);
        fourmedAmbert.a(Machecoulais.a(jSONObject2.optJSONObject("max_per_day"), "profig", 10));
        fourmedAmbert.c(FourmedeMontbrison.a(Machecoulais.a(jSONObject2.optJSONObject("timeout"), "ads", 3)));
        fourmedAmbert.a(Machecoulais.a(jSONObject2.optJSONObject("logs"), "crash_report", ""));
        FourmedeHauteLoire.b(jSONObject2, fourmedAmbert);
        FourmedeHauteLoire.c(jSONObject2, fourmedAmbert);
        JSONObject jSONObject3 = jSONObject2.optJSONObject("cache");
        JSONObject jSONObject4 = jSONObject3 != null ? jSONObject3.optJSONObject("ads_to_precache") : null;
        fourmedAmbert.b(Machecoulais.a(jSONObject4, "max", -1));
        fourmedAmbert.d(FourmedeMontbrison.a(Machecoulais.a(jSONObject3, "ad_expiration", 14400L)));
        return fourmedAmbert;
    }

    private static void b(JSONObject jSONObject, FourmedAmbert fourmedAmbert) {
        JSONObject jSONObject2 = jSONObject.optJSONObject("webview");
        fourmedAmbert.e(Machecoulais.a(jSONObject2, "back_button_enabled", false));
        fourmedAmbert.f(Machecoulais.a(jSONObject2, "close_ad_when_leaving_app", true));
        fourmedAmbert.c(FourmedeMontbrison.a(Machecoulais.a(jSONObject2, "webview_load_timeout", 80L)));
    }

    private static void c(JSONObject jSONObject, FourmedAmbert fourmedAmbert) {
        JSONArray jSONArray = jSONObject.optJSONArray("enabled");
        if (jSONArray == null) {
            jSONArray = new JSONArray();
        }
        String string2 = jSONArray.toString();
        cl.a((Object)string2, "enabledArray.toString()");
        CharSequence charSequence = string2;
        fourmedAmbert.a(du.b((CharSequence)charSequence, (CharSequence)"profig"));
        fourmedAmbert.b(du.b((CharSequence)charSequence, (CharSequence)"ads"));
        fourmedAmbert.c(du.b((CharSequence)charSequence, (CharSequence)"launch"));
        fourmedAmbert.d(du.b((CharSequence)charSequence, (CharSequence)"moat"));
    }
}


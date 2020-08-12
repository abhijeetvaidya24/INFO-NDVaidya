/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Thread
 *  java.lang.Throwable
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.appnext.core.a;

import com.appnext.core.f;
import org.json.JSONException;
import org.json.JSONObject;

public final class b {
    private static final String hX = "{\"EN\":{\"settings\":{\"active\":true,\"len\":12,\"font_size_px\":12,\"font_size_sp\":10},\"new\":{\"Install\":\"Install\",\"Download\":\"Download\",\"Shop\":\"Shop\",\"Sign up\":\"Sign up\",\"Watch\":\"Watch\",\"Join\":\"Join\",\"Start\":\"Start\",\"Subscribe\":\"Subscribe\",\"Add\":\"Add\",\"Search\":\"Search\",\"Share\":\"Share\",\"Get\":\"Get\",\"Book\":\"Book\",\"Play\":\"Play\"},\"existing\":{\"Install\":\"Install\",\"Use\":\"Use\",\"Play\":\"Play\",\"Reserve\":\"Reserve\",\"Buy\":\"Buy\",\"View\":\"View\",\"Log in\":\"Log in\",\"Listen\":\"Listen\",\"Read\":\"Read\",\"Watch\":\"Watch\",\"See more\":\"See more\",\"Find\":\"Find\",\"Book\":\"Book\",\"Chat\":\"Chat\",\"Park\":\"Park\",\"Open\":\"Open\",\"Exercise\":\"Exercise\",\"Optimize\":\"Optimize\"}},\"KO\":{\"settings\":{\"active\":true,\"len\":10,\"font_size_px\":12,\"font_size_sp\":10},\"new\":{\"Install\":\"\uc124\uce58\",\"Download\":\"\ub2e4\uc6b4\ub85c\ub4dc\",\"Shop\":\"\uac00\uac8c\uc5d0\uc11c \ubb3c\uac74\uc744 \uc0ac\ub2e4\",\"Sign up\":\"\ud68c\uc6d0\uac00\uc785\",\"Watch\":\"\ubcf4\ub2e4\",\"Join\":\"\uc785\ud68c\ud558\ub2e4\",\"Start\":\"\uc2dc\uc791\",\"Subscribe\":\"\uad6c\ub3c5\",\"Add\":\"\ucd94\uac00\",\"Search\":\"\uac80\uc0c9\",\"Share\":\"\uacf5\uc720\",\"Get\":\"\uc5bb\ub2e4\",\"Book\":\"\uc608\uc57d\",\"Play\":\"\uc7ac\uc0dd\"},\"existing\":{\"Install\":\"\uc124\uce58\",\"Use\":\"\uc124\uce58\",\"Play\":\"\uc7ac\uc0dd\",\"Reserve\":\"\uc608\uc57d\ud558\uae30\",\"Buy\":\"\uad6c\ub9e4\ud558\uae30\",\"View\":\"\ubc14\ub77c\ubcf4\ub2e4\",\"Log in\":\"\ub85c\uadf8\uc778\",\"Listen\":\"\ub4e3\uae30\",\"Read\":\"\uc77d\uae30\",\"Watch\":\"\ubcf4\uae30\",\"See more\":\"\ub354 \ubcf4\uae30\",\"Find\":\"\ucc3e\uae30\",\"Book\":\"\uc608\uc57d\",\"Chat\":\"\ucc44\ud305\",\"Park\":\"\uc77d\uae30\",\"Open\":\"\uac1c\uc7a5\",\"Exercise\":\"\uc5f0\uc2b5\ud558\ub2e4\",\"Optimize\":\"\ucd5c\uc801\ud654\ud558\uae30\"}}}";
    public static final String hY = "settings";
    public static final String hZ = "new";
    public static final String ia = "existing";
    private static b ic;
    private String ib;

    private b() {
        new Thread(new Runnable(){

            public final void run() {
                try {
                    b.this.ib = f.a("https://cdn.appnext.com/tools/sdk/langs/2.4.4/langs.json", null);
                }
                catch (Throwable throwable) {}
            }
        }).start();
    }

    private static String a(String string2, String string3, String string4, String string5) throws JSONException {
        JSONObject jSONObject = new JSONObject(string2);
        if (jSONObject.getJSONObject(string3).getJSONObject(hY).getBoolean("active")) {
            return jSONObject.getJSONObject(string3).getJSONObject(string4).getString(string5);
        }
        return string5;
    }

    public static b bn() {
        Class<b> class_ = b.class;
        synchronized (b.class) {
            if (ic == null) {
                ic = new b();
            }
            b b2 = ic;
            // ** MonitorExit[var2] (shouldn't be in output)
            return b2;
        }
    }

    /*
     * Exception decompiling
     */
    public final String b(String var1, String var2, String var3) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl43 : NEW : trying to set 1 previously set to 0
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

    public final String bo() {
        String string2 = this.ib;
        if (string2 != null) {
            return string2;
        }
        return hX;
    }

}


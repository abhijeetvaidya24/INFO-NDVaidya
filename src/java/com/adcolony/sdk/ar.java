/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageManager
 *  android.media.MediaScannerConnection
 *  android.media.MediaScannerConnection$OnScanCompletedListener
 *  android.net.Uri
 *  android.os.Vibrator
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.HashMap
 *  java.util.concurrent.ConcurrentHashMap
 *  java.util.concurrent.ExecutorService
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.adcolony.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Vibrator;
import com.adcolony.sdk.AdColonyInterstitial;
import com.adcolony.sdk.AdColonyInterstitialListener;
import com.adcolony.sdk.AdColonyNativeAdView;
import com.adcolony.sdk.AdColonyNativeAdViewListener;
import com.adcolony.sdk.a;
import com.adcolony.sdk.ad;
import com.adcolony.sdk.af;
import com.adcolony.sdk.ar;
import com.adcolony.sdk.au;
import com.adcolony.sdk.ax;
import com.adcolony.sdk.b;
import com.adcolony.sdk.c;
import com.adcolony.sdk.d;
import com.adcolony.sdk.e;
import com.adcolony.sdk.n;
import com.adcolony.sdk.w;
import com.adcolony.sdk.y;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import org.json.JSONArray;
import org.json.JSONObject;

class ar {
    ar() {
    }

    static /* synthetic */ boolean a(ar ar2, ad ad2) {
        return ar2.n(ad2);
    }

    static /* synthetic */ boolean b(ar ar2, ad ad2) {
        return ar2.m(ad2);
    }

    private void c(final String string) {
        au.b.execute(new Runnable(){

            public void run() {
                JSONObject jSONObject = w.a();
                w.a(jSONObject, "type", "open_hook");
                w.a(jSONObject, "message", string);
                new ad("CustomMessage.controller_send", 0, jSONObject).b();
            }
        });
    }

    private boolean m(ad ad2) {
        String string = w.b(ad2.c(), "ad_session_id");
        Activity activity = a.c() instanceof Activity ? (Activity)a.c() : null;
        if (activity != null && activity instanceof b) {
            JSONObject jSONObject = w.a();
            w.a(jSONObject, "id", string);
            new ad("AdSession.on_request_close", ((b)activity).f, jSONObject).b();
            return true;
        }
        return false;
    }

    private boolean n(ad ad2) {
        JSONObject jSONObject = ad2.c();
        d d2 = a.a().l();
        String string = w.b(jSONObject, "ad_session_id");
        AdColonyInterstitial adColonyInterstitial = (AdColonyInterstitial)d2.c().get((Object)string);
        ax ax2 = (ax)((Object)d2.f().get((Object)string));
        if (adColonyInterstitial != null && adColonyInterstitial.getListener() != null && adColonyInterstitial.d() != null || ax2 != null && ax2.getListener() != null && ax2.getExpandedContainer() != null) {
            if (ax2 == null) {
                new ad("AdUnit.make_in_app_purchase", adColonyInterstitial.d().c()).b();
            } else {
                new ad("AdUnit.make_in_app_purchase", ax2.getExpandedContainer().c()).b();
            }
            this.b(w.b(jSONObject, "ad_session_id"));
            return true;
        }
        return false;
    }

    void a() {
        a.a("System.open_store", new af(this){
            final /* synthetic */ ar a;
            {
                this.a = ar2;
            }

            public void a(ad ad2) {
                this.a.a(ad2);
            }
        });
        a.a("System.save_screenshot", new af(this){
            final /* synthetic */ ar a;
            {
                this.a = ar2;
            }

            public void a(ad ad2) {
                this.a.b(ad2);
            }
        });
        a.a("System.telephone", new af(this){
            final /* synthetic */ ar a;
            {
                this.a = ar2;
            }

            public void a(ad ad2) {
                this.a.c(ad2);
            }
        });
        a.a("System.sms", new af(this){
            final /* synthetic */ ar a;
            {
                this.a = ar2;
            }

            public void a(ad ad2) {
                this.a.d(ad2);
            }
        });
        a.a("System.vibrate", new af(this){
            final /* synthetic */ ar a;
            {
                this.a = ar2;
            }

            public void a(ad ad2) {
                this.a.e(ad2);
            }
        });
        a.a("System.open_browser", new af(this){
            final /* synthetic */ ar a;
            {
                this.a = ar2;
            }

            public void a(ad ad2) {
                this.a.f(ad2);
            }
        });
        a.a("System.mail", new af(this){
            final /* synthetic */ ar a;
            {
                this.a = ar2;
            }

            public void a(ad ad2) {
                this.a.g(ad2);
            }
        });
        a.a("System.launch_app", new af(this){
            final /* synthetic */ ar a;
            {
                this.a = ar2;
            }

            public void a(ad ad2) {
                this.a.h(ad2);
            }
        });
        a.a("System.create_calendar_event", new af(this){
            final /* synthetic */ ar a;
            {
                this.a = ar2;
            }

            public void a(ad ad2) {
                this.a.i(ad2);
            }
        });
        a.a("System.check_app_presence", new af(this){
            final /* synthetic */ ar a;
            {
                this.a = ar2;
            }

            public void a(ad ad2) {
                this.a.j(ad2);
            }
        });
        a.a("System.check_social_presence", new af(this){
            final /* synthetic */ ar a;
            {
                this.a = ar2;
            }

            public void a(ad ad2) {
                this.a.k(ad2);
            }
        });
        a.a("System.social_post", new af(this){
            final /* synthetic */ ar a;
            {
                this.a = ar2;
            }

            public void a(ad ad2) {
                this.a.l(ad2);
            }
        });
        a.a("System.make_in_app_purchase", new af(this){
            final /* synthetic */ ar a;
            {
                this.a = ar2;
            }

            public void a(ad ad2) {
                ar.a(this.a, ad2);
            }
        });
        a.a("System.close", new af(this){
            final /* synthetic */ ar a;
            {
                this.a = ar2;
            }

            public void a(ad ad2) {
                ar.b(this.a, ad2);
            }
        });
    }

    void a(String string) {
        d d2 = a.a().l();
        AdColonyInterstitial adColonyInterstitial = (AdColonyInterstitial)d2.c().get((Object)string);
        if (adColonyInterstitial != null && adColonyInterstitial.getListener() != null) {
            adColonyInterstitial.getListener().onLeftApplication(adColonyInterstitial);
            return;
        }
        ax ax2 = (ax)((Object)d2.f().get((Object)string));
        e e2 = ax2 != null ? ax2.getListener() : null;
        if (ax2 != null && e2 != null && e2 instanceof AdColonyNativeAdViewListener) {
            ((AdColonyNativeAdViewListener)e2).onLeftApplication((AdColonyNativeAdView)ax2);
        }
    }

    boolean a(ad ad2) {
        JSONObject jSONObject = w.a();
        JSONObject jSONObject2 = ad2.c();
        String string = w.b(jSONObject2, "product_id");
        if (string.equals((Object)"")) {
            string = w.b(jSONObject2, "handle");
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse((String)string));
        this.c(string);
        if (au.a(intent)) {
            w.a(jSONObject, "success", true);
            ad2.a(jSONObject).b();
            this.a(w.b(jSONObject2, "ad_session_id"));
            this.b(w.b(jSONObject2, "ad_session_id"));
            return true;
        }
        au.a("Unable to open.", 0);
        w.a(jSONObject, "success", false);
        ad2.a(jSONObject).b();
        return false;
    }

    void b(String string) {
        d d2 = a.a().l();
        AdColonyInterstitial adColonyInterstitial = (AdColonyInterstitial)d2.c().get((Object)string);
        if (adColonyInterstitial != null && adColonyInterstitial.getListener() != null) {
            adColonyInterstitial.getListener().onClicked(adColonyInterstitial);
            return;
        }
        ax ax2 = (ax)((Object)d2.f().get((Object)string));
        e e2 = ax2 != null ? ax2.getListener() : null;
        if (ax2 != null && e2 != null && e2 instanceof AdColonyNativeAdViewListener) {
            ((AdColonyNativeAdViewListener)e2).onClicked((AdColonyNativeAdView)ax2);
        }
    }

    /*
     * Exception decompiling
     */
    boolean b(ad var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl207 : ICONST_0 : trying to set 0 previously set to 1
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

    boolean c(ad ad2) {
        JSONObject jSONObject = w.a();
        JSONObject jSONObject2 = ad2.c();
        Intent intent = new Intent("android.intent.action.DIAL");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("tel:");
        stringBuilder.append(w.b(jSONObject2, "phone_number"));
        if (au.a(intent.setData(Uri.parse((String)stringBuilder.toString())))) {
            w.a(jSONObject, "success", true);
            ad2.a(jSONObject).b();
            this.a(w.b(jSONObject2, "ad_session_id"));
            this.b(w.b(jSONObject2, "ad_session_id"));
            return true;
        }
        au.a("Failed to dial number.", 0);
        w.a(jSONObject, "success", false);
        ad2.a(jSONObject).b();
        return false;
    }

    boolean d(ad ad2) {
        JSONObject jSONObject = ad2.c();
        JSONObject jSONObject2 = w.a();
        JSONArray jSONArray = w.g(jSONObject, "recipients");
        String string = "";
        for (int i2 = 0; i2 < jSONArray.length(); ++i2) {
            if (i2 != 0) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string);
                stringBuilder.append(";");
                string = stringBuilder.toString();
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string);
            stringBuilder.append(w.c(jSONArray, i2));
            string = stringBuilder.toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("smsto:");
        stringBuilder.append(string);
        if (au.a(new Intent("android.intent.action.VIEW", Uri.parse((String)stringBuilder.toString())).putExtra("sms_body", w.b(jSONObject, "body")))) {
            w.a(jSONObject2, "success", true);
            ad2.a(jSONObject2).b();
            this.a(w.b(jSONObject, "ad_session_id"));
            this.b(w.b(jSONObject, "ad_session_id"));
            return true;
        }
        au.a("Failed to create sms.", 0);
        w.a(jSONObject2, "success", false);
        ad2.a(jSONObject2).b();
        return false;
    }

    boolean e(ad ad2) {
        Context context = a.c();
        if (context == null) {
            return false;
        }
        int n2 = w.a(ad2.c(), "length_ms", 500);
        JSONObject jSONObject = w.a();
        JSONArray jSONArray = a.a().m().z();
        boolean bl = false;
        for (int i2 = 0; i2 < jSONArray.length(); ++i2) {
            if (!w.c(jSONArray, i2).equals((Object)"android.permission.VIBRATE")) continue;
            bl = true;
        }
        if (!bl) {
            new y.a().a("No vibrate permission detected.").a(y.e);
            w.a(jSONObject, "success", false);
            ad2.a(jSONObject).b();
            return false;
        }
        try {
            ((Vibrator)context.getSystemService("vibrator")).vibrate((long)n2);
            w.a(jSONObject, "success", false);
            ad2.a(jSONObject).b();
            return true;
        }
        catch (Exception exception) {
            new y.a().a("Vibrate command failed.").a(y.e);
            w.a(jSONObject, "success", false);
            ad2.a(jSONObject).b();
            return false;
        }
    }

    boolean f(ad ad2) {
        JSONObject jSONObject = w.a();
        JSONObject jSONObject2 = ad2.c();
        String string = w.b(jSONObject2, "url");
        if (string.startsWith("browser")) {
            string = string.replaceFirst("browser", "http");
        }
        if (string.startsWith("safari")) {
            string = string.replaceFirst("safari", "http");
        }
        this.c(string);
        if (au.a(new Intent("android.intent.action.VIEW", Uri.parse((String)string)))) {
            w.a(jSONObject, "success", true);
            ad2.a(jSONObject).b();
            this.a(w.b(jSONObject2, "ad_session_id"));
            this.b(w.b(jSONObject2, "ad_session_id"));
            return true;
        }
        au.a("Failed to launch browser.", 0);
        w.a(jSONObject, "success", false);
        ad2.a(jSONObject).b();
        return false;
    }

    boolean g(ad ad2) {
        JSONObject jSONObject = w.a();
        JSONObject jSONObject2 = ad2.c();
        JSONArray jSONArray = w.g(jSONObject2, "recipients");
        boolean bl = w.d(jSONObject2, "html");
        String string = w.b(jSONObject2, "subject");
        String string2 = w.b(jSONObject2, "body");
        String[] arrstring = new String[jSONArray.length()];
        for (int i2 = 0; i2 < jSONArray.length(); ++i2) {
            arrstring[i2] = w.c(jSONArray, i2);
        }
        Intent intent = new Intent("android.intent.action.SEND");
        if (!bl) {
            intent.setType("plain/text");
        }
        intent.putExtra("android.intent.extra.SUBJECT", string).putExtra("android.intent.extra.TEXT", string2).putExtra("android.intent.extra.EMAIL", arrstring);
        if (au.a(intent)) {
            w.a(jSONObject, "success", true);
            ad2.a(jSONObject).b();
            this.a(w.b(jSONObject2, "ad_session_id"));
            this.b(w.b(jSONObject2, "ad_session_id"));
            return true;
        }
        au.a("Failed to send email.", 0);
        w.a(jSONObject, "success", false);
        ad2.a(jSONObject).b();
        return false;
    }

    boolean h(ad ad2) {
        JSONObject jSONObject = w.a();
        JSONObject jSONObject2 = ad2.c();
        if (w.d(jSONObject2, "deep_link")) {
            return this.a(ad2);
        }
        Context context = a.c();
        if (context == null) {
            return false;
        }
        if (au.a(context.getPackageManager().getLaunchIntentForPackage(w.b(jSONObject2, "handle")))) {
            w.a(jSONObject, "success", true);
            ad2.a(jSONObject).b();
            this.a(w.b(jSONObject2, "ad_session_id"));
            this.b(w.b(jSONObject2, "ad_session_id"));
            return true;
        }
        au.a("Failed to launch external application.", 0);
        w.a(jSONObject, "success", false);
        ad2.a(jSONObject).b();
        return false;
    }

    /*
     * Exception decompiling
     */
    boolean i(ad var1) {
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

    boolean j(ad ad2) {
        JSONObject jSONObject = w.a();
        String string = w.b(ad2.c(), "name");
        boolean bl = au.a(string);
        w.a(jSONObject, "success", true);
        w.a(jSONObject, "result", bl);
        w.a(jSONObject, "name", string);
        w.a(jSONObject, "service", string);
        ad2.a(jSONObject).b();
        return true;
    }

    boolean k(ad ad2) {
        return this.j(ad2);
    }

    boolean l(ad ad2) {
        JSONObject jSONObject = w.a();
        JSONObject jSONObject2 = ad2.c();
        Intent intent = new Intent("android.intent.action.SEND").setType("text/plain");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(w.b(jSONObject2, "text"));
        stringBuilder.append(" ");
        stringBuilder.append(w.b(jSONObject2, "url"));
        if (au.a(intent.putExtra("android.intent.extra.TEXT", stringBuilder.toString()), true)) {
            w.a(jSONObject, "success", true);
            ad2.a(jSONObject).b();
            this.a(w.b(jSONObject2, "ad_session_id"));
            this.b(w.b(jSONObject2, "ad_session_id"));
            return true;
        }
        au.a("Unable to create social post.", 0);
        w.a(jSONObject, "success", false);
        ad2.a(jSONObject).b();
        return false;
    }

}


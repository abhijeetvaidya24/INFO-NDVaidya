/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageManager
 *  android.net.Uri
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package io.presage;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import io.presage.cl;
import java.util.List;

public final class Reblochon {
    public static final Reblochon a = new Reblochon();

    private Reblochon() {
    }

    private static void a(Context context, Intent intent) {
        if (Reblochon.b(context, intent)) {
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }

    private static void a(Context context, Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW", uri);
        if (Reblochon.b(context, intent)) {
            Reblochon.a(context, intent);
        }
    }

    public static void a(Context context, String string2) {
        CharSequence charSequence = string2;
        boolean bl2 = charSequence == null || charSequence.length() == 0;
        if (bl2) {
            return;
        }
        try {
            Uri uri = Uri.parse((String)string2);
            cl.a((Object)uri, "uri");
            Reblochon.a(context, uri);
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    /*
     * Exception decompiling
     */
    public static void b(Context var0, String var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl35 : RETURN : trying to set 1 previously set to 0
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

    private static boolean b(Context context, Intent intent) {
        return context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }

    public static boolean c(Context context, String string2) {
        CharSequence charSequence = string2;
        boolean bl2 = charSequence == null || charSequence.length() == 0;
        if (bl2) {
            return false;
        }
        try {
            Intent intent = Intent.parseUri((String)string2, (int)0);
            cl.a((Object)intent, "intent");
            boolean bl3 = Reblochon.b(context, intent);
            return bl3;
        }
        catch (Exception exception) {
            return false;
        }
    }
}


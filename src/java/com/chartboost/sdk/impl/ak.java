/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageManager
 *  android.net.Uri
 *  android.os.Handler
 *  com.chartboost.sdk.Tracking.a
 *  com.chartboost.sdk.impl.aj
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Throwable
 *  java.net.HttpURLConnection
 *  java.net.URI
 *  java.net.URISyntaxException
 *  java.net.URL
 *  java.net.URLConnection
 *  java.util.List
 *  java.util.concurrent.Executor
 */
package com.chartboost.sdk.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Handler;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Model.CBError;
import com.chartboost.sdk.a;
import com.chartboost.sdk.c;
import com.chartboost.sdk.i;
import com.chartboost.sdk.impl.ad;
import com.chartboost.sdk.impl.ah;
import com.chartboost.sdk.impl.ai;
import com.chartboost.sdk.impl.aj;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.concurrent.Executor;

public class ak {
    final ai a;
    final Handler b;
    private final Executor c;
    private final ah d;

    public ak(Executor executor, ah ah2, ai ai2, Handler handler) {
        this.c = executor;
        this.d = ah2;
        this.a = ai2;
        this.b = handler;
    }

    public void a(final com.chartboost.sdk.Model.c c2, final String string, final Activity activity, final aj aj2) {
        URI uRI;
        try {
            uRI = new URI(string);
        }
        catch (URISyntaxException uRISyntaxException) {
            this.a(c2, false, string, CBError.CBClickError.URI_INVALID, aj2);
            return;
        }
        String string2 = uRI.getScheme();
        if (string2 == null) {
            this.a(c2, false, string, CBError.CBClickError.URI_INVALID, aj2);
            return;
        }
        if (!string2.equals((Object)"http") && !string2.equals((Object)"https")) {
            this.a(c2, string, (Context)activity, aj2);
            return;
        }
        Runnable runnable = new Runnable(){

            private void a(final String string2) {
                Runnable runnable = new Runnable(){

                    public void run() {
                        try {
                            ak.this.a(c2, string2, (Context)activity, aj2);
                            return;
                        }
                        catch (Exception exception) {
                            com.chartboost.sdk.Tracking.a.a(ak.class, (String)"open openOnUiThread Runnable.run", (Exception)exception);
                            return;
                        }
                    }
                };
                Activity activity2 = activity;
                if (activity2 != null) {
                    activity2.runOnUiThread(runnable);
                    return;
                }
                ak.this.b.post(runnable);
            }

            /*
             * Unable to fully structure code
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             * Lifted jumps to return sites
             */
            public void run() {
                block17 : {
                    block15 : {
                        block16 : {
                            try {
                                var2_1 = string;
                                var3_2 = ak.this.a.b();
                                if (!var3_2) ** GOTO lbl44
                            }
                            catch (Exception var1_11) {
                                com.chartboost.sdk.Tracking.a.a(ak.class, (String)"open followTask", (Exception)var1_11);
                                return;
                            }
                            var5_3 = (HttpURLConnection)new URL(string).openConnection();
                            try {
                                var5_3.setInstanceFollowRedirects(false);
                                var5_3.setConnectTimeout(10000);
                                var5_3.setReadTimeout(10000);
                                var8_4 = var5_3.getHeaderField("Location");
                                if (var8_4 != null) {
                                    var2_1 = var8_4;
                                }
                                if (var5_3 != null) {
                                    break block15;
                                }
                                ** GOTO lbl44
                            }
                            catch (Exception var6_5) {
                                break block16;
                            }
                            catch (Throwable var7_7) {
                                var5_3 = null;
                                break block17;
                            }
                            catch (Exception var4_10) {
                                var5_3 = null;
                                var6_6 = var4_10;
                            }
                        }
                        CBLogging.a("CBURLOpener", "Exception raised while opening a HTTP Conection", var6_6);
                        if (var5_3 == null) ** GOTO lbl44
                    }
                    var5_3.disconnect();
                    {
                        ** GOTO lbl44
                    }
                    catch (Throwable var7_8) {
                        // empty catch block
                    }
                }
                if (var5_3 == null) throw var7_9;
                var5_3.disconnect();
                throw var7_9;
lbl44: // 4 sources:
                this.a(var2_1);
            }

        };
        this.c.execute(runnable);
    }

    /*
     * Exception decompiling
     */
    void a(com.chartboost.sdk.Model.c var1, String var2, Context var3, aj var4) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl112 : ALOAD_0 : trying to set 1 previously set to 0
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

    public void a(com.chartboost.sdk.Model.c c2, String string, aj aj2) {
        Activity activity = c2 != null ? c2.g.a() : null;
        this.a(c2, string, activity, aj2);
    }

    public void a(com.chartboost.sdk.Model.c c2, boolean bl, String string, CBError.CBClickError cBClickError, aj aj2) {
        if (c2 != null) {
            c2.x = false;
            if (c2.b()) {
                c2.l = 4;
            }
        }
        if (!bl) {
            if (i.c != null) {
                i.c.didFailToRecordClick(string, cBClickError);
                return;
            }
        } else {
            if (c2 != null && c2.w != null) {
                this.d.a(c2.w);
                return;
            }
            if (aj2 != null) {
                this.d.a(aj2);
            }
        }
    }

    public boolean a(String string) {
        try {
            Context context = i.m;
            Intent intent = new Intent("android.intent.action.VIEW");
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            intent.setData(Uri.parse((String)string));
            int n2 = context.getPackageManager().queryIntentActivities(intent, 65536).size();
            boolean bl = false;
            if (n2 > 0) {
                bl = true;
            }
            return bl;
        }
        catch (Exception exception) {
            CBLogging.a("CBURLOpener", "Cannot open URL", exception);
            com.chartboost.sdk.Tracking.a.a(ak.class, (String)"canOpenURL", (Exception)exception);
            return false;
        }
    }

}


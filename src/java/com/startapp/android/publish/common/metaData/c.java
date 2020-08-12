/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Handler
 *  android.os.Looper
 *  com.startapp.android.publish.adsCommon.BaseRequest
 *  com.startapp.android.publish.adsCommon.f.e
 *  com.startapp.android.publish.common.metaData.MetaDataRequest
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.net.UnknownHostException
 */
package com.startapp.android.publish.common.metaData;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.startapp.android.publish.ads.splash.f;
import com.startapp.android.publish.adsCommon.AdsConstants;
import com.startapp.android.publish.adsCommon.BaseRequest;
import com.startapp.android.publish.adsCommon.Utils.i;
import com.startapp.android.publish.adsCommon.b;
import com.startapp.android.publish.adsCommon.f.e;
import com.startapp.android.publish.adsCommon.k.a;
import com.startapp.android.publish.cache.d;
import com.startapp.android.publish.common.metaData.MetaData;
import com.startapp.android.publish.common.metaData.MetaDataRequest;
import com.startapp.android.publish.common.model.AdPreferences;
import com.startapp.common.g;
import java.net.UnknownHostException;

public class c {
    private final Context a;
    private final AdPreferences b;
    private MetaDataRequest.a c;
    private MetaData d = null;
    private com.startapp.android.publish.ads.banner.c e = null;
    private f f = null;
    private d g = null;
    private com.startapp.android.publish.adsCommon.adinformation.a h = null;
    private b i = null;
    private boolean j = false;

    public c(Context context, AdPreferences adPreferences, MetaDataRequest.a a2) {
        this.a = context;
        this.b = adPreferences;
        this.c = a2;
    }

    private void a(String string, String string2) {
        com.startapp.android.publish.adsCommon.f.f.a(this.a, new e(com.startapp.android.publish.adsCommon.f.d.b, string, string2), "");
    }

    /*
     * Exception decompiling
     */
    private void d() {
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

    public void a() {
        g.a(g.a.b, new Runnable(){

            public void run() {
                final Boolean bl = c.this.c();
                new Handler(Looper.getMainLooper()).post(new Runnable(){

                    public void run() {
                        c.this.a(bl);
                    }
                });
            }

        });
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected void a(Boolean bl) {
        Object object;
        Object object2 = object = MetaData.getLock();
        synchronized (object2) {
            if (!this.j) {
                Context context;
                if (bl.booleanValue() && this.d != null && (context = this.a) != null) {
                    try {
                        MetaData.update(this.a, this.d);
                    }
                    catch (Exception exception) {
                        this.a("GetMetaDataAsyncTask.onPostExecute-metadata update fail", exception.getMessage());
                    }
                } else {
                    MetaData.failedLoading();
                }
            }
            return;
        }
    }

    public void b() {
        this.j = true;
    }

    protected Boolean c() {
        block6 : {
            com.startapp.common.a.g.a(3, "Loading MetaData");
            MetaDataRequest metaDataRequest = new MetaDataRequest(this.a, this.c);
            try {
                metaDataRequest.fillApplicationDetails(this.a, this.b, false);
                metaDataRequest.fillLocationDetails(this.b, this.a);
                com.startapp.common.a.g.a(3, "Networking MetaData");
                String string = a.a(this.a, AdsConstants.a(AdsConstants.ServiceApiType.METADATA), (BaseRequest)metaDataRequest, null).a();
                this.d = i.a(string, MetaData.class);
                if (i.a()) break block6;
                this.i = i.a(string, b.class);
                if (i.a(16L) || i.a(32L)) {
                    this.e = i.a(string, com.startapp.android.publish.ads.banner.c.class);
                }
                if (i.a(8L)) {
                    this.f = i.a(string, f.class);
                }
                if (i.a(512L)) {
                    this.g = i.a(string, d.class);
                }
                if (!i.e()) break block6;
                this.h = i.a(string, com.startapp.android.publish.adsCommon.adinformation.a.class);
            }
            catch (Exception exception) {
                com.startapp.common.a.g.a(6, "Unable to handle GetMetaData command!!!!", exception);
                if (!(exception instanceof UnknownHostException) || !exception.getMessage().contains((CharSequence)"init.startappservice.com")) {
                    com.startapp.android.publish.adsCommon.f.f.a(this.a, com.startapp.android.publish.adsCommon.f.d.b, "GetMetaDataAsync.doInBackground - MetaData request failed", exception.getMessage(), "");
                }
                return Boolean.FALSE;
            }
        }
        this.d();
        return Boolean.TRUE;
    }

}


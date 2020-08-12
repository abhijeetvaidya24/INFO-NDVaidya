/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.IntentService
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.IBinder
 *  android.os.Message
 *  android.os.Messenger
 *  android.os.Parcelable
 *  android.os.ResultReceiver
 *  com.appnext.core.f
 *  com.appnext.core.n
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.util.HashMap
 */
package com.appnext.core;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.ResultReceiver;
import com.appnext.core.f;
import com.appnext.core.n;
import java.io.IOException;
import java.util.HashMap;

public class AdsService
extends IntentService {
    public static final int ADD_PACK = 8348;
    public static final int START_APP = 8346;
    private static HashMap<String, n> gi = new HashMap();
    private Runnable gj = new Runnable(){

        /*
         * Exception decompiling
         */
        public final void run() {
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
            // org.benf.cfr.reader.entities.d.c(ClassFile.java:773)
            // org.benf.cfr.reader.entities.d.e(ClassFile.java:870)
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
    };
    private Handler mHandler;
    Messenger mMessenger = new Messenger((Handler)new a());

    public AdsService() {
        super("AdsService");
    }

    private boolean R(String string2) {
        PackageManager packageManager = this.getPackageManager();
        try {
            packageManager.getPackageInfo(string2, 128);
            return true;
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            return false;
        }
    }

    static /* synthetic */ Handler a(AdsService adsService) {
        return adsService.mHandler;
    }

    static /* synthetic */ Handler a(AdsService adsService, Handler handler) {
        adsService.mHandler = null;
        return null;
    }

    private void a(String string2, Bundle bundle, ResultReceiver resultReceiver) {
        n n2 = (n)gi.get((Object)string2);
        if (n2 == null) {
            this.addPack(string2, bundle, resultReceiver);
            return;
        }
        n2.hC = bundle;
        gi.put((Object)string2, (Object)n2);
    }

    static /* synthetic */ boolean a(AdsService adsService, String string2) {
        return adsService.R(string2);
    }

    static /* synthetic */ HashMap aV() {
        return gi;
    }

    static /* synthetic */ Runnable b(AdsService adsService) {
        return adsService.gj;
    }

    protected final void a(final n n2) {
        AdsService adsService = this;
        synchronized (adsService) {
            new Thread(new Runnable(){

                public final void run() {
                    HashMap hashMap = new HashMap();
                    hashMap.put((Object)"guid", (Object)n2.hC.getString("guid"));
                    String string2 = n2.hC.getString("zone") == null ? "" : n2.hC.getString("zone");
                    hashMap.put((Object)"zone", (Object)string2);
                    hashMap.put((Object)"adsID", (Object)f.b((Context)AdsService.this, (boolean)true));
                    hashMap.put((Object)"isApk", (Object)"0");
                    hashMap.put((Object)"bannerid", (Object)n2.hC.getString("bannerid"));
                    hashMap.put((Object)"placementid", (Object)n2.hC.getString("placementid"));
                    hashMap.put((Object)"vid", (Object)n2.hC.getString("vid"));
                    hashMap.put((Object)"tid", (Object)n2.hC.getString("tid", ""));
                    hashMap.put((Object)"osid", (Object)"100");
                    hashMap.put((Object)"auid", (Object)n2.hC.getString("auid", ""));
                    String string3 = AdsService.this.getPackageManager().getInstallerPackageName(n2.am);
                    if (string3 == null) {
                        string3 = "";
                    }
                    hashMap.put((Object)"installer", (Object)string3);
                    try {
                        f.a((String)"https://admin.appnext.com/AdminService.asmx/SetOpenV1", (HashMap)hashMap);
                    }
                    catch (IOException iOException) {}
                }
            }).start();
            return;
        }
    }

    public void addPack(String string2, Bundle bundle, ResultReceiver resultReceiver) {
        if (gi == null) {
            gi = new HashMap();
        }
        if (gi.containsKey((Object)string2)) {
            n n2 = (n)gi.get((Object)string2);
            if (n2 == null) {
                this.addPack(string2, bundle, resultReceiver);
                return;
            }
            n2.hC = bundle;
            gi.put((Object)string2, (Object)n2);
            return;
        }
        n n3 = new n();
        n3.am = string2;
        n3.hC = bundle;
        gi.put((Object)string2, (Object)n3);
        if (this.mHandler == null) {
            this.mHandler = new Handler();
            this.mHandler.postDelayed(this.gj, 10000L);
        }
    }

    public IBinder onBind(Intent intent) {
        return this.mMessenger.getBinder();
    }

    public void onDestroy() {
        super.onDestroy();
        gi.clear();
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.mHandler = null;
    }

    protected void onHandleIntent(Intent intent) {
        if (intent.getIntExtra("added_info", 0) == 8348) {
            this.addPack(intent.getStringExtra("package"), intent.getExtras(), (ResultReceiver)intent.getParcelableExtra("receiver"));
            new StringBuilder("Package added: ").append(intent.getStringExtra("package"));
        }
    }

    public boolean onUnbind(Intent intent) {
        return false;
    }

    final class a
    extends Handler {
        a() {
        }

        public final void handleMessage(Message message) {
            if (message.what != 8348) {
                super.handleMessage(message);
                return;
            }
            Bundle bundle = message.getData();
            AdsService.this.addPack(bundle.getString("package"), bundle, (ResultReceiver)bundle.getParcelable("receiver"));
            new StringBuilder("Package added: ").append(bundle.getString("package"));
        }
    }

}


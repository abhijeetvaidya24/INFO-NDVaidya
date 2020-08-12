/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.net.ConnectivityManager
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.tapjoy.mraid.controller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import com.tapjoy.TapjoyLog;
import com.tapjoy.mraid.controller.Abstract;
import com.tapjoy.mraid.util.NetworkBroadcastReceiver;
import com.tapjoy.mraid.view.MraidView;

public class Network
extends Abstract {
    private ConnectivityManager c;
    private int d;
    private NetworkBroadcastReceiver e;
    private IntentFilter f;

    public Network(MraidView mraidView, Context context) {
        super(mraidView, context);
        this.c = (ConnectivityManager)context.getSystemService("connectivity");
    }

    /*
     * Exception decompiling
     */
    public String getNetwork() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Statement already marked as first in another block
        // org.benf.cfr.reader.b.a.a.i.b(Op03SimpleStatement.java:414)
        // org.benf.cfr.reader.b.a.a.b.ad.a(Misc.java:226)
        // org.benf.cfr.reader.b.a.a.b.l.a(ConditionalRewriter.java:623)
        // org.benf.cfr.reader.b.a.a.b.l.a(ConditionalRewriter.java:52)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:576)
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

    public void onConnectionChanged() {
        StringBuilder stringBuilder = new StringBuilder("window.mraidview.fireChangeEvent({ network: '");
        stringBuilder.append(this.getNetwork());
        stringBuilder.append("'});");
        String string = stringBuilder.toString();
        TapjoyLog.d("MRAID Network", string);
        this.a.injectMraidJavaScript(string);
    }

    public void startNetworkListener() {
        if (this.d == 0) {
            this.e = new NetworkBroadcastReceiver(this);
            this.f = new IntentFilter();
            this.f.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        }
        this.d = 1 + this.d;
        this.b.registerReceiver((BroadcastReceiver)this.e, this.f);
    }

    @Override
    public void stopAllListeners() {
        this.d = 0;
        try {
            this.b.unregisterReceiver((BroadcastReceiver)this.e);
        }
        catch (Exception exception) {}
    }

    public void stopNetworkListener() {
        this.d = -1 + this.d;
        if (this.d == 0) {
            this.b.unregisterReceiver((BroadcastReceiver)this.e);
            this.e = null;
            this.f = null;
        }
    }
}


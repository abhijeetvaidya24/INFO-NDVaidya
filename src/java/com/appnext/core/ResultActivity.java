/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.app.Activity
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.ActivityInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.ResolveInfo
 *  android.graphics.Paint
 *  android.net.Uri
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.webkit.WebSettings
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.List
 */
package com.appnext.core;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class ResultActivity
extends Activity {
    private Intent gA;
    private WebView webView;

    private static Intent V(String string2) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse((String)string2));
        return intent;
    }

    static /* synthetic */ Intent a(ResultActivity resultActivity, String string2) {
        return ResultActivity.V(string2);
    }

    private static List a(Context context, Intent intent) {
        List list = context.getPackageManager().queryIntentActivities(intent, 0);
        ArrayList arrayList = new ArrayList();
        for (ResolveInfo resolveInfo : list) {
            arrayList.add((Object)new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name));
        }
        return arrayList;
    }

    static /* synthetic */ void b(ResultActivity resultActivity, String string2) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse((String)string2));
        intent.addFlags(268435456);
        resultActivity.startActivity(intent);
    }

    private void bj() {
        this.onBackPressed();
    }

    private void openLink(String string2) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse((String)string2));
        intent.addFlags(268435456);
        this.startActivity(intent);
    }

    public final boolean hasNewResolver(Intent intent) {
        if (this.gA == null) {
            return intent != null;
        }
        if (intent == null) {
            return false;
        }
        List list = ResultActivity.a((Context)this, intent);
        HashSet hashSet = new HashSet();
        hashSet.addAll((Collection)ResultActivity.a((Context)this, this.gA));
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            if (hashSet.contains((Object)((ComponentName)iterator.next()))) continue;
            return true;
        }
        return false;
    }

    public void onBackPressed() {
        try {
            if (this.webView != null && this.webView.canGoBack()) {
                this.webView.goBack();
                return;
            }
            super.onBackPressed();
            return;
        }
        catch (Throwable throwable) {
            this.finish();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @SuppressLint(value={"SetJavaScriptEnabled"})
    protected void onCreate(Bundle bundle) {
        this.requestWindowFeature(1);
        super.onCreate(bundle);
        LinearLayout linearLayout = new LinearLayout((Context)this);
        this.setContentView((View)linearLayout);
        linearLayout.setOrientation(1);
        this.webView = new WebView(this.getApplicationContext());
        this.webView.getSettings().setTextZoom(100);
        this.webView.getSettings().setJavaScriptEnabled(true);
        this.webView.getSettings().setAppCacheEnabled(true);
        this.webView.getSettings().setDomStorageEnabled(true);
        this.webView.getSettings().setDatabaseEnabled(true);
        if (Build.VERSION.SDK_INT >= 21) {
            this.webView.getSettings().setMixedContentMode(0);
        }
        if (Build.VERSION.SDK_INT >= 17) {
            this.webView.getSettings().setMediaPlaybackRequiresUserGesture(false);
        }
        if (Build.VERSION.SDK_INT >= 19) {
            this.webView.setLayerType(2, null);
        } else {
            this.webView.setLayerType(1, null);
        }
        this.webView.setWebViewClient(new WebViewClient(){

            /*
             * Exception decompiling
             */
            public final boolean shouldOverrideUrlLoading(WebView var1, String var2) {
                // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl152.1 : ICONST_0 : trying to set 1 previously set to 0
                // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
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
        });
        linearLayout.addView((View)this.webView);
        this.webView.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, 0));
        ((LinearLayout.LayoutParams)this.webView.getLayoutParams()).weight = 1.0f;
        try {
            Intent intent;
            String string2 = this.getIntent().getExtras().getString("url");
            this.getIntent().getExtras().getString("title");
            new StringBuilder("loading result page ").append(string2);
            this.gA = new Intent(ResultActivity.V(string2)).setComponent(null);
            if (Build.VERSION.SDK_INT >= 15 && (intent = this.gA.getSelector()) != null) {
                intent.setComponent(null);
            }
            this.webView.loadUrl(string2);
            return;
        }
        catch (Throwable throwable) {
            this.finish();
            return;
        }
    }

}


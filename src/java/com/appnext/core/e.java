/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.ActivityInfo
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.pm.ResolveInfo
 *  android.net.Uri
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.text.TextUtils
 *  android.webkit.WebSettings
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  com.appnext.core.AppnextAd
 *  com.appnext.core.e$1
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.List
 */
package com.appnext.core;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.appnext.core.AppnextAd;
import com.appnext.core.e;
import com.appnext.core.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class e {
    @SuppressLint(value={"StaticFieldLeak"})
    private static e gD;
    private static final long gr = 8000L;
    private static final long gs = 15000L;
    private static final String gt = "com.android.vending";
    private static final String gu = "market://";
    private static final String gv = "https://play.google.com/store";
    private Context context;
    private Intent gA;
    private final ArrayList<b> gB;
    private int gC;
    private WebView gw;
    private WebView gx;
    private a gy;
    private Runnable gz;
    private Handler handler;

    @SuppressLint(value={"SetJavaScriptEnabled"})
    private e(Context context) {
        this.context = context.getApplicationContext();
        this.handler = new Handler(Looper.getMainLooper());
        this.gB = new ArrayList();
        this.gC = 0;
        this.gy = new 1(this);
        this.gz = new Runnable(){

            public final void run() {
                if (e.this.gy != null && e.this.gw != null) {
                    e.this.gy.error(e.this.gw.getUrl());
                    e.this.gw.stopLoading();
                }
                e.this.aZ();
            }
        };
    }

    private boolean S(String string2) {
        try {
            this.context.getPackageManager().getPackageInfo(string2, 0);
            return true;
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            return false;
        }
    }

    private void T(String string2) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse((String)string2));
        for (ResolveInfo resolveInfo : this.context.getPackageManager().queryIntentActivities(intent, 0)) {
            if (!resolveInfo.activityInfo.applicationInfo.packageName.equals((Object)gt)) continue;
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            ComponentName componentName = new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name);
            intent.addFlags(268435456);
            intent.addFlags(2097152);
            intent.addFlags(67108864);
            intent.setComponent(componentName);
            this.context.startActivity(intent);
            break;
        }
    }

    private void U(String string2) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse((String)string2));
        intent.setFlags(268435456);
        this.context.startActivity(intent);
    }

    private static Intent V(String string2) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse((String)string2));
        return intent;
    }

    static /* synthetic */ WebView a(e e2, WebView webView) {
        e2.gx = webView;
        return webView;
    }

    static /* synthetic */ ArrayList a(e e2) {
        return e2.gB;
    }

    private static List a(Context context, Intent intent) {
        List list = context.getPackageManager().queryIntentActivities(intent, 0);
        ArrayList arrayList = new ArrayList();
        for (ResolveInfo resolveInfo : list) {
            arrayList.add((Object)new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name));
        }
        return arrayList;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @SuppressLint(value={"SetJavaScriptEnabled"})
    private void a(final b b2) {
        try {
            Intent intent;
            new StringBuilder("ClickMarketUrl - ").append(b2.gN);
            if (!TextUtils.isEmpty((CharSequence)b2.gN)) {
                this.openMarket(b2.gN);
                new Thread(new Runnable(){

                    public final void run() {
                        try {
                            f.a(b2.gM, null);
                        }
                        catch (Throwable throwable) {}
                    }
                }).start();
                return;
            }
            this.ba();
            if (this.gw == null) {
                this.gw = new WebView(this.context);
                this.gw.getSettings().setJavaScriptEnabled(true);
                this.gw.getSettings().setDomStorageEnabled(true);
                if (Build.VERSION.SDK_INT >= 21) {
                    this.gw.getSettings().setMixedContentMode(0);
                }
                this.gw.setWebViewClient(new WebViewClient(){

                    /*
                     * Enabled aggressive block sorting
                     * Enabled unnecessary exception pruning
                     * Enabled aggressive exception aggregation
                     */
                    public final boolean shouldOverrideUrlLoading(WebView webView, String string2) {
                        block13 : {
                            block14 : {
                                if (string2 == null) {
                                    return false;
                                }
                                new StringBuilder("redirect url: ").append(string2);
                                if (string2.startsWith("https://play.google.com/store/apps/")) {
                                    string2 = string2.replace((CharSequence)"https://play.google.com/store/apps/", (CharSequence)e.gu);
                                }
                                if (string2.contains((CharSequence)"about:blank")) {
                                    return false;
                                }
                                if (string2.startsWith("http://") || string2.startsWith("https://")) break block13;
                                if (!string2.startsWith("intent://")) break block14;
                                try {
                                    block17 : {
                                        String string3;
                                        block16 : {
                                            Intent intent;
                                            block15 : {
                                                intent = Intent.parseUri((String)string2, (int)1);
                                                if (e.this.context.getPackageManager().resolveActivity(intent, 65536) != null) {
                                                    e.this.ba();
                                                    if (e.this.gy == null) return true;
                                                    e.this.gy.onMarket(intent.getData().toString());
                                                    return true;
                                                }
                                                Bundle bundle = intent.getExtras();
                                                if (bundle == null || !intent.getExtras().containsKey("browser_fallback_url") || intent.getExtras().getString("browser_fallback_url").equals((Object)"")) break block15;
                                                string3 = intent.getExtras().getString("browser_fallback_url");
                                                break block16;
                                            }
                                            if (!intent.getExtras().containsKey("market_referrer") || intent.getExtras().getString("market_referrer").equals((Object)"")) break block17;
                                            StringBuilder stringBuilder = new StringBuilder("market://details?id=");
                                            stringBuilder.append(intent.getPackage());
                                            stringBuilder.append("&referrer=");
                                            stringBuilder.append(intent.getExtras().getString("market_referrer"));
                                            string3 = stringBuilder.toString();
                                        }
                                        e.this.ba();
                                        if (e.this.gy == null) return true;
                                        e.this.gy.onMarket(string3);
                                        return true;
                                    }
                                    e.this.ba();
                                    if (e.this.gy == null) return true;
                                    e.this.gy.error(string2);
                                    return true;
                                }
                                catch (Throwable throwable) {
                                    return false;
                                }
                            }
                            Intent intent = new Intent("android.intent.action.VIEW");
                            intent.setData(Uri.parse((String)string2));
                            try {
                                if (e.this.context.getPackageManager().queryIntentActivities(intent, 0).size() > 0) {
                                    e.this.ba();
                                    if (e.this.gy == null) return true;
                                    e.this.gy.onMarket(string2);
                                    return true;
                                }
                                webView.loadUrl(string2);
                                return false;
                            }
                            catch (Throwable throwable) {}
                            return false;
                        }
                        e e2 = e.this;
                        if (e2.hasNewResolver(e.V(string2).setComponent(null))) {
                            e.this.ba();
                            if (e.this.gy == null) return true;
                            e.this.gy.onMarket(string2);
                            return true;
                        }
                        webView.loadUrl(string2);
                        return true;
                    }
                });
            }
            this.gw.stopLoading();
            this.gw.loadUrl("about:blank");
            this.gA = new Intent(e.V(b2.aQ)).setComponent(null);
            if (Build.VERSION.SDK_INT >= 15 && (intent = this.gA.getSelector()) != null) {
                intent.setComponent(null);
            }
            this.gw.loadUrl(b2.aQ);
            new StringBuilder("appurl: ").append(b2.aQ);
            Handler handler = this.handler;
            Runnable runnable = this.gz;
            long l2 = b2.aQ.endsWith("&ox=0") ? 15000L : b2.gQ;
            handler.postDelayed(runnable, l2);
            return;
        }
        catch (Throwable throwable) {
            a a2 = this.gy;
            if (a2 != null) {
                a2.error(b2.aQ);
            }
            this.aZ();
            return;
        }
    }

    static /* synthetic */ void a(e e2, int n2) {
        e2.gC = 0;
    }

    private void aZ() {
        this.gC = 0;
        if (this.gB.size() == 0) {
            return;
        }
        new StringBuilder("--ck-- out ").append(((b)this.gB.get((int)0)).aQ);
        ((b)this.gB.get((int)0)).gO = null;
        this.gB.remove(0);
        new StringBuilder("--ck-- size ").append(this.gB.size());
        this.a(null, null, null, null, null);
    }

    private void ba() {
        Handler handler = this.handler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    static /* synthetic */ WebView c(e e2) {
        return e2.gx;
    }

    public static void destroy() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static e k(Context context) {
        if (gD != null) return gD;
        Class<e> class_ = e.class;
        synchronized (e.class) {
            if (gD != null) return gD;
            gD = new e(context);
            // ** MonitorExit[var2_1] (shouldn't be in output)
            return gD;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void openMarket(String string2) {
        try {
            boolean bl = string2.startsWith(gu);
            if ((bl || string2.startsWith(gv)) && this.S(gt)) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse((String)string2));
                for (ResolveInfo resolveInfo : this.context.getPackageManager().queryIntentActivities(intent, 0)) {
                    if (!resolveInfo.activityInfo.applicationInfo.packageName.equals((Object)gt)) continue;
                    ActivityInfo activityInfo = resolveInfo.activityInfo;
                    ComponentName componentName = new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name);
                    intent.addFlags(268435456);
                    intent.addFlags(2097152);
                    intent.addFlags(67108864);
                    intent.setComponent(componentName);
                    this.context.startActivity(intent);
                    break;
                }
            } else {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse((String)string2));
                intent.setFlags(268435456);
                this.context.startActivity(intent);
            }
            if (this.gy != null) {
                this.gy.onMarket(string2);
            }
            return;
        }
        catch (Throwable throwable) {
            a a2 = this.gy;
            if (a2 != null) {
                a2.error(string2);
            }
            return;
        }
    }

    private void setState(int n2) {
        this.gC = n2;
    }

    public final void a(String string2, String string3, String string4, String string5, a a2) {
        this.a(string2, string3, string4, string5, a2, 8000L);
    }

    public final void a(String string2, String string3, String string4, String string5, a a2, long l2) {
        if (this.context == null) {
            return;
        }
        if (string4 != null) {
            Iterator iterator = this.gB.iterator();
            while (iterator.hasNext()) {
                if (!((b)iterator.next()).aQ.equals((Object)string4)) continue;
                return;
            }
            if (string4.endsWith("&ox=0")) {
                ArrayList<b> arrayList = this.gB;
                b b2 = new b(string2, string3, string4, string5, a2, l2);
                arrayList.add((Object)b2);
                new StringBuilder("--ck-- in ").append(string4);
            } else {
                this.gC = 0;
                if (this.gB.size() > 0 && !((b)this.gB.get((int)0)).aQ.endsWith("&ox=0")) {
                    new StringBuilder("--ck-- out ").append(((b)this.gB.get((int)0)).aQ);
                    ((b)this.gB.get((int)0)).gO = null;
                    this.gB.remove(0);
                    new StringBuilder("--ck-- size ").append(this.gB.size());
                }
                ArrayList<b> arrayList = this.gB;
                b b3 = new b(string2, string3, string4, string5, a2, l2);
                arrayList.add(0, (Object)b3);
                new StringBuilder("--ck-- in ").append(string4);
            }
        }
        if (this.gB.size() > 0 && this.gC != 1) {
            this.gC = 1;
            StringBuilder stringBuilder = new StringBuilder("vta load -  ");
            stringBuilder.append(((b)this.gB.get((int)0)).gP);
            stringBuilder.append(" - ");
            stringBuilder.append(((b)this.gB.get((int)0)).aQ);
            this.a((b)this.gB.get(0));
            return;
        }
        StringBuilder stringBuilder = new StringBuilder("vta waiting -  ");
        stringBuilder.append(string5);
        stringBuilder.append(" - ");
        stringBuilder.append(string4);
    }

    public final void a(final String string2, final String string3, final String string4, final String string5, final String string6, final String string7) {
        Runnable runnable = new Runnable(){

            public final void run() {
                try {
                    HashMap hashMap = new HashMap();
                    hashMap.put((Object)"guid", (Object)string2);
                    hashMap.put((Object)"bannerId", (Object)string3);
                    hashMap.put((Object)"placementId", (Object)string4);
                    hashMap.put((Object)"vid", (Object)string5);
                    hashMap.put((Object)"url", (Object)string6);
                    StringBuilder stringBuilder = new StringBuilder("https://admin.appnext.com/AdminService.asmx/");
                    stringBuilder.append(string7);
                    f.a(stringBuilder.toString(), (HashMap<String, String>)hashMap);
                }
                catch (Throwable throwable) {}
            }
        };
        new Thread(runnable).start();
    }

    public final void e(final AppnextAd appnextAd) {
        new Thread(new Runnable(){

            public final void run() {
                try {
                    f.a(appnextAd.getImpressionURL(), null);
                }
                catch (Throwable throwable) {}
            }
        }).start();
    }

    public final void f(final AppnextAd appnextAd) {
        new Thread(new Runnable(){

            public final void run() {
                try {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(appnextAd.getImpressionURL());
                    stringBuilder.append("&device=");
                    stringBuilder.append(f.bc());
                    stringBuilder.append("&ox=0");
                    f.a(stringBuilder.toString(), null);
                }
                catch (Throwable throwable) {}
            }
        }).start();
    }

    protected void finalize() throws Throwable {
        super.finalize();
    }

    public final boolean hasNewResolver(Intent intent) {
        if (this.gA == null) {
            return intent != null;
        }
        if (intent == null) {
            return false;
        }
        List list = e.a(this.context, intent);
        HashSet hashSet = new HashSet();
        hashSet.addAll((Collection)e.a(this.context, this.gA));
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            if (hashSet.contains((Object)((ComponentName)iterator.next()))) continue;
            return true;
        }
        return false;
    }

    public static interface a {
        public void error(String var1);

        public void onMarket(String var1);
    }

    private final class b {
        String aQ;
        String gM;
        String gN;
        a gO;
        String gP;
        long gQ;

        b(String string2, String string3, String string4, String string5, a a2, long l2) {
            this.gM = string2;
            this.gN = string3;
            this.aQ = string4;
            this.gO = a2;
            this.gP = string5;
            this.gQ = l2;
        }

        public final void error(String string2) {
            a a2 = this.gO;
            if (a2 != null) {
                a2.error(string2);
            }
        }

        public final void onMarket(String string2) {
            a a2 = this.gO;
            if (a2 != null) {
                a2.onMarket(string2);
            }
        }
    }

}


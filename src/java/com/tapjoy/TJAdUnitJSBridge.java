/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.annotation.TargetApi
 *  android.app.Activity
 *  android.app.AlertDialog
 *  android.app.AlertDialog$Builder
 *  android.app.ProgressDialog
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.content.Intent
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageManager
 *  android.graphics.Paint
 *  android.graphics.drawable.Drawable
 *  android.net.Uri
 *  android.os.AsyncTask
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Looper
 *  android.util.Pair
 *  android.view.View
 *  android.view.ViewParent
 *  android.webkit.WebView
 *  android.widget.RelativeLayout
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.reflect.Method
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.concurrent.ConcurrentLinkedQueue
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.tapjoy;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.View;
import android.view.ViewParent;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.moat.analytics.mobile.tjy.MoatAdEvent;
import com.moat.analytics.mobile.tjy.MoatAdEventType;
import com.moat.analytics.mobile.tjy.MoatFactory;
import com.moat.analytics.mobile.tjy.ReactiveVideoTracker;
import com.moat.analytics.mobile.tjy.ReactiveVideoTrackerPlugin;
import com.moat.analytics.mobile.tjy.ac;
import com.tapjoy.TJAdUnit;
import com.tapjoy.TJAdUnitActivity;
import com.tapjoy.TJAdUnitJSBridge;
import com.tapjoy.TJPlacementManager;
import com.tapjoy.TJSplitWebView;
import com.tapjoy.TJWebViewJSInterface;
import com.tapjoy.TJWebViewJSInterfaceListener;
import com.tapjoy.TapjoyAppSettings;
import com.tapjoy.TapjoyCache;
import com.tapjoy.TapjoyErrorMessage;
import com.tapjoy.TapjoyLog;
import com.tapjoy.TapjoyUtil;
import com.tapjoy.internal.ct;
import com.tapjoy.mraid.view.MraidView;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint(value={"SetJavaScriptEnabled"})
public class TJAdUnitJSBridge
implements TJWebViewJSInterfaceListener {
    final ConcurrentLinkedQueue a = new ConcurrentLinkedQueue();
    public boolean allowRedirect = true;
    private TJWebViewJSInterface b;
    private TJAdUnitJSBridge c;
    public boolean closeRequested = false;
    public boolean customClose = false;
    private Context d;
    public boolean didLaunchOtherActivity = false;
    private TJAdUnitActivity e;
    private TJAdUnit f;
    private WebView g;
    private TJSplitWebView h;
    private ProgressDialog i;
    private View j = null;
    private boolean k;
    private ReactiveVideoTracker l;
    private HashMap m;
    private Handler n;
    public String otherActivityCallbackID = null;
    public String splitWebViewCallbackID = null;

    public TJAdUnitJSBridge(Context context, WebView webView) {
        TapjoyLog.i("TJAdUnitJSBridge", "creating AdUnit/JS Bridge");
        this.d = context;
        this.g = webView;
        this.c = this;
        WebView webView2 = this.g;
        if (webView2 == null) {
            TapjoyLog.e("TJAdUnitJSBridge", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.SDK_ERROR, "Cannot create AdUnitJSBridge -- webview is NULL"));
            return;
        }
        this.b = new TJWebViewJSInterface(webView2, this);
        this.g.addJavascriptInterface((Object)this.b, "AndroidJavascriptInterface");
        this.setEnabled(true);
    }

    public TJAdUnitJSBridge(Context context, TJAdUnit tJAdUnit) {
        this(context, tJAdUnit.getWebView());
        this.f = tJAdUnit;
    }

    static /* synthetic */ View a(TJAdUnitJSBridge tJAdUnitJSBridge) {
        return tJAdUnitJSBridge.j;
    }

    static /* synthetic */ View a(TJAdUnitJSBridge tJAdUnitJSBridge, View view) {
        tJAdUnitJSBridge.j = view;
        return view;
    }

    static /* synthetic */ TJSplitWebView a(TJAdUnitJSBridge tJAdUnitJSBridge, TJSplitWebView tJSplitWebView) {
        tJAdUnitJSBridge.h = tJSplitWebView;
        return tJSplitWebView;
    }

    static /* synthetic */ WebView c(TJAdUnitJSBridge tJAdUnitJSBridge) {
        return tJAdUnitJSBridge.g;
    }

    static /* synthetic */ TJSplitWebView d(TJAdUnitJSBridge tJAdUnitJSBridge) {
        return tJAdUnitJSBridge.h;
    }

    static /* synthetic */ TJAdUnitActivity e(TJAdUnitJSBridge tJAdUnitJSBridge) {
        return tJAdUnitJSBridge.e;
    }

    static /* synthetic */ ReactiveVideoTracker f(TJAdUnitJSBridge tJAdUnitJSBridge) {
        return tJAdUnitJSBridge.l;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public void alert(JSONObject jSONObject, String string) {
        String string2;
        JSONArray jSONArray;
        String string3;
        block10 : {
            void var6_9;
            block11 : {
                string2 = "";
                StringBuilder stringBuilder = new StringBuilder("alert_method: ");
                stringBuilder.append((Object)jSONObject);
                TapjoyLog.d("TJAdUnitJSBridge", stringBuilder.toString());
                string3 = jSONObject.getString("title");
                try {
                    string2 = jSONObject.getString("message");
                    jSONArray = jSONObject.getJSONArray("buttons");
                    break block10;
                }
                catch (Exception exception) {
                    break block11;
                }
                catch (Exception exception) {
                    string3 = string2;
                }
            }
            Object[] arrobject = new Object[]{Boolean.FALSE};
            this.invokeJSCallback(string, arrobject);
            var6_9.printStackTrace();
            jSONArray = null;
        }
        TJAdUnitActivity tJAdUnitActivity = this.e;
        if (tJAdUnitActivity == null) {
            TapjoyLog.d("TJAdUnitJSBridge", "Cannot alert -- TJAdUnitActivity is null");
            return;
        }
        AlertDialog alertDialog = new AlertDialog.Builder((Context)tJAdUnitActivity).setTitle((CharSequence)string3).setMessage((CharSequence)string2).create();
        if (jSONArray == null || jSONArray.length() == 0) {
            Object[] arrobject = new Object[]{Boolean.FALSE};
            this.invokeJSCallback(string, arrobject);
            return;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        do {
            if (i2 >= jSONArray.length()) {
                alertDialog.setCancelable(false);
                alertDialog.setCanceledOnTouchOutside(false);
                alertDialog.show();
                return;
            }
            int n2 = i2 != 0 ? (i2 != 1 ? -1 : -3) : -2;
            try {
                arrayList.add((Object)jSONArray.getString(i2));
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
            alertDialog.setButton(n2, (CharSequence)arrayList.get(i2), new DialogInterface.OnClickListener(this, string){
                final /* synthetic */ String a;
                final /* synthetic */ TJAdUnitJSBridge b;
                {
                    this.b = tJAdUnitJSBridge;
                    this.a = string;
                }

                public final void onClick(DialogInterface dialogInterface, int n2) {
                    int n3 = n2 != -3 ? (n2 == -2 || n2 != -1 ? 0 : 2) : 1;
                    try {
                        TJAdUnitJSBridge tJAdUnitJSBridge = this.b;
                        String string = this.a;
                        Object[] arrobject = new Object[]{n3};
                        tJAdUnitJSBridge.invokeJSCallback(string, arrobject);
                        return;
                    }
                    catch (Exception exception) {
                        exception.printStackTrace();
                        return;
                    }
                }
            });
            ++i2;
        } while (true);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void attachVolumeListener(JSONObject jSONObject, String string) {
        try {
            boolean bl = jSONObject.getBoolean("attach");
            int n2 = jSONObject.optInt("interval", 500);
            if (n2 > 0) {
                this.f.attachVolumeListener(bl, n2);
                Object[] arrobject = new Object[]{true};
                this.invokeJSCallback(string, arrobject);
                return;
            }
            StringBuilder stringBuilder = new StringBuilder("Invalid `interval` value passed to attachVolumeListener(): interval=");
            stringBuilder.append(n2);
            TapjoyLog.d("TJAdUnitJSBridge", stringBuilder.toString());
            Object[] arrobject = new Object[]{false};
            this.invokeJSCallback(string, arrobject);
            return;
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder("attachVolumeListener exception ");
            stringBuilder.append(exception.toString());
            TapjoyLog.d("TJAdUnitJSBridge", stringBuilder.toString());
            Object[] arrobject = new Object[]{false};
            this.invokeJSCallback(string, arrobject);
            exception.printStackTrace();
            return;
        }
    }

    /*
     * Exception decompiling
     */
    public void cacheAsset(JSONObject var1, String var2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl15 : FAKE_TRY : trying to set 1 previously set to 0
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

    public void cachePathForURL(JSONObject jSONObject, String string) {
        String string2;
        try {
            string2 = jSONObject.getString("url");
        }
        catch (Exception exception) {
            this.invokeJSCallback(string, "");
            return;
        }
        if (TapjoyCache.getInstance() != null) {
            Object[] arrobject = new Object[]{TapjoyCache.getInstance().getPathOfCachedURL(string2)};
            this.invokeJSCallback(string, arrobject);
            return;
        }
        this.invokeJSCallback(string, "");
    }

    public void checkAppInstalled(JSONObject jSONObject, String string) {
        String string2;
        try {
            string2 = jSONObject.getString("bundle");
        }
        catch (Exception exception) {
            exception.printStackTrace();
            string2 = "";
        }
        if (string2 != null && string2.length() > 0) {
            Iterator iterator = this.d.getPackageManager().getInstalledApplications(0).iterator();
            while (iterator.hasNext()) {
                if (!((ApplicationInfo)iterator.next()).packageName.equals((Object)string2)) continue;
                Object[] arrobject = new Object[]{Boolean.TRUE};
                this.invokeJSCallback(string, arrobject);
                return;
            }
        }
        Object[] arrobject = new Object[]{Boolean.FALSE};
        this.invokeJSCallback(string, arrobject);
    }

    public void clearCache(JSONObject jSONObject, String string) {
        if (TapjoyCache.getInstance() != null) {
            TapjoyCache.getInstance().clearTapjoyCache();
            Object[] arrobject = new Object[]{Boolean.TRUE};
            this.invokeJSCallback(string, arrobject);
            return;
        }
        Object[] arrobject = new Object[]{Boolean.FALSE};
        this.invokeJSCallback(string, arrobject);
    }

    public void clearLoggingLevel(JSONObject jSONObject, String string) {
        TapjoyAppSettings.getInstance().clearLoggingLevel();
    }

    public void clearVideo(JSONObject jSONObject, final String string) {
        TJAdUnit tJAdUnit = this.f;
        if (tJAdUnit != null) {
            tJAdUnit.clearVideo(new AdUnitAsyncTaskListner(){

                @Override
                public final void onComplete(boolean bl) {
                    TJAdUnitJSBridge tJAdUnitJSBridge = TJAdUnitJSBridge.this;
                    String string2 = string;
                    Object[] arrobject = new Object[]{bl};
                    tJAdUnitJSBridge.invokeJSCallback(string2, arrobject);
                }
            });
        }
    }

    public void closeRequested(Boolean bl) {
        this.closeRequested = true;
        HashMap hashMap = new HashMap();
        hashMap.put((Object)"forceClose", (Object)bl);
        this.invokeJSAdunitMethod("closeRequested", (Map)hashMap);
    }

    public void contentReady(JSONObject jSONObject, String string) {
        TJAdUnit tJAdUnit = this.f;
        if (tJAdUnit != null) {
            tJAdUnit.fireContentReady();
            Object[] arrobject = new Object[]{true};
            this.invokeJSCallback(string, arrobject);
            return;
        }
        Object[] arrobject = new Object[]{false};
        this.invokeJSCallback(string, arrobject);
    }

    public void destroy() {
    }

    public void dismiss(JSONObject jSONObject, String string) {
        TJAdUnitActivity tJAdUnitActivity = this.e;
        if (tJAdUnitActivity != null) {
            Object[] arrobject = new Object[]{true};
            this.invokeJSCallback(string, arrobject);
            tJAdUnitActivity.finish();
            return;
        }
        TapjoyLog.d("TJAdUnitJSBridge", "Cannot dismiss -- TJAdUnitActivity is null");
        Object[] arrobject = new Object[]{false};
        this.invokeJSCallback(string, arrobject);
    }

    public void dismissSplitView(JSONObject jSONObject, String string) {
        TapjoyUtil.runOnMainThread(new Runnable(this, string){
            final /* synthetic */ String a;
            final /* synthetic */ TJAdUnitJSBridge b;
            {
                this.b = tJAdUnitJSBridge;
                this.a = string;
            }

            public final void run() {
                if (TJAdUnitJSBridge.d(this.b) != null) {
                    String string = this.a;
                    if (string != null) {
                        TJAdUnitJSBridge tJAdUnitJSBridge = this.b;
                        Object[] arrobject = new Object[]{Boolean.TRUE};
                        tJAdUnitJSBridge.invokeJSCallback(string, arrobject);
                    }
                    if (this.b.splitWebViewCallbackID != null) {
                        TJAdUnitJSBridge tJAdUnitJSBridge = this.b;
                        String string2 = tJAdUnitJSBridge.splitWebViewCallbackID;
                        Object[] arrobject = new Object[]{Boolean.TRUE};
                        tJAdUnitJSBridge.invokeJSCallback(string2, arrobject);
                        this.b.splitWebViewCallbackID = null;
                    }
                    ((android.view.ViewGroup)TJAdUnitJSBridge.d(this.b).getParent()).removeView((View)TJAdUnitJSBridge.d(this.b));
                    TJAdUnitJSBridge.a(this.b, null);
                    return;
                }
                String string = this.a;
                if (string != null) {
                    TJAdUnitJSBridge tJAdUnitJSBridge = this.b;
                    Object[] arrobject = new Object[]{Boolean.FALSE};
                    tJAdUnitJSBridge.invokeJSCallback(string, arrobject);
                }
            }
        });
    }

    public void display() {
        this.invokeJSAdunitMethod("display", new Object[0]);
    }

    /*
     * Exception decompiling
     */
    public void displayRichMedia(JSONObject var1, String var2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl8 : FAKE_TRY : trying to set 1 previously set to 0
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

    public void displayStoreURL(JSONObject jSONObject, String string) {
        this.displayURL(jSONObject, string);
    }

    public void displayURL(JSONObject jSONObject, String string) {
        try {
            String string2 = jSONObject.optString("style");
            String string3 = jSONObject.getString("url");
            JSONObject jSONObject2 = jSONObject.optJSONObject("splitViewLayout");
            JSONArray jSONArray = jSONObject.optJSONArray("splitViewExitHosts");
            if ("split".equals((Object)string2)) {
                Runnable runnable = new Runnable(this, jSONObject2, jSONArray, string, string3){
                    final /* synthetic */ JSONObject a;
                    final /* synthetic */ JSONArray b;
                    final /* synthetic */ String c;
                    final /* synthetic */ String d;
                    final /* synthetic */ TJAdUnitJSBridge e;
                    {
                        this.e = tJAdUnitJSBridge;
                        this.a = jSONObject;
                        this.b = jSONArray;
                        this.c = string;
                        this.d = string2;
                    }

                    public final void run() {
                        if (TJAdUnitJSBridge.c(this.e) != null) {
                            if (TJAdUnitJSBridge.d(this.e) == null) {
                                ViewParent viewParent = TJAdUnitJSBridge.c(this.e).getParent();
                                if (viewParent instanceof android.view.ViewGroup) {
                                    android.view.ViewGroup viewGroup = (android.view.ViewGroup)viewParent;
                                    TJAdUnitJSBridge tJAdUnitJSBridge = this.e;
                                    TJAdUnitJSBridge.a(tJAdUnitJSBridge, new TJSplitWebView(TJAdUnitJSBridge.b(tJAdUnitJSBridge), this.a, this.b, this.e));
                                    viewGroup.addView((View)TJAdUnitJSBridge.d(this.e), (android.view.ViewGroup$LayoutParams)new android.widget.RelativeLayout$LayoutParams(-1, -1));
                                }
                            } else {
                                TJAdUnitJSBridge.d(this.e).setExitHosts(this.b);
                                TJAdUnitJSBridge.d(this.e).applyLayoutOption(this.a);
                            }
                            if (TJAdUnitJSBridge.d(this.e) != null) {
                                TJAdUnitJSBridge tJAdUnitJSBridge = this.e;
                                tJAdUnitJSBridge.splitWebViewCallbackID = this.c;
                                TJAdUnitJSBridge.d(tJAdUnitJSBridge).loadUrl(this.d);
                                return;
                            }
                        }
                        TJAdUnitJSBridge.a(this.e, null);
                        TJAdUnitJSBridge tJAdUnitJSBridge = this.e;
                        tJAdUnitJSBridge.splitWebViewCallbackID = null;
                        String string = this.c;
                        Object[] arrobject = new Object[]{Boolean.FALSE};
                        tJAdUnitJSBridge.invokeJSCallback(string, arrobject);
                    }
                };
                TapjoyUtil.runOnMainThread(runnable);
                return;
            }
            this.didLaunchOtherActivity = true;
            this.otherActivityCallbackID = string;
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse((String)string3));
            this.d.startActivity(intent);
            return;
        }
        catch (Exception exception) {
            Object[] arrobject = new Object[]{Boolean.TRUE};
            this.invokeJSCallback(string, arrobject);
            exception.printStackTrace();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void displayVideo(JSONObject jSONObject, final String string) {
        try {
            String string2 = jSONObject.getString("url");
            if (string2.length() > 0 && string2 != "") {
                this.f.loadVideoUrl(string2, new AdUnitAsyncTaskListner(){

                    @Override
                    public final void onComplete(boolean bl) {
                        TJAdUnitJSBridge tJAdUnitJSBridge = TJAdUnitJSBridge.this;
                        String string2 = string;
                        Object[] arrobject = new Object[]{bl};
                        tJAdUnitJSBridge.invokeJSCallback(string2, arrobject);
                    }
                });
                return;
            }
            Object[] arrobject = new Object[]{Boolean.FALSE};
            this.invokeJSCallback(string, arrobject);
            return;
        }
        catch (Exception exception) {
            Object[] arrobject = new Object[]{Boolean.FALSE};
            this.invokeJSCallback(string, arrobject);
            exception.printStackTrace();
            return;
        }
    }

    public void endUsageTrackingEvent(JSONObject jSONObject, String string) {
        try {
            String string2 = jSONObject.getString("name");
            if (string2.isEmpty()) {
                TapjoyLog.d("TJAdUnitJSBridge", "Empty name for endUsageTrackingEvent");
                Object[] arrobject = new Object[]{false};
                this.invokeJSCallback(string, arrobject);
                return;
            }
            if (this.f != null) {
                this.f.endAdContentTracking(string2, jSONObject);
                Object[] arrobject = new Object[]{true};
                this.invokeJSCallback(string, arrobject);
                return;
            }
        }
        catch (JSONException jSONException) {
            StringBuilder stringBuilder = new StringBuilder("Unable to endUsageTrackingEvent. Invalid parameters: ");
            stringBuilder.append((Object)jSONException);
            TapjoyLog.w("TJAdUnitJSBridge", stringBuilder.toString());
        }
        Object[] arrobject = new Object[]{false};
        this.invokeJSCallback(string, arrobject);
    }

    public void flushBacklogMessageQueue() {
        Pair pair;
        while ((pair = (Pair)this.a.poll()) != null) {
            this.onDispatchMethod((String)pair.first, (JSONObject)pair.second);
        }
    }

    public void flushMessageQueue() {
        this.b.flushMessageQueue();
    }

    public void getCachedAssets(JSONObject jSONObject, String string) {
        if (TapjoyCache.getInstance() != null) {
            Object[] arrobject = new Object[]{TapjoyCache.getInstance().cachedAssetsToJSON()};
            this.invokeJSCallback(string, arrobject);
            return;
        }
        this.invokeJSCallback(string, "");
    }

    /*
     * Exception decompiling
     */
    public void getInstalledAppData(JSONObject var1, String var2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl16 : ALOAD : trying to set 1 previously set to 0
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

    public void getSplitViewURL(JSONObject jSONObject, String string) {
        TapjoyUtil.runOnMainThread(new Runnable(this, string){
            final /* synthetic */ String a;
            final /* synthetic */ TJAdUnitJSBridge b;
            {
                this.b = tJAdUnitJSBridge;
                this.a = string;
            }

            public final void run() {
                if (TJAdUnitJSBridge.d(this.b) != null) {
                    TJAdUnitJSBridge tJAdUnitJSBridge = this.b;
                    String string = this.a;
                    Object[] arrobject = new Object[]{TJAdUnitJSBridge.d(tJAdUnitJSBridge).getLastUrl()};
                    tJAdUnitJSBridge.invokeJSCallback(string, arrobject);
                    return;
                }
                TJAdUnitJSBridge tJAdUnitJSBridge = this.b;
                String string = this.a;
                Object[] arrobject = new Object[]{JSONObject.NULL};
                tJAdUnitJSBridge.invokeJSCallback(string, arrobject);
            }
        });
    }

    public void getVolume(JSONObject jSONObject, String string) {
        HashMap hashMap = this.getVolumeArgs();
        if (hashMap != null) {
            this.invokeJSCallback(string, (Map)hashMap);
            return;
        }
        Object[] arrobject = new Object[]{false};
        this.invokeJSCallback(string, arrobject);
    }

    public HashMap getVolumeArgs() {
        TJAdUnit tJAdUnit = this.f;
        if (tJAdUnit == null) {
            TapjoyLog.d("TJAdUnitJSBridge", "No ad unit provided");
            return null;
        }
        String string = tJAdUnit.getVolume();
        boolean bl = this.f.isMuted();
        StringBuilder stringBuilder = new StringBuilder("getVolumeArgs: volume=");
        stringBuilder.append(string);
        stringBuilder.append("; isMuted=");
        stringBuilder.append(bl);
        TapjoyLog.d("TJAdUnitJSBridge", stringBuilder.toString());
        HashMap hashMap = new HashMap();
        hashMap.put((Object)"currentVolume", (Object)string);
        hashMap.put((Object)"isMuted", (Object)bl);
        return hashMap;
    }

    public void hasSplitView(JSONObject jSONObject, String string) {
        TapjoyUtil.runOnMainThread(new Runnable(this, string){
            final /* synthetic */ String a;
            final /* synthetic */ TJAdUnitJSBridge b;
            {
                this.b = tJAdUnitJSBridge;
                this.a = string;
            }

            public final void run() {
                if (TJAdUnitJSBridge.d(this.b) != null) {
                    TJAdUnitJSBridge tJAdUnitJSBridge = this.b;
                    String string = this.a;
                    Object[] arrobject = new Object[]{Boolean.TRUE};
                    tJAdUnitJSBridge.invokeJSCallback(string, arrobject);
                    return;
                }
                TJAdUnitJSBridge tJAdUnitJSBridge = this.b;
                String string = this.a;
                Object[] arrobject = new Object[]{Boolean.FALSE};
                tJAdUnitJSBridge.invokeJSCallback(string, arrobject);
            }
        });
    }

    public void initMoatVideoTracker(JSONObject jSONObject, String string) {
        TJAdUnitActivity tJAdUnitActivity = this.e;
        Boolean bl = false;
        if (tJAdUnitActivity == null) {
            TapjoyLog.d("TJAdUnitJSBridge", "Error from initMoatVideoTracker -- TJAdUnitActivity is null");
            this.invokeJSCallback(string, new Object[]{bl});
            return;
        }
        try {
            String string2 = jSONObject.getString("partnerCode");
            this.l = (ReactiveVideoTracker)MoatFactory.create(tJAdUnitActivity).createCustomTracker(new ReactiveVideoTrackerPlugin(string2));
            if (this.m == null) {
                TapjoyLog.d("TJAdUnitJSBridge", "Initializing MOAT tracking events map");
                this.m = new HashMap();
                this.m.put((Object)"firstQuartile", (Object)MoatAdEventType.AD_EVT_FIRST_QUARTILE);
                this.m.put((Object)"midpoint", (Object)MoatAdEventType.AD_EVT_MID_POINT);
                this.m.put((Object)"thirdQuartile", (Object)MoatAdEventType.AD_EVT_THIRD_QUARTILE);
                this.m.put((Object)"complete", (Object)MoatAdEventType.AD_EVT_COMPLETE);
                this.m.put((Object)"paused", (Object)MoatAdEventType.AD_EVT_PAUSED);
                this.m.put((Object)"playing", (Object)MoatAdEventType.AD_EVT_PLAYING);
                this.m.put((Object)"start", (Object)MoatAdEventType.AD_EVT_START);
                this.m.put((Object)"stopped", (Object)MoatAdEventType.AD_EVT_STOPPED);
                this.m.put((Object)"skipped", (Object)MoatAdEventType.AD_EVT_SKIPPED);
                this.m.put((Object)"volumeChanged", (Object)MoatAdEventType.AD_EVT_VOLUME_CHANGE);
                this.m.put((Object)"enterFullScreen", (Object)MoatAdEventType.AD_EVT_ENTER_FULLSCREEN);
                this.m.put((Object)"exitFullScreen", (Object)MoatAdEventType.AD_EVT_EXIT_FULLSCREEN);
            }
            this.n = new Handler(Looper.getMainLooper());
            Object[] arrobject = new Object[]{true};
            this.invokeJSCallback(string, arrobject);
            return;
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder("initMoatVideoTracker exception ");
            stringBuilder.append(exception.toString());
            TapjoyLog.d("TJAdUnitJSBridge", stringBuilder.toString());
            this.invokeJSCallback(string, new Object[]{bl});
            return;
        }
    }

    public void invokeJSAdunitMethod(String string, Map map) {
        this.b.callback(map, string, null);
    }

    public /* varargs */ void invokeJSAdunitMethod(String string, Object ... arrobject) {
        ArrayList arrayList = new ArrayList((Collection)Arrays.asList((Object[])arrobject));
        this.b.callback(arrayList, string, null);
    }

    public void invokeJSCallback(String string, Map map) {
        this.b.callback(map, "", string);
    }

    public /* varargs */ void invokeJSCallback(String string, Object ... arrobject) {
        if (ct.c(string)) {
            TapjoyLog.d("TJAdUnitJSBridge", "invokeJSCallback -- no callbackID provided");
            return;
        }
        ArrayList arrayList = new ArrayList((Collection)Arrays.asList((Object[])arrobject));
        this.b.callback(arrayList, "", string);
    }

    public void log(JSONObject jSONObject, String string) {
        try {
            StringBuilder stringBuilder = new StringBuilder("Logging message=");
            stringBuilder.append(jSONObject.getString("message"));
            TapjoyLog.d("TJAdUnitJSBridge", stringBuilder.toString());
            Object[] arrobject = new Object[]{Boolean.TRUE};
            this.invokeJSCallback(string, arrobject);
            return;
        }
        catch (Exception exception) {
            Object[] arrobject = new Object[]{Boolean.FALSE};
            this.invokeJSCallback(string, arrobject);
            exception.printStackTrace();
            return;
        }
    }

    @TargetApi(value=19)
    public void nativeEval(JSONObject jSONObject, String string) {
        TapjoyUtil.runOnMainThread(new Runnable(this, jSONObject, string){
            final /* synthetic */ JSONObject a;
            final /* synthetic */ String b;
            final /* synthetic */ TJAdUnitJSBridge c;
            {
                this.c = tJAdUnitJSBridge;
                this.a = jSONObject;
                this.b = string;
            }

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            public final void run() {
                try {
                    int n2 = Build.VERSION.SDK_INT;
                    if (n2 >= 19) {
                        TJAdUnitJSBridge.c(this.c).evaluateJavascript(this.a.getString("command"), null);
                    } else {
                        WebView webView = TJAdUnitJSBridge.c(this.c);
                        StringBuilder stringBuilder = new StringBuilder("javascript:");
                        stringBuilder.append(this.a.getString("command"));
                        webView.loadUrl(stringBuilder.toString());
                    }
                    TJAdUnitJSBridge tJAdUnitJSBridge = this.c;
                    String string = this.b;
                    Object[] arrobject = new Object[]{Boolean.TRUE};
                    tJAdUnitJSBridge.invokeJSCallback(string, arrobject);
                    return;
                }
                catch (Exception exception) {
                    TJAdUnitJSBridge tJAdUnitJSBridge = this.c;
                    String string = this.b;
                    Object[] arrobject = new Object[]{Boolean.FALSE};
                    tJAdUnitJSBridge.invokeJSCallback(string, arrobject);
                    return;
                }
            }
        });
    }

    @Override
    public void onDispatchMethod(String string, JSONObject jSONObject) {
        if (this.k) {
            String string2 = null;
            try {
                string2 = jSONObject.optString("callbackId", null);
                JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                Method method = TJAdUnitJSBridge.class.getMethod(string, new Class[]{JSONObject.class, String.class});
                StringBuilder stringBuilder = new StringBuilder("Dispatching method: ");
                stringBuilder.append((Object)method);
                stringBuilder.append(" with data=");
                stringBuilder.append((Object)jSONObject2);
                stringBuilder.append("; callbackID=");
                stringBuilder.append(string2);
                TapjoyLog.d("TJAdUnitJSBridge", stringBuilder.toString());
                method.invoke((Object)this.c, new Object[]{jSONObject2, string2});
                return;
            }
            catch (Exception exception) {
                exception.printStackTrace();
                Object[] arrobject = new Object[]{Boolean.FALSE};
                this.invokeJSCallback(string2, arrobject);
                return;
            }
        }
        StringBuilder stringBuilder = new StringBuilder("Bridge currently disabled. Adding ");
        stringBuilder.append(string);
        stringBuilder.append(" to message queue");
        TapjoyLog.d("TJAdUnitJSBridge", stringBuilder.toString());
        this.a.add((Object)new Pair((Object)string, (Object)jSONObject));
    }

    public void onVideoCompletion() {
        HashMap hashMap = new HashMap();
        hashMap.put((Object)"videoEventName", (Object)"videoComplete");
        this.invokeJSAdunitMethod("videoEvent", (Map)hashMap);
    }

    public void onVideoError(String string) {
        HashMap hashMap = new HashMap();
        hashMap.put((Object)"videoEventName", (Object)"videoError");
        hashMap.put((Object)"error", (Object)string);
        this.invokeJSAdunitMethod("videoEvent", (Map)hashMap);
    }

    public void onVideoInfo(String string) {
        HashMap hashMap = new HashMap();
        hashMap.put((Object)"videoEventName", (Object)"videoInfo");
        hashMap.put((Object)"info", (Object)string);
        this.invokeJSAdunitMethod("videoEvent", (Map)hashMap);
    }

    public void onVideoPaused(int n2) {
        HashMap hashMap = new HashMap();
        hashMap.put((Object)"videoEventName", (Object)"videoPause");
        hashMap.put((Object)"currentTime", (Object)n2);
        this.invokeJSAdunitMethod("videoEvent", (Map)hashMap);
    }

    public void onVideoProgress(int n2) {
        HashMap hashMap = new HashMap();
        hashMap.put((Object)"videoEventName", (Object)"videoProgress");
        hashMap.put((Object)"currentTime", (Object)n2);
        this.invokeJSAdunitMethod("videoEvent", (Map)hashMap);
    }

    public void onVideoReady(int n2, int n3, int n4) {
        HashMap hashMap = new HashMap();
        hashMap.put((Object)"videoEventName", (Object)"videoReady");
        hashMap.put((Object)"videoDuration", (Object)n2);
        hashMap.put((Object)"videoWidth", (Object)n3);
        hashMap.put((Object)"videoHeight", (Object)n4);
        this.invokeJSAdunitMethod("videoEvent", (Map)hashMap);
    }

    public void onVideoStarted(int n2) {
        HashMap hashMap = new HashMap();
        hashMap.put((Object)"videoEventName", (Object)"videoStart");
        hashMap.put((Object)"currentTime", (Object)n2);
        this.invokeJSAdunitMethod("videoEvent", (Map)hashMap);
    }

    public void onVolumeChanged() {
        this.invokeJSAdunitMethod("volumeChanged", (Map)this.getVolumeArgs());
    }

    public void openApp(JSONObject jSONObject, String string) {
        try {
            String string2 = jSONObject.getString("bundle");
            Intent intent = this.d.getPackageManager().getLaunchIntentForPackage(string2);
            this.d.startActivity(intent);
            Object[] arrobject = new Object[]{Boolean.TRUE};
            this.invokeJSCallback(string, arrobject);
            return;
        }
        catch (Exception exception) {
            Object[] arrobject = new Object[]{Boolean.FALSE};
            this.invokeJSCallback(string, arrobject);
            exception.printStackTrace();
            return;
        }
    }

    public void pauseVideo(JSONObject jSONObject, String string) {
        TJAdUnit tJAdUnit = this.f;
        if (tJAdUnit != null) {
            Object[] arrobject = new Object[]{tJAdUnit.pauseVideo()};
            this.invokeJSCallback(string, arrobject);
        }
    }

    public void playVideo(JSONObject jSONObject, String string) {
        TJAdUnit tJAdUnit = this.f;
        if (tJAdUnit != null) {
            Object[] arrobject = new Object[]{tJAdUnit.playVideo()};
            this.invokeJSCallback(string, arrobject);
        }
    }

    /*
     * Exception decompiling
     */
    public void present(JSONObject var1_1, String var2_2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
        // org.benf.cfr.reader.b.a.a.j.b(Op04StructuredStatement.java:409)
        // org.benf.cfr.reader.b.a.a.j.d(Op04StructuredStatement.java:487)
        // org.benf.cfr.reader.b.a.a.i.a(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:692)
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

    public void removeAssetFromCache(JSONObject jSONObject, String string) {
        String string2;
        try {
            string2 = jSONObject.getString("url");
        }
        catch (Exception exception) {
            TapjoyLog.w("TJAdUnitJSBridge", "Unable to cache video. Invalid parameters.");
            Object[] arrobject = new Object[]{Boolean.FALSE};
            this.invokeJSCallback(string, arrobject);
            return;
        }
        if (TapjoyCache.getInstance() != null) {
            Object[] arrobject = new Object[]{TapjoyCache.getInstance().removeAssetFromCache(string2)};
            this.invokeJSCallback(string, arrobject);
            return;
        }
        Object[] arrobject = new Object[]{Boolean.FALSE};
        this.invokeJSCallback(string, arrobject);
    }

    public void sendUsageTrackingEvent(JSONObject jSONObject, String string) {
        try {
            String string2 = jSONObject.getString("name");
            if (string2.isEmpty()) {
                TapjoyLog.d("TJAdUnitJSBridge", "Empty name for sendUsageTrackingEvent");
                Object[] arrobject = new Object[]{false};
                this.invokeJSCallback(string, arrobject);
                return;
            }
            if (this.f != null) {
                this.f.sendAdContentTracking(string2, jSONObject);
                Object[] arrobject = new Object[]{true};
                this.invokeJSCallback(string, arrobject);
                return;
            }
        }
        catch (JSONException jSONException) {
            StringBuilder stringBuilder = new StringBuilder("Unable to sendUsageTrackingEvent. Invalid parameters: ");
            stringBuilder.append((Object)jSONException);
            TapjoyLog.w("TJAdUnitJSBridge", stringBuilder.toString());
        }
        Object[] arrobject = new Object[]{false};
        this.invokeJSCallback(string, arrobject);
    }

    public void setAdUnitActivity(TJAdUnitActivity tJAdUnitActivity) {
        this.e = tJAdUnitActivity;
    }

    /*
     * Exception decompiling
     */
    public void setAllowRedirect(JSONObject var1, String var2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl8 : ALOAD_0 : trying to set 1 previously set to 0
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

    public void setBackgroundColor(JSONObject jSONObject, final String string) {
        block2 : {
            String string2;
            TJAdUnit tJAdUnit;
            try {
                string2 = jSONObject.getString("backgroundColor");
                tJAdUnit = this.f;
                if (tJAdUnit == null) break block2;
            }
            catch (Exception exception) {
                TapjoyLog.w("TJAdUnitJSBridge", "Unable to set background color. Invalid parameters.");
                Object[] arrobject = new Object[]{false};
                this.invokeJSCallback(string, arrobject);
                return;
            }
            tJAdUnit.setBackgroundColor(string2, new AdUnitAsyncTaskListner(){

                @Override
                public final void onComplete(boolean bl) {
                    TJAdUnitJSBridge tJAdUnitJSBridge = TJAdUnitJSBridge.this;
                    String string2 = string;
                    Object[] arrobject = new Object[]{bl};
                    tJAdUnitJSBridge.invokeJSCallback(string2, arrobject);
                }
            });
            return;
        }
        Object[] arrobject = new Object[]{false};
        this.invokeJSCallback(string, arrobject);
    }

    public void setBackgroundWebViewContent(JSONObject jSONObject, final String string) {
        block2 : {
            String string2;
            TJAdUnit tJAdUnit;
            TapjoyLog.d("TJAdUnitJSBridge", "setBackgroundWebViewContent");
            try {
                string2 = jSONObject.getString("backgroundContent");
                tJAdUnit = this.f;
                if (tJAdUnit == null) break block2;
            }
            catch (Exception exception) {
                TapjoyLog.w("TJAdUnitJSBridge", "Unable to set background content. Invalid parameters.");
                Object[] arrobject = new Object[]{false};
                this.invokeJSCallback(string, arrobject);
                return;
            }
            tJAdUnit.setBackgroundContent(string2, new AdUnitAsyncTaskListner(){

                @Override
                public final void onComplete(boolean bl) {
                    TJAdUnitJSBridge tJAdUnitJSBridge = TJAdUnitJSBridge.this;
                    String string2 = string;
                    Object[] arrobject = new Object[]{bl};
                    tJAdUnitJSBridge.invokeJSCallback(string2, arrobject);
                }
            });
            return;
        }
        Object[] arrobject = new Object[]{false};
        this.invokeJSCallback(string, arrobject);
    }

    public void setCloseButtonClickable(JSONObject jSONObject, String string) {
        try {
            TapjoyUtil.runOnMainThread(new Runnable(this, jSONObject.optBoolean("clickable")){
                final /* synthetic */ boolean a;
                final /* synthetic */ TJAdUnitJSBridge b;
                {
                    this.b = tJAdUnitJSBridge;
                    this.a = bl;
                }

                public final void run() {
                    TJAdUnitActivity tJAdUnitActivity = TJAdUnitJSBridge.e(this.b);
                    if (tJAdUnitActivity != null) {
                        tJAdUnitActivity.setCloseButtonClickable(this.a);
                        return;
                    }
                    TapjoyLog.d("TJAdUnitJSBridge", "Cannot setCloseButtonClickable -- TJAdUnitActivity is null");
                }
            });
            Object[] arrobject = new Object[]{true};
            this.invokeJSCallback(string, arrobject);
            return;
        }
        catch (Exception exception) {
            Object[] arrobject = new Object[]{false};
            this.invokeJSCallback(string, arrobject);
            exception.printStackTrace();
            return;
        }
    }

    public void setCloseButtonVisible(JSONObject jSONObject, String string) {
        try {
            TapjoyUtil.runOnMainThread(new Runnable(this, jSONObject.getBoolean("visible")){
                final /* synthetic */ boolean a;
                final /* synthetic */ TJAdUnitJSBridge b;
                {
                    this.b = tJAdUnitJSBridge;
                    this.a = bl;
                }

                public final void run() {
                    TJAdUnitActivity tJAdUnitActivity = TJAdUnitJSBridge.e(this.b);
                    if (tJAdUnitActivity != null) {
                        tJAdUnitActivity.setCloseButtonVisibility(this.a);
                        return;
                    }
                    TapjoyLog.d("TJAdUnitJSBridge", "Cannot setCloseButtonVisible -- TJAdUnitActivity is null");
                }
            });
            Object[] arrobject = new Object[]{true};
            this.invokeJSCallback(string, arrobject);
            return;
        }
        catch (Exception exception) {
            Object[] arrobject = new Object[]{false};
            this.invokeJSCallback(string, arrobject);
            exception.printStackTrace();
            return;
        }
    }

    public void setEnabled(boolean bl) {
        this.k = bl;
        if (this.k) {
            this.flushBacklogMessageQueue();
        }
    }

    public void setEventPreloadLimit(JSONObject jSONObject, String string) {
        if (TapjoyCache.getInstance() != null) {
            int n2;
            try {
                n2 = jSONObject.getInt("eventPreloadLimit");
            }
            catch (Exception exception) {
                TapjoyLog.w("TJAdUnitJSBridge", "Unable to set Tapjoy cache's event preload limit. Invalid parameters.");
                Object[] arrobject = new Object[]{Boolean.FALSE};
                this.invokeJSCallback(string, arrobject);
                return;
            }
            TJPlacementManager.setCachedPlacementLimit(n2);
            Object[] arrobject = new Object[]{Boolean.TRUE};
            this.invokeJSCallback(string, arrobject);
            return;
        }
        Object[] arrobject = new Object[]{Boolean.FALSE};
        this.invokeJSCallback(string, arrobject);
    }

    public void setLoggingLevel(JSONObject jSONObject, String string) {
        try {
            String string2 = String.valueOf((Object)jSONObject.getString("loggingLevel"));
            TapjoyAppSettings.getInstance().saveLoggingLevel(string2);
            return;
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder("setLoggingLevel exception ");
            stringBuilder.append(exception.getLocalizedMessage());
            TapjoyLog.d("TJAdUnitJSBridge", stringBuilder.toString());
            Object[] arrobject = new Object[]{false};
            this.invokeJSCallback(string, arrobject);
            exception.printStackTrace();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setOrientation(JSONObject jSONObject, String string) {
        int n2;
        block4 : {
            block3 : {
                TJAdUnit tJAdUnit = this.f;
                Boolean bl = false;
                if (tJAdUnit == null) {
                    TapjoyLog.d("TJAdUnitJSBridge", "No ad unit provided");
                    this.invokeJSCallback(string, new Object[]{bl});
                    return;
                }
                try {
                    String string2 = jSONObject.getString("orientation");
                    if (string2.equals((Object)"landscape") || string2.equals((Object)"landscapeLeft")) break block3;
                    n2 = string2.equals((Object)"landscapeRight") ? 8 : 1;
                    break block4;
                }
                catch (Exception exception) {
                    this.invokeJSCallback(string, new Object[]{bl});
                    return;
                }
            }
            n2 = 0;
        }
        this.f.setOrientation(n2);
        Object[] arrobject = new Object[]{true};
        this.invokeJSCallback(string, arrobject);
    }

    public void setPrerenderLimit(JSONObject jSONObject, String string) {
        int n2;
        try {
            n2 = jSONObject.getInt("prerenderLimit");
        }
        catch (Exception exception) {
            TapjoyLog.w("TJAdUnitJSBridge", "Unable to set Tapjoy placement pre-render limit. Invalid parameters.");
            Object[] arrobject = new Object[]{Boolean.FALSE};
            this.invokeJSCallback(string, arrobject);
            return;
        }
        TJPlacementManager.setPreRenderedPlacementLimit(n2);
        Object[] arrobject = new Object[]{Boolean.TRUE};
        this.invokeJSCallback(string, arrobject);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setSpinnerVisible(JSONObject jSONObject, String string) {
        try {
            boolean bl = jSONObject.getBoolean("visible");
            String string2 = jSONObject.optString("title");
            String string3 = jSONObject.optString("message");
            TJAdUnitActivity tJAdUnitActivity = this.e;
            if (tJAdUnitActivity == null) {
                TapjoyLog.d("TJAdUnitJSBridge", "Cannot setSpinnerVisible -- TJAdUnitActivity is null");
                Object[] arrobject = new Object[]{Boolean.FALSE};
                this.invokeJSCallback(string, arrobject);
                return;
            }
            if (bl) {
                this.i = ProgressDialog.show((Context)tJAdUnitActivity, (CharSequence)string2, (CharSequence)string3);
            } else if (this.i != null) {
                this.i.dismiss();
            }
            Object[] arrobject = new Object[]{Boolean.TRUE};
            this.invokeJSCallback(string, arrobject);
            return;
        }
        catch (Exception exception) {
            Object[] arrobject = new Object[]{Boolean.FALSE};
            this.invokeJSCallback(string, arrobject);
            exception.printStackTrace();
            return;
        }
    }

    public void setVideoMute(JSONObject jSONObject, String string) {
        try {
            boolean bl = jSONObject.getBoolean("enabled");
            this.f.a(bl);
            Object[] arrobject = new Object[]{Boolean.TRUE};
            this.invokeJSCallback(string, arrobject);
            return;
        }
        catch (JSONException jSONException) {
            TapjoyLog.d("TJAdUnitJSBridge", "Failed to parse 'enabled' from json params.");
            Object[] arrobject = new Object[]{Boolean.FALSE};
            this.invokeJSCallback(string, arrobject);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void shouldClose(JSONObject jSONObject, String string) {
        TJAdUnitActivity tJAdUnitActivity = this.e;
        try {
            Boolean.valueOf((boolean)false);
            if (Boolean.valueOf((String)jSONObject.getString("close")).booleanValue() && tJAdUnitActivity != null) {
                tJAdUnitActivity.finish();
            }
            Object[] arrobject = new Object[]{Boolean.TRUE};
            this.invokeJSCallback(string, arrobject);
        }
        catch (Exception exception) {
            Object[] arrobject = new Object[]{Boolean.FALSE};
            this.invokeJSCallback(string, arrobject);
            if (tJAdUnitActivity != null) {
                tJAdUnitActivity.finish();
            }
            exception.printStackTrace();
        }
        this.closeRequested = false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void startMoatVideoTracker(JSONObject jSONObject, String string) {
        try {
            Integer n2 = jSONObject.getInt("videoLength");
            HashMap hashMap = new HashMap();
            JSONObject jSONObject2 = jSONObject.getJSONObject("adIds");
            if (jSONObject2 != null) {
                Iterator iterator = jSONObject2.keys();
                while (iterator.hasNext()) {
                    String string2 = (String)iterator.next();
                    hashMap.put((Object)string2, (Object)jSONObject2.getString(string2));
                }
            }
            this.n.post(new Runnable(this, (Map)hashMap, n2, string){
                final /* synthetic */ Map a;
                final /* synthetic */ Integer b;
                final /* synthetic */ String c;
                final /* synthetic */ TJAdUnitJSBridge d;
                {
                    this.d = tJAdUnitJSBridge;
                    this.a = map;
                    this.b = n2;
                    this.c = string;
                }

                public final void run() {
                    boolean bl = TJAdUnitJSBridge.f(this.d) != null ? TJAdUnitJSBridge.f(this.d).trackVideoAd(this.a, this.b, (View)TJAdUnitJSBridge.c(this.d)) : false;
                    TJAdUnitJSBridge tJAdUnitJSBridge = this.d;
                    String string = this.c;
                    Object[] arrobject = new Object[]{bl};
                    tJAdUnitJSBridge.invokeJSCallback(string, arrobject);
                }
            });
            return;
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder("startMoatVideoTracker exception ");
            stringBuilder.append(exception.toString());
            TapjoyLog.d("TJAdUnitJSBridge", stringBuilder.toString());
            Object[] arrobject = new Object[]{false};
            this.invokeJSCallback(string, arrobject);
            return;
        }
    }

    public void startUsageTrackingEvent(JSONObject jSONObject, String string) {
        try {
            String string2 = jSONObject.getString("name");
            if (string2.isEmpty()) {
                TapjoyLog.d("TJAdUnitJSBridge", "Empty name for startUsageTrackingEvent");
                Object[] arrobject = new Object[]{false};
                this.invokeJSCallback(string, arrobject);
                return;
            }
            if (this.f != null) {
                this.f.startAdContentTracking(string2, jSONObject);
                Object[] arrobject = new Object[]{true};
                this.invokeJSCallback(string, arrobject);
                return;
            }
        }
        catch (JSONException jSONException) {
            StringBuilder stringBuilder = new StringBuilder("Unable to startUsageTrackingEvent. Invalid parameters: ");
            stringBuilder.append((Object)jSONException);
            TapjoyLog.w("TJAdUnitJSBridge", stringBuilder.toString());
        }
        Object[] arrobject = new Object[]{false};
        this.invokeJSCallback(string, arrobject);
    }

    /*
     * Exception decompiling
     */
    public void triggerEvent(JSONObject var1, String var2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl36 : RETURN : trying to set 1 previously set to 0
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

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void triggerMoatVideoEvent(JSONObject jSONObject, String string) {
        try {
            Integer n2 = jSONObject.getInt("currentVideoTime");
            String string2 = jSONObject.getString("eventName");
            HashMap hashMap = this.m;
            MoatAdEventType moatAdEventType = null;
            if (hashMap != null) {
                moatAdEventType = (MoatAdEventType)((Object)this.m.get((Object)string2));
            }
            if (moatAdEventType == null) {
                StringBuilder stringBuilder = new StringBuilder("eventName:");
                stringBuilder.append(string2);
                stringBuilder.append(" has no matching MOAT event");
                TapjoyLog.d("TJAdUnitJSBridge", stringBuilder.toString());
                Object[] arrobject = new Object[]{false};
                this.invokeJSCallback(string, arrobject);
                return;
            }
            StringBuilder stringBuilder = new StringBuilder("Sending MOAT event: ");
            stringBuilder.append((Object)moatAdEventType);
            TapjoyLog.d("TJAdUnitJSBridge", stringBuilder.toString());
            MoatAdEvent moatAdEvent = new MoatAdEvent(moatAdEventType, n2);
            this.n.post(new Runnable(this, moatAdEvent){
                final /* synthetic */ MoatAdEvent a;
                final /* synthetic */ TJAdUnitJSBridge b;
                {
                    this.b = tJAdUnitJSBridge;
                    this.a = moatAdEvent;
                }

                public final void run() {
                    if (TJAdUnitJSBridge.f(this.b) != null) {
                        TJAdUnitJSBridge.f(this.b).dispatchEvent(this.a);
                    }
                }
            });
            Object[] arrobject = new Object[]{true};
            this.invokeJSCallback(string, arrobject);
            return;
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder("triggerMoatVideoEvent exception ");
            stringBuilder.append(exception.toString());
            TapjoyLog.d("TJAdUnitJSBridge", stringBuilder.toString());
            Object[] arrobject = new Object[]{false};
            this.invokeJSCallback(string, arrobject);
            return;
        }
    }

    public void unsetOrientation(JSONObject jSONObject, String string) {
        TJAdUnit tJAdUnit = this.f;
        Boolean bl = false;
        if (tJAdUnit == null) {
            TapjoyLog.d("TJAdUnitJSBridge", "No ad unit provided");
            this.invokeJSCallback(string, new Object[]{bl});
            return;
        }
        try {
            tJAdUnit.unsetOrientation();
            Object[] arrobject = new Object[]{true};
            this.invokeJSCallback(string, arrobject);
            return;
        }
        catch (Exception exception) {
            this.invokeJSCallback(string, new Object[]{bl});
            return;
        }
    }

}


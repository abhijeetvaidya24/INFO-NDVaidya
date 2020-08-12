/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.app.Activity
 *  android.content.ActivityNotFoundException
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.TypedArray
 *  android.net.ConnectivityManager
 *  android.net.Uri
 *  android.os.AsyncTask
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Message
 *  android.os.Parcelable
 *  android.util.AttributeSet
 *  android.util.DisplayMetrics
 *  android.view.Display
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewParent
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 *  android.view.WindowManager
 *  android.webkit.ValueCallback
 *  android.webkit.WebBackForwardList
 *  android.webkit.WebChromeClient
 *  android.webkit.WebChromeClient$CustomViewCallback
 *  android.webkit.WebResourceResponse
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.ProgressBar
 *  android.widget.RelativeLayout
 *  android.widget.VideoView
 *  java.io.FileInputStream
 *  java.io.FileNotFoundException
 *  java.io.InputStream
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Enum
 *  java.lang.Exception
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuffer
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.lang.Void
 *  java.util.regex.Matcher
 *  java.util.regex.Pattern
 */
package com.tapjoy.mraid.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.webkit.ValueCallback;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.VideoView;
import com.tapjoy.TapjoyCachedAssetData;
import com.tapjoy.TapjoyErrorMessage;
import com.tapjoy.TapjoyHttpURLResponse;
import com.tapjoy.TapjoyLog;
import com.tapjoy.TapjoyURLConnection;
import com.tapjoy.TapjoyUtil;
import com.tapjoy.mraid.controller.Abstract;
import com.tapjoy.mraid.controller.Utility;
import com.tapjoy.mraid.listener.MraidViewListener;
import com.tapjoy.mraid.listener.Player;
import com.tapjoy.mraid.util.MraidPlayer;
import com.tapjoy.mraid.util.Utils;
import com.tapjoy.mraid.view.ActionHandler;
import com.tapjoy.mraid.view.BasicWebView;
import com.tapjoy.mraid.view.Browser;
import com.tapjoy.mraid.view.MraidView;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MraidView
extends BasicWebView
implements ViewTreeObserver.OnGlobalLayoutListener {
    public static final String ACTION_KEY = "action";
    public static final String DIMENSIONS = "expand_dimensions";
    public static final String EXPAND_URL = "expand_url";
    public static final int MRAID_ID = 102;
    public static final String PLAYER_PROPERTIES = "player_properties";
    private static int[] c = new int[]{16843039, 16843040};
    private static final String[] d = new String[]{".mp4", ".3gp", ".mpg"};
    private static MraidPlayer s;
    private VideoView A;
    private WebChromeClient.CustomViewCallback B;
    private ProgressBar C;
    private Handler D = new Handler(this){
        final /* synthetic */ MraidView a;
        {
            this.a = mraidView;
        }

        public final void handleMessage(Message message) {
            block13 : {
                block11 : {
                    block12 : {
                        Bundle bundle = message.getData();
                        int n2 = message.what;
                        if (n2 == 1001) break block11;
                        if (n2 == 1003) break block12;
                        switch (n2) {
                            default: {
                                break;
                            }
                            case 1010: {
                                android.view.ViewGroup$MarginLayoutParams marginLayoutParams = (android.view.ViewGroup$MarginLayoutParams)this.a.getLayoutParams();
                                if (marginLayoutParams != null) {
                                    this.a.removeCloseImageButton();
                                    marginLayoutParams.height = bundle.getInt("resize_height", marginLayoutParams.height);
                                    marginLayoutParams.width = bundle.getInt("resize_width", marginLayoutParams.width);
                                    StringBuilder stringBuilder = new StringBuilder("window.mraidview.fireChangeEvent({ state: '");
                                    stringBuilder.append(this.a.getState());
                                    stringBuilder.append("', size: { width: ");
                                    stringBuilder.append((int)((float)marginLayoutParams.width / MraidView.a(this.a)));
                                    stringBuilder.append(", height: ");
                                    stringBuilder.append((int)((float)marginLayoutParams.height / MraidView.a(this.a)));
                                    stringBuilder.append("}});");
                                    String string = stringBuilder.toString();
                                    StringBuilder stringBuilder2 = new StringBuilder("resize: injection: ");
                                    stringBuilder2.append(string);
                                    TapjoyLog.d("MRAIDView", stringBuilder2.toString());
                                    this.a.injectMraidJavaScript(string);
                                    this.a.requestLayout();
                                    MraidView.c(this.a, bundle.getString("resize_customClosePostition"));
                                    if (MraidView.b(this.a) != PLACEMENT_TYPE.INLINE && MraidView.c(this.a) == customCloseState.OPEN) {
                                        this.a.showCloseImageButton();
                                    }
                                }
                                if (MraidView.d(this.a) != null) {
                                    MraidView.d(this.a).onResize();
                                    break;
                                }
                                break block13;
                            }
                            case 1009: {
                                String string = bundle.getString("message");
                                String string2 = bundle.getString("action");
                                StringBuilder stringBuilder = new StringBuilder("window.mraidview.fireErrorEvent(\"");
                                stringBuilder.append(string);
                                stringBuilder.append("\", \"");
                                stringBuilder.append(string2);
                                stringBuilder.append("\")");
                                String string3 = stringBuilder.toString();
                                this.a.injectMraidJavaScript(string3);
                                break;
                            }
                            case 1008: {
                                this.a.playAudioImpl(bundle);
                                break;
                            }
                            case 1007: {
                                this.a.playVideoImpl(bundle);
                                break;
                            }
                            case 1006: {
                                MraidView.a(this.a, VIEW_STATE.LEFT_BEHIND);
                                break;
                            }
                        }
                        break block13;
                    }
                    this.a.injectMraidJavaScript("window.mraidview.fireChangeEvent({ state: 'default' });");
                    this.a.setVisibility(0);
                    break block13;
                }
                if (com.tapjoy.mraid.view.MraidView$6.a[MraidView.e(this.a).ordinal()] == 1 && MraidView.b(this.a) != PLACEMENT_TYPE.INLINE) {
                    MraidView.f(this.a);
                }
            }
            super.handleMessage(message);
        }
    };
    private boolean E;
    WebViewClient a = new WebViewClient(this){
        final /* synthetic */ MraidView a;
        {
            this.a = mraidView;
        }

        public final void onLoadResource(WebView webView, String string) {
        }

        public final void onPageFinished(WebView webView, String string) {
            if (MraidView.d(this.a) != null) {
                MraidView.d(this.a).onPageFinished(webView, string);
            }
            MraidView mraidView = this.a;
            MraidView.a(mraidView, (int)((float)mraidView.getHeight() / MraidView.a(this.a)));
            MraidView mraidView2 = this.a;
            MraidView.b(mraidView2, (int)((float)mraidView2.getWidth() / MraidView.a(this.a)));
            MraidView.g(this.a).init(MraidView.a(this.a));
            this.a.createCloseImageButton();
            if (MraidView.b(this.a) == PLACEMENT_TYPE.INLINE) {
                this.a.removeCloseImageButton();
            }
        }

        public final void onPageStarted(WebView webView, String string, android.graphics.Bitmap bitmap) {
            if (MraidView.d(this.a) != null) {
                MraidView.d(this.a).onPageStarted(webView, string, bitmap);
            }
        }

        public final void onReceivedError(WebView webView, int n2, String string, String string2) {
            if (MraidView.d(this.a) != null) {
                MraidView.d(this.a).onReceivedError(webView, n2, string, string2);
            }
            StringBuilder stringBuilder = new StringBuilder("error:");
            stringBuilder.append(string);
            TapjoyLog.d("MRAIDView", stringBuilder.toString());
            super.onReceivedError(webView, n2, string, string2);
        }

        public final WebResourceResponse shouldInterceptRequest(WebView webView, String string) {
            if (com.tapjoy.TapjoyCache.getInstance() != null) {
                TapjoyCachedAssetData tapjoyCachedAssetData = com.tapjoy.TapjoyCache.getInstance().getCachedDataForURL(string);
                if (tapjoyCachedAssetData == null) {
                    StringBuilder stringBuilder = new StringBuilder("No cached data for ");
                    stringBuilder.append(string);
                    TapjoyLog.d("MRAIDView", stringBuilder.toString());
                } else {
                    WebResourceResponse webResourceResponse = MraidView.a(tapjoyCachedAssetData);
                    if (webResourceResponse != null) {
                        StringBuilder stringBuilder = new StringBuilder("Reading request for ");
                        stringBuilder.append(string);
                        stringBuilder.append(" from cache -- localPath: ");
                        stringBuilder.append(tapjoyCachedAssetData.getLocalFilePath());
                        TapjoyLog.d("MRAIDView", stringBuilder.toString());
                        return webResourceResponse;
                    }
                }
            }
            return super.shouldInterceptRequest(webView, string);
        }

        public final boolean shouldOverrideUrlLoading(WebView webView, String string) {
            Uri uri;
            block9 : {
                block8 : {
                    StringBuilder stringBuilder = new StringBuilder("shouldOverrideUrlLoading: ");
                    stringBuilder.append(string);
                    TapjoyLog.d("MRAIDView", stringBuilder.toString());
                    if (MraidView.d(this.a) != null && MraidView.d(this.a).shouldOverrideUrlLoading(webView, string)) {
                        return true;
                    }
                    uri = Uri.parse((String)string);
                    try {
                        if (string.startsWith("mraid")) {
                            return super.shouldOverrideUrlLoading(webView, string);
                        }
                        if (!string.startsWith("tel:")) break block8;
                        Intent intent = new Intent("android.intent.action.DIAL", Uri.parse((String)string));
                        intent.addFlags(268435456);
                        this.a.getContext().startActivity(intent);
                        return true;
                    }
                    catch (Exception exception) {
                        try {
                            Intent intent = new Intent();
                            intent.setAction("android.intent.action.VIEW");
                            intent.setData(uri);
                            intent.addFlags(268435456);
                            this.a.getContext().startActivity(intent);
                            return true;
                        }
                        catch (Exception exception2) {
                            return false;
                        }
                    }
                }
                if (!string.startsWith("mailto:")) break block9;
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse((String)string));
                intent.addFlags(268435456);
                this.a.getContext().startActivity(intent);
                return true;
            }
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(uri);
            intent.addFlags(268435456);
            this.a.getContext().startActivity(intent);
            return true;
        }
    };
    WebChromeClient b = new WebChromeClient(this){
        final /* synthetic */ MraidView a;
        {
            this.a = mraidView;
        }

        public final void onCloseWindow(WebView webView) {
            super.onCloseWindow(webView);
            MraidView.f(this.a);
        }

        public final boolean onConsoleMessage(android.webkit.ConsoleMessage consoleMessage) {
            if (MraidView.d(this.a) != null) {
                return MraidView.d(this.a).onConsoleMessage(consoleMessage);
            }
            return super.onConsoleMessage(consoleMessage);
        }

        public final void onHideCustomView() {
            super.onHideCustomView();
        }

        public final boolean onJsAlert(WebView webView, String string, String string2, android.webkit.JsResult jsResult) {
            TapjoyLog.d("MRAIDView", string2);
            return false;
        }

        public final void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
            FrameLayout frameLayout;
            TapjoyLog.d("MRAIDView", "-- onShowCustomView --");
            super.onShowCustomView(view, customViewCallback);
            MraidView.a(this.a, customViewCallback);
            if (view instanceof FrameLayout && (frameLayout = (FrameLayout)view).getFocusedChild() instanceof VideoView) {
                if (!(MraidView.h(this.a) instanceof Activity)) {
                    return;
                }
                Activity activity = (Activity)MraidView.h(this.a);
                MraidView.a(this.a, (VideoView)frameLayout.getFocusedChild());
                frameLayout.removeView((View)MraidView.i(this.a));
                if (MraidView.j(this.a) == null) {
                    MraidView mraidView = this.a;
                    MraidView.a(mraidView, new RelativeLayout(MraidView.h(mraidView)));
                    MraidView.j(this.a).setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                    MraidView.j(this.a).setBackgroundColor(-16777216);
                }
                android.widget.RelativeLayout$LayoutParams layoutParams = new android.widget.RelativeLayout$LayoutParams(-1, -1);
                layoutParams.addRule(13);
                MraidView.i(this.a).setLayoutParams((ViewGroup.LayoutParams)layoutParams);
                MraidView mraidView = this.a;
                MraidView.a(mraidView, new ProgressBar(MraidView.h(mraidView), null, 16842874));
                MraidView.k(this.a).setVisibility(0);
                android.widget.RelativeLayout$LayoutParams layoutParams2 = new android.widget.RelativeLayout$LayoutParams(-2, -2);
                layoutParams2.addRule(13);
                MraidView.k(this.a).setLayoutParams((ViewGroup.LayoutParams)layoutParams2);
                MraidView.j(this.a).addView((View)MraidView.i(this.a));
                MraidView.j(this.a).addView((View)MraidView.k(this.a));
                activity.getWindow().addContentView((View)MraidView.j(this.a), new ViewGroup.LayoutParams(-1, -1));
                new Thread(new Runnable(this.a){

                    /*
                     * Exception decompiling
                     */
                    public final void run() {
                        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl3 : ALOAD_0 : trying to set 1 previously set to 0
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

                    final class a
                    implements Runnable {
                        private boolean b = false;

                        /*
                         * Exception decompiling
                         */
                        public final void run() {
                            // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                            // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl1 : ALOAD_0 : trying to set 1 previously set to 0
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
                    }

                }).start();
                this.a.setVisibility(8);
                MraidView.i(this.a).setOnPreparedListener(new android.media.MediaPlayer$OnPreparedListener(this){
                    final /* synthetic */ 4 a;
                    {
                        this.a = var1_1;
                    }

                    public final void onPrepared(android.media.MediaPlayer mediaPlayer) {
                        TapjoyLog.i("MRAIDView", "** ON PREPARED **");
                        StringBuilder stringBuilder = new StringBuilder("isPlaying: ");
                        stringBuilder.append(mediaPlayer.isPlaying());
                        TapjoyLog.i("MRAIDView", stringBuilder.toString());
                        if (!mediaPlayer.isPlaying()) {
                            mediaPlayer.start();
                        }
                    }
                });
                MraidView.i(this.a).setOnCompletionListener(new android.media.MediaPlayer$OnCompletionListener(this){
                    final /* synthetic */ 4 a;
                    {
                        this.a = var1_1;
                    }

                    public final void onCompletion(android.media.MediaPlayer mediaPlayer) {
                        TapjoyLog.i("MRAIDView", "** ON COMPLETION **");
                        this.a.a.videoViewCleanup();
                    }
                });
                MraidView.i(this.a).setOnErrorListener(new android.media.MediaPlayer$OnErrorListener(this){
                    final /* synthetic */ 4 a;
                    {
                        this.a = var1_1;
                    }

                    public final boolean onError(android.media.MediaPlayer mediaPlayer, int n2, int n3) {
                        TapjoyLog.i("MRAIDView", "** ON ERROR **");
                        this.a.a.videoViewCleanup();
                        return false;
                    }
                });
                MraidView.i(this.a).start();
            }
        }
    };
    private customCloseState e = customCloseState.UNKNOWN;
    private boolean f = false;
    private boolean g;
    private Utility h;
    private float i;
    private int j;
    private boolean k;
    private int l;
    private int m;
    private int n;
    private int o;
    private PLACEMENT_TYPE p;
    private VIEW_STATE q = VIEW_STATE.DEFAULT;
    private MraidViewListener r;
    private int t = 0;
    private int u = 0;
    private Thread v = null;
    private boolean w = false;
    private int x;
    private Context y;
    private RelativeLayout z;

    public MraidView(Context context) {
        super(context);
        this.y = context;
        this.initialize();
    }

    public MraidView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.initialize();
        TypedArray typedArray = this.getContext().obtainStyledAttributes(attributeSet, c);
        int n2 = typedArray.getDimensionPixelSize(0, -1);
        int n3 = typedArray.getDimensionPixelSize(1, -1);
        if (n2 > 0 && n3 > 0) {
            this.h.setMaxSize(n2, n3);
        }
        typedArray.recycle();
    }

    public MraidView(Context context, MraidViewListener mraidViewListener) {
        super(context);
        this.setListener(mraidViewListener);
        this.y = context;
        this.initialize();
    }

    static /* synthetic */ float a(MraidView mraidView) {
        return mraidView.i;
    }

    static /* synthetic */ int a(MraidView mraidView, int n2) {
        mraidView.l = n2;
        return n2;
    }

    static /* synthetic */ WebChromeClient.CustomViewCallback a(MraidView mraidView, WebChromeClient.CustomViewCallback customViewCallback) {
        mraidView.B = customViewCallback;
        return customViewCallback;
    }

    static /* synthetic */ WebResourceResponse a(TapjoyCachedAssetData tapjoyCachedAssetData) {
        return MraidView.b(tapjoyCachedAssetData);
    }

    static /* synthetic */ ProgressBar a(MraidView mraidView, ProgressBar progressBar) {
        mraidView.C = progressBar;
        return progressBar;
    }

    static /* synthetic */ RelativeLayout a(MraidView mraidView, RelativeLayout relativeLayout) {
        mraidView.z = relativeLayout;
        return relativeLayout;
    }

    static /* synthetic */ VideoView a(MraidView mraidView, VideoView videoView) {
        mraidView.A = videoView;
        return videoView;
    }

    static /* synthetic */ VIEW_STATE a(MraidView mraidView, VIEW_STATE vIEW_STATE) {
        mraidView.q = vIEW_STATE;
        return vIEW_STATE;
    }

    static /* synthetic */ void a(MraidView mraidView, String string) {
        super.evaluateJavascript(string, null);
    }

    private static boolean a(String string) {
        String[] arrstring = d;
        int n2 = arrstring.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (!string.endsWith(arrstring[i2])) continue;
            return true;
        }
        return false;
    }

    static /* synthetic */ int b(MraidView mraidView, int n2) {
        mraidView.m = n2;
        return n2;
    }

    private static WebResourceResponse b(TapjoyCachedAssetData tapjoyCachedAssetData) {
        if (tapjoyCachedAssetData == null) {
            return null;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(tapjoyCachedAssetData.getLocalFilePath());
            WebResourceResponse webResourceResponse = new WebResourceResponse(tapjoyCachedAssetData.getMimeType(), "UTF-8", (InputStream)fileInputStream);
            return webResourceResponse;
        }
        catch (FileNotFoundException fileNotFoundException) {
            return null;
        }
    }

    static /* synthetic */ PLACEMENT_TYPE b(MraidView mraidView) {
        return mraidView.p;
    }

    static /* synthetic */ void b(MraidView mraidView, String string) {
        super.loadUrl(string);
    }

    static /* synthetic */ customCloseState c(MraidView mraidView) {
        return mraidView.e;
    }

    static /* synthetic */ void c(MraidView mraidView, String string) {
        if (string != null) {
            String string2;
            if (string.equals((Object)"top-right")) {
                string2 = "document.getElementById(\"closeButton\").style.right = 1;document.getElementById(\"closeButton\").style.top = 1;document.getElementById(\"closeButton\").style.bottom = mraid.getSize().height -36;document.getElementById(\"closeButton\").style.left = mraid.getSize().width -36";
            } else if (string.equals((Object)"top-center")) {
                string2 = "document.getElementById(\"closeButton\").style.right = mraid.getSize().width/2 - 18;document.getElementById(\"closeButton\").style.top = 1;document.getElementById(\"closeButton\").style.bottom = mraid.getSize().height -36;document.getElementById(\"closeButton\").style.left = mraid.getSize().width/2 -18";
            } else if (string.equals((Object)"top-left")) {
                string2 = "document.getElementById(\"closeButton\").style.right = mraid.getSize().width -36;document.getElementById(\"closeButton\").style.top = 1;document.getElementById(\"closeButton\").style.bottom = mraid.getSize().height -36;document.getElementById(\"closeButton\").style.left = 1";
            } else if (string.equals((Object)"center")) {
                string2 = "document.getElementById(\"closeButton\").style.right = mraid.getSize().width/2 - 18;document.getElementById(\"closeButton\").style.top = mraid.getSize().height/2 -18;document.getElementById(\"closeButton\").style.bottom = mraid.getSize().height/2 -18;document.getElementById(\"closeButton\").style.left = mraid.getSize().width/2 -18";
            } else if (string.equals((Object)"bottom-right")) {
                string2 = "document.getElementById(\"closeButton\").style.right = 1;document.getElementById(\"closeButton\").style.top = mraid.getSize().height -36;document.getElementById(\"closeButton\").style.bottom = 1;document.getElementById(\"closeButton\").style.left = mraid.getSize().width -36";
            } else if (string.equals((Object)"bottom-left")) {
                string2 = "document.getElementById(\"closeButton\").style.left = 1;document.getElementById(\"closeButton\").style.bottom = 1;document.getElementById(\"closeButton\").style.right = mraid.getSize().width -36;document.getElementById(\"closeButton\").style.top = mraid.getSize().height-36;";
            } else {
                boolean bl = string.equals((Object)"bottom-center");
                string2 = null;
                if (bl) {
                    string2 = "document.getElementById(\"closeButton\").style.bottom = 1;document.getElementById(\"closeButton\").style.right = mraid.getSize().width -36document.getElementById(\"closeButton\").style.right = mraid.getSize().width/2 -18;document.getElementById(\"closeButton\").style.top = mraid.getSize().height-36;";
                }
            }
            if (string2 != null) {
                mraidView.injectMraidJavaScript(string2);
                return;
            }
            TapjoyLog.d("MRAIDView", "Reposition of close button failed.");
        }
    }

    static /* synthetic */ VIEW_STATE e(MraidView mraidView) {
        return mraidView.q;
    }

    static /* synthetic */ void f(MraidView mraidView) {
        try {
            if (mraidView.r != null) {
                mraidView.r.onClose();
            }
            ((ViewGroup)mraidView.getParent()).removeView((View)mraidView);
        }
        catch (Exception exception) {}
    }

    static /* synthetic */ Utility g(MraidView mraidView) {
        return mraidView.h;
    }

    private int getContentViewHeight() {
        View view = this.getRootView().findViewById(16908290);
        if (view != null) {
            return view.getHeight();
        }
        return -1;
    }

    static /* synthetic */ Context h(MraidView mraidView) {
        return mraidView.y;
    }

    static /* synthetic */ VideoView i(MraidView mraidView) {
        return mraidView.A;
    }

    static /* synthetic */ RelativeLayout j(MraidView mraidView) {
        return mraidView.z;
    }

    static /* synthetic */ boolean l(MraidView mraidView) {
        return mraidView.w;
    }

    static /* synthetic */ void m(MraidView mraidView) {
        WindowManager windowManager = (WindowManager)mraidView.getContext().getSystemService("window");
        int n2 = windowManager.getDefaultDisplay().getWidth();
        int n3 = windowManager.getDefaultDisplay().getHeight();
        if ((n2 != mraidView.t || n3 != mraidView.u) && mraidView.getPlacementType() == PLACEMENT_TYPE.INTERSTITIAL) {
            mraidView.resizeOrientation(n2, n3, "top-right", true);
        }
    }

    public void addJavascriptObject(Object object, String string) {
        this.addJavascriptInterface(object, string);
    }

    public void clearView() {
        this.reset();
        super.clearView();
    }

    public void close() {
        this.D.sendEmptyMessage(1001);
    }

    public void createCloseImageButton() {
        this.injectMraidJavaScript("window.mraidview.createCss();");
        TapjoyLog.d("MRAIDView", "Creating close button.");
    }

    public customCloseState getCloseButtonState() {
        return this.e;
    }

    public ConnectivityManager getConnectivityManager() {
        return (ConnectivityManager)this.getContext().getSystemService("connectivity");
    }

    public PLACEMENT_TYPE getPlacementType() {
        return this.p;
    }

    MraidPlayer getPlayer() {
        MraidPlayer mraidPlayer;
        MraidPlayer mraidPlayer2 = s;
        if (mraidPlayer2 != null) {
            mraidPlayer2.releasePlayer();
        }
        s = mraidPlayer = new MraidPlayer(this.getContext());
        return mraidPlayer;
    }

    public String getSize() {
        StringBuilder stringBuilder = new StringBuilder("{ width: ");
        stringBuilder.append((int)Math.ceil((double)((float)this.getWidth() / this.i)));
        stringBuilder.append(", height: ");
        stringBuilder.append((int)Math.ceil((double)((float)this.getHeight() / this.i)));
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public String getState() {
        return this.q.toString().toLowerCase();
    }

    public VIEW_STATE getViewState() {
        return this.q;
    }

    public boolean hasMraidTag(String string) {
        return Pattern.compile((String)"<\\s*script[^>]+mraid\\.js").matcher((CharSequence)string).find();
    }

    @SuppressLint(value={"SetJavaScriptEnabled"})
    public void initialize() {
        this.setPlacementType(PLACEMENT_TYPE.INTERSTITIAL);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager)this.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        this.i = displayMetrics.density;
        this.g = false;
        this.h = new Utility(this, this.getContext());
        this.addJavascriptInterface((Object)this.h, "MRAIDUtilityControllerBridge");
        this.setWebViewClient(this.a);
        this.setWebChromeClient(this.b);
        this.j = this.getContentViewHeight();
        if (this.getViewTreeObserver() != null) {
            this.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
        }
        WindowManager windowManager = (WindowManager)this.getContext().getSystemService("window");
        this.t = windowManager.getDefaultDisplay().getWidth();
        this.u = windowManager.getDefaultDisplay().getHeight();
        if (this.getContext() instanceof Activity) {
            this.x = ((Activity)this.getContext()).getRequestedOrientation();
        }
    }

    public void injectMraidJavaScript(String string) {
        if (string != null && this.f) {
            StringBuilder stringBuilder = new StringBuilder("javascript:");
            stringBuilder.append(string);
            this.loadUrl(stringBuilder.toString());
        }
    }

    public boolean isMraid() {
        return this.f;
    }

    public boolean isPageFinished() {
        return this.g;
    }

    public void loadDataWithBaseURL(String string, String string2, String string3, String string4, String string5) {
        if (string2 == null) {
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        int n2 = string2.indexOf("<html>");
        this.f = false;
        int n3 = string2.indexOf("mraid.js");
        if (n3 > 0 && this.hasMraidTag(string2)) {
            int n4;
            int n5;
            block13 : {
                block12 : {
                    this.f = true;
                    for (n5 = n3; n5 >= 0; --n5) {
                        if (!string2.substring(n5, n5 + 7).equals((Object)"<script")) {
                            continue;
                        }
                        break block12;
                    }
                    n5 = n3;
                }
                for (int i2 = 0; i2 < string2.length(); ++i2) {
                    int n6 = n3 + i2;
                    n4 = n6 + 2;
                    if (!string2.substring(n6, n4).equalsIgnoreCase("/>") && !string2.substring(n6, n4 = n6 + 9).equalsIgnoreCase("</script>")) {
                        continue;
                    }
                    break block13;
                }
                n4 = n3;
            }
            if (n2 < 0) {
                TapjoyLog.d("MRAIDView", "wrapping fragment");
                stringBuffer.append("<html>");
                stringBuffer.append("<head>");
                stringBuffer.append("<meta name='viewport' content='user-scalable=no initial-scale=1.0' />");
                stringBuffer.append("<title>Advertisement</title>");
                stringBuffer.append("</head>");
                stringBuffer.append("<body style=\"margin:0; padding:0; overflow:hidden; background-color:transparent;\">");
                stringBuffer.append("<div align=\"center\"> ");
                stringBuffer.append(string2.substring(0, n5));
                stringBuffer.append("<script type=text/javascript>");
                String string6 = (String)TapjoyUtil.getResource("mraid.js");
                if (string6 == null) {
                    string6 = TapjoyUtil.copyTextFromJarIntoString("js/mraid.js", this.getContext());
                }
                stringBuffer.append(string6);
                stringBuffer.append("</script>");
                stringBuffer.append(string2.substring(n4));
            } else {
                int n7 = string2.indexOf("<head>");
                if (n7 != -1) {
                    String string7 = (String)TapjoyUtil.getResource("mraid.js");
                    if (string7 == null) {
                        string7 = TapjoyUtil.copyTextFromJarIntoString("js/mraid.js", this.getContext());
                    }
                    int n8 = n7 + 6;
                    stringBuffer.append(string2.substring(0, n8));
                    stringBuffer.append("<script type='text/javascript'>");
                    stringBuffer.append(string7);
                    stringBuffer.append("</script>");
                    stringBuffer.append(string2.substring(n8));
                }
            }
            TapjoyLog.d("MRAIDView", "injected js/mraid.js");
        } else {
            stringBuffer.append(string2);
        }
        super.loadDataWithBaseURL(string, stringBuffer.toString(), string3, string4, string5);
    }

    public void loadUrl(String string) {
        ((Activity)this.y).runOnUiThread(new Runnable(this, string){
            final /* synthetic */ String a;
            final /* synthetic */ MraidView b;
            {
                this.b = mraidView;
                this.a = string;
            }

            public final void run() {
                if (android.webkit.URLUtil.isValidUrl((String)this.a)) {
                    if (this.a.startsWith("javascript:")) {
                        if (android.os.Build$VERSION.SDK_INT >= 19) {
                            try {
                                String string = this.a.replaceFirst("javascript:", "");
                                MraidView.a(this.b, string);
                                return;
                            }
                            catch (Exception exception) {
                                StringBuilder stringBuilder = new StringBuilder("Exception in evaluateJavascript. Device not supported. ");
                                stringBuilder.append(exception.toString());
                                TapjoyLog.e("MRAIDView", stringBuilder.toString());
                                return;
                            }
                        }
                        MraidView.b(this.b, this.a);
                        return;
                    }
                    AsyncTask asyncTask = new AsyncTask(0){
                        TapjoyHttpURLResponse a;
                        TapjoyURLConnection b;
                        String c;
                        {
                            this();
                        }

                        private /* varargs */ Void a(String ... arrstring) {
                            this.c = arrstring[0];
                            try {
                                this.b = new TapjoyURLConnection();
                                this.a = this.b.getResponseFromURL(this.c);
                            }
                            catch (Exception exception) {
                                exception.printStackTrace();
                            }
                            return null;
                        }

                        protected final /* synthetic */ Object doInBackground(Object[] arrobject) {
                            return this.a((String[])arrobject);
                        }

                        protected final /* synthetic */ void onPostExecute(Object object) {
                            try {
                                if (this.a.statusCode != 0 && this.a.response != null) {
                                    if (this.a.statusCode == 302 && this.a.redirectURL != null && this.a.redirectURL.length() > 0) {
                                        StringBuilder stringBuilder = new StringBuilder("302 redirectURL detected: ");
                                        stringBuilder.append(this.a.redirectURL);
                                        TapjoyLog.i("MRAIDView", stringBuilder.toString());
                                        MraidView.this.loadUrlStandard(this.a.redirectURL);
                                        return;
                                    }
                                    MraidView.this.loadDataWithBaseURL(this.c, this.a.response, "text/html", "utf-8", this.c);
                                    return;
                                }
                                TapjoyLog.e("MRAIDView", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.NETWORK_ERROR, "Connection not properly established"));
                                if (MraidView.this.r != null) {
                                    MraidView.this.r.onReceivedError(MraidView.this, 0, "Connection not properly established", this.c);
                                }
                                return;
                            }
                            catch (Exception exception) {
                                StringBuilder stringBuilder = new StringBuilder("error in loadURL ");
                                stringBuilder.append((Object)exception);
                                TapjoyLog.w("MRAIDView", stringBuilder.toString());
                                exception.printStackTrace();
                                return;
                            }
                        }
                    };
                    Object[] arrobject = new String[]{this.a};
                    asyncTask.execute(arrobject);
                    return;
                }
                this.b.loadDataWithBaseURL(null, "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\"><html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\"><title>Connection not Established</title></head><h2>Connection Not Properly Established</h2><body></body></html>", "text/html", "utf-8", null);
            }
        });
    }

    public void loadUrlStandard(String string) {
        super.loadUrl(string);
    }

    protected void onAttachedToWindow() {
        if (!this.E) {
            ViewGroup.LayoutParams layoutParams = this.getLayoutParams();
            this.n = layoutParams.height;
            this.o = layoutParams.width;
            this.E = true;
        }
        this.w = false;
        Thread thread = this.v;
        if (thread == null || !thread.isAlive()) {
            this.v = new Thread(new Runnable(){

                /*
                 * Exception decompiling
                 */
                public final void run() {
                    // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                    // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl1 : ALOAD_0 : trying to set 1 previously set to 0
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
            this.v.start();
        }
        super.onAttachedToWindow();
    }

    protected void onDetachedFromWindow() {
        this.w = true;
        this.h.stopAllListeners();
        try {
            if (this.A != null) {
                this.A.stopPlayback();
            }
            if (this.B != null) {
                this.B.onCustomViewHidden();
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        super.onDetachedFromWindow();
    }

    public void onGlobalLayout() {
        boolean bl = this.k;
        if (!bl && this.j >= 0 && this.getContentViewHeight() >= 0 && this.j != this.getContentViewHeight()) {
            bl = true;
            this.injectMraidJavaScript("window.mraidview.fireChangeEvent({ keyboardState: true});");
        }
        if (this.k && this.j >= 0 && this.getContentViewHeight() >= 0 && this.j == this.getContentViewHeight()) {
            bl = false;
            this.injectMraidJavaScript("window.mraidview.fireChangeEvent({ keyboardState: false});");
        }
        if (this.j < 0) {
            this.j = this.getContentViewHeight();
        }
        this.k = bl;
    }

    public void open(String string, boolean bl, boolean bl2, boolean bl3) {
        String string2;
        boolean bl4 = MraidView.a(string);
        boolean bl5 = true;
        if (bl4) {
            string2 = string;
        } else {
            TapjoyHttpURLResponse tapjoyHttpURLResponse = new TapjoyURLConnection().getRedirectFromURL(string);
            StringBuilder stringBuilder = new StringBuilder("redirect: ");
            stringBuilder.append(tapjoyHttpURLResponse.redirectURL);
            stringBuilder.append(", ");
            stringBuilder.append(tapjoyHttpURLResponse.statusCode);
            TapjoyLog.i("MRAIDView", stringBuilder.toString());
            if (tapjoyHttpURLResponse != null && tapjoyHttpURLResponse.redirectURL != null && tapjoyHttpURLResponse.redirectURL.length() > 0 && MraidView.a(tapjoyHttpURLResponse.redirectURL)) {
                string2 = tapjoyHttpURLResponse.redirectURL;
            } else {
                string2 = null;
                bl5 = false;
            }
        }
        if (bl5) {
            Abstract.ReflectedParcelable reflectedParcelable = new Abstract.ReflectedParcelable(){
                public static final android.os.Parcelable$Creator CREATOR;
                public int height;
                public int width;
                public int x;
                public int y;

                static {
                    CREATOR = new android.os.Parcelable$Creator(){

                        public final /* synthetic */ Object createFromParcel(android.os.Parcel parcel) {
                            return new /* invalid duplicate definition of identical inner class */;
                        }
                    };
                }
                {
                    this.x = -1;
                    this.y = -1;
                    this.width = -1;
                    this.height = -1;
                }
            };
            reflectedParcelable.x = 0;
            reflectedParcelable.y = 0;
            reflectedParcelable.width = this.getWidth();
            reflectedParcelable.height = this.getHeight();
            this.playVideo(string2, false, true, true, false, reflectedParcelable, "fullscreen", "exit");
            return;
        }
        StringBuilder stringBuilder = new StringBuilder("Mraid Browser open:");
        stringBuilder.append(string);
        TapjoyLog.d("MRAIDView", stringBuilder.toString());
        Intent intent = new Intent(this.getContext(), Browser.class);
        intent.putExtra("extra_url", string);
        intent.putExtra("open_show_back", bl);
        intent.putExtra("open_show_forward", bl2);
        intent.putExtra("open_show_refresh", bl3);
        intent.addFlags(268435456);
        this.getContext().startActivity(intent);
    }

    public void openMap(String string, boolean bl) {
        StringBuilder stringBuilder = new StringBuilder("Opening Map Url ");
        stringBuilder.append(string);
        TapjoyLog.d("MRAIDView", stringBuilder.toString());
        String string2 = Utils.convert(string.trim());
        if (bl) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse((String)string2));
                intent.setFlags(268435456);
                this.getContext().startActivity(intent);
                return;
            }
            catch (ActivityNotFoundException activityNotFoundException) {
                activityNotFoundException.printStackTrace();
            }
        }
    }

    public void playAudio(String string, boolean bl, boolean bl2, boolean bl3, boolean bl4, String string2, String string3) {
        Abstract.ReflectedParcelable reflectedParcelable = new Abstract.ReflectedParcelable(){
            public static final android.os.Parcelable$Creator CREATOR;
            public boolean audioMuted;
            public boolean autoPlay;
            public boolean doLoop;
            public boolean inline;
            public boolean showControl;
            public String startStyle;
            public String stopStyle;

            static {
                CREATOR = new android.os.Parcelable$Creator(){

                    public final /* synthetic */ Object createFromParcel(android.os.Parcel parcel) {
                        return new /* invalid duplicate definition of identical inner class */;
                    }
                };
            }
            {
                this.showControl = true;
                this.autoPlay = true;
                this.audioMuted = false;
                this.doLoop = false;
                this.stopStyle = "normal";
                this.startStyle = "normal";
                this.inline = false;
            }

            public boolean doLoop() {
                return this.doLoop;
            }

            public boolean doMute() {
                return this.audioMuted;
            }

            public boolean exitOnComplete() {
                return this.stopStyle.equalsIgnoreCase("exit");
            }

            public boolean isAutoPlay() {
                return this.autoPlay;
            }

            public boolean isFullScreen() {
                return this.startStyle.equalsIgnoreCase("fullscreen");
            }

            public void muteAudio() {
                this.audioMuted = true;
            }

            public void setProperties(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, String string, String string2) {
                this.autoPlay = bl2;
                this.showControl = bl3;
                this.doLoop = bl5;
                this.audioMuted = bl;
                this.startStyle = string;
                this.stopStyle = string2;
                this.inline = bl4;
            }

            public void setStopStyle(String string) {
                this.stopStyle = string;
            }

            public boolean showControl() {
                return this.showControl;
            }
        };
        reflectedParcelable.setProperties(false, bl, bl2, bl4, bl3, string2, string3);
        Bundle bundle = new Bundle();
        bundle.putString(ACTION_KEY, Action.PLAY_AUDIO.toString());
        bundle.putString(EXPAND_URL, string);
        bundle.putParcelable(PLAYER_PROPERTIES, (Parcelable)reflectedParcelable);
        if (reflectedParcelable.isFullScreen()) {
            try {
                Intent intent = new Intent(this.getContext(), ActionHandler.class);
                intent.putExtras(bundle);
                this.getContext().startActivity(intent);
                return;
            }
            catch (ActivityNotFoundException activityNotFoundException) {
                activityNotFoundException.printStackTrace();
                return;
            }
        }
        Message message = this.D.obtainMessage(1008);
        message.setData(bundle);
        this.D.sendMessage(message);
    }

    public void playAudioImpl(Bundle bundle) {
        Abstract.PlayerProperties playerProperties = bundle.getParcelable(PLAYER_PROPERTIES);
        String string = bundle.getString(EXPAND_URL);
        MraidPlayer mraidPlayer = this.getPlayer();
        mraidPlayer.setPlayData(playerProperties, string);
        mraidPlayer.setLayoutParams(new ViewGroup.LayoutParams(1, 1));
        ((ViewGroup)this.getParent()).addView((View)mraidPlayer);
        mraidPlayer.playAudio();
    }

    public void playVideo(String string, boolean bl, boolean bl2, boolean bl3, boolean bl4, Abstract.Dimensions dimensions, String string2, String string3) {
        Message message = this.D.obtainMessage(1007);
        Abstract.ReflectedParcelable reflectedParcelable = new /* invalid duplicate definition of identical inner class */;
        reflectedParcelable.setProperties(bl, bl2, bl3, false, bl4, string2, string3);
        Bundle bundle = new Bundle();
        bundle.putString(EXPAND_URL, string);
        bundle.putString(ACTION_KEY, Action.PLAY_VIDEO.toString());
        bundle.putParcelable(PLAYER_PROPERTIES, (Parcelable)reflectedParcelable);
        if (dimensions != null) {
            bundle.putParcelable(DIMENSIONS, (Parcelable)dimensions);
        }
        if (reflectedParcelable.isFullScreen()) {
            try {
                Intent intent = new Intent(this.getContext(), ActionHandler.class);
                intent.putExtras(bundle);
                intent.setFlags(268435456);
                this.getContext().startActivity(intent);
                return;
            }
            catch (ActivityNotFoundException activityNotFoundException) {
                activityNotFoundException.printStackTrace();
                return;
            }
        }
        if (dimensions != null) {
            message.setData(bundle);
            this.D.sendMessage(message);
        }
    }

    public void playVideoImpl(Bundle bundle) {
        Abstract.PlayerProperties playerProperties = bundle.getParcelable(PLAYER_PROPERTIES);
        Abstract.Dimensions dimensions = bundle.getParcelable(DIMENSIONS);
        String string = bundle.getString(EXPAND_URL);
        MraidPlayer mraidPlayer = this.getPlayer();
        mraidPlayer.setPlayData(playerProperties, string);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimensions.width, dimensions.height);
        layoutParams.topMargin = dimensions.x;
        layoutParams.leftMargin = dimensions.y;
        mraidPlayer.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
        FrameLayout frameLayout = new FrameLayout(this.getContext());
        frameLayout.setId(101);
        frameLayout.setPadding(dimensions.x, dimensions.y, 0, 0);
        ((FrameLayout)this.getRootView().findViewById(16908290)).addView((View)frameLayout, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView((View)mraidPlayer);
        this.setVisibility(4);
        mraidPlayer.setListener(new Player(){

            @Override
            public final void onComplete() {
                FrameLayout frameLayout = (FrameLayout)MraidView.this.getRootView().findViewById(101);
                ((ViewGroup)frameLayout.getParent()).removeView((View)frameLayout);
                MraidView.this.setVisibility(0);
            }

            @Override
            public final void onError() {
                this.onComplete();
            }

            @Override
            public final void onPrepared() {
            }
        });
        mraidPlayer.playVideo();
    }

    public void raiseError(String string, String string2) {
        Message message = this.D.obtainMessage(1009);
        Bundle bundle = new Bundle();
        bundle.putString("message", string);
        bundle.putString(ACTION_KEY, string2);
        message.setData(bundle);
        this.D.sendMessage(message);
    }

    public void removeCloseImageButton() {
        this.injectMraidJavaScript("document.getElementById(\"closeButton\").style.visibility=\"hidden\";");
        TapjoyLog.d("MRAIDView", "Removing close button.");
        this.e = customCloseState.HIDDEN;
    }

    public void removeListener() {
        this.r = null;
    }

    public void reset() {
        this.invalidate();
        this.h.deleteOldAds();
        this.h.stopAllListeners();
        ViewGroup.LayoutParams layoutParams = this.getLayoutParams();
        if (this.E) {
            layoutParams.height = this.n;
            layoutParams.width = this.o;
        }
        this.setVisibility(0);
        this.requestLayout();
    }

    public void resizeOrientation(int n2, int n3, String string, boolean bl) {
        this.t = n2;
        this.u = n3;
        StringBuilder stringBuilder = new StringBuilder("resizeOrientation to dimensions: ");
        stringBuilder.append(n2);
        stringBuilder.append("x");
        stringBuilder.append(n3);
        TapjoyLog.d("MRAIDView", stringBuilder.toString());
        Message message = this.D.obtainMessage(1010);
        Bundle bundle = new Bundle();
        bundle.putInt("resize_width", n2);
        bundle.putInt("resize_height", n3);
        bundle.putBoolean("resize_allowOffScreen", bl);
        bundle.putString("resize_customClosePostition", string);
        message.setData(bundle);
        this.D.sendMessage(message);
    }

    public WebBackForwardList restoreState(Bundle bundle) {
        return super.restoreState(bundle);
    }

    public WebBackForwardList saveState(Bundle bundle) {
        return super.saveState(bundle);
    }

    public void setContext(Context context) {
        this.y = context;
    }

    public void setListener(MraidViewListener mraidViewListener) {
        this.r = mraidViewListener;
    }

    public void setMaxSize(int n2, int n3) {
        this.h.setMaxSize(n2, n3);
    }

    public void setOrientationProperties(boolean bl, String string) {
        int n2 = !bl ? true ^ string.equals((Object)"landscape") : -1;
        ((Activity)this.getContext()).setRequestedOrientation(n2);
    }

    public void setPlacementType(PLACEMENT_TYPE pLACEMENT_TYPE) {
        Thread thread;
        if (!pLACEMENT_TYPE.equals((Object)PLACEMENT_TYPE.INLINE) && !pLACEMENT_TYPE.equals((Object)PLACEMENT_TYPE.INTERSTITIAL)) {
            TapjoyLog.d("MRAIDView", "Incorrect placement type.");
        } else {
            this.p = pLACEMENT_TYPE;
        }
        if (pLACEMENT_TYPE.equals((Object)PLACEMENT_TYPE.INLINE) && ((thread = this.v) == null || !thread.isAlive())) {
            this.v = new Thread(new /* invalid duplicate definition of identical inner class */);
            this.v.start();
        }
    }

    public void show() {
        this.D.sendEmptyMessage(1003);
    }

    public void showCloseImageButton() {
        this.injectMraidJavaScript("document.getElementById(\"closeButton\").style.visibility=\"visible\";");
        TapjoyLog.d("MRAIDView", "Showing close button.");
        this.e = customCloseState.OPEN;
    }

    public boolean videoPlaying() {
        return this.A != null;
    }

    public void videoViewCleanup() {
        RelativeLayout relativeLayout = this.z;
        if (relativeLayout != null) {
            ((ViewGroup)relativeLayout.getParent()).removeView((View)this.z);
            this.z.setVisibility(8);
            this.z = null;
        }
        try {
            if (this.A != null) {
                this.A.stopPlayback();
            }
            if (this.B != null) {
                this.B.onCustomViewHidden();
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        this.A = null;
        this.B = null;
        this.setVisibility(0);
        this.loadUrl("javascript:try{Tapjoy.AdUnit.dispatchEvent('videoend')}catch(e){}");
    }

}


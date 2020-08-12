/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.os.AsyncTask
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewParent
 *  android.webkit.WebChromeClient
 *  android.webkit.WebSettings
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  com.appnext.core.webview.AppnextWebView$WebInterface
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.Void
 *  java.net.HttpRetryException
 *  java.net.URL
 *  java.util.ArrayList
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.concurrent.Executor
 */
package com.appnext.core.webview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.appnext.core.f;
import com.appnext.core.webview.AppnextWebView;
import com.appnext.core.webview.WebAppInterface;
import java.io.IOException;
import java.net.HttpRetryException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.Executor;

/*
 * Exception performing whole class analysis.
 */
public final class AppnextWebView {
    public static final int in = 1;
    public static final int io = 2;
    private static AppnextWebView ip;
    private WebAppInterface bX;
    private final HashMap<String, b> iq;
    private HashMap<String, WebView> ir;

    private AppnextWebView() {
        this.iq = new HashMap();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(b b2, String string2) {
        HashMap<String, b> hashMap;
        new StringBuilder("webview error: ").append(string2);
        HashMap<String, b> hashMap2 = hashMap = this.iq;
        synchronized (hashMap2) {
            Iterator iterator = b2.hH.iterator();
            do {
                if (!iterator.hasNext()) {
                    b2.hH.clear();
                    this.iq.remove((Object)b2.aQ);
                    return;
                }
                ((c)iterator.next()).error(string2);
            } while (true);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static /* synthetic */ void a(AppnextWebView appnextWebView, b b2, String string2) {
        HashMap<String, b> hashMap;
        new StringBuilder("webview error: ").append(string2);
        HashMap<String, b> hashMap2 = hashMap = appnextWebView.iq;
        synchronized (hashMap2) {
            Iterator iterator = b2.hH.iterator();
            do {
                if (!iterator.hasNext()) {
                    b2.hH.clear();
                    appnextWebView.iq.remove((Object)b2.aQ);
                    return;
                }
                ((c)iterator.next()).error(string2);
            } while (true);
        }
    }

    static /* synthetic */ WebAppInterface b(AppnextWebView appnextWebView) {
        return appnextWebView.bX;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void b(b b2, String string2) {
        HashMap<String, b> hashMap;
        new StringBuilder("downloaded ").append(string2);
        HashMap<String, b> hashMap2 = hashMap = this.iq;
        synchronized (hashMap2) {
            Iterator iterator = b2.hH.iterator();
            do {
                if (!iterator.hasNext()) {
                    b2.hH.clear();
                    return;
                }
                ((c)iterator.next()).f(string2);
            } while (true);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static /* synthetic */ void b(AppnextWebView appnextWebView, b b2, String string2) {
        HashMap<String, b> hashMap;
        new StringBuilder("downloaded ").append(string2);
        HashMap<String, b> hashMap2 = hashMap = appnextWebView.iq;
        synchronized (hashMap2) {
            Iterator iterator = b2.hH.iterator();
            do {
                if (!iterator.hasNext()) {
                    b2.hH.clear();
                    return;
                }
                ((c)iterator.next()).f(string2);
            } while (true);
        }
    }

    public static void b(WebAppInterface webAppInterface) {
        AppnextWebView.ip.bX = webAppInterface;
    }

    static /* synthetic */ AppnextWebView br() {
        return ip;
    }

    @SuppressLint(value={"NewApi"})
    public static AppnextWebView u(Context context) {
        if (ip == null) {
            AppnextWebView appnextWebView;
            ip = appnextWebView = new AppnextWebView();
            appnextWebView.ir = new HashMap();
        }
        return ip;
    }

    @SuppressLint(value={"SetJavaScriptEnabled", "NewApi", "InlinedApi"})
    private WebView v(Context context) {
        WebView webView = new WebView(context.getApplicationContext());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setAppCacheEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setDatabaseEnabled(true);
        if (Build.VERSION.SDK_INT >= 21) {
            webView.getSettings().setMixedContentMode(0);
        }
        if (Build.VERSION.SDK_INT >= 17) {
            webView.getSettings().setMediaPlaybackRequiresUserGesture(false);
        }
        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClient(){

            public final boolean shouldOverrideUrlLoading(WebView webView, String string2) {
                if (string2 == null) {
                    return false;
                }
                if (string2.startsWith("http")) {
                    webView.loadUrl(string2);
                    return true;
                }
                return super.shouldOverrideUrlLoading(webView, string2);
            }
        });
        return webView;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @SuppressLint(value={"AddJavascriptInterface"})
    public final WebView a(Context context, String string2, WebAppInterface webAppInterface, com.appnext.core.webview.a a2, String string3) {
        try {
            String string4;
            AppnextWebView.ip.bX = webAppInterface;
            WebView webView = (WebView)this.ir.get((Object)string3);
            if (webView != null && webView.getParent() != null) {
                ((ViewGroup)webView.getParent()).removeView((View)webView);
            }
            URL uRL = new URL(string2);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(uRL.getProtocol());
            stringBuilder.append("://");
            stringBuilder.append(uRL.getHost());
            String string5 = stringBuilder.toString();
            WebView webView2 = new WebView(context.getApplicationContext());
            webView2.getSettings().setJavaScriptEnabled(true);
            webView2.getSettings().setAppCacheEnabled(true);
            webView2.getSettings().setDomStorageEnabled(true);
            webView2.getSettings().setDatabaseEnabled(true);
            if (Build.VERSION.SDK_INT >= 21) {
                webView2.getSettings().setMixedContentMode(0);
            }
            if (Build.VERSION.SDK_INT >= 17) {
                webView2.getSettings().setMediaPlaybackRequiresUserGesture(false);
            }
            webView2.setWebChromeClient(new WebChromeClient());
            webView2.setWebViewClient(new /* invalid duplicate definition of identical inner class */);
            boolean bl = this.iq.containsKey((Object)string2);
            if (bl && ((b)this.iq.get((Object)string2)).state == 2 && !((b)this.iq.get((Object)string2)).iu.equals((Object)"")) {
                StringBuilder stringBuilder2 = new StringBuilder("<script>");
                stringBuilder2.append(((b)this.iq.get((Object)string2)).iu);
                stringBuilder2.append("</script>");
                string4 = stringBuilder2.toString();
            } else if (a2 != null) {
                StringBuilder stringBuilder3 = new StringBuilder("<script>");
                stringBuilder3.append(a2.J());
                stringBuilder3.append("</script>");
                string4 = stringBuilder3.toString();
            } else {
                StringBuilder stringBuilder4 = new StringBuilder("<script src='");
                stringBuilder4.append(string2);
                stringBuilder4.append("'></script>");
                string4 = stringBuilder4.toString();
            }
            StringBuilder stringBuilder5 = new StringBuilder("<html><body>");
            stringBuilder5.append(string4);
            stringBuilder5.append("</body></html>");
            webView2.loadDataWithBaseURL(string5, stringBuilder5.toString(), null, "UTF-8", null);
            this.ir.put((Object)string3, (Object)webView2);
            webView2.addJavascriptInterface((Object)new /* Unavailable Anonymous Inner Class!! */, "Appnext");
            return webView2;
        }
        catch (Throwable throwable) {
            return null;
        }
    }

    public final void a(WebAppInterface webAppInterface) {
        if (this.bX == webAppInterface) {
            this.bX = null;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void a(String string2, c c2) {
        AppnextWebView appnextWebView = this;
        synchronized (appnextWebView) {
            b b2;
            if (this.iq.containsKey((Object)string2)) {
                b2 = (b)this.iq.get((Object)string2);
            } else {
                b2 = new b();
                b2.aQ = string2;
            }
            if (b2.state == 2) {
                if (c2 != null) {
                    c2.f(string2);
                    return;
                }
            } else {
                if (b2.state == 0) {
                    b2.state = 1;
                    new a(b2).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (Object[])new String[]{string2, null});
                }
                if (c2 != null) {
                    b2.hH.add((Object)c2);
                }
                this.iq.put((Object)string2, (Object)b2);
            }
            return;
        }
    }

    public final boolean ai(String string2) {
        return this.ir.get((Object)string2) != null;
    }

    public final WebView aj(String string2) {
        WebView webView = (WebView)this.ir.get((Object)string2);
        if (webView != null && webView.getParent() != null) {
            ((ViewGroup)webView.getParent()).removeView((View)webView);
        }
        return webView;
    }

    public final String ak(String string2) {
        b b2 = (b)this.iq.get((Object)string2);
        if (b2 != null && b2.state == 2) {
            return b2.iu;
        }
        return null;
    }

    private final class a
    extends AsyncTask<String, Void, String> {
        b it;

        public a(b b2) {
            this.it = b2;
        }

        protected final void ah(String string2) {
            super.onPostExecute((Object)string2);
            if (string2.startsWith("error:")) {
                this.it.state = 0;
                AppnextWebView.this.iq.put((Object)this.it.aQ, (Object)this.it);
                AppnextWebView.a(AppnextWebView.this, this.it, string2.substring(7));
                return;
            }
            this.it.state = 2;
            AppnextWebView.this.iq.put((Object)this.it.aQ, (Object)this.it);
            AppnextWebView.b(AppnextWebView.this, this.it, string2);
        }

        protected final /* varargs */ String b(String ... arrstring) {
            try {
                b b2 = (b)AppnextWebView.this.iq.get((Object)arrstring[0]);
                b2.iu = f.a(arrstring[0], null, true, 10000);
                AppnextWebView.this.iq.put((Object)arrstring[0], (Object)b2);
                String string2 = arrstring[0];
                return string2;
            }
            catch (Throwable throwable) {
                return "error: unknown error";
            }
            catch (IOException iOException) {
                return "error: network problem";
            }
            catch (HttpRetryException httpRetryException) {
                StringBuilder stringBuilder = new StringBuilder("error: ");
                stringBuilder.append(httpRetryException.getReason());
                return stringBuilder.toString();
            }
        }

        protected final /* synthetic */ Object doInBackground(Object[] arrobject) {
            return this.b((String[])arrobject);
        }

        protected final /* synthetic */ void onPostExecute(Object object) {
            String string2 = (String)object;
            super.onPostExecute((Object)string2);
            if (string2.startsWith("error:")) {
                this.it.state = 0;
                AppnextWebView.this.iq.put((Object)this.it.aQ, (Object)this.it);
                AppnextWebView.a(AppnextWebView.this, this.it, string2.substring(7));
                return;
            }
            this.it.state = 2;
            AppnextWebView.this.iq.put((Object)this.it.aQ, (Object)this.it);
            AppnextWebView.b(AppnextWebView.this, this.it, string2);
        }
    }

    private final class b {
        public String aQ;
        public ArrayList<c> hH = new ArrayList();
        public String iu = "";
        public int state = 0;

        private b() {
        }
    }

    public static interface c {
        public void error(String var1);

        public void f(String var1);
    }

}


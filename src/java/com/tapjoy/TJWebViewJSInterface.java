/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.os.AsyncTask
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.webkit.JavascriptInterface
 *  android.webkit.ValueCallback
 *  android.webkit.WebView
 *  com.tapjoy.TapjoyErrorMessage
 *  com.tapjoy.TapjoyErrorMessage$ErrorType
 *  com.tapjoy.TapjoyLog
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Map
 *  java.util.concurrent.ConcurrentLinkedQueue
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.tapjoy;

import android.annotation.TargetApi;
import android.os.AsyncTask;
import android.os.Build;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.tapjoy.TJWebViewJSInterfaceListener;
import com.tapjoy.TapjoyErrorMessage;
import com.tapjoy.TapjoyLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONObject;

public class TJWebViewJSInterface {
    WebView a;
    TJWebViewJSInterfaceListener b;
    private final ConcurrentLinkedQueue c = new ConcurrentLinkedQueue();
    private boolean d;

    public TJWebViewJSInterface(WebView webView, TJWebViewJSInterfaceListener tJWebViewJSInterfaceListener) {
        this.a = webView;
        this.b = tJWebViewJSInterfaceListener;
    }

    public void callback(ArrayList arrayList, String string, String string2) {
        try {
            this.callbackToJavaScript((Object)new JSONArray((Collection)arrayList), string, string2);
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return;
        }
    }

    public void callback(Map map, String string, String string2) {
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put((Object)new JSONObject(map));
            this.callbackToJavaScript((Object)jSONArray, string, string2);
            return;
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder("Exception in callback to JS: ");
            stringBuilder.append(exception.toString());
            TapjoyLog.e((String)"TJWebViewJSInterface", (String)stringBuilder.toString());
            exception.printStackTrace();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void callbackToJavaScript(Object object, String string, String string2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("arguments", object);
            if (string != null && string.length() > 0) {
                jSONObject.put("method", (Object)string);
            }
            JSONObject jSONObject2 = new JSONObject();
            if (string2 != null && string2.length() > 0) {
                jSONObject2.put("callbackId", (Object)string2);
            }
            jSONObject2.put("data", (Object)jSONObject);
            StringBuilder stringBuilder = new StringBuilder("javascript:if(window.AndroidWebViewJavascriptBridge) AndroidWebViewJavascriptBridge._handleMessageFromAndroid('");
            stringBuilder.append((Object)jSONObject2);
            stringBuilder.append("');");
            String string3 = stringBuilder.toString();
            if (!this.d) {
                this.c.add((Object)string3);
                return;
            }
            new a(this.a).execute((Object[])new String[]{string3});
            return;
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder("Exception in callback to JS: ");
            stringBuilder.append(exception.toString());
            TapjoyLog.e((String)"TJWebViewJSInterface", (String)stringBuilder.toString());
            exception.printStackTrace();
            return;
        }
    }

    @JavascriptInterface
    public void dispatchMethod(String string) {
        StringBuilder stringBuilder = new StringBuilder("dispatchMethod params: ");
        stringBuilder.append(string);
        TapjoyLog.d((String)"TJWebViewJSInterface", (String)stringBuilder.toString());
        try {
            JSONObject jSONObject = new JSONObject(string);
            String string2 = jSONObject.getJSONObject("data").getString("method");
            StringBuilder stringBuilder2 = new StringBuilder("method: ");
            stringBuilder2.append(string2);
            TapjoyLog.d((String)"TJWebViewJSInterface", (String)stringBuilder2.toString());
            if (this.b != null) {
                this.b.onDispatchMethod(string2, jSONObject);
            }
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return;
        }
    }

    public void flushMessageQueue() {
        if (!this.d) {
            String string;
            while ((string = (String)this.c.poll()) != null) {
                new a(this.a).execute((Object[])new String[]{string});
            }
            this.d = true;
        }
    }

    @TargetApi(value=19)
    final class a
    extends AsyncTask {
        WebView a;

        public a(WebView webView) {
            this.a = webView;
        }

        protected final /* synthetic */ void onPostExecute(Object object) {
            String string = (String)object;
            if (this.a != null) {
                if (string.startsWith("javascript:") && Build.VERSION.SDK_INT >= 19) {
                    try {
                        String string2 = string.replaceFirst("javascript:", "");
                        this.a.evaluateJavascript(string2, null);
                        return;
                    }
                    catch (Exception exception) {
                        TapjoyErrorMessage.ErrorType errorType = TapjoyErrorMessage.ErrorType.INTERNAL_ERROR;
                        StringBuilder stringBuilder = new StringBuilder("Exception in evaluateJavascript. Device not supported. ");
                        stringBuilder.append(exception.toString());
                        TapjoyLog.e((String)"TJWebViewJSInterface", (TapjoyErrorMessage)new TapjoyErrorMessage(errorType, stringBuilder.toString()));
                        return;
                    }
                }
                try {
                    this.a.loadUrl(string);
                    return;
                }
                catch (Exception exception) {
                    TapjoyErrorMessage.ErrorType errorType = TapjoyErrorMessage.ErrorType.INTERNAL_ERROR;
                    StringBuilder stringBuilder = new StringBuilder("Exception in loadUrl. Device not supported. ");
                    stringBuilder.append(exception.toString());
                    TapjoyLog.e((String)"TJWebViewJSInterface", (TapjoyErrorMessage)new TapjoyErrorMessage(errorType, stringBuilder.toString()));
                }
            }
        }
    }

}


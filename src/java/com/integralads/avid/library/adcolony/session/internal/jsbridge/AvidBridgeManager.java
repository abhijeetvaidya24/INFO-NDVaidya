/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  android.webkit.WebView
 *  com.integralads.avid.library.adcolony.weakreference.AvidWebView
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  org.json.JSONObject
 */
package com.integralads.avid.library.adcolony.session.internal.jsbridge;

import android.text.TextUtils;
import android.webkit.WebView;
import com.integralads.avid.library.adcolony.AvidBridge;
import com.integralads.avid.library.adcolony.session.internal.InternalAvidAdSessionContext;
import com.integralads.avid.library.adcolony.session.internal.jsbridge.AvidEvent;
import com.integralads.avid.library.adcolony.utils.AvidCommand;
import com.integralads.avid.library.adcolony.weakreference.AvidWebView;
import java.util.ArrayList;
import org.json.JSONObject;

public class AvidBridgeManager {
    private final InternalAvidAdSessionContext a;
    private boolean b;
    private AvidWebView c;
    private boolean d;
    private AvidBridgeManagerListener e;
    private final ArrayList<AvidEvent> f = new ArrayList();

    public AvidBridgeManager(InternalAvidAdSessionContext internalAvidAdSessionContext) {
        this.a = internalAvidAdSessionContext;
        this.c = new AvidWebView(null);
    }

    private void a() {
        if (this.c.isEmpty()) {
            return;
        }
        this.b = true;
        this.c.injectJavaScript(AvidBridge.getAvidJs());
        this.c();
        this.b();
        this.e();
        this.d();
    }

    private void a(String string, JSONObject jSONObject) {
        String string2 = jSONObject != null ? jSONObject.toString() : null;
        if (!TextUtils.isEmpty((CharSequence)string2)) {
            this.callAvidbridge(AvidCommand.publishVideoEvent(string, string2));
            return;
        }
        this.callAvidbridge(AvidCommand.publishVideoEvent(string));
    }

    private void b() {
        if (this.isActive() && this.d) {
            this.callAvidbridge(AvidCommand.publishReadyEventForDeferredAdSession());
        }
    }

    private void c() {
        this.callAvidbridge(AvidCommand.setAvidAdSessionContext(this.a.getFullContext().toString()));
    }

    private void d() {
        AvidBridgeManagerListener avidBridgeManagerListener = this.e;
        if (avidBridgeManagerListener != null) {
            avidBridgeManagerListener.avidBridgeManagerDidInjectAvidJs();
        }
    }

    private void e() {
        for (AvidEvent avidEvent : this.f) {
            this.a(avidEvent.getType(), avidEvent.getData());
        }
        this.f.clear();
    }

    public void callAvidbridge(String string) {
        this.c.injectFormattedJavaScript(string);
    }

    public void destroy() {
        this.setWebView(null);
    }

    public boolean isActive() {
        return this.b;
    }

    public void onAvidJsReady() {
        this.a();
    }

    public void publishAppState(String string) {
        this.callAvidbridge(AvidCommand.setAppState(string));
    }

    public void publishNativeViewState(String string) {
        this.callAvidbridge(AvidCommand.setNativeViewState(string));
    }

    public void publishReadyEventForDeferredAdSession() {
        this.d = true;
        this.b();
    }

    public void publishVideoEvent(String string, JSONObject jSONObject) {
        if (this.isActive()) {
            this.a(string, jSONObject);
            return;
        }
        this.f.add((Object)new AvidEvent(1, string, jSONObject));
    }

    public void setListener(AvidBridgeManagerListener avidBridgeManagerListener) {
        this.e = avidBridgeManagerListener;
    }

    public void setWebView(WebView webView) {
        if (this.c.get() == webView) {
            return;
        }
        this.c.set((Object)webView);
        this.b = false;
        if (AvidBridge.isAvidJsReady()) {
            this.a();
        }
    }

    public static interface AvidBridgeManagerListener {
        public void avidBridgeManagerDidInjectAvidJs();
    }

}


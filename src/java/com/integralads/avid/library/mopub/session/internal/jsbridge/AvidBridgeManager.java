/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  android.webkit.WebView
 *  com.integralads.avid.library.mopub.weakreference.AvidWebView
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  org.json.JSONObject
 */
package com.integralads.avid.library.mopub.session.internal.jsbridge;

import android.text.TextUtils;
import android.webkit.WebView;
import com.integralads.avid.library.mopub.AvidBridge;
import com.integralads.avid.library.mopub.session.internal.InternalAvidAdSessionContext;
import com.integralads.avid.library.mopub.session.internal.jsbridge.AvidEvent;
import com.integralads.avid.library.mopub.utils.AvidCommand;
import com.integralads.avid.library.mopub.weakreference.AvidWebView;
import java.util.ArrayList;
import org.json.JSONObject;

public class AvidBridgeManager {
    public static final int VIDEO_EVENT_TAG = 1;
    private final InternalAvidAdSessionContext avidAdSessionContext;
    private AvidWebView avidWebView;
    private boolean isAvidJsInjected;
    private boolean isReadyEventPublished;
    private AvidBridgeManagerListener listener;
    private final ArrayList<AvidEvent> pendingEvents = new ArrayList();

    public AvidBridgeManager(InternalAvidAdSessionContext internalAvidAdSessionContext) {
        this.avidAdSessionContext = internalAvidAdSessionContext;
        this.avidWebView = new AvidWebView(null);
    }

    private void injectAvid() {
        if (this.avidWebView.isEmpty()) {
            return;
        }
        this.isAvidJsInjected = true;
        this.avidWebView.injectJavaScript(AvidBridge.getAvidJs());
        this.setAvidAdSessionContext();
        this.publishReadyEventIfNeeded();
        this.publishPendingEvents();
        this.notifyListener();
    }

    private void invokePublishVideoEvent(String string, JSONObject jSONObject) {
        String string2 = jSONObject != null ? jSONObject.toString() : null;
        if (!TextUtils.isEmpty((CharSequence)string2)) {
            this.callAvidbridge(AvidCommand.publishVideoEvent(string, string2));
            return;
        }
        this.callAvidbridge(AvidCommand.publishVideoEvent(string));
    }

    private void notifyListener() {
        AvidBridgeManagerListener avidBridgeManagerListener = this.listener;
        if (avidBridgeManagerListener != null) {
            avidBridgeManagerListener.avidBridgeManagerDidInjectAvidJs();
        }
    }

    private void publishPendingEvents() {
        for (AvidEvent avidEvent : this.pendingEvents) {
            this.invokePublishVideoEvent(avidEvent.getType(), avidEvent.getData());
        }
        this.pendingEvents.clear();
    }

    private void publishReadyEventIfNeeded() {
        if (this.isActive() && this.isReadyEventPublished) {
            this.callAvidbridge(AvidCommand.publishReadyEventForDeferredAdSession());
        }
    }

    private void setAvidAdSessionContext() {
        this.callAvidbridge(AvidCommand.setAvidAdSessionContext(this.avidAdSessionContext.getFullContext().toString()));
    }

    public void callAvidbridge(String string) {
        this.avidWebView.injectFormattedJavaScript(string);
    }

    public void destroy() {
        this.setWebView(null);
    }

    public boolean isActive() {
        return this.isAvidJsInjected;
    }

    public void onAvidJsReady() {
        this.injectAvid();
    }

    public void publishAppState(String string) {
        this.callAvidbridge(AvidCommand.setAppState(string));
    }

    public void publishNativeViewState(String string) {
        this.callAvidbridge(AvidCommand.setNativeViewState(string));
    }

    public void publishReadyEventForDeferredAdSession() {
        this.isReadyEventPublished = true;
        this.publishReadyEventIfNeeded();
    }

    public void publishVideoEvent(String string, JSONObject jSONObject) {
        if (this.isActive()) {
            this.invokePublishVideoEvent(string, jSONObject);
            return;
        }
        this.pendingEvents.add((Object)new AvidEvent(1, string, jSONObject));
    }

    public void setListener(AvidBridgeManagerListener avidBridgeManagerListener) {
        this.listener = avidBridgeManagerListener;
    }

    public void setWebView(WebView webView) {
        if (this.avidWebView.get() == webView) {
            return;
        }
        this.avidWebView.set((Object)webView);
        this.isAvidJsInjected = false;
        if (AvidBridge.isAvidJsReady()) {
            this.injectAvid();
        }
    }

    public static interface AvidBridgeManagerListener {
        public void avidBridgeManagerDidInjectAvidJs();
    }

}


/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  android.webkit.WebView
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.integralads.avid.library.mopub.session.internal;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import com.integralads.avid.library.mopub.deferred.AvidDeferredAdSessionListener;
import com.integralads.avid.library.mopub.deferred.AvidDeferredAdSessionListenerImpl;
import com.integralads.avid.library.mopub.session.ExternalAvidAdSessionContext;
import com.integralads.avid.library.mopub.session.internal.InternalAvidAdSessionContext;
import com.integralads.avid.library.mopub.session.internal.InternalAvidAdSessionListener;
import com.integralads.avid.library.mopub.session.internal.MediaType;
import com.integralads.avid.library.mopub.session.internal.ObstructionsWhiteList;
import com.integralads.avid.library.mopub.session.internal.SessionType;
import com.integralads.avid.library.mopub.session.internal.jsbridge.AvidBridgeManager;
import com.integralads.avid.library.mopub.session.internal.jsbridge.AvidWebViewManager;
import com.integralads.avid.library.mopub.utils.AvidJSONUtil;
import com.integralads.avid.library.mopub.utils.AvidTimestamp;
import com.integralads.avid.library.mopub.weakreference.AvidView;

public abstract class InternalAvidAdSession<T extends View>
implements AvidBridgeManager.AvidBridgeManagerListener {
    private AdState adState;
    private AvidBridgeManager avidBridgeManager;
    private AvidDeferredAdSessionListenerImpl avidDeferredAdSessionListener;
    private AvidView<T> avidView;
    private final InternalAvidAdSessionContext internalContext;
    private boolean isActive;
    private boolean isReady;
    private double lastUpdated;
    private InternalAvidAdSessionListener listener;
    private final ObstructionsWhiteList obstructionsWhiteList;
    private AvidWebViewManager webViewManager;

    public InternalAvidAdSession(Context context, String string, ExternalAvidAdSessionContext externalAvidAdSessionContext) {
        InternalAvidAdSessionContext internalAvidAdSessionContext;
        this.internalContext = internalAvidAdSessionContext = new InternalAvidAdSessionContext(context, string, this.getSessionType().toString(), this.getMediaType().toString(), externalAvidAdSessionContext);
        this.avidBridgeManager = new AvidBridgeManager(this.internalContext);
        this.avidBridgeManager.setListener(this);
        this.webViewManager = new AvidWebViewManager(this.internalContext, this.avidBridgeManager);
        this.avidView = new AvidView<Object>(null);
        this.isReady = true ^ externalAvidAdSessionContext.isDeferred();
        if (!this.isReady) {
            this.avidDeferredAdSessionListener = new AvidDeferredAdSessionListenerImpl(this, this.avidBridgeManager);
        }
        this.obstructionsWhiteList = new ObstructionsWhiteList();
        this.onViewChanged();
    }

    private void onViewChanged() {
        this.lastUpdated = AvidTimestamp.getCurrentTime();
        this.adState = AdState.AD_STATE_IDLE;
    }

    @Override
    public void avidBridgeManagerDidInjectAvidJs() {
        this.sessionStateCanBeChanged();
    }

    protected void cleanupViewState() {
        if (this.isActive()) {
            this.avidBridgeManager.publishNativeViewState(AvidJSONUtil.getEmptyTreeJSONObject().toString());
        }
    }

    public boolean doesManageView(View view) {
        return this.avidView.contains((Object)view);
    }

    public ExternalAvidAdSessionContext getAvidAdSessionContext() {
        return this.internalContext.getAvidAdSessionContext();
    }

    public String getAvidAdSessionId() {
        return this.internalContext.getAvidAdSessionId();
    }

    public AvidBridgeManager getAvidBridgeManager() {
        return this.avidBridgeManager;
    }

    public AvidDeferredAdSessionListener getAvidDeferredAdSessionListener() {
        return this.avidDeferredAdSessionListener;
    }

    public InternalAvidAdSessionListener getListener() {
        return this.listener;
    }

    public abstract MediaType getMediaType();

    public ObstructionsWhiteList getObstructionsWhiteList() {
        return this.obstructionsWhiteList;
    }

    public abstract SessionType getSessionType();

    public T getView() {
        return (T)((View)this.avidView.get());
    }

    public abstract WebView getWebView();

    public boolean isActive() {
        return this.isActive;
    }

    public boolean isEmpty() {
        return this.avidView.isEmpty();
    }

    public boolean isReady() {
        return this.isReady;
    }

    public void onEnd() {
        this.cleanupViewState();
        AvidDeferredAdSessionListenerImpl avidDeferredAdSessionListenerImpl = this.avidDeferredAdSessionListener;
        if (avidDeferredAdSessionListenerImpl != null) {
            avidDeferredAdSessionListenerImpl.destroy();
        }
        this.avidBridgeManager.destroy();
        this.webViewManager.destroy();
        this.isReady = false;
        this.sessionStateCanBeChanged();
        InternalAvidAdSessionListener internalAvidAdSessionListener = this.listener;
        if (internalAvidAdSessionListener != null) {
            internalAvidAdSessionListener.sessionDidEnd(this);
        }
    }

    public void onReady() {
        this.isReady = true;
        this.sessionStateCanBeChanged();
    }

    public void onStart() {
    }

    protected void onViewRegistered() {
    }

    protected void onViewUnregistered() {
    }

    public void publishEmptyNativeViewStateCommand(String string, double d2) {
        if (d2 > this.lastUpdated && this.adState != AdState.AD_STATE_HIDDEN) {
            this.avidBridgeManager.callAvidbridge(string);
            this.adState = AdState.AD_STATE_HIDDEN;
        }
    }

    public void publishNativeViewStateCommand(String string, double d2) {
        if (d2 > this.lastUpdated) {
            this.avidBridgeManager.callAvidbridge(string);
            this.adState = AdState.AD_STATE_VISIBLE;
        }
    }

    public void registerAdView(T t2) {
        if (!this.doesManageView((View)t2)) {
            this.onViewChanged();
            this.avidView.set(t2);
            this.onViewRegistered();
            this.sessionStateCanBeChanged();
        }
    }

    protected void sessionStateCanBeChanged() {
        boolean bl = this.avidBridgeManager.isActive() && this.isReady && !this.isEmpty();
        if (this.isActive != bl) {
            this.setActive(bl);
        }
    }

    protected void setActive(boolean bl) {
        this.isActive = bl;
        InternalAvidAdSessionListener internalAvidAdSessionListener = this.listener;
        if (internalAvidAdSessionListener != null) {
            if (bl) {
                internalAvidAdSessionListener.sessionHasBecomeActive(this);
                return;
            }
            internalAvidAdSessionListener.sessionHasResignedActive(this);
        }
    }

    public void setListener(InternalAvidAdSessionListener internalAvidAdSessionListener) {
        this.listener = internalAvidAdSessionListener;
    }

    public void setScreenMode(boolean bl) {
        if (this.isActive()) {
            String string = bl ? "active" : "inactive";
            this.avidBridgeManager.publishAppState(string);
        }
    }

    public void unregisterAdView(T t2) {
        if (this.doesManageView((View)t2)) {
            this.onViewChanged();
            this.cleanupViewState();
            this.avidView.set(null);
            this.onViewUnregistered();
            this.sessionStateCanBeChanged();
        }
    }

    protected void updateWebViewManager() {
        this.webViewManager.setWebView(this.getWebView());
    }

}


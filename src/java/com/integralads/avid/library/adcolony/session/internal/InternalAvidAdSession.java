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
package com.integralads.avid.library.adcolony.session.internal;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import com.integralads.avid.library.adcolony.deferred.AvidDeferredAdSessionListener;
import com.integralads.avid.library.adcolony.deferred.AvidDeferredAdSessionListenerImpl;
import com.integralads.avid.library.adcolony.session.ExternalAvidAdSessionContext;
import com.integralads.avid.library.adcolony.session.internal.InternalAvidAdSessionContext;
import com.integralads.avid.library.adcolony.session.internal.InternalAvidAdSessionListener;
import com.integralads.avid.library.adcolony.session.internal.MediaType;
import com.integralads.avid.library.adcolony.session.internal.ObstructionsWhiteList;
import com.integralads.avid.library.adcolony.session.internal.SessionType;
import com.integralads.avid.library.adcolony.session.internal.jsbridge.AvidBridgeManager;
import com.integralads.avid.library.adcolony.session.internal.jsbridge.AvidWebViewManager;
import com.integralads.avid.library.adcolony.utils.AvidJSONUtil;
import com.integralads.avid.library.adcolony.utils.AvidTimestamp;
import com.integralads.avid.library.adcolony.weakreference.AvidView;

public abstract class InternalAvidAdSession<T extends View>
implements AvidBridgeManager.AvidBridgeManagerListener {
    private final InternalAvidAdSessionContext a;
    private AvidBridgeManager b;
    private AvidWebViewManager c;
    private AvidView<T> d;
    private AvidDeferredAdSessionListenerImpl e;
    private InternalAvidAdSessionListener f;
    private boolean g;
    private boolean h;
    private final ObstructionsWhiteList i;
    private a j;
    private double k;

    public InternalAvidAdSession(Context context, String string, ExternalAvidAdSessionContext externalAvidAdSessionContext) {
        InternalAvidAdSessionContext internalAvidAdSessionContext;
        this.a = internalAvidAdSessionContext = new InternalAvidAdSessionContext(context, string, this.getSessionType().toString(), this.getMediaType().toString(), externalAvidAdSessionContext);
        this.b = new AvidBridgeManager(this.a);
        this.b.setListener(this);
        this.c = new AvidWebViewManager(this.a, this.b);
        this.d = new AvidView<Object>(null);
        this.g = true ^ externalAvidAdSessionContext.isDeferred();
        if (!this.g) {
            this.e = new AvidDeferredAdSessionListenerImpl(this, this.b);
        }
        this.i = new ObstructionsWhiteList();
        this.c();
    }

    private void c() {
        this.k = AvidTimestamp.getCurrentTime();
        this.j = a.a;
    }

    @Override
    public void avidBridgeManagerDidInjectAvidJs() {
        this.sessionStateCanBeChanged();
    }

    protected void cleanupViewState() {
        if (this.isActive()) {
            this.b.publishNativeViewState(AvidJSONUtil.getEmptyTreeJSONObject().toString());
        }
    }

    public boolean doesManageView(View view) {
        return this.d.contains((Object)view);
    }

    public String getAvidAdSessionId() {
        return this.a.getAvidAdSessionId();
    }

    public AvidBridgeManager getAvidBridgeManager() {
        return this.b;
    }

    public AvidDeferredAdSessionListener getAvidDeferredAdSessionListener() {
        return this.e;
    }

    public abstract MediaType getMediaType();

    public ObstructionsWhiteList getObstructionsWhiteList() {
        return this.i;
    }

    public abstract SessionType getSessionType();

    public T getView() {
        return (T)((View)this.d.get());
    }

    public abstract WebView getWebView();

    public boolean isActive() {
        return this.h;
    }

    public boolean isEmpty() {
        return this.d.isEmpty();
    }

    public boolean isReady() {
        return this.g;
    }

    public void onEnd() {
        this.cleanupViewState();
        AvidDeferredAdSessionListenerImpl avidDeferredAdSessionListenerImpl = this.e;
        if (avidDeferredAdSessionListenerImpl != null) {
            avidDeferredAdSessionListenerImpl.destroy();
        }
        this.b.destroy();
        this.c.destroy();
        this.g = false;
        this.sessionStateCanBeChanged();
        InternalAvidAdSessionListener internalAvidAdSessionListener = this.f;
        if (internalAvidAdSessionListener != null) {
            internalAvidAdSessionListener.sessionDidEnd(this);
        }
    }

    public void onReady() {
        this.g = true;
        this.sessionStateCanBeChanged();
    }

    public void onStart() {
    }

    protected void onViewRegistered() {
    }

    public void publishEmptyNativeViewStateCommand(String string, double d2) {
        if (d2 > this.k && this.j != a.c) {
            this.b.callAvidbridge(string);
            this.j = a.c;
        }
    }

    public void publishNativeViewStateCommand(String string, double d2) {
        if (d2 > this.k) {
            this.b.callAvidbridge(string);
            this.j = a.b;
        }
    }

    public void registerAdView(T t2) {
        if (!this.doesManageView((View)t2)) {
            this.c();
            this.d.set(t2);
            this.onViewRegistered();
            this.sessionStateCanBeChanged();
        }
    }

    protected void sessionStateCanBeChanged() {
        boolean bl = this.b.isActive() && this.g && !this.isEmpty();
        if (this.h != bl) {
            this.setActive(bl);
        }
    }

    protected void setActive(boolean bl) {
        this.h = bl;
        InternalAvidAdSessionListener internalAvidAdSessionListener = this.f;
        if (internalAvidAdSessionListener != null) {
            if (bl) {
                internalAvidAdSessionListener.sessionHasBecomeActive(this);
                return;
            }
            internalAvidAdSessionListener.sessionHasResignedActive(this);
        }
    }

    public void setListener(InternalAvidAdSessionListener internalAvidAdSessionListener) {
        this.f = internalAvidAdSessionListener;
    }

    public void setScreenMode(boolean bl) {
        if (this.isActive()) {
            String string = bl ? "active" : "inactive";
            this.b.publishAppState(string);
        }
    }

    protected void updateWebViewManager() {
        this.c.setWebView(this.getWebView());
    }

}


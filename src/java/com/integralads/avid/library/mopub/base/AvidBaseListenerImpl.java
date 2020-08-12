/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.integralads.avid.library.mopub.session.internal.InternalAvidAdSession
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 */
package com.integralads.avid.library.mopub.base;

import com.integralads.avid.library.mopub.session.internal.InternalAvidAdSession;
import com.integralads.avid.library.mopub.session.internal.jsbridge.AvidBridgeManager;

public abstract class AvidBaseListenerImpl {
    private InternalAvidAdSession avidAdSession;
    private AvidBridgeManager avidBridgeManager;

    public AvidBaseListenerImpl(InternalAvidAdSession internalAvidAdSession, AvidBridgeManager avidBridgeManager) {
        this.avidAdSession = internalAvidAdSession;
        this.avidBridgeManager = avidBridgeManager;
    }

    protected void assertSessionIsNotEnded() {
        if (this.avidAdSession != null) {
            return;
        }
        throw new IllegalStateException("The AVID ad session is ended. Please ensure you are not recording events after the session has ended.");
    }

    public void destroy() {
        this.avidAdSession = null;
        this.avidBridgeManager = null;
    }

    protected InternalAvidAdSession getAvidAdSession() {
        return this.avidAdSession;
    }

    protected AvidBridgeManager getAvidBridgeManager() {
        return this.avidBridgeManager;
    }
}


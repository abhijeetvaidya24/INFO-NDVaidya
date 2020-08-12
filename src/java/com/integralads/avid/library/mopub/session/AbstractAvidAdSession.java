/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.view.View
 *  com.integralads.avid.library.mopub.AvidManager
 *  com.integralads.avid.library.mopub.session.internal.InternalAvidAdSession
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.UUID
 */
package com.integralads.avid.library.mopub.session;

import android.app.Activity;
import android.view.View;
import com.integralads.avid.library.mopub.AvidManager;
import com.integralads.avid.library.mopub.deferred.AvidDeferredAdSessionListener;
import com.integralads.avid.library.mopub.session.internal.InternalAvidAdSession;
import com.integralads.avid.library.mopub.session.internal.ObstructionsWhiteList;
import java.util.UUID;

public abstract class AbstractAvidAdSession<T extends View> {
    private String avidAdSessionId = UUID.randomUUID().toString();

    public void endSession() {
        InternalAvidAdSession internalAvidAdSession = AvidManager.getInstance().findInternalAvidAdSessionById(this.getAvidAdSessionId());
        if (internalAvidAdSession != null) {
            internalAvidAdSession.onEnd();
        }
    }

    public String getAvidAdSessionId() {
        return this.avidAdSessionId;
    }

    public AvidDeferredAdSessionListener getAvidDeferredAdSessionListener() {
        InternalAvidAdSession internalAvidAdSession = AvidManager.getInstance().findInternalAvidAdSessionById(this.getAvidAdSessionId());
        AvidDeferredAdSessionListener avidDeferredAdSessionListener = internalAvidAdSession != null ? internalAvidAdSession.getAvidDeferredAdSessionListener() : null;
        if (avidDeferredAdSessionListener != null) {
            return avidDeferredAdSessionListener;
        }
        throw new IllegalStateException("The AVID ad session is not deferred. Please ensure you are only using AvidDeferredAdSessionListener for deferred AVID ad session.");
    }

    public void registerAdView(T t2, Activity activity) {
        InternalAvidAdSession internalAvidAdSession = AvidManager.getInstance().findInternalAvidAdSessionById(this.avidAdSessionId);
        if (internalAvidAdSession != null) {
            internalAvidAdSession.registerAdView(t2);
        }
        AvidManager.getInstance().registerActivity(activity);
    }

    public void registerFriendlyObstruction(View view) {
        InternalAvidAdSession internalAvidAdSession = AvidManager.getInstance().findInternalAvidAdSessionById(this.getAvidAdSessionId());
        if (internalAvidAdSession != null) {
            internalAvidAdSession.getObstructionsWhiteList().add(view);
        }
    }

    public void unregisterAdView(T t2) {
        InternalAvidAdSession internalAvidAdSession = AvidManager.getInstance().findInternalAvidAdSessionById(this.avidAdSessionId);
        if (internalAvidAdSession != null) {
            internalAvidAdSession.unregisterAdView(t2);
        }
    }
}


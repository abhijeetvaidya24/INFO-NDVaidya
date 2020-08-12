/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.view.View
 *  com.integralads.avid.library.adcolony.AvidManager
 *  com.integralads.avid.library.adcolony.session.internal.InternalAvidAdSession
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.UUID
 */
package com.integralads.avid.library.adcolony.session;

import android.app.Activity;
import android.view.View;
import com.integralads.avid.library.adcolony.AvidManager;
import com.integralads.avid.library.adcolony.deferred.AvidDeferredAdSessionListener;
import com.integralads.avid.library.adcolony.session.internal.InternalAvidAdSession;
import com.integralads.avid.library.adcolony.session.internal.ObstructionsWhiteList;
import java.util.UUID;

public abstract class AbstractAvidAdSession<T extends View> {
    private String a = UUID.randomUUID().toString();

    public void endSession() {
        InternalAvidAdSession internalAvidAdSession = AvidManager.getInstance().findInternalAvidAdSessionById(this.getAvidAdSessionId());
        if (internalAvidAdSession != null) {
            internalAvidAdSession.onEnd();
        }
    }

    public String getAvidAdSessionId() {
        return this.a;
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
        InternalAvidAdSession internalAvidAdSession = AvidManager.getInstance().findInternalAvidAdSessionById(this.a);
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
}


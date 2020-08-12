/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  com.integralads.avid.library.mopub.session.internal.InternalAvidManagedAdSession
 *  java.lang.String
 */
package com.integralads.avid.library.mopub.session;

import android.view.View;
import com.integralads.avid.library.mopub.AvidManager;
import com.integralads.avid.library.mopub.session.AbstractAvidAdSession;
import com.integralads.avid.library.mopub.session.internal.InternalAvidAdSession;
import com.integralads.avid.library.mopub.session.internal.InternalAvidManagedAdSession;
import com.integralads.avid.library.mopub.session.internal.trackingwebview.AvidJavaScriptResourceInjector;

public abstract class AbstractAvidManagedAdSession
extends AbstractAvidAdSession<View> {
    public void injectJavaScriptResource(String string) {
        InternalAvidManagedAdSession internalAvidManagedAdSession = (InternalAvidManagedAdSession)AvidManager.getInstance().findInternalAvidAdSessionById(this.getAvidAdSessionId());
        if (internalAvidManagedAdSession != null) {
            internalAvidManagedAdSession.getJavaScriptResourceInjector().injectJavaScriptResource(string);
        }
    }
}


/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  com.integralads.avid.library.adcolony.session.internal.InternalAvidManagedAdSession
 *  java.lang.String
 */
package com.integralads.avid.library.adcolony.session;

import android.view.View;
import com.integralads.avid.library.adcolony.AvidManager;
import com.integralads.avid.library.adcolony.session.AbstractAvidAdSession;
import com.integralads.avid.library.adcolony.session.internal.InternalAvidAdSession;
import com.integralads.avid.library.adcolony.session.internal.InternalAvidManagedAdSession;
import com.integralads.avid.library.adcolony.session.internal.trackingwebview.AvidJavaScriptResourceInjector;

public abstract class AbstractAvidManagedAdSession
extends AbstractAvidAdSession<View> {
    public void injectJavaScriptResource(String string) {
        InternalAvidManagedAdSession internalAvidManagedAdSession = (InternalAvidManagedAdSession)AvidManager.getInstance().findInternalAvidAdSessionById(this.getAvidAdSessionId());
        if (internalAvidManagedAdSession != null) {
            internalAvidManagedAdSession.getJavaScriptResourceInjector().injectJavaScriptResource(string);
        }
    }
}


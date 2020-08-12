/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.String
 */
package com.integralads.avid.library.adcolony.session.internal;

import android.content.Context;
import com.integralads.avid.library.adcolony.session.ExternalAvidAdSessionContext;
import com.integralads.avid.library.adcolony.session.internal.InternalAvidHtmlAdSession;
import com.integralads.avid.library.adcolony.session.internal.MediaType;
import com.integralads.avid.library.adcolony.session.internal.SessionType;

public class InternalAvidVideoAdSession
extends InternalAvidHtmlAdSession {
    public InternalAvidVideoAdSession(Context context, String string, ExternalAvidAdSessionContext externalAvidAdSessionContext) {
        super(context, string, externalAvidAdSessionContext);
    }

    @Override
    public MediaType getMediaType() {
        return MediaType.VIDEO;
    }

    @Override
    public SessionType getSessionType() {
        return SessionType.VIDEO;
    }
}


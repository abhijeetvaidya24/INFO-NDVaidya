/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.String
 */
package com.integralads.avid.library.mopub.session.internal;

import android.content.Context;
import com.integralads.avid.library.mopub.session.ExternalAvidAdSessionContext;
import com.integralads.avid.library.mopub.session.internal.InternalAvidHtmlAdSession;
import com.integralads.avid.library.mopub.session.internal.MediaType;
import com.integralads.avid.library.mopub.session.internal.SessionType;

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


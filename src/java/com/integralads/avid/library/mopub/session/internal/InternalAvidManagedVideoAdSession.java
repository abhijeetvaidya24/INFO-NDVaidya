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
import com.integralads.avid.library.mopub.session.internal.InternalAvidAdSession;
import com.integralads.avid.library.mopub.session.internal.InternalAvidManagedAdSession;
import com.integralads.avid.library.mopub.session.internal.MediaType;
import com.integralads.avid.library.mopub.session.internal.SessionType;
import com.integralads.avid.library.mopub.session.internal.jsbridge.AvidBridgeManager;
import com.integralads.avid.library.mopub.video.AvidVideoPlaybackListenerImpl;

public class InternalAvidManagedVideoAdSession
extends InternalAvidManagedAdSession {
    private AvidVideoPlaybackListenerImpl avidVideoPlaybackListener = new AvidVideoPlaybackListenerImpl(this, this.getAvidBridgeManager());

    public InternalAvidManagedVideoAdSession(Context context, String string, ExternalAvidAdSessionContext externalAvidAdSessionContext) {
        super(context, string, externalAvidAdSessionContext);
    }

    public AvidVideoPlaybackListenerImpl getAvidVideoPlaybackListener() {
        return this.avidVideoPlaybackListener;
    }

    @Override
    public MediaType getMediaType() {
        return MediaType.VIDEO;
    }

    @Override
    public SessionType getSessionType() {
        return SessionType.MANAGED_VIDEO;
    }

    @Override
    public void onEnd() {
        this.avidVideoPlaybackListener.destroy();
        super.onEnd();
    }
}


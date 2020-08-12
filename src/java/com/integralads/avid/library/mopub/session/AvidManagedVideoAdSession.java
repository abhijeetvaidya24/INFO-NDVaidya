/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.integralads.avid.library.mopub.session.internal.InternalAvidManagedVideoAdSession
 *  java.lang.String
 */
package com.integralads.avid.library.mopub.session;

import com.integralads.avid.library.mopub.AvidManager;
import com.integralads.avid.library.mopub.session.AbstractAvidManagedAdSession;
import com.integralads.avid.library.mopub.session.internal.InternalAvidAdSession;
import com.integralads.avid.library.mopub.session.internal.InternalAvidManagedVideoAdSession;
import com.integralads.avid.library.mopub.video.AvidVideoPlaybackListener;
import com.integralads.avid.library.mopub.video.AvidVideoPlaybackListenerImpl;

public class AvidManagedVideoAdSession
extends AbstractAvidManagedAdSession {
    public AvidVideoPlaybackListener getAvidVideoPlaybackListener() {
        InternalAvidManagedVideoAdSession internalAvidManagedVideoAdSession = (InternalAvidManagedVideoAdSession)AvidManager.getInstance().findInternalAvidAdSessionById(this.getAvidAdSessionId());
        if (internalAvidManagedVideoAdSession != null) {
            return internalAvidManagedVideoAdSession.getAvidVideoPlaybackListener();
        }
        return null;
    }
}


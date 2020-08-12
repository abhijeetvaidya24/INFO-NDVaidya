/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.integralads.avid.library.adcolony.session.internal.InternalAvidManagedVideoAdSession
 *  java.lang.String
 */
package com.integralads.avid.library.adcolony.session;

import com.integralads.avid.library.adcolony.AvidManager;
import com.integralads.avid.library.adcolony.session.AbstractAvidManagedAdSession;
import com.integralads.avid.library.adcolony.session.internal.InternalAvidAdSession;
import com.integralads.avid.library.adcolony.session.internal.InternalAvidManagedVideoAdSession;
import com.integralads.avid.library.adcolony.video.AvidVideoPlaybackListener;
import com.integralads.avid.library.adcolony.video.AvidVideoPlaybackListenerImpl;

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


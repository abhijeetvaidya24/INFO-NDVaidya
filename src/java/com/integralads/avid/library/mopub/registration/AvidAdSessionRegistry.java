/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collection
 *  java.util.HashMap
 */
package com.integralads.avid.library.mopub.registration;

import android.view.View;
import com.integralads.avid.library.mopub.registration.AvidAdSessionRegistryListener;
import com.integralads.avid.library.mopub.session.AbstractAvidAdSession;
import com.integralads.avid.library.mopub.session.internal.InternalAvidAdSession;
import com.integralads.avid.library.mopub.session.internal.InternalAvidAdSessionListener;
import java.util.Collection;
import java.util.HashMap;

public class AvidAdSessionRegistry
implements InternalAvidAdSessionListener {
    private static AvidAdSessionRegistry instance = new AvidAdSessionRegistry();
    private int activeSessionCount = 0;
    private final HashMap<String, AbstractAvidAdSession> avidAdSessions = new HashMap();
    private final HashMap<String, InternalAvidAdSession> internalAvidAdSessions = new HashMap();
    private AvidAdSessionRegistryListener listener;

    public static AvidAdSessionRegistry getInstance() {
        return instance;
    }

    public AbstractAvidAdSession findAvidAdSessionById(String string) {
        return (AbstractAvidAdSession)this.avidAdSessions.get((Object)string);
    }

    public InternalAvidAdSession findInternalAvidAdSessionById(String string) {
        return (InternalAvidAdSession)this.internalAvidAdSessions.get((Object)string);
    }

    public InternalAvidAdSession findInternalAvidAdSessionByView(View view) {
        for (InternalAvidAdSession internalAvidAdSession : this.internalAvidAdSessions.values()) {
            if (!internalAvidAdSession.doesManageView(view)) continue;
            return internalAvidAdSession;
        }
        return null;
    }

    public Collection<AbstractAvidAdSession> getAvidAdSessions() {
        return this.avidAdSessions.values();
    }

    public Collection<InternalAvidAdSession> getInternalAvidAdSessions() {
        return this.internalAvidAdSessions.values();
    }

    public AvidAdSessionRegistryListener getListener() {
        return this.listener;
    }

    public boolean hasActiveSessions() {
        return this.activeSessionCount > 0;
    }

    public boolean isEmpty() {
        return this.avidAdSessions.isEmpty();
    }

    public void registerAvidAdSession(AbstractAvidAdSession abstractAvidAdSession, InternalAvidAdSession internalAvidAdSession) {
        AvidAdSessionRegistryListener avidAdSessionRegistryListener;
        this.avidAdSessions.put((Object)abstractAvidAdSession.getAvidAdSessionId(), (Object)abstractAvidAdSession);
        this.internalAvidAdSessions.put((Object)abstractAvidAdSession.getAvidAdSessionId(), (Object)internalAvidAdSession);
        internalAvidAdSession.setListener(this);
        if (this.avidAdSessions.size() == 1 && (avidAdSessionRegistryListener = this.listener) != null) {
            avidAdSessionRegistryListener.registryHasSessionsChanged(this);
        }
    }

    @Override
    public void sessionDidEnd(InternalAvidAdSession internalAvidAdSession) {
        AvidAdSessionRegistryListener avidAdSessionRegistryListener;
        this.avidAdSessions.remove((Object)internalAvidAdSession.getAvidAdSessionId());
        this.internalAvidAdSessions.remove((Object)internalAvidAdSession.getAvidAdSessionId());
        internalAvidAdSession.setListener(null);
        if (this.avidAdSessions.size() == 0 && (avidAdSessionRegistryListener = this.listener) != null) {
            avidAdSessionRegistryListener.registryHasSessionsChanged(this);
        }
    }

    @Override
    public void sessionHasBecomeActive(InternalAvidAdSession internalAvidAdSession) {
        AvidAdSessionRegistryListener avidAdSessionRegistryListener;
        this.activeSessionCount = 1 + this.activeSessionCount;
        if (this.activeSessionCount == 1 && (avidAdSessionRegistryListener = this.listener) != null) {
            avidAdSessionRegistryListener.registryHasActiveSessionsChanged(this);
        }
    }

    @Override
    public void sessionHasResignedActive(InternalAvidAdSession internalAvidAdSession) {
        AvidAdSessionRegistryListener avidAdSessionRegistryListener;
        this.activeSessionCount = -1 + this.activeSessionCount;
        if (this.activeSessionCount == 0 && (avidAdSessionRegistryListener = this.listener) != null) {
            avidAdSessionRegistryListener.registryHasActiveSessionsChanged(this);
        }
    }

    public void setListener(AvidAdSessionRegistryListener avidAdSessionRegistryListener) {
        this.listener = avidAdSessionRegistryListener;
    }
}


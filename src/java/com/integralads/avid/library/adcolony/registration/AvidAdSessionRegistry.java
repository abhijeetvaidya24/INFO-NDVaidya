/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collection
 *  java.util.HashMap
 */
package com.integralads.avid.library.adcolony.registration;

import com.integralads.avid.library.adcolony.registration.AvidAdSessionRegistryListener;
import com.integralads.avid.library.adcolony.session.AbstractAvidAdSession;
import com.integralads.avid.library.adcolony.session.internal.InternalAvidAdSession;
import com.integralads.avid.library.adcolony.session.internal.InternalAvidAdSessionListener;
import java.util.Collection;
import java.util.HashMap;

public class AvidAdSessionRegistry
implements InternalAvidAdSessionListener {
    private static AvidAdSessionRegistry a = new AvidAdSessionRegistry();
    private final HashMap<String, InternalAvidAdSession> b = new HashMap();
    private final HashMap<String, AbstractAvidAdSession> c = new HashMap();
    private AvidAdSessionRegistryListener d;
    private int e = 0;

    public static AvidAdSessionRegistry getInstance() {
        return a;
    }

    public InternalAvidAdSession findInternalAvidAdSessionById(String string) {
        return (InternalAvidAdSession)this.b.get((Object)string);
    }

    public Collection<InternalAvidAdSession> getInternalAvidAdSessions() {
        return this.b.values();
    }

    public boolean hasActiveSessions() {
        return this.e > 0;
    }

    public boolean isEmpty() {
        return this.c.isEmpty();
    }

    public void registerAvidAdSession(AbstractAvidAdSession abstractAvidAdSession, InternalAvidAdSession internalAvidAdSession) {
        AvidAdSessionRegistryListener avidAdSessionRegistryListener;
        this.c.put((Object)abstractAvidAdSession.getAvidAdSessionId(), (Object)abstractAvidAdSession);
        this.b.put((Object)abstractAvidAdSession.getAvidAdSessionId(), (Object)internalAvidAdSession);
        internalAvidAdSession.setListener(this);
        if (this.c.size() == 1 && (avidAdSessionRegistryListener = this.d) != null) {
            avidAdSessionRegistryListener.registryHasSessionsChanged(this);
        }
    }

    @Override
    public void sessionDidEnd(InternalAvidAdSession internalAvidAdSession) {
        AvidAdSessionRegistryListener avidAdSessionRegistryListener;
        this.c.remove((Object)internalAvidAdSession.getAvidAdSessionId());
        this.b.remove((Object)internalAvidAdSession.getAvidAdSessionId());
        internalAvidAdSession.setListener(null);
        if (this.c.size() == 0 && (avidAdSessionRegistryListener = this.d) != null) {
            avidAdSessionRegistryListener.registryHasSessionsChanged(this);
        }
    }

    @Override
    public void sessionHasBecomeActive(InternalAvidAdSession internalAvidAdSession) {
        AvidAdSessionRegistryListener avidAdSessionRegistryListener;
        this.e = 1 + this.e;
        if (this.e == 1 && (avidAdSessionRegistryListener = this.d) != null) {
            avidAdSessionRegistryListener.registryHasActiveSessionsChanged(this);
        }
    }

    @Override
    public void sessionHasResignedActive(InternalAvidAdSession internalAvidAdSession) {
        AvidAdSessionRegistryListener avidAdSessionRegistryListener;
        this.e = -1 + this.e;
        if (this.e == 0 && (avidAdSessionRegistryListener = this.d) != null) {
            avidAdSessionRegistryListener.registryHasActiveSessionsChanged(this);
        }
    }

    public void setListener(AvidAdSessionRegistryListener avidAdSessionRegistryListener) {
        this.d = avidAdSessionRegistryListener;
    }
}


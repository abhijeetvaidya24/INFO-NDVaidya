/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.integralads.avid.library.adcolony.AvidManager
 *  com.integralads.avid.library.adcolony.session.AvidDisplayAdSession
 *  com.integralads.avid.library.adcolony.session.AvidManagedVideoAdSession
 *  com.integralads.avid.library.adcolony.session.AvidVideoAdSession
 *  com.integralads.avid.library.adcolony.session.internal.InternalAvidAdSession
 *  com.integralads.avid.library.adcolony.session.internal.InternalAvidDisplayAdSession
 *  com.integralads.avid.library.adcolony.session.internal.InternalAvidManagedVideoAdSession
 *  com.integralads.avid.library.adcolony.session.internal.InternalAvidVideoAdSession
 *  java.lang.Object
 *  java.lang.String
 */
package com.integralads.avid.library.adcolony.session;

import android.content.Context;
import com.integralads.avid.library.adcolony.AvidManager;
import com.integralads.avid.library.adcolony.session.AbstractAvidAdSession;
import com.integralads.avid.library.adcolony.session.AvidDisplayAdSession;
import com.integralads.avid.library.adcolony.session.AvidManagedVideoAdSession;
import com.integralads.avid.library.adcolony.session.AvidVideoAdSession;
import com.integralads.avid.library.adcolony.session.ExternalAvidAdSessionContext;
import com.integralads.avid.library.adcolony.session.internal.InternalAvidAdSession;
import com.integralads.avid.library.adcolony.session.internal.InternalAvidDisplayAdSession;
import com.integralads.avid.library.adcolony.session.internal.InternalAvidManagedVideoAdSession;
import com.integralads.avid.library.adcolony.session.internal.InternalAvidVideoAdSession;

public class AvidAdSessionManager {
    public static AvidDisplayAdSession startAvidDisplayAdSession(Context context, ExternalAvidAdSessionContext externalAvidAdSessionContext) {
        AvidManager.getInstance().init(context);
        AvidDisplayAdSession avidDisplayAdSession = new AvidDisplayAdSession();
        InternalAvidDisplayAdSession internalAvidDisplayAdSession = new InternalAvidDisplayAdSession(context, avidDisplayAdSession.getAvidAdSessionId(), externalAvidAdSessionContext);
        internalAvidDisplayAdSession.onStart();
        AvidManager.getInstance().registerAvidAdSession((AbstractAvidAdSession)avidDisplayAdSession, (InternalAvidAdSession)internalAvidDisplayAdSession);
        return avidDisplayAdSession;
    }

    public static AvidManagedVideoAdSession startAvidManagedVideoAdSession(Context context, ExternalAvidAdSessionContext externalAvidAdSessionContext) {
        AvidManager.getInstance().init(context);
        AvidManagedVideoAdSession avidManagedVideoAdSession = new AvidManagedVideoAdSession();
        InternalAvidManagedVideoAdSession internalAvidManagedVideoAdSession = new InternalAvidManagedVideoAdSession(context, avidManagedVideoAdSession.getAvidAdSessionId(), externalAvidAdSessionContext);
        internalAvidManagedVideoAdSession.onStart();
        AvidManager.getInstance().registerAvidAdSession((AbstractAvidAdSession)avidManagedVideoAdSession, (InternalAvidAdSession)internalAvidManagedVideoAdSession);
        return avidManagedVideoAdSession;
    }

    public static AvidVideoAdSession startAvidVideoAdSession(Context context, ExternalAvidAdSessionContext externalAvidAdSessionContext) {
        AvidManager.getInstance().init(context);
        AvidVideoAdSession avidVideoAdSession = new AvidVideoAdSession();
        InternalAvidVideoAdSession internalAvidVideoAdSession = new InternalAvidVideoAdSession(context, avidVideoAdSession.getAvidAdSessionId(), externalAvidAdSessionContext);
        internalAvidVideoAdSession.onStart();
        AvidManager.getInstance().registerAvidAdSession((AbstractAvidAdSession)avidVideoAdSession, (InternalAvidAdSession)internalAvidVideoAdSession);
        return avidVideoAdSession;
    }
}


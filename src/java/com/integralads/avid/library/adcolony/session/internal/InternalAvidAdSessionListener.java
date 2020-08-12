/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.integralads.avid.library.adcolony.session.internal.InternalAvidAdSession
 *  java.lang.Object
 */
package com.integralads.avid.library.adcolony.session.internal;

import com.integralads.avid.library.adcolony.session.internal.InternalAvidAdSession;

public interface InternalAvidAdSessionListener {
    public void sessionDidEnd(InternalAvidAdSession var1);

    public void sessionHasBecomeActive(InternalAvidAdSession var1);

    public void sessionHasResignedActive(InternalAvidAdSession var1);
}


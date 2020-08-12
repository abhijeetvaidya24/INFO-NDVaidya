/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.integralads.avid.library.mopub.registration.AvidAdSessionRegistry
 *  java.lang.Object
 */
package com.integralads.avid.library.mopub.registration;

import com.integralads.avid.library.mopub.registration.AvidAdSessionRegistry;

public interface AvidAdSessionRegistryListener {
    public void registryHasActiveSessionsChanged(AvidAdSessionRegistry var1);

    public void registryHasSessionsChanged(AvidAdSessionRegistry var1);
}


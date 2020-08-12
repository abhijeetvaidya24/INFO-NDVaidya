/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.ogury.consent.manager;

import com.ogury.consent.manager.ConsentManager;
import com.ogury.consent.manager.util.consent.ConsentException;

public interface ConsentListener {
    public void onComplete(ConsentManager.Answer var1);

    public void onError(ConsentException var1);
}


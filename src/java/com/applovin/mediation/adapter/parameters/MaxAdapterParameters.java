/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  java.lang.Object
 */
package com.applovin.mediation.adapter.parameters;

import android.os.Bundle;

public interface MaxAdapterParameters {
    public Bundle getServerParameters();

    public boolean hasUserConsent();

    public boolean isAgeRestrictedUser();

    public boolean isTesting();
}


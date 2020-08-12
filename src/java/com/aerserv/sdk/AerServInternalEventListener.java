/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.List
 */
package com.aerserv.sdk;

import com.aerserv.sdk.AerServEvent;
import com.aerserv.sdk.AerServEventListener;
import java.util.List;

public interface AerServInternalEventListener
extends AerServEventListener {
    public void onAerServInternalEvent(AerServEvent var1, List<Object> var2);
}


/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.String
 *  java.lang.Throwable
 */
package com.tapjoy.internal;

import java.io.IOException;

public final class ca
extends IOException {
    public ca(Throwable throwable) {
        super(throwable.getMessage());
    }
}


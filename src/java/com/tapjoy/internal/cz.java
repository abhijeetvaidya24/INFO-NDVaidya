/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.UnsupportedOperationException
 *  java.util.Iterator
 */
package com.tapjoy.internal;

import java.util.Iterator;

public abstract class cz
implements Iterator {
    protected cz() {
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}


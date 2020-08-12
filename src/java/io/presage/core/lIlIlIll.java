/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Object
 */
package io.presage.core;

import android.content.Context;

public abstract class lIlIlIll {
    protected Context IIIIIIIl;
    protected boolean IIIIIIlI;
    protected Object[] IIIIIIll;

    public lIlIlIll(Context context, boolean bl2, Object[] arrobject) {
        this.IIIIIIIl = context;
        this.IIIIIIlI = bl2;
        this.IIIIIIll = arrobject;
    }

    public abstract int IIIIIIII();

    public abstract void IIIIIIIl();

    public abstract void IIIIIIlI();

    public final boolean IIIIIlII() {
        return this.IIIIIIlI;
    }
}


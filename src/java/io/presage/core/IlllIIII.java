/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  io.presage.core.IIlIIllI
 *  java.lang.Exception
 *  java.lang.Object
 */
package io.presage.core;

import android.content.Context;
import io.presage.core.IIlIIllI;
import io.presage.core.IllIllIl;

public abstract class IlllIIII {
    IllIllIl IIIIIIII;
    protected Context IIIIIIIl;
    boolean IIIIIIlI;

    public IlllIIII(Context context) {
        this.IIIIIIIl = context;
        this.IIIIIIlI = false;
    }

    protected abstract void IIIIIIII(IIlIIllI var1);

    public void IIIIIIII(IIlIIllI iIlIIllI, IllIllIl illIllIl) {
        if (!this.IIIIIIlI) {
            this.IIIIIIlI = true;
            this.IIIIIIII = illIllIl;
            this.IIIIIIII(iIlIIllI);
        }
    }

    protected final void IIIIIIII(Exception exception, int n2) {
        this.IIIIIIlI = false;
        IllIllIl illIllIl = this.IIIIIIII;
        if (illIllIl != null) {
            illIllIl.IIIIIIII(exception, n2);
        }
    }
}


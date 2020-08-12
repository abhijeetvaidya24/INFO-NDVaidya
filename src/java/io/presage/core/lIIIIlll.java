/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package io.presage.core;

import io.presage.core.lIIIIlIl;
import io.presage.core.lIIIIllI;
import io.presage.core.lIIlIllI;
import io.presage.core.lIIlIlll;

public final class lIIIIlll {
    private byte[] IIIIIIII;
    private byte[] IIIIIIIl;

    public lIIIIlll(String string, String string2) {
        this.IIIIIIII = string.getBytes();
        this.IIIIIIIl = string2.getBytes();
    }

    public final byte[] IIIIIIII() {
        int n2 = new lIIlIlll().IIIIIIII(2).IIIIIIlI(this.IIIIIIII).length;
        try {
            byte[] arrby = lIIIIllI.IIIIIIII(new String(new lIIlIlll().IIIIIIII(2).IIIIIIII(1).IIIIIIII(String.valueOf((int)n2).getBytes()).IIIIIIlI(this.IIIIIIII)), "SHA-1").getBytes();
            return arrby;
        }
        catch (lIIIIlIl lIIIIlIl2) {
            throw new lIIlIllI((Throwable)((Object)lIIIIlIl2));
        }
    }

    public final byte[] IIIIIIIl() {
        return new lIIlIlll().IIIIIIII(2).IIIIIIlI(this.IIIIIIIl);
    }
}


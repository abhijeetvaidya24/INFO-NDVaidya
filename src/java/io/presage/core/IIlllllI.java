/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  io.presage.core.IIIllllI
 *  io.presage.core.IIlIIIII
 *  io.presage.core.IIllllll
 *  java.io.File
 *  java.lang.Character
 *  java.lang.Object
 *  java.lang.String
 *  java.net.InetAddress
 *  java.net.UnknownHostException
 */
package io.presage.core;

import android.content.Context;
import io.presage.core.IIIllllI;
import io.presage.core.IIlIIIII;
import io.presage.core.IIllllll;
import io.presage.core.lIIIlIlI;
import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class IIlllllI
extends IIllllll {
    private static final String IIIIIlll = lIIIlIlI.IIllIIII.IIIIIIII;

    public IIlllllI(Context context, int n2, long l2, long l3) {
        super(context, n2, l2, l3);
    }

    protected final IIlIIIII IIIIIIII(long l2, int n2, String string, String string2, int n3, long l3, long l4) {
        IIIllllI iIIllllI = new IIIllllI(l2, n2, string, string2, n3, l3, l4);
        return iIIllllI;
    }

    protected final String IIIIIIIl(String string) {
        if (string != null && !string.isEmpty()) {
            int n2 = string.length();
            byte[] arrby = new byte[n2 / 2];
            for (int i2 = 0; i2 < n2; i2 += 2) {
                arrby[i2 / 2] = (byte)((Character.digit((char)string.charAt(i2), (int)16) << 4) + Character.digit((char)string.charAt(i2 + 1), (int)16));
            }
            try {
                string = InetAddress.getByAddress((byte[])arrby).getHostAddress();
            }
            catch (UnknownHostException unknownHostException) {}
            return string;
        }
        return null;
    }

    public final int IIIIIIlI() {
        return 11;
    }

    protected final Object IIIIIIll() {
        return IIlllllI.class;
    }

    protected final File IIIIlIlI() {
        return new File(IIIIIlll);
    }
}


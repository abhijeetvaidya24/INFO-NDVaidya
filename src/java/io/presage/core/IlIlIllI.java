/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  io.presage.core.lIIIIllI
 *  io.presage.core.lIIIlIlI
 *  io.presage.core.lIIIlIlI$IIIllIll
 *  io.presage.core.lIIlIlll
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 */
package io.presage.core;

import android.content.Context;
import io.presage.core.IlIlllll;
import io.presage.core.lIIIIllI;
import io.presage.core.lIIIlIlI;
import io.presage.core.lIIlIlll;

public final class IlIlIllI {
    private static final String IIIIIIII = lIIIlIlI.IIIllIll.IIIIIIII;
    private static final String IIIIIIIl = lIIIlIlI.IIIllIll.IIIIIIIl;
    private static final String IIIIIIlI = lIIIlIlI.IIIIIIll;
    private Context IIIIIIll;

    public IlIlIllI(Context context) {
        this.IIIIIIll = context;
    }

    public static String IIIIIIII(String string2) {
        if ("prod".equals((Object)IIIIIIlI)) {
            return string2;
        }
        try {
            String string3 = new String(new lIIlIlll().IIIIIIII(0).IIIIIIII(lIIIIllI.IIIIIIII((String)IIIIIIII).getBytes()).IIIIIIII(2).IIIIIIII(1).IIIIIIII(IIIIIIIl.getBytes()).IIIIIIIl(string2.getBytes()));
            return string3;
        }
        catch (Exception exception) {
            IlIlllll.IIIIIIII(exception, 1);
            return null;
        }
    }
}


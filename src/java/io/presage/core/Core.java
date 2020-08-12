/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.Log
 *  io.presage.core.IIIIIIII$3
 *  io.presage.core.IIlIIllI
 *  io.presage.core.lIIlllII
 *  io.presage.core.lIIlllII$IIIIIIII
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.Void
 */
package io.presage.core;

import android.content.Context;
import android.util.Log;
import io.presage.core.IIIIIIII;
import io.presage.core.IIIIIIIl;
import io.presage.core.IIlIIIll;
import io.presage.core.IIlIIllI;
import io.presage.core.IIlIIlll;
import io.presage.core.IlIlllll;
import io.presage.core.lIIlllII;

public class Core {
    public static String getVersion() {
        return "4.0.11";
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void initialize(Context context, String string2) {
        try {
            String string3;
            boolean bl2;
            IIIIIIII iIIIIIII = IIIIIIII.IIIIIIII(context);
            if (string2 != null && !(bl2 = string2.isEmpty())) {
                try {
                    IIlIIllI iIlIIllI = IIlIIlll.IIIIIIII().IIIIIIIl();
                    new lIIlllII(iIIIIIII.IIIIIIII, (lIIlllII.IIIIIIII)new IIIIIIII.3(iIIIIIII, string2)).IIIIIIII(iIlIIllI, false, (Object[])new Void[0]);
                    return;
                }
                catch (IIlIIIll iIlIIIll) {
                    IlIlllll.IIIIIIII(iIlIIIll, 0);
                    return;
                }
            }
            StringBuilder stringBuilder = new StringBuilder("Unexpected API key: ");
            if (string2 == null) {
                string3 = null;
            } else {
                StringBuilder stringBuilder2 = new StringBuilder("\"");
                stringBuilder2.append(string2);
                stringBuilder2.append("\"");
                string3 = stringBuilder2.toString();
            }
            stringBuilder.append(string3);
            Log.e((String)"Presage.Core", (String)stringBuilder.toString());
            return;
        }
        catch (IIIIIIIl iIIIIIIl) {
            Log.e((String)"Presage.Core", (String)"An error occurred while initializing", (Throwable)((Object)iIIIIIIl));
            return;
        }
    }
}


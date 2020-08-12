/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 */
package com.adincube.sdk.util.b;

import android.content.Context;

public final class f {
    public static boolean a(Context context, String string) {
        RuntimeException runtimeException2;
        block2 : {
            int n2;
            try {
                n2 = context.checkCallingOrSelfPermission(string);
            }
            catch (RuntimeException runtimeException2) {
                if (runtimeException2.getMessage() == null || !runtimeException2.getMessage().startsWith("Unknown exception code: 1")) break block2;
                n2 = -1;
            }
            return n2 == 0;
        }
        throw runtimeException2;
    }
}


/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Object
 *  java.lang.String
 */
package io.presage;

import android.content.Context;

public final class Mascare {
    public static final boolean a(Context context, String string2) {
        return context.checkCallingOrSelfPermission(string2) == 0;
    }
}


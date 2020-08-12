/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Process
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 */
package io.presage.core;

import android.content.Context;
import android.os.Process;

public final class lIIIlIIl {
    public static boolean IIIIIIII(Context context, String string) {
        if (string != null && !string.isEmpty()) {
            return context.checkPermission(string, Process.myPid(), Process.myUid()) == 0;
        }
        new IllegalArgumentException();
        return false;
    }
}


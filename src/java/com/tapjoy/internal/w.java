/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.io.File
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 */
package com.tapjoy.internal;

import android.content.Context;
import java.io.File;

public final class w {
    private static String a = "Android";
    private static String b = "data";

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static File a(Context context) {
        File file;
        try {
            file = context.getExternalFilesDir(null);
        }
        catch (RuntimeException runtimeException) {
            return null;
        }
        for (int n2 = 0; file != null && n2 < 2; file = file.getParentFile(), ++n2) {
        }
        return file;
    }
}


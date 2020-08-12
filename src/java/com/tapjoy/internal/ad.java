/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.OutOfMemoryError
 *  java.lang.System
 */
package com.tapjoy.internal;

import com.tapjoy.internal.bg;

public final class ad {
    public static Object a(bg bg2) {
        int n2 = 1;
        do {
            try {
                Object object = bg2.call();
                return object;
            }
            catch (OutOfMemoryError outOfMemoryError) {
                if (n2 < 10) {
                    System.gc();
                    ++n2;
                    continue;
                }
                throw outOfMemoryError;
            }
            break;
        } while (true);
    }
}


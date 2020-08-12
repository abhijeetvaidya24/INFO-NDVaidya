/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Closeable
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.logging.Level
 *  java.util.logging.Logger
 */
package com.tapjoy.internal;

import java.io.Closeable;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class dc {
    static final Logger a = Logger.getLogger((String)dc.class.getName());

    private dc() {
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
                return;
            }
            catch (IOException iOException) {
                try {
                    a.log(Level.WARNING, "IOException thrown while closing Closeable.", (Throwable)iOException);
                    return;
                }
                catch (IOException iOException2) {
                    a.log(Level.SEVERE, "IOException should not have been thrown.", (Throwable)iOException2);
                }
            }
        }
    }
}


/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.tapjoy.internal.hv
 *  com.tapjoy.internal.hw
 *  com.tapjoy.internal.hy$1
 *  com.tapjoy.internal.hy$2
 *  com.tapjoy.internal.hz
 *  com.tapjoy.internal.ia
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.AssertionError
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.logging.Logger
 */
package com.tapjoy.internal;

import com.tapjoy.internal.hv;
import com.tapjoy.internal.hw;
import com.tapjoy.internal.hy;
import com.tapjoy.internal.hz;
import com.tapjoy.internal.ia;
import com.tapjoy.internal.ie;
import com.tapjoy.internal.if;
import com.tapjoy.internal.ig;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Logger;

public final class hy {
    static final Logger a = Logger.getLogger((String)hy.class.getName());

    private hy() {
    }

    public static hv a(ie ie2) {
        if (ie2 != null) {
            return new hz(ie2);
        }
        throw new IllegalArgumentException("sink == null");
    }

    public static hw a(if if_) {
        if (if_ != null) {
            return new ia(if_);
        }
        throw new IllegalArgumentException("source == null");
    }

    public static ie a(OutputStream outputStream) {
        ig ig2 = new ig();
        if (outputStream != null) {
            return new 1(ig2, outputStream);
        }
        throw new IllegalArgumentException("out == null");
    }

    public static if a(InputStream inputStream) {
        ig ig2 = new ig();
        if (inputStream != null) {
            return new 2(ig2, inputStream);
        }
        throw new IllegalArgumentException("in == null");
    }

    static boolean a(AssertionError assertionError) {
        return assertionError.getCause() != null && assertionError.getMessage() != null && assertionError.getMessage().contains((CharSequence)"getsockname failed");
    }
}


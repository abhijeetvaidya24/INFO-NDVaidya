/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 */
package com.tapjoy.internal;

import com.tapjoy.TJEarnedCurrencyListener;
import com.tapjoy.internal.ew;

public class TJEarnedCurrencyListenerNative
implements TJEarnedCurrencyListener {
    private final long a;

    private TJEarnedCurrencyListenerNative(long l2) {
        if (l2 != 0L) {
            this.a = l2;
            return;
        }
        throw new IllegalArgumentException();
    }

    @ew
    static Object create(long l2) {
        return new TJEarnedCurrencyListenerNative(l2);
    }

    private static native void onEarnedCurrencyNative(long var0, String var2, int var3);

    @Override
    public void onEarnedCurrency(String string, int n2) {
        TJEarnedCurrencyListenerNative.onEarnedCurrencyNative(this.a, string, n2);
    }
}


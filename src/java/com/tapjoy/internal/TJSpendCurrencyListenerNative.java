/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 */
package com.tapjoy.internal;

import com.tapjoy.TJSpendCurrencyListener;
import com.tapjoy.internal.ew;

public class TJSpendCurrencyListenerNative
implements TJSpendCurrencyListener {
    private final long a;

    private TJSpendCurrencyListenerNative(long l2) {
        if (l2 != 0L) {
            this.a = l2;
            return;
        }
        throw new IllegalArgumentException();
    }

    @ew
    static Object create(long l2) {
        return new TJSpendCurrencyListenerNative(l2);
    }

    private static native void onSpendCurrencyResponseFailureNative(long var0, String var2);

    private static native void onSpendCurrencyResponseNative(long var0, String var2, int var3);

    @Override
    public void onSpendCurrencyResponse(String string, int n2) {
        TJSpendCurrencyListenerNative.onSpendCurrencyResponseNative(this.a, string, n2);
    }

    @Override
    public void onSpendCurrencyResponseFailure(String string) {
        TJSpendCurrencyListenerNative.onSpendCurrencyResponseFailureNative(this.a, string);
    }
}


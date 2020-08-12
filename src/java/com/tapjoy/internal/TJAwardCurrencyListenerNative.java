/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 */
package com.tapjoy.internal;

import com.tapjoy.TJAwardCurrencyListener;
import com.tapjoy.internal.ew;

public class TJAwardCurrencyListenerNative
implements TJAwardCurrencyListener {
    private final long a;

    private TJAwardCurrencyListenerNative(long l2) {
        if (l2 != 0L) {
            this.a = l2;
            return;
        }
        throw new IllegalArgumentException();
    }

    @ew
    static Object create(long l2) {
        return new TJAwardCurrencyListenerNative(l2);
    }

    private static native void onAwardCurrencyResponseFailureNative(long var0, String var2);

    private static native void onAwardCurrencyResponseNative(long var0, String var2, int var3);

    @Override
    public void onAwardCurrencyResponse(String string, int n2) {
        TJAwardCurrencyListenerNative.onAwardCurrencyResponseNative(this.a, string, n2);
    }

    @Override
    public void onAwardCurrencyResponseFailure(String string) {
        TJAwardCurrencyListenerNative.onAwardCurrencyResponseFailureNative(this.a, string);
    }
}


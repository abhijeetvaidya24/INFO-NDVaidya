/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 */
package com.tapjoy.internal;

import com.tapjoy.TJGetCurrencyBalanceListener;
import com.tapjoy.internal.ew;

public class TJGetCurrencyBalanceListenerNative
implements TJGetCurrencyBalanceListener {
    private final long a;

    private TJGetCurrencyBalanceListenerNative(long l2) {
        if (l2 != 0L) {
            this.a = l2;
            return;
        }
        throw new IllegalArgumentException();
    }

    @ew
    static Object create(long l2) {
        return new TJGetCurrencyBalanceListenerNative(l2);
    }

    private static native void onGetCurrencyBalanceResponseFailureNative(long var0, String var2);

    private static native void onGetCurrencyBalanceResponseNative(long var0, String var2, int var3);

    @Override
    public void onGetCurrencyBalanceResponse(String string, int n2) {
        TJGetCurrencyBalanceListenerNative.onGetCurrencyBalanceResponseNative(this.a, string, n2);
    }

    @Override
    public void onGetCurrencyBalanceResponseFailure(String string) {
        TJGetCurrencyBalanceListenerNative.onGetCurrencyBalanceResponseFailureNative(this.a, string);
    }
}


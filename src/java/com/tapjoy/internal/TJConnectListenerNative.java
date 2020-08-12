/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 */
package com.tapjoy.internal;

import com.tapjoy.TJConnectListener;
import com.tapjoy.internal.ew;

public class TJConnectListenerNative
implements TJConnectListener {
    private final long a;

    private TJConnectListenerNative(long l2) {
        if (l2 != 0L) {
            this.a = l2;
            return;
        }
        throw new IllegalArgumentException();
    }

    @ew
    static Object create(long l2) {
        return new TJConnectListenerNative(l2);
    }

    private static native void onConnectFailureNative(long var0);

    private static native void onConnectSuccessNative(long var0);

    @Override
    public void onConnectFailure() {
        TJConnectListenerNative.onConnectFailureNative(this.a);
    }

    @Override
    public void onConnectSuccess() {
        TJConnectListenerNative.onConnectSuccessNative(this.a);
    }
}


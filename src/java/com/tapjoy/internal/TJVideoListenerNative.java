/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 */
package com.tapjoy.internal;

import com.tapjoy.TJVideoListener;
import com.tapjoy.internal.ew;

public class TJVideoListenerNative
implements TJVideoListener {
    private final long a;

    private TJVideoListenerNative(long l2) {
        if (l2 != 0L) {
            this.a = l2;
            return;
        }
        throw new IllegalArgumentException();
    }

    @ew
    static Object create(long l2) {
        return new TJVideoListenerNative(l2);
    }

    private static native void onVideoCompleteNative(long var0);

    private static native void onVideoErrorNative(long var0, int var2);

    private static native void onVideoStartNative(long var0);

    @Override
    public void onVideoComplete() {
        TJVideoListenerNative.onVideoCompleteNative(this.a);
    }

    @Override
    public void onVideoError(int n2) {
        TJVideoListenerNative.onVideoErrorNative(this.a, n2);
    }

    @Override
    public void onVideoStart() {
        TJVideoListenerNative.onVideoStartNative(this.a);
    }
}


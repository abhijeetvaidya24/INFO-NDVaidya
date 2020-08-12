/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 */
package com.tapjoy.internal;

import com.tapjoy.TJActionRequest;
import com.tapjoy.TJError;
import com.tapjoy.TJPlacement;
import com.tapjoy.TJPlacementListener;
import com.tapjoy.internal.ew;

public class TJPlacementListenerNative
implements TJPlacementListener {
    private final long a;

    private TJPlacementListenerNative(long l2) {
        if (l2 != 0L) {
            this.a = l2;
            return;
        }
        throw new IllegalArgumentException();
    }

    @ew
    static Object create(long l2) {
        return new TJPlacementListenerNative(l2);
    }

    private static native void onContentDismissNative(long var0, TJPlacement var2, String var3);

    private static native void onContentReadyNative(long var0, TJPlacement var2, String var3);

    private static native void onContentShowNative(long var0, TJPlacement var2, String var3);

    private static native void onPurchaseRequestNative(long var0, TJPlacement var2, String var3, TJActionRequest var4, String var5, String var6, String var7);

    private static native void onRequestFailureNative(long var0, TJPlacement var2, String var3, int var4, String var5);

    private static native void onRequestSuccessNative(long var0, TJPlacement var2, String var3);

    private static native void onRewardRequestNative(long var0, TJPlacement var2, String var3, TJActionRequest var4, String var5, String var6, String var7, int var8);

    @Override
    public void onContentDismiss(TJPlacement tJPlacement) {
        TJPlacementListenerNative.onContentDismissNative(this.a, tJPlacement, tJPlacement.getName());
    }

    @Override
    public void onContentReady(TJPlacement tJPlacement) {
        TJPlacementListenerNative.onContentReadyNative(this.a, tJPlacement, tJPlacement.getName());
    }

    @Override
    public void onContentShow(TJPlacement tJPlacement) {
        TJPlacementListenerNative.onContentShowNative(this.a, tJPlacement, tJPlacement.getName());
    }

    @Override
    public void onPurchaseRequest(TJPlacement tJPlacement, TJActionRequest tJActionRequest, String string) {
        TJPlacementListenerNative.onPurchaseRequestNative(this.a, tJPlacement, tJPlacement.getName(), tJActionRequest, tJActionRequest.getRequestId(), tJActionRequest.getToken(), string);
    }

    @Override
    public void onRequestFailure(TJPlacement tJPlacement, TJError tJError) {
        TJPlacementListenerNative.onRequestFailureNative(this.a, tJPlacement, tJPlacement.getName(), tJError.code, tJError.message);
    }

    @Override
    public void onRequestSuccess(TJPlacement tJPlacement) {
        TJPlacementListenerNative.onRequestSuccessNative(this.a, tJPlacement, tJPlacement.getName());
    }

    @Override
    public void onRewardRequest(TJPlacement tJPlacement, TJActionRequest tJActionRequest, String string, int n2) {
        TJPlacementListenerNative.onRewardRequestNative(this.a, tJPlacement, tJPlacement.getName(), tJActionRequest, tJActionRequest.getRequestId(), tJActionRequest.getToken(), string, n2);
    }
}


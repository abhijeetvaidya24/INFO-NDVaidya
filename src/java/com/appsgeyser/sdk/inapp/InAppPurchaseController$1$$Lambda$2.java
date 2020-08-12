/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.appsgeyser.sdk.inapp.InAppPurchaseController
 *  com.appsgeyser.sdk.inapp.InAppPurchaseController$1
 *  java.lang.Object
 *  java.lang.Runnable
 */
package com.appsgeyser.sdk.inapp;

import com.appsgeyser.sdk.inapp.InAppPurchaseController;

final class InAppPurchaseController$1$$Lambda$2
implements Runnable {
    private final InAppPurchaseController.1 arg$1;

    private InAppPurchaseController$1$$Lambda$2(InAppPurchaseController.1 var1_1) {
        this.arg$1 = var1_1;
    }

    public static Runnable lambdaFactory$(InAppPurchaseController.1 var0) {
        return new InAppPurchaseController$1$$Lambda$2(var0);
    }

    public void run() {
        InAppPurchaseController.1.lambda$onBillingServiceDisconnected$1((InAppPurchaseController.1)this.arg$1);
    }
}


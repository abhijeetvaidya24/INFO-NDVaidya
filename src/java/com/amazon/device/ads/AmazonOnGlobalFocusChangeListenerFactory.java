/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnGlobalFocusChangeListener
 *  java.lang.Object
 */
package com.amazon.device.ads;

import android.view.View;
import android.view.ViewTreeObserver;
import com.amazon.device.ads.ViewabilityObserver;

class AmazonOnGlobalFocusChangeListenerFactory {
    AmazonOnGlobalFocusChangeListenerFactory() {
    }

    public ViewTreeObserver.OnGlobalFocusChangeListener buildAmazonOnGlobalFocusChangedListener(ViewabilityObserver viewabilityObserver) {
        return new AmazonOnGlobalFocusChangeListener(viewabilityObserver);
    }

    private class AmazonOnGlobalFocusChangeListener
    implements ViewTreeObserver.OnGlobalFocusChangeListener {
        private final ViewabilityObserver viewabilityObserver;

        public AmazonOnGlobalFocusChangeListener(ViewabilityObserver viewabilityObserver) {
            this.viewabilityObserver = viewabilityObserver;
        }

        public void onGlobalFocusChanged(View view, View view2) {
            this.viewabilityObserver.fireViewableEvent(false);
        }
    }

}


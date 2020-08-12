/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnScrollChangedListener
 *  java.lang.Object
 */
package com.amazon.device.ads;

import android.view.ViewTreeObserver;
import com.amazon.device.ads.ViewabilityObserver;

class AmazonOnScrollChangedListenerFactory {
    AmazonOnScrollChangedListenerFactory() {
    }

    public ViewTreeObserver.OnScrollChangedListener buildAmazonOnScrollChangedListenerFactory(ViewabilityObserver viewabilityObserver) {
        return new AmazonOnScrollChangedListener(viewabilityObserver);
    }

    private class AmazonOnScrollChangedListener
    implements ViewTreeObserver.OnScrollChangedListener {
        private final ViewabilityObserver viewabilityObserver;

        public AmazonOnScrollChangedListener(ViewabilityObserver viewabilityObserver) {
            this.viewabilityObserver = viewabilityObserver;
        }

        public void onScrollChanged() {
            this.viewabilityObserver.fireViewableEvent(true);
        }
    }

}


/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnWindowFocusChangeListener
 *  java.lang.Object
 */
package com.amazon.device.ads;

import android.view.ViewTreeObserver;
import com.amazon.device.ads.ViewabilityObserver;

class AmazonOnWindowFocusChangeListenerFactory {
    AmazonOnWindowFocusChangeListenerFactory() {
    }

    public ViewTreeObserver.OnWindowFocusChangeListener buildOnWindowFocusChangeListener(ViewabilityObserver viewabilityObserver) {
        return new AmazonOnWindowFocusChangeListener(viewabilityObserver);
    }

    private class AmazonOnWindowFocusChangeListener
    implements ViewTreeObserver.OnWindowFocusChangeListener {
        private final ViewabilityObserver viewabilityObserver;

        AmazonOnWindowFocusChangeListener(ViewabilityObserver viewabilityObserver) {
            this.viewabilityObserver = viewabilityObserver;
        }

        public void onWindowFocusChanged(boolean bl) {
            this.viewabilityObserver.fireViewableEvent(false);
        }
    }

}


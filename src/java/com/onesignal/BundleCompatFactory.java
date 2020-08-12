/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  com.onesignal.BundleCompatBundle
 *  com.onesignal.BundleCompatPersistableBundle
 *  java.lang.Object
 */
package com.onesignal;

import android.os.Build;
import com.onesignal.BundleCompat;
import com.onesignal.BundleCompatBundle;
import com.onesignal.BundleCompatPersistableBundle;

class BundleCompatFactory {
    static BundleCompat getInstance() {
        if (Build.VERSION.SDK_INT >= 26) {
            return new BundleCompatPersistableBundle();
        }
        return new BundleCompatBundle();
    }
}


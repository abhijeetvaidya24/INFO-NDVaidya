/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 */
package com.onesignal;

import android.os.Bundle;
import com.onesignal.BundleCompat;

class BundleCompatBundle
implements BundleCompat<Bundle> {
    private Bundle mBundle;

    BundleCompatBundle() {
        this.mBundle = new Bundle();
    }

    BundleCompatBundle(Bundle bundle) {
        this.mBundle = bundle;
    }

    @Override
    public boolean containsKey(String string) {
        return this.mBundle.containsKey(string);
    }

    @Override
    public boolean getBoolean(String string, boolean bl2) {
        return this.mBundle.getBoolean(string, bl2);
    }

    @Override
    public Bundle getBundle() {
        return this.mBundle;
    }

    @Override
    public Integer getInt(String string) {
        return this.mBundle.getInt(string);
    }

    @Override
    public Long getLong(String string) {
        return this.mBundle.getLong(string);
    }

    @Override
    public String getString(String string) {
        return this.mBundle.getString(string);
    }

    @Override
    public void putLong(String string, Long l2) {
        this.mBundle.putLong(string, l2.longValue());
    }

    @Override
    public void putString(String string, String string2) {
        this.mBundle.putString(string, string2);
    }
}


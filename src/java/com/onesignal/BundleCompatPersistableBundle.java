/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.PersistableBundle
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 */
package com.onesignal;

import android.os.PersistableBundle;
import com.onesignal.BundleCompat;

class BundleCompatPersistableBundle
implements BundleCompat<PersistableBundle> {
    private PersistableBundle mBundle;

    BundleCompatPersistableBundle() {
        this.mBundle = new PersistableBundle();
    }

    BundleCompatPersistableBundle(PersistableBundle persistableBundle) {
        this.mBundle = persistableBundle;
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
    public PersistableBundle getBundle() {
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


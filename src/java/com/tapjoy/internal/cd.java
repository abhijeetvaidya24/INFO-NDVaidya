/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.ref.WeakReference
 */
package com.tapjoy.internal;

import java.lang.ref.WeakReference;

public final class cd {
    public WeakReference a;

    public final Object a() {
        WeakReference weakReference = this.a;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public final void a(Object object) {
        this.a = new WeakReference(object);
    }
}


/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.ref.WeakReference
 */
package com.integralads.avid.library.mopub.weakreference;

import java.lang.ref.WeakReference;

public class ObjectWrapper<T> {
    private WeakReference<T> weakReference;

    public ObjectWrapper(T t2) {
        this.weakReference = new WeakReference(t2);
    }

    public boolean contains(Object object) {
        T t2 = this.get();
        return t2 != null && object != null && t2.equals(object);
    }

    public T get() {
        return (T)this.weakReference.get();
    }

    public boolean isEmpty() {
        return this.get() == null;
    }

    public void set(T t2) {
        this.weakReference = new WeakReference(t2);
    }
}


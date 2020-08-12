/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.ref.WeakReference
 */
package com.integralads.avid.library.adcolony.weakreference;

import java.lang.ref.WeakReference;

public class ObjectWrapper<T> {
    private WeakReference<T> a;

    public ObjectWrapper(T t2) {
        this.a = new WeakReference(t2);
    }

    public boolean contains(Object object) {
        T t2 = this.get();
        return t2 != null && object != null && t2.equals(object);
    }

    public T get() {
        return (T)this.a.get();
    }

    public boolean isEmpty() {
        return this.get() == null;
    }

    public void set(T t2) {
        this.a = new WeakReference(t2);
    }
}


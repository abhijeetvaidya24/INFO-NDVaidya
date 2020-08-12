/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.AssertionError
 *  java.lang.CloneNotSupportedException
 *  java.lang.Object
 *  java.util.AbstractSet
 *  java.util.Iterator
 *  java.util.Set
 *  java.util.WeakHashMap
 */
package com.tapjoy.internal;

import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

public final class bd
extends AbstractSet
implements Serializable,
Set {
    transient WeakHashMap a;

    public bd() {
        this(new WeakHashMap());
    }

    private bd(WeakHashMap weakHashMap) {
        this.a = weakHashMap;
    }

    public final boolean add(Object object) {
        return this.a.put(object, (Object)this) == null;
    }

    public final void clear() {
        this.a.clear();
    }

    public final Object clone() {
        try {
            bd bd2 = (bd)((Object)Object.super.clone());
            return bd2;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new AssertionError((Object)cloneNotSupportedException);
        }
    }

    public final boolean contains(Object object) {
        return this.a.containsKey(object);
    }

    public final boolean isEmpty() {
        return this.a.isEmpty();
    }

    public final Iterator iterator() {
        return this.a.keySet().iterator();
    }

    public final boolean remove(Object object) {
        return this.a.remove(object) != null;
    }

    public final int size() {
        return this.a.size();
    }
}


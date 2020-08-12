/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.List
 *  java.util.NoSuchElementException
 */
package com.tapjoy.internal;

import com.tapjoy.internal.bb;
import com.tapjoy.internal.bc;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public final class ba
implements bc {
    private final List a;

    public ba(List list) {
        this.a = list;
    }

    @Override
    public final Object a(int n2) {
        return this.a.get(n2);
    }

    public final boolean add(Object object) {
        return this.a.add(object);
    }

    public final boolean addAll(Collection collection) {
        return this.a.addAll(collection);
    }

    @Override
    public final void b(int n2) {
        bb.a(this.a, n2);
    }

    public final void clear() {
        this.a.clear();
    }

    public final boolean contains(Object object) {
        return this.a.contains(object);
    }

    public final boolean containsAll(Collection collection) {
        return this.a.containsAll(collection);
    }

    public final Object element() {
        Object object = this.peek();
        if (object != null) {
            return object;
        }
        throw new NoSuchElementException();
    }

    public final boolean equals(Object object) {
        return this.a.equals(object);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final boolean isEmpty() {
        return this.a.isEmpty();
    }

    public final Iterator iterator() {
        return this.a.iterator();
    }

    public final boolean offer(Object object) {
        return this.a.add(object);
    }

    public final Object peek() {
        if (this.a.isEmpty()) {
            return null;
        }
        return this.a.get(0);
    }

    public final Object poll() {
        if (this.a.isEmpty()) {
            return null;
        }
        return this.a.remove(0);
    }

    public final Object remove() {
        Object object = this.poll();
        if (object != null) {
            return object;
        }
        throw new NoSuchElementException();
    }

    public final boolean remove(Object object) {
        return this.a.remove(object);
    }

    public final boolean removeAll(Collection collection) {
        return this.a.removeAll(collection);
    }

    public final boolean retainAll(Collection collection) {
        return this.a.retainAll(collection);
    }

    public final int size() {
        return this.a.size();
    }

    public final Object[] toArray() {
        return this.a.toArray();
    }

    public final Object[] toArray(Object[] arrobject) {
        return this.a.toArray(arrobject);
    }
}


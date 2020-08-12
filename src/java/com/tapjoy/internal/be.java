/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.UnsupportedOperationException
 *  java.lang.ref.ReferenceQueue
 *  java.util.AbstractMap
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.Set
 */
package com.tapjoy.internal;

import com.tapjoy.internal.cb;
import com.tapjoy.internal.cc;
import java.lang.ref.ReferenceQueue;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public final class be
extends AbstractMap {
    private final HashMap a = new HashMap();
    private final cc b = new cc();

    public static be a() {
        return new be();
    }

    private static Object a(cb cb2) {
        if (cb2 != null) {
            return cb2.get();
        }
        return null;
    }

    private void b() {
        cb cb2;
        while ((cb2 = this.b.a()) != null) {
            this.a.remove(cb2.a);
        }
    }

    public final void clear() {
        this.a.clear();
        while (this.b.a() != null) {
        }
    }

    public final boolean containsKey(Object object) {
        this.b();
        return this.a.containsKey(object);
    }

    public final boolean containsValue(Object object) {
        this.b();
        Iterator iterator = this.a.values().iterator();
        while (iterator.hasNext()) {
            if (!object.equals(((cb)((Object)iterator.next())).get())) continue;
            return true;
        }
        return false;
    }

    public final Set entrySet() {
        this.b();
        throw new UnsupportedOperationException();
    }

    public final boolean equals(Object object) {
        this.b();
        throw new UnsupportedOperationException();
    }

    public final Object get(Object object) {
        this.b();
        return be.a((cb)((Object)this.a.get(object)));
    }

    public final int hashCode() {
        this.b();
        throw new UnsupportedOperationException();
    }

    public final Set keySet() {
        this.b();
        return this.a.keySet();
    }

    public final Object put(Object object, Object object2) {
        this.b();
        return be.a((cb)((Object)this.a.put(object, (Object)new cb(object, object2, this.b))));
    }

    public final Object remove(Object object) {
        this.b();
        return be.a((cb)((Object)this.a.remove(object)));
    }

    public final int size() {
        this.b();
        return this.a.size();
    }

    public final String toString() {
        this.b();
        throw new UnsupportedOperationException();
    }

    public final Collection values() {
        this.b();
        throw new UnsupportedOperationException();
    }
}


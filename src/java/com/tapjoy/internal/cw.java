/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.tapjoy.internal.cw$1
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.util.Iterator
 *  java.util.NoSuchElementException
 */
package com.tapjoy.internal;

import com.tapjoy.internal.cw;
import com.tapjoy.internal.cz;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class cw {
    static final cz a = new 1();
    private static final Iterator b = new Iterator(){

        public final boolean hasNext() {
            return false;
        }

        public final Object next() {
            throw new NoSuchElementException();
        }

        public final void remove() {
            throw new IllegalStateException();
        }
    };

    public static Object a(Iterator iterator) {
        if (iterator.hasNext()) {
            return iterator.next();
        }
        return null;
    }

}


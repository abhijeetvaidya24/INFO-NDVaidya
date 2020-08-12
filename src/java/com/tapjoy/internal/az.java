/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Closeable
 *  java.io.Flushable
 *  java.lang.IndexOutOfBoundsException
 *  java.lang.Object
 *  java.util.Collection
 *  java.util.LinkedList
 *  java.util.List
 */
package com.tapjoy.internal;

import com.tapjoy.internal.ay;
import com.tapjoy.internal.bb;
import com.tapjoy.internal.bc;
import java.io.Closeable;
import java.io.Flushable;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public final class az
extends ay
implements bc,
Closeable,
Flushable {
    private final bc a;
    private final LinkedList b;
    private final LinkedList c;
    private int d;
    private boolean e;

    private az(bc bc2) {
        this.a = bc2;
        this.b = new LinkedList();
        this.c = new LinkedList();
        this.d = bc2.size();
        boolean bl = this.d == 0;
        this.e = bl;
    }

    public static az a(bc bc2) {
        return new az(bc2);
    }

    @Override
    public final Object a(int n2) {
        IndexOutOfBoundsException indexOutOfBoundsException;
        if (n2 >= 0 && n2 < this.d) {
            int n3 = this.b.size();
            if (n2 < n3) {
                return this.b.get(n2);
            }
            if (this.e) {
                return this.c.get(n2 - n3);
            }
            if (n2 < this.a.size()) {
                Object object = null;
                while (n3 <= n2) {
                    object = this.a.a(n3);
                    this.b.add(object);
                    ++n3;
                }
                if (n2 + 1 + this.c.size() == this.d) {
                    this.e = true;
                }
                return object;
            }
            return this.c.get(n2 - this.a.size());
        }
        indexOutOfBoundsException = new IndexOutOfBoundsException();
        throw indexOutOfBoundsException;
    }

    @Override
    public final void b(int n2) {
        if (n2 > 0 && n2 <= this.d) {
            if (n2 <= this.b.size()) {
                bb.a((List)this.b, n2);
                this.a.b(n2);
            } else {
                this.b.clear();
                int n3 = n2 + this.c.size() - this.d;
                if (n3 < 0) {
                    this.a.b(n2);
                } else {
                    this.a.clear();
                    this.e = true;
                    if (n3 > 0) {
                        bb.a((List)this.c, n3);
                    }
                }
            }
            this.d -= n2;
            return;
        }
        throw new IndexOutOfBoundsException();
    }

    public final void close() {
        try {
            this.flush();
            return;
        }
        finally {
            bc bc2 = this.a;
            if (bc2 instanceof Closeable) {
                ((Closeable)bc2).close();
            }
        }
    }

    protected final void finalize() {
        this.close();
        Object.super.finalize();
    }

    public final void flush() {
        if (!this.c.isEmpty()) {
            this.a.addAll((Collection)this.c);
            if (this.e) {
                this.b.addAll((Collection)this.c);
            }
            this.c.clear();
        }
    }

    public final boolean offer(Object object) {
        this.c.add(object);
        this.d = 1 + this.d;
        return true;
    }

    public final Object peek() {
        if (this.d <= 0) {
            return null;
        }
        if (!this.b.isEmpty()) {
            return this.b.element();
        }
        if (this.e) {
            return this.c.element();
        }
        Object object = this.a.peek();
        this.b.add(object);
        if (this.d == this.b.size() + this.c.size()) {
            this.e = true;
        }
        return object;
    }

    public final Object poll() {
        Object object;
        if (this.d <= 0) {
            return null;
        }
        if (!this.b.isEmpty()) {
            object = this.b.remove();
            this.a.b(1);
        } else if (this.e) {
            object = this.c.remove();
        } else {
            object = this.a.remove();
            if (this.d == 1 + this.c.size()) {
                this.e = true;
            }
        }
        --this.d;
        return object;
    }

    public final int size() {
        return this.d;
    }
}


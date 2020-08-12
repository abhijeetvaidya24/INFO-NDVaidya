/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.UnsupportedOperationException
 *  java.lang.Void
 *  java.util.ListIterator
 *  java.util.NoSuchElementException
 *  org.jetbrains.annotations.NotNull
 */
package a.a.a;

import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.jetbrains.annotations.NotNull;

public final class r
implements ListIterator {
    public static final r a = new r();

    private r() {
    }

    @NotNull
    public Void a() {
        throw (Throwable)new NoSuchElementException();
    }

    public /* synthetic */ void add(Object object) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @NotNull
    public Void b() {
        throw (Throwable)new NoSuchElementException();
    }

    public boolean hasNext() {
        return false;
    }

    public boolean hasPrevious() {
        return false;
    }

    public /* synthetic */ Object next() {
        return this.a();
    }

    public int nextIndex() {
        return 0;
    }

    public /* synthetic */ Object previous() {
        return this.b();
    }

    public int previousIndex() {
        return -1;
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* synthetic */ void set(Object object) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}


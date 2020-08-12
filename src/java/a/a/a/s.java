/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.IndexOutOfBoundsException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.UnsupportedOperationException
 *  java.lang.Void
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.List
 *  java.util.ListIterator
 *  java.util.RandomAccess
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package a.a.a;

import a.a.a.r;
import a.a.b.b.d;
import a.a.b.b.h;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class s
implements Serializable,
List,
RandomAccess {
    public static final s a = new s();

    private s() {
    }

    public int a() {
        return 0;
    }

    @NotNull
    public Void a(int n2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Empty list doesn't contain element at index ");
        stringBuilder.append(n2);
        stringBuilder.append('.');
        throw (Throwable)new IndexOutOfBoundsException(stringBuilder.toString());
    }

    public boolean a(@NotNull Void void_) {
        h.b((Object)void_, "element");
        return false;
    }

    public /* synthetic */ void add(int n2, Object object) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* synthetic */ boolean add(Object object) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(int n2, Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public int b(@NotNull Void void_) {
        h.b((Object)void_, "element");
        return -1;
    }

    public int c(@NotNull Void void_) {
        h.b((Object)void_, "element");
        return -1;
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final boolean contains(Object object) {
        if (object instanceof Void) {
            return this.a((Void)object);
        }
        return false;
    }

    public boolean containsAll(@NotNull Collection collection) {
        h.b((Object)collection, "elements");
        return collection.isEmpty();
    }

    public boolean equals(@Nullable Object object) {
        return object instanceof List && ((List)object).isEmpty();
    }

    public /* synthetic */ Object get(int n2) {
        return this.a(n2);
    }

    public int hashCode() {
        return 1;
    }

    public final int indexOf(Object object) {
        if (object instanceof Void) {
            return this.b((Void)object);
        }
        return -1;
    }

    public boolean isEmpty() {
        return true;
    }

    @NotNull
    public Iterator iterator() {
        return (Iterator)r.a;
    }

    public final int lastIndexOf(Object object) {
        if (object instanceof Void) {
            return this.c((Void)object);
        }
        return -1;
    }

    @NotNull
    public ListIterator listIterator() {
        return r.a;
    }

    @NotNull
    public ListIterator listIterator(int n2) {
        if (n2 == 0) {
            return r.a;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Index: ");
        stringBuilder.append(n2);
        throw (Throwable)new IndexOutOfBoundsException(stringBuilder.toString());
    }

    public /* synthetic */ Object remove(int n2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean remove(Object object) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* synthetic */ Object set(int n2, Object object) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final int size() {
        return this.a();
    }

    @NotNull
    public List subList(int n2, int n3) {
        if (n2 == 0 && n3 == 0) {
            return this;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fromIndex: ");
        stringBuilder.append(n2);
        stringBuilder.append(", toIndex: ");
        stringBuilder.append(n3);
        throw (Throwable)new IndexOutOfBoundsException(stringBuilder.toString());
    }

    public Object[] toArray() {
        return d.a(this);
    }

    public <T> T[] toArray(T[] arrT) {
        return d.a(this, arrT);
    }

    @NotNull
    public String toString() {
        return "[]";
    }
}


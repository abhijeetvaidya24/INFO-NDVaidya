/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  a.a.b.b.h
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.List
 *  java.util.NoSuchElementException
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package a.a.a;

import a.a.a.g;
import a.a.a.p;
import a.a.b.b.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

class q
extends p {
    @NotNull
    public static final <T, C extends Collection<? super T>> C a(@NotNull Iterable<? extends T> iterable, @NotNull C c) {
        h.b(iterable, (String)"$receiver");
        h.b(c, (String)"destination");
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            c.add(iterator.next());
        }
        return c;
    }

    @NotNull
    public static final <T> List<T> a(@NotNull Iterable<? extends T> iterable) {
        h.b(iterable, (String)"$receiver");
        if (iterable instanceof Collection) {
            Collection collection = (Collection)iterable;
            int n2 = collection.size();
            if (n2 != 0) {
                if (n2 != 1) {
                    return g.a(collection);
                }
                Object object = iterable instanceof List ? ((List)iterable).get(0) : iterable.iterator().next();
                return g.a((Object)object);
            }
            return g.a();
        }
        return g.b(g.b(iterable));
    }

    @NotNull
    public static final <T> List<T> a(@NotNull Collection<? extends T> collection) {
        h.b(collection, (String)"$receiver");
        return (List)new ArrayList(collection);
    }

    @NotNull
    public static final <T> List<T> b(@NotNull Iterable<? extends T> iterable) {
        h.b(iterable, (String)"$receiver");
        if (iterable instanceof Collection) {
            return g.a((Collection)iterable);
        }
        return (List)g.a(iterable, (Collection)new ArrayList());
    }

    public static final <T> T c(@NotNull List<? extends T> list) {
        h.b(list, (String)"$receiver");
        if (!list.isEmpty()) {
            return (T)list.get(0);
        }
        throw (Throwable)new NoSuchElementException("List is empty.");
    }

    @Nullable
    public static final <T> T d(@NotNull List<? extends T> list) {
        h.b(list, (String)"$receiver");
        if (list.isEmpty()) {
            return null;
        }
        return (T)list.get(0);
    }

    public static final <T> T e(@NotNull List<? extends T> list) {
        h.b(list, (String)"$receiver");
        if (!list.isEmpty()) {
            return (T)list.get(g.a(list));
        }
        throw (Throwable)new NoSuchElementException("List is empty.");
    }
}


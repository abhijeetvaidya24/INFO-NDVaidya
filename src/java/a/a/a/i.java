/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  a.a.a.a
 *  a.a.a.g
 *  a.a.a.h
 *  a.a.a.s
 *  a.a.b.b.h
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 *  org.jetbrains.annotations.NotNull
 */
package a.a.a;

import a.a.a.a;
import a.a.a.g;
import a.a.a.h;
import a.a.a.s;
import java.util.List;
import org.jetbrains.annotations.NotNull;

class i
extends h {
    public static final <T> int a(@NotNull List<? extends T> list) {
        a.a.b.b.h.b(list, (String)"$receiver");
        return -1 + list.size();
    }

    @NotNull
    public static final <T> List<T> a() {
        return (List)s.a;
    }

    @NotNull
    public static final /* varargs */ <T> List<T> a(@NotNull T ... arrT) {
        a.a.b.b.h.b(arrT, (String)"elements");
        if (arrT.length > 0) {
            return a.a((Object[])arrT);
        }
        return g.a();
    }

    @NotNull
    public static final <T> List<T> b(@NotNull List<? extends T> list) {
        a.a.b.b.h.b(list, (String)"$receiver");
        int n2 = list.size();
        if (n2 != 0) {
            if (n2 != 1) {
                return list;
            }
            return g.a((Object)list.get(0));
        }
        return g.a();
    }
}


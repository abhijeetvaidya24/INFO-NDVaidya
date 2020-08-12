/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.yandex.metrica.impl.ob.s$a
 *  com.yandex.metrica.impl.ob.s$b
 *  com.yandex.metrica.impl.ob.s$c
 *  com.yandex.metrica.impl.ob.s$d
 *  com.yandex.metrica.impl.ob.t
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.LinkedList
 *  java.util.List
 *  java.util.Map
 */
package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.db;
import com.yandex.metrica.impl.ob.r;
import com.yandex.metrica.impl.ob.s;
import com.yandex.metrica.impl.ob.t;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
 * Exception performing whole class analysis.
 */
public class s {
    private final t a;
    private final db b;
    private List<e> c;

    s(t t2, db db2) {
        this.a = t2;
        this.b = db2;
        this.c = new LinkedList();
        this.c.add((Object)new /* Unavailable Anonymous Inner Class!! */);
        this.c.add((Object)new /* Unavailable Anonymous Inner Class!! */);
        this.c.add((Object)new /* Unavailable Anonymous Inner Class!! */);
        this.c.add((Object)new /* Unavailable Anonymous Inner Class!! */);
    }

    void a() {
        String string2 = this.a.l().a();
        if (!db.a.values().contains((Object)string2)) {
            Iterator iterator = this.c.iterator();
            while (iterator.hasNext()) {
                ((e)iterator.next()).d();
            }
        }
    }

    private static abstract class e {
        private final t a;

        e(t t2) {
            this.a = t2;
        }

        protected abstract boolean a();

        protected abstract void b();

        t c() {
            return this.a;
        }

        void d() {
            if (this.a()) {
                this.b();
            }
        }
    }

}


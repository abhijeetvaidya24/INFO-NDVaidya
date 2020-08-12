/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.b.a.a.a.b.i
 *  com.b.a.a.a.c.e
 *  java.lang.Object
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 */
package com.b.a.a.a.c;

import com.b.a.a.a.b.i;
import com.b.a.a.a.c.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class a {
    private static a a = new a();
    private final ArrayList<i> b = new ArrayList();
    private final ArrayList<i> c = new ArrayList();

    private a() {
    }

    public static a a() {
        return a;
    }

    public void a(i i2) {
        this.b.add((Object)i2);
    }

    public Collection<i> b() {
        return Collections.unmodifiableCollection(this.b);
    }

    public void b(i i2) {
        boolean bl = this.d();
        this.c.add((Object)i2);
        if (!bl) {
            e.a().b();
        }
    }

    public Collection<i> c() {
        return Collections.unmodifiableCollection(this.c);
    }

    public void c(i i2) {
        boolean bl = this.d();
        this.b.remove((Object)i2);
        this.c.remove((Object)i2);
        if (bl && !this.d()) {
            e.a().c();
        }
    }

    public boolean d() {
        return this.c.size() > 0;
    }
}


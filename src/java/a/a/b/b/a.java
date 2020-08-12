/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  a.a.b.b.a$a
 *  a.a.d.a
 *  a.a.d.c
 *  java.io.Serializable
 *  java.lang.AbstractMethodError
 *  java.lang.Object
 *  java.lang.String
 */
package a.a.b.b;

import a.a.b.b.a;
import a.a.d.c;
import java.io.Serializable;

public abstract class a
implements a.a.d.a,
Serializable {
    public static final Object a = a.a();
    private transient a.a.d.a b;
    protected final Object receiver;

    public a() {
        this(a);
    }

    protected a(Object object) {
        this.receiver = object;
    }

    public c a() {
        throw new AbstractMethodError();
    }

    public String b() {
        throw new AbstractMethodError();
    }

    public String c() {
        throw new AbstractMethodError();
    }

    protected abstract a.a.d.a d();

    public Object e() {
        return this.receiver;
    }

    public a.a.d.a f() {
        a.a.d.a a2 = this.b;
        if (a2 == null) {
            this.b = a2 = this.d();
        }
        return a2;
    }
}


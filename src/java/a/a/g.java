/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  a.a.b.a.a
 *  a.a.b.b.e
 *  a.a.b.b.h
 *  a.a.c
 *  a.a.i
 *  java.io.Serializable
 *  java.lang.Object
 *  java.lang.String
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package a.a;

import a.a.b.a.a;
import a.a.b.b.e;
import a.a.b.b.h;
import a.a.c;
import a.a.i;
import java.io.Serializable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class g<T>
implements c<T>,
Serializable {
    private volatile Object _value;
    private a<? extends T> initializer;
    private final Object lock;

    public g(@NotNull a<? extends T> a2, @Nullable Object object) {
        h.b(a2, (String)"initializer");
        this.initializer = a2;
        this._value = i.a;
        if (object == null) {
            object = this;
        }
        this.lock = object;
    }

    public /* synthetic */ g(a a2, Object object, int n2, e e2) {
        if ((n2 & 2) != 0) {
            object = null;
        }
        this(a2, object);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public T a() {
        Object object;
        Object object2 = this._value;
        if (object2 != i.a) {
            return (T)object2;
        }
        Object object3 = object = this.lock;
        synchronized (object3) {
            Object object4 = this._value;
            if (object4 == i.a) {
                a<? extends T> a2 = this.initializer;
                if (a2 == null) {
                    h.a();
                }
                this._value = object4 = a2.a();
                this.initializer = null;
            }
            return (T)object4;
        }
    }

    public boolean b() {
        return this._value != i.a;
    }

    @NotNull
    public String toString() {
        if (this.b()) {
            return String.valueOf(this.a());
        }
        return "Lazy value not initialized yet.";
    }
}


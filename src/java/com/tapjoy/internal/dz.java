/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.List
 */
package com.tapjoy.internal;

import com.tapjoy.internal.dk;
import com.tapjoy.internal.dl;
import com.tapjoy.internal.dn;
import com.tapjoy.internal.do;
import com.tapjoy.internal.dp;
import com.tapjoy.internal.ds;
import com.tapjoy.internal.dy;
import com.tapjoy.internal.hx;
import java.util.List;

public final class dz
extends dl {
    public static final dn c = new b();
    public final List d;

    public dz(List list, hx hx2) {
        super(c, hx2);
        this.d = ds.a("events", list);
    }

    public final boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof dz)) {
            return false;
        }
        dz dz2 = (dz)object;
        return this.a().equals(dz2.a()) && this.d.equals((Object)dz2.d);
    }

    public final int hashCode() {
        int n2 = this.b;
        if (n2 == 0) {
            this.b = n2 = 37 * this.a().hashCode() + this.d.hashCode();
        }
        return n2;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (!this.d.isEmpty()) {
            stringBuilder.append(", events=");
            stringBuilder.append((Object)this.d);
        }
        StringBuilder stringBuilder2 = stringBuilder.replace(0, 2, "EventBatch{");
        stringBuilder2.append('}');
        return stringBuilder2.toString();
    }

    public static final class a
    extends dl.a {
        public List c = ds.a();

        public final dz b() {
            return new dz(this.c, super.a());
        }
    }

    static final class b
    extends dn {
        b() {
            super(dk.c, dz.class);
        }

        @Override
        public final /* synthetic */ int a(Object object) {
            dz dz2 = (dz)object;
            return dy.c.a().a(1, (Object)dz2.d) + dz2.a().c();
        }

        @Override
        public final /* synthetic */ Object a(do do_) {
            int n2;
            a a2 = new a();
            long l2 = do_.a();
            while ((n2 = do_.b()) != -1) {
                if (n2 != 1) {
                    dk dk2 = do_.c();
                    a2.a(n2, dk2, dk2.a().a(do_));
                    continue;
                }
                a2.c.add(dy.c.a(do_));
            }
            do_.a(l2);
            return a2.b();
        }
    }

}


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
import com.tapjoy.internal.hx;
import java.util.List;

public final class ej
extends dl {
    public static final dn c = new b();
    public final List d;

    public ej(List list) {
        this(list, hx.b);
    }

    public ej(List list, hx hx2) {
        super(c, hx2);
        this.d = ds.a("elements", list);
    }

    public final boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof ej)) {
            return false;
        }
        ej ej2 = (ej)object;
        return this.a().equals(ej2.a()) && this.d.equals((Object)ej2.d);
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
            stringBuilder.append(", elements=");
            stringBuilder.append((Object)this.d);
        }
        StringBuilder stringBuilder2 = stringBuilder.replace(0, 2, "StringList{");
        stringBuilder2.append('}');
        return stringBuilder2.toString();
    }

    public static final class a
    extends dl.a {
        public List c = ds.a();

        public final ej b() {
            return new ej(this.c, super.a());
        }
    }

    static final class b
    extends dn {
        b() {
            super(dk.c, ej.class);
        }

        @Override
        public final /* synthetic */ int a(Object object) {
            ej ej2 = (ej)object;
            return dn.p.a().a(1, (Object)ej2.d) + ej2.a().c();
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
                a2.c.add(dn.p.a(do_));
            }
            do_.a(l2);
            return a2.b();
        }
    }

}


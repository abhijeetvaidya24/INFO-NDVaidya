/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.tapjoy.internal;

import com.tapjoy.internal.dk;
import com.tapjoy.internal.dl;
import com.tapjoy.internal.dn;
import com.tapjoy.internal.do;
import com.tapjoy.internal.dp;
import com.tapjoy.internal.ds;
import com.tapjoy.internal.dx;
import com.tapjoy.internal.ed;
import com.tapjoy.internal.ek;
import com.tapjoy.internal.hx;

public final class ee
extends dl {
    public static final dn c = new b();
    public final ed d;
    public final dx e;
    public final ek f;

    public ee(ed ed2, dx dx2, ek ek2) {
        this(ed2, dx2, ek2, hx.b);
    }

    public ee(ed ed2, dx dx2, ek ek2, hx hx2) {
        super(c, hx2);
        this.d = ed2;
        this.e = dx2;
        this.f = ek2;
    }

    public final boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof ee)) {
            return false;
        }
        ee ee2 = (ee)object;
        return this.a().equals(ee2.a()) && ds.a((Object)this.d, (Object)ee2.d) && ds.a((Object)this.e, (Object)ee2.e) && ds.a((Object)this.f, (Object)ee2.f);
    }

    public final int hashCode() {
        int n2 = this.b;
        if (n2 == 0) {
            int n3 = 37 * this.a().hashCode();
            ed ed2 = this.d;
            int n4 = ed2 != null ? ed2.hashCode() : 0;
            int n5 = 37 * (n3 + n4);
            dx dx2 = this.e;
            int n6 = dx2 != null ? dx2.hashCode() : 0;
            int n7 = 37 * (n5 + n6);
            ek ek2 = this.f;
            int n8 = 0;
            if (ek2 != null) {
                n8 = ek2.hashCode();
            }
            this.b = n2 = n7 + n8;
        }
        return n2;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.d != null) {
            stringBuilder.append(", info=");
            stringBuilder.append((Object)this.d);
        }
        if (this.e != null) {
            stringBuilder.append(", app=");
            stringBuilder.append((Object)this.e);
        }
        if (this.f != null) {
            stringBuilder.append(", user=");
            stringBuilder.append((Object)this.f);
        }
        StringBuilder stringBuilder2 = stringBuilder.replace(0, 2, "InfoSet{");
        stringBuilder2.append('}');
        return stringBuilder2.toString();
    }

    public static final class a
    extends dl.a {
        public ed c;
        public dx d;
        public ek e;

        public final ee b() {
            return new ee(this.c, this.d, this.e, super.a());
        }
    }

    static final class b
    extends dn {
        b() {
            super(dk.c, ee.class);
        }

        @Override
        public final /* synthetic */ int a(Object object) {
            ee ee2 = (ee)object;
            int n2 = ee2.d != null ? ed.c.a(1, (Object)ee2.d) : 0;
            int n3 = ee2.e != null ? dx.c.a(2, (Object)ee2.e) : 0;
            int n4 = n2 + n3;
            ek ek2 = ee2.f;
            int n5 = 0;
            if (ek2 != null) {
                n5 = ek.c.a(3, (Object)ee2.f);
            }
            return n4 + n5 + ee2.a().c();
        }

        @Override
        public final /* synthetic */ Object a(do do_) {
            int n2;
            a a2 = new a();
            long l2 = do_.a();
            while ((n2 = do_.b()) != -1) {
                if (n2 != 1) {
                    if (n2 != 2) {
                        if (n2 != 3) {
                            dk dk2 = do_.c();
                            a2.a(n2, dk2, dk2.a().a(do_));
                            continue;
                        }
                        a2.e = (ek)ek.c.a(do_);
                        continue;
                    }
                    a2.d = (dx)dx.c.a(do_);
                    continue;
                }
                a2.c = (ed)ed.c.a(do_);
            }
            do_.a(l2);
            return a2.b();
        }
    }

}


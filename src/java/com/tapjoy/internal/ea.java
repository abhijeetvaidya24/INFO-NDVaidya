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
import com.tapjoy.internal.eb;
import com.tapjoy.internal.hx;

public final class ea
extends dl {
    public static final dn c = new b();
    public static final eb d = eb.APP;
    public final eb e;
    public final String f;
    public final String g;

    public ea(eb eb2, String string, String string2, hx hx2) {
        super(c, hx2);
        this.e = eb2;
        this.f = string;
        this.g = string2;
    }

    public final boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof ea)) {
            return false;
        }
        ea ea2 = (ea)object;
        return this.a().equals(ea2.a()) && this.e.equals((Object)ea2.e) && this.f.equals((Object)ea2.f) && ds.a((Object)this.g, (Object)ea2.g);
    }

    public final int hashCode() {
        int n2 = this.b;
        if (n2 == 0) {
            int n3 = 37 * (37 * (37 * this.a().hashCode() + this.e.hashCode()) + this.f.hashCode());
            String string = this.g;
            int n4 = string != null ? string.hashCode() : 0;
            this.b = n2 = n3 + n4;
        }
        return n2;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(", type=");
        stringBuilder.append((Object)this.e);
        stringBuilder.append(", name=");
        stringBuilder.append(this.f);
        if (this.g != null) {
            stringBuilder.append(", category=");
            stringBuilder.append(this.g);
        }
        StringBuilder stringBuilder2 = stringBuilder.replace(0, 2, "EventGroup{");
        stringBuilder2.append('}');
        return stringBuilder2.toString();
    }

    public static final class a
    extends dl.a {
        public eb c;
        public String d;
        public String e;

        public final ea b() {
            String string;
            eb eb2 = this.c;
            if (eb2 != null && (string = this.d) != null) {
                return new ea(eb2, string, this.e, super.a());
            }
            Object[] arrobject = new Object[]{this.c, "type", this.d, "name"};
            throw ds.a(arrobject);
        }
    }

    static final class b
    extends dn {
        b() {
            super(dk.c, ea.class);
        }

        private static ea b(do do_) {
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
                        a2.e = (String)dn.p.a(do_);
                        continue;
                    }
                    a2.d = (String)dn.p.a(do_);
                    continue;
                }
                try {
                    a2.c = (eb)eb.ADAPTER.a(do_);
                }
                catch (dn.a a3) {
                    a2.a(n2, dk.a, a3.a);
                }
            }
            do_.a(l2);
            return a2.b();
        }

        @Override
        public final /* synthetic */ int a(Object object) {
            ea ea2 = (ea)object;
            int n2 = eb.ADAPTER.a(1, (Object)ea2.e) + dn.p.a(2, (Object)ea2.f);
            int n3 = ea2.g != null ? dn.p.a(3, (Object)ea2.g) : 0;
            return n2 + n3 + ea2.a().c();
        }

        @Override
        public final /* synthetic */ Object a(do do_) {
            return b.b(do_);
        }
    }

}


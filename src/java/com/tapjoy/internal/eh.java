/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Long
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
import com.tapjoy.internal.hx;

public final class eh
extends dl {
    public static final dn c;
    public static final Long d;
    public static final Long e;
    public final String f;
    public final Long g;
    public final Long h;

    static {
        Long l2;
        c = new b();
        d = l2 = Long.valueOf((long)0L);
        e = l2;
    }

    public eh(String string, Long l2) {
        this(string, l2, null, hx.b);
    }

    public eh(String string, Long l2, Long l3, hx hx2) {
        super(c, hx2);
        this.f = string;
        this.g = l2;
        this.h = l3;
    }

    public final a b() {
        a a2 = new a();
        a2.c = this.f;
        a2.d = this.g;
        a2.e = this.h;
        a2.a(this.a());
        return a2;
    }

    public final boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof eh)) {
            return false;
        }
        eh eh2 = (eh)object;
        return this.a().equals(eh2.a()) && this.f.equals((Object)eh2.f) && this.g.equals((Object)eh2.g) && ds.a((Object)this.h, (Object)eh2.h);
    }

    public final int hashCode() {
        int n2 = this.b;
        if (n2 == 0) {
            int n3 = 37 * (37 * (37 * this.a().hashCode() + this.f.hashCode()) + this.g.hashCode());
            Long l2 = this.h;
            int n4 = l2 != null ? l2.hashCode() : 0;
            this.b = n2 = n3 + n4;
        }
        return n2;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(", id=");
        stringBuilder.append(this.f);
        stringBuilder.append(", received=");
        stringBuilder.append((Object)this.g);
        if (this.h != null) {
            stringBuilder.append(", clicked=");
            stringBuilder.append((Object)this.h);
        }
        StringBuilder stringBuilder2 = stringBuilder.replace(0, 2, "Push{");
        stringBuilder2.append('}');
        return stringBuilder2.toString();
    }

    public static final class a
    extends dl.a {
        public String c;
        public Long d;
        public Long e;

        public final eh b() {
            Long l2;
            String string = this.c;
            if (string != null && (l2 = this.d) != null) {
                return new eh(string, l2, this.e, super.a());
            }
            Object[] arrobject = new Object[]{this.c, "id", this.d, "received"};
            throw ds.a(arrobject);
        }
    }

    static final class b
    extends dn {
        b() {
            super(dk.c, eh.class);
        }

        @Override
        public final /* synthetic */ int a(Object object) {
            eh eh2 = (eh)object;
            int n2 = dn.p.a(1, (Object)eh2.f) + dn.i.a(2, (Object)eh2.g);
            int n3 = eh2.h != null ? dn.i.a(3, (Object)eh2.h) : 0;
            return n2 + n3 + eh2.a().c();
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
                        a2.e = (Long)dn.i.a(do_);
                        continue;
                    }
                    a2.d = (Long)dn.i.a(do_);
                    continue;
                }
                a2.c = (String)dn.p.a(do_);
            }
            do_.a(l2);
            return a2.b();
        }
    }

}


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

public final class ec
extends dl {
    public static final dn c = new b();
    public static final Long d = 0L;
    public final String e;
    public final Long f;

    public ec(String string, Long l2) {
        this(string, l2, hx.b);
    }

    public ec(String string, Long l2, hx hx2) {
        super(c, hx2);
        this.e = string;
        this.f = l2;
    }

    public final boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof ec)) {
            return false;
        }
        ec ec2 = (ec)object;
        return this.a().equals(ec2.a()) && this.e.equals((Object)ec2.e) && this.f.equals((Object)ec2.f);
    }

    public final int hashCode() {
        int n2 = this.b;
        if (n2 == 0) {
            this.b = n2 = 37 * (37 * this.a().hashCode() + this.e.hashCode()) + this.f.hashCode();
        }
        return n2;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(", name=");
        stringBuilder.append(this.e);
        stringBuilder.append(", value=");
        stringBuilder.append((Object)this.f);
        StringBuilder stringBuilder2 = stringBuilder.replace(0, 2, "EventValue{");
        stringBuilder2.append('}');
        return stringBuilder2.toString();
    }

    public static final class a
    extends dl.a {
        public String c;
        public Long d;

        public final ec b() {
            Long l2;
            String string = this.c;
            if (string != null && (l2 = this.d) != null) {
                return new ec(string, l2, super.a());
            }
            Object[] arrobject = new Object[]{this.c, "name", this.d, "value"};
            throw ds.a(arrobject);
        }
    }

    static final class b
    extends dn {
        b() {
            super(dk.c, ec.class);
        }

        @Override
        public final /* synthetic */ int a(Object object) {
            ec ec2 = (ec)object;
            return dn.p.a(1, (Object)ec2.e) + dn.i.a(2, (Object)ec2.f) + ec2.a().c();
        }

        @Override
        public final /* synthetic */ Object a(do do_) {
            int n2;
            a a2 = new a();
            long l2 = do_.a();
            while ((n2 = do_.b()) != -1) {
                if (n2 != 1) {
                    if (n2 != 2) {
                        dk dk2 = do_.c();
                        a2.a(n2, dk2, dk2.a().a(do_));
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


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
import com.tapjoy.internal.hx;

public final class ef
extends dl {
    public static final dn c = new b();
    public final String d;
    public final String e;
    public final String f;

    public ef(String string, String string2, String string3) {
        this(string, string2, string3, hx.b);
    }

    public ef(String string, String string2, String string3, hx hx2) {
        super(c, hx2);
        this.d = string;
        this.e = string2;
        this.f = string3;
    }

    public final boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof ef)) {
            return false;
        }
        ef ef2 = (ef)object;
        return this.a().equals(ef2.a()) && ds.a((Object)this.d, (Object)ef2.d) && ds.a((Object)this.e, (Object)ef2.e) && ds.a((Object)this.f, (Object)ef2.f);
    }

    public final int hashCode() {
        int n2 = this.b;
        if (n2 == 0) {
            int n3 = 37 * this.a().hashCode();
            String string = this.d;
            int n4 = string != null ? string.hashCode() : 0;
            int n5 = 37 * (n3 + n4);
            String string2 = this.e;
            int n6 = string2 != null ? string2.hashCode() : 0;
            int n7 = 37 * (n5 + n6);
            String string3 = this.f;
            int n8 = 0;
            if (string3 != null) {
                n8 = string3.hashCode();
            }
            this.b = n2 = n7 + n8;
        }
        return n2;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.d != null) {
            stringBuilder.append(", fq7Change=");
            stringBuilder.append(this.d);
        }
        if (this.e != null) {
            stringBuilder.append(", fq30Change=");
            stringBuilder.append(this.e);
        }
        if (this.f != null) {
            stringBuilder.append(", pushId=");
            stringBuilder.append(this.f);
        }
        StringBuilder stringBuilder2 = stringBuilder.replace(0, 2, "Meta{");
        stringBuilder2.append('}');
        return stringBuilder2.toString();
    }

    public static final class a
    extends dl.a {
        public String c;
        public String d;
        public String e;

        public final ef b() {
            return new ef(this.c, this.d, this.e, super.a());
        }
    }

    static final class b
    extends dn {
        b() {
            super(dk.c, ef.class);
        }

        @Override
        public final /* synthetic */ int a(Object object) {
            ef ef2 = (ef)object;
            int n2 = ef2.d != null ? dn.p.a(1, (Object)ef2.d) : 0;
            int n3 = ef2.e != null ? dn.p.a(2, (Object)ef2.e) : 0;
            int n4 = n2 + n3;
            String string = ef2.f;
            int n5 = 0;
            if (string != null) {
                n5 = dn.p.a(3, (Object)ef2.f);
            }
            return n4 + n5 + ef2.a().c();
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
                        a2.e = (String)dn.p.a(do_);
                        continue;
                    }
                    a2.d = (String)dn.p.a(do_);
                    continue;
                }
                a2.c = (String)dn.p.a(do_);
            }
            do_.a(l2);
            return a2.b();
        }
    }

}


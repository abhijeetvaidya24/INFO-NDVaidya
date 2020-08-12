/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Integer
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

public final class dx
extends dl {
    public static final dn c = new b();
    public static final Integer d = 0;
    public final String e;
    public final Integer f;
    public final String g;
    public final String h;
    public final String i;

    public dx(String string, Integer n2, String string2, String string3, String string4, hx hx2) {
        super(c, hx2);
        this.e = string;
        this.f = n2;
        this.g = string2;
        this.h = string3;
        this.i = string4;
    }

    public final boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof dx)) {
            return false;
        }
        dx dx2 = (dx)object;
        return this.a().equals(dx2.a()) && ds.a((Object)this.e, (Object)dx2.e) && ds.a((Object)this.f, (Object)dx2.f) && ds.a((Object)this.g, (Object)dx2.g) && ds.a((Object)this.h, (Object)dx2.h) && ds.a((Object)this.i, (Object)dx2.i);
    }

    public final int hashCode() {
        int n2 = this.b;
        if (n2 == 0) {
            int n3 = 37 * this.a().hashCode();
            String string = this.e;
            int n4 = string != null ? string.hashCode() : 0;
            int n5 = 37 * (n3 + n4);
            Integer n6 = this.f;
            int n7 = n6 != null ? n6.hashCode() : 0;
            int n8 = 37 * (n5 + n7);
            String string2 = this.g;
            int n9 = string2 != null ? string2.hashCode() : 0;
            int n10 = 37 * (n8 + n9);
            String string3 = this.h;
            int n11 = string3 != null ? string3.hashCode() : 0;
            int n12 = 37 * (n10 + n11);
            String string4 = this.i;
            int n13 = 0;
            if (string4 != null) {
                n13 = string4.hashCode();
            }
            this.b = n2 = n12 + n13;
        }
        return n2;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.e != null) {
            stringBuilder.append(", pkgVer=");
            stringBuilder.append(this.e);
        }
        if (this.f != null) {
            stringBuilder.append(", pkgRev=");
            stringBuilder.append((Object)this.f);
        }
        if (this.g != null) {
            stringBuilder.append(", dataVer=");
            stringBuilder.append(this.g);
        }
        if (this.h != null) {
            stringBuilder.append(", installer=");
            stringBuilder.append(this.h);
        }
        if (this.i != null) {
            stringBuilder.append(", store=");
            stringBuilder.append(this.i);
        }
        StringBuilder stringBuilder2 = stringBuilder.replace(0, 2, "App{");
        stringBuilder2.append('}');
        return stringBuilder2.toString();
    }

    public static final class a
    extends dl.a {
        public String c;
        public Integer d;
        public String e;
        public String f;
        public String g;

        public final dx b() {
            dx dx2 = new dx(this.c, this.d, this.e, this.f, this.g, super.a());
            return dx2;
        }
    }

    static final class b
    extends dn {
        b() {
            super(dk.c, dx.class);
        }

        @Override
        public final /* synthetic */ int a(Object object) {
            dx dx2 = (dx)object;
            int n2 = dx2.e != null ? dn.p.a(1, (Object)dx2.e) : 0;
            int n3 = dx2.f != null ? dn.d.a(2, (Object)dx2.f) : 0;
            int n4 = n2 + n3;
            int n5 = dx2.g != null ? dn.p.a(3, (Object)dx2.g) : 0;
            int n6 = n4 + n5;
            int n7 = dx2.h != null ? dn.p.a(4, (Object)dx2.h) : 0;
            int n8 = n6 + n7;
            String string = dx2.i;
            int n9 = 0;
            if (string != null) {
                n9 = dn.p.a(5, (Object)dx2.i);
            }
            return n8 + n9 + dx2.a().c();
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
                            if (n2 != 4) {
                                if (n2 != 5) {
                                    dk dk2 = do_.c();
                                    a2.a(n2, dk2, dk2.a().a(do_));
                                    continue;
                                }
                                a2.g = (String)dn.p.a(do_);
                                continue;
                            }
                            a2.f = (String)dn.p.a(do_);
                            continue;
                        }
                        a2.e = (String)dn.p.a(do_);
                        continue;
                    }
                    a2.d = (Integer)dn.d.a(do_);
                    continue;
                }
                a2.c = (String)dn.p.a(do_);
            }
            do_.a(l2);
            return a2.b();
        }
    }

}


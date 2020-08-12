/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Void
 *  java.util.List
 */
package com.tappx.a.a.a.b;

import com.tappx.a.a.a.b.a.b;
import com.tappx.a.a.a.b.a.c;
import com.tappx.a.a.a.b.a.e;
import com.tappx.a.a.a.b.a.g;
import com.tappx.a.a.a.b.d;
import com.tappx.a.a.a.b.f;
import com.tappx.a.a.a.b.h;
import com.tappx.a.a.a.b.i;
import com.tappx.a.a.a.b.j;
import com.tappx.a.a.a.b.l;
import com.tappx.a.a.a.o;
import java.util.List;

public class j
implements i {
    private final c a;
    private final l.a b;
    private final f.a c;
    private final d.a d;
    private final h.a e;
    private String f;

    public j(c c2, l.a a2, f.a a3, d.a a4, h.a a5, String string) {
        this.a = c2;
        this.b = a2;
        this.d = a4;
        this.c = a3;
        this.e = a5;
        this.f = string;
    }

    i.a a(b b2) {
        int n2 = 9.a[b2.a().ordinal()];
        if (n2 != 1 && n2 != 2) {
            if (n2 != 3) {
                return i.a.a;
            }
            return i.a.d;
        }
        return i.a.c;
    }

    @Override
    public i.b a(long l2, com.tappx.a.a.a.h.i i2, final o<Void> o2, final com.tappx.a.a.a.j<Void> j2) {
        h h2 = this.e.a(new g.b<Void>(){

            @Override
            public void a(Void void_) {
                o2.a(void_);
            }
        }, new g.a(){

            @Override
            public void a(b b2) {
                j2.a(null);
            }
        }, l2, i2);
        this.a.a(h2);
        return new a(h2);
    }

    @Override
    public i.b a(com.tappx.a.a.a.e.g g2, final o<com.tappx.a.a.a.e.f> o2, final com.tappx.a.a.a.j<i.a> j2) {
        f f2 = this.c.a(this.f, g2.h(), new g.b<com.tappx.a.a.a.e.f>(){

            @Override
            public void a(com.tappx.a.a.a.e.f f2) {
                com.tappx.a.a.a.c.a.e("+QDdaoqvt3qJgm+ZybmeEWKfNA+0iZtjtThflGW6n9w", new Object[0]);
                o2.a(f2);
            }
        }, new g.a(){

            @Override
            public void a(b b2) {
                Object[] arrobject = new Object[]{String.valueOf((Object)((Object)b2.a())), b2.c};
                com.tappx.a.a.a.c.a.e("w4andMWX7t5Jfk790BgWUrMNcOuo2+YQaoHGCbc1pcv+JGcCt9DRPjxTYUAbO5pE", arrobject);
                i.a a2 = j.this.a(b2);
                j2.a(a2);
            }
        });
        this.a.a(f2);
        return new a(f2);
    }

    @Override
    public i.b a(com.tappx.a.a.a.e.i i2, final o<com.tappx.a.a.a.e.d> o2, final com.tappx.a.a.a.j<i.a> j2) {
        l l2 = this.b.a(this.f, i2, new g.b<com.tappx.a.a.a.e.d>(){

            @Override
            public void a(com.tappx.a.a.a.e.d d2) {
                Object[] arrobject = new Object[]{d2.a().size()};
                com.tappx.a.a.a.c.a.e("0SvrL3Mu6kpegPQCJvH2Z3Pn/6HNDFPvXWhwtIQHwo9OKbwcnbuQeVUXYNnm0mlw", arrobject);
                o2.a(d2);
            }
        }, new g.a(){

            @Override
            public void a(b b2) {
                Object[] arrobject = new Object[]{String.valueOf((Object)((Object)b2.a())), b2.c};
                com.tappx.a.a.a.c.a.e("UJIn9VFKpDDGLj92vFtsDu89edbIfDnf+1BS1Op+N3ibnXDClU6Qn4m9zcPUJndT", arrobject);
                i.a a2 = j.this.a(b2);
                j2.a(a2);
            }
        });
        com.tappx.a.a.a.c.a.e("upDm/dcl7UFgv/WqQEFY8gxmh3157yb0PYmjrJydiuLWTs98xZyVkrKHoj9tmnz38qJvrbo3OSEcqRch9gbHFw", new Object[0]);
        this.a.a(l2);
        return new a(l2);
    }

    @Override
    public i.b a(final o<com.tappx.a.a.a.h.b> o2, final com.tappx.a.a.a.j<Void> j2) {
        d d2 = this.d.a(new g.b<com.tappx.a.a.a.h.b>(){

            @Override
            public void a(com.tappx.a.a.a.h.b b2) {
                o2.a(b2);
            }
        }, new g.a(){

            @Override
            public void a(b b2) {
                j2.a(null);
            }
        });
        this.a.a(d2);
        return new a(d2);
    }

    @Override
    public void a(i.b b2) {
        if (!(b2 instanceof a)) {
            return;
        }
        a a2 = (a)b2;
        this.a.b(a2.a());
    }

    protected static final class a
    extends i.b {
        private final e<?> a;

        private a(e<?> e2) {
            this.a = e2;
        }

        public e<?> a() {
            return this.a;
        }
    }

}


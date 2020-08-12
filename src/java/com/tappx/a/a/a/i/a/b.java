/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Void
 */
package com.tappx.a.a.a.i.a;

import com.tappx.a.a.a.b.a.e;
import com.tappx.a.a.a.b.a.g;
import com.tappx.a.a.a.i.a.b;
import com.tappx.a.a.a.i.a.c;

public class b
implements com.tappx.a.a.a.i.a.a {
    private static final int a = 4;
    private final com.tappx.a.a.a.b.a.c b;

    public b(com.tappx.a.a.a.b.a.c c2) {
        this.b = c2;
    }

    @Override
    public void a(String string) {
        if (string == null) {
            return;
        }
        com.tappx.a.a.a.c.a.e("0fBLEtCaOL9UAJMNctGOmg", string);
        c c2 = new c(string, null, null);
        c2.a(new a(c2));
        this.b.a(c2);
    }

    private final class a
    implements g.a {
        private final c b;
        private int c = 0;

        private a(c c2) {
            this.b = c2;
        }

        private int a(int n2) {
            return (int)(1000.0 * Math.pow((double)2.0, (double)(1.5f * (float)n2)));
        }

        @Override
        public void a(com.tappx.a.a.a.b.a.b b2) {
            this.c = 1 + this.c;
            int n2 = this.c;
            if (n2 > 4) {
                Object[] arrobject = new Object[]{n2 - 1};
                com.tappx.a.a.a.c.a.e("VVPuWC/9Kuu7F3i2uDo+EpXhKnuxQFx794EdWq4sqJx9G87i++pCpDIUbWEx83NA", arrobject);
                return;
            }
            int n3 = this.a(n2);
            Object[] arrobject = new Object[]{String.valueOf((int)n3)};
            com.tappx.a.a.a.c.a.e("nLLZ8hYKbSEKzUbM0u+Pir24N5Oaw+Lx+MoBG+cviQs", arrobject);
            b.this.b.a(this.b, n3);
        }
    }

}


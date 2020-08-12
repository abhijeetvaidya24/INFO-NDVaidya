/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.tapjoy.internal.hu
 *  com.tapjoy.internal.hv
 *  java.io.IOException
 *  java.io.Serializable
 *  java.lang.AssertionError
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 */
package com.tapjoy.internal;

import com.tapjoy.internal.dk;
import com.tapjoy.internal.dn;
import com.tapjoy.internal.dp;
import com.tapjoy.internal.hu;
import com.tapjoy.internal.hv;
import com.tapjoy.internal.hx;
import java.io.IOException;
import java.io.Serializable;

public abstract class dl
implements Serializable {
    transient int a = 0;
    protected transient int b = 0;
    private final transient dn c;
    private final transient hx d;

    protected dl(dn dn2, hx hx2) {
        if (dn2 != null) {
            if (hx2 != null) {
                this.c = dn2;
                this.d = hx2;
                return;
            }
            throw new NullPointerException("unknownFields == null");
        }
        throw new NullPointerException("adapter == null");
    }

    public final hx a() {
        hx hx2 = this.d;
        if (hx2 != null) {
            return hx2;
        }
        return hx.b;
    }

    public String toString() {
        return dn.c(this);
    }

    public static abstract class a {
        hu a;
        dp b;

        protected a() {
        }

        public final a a(int n2, dk dk2, Object object) {
            if (this.b == null) {
                this.a = new hu();
                this.b = new dp((hv)this.a);
            }
            try {
                dk2.a().a(this.b, n2, object);
                return this;
            }
            catch (IOException iOException) {
                throw new AssertionError();
            }
        }

        public final a a(hx hx2) {
            if (hx2.c() > 0) {
                if (this.b == null) {
                    this.a = new hu();
                    this.b = new dp((hv)this.a);
                }
                try {
                    this.b.a(hx2);
                    return this;
                }
                catch (IOException iOException) {
                    throw new AssertionError();
                }
            }
            return this;
        }

        public final hx a() {
            hu hu2 = this.a;
            if (hu2 != null) {
                return new hx(hu2.h().g());
            }
            return hx.b;
        }
    }

}


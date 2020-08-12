/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 */
package com.tapjoy.internal;

import com.tapjoy.internal.hu;
import com.tapjoy.internal.hv;
import com.tapjoy.internal.hx;
import com.tapjoy.internal.ib;
import com.tapjoy.internal.ie;
import com.tapjoy.internal.ih;

final class hz
implements hv {
    public final hu a = new hu();
    public final ie b;
    boolean c;

    hz(ie ie2) {
        if (ie2 != null) {
            this.b = ie2;
            return;
        }
        throw new IllegalArgumentException("sink == null");
    }

    private hv b() {
        if (!this.c) {
            hu hu2 = this.a;
            long l2 = hu2.b;
            if (l2 == 0L) {
                l2 = 0L;
            } else {
                ib ib2 = hu2.a.g;
                if (ib2.c < 8192 && ib2.e) {
                    l2 -= (long)(ib2.c - ib2.b);
                }
            }
            if (l2 > 0L) {
                this.b.a(this.a, l2);
            }
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override
    public final hv a() {
        if (!this.c) {
            long l2 = this.a.b;
            if (l2 > 0L) {
                this.b.a(this.a, l2);
            }
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override
    public final void a(hu hu2, long l2) {
        if (!this.c) {
            this.a.a(hu2, l2);
            this.b();
            return;
        }
        throw new IllegalStateException("closed");
    }

    @Override
    public final hv b(hx hx2) {
        if (!this.c) {
            this.a.a(hx2);
            return this.b();
        }
        throw new IllegalStateException("closed");
    }

    @Override
    public final hv b(String string) {
        if (!this.c) {
            this.a.a(string);
            return this.b();
        }
        throw new IllegalStateException("closed");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final void close() {
        Throwable throwable;
        block7 : {
            if (this.c) {
                return;
            }
            try {
                long l2 = this.a.b LCMP 0L;
                throwable = null;
                if (l2 > 0) {
                    this.b.a(this.a, this.a.b);
                    throwable = null;
                }
            }
            catch (Throwable throwable2) {
                // empty catch block
            }
            try {
                this.b.close();
            }
            catch (Throwable throwable3) {
                if (throwable != null) break block7;
                throwable = throwable3;
            }
        }
        this.c = true;
        if (throwable != null) {
            ih.a(throwable);
        }
    }

    @Override
    public final hv d(int n2) {
        if (!this.c) {
            this.a.b(n2);
            return this.b();
        }
        throw new IllegalStateException("closed");
    }

    @Override
    public final hv e(int n2) {
        if (!this.c) {
            this.a.a(n2);
            return this.b();
        }
        throw new IllegalStateException("closed");
    }

    @Override
    public final hv f(long l2) {
        if (!this.c) {
            this.a.e(l2);
            return this.b();
        }
        throw new IllegalStateException("closed");
    }

    @Override
    public final void flush() {
        if (!this.c) {
            if (this.a.b > 0L) {
                ie ie2 = this.b;
                hu hu2 = this.a;
                ie2.a(hu2, hu2.b);
            }
            this.b.flush();
            return;
        }
        throw new IllegalStateException("closed");
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("buffer(");
        stringBuilder.append((Object)this.b);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}


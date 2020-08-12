/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.EOFException
 *  java.lang.AssertionError
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.tapjoy.internal;

import com.tapjoy.internal.hu;
import com.tapjoy.internal.hw;
import com.tapjoy.internal.hx;
import com.tapjoy.internal.if;
import com.tapjoy.internal.ih;
import java.io.EOFException;

final class ia
implements hw {
    public final hu a = new hu();
    public final if b;
    boolean c;

    ia(if if_) {
        if (if_ != null) {
            this.b = if_;
            return;
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override
    public final void a(long l2) {
        IllegalArgumentException illegalArgumentException;
        if (l2 >= 0L) {
            if (!this.c) {
                boolean bl;
                block4 : {
                    while (this.a.b < l2) {
                        if (this.b.b(this.a, 8192L) != -1L) continue;
                        bl = false;
                        break block4;
                    }
                    bl = true;
                }
                if (bl) {
                    return;
                }
                throw new EOFException();
            }
            throw new IllegalStateException("closed");
        }
        StringBuilder stringBuilder = new StringBuilder("byteCount < 0: ");
        stringBuilder.append(l2);
        illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    @Override
    public final long b(hu hu2, long l2) {
        if (hu2 != null) {
            if (l2 >= 0L) {
                if (!this.c) {
                    if (this.a.b == 0L && this.b.b(this.a, 8192L) == -1L) {
                        return -1L;
                    }
                    long l3 = Math.min((long)l2, (long)this.a.b);
                    return this.a.b(hu2, l3);
                }
                throw new IllegalStateException("closed");
            }
            StringBuilder stringBuilder = new StringBuilder("byteCount < 0: ");
            stringBuilder.append(l2);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        throw new IllegalArgumentException("sink == null");
    }

    @Override
    public final hx b(long l2) {
        this.a(l2);
        return this.a.b(l2);
    }

    @Override
    public final boolean b() {
        if (!this.c) {
            return this.a.b() && this.b.b(this.a, 8192L) == -1L;
        }
        throw new IllegalStateException("closed");
    }

    @Override
    public final byte c() {
        this.a(1L);
        return this.a.c();
    }

    @Override
    public final String c(long l2) {
        this.a(l2);
        return this.a.c(l2);
    }

    @Override
    public final void close() {
        if (this.c) {
            return;
        }
        this.c = true;
        this.b.close();
        hu hu2 = this.a;
        try {
            hu2.d(hu2.b);
            return;
        }
        catch (EOFException eOFException) {
            throw new AssertionError((Object)eOFException);
        }
    }

    @Override
    public final void d(long l2) {
        IllegalStateException illegalStateException;
        if (!this.c) {
            while (l2 > 0L) {
                if (this.a.b == 0L && this.b.b(this.a, 8192L) == -1L) {
                    throw new EOFException();
                }
                long l3 = Math.min((long)l2, (long)this.a.b);
                this.a.d(l3);
                l2 -= l3;
            }
            return;
        }
        illegalStateException = new IllegalStateException("closed");
        throw illegalStateException;
    }

    @Override
    public final int e() {
        this.a(4L);
        return ih.a(this.a.d());
    }

    @Override
    public final long f() {
        this.a(8L);
        return this.a.f();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("buffer(");
        stringBuilder.append((Object)this.b);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}


/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.ByteArrayOutputStream
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.System
 */
package com.tappx.b.a;

import com.tappx.b.a.f;
import java.io.ByteArrayOutputStream;

public class u
extends ByteArrayOutputStream {
    private static final int a = 256;
    private final f b;

    public u(f f2) {
        this(f2, 256);
    }

    public u(f f2, int n2) {
        this.b = f2;
        this.buf = this.b.a(Math.max((int)n2, (int)256));
    }

    private void a(int n2) {
        if (n2 + this.count <= this.buf.length) {
            return;
        }
        byte[] arrby = this.b.a(2 * (n2 + this.count));
        System.arraycopy((Object)this.buf, (int)0, (Object)arrby, (int)0, (int)this.count);
        this.b.a(this.buf);
        this.buf = arrby;
    }

    public void close() {
        this.b.a(this.buf);
        this.buf = null;
        super.close();
    }

    public void finalize() {
        this.b.a(this.buf);
    }

    public void write(int n2) {
        u u2 = this;
        synchronized (u2) {
            this.a(1);
            super.write(n2);
            return;
        }
    }

    public void write(byte[] arrby, int n2, int n3) {
        u u2 = this;
        synchronized (u2) {
            this.a(n3);
            super.write(arrby, n2, n3);
            return;
        }
    }
}


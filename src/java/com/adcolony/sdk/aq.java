/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.InputStream
 */
package com.adcolony.sdk;

import java.io.IOException;
import java.io.InputStream;

class aq
extends InputStream {
    InputStream a;
    int b;

    aq(InputStream inputStream, int n2, int n3) throws IOException {
        this.a = inputStream;
        while (n2 > 0) {
            n2 -= (int)inputStream.skip((long)n2);
        }
        this.b = n3;
    }

    public int available() throws IOException {
        int n2;
        int n3 = this.a.available();
        if (n3 <= (n2 = this.b)) {
            return n3;
        }
        return n2;
    }

    public void close() throws IOException {
        this.a.close();
    }

    public int read() throws IOException {
        int n2 = this.b;
        if (n2 == 0) {
            return -1;
        }
        this.b = n2 - 1;
        return this.a.read();
    }

    public int read(byte[] arrby) throws IOException {
        return this.read(arrby, 0, arrby.length);
    }

    public int read(byte[] arrby, int n2, int n3) throws IOException {
        int n4;
        int n5 = this.b;
        if (n5 == 0) {
            return -1;
        }
        if (n3 > n5) {
            n3 = n5;
        }
        if ((n4 = this.a.read(arrby, n2, n3)) == -1) {
            return -1;
        }
        this.b -= n4;
        return n4;
    }

    public long skip(long l2) throws IOException {
        int n2 = (int)l2;
        if (n2 <= 0) {
            return 0L;
        }
        int n3 = this.b;
        if (n2 > n3) {
            n2 = n3;
        }
        this.b -= n2;
        while (n2 > 0) {
            n2 -= (int)this.a.skip(l2);
        }
        return l2;
    }
}


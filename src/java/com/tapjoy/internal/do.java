/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.tapjoy.internal.hw
 *  java.io.EOFException
 *  java.io.IOException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.net.ProtocolException
 */
package com.tapjoy.internal;

import com.tapjoy.internal.dk;
import com.tapjoy.internal.hw;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;

public final class do {
    final hw a;
    private long b = 0L;
    private long c = Long.MAX_VALUE;
    private int d;
    private int e = 2;
    private int f = -1;
    private long g = -1L;
    private dk h;

    public do(hw hw2) {
        this.a = hw2;
    }

    private void a(int n2) {
        EOFException eOFException;
        while (this.b < this.c && !this.a.b()) {
            int n3 = this.i();
            if (n3 != 0) {
                int n4 = n3 >> 3;
                int n5 = n3 & 7;
                if (n5 != 0) {
                    if (n5 != 1) {
                        if (n5 != 2) {
                            if (n5 != 3) {
                                if (n5 != 4) {
                                    if (n5 == 5) {
                                        this.e = 5;
                                        this.f();
                                        continue;
                                    }
                                    StringBuilder stringBuilder = new StringBuilder("Unexpected field encoding: ");
                                    stringBuilder.append(n5);
                                    throw new ProtocolException(stringBuilder.toString());
                                }
                                if (n4 == n2) {
                                    return;
                                }
                                throw new ProtocolException("Unexpected end group");
                            }
                            this.a(n4);
                            continue;
                        }
                        int n6 = this.i();
                        long l2 = this.b;
                        long l3 = n6;
                        this.b = l2 + l3;
                        this.a.d(l3);
                        continue;
                    }
                    this.e = 1;
                    this.g();
                    continue;
                }
                this.e = 0;
                this.e();
                continue;
            }
            throw new ProtocolException("Unexpected tag 0");
        }
        eOFException = new EOFException();
        throw eOFException;
    }

    private void b(int n2) {
        if (this.e == n2) {
            this.e = 6;
            return;
        }
        long l2 = this.b;
        long l3 = this.c;
        if (l2 <= l3) {
            if (l2 == l3) {
                this.c = this.g;
                this.g = -1L;
                this.e = 6;
                return;
            }
            this.e = 7;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder("Expected to end at ");
        stringBuilder.append(this.c);
        stringBuilder.append(" but was ");
        stringBuilder.append(this.b);
        throw new IOException(stringBuilder.toString());
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private int i() {
        int n2;
        this.b = 1L + this.b;
        byte by2 = this.a.c();
        if (by2 >= 0) {
            return by2;
        }
        int n3 = by2 & 127;
        this.b = 1L + this.b;
        byte by3 = this.a.c();
        if (by3 >= 0) {
            n2 = by3 << 7;
            do {
                return n3 | n2;
                break;
            } while (true);
        }
        n3 |= (by3 & 127) << 7;
        this.b = 1L + this.b;
        byte by4 = this.a.c();
        if (by4 >= 0) {
            n2 = by4 << 14;
            return n3 | n2;
        }
        n3 |= (by4 & 127) << 14;
        this.b = 1L + this.b;
        byte by5 = this.a.c();
        if (by5 >= 0) {
            n2 = by5 << 21;
            return n3 | n2;
        }
        int n4 = n3 | (by5 & 127) << 21;
        this.b = 1L + this.b;
        byte by6 = this.a.c();
        int n5 = n4 | by6 << 28;
        if (by6 >= 0) return n5;
        for (int i2 = 0; i2 < 5; ++i2) {
            this.b = 1L + this.b;
            if (this.a.c() < 0) continue;
            return n5;
        }
        throw new ProtocolException("Malformed VARINT");
    }

    public final long a() {
        if (this.e == 2) {
            int n2;
            this.d = n2 = 1 + this.d;
            if (n2 <= 65) {
                long l2 = this.g;
                this.g = -1L;
                this.e = 6;
                return l2;
            }
            throw new IOException("Wire recursion limit exceeded");
        }
        throw new IllegalStateException("Unexpected call to beginMessage()");
    }

    public final void a(long l2) {
        if (this.e == 6) {
            int n2;
            this.d = n2 = -1 + this.d;
            if (n2 >= 0 && this.g == -1L) {
                if (this.b != this.c && this.d != 0) {
                    StringBuilder stringBuilder = new StringBuilder("Expected to end at ");
                    stringBuilder.append(this.c);
                    stringBuilder.append(" but was ");
                    stringBuilder.append(this.b);
                    throw new IOException(stringBuilder.toString());
                }
                this.c = l2;
                return;
            }
            throw new IllegalStateException("No corresponding call to beginMessage()");
        }
        throw new IllegalStateException("Unexpected call to endMessage()");
    }

    public final int b() {
        IllegalStateException illegalStateException;
        int n2 = this.e;
        if (n2 == 7) {
            this.e = 2;
            return this.f;
        }
        if (n2 == 6) {
            while (this.b < this.c && !this.a.b()) {
                int n3 = this.i();
                if (n3 != 0) {
                    this.f = n3 >> 3;
                    int n4 = n3 & 7;
                    if (n4 != 0) {
                        if (n4 != 1) {
                            if (n4 != 2) {
                                if (n4 != 3) {
                                    if (n4 != 4) {
                                        if (n4 == 5) {
                                            this.h = dk.d;
                                            this.e = 5;
                                            return this.f;
                                        }
                                        StringBuilder stringBuilder = new StringBuilder("Unexpected field encoding: ");
                                        stringBuilder.append(n4);
                                        throw new ProtocolException(stringBuilder.toString());
                                    }
                                    throw new ProtocolException("Unexpected end group");
                                }
                                this.a(this.f);
                                continue;
                            }
                            this.h = dk.c;
                            this.e = 2;
                            int n5 = this.i();
                            if (n5 >= 0) {
                                if (this.g == -1L) {
                                    this.g = this.c;
                                    this.c = this.b + (long)n5;
                                    if (this.c <= this.g) {
                                        return this.f;
                                    }
                                    throw new EOFException();
                                }
                                throw new IllegalStateException();
                            }
                            StringBuilder stringBuilder = new StringBuilder("Negative length: ");
                            stringBuilder.append(n5);
                            throw new ProtocolException(stringBuilder.toString());
                        }
                        this.h = dk.b;
                        this.e = 1;
                        return this.f;
                    }
                    this.h = dk.a;
                    this.e = 0;
                    return this.f;
                }
                throw new ProtocolException("Unexpected tag 0");
            }
            return -1;
        }
        illegalStateException = new IllegalStateException("Unexpected call to nextTag()");
        throw illegalStateException;
    }

    public final dk c() {
        return this.h;
    }

    public final int d() {
        int n2 = this.e;
        if (n2 != 0 && n2 != 2) {
            StringBuilder stringBuilder = new StringBuilder("Expected VARINT or LENGTH_DELIMITED but was ");
            stringBuilder.append(this.e);
            throw new ProtocolException(stringBuilder.toString());
        }
        int n3 = this.i();
        this.b(0);
        return n3;
    }

    public final long e() {
        ProtocolException protocolException;
        int n2 = this.e;
        if (n2 != 0 && n2 != 2) {
            StringBuilder stringBuilder = new StringBuilder("Expected VARINT or LENGTH_DELIMITED but was ");
            stringBuilder.append(this.e);
            throw new ProtocolException(stringBuilder.toString());
        }
        long l2 = 0L;
        for (int i2 = 0; i2 < 64; i2 += 7) {
            this.b = 1L + this.b;
            byte by2 = this.a.c();
            l2 |= (long)(by2 & 127) << i2;
            if ((by2 & 128) != 0) continue;
            this.b(0);
            return l2;
        }
        protocolException = new ProtocolException("WireInput encountered a malformed varint");
        throw protocolException;
    }

    public final int f() {
        int n2 = this.e;
        if (n2 != 5 && n2 != 2) {
            StringBuilder stringBuilder = new StringBuilder("Expected FIXED32 or LENGTH_DELIMITED but was ");
            stringBuilder.append(this.e);
            throw new ProtocolException(stringBuilder.toString());
        }
        this.a.a(4L);
        this.b = 4L + this.b;
        int n3 = this.a.e();
        this.b(5);
        return n3;
    }

    public final long g() {
        int n2 = this.e;
        if (n2 != 1 && n2 != 2) {
            StringBuilder stringBuilder = new StringBuilder("Expected FIXED64 or LENGTH_DELIMITED but was ");
            stringBuilder.append(this.e);
            throw new ProtocolException(stringBuilder.toString());
        }
        this.a.a(8L);
        this.b = 8L + this.b;
        long l2 = this.a.f();
        this.b(1);
        return l2;
    }

    final long h() {
        if (this.e == 2) {
            long l2 = this.c - this.b;
            this.a.a(l2);
            this.e = 6;
            this.b = this.c;
            this.c = this.g;
            this.g = -1L;
            return l2;
        }
        StringBuilder stringBuilder = new StringBuilder("Expected LENGTH_DELIMITED but was ");
        stringBuilder.append(this.e);
        throw new ProtocolException(stringBuilder.toString());
    }
}


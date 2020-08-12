/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.InputStream
 *  java.lang.Object
 *  java.util.Collections
 *  java.util.List
 */
package com.tappx.b.a;

import com.tappx.b.g;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

public final class k {
    private final int a;
    private final List<g> b;
    private final int c;
    private final InputStream d;

    public k(int n2, List<g> list) {
        this(n2, list, -1, null);
    }

    public k(int n2, List<g> list, int n3, InputStream inputStream) {
        this.a = n2;
        this.b = list;
        this.c = n3;
        this.d = inputStream;
    }

    public final int a() {
        return this.a;
    }

    public final List<g> b() {
        return Collections.unmodifiableList(this.b);
    }

    public final int c() {
        return this.c;
    }

    public final InputStream d() {
        return this.d;
    }
}


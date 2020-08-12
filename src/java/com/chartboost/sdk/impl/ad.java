/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 *  java.util.concurrent.atomic.AtomicInteger
 */
package com.chartboost.sdk.impl;

import com.chartboost.sdk.Model.CBError;
import com.chartboost.sdk.impl.ae;
import com.chartboost.sdk.impl.af;
import com.chartboost.sdk.impl.ag;
import java.io.File;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class ad<T> {
    public final String b;
    public final String c;
    public final int d;
    public final AtomicInteger e;
    public final File f;
    public long g;
    public long h;
    public long i;
    public int j;

    public ad(String string, String string2, int n2, File file) {
        this.b = string;
        this.c = string2;
        this.d = n2;
        this.e = new AtomicInteger();
        this.f = file;
        this.g = 0L;
        this.h = 0L;
        this.i = 0L;
        this.j = 0;
    }

    public ae a() {
        return new ae(null, null, null);
    }

    public af<T> a(ag ag2) {
        return af.a(null);
    }

    public void a(CBError cBError, ag ag2) {
    }

    public void a(T t2, ag ag2) {
    }

    public boolean b() {
        return this.e.compareAndSet(0, -1);
    }
}


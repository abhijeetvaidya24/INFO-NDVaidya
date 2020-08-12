/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.tapjoy.internal.hu
 *  java.io.Closeable
 *  java.io.Flushable
 *  java.lang.Object
 */
package com.tapjoy.internal;

import com.tapjoy.internal.hu;
import java.io.Closeable;
import java.io.Flushable;

public interface ie
extends Closeable,
Flushable {
    public void a(hu var1, long var2);

    public void close();

    public void flush();
}


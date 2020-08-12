/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.ref.Reference
 *  java.lang.ref.ReferenceQueue
 */
package com.tapjoy.internal;

import com.tapjoy.internal.cb;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

public final class cc
extends ReferenceQueue {
    public final cb a() {
        return (cb)super.poll();
    }
}


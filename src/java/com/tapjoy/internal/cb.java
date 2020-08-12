/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.ref.ReferenceQueue
 *  java.lang.ref.WeakReference
 */
package com.tapjoy.internal;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public final class cb
extends WeakReference {
    public final Object a;

    public cb(Object object, Object object2, ReferenceQueue referenceQueue) {
        super(object2, referenceQueue);
        this.a = object;
    }
}


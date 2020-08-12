/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.chartboost.sdk.impl;

import com.chartboost.sdk.Model.CBError;

public class af<T> {
    public final T a;
    public final CBError b;

    private af(T t2, CBError cBError) {
        this.a = t2;
        this.b = cBError;
    }

    public static <T> af<T> a(CBError cBError) {
        return new af<Object>(null, cBError);
    }

    public static <T> af<T> a(T t2) {
        return new af<T>(t2, null);
    }
}


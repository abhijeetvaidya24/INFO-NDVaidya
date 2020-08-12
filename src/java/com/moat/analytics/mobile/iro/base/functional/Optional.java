/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.NoSuchElementException
 */
package com.moat.analytics.mobile.iro.base.functional;

import java.util.NoSuchElementException;

public final class Optional<T> {
    private static final Optional<?> \u02cf = new Optional<T>();
    private final T \u02cb;

    private Optional() {
        this.\u02cb = null;
    }

    private Optional(T t2) {
        if (t2 != null) {
            this.\u02cb = t2;
            return;
        }
        throw new NullPointerException("Optional of null value.");
    }

    public static <T> Optional<T> empty() {
        return \u02cf;
    }

    public static <T> Optional<T> of(T t2) {
        return new Optional<T>(t2);
    }

    public static <T> Optional<T> ofNullable(T t2) {
        if (t2 == null) {
            return Optional.empty();
        }
        return Optional.of(t2);
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Optional)) {
            return false;
        }
        Optional optional = (Optional)object;
        T t2 = this.\u02cb;
        T t3 = optional.\u02cb;
        if (t2 != t3) {
            return t2 != null && t3 != null && t2.equals(t3);
        }
        return true;
    }

    public final T get() {
        T t2 = this.\u02cb;
        if (t2 != null) {
            return t2;
        }
        throw new NoSuchElementException("No value present");
    }

    public final int hashCode() {
        T t2 = this.\u02cb;
        if (t2 == null) {
            return 0;
        }
        return t2.hashCode();
    }

    public final boolean isPresent() {
        return this.\u02cb != null;
    }

    public final T orElse(T t2) {
        T t3 = this.\u02cb;
        if (t3 != null) {
            return t3;
        }
        return t2;
    }

    public final String toString() {
        T t2 = this.\u02cb;
        if (t2 != null) {
            return String.format((String)"Optional[%s]", (Object[])new Object[]{t2});
        }
        return "Optional.empty";
    }
}


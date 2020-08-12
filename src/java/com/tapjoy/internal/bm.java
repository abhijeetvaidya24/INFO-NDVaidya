/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.StringWriter
 *  java.io.Writer
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collection
 *  java.util.Map
 */
package com.tapjoy.internal;

import com.tapjoy.internal.bq;
import com.tapjoy.internal.by;
import com.tapjoy.internal.cu;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Collection;
import java.util.Map;

public final class bm
implements bq {
    private final StringWriter a = new StringWriter();
    private final by b = new by((Writer)this.a);

    public static String a(Object object) {
        return new bm().b(object).toString();
    }

    private bm b(Object object) {
        try {
            this.b.a(object);
            return this;
        }
        catch (IOException iOException) {
            throw cu.a(iOException);
        }
    }

    public final bm a() {
        try {
            this.b.a();
            return this;
        }
        catch (IOException iOException) {
            throw cu.a(iOException);
        }
    }

    public final bm a(long l2) {
        try {
            this.b.a(l2);
            return this;
        }
        catch (IOException iOException) {
            throw cu.a(iOException);
        }
    }

    public final bm a(bq bq2) {
        try {
            this.b.a(bq2);
            return this;
        }
        catch (IOException iOException) {
            throw cu.a(iOException);
        }
    }

    public final bm a(Number number) {
        try {
            this.b.a(number);
            return this;
        }
        catch (IOException iOException) {
            throw cu.a(iOException);
        }
    }

    public final bm a(String string) {
        try {
            this.b.a(string);
            return this;
        }
        catch (IOException iOException) {
            throw cu.a(iOException);
        }
    }

    public final bm a(Collection collection) {
        try {
            this.b.a(collection);
            return this;
        }
        catch (IOException iOException) {
            throw cu.a(iOException);
        }
    }

    public final bm a(Map map) {
        try {
            this.b.a(map);
            return this;
        }
        catch (IOException iOException) {
            throw cu.a(iOException);
        }
    }

    @Override
    public final void a(Writer writer) {
        try {
            this.b.a.flush();
            writer.write(this.a.toString());
            return;
        }
        catch (IOException iOException) {
            throw cu.a(iOException);
        }
    }

    public final bm b() {
        try {
            this.b.b();
            return this;
        }
        catch (IOException iOException) {
            throw cu.a(iOException);
        }
    }

    public final bm b(String string) {
        try {
            this.b.b(string);
            return this;
        }
        catch (IOException iOException) {
            throw cu.a(iOException);
        }
    }

    public final bm c() {
        try {
            this.b.c();
            return this;
        }
        catch (IOException iOException) {
            throw cu.a(iOException);
        }
    }

    public final bm d() {
        try {
            this.b.d();
            return this;
        }
        catch (IOException iOException) {
            throw cu.a(iOException);
        }
    }

    public final String toString() {
        try {
            this.b.a.flush();
            String string = this.a.toString();
            return string;
        }
        catch (IOException iOException) {
            throw cu.a(iOException);
        }
    }
}


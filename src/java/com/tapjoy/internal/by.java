/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Closeable
 *  java.io.IOException
 *  java.io.Writer
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Double
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Long
 *  java.lang.NoSuchFieldError
 *  java.lang.NullPointerException
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Date
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
package com.tapjoy.internal;

import com.tapjoy.internal.bq;
import com.tapjoy.internal.bv;
import com.tapjoy.internal.bw;
import com.tapjoy.internal.z;
import java.io.Closeable;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class by
implements Closeable {
    final Writer a;
    private final List b = new ArrayList();
    private String c;
    private String d;
    private boolean e;

    public by(Writer writer) {
        this.b.add((Object)bv.f);
        this.d = ":";
        if (writer != null) {
            this.a = writer;
            return;
        }
        throw new NullPointerException("out == null");
    }

    private by a(bv bv2, bv bv3, String string2) {
        bv bv4 = this.e();
        if (bv4 != bv3 && bv4 != bv2) {
            StringBuilder stringBuilder = new StringBuilder("Nesting problem: ");
            stringBuilder.append((Object)this.b);
            throw new IllegalStateException(stringBuilder.toString());
        }
        List list = this.b;
        list.remove(-1 + list.size());
        if (bv4 == bv3) {
            this.g();
        }
        this.a.write(string2);
        return this;
    }

    private by a(bv bv2, String string2) {
        this.a(true);
        this.b.add((Object)bv2);
        this.a.write(string2);
        return this;
    }

    private by a(Object[] arrobject) {
        if (arrobject == null) {
            return this.f();
        }
        this.a();
        int n2 = arrobject.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            this.a(arrobject[i2]);
        }
        this.b();
        return this;
    }

    private void a(bv bv2) {
        List list = this.b;
        list.set(-1 + list.size(), (Object)bv2);
    }

    private void a(boolean bl2) {
        int n2 = 1.a[this.e().ordinal()];
        if (n2 != 1) {
            if (n2 != 2) {
                if (n2 != 3) {
                    if (n2 != 4) {
                        if (n2 != 5) {
                            StringBuilder stringBuilder = new StringBuilder("Nesting problem: ");
                            stringBuilder.append((Object)this.b);
                            throw new IllegalStateException(stringBuilder.toString());
                        }
                        throw new IllegalStateException("JSON must have only one top-level value.");
                    }
                    this.a.append((CharSequence)this.d);
                    this.a(bv.e);
                    return;
                }
                this.a.append(',');
                this.g();
                return;
            }
            this.a(bv.b);
            this.g();
            return;
        }
        if (!this.e && !bl2) {
            throw new IllegalStateException("JSON must start with an array or an object.");
        }
        this.a(bv.g);
    }

    private void c(String string2) {
        this.a.write("\"");
        int n2 = string2.length();
        for (int i2 = 0; i2 < n2; ++i2) {
            block7 : {
                block8 : {
                    char c2;
                    block11 : {
                        block9 : {
                            block10 : {
                                c2 = string2.charAt(i2);
                                if (c2 == '\f') break block7;
                                if (c2 == '\r') break block8;
                                if (c2 == '\"' || c2 == '\\') break block9;
                                if (c2 == '\u2028' || c2 == '\u2029') break block10;
                                switch (c2) {
                                    default: {
                                        if (c2 <= '\u001f') {
                                            Writer writer = this.a;
                                            Object[] arrobject = new Object[]{(int)c2};
                                            writer.write(String.format((String)"\\u%04x", (Object[])arrobject));
                                            break;
                                        }
                                        break block11;
                                    }
                                    case '\n': {
                                        this.a.write("\\n");
                                        break;
                                    }
                                    case '\t': {
                                        this.a.write("\\t");
                                        break;
                                    }
                                    case '\b': {
                                        this.a.write("\\b");
                                        break;
                                    }
                                }
                                continue;
                            }
                            Writer writer = this.a;
                            Object[] arrobject = new Object[]{(int)c2};
                            writer.write(String.format((String)"\\u%04x", (Object[])arrobject));
                            continue;
                        }
                        this.a.write(92);
                    }
                    this.a.write((int)c2);
                    continue;
                }
                this.a.write("\\r");
                continue;
            }
            this.a.write("\\f");
        }
        this.a.write("\"");
    }

    private bv e() {
        List list = this.b;
        return (bv)((Object)list.get(-1 + list.size()));
    }

    private by f() {
        this.a(false);
        this.a.write("null");
        return this;
    }

    private void g() {
        if (this.c == null) {
            return;
        }
        this.a.write("\n");
        for (int i2 = 1; i2 < this.b.size(); ++i2) {
            this.a.write(this.c);
        }
    }

    public final by a() {
        return this.a(bv.a, "[");
    }

    public final by a(long l2) {
        this.a(false);
        this.a.write(Long.toString((long)l2));
        return this;
    }

    public final by a(bq bq2) {
        this.a(false);
        bq2.a(this.a);
        return this;
    }

    public final by a(Number number) {
        if (number == null) {
            return this.f();
        }
        String string2 = number.toString();
        if (!this.e && (string2.equals((Object)"-Infinity") || string2.equals((Object)"Infinity") || string2.equals((Object)"NaN"))) {
            StringBuilder stringBuilder = new StringBuilder("Numeric values must be finite, but was ");
            stringBuilder.append((Object)number);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        this.a(false);
        this.a.append((CharSequence)string2);
        return this;
    }

    public final by a(Object object) {
        if (object == null) {
            return this.f();
        }
        if (object instanceof bw) {
            int n2 = this.b.size();
            if (this.b.size() == n2) {
                return this;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(object.getClass().getName());
            stringBuilder.append(".writeToJson(JsonWriter) wrote incomplete value");
            throw new IllegalStateException(stringBuilder.toString());
        }
        if (object instanceof Boolean) {
            boolean bl2 = (Boolean)object;
            this.a(false);
            Writer writer = this.a;
            String string2 = bl2 ? "true" : "false";
            writer.write(string2);
            return this;
        }
        if (object instanceof Number) {
            if (object instanceof Long) {
                return this.a(((Number)object).longValue());
            }
            if (object instanceof Double) {
                double d2 = ((Number)object).doubleValue();
                if (!this.e && (Double.isNaN((double)d2) || Double.isInfinite((double)d2))) {
                    StringBuilder stringBuilder = new StringBuilder("Numeric values must be finite, but was ");
                    stringBuilder.append(d2);
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
                this.a(false);
                this.a.append((CharSequence)Double.toString((double)d2));
                return this;
            }
            return this.a((Number)object);
        }
        if (object instanceof String) {
            return this.b((String)object);
        }
        if (object instanceof bq) {
            return this.a((bq)object);
        }
        if (object instanceof Collection) {
            return this.a((Collection)object);
        }
        if (object instanceof Map) {
            return this.a((Map)object);
        }
        if (object instanceof Date) {
            Date date = (Date)object;
            if (date == null) {
                return this.f();
            }
            return this.b(z.a(date));
        }
        if (object instanceof Object[]) {
            return this.a((Object[])object);
        }
        StringBuilder stringBuilder = new StringBuilder("Unknown type: ");
        stringBuilder.append(object.getClass().getName());
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public final by a(String string2) {
        block2 : {
            block5 : {
                block4 : {
                    bv bv2;
                    block3 : {
                        if (string2 == null) break block2;
                        bv2 = this.e();
                        if (bv2 != bv.e) break block3;
                        this.a.write(44);
                        break block4;
                    }
                    if (bv2 != bv.c) break block5;
                }
                this.g();
                this.a(bv.d);
                this.c(string2);
                return this;
            }
            StringBuilder stringBuilder = new StringBuilder("Nesting problem: ");
            stringBuilder.append((Object)this.b);
            throw new IllegalStateException(stringBuilder.toString());
        }
        throw new NullPointerException("name == null");
    }

    public final by a(Collection collection) {
        if (collection == null) {
            return this.f();
        }
        this.a();
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            this.a(iterator.next());
        }
        this.b();
        return this;
    }

    public final by a(Map map) {
        if (map == null) {
            return this.f();
        }
        this.c();
        for (Map.Entry entry : map.entrySet()) {
            this.a(String.valueOf((Object)entry.getKey()));
            this.a(entry.getValue());
        }
        this.d();
        return this;
    }

    public final by b() {
        return this.a(bv.a, bv.b, "]");
    }

    public final by b(String string2) {
        if (string2 == null) {
            return this.f();
        }
        this.a(false);
        this.c(string2);
        return this;
    }

    public final by c() {
        return this.a(bv.c, "{");
    }

    public final void close() {
        this.a.close();
        if (this.e() == bv.g) {
            return;
        }
        throw new IOException("Incomplete document");
    }

    public final by d() {
        return this.a(bv.c, bv.e, "}");
    }

}


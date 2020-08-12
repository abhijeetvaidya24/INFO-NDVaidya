/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.tapjoy.internal.bt
 *  java.io.ByteArrayInputStream
 *  java.io.InputStream
 *  java.io.InputStreamReader
 *  java.io.Reader
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.Readable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.net.URI
 *  java.net.URISyntaxException
 *  java.net.URL
 *  java.nio.charset.Charset
 *  java.util.HashMap
 *  java.util.LinkedHashMap
 *  java.util.LinkedList
 *  java.util.List
 *  java.util.Map
 */
package com.tapjoy.internal;

import com.tapjoy.internal.bn;
import com.tapjoy.internal.bp;
import com.tapjoy.internal.bs;
import com.tapjoy.internal.bt;
import com.tapjoy.internal.bu;
import com.tapjoy.internal.bx;
import com.tapjoy.internal.ca;
import com.tapjoy.internal.cn;
import com.tapjoy.internal.cp;
import com.tapjoy.internal.db;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public abstract class bs
implements bp,
bu {
    private HashMap a;

    public static bs a(InputStream inputStream) {
        return a.a().a(inputStream);
    }

    private void a(List list) {
        this.f();
        while (this.j()) {
            list.add(this.u());
        }
        this.g();
    }

    public static bs b(String string) {
        return a.a().a(string);
    }

    private static URI d(String string) {
        try {
            URI uRI = new URI(string);
            return uRI;
        }
        catch (URISyntaxException uRISyntaxException) {
            throw new ca(uRISyntaxException);
        }
    }

    private boolean t() {
        if (this.k() == bx.i) {
            this.o();
            return true;
        }
        return false;
    }

    private Object u() {
        bx bx2 = this.k();
        switch (1.a[bx2.ordinal()]) {
            default: {
                StringBuilder stringBuilder = new StringBuilder("Expected a value but was ");
                stringBuilder.append((Object)bx2);
                throw new IllegalStateException(stringBuilder.toString());
            }
            case 6: {
                return this.m();
            }
            case 5: {
                return new cn(this.m());
            }
            case 4: {
                return this.n();
            }
            case 3: {
                this.o();
                return null;
            }
            case 2: {
                return this.d();
            }
            case 1: 
        }
        return this.c();
    }

    public final Object a(bn bn2) {
        if (this.t()) {
            return null;
        }
        return bn2.a(this);
    }

    @Override
    public final Object a(String string) {
        HashMap hashMap = this.a;
        if (hashMap != null) {
            return hashMap.get((Object)string);
        }
        return null;
    }

    @Override
    public final void a(String string, Object object) {
        if (this.a == null) {
            this.a = new HashMap();
        }
        this.a.put((Object)string, object);
    }

    public final void a(List list, bn bn2) {
        this.f();
        while (this.j()) {
            list.add(bn2.a(this));
        }
        this.g();
    }

    public final void a(Map map) {
        this.h();
        while (this.j()) {
            map.put((Object)this.l(), this.u());
        }
        this.i();
    }

    public final boolean a() {
        return this.k() == bx.c;
    }

    public final String b() {
        if (this.t()) {
            return null;
        }
        return this.m();
    }

    public final String c(String string) {
        if (this.t()) {
            return string;
        }
        return this.m();
    }

    public final List c() {
        LinkedList linkedList = new LinkedList();
        this.a((List)linkedList);
        return linkedList;
    }

    public final Map d() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.a((Map)linkedHashMap);
        return linkedHashMap;
    }

    public final URL e() {
        URI uRI = (URI)this.a("BASE_URI");
        if (uRI != null) {
            return uRI.resolve(bs.d(this.m())).toURL();
        }
        return new URL(this.m());
    }

}


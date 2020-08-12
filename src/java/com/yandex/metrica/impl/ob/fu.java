/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.UnsupportedEncodingException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.net.URLEncoder
 *  java.util.Collections
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.fr;
import com.yandex.metrica.impl.ob.ft;
import com.yandex.metrica.impl.ob.fw;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

public abstract class fu<T> {
    private final int a;
    private final String b;
    private fw c;
    private volatile b<T> d;
    private volatile a e;

    public fu(int n2, String string2) {
        this.a = n2;
        this.b = string2;
        this.a(new fw());
    }

    private static byte[] a(Map<String, String> map, String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            for (Map.Entry entry : map.entrySet()) {
                stringBuilder.append(URLEncoder.encode((String)((String)entry.getKey()), (String)string2));
                stringBuilder.append('=');
                stringBuilder.append(URLEncoder.encode((String)((String)entry.getValue()), (String)string2));
                stringBuilder.append('&');
            }
            byte[] arrby = stringBuilder.toString().getBytes(string2);
            return arrby;
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            RuntimeException runtimeException;
            StringBuilder stringBuilder2 = new StringBuilder("Encoding not supported: ");
            stringBuilder2.append(string2);
            runtimeException = new RuntimeException(stringBuilder2.toString(), (Throwable)unsupportedEncodingException);
            throw runtimeException;
        }
    }

    public fu<?> a(fw fw2) {
        this.c = fw2;
        return this;
    }

    public String a() {
        return this.b;
    }

    protected void a(a a2) {
        this.e = a2;
    }

    protected void a(b<T> b2) {
        this.d = b2;
    }

    protected abstract T b(ft var1) throws fr;

    public Map<String, String> b() throws fr {
        return Collections.emptyMap();
    }

    public byte[] c() throws fr {
        Map<String, String> map = this.k();
        if (map != null && map.size() > 0) {
            return fu.a(map, this.l());
        }
        return null;
    }

    public int d() {
        return this.a;
    }

    protected b<T> e() {
        return this.d;
    }

    protected a f() {
        return this.e;
    }

    protected Map<String, String> g() throws fr {
        return this.k();
    }

    protected String h() {
        return this.l();
    }

    public String i() {
        return this.m();
    }

    public byte[] j() throws fr {
        Map<String, String> map = this.g();
        if (map != null && map.size() > 0) {
            return fu.a(map, this.h());
        }
        return null;
    }

    protected Map<String, String> k() throws fr {
        return null;
    }

    protected String l() {
        return "UTF-8";
    }

    public String m() {
        StringBuilder stringBuilder = new StringBuilder("application/x-www-form-urlencoded; charset=");
        stringBuilder.append(this.l());
        return stringBuilder.toString();
    }

    public final int n() {
        return this.c.a();
    }

    public fw o() {
        return this.c;
    }

    public static interface a {
        public void a(fr var1);
    }

    public static interface b<T> {
        public void a(T var1);
    }

}


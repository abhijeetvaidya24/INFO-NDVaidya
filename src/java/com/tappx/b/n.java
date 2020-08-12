/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.os.Handler
 *  android.os.Looper
 *  android.text.TextUtils
 *  com.tappx.b.e
 *  java.io.UnsupportedEncodingException
 *  java.lang.CharSequence
 *  java.lang.Comparable
 *  java.lang.Deprecated
 *  java.lang.Enum
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.net.URLEncoder
 *  java.util.Collections
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
package com.tappx.b;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tappx.b.b;
import com.tappx.b.e;
import com.tappx.b.k;
import com.tappx.b.o;
import com.tappx.b.p;
import com.tappx.b.r;
import com.tappx.b.u;
import com.tappx.b.v;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

public abstract class n<T>
implements Comparable<n<T>> {
    private static final String a = "UTF-8";
    private final v.a b;
    private final int c;
    private final String d;
    private final int e;
    private final Object f;
    private p.a g;
    private Integer h;
    private o i;
    private boolean j;
    private boolean k;
    private boolean l;
    private boolean m;
    private r n;
    private b.a o;
    private Object p;
    private b q;

    public n(int n2, String string2, p.a a2) {
        v.a a3 = v.a.a ? new v.a() : null;
        this.b = a3;
        this.f = new Object();
        this.j = true;
        this.k = false;
        this.l = false;
        this.m = false;
        this.o = null;
        this.c = n2;
        this.d = string2;
        this.g = a2;
        this.a((r)new e());
        this.e = n.c(string2);
    }

    @Deprecated
    public n(String string2, p.a a2) {
        this(-1, string2, a2);
    }

    private byte[] a(Map<String, String> map, String string2) {
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
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Encoding not supported: ");
            stringBuilder2.append(string2);
            runtimeException = new RuntimeException(stringBuilder2.toString(), (Throwable)unsupportedEncodingException);
            throw runtimeException;
        }
    }

    private static int c(String string2) {
        String string3;
        Uri uri;
        if (!TextUtils.isEmpty((CharSequence)string2) && (uri = Uri.parse((String)string2)) != null && (string3 = uri.getHost()) != null) {
            return string3.hashCode();
        }
        return 0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean A() {
        Object object;
        Object object2 = object = this.f;
        synchronized (object2) {
            return this.l;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    void B() {
        Object object;
        Object object2 = object = this.f;
        // MONITORENTER : object2
        b b2 = this.q;
        // MONITOREXIT : object2
        if (b2 == null) return;
        b2.a(this);
    }

    public int a(n<T> n2) {
        c c2;
        c c3 = this.e();
        if (c3 == (c2 = n2.e())) {
            return this.h - n2.h;
        }
        return c2.ordinal() - c3.ordinal();
    }

    public final n<?> a(int n2) {
        this.h = n2;
        return this;
    }

    public n<?> a(b.a a2) {
        this.o = a2;
        return this;
    }

    public n<?> a(o o2) {
        this.i = o2;
        return this;
    }

    public n<?> a(r r2) {
        this.n = r2;
        return this;
    }

    public final n<?> a(boolean bl) {
        this.j = bl;
        return this;
    }

    protected abstract p<T> a(k var1);

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    void a(b b2) {
        Object object;
        Object object2 = object = this.f;
        synchronized (object2) {
            this.q = b2;
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    void a(p<?> p2) {
        Object object;
        Object object2 = object = this.f;
        // MONITORENTER : object2
        b b2 = this.q;
        // MONITOREXIT : object2
        if (b2 == null) return;
        b2.a(this, p2);
    }

    protected abstract void a(T var1);

    public void a(String string2) {
        if (v.a.a) {
            this.b.a(string2, Thread.currentThread().getId());
        }
    }

    public byte[] a() {
        Map<String, String> map = this.s();
        if (map != null && map.size() > 0) {
            return this.a(map, this.t());
        }
        return null;
    }

    public n<?> b(Object object) {
        this.p = object;
        return this;
    }

    public final n<?> b(boolean bl) {
        this.m = bl;
        return this;
    }

    protected u b(u u2) {
        return u2;
    }

    void b(final String string2) {
        o o2 = this.i;
        if (o2 != null) {
            o2.b(this);
        }
        if (v.a.a) {
            final long l2 = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new Runnable(){

                    public void run() {
                        n.this.b.a(string2, l2);
                        n.this.b.a(this.toString());
                    }
                });
                return;
            }
            this.b.a(string2, l2);
            this.b.a(this.toString());
        }
    }

    @Deprecated
    public byte[] b() {
        Map<String, String> map = this.p();
        if (map != null && map.size() > 0) {
            return this.a(map, this.q());
        }
        return null;
    }

    public Map<String, String> c() {
        return Collections.emptyMap();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void c(u u2) {
        Object object;
        Object object2 = object = this.f;
        // MONITORENTER : object2
        p.a a2 = this.g;
        // MONITOREXIT : object2
        if (a2 == null) return;
        a2.a(u2);
    }

    public /* synthetic */ int compareTo(Object object) {
        return this.a((n)object);
    }

    public c e() {
        return c.b;
    }

    public int f() {
        return this.c;
    }

    public Object g() {
        return this.p;
    }

    public p.a h() {
        return this.g;
    }

    public int i() {
        return this.e;
    }

    public final int j() {
        Integer n2 = this.h;
        if (n2 != null) {
            return n2;
        }
        throw new IllegalStateException("getSequence called before setSequence");
    }

    public String k() {
        return this.d;
    }

    public String l() {
        return this.k();
    }

    public b.a m() {
        return this.o;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void n() {
        Object object;
        Object object2 = object = this.f;
        synchronized (object2) {
            this.k = true;
            this.g = null;
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean o() {
        Object object;
        Object object2 = object = this.f;
        synchronized (object2) {
            return this.k;
        }
    }

    @Deprecated
    protected Map<String, String> p() {
        return this.s();
    }

    @Deprecated
    protected String q() {
        return this.t();
    }

    @Deprecated
    public String r() {
        return this.u();
    }

    protected Map<String, String> s() {
        return null;
    }

    protected String t() {
        return "UTF-8";
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("0x");
        stringBuilder.append(Integer.toHexString((int)this.i()));
        String string2 = stringBuilder.toString();
        StringBuilder stringBuilder2 = new StringBuilder();
        String string3 = this.k ? "[X] " : "[ ] ";
        stringBuilder2.append(string3);
        stringBuilder2.append(this.k());
        stringBuilder2.append(" ");
        stringBuilder2.append(string2);
        stringBuilder2.append(" ");
        stringBuilder2.append((Object)((Object)this.e()));
        stringBuilder2.append(" ");
        stringBuilder2.append((Object)this.h);
        return stringBuilder2.toString();
    }

    public String u() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("application/x-www-form-urlencoded; charset=");
        stringBuilder.append(this.t());
        return stringBuilder.toString();
    }

    public final boolean v() {
        return this.j;
    }

    public final boolean w() {
        return this.m;
    }

    public final int x() {
        return this.n.a();
    }

    public r y() {
        return this.n;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void z() {
        Object object;
        Object object2 = object = this.f;
        synchronized (object2) {
            this.l = true;
            return;
        }
    }

    public static interface a {
        public static final int a = -1;
        public static final int b = 0;
        public static final int c = 1;
        public static final int d = 2;
        public static final int e = 3;
        public static final int f = 4;
        public static final int g = 5;
        public static final int h = 6;
        public static final int i = 7;
    }

    static interface b {
        public void a(n<?> var1);

        public void a(n<?> var1, p<?> var2);
    }

    public static final class c
    extends Enum<c> {
        public static final /* enum */ c a = new c();
        public static final /* enum */ c b = new c();
        public static final /* enum */ c c = new c();
        public static final /* enum */ c d = new c();
        private static final /* synthetic */ c[] e;

        static {
            c[] arrc = new c[]{a, b, c, d};
            e = arrc;
        }

        public static c valueOf(String string2) {
            return (c)Enum.valueOf(c.class, (String)string2);
        }

        public static c[] values() {
            return (c[])e.clone();
        }
    }

}


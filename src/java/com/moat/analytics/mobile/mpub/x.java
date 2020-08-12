/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.moat.analytics.mobile.mpub.x$1
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.ClassLoader
 *  java.lang.Double
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.ref.WeakReference
 *  java.lang.reflect.InvocationHandler
 *  java.lang.reflect.Method
 *  java.lang.reflect.Proxy
 *  java.util.LinkedList
 *  java.util.Map
 */
package com.moat.analytics.mobile.mpub;

import com.moat.analytics.mobile.mpub.m;
import com.moat.analytics.mobile.mpub.p;
import com.moat.analytics.mobile.mpub.w;
import com.moat.analytics.mobile.mpub.x;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.LinkedList;
import java.util.Map;

class x<T>
implements InvocationHandler {
    private static final Object[] a = new Object[0];
    private final a<T> b;
    private final Class<T> c;
    private final LinkedList<x<T>> d;
    private boolean e;
    private T f;

    x(a<T> a2, Class<T> class_) {
        com.moat.analytics.mobile.mpub.a.a.a.a(a2);
        com.moat.analytics.mobile.mpub.a.a.a.a(class_);
        this.b = a2;
        this.c = class_;
        this.d = new LinkedList();
        w.a().a((w.b)new 1(this));
    }

    static <T> T a(a<T> a2, Class<T> class_) {
        ClassLoader classLoader = class_.getClassLoader();
        x<T> x2 = new x<T>(a2, class_);
        return (T)Proxy.newProxyInstance((ClassLoader)classLoader, (Class[])new Class[]{class_}, x2);
    }

    private Object a(Method method) {
        try {
            if (Boolean.TYPE.equals((Object)method.getReturnType())) {
                Boolean bl2 = true;
                return bl2;
            }
        }
        catch (Exception exception) {
            m.a(exception);
        }
        return null;
    }

    private Object a(Method method, Object[] arrobject) {
        Class class_ = method.getDeclaringClass();
        w w2 = w.a();
        if (Object.class.equals((Object)class_)) {
            String string2 = method.getName();
            if ("getClass".equals((Object)string2)) {
                return this.c;
            }
            if ("toString".equals((Object)string2)) {
                Object object = method.invoke((Object)this, arrobject);
                String string3 = x.class.getName();
                String string4 = this.c.getName();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(object);
                stringBuilder.append("");
                return stringBuilder.toString().replace((CharSequence)string3, (CharSequence)string4);
            }
            return method.invoke((Object)this, arrobject);
        }
        if (this.e && this.f == null) {
            this.d.clear();
            return this.a(method);
        }
        if (w2.a == w.d.b) {
            this.c();
            T t2 = this.f;
            if (t2 != null) {
                return method.invoke(t2, arrobject);
            }
        }
        if (!(w2.a != w.d.a || this.e && this.f == null)) {
            this.b(method, arrobject);
        }
        return this.a(method);
    }

    static /* synthetic */ void a(x x2) {
        x2.c();
    }

    private void b() {
        if (!this.e) {
            try {
                this.f = this.b.a().c(null);
            }
            catch (Exception exception) {
                p.a("OnOffTrackerProxy", this, "Could not create instance", exception);
                m.a(exception);
            }
            this.e = true;
        }
    }

    private void b(Method method, Object[] arrobject) {
        if (this.d.size() >= 15) {
            this.d.remove(5);
        }
        this.d.add((Object)new b(method, arrobject));
    }

    private void c() {
        this.b();
        if (this.f == null) {
            return;
        }
        for (b b2 : this.d) {
            Object[] arrobject = new Object[b2.b.length];
            WeakReference[] arrweakReference = b2.b;
            int n2 = arrweakReference.length;
            int n3 = 0;
            for (int i2 = 0; i2 < n2; ++i2) {
                WeakReference weakReference = arrweakReference[i2];
                int n4 = n3 + 1;
                arrobject[n3] = weakReference.get();
                n3 = n4;
            }
            try {
                b2.d.invoke(this.f, arrobject);
            }
            catch (Exception exception) {
                m.a(exception);
            }
        }
        this.d.clear();
    }

    public Object invoke(Object object, Method method, Object[] arrobject) {
        try {
            Object object2 = this.a(method, arrobject);
            return object2;
        }
        catch (Exception exception) {
            m.a(exception);
            return this.a(method);
        }
    }

    static interface a<T> {
        public com.moat.analytics.mobile.mpub.a.b.a<T> a();
    }

    private class b {
        private final WeakReference[] b;
        private final LinkedList<Object> c = new LinkedList();
        private final Method d;

        private /* varargs */ b(Method method, Object ... arrobject) {
            if (arrobject == null) {
                arrobject = a;
            }
            WeakReference[] arrweakReference = new WeakReference[arrobject.length];
            int n2 = arrobject.length;
            int n3 = 0;
            for (int i2 = 0; i2 < n2; ++i2) {
                Object object = arrobject[i2];
                if (object instanceof Map || object instanceof Integer || object instanceof Double) {
                    this.c.add(object);
                }
                int n4 = n3 + 1;
                arrweakReference[n3] = new WeakReference(object);
                n3 = n4;
            }
            this.b = arrweakReference;
            this.d = method;
        }
    }

}


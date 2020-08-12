/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.moat.analytics.mobile.iro.s$1
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.ClassLoader
 *  java.lang.Double
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.ref.WeakReference
 *  java.lang.reflect.InvocationHandler
 *  java.lang.reflect.Method
 *  java.lang.reflect.Proxy
 *  java.util.LinkedList
 *  java.util.Map
 */
package com.moat.analytics.mobile.iro;

import com.moat.analytics.mobile.iro.b;
import com.moat.analytics.mobile.iro.base.asserts.Asserts;
import com.moat.analytics.mobile.iro.base.functional.Optional;
import com.moat.analytics.mobile.iro.o;
import com.moat.analytics.mobile.iro.s;
import com.moat.analytics.mobile.iro.t;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.LinkedList;
import java.util.Map;

class s<T>
implements InvocationHandler {
    private static final Object[] \u02ca = new Object[0];
    private final LinkedList<s<T>> \u02cb;
    private final Class<T> \u02ce;
    private boolean \u02cf;
    private final a<T> \u0971;
    private T \u141d;

    private s(a<T> a2, Class<T> class_) throws o {
        Asserts.checkNotNull(a2);
        Asserts.checkNotNull(class_);
        this.\u0971 = a2;
        this.\u02ce = class_;
        this.\u02cb = new LinkedList();
        t.\u02cb().\u0971((t.a)new 1(this));
    }

    private static Boolean \u02ca(Method method) {
        try {
            if (Boolean.TYPE.equals((Object)method.getReturnType())) {
                Boolean bl2 = true;
                return bl2;
            }
        }
        catch (Exception exception) {
            o.\u0971(exception);
        }
        return null;
    }

    static <T> T \u02ca(a<T> a2, Class<T> class_) throws o {
        ClassLoader classLoader = class_.getClassLoader();
        s<T> s2 = new s<T>(a2, class_);
        return (T)Proxy.newProxyInstance((ClassLoader)classLoader, (Class[])new Class[]{class_}, s2);
    }

    private void \u02cb() throws o {
        if (!this.\u02cf) {
            try {
                this.\u141d = this.\u0971.\u02cf().orElse(null);
            }
            catch (Exception exception) {
                b.\u02ca("OnOffTrackerProxy", this, "Could not create instance", exception);
                o.\u0971(exception);
            }
            this.\u02cf = true;
        }
        if (this.\u141d == null) {
            return;
        }
        for (e e2 : this.\u02cb) {
            Object[] arrobject = new Object[e2.\u02ce.length];
            WeakReference[] arrweakReference = e2.\u02ce;
            int n2 = arrweakReference.length;
            int n3 = 0;
            for (int i2 = 0; i2 < n2; ++i2) {
                WeakReference weakReference = arrweakReference[i2];
                int n4 = n3 + 1;
                arrobject[n3] = weakReference.get();
                n3 = n4;
            }
            try {
                e2.\u02ca.invoke(this.\u141d, arrobject);
            }
            catch (Exception exception) {
                o.\u0971(exception);
            }
        }
        this.\u02cb.clear();
    }

    static /* synthetic */ void \u0971(s s2) throws o {
        s2.\u02cb();
    }

    public Object invoke(Object object, Method method, Object[] arrobject) throws Throwable {
        try {
            Class class_ = method.getDeclaringClass();
            t t2 = t.\u02cb();
            if (Object.class.equals((Object)class_)) {
                String string2 = method.getName();
                if ("getClass".equals((Object)string2)) {
                    return this.\u02ce;
                }
                if ("toString".equals((Object)string2)) {
                    Object object2 = method.invoke((Object)this, arrobject);
                    String string3 = s.class.getName();
                    String string4 = this.\u02ce.getName();
                    return String.valueOf((Object)object2).replace((CharSequence)string3, (CharSequence)string4);
                }
                return method.invoke((Object)this, arrobject);
            }
            if (this.\u02cf && this.\u141d == null) {
                this.\u02cb.clear();
                return s.\u02ca(method);
            }
            if (t2.\u02cb == t.c.\u0971) {
                this.\u02cb();
                if (this.\u141d != null) {
                    return method.invoke(this.\u141d, arrobject);
                }
            }
            if (!(t2.\u02cb != t.c.\u02ca || this.\u02cf && this.\u141d == null)) {
                if (this.\u02cb.size() >= 15) {
                    this.\u02cb.remove(5);
                }
                this.\u02cb.add((Object)new e(this, method, arrobject, 0));
            }
            Boolean bl2 = s.\u02ca(method);
            return bl2;
        }
        catch (Exception exception) {
            o.\u0971(exception);
            return s.\u02ca(method);
        }
    }

    static interface a<T> {
        public Optional<T> \u02cf() throws o;
    }

    final class e {
        private final Method \u02ca;
        private final LinkedList<Object> \u02cb = new LinkedList();
        private final WeakReference[] \u02ce;
        private /* synthetic */ s \u0971;

        private /* varargs */ e(s s2, Method method, Object ... arrobject) {
            this.\u0971 = s2;
            if (arrobject == null) {
                arrobject = \u02ca;
            }
            WeakReference[] arrweakReference = new WeakReference[arrobject.length];
            int n2 = arrobject.length;
            int n3 = 0;
            for (int i2 = 0; i2 < n2; ++i2) {
                Object object = arrobject[i2];
                if (object instanceof Map || object instanceof Integer || object instanceof Double) {
                    this.\u02cb.add(object);
                }
                int n4 = n3 + 1;
                arrweakReference[n3] = new WeakReference(object);
                n3 = n4;
            }
            this.\u02ce = arrweakReference;
            this.\u02ca = method;
        }

        /* synthetic */ e(s s2, Method method, Object[] arrobject, byte by) {
            this(s2, method, arrobject);
        }
    }

}


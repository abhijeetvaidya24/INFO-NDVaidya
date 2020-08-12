/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.moat.analytics.mobile.ogury.e
 *  com.moat.analytics.mobile.ogury.p$5
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
package com.moat.analytics.mobile.ogury;

import com.moat.analytics.mobile.ogury.base.asserts.Asserts;
import com.moat.analytics.mobile.ogury.base.functional.Optional;
import com.moat.analytics.mobile.ogury.e;
import com.moat.analytics.mobile.ogury.l;
import com.moat.analytics.mobile.ogury.p;
import com.moat.analytics.mobile.ogury.q;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.LinkedList;
import java.util.Map;

class p<T>
implements InvocationHandler {
    private static final Object[] \u02cb = new Object[0];
    private T \u02bc;
    private final b<T> \u02ca;
    private final Class<T> \u02ce;
    private boolean \u02cf;
    private final LinkedList<p<T>> \u0971;

    private p(b<T> b2, Class<T> class_) throws l {
        Asserts.checkNotNull(b2);
        Asserts.checkNotNull(class_);
        this.\u02ca = b2;
        this.\u02ce = class_;
        this.\u0971 = new LinkedList();
        q.\u02ca().\u02ca((q.b)new 5(this));
    }

    private void \u02ca() throws l {
        if (!this.\u02cf) {
            try {
                this.\u02bc = this.\u02ca.\u02cf().orElse(null);
            }
            catch (Exception exception) {
                e.1.\u02cf("OnOffTrackerProxy", this, "Could not create instance", exception);
                l.\u0971(exception);
            }
            this.\u02cf = true;
        }
        if (this.\u02bc == null) {
            return;
        }
        for (d d2 : this.\u0971) {
            Object[] arrobject = new Object[d2.\u02ce.length];
            WeakReference[] arrweakReference = d2.\u02ce;
            int n2 = arrweakReference.length;
            int n3 = 0;
            for (int i2 = 0; i2 < n2; ++i2) {
                WeakReference weakReference = arrweakReference[i2];
                int n4 = n3 + 1;
                arrobject[n3] = weakReference.get();
                n3 = n4;
            }
            try {
                d2.\u02cf.invoke(this.\u02bc, arrobject);
            }
            catch (Exception exception) {
                l.\u0971(exception);
            }
        }
        this.\u0971.clear();
    }

    static <T> T \u02cb(b<T> b2, Class<T> class_) throws l {
        ClassLoader classLoader = class_.getClassLoader();
        p<T> p2 = new p<T>(b2, class_);
        return (T)Proxy.newProxyInstance((ClassLoader)classLoader, (Class[])new Class[]{class_}, p2);
    }

    private static Object \u02cf(Method method) {
        try {
            if (Boolean.TYPE.equals((Object)method.getReturnType())) {
                Boolean bl2 = Boolean.TRUE;
                return bl2;
            }
        }
        catch (Exception exception) {
            l.\u0971(exception);
        }
        return null;
    }

    static /* synthetic */ void \u0971(p p2) throws l {
        p2.\u02ca();
    }

    public Object invoke(Object object, Method method, Object[] arrobject) throws Throwable {
        try {
            Class class_ = method.getDeclaringClass();
            q q2 = q.\u02ca();
            if (Object.class.equals((Object)class_)) {
                String string2 = method.getName();
                if ("getClass".equals((Object)string2)) {
                    return this.\u02ce;
                }
                if ("toString".equals((Object)string2)) {
                    Object object2 = method.invoke((Object)this, arrobject);
                    String string3 = p.class.getName();
                    String string4 = this.\u02ce.getName();
                    return String.valueOf((Object)object2).replace((CharSequence)string3, (CharSequence)string4);
                }
                return method.invoke((Object)this, arrobject);
            }
            if (this.\u02cf && this.\u02bc == null) {
                this.\u0971.clear();
                return p.\u02cf(method);
            }
            if (q2.\u0971 == q.e.\u02ce) {
                this.\u02ca();
                if (this.\u02bc != null) {
                    return method.invoke(this.\u02bc, arrobject);
                }
            }
            if (!(q2.\u0971 != q.e.\u02ca || this.\u02cf && this.\u02bc == null)) {
                if (this.\u0971.size() >= 15) {
                    this.\u0971.remove(5);
                }
                this.\u0971.add((Object)new d(this, method, arrobject, 0));
            }
            Object object3 = p.\u02cf(method);
            return object3;
        }
        catch (Exception exception) {
            l.\u0971(exception);
            return p.\u02cf(method);
        }
    }

    static interface b<T> {
        public Optional<T> \u02cf() throws l;
    }

    final class d {
        private final LinkedList<Object> \u02ca = new LinkedList();
        private final WeakReference[] \u02ce;
        private final Method \u02cf;
        private /* synthetic */ p \u0971;

        private /* varargs */ d(p p2, Method method, Object ... arrobject) {
            this.\u0971 = p2;
            if (arrobject == null) {
                arrobject = \u02cb;
            }
            WeakReference[] arrweakReference = new WeakReference[arrobject.length];
            int n2 = arrobject.length;
            int n3 = 0;
            for (int i2 = 0; i2 < n2; ++i2) {
                Object object = arrobject[i2];
                if (object instanceof Map || object instanceof Integer || object instanceof Double) {
                    this.\u02ca.add(object);
                }
                int n4 = n3 + 1;
                arrweakReference[n3] = new WeakReference(object);
                n3 = n4;
            }
            this.\u02ce = arrweakReference;
            this.\u02cf = method;
        }

        /* synthetic */ d(p p2, Method method, Object[] arrobject, byte by) {
            this(p2, method, arrobject);
        }
    }

}


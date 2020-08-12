/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.moat.analytics.mobile.cha.p$1
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
package com.moat.analytics.mobile.cha;

import com.moat.analytics.mobile.cha.a;
import com.moat.analytics.mobile.cha.base.asserts.Asserts;
import com.moat.analytics.mobile.cha.base.functional.Optional;
import com.moat.analytics.mobile.cha.o;
import com.moat.analytics.mobile.cha.p;
import com.moat.analytics.mobile.cha.t;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.LinkedList;
import java.util.Map;

class p<T>
implements InvocationHandler {
    private static final Object[] \u02cb = new Object[0];
    private final c<T> \u02ca;
    private boolean \u02ce;
    private final LinkedList<p<T>> \u02cf;
    private final Class<T> \u0971;
    private T \u141d;

    private p(c<T> c2, Class<T> class_) throws o {
        Asserts.checkNotNull(c2);
        Asserts.checkNotNull(class_);
        this.\u02ca = c2;
        this.\u0971 = class_;
        this.\u02cf = new LinkedList();
        t.\u02cf().\u02ca((t.b)new 1(this));
    }

    private static Boolean \u02ca(Method method) {
        try {
            if (Boolean.TYPE.equals((Object)method.getReturnType())) {
                Boolean bl2 = true;
                return bl2;
            }
        }
        catch (Exception exception) {
            o.\u02ce(exception);
        }
        return null;
    }

    static <T> T \u02cb(c<T> c2, Class<T> class_) throws o {
        ClassLoader classLoader = class_.getClassLoader();
        p<T> p2 = new p<T>(c2, class_);
        return (T)Proxy.newProxyInstance((ClassLoader)classLoader, (Class[])new Class[]{class_}, p2);
    }

    private void \u02ce() throws o {
        if (!this.\u02ce) {
            try {
                this.\u141d = this.\u02ca.\u02cb().orElse(null);
            }
            catch (Exception exception) {
                a.\u0971("OnOffTrackerProxy", this, "Could not create instance", exception);
                o.\u02ce(exception);
            }
            this.\u02ce = true;
        }
        if (this.\u141d == null) {
            return;
        }
        for (d d2 : this.\u02cf) {
            Object[] arrobject = new Object[d2.\u02ca.length];
            WeakReference[] arrweakReference = d2.\u02ca;
            int n2 = arrweakReference.length;
            int n3 = 0;
            for (int i2 = 0; i2 < n2; ++i2) {
                WeakReference weakReference = arrweakReference[i2];
                int n4 = n3 + 1;
                arrobject[n3] = weakReference.get();
                n3 = n4;
            }
            try {
                d2.\u02cb.invoke(this.\u141d, arrobject);
            }
            catch (Exception exception) {
                o.\u02ce(exception);
            }
        }
        this.\u02cf.clear();
    }

    static /* synthetic */ void \u02ce(p p2) throws o {
        p2.\u02ce();
    }

    public Object invoke(Object object, Method method, Object[] arrobject) throws Throwable {
        try {
            Class class_ = method.getDeclaringClass();
            t t2 = t.\u02cf();
            if (Object.class.equals((Object)class_)) {
                String string = method.getName();
                if ("getClass".equals((Object)string)) {
                    return this.\u0971;
                }
                if ("toString".equals((Object)string)) {
                    Object object2 = method.invoke((Object)this, arrobject);
                    String string2 = p.class.getName();
                    String string3 = this.\u0971.getName();
                    return String.valueOf((Object)object2).replace((CharSequence)string2, (CharSequence)string3);
                }
                return method.invoke((Object)this, arrobject);
            }
            if (this.\u02ce && this.\u141d == null) {
                this.\u02cf.clear();
                return p.\u02ca(method);
            }
            if (t2.\u02ce == t.a.\u02ce) {
                this.\u02ce();
                if (this.\u141d != null) {
                    return method.invoke(this.\u141d, arrobject);
                }
            }
            if (!(t2.\u02ce != t.a.\u0971 || this.\u02ce && this.\u141d == null)) {
                if (this.\u02cf.size() >= 15) {
                    this.\u02cf.remove(5);
                }
                this.\u02cf.add((Object)new d(this, method, arrobject, 0));
            }
            Boolean bl2 = p.\u02ca(method);
            return bl2;
        }
        catch (Exception exception) {
            o.\u02ce(exception);
            return p.\u02ca(method);
        }
    }

    static interface c<T> {
        public Optional<T> \u02cb() throws o;
    }

    final class d {
        private final WeakReference[] \u02ca;
        private final Method \u02cb;
        private final LinkedList<Object> \u02ce = new LinkedList();
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
                    this.\u02ce.add(object);
                }
                int n4 = n3 + 1;
                arrweakReference[n3] = new WeakReference(object);
                n3 = n4;
            }
            this.\u02ca = arrweakReference;
            this.\u02cb = method;
        }

        /* synthetic */ d(p p2, Method method, Object[] arrobject, byte by) {
            this(p2, method, arrobject);
        }
    }

}


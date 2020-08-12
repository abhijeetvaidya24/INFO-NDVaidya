/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  java.lang.Class
 *  java.lang.ClassLoader
 *  java.lang.IllegalAccessException
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.lang.UnsupportedOperationException
 *  java.lang.Void
 *  java.lang.reflect.InvocationHandler
 *  java.lang.reflect.InvocationTargetException
 *  java.lang.reflect.Method
 *  java.lang.reflect.Proxy
 */
package com.tapjoy.internal;

import android.os.Handler;
import android.os.Looper;
import com.tapjoy.internal.bf;
import com.tapjoy.internal.cu;
import com.tapjoy.internal.fu;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public final class eq {
    public static Object a(Object object, Class class_) {
        return Proxy.newProxyInstance((ClassLoader)class_.getClassLoader(), (Class[])new Class[]{class_}, (InvocationHandler)new a(object, Thread.currentThread(), Looper.myLooper()));
    }

    static final class a
    implements InvocationHandler {
        private final Object a;
        private final Thread b;
        private final Looper c;

        public a(Object object, Thread thread, Looper looper) {
            this.a = object;
            this.b = thread;
            this.c = looper;
        }

        public final Object invoke(Object object, final Method method, final Object[] arrobject) {
            if (this.b == Thread.currentThread()) {
                return method.invoke(this.a, arrobject);
            }
            if (method.getReturnType().equals((Object)Void.TYPE)) {
                Runnable runnable = new Runnable(){

                    public final void run() {
                        try {
                            method.invoke(a.this.a, arrobject);
                            return;
                        }
                        catch (InvocationTargetException invocationTargetException) {
                            throw cu.a(invocationTargetException);
                        }
                        catch (IllegalAccessException illegalAccessException) {
                            throw cu.a(illegalAccessException);
                        }
                        catch (IllegalArgumentException illegalArgumentException) {
                            throw cu.a(illegalArgumentException);
                        }
                    }
                };
                Looper looper = this.c;
                if (looper != null && new Handler(looper).post(runnable)) {
                    return null;
                }
                if (this.b == fu.b() && fu.a.a(runnable)) {
                    return null;
                }
                Looper looper2 = Looper.getMainLooper();
                if (looper2 != null && new Handler(looper2).post(runnable)) {
                    return null;
                }
                return method.invoke(this.a, arrobject);
            }
            StringBuilder stringBuilder = new StringBuilder("method not return void: ");
            stringBuilder.append(method.getName());
            throw new UnsupportedOperationException(stringBuilder.toString());
        }

    }

}


/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.SystemClock
 *  android.util.Log
 *  java.lang.Class
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.StackTraceElement
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.List
 *  java.util.Locale
 */
package com.tappx.b;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class v {
    public static String a = "Volley";
    public static boolean b = Log.isLoggable((String)a, (int)2);

    public static void a(String string2) {
        v.b("Changing log tag to %s", string2);
        a = string2;
        b = Log.isLoggable((String)a, (int)2);
    }

    public static /* varargs */ void a(String string2, Object ... arrobject) {
        if (b) {
            Log.v((String)a, (String)v.e(string2, arrobject));
        }
    }

    public static /* varargs */ void a(Throwable throwable, String string2, Object ... arrobject) {
        Log.e((String)a, (String)v.e(string2, arrobject), (Throwable)throwable);
    }

    public static /* varargs */ void b(String string2, Object ... arrobject) {
        Log.d((String)a, (String)v.e(string2, arrobject));
    }

    public static /* varargs */ void b(Throwable throwable, String string2, Object ... arrobject) {
        Log.wtf((String)a, (String)v.e(string2, arrobject), (Throwable)throwable);
    }

    public static /* varargs */ void c(String string2, Object ... arrobject) {
        Log.e((String)a, (String)v.e(string2, arrobject));
    }

    public static /* varargs */ void d(String string2, Object ... arrobject) {
        Log.wtf((String)a, (String)v.e(string2, arrobject));
    }

    private static /* varargs */ String e(String string2, Object ... arrobject) {
        String string3;
        block2 : {
            if (arrobject != null) {
                string2 = String.format((Locale)Locale.US, (String)string2, (Object[])arrobject);
            }
            StackTraceElement[] arrstackTraceElement = new Throwable().fillInStackTrace().getStackTrace();
            for (int i2 = 2; i2 < arrstackTraceElement.length; ++i2) {
                if (arrstackTraceElement[i2].getClass().equals(v.class)) continue;
                String string4 = arrstackTraceElement[i2].getClassName();
                String string5 = string4.substring(1 + string4.lastIndexOf(46));
                String string6 = string5.substring(1 + string5.lastIndexOf(36));
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string6);
                stringBuilder.append(".");
                stringBuilder.append(arrstackTraceElement[i2].getMethodName());
                string3 = stringBuilder.toString();
                break block2;
            }
            string3 = "<unknown>";
        }
        Locale locale = Locale.US;
        Object[] arrobject2 = new Object[]{Thread.currentThread().getId(), string3, string2};
        return String.format((Locale)locale, (String)"[%d] %s: %s", (Object[])arrobject2);
    }

    static class com.tappx.b.v$a {
        public static final boolean a = v.b;
        private final List<a> c = new ArrayList();
        private boolean d = false;

        com.tappx.b.v$a() {
        }

        private long a() {
            if (this.c.size() == 0) {
                return 0L;
            }
            long l2 = ((a)this.c.get((int)0)).c;
            List<a> list = this.c;
            return ((a)list.get((int)(-1 + list.size()))).c - l2;
        }

        public void a(String string2) {
            com.tappx.b.v$a a2 = this;
            synchronized (a2) {
                long l2;
                block5 : {
                    this.d = true;
                    l2 = this.a();
                    if (l2 > 0L) break block5;
                    return;
                }
                try {
                    long l3 = ((a)this.c.get((int)0)).c;
                    Object[] arrobject = new Object[]{l2, string2};
                    v.b("(%-4d ms) %s", arrobject);
                    for (a a3 : this.c) {
                        long l4 = a3.c;
                        Object[] arrobject2 = new Object[]{l4 - l3, a3.b, a3.a};
                        v.b("(+%-4d) [%2d] %s", arrobject2);
                        l3 = l4;
                    }
                }
                catch (Throwable throwable) {}
                {
                    throw throwable;
                }
                return;
            }
        }

        public void a(String string2, long l2) {
            com.tappx.b.v$a a2 = this;
            synchronized (a2) {
                if (!this.d) {
                    List<a> list = this.c;
                    a a3 = new a(string2, l2, SystemClock.elapsedRealtime());
                    list.add((Object)a3);
                    return;
                }
                throw new IllegalStateException("Marker added to finished log");
            }
        }

        protected void finalize() {
            if (!this.d) {
                this.a("Request on the loose");
                v.c("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
            }
        }

        private static class a {
            public final String a;
            public final long b;
            public final long c;

            public a(String string2, long l2, long l3) {
                this.a = string2;
                this.b = l2;
                this.c = l3;
            }
        }

    }

}


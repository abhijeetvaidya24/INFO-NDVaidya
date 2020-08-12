/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.tappx.a.a.a.l
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.reflect.Method
 */
package com.tappx.a.a.a.d;

import android.content.Context;
import com.tappx.a.a.a.f;
import com.tappx.a.a.a.l;
import java.lang.reflect.Method;

public class o {
    private static final int a = 0;
    private static final String b = "getAdvertisingIdInfo";
    private static final String c = "com.google.android.gms.common.GooglePlayServicesUtil";
    private static final String d = "com.google.android.gms.ads.identifier.AdvertisingIdClient";
    private static final String e = "isGooglePlayServicesAvailable";
    private static final String f = "isLimitAdTrackingEnabled";
    private static final String g = "getId";
    private final Context h;
    private final f<a> i;

    public o(Context context) {
        this(context, (f<a>)new l(com.tappx.a.a.a.a.a.o));
    }

    o(Context context, f<a> f2) {
        this.h = context;
        this.i = f2;
    }

    /*
     * Exception decompiling
     */
    private static Method a(Class<?> var0, String var1, Class<?>[] var2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl1 : ALOAD_0 : trying to set 1 previously set to 0
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:919)
        throw new IllegalStateException("Decompilation failed");
    }

    private boolean a(Object object) {
        Boolean bl2;
        block3 : {
            try {
                bl2 = (Boolean)o.a(object.getClass(), f, null).invoke(object, new Object[0]);
                if (bl2 != null) break block3;
                return false;
            }
            catch (Exception exception) {
                return false;
            }
        }
        boolean bl3 = bl2;
        return bl3;
    }

    private String b(Object object) {
        try {
            String string2 = (String)o.a(object.getClass(), g, null).invoke(object, new Object[0]);
            return string2;
        }
        catch (Exception exception) {
            return null;
        }
    }

    private a c() {
        Object[] arrobject = new Object[]{this.h};
        Class[] arrclass = new Class[]{Context.class};
        Object object = o.a(Class.forName((String)d), b, arrclass).invoke(null, arrobject);
        return new a(this.b(object), this.a(object));
    }

    private boolean d() {
        Object[] arrobject = new Object[]{this.h};
        Class[] arrclass = new Class[]{Context.class};
        Object object = o.a(Class.forName((String)c), e, arrclass).invoke(null, arrobject);
        return object != null && (Integer)object == 0;
    }

    public boolean a() {
        try {
            boolean bl2 = this.d();
            return bl2;
        }
        catch (Exception exception) {
            return false;
        }
    }

    public a b() {
        a a2 = this.i.a();
        if (a2 != null) {
            return a2;
        }
        try {
            a a3 = this.c();
            this.i.a(a3);
            return a3;
        }
        catch (Exception exception) {
            return null;
        }
    }

    public static class a {
        private final String a;
        private final boolean b;

        public a(String string2, boolean bl2) {
            this.a = string2;
            this.b = bl2;
        }

        public String a() {
            return this.a;
        }

        public boolean b() {
            return this.b;
        }
    }

}


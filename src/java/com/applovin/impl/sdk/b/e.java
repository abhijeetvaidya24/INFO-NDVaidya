/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Set
 */
package com.applovin.impl.sdk.b;

import android.content.Context;
import android.content.SharedPreferences;
import com.applovin.impl.sdk.b.b;
import com.applovin.impl.sdk.b.d;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.p;
import java.util.Set;

public final class e {
    private static SharedPreferences b;
    private final j a;
    private final SharedPreferences c;

    public e(j j2) {
        this.a = j2;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("com.applovin.sdk.preferences.");
        stringBuilder.append(j2.s());
        String string2 = stringBuilder.toString();
        this.c = j2.w().getSharedPreferences(string2, 0);
    }

    private static SharedPreferences a(Context context) {
        if (b == null) {
            b = context.getSharedPreferences("com.applovin.sdk.shared", 0);
        }
        return b;
    }

    /*
     * Exception decompiling
     */
    private static <T> T a(String var0, T var1_1, Class var2_2, SharedPreferences var3_3, j var4_4) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
        // org.benf.cfr.reader.b.a.a.j.b(Op04StructuredStatement.java:409)
        // org.benf.cfr.reader.b.a.a.j.d(Op04StructuredStatement.java:487)
        // org.benf.cfr.reader.b.a.a.i.a(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:692)
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

    private static void a(SharedPreferences.Editor editor, j j2) {
        if (j2 != null && j2.a(b.ab).booleanValue()) {
            editor.apply();
            return;
        }
        editor.commit();
    }

    public static <T> void a(d<T> d2, Context context) {
        e.a(e.a(context).edit().remove(d2.a()), null);
    }

    public static <T> void a(d<T> d2, T t2, Context context) {
        e.a(d2.a(), t2, e.a(context), null, null);
    }

    private static <T> void a(String string2, T t2, SharedPreferences sharedPreferences, SharedPreferences.Editor editor, j j2) {
        boolean bl = true;
        boolean bl2 = editor != null;
        if (!bl2) {
            editor = sharedPreferences.edit();
        }
        if (t2 instanceof Boolean) {
            editor.putBoolean(string2, ((Boolean)t2).booleanValue());
        } else if (t2 instanceof Float) {
            editor.putFloat(string2, ((Float)t2).floatValue());
        } else if (t2 instanceof Integer) {
            editor.putInt(string2, ((Integer)t2).intValue());
        } else if (t2 instanceof Long) {
            editor.putLong(string2, ((Long)t2).longValue());
        } else if (t2 instanceof String) {
            editor.putString(string2, (String)t2);
        } else if (t2 instanceof Set) {
            editor.putStringSet(string2, (Set)t2);
        } else {
            if (j2 != null) {
                p p2 = j2.u();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unable to put default value of invalid type: ");
                stringBuilder.append(t2);
                p2.d("SharedPreferencesManager", stringBuilder.toString());
            }
            bl = false;
        }
        if (bl && !bl2) {
            e.a(editor, j2);
        }
    }

    public static <T> T b(d<T> d2, T t2, Context context) {
        return e.a(d2.a(), t2, d2.b(), e.a(context), null);
    }

    public <T> T a(String string2, T t2, Class class_, SharedPreferences sharedPreferences) {
        return e.a(string2, t2, class_, sharedPreferences, this.a);
    }

    public void a(SharedPreferences sharedPreferences) {
        e.a(sharedPreferences.edit().clear(), this.a);
    }

    public <T> void a(d<T> d2) {
        e.a(this.c.edit().remove(d2.a()), this.a);
    }

    public <T> void a(d<T> d2, T t2) {
        this.a(d2, t2, this.c);
    }

    public <T> void a(d<T> d2, T t2, SharedPreferences sharedPreferences) {
        this.a(d2.a(), t2, sharedPreferences);
    }

    public <T> void a(String string2, T t2, SharedPreferences.Editor editor) {
        e.a(string2, t2, null, editor, this.a);
    }

    public <T> void a(String string2, T t2, SharedPreferences sharedPreferences) {
        e.a(string2, t2, sharedPreferences, null, this.a);
    }

    public <T> T b(d<T> d2, T t2) {
        return this.b(d2, t2, this.c);
    }

    public <T> T b(d<T> d2, T t2, SharedPreferences sharedPreferences) {
        return this.a(d2.a(), t2, d2.b(), sharedPreferences);
    }
}


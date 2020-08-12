/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  com.startapp.android.publish.adsCommon.e.a$a
 *  java.io.PrintWriter
 *  java.io.StringWriter
 *  java.io.Writer
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Thread
 *  java.lang.Thread$UncaughtExceptionHandler
 *  java.lang.Throwable
 */
package com.startapp.android.publish.adsCommon.e;

import android.content.Context;
import android.text.TextUtils;
import com.startapp.android.publish.adsCommon.e.a;
import com.startapp.common.b.b;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

/*
 * Exception performing whole class analysis.
 */
public class a
implements Thread.UncaughtExceptionHandler {
    private final Thread.UncaughtExceptionHandler a;

    private a(Context context) {
        this.a = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler((Thread.UncaughtExceptionHandler)this);
        com.startapp.common.b.a.a(context);
        com.startapp.common.b.a.a((com.startapp.common.b.a.a)new /* Unavailable Anonymous Inner Class!! */);
    }

    public static void a(Context context) {
        Class<a> class_ = a.class;
        synchronized (a.class) {
            new a(context);
            // ** MonitorExit[var3_1] (shouldn't be in output)
            return;
        }
    }

    public void uncaughtException(Thread thread, Throwable throwable) {
        StringWriter stringWriter = new StringWriter();
        throwable.printStackTrace(new PrintWriter((Writer)stringWriter));
        String string = stringWriter.toString();
        if (!TextUtils.isEmpty((CharSequence)string) && (string.contains((CharSequence)"startapp") || string.contains((CharSequence)"truenet"))) {
            com.startapp.common.b.a.a(new b.a(868418937).a(1000L).a("KEY_STACK_TRACE", string).a());
        }
        this.a.uncaughtException(thread, throwable);
    }
}


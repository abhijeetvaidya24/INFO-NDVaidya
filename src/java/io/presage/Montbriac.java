/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 *  io.presage.w
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 */
package io.presage;

import android.os.Looper;
import io.presage.cl;
import io.presage.w;

public final class Montbriac {
    public static final void a() {
    }

    public static final void a(String string2) {
        if (cl.a((Object)Looper.myLooper(), (Object)Looper.getMainLooper())) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append(" cannot be called from the main thread");
            new IllegalStateException(stringBuilder.toString());
            Montbriac.a();
        }
    }

    public static final boolean a(Throwable throwable) {
        return throwable instanceof w;
    }
}


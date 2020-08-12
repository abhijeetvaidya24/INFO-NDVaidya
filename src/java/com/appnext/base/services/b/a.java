/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  com.appnext.base.a.b.c
 *  com.appnext.base.services.a.a
 *  com.appnext.base.services.a.b
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.Throwable
 *  java.util.List
 */
package com.appnext.base.services.b;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import com.appnext.base.a.b.c;
import com.appnext.base.services.a.b;
import java.util.List;

public class a {
    private static volatile a eM;
    private com.appnext.base.services.a.c eN;

    public a(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                this.eN = new b(context);
                return;
            }
            this.eN = new com.appnext.base.services.a.a(context);
        }
        catch (Throwable throwable) {}
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static a d(Context context) {
        if (eM != null) return eM;
        Class<a> class_ = a.class;
        synchronized (a.class) {
            if (eM != null) return eM;
            eM = new a(context);
            // ** MonitorExit[var2_1] (shouldn't be in output)
            return eM;
        }
    }

    public final void a(c c2, boolean bl) {
        this.eN.a(c2, bl, null);
    }

    public final void c(c c2) {
        this.eN.c(c2);
    }

    public final void h(List<c> list) {
        this.eN.h(list);
    }
}


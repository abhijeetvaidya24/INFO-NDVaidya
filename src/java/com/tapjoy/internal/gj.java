/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  com.tapjoy.internal.gd
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 */
package com.tapjoy.internal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tapjoy.internal.ct;
import com.tapjoy.internal.et;
import com.tapjoy.internal.ez;
import com.tapjoy.internal.fv;
import com.tapjoy.internal.gd;

public abstract class gj {
    long c;
    boolean d;
    public fv e;
    public String f;
    et g;

    static void a(Context context, String string2) {
        if (ct.c(string2)) {
            return;
        }
        try {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse((String)string2)));
        }
        catch (Exception exception) {}
    }

    public abstract void a(gd var1, ez var2);

    public abstract void b();

    public boolean c() {
        return true;
    }
}


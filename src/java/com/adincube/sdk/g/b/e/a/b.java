/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.adincube.sdk.g.b.e.a.a
 *  com.adincube.sdk.h.b.b
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  org.json.JSONObject
 */
package com.adincube.sdk.g.b.e.a;

import android.content.Context;
import com.adincube.sdk.g.b.e.a.a;
import com.adincube.sdk.util.e;
import com.adincube.sdk.util.f;
import com.adincube.sdk.util.n;
import org.json.JSONObject;

public final class b
implements a {
    private String a;

    public b(String string) {
        this.a = string;
    }

    public final com.adincube.sdk.h.b.b a() {
        Context context = f.a();
        String string = n.a(context, this.a);
        if (string == null) {
            return null;
        }
        try {
            com.adincube.sdk.h.b.b b2 = com.adincube.sdk.h.b.b.a((JSONObject)new JSONObject(e.c(string)));
            return b2;
        }
        catch (Exception exception) {
            new Object[1][0] = exception;
            n.b(context, this.a);
            return null;
        }
    }

    public final void a(com.adincube.sdk.h.b.b b2) {
        if (b2 != null && b2.c) {
            return;
        }
        Context context = f.a();
        if (b2 != null) {
            String string = e.d(b2.a().toString());
            n.a(context, this.a, string);
            return;
        }
        n.b(context, this.a);
    }

    public final void b() {
        n.b(f.a(), this.a);
    }
}


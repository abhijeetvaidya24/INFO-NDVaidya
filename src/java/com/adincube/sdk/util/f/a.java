/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  com.adincube.sdk.AdinCubeActivity
 *  com.adincube.sdk.h.a.c
 *  com.adincube.sdk.h.c.b
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  org.json.JSONObject
 */
package com.adincube.sdk.util.f;

import android.content.Context;
import android.content.Intent;
import com.adincube.sdk.AdinCubeActivity;
import com.adincube.sdk.h.a.c;
import com.adincube.sdk.util.b;
import org.json.JSONObject;

public final class a {
    public c a;
    public com.adincube.sdk.h.c.b b;
    private Context c;

    public a(Context context) {
        this.c = context;
    }

    public final Intent a() {
        Intent intent = new Intent(this.c, AdinCubeActivity.class);
        intent.putExtra("a", this.a.f().toString());
        intent.putExtra("at", this.b.e);
        new b(this.c).a(intent);
        return intent;
    }
}


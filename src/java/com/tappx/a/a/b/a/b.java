/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ActivityNotFoundException
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Parcelable
 *  com.tappx.a.a.b.p
 *  com.tappx.sdk.a.a
 *  com.tappx.sdk.android.AdActivity
 *  com.tappx.sdk.android.InterstitialAdActivity
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 */
package com.tappx.a.a.b.a;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import com.tappx.a.a.a.h;
import com.tappx.a.a.b.p;
import com.tappx.sdk.a.a;
import com.tappx.sdk.android.AdActivity;
import com.tappx.sdk.android.InterstitialAdActivity;

class b {
    public static void a(Context context, String string2, a a2, int n2) {
        Class class_ = a2.f() ? InterstitialAdActivity.class : AdActivity.class;
        Intent intent = new Intent(context, class_);
        p.a((Intent)intent, (String)string2);
        intent.putExtra("aavc_fagZVUC6pOQOxawVwpVy", (Parcelable)a2);
        intent.putExtra("aavc_otZMuRlffpTHI9DsaLyI", n2);
        intent.addFlags(268435456);
        try {
            context.startActivity(intent);
            return;
        }
        catch (ActivityNotFoundException activityNotFoundException) {
            String string3 = class_.getName();
            String string4 = class_.getSimpleName();
            com.tappx.a.a.a.c.a.b(h.a("dfKcWOaG8KPoMfm5zts08Qlu05+R8BIzO3YcOMbimy7M7b66oYD1J20myZSpOoOWRYcUsjDmTjtwSPWh2TgTXA"), string3, string4);
            return;
        }
    }
}


/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  com.tappx.a.a.b.o
 *  java.lang.Object
 *  java.lang.String
 */
package com.tappx.a.a.b;

import android.net.Uri;
import com.tappx.a.a.b.o;

public class ak {
    static final String a = "tappx";
    static final String b = "loadFailed";
    private static final String c = "noFillAd";
    private static final String d = "loadFinished";

    public boolean a(String string2, o.b b2) {
        Uri uri = Uri.parse((String)string2);
        if (!a.equalsIgnoreCase(uri.getScheme())) {
            return false;
        }
        String string3 = uri.getHost();
        if (c.equalsIgnoreCase(string3)) {
            b2.b();
        } else if (d.equalsIgnoreCase(string3)) {
            b2.a();
        }
        return true;
    }
}


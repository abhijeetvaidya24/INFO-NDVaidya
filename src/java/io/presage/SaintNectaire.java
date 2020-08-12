/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.webkit.WebResourceResponse
 *  io.presage.ds
 *  java.io.ByteArrayInputStream
 *  java.io.InputStream
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.charset.Charset
 */
package io.presage;

import android.content.Context;
import android.webkit.WebResourceResponse;
import io.presage.CapGrisNez;
import io.presage.CarreMirabelle;
import io.presage.RouedeBrie;
import io.presage.ak;
import io.presage.cl;
import io.presage.ds;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;

public final class SaintNectaire {
    public static final SaintNectaire a = new SaintNectaire();

    private SaintNectaire() {
    }

    public static WebResourceResponse a(Context context, CapGrisNez capGrisNez) {
        new RouedeBrie();
        String string2 = RouedeBrie.a(capGrisNez);
        String string3 = CarreMirabelle.CamembertauCalvados.a(context).b();
        boolean bl2 = ((CharSequence)string3).length() > 0;
        if (bl2) {
            return SaintNectaire.a(string3, string2);
        }
        return null;
    }

    private static WebResourceResponse a(String string2, String string3) {
        StringBuilder stringBuilder = new StringBuilder("javascript:");
        stringBuilder.append(string3);
        stringBuilder.append(string2);
        String string4 = stringBuilder.toString();
        Charset charset = ds.a;
        if (string4 != null) {
            byte[] arrby = string4.getBytes(charset);
            cl.a((Object)arrby, "(this as java.lang.String).getBytes(charset)");
            return new WebResourceResponse("text/javascript", "UTF-8", (InputStream)new ByteArrayInputStream(arrby));
        }
        throw new ak("null cannot be cast to non-null type java.lang.String");
    }
}


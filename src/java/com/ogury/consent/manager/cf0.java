/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.charset.Charset
 */
package com.ogury.consent.manager;

import com.ogury.consent.manager.tx6480;
import java.nio.charset.Charset;

public final class cf0 {
    public static final Charset a;
    public static final Charset b;
    public static final Charset c;
    public static final Charset d;
    public static final Charset e;
    public static final Charset f;
    public static final cf0 g;

    static {
        g = new cf0();
        Charset charset = Charset.forName((String)"UTF-8");
        tx6480.a((Object)charset, "Charset.forName(\"UTF-8\")");
        a = charset;
        Charset charset2 = Charset.forName((String)"UTF-16");
        tx6480.a((Object)charset2, "Charset.forName(\"UTF-16\")");
        b = charset2;
        Charset charset3 = Charset.forName((String)"UTF-16BE");
        tx6480.a((Object)charset3, "Charset.forName(\"UTF-16BE\")");
        c = charset3;
        Charset charset4 = Charset.forName((String)"UTF-16LE");
        tx6480.a((Object)charset4, "Charset.forName(\"UTF-16LE\")");
        d = charset4;
        Charset charset5 = Charset.forName((String)"US-ASCII");
        tx6480.a((Object)charset5, "Charset.forName(\"US-ASCII\")");
        e = charset5;
        Charset charset6 = Charset.forName((String)"ISO-8859-1");
        tx6480.a((Object)charset6, "Charset.forName(\"ISO-8859-1\")");
        f = charset6;
    }

    private cf0() {
    }
}


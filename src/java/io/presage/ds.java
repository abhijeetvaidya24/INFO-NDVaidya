/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.charset.Charset
 */
package io.presage;

import io.presage.cl;
import java.nio.charset.Charset;

public final class ds {
    public static final Charset a;
    public static final Charset b;
    public static final Charset c;
    public static final Charset d;
    public static final Charset e;
    public static final Charset f;
    public static final ds g;

    static {
        g = new ds();
        Charset charset = Charset.forName((String)"UTF-8");
        cl.a((Object)charset, "Charset.forName(\"UTF-8\")");
        a = charset;
        Charset charset2 = Charset.forName((String)"UTF-16");
        cl.a((Object)charset2, "Charset.forName(\"UTF-16\")");
        b = charset2;
        Charset charset3 = Charset.forName((String)"UTF-16BE");
        cl.a((Object)charset3, "Charset.forName(\"UTF-16BE\")");
        c = charset3;
        Charset charset4 = Charset.forName((String)"UTF-16LE");
        cl.a((Object)charset4, "Charset.forName(\"UTF-16LE\")");
        d = charset4;
        Charset charset5 = Charset.forName((String)"US-ASCII");
        cl.a((Object)charset5, "Charset.forName(\"US-ASCII\")");
        e = charset5;
        Charset charset6 = Charset.forName((String)"ISO-8859-1");
        cl.a((Object)charset6, "Charset.forName(\"ISO-8859-1\")");
        f = charset6;
    }

    private ds() {
    }
}


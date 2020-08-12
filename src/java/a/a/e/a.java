/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.charset.Charset
 *  org.jetbrains.annotations.NotNull
 */
package a.a.e;

import a.a.b.b.h;
import java.nio.charset.Charset;
import org.jetbrains.annotations.NotNull;

public final class a {
    @NotNull
    public static final Charset a;
    @NotNull
    public static final Charset b;
    @NotNull
    public static final Charset c;
    @NotNull
    public static final Charset d;
    @NotNull
    public static final Charset e;
    @NotNull
    public static final Charset f;
    public static final a g;

    static {
        g = new a();
        Charset charset = Charset.forName((String)"UTF-8");
        h.a((Object)charset, "Charset.forName(\"UTF-8\")");
        a = charset;
        Charset charset2 = Charset.forName((String)"UTF-16");
        h.a((Object)charset2, "Charset.forName(\"UTF-16\")");
        b = charset2;
        Charset charset3 = Charset.forName((String)"UTF-16BE");
        h.a((Object)charset3, "Charset.forName(\"UTF-16BE\")");
        c = charset3;
        Charset charset4 = Charset.forName((String)"UTF-16LE");
        h.a((Object)charset4, "Charset.forName(\"UTF-16LE\")");
        d = charset4;
        Charset charset5 = Charset.forName((String)"US-ASCII");
        h.a((Object)charset5, "Charset.forName(\"US-ASCII\")");
        e = charset5;
        Charset charset6 = Charset.forName((String)"ISO-8859-1");
        h.a((Object)charset6, "Charset.forName(\"ISO-8859-1\")");
        f = charset6;
    }

    private a() {
    }
}


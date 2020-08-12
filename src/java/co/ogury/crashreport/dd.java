/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.charset.Charset
 */
package co.ogury.crashreport;

import co.ogury.crashreport.tx8640;
import java.nio.charset.Charset;

public final class dd {
    public static final Charset a;

    static {
        new dd();
        Charset charset = Charset.forName((String)"UTF-8");
        tx8640.a((Object)charset, "Charset.forName(\"UTF-8\")");
        a = charset;
        tx8640.a((Object)Charset.forName((String)"UTF-16"), "Charset.forName(\"UTF-16\")");
        tx8640.a((Object)Charset.forName((String)"UTF-16BE"), "Charset.forName(\"UTF-16BE\")");
        tx8640.a((Object)Charset.forName((String)"UTF-16LE"), "Charset.forName(\"UTF-16LE\")");
        tx8640.a((Object)Charset.forName((String)"US-ASCII"), "Charset.forName(\"US-ASCII\")");
        tx8640.a((Object)Charset.forName((String)"ISO-8859-1"), "Charset.forName(\"ISO-8859-1\")");
    }

    private dd() {
    }
}


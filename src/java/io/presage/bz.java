/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Reader
 *  java.io.StringWriter
 *  java.io.Writer
 *  java.lang.Object
 *  java.lang.String
 */
package io.presage;

import io.presage.cl;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

public final class bz {
    private static long a(Reader reader, Writer writer) {
        char[] arrc = new char[8192];
        int n2 = reader.read(arrc);
        long l2 = 0L;
        while (n2 >= 0) {
            writer.write(arrc, 0, n2);
            l2 += (long)n2;
            n2 = reader.read(arrc);
        }
        return l2;
    }

    public static final String a(Reader reader) {
        StringWriter stringWriter = new StringWriter();
        bz.a(reader, (Writer)stringWriter);
        String string2 = stringWriter.toString();
        cl.a((Object)string2, "buffer.toString()");
        return string2;
    }
}


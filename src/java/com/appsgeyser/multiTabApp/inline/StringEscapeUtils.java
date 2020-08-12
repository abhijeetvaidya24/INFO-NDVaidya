/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.StringWriter
 *  java.io.Writer
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Locale
 */
package com.appsgeyser.multiTabApp.inline;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Locale;

public class StringEscapeUtils {
    private static final String CSV_QUOTE_STR = String.valueOf((char)'\"');

    public static String escapeJavaScript(String string2) {
        try {
            String string3 = StringEscapeUtils.escapeJavaStyleString(string2, true, true);
            return string3;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return string2;
        }
    }

    private static String escapeJavaStyleString(String string2, boolean bl, boolean bl2) throws Exception {
        if (string2 == null) {
            return null;
        }
        try {
            StringWriter stringWriter = new StringWriter(2 * string2.length());
            StringEscapeUtils.escapeJavaStyleString((Writer)stringWriter, string2, bl, bl2);
            String string3 = stringWriter.toString();
            return string3;
        }
        catch (IOException iOException) {
            throw new Exception("escapeJavaStyleString error!");
        }
    }

    private static void escapeJavaStyleString(Writer writer, String string2, boolean bl, boolean bl2) throws IOException {
        IllegalArgumentException illegalArgumentException;
        if (writer != null) {
            if (string2 == null) {
                return;
            }
            int n2 = string2.length();
            block7 : for (int i2 = 0; i2 < n2; ++i2) {
                char c2 = string2.charAt(i2);
                if (c2 > '\u0fff') {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("\\u");
                    stringBuilder.append(StringEscapeUtils.hex(c2));
                    writer.write(stringBuilder.toString());
                    continue;
                }
                if (c2 > '\u00ff') {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("\\u0");
                    stringBuilder.append(StringEscapeUtils.hex(c2));
                    writer.write(stringBuilder.toString());
                    continue;
                }
                if (c2 > '') {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("\\u00");
                    stringBuilder.append(StringEscapeUtils.hex(c2));
                    writer.write(stringBuilder.toString());
                    continue;
                }
                if (c2 < ' ') {
                    switch (c2) {
                        default: {
                            if (c2 <= '\u000f') break;
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("\\u00");
                            stringBuilder.append(StringEscapeUtils.hex(c2));
                            writer.write(stringBuilder.toString());
                            continue block7;
                        }
                        case '\r': {
                            writer.write(92);
                            writer.write(114);
                            continue block7;
                        }
                        case '\f': {
                            writer.write(92);
                            writer.write(102);
                            continue block7;
                        }
                        case '\n': {
                            writer.write(92);
                            writer.write(110);
                            continue block7;
                        }
                        case '\t': {
                            writer.write(92);
                            writer.write(116);
                            continue block7;
                        }
                        case '\b': {
                            writer.write(92);
                            writer.write(98);
                            continue block7;
                        }
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("\\u000");
                    stringBuilder.append(StringEscapeUtils.hex(c2));
                    writer.write(stringBuilder.toString());
                    continue;
                }
                if (c2 != '\"') {
                    if (c2 != '\'') {
                        if (c2 != '/') {
                            if (c2 != '\\') {
                                writer.write((int)c2);
                                continue;
                            }
                            writer.write(92);
                            writer.write(92);
                            continue;
                        }
                        if (bl2) {
                            writer.write(92);
                        }
                        writer.write(47);
                        continue;
                    }
                    if (bl) {
                        writer.write(92);
                    }
                    writer.write(39);
                    continue;
                }
                writer.write(92);
                writer.write(34);
            }
            return;
        }
        illegalArgumentException = new IllegalArgumentException("The Writer must not be null");
        throw illegalArgumentException;
    }

    private static String hex(char c2) {
        return Integer.toHexString((int)c2).toUpperCase(Locale.ENGLISH);
    }
}


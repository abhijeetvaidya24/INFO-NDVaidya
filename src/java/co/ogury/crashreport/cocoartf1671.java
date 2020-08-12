/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build
 *  android.os.Build$VERSION
 *  co.ogury.crashreport.ii
 *  co.ogury.crashreport.tx5040
 *  java.io.File
 *  java.io.IOException
 *  java.io.PrintWriter
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runtime
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 */
package co.ogury.crashreport;

import android.content.Context;
import android.os.Build;
import co.ogury.crashreport.Helvetica;
import co.ogury.crashreport.ansi;
import co.ogury.crashreport.blue255;
import co.ogury.crashreport.cocoasubrtf100;
import co.ogury.crashreport.colortbl;
import co.ogury.crashreport.green255;
import co.ogury.crashreport.ii;
import co.ogury.crashreport.red255;
import co.ogury.crashreport.rtf1;
import co.ogury.crashreport.tx5040;
import co.ogury.crashreport.tx8640;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public final class cocoartf1671 {
    private final rtf1 a;
    private final cocoasubrtf100 b;
    private final Helvetica c;

    public cocoartf1671(Context context, cocoasubrtf100 cocoasubrtf1002, Helvetica helvetica) {
        tx8640.b((Object)context, "context");
        tx8640.b(cocoasubrtf1002, "crashFormatter");
        tx8640.b(helvetica, "fileStore");
        this.b = cocoasubrtf1002;
        this.c = helvetica;
        this.a = rtf1.rtf1.a(context);
    }

    public static String a(File file) throws Exception {
        tx8640.b((Object)file, "file");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(tx5040.a((File)file, null, (int)1));
        String string = stringBuilder.toString();
        tx8640.a((Object)string, "sb.toString()");
        return string;
    }

    public final void a(Throwable throwable) throws IOException {
        green255 green2552;
        tx8640.b((Object)throwable, "throwable");
        String string = Build.MODEL;
        tx8640.a((Object)string, "Build.MODEL");
        String string2 = Build.VERSION.RELEASE;
        tx8640.a((Object)string2, "Build.VERSION.RELEASE");
        Runtime runtime = Runtime.getRuntime();
        if (runtime != null) {
            long l2 = runtime.freeMemory();
            long l3 = runtime.totalMemory();
            long l4 = runtime.maxMemory();
            green2552 = new green255(l2, l3, l4, true);
        } else {
            green255 green2553;
            green2552 = green2553 = new green255(0L, 0L, 0L, false, 15);
        }
        red255 red2552 = new red255(string, string2, green2552);
        ansi ansi2 = this.b.a(throwable, red2552, this.a, this.c);
        if (ansi2 instanceof colortbl) {
            return;
        }
        if (ansi2 instanceof blue255) {
            File file2;
            blue255 blue2552;
            block10 : {
                blue2552 = (blue255)ansi2;
                String string3 = blue2552.b();
                for (File file2 : this.c.a()) {
                    String string4 = file2.getName();
                    tx8640.a((Object)string4, "file.name");
                    if (!ii.a((CharSequence)string4, (CharSequence)string3, (boolean)false, (int)2)) {
                        continue;
                    }
                    break block10;
                }
                file2 = null;
            }
            if (file2 == null) {
                return;
            }
            String string5 = blue2552.a();
            String string6 = cocoartf1671.a(file2);
            PrintWriter printWriter = new PrintWriter(file2);
            int n2 = ((CharSequence)string6).length();
            boolean bl = false;
            if (n2 == 0) {
                bl = true;
            }
            if (bl) {
                printWriter.print(string5);
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string6);
                stringBuilder.append(',');
                stringBuilder.append(string5);
                printWriter.print(stringBuilder.toString());
            }
            printWriter.close();
        }
    }

    public final File[] a() {
        return this.c.a();
    }
}


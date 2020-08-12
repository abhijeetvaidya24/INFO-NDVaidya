/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.io.File
 *  java.io.PrintWriter
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 */
package co.ogury.crashreport;

import android.content.Context;
import co.ogury.crashreport.f0;
import co.ogury.crashreport.tx8640;
import java.io.File;
import java.io.PrintWriter;

public final class Helvetica {
    private final File a;

    static {
        new rtf1(0);
    }

    public Helvetica(Context context) {
        tx8640.b((Object)context, "context");
        this.a = new File(context.getFilesDir(), "presageDir");
        this.a.mkdirs();
    }

    public static void a(File file) {
        tx8640.b((Object)file, "file");
        try {
            new PrintWriter(file).print("");
            return;
        }
        catch (Exception exception) {
            f0.a(exception);
            return;
        }
    }

    public final boolean a(String string) {
        tx8640.b(string, "fileName");
        return new File(this.a, string).createNewFile();
    }

    public final File[] a() {
        File[] arrfile = this.a.listFiles();
        if (arrfile == null) {
            arrfile = new File[]{};
        }
        return arrfile;
    }

    public static final class rtf1 {
        private rtf1() {
        }

        public /* synthetic */ rtf1(byte by2) {
            this();
        }
    }

}


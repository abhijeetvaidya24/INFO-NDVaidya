/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package co.ogury.crashreport;

import co.ogury.crashreport.Helvetica;
import co.ogury.crashreport.ansicpg1252;
import co.ogury.crashreport.cocoartf1671;
import co.ogury.crashreport.f0;
import co.ogury.crashreport.fonttbl;
import co.ogury.crashreport.tx8640;
import java.io.File;

public final class fswiss {
    private final cocoartf1671 a;
    private final fonttbl b;

    static {
        new rtf1(0);
    }

    public fswiss(cocoartf1671 cocoartf16712, fonttbl fonttbl2) {
        tx8640.b(cocoartf16712, "crashFileStore");
        tx8640.b(fonttbl2, "crashReportDao");
        this.a = cocoartf16712;
        this.b = fonttbl2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static final /* synthetic */ void a(fswiss fswiss2) {
        int n2;
        File[] arrfile = fswiss2.a.a();
        try {
            n2 = arrfile.length;
        }
        catch (Exception exception) {
            f0.a(exception);
            return;
        }
        for (int i2 = 0; i2 < n2; ++i2) {
            File file = arrfile[i2];
            String string = cocoartf1671.a(file);
            boolean bl = ((CharSequence)string).length() == 0;
            if (bl) continue;
            StringBuilder stringBuilder = new StringBuilder("[");
            stringBuilder.append(string);
            stringBuilder.append(']');
            String string2 = stringBuilder.toString();
            fonttbl fonttbl2 = fswiss2.b;
            String string3 = file.getName();
            tx8640.a((Object)string3, "file.name");
            if (ansicpg1252.a(string2, fonttbl2.a(string3)) >= 500) continue;
            tx8640.b((Object)file, "file");
            Helvetica.a(file);
        }
    }

    public static final class rtf1 {
        private rtf1() {
        }

        public /* synthetic */ rtf1(byte by2) {
            this();
        }
    }

}


/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  co.ogury.crashreport.tx5040
 *  java.io.Closeable
 *  java.io.File
 *  java.io.FileInputStream
 *  java.lang.Object
 *  java.lang.OutOfMemoryError
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.nio.charset.Charset
 *  java.util.Arrays
 */
package co.ogury.crashreport;

import co.ogury.crashreport.dd;
import co.ogury.crashreport.tx2160;
import co.ogury.crashreport.tx2880;
import co.ogury.crashreport.tx5040;
import co.ogury.crashreport.tx8640;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.Charset;
import java.util.Arrays;

public class tx4320 {
    public static /* synthetic */ String a(File file, Charset charset, int n2) {
        Charset charset2 = dd.a;
        tx8640.b((Object)file, "$receiver");
        tx8640.b((Object)charset2, "charset");
        return new String(tx5040.a((File)file), charset2);
    }

    public static final void a(Closeable closeable, Throwable throwable) {
        if (throwable == null) {
            closeable.close();
            return;
        }
        try {
            closeable.close();
            return;
        }
        catch (Throwable throwable2) {
            tx8640.b((Object)throwable, "$receiver");
            tx8640.b((Object)throwable2, "exception");
            tx2880.a.a(throwable, throwable2);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static byte[] a(File file) {
        Throwable throwable3;
        Throwable throwable2;
        Closeable closeable;
        byte[] arrby;
        block8 : {
            tx8640.b((Object)file, "$receiver");
            closeable = (Closeable)new FileInputStream(file);
            throwable2 = null;
            try {
                FileInputStream fileInputStream = (FileInputStream)closeable;
                int n2 = 0;
                long l2 = file.length();
                if (l2 > Integer.MAX_VALUE) {
                    StringBuilder stringBuilder = new StringBuilder("File ");
                    stringBuilder.append((Object)file);
                    stringBuilder.append(" is too big (");
                    stringBuilder.append(l2);
                    stringBuilder.append(" bytes) to fit in memory.");
                    throw (Throwable)new OutOfMemoryError(stringBuilder.toString());
                }
                int n3 = (int)l2;
                arrby = new byte[n3];
                do {
                    int n4;
                    throwable2 = null;
                    if (n3 <= 0 || (n4 = fileInputStream.read(arrby, n2, n3)) < 0) break;
                    n3 -= n4;
                    n2 += n4;
                } while (true);
                if (n3 == 0) break block8;
                arrby = Arrays.copyOf((byte[])arrby, (int)n2);
                tx8640.a((Object)arrby, "java.util.Arrays.copyOf(this, newSize)");
            }
            catch (Throwable throwable3) {
            }
            catch (Throwable throwable4) {
                throwable2 = throwable4;
                throw throwable2;
            }
        }
        tx4320.a(closeable, null);
        return arrby;
        tx4320.a(closeable, throwable2);
        throw throwable3;
    }
}


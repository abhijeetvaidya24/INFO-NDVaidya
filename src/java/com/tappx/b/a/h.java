/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.SystemClock
 *  android.text.TextUtils
 *  java.io.BufferedInputStream
 *  java.io.BufferedOutputStream
 *  java.io.DataInputStream
 *  java.io.EOFException
 *  java.io.File
 *  java.io.FileInputStream
 *  java.io.FileOutputStream
 *  java.io.FilterInputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Collections
 *  java.util.Iterator
 *  java.util.LinkedHashMap
 *  java.util.List
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
package com.tappx.b.a;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tappx.b.a.j;
import com.tappx.b.b;
import com.tappx.b.g;
import com.tappx.b.v;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class h
implements com.tappx.b.b {
    private static final int e = 5242880;
    private static final float f = 0.9f;
    private static final int g = 538247942;
    private final Map<String, a> a = new LinkedHashMap(16, 0.75f, true);
    private long b = 0L;
    private final File c;
    private final int d;

    public h(File file) {
        this(file, 5242880);
    }

    public h(File file, int n2) {
        this.c = file;
        this.d = n2;
    }

    static int a(InputStream inputStream) {
        return 0 | h.c(inputStream) << 0 | h.c(inputStream) << 8 | h.c(inputStream) << 16 | h.c(inputStream) << 24;
    }

    static String a(b b2) {
        return new String(h.a(b2, h.b((InputStream)b2)), "UTF-8");
    }

    private void a(int n2) {
        long l2 = this.b;
        long l3 = n2;
        if (l2 + l3 < (long)this.d) {
            return;
        }
        if (v.b) {
            v.a("Pruning old cache entries.", new Object[0]);
        }
        long l4 = this.b;
        long l5 = SystemClock.elapsedRealtime();
        Iterator iterator = this.a.entrySet().iterator();
        int n3 = 0;
        while (iterator.hasNext()) {
            long l6;
            a a2 = ((Map.Entry)iterator.next()).getValue();
            if (this.c(a2.b).delete()) {
                long l7 = this.b;
                l6 = l3;
                this.b = l7 - a2.a;
            } else {
                l6 = l3;
                Object[] arrobject = new Object[]{a2.b, this.d(a2.b)};
                v.b("Could not delete cache entry for key=%s, filename=%s", arrobject);
            }
            iterator.remove();
            ++n3;
            if ((float)(l6 + this.b) < 0.9f * (float)this.d) break;
            l3 = l6;
        }
        if (v.b) {
            Object[] arrobject = new Object[]{n3, this.b - l4, SystemClock.elapsedRealtime() - l5};
            v.a("pruned %d files, %d bytes, %d ms", arrobject);
        }
    }

    static void a(OutputStream outputStream, int n2) {
        outputStream.write(255 & n2 >> 0);
        outputStream.write(255 & n2 >> 8);
        outputStream.write(255 & n2 >> 16);
        outputStream.write(255 & n2 >> 24);
    }

    static void a(OutputStream outputStream, long l2) {
        outputStream.write((int)((byte)(l2 >>> 0)));
        outputStream.write((int)((byte)(l2 >>> 8)));
        outputStream.write((int)((byte)(l2 >>> 16)));
        outputStream.write((int)((byte)(l2 >>> 24)));
        outputStream.write((int)((byte)(l2 >>> 32)));
        outputStream.write((int)((byte)(l2 >>> 40)));
        outputStream.write((int)((byte)(l2 >>> 48)));
        outputStream.write((int)((byte)(l2 >>> 56)));
    }

    static void a(OutputStream outputStream, String string) {
        byte[] arrby = string.getBytes("UTF-8");
        h.a(outputStream, (long)arrby.length);
        outputStream.write(arrby, 0, arrby.length);
    }

    private void a(String string, a a2) {
        if (!this.a.containsKey((Object)string)) {
            this.b += a2.a;
        } else {
            a a3 = this.a.get((Object)string);
            this.b += a2.a - a3.a;
        }
        this.a.put((Object)string, (Object)a2);
    }

    static void a(List<g> list, OutputStream outputStream) {
        if (list != null) {
            h.a(outputStream, list.size());
            for (g g2 : list) {
                h.a(outputStream, g2.a());
                h.a(outputStream, g2.b());
            }
        } else {
            h.a(outputStream, 0);
        }
    }

    static byte[] a(b b2, long l2) {
        int n2;
        long l3 = b2.b();
        if (l2 >= 0L && l2 <= l3 && (long)(n2 = (int)l2) == l2) {
            byte[] arrby = new byte[n2];
            new DataInputStream((InputStream)b2).readFully(arrby);
            return arrby;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("streamToBytes length=");
        stringBuilder.append(l2);
        stringBuilder.append(", maxLength=");
        stringBuilder.append(l3);
        throw new IOException(stringBuilder.toString());
    }

    static long b(InputStream inputStream) {
        return 0L | (255L & (long)h.c(inputStream)) << 0 | (255L & (long)h.c(inputStream)) << 8 | (255L & (long)h.c(inputStream)) << 16 | (255L & (long)h.c(inputStream)) << 24 | (255L & (long)h.c(inputStream)) << 32 | (255L & (long)h.c(inputStream)) << 40 | (255L & (long)h.c(inputStream)) << 48 | (255L & (long)h.c(inputStream)) << 56;
    }

    static List<g> b(b b2) {
        int n2 = h.a((InputStream)b2);
        Object object = n2 == 0 ? Collections.emptyList() : new ArrayList(n2);
        for (int i2 = 0; i2 < n2; ++i2) {
            object.add((Object)new g(h.a(b2).intern(), h.a(b2).intern()));
        }
        return object;
    }

    private static int c(InputStream inputStream) {
        int n2 = inputStream.read();
        if (n2 != -1) {
            return n2;
        }
        throw new EOFException();
    }

    private String d(String string) {
        int n2 = string.length() / 2;
        String string2 = String.valueOf((int)string.substring(0, n2).hashCode());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(String.valueOf((int)string.substring(n2).hashCode()));
        return stringBuilder.toString();
    }

    private void e(String string) {
        a a2 = this.a.remove((Object)string);
        if (a2 != null) {
            this.b -= a2.a;
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    @Override
    public b.a a(String string) {
        a a2;
        FilterInputStream filterInputStream;
        block12 : {
            h h2 = this;
            // MONITORENTER : h2
            a2 = this.a.get((Object)string);
            if (a2 == null) {
                // MONITOREXIT : h2
                return null;
            }
            File file = this.c(string);
            try {
                filterInputStream = new FilterInputStream((InputStream)new BufferedInputStream(this.a(file)), file.length()){
                    private final long a;
                    private long b;
                    {
                        this.a = l2;
                    }

                    long b() {
                        return this.a - this.b;
                    }

                    public int read() {
                        int n2 = super.read();
                        if (n2 != -1) {
                            this.b = 1L + this.b;
                        }
                        return n2;
                    }

                    public int read(byte[] arrby, int n2, int n3) {
                        int n4 = super.read(arrby, n2, n3);
                        if (n4 != -1) {
                            this.b += (long)n4;
                        }
                        return n4;
                    }
                };
            }
            catch (IOException iOException) {
                Object[] arrobject = new Object[]{file.getAbsolutePath(), iOException.toString()};
                v.b("%s: %s", arrobject);
                this.b(string);
                // MONITOREXIT : h2
                return null;
            }
            a a3 = a.a(filterInputStream);
            if (TextUtils.equals((CharSequence)string, (CharSequence)a3.b)) break block12;
            Object[] arrobject = new Object[]{file.getAbsolutePath(), string, a3.b};
            v.b("%s: key=%s, found=%s", arrobject);
            this.e(string);
            filterInputStream.close();
            // MONITOREXIT : h2
            return null;
        }
        b.a a4 = a2.a(h.a(filterInputStream, filterInputStream.b()));
        {
            catch (Throwable throwable) {
                filterInputStream.close();
                throw throwable;
            }
        }
        filterInputStream.close();
        // MONITOREXIT : h2
        return a4;
    }

    InputStream a(File file) {
        return new FileInputStream(file);
    }

    /*
     * Exception decompiling
     */
    @Override
    public void a() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl87 : IINC : trying to set 1 previously set to 0
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:919)
        throw new IllegalStateException("Decompilation failed");
    }

    @Override
    public void a(String string, b.a a2) {
        h h2 = this;
        synchronized (h2) {
            this.a(a2.a.length);
            File file = this.c(string);
            try {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(this.b(file));
                Object object = new Object(string, a2){
                    long a;
                    final String b;
                    final String c;
                    final long d;
                    final long e;
                    final long f;
                    final long g;
                    final List<g> h;
                    {
                        this(string, a2.b, a2.c, a2.d, a2.e, a2.f, a.a(a2));
                        this.a = a2.a.length;
                    }
                    {
                        this.b = string;
                        if ("".equals((Object)string2)) {
                            string2 = null;
                        }
                        this.c = string2;
                        this.d = l2;
                        this.e = l3;
                        this.f = l4;
                        this.g = l5;
                        this.h = list;
                    }

                    static a a(b b2) {
                        if (h.a((InputStream)b2) == 538247942) {
                            String string = h.a(b2);
                            String string2 = h.a(b2);
                            long l2 = h.b((InputStream)b2);
                            long l3 = h.b((InputStream)b2);
                            long l4 = h.b((InputStream)b2);
                            long l5 = h.b((InputStream)b2);
                            List<g> list = h.b(b2);
                            Object object = new /* invalid duplicate definition of identical inner class */;
                            return object;
                        }
                        throw new IOException();
                    }

                    private static List<g> a(b.a a2) {
                        if (a2.h != null) {
                            return a2.h;
                        }
                        return j.b(a2.g);
                    }

                    b.a a(byte[] arrby) {
                        b.a a2 = new b.a();
                        a2.a = arrby;
                        a2.b = this.c;
                        a2.c = this.d;
                        a2.d = this.e;
                        a2.e = this.f;
                        a2.f = this.g;
                        a2.g = j.a(this.h);
                        a2.h = Collections.unmodifiableList(this.h);
                        return a2;
                    }

                    /*
                     * Enabled aggressive block sorting
                     * Enabled unnecessary exception pruning
                     * Enabled aggressive exception aggregation
                     */
                    boolean a(OutputStream outputStream) {
                        try {
                            h.a(outputStream, 538247942);
                            h.a(outputStream, this.b);
                            String string = this.c == null ? "" : this.c;
                            h.a(outputStream, string);
                            h.a(outputStream, this.d);
                            h.a(outputStream, this.e);
                            h.a(outputStream, this.f);
                            h.a(outputStream, this.g);
                            h.a(this.h, outputStream);
                            outputStream.flush();
                            return true;
                        }
                        catch (IOException iOException) {
                            Object[] arrobject = new Object[]{iOException.toString()};
                            v.b("%s", arrobject);
                            return false;
                        }
                    }
                };
                if (object.a((OutputStream)bufferedOutputStream)) {
                    bufferedOutputStream.write(a2.a);
                    bufferedOutputStream.close();
                    this.a(string, object);
                    return;
                }
                bufferedOutputStream.close();
                Object[] arrobject = new Object[]{file.getAbsolutePath()};
                v.b("Failed to write header for %s", arrobject);
                throw new IOException();
            }
            catch (IOException iOException) {
                if (!file.delete()) {
                    Object[] arrobject = new Object[]{file.getAbsolutePath()};
                    v.b("Could not clean up file %s", arrobject);
                }
                return;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a(String string, boolean bl) {
        h h2 = this;
        synchronized (h2) {
            b.a a2 = this.a(string);
            if (a2 != null) {
                a2.f = 0L;
                if (bl) {
                    a2.e = 0L;
                }
                this.a(string, a2);
            }
            return;
        }
    }

    OutputStream b(File file) {
        return new FileOutputStream(file);
    }

    @Override
    public void b() {
        h h2 = this;
        synchronized (h2) {
            block7 : {
                File[] arrfile = this.c.listFiles();
                if (arrfile == null) break block7;
                int n2 = arrfile.length;
                for (int i2 = 0; i2 < n2; ++i2) {
                    arrfile[i2].delete();
                }
            }
            try {
                this.a.clear();
                this.b = 0L;
                v.b("Cache cleared.", new Object[0]);
                return;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void b(String string) {
        h h2 = this;
        synchronized (h2) {
            boolean bl = this.c(string).delete();
            this.e(string);
            if (!bl) {
                Object[] arrobject = new Object[]{string, this.d(string)};
                v.b("Could not delete cache entry for key=%s, filename=%s", arrobject);
            }
            return;
        }
    }

    public File c(String string) {
        return new File(this.c, this.d(string));
    }

}


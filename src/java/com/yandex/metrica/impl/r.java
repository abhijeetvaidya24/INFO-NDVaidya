/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.util.Base64
 *  com.yandex.metrica.YandexMetrica
 *  com.yandex.metrica.impl.bk
 *  java.io.ByteArrayInputStream
 *  java.io.ByteArrayOutputStream
 *  java.io.Closeable
 *  java.io.File
 *  java.io.FileInputStream
 *  java.io.FileNotFoundException
 *  java.io.FileOutputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.InputStreamReader
 *  java.io.Reader
 *  java.io.StringWriter
 *  java.io.UnsupportedEncodingException
 *  java.io.Writer
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.nio.channels.FileChannel
 *  java.nio.channels.FileLock
 *  java.util.HashMap
 *  java.util.Map
 *  java.util.zip.GZIPInputStream
 */
package com.yandex.metrica.impl;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.util.Base64;
import com.yandex.metrica.YandexMetrica;
import com.yandex.metrica.impl.bk;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;

public final class r {
    public static int a(Reader reader, Writer writer) throws IOException {
        int n2;
        char[] arrc = new char[4096];
        int n3 = 0;
        while (-1 != (n2 = reader.read(arrc, 0, 4096))) {
            writer.write(arrc, 0, n2);
            n3 += n2;
        }
        return n3;
    }

    public static String a(Context context, File file) {
        byte[] arrby = r.b(context, file);
        try {
            String string2 = new String(arrby, "UTF-8");
            return string2;
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            String string3 = new String(arrby);
            YandexMetrica.getReporter((Context)context, (String)"20799a27-fa80-4b36-b2db-0f8141f24180").reportError("read_share_file_with_unsupported_encoding", (Throwable)unsupportedEncodingException);
            return string3;
        }
    }

    public static String a(InputStream inputStream) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
        StringWriter stringWriter = new StringWriter();
        r.a((Reader)inputStreamReader, (Writer)stringWriter);
        return stringWriter.toString();
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static String a(String string2) throws IOException {
        void var3_6;
        FileInputStream fileInputStream;
        block4 : {
            String string3;
            fileInputStream = null;
            FileInputStream fileInputStream2 = new FileInputStream(string2);
            try {
                string3 = r.a((InputStream)fileInputStream2);
            }
            catch (Throwable throwable) {
                fileInputStream = fileInputStream2;
                break block4;
            }
            bk.a((Closeable)fileInputStream2);
            return string3;
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        bk.a(fileInputStream);
        throw var3_6;
    }

    public static void a(Context context, String string2, String string3) {
        try {
            if (bk.a((int)24)) {
                r.a(string3, context.openFileOutput(string2, 0));
                r.c(context, context.getFileStreamPath(string2));
                return;
            }
            r.a(string3, context.openFileOutput(string2, 1));
        }
        catch (FileNotFoundException fileNotFoundException) {}
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void a(String string2, FileOutputStream fileOutputStream) {
        FileLock fileLock = null;
        try {
            FileChannel fileChannel = fileOutputStream.getChannel();
            fileLock = fileChannel.lock();
            byte[] arrby = string2.getBytes("UTF-8");
            ByteBuffer byteBuffer = ByteBuffer.allocate((int)arrby.length);
            byteBuffer.put(arrby);
            byteBuffer.flip();
            fileChannel.write(byteBuffer);
            fileChannel.force(true);
            return;
        }
        catch (IOException iOException) {}
        return;
        finally {
            r.a(fileLock);
            bk.a((Closeable)fileOutputStream);
        }
    }

    /*
     * Exception decompiling
     */
    public static void a(FileLock var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Underrun type stack
        // org.benf.cfr.reader.b.a.c.e.a(StackSim.java:35)
        // org.benf.cfr.reader.b.b.af.a(OperationFactoryPop.java:20)
        // org.benf.cfr.reader.b.b.e.a(JVMInstr.java:315)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:195)
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

    /*
     * Exception decompiling
     */
    public static String b(String var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl54 : ALOAD_2 : trying to set 1 previously set to 0
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

    public static void b(Context context, String string2, String string3) {
        File file = new File(context.getNoBackupFilesDir(), string2);
        try {
            r.a(string3, new FileOutputStream(file));
            r.c(context, file);
        }
        catch (FileNotFoundException fileNotFoundException) {}
    }

    /*
     * Exception decompiling
     */
    public static byte[] b(Context var0, File var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Underrun type stack
        // org.benf.cfr.reader.b.a.c.e.a(StackSim.java:35)
        // org.benf.cfr.reader.b.b.af.a(OperationFactoryPop.java:20)
        // org.benf.cfr.reader.b.b.e.a(JVMInstr.java:315)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:195)
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

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static byte[] b(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return null;
        }
        byte[] arrby = new byte[8192];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        block4 : do {
            do {
                int n2;
                if (-1 == (n2 = inputStream.read(arrby))) {
                    byte[] arrby2 = byteArrayOutputStream.toByteArray();
                    return arrby2;
                }
                if (n2 <= 0) continue block4;
                byteArrayOutputStream.write(arrby, 0, n2);
            } while (true);
            break;
        } while (true);
        finally {
            bk.a((Closeable)byteArrayOutputStream);
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static String c(String string2) {
        ByteArrayInputStream byteArrayInputStream;
        String string3;
        GZIPInputStream gZIPInputStream;
        block9 : {
            Exception exception2;
            Throwable throwable;
            block10 : {
                string3 = null;
                byteArrayInputStream = new ByteArrayInputStream(Base64.decode((String)string2, (int)0));
                gZIPInputStream = new GZIPInputStream((InputStream)byteArrayInputStream);
                try {
                    string3 = r.a((InputStream)gZIPInputStream);
                    break block9;
                }
                catch (Exception exception2) {}
                break block9;
                catch (Throwable throwable2) {
                    string3 = gZIPInputStream;
                    throwable = throwable2;
                    break block10;
                }
                catch (Throwable throwable3) {
                    string3 = null;
                    break block10;
                }
                catch (Exception exception2) {
                    gZIPInputStream = null;
                    break block9;
                }
                catch (Throwable throwable4) {
                    byteArrayInputStream = null;
                }
            }
            bk.a(byteArrayInputStream);
            bk.a(string3);
            throw throwable;
            catch (Exception exception2) {
                byteArrayInputStream = null;
                gZIPInputStream = null;
            }
        }
        bk.a((Closeable)byteArrayInputStream);
        bk.a(gZIPInputStream);
        return string3;
    }

    public static void c(final Context context, final File file) {
        if (file.exists()) {
            file.setReadable(true, false);
            if (bk.a((int)24)) {
                new File(context.getApplicationInfo().dataDir).setExecutable(true, false);
                return;
            }
        } else {
            YandexMetrica.getReporter((Context)context, (String)"20799a27-fa80-4b36-b2db-0f8141f24180").reportEvent("make_non_existed_world_readable", (Map)new HashMap<String, Object>(){
                {
                    this.put((Object)"file_name", (Object)file.getName());
                    this.put((Object)"applicationId", (Object)context.getPackageName());
                }
            });
        }
    }

}


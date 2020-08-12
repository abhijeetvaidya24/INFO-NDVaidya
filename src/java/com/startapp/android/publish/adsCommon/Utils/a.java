/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  java.io.File
 *  java.io.FileOutputStream
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.Map
 *  java.util.concurrent.ConcurrentHashMap
 */
package com.startapp.android.publish.adsCommon.Utils;

import android.content.Context;
import android.graphics.Bitmap;
import com.startapp.common.g;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class a {
    private static final Map<String, Bitmap> a = new ConcurrentHashMap();

    public static Bitmap a(Context context, String string) {
        Bitmap bitmap = a.a(context, string, false);
        if (bitmap == null) {
            bitmap = a.a(context, string, true);
        }
        return bitmap;
    }

    /*
     * Exception decompiling
     */
    private static Bitmap a(Context var0, String var1, boolean var2) {
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

    static /* synthetic */ Map a() {
        return a;
    }

    public static void a(final Context context, final Bitmap bitmap, final String string, final String string2) {
        g.a(g.a.a, new Runnable(){

            /*
             * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
             * Unable to fully structure code
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             * Lifted jumps to return sites
             */
            public void run() {
                block12 : {
                    var1_1 = a.a();
                    var2_2 = new StringBuilder();
                    var2_2.append(string);
                    var2_2.append(string2);
                    var1_1.put((Object)var2_2.toString(), (Object)bitmap);
                    var6_3 = null;
                    var7_4 = new StringBuilder();
                    var7_4.append(context.getFilesDir().getPath());
                    var7_4.append("/");
                    var7_4.append(string);
                    var7_4.append(".png");
                    var16_5 = new FileOutputStream(var7_4.toString());
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)var16_5);
                    var16_5.close();
                    return;
                    catch (Throwable var18_6) {
                        var10_7 = var18_6;
                        var6_3 = var16_5;
                        break block12;
                    }
                    catch (Exception var17_9) {
                        var8_10 = var17_9;
                        var6_3 = var16_5;
                        ** GOTO lbl-1000
                    }
                    catch (Throwable var10_8) {
                        break block12;
                    }
                    catch (Exception var8_11) {
                        // empty catch block
                    }
lbl-1000: // 2 sources:
                    {
                        var8_10.printStackTrace();
                        if (var6_3 == null) return;
                    }
                    try {
                        var6_3.close();
                        return;
                    }
                    catch (IOException var9_12) {
                        var9_12.printStackTrace();
                    }
                    return;
                }
                if (var6_3 == null) throw var10_7;
                try {
                    var6_3.close();
                    throw var10_7;
                }
                catch (IOException var11_13) {
                    var11_13.printStackTrace();
                }
                throw var10_7;
            }
        });
    }

    public static boolean a(Context context, String string, String string2) {
        Map<String, Bitmap> map = a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(string2);
        if (!map.containsKey((Object)stringBuilder.toString())) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(context.getFilesDir().getPath());
            stringBuilder2.append("/");
            stringBuilder2.append(string);
            if (!new File(stringBuilder2.toString()).exists()) {
                return false;
            }
        }
        return true;
    }

}


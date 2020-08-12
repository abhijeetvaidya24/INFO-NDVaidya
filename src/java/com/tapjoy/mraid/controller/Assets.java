/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.AlertDialog
 *  android.app.AlertDialog$Builder
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.os.Environment
 *  android.os.StatFs
 *  android.webkit.JavascriptInterface
 *  java.io.File
 *  java.io.FileOutputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.net.URL
 */
package com.tapjoy.mraid.controller;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Environment;
import android.os.StatFs;
import android.webkit.JavascriptInterface;
import com.tapjoy.TapjoyLog;
import com.tapjoy.internal.da;
import com.tapjoy.internal.em;
import com.tapjoy.mraid.controller.Abstract;
import com.tapjoy.mraid.controller.Assets;
import com.tapjoy.mraid.view.MraidView;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class Assets
extends Abstract {
    private static final char[] d = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private int c = 0;

    public Assets(MraidView mraidView, Context context) {
        super(mraidView, context);
    }

    private File a(String string) {
        File file = this.b.getFilesDir();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(file.getPath());
        stringBuilder.append(File.separator);
        stringBuilder.append(string);
        return new File(stringBuilder.toString());
    }

    private String a() {
        return this.b.getFilesDir().getPath();
    }

    private static String b(String string) {
        if (string.lastIndexOf((int)File.separatorChar) >= 0) {
            return string.substring(0, string.lastIndexOf((int)File.separatorChar));
        }
        return "/";
    }

    private static String c(String string) {
        if (string.lastIndexOf((int)File.separatorChar) >= 0) {
            string = string.substring(1 + string.lastIndexOf((int)File.separatorChar));
        }
        return string;
    }

    public static boolean deleteDirectory(File file) {
        if (file.exists()) {
            File[] arrfile = file.listFiles();
            for (int i2 = 0; i2 < arrfile.length; ++i2) {
                if (arrfile[i2].isDirectory()) {
                    Assets.deleteDirectory(arrfile[i2]);
                    continue;
                }
                arrfile[i2].delete();
            }
        }
        return file.delete();
    }

    public static boolean deleteDirectory(String string) {
        if (string != null) {
            return Assets.deleteDirectory(new File(string));
        }
        return false;
    }

    /*
     * Exception decompiling
     */
    public void addAsset(String var1, String var2) {
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

    public int cacheRemaining() {
        StatFs statFs = new StatFs(this.b.getFilesDir().getPath());
        return statFs.getFreeBlocks() * statFs.getBlockSize();
    }

    /*
     * Exception decompiling
     */
    public String copyTextFromJarIntoAssetDir(String var1, String var2) {
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

    public void deleteOldAds() {
        String string = this.a();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(File.separator);
        stringBuilder.append("ad");
        Assets.deleteDirectory(new File(stringBuilder.toString()));
    }

    public FileOutputStream getAssetOutputString(String string) {
        File file = this.a(Assets.b(string));
        file.mkdirs();
        return new FileOutputStream(new File(file, Assets.c(string)));
    }

    public String getAssetPath() {
        StringBuilder stringBuilder = new StringBuilder("file://");
        stringBuilder.append((Object)this.b.getFilesDir());
        stringBuilder.append("/");
        return stringBuilder.toString();
    }

    public void removeAsset(String string) {
        File file = this.a(Assets.b(string));
        file.mkdirs();
        new File(file, Assets.c(string)).delete();
        StringBuilder stringBuilder = new StringBuilder("MraidAdController.assetRemoved('");
        stringBuilder.append(string);
        stringBuilder.append("' )");
        String string2 = stringBuilder.toString();
        this.a.injectMraidJavaScript(string2);
    }

    @Override
    public void stopAllListeners() {
    }

    public void storePicture(String string) {
        StringBuilder stringBuilder = new StringBuilder("Storing media from ");
        stringBuilder.append(string);
        stringBuilder.append(" to device photo album.  Output directory: ");
        stringBuilder.append((Object)Environment.getExternalStorageDirectory());
        stringBuilder.append(" state: ");
        stringBuilder.append(Environment.getExternalStorageState());
        TapjoyLog.d("MRAID Assets", stringBuilder.toString());
        this.c = 1 + this.c;
        try {
            URL uRL = new URL(string);
            StringBuilder stringBuilder2 = new StringBuilder("MraidMedia");
            stringBuilder2.append(this.c);
            stringBuilder2.append(".jpg");
            String string2 = stringBuilder2.toString();
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(Environment.getExternalStorageDirectory().toString());
            stringBuilder3.append("/");
            stringBuilder3.append(string2);
            File file = new File(stringBuilder3.toString());
            long l2 = System.currentTimeMillis();
            TapjoyLog.d("MRAID Assets", "download beginning");
            StringBuilder stringBuilder4 = new StringBuilder("download url:");
            stringBuilder4.append((Object)uRL);
            TapjoyLog.d("MRAID Assets", stringBuilder4.toString());
            StringBuilder stringBuilder5 = new StringBuilder("downloaded file name:");
            stringBuilder5.append(string2);
            TapjoyLog.d("MRAID Assets", stringBuilder5.toString());
            InputStream inputStream = em.a(uRL).getInputStream();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            da.a(inputStream, (OutputStream)fileOutputStream);
            fileOutputStream.close();
            StringBuilder stringBuilder6 = new StringBuilder("download ready in");
            stringBuilder6.append((System.currentTimeMillis() - l2) / 1000L);
            stringBuilder6.append(" sec");
            TapjoyLog.d("MRAID Assets", stringBuilder6.toString());
            return;
        }
        catch (IOException iOException) {
            StringBuilder stringBuilder7 = new StringBuilder("Error: ");
            stringBuilder7.append((Object)iOException);
            TapjoyLog.d("MRAID Assets", stringBuilder7.toString());
            return;
        }
    }

    @JavascriptInterface
    public void storePictureInit(String string) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.b);
        StringBuilder stringBuilder = new StringBuilder("Are you sure you want to save file from ");
        stringBuilder.append(string);
        stringBuilder.append(" to your SD card?");
        builder.setMessage((CharSequence)stringBuilder.toString());
        builder.setCancelable(false);
        builder.setPositiveButton((CharSequence)"Yes", new DialogInterface.OnClickListener(this, string){
            final /* synthetic */ String a;
            final /* synthetic */ Assets b;
            {
                this.b = assets;
                this.a = string;
            }

            public final void onClick(DialogInterface dialogInterface, int n2) {
                this.b.storePicture(this.a);
            }
        });
        builder.setNegativeButton((CharSequence)"No", null);
        builder.show();
    }

    /*
     * Exception decompiling
     */
    public String writeToDisk(InputStream var1, String var2, boolean var3) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl49.1 : ALOAD_0 : trying to set 1 previously set to 0
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
}


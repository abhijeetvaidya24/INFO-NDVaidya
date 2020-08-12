/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.AssetManager
 *  java.io.File
 *  java.io.FileOutputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 */
package com.github.barteksc.pdfviewer.util;

import android.content.Context;
import android.content.res.AssetManager;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileUtils {
    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static void copy(InputStream inputStream, File file) throws IOException {
        FileOutputStream fileOutputStream;
        void var3_8;
        block12 : {
            fileOutputStream = new FileOutputStream(file);
            try {
                int n2;
                byte[] arrby = new byte[1024];
                while ((n2 = inputStream.read(arrby)) != -1) {
                    fileOutputStream.write(arrby, 0, n2);
                }
                if (inputStream == null) return;
            }
            catch (Throwable throwable) {}
            try {
                inputStream.close();
                return;
            }
            finally {
                fileOutputStream.close();
            }
            break block12;
            catch (Throwable throwable) {
                fileOutputStream = null;
            }
        }
        if (inputStream == null) throw var3_8;
        try {
            inputStream.close();
            throw var3_8;
        }
        finally {
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        }
    }

    public static File fileFromAsset(Context context, String string) throws IOException {
        File file = context.getCacheDir();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append("-pdfview.pdf");
        File file2 = new File(file, stringBuilder.toString());
        if (string.contains((CharSequence)"/")) {
            file2.getParentFile().mkdirs();
        }
        FileUtils.copy(context.getAssets().open(string), file2);
        return file2;
    }
}


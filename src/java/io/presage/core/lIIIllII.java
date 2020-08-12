/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.StatFs
 *  java.io.File
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Arrays
 *  java.util.Comparator
 */
package io.presage.core;

import android.os.StatFs;
import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public final class lIIIllII {
    public static long IIIIIIII = 0xA00000L;

    public static void IIIIIIII(File file) {
        if (file != null) {
            if (!file.exists()) {
                return;
            }
            if (file.isDirectory()) {
                File[] arrfile = file.listFiles();
                if (arrfile != null) {
                    int n2 = arrfile.length;
                    for (int i2 = 0; i2 < n2; ++i2) {
                        lIIIllII.IIIIIIII(arrfile[i2]);
                    }
                }
                return;
            }
            file.delete();
        }
    }

    public static void IIIIIIII(File[] arrfile, final boolean bl2) {
        if (arrfile == null) {
            return;
        }
        Arrays.sort((Object[])arrfile, (Comparator)new Comparator<File>(){

            public final /* synthetic */ int compare(Object object, Object object2) {
                File file = (File)object;
                File file2 = (File)object2;
                if (file.lastModified() == file2.lastModified()) {
                    return 0;
                }
                int n2 = file.lastModified() > file2.lastModified() ? 1 : -1;
                if (bl2) {
                    n2 *= -1;
                }
                return n2;
            }
        });
    }

    public static long IIIIIIIl(File file) {
        if (file != null) {
            StatFs statFs = new StatFs(file.getAbsolutePath());
            return (long)statFs.getAvailableBlocks() * (long)statFs.getBlockSize();
        }
        return -1L;
    }

}


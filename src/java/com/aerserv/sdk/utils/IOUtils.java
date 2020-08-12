/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.InputStreamReader
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.aerserv.sdk.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class IOUtils {
    private static final int BUFFER_SIZE = 4096;

    public static boolean deleteDirectory(File file) {
        File[] arrfile;
        if (file != null && file.exists() && (arrfile = file.listFiles()) != null) {
            for (File file2 : arrfile) {
                if (file2.isDirectory()) {
                    IOUtils.deleteDirectory(file2);
                    continue;
                }
                file2.delete();
            }
        }
        return file.delete();
    }

    public static String inputStreamToString(InputStream inputStream, String string) throws IOException {
        int n2;
        StringBuilder stringBuilder = new StringBuilder();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, string);
        char[] arrc = new char[4096];
        while ((n2 = inputStreamReader.read(arrc)) != -1) {
            stringBuilder.append(arrc, 0, n2);
        }
        return stringBuilder.toString();
    }
}


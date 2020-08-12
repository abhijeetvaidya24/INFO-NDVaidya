/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.io.File
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.aerserv.sdk.utils;

import android.content.Context;
import java.io.File;

public class VideoFileName {
    private String file;
    private String fileName;
    private String path;
    private String url;

    public VideoFileName(Context context, String string) {
        this.url = string;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string.replaceFirst(".*/", ""));
        stringBuilder.append(".aerserv");
        this.fileName = stringBuilder.toString();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(context.getExternalFilesDir(null).getAbsolutePath());
        stringBuilder2.append("/aerserv/");
        stringBuilder2.append(string.substring(0, string.lastIndexOf(47)).replaceAll("[^a-zA-Z0-9\\.\\-]+", "/"));
        this.path = stringBuilder2.toString();
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(this.path);
        stringBuilder3.append("/");
        stringBuilder3.append(this.fileName);
        this.file = stringBuilder3.toString();
    }

    public String getFile() {
        return this.file;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getPath() {
        return this.path;
    }

    public String getUrl() {
        return this.url;
    }
}


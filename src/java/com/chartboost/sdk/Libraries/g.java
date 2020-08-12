/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.lang.Object
 *  java.lang.String
 */
package com.chartboost.sdk.Libraries;

import java.io.File;

public class g {
    public final File a;
    public final File b;
    public final File c;
    public final File d;
    public final File e;
    public final File f;
    public final File g;

    g(File file) {
        this.a = new File(file, ".chartboost");
        if (!this.a.exists()) {
            this.a.mkdirs();
        }
        this.b = g.a(this.a, "css");
        this.c = g.a(this.a, "html");
        this.d = g.a(this.a, "images");
        this.e = g.a(this.a, "js");
        this.f = g.a(this.a, "templates");
        this.g = g.a(this.a, "videos");
    }

    private static File a(File file, String string2) {
        File file2 = new File(file, string2);
        if (!file2.exists()) {
            file2.mkdir();
        }
        return file2;
    }
}


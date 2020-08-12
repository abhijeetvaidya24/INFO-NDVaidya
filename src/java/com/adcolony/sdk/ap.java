/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.StatFs
 *  java.io.File
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.adcolony.sdk;

import android.content.Context;
import android.os.StatFs;
import com.adcolony.sdk.a;
import com.adcolony.sdk.l;
import com.adcolony.sdk.y;
import java.io.File;

class ap {
    private String a;
    private String b;
    private String c;
    private String d;
    private File e;
    private File f;
    private File g;

    ap() {
    }

    double a(String string) {
        int n2;
        long l2;
        try {
            StatFs statFs = new StatFs(string);
            l2 = statFs.getBlockSize();
            n2 = statFs.getAvailableBlocks();
        }
        catch (RuntimeException runtimeException) {
            return 0.0;
        }
        return l2 * (long)n2;
    }

    boolean a() {
        new y.a().a("Configuring storage").a(y.d);
        l l2 = a.a();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.c());
        stringBuilder.append("/adc3/");
        this.a = stringBuilder.toString();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(this.a);
        stringBuilder2.append("media/");
        this.b = stringBuilder2.toString();
        this.e = new File(this.b);
        if (!this.e.isDirectory()) {
            this.e.delete();
            this.e.mkdirs();
        }
        if (!this.e.isDirectory()) {
            l2.a(true);
            return false;
        }
        if (this.a(this.b) < 2.097152E7) {
            new y.a().a("Not enough memory available at media path, disabling AdColony.").a(y.e);
            l2.a(true);
            return false;
        }
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(this.c());
        stringBuilder3.append("/adc3/data/");
        this.c = stringBuilder3.toString();
        this.f = new File(this.c);
        if (!this.f.isDirectory()) {
            this.f.delete();
        }
        this.f.mkdirs();
        StringBuilder stringBuilder4 = new StringBuilder();
        stringBuilder4.append(this.a);
        stringBuilder4.append("tmp/");
        this.d = stringBuilder4.toString();
        this.g = new File(this.d);
        if (!this.g.isDirectory()) {
            this.g.delete();
            this.g.mkdirs();
        }
        return true;
    }

    boolean b() {
        File file = this.e;
        if (file != null && this.f != null && this.g != null) {
            if (!file.isDirectory()) {
                this.e.delete();
            }
            if (!this.f.isDirectory()) {
                this.f.delete();
            }
            if (!this.g.isDirectory()) {
                this.g.delete();
            }
            this.e.mkdirs();
            this.f.mkdirs();
            this.g.mkdirs();
            return true;
        }
        return false;
    }

    String c() {
        Context context = a.c();
        if (context == null) {
            return "";
        }
        return context.getFilesDir().getAbsolutePath();
    }

    String d() {
        return this.b;
    }

    String e() {
        return this.c;
    }

    String f() {
        return this.d;
    }

    String g() {
        return this.a;
    }
}


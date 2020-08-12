/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.adincube.sdk.d.c.a
 *  com.adincube.sdk.d.c.d
 *  com.adincube.sdk.h.a.a.a
 *  com.adincube.sdk.j.b
 *  com.adincube.sdk.j.b$b
 *  com.adincube.sdk.j.d$a
 *  java.io.File
 *  java.io.FileOutputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.net.HttpURLConnection
 *  java.net.URL
 */
package com.adincube.sdk.j;

import android.content.Context;
import com.adincube.sdk.j.b;
import com.adincube.sdk.j.d;
import com.adincube.sdk.util.f;
import com.adincube.sdk.util.n;
import com.adincube.sdk.util.q;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public final class d
extends b {
    public com.adincube.sdk.h.a.a.a a = null;
    public a b = null;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected final void g() {
        int n2;
        HttpURLConnection httpURLConnection;
        block9 : {
            httpURLConnection = null;
            try {
                httpURLConnection = super.a(this.a.c(), "GET");
                n2 = httpURLConnection.getResponseCode();
                if (n2 == 200) {
                    Context context = f.a();
                    InputStream inputStream = q.a(httpURLConnection);
                    com.adincube.sdk.h.a.a.a a2 = this.a;
                    try {
                        int n3;
                        FileOutputStream fileOutputStream = context.openFileOutput(n.a(a2), 0);
                        byte[] arrby = new byte[1024];
                        while ((n3 = inputStream.read(arrby)) != -1) {
                            fileOutputStream.write(arrby, 0, n3);
                        }
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        context.getFileStreamPath(n.a(a2)).renameTo(context.getFileStreamPath(n.b(a2)));
                    }
                    catch (IOException iOException) {
                        com.adincube.sdk.util.a.c("writeAdResource() IOException", new Object[]{iOException});
                        context.getFileStreamPath(n.a(a2)).delete();
                        context.getFileStreamPath(n.b(a2)).delete();
                        throw iOException;
                    }
                    this.b.a(this.a);
                }
                if (n2 < 400) break block9;
            }
            catch (Throwable throwable) {
                if (httpURLConnection == null) throw throwable;
                httpURLConnection.disconnect();
                throw throwable;
            }
            if (n2 < 500) throw new com.adincube.sdk.d.c.a(n2);
        }
        if (n2 < 500) {
            if (httpURLConnection == null) return;
            httpURLConnection.disconnect();
            return;
        }
        StringBuilder stringBuilder = new StringBuilder("Server Error : ");
        stringBuilder.append(n2);
        throw new com.adincube.sdk.d.c.d(stringBuilder.toString());
    }

    protected final b.b h() {
        return b.b.a;
    }

    protected final String i() {
        return "DownloadAdResource";
    }
}


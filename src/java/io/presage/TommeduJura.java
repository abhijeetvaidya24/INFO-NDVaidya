/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.DownloadManager
 *  android.app.DownloadManager$Request
 *  android.content.Context
 *  android.net.Uri
 *  android.os.Environment
 *  android.webkit.DownloadListener
 *  android.widget.Toast
 *  io.presage.at
 *  io.presage.dt
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.List
 *  java.util.UUID
 */
package io.presage;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.webkit.DownloadListener;
import android.widget.Toast;
import io.presage.Mascare;
import io.presage.ak;
import io.presage.at;
import io.presage.cl;
import io.presage.dt;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

public final class TommeduJura
implements DownloadListener {
    private final Context a;

    public TommeduJura(Context context) {
        this.a = context;
    }

    public final void onDownloadStart(String string2, String string3, String string4, String string5, long l2) {
        String string6;
        if (!Mascare.a(this.a, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            return;
        }
        Uri uri = Uri.parse((String)string2);
        cl.a((Object)uri, "uri");
        String string7 = uri.getPath();
        cl.a((Object)string7, "uri.path");
        CharSequence charSequence = string7;
        List list = new dt("/").b(charSequence);
        if (true ^ ((Collection)list).isEmpty()) {
            string6 = (String)at.d((List)list);
        } else {
            string6 = UUID.randomUUID().toString();
            cl.a((Object)string6, "UUID.randomUUID().toString()");
        }
        DownloadManager.Request request = new DownloadManager.Request(uri);
        request.setTitle((CharSequence)string6);
        request.allowScanningByMediaScanner();
        request.setNotificationVisibility(1);
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "download");
        Object object = this.a.getSystemService("download");
        if (object != null) {
            ((DownloadManager)object).enqueue(request);
            Context context = this.a;
            String string8 = String.format((String)"Start downloading %s", (Object[])Arrays.copyOf((Object[])new Object[]{string6}, (int)1));
            cl.a((Object)string8, "java.lang.String.format(format, *args)");
            Toast.makeText((Context)context, (CharSequence)string8, (int)0).show();
            return;
        }
        throw new ak("null cannot be cast to non-null type android.app.DownloadManager");
    }
}


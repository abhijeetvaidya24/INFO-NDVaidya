/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.DownloadManager
 *  android.app.DownloadManager$Request
 *  android.content.Context
 *  android.net.Uri
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Environment
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.aerserv.sdk.controller.command;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import com.aerserv.sdk.controller.command.Command;
import com.aerserv.sdk.utils.AerServLog;

public class DownloadImageCommand
implements Command {
    private Context context;
    private String url;

    public DownloadImageCommand(Context context, String string) {
        this.context = context;
        this.url = string;
    }

    @Override
    public void execute() {
        String string = this.getClass().getName();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Downloading image: ");
        stringBuilder.append(this.url);
        AerServLog.d(string, stringBuilder.toString());
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse((String)this.url));
        String string2 = Environment.DIRECTORY_DOWNLOADS;
        String string3 = this.url;
        request.setDestinationInExternalPublicDir(string2, string3.substring(1 + string3.lastIndexOf(47)));
        if (Build.VERSION.SDK_INT > 10) {
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(1);
        }
        ((DownloadManager)this.context.getSystemService("download")).enqueue(request);
    }
}


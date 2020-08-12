/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.media.MediaScannerConnection
 *  android.media.MediaScannerConnection$MediaScannerConnectionClient
 *  android.net.Uri
 *  java.io.File
 *  java.lang.Object
 *  java.lang.String
 */
package com.tappx.a.a.b;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import java.io.File;

public class r {
    private final Context a;
    private MediaScannerConnection b;
    private String c;
    private String d;
    private final MediaScannerConnection.MediaScannerConnectionClient e = new MediaScannerConnection.MediaScannerConnectionClient(){

        public void onMediaScannerConnected() {
            if (r.this.b != null) {
                r.this.b.scanFile(r.this.c, r.this.d);
            }
        }

        public void onScanCompleted(String string2, Uri uri) {
            if (r.this.b != null) {
                r.this.b.disconnect();
            }
        }
    };

    public r(Context context) {
        this.a = context.getApplicationContext();
    }

    public void a(File file, String string2) {
        this.a(file.getAbsolutePath(), string2);
    }

    public void a(String string2, String string3) {
        this.c = string2;
        this.d = string3;
        this.b = new MediaScannerConnection(this.a, this.e);
        this.b.connect();
    }

}


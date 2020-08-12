/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.ActivityNotFoundException
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.AsyncTask
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Void
 */
package com.tappx.a.a.b;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import com.tappx.a.a.b.al;
import com.tappx.a.a.b.h;

public class q {
    void a(Context context, String string2) {
        al.a(new a(context), string2);
    }

    private static final class a
    extends AsyncTask<String, Void, Uri> {
        private final Context d;

        private a(Context context) {
            this.d = context;
        }

        private String a(String string2) {
            return string2;
        }

        private void a(Intent intent) {
            if (!(this.d instanceof Activity)) {
                intent.addFlags(268435456);
            }
            try {
                this.d.startActivity(intent);
            }
            catch (ActivityNotFoundException activityNotFoundException) {}
        }

        private void b(Uri uri) {
            if (this.d(uri)) {
                return;
            }
            if (this.c(uri)) {
                this.f(uri);
                return;
            }
            this.e(uri);
        }

        private boolean c(Uri uri) {
            String string2 = uri.getScheme();
            return "http".equalsIgnoreCase(string2) || "https".equalsIgnoreCase(string2);
            {
            }
        }

        private boolean d(Uri uri) {
            return "about".equalsIgnoreCase(uri.getScheme());
        }

        private void e(Uri uri) {
            this.f(uri);
        }

        private void f(Uri uri) {
            Intent intent = new Intent("android.intent.action.VIEW", uri);
            if (h.a(this.d, intent)) {
                this.a(intent);
            }
        }

        protected /* varargs */ Uri a(String ... arrstring) {
            String string2 = this.a(arrstring[0]);
            if (string2 == null) {
                return null;
            }
            return Uri.parse((String)string2);
        }

        protected void a(Uri uri) {
            if (uri == null) {
                return;
            }
            this.b(uri);
        }

        protected /* synthetic */ Object doInBackground(Object[] arrobject) {
            return this.a((String[])arrobject);
        }

        protected /* synthetic */ void onPostExecute(Object object) {
            this.a((Uri)object);
        }
    }

}


/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.BitmapFactory
 *  android.graphics.BitmapFactory$Options
 *  com.chartboost.sdk.Tracking.a
 *  com.chartboost.sdk.e
 *  com.chartboost.sdk.impl.al
 *  java.io.File
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.OutOfMemoryError
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  org.json.JSONObject
 */
package com.chartboost.sdk.Libraries;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.e;
import com.chartboost.sdk.Libraries.f;
import com.chartboost.sdk.Model.c;
import com.chartboost.sdk.impl.al;
import java.io.File;
import org.json.JSONObject;

public class h {
    private a a;
    private final com.chartboost.sdk.e b;
    private String c;
    private float d = 1.0f;

    public h(com.chartboost.sdk.e e2) {
        this.b = e2;
    }

    public int a() {
        return this.a.e() * this.a.c();
    }

    public boolean a(String string2) {
        return this.a(this.b.g(), string2);
    }

    public boolean a(JSONObject jSONObject, String string2) {
        JSONObject jSONObject2 = e.a(jSONObject, string2);
        this.c = string2;
        if (jSONObject2 == null) {
            return true;
        }
        String string3 = jSONObject2.optString("url");
        this.d = (float)jSONObject2.optDouble("scale", 1.0);
        if (string3.isEmpty()) {
            return true;
        }
        String string4 = jSONObject2.optString("checksum");
        if (string4.isEmpty()) {
            return false;
        }
        this.a = this.b.e.j.a(string4);
        return this.a != null;
    }

    public int b() {
        return this.a.f() * this.a.c();
    }

    public void c() {
        a a2 = this.a;
        if (a2 != null) {
            a2.d();
        }
    }

    public boolean d() {
        return this.a != null;
    }

    public Bitmap e() {
        a a2 = this.a;
        if (a2 != null) {
            return a2.a();
        }
        return null;
    }

    public float f() {
        return this.d;
    }

    public static class a {
        private int a;
        private final String b;
        private final File c;
        private Bitmap d;
        private final f e;
        private int f = -1;
        private int g = -1;

        public a(String string2, File file, f f2) {
            this.c = file;
            this.b = string2;
            this.d = null;
            this.a = 1;
            this.e = f2;
        }

        private void g() {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile((String)this.c.getAbsolutePath(), (BitmapFactory.Options)options);
                this.f = options.outWidth;
                this.g = options.outHeight;
                return;
            }
            catch (Exception exception) {
                CBLogging.a("MemoryBitmap", "Error decoding file size", exception);
                com.chartboost.sdk.Tracking.a.a((Class)this.getClass(), (String)"decodeSize", (Exception)exception);
                return;
            }
        }

        public Bitmap a() {
            if (this.d == null) {
                this.b();
            }
            return this.d;
        }

        /*
         * Loose catch block
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         * Lifted jumps to return sites
         */
        public void b() {
            if (this.d != null) {
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Loading image '");
            stringBuilder.append(this.b);
            stringBuilder.append("' from cache");
            CBLogging.a("MemoryBitmap", stringBuilder.toString());
            byte[] arrby = this.e.a(this.c);
            if (arrby == null) {
                CBLogging.b("MemoryBitmap", "decode() - bitmap not found");
                return;
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray((byte[])arrby, (int)0, (int)arrby.length, (BitmapFactory.Options)options);
            BitmapFactory.Options options2 = new BitmapFactory.Options();
            options2.inJustDecodeBounds = false;
            options2.inDither = false;
            options2.inPurgeable = true;
            options2.inInputShareable = true;
            options2.inTempStorage = new byte[32768];
            options2.inSampleSize = 1;
            while (options2.inSampleSize < 32) {
                try {
                    this.d = BitmapFactory.decodeByteArray((byte[])arrby, (int)0, (int)arrby.length, (BitmapFactory.Options)options2);
                }
                catch (Exception exception) {
                    CBLogging.a("MemoryBitmap", "Exception raised decoding bitmap", exception);
                    com.chartboost.sdk.Tracking.a.a((Class)this.getClass(), (String)"decodeByteArray", (Exception)exception);
                }
                if (this.d != null) break;
                this.c.delete();
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Unable to decode ");
                stringBuilder2.append(this.b);
                throw new RuntimeException(stringBuilder2.toString());
                catch (OutOfMemoryError outOfMemoryError) {
                    CBLogging.a("MemoryBitmap", "OutOfMemoryError suppressed - trying larger sample size", outOfMemoryError);
                    options2.inSampleSize = 2 * options2.inSampleSize;
                }
            }
            this.a = options2.inSampleSize;
        }

        public int c() {
            return this.a;
        }

        public void d() {
            try {
                if (this.d != null && !this.d.isRecycled()) {
                    this.d.recycle();
                }
            }
            catch (Exception exception) {
                com.chartboost.sdk.Tracking.a.a((Class)this.getClass(), (String)"recycle", (Exception)exception);
            }
            this.d = null;
        }

        public int e() {
            Bitmap bitmap = this.d;
            if (bitmap != null) {
                return bitmap.getWidth();
            }
            int n2 = this.f;
            if (n2 >= 0) {
                return n2;
            }
            this.g();
            return this.f;
        }

        public int f() {
            Bitmap bitmap = this.d;
            if (bitmap != null) {
                return bitmap.getHeight();
            }
            int n2 = this.g;
            if (n2 >= 0) {
                return n2;
            }
            this.g();
            return this.g;
        }
    }

}


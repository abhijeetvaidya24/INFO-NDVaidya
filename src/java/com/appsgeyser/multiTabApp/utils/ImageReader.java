/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.BitmapFactory
 *  android.graphics.BitmapFactory$Options
 *  android.util.Base64
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 */
package com.appsgeyser.multiTabApp.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import java.io.IOException;
import java.io.InputStream;

public class ImageReader {
    public static Bitmap createBitmapFromBase64(String string2) {
        if (string2.equals((Object)"")) {
            return null;
        }
        byte[] arrby = Base64.decode((String)string2.replace((CharSequence)"data:image/png;base64,", (CharSequence)""), (int)0);
        return BitmapFactory.decodeByteArray((byte[])arrby, (int)0, (int)arrby.length);
    }

    public static Bitmap decodeFile(InputStream inputStream, int n2) {
        if (n2 == 0) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        int n3 = 1;
        options.inJustDecodeBounds = n3;
        BitmapFactory.decodeStream((InputStream)inputStream, null, (BitmapFactory.Options)options);
        while (options.outWidth / n3 / 2 >= n2 && options.outHeight / n3 / 2 >= n2) {
            n3 *= 2;
        }
        BitmapFactory.Options options2 = new BitmapFactory.Options();
        options2.inSampleSize = n3;
        try {
            inputStream.reset();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            return null;
        }
        return BitmapFactory.decodeStream((InputStream)inputStream, null, (BitmapFactory.Options)options2);
    }
}


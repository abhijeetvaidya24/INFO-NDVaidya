/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.BitmapFactory
 *  android.provider.MediaStore
 *  android.provider.MediaStore$Images
 *  android.provider.MediaStore$Images$Media
 *  com.amazon.device.ads.MobileAdsLogger
 *  java.io.BufferedInputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Object
 *  java.lang.String
 */
package com.amazon.device.ads;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.MediaStore;
import com.amazon.device.ads.MobileAdsLogger;
import com.amazon.device.ads.MobileAdsLoggerFactory;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

class GraphicsUtils {
    private static final String LOGTAG = "GraphicsUtils";
    private final MobileAdsLogger logger = new MobileAdsLoggerFactory().createMobileAdsLogger(LOGTAG);

    GraphicsUtils() {
    }

    public Bitmap createBitmapImage(InputStream inputStream) {
        if (inputStream != null) {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 32768);
            bufferedInputStream.mark(32768);
            Bitmap bitmap = BitmapFactory.decodeStream((InputStream)bufferedInputStream);
            try {
                bufferedInputStream.close();
                return bitmap;
            }
            catch (IOException iOException) {
                this.logger.e("IOException while trying to close the input stream.");
                return bitmap;
            }
        }
        return null;
    }

    public String insertImageInMediaStore(Context context, Bitmap bitmap, String string, String string2) {
        return MediaStore.Images.Media.insertImage((ContentResolver)context.getContentResolver(), (Bitmap)bitmap, (String)string, (String)string2);
    }
}


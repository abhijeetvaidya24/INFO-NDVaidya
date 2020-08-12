/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.Picture
 *  android.util.Base64
 *  android.webkit.WebView
 *  java.io.ByteArrayOutputStream
 *  java.io.OutputStream
 *  java.lang.Object
 *  java.lang.String
 */
package com.appsgeyser.multiTabApp.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Picture;
import android.util.Base64;
import android.webkit.WebView;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public class WebViewScreenShooter {
    public static String takeScreenShotInBase64(WebView webView) {
        Picture picture = webView.capturePicture();
        Bitmap bitmap = Bitmap.createBitmap((int)picture.getWidth(), (int)picture.getHeight(), (Bitmap.Config)Bitmap.Config.ARGB_8888);
        picture.draw(new Canvas(bitmap));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)byteArrayOutputStream);
        return Base64.encodeToString((byte[])byteArrayOutputStream.toByteArray(), (int)0);
    }
}


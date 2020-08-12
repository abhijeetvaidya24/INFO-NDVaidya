/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.drawable.BitmapDrawable
 *  android.graphics.drawable.Drawable
 *  android.net.Uri
 *  android.os.Handler
 *  android.os.Looper
 *  android.text.TextUtils
 *  android.util.DisplayMetrics
 *  android.util.TypedValue
 *  android.widget.ImageView
 *  java.io.File
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.util.Map
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.applovin.sdk;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.ImageView;
import com.applovin.impl.sdk.e.g;
import com.applovin.impl.sdk.e.m;
import java.io.File;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class AppLovinSdkUtils {
    private static final Handler a = new Handler(Looper.getMainLooper());

    private static void a(ImageView imageView) {
        Drawable drawable2;
        if (imageView != null && (drawable2 = imageView.getDrawable()) != null && drawable2 instanceof BitmapDrawable) {
            ((BitmapDrawable)drawable2).getBitmap().recycle();
        }
    }

    public static int dpToPx(Context context, int n2) {
        return (int)TypedValue.applyDimension((int)1, (float)n2, (DisplayMetrics)context.getResources().getDisplayMetrics());
    }

    public static boolean isValidString(String string2) {
        return true ^ TextUtils.isEmpty((CharSequence)string2);
    }

    public static int pxToDp(Context context, int n2) {
        return (int)((float)n2 / context.getResources().getDisplayMetrics().density);
    }

    public static void runOnUiThread(Runnable runnable) {
        AppLovinSdkUtils.runOnUiThread(false, runnable);
    }

    public static void runOnUiThread(boolean bl, Runnable runnable) {
        if (!bl && Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
            return;
        }
        a.post(runnable);
    }

    public static void runOnUiThreadDelayed(Runnable runnable, long l2) {
        a.postDelayed(runnable, l2);
    }

    public static void safePopulateImageView(Context context, ImageView imageView, int n2, int n3) {
        AppLovinSdkUtils.a(imageView);
        Bitmap bitmap = m.a(context, n2, n3);
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
        }
    }

    public static void safePopulateImageView(ImageView imageView, Bitmap bitmap) {
        AppLovinSdkUtils.a(imageView);
        if (imageView != null && bitmap != null) {
            imageView.setImageBitmap(bitmap);
        }
    }

    public static void safePopulateImageView(ImageView imageView, Uri uri, int n2) {
        AppLovinSdkUtils.a(imageView);
        Bitmap bitmap = m.a(new File(uri.getPath()), n2);
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
        }
    }

    public static Map<String, String> toMap(JSONObject jSONObject) throws JSONException {
        return g.a(jSONObject);
    }
}


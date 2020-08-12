/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Point
 *  android.graphics.Rect
 *  android.util.DisplayMetrics
 *  android.util.TypedValue
 *  android.view.Display
 *  android.view.View
 *  android.view.Window
 *  android.view.WindowManager
 *  java.lang.ClassCastException
 *  java.lang.Double
 *  java.lang.Object
 *  java.lang.String
 */
package com.aerserv.sdk.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.aerserv.sdk.utils.DeviceInfo;

public class DisplayUtils {
    public static int convertDipToPx(Context context, int n2) {
        Resources resources = context.getResources();
        return (int)TypedValue.applyDimension((int)1, (float)n2, (DisplayMetrics)resources.getDisplayMetrics());
    }

    public static Point convertPointToDip(Context context, Point point) {
        return new Point(DisplayUtils.convertPxToDip(context, point.x), DisplayUtils.convertPxToDip(context, point.y));
    }

    public static int convertPxToDip(Context context, int n2) {
        double d2 = context.getResources().getDisplayMetrics().density;
        double d3 = n2;
        Double.isNaN((double)d3);
        Double.isNaN((double)d2);
        return (int)(d3 / d2);
    }

    public static Rect convertRectToDip(Context context, Rect rect) {
        return new Rect(DisplayUtils.convertPxToDip(context, rect.left), DisplayUtils.convertPxToDip(context, rect.top), DisplayUtils.convertPxToDip(context, rect.right), DisplayUtils.convertPxToDip(context, rect.bottom));
    }

    public static Point getActivitySize(Context context) {
        try {
            View view = ((Activity)context).getWindow().getDecorView().findViewById(16908290);
            Point point = new Point(view.getWidth(), view.getHeight());
            return point;
        }
        catch (ClassCastException classCastException) {
            return DeviceInfo.getScreenSize(context);
        }
    }

    public static Point getScreenSize(Context context, int n2) {
        Display display = ((WindowManager)context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        display.getMetrics(displayMetrics);
        int n3 = displayMetrics.widthPixels;
        int n4 = displayMetrics.heightPixels;
        if (2 != n2) {
            float f2 = n3;
            n4 = (int)(f2 * f2 / (float)n4);
        }
        return new Point(n3, n4);
    }

    public static Point getScreenSizeInDip(Context context) {
        WindowManager windowManager = (WindowManager)context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return DisplayUtils.convertPointToDip(context, new Point(displayMetrics.widthPixels, displayMetrics.heightPixels));
    }

    public static Rect getViewSize(View view) {
        int[] arrn = new int[]{0, 0};
        view.getLocationInWindow(arrn);
        int n2 = view.getWidth();
        int n3 = view.getHeight();
        return new Rect(arrn[0], arrn[1], n2 + arrn[0], n3 + arrn[1]);
    }
}


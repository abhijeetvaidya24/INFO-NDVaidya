/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.AssetManager
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.BitmapFactory
 *  android.util.DisplayMetrics
 *  android.view.ViewGroup
 *  android.widget.ImageButton
 *  android.widget.TextView
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.CharSequence
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 */
package com.appsgeyser.multiTabApp.ui.navigationwidget;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import java.io.IOException;
import java.io.InputStream;

public class NavigationWidgetCustomIcon {
    private TextView _badge;
    private ViewGroup _iconView;
    private ImageButton _imageButton;

    public void hideBadge() {
        this._badge.setVisibility(8);
    }

    public void showBadge() {
        this._badge.setVisibility(0);
    }

    public void updateBadge(String string2) {
        if (string2.length() > 0) {
            this.showBadge();
            this._badge.setText((CharSequence)string2);
            return;
        }
        this.hideBadge();
    }

    public void updateIcon(String string2) {
        Context context = this._iconView.getContext();
        try {
            InputStream inputStream = context.getAssets().open(string2);
            int n2 = Math.round((float)(38.0f * (context.getResources().getDisplayMetrics().xdpi / 160.0f)));
            Bitmap bitmap = BitmapFactory.decodeStream((InputStream)inputStream);
            this._imageButton.setImageBitmap(Bitmap.createScaledBitmap((Bitmap)bitmap, (int)n2, (int)n2, (boolean)false));
            return;
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            return;
        }
    }
}


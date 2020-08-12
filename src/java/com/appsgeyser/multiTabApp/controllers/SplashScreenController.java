/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.res.AssetManager
 *  android.graphics.Bitmap
 *  android.os.Handler
 *  android.view.Display
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.WindowManager
 *  android.widget.ImageView
 *  com.appsgeyser.multiTabApp.MainNavigationActivity
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 */
package com.appsgeyser.multiTabApp.controllers;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.os.Handler;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import com.appsgeyser.multiTabApp.MainNavigationActivity;
import com.appsgeyser.multiTabApp.utils.ImageReader;
import java.io.IOException;
import java.io.InputStream;

public class SplashScreenController {
    private MainNavigationActivity _activity;
    private Handler _handler = new Handler();
    private ViewGroup _splashScreenView;
    private Runnable hideSplashScreenViewRunnable = new Runnable(){

        public void run() {
            SplashScreenController.this._activity.showContentView();
        }
    };
    private Runnable showSplashScreenViewRunnable = new Runnable(){

        public void run() {
            SplashScreenController.this._activity.showSplashScreen();
        }
    };

    public SplashScreenController(ViewGroup viewGroup, MainNavigationActivity mainNavigationActivity) {
        this._splashScreenView = viewGroup;
        this._activity = mainNavigationActivity;
    }

    public void showSplashScreen(String string2) {
        ImageView imageView = (ImageView)this._splashScreenView.findViewById(2131296594);
        try {
            imageView.setImageBitmap(ImageReader.decodeFile(this._activity.getAssets().open(string2), this._activity.getWindowManager().getDefaultDisplay().getWidth()));
            this._activity.runOnUiThread(this.showSplashScreenViewRunnable);
            this._handler.postDelayed(new Runnable(){

                public void run() {
                    SplashScreenController.this._activity.runOnUiThread(SplashScreenController.this.hideSplashScreenViewRunnable);
                }
            }, 2000L);
            return;
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            this._activity.showContentView();
            return;
        }
    }

}


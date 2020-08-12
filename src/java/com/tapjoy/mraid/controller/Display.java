/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.R
 *  android.R$raw
 *  android.app.Activity
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.content.pm.PackageManager
 *  android.net.Uri
 *  android.util.DisplayMetrics
 *  android.view.Display
 *  android.view.WindowManager
 *  android.webkit.JavascriptInterface
 *  android.webkit.URLUtil
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.reflect.Field
 *  java.util.List
 */
package com.tapjoy.mraid.controller;

import android.R;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.webkit.JavascriptInterface;
import android.webkit.URLUtil;
import com.tapjoy.TapjoyLog;
import com.tapjoy.mraid.controller.Abstract;
import com.tapjoy.mraid.util.ConfigBroadcastReceiver;
import com.tapjoy.mraid.view.MraidView;
import java.lang.reflect.Field;
import java.util.List;

public class Display
extends Abstract {
    private WindowManager c;
    private boolean d = false;
    private int e = -1;
    private int f = -1;
    private ConfigBroadcastReceiver g;
    private float h;
    private Context i;

    public Display(MraidView mraidView, Context context) {
        super(mraidView, context);
        this.i = context;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.c = (WindowManager)context.getSystemService("window");
        this.c.getDefaultDisplay().getMetrics(displayMetrics);
        this.h = displayMetrics.density;
    }

    @JavascriptInterface
    public void close() {
        TapjoyLog.d("MRAID Display", "close");
        this.a.close();
    }

    public String dimensions() {
        StringBuilder stringBuilder = new StringBuilder("{ \"top\" :");
        stringBuilder.append((int)((float)this.a.getTop() / this.h));
        stringBuilder.append(",\"left\" :");
        stringBuilder.append((int)((float)this.a.getLeft() / this.h));
        stringBuilder.append(",\"bottom\" :");
        stringBuilder.append((int)((float)this.a.getBottom() / this.h));
        stringBuilder.append(",\"right\" :");
        stringBuilder.append((int)((float)this.a.getRight() / this.h));
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public String getMaxSize() {
        if (this.d) {
            StringBuilder stringBuilder = new StringBuilder("{ width: ");
            stringBuilder.append(this.e);
            stringBuilder.append(", height: ");
            stringBuilder.append(this.f);
            stringBuilder.append("}");
            return stringBuilder.toString();
        }
        return this.getScreenSize();
    }

    public int getOrientation() {
        int n2 = this.c.getDefaultDisplay().getOrientation();
        int n3 = n2 != 0 ? (n2 != 1 ? (n2 != 2 ? (n2 != 3 ? -1 : 270) : 180) : 90) : 0;
        StringBuilder stringBuilder = new StringBuilder("getOrientation: ");
        stringBuilder.append(n3);
        TapjoyLog.d("MRAID Display", stringBuilder.toString());
        return n3;
    }

    public String getScreenSize() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.c.getDefaultDisplay().getMetrics(displayMetrics);
        StringBuilder stringBuilder = new StringBuilder("{ width: ");
        stringBuilder.append((int)Math.ceil((double)((float)displayMetrics.widthPixels / displayMetrics.density)));
        stringBuilder.append(", height: ");
        stringBuilder.append((int)Math.ceil((double)((float)displayMetrics.heightPixels / displayMetrics.density)));
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public String getSize() {
        return this.a.getSize();
    }

    public boolean isVisible() {
        return this.a.getVisibility() == 0;
    }

    public void logHTML(String string) {
        TapjoyLog.d("MRAID Display", string);
    }

    public void onOrientationChanged(int n2) {
        StringBuilder stringBuilder = new StringBuilder("window.mraidview.fireChangeEvent({ orientation: ");
        stringBuilder.append(n2);
        stringBuilder.append("});");
        String string = stringBuilder.toString();
        TapjoyLog.d("MRAID Display", string);
        this.a.injectMraidJavaScript(string);
    }

    @JavascriptInterface
    public void open(String string, boolean bl, boolean bl2, boolean bl3) {
        StringBuilder stringBuilder = new StringBuilder("open: url: ");
        stringBuilder.append(string);
        stringBuilder.append(" back: ");
        stringBuilder.append(bl);
        stringBuilder.append(" forward: ");
        stringBuilder.append(bl2);
        stringBuilder.append(" refresh: ");
        stringBuilder.append(bl3);
        TapjoyLog.i("MRAID Display", stringBuilder.toString());
        if (!URLUtil.isValidUrl((String)string)) {
            TapjoyLog.i("MRAID Display", "invalid URL");
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse((String)string));
            List list = this.i.getPackageManager().queryIntentActivities(intent, 0);
            if (list.size() == 1) {
                this.i.startActivity(intent);
                return;
            }
            if (list.size() > 1) {
                Intent intent2 = Intent.createChooser((Intent)intent, (CharSequence)"Select");
                ((Activity)this.i).startActivity(intent2);
                return;
            }
            this.a.raiseError("Invalid url", "open");
            return;
        }
        this.a.open(string, bl, bl2, bl3);
    }

    @JavascriptInterface
    public void openMap(String string, boolean bl) {
        StringBuilder stringBuilder = new StringBuilder("openMap: url: ");
        stringBuilder.append(string);
        TapjoyLog.d("MRAID Display", stringBuilder.toString());
        this.a.openMap(string, bl);
    }

    @JavascriptInterface
    public void playAudio(String string, boolean bl, boolean bl2, boolean bl3, boolean bl4, String string2, String string3) {
        StringBuilder stringBuilder = new StringBuilder("playAudio: url: ");
        stringBuilder.append(string);
        stringBuilder.append(" autoPlay: ");
        stringBuilder.append(bl);
        stringBuilder.append(" controls: ");
        stringBuilder.append(bl2);
        stringBuilder.append(" loop: ");
        stringBuilder.append(bl3);
        stringBuilder.append(" position: ");
        stringBuilder.append(bl4);
        stringBuilder.append(" startStyle: ");
        stringBuilder.append(string2);
        stringBuilder.append(" stopStyle: ");
        stringBuilder.append(string3);
        TapjoyLog.d("MRAID Display", stringBuilder.toString());
        if (!URLUtil.isValidUrl((String)string)) {
            this.a.raiseError("Invalid url", "playAudio");
            return;
        }
        this.a.playAudio(string, bl, bl2, bl3, bl4, string2, string3);
    }

    @JavascriptInterface
    public void playVideo(String string, boolean bl, boolean bl2, boolean bl3, boolean bl4, int[] arrn, String string2, String string3) {
        Abstract.ReflectedParcelable reflectedParcelable;
        String string4 = string;
        StringBuilder stringBuilder = new StringBuilder("playVideo: url: ");
        stringBuilder.append(string4);
        stringBuilder.append(" audioMuted: ");
        stringBuilder.append(bl);
        stringBuilder.append(" autoPlay: ");
        stringBuilder.append(bl2);
        stringBuilder.append(" controls: ");
        stringBuilder.append(bl3);
        stringBuilder.append(" loop: ");
        stringBuilder.append(bl4);
        stringBuilder.append(" x: ");
        int n2 = 0;
        stringBuilder.append(arrn[0]);
        stringBuilder.append(" y: ");
        stringBuilder.append(arrn[1]);
        stringBuilder.append(" width: ");
        stringBuilder.append(arrn[2]);
        stringBuilder.append(" height: ");
        stringBuilder.append(arrn[3]);
        stringBuilder.append(" startStyle: ");
        stringBuilder.append(string2);
        stringBuilder.append(" stopStyle: ");
        stringBuilder.append(string3);
        TapjoyLog.d("MRAID Display", stringBuilder.toString());
        if (arrn[0] != -1) {
            Abstract.ReflectedParcelable reflectedParcelable2 = new Abstract.ReflectedParcelable(){
                public static final android.os.Parcelable$Creator CREATOR;
                public int height;
                public int width;
                public int x;
                public int y;

                static {
                    CREATOR = new android.os.Parcelable$Creator(){

                        public final /* synthetic */ Object createFromParcel(android.os.Parcel parcel) {
                            return new /* invalid duplicate definition of identical inner class */;
                        }
                    };
                }
                {
                    this.x = -1;
                    this.y = -1;
                    this.width = -1;
                    this.height = -1;
                }
            };
            reflectedParcelable2.x = arrn[0];
            reflectedParcelable2.y = arrn[1];
            reflectedParcelable2.width = arrn[2];
            reflectedParcelable2.height = arrn[3];
            reflectedParcelable2.width = (int)Math.ceil((double)(this.h * (float)reflectedParcelable2.width));
            reflectedParcelable2.height = (int)Math.ceil((double)(this.h * (float)reflectedParcelable2.height));
            reflectedParcelable2.x = (int)((float)reflectedParcelable2.x * this.h);
            reflectedParcelable2.y = (int)((float)reflectedParcelable2.y * this.h);
            if (reflectedParcelable2.height < 0) {
                reflectedParcelable2.height = this.a.getHeight();
            }
            if (reflectedParcelable2.width < 0) {
                reflectedParcelable2.width = this.a.getWidth();
            }
            int[] arrn2 = new int[2];
            this.a.getLocationInWindow(arrn2);
            if (reflectedParcelable2.x < 0) {
                reflectedParcelable2.x = arrn2[0];
            }
            if (reflectedParcelable2.y < 0) {
                reflectedParcelable2.y = arrn2[1] - 0;
            }
            reflectedParcelable = reflectedParcelable2;
        } else {
            reflectedParcelable = null;
        }
        if (string4.contains((CharSequence)"android.resource")) {
            String string5 = string4.substring(1 + string4.lastIndexOf("/"), string4.lastIndexOf("."));
            try {
                n2 = R.raw.class.getField(string5).getInt(null);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
            String string6 = this.b.getPackageName();
            StringBuilder stringBuilder2 = new StringBuilder("android.resource://");
            stringBuilder2.append(string6);
            stringBuilder2.append("/");
            stringBuilder2.append(n2);
            string4 = stringBuilder2.toString();
        }
        String string7 = string4;
        this.a.playVideo(string7, false, true, true, false, reflectedParcelable, "fullscreen", "exit");
    }

    public void setMaxSize(int n2, int n3) {
        StringBuilder stringBuilder = new StringBuilder("setMaxSize: ");
        stringBuilder.append(n2);
        stringBuilder.append("x");
        stringBuilder.append(n3);
        TapjoyLog.d("MRAID Display", stringBuilder.toString());
        this.d = true;
        this.e = n2;
        this.f = n3;
    }

    @JavascriptInterface
    public void setOrientationProperties(boolean bl, String string) {
        StringBuilder stringBuilder = new StringBuilder("setOrientationProperties: allowOrientationChange: ");
        stringBuilder.append(Boolean.toString((boolean)bl));
        stringBuilder.append(" forceOrientation: ");
        stringBuilder.append(string);
        TapjoyLog.d("MRAID Display", stringBuilder.toString());
        this.a.setOrientationProperties(bl, string);
    }

    @JavascriptInterface
    public void show() {
        TapjoyLog.d("MRAID Display", "show");
        this.a.show();
    }

    public void startConfigurationListener() {
        try {
            if (this.g == null) {
                this.g = new ConfigBroadcastReceiver(this);
            }
            this.b.registerReceiver((BroadcastReceiver)this.g, new IntentFilter("android.intent.action.CONFIGURATION_CHANGED"));
        }
        catch (Exception exception) {}
    }

    @Override
    public void stopAllListeners() {
        this.stopConfigurationListener();
        this.g = null;
    }

    public void stopConfigurationListener() {
        try {
            this.b.unregisterReceiver((BroadcastReceiver)this.g);
        }
        catch (Exception exception) {}
    }

    @JavascriptInterface
    public void useCustomClose(boolean bl) {
        if (bl) {
            this.a.removeCloseImageButton();
            return;
        }
        if (!bl) {
            this.a.showCloseImageButton();
        }
    }
}


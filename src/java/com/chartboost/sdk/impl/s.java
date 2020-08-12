/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.BitmapFactory
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Environment
 *  android.os.Handler
 *  android.os.Looper
 *  android.text.TextUtils
 *  com.google.android.gms.ads.identifier.AdvertisingIdClient
 *  com.google.android.gms.ads.identifier.AdvertisingIdClient$Info
 *  com.google.android.gms.common.GooglePlayServicesNotAvailableException
 *  com.google.android.gms.common.GooglePlayServicesRepairableException
 *  java.io.File
 *  java.io.IOException
 *  java.lang.CharSequence
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 */
package com.chartboost.sdk.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.File;
import java.io.IOException;

public class s {
    private static s b = new s(new Handler(Looper.getMainLooper()));
    public final Handler a;

    public s(Handler handler) {
        this.a = handler;
    }

    public static s a() {
        return b;
    }

    public Bitmap a(byte[] arrby) {
        return BitmapFactory.decodeByteArray((byte[])arrby, (int)0, (int)arrby.length, null);
    }

    public AdvertisingIdClient.Info a(Context context) throws IOException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException, IllegalStateException {
        return AdvertisingIdClient.getAdvertisingIdInfo((Context)context);
    }

    public boolean a(int n2) {
        return Build.VERSION.SDK_INT >= n2;
    }

    public boolean a(CharSequence charSequence) {
        return TextUtils.isEmpty((CharSequence)charSequence);
    }

    public File b() {
        return Environment.getExternalStorageDirectory();
    }

    public String c() {
        return Environment.getExternalStorageState();
    }

    public String d() {
        return Build.VERSION.RELEASE;
    }

    public boolean e() {
        return Looper.myLooper() == Looper.getMainLooper();
    }
}


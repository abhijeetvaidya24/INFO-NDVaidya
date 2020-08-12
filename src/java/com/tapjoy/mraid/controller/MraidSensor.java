/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Double
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.tapjoy.mraid.controller;

import android.content.Context;
import com.tapjoy.TapjoyLog;
import com.tapjoy.mraid.controller.Abstract;
import com.tapjoy.mraid.listener.Accel;
import com.tapjoy.mraid.view.MraidView;

public class MraidSensor
extends Abstract {
    final int c = 1000;
    private Accel d;
    private float e = 0.0f;
    private float f = 0.0f;
    private float g = 0.0f;

    public MraidSensor(MraidView mraidView, Context context) {
        super(mraidView, context);
        this.d = new Accel(context, this);
    }

    public float getHeading() {
        StringBuilder stringBuilder = new StringBuilder("getHeading: ");
        stringBuilder.append(this.d.getHeading());
        TapjoyLog.d("MRAID Sensor", stringBuilder.toString());
        return this.d.getHeading();
    }

    public String getTilt() {
        StringBuilder stringBuilder = new StringBuilder("{ x : \"");
        stringBuilder.append(this.e);
        stringBuilder.append("\", y : \"");
        stringBuilder.append(this.f);
        stringBuilder.append("\", z : \"");
        stringBuilder.append(this.g);
        stringBuilder.append("\"}");
        String string = stringBuilder.toString();
        StringBuilder stringBuilder2 = new StringBuilder("getTilt: ");
        stringBuilder2.append(string);
        TapjoyLog.d("MRAID Sensor", stringBuilder2.toString());
        return string;
    }

    public void onHeadingChange(float f2) {
        StringBuilder stringBuilder = new StringBuilder("window.mraidview.fireChangeEvent({ heading: ");
        double d2 = f2;
        Double.isNaN((double)d2);
        stringBuilder.append((int)(d2 * 57.29577951308232));
        stringBuilder.append("});");
        String string = stringBuilder.toString();
        TapjoyLog.d("MRAID Sensor", string);
        this.a.injectMraidJavaScript(string);
    }

    public void onShake() {
        this.a.injectMraidJavaScript("mraid.gotShake()");
    }

    public void onTilt(float f2, float f3, float f4) {
        this.e = f2;
        this.f = f3;
        this.g = f4;
        StringBuilder stringBuilder = new StringBuilder("window.mraidview.fireChangeEvent({ tilt: ");
        stringBuilder.append(this.getTilt());
        stringBuilder.append("})");
        String string = stringBuilder.toString();
        TapjoyLog.d("MRAID Sensor", string);
        this.a.injectMraidJavaScript(string);
    }

    public void startHeadingListener() {
        this.d.startTrackingHeading();
    }

    public void startShakeListener() {
        this.d.startTrackingShake();
    }

    public void startTiltListener() {
        this.d.startTrackingTilt();
    }

    @Override
    public void stopAllListeners() {
        this.d.stopAllListeners();
    }

    public void stopHeadingListener() {
        this.d.stopTrackingHeading();
    }

    public void stopShakeListener() {
        this.d.stopTrackingShake();
    }

    public void stopTiltListener() {
        this.d.stopTrackingTilt();
    }
}


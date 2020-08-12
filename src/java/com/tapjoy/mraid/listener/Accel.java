/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.hardware.Sensor
 *  android.hardware.SensorEvent
 *  android.hardware.SensorEventListener
 *  android.hardware.SensorManager
 *  com.tapjoy.mraid.controller.MraidSensor
 *  java.lang.Exception
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.util.List
 */
package com.tapjoy.mraid.listener;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tapjoy.mraid.controller.MraidSensor;
import java.util.List;

public class Accel
implements SensorEventListener {
    MraidSensor a;
    int b = 0;
    int c = 0;
    int d = 0;
    private SensorManager e;
    private int f = 3;
    private long g;
    private int h;
    private long i;
    private long j;
    private float[] k;
    private float[] l = new float[]{0.0f, 0.0f, 0.0f};
    private boolean m;
    private boolean n;
    private float[] o = new float[]{0.0f, 0.0f, 0.0f};
    private float[] p = new float[]{-1.0f, -1.0f, -1.0f};

    public Accel(Context context, MraidSensor mraidSensor) {
        this.a = mraidSensor;
        this.e = (SensorManager)context.getSystemService("sensor");
    }

    private void a() {
        List list = this.e.getSensorList(1);
        if (list.size() > 0) {
            this.e.registerListener((SensorEventListener)this, (Sensor)list.get(0), this.f);
        }
    }

    public float getHeading() {
        return this.p[0];
    }

    public void onAccuracyChanged(Sensor sensor, int n2) {
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        float[] arrf;
        int n2 = sensorEvent.sensor.getType();
        if (n2 != 1) {
            if (n2 == 2) {
                this.k = (float[])sensorEvent.values.clone();
                this.m = true;
            }
        } else {
            this.o = this.l;
            this.l = (float[])sensorEvent.values.clone();
            this.n = true;
        }
        float[] arrf2 = this.k;
        if (arrf2 != null && (arrf = this.l) != null && this.n && this.m) {
            this.n = false;
            this.m = false;
            float[] arrf3 = new float[9];
            SensorManager.getRotationMatrix((float[])arrf3, (float[])new float[9], (float[])arrf, (float[])arrf2);
            this.p = new float[3];
            SensorManager.getOrientation((float[])arrf3, (float[])this.p);
            this.a.onHeadingChange(this.p[0]);
        }
        if (sensorEvent.sensor.getType() == 1) {
            long l2;
            long l3 = System.currentTimeMillis();
            if (l3 - this.g > 500L) {
                this.h = 0;
            }
            if (l3 - (l2 = this.i) > 100L) {
                long l4 = l3 - l2;
                float[] arrf4 = this.l;
                float f2 = arrf4[0] + arrf4[1] + arrf4[2];
                float[] arrf5 = this.o;
                if (10000.0f * (Math.abs((float)(f2 - arrf5[0] - arrf5[1] - arrf5[2])) / (float)l4) > 1000.0f) {
                    int n3;
                    this.h = n3 = 1 + this.h;
                    if (n3 >= 2 && l3 - this.j > 2000L) {
                        this.j = l3;
                        this.h = 0;
                        this.a.onShake();
                    }
                    this.g = l3;
                }
                this.i = l3;
                MraidSensor mraidSensor = this.a;
                float[] arrf6 = this.l;
                mraidSensor.onTilt(arrf6[0], arrf6[1], arrf6[2]);
            }
        }
    }

    public void setSensorDelay(int n2) {
        this.f = n2;
        if (this.b > 0 || this.c > 0) {
            this.stop();
            this.a();
        }
    }

    public void startTrackingHeading() {
        List list;
        if (this.d == 0 && (list = this.e.getSensorList(2)).size() > 0) {
            this.e.registerListener((SensorEventListener)this, (Sensor)list.get(0), this.f);
            this.a();
        }
        this.d = 1 + this.d;
    }

    public void startTrackingShake() {
        if (this.c == 0) {
            this.setSensorDelay(1);
            this.a();
        }
        this.c = 1 + this.c;
    }

    public void startTrackingTilt() {
        if (this.b == 0) {
            this.a();
        }
        this.b = 1 + this.b;
    }

    public void stop() {
        if (this.d == 0 && this.c == 0 && this.b == 0) {
            this.e.unregisterListener((SensorEventListener)this);
        }
    }

    public void stopAllListeners() {
        this.b = 0;
        this.c = 0;
        this.d = 0;
        try {
            this.stop();
        }
        catch (Exception exception) {}
    }

    public void stopTrackingHeading() {
        int n2 = this.d;
        if (n2 > 0) {
            int n3;
            this.d = n3 = n2 - 1;
            if (n3 == 0) {
                this.stop();
            }
        }
    }

    public void stopTrackingShake() {
        int n2 = this.c;
        if (n2 > 0) {
            int n3;
            this.c = n3 = n2 - 1;
            if (n3 == 0) {
                this.setSensorDelay(3);
                this.stop();
            }
        }
    }

    public void stopTrackingTilt() {
        int n2 = this.b;
        if (n2 > 0) {
            int n3;
            this.b = n3 = n2 - 1;
            if (n3 == 0) {
                this.stop();
            }
        }
    }
}


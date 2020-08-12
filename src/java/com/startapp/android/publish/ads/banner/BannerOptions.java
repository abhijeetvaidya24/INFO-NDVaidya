/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Enum
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 */
package com.startapp.android.publish.ads.banner;

import com.startapp.common.c.f;
import java.io.Serializable;

public class BannerOptions
implements Serializable {
    private static final long serialVersionUID = 1L;
    private int adsNumber = 4;
    private int delayFaceTime = 5000;
    @f(b="Lcom/startapp/android/publish/ads/banner/BannerOptions$Effect;")
    private Effect effect = Effect.ROTATE_3D;
    private int height = 50;
    private float heightRatio = 1.0f;
    private int htmlAdsNumber = 10;
    private float minScale = 0.88f;
    private int minViewabilityPercentage = 50;
    private int refreshRate = 60000;
    private int refreshRate3D = 60000;
    private boolean rotateThroughOnStart = true;
    private int rotateThroughSpeedMult = 2;
    private int scalePower = 4;
    private int stepSize = 5;
    private int timeBetweenFrames = 25;
    private int width = 300;
    private float widthRatio = 1.0f;

    public BannerOptions() {
    }

    public BannerOptions(BannerOptions bannerOptions) {
        this.width = bannerOptions.width;
        this.height = bannerOptions.height;
        this.timeBetweenFrames = bannerOptions.timeBetweenFrames;
        this.stepSize = bannerOptions.stepSize;
        this.delayFaceTime = bannerOptions.delayFaceTime;
        this.adsNumber = bannerOptions.adsNumber;
        this.htmlAdsNumber = bannerOptions.htmlAdsNumber;
        this.refreshRate3D = bannerOptions.refreshRate3D;
        this.widthRatio = bannerOptions.widthRatio;
        this.heightRatio = bannerOptions.heightRatio;
        this.minScale = bannerOptions.minScale;
        this.scalePower = bannerOptions.scalePower;
        this.effect = bannerOptions.effect;
        this.rotateThroughOnStart = bannerOptions.rotateThroughOnStart;
        this.rotateThroughSpeedMult = bannerOptions.rotateThroughSpeedMult;
        this.refreshRate = bannerOptions.refreshRate;
    }

    public int a() {
        return this.timeBetweenFrames;
    }

    public void a(int n2, int n3) {
        this.width = n2;
        this.height = n3;
    }

    public int b() {
        return this.stepSize;
    }

    public int c() {
        return this.delayFaceTime;
    }

    public int d() {
        return this.width;
    }

    public int e() {
        return this.height;
    }

    public boolean equals(Object object) {
        BannerOptions bannerOptions = (BannerOptions)object;
        return bannerOptions.f() == this.f() && bannerOptions.g() == this.g() && bannerOptions.h() == this.h() && bannerOptions.c() == this.c() && bannerOptions.e() == this.e() && bannerOptions.b() == this.b() && bannerOptions.a() == this.a() && bannerOptions.d() == this.d() && bannerOptions.i() == this.i();
    }

    public int f() {
        return this.adsNumber;
    }

    public int g() {
        return this.htmlAdsNumber;
    }

    public int h() {
        return this.refreshRate3D;
    }

    public int i() {
        return this.refreshRate;
    }

    public float j() {
        return this.widthRatio;
    }

    public float k() {
        return this.heightRatio;
    }

    public float l() {
        return this.minScale;
    }

    public int m() {
        return this.scalePower;
    }

    public Effect n() {
        return this.effect;
    }

    public boolean o() {
        return this.rotateThroughOnStart;
    }

    public int p() {
        return this.rotateThroughSpeedMult;
    }

    public int q() {
        return this.minViewabilityPercentage;
    }

    public static final class Effect
    extends Enum<Effect> {
        private static final /* synthetic */ Effect[] $VALUES;
        public static final /* enum */ Effect EXCHANGE;
        public static final /* enum */ Effect FLY_IN;
        public static final /* enum */ Effect ROTATE_3D;
        private int index;

        static {
            ROTATE_3D = new Effect(1);
            EXCHANGE = new Effect(2);
            FLY_IN = new Effect(3);
            Effect[] arreffect = new Effect[]{ROTATE_3D, EXCHANGE, FLY_IN};
            $VALUES = arreffect;
        }

        private Effect(int n3) {
            this.index = n3;
        }

        public static Effect getByIndex(int n2) {
            Effect effect = ROTATE_3D;
            Effect[] arreffect = Effect.values();
            for (int j = 0; j < arreffect.length; ++j) {
                if (arreffect[j].getIndex() != n2) continue;
                effect = arreffect[j];
            }
            return effect;
        }

        public static Effect getByName(String string) {
            Effect effect = ROTATE_3D;
            Effect[] arreffect = Effect.values();
            for (int j = 0; j < arreffect.length; ++j) {
                if (arreffect[j].name().toLowerCase().compareTo(string.toLowerCase()) != 0) continue;
                effect = arreffect[j];
            }
            return effect;
        }

        public static Effect valueOf(String string) {
            return (Effect)Enum.valueOf(Effect.class, (String)string);
        }

        public static Effect[] values() {
            return (Effect[])$VALUES.clone();
        }

        public int getIndex() {
            return this.index;
        }

        public int getRotationMultiplier() {
            return (int)Math.pow((double)2.0, (double)(-1 + this.index));
        }
    }

}


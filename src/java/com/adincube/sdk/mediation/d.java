/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.adincube.sdk.mediation.d$1
 *  com.adincube.sdk.mediation.d$10
 *  com.adincube.sdk.mediation.d$11
 *  com.adincube.sdk.mediation.d$12
 *  com.adincube.sdk.mediation.d$13
 *  com.adincube.sdk.mediation.d$14
 *  com.adincube.sdk.mediation.d$15
 *  com.adincube.sdk.mediation.d$16
 *  com.adincube.sdk.mediation.d$17
 *  com.adincube.sdk.mediation.d$18
 *  com.adincube.sdk.mediation.d$19
 *  com.adincube.sdk.mediation.d$2
 *  com.adincube.sdk.mediation.d$20
 *  com.adincube.sdk.mediation.d$21
 *  com.adincube.sdk.mediation.d$22
 *  com.adincube.sdk.mediation.d$23
 *  com.adincube.sdk.mediation.d$24
 *  com.adincube.sdk.mediation.d$25
 *  com.adincube.sdk.mediation.d$26
 *  com.adincube.sdk.mediation.d$3
 *  com.adincube.sdk.mediation.d$4
 *  com.adincube.sdk.mediation.d$5
 *  com.adincube.sdk.mediation.d$6
 *  com.adincube.sdk.mediation.d$7
 *  com.adincube.sdk.mediation.d$8
 *  com.adincube.sdk.mediation.d$9
 *  java.lang.Enum
 *  java.lang.NoClassDefFoundError
 *  java.lang.Object
 *  java.lang.String
 */
package com.adincube.sdk.mediation;

import com.adincube.sdk.mediation.d;
import com.adincube.sdk.mediation.i;

public abstract class d
extends Enum<d> {
    private static final /* synthetic */ d[] B;
    public static final /* enum */ d a = new 1("RTB");
    public static final /* enum */ d b = new 12("AdBuddiz");
    public static final /* enum */ d c = new 20("AdColony");
    public static final /* enum */ d d = new 21("AdMob");
    public static final /* enum */ d e = new 22("AerServ");
    public static final /* enum */ d f = new 23("Amazon");
    public static final /* enum */ d g = new 24("AppLovin");
    public static final /* enum */ d h = new 25("AppNext");
    public static final /* enum */ d i = new 26("Avocarrot");
    public static final /* enum */ d j = new 2("Chartboost");
    public static final /* enum */ d k = new 3("DoubleClick");
    public static final /* enum */ d l = new 4("Facebook");
    public static final /* enum */ d m = new 5("Flurry");
    public static final /* enum */ d n = new 6("InMobi");
    public static final /* enum */ d o = new 7("IronSource");
    public static final /* enum */ d p = new 8("MailRu");
    public static final /* enum */ d q = new 9("MediaBrix");
    public static final /* enum */ d r = new 10("MoPub");
    public static final /* enum */ d s = new 11("Mobvista");
    public static final /* enum */ d t = new 13("Ogury");
    public static final /* enum */ d u = new 14("PubNative");
    public static final /* enum */ d v = new 15("StartApp");
    public static final /* enum */ d w = new 16("Tapjoy");
    public static final /* enum */ d x = new 17("UnityAds");
    public static final /* enum */ d y = new 18("VidCoin");
    public static final /* enum */ d z = new 19("Vungle");
    public i A;

    static {
        d[] arrd = new d[]{a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z};
        B = arrd;
    }

    private d() {
        try {
            this.A = this.b();
        }
        catch (NoClassDefFoundError noClassDefFoundError) {}
    }

    /* synthetic */ d(String string, int n2, byte by) {
        this();
    }

    public static d[] a() {
        return (d[])B.clone();
    }

    protected abstract i b();
}


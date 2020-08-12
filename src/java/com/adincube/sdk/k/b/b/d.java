/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.List
 */
package com.adincube.sdk.k.b.b;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public final class d
extends Enum<d> {
    public static final /* enum */ d a = new d("createView", new String[0]);
    public static final /* enum */ d b = new d("start", new String[0]);
    public static final /* enum */ d c = new d("firstQuartile", new String[0]);
    public static final /* enum */ d d = new d("midpoint", new String[0]);
    public static final /* enum */ d e = new d("thirdQuartile", new String[0]);
    public static final /* enum */ d f = new d("complete", new String[0]);
    public static final /* enum */ d g = new d("mute", new String[0]);
    public static final /* enum */ d h = new d("unmute", new String[0]);
    public static final /* enum */ d i = new d("pause", new String[0]);
    public static final /* enum */ d j = new d("rewind", new String[0]);
    public static final /* enum */ d k = new d("resume", new String[0]);
    public static final /* enum */ d l = new d("fullscreen", new String[0]);
    public static final /* enum */ d m = new d("exitFullscreen", new String[0]);
    public static final /* enum */ d n = new d("expand", new String[0]);
    public static final /* enum */ d o = new d("collapse", new String[0]);
    public static final /* enum */ d p = new d("acceptInvitation", new String[0]);
    public static final /* enum */ d q = new d("acceptInvitationLinear", new String[0]);
    public static final /* enum */ d r = new d("close", new String[0]);
    public static final /* enum */ d s = new d("closeLinear", new String[0]);
    public static final /* enum */ d t = new d("skip", new String[0]);
    public static final /* enum */ d u = new d("progress", "offset");
    public static final /* enum */ d v = new d(null, new String[0]);
    private static final /* synthetic */ d[] y;
    public String w;
    private List<String> x = new ArrayList();

    static {
        d[] arrd = new d[]{a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v};
        y = arrd;
    }

    private /* varargs */ d(String string2, String ... arrstring) {
        this.w = string2;
        this.x.addAll((Collection)Arrays.asList((Object[])arrstring));
    }

    public static d a(String string) {
        for (d d2 : (d[])y.clone()) {
            String string2 = d2.w;
            if (string2 == null || !string2.equals((Object)string)) continue;
            return d2;
        }
        return v;
    }
}


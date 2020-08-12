/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.tappx.a.a.b.y$1
 *  com.tappx.a.a.b.y$2
 *  com.tappx.a.a.b.y$3
 *  com.tappx.a.a.b.y$4
 *  com.tappx.a.a.b.y$5
 *  com.tappx.a.a.b.y$6
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.tappx.a.a.b;

import com.tappx.a.a.b.s;
import com.tappx.a.a.b.y;

public class y
extends Enum<y> {
    public static final /* enum */ y a = new y("close");
    public static final /* enum */ y b = new 1("EXPAND", 1, "expand");
    public static final /* enum */ y c = new y("usecustomclose");
    public static final /* enum */ y d = new 2("OPEN", 3, "open");
    public static final /* enum */ y e = new 3("RESIZE", 4, "resize");
    public static final /* enum */ y f = new y("setOrientationProperties");
    public static final /* enum */ y g = new 4("PLAY_VIDEO", 6, "playVideo");
    public static final /* enum */ y h = new 5("STORE_PICTURE", 7, "storePicture");
    public static final /* enum */ y i = new 6("CREATE_CALENDAR_EVENT", 8, "createCalendarEvent");
    public static final /* enum */ y j = new y("");
    private static final /* synthetic */ y[] l;
    private final String k;

    static {
        y[] arry = new y[]{a, b, c, d, e, f, g, h, i, j};
        l = arry;
    }

    private y(String string3) {
        this.k = string3;
    }

    static y a(String string2) {
        for (y y2 : y.values()) {
            if (!y2.k.equals((Object)string2)) continue;
            return y2;
        }
        return j;
    }

    public static y valueOf(String string2) {
        return (y)Enum.valueOf(y.class, (String)string2);
    }

    public static y[] values() {
        return (y[])l.clone();
    }

    String a() {
        return this.k;
    }

    boolean a(s s2) {
        return false;
    }
}


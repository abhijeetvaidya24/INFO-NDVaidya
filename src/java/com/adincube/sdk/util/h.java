/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Calendar
 *  java.util.Date
 *  java.util.TimeZone
 */
package com.adincube.sdk.util;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public final class h {
    public static Date a() {
        return Calendar.getInstance((TimeZone)TimeZone.getTimeZone((String)"UTC")).getTime();
    }

    public static void a(Calendar calendar) {
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
    }
}


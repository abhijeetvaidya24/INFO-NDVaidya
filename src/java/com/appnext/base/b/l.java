/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Calendar
 *  java.util.Date
 */
package com.appnext.base.b;

import java.util.Calendar;
import java.util.Date;

public final class l {
    public static Date a(long l2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(l2);
        return calendar.getTime();
    }
}


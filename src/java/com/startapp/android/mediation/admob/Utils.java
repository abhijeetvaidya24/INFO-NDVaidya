/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Calendar
 */
package com.startapp.android.mediation.admob;

import java.util.Calendar;

public class Utils {
    public static int getDiffInYears(long l2, long l3) {
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar.setTimeInMillis(l2);
        calendar2.setTimeInMillis(l3);
        return Utils.getDiffInYears(calendar, calendar2);
    }

    public static int getDiffInYears(Calendar calendar, Calendar calendar2) {
        int n2 = calendar.get(1) - calendar2.get(1);
        int n3 = calendar.get(2) - calendar2.get(2);
        int n4 = calendar.get(5) - calendar2.get(5);
        if (n3 < 0 || n3 == 0 && n4 < 0) {
            --n2;
        }
        return n2;
    }
}


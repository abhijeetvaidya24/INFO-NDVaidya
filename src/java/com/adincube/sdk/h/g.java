/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.location.Location
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Calendar
 *  java.util.Date
 *  java.util.Locale
 *  java.util.TimeZone
 */
package com.adincube.sdk.h;

import android.location.Location;
import com.adincube.sdk.h.b;
import com.adincube.sdk.h.c;
import com.adincube.sdk.util.h;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public final class g {
    public b a;
    public c b;
    public Location c;
    public Integer d;
    public Date e;

    public final Date a() {
        if (this.e == null && this.d == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance((TimeZone)TimeZone.getTimeZone((String)"UTC"));
        calendar.setTime(new Date());
        h.a(calendar);
        Date date = calendar.getTime();
        int n2 = this.d;
        Calendar calendar2 = Calendar.getInstance((TimeZone)TimeZone.getTimeZone((String)"UTC"));
        calendar2.setTime(date);
        calendar2.add(1, -n2);
        Date date2 = calendar2.getTime();
        Calendar calendar3 = Calendar.getInstance((TimeZone)TimeZone.getTimeZone((String)"UTC"));
        calendar3.setTime(date2);
        h.a(calendar3);
        calendar3.set(6, 1);
        return calendar3.getTime();
    }

    public final Integer b() {
        if (this.a() == null) {
            return null;
        }
        Date date = this.a();
        Calendar calendar = Calendar.getInstance((TimeZone)TimeZone.getTimeZone((String)"UTC"));
        calendar.setTime(date);
        return calendar.get(1);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UserInformation: \n");
        if (this.d != null) {
            Locale locale = Locale.US;
            Object[] arrobject = new Object[]{this.d};
            stringBuilder.append(String.format((Locale)locale, (String)"age - %d\n", (Object[])arrobject));
        }
        if (this.a != null) {
            Locale locale = Locale.US;
            Object[] arrobject = new Object[]{this.a.c};
            stringBuilder.append(String.format((Locale)locale, (String)"gender - %s\n", (Object[])arrobject));
        }
        if (this.b != null) {
            Locale locale = Locale.US;
            Object[] arrobject = new Object[]{this.b.c};
            stringBuilder.append(String.format((Locale)locale, (String)"marital status - %s\n", (Object[])arrobject));
        }
        if (this.c != null) {
            Locale locale = Locale.US;
            Object[] arrobject = new Object[]{this.c.getLatitude(), this.c.getLongitude()};
            stringBuilder.append(String.format((Locale)locale, (String)"location - %.2f - %.2f\n", (Object[])arrobject));
        }
        return stringBuilder.toString();
    }
}


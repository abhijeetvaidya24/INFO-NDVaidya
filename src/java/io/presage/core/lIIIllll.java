/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.text.SimpleDateFormat
 *  java.util.Calendar
 *  java.util.Date
 *  java.util.Locale
 *  java.util.TimeZone
 */
package io.presage.core;

import io.presage.core.lIIIlIlI;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public final class lIIIllll {
    private static final String IIIIIIII = lIIIlIlI.IIllIIlI.IIIIIIII;
    private static final String IIIIIIIl = lIIIlIlI.IIllIIlI.IIIIIIIl;
    private static final String IIIIIIlI = lIIIlIlI.IIllIIlI.IIIIIIlI;
    private static final String IIIIIIll = lIIIlIlI.IIIIIIII;

    public static final long IIIIIIII() {
        return System.currentTimeMillis();
    }

    public static String IIIIIIII(long l2) {
        return new SimpleDateFormat(IIIIIIlI, Locale.US).format((Object)l2);
    }

    public static String IIIIIIIl() {
        Calendar calendar = Calendar.getInstance((TimeZone)TimeZone.getTimeZone((String)IIIIIIII), (Locale)Locale.getDefault());
        String string = new SimpleDateFormat(IIIIIIIl, Locale.US).format(calendar.getTime());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string.substring(0, 3));
        stringBuilder.append(IIIIIIll);
        stringBuilder.append(string.substring(3, 5));
        return stringBuilder.toString();
    }
}


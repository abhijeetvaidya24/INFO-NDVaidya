/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Class
 *  java.lang.Comparable
 *  java.lang.Double
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.text.DecimalFormat
 */
package com.aerserv.sdk.utils;

import com.aerserv.sdk.utils.AerServLog;
import java.io.Serializable;
import java.text.DecimalFormat;

public class TimeSpan
implements Serializable,
Comparable<TimeSpan> {
    private static final Integer MINUTES_PER_HOUR;
    private static final Integer SECONDS_PER_MINUTE;
    private Integer hours;
    private Integer minutes;
    private Float seconds;
    private long totalMilliseconds;
    private int totalSeconds;

    static {
        Integer n2;
        SECONDS_PER_MINUTE = n2 = Integer.valueOf((int)60);
        MINUTES_PER_HOUR = n2;
    }

    public TimeSpan(int n2, int n3, float f2) {
        this.hours = n2;
        this.minutes = n3;
        this.seconds = Float.valueOf((float)f2);
        this.normalizeTimeSpan();
        this.calculateSeconds();
    }

    public TimeSpan(String string) {
        if (string != null && string.length() != 0) {
            String[] arrstring = string.split(":");
            int n2 = arrstring.length;
            if (n2 != 1) {
                if (n2 != 2) {
                    if (n2 != 3) {
                        this.errorParsingTimespan();
                        return;
                    }
                    this.hours = Integer.valueOf((String)arrstring[0]);
                    this.minutes = Integer.valueOf((String)arrstring[1]);
                    this.seconds = Float.valueOf((String)arrstring[2]);
                } else {
                    this.hours = 0;
                    this.minutes = Integer.valueOf((String)arrstring[0]);
                    this.seconds = Float.valueOf((String)arrstring[1]);
                }
            } else {
                this.hours = 0;
                this.minutes = 0;
                this.seconds = Float.valueOf((String)arrstring[0]);
            }
            this.normalizeTimeSpan();
            this.calculateSeconds();
            this.calculateMilliseconds();
            return;
        }
        this.errorParsingTimespan();
    }

    private void calculateMilliseconds() {
        this.totalMilliseconds = (long)(1000.0f * (this.seconds.floatValue() + (float)(60 * this.minutes) + (float)(60 * (60 * this.hours))));
    }

    private void calculateSeconds() {
        this.totalSeconds = (int)(this.seconds.floatValue() + (float)(60 * this.minutes) + (float)(60 * (60 * this.hours)));
    }

    private void errorParsingTimespan() {
        Integer n2;
        AerServLog.d(this.getClass().getName(), "The format of the timespan argument is invalid.  Defaulting to 0");
        this.hours = n2 = Integer.valueOf((int)0);
        this.minutes = n2;
        this.seconds = Float.valueOf((float)0.0f);
    }

    private void normalizeTimeSpan() {
        if (this.seconds.floatValue() >= (float)SECONDS_PER_MINUTE.intValue()) {
            this.minutes = this.minutes + this.seconds.intValue() / SECONDS_PER_MINUTE;
            this.seconds = Float.valueOf((float)(this.seconds.floatValue() % (float)SECONDS_PER_MINUTE.intValue()));
        }
        if (this.minutes >= MINUTES_PER_HOUR) {
            this.hours = this.hours + this.hours / MINUTES_PER_HOUR;
            this.minutes = this.minutes % MINUTES_PER_HOUR;
        }
    }

    public int compareTo(TimeSpan timeSpan) {
        int n2 = this.hours.compareTo(timeSpan.hours);
        if (n2 == 0) {
            n2 = this.minutes.compareTo(timeSpan.minutes);
        }
        if (n2 == 0) {
            n2 = this.seconds.compareTo(timeSpan.seconds);
        }
        return n2;
    }

    public int divideBy(TimeSpan timeSpan) {
        double d2 = this.hours.intValue();
        double d3 = Math.pow((double)60.0, (double)2.0);
        Double.isNaN((double)d2);
        double d4 = d2 * d3;
        double d5 = 60 * this.minutes;
        Double.isNaN((double)d5);
        double d6 = d4 + d5;
        double d7 = this.seconds.floatValue();
        Double.isNaN((double)d7);
        double d8 = d6 + d7;
        double d9 = timeSpan.getHours().intValue();
        double d10 = Math.pow((double)60.0, (double)2.0);
        Double.isNaN((double)d9);
        double d11 = d9 * d10;
        double d12 = 60 * timeSpan.getMinutes();
        Double.isNaN((double)d12);
        double d13 = d11 + d12;
        double d14 = timeSpan.getSeconds().floatValue();
        Double.isNaN((double)d14);
        return (int)Math.round((double)(100.0 * (d8 / (d13 + d14))));
    }

    public Integer getHours() {
        return this.hours;
    }

    public Integer getMinutes() {
        return this.minutes;
    }

    public Float getSeconds() {
        return this.seconds;
    }

    public long getTotalMilliseconds() {
        return this.totalMilliseconds;
    }

    public int getTotalSeconds() {
        return this.totalSeconds;
    }

    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("00.#####");
        Object[] arrobject = new Object[]{this.hours, this.minutes, decimalFormat.format((Object)this.seconds)};
        return String.format((String)"%02d:%02d:%s", (Object[])arrobject);
    }
}


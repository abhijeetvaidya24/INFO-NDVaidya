/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.text.SimpleDateFormat
 *  java.util.ArrayList
 *  java.util.Collections
 *  java.util.Date
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Locale
 */
package com.amazon.device.ads;

import com.amazon.device.ads.StringUtils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

class CalendarEventParameters {
    public static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mmZZZZZ";
    public static final List<String> DATE_FORMATS = Collections.unmodifiableList((List)new ArrayList<String>(){
        {
            this.add((Object)CalendarEventParameters.DATE_FORMAT);
            this.add((Object)"yyyy-MM-dd'T'HH:mmZ");
            this.add((Object)"yyyy-MM-dd'T'HH:mm");
            this.add((Object)"yyyy-MM-dd");
        }
    });
    private String description;
    private Date end;
    private String location;
    private Date start;
    private String summary;

    public CalendarEventParameters(String string, String string2, String string3, String string4, String string5) {
        if (!StringUtils.isNullOrEmpty(string)) {
            this.description = string;
            this.location = string2;
            this.summary = string3;
            if (!StringUtils.isNullOrEmpty(string4)) {
                this.start = this.convertToDate(string4);
                if (StringUtils.isNullOrEmpty(string5)) {
                    this.end = null;
                    return;
                }
                this.end = this.convertToDate(string5);
                return;
            }
            throw new IllegalArgumentException("No start date for event");
        }
        throw new IllegalArgumentException("No description for event");
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private Date convertToDate(String string) {
        Date date;
        Iterator iterator = DATE_FORMATS.iterator();
        if (iterator.hasNext()) {
            String string2 = (String)iterator.next();
            {
                date = new SimpleDateFormat(string2, Locale.US).parse(string);
            }
        } else {
            date = null;
        }
        if (date != null) {
            return date;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Could not parse datetime string ");
        stringBuilder.append(string);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public String getDescription() {
        return this.description;
    }

    public Date getEnd() {
        return this.end;
    }

    public String getLocation() {
        return this.location;
    }

    public Date getStart() {
        return this.start;
    }

    public String getSummary() {
        return this.summary;
    }

}


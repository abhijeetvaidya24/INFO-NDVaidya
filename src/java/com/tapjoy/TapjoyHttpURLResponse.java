/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 *  java.util.Map
 */
package com.tapjoy;

import java.util.List;
import java.util.Map;

public class TapjoyHttpURLResponse {
    public int contentLength;
    public long date;
    public long expires;
    public Map headerFields;
    public String redirectURL;
    public String response;
    public int statusCode;

    public String getHeaderFieldAsString(String string2) {
        List list;
        Map map = this.headerFields;
        if (map != null && (list = (List)map.get((Object)string2)) != null && list.get(0) != null) {
            return (String)list.get(0);
        }
        return "";
    }
}


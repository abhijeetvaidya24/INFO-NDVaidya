/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 *  java.util.Map
 */
package com.aerserv.sdk.http;

import java.util.List;
import java.util.Map;

public interface HttpTaskListener {
    public static final int STATUS_CODE_TIMEOUT = 10001;

    public void onHttpTaskFailure(String var1, int var2);

    public void onHttpTaskSuccess(String var1, int var2, Map<String, List<String>> var3, String var4);
}


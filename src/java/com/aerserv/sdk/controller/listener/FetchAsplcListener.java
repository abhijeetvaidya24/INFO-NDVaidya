/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package com.aerserv.sdk.controller.listener;

import com.aerserv.sdk.model.Asplc;
import java.util.List;

public interface FetchAsplcListener {
    public void onError();

    public void onSuccess(String var1, List<Asplc> var2, List<Integer> var3);
}


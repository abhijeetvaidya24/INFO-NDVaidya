/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.tapjoy;

public interface TJActionRequest {
    public void cancelled();

    public void completed();

    public String getRequestId();

    public String getToken();
}


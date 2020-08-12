/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Object
 *  java.lang.String
 *  java.util.concurrent.TimeUnit
 */
package com.startapp.android.publish.adsCommon.f;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

public class a
implements Serializable {
    private static final String a = new String(new byte[]{104, 116, 116, 112, 115, 58, 47, 47, 105, 109, 112, 46, 115, 116, 97, 114, 116, 97, 112, 112, 115, 101, 114, 118, 105, 99, 101, 46, 99, 111, 109, 47, 116, 114, 97, 99, 107, 105, 110, 103, 47, 105, 110, 102, 111, 69, 118, 101, 110, 116});
    private static final long serialVersionUID = 1L;
    private boolean dns;
    public String hostPeriodic;
    public String hostSecured;
    private int retryNum;
    private int retryTime;
    private boolean sendHopsOnFirstSucceededSmartRedirect;
    private float succeededSmartRedirectInfoProbability;

    public a() {
        String string;
        this.hostSecured = string = a;
        this.hostPeriodic = string;
        this.dns = false;
        this.retryNum = 3;
        this.retryTime = 10;
        this.succeededSmartRedirectInfoProbability = 0.01f;
        this.sendHopsOnFirstSucceededSmartRedirect = false;
    }

    public String a() {
        return this.hostSecured;
    }

    public String b() {
        String string = this.hostPeriodic;
        if (string != null) {
            return string;
        }
        return a;
    }

    public boolean c() {
        return this.dns;
    }

    public int d() {
        return this.retryNum;
    }

    public long e() {
        return TimeUnit.SECONDS.toMillis((long)this.retryTime);
    }

    public float f() {
        return this.succeededSmartRedirectInfoProbability;
    }

    public boolean g() {
        return this.sendHopsOnFirstSucceededSmartRedirect;
    }
}


/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Object
 *  java.util.List
 */
package com.startapp.android.publish.adsCommon.a;

import com.startapp.android.publish.adsCommon.a.a;
import com.startapp.common.c.e;
import java.io.Serializable;
import java.util.List;

@e(a="type", b="com.startapp.android.publish.adsCommon.adrules")
public abstract class c
implements Serializable {
    private static final long serialVersionUID = 1L;
    private transient boolean a;

    public boolean a() {
        return this.a;
    }

    public abstract boolean a(List<a> var1);
}


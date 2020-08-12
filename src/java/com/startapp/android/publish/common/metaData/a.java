/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Object
 */
package com.startapp.android.publish.common.metaData;

import java.io.Serializable;

public class a
implements Serializable {
    private static final long serialVersionUID = 1L;
    private int delay = 3;
    private boolean enabled = true;
    private int minApiLevel = 18;

    public a() {
    }

    public a(int n2) {
        this.minApiLevel = n2;
    }

    public int a() {
        return this.delay;
    }

    public int b() {
        return this.minApiLevel;
    }

    public boolean c() {
        return this.enabled;
    }
}


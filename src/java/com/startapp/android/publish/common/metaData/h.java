/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.io.Serializable
 *  java.lang.Object
 */
package com.startapp.android.publish.common.metaData;

import android.content.Context;
import com.startapp.android.publish.adsCommon.k;
import java.io.Serializable;

public class h
implements Serializable {
    private static final long serialVersionUID = 1L;
    private boolean enabled = false;

    public void a(Context context, boolean bl) {
        k.b(context, "userDisabledSimpleToken", bl ^ true);
    }

    public boolean a() {
        return this.enabled;
    }

    public boolean a(Context context) {
        return k.a(context, "userDisabledSimpleToken", false);
    }

    public boolean b(Context context) {
        return !this.a(context) && this.a();
    }
}


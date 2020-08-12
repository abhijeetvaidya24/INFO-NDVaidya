/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 */
package io.presage.core;

import android.content.Context;
import android.content.SharedPreferences;
import io.presage.core.lIIIIIlI;

public class CoreSdkType {
    private static final String IIIIIIII = lIIIIIlI.IIIIlllI.IIIIIIII;
    private static final String IIIIIIIl = lIIIIIlI.IIIIlllI.IIIIIIIl;
    private Integer IIIIIIlI;
    private SharedPreferences IIIIIIll;

    public CoreSdkType(Context context) {
        this.IIIIIIll = context.getSharedPreferences(IIIIIIII, 0);
    }

    public int getType() {
        if (this.IIIIIIlI == null) {
            this.IIIIIIlI = this.IIIIIIll.getInt(IIIIIIIl, 0);
        }
        return this.IIIIIIlI;
    }

    public void setType(int n2) {
        this.IIIIIIlI = n2;
        this.IIIIIIll.edit().putInt(IIIIIIIl, this.IIIIIIlI.intValue()).apply();
    }
}


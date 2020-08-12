/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  java.lang.Object
 *  java.lang.String
 */
package io.presage.common;

import android.content.Context;
import android.content.SharedPreferences;

public final class SdkType {
    public static final CamembertauCalvados a = new CamembertauCalvados(0);
    private final SharedPreferences b;

    private SdkType(Context context) {
        this.b = context.getSharedPreferences("sdktypefile", 0);
    }

    public /* synthetic */ SdkType(Context context, byte by) {
        this(context);
    }

    public static final SdkType create(Context context) {
        return CamembertauCalvados.a(context);
    }

    public final int a() {
        return this.b.getInt("sdk_type", 0);
    }

    public final void setType(int n2) {
        this.b.edit().putInt("sdk_type", n2).apply();
    }

    public static final class CamembertauCalvados {
        private CamembertauCalvados() {
        }

        public /* synthetic */ CamembertauCalvados(byte by) {
            this();
        }

        public static SdkType a(Context context) {
            return new SdkType(context, 0);
        }
    }

}


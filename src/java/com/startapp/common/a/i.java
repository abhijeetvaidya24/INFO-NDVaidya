/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.widget.Toast
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 */
package com.startapp.common.a;

import android.content.Context;
import android.widget.Toast;

public class i {
    private static i a = new i();
    private Toast b;

    private i() {
    }

    public static i a() {
        return a;
    }

    public void a(Context context, String string) {
        Toast toast = this.b;
        if (toast == null) {
            this.b = Toast.makeText((Context)context, (CharSequence)string, (int)0);
        } else {
            toast.setText((CharSequence)string);
            this.b.setDuration(0);
        }
        this.b.show();
    }
}


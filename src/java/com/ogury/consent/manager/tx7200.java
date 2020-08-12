/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.io.Serializable
 *  java.lang.Object
 *  java.lang.String
 */
package com.ogury.consent.manager;

import android.content.Context;
import com.ogury.consent.manager.rtf1;
import com.ogury.consent.manager.tx6480;
import java.io.Serializable;

public final class tx7200 {
    public static boolean a(Context context) {
        tx6480.b((Object)context, "context");
        return rtf1.rtf1.b(context);
    }

    public static final class rtf1
    implements Serializable {
        public boolean a;

        public final String toString() {
            return String.valueOf((boolean)this.a);
        }
    }

}


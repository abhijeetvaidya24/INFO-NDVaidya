/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  com.adincube.sdk.d.a.q
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.VerifyError
 */
package com.adincube.sdk.util.b;

import android.os.Build;
import com.adincube.sdk.d.a.q;

public final class a {
    public static void a() {
        boolean bl = a.b() >= 7;
        if (bl) {
            return;
        }
        throw new q();
    }

    public static int b() {
        if (Build.VERSION.RELEASE.startsWith("1.5")) {
            return 3;
        }
        try {
            int n2 = Build.VERSION.SDK_INT;
            return n2;
        }
        catch (VerifyError verifyError) {
            return 3;
        }
    }
}


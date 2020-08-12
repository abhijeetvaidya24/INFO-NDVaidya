/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Object
 */
package io.presage;

import android.content.Context;
import io.presage.ads.AdsSdkType;
import io.presage.core.CoreSdkType;

public class SdkType {
    private Context IIIIIIII;

    public SdkType(Context context) {
        this.IIIIIIII = context;
    }

    public void setType(int n2) {
        new CoreSdkType(this.IIIIIIII).setType(n2);
        new AdsSdkType(this.IIIIIIII).setType(n2);
    }
}


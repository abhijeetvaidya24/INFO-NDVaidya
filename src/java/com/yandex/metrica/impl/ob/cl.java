/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.pm.FeatureInfo
 *  java.lang.Object
 *  java.lang.String
 */
package com.yandex.metrica.impl.ob;

import android.content.pm.FeatureInfo;
import com.yandex.metrica.impl.ob.cm;

public abstract class cl {
    protected abstract cm a(FeatureInfo var1);

    public cm b(FeatureInfo featureInfo) {
        if (featureInfo.name == null) {
            if (featureInfo.reqGlEsVersion == 0) {
                return this.a(featureInfo);
            }
            return new cm("openGlFeature", featureInfo.reqGlEsVersion, this.c(featureInfo));
        }
        return this.a(featureInfo);
    }

    boolean c(FeatureInfo featureInfo) {
        return (1 & featureInfo.flags) != 0;
    }
}


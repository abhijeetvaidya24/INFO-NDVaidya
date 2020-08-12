/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.util.AttributeSet
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 */
package com.startapp.android.publish.ads.banner;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;

class b {
    private Context a;
    private String b;

    b(Context context, AttributeSet attributeSet) {
        this.a = context;
        this.b = this.a(attributeSet, "adTag");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private String a(AttributeSet attributeSet, String string) {
        String string2 = null;
        try {
            int n2 = attributeSet.getAttributeResourceValue(null, string, -1);
            String string3 = n2 != -1 ? this.a.getResources().getString(n2) : attributeSet.getAttributeValue(null, string);
            return string3;
        }
        catch (Exception exception) {}
        return string2;
    }

    public String a() {
        return this.b;
    }
}


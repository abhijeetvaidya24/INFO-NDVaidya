/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package com.adincube.sdk.mediation.d;

import com.adincube.sdk.mediation.a;
import com.adincube.sdk.mediation.b;
import com.adincube.sdk.mediation.j;
import com.aerserv.sdk.AerServEvent;
import java.util.List;

public final class c {
    a a = null;
    boolean b = false;
    private b c = null;

    public c(b b2) {
        this.c = b2;
    }

    public final void a(j j2) {
        a a2 = this.a;
        if (a2 != null) {
            a2.a(j2);
        }
    }

    public final boolean a(AerServEvent aerServEvent, List<Object> list) {
        int n2 = 1.a[aerServEvent.ordinal()];
        if (n2 != 1) {
            if (n2 != 2) {
                if (n2 != 3) {
                    return false;
                }
                int n3 = list.size();
                String string = null;
                if (n3 > 0) {
                    boolean bl = list.get(0) instanceof String;
                    string = null;
                    if (bl) {
                        string = (String)list.get(0);
                    }
                }
                j.a a2 = j.a.d;
                if ("No ad available for this request.".equals(string)) {
                    a2 = j.a.b;
                }
                this.a(new j(this.c, a2, string));
            }
            return true;
        }
        this.b = true;
        a a3 = this.a;
        if (a3 != null) {
            a3.a();
        }
        return true;
    }

}


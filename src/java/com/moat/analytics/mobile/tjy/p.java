/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  android.webkit.ValueCallback
 *  com.moat.analytics.mobile.tjy.n
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.moat.analytics.mobile.tjy;

import android.util.Log;
import android.webkit.ValueCallback;
import com.moat.analytics.mobile.tjy.n;

class p
implements ValueCallback {
    final /* synthetic */ n a;

    p(n n2) {
        this.a = n2;
    }

    public void a(String string2) {
        String string3 = "null";
        if (string2 != null && !string2.equalsIgnoreCase(string3) && !string2.equalsIgnoreCase("false")) {
            if (string2.equalsIgnoreCase("true")) {
                n.a((n)this.a, (int)-1);
                n.a((n)this.a);
                return;
            }
            if (n.b((n)this.a).b()) {
                StringBuilder stringBuilder = new StringBuilder("Received unusual value from Javascript:");
                stringBuilder.append(string2);
                Log.d((String)"MoatJavaScriptBridge", (String)stringBuilder.toString());
            }
            return;
        }
        if (n.b((n)this.a).b()) {
            StringBuilder stringBuilder = new StringBuilder("Received value is:");
            if (string2 != null) {
                StringBuilder stringBuilder2 = new StringBuilder("(String)");
                stringBuilder2.append(string2);
                string3 = stringBuilder2.toString();
            }
            stringBuilder.append(string3);
            Log.d((String)"MoatJavaScriptBridge", (String)stringBuilder.toString());
        }
        if (n.c((n)this.a) == -1 || n.c((n)this.a) == 50) {
            n.d((n)this.a);
        }
        n.e((n)this.a);
    }

    public /* synthetic */ void onReceiveValue(Object object) {
        this.a((String)object);
    }
}


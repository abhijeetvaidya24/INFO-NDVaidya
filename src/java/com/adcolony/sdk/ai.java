/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.util.HashMap
 */
package com.adcolony.sdk;

import android.os.Bundle;
import java.util.HashMap;

class ai {
    private static int f;
    private static HashMap<String, Integer> g;
    private static HashMap<String, Integer> h;

    static {
        g = new HashMap();
        h = new HashMap();
    }

    static boolean a(int n2, Bundle bundle) {
        int n3 = (int)(System.currentTimeMillis() / 1000L);
        if (n2 != 0) {
            if (n2 != 1) {
                return false;
            }
            if (bundle == null) {
                return false;
            }
            String string = bundle.getString("zone_id");
            if (g.get((Object)string) == null) {
                g.put((Object)string, (Object)n3);
            }
            if (h.get((Object)string) == null) {
                h.put((Object)string, (Object)0);
            }
            if (n3 - (Integer)g.get((Object)string) > 1) {
                h.put((Object)string, (Object)1);
                g.put((Object)string, (Object)n3);
                return false;
            }
            int n4 = 1 + (Integer)h.get((Object)string);
            h.put((Object)string, (Object)n4);
            return n4 > 3;
        }
        if (n3 - f < 5) {
            return true;
        }
        f = n3;
        return false;
    }
}


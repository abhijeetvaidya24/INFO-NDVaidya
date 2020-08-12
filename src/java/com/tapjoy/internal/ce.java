/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.InputStream
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.net.URI
 *  java.util.LinkedHashMap
 *  java.util.Map
 */
package com.tapjoy.internal;

import com.tapjoy.internal.bs;
import com.tapjoy.internal.cf;
import com.tapjoy.internal.cg;
import java.io.InputStream;
import java.net.URI;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class ce
extends cf {
    public abstract Object a(bs var1);

    @Override
    public final Object a(URI uRI, InputStream inputStream) {
        int n2;
        String string;
        block8 : {
            bs bs2 = bs.a(inputStream);
            bs2.a("BASE_URI", (Object)uRI);
            n2 = 0;
            bs2.h();
            Object object = null;
            string = null;
            try {
                while (bs2.j()) {
                    String string2 = bs2.l();
                    if ("status".equals((Object)string2)) {
                        n2 = bs2.r();
                        continue;
                    }
                    if ("message".equals((Object)string2)) {
                        string = bs2.m();
                        continue;
                    }
                    if ("data".equals((Object)string2)) {
                        object = this.a(bs2);
                        continue;
                    }
                    bs2.s();
                }
                bs2.i();
                if (n2 != 200) break block8;
            }
            catch (Throwable throwable) {
                bs2.close();
                throw throwable;
            }
            bs2.close();
            return object;
        }
        throw new cg(n2, string);
    }

    @Override
    public final Map a() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put((Object)"Accept", (Object)"application/json");
        return linkedHashMap;
    }
}


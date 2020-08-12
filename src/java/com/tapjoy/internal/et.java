/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.HashMap
 *  java.util.Map
 */
package com.tapjoy.internal;

import com.tapjoy.TapjoyLog;
import com.tapjoy.internal.aq;
import com.tapjoy.internal.fi;
import java.util.HashMap;
import java.util.Map;

public abstract class et {
    private static final String c = "et";
    public final Map a = new HashMap();
    public final Map b = new HashMap();

    protected et(String string2, String string3, String string4) {
        this.a.put((Object)"placement", (Object)string2);
        this.a.put((Object)"placement_type", (Object)string3);
        this.a.put((Object)"content_type", (Object)string4);
    }

    public final fi.a a() {
        return this.a("Content.rendered", null, null);
    }

    protected final fi.a a(String string2, Map map, Map map2) {
        fi.a a2 = fi.e(string2).a().a(this.a).a(map).b(map2);
        this.b.put((Object)string2, (Object)a2);
        return a2;
    }

    public final void a(String string2, Object object) {
        this.a.put((Object)string2, object);
    }

    public final fi.a b() {
        return this.b("Content.rendered", null, null);
    }

    protected final fi.a b(String string2, Map map, Map map2) {
        fi.a a2 = !aq.a(string2) ? (fi.a)this.b.remove((Object)string2) : null;
        if (a2 == null) {
            String string3 = c;
            StringBuilder stringBuilder = new StringBuilder("Error when calling endTrackingEvent -- ");
            stringBuilder.append(string2);
            stringBuilder.append(" tracking has not been started.");
            TapjoyLog.e(string3, stringBuilder.toString());
            return a2;
        }
        a2.a(this.a).a(map).b(map2).b().c();
        return a2;
    }
}


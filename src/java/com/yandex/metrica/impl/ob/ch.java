/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.Calendar
 *  java.util.GregorianCalendar
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.cj;
import java.util.Calendar;
import java.util.GregorianCalendar;
import org.json.JSONException;
import org.json.JSONObject;

public class ch {
    private final String a;
    private final cj b;
    private final long c;
    private final boolean d;
    private final long e;

    public ch(String string2, cj cj2, long l2) {
        this.a = string2;
        this.b = cj2;
        this.c = l2;
        this.d = this.f();
        this.e = -1L;
    }

    public ch(JSONObject jSONObject, long l2) throws JSONException {
        this.a = jSONObject.getString("device_id");
        this.b = jSONObject.has("device_snapshot_key") ? new cj(jSONObject.getString("device_snapshot_key")) : null;
        this.c = jSONObject.optLong("last_elections_time", -1L);
        this.d = this.f();
        this.e = l2;
    }

    private boolean f() {
        return this.c > -1L && System.currentTimeMillis() - this.c < 604800000L;
    }

    public String a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("device_id", (Object)this.a);
        cj cj2 = this.b;
        if (cj2 != null) {
            jSONObject.put("device_snapshot_key", (Object)cj2.a());
        }
        jSONObject.put("last_elections_time", this.c);
        return jSONObject.toString();
    }

    public boolean a(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null) {
            if (this.getClass() != object.getClass()) {
                return false;
            }
            ch ch2 = (ch)object;
            if (this.d != ch2.d) {
                return false;
            }
            if (!this.a.equals((Object)ch2.a)) {
                return false;
            }
            cj cj2 = this.b;
            if (cj2 != null) {
                return cj2.equals(ch2.b);
            }
            if (ch2.b == null) {
                return true;
            }
        }
        return false;
    }

    public boolean b() {
        if (this.e > -1L) {
            Calendar calendar = GregorianCalendar.getInstance();
            calendar.setTimeInMillis(this.e);
            if (calendar.get(1) == 1970) {
                return true;
            }
        }
        return false;
    }

    public String c() {
        return this.a;
    }

    public cj d() {
        return this.b;
    }

    public boolean e() {
        return this.d;
    }

    public int hashCode() {
        int n2 = 31 * this.a.hashCode();
        cj cj2 = this.b;
        int n3 = cj2 != null ? cj2.hashCode() : 0;
        return 31 * (n2 + n3) + this.d;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Credentials{mFresh=");
        stringBuilder.append(this.d);
        stringBuilder.append(", mLastElectionsTime=");
        stringBuilder.append(this.c);
        stringBuilder.append(", mDeviceSnapshot=");
        stringBuilder.append((Object)this.b);
        stringBuilder.append(", mDeviceID='");
        stringBuilder.append(this.a);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}


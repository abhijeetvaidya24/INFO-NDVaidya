/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  org.json.JSONObject
 */
package io.presage;

import io.presage.cl;
import org.json.JSONObject;

public final class Comte18mois {
    private final boolean a;
    private final long b;
    private final JSONObject c;
    private final boolean d;
    private final String e;

    public /* synthetic */ Comte18mois(long l2, JSONObject jSONObject, boolean bl2) {
        this(false, l2, jSONObject, bl2, null);
    }

    public Comte18mois(boolean bl2, long l2, JSONObject jSONObject, boolean bl3, String string2) {
        this.a = bl2;
        this.b = l2;
        this.c = jSONObject;
        this.d = bl3;
        this.e = string2;
    }

    public final boolean a() {
        return this.a;
    }

    public final long b() {
        return this.b;
    }

    public final JSONObject c() {
        return this.c;
    }

    public final boolean d() {
        return this.d;
    }

    public final String e() {
        return this.e;
    }

    public final boolean equals(Object object) {
        if (this != object) {
            if (object instanceof Comte18mois) {
                boolean bl2;
                boolean bl3;
                Comte18mois comte18mois = (Comte18mois)object;
                boolean bl4 = this.a == comte18mois.a;
                if (bl4 && (bl2 = this.b == comte18mois.b) && cl.a((Object)this.c, (Object)comte18mois.c) && (bl3 = this.d == comte18mois.d) && cl.a((Object)this.e, (Object)comte18mois.e)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int n2 = this.a;
        int n3 = 1;
        if (n2 != 0) {
            n2 = 1;
        }
        int n4 = n2 * 31;
        long l2 = this.b;
        int n5 = 31 * (n4 + (int)(l2 ^ l2 >>> 32));
        JSONObject jSONObject = this.c;
        int n6 = jSONObject != null ? jSONObject.hashCode() : 0;
        int n7 = 31 * (n5 + n6);
        int n8 = this.d;
        if (n8 == 0) {
            n3 = n8;
        }
        int n9 = 31 * (n7 + n3);
        String string2 = this.e;
        int n10 = 0;
        if (string2 != null) {
            n10 = string2.hashCode();
        }
        return n9 + n10;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("ProfigRequest(allowRequest=");
        stringBuilder.append(this.a);
        stringBuilder.append(", jobScheduleWindow=");
        stringBuilder.append(this.b);
        stringBuilder.append(", request=");
        stringBuilder.append((Object)this.c);
        stringBuilder.append(", profigEnabled=");
        stringBuilder.append(this.d);
        stringBuilder.append(", profigHash=");
        stringBuilder.append(this.e);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}


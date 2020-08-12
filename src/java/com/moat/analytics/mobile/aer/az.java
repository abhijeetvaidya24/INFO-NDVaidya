/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.moat.analytics.mobile.aer;

import com.moat.analytics.mobile.aer.base.asserts.a;

final class az {
    static final az a = new az("", "");
    final String b;
    final String c;

    public az(String string, String string2) {
        a.a(string);
        a.a(string2);
        this.b = string;
        this.c = string2;
    }

    public boolean a() {
        return this == a || this.c.trim().isEmpty();
        {
        }
    }

    public String b() {
        if (this.a()) {
            return "";
        }
        Object[] arrobject = new Object[]{this.c, this.b};
        return String.format((String)"%s(%s)", (Object[])arrobject);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null) {
            if (this.getClass() != object.getClass()) {
                return false;
            }
            az az2 = (az)object;
            if (!this.b.equals((Object)az2.b)) {
                return false;
            }
            return this.c.equals((Object)az2.c);
        }
        return false;
    }

    public int hashCode() {
        return 31 * this.b.hashCode() + this.c.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ResponseToJS{message='");
        stringBuilder.append(this.b);
        stringBuilder.append('\'');
        stringBuilder.append(", function='");
        stringBuilder.append(this.c);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}


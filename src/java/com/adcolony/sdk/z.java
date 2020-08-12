/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.text.SimpleDateFormat
 *  java.util.Date
 *  java.util.Locale
 */
package com.adcolony.sdk;

import com.adcolony.sdk.v;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

class z {
    static final SimpleDateFormat l = new SimpleDateFormat("yyyyMMdd'T'HHmmss.SSSZ", Locale.US);
    private Date a;
    private int b;
    private v c;
    protected String o;

    z() {
    }

    String b() {
        int n2 = this.b;
        if (n2 != -1) {
            if (n2 != 0) {
                if (n2 != 1) {
                    if (n2 != 2) {
                        if (n2 != 3) {
                            return "UNKNOWN LOG LEVEL";
                        }
                        return "Debug";
                    }
                    return "Info";
                }
                return "Warn";
            }
            return "Error";
        }
        return "Fatal";
    }

    String d() {
        return this.o;
    }

    String e() {
        return l.format(this.a);
    }

    v f() {
        return this.c;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.e());
        stringBuilder.append(" ");
        stringBuilder.append(this.b());
        stringBuilder.append("/");
        stringBuilder.append(this.f().d());
        stringBuilder.append(": ");
        stringBuilder.append(this.d());
        return stringBuilder.toString();
    }

    static class a {
        protected z b = new z();

        a() {
        }

        a a(int n2) {
            this.b.b = n2;
            return this;
        }

        a a(v v2) {
            this.b.c = v2;
            return this;
        }

        a a(String string) {
            this.b.o = string;
            return this;
        }

        z a() {
            if (this.b.a == null) {
                this.b.a = new Date(System.currentTimeMillis());
            }
            return this.b;
        }
    }

}


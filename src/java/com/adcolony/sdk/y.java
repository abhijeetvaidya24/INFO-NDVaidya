/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.adcolony.sdk;

import com.adcolony.sdk.aa;
import com.adcolony.sdk.au;

class y {
    static y a = new y(3, false);
    static y b = new y(3, true);
    static y c = new y(2, false);
    static y d = new y(2, true);
    static y e = new y(1, false);
    static y f = new y(1, true);
    static y g = new y(0, false);
    static y h = new y(0, true);
    private int i;
    private boolean j;

    y(int n2, boolean bl) {
        this.i = n2;
        this.j = bl;
    }

    private void a(String string) {
        aa.a(this.i, string, this.j);
    }

    static class a {
        StringBuilder a = new StringBuilder();

        a() {
        }

        a a(double d2) {
            au.a(d2, 2, this.a);
            return this;
        }

        a a(int n2) {
            this.a.append(n2);
            return this;
        }

        a a(Object object) {
            if (object != null) {
                this.a.append(object.toString());
                return this;
            }
            this.a.append("null");
            return this;
        }

        a a(String string) {
            this.a.append(string);
            return this;
        }

        void a(y y2) {
            y2.a(this.a.toString());
        }
    }

}


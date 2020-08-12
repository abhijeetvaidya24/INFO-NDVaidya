/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 */
package com.applovin.impl.mediation;

import android.os.Bundle;

public class f {
    private final Bundle a;

    private f(a a2) {
        this.a = a2.a;
    }

    public Bundle a() {
        return this.a;
    }

    public static class a {
        private final Bundle a = new Bundle();

        public a a(String string) {
            if (string != null) {
                this.a.remove(string);
                return this;
            }
            throw new IllegalArgumentException("No key specified.");
        }

        public a a(String string, String string2) {
            if (string != null) {
                this.a.putString(string, string2);
                return this;
            }
            throw new IllegalArgumentException("No key specified");
        }

        public f a() {
            return new f(this);
        }
    }

}


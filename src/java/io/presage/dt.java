/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.presage.at
 *  java.io.Serializable
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 *  java.util.regex.Matcher
 *  java.util.regex.Pattern
 */
package io.presage;

import io.presage.at;
import io.presage.cl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class dt
implements Serializable {
    public static final CamembertauCalvados a = new CamembertauCalvados(0);
    private final Pattern b;

    public dt(String string) {
        Pattern pattern = Pattern.compile((String)string);
        cl.a((Object)pattern, "Pattern.compile(pattern)");
        this(pattern);
    }

    public dt(Pattern pattern) {
        this.b = pattern;
    }

    private final Object writeReplace() {
        String string = this.b.pattern();
        cl.a((Object)string, "nativePattern.pattern()");
        return new CamembertdeNormandie(string, this.b.flags());
    }

    public final boolean a(CharSequence charSequence) {
        return this.b.matcher(charSequence).find();
    }

    public final List<String> b(CharSequence charSequence) {
        Matcher matcher = this.b.matcher(charSequence);
        if (!matcher.find()) {
            return at.a((Object)charSequence.toString());
        }
        ArrayList arrayList = new ArrayList(10);
        int n2 = 0;
        do {
            arrayList.add((Object)charSequence.subSequence(n2, matcher.start()).toString());
            n2 = matcher.end();
        } while (matcher.find());
        arrayList.add((Object)charSequence.subSequence(n2, charSequence.length()).toString());
        return (List)arrayList;
    }

    public final String toString() {
        String string = this.b.toString();
        cl.a((Object)string, "nativePattern.toString()");
        return string;
    }

    public static final class CamembertauCalvados {
        private CamembertauCalvados() {
        }

        public /* synthetic */ CamembertauCalvados(byte by) {
            this();
        }
    }

    static final class CamembertdeNormandie
    implements Serializable {
        public static final CamembertauCalvados a = new CamembertauCalvados(0);
        private static final long serialVersionUID;
        private final String b;
        private final int c;

        public CamembertdeNormandie(String string, int n2) {
            this.b = string;
            this.c = n2;
        }

        private final Object readResolve() {
            Pattern pattern = Pattern.compile((String)this.b, (int)this.c);
            cl.a((Object)pattern, "Pattern.compile(pattern, flags)");
            return new dt(pattern);
        }

        public static final class CamembertauCalvados {
            private CamembertauCalvados() {
            }

            public /* synthetic */ CamembertauCalvados(byte by) {
                this();
            }
        }

    }

}


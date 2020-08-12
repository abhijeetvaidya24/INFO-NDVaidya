/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Date
 *  java.util.HashSet
 *  java.util.Set
 */
package com.adincube.sdk.util.g;

import com.adincube.sdk.util.g.b;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public final class d
extends b {
    public Date b = null;
    public Date c = null;
    public Integer d = null;
    public Integer e = null;
    public Integer f = null;
    public String g = null;
    public Integer h = null;
    public Set<Integer> i = new HashSet();
    public int j = 0;
    public boolean k;
    public Set<Integer> l = new HashSet();
    public boolean m;
    public Boolean n = null;
    public Set<a> o = new HashSet();

    @Override
    public final boolean a() {
        if (this.m) {
            for (a a2 : this.o) {
                boolean bl = 31 >= a2.a && 31 <= a2.b;
                if (!bl) continue;
                return this.n == false;
            }
            return this.n;
        }
        if (this.k) {
            return this.l.contains((Object)31);
        }
        return false;
    }

}


/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  io.presage.BleudesCausses
 *  io.presage.BriedeMeaux
 *  io.presage.r
 *  java.lang.Object
 */
package io.presage;

import android.content.Context;
import io.presage.BleudesCausses;
import io.presage.BriedeMeaux;
import io.presage.cl;
import io.presage.r;

public final class Bofavre {
    public static final CamembertauCalvados a = new CamembertauCalvados(0);
    private final BleudesCausses b;
    private final BriedeMeaux c;

    public Bofavre(Context context) {
        this.b = new BleudesCausses(context);
        this.c = new BriedeMeaux(context);
    }

    public final r a() {
        return (r)this.b;
    }

    public final r b() {
        return (r)this.c;
    }

    public static final class CamembertauCalvados {
        private CamembertauCalvados() {
        }

        public /* synthetic */ CamembertauCalvados(byte by) {
            this();
        }

        public static Bofavre a(Context context) {
            Context context2 = context.getApplicationContext();
            cl.a((Object)context2, "context.applicationContext");
            return new Bofavre(context2);
        }
    }

}


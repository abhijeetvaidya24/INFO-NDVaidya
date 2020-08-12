/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashSet
 *  java.util.Set
 */
package io.presage;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashSet;
import java.util.Set;

public final class TetedeMoine {
    public static final CamembertauCalvados a = new CamembertauCalvados(0);
    private final Context b;
    private final String c;

    public TetedeMoine(Context context, String string2) {
        this.b = context;
        this.c = string2;
    }

    public final boolean a(String string2) {
        SharedPreferences sharedPreferences = this.b.getSharedPreferences("PERSISTED_SETS", 0);
        Set set = sharedPreferences.getStringSet(this.c, null);
        if (set == null) {
            set = (Set)new HashSet();
        }
        set.add((Object)string2);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putStringSet(this.c, set);
        editor.apply();
        return true;
    }

    public final boolean b(String string2) {
        Set set = this.b.getSharedPreferences("PERSISTED_SETS", 0).getStringSet(this.c, null);
        if (set != null) {
            return set.contains((Object)string2);
        }
        return false;
    }

    public final boolean c(String string2) {
        SharedPreferences sharedPreferences = this.b.getSharedPreferences("PERSISTED_SETS", 0);
        Set set = sharedPreferences.getStringSet(this.c, null);
        if (set != null && set.remove((Object)string2)) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putStringSet(this.c, set);
            editor.apply();
            return true;
        }
        return false;
    }

    public static final class CamembertauCalvados {
        private CamembertauCalvados() {
        }

        public /* synthetic */ CamembertauCalvados(byte by) {
            this();
        }
    }

}


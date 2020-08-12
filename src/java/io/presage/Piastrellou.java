/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.media.AudioManager
 *  java.lang.Object
 *  java.lang.String
 */
package io.presage;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.AudioManager;
import io.presage.ak;
import io.presage.cl;

public final class Piastrellou {
    public static final CamembertauCalvados a = new CamembertauCalvados(0);
    private final Context b;

    public Piastrellou(Context context) {
        this.b = context;
    }

    public final int a() {
        Object object = this.b.getSystemService("audio");
        if (object != null) {
            return ((AudioManager)object).getStreamVolume(3);
        }
        throw new ak("null cannot be cast to non-null type android.media.AudioManager");
    }

    public final String b() {
        Resources resources = this.b.getResources();
        cl.a((Object)resources, "context.resources");
        if (resources.getConfiguration().orientation == 2) {
            return "landscape";
        }
        return "portrait";
    }

    public final boolean c() {
        Context context = this.b;
        if (context instanceof Activity) {
            if (((Activity)context).getRequestedOrientation() != 1) {
                return ((Activity)this.b).getRequestedOrientation() == 0;
            }
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


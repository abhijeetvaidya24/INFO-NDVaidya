/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  io.presage.OlivetauPoivre
 *  java.lang.Object
 */
package io.presage.interstitial;

import android.app.Activity;
import io.presage.OlivetauPoivre;
import io.presage.ci;
import io.presage.common.AdConfig;
import io.presage.interstitial.PresageInterstitialCallback;

public final class PresageInterstitial {
    public static final CamembertauCalvados a = new CamembertauCalvados(0);
    private final OlivetauPoivre b;

    public PresageInterstitial(Activity activity) {
        this(activity, null);
    }

    public PresageInterstitial(Activity activity, AdConfig adConfig) {
        this(new OlivetauPoivre(activity, adConfig));
    }

    private PresageInterstitial(OlivetauPoivre olivetauPoivre) {
        this.b = olivetauPoivre;
    }

    public /* synthetic */ PresageInterstitial(OlivetauPoivre olivetauPoivre, ci ci2) {
        this(olivetauPoivre);
    }

    public final boolean isLoaded() {
        return this.b.a();
    }

    public final void load() {
        this.b.d();
    }

    public final void setInterstitialCallback(PresageInterstitialCallback presageInterstitialCallback) {
        this.b.a(presageInterstitialCallback);
    }

    public final void show() {
        this.b.e();
    }

    public static final class CamembertauCalvados {
        private CamembertauCalvados() {
        }

        public /* synthetic */ CamembertauCalvados(byte by) {
            this();
        }
    }

}


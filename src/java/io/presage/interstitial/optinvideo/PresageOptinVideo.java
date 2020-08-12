/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  io.presage.PaletdeBourgogne
 *  io.presage.interstitial.optinvideo.PresageOptinVideoCallback
 *  java.lang.Object
 *  java.lang.String
 */
package io.presage.interstitial.optinvideo;

import android.app.Activity;
import io.presage.PaletdeBourgogne;
import io.presage.ci;
import io.presage.common.AdConfig;
import io.presage.interstitial.optinvideo.PresageOptinVideoCallback;

public final class PresageOptinVideo {
    public static final CamembertauCalvados a = new CamembertauCalvados(0);
    private final PaletdeBourgogne b;

    public PresageOptinVideo(Activity activity, AdConfig adConfig) {
        this(new PaletdeBourgogne(activity, adConfig));
    }

    private PresageOptinVideo(PaletdeBourgogne paletdeBourgogne) {
        this.b = paletdeBourgogne;
    }

    public /* synthetic */ PresageOptinVideo(PaletdeBourgogne paletdeBourgogne, ci ci2) {
        this(paletdeBourgogne);
    }

    public final boolean isLoaded() {
        return this.b.a();
    }

    public final void load() {
        this.b.d();
    }

    public final void setOptinVideoCallback(PresageOptinVideoCallback presageOptinVideoCallback) {
        this.b.a(presageOptinVideoCallback);
    }

    public final void setUserId(String string) {
        this.b.b(string);
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


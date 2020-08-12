/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.database.ContentObserver
 *  android.media.AudioManager
 *  android.net.Uri
 *  android.os.Handler
 *  android.provider.Settings
 *  android.provider.Settings$System
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  org.json.JSONObject
 */
package com.adcolony.sdk;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Handler;
import android.provider.Settings;
import com.adcolony.sdk.AdColonyInterstitial;
import com.adcolony.sdk.a;
import com.adcolony.sdk.ad;
import com.adcolony.sdk.c;
import com.adcolony.sdk.g;
import com.adcolony.sdk.w;
import com.adcolony.sdk.y;
import com.integralads.avid.library.adcolony.session.AvidManagedVideoAdSession;
import com.integralads.avid.library.adcolony.video.AvidVideoPlaybackListener;
import org.json.JSONObject;

class k
extends ContentObserver {
    private AudioManager a;
    private AdColonyInterstitial b;

    public k(Handler handler, AdColonyInterstitial adColonyInterstitial) {
        super(handler);
        Context context = a.c();
        if (context != null) {
            this.a = (AudioManager)context.getSystemService("audio");
            this.b = adColonyInterstitial;
            context.getApplicationContext().getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, (ContentObserver)this);
        }
    }

    void a() {
        Context context = a.c();
        if (context != null) {
            context.getApplicationContext().getContentResolver().unregisterContentObserver((ContentObserver)this);
        }
        this.b = null;
        this.a = null;
    }

    public boolean deliverSelfNotifications() {
        return false;
    }

    public void onChange(boolean bl) {
        AdColonyInterstitial adColonyInterstitial;
        if (this.a != null && (adColonyInterstitial = this.b) != null) {
            if (adColonyInterstitial.d() == null) {
                return;
            }
            double d2 = 100.0f * ((float)this.a.getStreamVolume(3) / 15.0f);
            int n2 = (int)d2;
            if (this.b.g() && this.b.h().e() != null && !this.b.i()) {
                this.b.h().e().getAvidVideoPlaybackListener().recordAdVolumeChangeEvent(n2);
                this.b.h().a("volume_change");
            }
            JSONObject jSONObject = w.a();
            w.a(jSONObject, "audio_percentage", d2);
            w.a(jSONObject, "ad_session_id", this.b.d().b());
            w.b(jSONObject, "id", this.b.d().d());
            new ad("AdContainer.on_audio_change", this.b.d().c(), jSONObject).b();
            new y.a().a("Volume changed to ").a(d2).a(y.d);
        }
    }
}


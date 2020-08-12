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
 *  java.lang.Object
 *  java.lang.String
 */
package com.b.a.a.a.a;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Handler;
import android.provider.Settings;
import com.b.a.a.a.a.a;
import com.b.a.a.a.a.c;

public final class d
extends ContentObserver {
    private final Context a;
    private final AudioManager b;
    private final a c;
    private final c d;
    private float e;

    public d(Handler handler, Context context, a a2, c c2) {
        super(handler);
        this.a = context;
        this.b = (AudioManager)context.getSystemService("audio");
        this.c = a2;
        this.d = c2;
    }

    private boolean a(float f2) {
        return f2 != this.e;
    }

    private float c() {
        int n2 = this.b.getStreamVolume(3);
        int n3 = this.b.getStreamMaxVolume(3);
        return this.c.a(n2, n3);
    }

    private void d() {
        this.d.a(this.e);
    }

    public void a() {
        this.e = this.c();
        this.d();
        this.a.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, (ContentObserver)this);
    }

    public void b() {
        this.a.getContentResolver().unregisterContentObserver((ContentObserver)this);
    }

    public void onChange(boolean bl) {
        super.onChange(bl);
        float f2 = this.c();
        if (this.a(f2)) {
            this.e = f2;
            this.d();
        }
    }
}


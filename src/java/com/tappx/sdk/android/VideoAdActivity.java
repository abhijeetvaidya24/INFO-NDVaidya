/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.ActivityNotFoundException
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Configuration
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.media.AudioManager
 *  android.media.AudioManager$OnAudioFocusChangeListener
 *  android.os.Bundle
 *  android.view.View
 *  android.view.Window
 *  java.lang.Class
 *  java.lang.Deprecated
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 */
package com.tappx.sdk.android;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import com.tappx.a.a.b.ag;
import com.tappx.a.a.b.e;

public class VideoAdActivity
extends Activity
implements e.a {
    public static final String VIDEO_CLASS_EXTRAS_KEY = "video_view_class_name";
    public static final String VIDEO_URL = "video_url";
    private e a;

    static Intent a(Context context, String string) {
        Intent intent = new Intent(context, VideoAdActivity.class);
        intent.setFlags(268435456);
        intent.putExtra(VIDEO_CLASS_EXTRAS_KEY, "mraid");
        intent.putExtra(VIDEO_URL, string);
        return intent;
    }

    private e a(Bundle bundle) {
        return new ag((Context)this, this.getIntent().getExtras(), bundle, this);
    }

    public static void startMraid(Context context, String string) {
        Intent intent = VideoAdActivity.a(context, string);
        try {
            context.startActivity(intent);
        }
        catch (ActivityNotFoundException activityNotFoundException) {}
    }

    @Deprecated
    e a() {
        return this.a;
    }

    @Deprecated
    void a(e e2) {
        this.a = e2;
    }

    void b() {
        AudioManager audioManager = (AudioManager)this.getSystemService("audio");
        if (audioManager != null) {
            audioManager.abandonAudioFocus(null);
        }
    }

    protected void onActivityResult(int n2, int n3, Intent intent) {
        e e2 = this.a;
        if (e2 != null) {
            e2.a(n2, n3, intent);
        }
    }

    public void onBackPressed() {
        e e2 = this.a;
        if (e2 != null && e2.g()) {
            super.onBackPressed();
            this.a.f();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        e e2 = this.a;
        if (e2 != null) {
            e2.a(configuration);
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.getWindow().setBackgroundDrawable((Drawable)new ColorDrawable(-16777216));
        this.requestWindowFeature(1);
        this.getWindow().addFlags(1024);
        try {
            this.a = this.a(bundle);
        }
        catch (Exception exception) {
            this.finish();
            return;
        }
        this.a.a();
    }

    protected void onDestroy() {
        e e2 = this.a;
        if (e2 != null) {
            e2.e();
        }
        super.onDestroy();
        this.b();
    }

    @Override
    public void onFinish() {
        this.finish();
    }

    protected void onPause() {
        e e2 = this.a;
        if (e2 != null) {
            e2.c();
        }
        super.onPause();
    }

    protected void onResume() {
        super.onResume();
        e e2 = this.a;
        if (e2 != null) {
            e2.d();
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        e e2 = this.a;
        if (e2 != null) {
            e2.a(bundle);
        }
    }

    @Override
    public void onSetContentView(View view) {
        this.setContentView(view);
    }
}


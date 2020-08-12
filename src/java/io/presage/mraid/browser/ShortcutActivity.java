/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.graphics.Bitmap
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.view.View
 *  android.widget.FrameLayout
 *  io.presage.EcirdelAubrac
 *  io.presage.mraid.browser.ShortcutActivity$CamembertauCalvados$CamembertauCalvados
 *  io.presage.mraid.browser.ShortcutActivity$CamembertauCalvados$CamembertdeNormandie
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 */
package io.presage.mraid.browser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.FrameLayout;
import io.presage.AbbayedeTamie;
import io.presage.BrillatSavarin;
import io.presage.EcirdelAubrac;
import io.presage.RegaldeBourgogne;
import io.presage.StVincentauChablis;
import io.presage.TommeCrayeuse;
import io.presage.TommedAuvergne;
import io.presage.cc;
import io.presage.cl;
import io.presage.mraid.browser.ShortcutActivity;

public final class ShortcutActivity
extends Activity {
    public static final CamembertauCalvados a = new CamembertauCalvados(0);
    private StVincentauChablis b;

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        FrameLayout frameLayout = new FrameLayout((Context)this);
        BrillatSavarin brillatSavarin = new BrillatSavarin();
        brillatSavarin.h("http://ogury.io");
        Activity activity = this;
        Context context = this.getApplicationContext();
        cl.a((Object)context, "this.applicationContext");
        this.b = StVincentauChablis.CamembertauCalvados.a(activity, brillatSavarin, new RegaldeBourgogne(context), frameLayout);
        Intent intent = this.getIntent();
        cl.a((Object)intent, "intent");
        String string = intent.getExtras().getString("args", "");
        cl.a((Object)string, "extraString");
        boolean bl2 = ((CharSequence)string).length() == 0;
        if (bl2) {
            this.finish();
            return;
        }
        TommeCrayeuse tommeCrayeuse = TommedAuvergne.a(string);
        StVincentauChablis stVincentauChablis = this.b;
        if (stVincentauChablis != null) {
            stVincentauChablis.a(tommeCrayeuse);
        }
        this.setContentView((View)frameLayout);
    }

    protected final void onDestroy() {
        super.onDestroy();
        StVincentauChablis stVincentauChablis = this.b;
        if (stVincentauChablis != null) {
            stVincentauChablis.d();
        }
    }

    public static final class io.presage.mraid.browser.ShortcutActivity$CamembertauCalvados {
        private io.presage.mraid.browser.ShortcutActivity$CamembertauCalvados() {
        }

        public /* synthetic */ io.presage.mraid.browser.ShortcutActivity$CamembertauCalvados(byte by) {
            this();
        }

        public static final /* synthetic */ void a(Context context, String string) {
            io.presage.mraid.browser.ShortcutActivity$CamembertauCalvados.c(context, string);
        }

        public static final /* synthetic */ void a(Context context, String string, String string2, Bitmap bitmap) {
            io.presage.mraid.browser.ShortcutActivity$CamembertauCalvados.b(context, string, string2, bitmap);
        }

        public static void a(Context context, String string, String string2, String string3, String string4) {
            CamembertauCalvados camembertauCalvados = new CamembertauCalvados(string2, context, string3, string, string4);
            EcirdelAubrac.CamembertauCalvados.a((cc)camembertauCalvados).a((cc)CamembertdeNormandie.a);
        }

        private static Intent b(Context context, String string) {
            Intent intent = new Intent(context.getApplicationContext(), ShortcutActivity.class);
            intent.addFlags(268435456);
            intent.addFlags(32768);
            boolean bl2 = ((CharSequence)string).length() > 0;
            if (bl2) {
                intent.putExtra("args", string);
                intent.addFlags(8388608);
                intent.addFlags(67108864);
            }
            intent.setAction("android.intent.action.MAIN");
            return intent;
        }

        private static void b(Context context, String string, String string2, Bitmap bitmap) {
            Intent intent = new Intent();
            intent.putExtra("android.intent.extra.shortcut.INTENT", (Parcelable)io.presage.mraid.browser.ShortcutActivity$CamembertauCalvados.b(context, string2));
            intent.putExtra("android.intent.extra.shortcut.NAME", string);
            intent.putExtra("android.intent.extra.shortcut.ICON", (Parcelable)bitmap);
            intent.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
            try {
                context.sendBroadcast(intent);
                return;
            }
            catch (Exception exception) {
                return;
            }
        }

        private static void c(Context context, String string) {
            Intent intent = new Intent();
            intent.putExtra("android.intent.extra.shortcut.INTENT", (Parcelable)io.presage.mraid.browser.ShortcutActivity$CamembertauCalvados.b(context, ""));
            intent.putExtra("android.intent.extra.shortcut.NAME", string);
            intent.setAction("com.android.launcher.action.UNINSTALL_SHORTCUT");
            context.sendBroadcast(intent);
        }
    }

}


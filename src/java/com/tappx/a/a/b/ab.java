/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.app.Activity
 *  android.app.AlertDialog
 *  android.app.AlertDialog$Builder
 *  android.content.ActivityNotFoundException
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Environment
 *  android.view.View
 *  android.view.ViewParent
 *  android.view.Window
 *  android.view.WindowManager
 *  android.view.WindowManager$LayoutParams
 *  android.widget.Toast
 *  com.tappx.a.a.b.ab$2
 *  com.tappx.sdk.android.VideoAdActivity
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.net.URI
 *  java.util.Map
 *  java.util.Set
 */
package com.tappx.a.a.b;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.view.View;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;
import com.tappx.a.a.a.j.c;
import com.tappx.a.a.b.aa;
import com.tappx.a.a.b.ab;
import com.tappx.a.a.b.ad;
import com.tappx.a.a.b.al;
import com.tappx.a.a.b.h;
import com.tappx.a.a.b.i;
import com.tappx.a.a.b.q;
import com.tappx.a.a.b.w;
import com.tappx.sdk.android.VideoAdActivity;
import java.net.URI;
import java.util.Map;
import java.util.Set;

public class ab {
    private final q a;

    public ab() {
        this(new q());
    }

    public ab(q q2) {
        this.a = q2;
    }

    public void a(Context context, String string2) {
        VideoAdActivity.startMraid((Context)context, (String)string2);
    }

    public void a(final Context context, final String string2, final a a2) {
        if (this.b(context)) {
            if (context instanceof Activity) {
                new AlertDialog.Builder(context).setTitle((CharSequence)"Save Image").setMessage((CharSequence)"Download image to Gallery?").setNegativeButton((CharSequence)"Cancel", null).setPositiveButton((CharSequence)"Ok", new DialogInterface.OnClickListener(){

                    public void onClick(DialogInterface dialogInterface, int n2) {
                        ab.this.b(context, string2, a2);
                    }
                }).setCancelable(true).show();
                return;
            }
            Toast.makeText((Context)context, (CharSequence)"Downloading image ...", (int)0).show();
            this.b(context, string2, a2);
            return;
        }
        throw new w("Unsupported action");
    }

    public void a(Context context, URI uRI) {
        this.a.a(context, uRI.toString());
    }

    public void a(Context context, Map<String, String> map) {
        w w2;
        if (this.a(context)) {
            try {
                Map<String, Object> map2 = ad.b(map);
                Intent intent = new Intent("android.intent.action.INSERT").setType("vnd.android.cursor.item/event");
                for (String string2 : map2.keySet()) {
                    Object object = map2.get((Object)string2);
                    if (object instanceof Long) {
                        intent.putExtra(string2, ((Long)object).longValue());
                        continue;
                    }
                    if (object instanceof Integer) {
                        intent.putExtra(string2, ((Integer)object).intValue());
                        continue;
                    }
                    intent.putExtra(string2, (String)object);
                }
                intent.setFlags(268435456);
                context.startActivity(intent);
                return;
            }
            catch (Exception exception) {
                throw new w(exception);
            }
            catch (IllegalArgumentException illegalArgumentException) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Invalid params ");
                stringBuilder.append(illegalArgumentException.getMessage());
                aa.c(stringBuilder.toString());
                throw new w(illegalArgumentException);
            }
            catch (ActivityNotFoundException activityNotFoundException) {
                throw new w("App not found");
            }
        }
        w2 = new w("Unsupported action");
        throw w2;
    }

    @TargetApi(value=11)
    boolean a(Activity activity, View view) {
        if (Build.VERSION.SDK_INT < 12) {
            return false;
        }
        while (view.isHardwareAccelerated()) {
            if (al.a(view.getLayerType(), 1)) {
                return false;
            }
            if (!(view.getParent() instanceof View)) {
                Window window = activity.getWindow();
                return window != null && al.a(window.getAttributes().flags, 16777216);
            }
            view = (View)view.getParent();
        }
        return false;
    }

    boolean a(Context context) {
        Intent intent = new Intent("android.intent.action.INSERT").setType("vnd.android.cursor.item/event");
        boolean bl = Build.VERSION.SDK_INT >= 14;
        return bl && h.a(context, intent);
    }

    void b(Context context, String string2, a a2) {
        al.a(new i(context, (i.a)new 2(this, context, a2)), string2);
    }

    boolean b(Context context) {
        return "mounted".equals((Object)Environment.getExternalStorageState()) && c.a(context, "android.permission.WRITE_EXTERNAL_STORAGE");
    }

    boolean c(Context context) {
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse((String)"tel:"));
        return h.a(context, intent);
    }

    boolean d(Context context) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse((String)"sms:"));
        return h.a(context, intent);
    }

    static interface a {
        public void a(w var1);
    }

}


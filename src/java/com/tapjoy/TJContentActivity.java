/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.view.Window
 *  com.tapjoy.internal.fq
 *  com.tapjoy.internal.gc
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 */
package com.tapjoy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import com.tapjoy.internal.fq;
import com.tapjoy.internal.gc;

public class TJContentActivity
extends Activity {
    private static volatile ContentProducer a;
    private ContentProducer b;
    private boolean c = false;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean a(Intent intent) {
        String string = intent.getStringExtra("com.tapjoy.internal.content.producer.id");
        if (string == null) {
            return false;
        }
        Class<TJContentActivity> class_ = TJContentActivity.class;
        synchronized (TJContentActivity.class) {
            if (a != null && string.equals((Object)TJContentActivity.toIdentityString(a))) {
                this.b = a;
                a = null;
                // ** MonitorExit[var4_3] (shouldn't be in output)
                if (intent.getBooleanExtra("com.tapjoy.internal.content.fullscreen", false)) {
                    this.getWindow().setFlags(1024, 1024);
                }
                this.b.show(this);
                return true;
            }
            // ** MonitorExit[var4_3] (shouldn't be in output)
            return false;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void start(Context context, ContentProducer contentProducer, boolean bl) {
        Intent intent = new Intent(context, TJContentActivity.class);
        intent.setFlags(276889600);
        intent.putExtra("com.tapjoy.internal.content.producer.id", TJContentActivity.toIdentityString(contentProducer));
        intent.putExtra("com.tapjoy.internal.content.fullscreen", bl);
        Class<TJContentActivity> class_ = TJContentActivity.class;
        synchronized (TJContentActivity.class) {
            a = contentProducer;
            context.startActivity(intent);
            // ** MonitorExit[var8_4] (shouldn't be in output)
            return;
        }
    }

    public static String toIdentityString(Object object) {
        if (object == null) {
            return "null";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(object.getClass().getName());
        stringBuilder.append(System.identityHashCode((Object)object));
        return stringBuilder.toString();
    }

    protected void onActivityResult(int n2, int n3, Intent intent) {
        this.b.onActivityResult(this, n2, n3, intent);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.requestWindowFeature(1);
        if (!this.a(this.getIntent())) {
            this.finish();
        }
    }

    protected void onDestroy() {
        ContentProducer contentProducer = this.b;
        if (contentProducer != null) {
            contentProducer.dismiss(this);
        }
        super.onDestroy();
    }

    protected void onStart() {
        super.onStart();
        if (gc.a().n) {
            this.c = true;
            fq.a((Activity)this);
        }
    }

    protected void onStop() {
        if (this.c) {
            this.c = false;
            fq.b((Activity)this);
        }
        super.onStop();
    }

    public static interface ContentProducer {
        public void dismiss(Activity var1);

        public void onActivityResult(Activity var1, int var2, int var3, Intent var4);

        public void show(Activity var1);
    }

}


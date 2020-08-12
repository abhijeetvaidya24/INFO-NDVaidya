/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.AlertDialog
 *  android.app.AlertDialog$Builder
 *  android.content.Context
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.net.http.SslError
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.Window
 *  android.webkit.SslErrorHandler
 *  android.webkit.WebView
 *  android.widget.LinearLayout
 *  android.widget.TextView
 *  com.appsgeyser.multiTabApp.MainNavigationActivity
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 */
package com.appsgeyser.multiTabApp.ui.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.http.SslError;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.appsgeyser.multiTabApp.Factory;
import com.appsgeyser.multiTabApp.MainNavigationActivity;

public class SslErrorDialog {
    private Context _activity;

    public SslErrorDialog(Context context) {
        this._activity = context;
    }

    public void execute(WebView webView, final SslErrorHandler sslErrorHandler, SslError sslError) {
        if (Build.VERSION.SDK_INT >= 14 && !sslError.getUrl().equals((Object)webView.getUrl())) {
            sslErrorHandler.proceed();
            return;
        }
        final AlertDialog alertDialog = new AlertDialog.Builder(this._activity).create();
        LinearLayout linearLayout = (LinearLayout)Factory.getInstance().getMainNavigationActivity().getLayoutInflater().inflate(2131492943, null);
        TextView textView = (TextView)linearLayout.findViewById(2131296379);
        TextView textView2 = (TextView)linearLayout.findViewById(2131296382);
        TextView textView3 = (TextView)linearLayout.findViewById(2131296380);
        TextView textView4 = (TextView)linearLayout.findViewById(2131296394);
        alertDialog.setView((View)linearLayout);
        if (alertDialog.getWindow() != null) {
            alertDialog.getWindow().setBackgroundDrawable((Drawable)new ColorDrawable(0));
        }
        textView4.setText(2131755276);
        textView.setText(2131755273);
        textView2.setText((CharSequence)this._activity.getString(2131755275));
        textView3.setText((CharSequence)this._activity.getString(2131755274));
        textView2.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                sslErrorHandler.proceed();
                alertDialog.dismiss();
            }
        });
        textView3.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                sslErrorHandler.cancel();
                alertDialog.dismiss();
            }
        });
        alertDialog.show();
    }

}


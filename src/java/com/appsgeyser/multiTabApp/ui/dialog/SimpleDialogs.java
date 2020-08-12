/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.AlertDialog
 *  android.app.AlertDialog$Builder
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnCancelListener
 *  android.content.DialogInterface$OnClickListener
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.Window
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
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.appsgeyser.multiTabApp.Factory;
import com.appsgeyser.multiTabApp.MainNavigationActivity;

public class SimpleDialogs {
    public static AlertDialog createConfirmDialog(String string2, String string3, Context context, final DialogInterface.OnClickListener onClickListener, final DialogInterface.OnClickListener onClickListener2) {
        final AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        LinearLayout linearLayout = (LinearLayout)Factory.getInstance().getMainNavigationActivity().getLayoutInflater().inflate(2131492943, null);
        TextView textView = (TextView)linearLayout.findViewById(2131296379);
        TextView textView2 = (TextView)linearLayout.findViewById(2131296382);
        TextView textView3 = (TextView)linearLayout.findViewById(2131296380);
        TextView textView4 = (TextView)linearLayout.findViewById(2131296394);
        alertDialog.setView((View)linearLayout);
        if (alertDialog.getWindow() != null) {
            alertDialog.getWindow().setBackgroundDrawable((Drawable)new ColorDrawable(0));
        }
        textView.setText((CharSequence)string3);
        if (string2 != null) {
            textView4.setText((CharSequence)string2);
        } else {
            textView4.setVisibility(8);
        }
        textView2.setText((CharSequence)context.getString(2131755313));
        textView3.setText((CharSequence)context.getString(2131755201));
        textView2.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                alertDialog.dismiss();
                DialogInterface.OnClickListener onClickListener2 = onClickListener;
                if (onClickListener2 != null) {
                    onClickListener2.onClick((DialogInterface)alertDialog, 0);
                }
            }
        });
        textView3.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                alertDialog.dismiss();
                DialogInterface.OnClickListener onClickListener = onClickListener2;
                if (onClickListener != null) {
                    onClickListener.onClick((DialogInterface)alertDialog, 0);
                }
            }
        });
        alertDialog.setOnCancelListener(new DialogInterface.OnCancelListener(){

            public void onCancel(DialogInterface dialogInterface) {
                dialogInterface.dismiss();
                DialogInterface.OnClickListener onClickListener = onClickListener2;
                if (onClickListener != null) {
                    onClickListener.onClick(dialogInterface, 0);
                }
            }
        });
        return alertDialog;
    }

    public static void showOpenOrSaveDialog(Context context, final DialogInterface.OnClickListener onClickListener, final DialogInterface.OnClickListener onClickListener2) {
        final AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        LinearLayout linearLayout = (LinearLayout)Factory.getInstance().getMainNavigationActivity().getLayoutInflater().inflate(2131492944, null);
        TextView textView = (TextView)linearLayout.findViewById(2131296379);
        TextView textView2 = (TextView)linearLayout.findViewById(2131296382);
        TextView textView3 = (TextView)linearLayout.findViewById(2131296380);
        TextView textView4 = (TextView)linearLayout.findViewById(2131296381);
        TextView textView5 = (TextView)linearLayout.findViewById(2131296394);
        alertDialog.setView((View)linearLayout);
        if (alertDialog.getWindow() != null) {
            alertDialog.getWindow().setBackgroundDrawable((Drawable)new ColorDrawable(0));
        }
        textView2.setText((CharSequence)context.getString(2131755210));
        textView3.setText((CharSequence)context.getString(2131755256));
        textView4.setText((CharSequence)context.getString(2131755112));
        textView5.setText((CharSequence)context.getString(2131755186));
        textView.setText((CharSequence)context.getString(2131755144));
        textView2.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                onClickListener.onClick((DialogInterface)alertDialog, 0);
                alertDialog.cancel();
            }
        });
        textView3.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                onClickListener2.onClick((DialogInterface)alertDialog, 0);
                alertDialog.cancel();
            }
        });
        textView4.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                alertDialog.cancel();
            }
        });
        alertDialog.setCancelable(true);
        alertDialog.show();
    }

}


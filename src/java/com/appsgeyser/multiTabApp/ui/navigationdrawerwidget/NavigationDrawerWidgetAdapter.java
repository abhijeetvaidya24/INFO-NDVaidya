/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnLongClickListener
 *  android.view.ViewGroup
 *  android.widget.ArrayAdapter
 *  android.widget.ImageView
 *  android.widget.TextView
 *  com.appsgeyser.multiTabApp.MainNavigationActivity
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 */
package com.appsgeyser.multiTabApp.ui.navigationdrawerwidget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.appsgeyser.multiTabApp.MainNavigationActivity;
import com.appsgeyser.multiTabApp.ui.navigationdrawerwidget.DrawerWidgetModel;
import java.util.ArrayList;
import java.util.List;

class NavigationDrawerWidgetAdapter
extends ArrayAdapter<DrawerWidgetModel> {
    private final ArrayList<DrawerWidgetModel> objects;

    NavigationDrawerWidgetAdapter(Context context, ArrayList<DrawerWidgetModel> arrayList) {
        super(context, 0, arrayList);
        this.objects = arrayList;
    }

    public int getCount() {
        return this.objects.size();
    }

    public DrawerWidgetModel getItem(int n2) {
        return (DrawerWidgetModel)this.objects.get(n2);
    }

    public View getView(int n2, View view, ViewGroup viewGroup) {
        DrawerWidgetModel drawerWidgetModel;
        DrawerWidgetModel drawerWidgetModel2 = (DrawerWidgetModel)this.objects.get(n2);
        if (view == null) {
            LayoutInflater layoutInflater = ((MainNavigationActivity)this.getContext()).getLayoutInflater();
            if (!drawerWidgetModel2.isDivider() && drawerWidgetModel2.getImageDrawable() != null) {
                view = layoutInflater.inflate(2131492961, viewGroup, false);
            } else if (!drawerWidgetModel2.isDivider() && drawerWidgetModel2.getImageDrawable() == null) {
                view = layoutInflater.inflate(2131492960, viewGroup, false);
            } else {
                view = layoutInflater.inflate(2131492952, viewGroup, false);
                view.setOnClickListener(null);
                view.setOnLongClickListener(null);
                view.setLongClickable(false);
            }
        }
        if ((drawerWidgetModel = this.getItem(n2)) != null) {
            ImageView imageView = (ImageView)view.findViewById(2131296509);
            TextView textView = (TextView)view.findViewById(2131296400);
            if (imageView != null) {
                imageView.setImageDrawable(drawerWidgetModel.getImageDrawable());
            }
            if (textView != null) {
                textView.setText((CharSequence)drawerWidgetModel.getDescription());
            }
        }
        return view;
    }
}


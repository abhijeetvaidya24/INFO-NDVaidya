/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.text.format.DateFormat
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ArrayAdapter
 *  android.widget.ProgressBar
 *  android.widget.TextView
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Calendar
 *  java.util.Date
 *  java.util.List
 */
package com.appsgeyser.multiTabApp.browser;

import android.app.Activity;
import android.content.Context;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.appsgeyser.multiTabApp.browser.DownloadsItem;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DownloadsItemAdapter
extends ArrayAdapter<DownloadsItem> {
    private Activity context;
    private List<DownloadsItem> itemList;
    private int resource;

    public DownloadsItemAdapter(Activity activity, int n2, List<DownloadsItem> list) {
        super((Context)activity, n2, list);
        this.itemList = list;
        this.context = activity;
        this.resource = n2;
    }

    public static boolean isSameDay(Calendar calendar, Calendar calendar2) {
        if (calendar != null && calendar2 != null) {
            int n2 = calendar.get(0);
            int n3 = calendar2.get(0);
            boolean bl = false;
            if (n2 == n3) {
                int n4 = calendar.get(1);
                int n5 = calendar2.get(1);
                bl = false;
                if (n4 == n5) {
                    int n6 = calendar.get(6);
                    int n7 = calendar2.get(6);
                    bl = false;
                    if (n6 == n7) {
                        bl = true;
                    }
                }
            }
            return bl;
        }
        throw new IllegalArgumentException("The dates must not be null");
    }

    public static boolean isSameDay(Date date, Date date2) {
        if (date != null && date2 != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(date2);
            return DownloadsItemAdapter.isSameDay(calendar, calendar2);
        }
        throw new IllegalArgumentException("The dates must not be null");
    }

    public View getView(int n2, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = this.context.getLayoutInflater().inflate(this.resource, null, true);
            viewHolder = new ViewHolder();
            viewHolder.name = (TextView)view.findViewById(2131296506);
            viewHolder.description = (TextView)view.findViewById(2131296372);
            viewHolder.progressBar = (ProgressBar)view.findViewById(2131296544);
            viewHolder.date = (TextView)view.findViewById(2131296643);
            view.setTag((Object)viewHolder);
        } else {
            viewHolder = (ViewHolder)view.getTag();
        }
        DownloadsItem downloadsItem = (DownloadsItem)this.itemList.get(n2);
        viewHolder.name.setText((CharSequence)downloadsItem.getName());
        viewHolder.description.setText((CharSequence)downloadsItem.getDescription());
        if (downloadsItem.getDate() != null && downloadsItem.getDate() != 0L) {
            if (DownloadsItemAdapter.isSameDay(new Date(), new Date(downloadsItem.getDate().longValue()))) {
                viewHolder.date.setText(DateFormat.format((CharSequence)"HH:mm", (long)downloadsItem.getDate()));
            } else {
                viewHolder.date.setText(DateFormat.format((CharSequence)"dd MMM", (long)downloadsItem.getDate()));
            }
            viewHolder.date.setVisibility(0);
        } else {
            viewHolder.date.setVisibility(8);
        }
        if (downloadsItem.getStatus() == DownloadsItem.Status.InProgress) {
            viewHolder.progressBar.setProgress(downloadsItem.getProgress().intValue());
            viewHolder.progressBar.setVisibility(0);
            viewHolder.description.setVisibility(8);
            return view;
        }
        if (downloadsItem.getStatus() == DownloadsItem.Status.Ok) {
            viewHolder.progressBar.setVisibility(8);
            viewHolder.description.setVisibility(0);
            return view;
        }
        if (downloadsItem.getStatus() == DownloadsItem.Status.Fail) {
            viewHolder.progressBar.setVisibility(8);
            viewHolder.description.setVisibility(0);
        }
        return view;
    }

    private static class ViewHolder {
        TextView date;
        TextView description;
        TextView name;
        ProgressBar progressBar;

        private ViewHolder() {
        }
    }

}


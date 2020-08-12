/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.preference.DialogPreference
 *  android.util.AttributeSet
 *  android.view.View
 *  android.widget.TimePicker
 *  java.lang.CharSequence
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Locale
 */
package com.appsgeyser.multiTabApp.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.preference.DialogPreference;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TimePicker;
import java.util.Locale;

public class TimePreference
extends DialogPreference {
    private int lastHour = 0;
    private int lastMinute = 0;
    private TimePicker picker = null;

    public TimePreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.setPositiveButtonText((CharSequence)"Set");
        this.setNegativeButtonText((CharSequence)"Cancel");
    }

    public static int getHour(String string2) {
        return Integer.parseInt((String)string2.split(":")[0]);
    }

    public static int getMinute(String string2) {
        return Integer.parseInt((String)string2.split(":")[1]);
    }

    protected void onBindDialogView(View view) {
        super.onBindDialogView(view);
        this.picker.setCurrentHour(Integer.valueOf((int)this.lastHour));
        this.picker.setCurrentMinute(Integer.valueOf((int)this.lastMinute));
    }

    protected View onCreateDialogView() {
        this.picker = new TimePicker(this.getContext());
        return this.picker;
    }

    protected void onDialogClosed(boolean bl) {
        super.onDialogClosed(bl);
        if (bl) {
            this.lastHour = this.picker.getCurrentHour();
            this.lastMinute = this.picker.getCurrentMinute();
            StringBuilder stringBuilder = new StringBuilder();
            Locale locale = Locale.US;
            Object[] arrobject = new Object[]{this.lastHour};
            stringBuilder.append(String.format((Locale)locale, (String)"%02d", (Object[])arrobject));
            stringBuilder.append(":");
            Locale locale2 = Locale.US;
            Object[] arrobject2 = new Object[]{this.lastMinute};
            stringBuilder.append(String.format((Locale)locale2, (String)"%02d", (Object[])arrobject2));
            String string2 = stringBuilder.toString();
            if (this.callChangeListener((Object)string2)) {
                this.persistString(string2);
            }
        }
    }

    protected Object onGetDefaultValue(TypedArray typedArray, int n2) {
        return typedArray.getString(n2);
    }

    protected void onSetInitialValue(boolean bl, Object object) {
        String string2 = bl ? (object == null ? this.getPersistedString("00:00") : this.getPersistedString(object.toString())) : object.toString();
        this.lastHour = TimePreference.getHour(string2);
        this.lastMinute = TimePreference.getMinute(string2);
    }
}


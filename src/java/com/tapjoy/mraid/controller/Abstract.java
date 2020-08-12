/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  com.tapjoy.mraid.view.MraidView
 *  java.lang.Class
 *  java.lang.ClassLoader
 *  java.lang.IllegalAccessException
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.reflect.Field
 */
package com.tapjoy.mraid.controller;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.tapjoy.mraid.util.NavigationStringEnum;
import com.tapjoy.mraid.util.TransitionStringEnum;
import com.tapjoy.mraid.view.MraidView;
import java.lang.reflect.Field;

public abstract class Abstract {
    public static final String EXIT = "exit";
    public static final String FULL_SCREEN = "fullscreen";
    public static final String STYLE_NORMAL = "normal";
    protected MraidView a;
    protected Context b;

    public Abstract(MraidView mraidView, Context context) {
        this.a = mraidView;
        this.b = context;
    }

    public abstract void stopAllListeners();

    public static class ReflectedParcelable
    implements Parcelable {
        public ReflectedParcelable() {
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        protected ReflectedParcelable(Parcel parcel) {
            Field[] arrfield = this.getClass().getDeclaredFields();
            try {
                for (int n2 = 0; n2 < arrfield.length; ++n2) {
                    Field field = arrfield[n2];
                    Class class_ = field.getType();
                    if (class_.isEnum()) {
                        String string2 = class_.toString();
                        if (string2.equals((Object)"class com.tapjoy.mraid.util.NavigationStringEnum")) {
                            field.set((Object)this, (Object)NavigationStringEnum.fromString(parcel.readString()));
                            continue;
                        }
                        if (!string2.equals((Object)"class com.tapjoy.mraid.util.TransitionStringEnum")) continue;
                        field.set((Object)this, (Object)TransitionStringEnum.fromString(parcel.readString()));
                        continue;
                    }
                    if (field.get((Object)this) instanceof Parcelable.Creator) continue;
                    field.set((Object)this, parcel.readValue(null));
                }
                return;
            }
            catch (IllegalAccessException illegalAccessException) {
                illegalAccessException.printStackTrace();
                return;
            }
            catch (IllegalArgumentException illegalArgumentException) {
                illegalArgumentException.printStackTrace();
                return;
            }
        }

        public int describeContents() {
            return 0;
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public void writeToParcel(Parcel parcel, int n2) {
            Field[] arrfield = this.getClass().getDeclaredFields();
            try {
                for (int n3 = 0; n3 < arrfield.length; ++n3) {
                    Field field = arrfield[n3];
                    Class class_ = field.getType();
                    if (class_.isEnum()) {
                        String string2 = class_.toString();
                        if (string2.equals((Object)"class com.tapjoy.mraid.util.NavigationStringEnum")) {
                            parcel.writeString(((NavigationStringEnum)((Object)field.get((Object)this))).getText());
                            continue;
                        }
                        if (!string2.equals((Object)"class com.tapjoy.mraid.util.TransitionStringEnum")) continue;
                        parcel.writeString(((TransitionStringEnum)((Object)field.get((Object)this))).getText());
                        continue;
                    }
                    Object object = field.get((Object)this);
                    if (object instanceof Parcelable.Creator) continue;
                    parcel.writeValue(object);
                }
                return;
            }
            catch (IllegalAccessException illegalAccessException) {
                illegalAccessException.printStackTrace();
                return;
            }
            catch (IllegalArgumentException illegalArgumentException) {
                illegalArgumentException.printStackTrace();
                return;
            }
        }
    }

}


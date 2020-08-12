/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  java.lang.Object
 *  java.lang.String
 */
package com.appsgeyser.sdk.configuration.models;

import android.os.Parcel;
import android.os.Parcelable;

public class ConfigPhpSdkModel
implements Parcelable {
    public static final Parcelable.Creator<ConfigPhpSdkModel> CREATOR = new Parcelable.Creator<ConfigPhpSdkModel>(){

        public ConfigPhpSdkModel createFromParcel(Parcel parcel) {
            return new ConfigPhpSdkModel(parcel);
        }

        public ConfigPhpSdkModel[] newArray(int n2) {
            return new ConfigPhpSdkModel[n2];
        }
    };
    private boolean active;
    private boolean activeByDefault;
    private String id;
    private String tag;
    private String textOfPolicy;

    private ConfigPhpSdkModel(Parcel parcel) {
        byte by = parcel.readByte();
        boolean bl = true;
        boolean bl2 = by != 0;
        this.active = bl2;
        this.id = parcel.readString();
        if (parcel.readByte() == 0) {
            bl = false;
        }
        this.activeByDefault = bl;
        this.textOfPolicy = parcel.readString();
        this.tag = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public String getTextOfPolicy() {
        return this.textOfPolicy;
    }

    public boolean isActive() {
        return this.active;
    }

    public boolean isActiveByDefault() {
        return this.activeByDefault;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        parcel.writeByte((byte)(this.active ? 1 : 0));
        parcel.writeString(this.id);
        parcel.writeByte((byte)(this.activeByDefault ? 1 : 0));
        parcel.writeString(this.textOfPolicy);
        parcel.writeString(this.tag);
    }

}


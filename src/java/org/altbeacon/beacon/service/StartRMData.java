/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  java.io.Serializable
 *  java.lang.Boolean
 *  java.lang.ClassLoader
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 */
package org.altbeacon.beacon.service;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import org.altbeacon.beacon.Region;

public class StartRMData
implements Parcelable,
Serializable {
    public static final Parcelable.Creator<StartRMData> CREATOR = new Parcelable.Creator<StartRMData>(){

        public StartRMData createFromParcel(Parcel parcel) {
            return new StartRMData(parcel);
        }

        public StartRMData[] newArray(int n2) {
            return new StartRMData[n2];
        }
    };
    private boolean mBackgroundFlag;
    private long mBetweenScanPeriod;
    private String mCallbackPackageName;
    private Region mRegion;
    private long mScanPeriod;

    private StartRMData() {
    }

    public StartRMData(long l2, long l3, boolean bl2) {
        this.mScanPeriod = l2;
        this.mBetweenScanPeriod = l3;
        this.mBackgroundFlag = bl2;
    }

    private StartRMData(Parcel parcel) {
        this.mRegion = (Region)parcel.readParcelable(StartRMData.class.getClassLoader());
        this.mCallbackPackageName = parcel.readString();
        this.mScanPeriod = parcel.readLong();
        this.mBetweenScanPeriod = parcel.readLong();
        boolean bl2 = parcel.readByte() != 0;
        this.mBackgroundFlag = bl2;
    }

    public StartRMData(Region region, String string, long l2, long l3, boolean bl2) {
        this.mScanPeriod = l2;
        this.mBetweenScanPeriod = l3;
        this.mRegion = region;
        this.mCallbackPackageName = string;
        this.mBackgroundFlag = bl2;
    }

    public static StartRMData fromBundle(Bundle bundle) {
        boolean bl2;
        bundle.setClassLoader(Region.class.getClassLoader());
        StartRMData startRMData = new StartRMData();
        if (bundle.containsKey("region")) {
            startRMData.mRegion = (Region)bundle.getSerializable("region");
            bl2 = true;
        } else {
            bl2 = false;
        }
        if (bundle.containsKey("scanPeriod")) {
            startRMData.mScanPeriod = (Long)bundle.get("scanPeriod");
            bl2 = true;
        }
        if (bundle.containsKey("betweenScanPeriod")) {
            startRMData.mBetweenScanPeriod = (Long)bundle.get("betweenScanPeriod");
        }
        if (bundle.containsKey("backgroundFlag")) {
            startRMData.mBackgroundFlag = (Boolean)bundle.get("backgroundFlag");
        }
        if (bundle.containsKey("callbackPackageName")) {
            startRMData.mCallbackPackageName = (String)bundle.get("callbackPackageName");
        }
        if (bl2) {
            return startRMData;
        }
        return null;
    }

    public int describeContents() {
        return 0;
    }

    public boolean getBackgroundFlag() {
        return this.mBackgroundFlag;
    }

    public long getBetweenScanPeriod() {
        return this.mBetweenScanPeriod;
    }

    public String getCallbackPackageName() {
        return this.mCallbackPackageName;
    }

    public Region getRegionData() {
        return this.mRegion;
    }

    public long getScanPeriod() {
        return this.mScanPeriod;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putLong("scanPeriod", this.mScanPeriod);
        bundle.putLong("betweenScanPeriod", this.mBetweenScanPeriod);
        bundle.putBoolean("backgroundFlag", this.mBackgroundFlag);
        bundle.putString("callbackPackageName", this.mCallbackPackageName);
        Region region = this.mRegion;
        if (region != null) {
            bundle.putSerializable("region", (Serializable)region);
        }
        return bundle;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        parcel.writeParcelable((Parcelable)this.mRegion, n2);
        parcel.writeString(this.mCallbackPackageName);
        parcel.writeLong(this.mScanPeriod);
        parcel.writeLong(this.mBetweenScanPeriod);
        parcel.writeByte((byte)(this.mBackgroundFlag ? 1 : 0));
    }

}


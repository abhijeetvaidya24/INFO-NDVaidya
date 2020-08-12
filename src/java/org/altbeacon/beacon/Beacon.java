/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  java.io.Serializable
 *  java.lang.Class
 *  java.lang.ClassLoader
 *  java.lang.Deprecated
 *  java.lang.Double
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Collections
 *  java.util.Iterator
 *  java.util.List
 *  org.altbeacon.beacon.client.NullBeaconDataFactory
 */
package org.altbeacon.beacon;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.altbeacon.beacon.Identifier;
import org.altbeacon.beacon.client.BeaconDataFactory;
import org.altbeacon.beacon.client.NullBeaconDataFactory;
import org.altbeacon.beacon.distance.DistanceCalculator;
import org.altbeacon.beacon.logging.LogManager;

public class Beacon
implements Parcelable,
Serializable {
    @Deprecated
    public static final Parcelable.Creator<Beacon> CREATOR;
    private static final List<Identifier> UNMODIFIABLE_LIST_OF_IDENTIFIER;
    private static final List<Long> UNMODIFIABLE_LIST_OF_LONG;
    protected static BeaconDataFactory beaconDataFactory;
    protected static DistanceCalculator sDistanceCalculator;
    protected static boolean sHardwareEqualityEnforced;
    protected int mBeaconTypeCode;
    protected String mBluetoothAddress;
    protected String mBluetoothName;
    protected List<Long> mDataFields;
    protected Double mDistance;
    protected List<Long> mExtraDataFields;
    protected List<Identifier> mIdentifiers;
    protected int mManufacturer;
    protected boolean mMultiFrameBeacon = false;
    private int mPacketCount = 0;
    protected String mParserIdentifier;
    protected int mRssi;
    private int mRssiMeasurementCount = 0;
    private Double mRunningAverageRssi = null;
    protected int mServiceUuid = -1;
    protected int mTxPower;

    static {
        UNMODIFIABLE_LIST_OF_LONG = Collections.unmodifiableList((List)new ArrayList());
        UNMODIFIABLE_LIST_OF_IDENTIFIER = Collections.unmodifiableList((List)new ArrayList());
        sHardwareEqualityEnforced = false;
        sDistanceCalculator = null;
        beaconDataFactory = new NullBeaconDataFactory();
        CREATOR = new Parcelable.Creator<Beacon>(){

            public Beacon createFromParcel(Parcel parcel) {
                return new Beacon(parcel);
            }

            public Beacon[] newArray(int n2) {
                return new Beacon[n2];
            }
        };
    }

    protected Beacon() {
        this.mIdentifiers = new ArrayList(1);
        this.mDataFields = new ArrayList(1);
        this.mExtraDataFields = new ArrayList(1);
    }

    @Deprecated
    protected Beacon(Parcel parcel) {
        int n2 = parcel.readInt();
        this.mIdentifiers = new ArrayList(n2);
        for (int i2 = 0; i2 < n2; ++i2) {
            this.mIdentifiers.add((Object)Identifier.parse(parcel.readString()));
        }
        this.mDistance = parcel.readDouble();
        this.mRssi = parcel.readInt();
        this.mTxPower = parcel.readInt();
        this.mBluetoothAddress = parcel.readString();
        this.mBeaconTypeCode = parcel.readInt();
        this.mServiceUuid = parcel.readInt();
        int n3 = parcel.readInt();
        this.mDataFields = new ArrayList(n3);
        for (int i3 = 0; i3 < n3; ++i3) {
            this.mDataFields.add((Object)parcel.readLong());
        }
        int n4 = parcel.readInt();
        this.mExtraDataFields = new ArrayList(n4);
        for (int i4 = 0; i4 < n4; ++i4) {
            this.mExtraDataFields.add((Object)parcel.readLong());
        }
        this.mManufacturer = parcel.readInt();
        this.mBluetoothName = parcel.readString();
        this.mParserIdentifier = parcel.readString();
        byte by = parcel.readByte();
        boolean bl2 = false;
        if (by != 0) {
            bl2 = true;
        }
        this.mMultiFrameBeacon = bl2;
        this.mRunningAverageRssi = (Double)parcel.readValue(null);
        this.mRssiMeasurementCount = parcel.readInt();
        this.mPacketCount = parcel.readInt();
    }

    protected static Double calculateDistance(int n2, double d2) {
        if (Beacon.getDistanceCalculator() != null) {
            return Beacon.getDistanceCalculator().calculateDistance(n2, d2);
        }
        LogManager.e("Beacon", "Distance calculator not set.  Distance will bet set to -1", new Object[0]);
        return -1.0;
    }

    public static DistanceCalculator getDistanceCalculator() {
        return sDistanceCalculator;
    }

    public static boolean getHardwareEqualityEnforced() {
        return sHardwareEqualityEnforced;
    }

    public static void setDistanceCalculator(DistanceCalculator distanceCalculator) {
        sDistanceCalculator = distanceCalculator;
    }

    public static void setHardwareEqualityEnforced(boolean bl2) {
        sHardwareEqualityEnforced = bl2;
    }

    private StringBuilder toStringBuilder() {
        StringBuilder stringBuilder = new StringBuilder();
        Iterator iterator = this.mIdentifiers.iterator();
        int n2 = 1;
        while (iterator.hasNext()) {
            Identifier identifier = (Identifier)iterator.next();
            if (n2 > 1) {
                stringBuilder.append(" ");
            }
            stringBuilder.append("id");
            stringBuilder.append(n2);
            stringBuilder.append(": ");
            String string = identifier == null ? "null" : identifier.toString();
            stringBuilder.append(string);
            ++n2;
        }
        if (this.mParserIdentifier != null) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(" type ");
            stringBuilder2.append(this.mParserIdentifier);
            stringBuilder.append(stringBuilder2.toString());
        }
        return stringBuilder;
    }

    @Deprecated
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        if (!(object instanceof Beacon)) {
            return false;
        }
        Beacon beacon = (Beacon)object;
        if (!this.mIdentifiers.equals(beacon.mIdentifiers)) {
            return false;
        }
        if (sHardwareEqualityEnforced) {
            return this.getBluetoothAddress().equals((Object)beacon.getBluetoothAddress());
        }
        return true;
    }

    public String getBluetoothAddress() {
        return this.mBluetoothAddress;
    }

    public List<Long> getDataFields() {
        if (this.mDataFields.getClass().isInstance(UNMODIFIABLE_LIST_OF_LONG)) {
            return this.mDataFields;
        }
        return Collections.unmodifiableList(this.mDataFields);
    }

    public double getDistance() {
        if (this.mDistance == null) {
            double d2 = this.mRssi;
            Double d3 = this.mRunningAverageRssi;
            if (d3 != null) {
                d2 = d3;
            } else {
                LogManager.d("Beacon", "Not using running average RSSI because it is null", new Object[0]);
            }
            this.mDistance = Beacon.calculateDistance(this.mTxPower, d2);
        }
        return this.mDistance;
    }

    public List<Long> getExtraDataFields() {
        if (this.mExtraDataFields.getClass().isInstance(UNMODIFIABLE_LIST_OF_LONG)) {
            return this.mExtraDataFields;
        }
        return Collections.unmodifiableList(this.mExtraDataFields);
    }

    public Identifier getIdentifier(int n2) {
        return (Identifier)this.mIdentifiers.get(n2);
    }

    public int getRssi() {
        return this.mRssi;
    }

    public int getServiceUuid() {
        return this.mServiceUuid;
    }

    public int hashCode() {
        StringBuilder stringBuilder = this.toStringBuilder();
        if (sHardwareEqualityEnforced) {
            stringBuilder.append(this.mBluetoothAddress);
        }
        return stringBuilder.toString().hashCode();
    }

    public boolean isExtraBeaconData() {
        return this.mIdentifiers.size() == 0 && this.mDataFields.size() != 0;
    }

    public boolean isMultiFrameBeacon() {
        return this.mMultiFrameBeacon;
    }

    public void setExtraDataFields(List<Long> list) {
        this.mExtraDataFields = list;
    }

    public void setPacketCount(int n2) {
        this.mPacketCount = n2;
    }

    public void setRssi(int n2) {
        this.mRssi = n2;
    }

    public void setRssiMeasurementCount(int n2) {
        this.mRssiMeasurementCount = n2;
    }

    public void setRunningAverageRssi(double d2) {
        this.mRunningAverageRssi = d2;
        this.mDistance = null;
    }

    public String toString() {
        return this.toStringBuilder().toString();
    }

    @Deprecated
    public void writeToParcel(Parcel parcel, int n2) {
        parcel.writeInt(this.mIdentifiers.size());
        for (Identifier identifier : this.mIdentifiers) {
            String string = identifier == null ? null : identifier.toString();
            parcel.writeString(string);
        }
        parcel.writeDouble(this.getDistance());
        parcel.writeInt(this.mRssi);
        parcel.writeInt(this.mTxPower);
        parcel.writeString(this.mBluetoothAddress);
        parcel.writeInt(this.mBeaconTypeCode);
        parcel.writeInt(this.mServiceUuid);
        parcel.writeInt(this.mDataFields.size());
        Iterator iterator = this.mDataFields.iterator();
        while (iterator.hasNext()) {
            parcel.writeLong(((Long)iterator.next()).longValue());
        }
        parcel.writeInt(this.mExtraDataFields.size());
        Iterator iterator2 = this.mExtraDataFields.iterator();
        while (iterator2.hasNext()) {
            parcel.writeLong(((Long)iterator2.next()).longValue());
        }
        parcel.writeInt(this.mManufacturer);
        parcel.writeString(this.mBluetoothName);
        parcel.writeString(this.mParserIdentifier);
        parcel.writeByte((byte)(this.mMultiFrameBeacon ? 1 : 0));
        parcel.writeValue((Object)this.mRunningAverageRssi);
        parcel.writeInt(this.mRssiMeasurementCount);
        parcel.writeInt(this.mPacketCount);
    }

}


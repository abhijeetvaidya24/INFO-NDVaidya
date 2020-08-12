/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  java.io.Serializable
 *  java.lang.CharSequence
 *  java.lang.CloneNotSupportedException
 *  java.lang.Deprecated
 *  java.lang.IllegalArgumentException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.List
 *  java.util.regex.Matcher
 *  java.util.regex.Pattern
 */
package org.altbeacon.beacon;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.altbeacon.beacon.Beacon;
import org.altbeacon.beacon.Identifier;

public class Region
implements Parcelable,
Serializable {
    public static final Parcelable.Creator<Region> CREATOR;
    private static final Pattern MAC_PATTERN;
    protected final String mBluetoothAddress;
    protected final List<Identifier> mIdentifiers;
    protected final String mUniqueId;

    static {
        MAC_PATTERN = Pattern.compile((String)"^[0-9A-Fa-f]{2}\\:[0-9A-Fa-f]{2}\\:[0-9A-Fa-f]{2}\\:[0-9A-Fa-f]{2}\\:[0-9A-Fa-f]{2}\\:[0-9A-Fa-f]{2}$");
        CREATOR = new Parcelable.Creator<Region>(){

            public Region createFromParcel(Parcel parcel) {
                return new Region(parcel);
            }

            public Region[] newArray(int n2) {
                return new Region[n2];
            }
        };
    }

    protected Region(Parcel parcel) {
        this.mUniqueId = parcel.readString();
        this.mBluetoothAddress = parcel.readString();
        int n2 = parcel.readInt();
        this.mIdentifiers = new ArrayList(n2);
        for (int i2 = 0; i2 < n2; ++i2) {
            String string = parcel.readString();
            if (string == null) {
                this.mIdentifiers.add(null);
                continue;
            }
            Identifier identifier = Identifier.parse(string);
            this.mIdentifiers.add((Object)identifier);
        }
    }

    public Region(String string, List<Identifier> list, String string2) {
        this.validateMac(string2);
        this.mIdentifiers = new ArrayList(list);
        this.mUniqueId = string;
        this.mBluetoothAddress = string2;
        if (string != null) {
            return;
        }
        throw new NullPointerException("uniqueId may not be null");
    }

    private void validateMac(String string) throws IllegalArgumentException {
        if (string != null) {
            if (MAC_PATTERN.matcher((CharSequence)string).matches()) {
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid mac address: '");
            stringBuilder.append(string);
            stringBuilder.append("' Must be 6 hex bytes separated by colons.");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    @Deprecated
    public Region clone() {
        return new Region(this.mUniqueId, this.mIdentifiers, this.mBluetoothAddress);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        if (object instanceof Region) {
            return ((Region)object).mUniqueId.equals((Object)this.mUniqueId);
        }
        return false;
    }

    public Identifier getIdentifier(int n2) {
        if (this.mIdentifiers.size() > n2) {
            return (Identifier)this.mIdentifiers.get(n2);
        }
        return null;
    }

    public String getUniqueId() {
        return this.mUniqueId;
    }

    public boolean hasSameIdentifiers(Region region) {
        if (region.mIdentifiers.size() == this.mIdentifiers.size()) {
            for (int i2 = 0; i2 < region.mIdentifiers.size(); ++i2) {
                if (region.getIdentifier(i2) == null && this.getIdentifier(i2) != null) {
                    return false;
                }
                if (region.getIdentifier(i2) != null && this.getIdentifier(i2) == null) {
                    return false;
                }
                if (region.getIdentifier(i2) == null && this.getIdentifier(i2) == null || region.getIdentifier(i2).equals(this.getIdentifier(i2))) continue;
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.mUniqueId.hashCode();
    }

    public boolean matchesBeacon(Beacon beacon) {
        int n2 = this.mIdentifiers.size();
        while (--n2 >= 0) {
            Identifier identifier = (Identifier)this.mIdentifiers.get(n2);
            int n3 = beacon.mIdentifiers.size();
            Identifier identifier2 = null;
            if (n2 < n3) {
                identifier2 = beacon.getIdentifier(n2);
            }
            if ((identifier2 != null || identifier == null) && (identifier2 == null || identifier == null || identifier.equals(identifier2))) continue;
            return false;
        }
        String string = this.mBluetoothAddress;
        return string == null || string.equalsIgnoreCase(beacon.mBluetoothAddress);
    }

    public String toString() {
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
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int n2) {
        parcel.writeString(this.mUniqueId);
        parcel.writeString(this.mBluetoothAddress);
        parcel.writeInt(this.mIdentifiers.size());
        for (Identifier identifier : this.mIdentifiers) {
            if (identifier != null) {
                parcel.writeString(identifier.toString());
                continue;
            }
            parcel.writeString(null);
        }
    }

}


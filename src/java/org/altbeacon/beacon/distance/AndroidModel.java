/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package org.altbeacon.beacon.distance;

import android.os.Build;
import org.altbeacon.beacon.logging.LogManager;

public class AndroidModel {
    String mBuildNumber;
    String mManufacturer;
    String mModel;
    String mVersion;

    public AndroidModel(String string, String string2, String string3, String string4) {
        this.mVersion = string;
        this.mBuildNumber = string2;
        this.mModel = string3;
        this.mManufacturer = string4;
    }

    public static AndroidModel forThisDevice() {
        return new AndroidModel(Build.VERSION.RELEASE, Build.ID, Build.MODEL, Build.MANUFACTURER);
    }

    public String getBuildNumber() {
        return this.mBuildNumber;
    }

    public String getManufacturer() {
        return this.mManufacturer;
    }

    public String getModel() {
        return this.mModel;
    }

    public String getVersion() {
        return this.mVersion;
    }

    public int matchScore(AndroidModel androidModel) {
        int n2 = this.mManufacturer.equalsIgnoreCase(androidModel.mManufacturer);
        if (n2 == 1 && this.mModel.equals((Object)androidModel.mModel)) {
            n2 = 2;
        }
        if (n2 == 2 && this.mBuildNumber.equals((Object)androidModel.mBuildNumber)) {
            n2 = 3;
        }
        if (n2 == 3 && this.mVersion.equals((Object)androidModel.mVersion)) {
            n2 = 4;
        }
        Object[] arrobject = new Object[]{n2, this.toString(), androidModel};
        LogManager.d("AndroidModel", "Score is %s for %s compared to %s", arrobject);
        return n2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("");
        stringBuilder.append(this.mManufacturer);
        stringBuilder.append(";");
        stringBuilder.append(this.mModel);
        stringBuilder.append(";");
        stringBuilder.append(this.mBuildNumber);
        stringBuilder.append(";");
        stringBuilder.append(this.mVersion);
        return stringBuilder.toString();
    }
}


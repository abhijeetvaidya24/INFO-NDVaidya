/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageInfo
 *  android.os.Build
 *  android.os.Build$VERSION
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 */
package io.presage.core;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Build;

public final class IIIlIIlI {
    public String IIIIIIII;
    public int IIIIIIIl;
    public long IIIIIIlI;
    public long IIIIIIll;
    public boolean IIIIIlII;
    public boolean IIIIIlIl;
    public String IIIIIllI;
    public long IIIIIlll;

    /*
     * Enabled aggressive block sorting
     */
    public IIIlIIlI(PackageInfo packageInfo, boolean bl2, boolean bl3) {
        this.IIIIIIII = packageInfo.packageName;
        this.IIIIIIIl = packageInfo.applicationInfo.uid;
        this.IIIIIIlI = packageInfo.firstInstallTime;
        this.IIIIIIll = packageInfo.lastUpdateTime;
        this.IIIIIlII = bl2;
        this.IIIIIlIl = bl3;
        String string2 = packageInfo.versionName != null ? packageInfo.versionName : "";
        this.IIIIIllI = string2;
        long l2 = Build.VERSION.SDK_INT >= 28 ? packageInfo.getLongVersionCode() : Integer.valueOf((int)packageInfo.versionCode).longValue();
        this.IIIIIlll = l2;
    }

    public IIIlIIlI(String string2, int n2, long l2, long l3, boolean bl2, boolean bl3, String string3, long l4) {
        this.IIIIIIII = string2;
        this.IIIIIIIl = n2;
        this.IIIIIIlI = l2;
        this.IIIIIIll = l3;
        this.IIIIIlII = bl2;
        this.IIIIIlIl = bl3;
        this.IIIIIllI = string3;
        this.IIIIIlll = l4;
    }
}


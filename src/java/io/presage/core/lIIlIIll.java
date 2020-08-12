/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.ServiceConnection
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.os.Build
 *  android.os.IBinder
 *  android.os.RemoteException
 *  android.provider.Settings
 *  android.provider.Settings$Secure
 *  android.provider.Settings$SettingNotFoundException
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.IllegalStateException
 *  java.lang.InterruptedException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Collections
 *  java.util.Comparator
 *  java.util.List
 *  java.util.UUID
 *  java.util.concurrent.LinkedBlockingQueue
 */
package io.presage.core;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.IBinder;
import android.os.RemoteException;
import android.provider.Settings;
import io.presage.core.lIIIlIlI;
import io.presage.core.lIIlIIIl;
import io.presage.core.lIIlIIlI;
import io.presage.core.lIIlIlII;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.LinkedBlockingQueue;

public final class lIIlIIll {
    private static final String IIIIIIIl = lIIIlIlI.IIIIIIlI.IIIIIIII;
    private static final String IIIIIIlI = lIIIlIlI.IIIIIIlI.IIIIIIIl;
    private static final String IIIIIIll = lIIIlIlI.IIIIIIlI.IIIIIIlI;
    private static final String IIIIIlII = lIIIlIlI.IIIIIIlI.IIIIIIll;
    private static final String IIIIIlIl = lIIIlIlI.IIIIIIlI.IIIIIlII;
    private static final String IIIIIllI = lIIIlIlI.IIIIIIlI.IIIIIlIl;
    private static final String IIIIIlll = lIIIlIlI.IIIIIIlI.IIIIIllI;
    private static final String IIIIlIII = lIIIlIlI.IIIIIIlI.IIIIIlll;
    public IIIIIIIl IIIIIIII;
    private Context IIIIlIIl;

    public lIIlIIll(Context context) {
        this.IIIIlIIl = context;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private lIIlIIlI IIIIIIII() {
        Throwable throwable2222;
        lIIlIlII lIIlIlII2;
        block10 : {
            block9 : {
                String string = Build.MODEL;
                boolean bl2 = true;
                if (string != null && Build.MODEL.contains((CharSequence)IIIIIlll) && Build.MANUFACTURER != null && Build.MANUFACTURER.equalsIgnoreCase(IIIIIllI)) {
                    try {
                        String string2 = Settings.Secure.getString((ContentResolver)this.IIIIlIIl.getContentResolver(), (String)IIIIIlII);
                        boolean bl3 = Settings.Secure.getInt((ContentResolver)this.IIIIlIIl.getContentResolver(), (String)IIIIIlIl);
                        if (bl3 != bl2) {
                            bl2 = false;
                        }
                        if (string2 != null) return new lIIlIIlI(string2, bl2, false);
                    }
                    catch (Settings.SettingNotFoundException settingNotFoundException) {
                        return this.IIIIIIlI();
                    }
                    return this.IIIIIIlI();
                }
                if (!this.IIIIIIIl()) return this.IIIIIIlI();
                lIIlIlII2 = new lIIlIlII();
                Intent intent = new Intent(IIIIIIlI);
                intent.setPackage(IIIIIIll);
                if (!this.IIIIlIIl.getApplicationContext().bindService(intent, (ServiceConnection)lIIlIlII2, (int)bl2)) return this.IIIIIIlI();
                if (lIIlIlII2.IIIIIIIl) break block9;
                lIIlIlII2.IIIIIIIl = bl2;
                lIIlIIIl lIIlIIIl2 = new lIIlIIIl((IBinder)lIIlIlII2.IIIIIIII.take());
                lIIlIIlI lIIlIIlI2 = new lIIlIIlI(lIIlIIIl2.IIIIIIII(), lIIlIIIl2.IIIIIIIl(), false);
                this.IIIIlIIl.getApplicationContext().unbindService((ServiceConnection)lIIlIlII2);
                return lIIlIIlI2;
            }
            try {
                throw new IllegalStateException();
            }
            catch (Throwable throwable2222) {
                break block10;
            }
            catch (RemoteException | InterruptedException throwable) {
                lIIlIIlI lIIlIIlI3 = this.IIIIIIlI();
                this.IIIIlIIl.getApplicationContext().unbindService((ServiceConnection)lIIlIlII2);
                return lIIlIIlI3;
            }
        }
        this.IIIIlIIl.getApplicationContext().unbindService((ServiceConnection)lIIlIlII2);
        throw throwable2222;
    }

    static /* synthetic */ lIIlIIlI IIIIIIII(lIIlIIll lIIlIIll2) {
        return lIIlIIll2.IIIIIIII();
    }

    static /* synthetic */ void IIIIIIII(lIIlIIll lIIlIIll2, lIIlIIlI lIIlIIlI2) {
        IIIIIIIl iIIIIIIl = lIIlIIll2.IIIIIIII;
        if (iIIIIIIl != null) {
            iIIIIIIl.IIIIIIII(lIIlIIlI2);
        }
    }

    static /* synthetic */ void IIIIIIII(lIIlIIll lIIlIIll2, Exception exception) {
        lIIlIIll2.IIIIIIII(exception, 1);
    }

    private boolean IIIIIIIl() {
        boolean bl2;
        bl2 = false;
        try {
            this.IIIIlIIl.getPackageManager().getPackageInfo(IIIIIIIl, 0);
            bl2 = true;
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {}
        return bl2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private lIIlIIlI IIIIIIlI() {
        ApplicationInfo applicationInfo;
        block8 : {
            ArrayList arrayList;
            block10 : {
                List list;
                block9 : {
                    PackageManager packageManager;
                    block7 : {
                        packageManager = this.IIIIlIIl.getPackageManager();
                        if (packageManager != null) break block7;
                        applicationInfo = null;
                        break block8;
                    }
                    list = packageManager.getInstalledApplications(128);
                    if (!list.isEmpty()) break block9;
                    applicationInfo = null;
                    break block8;
                }
                try {
                    arrayList = new ArrayList();
                    for (ApplicationInfo applicationInfo2 : list) {
                        if ((1 & applicationInfo2.flags) == 0 || applicationInfo2.packageName == null) continue;
                        arrayList.add((Object)applicationInfo2);
                    }
                    if (!arrayList.isEmpty()) break block10;
                    applicationInfo = null;
                    break block8;
                }
                catch (Exception exception) {
                    return new lIIlIIlI(IIIIlIII, false, true);
                }
            }
            Collections.sort((List)arrayList, (Comparator)new IIIIIIlI());
            applicationInfo = (ApplicationInfo)arrayList.get(0);
        }
        if (applicationInfo != null) return new lIIlIIlI(UUID.nameUUIDFromBytes((byte[])String.valueOf((long)this.IIIIlIIl.getPackageManager().getPackageInfo((String)applicationInfo.packageName, (int)128).firstInstallTime).getBytes()).toString(), false, true);
        return new lIIlIIlI(IIIIlIII, false, true);
    }

    public final void IIIIIIII(Exception exception, int n2) {
        IIIIIIIl iIIIIIIl = this.IIIIIIII;
        if (iIIIIIIl != null) {
            iIIIIIIl.IIIIIIII(exception, n2);
        }
    }

    public static interface IIIIIIIl {
        public void IIIIIIII(lIIlIIlI var1);

        public void IIIIIIII(Exception var1, int var2);
    }

    public final class IIIIIIlI
    implements Comparator<ApplicationInfo> {
        public final /* synthetic */ int compare(Object object, Object object2) {
            ApplicationInfo applicationInfo = (ApplicationInfo)object;
            ApplicationInfo applicationInfo2 = (ApplicationInfo)object2;
            return applicationInfo.packageName.compareTo(applicationInfo2.packageName);
        }
    }

}


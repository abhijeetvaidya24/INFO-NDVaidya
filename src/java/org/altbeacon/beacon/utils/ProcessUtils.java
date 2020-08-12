/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.ActivityManager
 *  android.app.ActivityManager$RunningAppProcessInfo
 *  android.content.Context
 *  android.os.Process
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package org.altbeacon.beacon.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import java.util.List;

public class ProcessUtils {
    Context mContext;

    public ProcessUtils(Context context) {
        this.mContext = context;
    }

    public String getPackageName() {
        return this.mContext.getApplicationContext().getPackageName();
    }

    public int getPid() {
        return Process.myPid();
    }

    public String getProcessName() {
        List list = ((ActivityManager)this.mContext.getSystemService("activity")).getRunningAppProcesses();
        if (list != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : list) {
                if (runningAppProcessInfo.pid != this.getPid()) continue;
                return runningAppProcessInfo.processName;
            }
        }
        return null;
    }

    public boolean isMainProcess() {
        return this.getPackageName().equals((Object)this.getProcessName());
    }
}


/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.util.Log
 *  androidx.core.app.ActivityCompat
 *  com.appsgeyser.multiTabApp.MainNavigationActivity
 *  java.lang.Class
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.HashMap
 */
package com.appsgeyser.multiTabApp.utils;

import android.app.Activity;
import android.util.Log;
import androidx.core.app.ActivityCompat;
import com.appsgeyser.multiTabApp.Factory;
import com.appsgeyser.multiTabApp.MainNavigationActivity;
import java.util.ArrayList;
import java.util.HashMap;

public class PermissionController {
    private static PermissionController permissionController;
    private boolean isLaunch;
    private final ArrayList<HashMap<String[], Integer>> queue = new ArrayList();

    public static PermissionController getInstance() {
        Class<PermissionController> class_ = PermissionController.class;
        synchronized (PermissionController.class) {
            if (permissionController == null) {
                permissionController = new PermissionController();
            }
            PermissionController permissionController = PermissionController.permissionController;
            // ** MonitorExit[var2] (shouldn't be in output)
            return permissionController;
        }
    }

    public void addPermissions(String[] arrstring, Integer n2) {
        HashMap hashMap = new HashMap(1);
        hashMap.put((Object)arrstring, (Object)n2);
        if (!this.isLaunch) {
            ActivityCompat.requestPermissions((Activity)Factory.getInstance().getMainNavigationActivity(), (String[])arrstring, (int)n2);
            Log.i((String)"permissionsPair!", (String)"request");
            this.isLaunch = true;
            return;
        }
        this.queue.add((Object)hashMap);
    }
}


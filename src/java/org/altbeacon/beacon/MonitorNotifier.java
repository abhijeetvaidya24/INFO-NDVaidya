/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package org.altbeacon.beacon;

import org.altbeacon.beacon.Region;

public interface MonitorNotifier {
    public void didDetermineStateForRegion(int var1, Region var2);

    public void didEnterRegion(Region var1);

    public void didExitRegion(Region var1);
}


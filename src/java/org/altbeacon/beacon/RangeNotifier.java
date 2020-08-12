/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Collection
 */
package org.altbeacon.beacon;

import java.util.Collection;
import org.altbeacon.beacon.Beacon;
import org.altbeacon.beacon.Region;

public interface RangeNotifier {
    public void didRangeBeaconsInRegion(Collection<Beacon> var1, Region var2);
}


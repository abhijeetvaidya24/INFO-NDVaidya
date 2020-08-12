/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 */
package com.ironsource.mediationsdk.model;

import com.ironsource.mediationsdk.model.OfferwallPlacement;
import java.util.ArrayList;

public class OfferwallConfigurations {
    private OfferwallPlacement mDefaultOWPlacement;
    private ArrayList<OfferwallPlacement> mOWPlacements = new ArrayList();

    public void addOfferwallPlacement(OfferwallPlacement offerwallPlacement) {
        if (offerwallPlacement != null) {
            this.mOWPlacements.add((Object)offerwallPlacement);
            if (offerwallPlacement.getPlacementId() == 0) {
                this.mDefaultOWPlacement = offerwallPlacement;
            }
        }
    }

    public OfferwallPlacement getDefaultOfferwallPlacement() {
        return this.mDefaultOWPlacement;
    }

    public OfferwallPlacement getOfferwallPlacement(String string) {
        for (OfferwallPlacement offerwallPlacement : this.mOWPlacements) {
            if (!offerwallPlacement.getPlacementName().equals((Object)string)) continue;
            return offerwallPlacement;
        }
        return null;
    }
}


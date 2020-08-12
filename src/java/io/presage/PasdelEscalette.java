/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 *  java.lang.Object
 *  java.lang.String
 */
package io.presage;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import io.presage.BoulettedAvesnes;
import io.presage.ParmigianoReggiano;
import io.presage.PavedAremberg;

public final class PasdelEscalette {
    public static final PasdelEscalette a = new PasdelEscalette();

    private PasdelEscalette() {
    }

    public static ParmigianoReggiano a(PavedAremberg pavedAremberg, FrameLayout frameLayout, BoulettedAvesnes boulettedAvesnes, String string2) {
        return new ParmigianoReggiano(pavedAremberg, (ViewGroup)frameLayout, boulettedAvesnes, string2);
    }
}


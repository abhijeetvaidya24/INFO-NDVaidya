/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Object
 *  java.util.ArrayList
 */
package io.presage.core;

import io.presage.core.IlIllIlI;
import java.util.ArrayList;

public final class IlIlllIl {
    ArrayList<Integer> IIIIIIII;

    public IlIlllIl(ArrayList<Integer> arrayList) {
        if (!arrayList.isEmpty()) {
            this.IIIIIIII = arrayList;
            return;
        }
        throw new IlIllIlI();
    }
}


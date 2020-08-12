/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.ArrayList
 *  java.util.List
 */
package org.altbeacon.bluetooth;

import java.util.ArrayList;
import java.util.List;
import org.altbeacon.bluetooth.Pdu;

public class BleAdvertisement {
    private byte[] mBytes;
    private List<Pdu> mPdus;

    public BleAdvertisement(byte[] arrby) {
        this.mBytes = arrby;
        this.mPdus = this.parsePdus();
    }

    private List<Pdu> parsePdus() {
        Pdu pdu;
        ArrayList arrayList = new ArrayList();
        int n2 = 0;
        do {
            if ((pdu = Pdu.parse(this.mBytes, n2)) == null) continue;
            n2 = 1 + (n2 + pdu.getDeclaredLength());
            arrayList.add((Object)pdu);
        } while (pdu != null && n2 < this.mBytes.length);
        return arrayList;
    }

    public List<Pdu> getPdus() {
        return this.mPdus;
    }
}


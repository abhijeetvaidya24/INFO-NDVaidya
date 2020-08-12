/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.presage.core.lIIlIlIl
 *  io.presage.core.lIIllIIl
 *  io.presage.core.lIIllIlI
 *  java.lang.Object
 *  java.security.NoSuchAlgorithmException
 *  java.util.Arrays
 *  java.util.Iterator
 *  java.util.LinkedList
 */
package io.presage.core;

import io.presage.core.lIIlIlIl;
import io.presage.core.lIIllIII;
import io.presage.core.lIIllIIl;
import io.presage.core.lIIllIlI;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public final class lIIlIlll {
    private LinkedList<lIIllIII> IIIIIIII = new LinkedList();

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final lIIlIlll IIIIIIII(int n2) {
        lIIllIlI lIIllIlI2;
        LinkedList<lIIllIII> linkedList = this.IIIIIIII;
        if (n2 != 0) {
            if (n2 != 1) {
                if (n2 != 2) throw new NoSuchAlgorithmException();
                lIIllIlI2 = new lIIlIlIl();
            } else {
                lIIllIlI2 = new lIIllIIl();
            }
        } else {
            lIIllIlI2 = new lIIllIlI();
        }
        linkedList.add((Object)lIIllIlI2);
        return this;
    }

    public final lIIlIlll IIIIIIII(byte[] arrby) {
        ((lIIllIII)this.IIIIIIII.getLast()).IIIIIIII(arrby);
        return this;
    }

    public final byte[] IIIIIIIl(byte[] arrby) {
        Iterator iterator = this.IIIIIIII.iterator();
        while (iterator.hasNext()) {
            byte[] arrby2 = ((lIIllIII)iterator.next()).IIIIIIIl(arrby);
            arrby = Arrays.copyOf((byte[])arrby2, (int)arrby2.length);
        }
        return arrby;
    }

    public final byte[] IIIIIIlI(byte[] arrby) {
        Iterator iterator = this.IIIIIIII.iterator();
        while (iterator.hasNext()) {
            byte[] arrby2 = ((lIIllIII)iterator.next()).IIIIIIlI(arrby);
            arrby = Arrays.copyOf((byte[])arrby2, (int)arrby2.length);
        }
        return arrby;
    }
}


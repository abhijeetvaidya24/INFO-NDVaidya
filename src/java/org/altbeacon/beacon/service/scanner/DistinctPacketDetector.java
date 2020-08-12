/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.util.HashSet
 *  java.util.Set
 */
package org.altbeacon.beacon.service.scanner;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.HashSet;
import java.util.Set;

public class DistinctPacketDetector {
    private final Set<ByteBuffer> mDistinctPacketsDetected = new HashSet();

    public void clearDetections() {
        this.mDistinctPacketsDetected.clear();
    }

    public boolean isPacketDistinct(String string, byte[] arrby) {
        byte[] arrby2 = string.getBytes();
        ByteBuffer byteBuffer = ByteBuffer.allocate((int)(arrby2.length + arrby.length));
        byteBuffer.put(arrby2);
        byteBuffer.put(arrby);
        byteBuffer.rewind();
        if (this.mDistinctPacketsDetected.size() == 1000) {
            return this.mDistinctPacketsDetected.contains((Object)byteBuffer);
        }
        return this.mDistinctPacketsDetected.add((Object)byteBuffer);
    }
}


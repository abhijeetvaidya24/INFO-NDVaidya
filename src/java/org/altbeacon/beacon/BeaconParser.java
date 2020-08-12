/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.bluetooth.BluetoothDevice
 *  android.util.Log
 *  java.io.Serializable
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Double
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Math
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.List
 *  java.util.regex.Matcher
 *  java.util.regex.Pattern
 */
package org.altbeacon.beacon;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothDevice;
import android.util.Log;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.altbeacon.beacon.Beacon;
import org.altbeacon.beacon.logging.LogManager;

public class BeaconParser
implements Serializable {
    private static final Pattern D_PATTERN;
    private static final char[] HEX_ARRAY;
    private static final Pattern I_PATTERN;
    private static final Pattern M_PATTERN;
    private static final Pattern P_PATTERN;
    private static final Pattern S_PATTERN;
    private static final Pattern X_PATTERN;
    protected List<BeaconParser> extraParsers = new ArrayList();
    protected Boolean mAllowPduOverflow = true;
    protected String mBeaconLayout;
    protected Integer mDBmCorrection;
    protected final List<Integer> mDataEndOffsets = new ArrayList();
    protected final List<Boolean> mDataLittleEndianFlags = new ArrayList();
    protected final List<Integer> mDataStartOffsets = new ArrayList();
    protected Boolean mExtraFrame;
    protected int[] mHardwareAssistManufacturers = new int[]{76};
    protected String mIdentifier;
    protected final List<Integer> mIdentifierEndOffsets = new ArrayList();
    protected final List<Boolean> mIdentifierLittleEndianFlags = new ArrayList();
    protected final List<Integer> mIdentifierStartOffsets = new ArrayList();
    protected final List<Boolean> mIdentifierVariableLengthFlags = new ArrayList();
    protected Integer mLayoutSize;
    private Long mMatchingBeaconTypeCode;
    protected Integer mMatchingBeaconTypeCodeEndOffset;
    protected Integer mMatchingBeaconTypeCodeStartOffset;
    protected Integer mPowerEndOffset;
    protected Integer mPowerStartOffset;
    protected Long mServiceUuid;
    protected Integer mServiceUuidEndOffset;
    protected Integer mServiceUuidStartOffset;

    static {
        I_PATTERN = Pattern.compile((String)"i\\:(\\d+)\\-(\\d+)([blv]*)?");
        M_PATTERN = Pattern.compile((String)"m\\:(\\d+)-(\\d+)\\=([0-9A-Fa-f]+)");
        S_PATTERN = Pattern.compile((String)"s\\:(\\d+)-(\\d+)\\=([0-9A-Fa-f]+)");
        D_PATTERN = Pattern.compile((String)"d\\:(\\d+)\\-(\\d+)([bl]*)?");
        P_PATTERN = Pattern.compile((String)"p\\:(\\d+)\\-(\\d+)\\:?([\\-\\d]+)?");
        X_PATTERN = Pattern.compile((String)"x");
        HEX_ARRAY = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    private String byteArrayToFormattedString(byte[] arrby, int n2, int n3, boolean bl2) {
        int n4 = n3 - n2;
        int n5 = n4 + 1;
        byte[] arrby2 = new byte[n5];
        int n6 = 0;
        if (bl2) {
            for (int i2 = 0; i2 <= n4; ++i2) {
                arrby2[i2] = arrby[-1 + (n2 + arrby2.length) - i2];
            }
        } else {
            for (int i3 = 0; i3 <= n4; ++i3) {
                arrby2[i3] = arrby[n2 + i3];
            }
        }
        if (n5 < 5) {
            long l2 = 0L;
            while (n6 < arrby2.length) {
                long l3 = 255 & arrby2[-1 + (arrby2.length - n6)];
                double d2 = n6;
                Double.isNaN((double)d2);
                l2 += l3 * (long)Math.pow((double)256.0, (double)(d2 * 1.0));
                ++n6;
            }
            return Long.toString((long)l2);
        }
        String string = BeaconParser.bytesToHex(arrby2);
        if (arrby2.length == 16) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string.substring(0, 8));
            stringBuilder.append("-");
            stringBuilder.append(string.substring(8, 12));
            stringBuilder.append("-");
            stringBuilder.append(string.substring(12, 16));
            stringBuilder.append("-");
            stringBuilder.append(string.substring(16, 20));
            stringBuilder.append("-");
            stringBuilder.append(string.substring(20, 32));
            return stringBuilder.toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("0x");
        stringBuilder.append(string);
        return stringBuilder.toString();
    }

    private String byteArrayToString(byte[] arrby) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i2 = 0; i2 < arrby.length; ++i2) {
            Object[] arrobject = new Object[]{arrby[i2]};
            stringBuilder.append(String.format((String)"%02x", (Object[])arrobject));
            stringBuilder.append(" ");
        }
        return stringBuilder.toString().trim();
    }

    private boolean byteArraysMatch(byte[] arrby, int n2, byte[] arrby2) {
        int n3 = arrby2.length;
        if (arrby.length - n2 < n3) {
            return false;
        }
        for (int i2 = 0; i2 < n3; ++i2) {
            if (arrby[n2 + i2] == arrby2[i2]) continue;
            return false;
        }
        return true;
    }

    protected static String bytesToHex(byte[] arrby) {
        char[] arrc = new char[2 * arrby.length];
        for (int i2 = 0; i2 < arrby.length; ++i2) {
            int n2 = 255 & arrby[i2];
            int n3 = i2 * 2;
            char[] arrc2 = HEX_ARRAY;
            arrc[n3] = arrc2[n2 >>> 4];
            arrc[n3 + 1] = arrc2[n2 & 15];
        }
        return new String(arrc);
    }

    private int calculateLayoutSize() {
        Integer n2;
        Integer n3;
        List<Integer> list;
        List<Integer> list2 = this.mIdentifierEndOffsets;
        int n4 = 0;
        if (list2 != null) {
            Iterator iterator = list2.iterator();
            while (iterator.hasNext()) {
                int n5 = (Integer)iterator.next();
                if (n5 <= n4) continue;
                n4 = n5;
            }
        }
        if ((list = this.mDataEndOffsets) != null) {
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                int n6 = (Integer)iterator.next();
                if (n6 <= n4) continue;
                n4 = n6;
            }
        }
        if ((n2 = this.mPowerEndOffset) != null && n2 > n4) {
            n4 = this.mPowerEndOffset;
        }
        if ((n3 = this.mServiceUuidEndOffset) != null && n3 > n4) {
            n4 = this.mServiceUuidEndOffset;
        }
        return n4 + 1;
    }

    @TargetApi(value=9)
    private byte[] ensureMaxSize(byte[] arrby, int n2) {
        if (arrby.length >= n2) {
            return arrby;
        }
        return Arrays.copyOf((byte[])arrby, (int)n2);
    }

    public static byte[] longToByteArray(long l2, int n2) {
        return BeaconParser.longToByteArray(l2, n2, true);
    }

    public static byte[] longToByteArray(long l2, int n2, boolean bl2) {
        byte[] arrby = new byte[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            int n3 = bl2 ? i2 : -1 + (n2 - i2);
            int n4 = 8 * (-1 + (n2 - n3));
            long l3 = 255L << n4;
            long l4 = n4;
            arrby[i2] = (byte)((l3 & l2) >> (int)l4);
        }
        return arrby;
    }

    /*
     * Exception decompiling
     */
    public boolean equals(Object var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl26.1 : ICONST_0 : trying to set 1 previously set to 0
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:919)
        throw new IllegalStateException("Decompilation failed");
    }

    public Beacon fromScanData(byte[] arrby, int n2, BluetoothDevice bluetoothDevice) {
        return this.fromScanData(arrby, n2, bluetoothDevice, new Beacon());
    }

    /*
     * Exception decompiling
     */
    protected Beacon fromScanData(byte[] var1, int var2, BluetoothDevice var3, Beacon var4) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Underrun type stack
        // org.benf.cfr.reader.b.a.c.e.a(StackSim.java:35)
        // org.benf.cfr.reader.b.b.af.a(OperationFactoryPop.java:20)
        // org.benf.cfr.reader.b.b.e.a(JVMInstr.java:315)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:195)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:919)
        throw new IllegalStateException("Decompilation failed");
    }

    public List<BeaconParser> getExtraDataParsers() {
        return new ArrayList(this.extraParsers);
    }

    public int[] getHardwareAssistManufacturers() {
        return this.mHardwareAssistManufacturers;
    }

    public String getLayout() {
        return this.mBeaconLayout;
    }

    public Long getMatchingBeaconTypeCode() {
        return this.mMatchingBeaconTypeCode;
    }

    public int getMatchingBeaconTypeCodeEndOffset() {
        return this.mMatchingBeaconTypeCodeEndOffset;
    }

    public int getMatchingBeaconTypeCodeStartOffset() {
        return this.mMatchingBeaconTypeCodeStartOffset;
    }

    public Long getServiceUuid() {
        return this.mServiceUuid;
    }

    public int hashCode() {
        Object[] arrobject = new Object[]{this.mMatchingBeaconTypeCode, this.mIdentifierStartOffsets, this.mIdentifierEndOffsets, this.mIdentifierLittleEndianFlags, this.mDataStartOffsets, this.mDataEndOffsets, this.mDataLittleEndianFlags, this.mIdentifierVariableLengthFlags, this.mMatchingBeaconTypeCodeStartOffset, this.mMatchingBeaconTypeCodeEndOffset, this.mServiceUuidStartOffset, this.mServiceUuidEndOffset, this.mServiceUuid, this.mExtraFrame, this.mPowerStartOffset, this.mPowerEndOffset, this.mDBmCorrection, this.mLayoutSize, this.mAllowPduOverflow, this.mIdentifier, this.mHardwareAssistManufacturers, this.extraParsers};
        return Arrays.hashCode((Object[])arrobject);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public BeaconParser setBeaconLayout(String string) {
        this.mBeaconLayout = string;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Parsing beacon layout: ");
        stringBuilder.append(string);
        Log.d((String)"BeaconParser", (String)stringBuilder.toString());
        String[] arrstring = string.split(",");
        this.mExtraFrame = false;
        int n2 = arrstring.length;
        int n3 = 0;
        do {
            boolean bl2;
            Matcher matcher;
            String string2;
            if (n3 < n2) {
                string2 = arrstring[n3];
                matcher = I_PATTERN.matcher((CharSequence)string2);
                bl2 = false;
            } else {
                if (!this.mExtraFrame.booleanValue()) {
                    if (this.mIdentifierStartOffsets.size() == 0) throw new BeaconLayoutException("You must supply at least one identifier offset with a prefix of 'i'");
                    if (this.mIdentifierEndOffsets.size() == 0) throw new BeaconLayoutException("You must supply at least one identifier offset with a prefix of 'i'");
                    if (this.mPowerStartOffset == null) throw new BeaconLayoutException("You must supply a power byte offset with a prefix of 'p'");
                    if (this.mPowerEndOffset == null) throw new BeaconLayoutException("You must supply a power byte offset with a prefix of 'p'");
                }
                if (this.mMatchingBeaconTypeCodeStartOffset != null && this.mMatchingBeaconTypeCodeEndOffset != null) {
                    this.mLayoutSize = this.calculateLayoutSize();
                    return this;
                }
                BeaconLayoutException beaconLayoutException = new BeaconLayoutException("You must supply a matching beacon type expression with a prefix of 'm'");
                throw beaconLayoutException;
            }
            while (matcher.find()) {
                try {
                    int n4 = Integer.parseInt((String)matcher.group(1));
                    int n5 = Integer.parseInt((String)matcher.group(2));
                    Boolean bl3 = matcher.group(3).contains((CharSequence)"l");
                    this.mIdentifierLittleEndianFlags.add((Object)bl3);
                    Boolean bl4 = matcher.group(3).contains((CharSequence)"v");
                    this.mIdentifierVariableLengthFlags.add((Object)bl4);
                    this.mIdentifierStartOffsets.add((Object)n4);
                    this.mIdentifierEndOffsets.add((Object)n5);
                    bl2 = true;
                }
                catch (NumberFormatException numberFormatException) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("Cannot parse integer byte offset in term: ");
                    stringBuilder2.append(string2);
                    throw new BeaconLayoutException(stringBuilder2.toString());
                }
            }
            Matcher matcher2 = D_PATTERN.matcher((CharSequence)string2);
            while (matcher2.find()) {
                try {
                    int n6 = Integer.parseInt((String)matcher2.group(1));
                    int n7 = Integer.parseInt((String)matcher2.group(2));
                    Boolean bl5 = matcher2.group(3).contains((CharSequence)"l");
                    this.mDataLittleEndianFlags.add((Object)bl5);
                    this.mDataStartOffsets.add((Object)n6);
                    this.mDataEndOffsets.add((Object)n7);
                    bl2 = true;
                }
                catch (NumberFormatException numberFormatException) {
                    StringBuilder stringBuilder3 = new StringBuilder();
                    stringBuilder3.append("Cannot parse integer byte offset in term: ");
                    stringBuilder3.append(string2);
                    throw new BeaconLayoutException(stringBuilder3.toString());
                }
            }
            Matcher matcher3 = P_PATTERN.matcher((CharSequence)string2);
            while (matcher3.find()) {
                try {
                    int n8 = Integer.parseInt((String)matcher3.group(1));
                    int n9 = Integer.parseInt((String)matcher3.group(2));
                    int n10 = matcher3.group(3) != null ? Integer.parseInt((String)matcher3.group(3)) : 0;
                    this.mDBmCorrection = n10;
                    this.mPowerStartOffset = n8;
                    this.mPowerEndOffset = n9;
                    bl2 = true;
                }
                catch (NumberFormatException numberFormatException) {
                    StringBuilder stringBuilder4 = new StringBuilder();
                    stringBuilder4.append("Cannot parse integer power byte offset in term: ");
                    stringBuilder4.append(string2);
                    throw new BeaconLayoutException(stringBuilder4.toString());
                }
            }
            Matcher matcher4 = M_PATTERN.matcher((CharSequence)string2);
            while (matcher4.find()) {
                try {
                    int n11 = Integer.parseInt((String)matcher4.group(1));
                    int n12 = Integer.parseInt((String)matcher4.group(2));
                    this.mMatchingBeaconTypeCodeStartOffset = n11;
                    this.mMatchingBeaconTypeCodeEndOffset = n12;
                }
                catch (NumberFormatException numberFormatException) {
                    StringBuilder stringBuilder5 = new StringBuilder();
                    stringBuilder5.append("Cannot parse integer byte offset in term: ");
                    stringBuilder5.append(string2);
                    throw new BeaconLayoutException(stringBuilder5.toString());
                }
                String string3 = matcher4.group(3);
                try {
                    StringBuilder stringBuilder6 = new StringBuilder();
                    stringBuilder6.append("0x");
                    stringBuilder6.append(string3);
                    this.mMatchingBeaconTypeCode = Long.decode((String)stringBuilder6.toString());
                    bl2 = true;
                }
                catch (NumberFormatException numberFormatException) {
                    StringBuilder stringBuilder7 = new StringBuilder();
                    stringBuilder7.append("Cannot parse beacon type code: ");
                    stringBuilder7.append(string3);
                    stringBuilder7.append(" in term: ");
                    stringBuilder7.append(string2);
                    throw new BeaconLayoutException(stringBuilder7.toString());
                }
            }
            Matcher matcher5 = S_PATTERN.matcher((CharSequence)string2);
            while (matcher5.find()) {
                try {
                    int n13 = Integer.parseInt((String)matcher5.group(1));
                    int n14 = Integer.parseInt((String)matcher5.group(2));
                    this.mServiceUuidStartOffset = n13;
                    this.mServiceUuidEndOffset = n14;
                }
                catch (NumberFormatException numberFormatException) {
                    StringBuilder stringBuilder8 = new StringBuilder();
                    stringBuilder8.append("Cannot parse integer byte offset in term: ");
                    stringBuilder8.append(string2);
                    throw new BeaconLayoutException(stringBuilder8.toString());
                }
                String string4 = matcher5.group(3);
                try {
                    StringBuilder stringBuilder9 = new StringBuilder();
                    stringBuilder9.append("0x");
                    stringBuilder9.append(string4);
                    this.mServiceUuid = Long.decode((String)stringBuilder9.toString());
                    bl2 = true;
                }
                catch (NumberFormatException numberFormatException) {
                    StringBuilder stringBuilder10 = new StringBuilder();
                    stringBuilder10.append("Cannot parse serviceUuid: ");
                    stringBuilder10.append(string4);
                    stringBuilder10.append(" in term: ");
                    stringBuilder10.append(string2);
                    throw new BeaconLayoutException(stringBuilder10.toString());
                }
            }
            Matcher matcher6 = X_PATTERN.matcher((CharSequence)string2);
            while (matcher6.find()) {
                this.mExtraFrame = true;
                bl2 = true;
            }
            if (!bl2) {
                LogManager.d("BeaconParser", "cannot parse term %s", string2);
                StringBuilder stringBuilder11 = new StringBuilder();
                stringBuilder11.append("Cannot parse beacon layout term: ");
                stringBuilder11.append(string2);
                throw new BeaconLayoutException(stringBuilder11.toString());
            }
            ++n3;
        } while (true);
    }

    public static class BeaconLayoutException
    extends RuntimeException {
        public BeaconLayoutException(String string) {
            super(string);
        }
    }

}


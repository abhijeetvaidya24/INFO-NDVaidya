/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  java.io.Serializable
 *  java.lang.ArrayIndexOutOfBoundsException
 *  java.lang.CharSequence
 *  java.lang.Comparable
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.UnsupportedOperationException
 *  java.nio.ByteBuffer
 *  java.nio.LongBuffer
 *  java.util.Arrays
 *  java.util.UUID
 *  java.util.regex.Matcher
 *  java.util.regex.Pattern
 */
package org.altbeacon.beacon;

import android.annotation.TargetApi;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.LongBuffer;
import java.util.Arrays;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Identifier
implements Serializable,
Comparable<Identifier> {
    private static final Pattern DECIMAL_PATTERN;
    private static final char[] HEX_DIGITS;
    private static final Pattern HEX_PATTERN;
    private static final Pattern HEX_PATTERN_NO_PREFIX;
    private static final Pattern UUID_PATTERN;
    private final byte[] mValue;

    static {
        HEX_PATTERN = Pattern.compile((String)"^0x[0-9A-Fa-f]*$");
        HEX_PATTERN_NO_PREFIX = Pattern.compile((String)"^[0-9A-Fa-f]*$");
        DECIMAL_PATTERN = Pattern.compile((String)"^0|[1-9][0-9]*$");
        UUID_PATTERN = Pattern.compile((String)"^[0-9A-Fa-f]{8}-?[0-9A-Fa-f]{4}-?[0-9A-Fa-f]{4}-?[0-9A-Fa-f]{4}-?[0-9A-Fa-f]{12}$");
        HEX_DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    protected Identifier(byte[] arrby) {
        if (arrby != null) {
            this.mValue = arrby;
            return;
        }
        throw new NullPointerException("Identifiers cannot be constructed from null pointers but \"value\" is null.");
    }

    @TargetApi(value=9)
    public static Identifier fromBytes(byte[] arrby, int n2, int n3, boolean bl2) {
        if (arrby != null) {
            if (n2 >= 0 && n2 <= arrby.length) {
                if (n3 <= arrby.length) {
                    if (n2 <= n3) {
                        byte[] arrby2 = Arrays.copyOfRange((byte[])arrby, (int)n2, (int)n3);
                        if (bl2) {
                            Identifier.reverseArray(arrby2);
                        }
                        return new Identifier(arrby2);
                    }
                    throw new IllegalArgumentException("start > end");
                }
                throw new ArrayIndexOutOfBoundsException("end > bytes.length");
            }
            throw new ArrayIndexOutOfBoundsException("start < 0 || start > bytes.length");
        }
        throw new NullPointerException("Identifiers cannot be constructed from null pointers but \"bytes\" is null.");
    }

    public static Identifier fromInt(int n2) {
        if (n2 >= 0 && n2 <= 65535) {
            byte[] arrby = new byte[]{(byte)(n2 >> 8), (byte)n2};
            return new Identifier(arrby);
        }
        throw new IllegalArgumentException("Identifiers can only be constructed from integers between 0 and 65535 (inclusive).");
    }

    public static Identifier fromLong(long l2, int n2) {
        IllegalArgumentException illegalArgumentException;
        if (n2 >= 0) {
            byte[] arrby = new byte[n2];
            for (int i2 = n2 - 1; i2 >= 0; --i2) {
                arrby[i2] = (byte)(255L & l2);
                l2 >>= 8;
            }
            return new Identifier(arrby);
        }
        illegalArgumentException = new IllegalArgumentException("Identifier length must be > 0.");
        throw illegalArgumentException;
    }

    public static Identifier parse(String string) {
        return Identifier.parse(string, -1);
    }

    public static Identifier parse(String string, int n2) {
        if (string != null) {
            if (HEX_PATTERN.matcher((CharSequence)string).matches()) {
                return Identifier.parseHex(string.substring(2), n2);
            }
            if (UUID_PATTERN.matcher((CharSequence)string).matches()) {
                return Identifier.parseHex(string.replace((CharSequence)"-", (CharSequence)""), n2);
            }
            if (DECIMAL_PATTERN.matcher((CharSequence)string).matches()) {
                int n3;
                block7 : {
                    try {
                        n3 = Integer.valueOf((String)string);
                        if (n2 <= 0 || n2 == 2) break block7;
                    }
                    catch (Throwable throwable) {
                        throw new IllegalArgumentException("Unable to parse Identifier in decimal format.", throwable);
                    }
                    return Identifier.fromLong(n3, n2);
                }
                return Identifier.fromInt(n3);
            }
            if (HEX_PATTERN_NO_PREFIX.matcher((CharSequence)string).matches()) {
                return Identifier.parseHex(string, n2);
            }
            throw new IllegalArgumentException("Unable to parse Identifier.");
        }
        throw new NullPointerException("Identifiers cannot be constructed from null pointers but \"stringValue\" is null.");
    }

    private static Identifier parseHex(String string, int n2) {
        String string2 = string.length() % 2 == 0 ? "" : "0";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(string.toUpperCase());
        String string3 = stringBuilder.toString();
        if (n2 > 0 && n2 < string3.length() / 2) {
            string3 = string3.substring(string3.length() - n2 * 2);
        }
        if (n2 > 0 && n2 > string3.length() / 2) {
            int n3 = n2 * 2 - string3.length();
            StringBuilder stringBuilder2 = new StringBuilder();
            while (stringBuilder2.length() < n3) {
                stringBuilder2.append("0");
            }
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(stringBuilder2.toString());
            stringBuilder3.append(string3);
            string3 = stringBuilder3.toString();
        }
        byte[] arrby = new byte[string3.length() / 2];
        for (int i2 = 0; i2 < arrby.length; ++i2) {
            int n4 = i2 * 2;
            arrby[i2] = (byte)(255 & Integer.parseInt((String)string3.substring(n4, n4 + 2), (int)16));
        }
        return new Identifier(arrby);
    }

    private static void reverseArray(byte[] arrby) {
        for (int i2 = 0; i2 < arrby.length / 2; ++i2) {
            int n2 = -1 + (arrby.length - i2);
            byte by = arrby[i2];
            arrby[i2] = arrby[n2];
            arrby[n2] = by;
        }
    }

    public int compareTo(Identifier identifier) {
        byte[] arrby;
        byte[] arrby2 = this.mValue;
        int n2 = arrby2.length;
        byte[] arrby3 = identifier.mValue;
        if (n2 != arrby3.length) {
            if (arrby2.length < arrby3.length) {
                return -1;
            }
            return 1;
        }
        for (int i2 = 0; i2 < (arrby = this.mValue).length; ++i2) {
            byte by = arrby[i2];
            byte[] arrby4 = identifier.mValue;
            if (by == arrby4[i2]) continue;
            if (arrby[i2] < arrby4[i2]) {
                return -1;
            }
            return 1;
        }
        return 0;
    }

    public boolean equals(Object object) {
        if (!(object instanceof Identifier)) {
            return false;
        }
        Identifier identifier = (Identifier)object;
        return Arrays.equals((byte[])this.mValue, (byte[])identifier.mValue);
    }

    public int hashCode() {
        return Arrays.hashCode((byte[])this.mValue);
    }

    public String toHexString() {
        int n2 = this.mValue.length;
        int n3 = n2 * 2;
        int n4 = 2;
        char[] arrc = new char[n3 + n4];
        arrc[0] = 48;
        arrc[1] = 120;
        for (int i2 = 0; i2 < n2; ++i2) {
            int n5 = n4 + 1;
            char[] arrc2 = HEX_DIGITS;
            byte[] arrby = this.mValue;
            arrc[n4] = arrc2[(240 & arrby[i2]) >>> 4];
            n4 = n5 + 1;
            arrc[n5] = arrc2[15 & arrby[i2]];
        }
        return new String(arrc);
    }

    public int toInt() {
        UnsupportedOperationException unsupportedOperationException;
        if (this.mValue.length <= 2) {
            byte[] arrby;
            int n2 = 0;
            for (int i2 = 0; i2 < (arrby = this.mValue).length; ++i2) {
                n2 |= (255 & arrby[i2]) << 8 * (-1 + (arrby.length - i2));
            }
            return n2;
        }
        unsupportedOperationException = new UnsupportedOperationException("Only supported for Identifiers with max byte length of 2");
        throw unsupportedOperationException;
    }

    public String toString() {
        byte[] arrby = this.mValue;
        if (arrby.length == 2) {
            return Integer.toString((int)this.toInt());
        }
        if (arrby.length == 16) {
            return this.toUuid().toString();
        }
        return this.toHexString();
    }

    public UUID toUuid() {
        byte[] arrby = this.mValue;
        if (arrby.length == 16) {
            LongBuffer longBuffer = ByteBuffer.wrap((byte[])arrby).asLongBuffer();
            return new UUID(longBuffer.get(), longBuffer.get());
        }
        throw new UnsupportedOperationException("Only Identifiers backed by a byte array with length of exactly 16 can be UUIDs.");
    }
}


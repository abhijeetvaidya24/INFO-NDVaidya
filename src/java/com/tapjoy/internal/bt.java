/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.EOFException
 *  java.io.IOException
 *  java.io.Reader
 *  java.lang.AssertionError
 *  java.lang.Class
 *  java.lang.Double
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.ArrayList
 *  java.util.List
 */
package com.tapjoy.internal;

import com.tapjoy.internal.bs;
import com.tapjoy.internal.bt;
import com.tapjoy.internal.bv;
import com.tapjoy.internal.bx;
import com.tapjoy.internal.bz;
import com.tapjoy.internal.co;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public final class bt
extends bs {
    public static final bs.a a = new bs.a(){

        public final bs a(Reader reader) {
            return new bt(reader);
        }

        public final bs a(String string) {
            return new bt((Reader)new java.io.StringReader(string));
        }
    };
    private final co b = new co();
    private final Reader c;
    private boolean d = false;
    private final char[] e = new char[1024];
    private int f = 0;
    private int g = 0;
    private int h = 1;
    private int i = 1;
    private final List j = new ArrayList();
    private bx k;
    private String l;
    private String m;
    private int n;
    private int o;
    private boolean p;

    public bt(Reader reader) {
        this.a(bv.f);
        this.p = false;
        if (reader != null) {
            this.c = reader;
            return;
        }
        throw new NullPointerException("in == null");
    }

    private void A() {
        while (this.f < this.g || this.a(1)) {
            char[] arrc = this.e;
            int n2 = this.f;
            this.f = n2 + 1;
            char c2 = arrc[n2];
            if (c2 != '\r' && c2 != '\n') continue;
        }
    }

    private bx a(boolean bl) {
        bx bx2;
        if (bl) {
            this.b(bv.b);
        } else {
            int n2 = this.y();
            if (n2 != 44) {
                if (n2 != 59) {
                    if (n2 == 93) {
                        bx bx3;
                        this.u();
                        this.k = bx3 = bx.b;
                        return bx3;
                    }
                    throw this.d("Unterminated array");
                }
                this.z();
            }
        }
        int n3 = this.y();
        if (n3 != 44 && n3 != 59) {
            if (n3 != 93) {
                this.f = -1 + this.f;
                return this.v();
            }
            if (bl) {
                bx bx4;
                this.u();
                this.k = bx4 = bx.b;
                return bx4;
            }
        }
        this.z();
        this.f = -1 + this.f;
        this.m = "null";
        this.k = bx2 = bx.i;
        return bx2;
    }

    private String a(char c2) {
        IOException iOException;
        StringBuilder stringBuilder = null;
        do {
            int n2;
            int n3 = this.f;
            while ((n2 = this.f) < this.g) {
                char[] arrc = this.e;
                this.f = n2 + 1;
                char c3 = arrc[n2];
                if (c3 == c2) {
                    if (this.p) {
                        return "skipped!";
                    }
                    if (stringBuilder == null) {
                        return this.b.a(arrc, n3, this.f - n3 - 1);
                    }
                    stringBuilder.append(arrc, n3, this.f - n3 - 1);
                    return stringBuilder.toString();
                }
                if (c3 != '\\') continue;
                if (stringBuilder == null) {
                    stringBuilder = new StringBuilder();
                }
                stringBuilder.append(this.e, n3, this.f - n3 - 1);
                if (this.f == this.g && !this.a(1)) {
                    throw this.d("Unterminated escape sequence");
                }
                char[] arrc2 = this.e;
                int n4 = this.f;
                this.f = n4 + 1;
                int n5 = arrc2[n4];
                if (n5 != 98) {
                    if (n5 != 102) {
                        if (n5 != 110) {
                            if (n5 != 114) {
                                if (n5 != 116) {
                                    if (n5 == 117) {
                                        if (4 + this.f > this.g && !this.a(4)) {
                                            throw this.d("Unterminated escape sequence");
                                        }
                                        String string = this.b.a(this.e, this.f, 4);
                                        this.f = 4 + this.f;
                                        n5 = (char)Integer.parseInt((String)string, (int)16);
                                    }
                                } else {
                                    n5 = 9;
                                }
                            } else {
                                n5 = 13;
                            }
                        } else {
                            n5 = 10;
                        }
                    } else {
                        n5 = 12;
                    }
                } else {
                    n5 = 8;
                }
                stringBuilder.append((char)n5);
                n3 = this.f;
            }
            if (stringBuilder == null) {
                stringBuilder = new StringBuilder();
            }
            stringBuilder.append(this.e, n3, this.f - n3);
        } while (this.a(1));
        iOException = this.d("Unterminated string");
        throw iOException;
    }

    private void a(bv bv2) {
        this.j.add((Object)bv2);
    }

    private void a(bx bx2) {
        this.k();
        if (this.k == bx2) {
            this.t();
            return;
        }
        StringBuilder stringBuilder = new StringBuilder("Expected ");
        stringBuilder.append((Object)bx2);
        stringBuilder.append(" but was ");
        stringBuilder.append((Object)this.k());
        throw new IllegalStateException(stringBuilder.toString());
    }

    private boolean a(int n2) {
        int n3;
        int n4;
        Reader reader;
        char[] arrc;
        int n5;
        for (int i2 = 0; i2 < (n3 = this.f); ++i2) {
            if (this.e[i2] == '\n') {
                this.h = 1 + this.h;
                this.i = 1;
                continue;
            }
            this.i = 1 + this.i;
        }
        int n6 = this.g;
        if (n6 != n3) {
            this.g = n6 - n3;
            char[] arrc2 = this.e;
            System.arraycopy((Object)arrc2, (int)n3, (Object)arrc2, (int)0, (int)this.g);
        } else {
            this.g = 0;
        }
        this.f = 0;
        while ((n4 = (reader = this.c).read(arrc = this.e, n5 = this.g, arrc.length - n5)) != -1) {
            int n7;
            this.g = n4 + this.g;
            if (this.h == 1 && (n7 = this.i) == 1 && this.g > 0 && this.e[0] == '\ufeff') {
                this.f = 1 + this.f;
                this.i = n7 - 1;
            }
            if (this.g < n2) continue;
            return true;
        }
        return false;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private bx b(boolean var1_1) {
        if (var1_1) {
            if (this.y() == 125) {
                this.u();
                this.k = var8_2 = bx.d;
                return var8_2;
            }
            this.f = -1 + this.f;
        } else {
            var2_3 = this.y();
            if (var2_3 != 44 && var2_3 != 59) {
                if (var2_3 != 125) throw this.d("Unterminated object");
                this.u();
                this.k = var6_4 = bx.d;
                return var6_4;
            }
        }
        var3_5 = this.y();
        if (var3_5 == 34) ** GOTO lbl23
        if (var3_5 != 39) {
            this.z();
            this.f = -1 + this.f;
            this.l = this.c(false);
            if (this.l.length() == 0) throw this.d("Expected name");
        } else {
            this.z();
lbl23: // 2 sources:
            this.l = this.a((char)var3_5);
        }
        this.b(bv.d);
        this.k = var4_6 = bx.e;
        return var4_6;
    }

    private void b(bv bv2) {
        List list = this.j;
        list.set(-1 + list.size(), (Object)bv2);
    }

    /*
     * Exception decompiling
     */
    private String c(boolean var1_1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Extractable last case doesn't follow previous
        // org.benf.cfr.reader.b.a.a.b.as.a(SwitchReplacer.java:478)
        // org.benf.cfr.reader.b.a.a.b.as.a(SwitchReplacer.java:61)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:372)
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

    private IOException d(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(" at line ");
        stringBuilder.append(this.w());
        stringBuilder.append(" column ");
        stringBuilder.append(this.x());
        throw new bz(stringBuilder.toString());
    }

    private bx t() {
        this.k();
        bx bx2 = this.k;
        this.k = null;
        this.m = null;
        this.l = null;
        return bx2;
    }

    private bv u() {
        List list = this.j;
        return (bv)((Object)list.remove(-1 + list.size()));
    }

    private bx v() {
        bx bx2;
        int n2;
        block10 : {
            block11 : {
                bx bx3;
                block12 : {
                    bx bx4;
                    block13 : {
                        block14 : {
                            bx bx5;
                            block17 : {
                                block15 : {
                                    block22 : {
                                        block24 : {
                                            int n3;
                                            int n4;
                                            int n5;
                                            block23 : {
                                                char c2;
                                                char[] arrc;
                                                block21 : {
                                                    char c3;
                                                    int n6;
                                                    block20 : {
                                                        block19 : {
                                                            int n7;
                                                            char[] arrc2;
                                                            char[] arrc3;
                                                            int n8;
                                                            int n9;
                                                            char[] arrc4;
                                                            int n10;
                                                            int n11;
                                                            char[] arrc5;
                                                            char[] arrc6;
                                                            block18 : {
                                                                char[] arrc7;
                                                                int n12;
                                                                int n13;
                                                                char[] arrc8;
                                                                int n14;
                                                                char[] arrc9;
                                                                int n15;
                                                                char[] arrc10;
                                                                block16 : {
                                                                    int n16;
                                                                    char[] arrc11;
                                                                    char[] arrc12;
                                                                    char[] arrc13;
                                                                    int n17;
                                                                    char[] arrc14;
                                                                    int n18;
                                                                    n2 = this.y();
                                                                    if (n2 == 34) break block10;
                                                                    if (n2 == 39) break block11;
                                                                    if (n2 == 91) break block12;
                                                                    if (n2 == 123) break block13;
                                                                    --this.f;
                                                                    this.m = this.c(true);
                                                                    int n19 = this.o;
                                                                    if (n19 == 0) break block14;
                                                                    int n20 = this.n;
                                                                    if (n20 == -1) break block15;
                                                                    if (n19 != 4 || 'n' != (arrc14 = this.e)[n20] && 'N' != arrc14[n20] || 'u' != (arrc11 = this.e)[(n17 = this.n) + 1] && 'U' != arrc11[n17 + 1] || 'l' != (arrc13 = this.e)[(n18 = this.n) + 2] && 'L' != arrc13[n18 + 2] || 'l' != (arrc12 = this.e)[(n16 = this.n) + 3] && 'L' != arrc12[n16 + 3]) break block16;
                                                                    this.m = "null";
                                                                    bx5 = bx.i;
                                                                    break block17;
                                                                }
                                                                if (this.o != 4 || 't' != (arrc10 = this.e)[n15 = this.n] && 'T' != arrc10[n15] || 'r' != (arrc9 = this.e)[(n12 = this.n) + 1] && 'R' != arrc9[n12 + 1] || 'u' != (arrc7 = this.e)[(n13 = this.n) + 2] && 'U' != arrc7[n13 + 2] || 'e' != (arrc8 = this.e)[(n14 = this.n) + 3] && 'E' != arrc8[n14 + 3]) break block18;
                                                                this.m = "true";
                                                                bx5 = bx.h;
                                                                break block17;
                                                            }
                                                            if (this.o != 5 || 'f' != (arrc3 = this.e)[n9 = this.n] && 'F' != arrc3[n9] || 'a' != (arrc4 = this.e)[(n11 = this.n) + 1] && 'A' != arrc4[n11 + 1] || 'l' != (arrc5 = this.e)[(n7 = this.n) + 2] && 'L' != arrc5[n7 + 2] || 's' != (arrc6 = this.e)[(n10 = this.n) + 3] && 'S' != arrc6[n10 + 3] || 'e' != (arrc2 = this.e)[(n8 = this.n) + 4] && 'E' != arrc2[n8 + 4]) break block19;
                                                            this.m = "false";
                                                            bx5 = bx.h;
                                                            break block17;
                                                        }
                                                        this.m = this.b.a(this.e, this.n, this.o);
                                                        arrc = this.e;
                                                        n3 = this.n;
                                                        n5 = this.o;
                                                        c3 = arrc[n3];
                                                        if (c3 == '-') {
                                                            int n21 = n3 + 1;
                                                            char c4 = arrc[n21];
                                                            n6 = n21;
                                                            c3 = c4;
                                                        } else {
                                                            n6 = n3;
                                                        }
                                                        if (c3 != '0') break block20;
                                                        n4 = n6 + 1;
                                                        c2 = arrc[n4];
                                                        break block21;
                                                    }
                                                    if (c3 >= '1' && c3 <= '9') {
                                                        n4 = n6 + 1;
                                                        c2 = arrc[n4];
                                                        while (c2 >= '0' && c2 <= '9') {
                                                            c2 = arrc[++n4];
                                                        }
                                                    }
                                                    break block22;
                                                }
                                                if (c2 == '.') {
                                                    c2 = arrc[++n4];
                                                    while (c2 >= '0' && c2 <= '9') {
                                                        c2 = arrc[++n4];
                                                    }
                                                }
                                                if (c2 != 'e' && c2 != 'E') break block23;
                                                int n22 = n4 + 1;
                                                char c5 = arrc[n22];
                                                if (c5 == '+' || c5 == '-') {
                                                    c5 = arrc[++n22];
                                                }
                                                if (c5 >= '0' && c5 <= '9') {
                                                    n4 = n22 + 1;
                                                    char c6 = arrc[n4];
                                                    while (c6 >= '0' && c6 <= '9') {
                                                        c6 = arrc[++n4];
                                                    }
                                                }
                                                break block24;
                                            }
                                            if (n4 != n3 + n5) break block15;
                                            bx5 = bx.g;
                                            break block17;
                                        }
                                        bx5 = bx.f;
                                        break block17;
                                    }
                                    bx5 = bx.f;
                                    break block17;
                                }
                                bx5 = bx.f;
                            }
                            this.k = bx5;
                            if (this.k == bx.f) {
                                this.z();
                            }
                            return this.k;
                        }
                        throw this.d("Expected literal value");
                    }
                    this.a(bv.c);
                    this.k = bx4 = bx.c;
                    return bx4;
                }
                this.a(bv.a);
                this.k = bx3 = bx.a;
                return bx3;
            }
            this.z();
        }
        this.m = this.a((char)n2);
        this.k = bx2 = bx.f;
        return bx2;
    }

    private int w() {
        int n2 = this.h;
        for (int i2 = 0; i2 < this.f; ++i2) {
            if (this.e[i2] != '\n') continue;
            ++n2;
        }
        return n2;
    }

    private int x() {
        int n2 = this.i;
        for (int i2 = 0; i2 < this.f; ++i2) {
            if (this.e[i2] == '\n') {
                n2 = 1;
                continue;
            }
            ++n2;
        }
        return n2;
    }

    private int y() {
        do {
            int n2 = this.f;
            int n3 = this.g;
            int n4 = 1;
            if (n2 >= n3 && !this.a(n4)) {
                throw new EOFException("End of input");
            }
            char[] arrc = this.e;
            int n5 = this.f;
            this.f = n5 + 1;
            char c2 = arrc[n5];
            if (c2 == '\t' || c2 == '\n' || c2 == '\r' || c2 == ' ') continue;
            if (c2 != '#') {
                if (c2 != '/') {
                    return c2;
                }
                if (this.f == this.g && !this.a(n4)) {
                    return c2;
                }
                this.z();
                char[] arrc2 = this.e;
                int n6 = this.f;
                char c3 = arrc2[n6];
                if (c3 != '*') {
                    if (c3 != '/') {
                        return c2;
                    }
                    this.f = n6 + 1;
                    this.A();
                    continue;
                }
                this.f = n6 + 1;
                block1 : do {
                    int n7 = 2 + this.f;
                    int n8 = this.g;
                    int n9 = 0;
                    if (n7 > n8) {
                        if (this.a(2)) {
                            n9 = 0;
                        } else {
                            n4 = 0;
                            break;
                        }
                    }
                    while (n9 < 2) {
                        if (this.e[n9 + this.f] == "*/".charAt(n9)) {
                            ++n9;
                            continue;
                        }
                        this.f = n4 + this.f;
                        continue block1;
                    }
                    break;
                } while (true);
                if (n4 != 0) {
                    this.f = 2 + this.f;
                    continue;
                }
                throw this.d("Unterminated comment");
            }
            this.z();
            this.A();
        } while (true);
    }

    private void z() {
        if (this.d) {
            return;
        }
        throw this.d("Use JsonReader.setLenient(true) to accept malformed JSON");
    }

    @Override
    public final void close() {
        this.m = null;
        this.k = null;
        this.j.clear();
        this.j.add((Object)bv.h);
        this.c.close();
    }

    @Override
    public final void f() {
        this.a(bx.a);
    }

    @Override
    public final void g() {
        this.a(bx.b);
    }

    @Override
    public final void h() {
        this.a(bx.c);
    }

    @Override
    public final void i() {
        this.a(bx.d);
    }

    @Override
    public final boolean j() {
        this.k();
        return this.k != bx.d && this.k != bx.b;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final bx k() {
        bx bx2 = this.k;
        if (bx2 != null) {
            return bx2;
        }
        int[] arrn = 2.a;
        List list = this.j;
        switch (arrn[((bv)((Object)list.get(list.size() - 1))).ordinal()]) {
            default: {
                throw new AssertionError();
            }
            case 8: {
                throw new IllegalStateException("JsonReader is closed");
            }
            case 7: {
                try {
                    bx bx3 = this.v();
                    if (this.d) {
                        return bx3;
                    }
                    throw this.d("Expected EOF");
                }
                catch (EOFException eOFException) {
                    bx bx4;
                    this.k = bx4 = bx.j;
                    return bx4;
                }
            }
            case 6: {
                return this.b(false);
            }
            case 5: {
                int n2 = this.y();
                if (n2 != 58) {
                    int n3;
                    char[] arrc;
                    if (n2 != 61) {
                        throw this.d("Expected ':'");
                    }
                    this.z();
                    if ((this.f < this.g || this.a(1)) && (arrc = this.e)[n3 = this.f] == '>') {
                        this.f = n3 + 1;
                    }
                }
                this.b(bv.e);
                return this.v();
            }
            case 4: {
                return this.b(true);
            }
            case 3: {
                return this.a(false);
            }
            case 2: {
                return this.a(true);
            }
            case 1: 
        }
        this.b(bv.g);
        bx bx5 = this.v();
        if (!this.d && this.k != bx.a) {
            if (this.k == bx.c) {
                return bx5;
            }
            StringBuilder stringBuilder = new StringBuilder("Expected JSON document to start with '[' or '{' but was ");
            stringBuilder.append((Object)this.k);
            throw new IOException(stringBuilder.toString());
        }
        return bx5;
    }

    @Override
    public final String l() {
        this.k();
        if (this.k == bx.e) {
            String string = this.l;
            this.t();
            return string;
        }
        StringBuilder stringBuilder = new StringBuilder("Expected a name but was ");
        stringBuilder.append((Object)this.k());
        throw new IllegalStateException(stringBuilder.toString());
    }

    @Override
    public final String m() {
        this.k();
        if (this.k != bx.f && this.k != bx.g) {
            StringBuilder stringBuilder = new StringBuilder("Expected a string but was ");
            stringBuilder.append((Object)this.k());
            throw new IllegalStateException(stringBuilder.toString());
        }
        String string = this.m;
        this.t();
        return string;
    }

    @Override
    public final boolean n() {
        this.k();
        if (this.k == bx.h) {
            boolean bl = this.m == "true";
            this.t();
            return bl;
        }
        StringBuilder stringBuilder = new StringBuilder("Expected a boolean but was ");
        stringBuilder.append((Object)this.k);
        throw new IllegalStateException(stringBuilder.toString());
    }

    @Override
    public final void o() {
        this.k();
        if (this.k == bx.i) {
            this.t();
            return;
        }
        StringBuilder stringBuilder = new StringBuilder("Expected null but was ");
        stringBuilder.append((Object)this.k);
        throw new IllegalStateException(stringBuilder.toString());
    }

    @Override
    public final double p() {
        this.k();
        if (this.k != bx.f && this.k != bx.g) {
            StringBuilder stringBuilder = new StringBuilder("Expected a double but was ");
            stringBuilder.append((Object)this.k);
            throw new IllegalStateException(stringBuilder.toString());
        }
        double d2 = Double.parseDouble((String)this.m);
        this.t();
        return d2;
    }

    /*
     * Exception decompiling
     */
    @Override
    public final long q() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl48 : ALOAD_0 : trying to set 1 previously set to 0
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

    /*
     * Exception decompiling
     */
    @Override
    public final int r() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl48 : ALOAD_0 : trying to set 1 previously set to 0
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

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final void s() {
        this.k();
        if (this.k == bx.b || this.k == bx.d) {
            StringBuilder stringBuilder = new StringBuilder("Expected a value but was ");
            stringBuilder.append((Object)this.k);
            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
            throw illegalStateException;
        }
        this.p = true;
        int n2 = 0;
        try {
            do {
                bx bx3;
                if ((bx3 = this.t()) != bx.a && bx3 != bx.c) {
                    bx bx2;
                    if (bx3 != bx.b && bx3 != (bx2 = bx.d)) continue;
                    --n2;
                    continue;
                }
                ++n2;
            } while (n2 != 0);
            return;
        }
        finally {
            this.p = false;
        }
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getClass().getSimpleName());
        stringBuilder.append(" near ");
        StringBuilder stringBuilder2 = new StringBuilder();
        int n2 = Math.min((int)this.f, (int)20);
        stringBuilder2.append(this.e, this.f - n2, n2);
        int n3 = Math.min((int)(this.g - this.f), (int)20);
        stringBuilder2.append(this.e, this.f, n3);
        stringBuilder.append((Object)stringBuilder2);
        return stringBuilder.toString();
    }
}


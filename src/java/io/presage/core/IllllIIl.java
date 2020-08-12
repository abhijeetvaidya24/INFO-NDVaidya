/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.presage.core.IIlIIllI
 *  io.presage.core.IllllIIl$1
 *  io.presage.core.IlllllII
 *  io.presage.core.lIIIllII
 *  java.io.File
 *  java.io.FileFilter
 *  java.io.FileOutputStream
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Thread
 *  java.util.ArrayList
 */
package io.presage.core;

import io.presage.core.IIlIIllI;
import io.presage.core.IllllIIl;
import io.presage.core.IlllllII;
import io.presage.core.lIIIllII;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

public abstract class IllllIIl {
    public File IIIIIIII;
    ArrayList<File> IIIIIIIl;
    private int IIIIIIlI;

    public IllllIIl(File file) {
        if (file != null) {
            if (!file.exists() && !file.mkdirs()) {
                throw new IOException();
            }
            this.IIIIIIII = file;
            this.IIIIIIlI = Math.min((int)Math.max((int)10, (int)10), (int)10);
            this.IIIIIIIl = new ArrayList();
            return;
        }
        throw new IOException();
    }

    static void IIIIIIII(IIIIIIII iIIIIIII) {
        if (iIIIIIII != null) {
            iIIIIIII.IIIIIIIl();
        }
    }

    private void IIIIIIlI() {
        File[] arrfile = this.IIIIIIII(false);
        Object[] arrobject = new Object[]{arrfile.length, this.IIIIIIlI};
        int n2 = Math.max((int)0, (int)(arrfile.length - (this.IIIIIIlI - 1)));
        for (int i2 = 0; i2 < n2; ++i2) {
            lIIIllII.IIIIIIII((File)arrfile[i2]);
        }
    }

    protected abstract String IIIIIIII();

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void IIIIIIII(IIlIIllI iIlIIllI, byte[] arrby, IIIIIIII iIIIIIII) {
        boolean bl2;
        try {
            Object[] arrobject = new Object[]{Thread.currentThread().getId(), Thread.currentThread().getName()};
        }
        catch (Exception exception) {
            new IllegalArgumentException();
            IllllIIl.IIIIIIII(iIIIIIII);
            return;
        }
        if (arrby != null && arrby.length != 0 && !(bl2 = lIIIllII.IIIIIIIl((File)this.IIIIIIII) < lIIIllII.IIIIIIII)) {
            File[] arrfile = this.IIIIIIII(false);
            boolean bl3 = arrfile != null && arrfile.length >= this.IIIIIIlI;
            if (bl3) {
                this.IIIIIIlI();
            }
            File file = this.IIIIIIII;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.IIIIIIII());
            stringBuilder.append(System.currentTimeMillis());
            stringBuilder.append(this.IIIIIIIl());
            File file2 = new File(file, stringBuilder.toString());
            this.IIIIIIIl.add((Object)file2);
            new IlllllII((OutputStream)new FileOutputStream(file2, true), true, (IlllllII.IIIIIIII)new 1(this, file2, iIIIIIII)).IIIIIIII(iIlIIllI, false, (Object[])new byte[][]{arrby});
            return;
        }
        new IllegalArgumentException();
        IllllIIl.IIIIIIII(iIIIIIII);
    }

    public final File[] IIIIIIII(boolean bl2) {
        FileFilter fileFilter = new FileFilter(){

            public final boolean accept(File file) {
                if (IllllIIl.this.IIIIIIIl.contains((Object)file)) {
                    new Object[1][0] = file.getAbsolutePath();
                }
                return !IllllIIl.this.IIIIIIIl.contains((Object)file);
            }
        };
        File[] arrfile = this.IIIIIIII.listFiles(fileFilter);
        if (arrfile == null) {
            return new File[0];
        }
        lIIIllII.IIIIIIII((File[])arrfile, (boolean)bl2);
        return arrfile;
    }

    protected abstract String IIIIIIIl();

    public static interface IIIIIIII {
        public void IIIIIIII();

        public void IIIIIIIl();
    }

}


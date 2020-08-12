/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  io.presage.core.IIlIIllI
 *  io.presage.core.IlllIlll$1
 *  io.presage.core.IlllllII
 *  io.presage.core.lIIIlIlI
 *  io.presage.core.lIIIlIlI$IIIlIlII
 *  io.presage.core.lIIIllII
 *  io.presage.core.lIIIllll
 *  java.io.File
 *  java.io.FileFilter
 *  java.io.FileOutputStream
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.ArrayList
 *  java.util.Collections
 *  java.util.Iterator
 *  java.util.List
 *  java.util.regex.Matcher
 *  java.util.regex.Pattern
 */
package io.presage.core;

import android.content.Context;
import android.content.SharedPreferences;
import io.presage.core.IIlIIIll;
import io.presage.core.IIlIIlIl;
import io.presage.core.IIlIIllI;
import io.presage.core.IlllIlll;
import io.presage.core.IllllIII;
import io.presage.core.IlllllII;
import io.presage.core.lIIIIIlI;
import io.presage.core.lIIIIlII;
import io.presage.core.lIIIlIlI;
import io.presage.core.lIIIllII;
import io.presage.core.lIIIllll;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class IlllIlll {
    private static final String IIIIIIII = lIIIIIlI.IIIIIllI.IIIIIIII;
    private static final String IIIIIIIl = lIIIlIlI.IIIlIlII.IIIIIIII;
    private static long IIIIIllI = 0xA00000L;
    protected File IIIIIIlI;
    public File IIIIIIll;
    public IIIIIIII IIIIIlII;
    protected List<IIIIIIIl> IIIIIlIl;
    private SharedPreferences IIIIIlll;
    private long IIIIlIII;
    private long IIIIlIIl;
    private int IIIIlIlI;

    public IlllIlll(Context context, File file, int n2, long l2) {
        if (file != null) {
            if (!file.exists() && !file.mkdirs()) {
                throw new IOException();
            }
            this.IIIIIIll = file;
            this.IIIIIlll = context.getSharedPreferences(this.IIIIIIlI(), 0);
            this.IIIIIIlI = this.IIIIIlll();
            this.IIIIlIlI = Math.min((int)Math.max((int)n2, (int)this.IIIIIIll()), (int)100);
            this.IIIIlIIl = Math.min((long)Math.max((long)l2, (long)this.IIIIIlIl()), (long)this.IIIIIlII());
            this.IIIIIlIl = Collections.synchronizedList((List)new ArrayList());
            Object[] arrobject = new Object[]{this.IIIIlIIl, l2};
            this.IIIIlIII = this.IIIIIlll.getLong(IIIIIIII, -1L);
            return;
        }
        throw new IOException();
    }

    static /* synthetic */ String IIIIIIII(IlllIlll illlIlll) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(illlIlll.IIIIIIII());
        stringBuilder.append(IIIIIIIl);
        stringBuilder.append(illlIlll.IIIIIIIl());
        return stringBuilder.toString();
    }

    private long IIIIllIl() {
        File file = this.IIIIIIlI;
        if (file == null) {
            return 0L;
        }
        return file.length();
    }

    protected abstract String IIIIIIII();

    public final void IIIIIIII(IIlIIllI iIlIIllI, byte[] arrby, IIIIIIlI iIIIIIlI) {
        this.IIIIIlIl.add((Object)new IIIIIIIl(iIlIIllI, arrby, iIIIIIlI));
        new Object[1][0] = this.IIIIIlIl.size();
        if (this.IIIIIlIl.size() == 1) {
            this.IIIIIIII((IIIIIIIl)this.IIIIIlIl.get(0));
        }
    }

    protected void IIIIIIII(IIIIIIIl iIIIIIIl) {
        new Object[1][0] = this.IIIIIlIl.size();
        if (iIIIIIIl.IIIIIIlI != null && iIIIIIIl.IIIIIIlI.length != 0) {
            if (this.IIIIlIll()) {
                if (iIIIIIIl.IIIIIIIl) {
                    lIIIIlII.IIIIIIII((IIlIIlIl)iIIIIIIl.IIIIIIII);
                }
                this.IIIIIIII(iIIIIIIl.IIIIIIll, false, new IllllIII(), 0);
                return;
            }
            if (this.IIIIlIIl() || this.IIIIlIlI()) {
                File file = new File(this.IIIIIIlI.getAbsolutePath());
                this.IIIIIIlI = this.IIIIIllI();
                this.IIIIIIII(file);
                if (this.IIIIlIII()) {
                    this.IIIIllII();
                }
            }
            try {
                IlllllII illlllII = new IlllllII((OutputStream)new FileOutputStream(this.IIIIIIlI, true), true, (IlllllII.IIIIIIII)new 1(this, iIIIIIIl));
                IIlIIllI iIlIIllI = iIIIIIIl.IIIIIIII;
                boolean bl2 = iIIIIIIl.IIIIIIIl;
                byte[][] arrarrby = new byte[][]{iIIIIIIl.IIIIIIlI};
                illlllII.IIIIIIII(iIlIIllI, bl2, (Object[])arrarrby);
                return;
            }
            catch (Exception exception) {
                if (iIIIIIIl.IIIIIIIl) {
                    lIIIIlII.IIIIIIII((IIlIIlIl)iIIIIIIl.IIIIIIII);
                }
                this.IIIIIIII(iIIIIIIl.IIIIIIll, false, exception, 1);
                return;
            }
            catch (IIlIIIll iIlIIIll) {
                if (iIIIIIIl.IIIIIIIl) {
                    lIIIIlII.IIIIIIII((IIlIIlIl)iIIIIIIl.IIIIIIII);
                }
                this.IIIIIIII(iIIIIIIl.IIIIIIll, false, iIlIIIll, 0);
                return;
            }
        }
        if (iIIIIIIl.IIIIIIIl) {
            lIIIIlII.IIIIIIII((IIlIIlIl)iIIIIIIl.IIIIIIII);
        }
        this.IIIIIIII(iIIIIIIl.IIIIIIll, false, (Exception)new IllegalArgumentException(), 0);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected final void IIIIIIII(IIIIIIlI iIIIIIlI, boolean bl2, Exception exception, int n2) {
        List<IIIIIIIl> list;
        if (iIIIIIlI != null) {
            iIIIIIlI.IIIIIIII(bl2, exception, n2);
        }
        List<IIIIIIIl> list2 = list = this.IIIIIlIl;
        synchronized (list2) {
            Iterator iterator = this.IIIIIlIl.iterator();
            if (iterator.hasNext()) {
                iterator.next();
                iterator.remove();
            }
        }
        new Object[1][0] = this.IIIIIlIl.size();
        if (this.IIIIIlIl.size() > 0) {
            this.IIIIIIII((IIIIIIIl)this.IIIIIlIl.get(0));
        }
    }

    protected final void IIIIIIII(File file) {
        IIIIIIII iIIIIIII = this.IIIIIlII;
        if (iIIIIIII != null) {
            iIIIIIII.IIIIIIII(file);
        }
    }

    public final File[] IIIIIIII(boolean bl2) {
        FileFilter fileFilter = new FileFilter(){

            public final boolean accept(File file) {
                return IlllIlll.this.IIIIIIlI == null || !file.getAbsolutePath().equals((Object)IlllIlll.this.IIIIIIlI.getAbsolutePath());
                {
                }
            }
        };
        File[] arrfile = this.IIIIIIll.listFiles(fileFilter);
        if (arrfile == null) {
            return new File[0];
        }
        lIIIllII.IIIIIIII((File[])arrfile, (boolean)bl2);
        return arrfile;
    }

    protected abstract String IIIIIIIl();

    protected abstract String IIIIIIlI();

    protected abstract int IIIIIIll();

    protected abstract long IIIIIlII();

    protected abstract long IIIIIlIl();

    protected final File IIIIIllI() {
        long l2 = System.currentTimeMillis();
        SharedPreferences.Editor editor = this.IIIIIlll.edit();
        editor.putLong(IIIIIIII, l2);
        editor.apply();
        this.IIIIlIII = l2;
        File file = this.IIIIIIll;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.IIIIIIII());
        stringBuilder.append(System.currentTimeMillis());
        stringBuilder.append(this.IIIIIIIl());
        return new File(file, stringBuilder.toString());
    }

    protected final File IIIIIlll() {
        File[] arrfile = this.IIIIIIll.listFiles(new FileFilter(){

            public final boolean accept(File file) {
                if (file == null) {
                    return false;
                }
                String string2 = file.getName();
                return Pattern.compile((String)IlllIlll.IIIIIIII(IlllIlll.this)).matcher((CharSequence)string2).matches();
            }
        });
        if (arrfile != null && arrfile.length != 0) {
            lIIIllII.IIIIIIII((File[])arrfile, (boolean)true);
            return arrfile[0];
        }
        return this.IIIIIllI();
    }

    protected final boolean IIIIlIII() {
        if (this.IIIIIIII(false) == null) {
            return false;
        }
        int n2 = this.IIIIIIII(false).length;
        int n3 = this.IIIIlIlI;
        boolean bl2 = false;
        if (n2 > n3) {
            bl2 = true;
        }
        return bl2;
    }

    protected final boolean IIIIlIIl() {
        Object[] arrobject = new Object[3];
        boolean bl2 = this.IIIIllIl() > this.IIIIlIIl;
        arrobject[0] = bl2;
        arrobject[1] = this.IIIIllIl();
        arrobject[2] = this.IIIIlIIl;
        return this.IIIIllIl() > this.IIIIlIIl;
    }

    protected final boolean IIIIlIlI() {
        Object[] arrobject = new Object[2];
        boolean bl2 = System.currentTimeMillis() - this.IIIIlIII > 86400000L;
        arrobject[0] = bl2;
        arrobject[1] = lIIIllll.IIIIIIII((long)(86400000L + this.IIIIlIII));
        return System.currentTimeMillis() - this.IIIIlIII > 86400000L;
    }

    protected final boolean IIIIlIll() {
        return lIIIllII.IIIIIIIl((File)this.IIIIIIll) < IIIIIllI;
    }

    protected final void IIIIllII() {
        File[] arrfile = this.IIIIIIII(false);
        int n2 = Math.max((int)0, (int)(arrfile.length - this.IIIIlIlI));
        for (int i2 = 0; i2 < n2; ++i2) {
            lIIIllII.IIIIIIII((File)arrfile[i2]);
        }
    }

    public static interface IIIIIIII {
        public void IIIIIIII(File var1);
    }

    public final class IIIIIIIl {
        IIlIIllI IIIIIIII;
        boolean IIIIIIIl;
        byte[] IIIIIIlI;
        IIIIIIlI IIIIIIll;

        public IIIIIIIl(IIlIIllI iIlIIllI, byte[] arrby, IIIIIIlI iIIIIIlI) {
            this.IIIIIIII = iIlIIllI;
            this.IIIIIIIl = false;
            this.IIIIIIlI = arrby;
            this.IIIIIIll = iIIIIIlI;
        }
    }

    public static interface IIIIIIlI {
        public void IIIIIIII(boolean var1, Exception var2, int var3);
    }

}


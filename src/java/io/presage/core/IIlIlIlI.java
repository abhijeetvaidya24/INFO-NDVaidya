/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  io.presage.core.IIlIIllI
 *  io.presage.core.IIlIlIII
 *  io.presage.core.IIlIlIlI$2
 *  io.presage.core.IIlIlIlI$3
 *  io.presage.core.IIlIlIlI$4
 *  io.presage.core.IllIlIIl
 *  io.presage.core.IlllIllI
 *  io.presage.core.lIIIlIII
 *  java.io.File
 *  java.io.FileInputStream
 *  java.io.FileNotFoundException
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Set
 */
package io.presage.core;

import android.content.Context;
import io.presage.core.IIlIIllI;
import io.presage.core.IIlIlIII;
import io.presage.core.IIlIlIIl;
import io.presage.core.IIlIlIlI;
import io.presage.core.IIlIlIll;
import io.presage.core.IIlIllII;
import io.presage.core.IlIlllll;
import io.presage.core.IllIIIIl;
import io.presage.core.IllIIlIl;
import io.presage.core.IllIIlll;
import io.presage.core.IllIlIIl;
import io.presage.core.IlllIllI;
import io.presage.core.IlllIlll;
import io.presage.core.lIIIlIII;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

public final class IIlIlIlI {
    public Context IIIIIIII;
    public boolean IIIIIIIl;
    public File IIIIIIlI;
    public File IIIIIIll;
    public IIlIllII IIIIIlII;
    public IlllIllI IIIIIlIl;

    public IIlIlIlI(Context context, File file, File file2) {
        if (!file.exists() && !file.mkdirs()) {
            throw new IIlIlIll();
        }
        if (!file2.exists() && !file2.mkdirs()) {
            throw new IIlIlIll();
        }
        this.IIIIIIII = context;
        this.IIIIIIlI = file;
        this.IIIIIIll = file2;
    }

    public final void IIIIIIII() {
        IIlIlIll iIlIlIll;
        if (this.IIIIIlII.IIIIIlII != null) {
            for (IIlIlIIl iIlIlIIl : this.IIIIIlII.IIIIIlII) {
                try {
                    iIlIlIIl.IIIIIIII(this.IIIIIlII.IIIIIIll, this.IIIIIIll, (IIlIlIIl.IIIIIIII)new 2(this));
                }
                catch (IOException iOException) {
                    IlIlllll.IIIIIIII((Exception)((Object)iOException), 1);
                }
            }
            return;
        }
        iIlIlIll = new IIlIlIll();
        throw iIlIlIll;
    }

    final void IIIIIIII(File file) {
        if (this.IIIIIIIl && this.IIIIIlII != null) {
            new Object[1][0] = file;
            try {
                if (!lIIIlIII.IIIIIIIl((Context)this.IIIIIIII)) {
                    return;
                }
                IllIIlll illIIlll = new IllIIlll(this.IIIIIlII.IIIIlIIl, IllIIlll.IIIIIIII, (IllIIlIl)new IllIlIIl(this.IIIIIIII, this.IIIIIlII.IIIIIllI, this.IIIIIlII.IIIIIlll, this.IIIIIlII.IIIIlIII), (InputStream)new FileInputStream(file));
                IllIIIIl.IIIIIIII(this.IIIIIlII.IIIIIlIl, illIIlll, (IllIIIIl.IIIIIIII)new 4(this, file));
                return;
            }
            catch (FileNotFoundException fileNotFoundException) {
                IlIlllll.IIIIIIII((Exception)((Object)fileNotFoundException), 0);
            }
        }
    }

    final void IIIIIIII(byte[] arrby) {
        IlllIllI illlIllI;
        if (this.IIIIIIIl && (illlIllI = this.IIIIIlIl) != null) {
            illlIllI.IIIIIIII(this.IIIIIlII.IIIIIIII, arrby, (IlllIlll.IIIIIIlI)new 3(this));
        }
    }

    public final void IIIIIIII(File[] arrfile) {
        if (arrfile.length > 0) {
            int n2 = arrfile.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                this.IIIIIIII(arrfile[i2]);
            }
        }
    }
}


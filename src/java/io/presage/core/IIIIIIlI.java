/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  io.presage.core.IIIIIIlI$1
 *  io.presage.core.IIIIIIlI$2
 *  io.presage.core.IIlIIllI
 *  io.presage.core.IllIlIll
 *  io.presage.core.IllllIll
 *  io.presage.core.IlllllII
 *  io.presage.core.lIIIIllI
 *  io.presage.core.lIIIlIlI
 *  io.presage.core.lIIIlIlI$IIlIlIIl
 *  io.presage.core.lIIIllII
 *  io.presage.core.lIIlIlll
 *  java.io.File
 *  java.io.FileInputStream
 *  java.io.FileOutputStream
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.Boolean
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.Void
 *  org.json.JSONObject
 */
package io.presage.core;

import android.content.Context;
import android.content.SharedPreferences;
import io.presage.core.CoreSdkType;
import io.presage.core.IIIIIIlI;
import io.presage.core.IIlIIIll;
import io.presage.core.IIlIIllI;
import io.presage.core.IIlIIlll;
import io.presage.core.IlIlllll;
import io.presage.core.IllIlIll;
import io.presage.core.IllIllII;
import io.presage.core.IllIlllI;
import io.presage.core.IllllIll;
import io.presage.core.IlllllII;
import io.presage.core.lIIIIIlI;
import io.presage.core.lIIIIllI;
import io.presage.core.lIIIlIlI;
import io.presage.core.lIIIllII;
import io.presage.core.lIIlIlll;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import org.json.JSONObject;

public final class IIIIIIlI {
    public static final String IIIIIIII;
    public static final String IIIIIIIl;
    static final String IIIIIIlI;
    public static final String IIIIIIll;
    public static final String IIIIIlII;
    public static final String IIIIIlIl;
    public static final String IIIIIllI;
    public static final String IIIIIlll;
    private static final String IIIIllll;
    private static final String IIIlIIII;
    private static final String IIIlIIIl;
    private static final String IIIlIIlI;
    private static final String IIIlIIll;
    public Context IIIIlIII;
    public SharedPreferences IIIIlIIl;
    String IIIIlIlI;
    public String IIIIlIll;
    public Boolean IIIIllII;
    public Boolean IIIIllIl;
    public IllIllII IIIIlllI;
    private CoreSdkType IIIlIlII;
    private IIIIIIII IIIlIlIl;

    static {
        IIIIllll = lIIIIIlI.IIIIllII.IIIIIIII;
        IIIlIIII = lIIIIIlI.IIIIllII.IIIIIIIl;
        IIIIIIII = lIIIIIlI.IIIIllII.IIIIIIlI;
        IIIIIIIl = lIIIIIlI.IIIIllII.IIIIIIll;
        IIIIIIlI = lIIIIIlI.IIIIllII.IIIIIlII;
        IIIIIIll = lIIIIIlI.IIIIllII.IIIIIlIl;
        IIIIIlII = lIIIIIlI.IIIIllII.IIIIIllI;
        IIIIIlIl = lIIIIIlI.IIIIllII.IIIIlIII;
        IIIIIllI = lIIIIIlI.IIIIllII.IIIIlIIl;
        IIIIIlll = lIIIIIlI.IIIIllII.IIIIIlll;
        IIIlIIIl = lIIIlIlI.IIlIlIIl.IIIIIIII;
        IIIlIIlI = lIIIlIlI.IIlIlIIl.IIIIIIIl;
        IIIlIIll = lIIIlIlI.IIIIIIll;
    }

    public IIIIIIlI(Context context) {
        this.IIIIlIII = context;
        this.IIIIlIIl = this.IIIIlIII.getSharedPreferences(IIIIllll, 0);
    }

    public static int IIIIIIII() {
        return 40011;
    }

    static /* synthetic */ Context IIIIIIII(IIIIIIlI iIIIIIlI) {
        return iIIIIIlI.IIIIlIII;
    }

    static /* synthetic */ IllIllII IIIIIIIl(IIIIIIlI iIIIIIlI) {
        return iIIIIIlI.IIIIlllI;
    }

    public static String IIIIIIIl() {
        return "4.0.11";
    }

    static /* synthetic */ void IIIIIIlI(IIIIIIlI iIIIIIlI) {
        iIIIIIlI.IIIIlIlI();
    }

    public static String IIIIIlll() {
        return IIIlIIlI;
    }

    static /* synthetic */ String IIIIlIII() {
        return IIIlIIll;
    }

    static /* synthetic */ String IIIIlIIl() {
        return IIIlIIIl;
    }

    private void IIIIlIlI() {
        IIIIIIII iIIIIIII = this.IIIlIlIl;
        if (iIIIIIII != null) {
            iIIIIIII.IIIIIIII();
        }
    }

    private File IIIIlIll() {
        return new File(this.IIIIlIII.getFilesDir(), IIIlIIII);
    }

    public final void IIIIIIII(IIIIIIII iIIIIIII) {
        this.IIIlIlIl = iIIIIIII;
        File file = this.IIIIlIll();
        if (!file.exists()) {
            this.IIIIlIlI();
            return;
        }
        try {
            IIlIIllI iIlIIllI = IIlIIlll.IIIIIIII().IIIIIIll();
            new IllllIll((InputStream)new FileInputStream(file), (IllllIll.IIIIIIII)new 1(this)).IIIIIIII(iIlIIllI, false, (Object[])new Void[0]);
            return;
        }
        catch (Exception exception) {
            this.IIIIlIlI();
            return;
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public final void IIIIIIII(IllIllII var1_1) {
        try {
            block9 : {
                var6_2 = this.IIIIlIll();
                if (var1_1 == null || var6_2.exists() && !var6_2.canWrite()) break block9;
                var7_3 = new IllIlIll(this.IIIIlIII).IIIIIIII(var1_1);
                var8_4 = "prod".equals((Object)IIIIIIlI.IIIlIIll) != false ? var7_3.toString().getBytes() : new lIIlIlll().IIIIIIII(0).IIIIIIII(lIIIIllI.IIIIIIII((String)IIIIIIlI.IIIlIIIl).getBytes()).IIIIIIII(2).IIIIIIIl(var7_3.toString().getBytes());
                var9_5 = IIlIIlll.IIIIIIII().IIIIIIll();
                new IlllllII((OutputStream)new FileOutputStream(var6_2), true, (IlllllII.IIIIIIII)new 2(this)).IIIIIIII(var9_5, false, (Object[])new byte[][]{var8_4});
                this.IIIIlllI = var1_1;
                return;
            }
            throw new IllIlllI();
        }
        catch (IllIlllI var4_6) {
            ** GOTO lbl22
        }
        catch (Exception var5_7) {
            try {
                throw new IllIlllI(var5_7);
                catch (IIlIIIll var2_8) {
                    throw var2_8;
                }
            }
            catch (IIlIIIll var3_9) {
                IlIlllll.IIIIIIII(var3_9, 0);
                return;
            }
lbl22: // 1 sources:
            IlIlllll.IIIIIIII(var4_6, 1);
            return;
        }
    }

    public final String IIIIIIlI() {
        String string2;
        if (this.IIIIlIIl.contains(IIIIIIlI) && ((string2 = this.IIIIlIlI) == null || string2.isEmpty())) {
            this.IIIIlIlI = this.IIIIlIIl.getString(IIIIIIlI, "");
        }
        return this.IIIIlIlI;
    }

    public final String IIIIIIll() {
        if (this.IIIIlIIl.contains(IIIIIIll)) {
            String string2 = this.IIIIlIll;
            if (string2 == null || string2.isEmpty()) {
                this.IIIIlIll = this.IIIIlIIl.getString(IIIIIIll, "");
            }
            return this.IIIIlIll;
        }
        return "";
    }

    public final boolean IIIIIlII() {
        if (this.IIIIlIIl.contains(IIIIIlII)) {
            if (this.IIIIllII == null) {
                this.IIIIllII = this.IIIIlIIl.getBoolean(IIIIIlII, false);
            }
            return this.IIIIllII;
        }
        return false;
    }

    public final int IIIIIlIl() {
        if (this.IIIlIlII == null) {
            this.IIIlIlII = new CoreSdkType(this.IIIIlIII);
        }
        return this.IIIlIlII.getType();
    }

    public final void IIIIIllI() {
        lIIIllII.IIIIIIII((File)this.IIIIlIll());
        this.IIIIlllI = null;
    }

    static interface IIIIIIII {
        public void IIIIIIII();
    }

}


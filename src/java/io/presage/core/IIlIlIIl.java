/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 *  io.presage.core.IIlIlIII
 *  io.presage.core.lIIIllII
 *  io.presage.core.lIIIllll
 *  java.io.File
 *  java.io.FileNotFoundException
 *  java.io.IOException
 *  java.lang.Exception
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.System
 */
package io.presage.core;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import io.presage.core.IIIIIlIl;
import io.presage.core.IIlIIIll;
import io.presage.core.IIlIlIII;
import io.presage.core.IlIlllll;
import io.presage.core.lIIIIIlI;
import io.presage.core.lIIIllII;
import io.presage.core.lIIIllll;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class IIlIlIIl {
    private static final String IIIIlIII = lIIIIIlI.IIIIIlIl.IIIIIIII;
    protected long IIIIIIII = 3L;
    protected Context IIIIIIIl;
    public boolean IIIIIIlI;
    public int IIIIIIll;
    public long IIIIIlII;
    protected long IIIIIlIl;
    protected IIlIlIII IIIIIllI;
    private IIIIIIII IIIIIlll;
    private File IIIIlIIl;
    private SharedPreferences IIIIlIlI;
    private long IIIIlIll;
    private Handler IIIIllII;

    public IIlIlIIl(Context context, int n2, long l2, long l3) {
        this.IIIIIIIl = context;
        this.IIIIIIll = n2;
        long l4 = 0L;
        this.IIIIIlII = Math.min((long)Math.max((long)l2, (long)l4), (long)8760L);
        if (l3 != l4) {
            l4 = Math.max((long)l3, (long)this.IIIIIIII);
        }
        this.IIIIIlIl = l4;
        this.IIIIIIlI = false;
        this.IIIIlIlI = context.getSharedPreferences(IIIIlIII, 0);
        this.IIIIlIll = this.IIIIlIII();
        this.IIIIllII = new Handler(Looper.getMainLooper()){

            public final void handleMessage(Message message) {
                int n2 = message.what;
                if (n2 != -1) {
                    if (n2 != 0) {
                        if (n2 != 1) {
                            Object[] arrobject = new Object[]{message.what, message.obj.toString()};
                            return;
                        }
                        IIlIlIIl iIlIlIIl = IIlIlIIl.this;
                        IIlIlIIl.IIIIIIII(iIlIlIIl, iIlIlIIl, (IIIIIlIl)message.obj);
                        return;
                    }
                    IIlIlIIl.this.IIIIIlIl();
                    return;
                }
                IlIlllll.IIIIIIII((Exception)((Object)message.obj), message.arg1);
            }
        };
    }

    public static void IIIIIIII(Context context, File file) {
        lIIIllII.IIIIIIII((File)file);
        if (Build.VERSION.SDK_INT >= 24) {
            context.deleteSharedPreferences(IIIIlIII);
            return;
        }
        context.getSharedPreferences(IIIIlIII, 0).edit().clear().apply();
    }

    static /* synthetic */ void IIIIIIII(IIlIlIIl iIlIlIIl, IIlIlIIl iIlIlIIl2, IIIIIlIl iIIIIlIl) {
        if (iIlIlIIl.IIIIIlll != null && iIIIIlIl != null) {
            Object[] arrobject = new Object[]{iIlIlIIl.IIIIIIlI(), lIIIllll.IIIIIIII((long)iIIIIlIl.IIIIIIII)};
            long l2 = iIIIIlIl.IIIIIIII;
            iIlIlIIl.IIIIlIlI.edit().putLong(String.valueOf((int)iIlIlIIl.IIIIIIlI()), l2).apply();
            iIlIlIIl.IIIIlIll = l2;
            iIlIlIIl.IIIIIlll.IIIIIIII(iIlIlIIl2, iIIIIlIl);
        }
    }

    private void IIIIIIII(Object object) {
        Message message = new Message();
        message.what = 1;
        message.obj = object;
        this.IIIIllII.sendMessage(message);
    }

    private void IIIIIIIl(Exception exception, int n2) {
        this.IIIIIIII(exception, n2);
        this.IIIIIllI();
    }

    private long IIIIlIII() {
        if (this.IIIIlIll == 0L) {
            this.IIIIlIll = this.IIIIlIlI.getLong(String.valueOf((int)this.IIIIIIlI()), 0L);
        }
        return this.IIIIlIll;
    }

    protected final File IIIIIIII(String string2) {
        if (string2 != null && !string2.isEmpty()) {
            File file = this.IIIIlIIl;
            if (file != null) {
                File file2 = new File(file, String.valueOf((int)this.IIIIIIlI()));
                if (!file2.exists() && !file2.mkdirs()) {
                    throw new FileNotFoundException();
                }
                return new File(file2, string2);
            }
            throw new FileNotFoundException();
        }
        throw new FileNotFoundException();
    }

    public abstract void IIIIIIII();

    protected final void IIIIIIII(IIIIIlIl iIIIIlIl) {
        if (this.IIIIIIlI) {
            this.IIIIIIII((Object)iIIIIlIl);
        }
    }

    protected final void IIIIIIII(Exception exception) {
        this.IIIIIIII(exception, 1);
    }

    protected final void IIIIIIII(Exception exception, int n2) {
        Message message = new Message();
        message.what = -1;
        message.obj = exception;
        message.arg1 = n2;
        this.IIIIllII.sendMessage(message);
    }

    protected final void IIIIIIII(final Runnable runnable) {
        new Object[1][0] = this.IIIIIIlI();
        IIlIlIII iIlIlIII = this.IIIIIllI;
        if (iIlIlIII != null && !iIlIlIII.isShutdown()) {
            this.IIIIIllI.execute(new Runnable(){

                /*
                 * Enabled aggressive block sorting
                 * Enabled unnecessary exception pruning
                 * Enabled aggressive exception aggregation
                 * Converted monitor instructions to comments
                 * Lifted jumps to return sites
                 */
                public final void run() {
                    try {
                        Object object;
                        Object object2 = object = IIlIlIIl.this.IIIIIIll();
                        // MONITORENTER : object2
                    }
                    catch (Exception exception) {
                        IIlIlIIl.this.IIIIIIII(exception);
                        return;
                    }
                    runnable.run();
                    // MONITOREXIT : object2
                    IIlIlIIl.this.IIIIIllI.IIIIIIII();
                }
            });
            return;
        }
        this.IIIIIIII(new IIlIIIll(), 0);
    }

    /*
     * Enabled aggressive block sorting
     */
    public final boolean IIIIIIII(IIlIlIII iIlIlIII, File file, IIIIIIII iIIIIIII) {
        if (file == null) {
            IOException iOException = new IOException();
            throw iOException;
        }
        if (!file.exists()) {
            if (!file.mkdirs()) throw new IOException();
        }
        if (!file.canWrite()) throw new IOException();
        if (this.IIIIIIlI) return false;
        if (this.IIIIIlII > 0L && this.IIIIlIII() <= System.currentTimeMillis()) {
            if (System.currentTimeMillis() <= this.IIIIlIII() + 3600000L * this.IIIIIlII) return false;
        }
        boolean bl2 = true;
        if (!bl2) {
            return false;
        }
        new Object[1][0] = this.IIIIIIlI();
        this.IIIIIIlI = true;
        this.IIIIlIIl = file;
        this.IIIIIlll = iIIIIIII;
        this.IIIIIllI = iIlIlIII;
        IIlIlIII iIlIlIII2 = this.IIIIIllI;
        if (iIlIlIII2 != null && !iIlIlIII2.isShutdown()) {
            this.IIIIIllI.execute(new Runnable(){

                /*
                 * Enabled aggressive block sorting
                 * Enabled unnecessary exception pruning
                 * Enabled aggressive exception aggregation
                 * Converted monitor instructions to comments
                 * Lifted jumps to return sites
                 */
                public final void run() {
                    try {
                        Object object;
                        Object object2 = object = IIlIlIIl.this.IIIIIIll();
                        // MONITORENTER : object2
                    }
                    catch (Exception exception) {
                        IIlIlIIl.this.IIIIIIIl(exception);
                        return;
                    }
                    IIlIlIIl.this.IIIIIIII();
                    // MONITOREXIT : object2
                    IIlIlIIl.this.IIIIIllI.IIIIIIII();
                }
            });
            return true;
        }
        this.IIIIIIIl(new IIlIIIll(), 0);
        return true;
    }

    public abstract void IIIIIIIl();

    protected final void IIIIIIIl(IIIIIlIl iIIIIlIl) {
        if (this.IIIIIIlI) {
            this.IIIIIIII((Object)iIIIIlIl);
            this.IIIIIllI();
        }
    }

    protected final void IIIIIIIl(Exception exception) {
        this.IIIIIIIl(exception, 1);
    }

    public abstract int IIIIIIlI();

    public abstract Object IIIIIIll();

    public final long IIIIIlII() {
        return this.IIIIIlIl;
    }

    public final void IIIIIlIl() {
        if (this.IIIIIIlI) {
            new Object[1][0] = this.IIIIIIlI();
            IIlIlIII iIlIlIII = this.IIIIIllI;
            if (iIlIlIII != null && !iIlIlIII.isShutdown()) {
                this.IIIIIllI.execute(new Runnable(){

                    /*
                     * Enabled aggressive block sorting
                     * Enabled unnecessary exception pruning
                     * Enabled aggressive exception aggregation
                     * Converted monitor instructions to comments
                     * Lifted jumps to return sites
                     */
                    public final void run() {
                        try {
                            Object object;
                            Object object2 = object = IIlIlIIl.this.IIIIIIll();
                            // MONITORENTER : object2
                        }
                        catch (Exception exception) {
                            IIlIlIIl.this.IIIIIIII(exception);
                            return;
                        }
                        IIlIlIIl.this.IIIIIIIl();
                        // MONITOREXIT : object2
                        IIlIlIIl.this.IIIIIllI.IIIIIIII();
                    }
                });
            } else {
                this.IIIIIIII(new IIlIIIll(), 0);
            }
            this.IIIIIIlI = false;
            this.IIIIIlll = null;
        }
    }

    protected final void IIIIIllI() {
        Message message = new Message();
        message.what = 0;
        this.IIIIllII.sendMessage(message);
    }

    protected final boolean IIIIIlll() {
        return lIIIllII.IIIIIIIl((File)this.IIIIlIIl) < lIIIllII.IIIIIIII;
    }

    public static interface IIIIIIII {
        public void IIIIIIII(IIlIlIIl var1, IIIIIlIl var2);
    }

}


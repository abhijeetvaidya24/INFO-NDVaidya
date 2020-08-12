/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.app.AlarmManager
 *  android.app.PendingIntent
 *  android.bluetooth.BluetoothAdapter
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.HandlerThread
 *  android.os.Looper
 *  android.os.Process
 *  android.os.SystemClock
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.SecurityException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.Date
 *  org.altbeacon.beacon.service.scanner.CycledLeScannerForAndroidO
 *  org.altbeacon.beacon.service.scanner.CycledLeScannerForJellyBeanMr2
 *  org.altbeacon.beacon.service.scanner.CycledLeScannerForLollipop
 */
package org.altbeacon.beacon.service.scanner;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import java.util.Date;
import org.altbeacon.beacon.BeaconManager;
import org.altbeacon.beacon.logging.LogManager;
import org.altbeacon.beacon.service.scanner.CycledLeScanCallback;
import org.altbeacon.beacon.service.scanner.CycledLeScannerForAndroidO;
import org.altbeacon.beacon.service.scanner.CycledLeScannerForJellyBeanMr2;
import org.altbeacon.beacon.service.scanner.CycledLeScannerForLollipop;
import org.altbeacon.beacon.startup.StartupBroadcastReceiver;
import org.altbeacon.bluetooth.BluetoothCrashResolver;

@TargetApi(value=18)
public abstract class CycledLeScanner {
    protected boolean mBackgroundFlag = false;
    protected long mBetweenScanPeriod;
    private BluetoothAdapter mBluetoothAdapter;
    protected final BluetoothCrashResolver mBluetoothCrashResolver;
    protected final Context mContext;
    private long mCurrentScanStartTime = 0L;
    protected final CycledLeScanCallback mCycledLeScanCallback;
    private volatile boolean mDistinctPacketsDetectedPerScan = false;
    protected final Handler mHandler = new Handler(Looper.getMainLooper());
    private long mLastScanCycleEndTime = 0L;
    private long mLastScanCycleStartTime = 0L;
    private boolean mLongScanForcingEnabled = false;
    protected long mNextScanCycleStartTime = 0L;
    protected boolean mRestartNeeded = false;
    private long mScanCycleStopTime = 0L;
    private boolean mScanCyclerStarted = false;
    protected final Handler mScanHandler;
    private long mScanPeriod;
    private final HandlerThread mScanThread;
    private boolean mScanning;
    private boolean mScanningEnabled = false;
    private boolean mScanningLeftOn = false;
    protected boolean mScanningPaused;
    private PendingIntent mWakeUpOperation = null;

    protected CycledLeScanner(Context context, long l2, long l3, boolean bl2, CycledLeScanCallback cycledLeScanCallback, BluetoothCrashResolver bluetoothCrashResolver) {
        this.mScanPeriod = l2;
        this.mBetweenScanPeriod = l3;
        this.mContext = context;
        this.mCycledLeScanCallback = cycledLeScanCallback;
        this.mBluetoothCrashResolver = bluetoothCrashResolver;
        this.mBackgroundFlag = bl2;
        this.mScanThread = new HandlerThread("CycledLeScannerThread");
        this.mScanThread.start();
        this.mScanHandler = new Handler(this.mScanThread.getLooper());
    }

    private boolean checkLocationPermission() {
        return this.checkPermission("android.permission.ACCESS_COARSE_LOCATION") || this.checkPermission("android.permission.ACCESS_FINE_LOCATION");
        {
        }
    }

    private boolean checkPermission(String string) {
        return this.mContext.checkPermission(string, Process.myPid(), Process.myUid()) == 0;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static CycledLeScanner createScanner(Context context, long l2, long l3, boolean bl2, CycledLeScanCallback cycledLeScanCallback, BluetoothCrashResolver bluetoothCrashResolver) {
        boolean bl3;
        boolean bl4;
        block6 : {
            block3 : {
                block4 : {
                    block5 : {
                        block2 : {
                            int n2 = Build.VERSION.SDK_INT;
                            bl4 = false;
                            if (n2 < 18) {
                                LogManager.w("CycledLeScanner", "Not supported prior to API 18.", new Object[0]);
                                return null;
                            }
                            int n3 = Build.VERSION.SDK_INT;
                            bl3 = true;
                            if (n3 >= 21) break block2;
                            LogManager.i("CycledLeScanner", "This is pre Android 5.0.  We are using old scanning APIs", new Object[0]);
                            break block3;
                        }
                        if (Build.VERSION.SDK_INT >= 26) break block4;
                        if (!BeaconManager.isAndroidLScanningDisabled()) break block5;
                        LogManager.i("CycledLeScanner", "This is Android 5.0, but L scanning is disabled. We are using old scanning APIs", new Object[0]);
                        bl4 = false;
                        break block3;
                    }
                    LogManager.i("CycledLeScanner", "This is Android 5.0.  We are using new scanning APIs", new Object[0]);
                    bl4 = false;
                    break block6;
                }
                LogManager.i("CycledLeScanner", "Using Android O scanner", new Object[0]);
                bl4 = true;
            }
            bl3 = false;
        }
        if (bl4) {
            return new CycledLeScannerForAndroidO(context, l2, l3, bl2, cycledLeScanCallback, bluetoothCrashResolver);
        }
        if (!bl3) return new CycledLeScannerForJellyBeanMr2(context, l2, l3, bl2, cycledLeScanCallback, bluetoothCrashResolver);
        return new CycledLeScannerForLollipop(context, l2, l3, bl2, cycledLeScanCallback, bluetoothCrashResolver);
    }

    /*
     * Exception decompiling
     */
    private void finishScanCycle() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl151 : RETURN : trying to set 1 previously set to 0
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

    private long getNextScanStartTime() {
        long l2 = this.mBetweenScanPeriod;
        if (l2 == 0L) {
            return SystemClock.elapsedRealtime();
        }
        long l3 = l2 + this.mScanPeriod;
        long l4 = l2 - SystemClock.elapsedRealtime() % l3;
        Object[] arrobject = new Object[]{this.mBetweenScanPeriod, l4};
        LogManager.d("CycledLeScanner", "Normalizing between scan period from %s to %s", arrobject);
        return l4 + SystemClock.elapsedRealtime();
    }

    private boolean mustStopScanToPreventAndroidNScanTimeout() {
        long l2;
        long l3 = SystemClock.elapsedRealtime() + this.mBetweenScanPeriod + this.mScanPeriod;
        boolean bl2 = Build.VERSION.SDK_INT >= 24 && (l2 = this.mCurrentScanStartTime) > 0L && l3 - l2 > 1800000L;
        if (bl2) {
            LogManager.d("CycledLeScanner", "The next scan cycle would go over the Android N max duration.", new Object[0]);
            if (this.mLongScanForcingEnabled) {
                LogManager.d("CycledLeScanner", "Stopping scan to prevent Android N scan timeout.", new Object[0]);
                return true;
            }
            LogManager.w("CycledLeScanner", "Allowing a long running scan to be stopped by the OS.  To prevent this, set longScanForcingEnabled in the AndroidBeaconLibrary.", new Object[0]);
        }
        return false;
    }

    protected void cancelWakeUpAlarm() {
        Object[] arrobject = new Object[]{this.mWakeUpOperation};
        LogManager.d("CycledLeScanner", "cancel wakeup alarm: %s", arrobject);
        ((AlarmManager)this.mContext.getSystemService("alarm")).set(2, Long.MAX_VALUE, this.getWakeUpOperation());
        Object[] arrobject2 = new Object[]{Long.MAX_VALUE - SystemClock.elapsedRealtime(), this.getWakeUpOperation()};
        LogManager.d("CycledLeScanner", "Set a wakeup alarm to go off in %s ms: %s", arrobject2);
    }

    protected abstract boolean deferScanIfNeeded();

    public void destroy() {
        LogManager.d("CycledLeScanner", "Destroying", new Object[0]);
        this.mHandler.removeCallbacksAndMessages(null);
        this.mScanHandler.post(new Runnable(){

            public void run() {
                LogManager.d("CycledLeScanner", "Quitting scan thread", new Object[0]);
                CycledLeScanner.this.mScanThread.quit();
            }
        });
    }

    protected abstract void finishScan();

    /*
     * Exception decompiling
     */
    protected BluetoothAdapter getBluetoothAdapter() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl27 : ALOAD_0 : trying to set 1 previously set to 0
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

    public boolean getDistinctPacketsDetectedPerScan() {
        return this.mDistinctPacketsDetectedPerScan;
    }

    protected PendingIntent getWakeUpOperation() {
        if (this.mWakeUpOperation == null) {
            Intent intent = new Intent(this.mContext, StartupBroadcastReceiver.class);
            intent.putExtra("wakeup", true);
            this.mWakeUpOperation = PendingIntent.getBroadcast((Context)this.mContext, (int)0, (Intent)intent, (int)134217728);
        }
        return this.mWakeUpOperation;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    protected void scanLeDevice(Boolean var1_1) {
        try {
            block13 : {
                block11 : {
                    block12 : {
                        block15 : {
                            block14 : {
                                this.mScanCyclerStarted = true;
                                if (this.getBluetoothAdapter() == null) {
                                    LogManager.e("CycledLeScanner", "No Bluetooth adapter.  beaconService cannot scan.", new Object[0]);
                                }
                                if (!this.mScanningEnabled || !var1_1.booleanValue()) break block13;
                                if (this.deferScanIfNeeded()) {
                                    return;
                                }
                                LogManager.d("CycledLeScanner", "starting a new scan cycle", new Object[0]);
                                if (!this.mScanning || this.mScanningPaused || this.mRestartNeeded) break block14;
                                var4_2 = new StringBuilder();
                                var4_2.append("We are already scanning and have been for ");
                                var4_2.append(SystemClock.elapsedRealtime() - this.mCurrentScanStartTime);
                                var4_2.append(" millis");
                                LogManager.d("CycledLeScanner", var4_2.toString(), new Object[0]);
                                break block11;
                            }
                            this.mScanning = true;
                            this.mScanningPaused = false;
                            if (this.getBluetoothAdapter() == null) break block11;
                            if (!this.getBluetoothAdapter().isEnabled()) ** GOTO lbl47
                            if (this.mBluetoothCrashResolver == null || !this.mBluetoothCrashResolver.isRecoveryInProgress()) break block15;
                            LogManager.w("CycledLeScanner", "Skipping scan because crash recovery is in progress.", new Object[0]);
                            ** GOTO lbl44
                        }
                        if (!this.mScanningEnabled) ** GOTO lbl43
                        if (this.mRestartNeeded) {
                            this.mRestartNeeded = false;
                            LogManager.d("CycledLeScanner", "restarting a bluetooth le scan", new Object[0]);
                            break block12;
                        }
                        LogManager.d("CycledLeScanner", "starting a new bluetooth le scan", new Object[0]);
                    }
                    try {
                        if (Build.VERSION.SDK_INT < 23 || this.checkLocationPermission()) {
                            this.mCurrentScanStartTime = SystemClock.elapsedRealtime();
                            this.startScan();
                        }
                        ** GOTO lbl44
                    }
                    catch (Exception var3_3) {
                        try {
                            block16 : {
                                LogManager.e(var3_3, "CycledLeScanner", "Internal Android exception scanning for beacons", new Object[0]);
                                break block16;
lbl43: // 1 sources:
                                LogManager.d("CycledLeScanner", "Scanning unnecessary - no monitoring or ranging active.", new Object[0]);
                            }
                            this.mLastScanCycleStartTime = SystemClock.elapsedRealtime();
lbl47: // 1 sources:
                            LogManager.d("CycledLeScanner", "Bluetooth is disabled.  Cannot scan for beacons.", new Object[0]);
                        }
                        catch (Exception var2_4) {
                            LogManager.e(var2_4, "CycledLeScanner", "Exception starting Bluetooth scan.  Perhaps Bluetooth is disabled or unavailable?", new Object[0]);
                        }
                    }
                }
                this.mScanCycleStopTime = SystemClock.elapsedRealtime() + this.mScanPeriod;
                this.scheduleScanCycleStop();
                LogManager.d("CycledLeScanner", "Scan started", new Object[0]);
                return;
            }
            LogManager.d("CycledLeScanner", "disabling scan", new Object[0]);
            this.mScanning = false;
            this.mScanCyclerStarted = false;
            this.stopScan();
            this.mCurrentScanStartTime = 0L;
            this.mLastScanCycleEndTime = SystemClock.elapsedRealtime();
            this.mHandler.removeCallbacksAndMessages(null);
            this.finishScanCycle();
            return;
        }
        catch (SecurityException v0) {
            LogManager.w("CycledLeScanner", "SecurityException working accessing bluetooth.", new Object[0]);
            return;
        }
    }

    protected void scheduleScanCycleStop() {
        long l2 = this.mScanCycleStopTime - SystemClock.elapsedRealtime();
        if (this.mScanningEnabled && l2 > 0L) {
            Object[] arrobject = new Object[]{l2};
            LogManager.d("CycledLeScanner", "Waiting to stop scan cycle for another %s milliseconds", arrobject);
            if (this.mBackgroundFlag) {
                this.setWakeUpAlarm();
            }
            Handler handler = this.mHandler;
            Runnable runnable = new Runnable(){

                public void run() {
                    CycledLeScanner.this.scheduleScanCycleStop();
                }
            };
            if (l2 > 1000L) {
                l2 = 1000L;
            }
            handler.postDelayed(runnable, l2);
            return;
        }
        this.finishScanCycle();
    }

    public void setDistinctPacketsDetectedPerScan(boolean bl2) {
        this.mDistinctPacketsDetectedPerScan = bl2;
    }

    public void setLongScanForcingEnabled(boolean bl2) {
        this.mLongScanForcingEnabled = bl2;
    }

    public void setScanPeriods(long l2, long l3, boolean bl2) {
        long l4;
        long l5;
        long l6;
        Object[] arrobject = new Object[]{l2, l3};
        LogManager.d("CycledLeScanner", "Set scan periods called with %s, %s Background mode must have changed.", arrobject);
        if (this.mBackgroundFlag != bl2) {
            this.mRestartNeeded = true;
        }
        this.mBackgroundFlag = bl2;
        this.mScanPeriod = l2;
        this.mBetweenScanPeriod = l3;
        if (this.mBackgroundFlag) {
            LogManager.d("CycledLeScanner", "We are in the background.  Setting wakeup alarm", new Object[0]);
            this.setWakeUpAlarm();
        } else {
            LogManager.d("CycledLeScanner", "We are not in the background.  Cancelling wakeup alarm", new Object[0]);
            this.cancelWakeUpAlarm();
        }
        long l7 = SystemClock.elapsedRealtime();
        long l8 = this.mNextScanCycleStartTime;
        if (l8 > l7 && (l4 = l3 + this.mLastScanCycleEndTime) < l8) {
            this.mNextScanCycleStartTime = l4;
            Object[] arrobject2 = new Object[]{new Date(this.mNextScanCycleStartTime - SystemClock.elapsedRealtime() + System.currentTimeMillis())};
            LogManager.i("CycledLeScanner", "Adjusted nextScanStartTime to be %s", arrobject2);
        }
        if ((l5 = this.mScanCycleStopTime) > l7 && (l6 = l2 + this.mLastScanCycleStartTime) < l5) {
            this.mScanCycleStopTime = l6;
            Object[] arrobject3 = new Object[]{this.mScanCycleStopTime};
            LogManager.i("CycledLeScanner", "Adjusted scanStopTime to be %s", arrobject3);
        }
    }

    protected void setWakeUpAlarm() {
        long l2 = this.mBetweenScanPeriod;
        if (300000L >= l2) {
            l2 = 300000L;
        }
        long l3 = this.mScanPeriod;
        if (l2 < l3) {
            l2 = l3;
        }
        ((AlarmManager)this.mContext.getSystemService("alarm")).set(2, l2 + SystemClock.elapsedRealtime(), this.getWakeUpOperation());
        Object[] arrobject = new Object[]{l2, this.getWakeUpOperation()};
        LogManager.d("CycledLeScanner", "Set a wakeup alarm to go off in %s ms: %s", arrobject);
    }

    public void start() {
        LogManager.d("CycledLeScanner", "start called", new Object[0]);
        this.mScanningEnabled = true;
        if (!this.mScanCyclerStarted) {
            this.scanLeDevice(true);
            return;
        }
        LogManager.d("CycledLeScanner", "scanning already started", new Object[0]);
    }

    protected abstract void startScan();

    public void stop() {
        LogManager.d("CycledLeScanner", "stop called", new Object[0]);
        this.mScanningEnabled = false;
        if (this.mScanCyclerStarted) {
            this.scanLeDevice(false);
            if (this.mScanningLeftOn) {
                LogManager.d("CycledLeScanner", "Stopping scanning previously left on.", new Object[0]);
                this.mScanningLeftOn = false;
                try {
                    LogManager.d("CycledLeScanner", "stopping bluetooth le scan", new Object[0]);
                    this.finishScan();
                    return;
                }
                catch (Exception exception) {
                    LogManager.w(exception, "CycledLeScanner", "Internal Android exception scanning for beacons", new Object[0]);
                    return;
                }
            }
        } else {
            LogManager.d("CycledLeScanner", "scanning already stopped", new Object[0]);
        }
    }

    protected abstract void stopScan();

}


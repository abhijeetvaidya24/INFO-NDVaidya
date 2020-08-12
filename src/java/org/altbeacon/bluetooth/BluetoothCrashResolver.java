/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.bluetooth.BluetoothAdapter
 *  android.bluetooth.BluetoothAdapter$LeScanCallback
 *  android.bluetooth.BluetoothDevice
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.SystemClock
 *  java.lang.InterruptedException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Thread
 *  java.util.HashSet
 *  java.util.Set
 */
package org.altbeacon.bluetooth;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.SystemClock;
import java.util.HashSet;
import java.util.Set;
import org.altbeacon.beacon.logging.LogManager;

public class BluetoothCrashResolver {
    private Context context = null;
    private int detectedCrashCount = 0;
    private boolean discoveryStartConfirmed = false;
    private final Set<String> distinctBluetoothAddresses = new HashSet();
    private long lastBluetoothCrashDetectionTime = 0L;
    private long lastBluetoothOffTime = 0L;
    private long lastBluetoothTurningOnTime = 0L;
    private boolean lastRecoverySucceeded = false;
    private long lastStateSaveTime = 0L;
    private final BroadcastReceiver receiver = new BroadcastReceiver(){

        /*
         * Exception decompiling
         */
        public void onReceive(Context var1_1, Intent var2_2) {
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
            // org.benf.cfr.reader.entities.d.c(ClassFile.java:773)
            // org.benf.cfr.reader.entities.d.e(ClassFile.java:870)
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
    };
    private int recoveryAttemptCount = 0;
    private boolean recoveryInProgress = false;
    private UpdateNotifier updateNotifier;

    public BluetoothCrashResolver(Context context) {
        this.context = context.getApplicationContext();
        LogManager.d("BluetoothCrashResolver", "constructed", new Object[0]);
        this.loadState();
    }

    static /* synthetic */ boolean access$000(BluetoothCrashResolver bluetoothCrashResolver) {
        return bluetoothCrashResolver.recoveryInProgress;
    }

    static /* synthetic */ void access$100(BluetoothCrashResolver bluetoothCrashResolver) {
        bluetoothCrashResolver.finishRecovery();
    }

    static /* synthetic */ boolean access$202(BluetoothCrashResolver bluetoothCrashResolver, boolean bl2) {
        bluetoothCrashResolver.discoveryStartConfirmed = bl2;
        return bl2;
    }

    static /* synthetic */ long access$300(BluetoothCrashResolver bluetoothCrashResolver) {
        return bluetoothCrashResolver.lastBluetoothOffTime;
    }

    static /* synthetic */ long access$302(BluetoothCrashResolver bluetoothCrashResolver, long l2) {
        bluetoothCrashResolver.lastBluetoothOffTime = l2;
        return l2;
    }

    static /* synthetic */ long access$400(BluetoothCrashResolver bluetoothCrashResolver) {
        return bluetoothCrashResolver.lastBluetoothTurningOnTime;
    }

    static /* synthetic */ long access$402(BluetoothCrashResolver bluetoothCrashResolver, long l2) {
        bluetoothCrashResolver.lastBluetoothTurningOnTime = l2;
        return l2;
    }

    private void cancelDiscovery() {
        try {
            BluetoothAdapter bluetoothAdapter;
            Thread.sleep((long)5000L);
            if (!this.discoveryStartConfirmed) {
                LogManager.w("BluetoothCrashResolver", "BluetoothAdapter.ACTION_DISCOVERY_STARTED never received.  Recovery may fail.", new Object[0]);
            }
            if ((bluetoothAdapter = BluetoothAdapter.getDefaultAdapter()).isDiscovering()) {
                LogManager.d("BluetoothCrashResolver", "Cancelling discovery", new Object[0]);
                bluetoothAdapter.cancelDiscovery();
                return;
            }
            LogManager.d("BluetoothCrashResolver", "Discovery not running.  Won't cancel it", new Object[0]);
            return;
        }
        catch (InterruptedException interruptedException) {
            LogManager.d("BluetoothCrashResolver", "DiscoveryCanceller sleep interrupted.", new Object[0]);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void finishRecovery() {
        Set<String> set;
        LogManager.w("BluetoothCrashResolver", "Recovery attempt finished", new Object[0]);
        Set<String> set2 = set = this.distinctBluetoothAddresses;
        synchronized (set2) {
            this.distinctBluetoothAddresses.clear();
        }
        this.recoveryInProgress = false;
    }

    private int getCrashRiskDeviceCount() {
        return 1590;
    }

    /*
     * Exception decompiling
     */
    private void loadState() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl108.1 : ICONST_1 : trying to set 1 previously set to 0
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

    private void processStateChange() {
        UpdateNotifier updateNotifier = this.updateNotifier;
        if (updateNotifier != null) {
            updateNotifier.dataUpdated();
        }
        if (SystemClock.elapsedRealtime() - this.lastStateSaveTime > 60000L) {
            this.saveState();
        }
    }

    /*
     * Exception decompiling
     */
    private void saveState() {
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

    @TargetApi(value=17)
    private void startRecovery() {
        this.recoveryAttemptCount = 1 + this.recoveryAttemptCount;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        LogManager.d("BluetoothCrashResolver", "about to check if discovery is active", new Object[0]);
        if (!bluetoothAdapter.isDiscovering()) {
            LogManager.w("BluetoothCrashResolver", "Recovery attempt started", new Object[0]);
            this.recoveryInProgress = true;
            this.discoveryStartConfirmed = false;
            LogManager.d("BluetoothCrashResolver", "about to command discovery", new Object[0]);
            if (!bluetoothAdapter.startDiscovery()) {
                LogManager.w("BluetoothCrashResolver", "Can't start discovery.  Is Bluetooth turned on?", new Object[0]);
            }
            Object[] arrobject = new Object[]{bluetoothAdapter.isDiscovering()};
            LogManager.d("BluetoothCrashResolver", "startDiscovery commanded.  isDiscovering()=%s", arrobject);
            Object[] arrobject2 = new Object[]{5000};
            LogManager.d("BluetoothCrashResolver", "We will be cancelling this discovery in %s milliseconds.", arrobject2);
            this.cancelDiscovery();
            return;
        }
        LogManager.w("BluetoothCrashResolver", "Already discovering.  Recovery attempt abandoned.", new Object[0]);
    }

    public void crashDetected() {
        if (Build.VERSION.SDK_INT < 18) {
            LogManager.d("BluetoothCrashResolver", "Ignoring crashes before API 18, because BLE is unsupported.", new Object[0]);
            return;
        }
        LogManager.w("BluetoothCrashResolver", "BluetoothService crash detected", new Object[0]);
        if (this.distinctBluetoothAddresses.size() > 0) {
            Object[] arrobject = new Object[]{this.distinctBluetoothAddresses.size()};
            LogManager.d("BluetoothCrashResolver", "Distinct Bluetooth devices seen at crash: %s", arrobject);
        }
        this.lastBluetoothCrashDetectionTime = SystemClock.elapsedRealtime();
        this.detectedCrashCount = 1 + this.detectedCrashCount;
        if (this.recoveryInProgress) {
            LogManager.d("BluetoothCrashResolver", "Ignoring Bluetooth crash because recovery is already in progress.", new Object[0]);
        } else {
            this.startRecovery();
        }
        this.processStateChange();
    }

    public boolean isRecoveryInProgress() {
        return this.recoveryInProgress;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @TargetApi(value=18)
    public void notifyScannedDevice(BluetoothDevice bluetoothDevice, BluetoothAdapter.LeScanCallback leScanCallback) {
        Set<String> set;
        int n2 = this.distinctBluetoothAddresses.size();
        Set<String> set2 = set = this.distinctBluetoothAddresses;
        synchronized (set2) {
            this.distinctBluetoothAddresses.add((Object)bluetoothDevice.getAddress());
        }
        int n3 = this.distinctBluetoothAddresses.size();
        if (n2 != n3 && n3 % 100 == 0) {
            Object[] arrobject = new Object[]{this.distinctBluetoothAddresses.size()};
            LogManager.d("BluetoothCrashResolver", "Distinct Bluetooth devices seen: %s", arrobject);
        }
        if (this.distinctBluetoothAddresses.size() > this.getCrashRiskDeviceCount() && !this.recoveryInProgress) {
            Object[] arrobject = new Object[]{this.distinctBluetoothAddresses.size()};
            LogManager.w("BluetoothCrashResolver", "Large number of Bluetooth devices detected: %s Proactively attempting to clear out address list to prevent a crash", arrobject);
            LogManager.w("BluetoothCrashResolver", "Stopping LE Scan", new Object[0]);
            BluetoothAdapter.getDefaultAdapter().stopLeScan(leScanCallback);
            this.startRecovery();
            this.processStateChange();
        }
    }

    public void start() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        intentFilter.addAction("android.bluetooth.adapter.action.DISCOVERY_STARTED");
        intentFilter.addAction("android.bluetooth.adapter.action.DISCOVERY_FINISHED");
        this.context.registerReceiver(this.receiver, intentFilter);
        LogManager.d("BluetoothCrashResolver", "started listening for BluetoothAdapter events", new Object[0]);
    }

    public void stop() {
        this.context.unregisterReceiver(this.receiver);
        LogManager.d("BluetoothCrashResolver", "stopped listening for BluetoothAdapter events", new Object[0]);
        this.saveState();
    }

    public static interface UpdateNotifier {
        public void dataUpdated();
    }

}


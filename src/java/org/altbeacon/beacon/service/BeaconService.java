/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.AlarmManager
 *  android.app.PendingIntent
 *  android.app.Service
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.IBinder
 *  android.os.Looper
 *  android.os.Message
 *  android.os.Messenger
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.ref.WeakReference
 *  java.util.Map
 */
package org.altbeacon.beacon.service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.altbeacon.beacon.Region;
import org.altbeacon.beacon.logging.LogManager;
import org.altbeacon.beacon.service.Callback;
import org.altbeacon.beacon.service.MonitoringStatus;
import org.altbeacon.beacon.service.RangeState;
import org.altbeacon.beacon.service.ScanHelper;
import org.altbeacon.beacon.service.SettingsData;
import org.altbeacon.beacon.service.StartRMData;
import org.altbeacon.beacon.service.scanner.CycledLeScanner;
import org.altbeacon.beacon.startup.StartupBroadcastReceiver;
import org.altbeacon.bluetooth.BluetoothCrashResolver;

public class BeaconService
extends Service {
    private BluetoothCrashResolver bluetoothCrashResolver;
    private final Handler handler = new Handler();
    final Messenger mMessenger = new Messenger((Handler)new IncomingHandler(this));
    private ScanHelper mScanHelper;

    private PendingIntent getRestartIntent() {
        Intent intent = new Intent(this.getApplicationContext(), StartupBroadcastReceiver.class);
        return PendingIntent.getBroadcast((Context)this.getApplicationContext(), (int)1, (Intent)intent, (int)1073741824);
    }

    public IBinder onBind(Intent intent) {
        LogManager.i("BeaconService", "binding", new Object[0]);
        return this.mMessenger.getBinder();
    }

    /*
     * Exception decompiling
     */
    public void onCreate() {
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

    public void onDestroy() {
        LogManager.e("BeaconService", "onDestroy()", new Object[0]);
        if (Build.VERSION.SDK_INT < 18) {
            LogManager.w("BeaconService", "Not supported prior to API 18.", new Object[0]);
            return;
        }
        this.bluetoothCrashResolver.stop();
        LogManager.i("BeaconService", "onDestroy called.  stopping scanning", new Object[0]);
        this.handler.removeCallbacksAndMessages(null);
        this.mScanHelper.getCycledScanner().stop();
        this.mScanHelper.getCycledScanner().destroy();
        this.mScanHelper.getMonitoringStatus().stopStatusPreservation();
    }

    public int onStartCommand(Intent intent, int n2, int n3) {
        String string;
        if (intent == null) {
            string = "starting with null intent";
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("starting with intent ");
            stringBuilder.append(intent.toString());
            string = stringBuilder.toString();
        }
        LogManager.i("BeaconService", string, new Object[0]);
        return super.onStartCommand(intent, n2, n3);
    }

    public void onTaskRemoved(Intent intent) {
        super.onTaskRemoved(intent);
        LogManager.d("BeaconService", "task removed", new Object[0]);
        if (Build.VERSION.RELEASE.contains((CharSequence)"4.4.1") || Build.VERSION.RELEASE.contains((CharSequence)"4.4.2") || Build.VERSION.RELEASE.contains((CharSequence)"4.4.3")) {
            ((AlarmManager)this.getApplicationContext().getSystemService("alarm")).set(0, 1000L + System.currentTimeMillis(), this.getRestartIntent());
            LogManager.d("BeaconService", "Setting a wakeup alarm to go off due to Android 4.4.2 service restarting bug.", new Object[0]);
        }
    }

    public boolean onUnbind(Intent intent) {
        LogManager.i("BeaconService", "unbinding", new Object[0]);
        return false;
    }

    public void reloadParsers() {
        this.mScanHelper.reloadParsers();
    }

    public void setScanPeriods(long l2, long l3, boolean bl2) {
        this.mScanHelper.getCycledScanner().setScanPeriods(l2, l3, bl2);
    }

    public void startMonitoringBeaconsInRegion(Region region, Callback callback) {
        LogManager.d("BeaconService", "startMonitoring called", new Object[0]);
        this.mScanHelper.getMonitoringStatus().addRegion(region, callback);
        Object[] arrobject = new Object[]{this.mScanHelper.getMonitoringStatus().regionsCount()};
        LogManager.d("BeaconService", "Currently monitoring %s regions.", arrobject);
        this.mScanHelper.getCycledScanner().start();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void startRangingBeaconsInRegion(Region region, Callback callback) {
        Map<Region, RangeState> map;
        Map<Region, RangeState> map2 = map = this.mScanHelper.getRangedRegionState();
        synchronized (map2) {
            if (this.mScanHelper.getRangedRegionState().containsKey((Object)region)) {
                LogManager.i("BeaconService", "Already ranging that region -- will replace existing region.", new Object[0]);
                this.mScanHelper.getRangedRegionState().remove((Object)region);
            }
            this.mScanHelper.getRangedRegionState().put((Object)region, (Object)new RangeState(callback));
            Object[] arrobject = new Object[]{this.mScanHelper.getRangedRegionState().size()};
            LogManager.d("BeaconService", "Currently ranging %s regions.", arrobject);
        }
        this.mScanHelper.getCycledScanner().start();
    }

    public void stopMonitoringBeaconsInRegion(Region region) {
        LogManager.d("BeaconService", "stopMonitoring called", new Object[0]);
        this.mScanHelper.getMonitoringStatus().removeRegion(region);
        Object[] arrobject = new Object[]{this.mScanHelper.getMonitoringStatus().regionsCount()};
        LogManager.d("BeaconService", "Currently monitoring %s regions.", arrobject);
        if (this.mScanHelper.getMonitoringStatus().regionsCount() == 0 && this.mScanHelper.getRangedRegionState().size() == 0) {
            this.mScanHelper.getCycledScanner().stop();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void stopRangingBeaconsInRegion(Region region) {
        Map<Region, RangeState> map;
        Map<Region, RangeState> map2 = map = this.mScanHelper.getRangedRegionState();
        // MONITORENTER : map2
        this.mScanHelper.getRangedRegionState().remove((Object)region);
        int n2 = this.mScanHelper.getRangedRegionState().size();
        Object[] arrobject = new Object[]{this.mScanHelper.getRangedRegionState().size()};
        LogManager.d("BeaconService", "Currently ranging %s regions.", arrobject);
        // MONITOREXIT : map2
        if (n2 != 0) return;
        if (this.mScanHelper.getMonitoringStatus().regionsCount() != 0) return;
        this.mScanHelper.getCycledScanner().stop();
    }

    static class IncomingHandler
    extends Handler {
        private final WeakReference<BeaconService> mService;

        IncomingHandler(BeaconService beaconService) {
            super(Looper.getMainLooper());
            this.mService = new WeakReference((Object)beaconService);
        }

        public void handleMessage(Message message) {
            BeaconService beaconService = (BeaconService)((Object)this.mService.get());
            if (beaconService != null) {
                StartRMData startRMData = StartRMData.fromBundle(message.getData());
                if (startRMData != null) {
                    int n2 = message.what;
                    if (n2 != 2) {
                        if (n2 != 3) {
                            if (n2 != 4) {
                                if (n2 != 5) {
                                    if (n2 != 6) {
                                        super.handleMessage(message);
                                        return;
                                    }
                                    LogManager.i("BeaconService", "set scan intervals received", new Object[0]);
                                    beaconService.setScanPeriods(startRMData.getScanPeriod(), startRMData.getBetweenScanPeriod(), startRMData.getBackgroundFlag());
                                    return;
                                }
                                LogManager.i("BeaconService", "stop monitoring received", new Object[0]);
                                beaconService.stopMonitoringBeaconsInRegion(startRMData.getRegionData());
                                beaconService.setScanPeriods(startRMData.getScanPeriod(), startRMData.getBetweenScanPeriod(), startRMData.getBackgroundFlag());
                                return;
                            }
                            LogManager.i("BeaconService", "start monitoring received", new Object[0]);
                            beaconService.startMonitoringBeaconsInRegion(startRMData.getRegionData(), new Callback(startRMData.getCallbackPackageName()));
                            beaconService.setScanPeriods(startRMData.getScanPeriod(), startRMData.getBetweenScanPeriod(), startRMData.getBackgroundFlag());
                            return;
                        }
                        LogManager.i("BeaconService", "stop ranging received", new Object[0]);
                        beaconService.stopRangingBeaconsInRegion(startRMData.getRegionData());
                        beaconService.setScanPeriods(startRMData.getScanPeriod(), startRMData.getBetweenScanPeriod(), startRMData.getBackgroundFlag());
                        return;
                    }
                    LogManager.i("BeaconService", "start ranging received", new Object[0]);
                    beaconService.startRangingBeaconsInRegion(startRMData.getRegionData(), new Callback(startRMData.getCallbackPackageName()));
                    beaconService.setScanPeriods(startRMData.getScanPeriod(), startRMData.getBetweenScanPeriod(), startRMData.getBackgroundFlag());
                    return;
                }
                if (message.what == 7) {
                    LogManager.i("BeaconService", "Received settings update from other process", new Object[0]);
                    SettingsData settingsData = SettingsData.fromBundle(message.getData());
                    if (settingsData != null) {
                        settingsData.apply(beaconService);
                        return;
                    }
                    LogManager.w("BeaconService", "Settings data missing", new Object[0]);
                    return;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Received unknown message from other process : ");
                stringBuilder.append(message.what);
                LogManager.i("BeaconService", stringBuilder.toString(), new Object[0]);
            }
        }
    }

}


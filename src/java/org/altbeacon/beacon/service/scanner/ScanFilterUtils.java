/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.bluetooth.le.ScanFilter
 *  android.bluetooth.le.ScanFilter$Builder
 *  android.os.ParcelUuid
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 */
package org.altbeacon.beacon.service.scanner;

import android.annotation.TargetApi;
import android.bluetooth.le.ScanFilter;
import android.os.ParcelUuid;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.altbeacon.beacon.BeaconParser;
import org.altbeacon.beacon.logging.LogManager;

@TargetApi(value=21)
public class ScanFilterUtils {
    public List<ScanFilterData> createScanFilterDataForBeaconParser(BeaconParser beaconParser) {
        ArrayList arrayList = new ArrayList();
        for (int n2 : beaconParser.getHardwareAssistManufacturers()) {
            int n3;
            Long l2 = beaconParser.getServiceUuid();
            long l3 = beaconParser.getMatchingBeaconTypeCode();
            int n4 = beaconParser.getMatchingBeaconTypeCodeStartOffset();
            int n5 = beaconParser.getMatchingBeaconTypeCodeEndOffset();
            int n6 = n5 + 1;
            int n7 = n6 - n3;
            byte[] arrby = new byte[n7];
            byte[] arrby2 = new byte[n7];
            byte[] arrby3 = BeaconParser.longToByteArray(l3, 1 + (n5 - n4));
            for (n3 = 2; n3 <= n5; ++n3) {
                int n8 = n3 - 2;
                if (n3 < n4) {
                    arrby[n8] = 0;
                    arrby2[n8] = 0;
                    continue;
                }
                arrby[n8] = arrby3[n3 - n4];
                arrby2[n8] = -1;
            }
            ScanFilterData scanFilterData = new ScanFilterData();
            scanFilterData.manufacturer = n2;
            scanFilterData.filter = arrby;
            scanFilterData.mask = arrby2;
            scanFilterData.serviceUuid = l2;
            arrayList.add((Object)scanFilterData);
        }
        return arrayList;
    }

    public List<ScanFilter> createScanFiltersForBeaconParsers(List<BeaconParser> list) {
        ArrayList arrayList = new ArrayList();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            for (ScanFilterData scanFilterData : this.createScanFilterDataForBeaconParser((BeaconParser)iterator.next())) {
                ScanFilter.Builder builder = new ScanFilter.Builder();
                if (scanFilterData.serviceUuid != null) {
                    Object[] arrobject = new Object[]{scanFilterData.serviceUuid};
                    String string = String.format((String)"0000%04X-0000-1000-8000-00805f9b34fb", (Object[])arrobject);
                    ParcelUuid parcelUuid = ParcelUuid.fromString((String)string);
                    ParcelUuid parcelUuid2 = ParcelUuid.fromString((String)"FFFFFFFF-FFFF-FFFF-FFFF-FFFFFFFFFFFF");
                    if (LogManager.isVerboseLoggingEnabled()) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("making scan filter for service: ");
                        stringBuilder.append(string);
                        stringBuilder.append(" ");
                        stringBuilder.append((Object)parcelUuid);
                        LogManager.d("ScanFilterUtils", stringBuilder.toString(), new Object[0]);
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("making scan filter with service mask: ");
                        stringBuilder2.append("FFFFFFFF-FFFF-FFFF-FFFF-FFFFFFFFFFFF");
                        stringBuilder2.append(" ");
                        stringBuilder2.append((Object)parcelUuid2);
                        LogManager.d("ScanFilterUtils", stringBuilder2.toString(), new Object[0]);
                    }
                    builder.setServiceUuid(parcelUuid, parcelUuid2);
                } else {
                    builder.setServiceUuid(null);
                    builder.setManufacturerData(scanFilterData.manufacturer, scanFilterData.filter, scanFilterData.mask);
                }
                ScanFilter scanFilter = builder.build();
                if (LogManager.isVerboseLoggingEnabled()) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Set up a scan filter: ");
                    stringBuilder.append((Object)scanFilter);
                    LogManager.d("ScanFilterUtils", stringBuilder.toString(), new Object[0]);
                }
                arrayList.add((Object)scanFilter);
            }
        }
        return arrayList;
    }

    public List<ScanFilter> createWildcardScanFilters() {
        ArrayList arrayList = new ArrayList();
        arrayList.add((Object)new ScanFilter.Builder().build());
        return arrayList;
    }

    class ScanFilterData {
        public byte[] filter;
        public int manufacturer;
        public byte[] mask;
        public Long serviceUuid = null;

        ScanFilterData() {
        }
    }

}


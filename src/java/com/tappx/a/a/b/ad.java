/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.net.URI
 *  java.net.URISyntaxException
 *  java.util.Date
 *  java.util.HashMap
 *  java.util.Map
 */
package com.tappx.a.a.b;

import android.annotation.TargetApi;
import com.tappx.a.a.b.w;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

class ad {
    private static final String[] b = new String[]{"yyyy-MM-dd'T'HH:mm:ssZZZZZ", "yyyy-MM-dd'T'HH:mmZZZZZ"};

    static String a(int n2) {
        if (n2 != 0 && n2 >= -31 && n2 <= 31) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("");
            stringBuilder.append(n2);
            return stringBuilder.toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid params ");
        stringBuilder.append(n2);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    static String a(Map<String, String> map) {
        StringBuilder stringBuilder = new StringBuilder();
        if (map.containsKey((Object)"frequency")) {
            String string2 = (String)map.get((Object)"frequency");
            int n2 = map.containsKey((Object)"interval") ? Integer.parseInt((String)((String)map.get((Object)"interval"))) : -1;
            if ("daily".equals((Object)string2)) {
                stringBuilder.append("FREQ=DAILY;");
                if (n2 != -1) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("INTERVAL=");
                    stringBuilder2.append(n2);
                    stringBuilder2.append(";");
                    stringBuilder.append(stringBuilder2.toString());
                }
            } else if ("weekly".equals((Object)string2)) {
                stringBuilder.append("FREQ=WEEKLY;");
                if (n2 != -1) {
                    StringBuilder stringBuilder3 = new StringBuilder();
                    stringBuilder3.append("INTERVAL=");
                    stringBuilder3.append(n2);
                    stringBuilder3.append(";");
                    stringBuilder.append(stringBuilder3.toString());
                }
                if (map.containsKey((Object)"daysInWeek")) {
                    String string3 = ad.b((String)map.get((Object)"daysInWeek"));
                    if (string3 == null) throw new IllegalArgumentException("invalid ");
                    StringBuilder stringBuilder4 = new StringBuilder();
                    stringBuilder4.append("BYDAY=");
                    stringBuilder4.append(string3);
                    stringBuilder4.append(";");
                    stringBuilder.append(stringBuilder4.toString());
                }
            } else {
                if (!"monthly".equals((Object)string2)) throw new IllegalArgumentException("Invalid frequency");
                stringBuilder.append("FREQ=MONTHLY;");
                if (n2 != -1) {
                    StringBuilder stringBuilder5 = new StringBuilder();
                    stringBuilder5.append("INTERVAL=");
                    stringBuilder5.append(n2);
                    stringBuilder5.append(";");
                    stringBuilder.append(stringBuilder5.toString());
                }
                if (map.containsKey((Object)"daysInMonth")) {
                    String string4 = ad.c((String)map.get((Object)"daysInMonth"));
                    if (string4 == null) throw new IllegalArgumentException();
                    StringBuilder stringBuilder6 = new StringBuilder();
                    stringBuilder6.append("BYMONTHDAY=");
                    stringBuilder6.append(string4);
                    stringBuilder6.append(";");
                    stringBuilder.append(stringBuilder6.toString());
                }
            }
        }
        if (!stringBuilder.toString().isEmpty()) return stringBuilder.toString();
        return null;
    }

    static URI a(String string2, URI uRI) {
        if (string2 == null) {
            return uRI;
        }
        return ad.d(string2);
    }

    /*
     * Exception decompiling
     */
    static Date a(String var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl29.1 : IINC : trying to set 1 previously set to 0
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

    static String b(int n2) {
        switch (n2) {
            default: {
                throw new IllegalArgumentException();
            }
            case 6: {
                return "SA";
            }
            case 5: {
                return "FR";
            }
            case 4: {
                return "TH";
            }
            case 3: {
                return "WE";
            }
            case 2: {
                return "TU";
            }
            case 1: {
                return "MO";
            }
            case 0: 
        }
        return "SU";
    }

    static String b(String string2) {
        IllegalArgumentException illegalArgumentException;
        StringBuilder stringBuilder = new StringBuilder();
        boolean[] arrbl = new boolean[7];
        String[] arrstring = string2.split(",");
        int n2 = arrstring.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            int n3 = Integer.parseInt((String)arrstring[i2]);
            if (n3 == 7) {
                n3 = 0;
            }
            if (arrbl[n3]) continue;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(ad.b(n3));
            stringBuilder2.append(",");
            stringBuilder.append(stringBuilder2.toString());
            arrbl[n3] = true;
        }
        if (arrstring.length != 0) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            return stringBuilder.toString();
        }
        illegalArgumentException = new IllegalArgumentException();
        throw illegalArgumentException;
    }

    @TargetApi(value=14)
    static Map<String, Object> b(Map<String, String> map) {
        HashMap hashMap = new HashMap();
        if (map.containsKey((Object)"description") && map.containsKey((Object)"start")) {
            hashMap.put((Object)"title", map.get((Object)"description"));
            if (map.containsKey((Object)"start") && map.get((Object)"start") != null) {
                Date date = ad.a((String)map.get((Object)"start"));
                if (date != null) {
                    String string2;
                    hashMap.put((Object)"beginTime", (Object)date.getTime());
                    if (map.containsKey((Object)"end") && map.get((Object)"end") != null) {
                        Date date2 = ad.a((String)map.get((Object)"end"));
                        if (date2 != null) {
                            hashMap.put((Object)"endTime", (Object)date2.getTime());
                        } else {
                            throw new IllegalArgumentException();
                        }
                    }
                    if (map.containsKey((Object)"location")) {
                        hashMap.put((Object)"eventLocation", map.get((Object)"location"));
                    }
                    if (map.containsKey((Object)"summary")) {
                        hashMap.put((Object)"description", map.get((Object)"summary"));
                    }
                    if (map.containsKey((Object)"transparency")) {
                        hashMap.put((Object)"availability", (Object)((int)((String)map.get((Object)"transparency")).equals((Object)"transparent")));
                    }
                    if ((string2 = ad.a(map)) != null) {
                        hashMap.put((Object)"rrule", (Object)string2);
                    }
                    return hashMap;
                }
                throw new IllegalArgumentException();
            }
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException();
    }

    static String c(String string2) {
        IllegalArgumentException illegalArgumentException;
        StringBuilder stringBuilder = new StringBuilder();
        boolean[] arrbl = new boolean[63];
        String[] arrstring = string2.split(",");
        int n2 = arrstring.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            int n3 = Integer.parseInt((String)arrstring[i2]);
            int n4 = n3 + 31;
            if (arrbl[n4]) continue;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(ad.a(n3));
            stringBuilder2.append(",");
            stringBuilder.append(stringBuilder2.toString());
            arrbl[n4] = true;
        }
        if (arrstring.length != 0) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            return stringBuilder.toString();
        }
        illegalArgumentException = new IllegalArgumentException();
        throw illegalArgumentException;
    }

    static URI d(String string2) {
        if (string2 != null) {
            try {
                URI uRI = new URI(string2);
                return uRI;
            }
            catch (URISyntaxException uRISyntaxException) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Invalid param: ");
                stringBuilder.append(string2);
                throw new w(stringBuilder.toString());
            }
        }
        throw new w("Null param");
    }
}


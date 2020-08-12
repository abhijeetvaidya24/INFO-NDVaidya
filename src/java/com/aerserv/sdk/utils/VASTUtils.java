/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.aerserv.sdk.model.ad.VASTProviderAd
 *  com.aerserv.sdk.model.vast.Ad
 *  com.aerserv.sdk.model.vast.CompanionAdsCreative
 *  com.aerserv.sdk.model.vast.Creative
 *  com.aerserv.sdk.model.vast.InLine
 *  com.aerserv.sdk.model.vast.LinearCreative
 *  com.aerserv.sdk.model.vast.PlayableVastCreative
 *  com.aerserv.sdk.view.vastplayer.PlayableAd
 *  com.aerserv.sdk.view.vastplayer.VastPlayer
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Comparator
 *  java.util.Iterator
 *  java.util.LinkedList
 *  java.util.List
 *  java.util.Set
 *  java.util.TreeSet
 */
package com.aerserv.sdk.utils;

import com.aerserv.sdk.model.ad.VASTProviderAd;
import com.aerserv.sdk.model.vast.Ad;
import com.aerserv.sdk.model.vast.CompanionAdsCreative;
import com.aerserv.sdk.model.vast.CompanionAdsRequirement;
import com.aerserv.sdk.model.vast.Creative;
import com.aerserv.sdk.model.vast.Creatives;
import com.aerserv.sdk.model.vast.InLine;
import com.aerserv.sdk.model.vast.LinearCreative;
import com.aerserv.sdk.model.vast.MediaFile;
import com.aerserv.sdk.model.vast.PlayableVastCreative;
import com.aerserv.sdk.model.vast.SequenceEnabled;
import com.aerserv.sdk.model.vast.VAST;
import com.aerserv.sdk.utils.AerServLog;
import com.aerserv.sdk.utils.TimeSpan;
import com.aerserv.sdk.view.vastplayer.PlayableAd;
import com.aerserv.sdk.view.vastplayer.VastPlayer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class VASTUtils {
    private static final String LOG_TAG = "VASTUtils";

    /*
     * Exception decompiling
     */
    public static Integer calculateMillisBeforeSkippable(String var0, long var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl117 : ALOAD : trying to set 1 previously set to 0
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

    public static Integer calculateMillisecondsBeforeClosable(VASTProviderAd vASTProviderAd, int n2) {
        String string = vASTProviderAd.getCloseOffset();
        if (string != null) {
            if (string.matches("^[0-9]?([1-9]|[0-9](\\.\\d+))%$")) {
                Float f2 = Float.valueOf((String)string.replace((CharSequence)"%", (CharSequence)""));
                return (int)((float)n2 * f2.floatValue() / 100.0f);
            }
            if (string.matches("^((2[0-3]|[0-1]\\d):)?[0-5]\\d:[0-5]\\d(\\.\\d+)?$")) {
                return (int)new TimeSpan(string).getTotalMilliseconds();
            }
        }
        return null;
    }

    public static String getFirstVideoUrl(VASTProviderAd vASTProviderAd) {
        try {
            Iterator iterator = VASTUtils.normalizeSequenceEnabled(vASTProviderAd.getFirstPlayableVAST().getAds(), InLine.class).iterator();
            while (iterator.hasNext()) {
                for (PlayableVastCreative playableVastCreative : new PlayableAd((InLine)iterator.next()).getPlayableVastCreatives()) {
                    if (!(playableVastCreative instanceof LinearCreative)) continue;
                    for (MediaFile mediaFile : ((LinearCreative)playableVastCreative).getMediaFiles()) {
                        if (!VastPlayer.supportedMimeTypesSet.contains((Object)mediaFile.getMimeType())) continue;
                        String string = mediaFile.getMediaUri();
                        return string;
                    }
                }
            }
        }
        catch (Exception exception) {
            AerServLog.d(VASTUtils.class.getName(), "Exception caught while trying to getFirstVideoUrl", exception);
        }
        return null;
    }

    public static String getOrElse(String string, String string2) {
        if (string != null && !string.isEmpty()) {
            return string;
        }
        return string2;
    }

    /*
     * Exception decompiling
     */
    public static boolean inLineContainsVpaid(InLine var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl53.1 : ICONST_0 : trying to set 1 previously set to 0
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

    public static boolean mustShowCompanionAds(VASTProviderAd vASTProviderAd) {
        if (vASTProviderAd.getFirstPlayableVAST() == null) {
            return false;
        }
        for (Ad ad : vASTProviderAd.getFirstPlayableVAST().getAds()) {
            if (!(ad instanceof InLine)) continue;
            Iterator iterator = ((InLine)ad).getCreatives().iterator();
            while (iterator.hasNext()) {
                CompanionAdsCreative companionAdsCreative;
                Creative creative = (Creative)iterator.next();
                if (!(creative instanceof CompanionAdsCreative) || (companionAdsCreative = (CompanionAdsCreative)creative).getCompanionAdsRequirement() != CompanionAdsRequirement.ALL && companionAdsCreative.getCompanionAdsRequirement() != CompanionAdsRequirement.ANY) continue;
                return true;
            }
        }
        return false;
    }

    public static LinkedList<? extends SequenceEnabled> normalizeSequenceEnabled(TreeSet<? extends SequenceEnabled> treeSet, Class class_) {
        Comparator<SequenceEnabled> comparator = new Comparator<SequenceEnabled>(){

            public int compare(SequenceEnabled sequenceEnabled, SequenceEnabled sequenceEnabled2) {
                if (sequenceEnabled.getSequencePosition() != null && sequenceEnabled2.getSequencePosition() != null) {
                    return sequenceEnabled.getSequencePosition() - sequenceEnabled2.getSequencePosition();
                }
                if (sequenceEnabled.getSequencePosition() != null && sequenceEnabled2.getSequencePosition() == null) {
                    return -1;
                }
                if (sequenceEnabled.getSequencePosition() == null && sequenceEnabled2.getSequencePosition() != null) {
                    return 1;
                }
                if (sequenceEnabled instanceof CompanionAdsCreative) {
                    return 1;
                }
                return -1;
            }
        };
        ArrayList arrayList = new ArrayList(treeSet);
        Collections.sort((List)arrayList, (Comparator)comparator);
        return new LinkedList((Collection)arrayList);
    }

    public static int safeToInt(String string) {
        try {
            int n2 = Integer.valueOf((String)string);
            return n2;
        }
        catch (Exception exception) {
            return 0;
        }
    }

}


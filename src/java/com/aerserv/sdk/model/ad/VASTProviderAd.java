/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.os.AsyncTask
 *  com.aerserv.sdk.model.vast.CompanionAdsCreative
 *  com.aerserv.sdk.model.vast.LinearCreative
 *  com.aerserv.sdk.model.vast.NonLinearAdsCreative
 *  com.aerserv.sdk.model.vast.Wrapper
 *  java.io.IOException
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.TreeSet
 *  org.xmlpull.v1.XmlPullParserException
 */
package com.aerserv.sdk.model.ad;

import android.net.Uri;
import android.os.AsyncTask;
import com.aerserv.sdk.AerServVirtualCurrency;
import com.aerserv.sdk.analytics.AerServAnalytics;
import com.aerserv.sdk.controller.listener.AdFactoryListener;
import com.aerserv.sdk.controller.listener.VastWrapperCallerListener;
import com.aerserv.sdk.http.HttpTask;
import com.aerserv.sdk.http.HttpTaskListener;
import com.aerserv.sdk.model.Placement;
import com.aerserv.sdk.model.ad.AdType;
import com.aerserv.sdk.model.ad.ProviderAd;
import com.aerserv.sdk.model.vast.Ad;
import com.aerserv.sdk.model.vast.CompanionAd;
import com.aerserv.sdk.model.vast.CompanionAdsCreative;
import com.aerserv.sdk.model.vast.Creative;
import com.aerserv.sdk.model.vast.Creatives;
import com.aerserv.sdk.model.vast.EventType;
import com.aerserv.sdk.model.vast.LinearCreative;
import com.aerserv.sdk.model.vast.NonLinearAd;
import com.aerserv.sdk.model.vast.NonLinearAdsCreative;
import com.aerserv.sdk.model.vast.TrackingEvents;
import com.aerserv.sdk.model.vast.VAST;
import com.aerserv.sdk.model.vast.Vpaid;
import com.aerserv.sdk.model.vast.Wrapper;
import com.aerserv.sdk.utils.AerServLog;
import com.aerserv.sdk.utils.VastErrorHandler;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import org.xmlpull.v1.XmlPullParserException;

public final class VASTProviderAd
implements ProviderAd {
    private static final String providerName = "ASAerServ";
    private String closeOffset;
    private boolean muted;
    private VAST vast;
    private AerServVirtualCurrency virtualCurrencyData;
    private Vpaid vpaid;

    private VASTProviderAd() {
        this.muted = false;
    }

    private VASTProviderAd(Placement placement) {
        block6 : {
            block7 : {
                this.muted = false;
                String string = placement.getAdMarkup();
                if (string == null) break block6;
                if (string.isEmpty()) break block6;
                this.vast = VAST.parseXml(string);
                if (!AerServAnalytics.getInstance().isEnabled()) break block7;
                AerServAnalytics.getInstance().addValue("vast", "parseXml", "vastVersion", this.vast.getVersion());
            }
            this.virtualCurrencyData = placement.getVc();
            this.muted = placement.getStartAdMuted();
            return;
        }
        try {
            throw new IllegalArgumentException("Cannot instantiate VASTAd.  Invalid or empty xml");
        }
        catch (Exception exception) {
            AerServLog.e(this.getClass().getSimpleName(), "Exception when trying to parse vast");
            AerServAnalytics.getInstance().addVastParseError("Invalid XML");
            VastErrorHandler.fireError(VastErrorHandler.Error.INVALID_XML);
            throw new IllegalArgumentException("Cannot instantiate VASTAd.  Invalid xml", (Throwable)exception);
        }
        catch (IOException iOException) {
            AerServLog.e(this.getClass().getSimpleName(), "IOException when trying to parse vast");
            AerServAnalytics.getInstance().addVastParseError("Invalid XML");
            VastErrorHandler.fireError(VastErrorHandler.Error.INVALID_XML);
            throw new IllegalArgumentException("Cannot instantiate VASTAd.  Invalid xml", (Throwable)iOException);
        }
        catch (XmlPullParserException xmlPullParserException) {
            AerServLog.e(this.getClass().getSimpleName(), "There was an error parsing vast.  vast does not conform to spec");
            AerServAnalytics.getInstance().addVastParseError("Does not conform to spec");
            throw new IllegalArgumentException("Cannot instantiate VASTAd.  Invalid xml", (Throwable)xmlPullParserException);
        }
    }

    public static void buildVASTAd(Placement placement, final AdFactoryListener adFactoryListener) {
        AerServLog.d(VASTProviderAd.class.getSimpleName(), "Building VAST ad");
        final VASTProviderAd vASTProviderAd = new VASTProviderAd(placement);
        vASTProviderAd.closeOffset = placement.getCloseOffset();
        if (vASTProviderAd.getVast().getAds().size() == 0) {
            adFactoryListener.adBuildFailed("empty vast");
            return;
        }
        if (vASTProviderAd.vast.getAds().first() instanceof Wrapper) {
            AerServLog.d(VASTProviderAd.class.getSimpleName(), "VAST ad constructed is a wrapper. continue digging.");
            VastWrapperCallerListener vastWrapperCallerListener = new VastWrapperCallerListener(){

                @Override
                public void wrapperCallFailed() {
                    adFactoryListener.adBuildFailed("Could not build the wrapped VAST.  Most likely it's poorly formatted.");
                }

                @Override
                public void wrapperResultsReceived(VAST vAST) {
                    vASTProviderAd.vast.setWrappedVast(vAST);
                    AerServLog.d(VASTProviderAd.class.getSimpleName(), "VAST wrapper successfully traversed");
                    vASTProviderAd.buildVpaidIfExists(adFactoryListener);
                }
            };
            VASTProviderAd.followVastWrapper(vASTProviderAd.vast, vastWrapperCallerListener);
            return;
        }
        vASTProviderAd.buildVpaidIfExists(adFactoryListener);
    }

    /*
     * Exception decompiling
     */
    private void buildVpaidIfExists(AdFactoryListener var1_1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[DOLOOP]], but top level block is 2[DOLOOP]
        // org.benf.cfr.reader.b.a.a.j.a(Op04StructuredStatement.java:432)
        // org.benf.cfr.reader.b.a.a.j.d(Op04StructuredStatement.java:484)
        // org.benf.cfr.reader.b.a.a.i.a(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:692)
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

    private static void followVastWrapper(VAST vAST, final VastWrapperCallerListener vastWrapperCallerListener) {
        new HttpTask(Uri.parse((String)((Wrapper)vAST.getAds().first()).getAdTagUri()).toString(), new HttpTaskListener(){

            @Override
            public void onHttpTaskFailure(String string, int n2) {
                vastWrapperCallerListener.wrapperCallFailed();
            }

            @Override
            public void onHttpTaskSuccess(String string, int n2, Map<String, List<String>> map, String string2) {
                try {
                    final VAST vAST = VAST.parseXml(string2);
                    if (!vAST.getAds().isEmpty() && vAST.getAds().first() instanceof Wrapper) {
                        VASTProviderAd.followVastWrapper(vAST, new VastWrapperCallerListener(){

                            @Override
                            public void wrapperCallFailed() {
                                vastWrapperCallerListener.wrapperCallFailed();
                            }

                            @Override
                            public void wrapperResultsReceived(VAST vAST2) {
                                vAST.setWrappedVast(vAST2);
                                vastWrapperCallerListener.wrapperResultsReceived(vAST);
                            }
                        });
                        return;
                    }
                    if (vAST.getAds().isEmpty()) {
                        AerServLog.d(VASTProviderAd.class.getSimpleName(), "Empty VAST.  Executing fallback.");
                        vastWrapperCallerListener.wrapperCallFailed();
                        return;
                    }
                    vastWrapperCallerListener.wrapperResultsReceived(vAST);
                    return;
                }
                catch (Exception exception) {
                    AerServLog.d(this.getClass().getSimpleName(), "There was an error unwrapping vast.  unwrapped vast does not conform to spec", exception);
                    vastWrapperCallerListener.wrapperCallFailed();
                    AerServAnalytics.getInstance().addVastParseError("Does not conform to spec");
                    VastErrorHandler.fireError(VastErrorHandler.Error.DOES_NOT_CONFORM_TO_SPEC);
                    return;
                }
            }

        }).execute(new Object[0]);
    }

    private List<String> getAllWrapperCompanionClickTrackingUris(VAST vAST) {
        ArrayList arrayList = new ArrayList();
        if (vAST.getAds().first() instanceof Wrapper) {
            Iterator iterator = ((Wrapper)vAST.getAds().first()).getCreatives().iterator();
            while (iterator.hasNext()) {
                Creative creative = (Creative)iterator.next();
                if (!(creative instanceof CompanionAdsCreative)) continue;
                Iterator iterator2 = ((CompanionAdsCreative)creative).getCompanionAds().iterator();
                while (iterator2.hasNext()) {
                    arrayList.addAll(((CompanionAd)iterator2.next()).getClickTrackingUris());
                }
            }
            arrayList.addAll(this.getAllWrapperCompanionClickTrackingUris(vAST.getWrappedVAST()));
        }
        return arrayList;
    }

    private List<String> getAllWrapperErrorUris(VAST vAST) {
        ArrayList arrayList = new ArrayList();
        if (vAST.getAds().first() instanceof Wrapper) {
            arrayList.addAll((Collection)((Wrapper)vAST.getAds().first()).getErrorUris());
            arrayList.addAll(this.getAllWrapperErrorUris(vAST.getWrappedVAST()));
        }
        return arrayList;
    }

    private List<String> getAllWrapperImpressionUris(VAST vAST) {
        ArrayList arrayList = new ArrayList();
        if (vAST.getAds().first() instanceof Wrapper) {
            arrayList.addAll((Collection)((Wrapper)vAST.getAds().first()).getImpressionUris());
            arrayList.addAll(this.getAllWrapperImpressionUris(vAST.getWrappedVAST()));
        }
        return arrayList;
    }

    private List<String> getAllWrapperLinearClickTrackingUris(VAST vAST) {
        ArrayList arrayList = new ArrayList();
        if (vAST.getAds().first() instanceof Wrapper) {
            Iterator iterator = ((Wrapper)vAST.getAds().first()).getCreatives().iterator();
            while (iterator.hasNext()) {
                Creative creative = (Creative)iterator.next();
                if (!(creative instanceof LinearCreative)) continue;
                arrayList.addAll((Collection)((LinearCreative)creative).getClickTrackingUris());
            }
            arrayList.addAll(this.getAllWrapperLinearClickTrackingUris(vAST.getWrappedVAST()));
        }
        return arrayList;
    }

    private TrackingEvents getAllWrapperLinearCreativeTrackingEvents(VAST vAST) {
        TrackingEvents trackingEvents = new TrackingEvents();
        if (vAST.getAds().first() instanceof Wrapper) {
            Iterator iterator = ((Wrapper)vAST.getAds().first()).getCreatives().iterator();
            while (iterator.hasNext()) {
                Creative creative = (Creative)iterator.next();
                if (!(creative instanceof LinearCreative)) continue;
                trackingEvents.addAll((Collection)((LinearCreative)creative).getTrackingEvents());
            }
            trackingEvents.addAll((Collection)this.getAllWrapperLinearCreativeTrackingEvents(vAST.getWrappedVAST()));
        }
        return trackingEvents;
    }

    private TrackingEvents getAllWrapperLinearCreativeTrackingEventsByType(VAST vAST, EventType eventType) {
        TrackingEvents trackingEvents = new TrackingEvents();
        if (vAST.getAds().first() instanceof Wrapper) {
            Iterator iterator = ((Wrapper)vAST.getAds().first()).getCreatives().iterator();
            while (iterator.hasNext()) {
                Creative creative = (Creative)iterator.next();
                if (!(creative instanceof LinearCreative)) continue;
                trackingEvents.addAll((Collection)((LinearCreative)creative).getTrackingEventsByEventType(eventType));
            }
            trackingEvents.addAll((Collection)this.getAllWrapperLinearCreativeTrackingEventsByType(vAST.getWrappedVAST(), eventType));
        }
        return trackingEvents;
    }

    private List<String> getAllWrapperLinearCustomClickUris(VAST vAST) {
        ArrayList arrayList = new ArrayList();
        if (vAST.getAds().first() instanceof Wrapper) {
            Iterator iterator = ((Wrapper)vAST.getAds().first()).getCreatives().iterator();
            while (iterator.hasNext()) {
                Creative creative = (Creative)iterator.next();
                if (!(creative instanceof LinearCreative)) continue;
                arrayList.addAll((Collection)((LinearCreative)creative).getCustomClickTrackingUris());
            }
            arrayList.addAll(this.getAllWrapperLinearCustomClickUris(vAST.getWrappedVAST()));
        }
        return arrayList;
    }

    private List<String> getAllWrapperNonLinearClickTrackingUris(VAST vAST) {
        ArrayList arrayList = new ArrayList();
        if (vAST.getAds().first() instanceof Wrapper) {
            Iterator iterator = ((Wrapper)vAST.getAds().first()).getCreatives().iterator();
            while (iterator.hasNext()) {
                Creative creative = (Creative)iterator.next();
                if (!(creative instanceof NonLinearAdsCreative)) continue;
                Iterator iterator2 = ((NonLinearAdsCreative)creative).getNonLinearAds().iterator();
                while (iterator2.hasNext()) {
                    arrayList.addAll(((NonLinearAd)iterator2.next()).getClickTrackingUris());
                }
            }
            arrayList.addAll(this.getAllWrapperNonLinearClickTrackingUris(vAST.getWrappedVAST()));
        }
        return arrayList;
    }

    private TrackingEvents getAllWrapperNonLinearTrackingEvents(VAST vAST) {
        TrackingEvents trackingEvents = new TrackingEvents();
        if (vAST.getAds().first() instanceof Wrapper) {
            Iterator iterator = ((Wrapper)vAST.getAds().first()).getCreatives().iterator();
            while (iterator.hasNext()) {
                Creative creative = (Creative)iterator.next();
                if (!(creative instanceof NonLinearAdsCreative)) continue;
                trackingEvents.addAll((Collection)((NonLinearAdsCreative)creative).getTrackingEvents());
            }
            trackingEvents.addAll((Collection)this.getAllWrapperNonLinearTrackingEvents(vAST.getWrappedVAST()));
        }
        return trackingEvents;
    }

    private VAST getFirstPlayableVAST(VAST vAST) {
        if (vAST == null) {
            return null;
        }
        if (!vAST.getAds().isEmpty() && vAST.getAds().first() instanceof Wrapper) {
            vAST = this.getFirstPlayableVAST(vAST.getWrappedVAST());
        }
        return vAST;
    }

    @Override
    public AdType getAdType() {
        return AdType.VAST;
    }

    public List<String> getAllWrapperCompanionClickTrackingUris() {
        return this.getAllWrapperCompanionClickTrackingUris(this.vast);
    }

    public List<String> getAllWrapperErrorUris() {
        return this.getAllWrapperErrorUris(this.vast);
    }

    public List<String> getAllWrapperImpressionUris() {
        return this.getAllWrapperImpressionUris(this.vast);
    }

    public List<String> getAllWrapperLinearClickTrackingUris() {
        return this.getAllWrapperLinearClickTrackingUris(this.vast);
    }

    public TrackingEvents getAllWrapperLinearCreativeTrackingEvents() {
        return this.getAllWrapperLinearCreativeTrackingEvents(this.vast);
    }

    public TrackingEvents getAllWrapperLinearCreativeTrackingEventsByType(EventType eventType) {
        return this.getAllWrapperLinearCreativeTrackingEventsByType(this.vast, eventType);
    }

    public List<String> getAllWrapperLinearCustomClickUris() {
        return this.getAllWrapperLinearCustomClickUris(this.vast);
    }

    public List<String> getAllWrapperNonLinearClickTrackingUris() {
        return this.getAllWrapperNonLinearClickTrackingUris(this.vast);
    }

    public TrackingEvents getAllWrapperNonLinearTrackingEvents() {
        return this.getAllWrapperNonLinearTrackingEvents(this.vast);
    }

    public String getCloseOffset() {
        return this.closeOffset;
    }

    public VAST getFirstPlayableVAST() {
        return this.getFirstPlayableVAST(this.vast);
    }

    @Override
    public boolean getIsShowAdCommandRequiredOnPreload() {
        return false;
    }

    @Override
    public String getProviderName() {
        return providerName;
    }

    public VAST getVast() {
        return this.vast;
    }

    @Override
    public AerServVirtualCurrency getVirtualCurrency() {
        return this.virtualCurrencyData;
    }

    public Vpaid getVpaid() {
        return this.vpaid;
    }

    public boolean isMuted() {
        return this.muted;
    }

    public boolean isVirtualCurrencyEnabled() {
        return this.virtualCurrencyData.isEnabled();
    }

}


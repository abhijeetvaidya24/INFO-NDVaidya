/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.util.Log
 *  android.view.View
 *  com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener
 *  com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener
 *  com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener
 *  com.applovin.mediation.adapter.parameters.MaxAdapterInitializationParameters
 *  java.lang.Class
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Set
 */
package com.applovin.mediation.adapters;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener;
import com.applovin.mediation.adapter.parameters.MaxAdapterInitializationParameters;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class MediationAdapterRouter {
    private final Map<String, List<MediationAdapterRouterListenerWrapper>> listeners = new HashMap();
    private final Set<MaxAdapter> loadedAdapters = new HashSet();
    protected MaxAdapter.OnCompletionListener mOnCompletionListener;
    protected final String mTag = this.getClass().getSimpleName();
    private final Set<MaxAdapter> showingAdapters = new HashSet();

    protected MediationAdapterRouter() {
    }

    private void addAdapter(MaxAdapter maxAdapter, MaxAdapterListener maxAdapterListener, String string2, RouterAdLoadType routerAdLoadType, View view) {
        MediationAdapterRouterListenerWrapper mediationAdapterRouterListenerWrapper = new MediationAdapterRouterListenerWrapper(maxAdapter, maxAdapterListener, routerAdLoadType, view);
        Object object = this.listeners.get((Object)string2) != null ? (List)this.listeners.get((Object)string2) : new ArrayList(1);
        object.add((Object)mediationAdapterRouterListenerWrapper);
        this.listeners.put((Object)string2, object);
    }

    private void addLoadedAdapter(MaxAdapter maxAdapter) {
        this.loadedAdapters.add((Object)maxAdapter);
    }

    private List<MediationAdapterRouterListenerWrapper> getListenerWrappers(String string2) {
        if (this.listeners.containsKey((Object)string2)) {
            return new ArrayList((Collection)this.listeners.get((Object)string2));
        }
        return null;
    }

    private boolean isAdLoaded(MaxAdapter maxAdapter) {
        return this.loadedAdapters.contains((Object)maxAdapter);
    }

    private boolean isAdShowing(MaxAdapter maxAdapter) {
        return this.showingAdapters.contains((Object)maxAdapter);
    }

    private void removeLoadedAdapter(MaxAdapter maxAdapter) {
        this.loadedAdapters.remove((Object)maxAdapter);
    }

    private void removeShowingAdapter(MaxAdapter maxAdapter) {
        this.showingAdapters.remove((Object)maxAdapter);
    }

    void addAdViewAdapter(MaxAdapter maxAdapter, MaxAdViewAdapterListener maxAdViewAdapterListener, String string2, View view) {
        this.addAdapter(maxAdapter, (MaxAdapterListener)maxAdViewAdapterListener, string2, RouterAdLoadType.ADVIEW, view);
    }

    void addInterstitialAdapter(MaxAdapter maxAdapter, MaxInterstitialAdapterListener maxInterstitialAdapterListener, String string2) {
        this.addAdapter(maxAdapter, (MaxAdapterListener)maxInterstitialAdapterListener, string2, RouterAdLoadType.INTERSTITIAL, null);
    }

    void addRewardedAdapter(MaxAdapter maxAdapter, MaxRewardedAdapterListener maxRewardedAdapterListener, String string2) {
        this.addAdapter(maxAdapter, (MaxAdapterListener)maxRewardedAdapterListener, string2, RouterAdLoadType.REWARDED, null);
    }

    void addShowingAdapter(MaxAdapter maxAdapter) {
        this.showingAdapters.add((Object)maxAdapter);
    }

    abstract void initialize(MaxAdapterInitializationParameters var1, Activity var2, MaxAdapter.OnCompletionListener var3);

    protected void log(String string2) {
        Log.i((String)this.mTag, (String)string2);
    }

    protected void log(String string2, Throwable throwable) {
        Log.i((String)this.mTag, (String)string2, (Throwable)throwable);
    }

    protected void onAdClicked(String string2) {
        List<MediationAdapterRouterListenerWrapper> list = this.getListenerWrappers(string2);
        if (list != null && list.size() > 0) {
            for (MediationAdapterRouterListenerWrapper mediationAdapterRouterListenerWrapper : list) {
                if (!this.isAdShowing(mediationAdapterRouterListenerWrapper.getAdapter())) continue;
                RouterAdLoadType routerAdLoadType = mediationAdapterRouterListenerWrapper.getLoadType();
                MaxAdapterListener maxAdapterListener = mediationAdapterRouterListenerWrapper.getListener();
                if (routerAdLoadType == RouterAdLoadType.INTERSTITIAL) {
                    this.log("Interstitial clicked");
                    ((MaxInterstitialAdapterListener)maxAdapterListener).onInterstitialAdClicked();
                    continue;
                }
                if (routerAdLoadType == RouterAdLoadType.REWARDED) {
                    this.log("Rewarded clicked");
                    ((MaxRewardedAdapterListener)maxAdapterListener).onRewardedAdClicked();
                    continue;
                }
                if (routerAdLoadType != RouterAdLoadType.ADVIEW) continue;
                this.log("AdView clicked");
                ((MaxAdViewAdapterListener)maxAdapterListener).onAdViewAdClicked();
            }
        }
    }

    protected void onAdDisplayFailed(String string2, MaxAdapterError maxAdapterError) {
        List<MediationAdapterRouterListenerWrapper> list = this.getListenerWrappers(string2);
        if (list != null && list.size() > 0) {
            for (MediationAdapterRouterListenerWrapper mediationAdapterRouterListenerWrapper : list) {
                if (!this.isAdShowing(mediationAdapterRouterListenerWrapper.getAdapter())) continue;
                RouterAdLoadType routerAdLoadType = mediationAdapterRouterListenerWrapper.getLoadType();
                MaxAdapterListener maxAdapterListener = mediationAdapterRouterListenerWrapper.getListener();
                if (routerAdLoadType == RouterAdLoadType.INTERSTITIAL) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Interstitial failed to display with error: ");
                    stringBuilder.append(maxAdapterError.toString());
                    this.log(stringBuilder.toString());
                    ((MaxInterstitialAdapterListener)maxAdapterListener).onInterstitialAdDisplayFailed(maxAdapterError);
                    continue;
                }
                if (routerAdLoadType == RouterAdLoadType.REWARDED) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Rewarded failed to display with error: ");
                    stringBuilder.append(maxAdapterError.toString());
                    this.log(stringBuilder.toString());
                    ((MaxRewardedAdapterListener)maxAdapterListener).onRewardedAdDisplayFailed(maxAdapterError);
                    continue;
                }
                if (routerAdLoadType != RouterAdLoadType.ADVIEW) continue;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("AdView failed to display with error: ");
                stringBuilder.append(maxAdapterError.toString());
                this.log(stringBuilder.toString());
                ((MaxAdViewAdapterListener)maxAdapterListener).onAdViewAdDisplayFailed(maxAdapterError);
            }
        }
    }

    protected void onAdDisplayed(String string2) {
        List<MediationAdapterRouterListenerWrapper> list = this.getListenerWrappers(string2);
        if (list != null && list.size() > 0) {
            for (MediationAdapterRouterListenerWrapper mediationAdapterRouterListenerWrapper : list) {
                if (!this.isAdShowing(mediationAdapterRouterListenerWrapper.getAdapter())) continue;
                RouterAdLoadType routerAdLoadType = mediationAdapterRouterListenerWrapper.getLoadType();
                MaxAdapterListener maxAdapterListener = mediationAdapterRouterListenerWrapper.getListener();
                if (routerAdLoadType == RouterAdLoadType.INTERSTITIAL) {
                    this.log("Interstitial shown");
                    ((MaxInterstitialAdapterListener)maxAdapterListener).onInterstitialAdDisplayed();
                    continue;
                }
                if (routerAdLoadType == RouterAdLoadType.REWARDED) {
                    this.log("Rewarded shown");
                    ((MaxRewardedAdapterListener)maxAdapterListener).onRewardedAdDisplayed();
                    continue;
                }
                if (routerAdLoadType != RouterAdLoadType.ADVIEW) continue;
                this.log("AdView shown");
                ((MaxAdViewAdapterListener)maxAdapterListener).onAdViewAdDisplayed();
            }
        }
    }

    protected void onAdHidden(String string2) {
        List<MediationAdapterRouterListenerWrapper> list = this.getListenerWrappers(string2);
        if (list != null && list.size() > 0) {
            for (MediationAdapterRouterListenerWrapper mediationAdapterRouterListenerWrapper : list) {
                if (!this.isAdShowing(mediationAdapterRouterListenerWrapper.getAdapter())) continue;
                RouterAdLoadType routerAdLoadType = mediationAdapterRouterListenerWrapper.getLoadType();
                MaxAdapterListener maxAdapterListener = mediationAdapterRouterListenerWrapper.getListener();
                if (routerAdLoadType == RouterAdLoadType.INTERSTITIAL) {
                    this.log("Interstitial hidden");
                    ((MaxInterstitialAdapterListener)maxAdapterListener).onInterstitialAdHidden();
                    continue;
                }
                if (routerAdLoadType == RouterAdLoadType.REWARDED) {
                    this.log("Rewarded hidden");
                    ((MaxRewardedAdapterListener)maxAdapterListener).onRewardedAdHidden();
                    continue;
                }
                if (routerAdLoadType != RouterAdLoadType.ADVIEW) continue;
                this.log("AdView hidden");
                ((MaxAdViewAdapterListener)maxAdapterListener).onAdViewAdHidden();
            }
        }
    }

    protected void onAdLoadFailed(String string2, MaxAdapterError maxAdapterError) {
        List<MediationAdapterRouterListenerWrapper> list = this.getListenerWrappers(string2);
        if (list != null && list.size() > 0) {
            for (MediationAdapterRouterListenerWrapper mediationAdapterRouterListenerWrapper : list) {
                if (this.isAdLoaded(mediationAdapterRouterListenerWrapper.getAdapter())) continue;
                RouterAdLoadType routerAdLoadType = mediationAdapterRouterListenerWrapper.getLoadType();
                MaxAdapterListener maxAdapterListener = mediationAdapterRouterListenerWrapper.getListener();
                if (routerAdLoadType == RouterAdLoadType.INTERSTITIAL) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Interstitial failed to load with error: ");
                    stringBuilder.append(maxAdapterError.toString());
                    this.log(stringBuilder.toString());
                    ((MaxInterstitialAdapterListener)maxAdapterListener).onInterstitialAdLoadFailed(maxAdapterError);
                    continue;
                }
                if (routerAdLoadType == RouterAdLoadType.REWARDED) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Rewarded failed to load with error: ");
                    stringBuilder.append(maxAdapterError.toString());
                    this.log(stringBuilder.toString());
                    ((MaxRewardedAdapterListener)maxAdapterListener).onRewardedAdLoadFailed(maxAdapterError);
                    continue;
                }
                if (routerAdLoadType != RouterAdLoadType.ADVIEW) continue;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("AdView failed to load with error: ");
                stringBuilder.append(maxAdapterError.toString());
                this.log(stringBuilder.toString());
                ((MaxAdViewAdapterListener)maxAdapterListener).onAdViewAdLoadFailed(maxAdapterError);
            }
        }
    }

    protected void onAdLoaded(String string2) {
        List<MediationAdapterRouterListenerWrapper> list = this.getListenerWrappers(string2);
        if (list != null && list.size() > 0) {
            for (MediationAdapterRouterListenerWrapper mediationAdapterRouterListenerWrapper : list) {
                if (this.isAdLoaded(mediationAdapterRouterListenerWrapper.getAdapter())) continue;
                this.addLoadedAdapter(mediationAdapterRouterListenerWrapper.getAdapter());
                RouterAdLoadType routerAdLoadType = mediationAdapterRouterListenerWrapper.getLoadType();
                MaxAdapterListener maxAdapterListener = mediationAdapterRouterListenerWrapper.getListener();
                if (routerAdLoadType == RouterAdLoadType.INTERSTITIAL) {
                    this.log("Interstitial loaded");
                    ((MaxInterstitialAdapterListener)maxAdapterListener).onInterstitialAdLoaded();
                    continue;
                }
                if (routerAdLoadType == RouterAdLoadType.REWARDED) {
                    this.log("Rewarded loaded");
                    ((MaxRewardedAdapterListener)maxAdapterListener).onRewardedAdLoaded();
                    continue;
                }
                if (routerAdLoadType != RouterAdLoadType.ADVIEW) continue;
                this.log("AdView loaded");
                ((MaxAdViewAdapterListener)maxAdapterListener).onAdViewAdLoaded(mediationAdapterRouterListenerWrapper.getAdView());
            }
        }
    }

    protected void onAdViewAdCollapsed(String string2) {
        List<MediationAdapterRouterListenerWrapper> list = this.getListenerWrappers(string2);
        if (list != null && list.size() > 0) {
            for (MediationAdapterRouterListenerWrapper mediationAdapterRouterListenerWrapper : list) {
                if (!this.isAdShowing(mediationAdapterRouterListenerWrapper.getAdapter())) continue;
                RouterAdLoadType routerAdLoadType = mediationAdapterRouterListenerWrapper.getLoadType();
                MaxAdapterListener maxAdapterListener = mediationAdapterRouterListenerWrapper.getListener();
                if (routerAdLoadType != RouterAdLoadType.ADVIEW) continue;
                this.log("AdView collapsed");
                ((MaxAdViewAdapterListener)maxAdapterListener).onAdViewAdCollapsed();
            }
        }
    }

    protected void onAdViewAdExpanded(String string2) {
        List<MediationAdapterRouterListenerWrapper> list = this.getListenerWrappers(string2);
        if (list != null && list.size() > 0) {
            for (MediationAdapterRouterListenerWrapper mediationAdapterRouterListenerWrapper : list) {
                if (!this.isAdShowing(mediationAdapterRouterListenerWrapper.getAdapter())) continue;
                RouterAdLoadType routerAdLoadType = mediationAdapterRouterListenerWrapper.getLoadType();
                MaxAdapterListener maxAdapterListener = mediationAdapterRouterListenerWrapper.getListener();
                if (routerAdLoadType != RouterAdLoadType.ADVIEW) continue;
                this.log("AdView expanded");
                ((MaxAdViewAdapterListener)maxAdapterListener).onAdViewAdExpanded();
            }
        }
    }

    protected void onRewardedAdVideoCompleted(String string2) {
        List<MediationAdapterRouterListenerWrapper> list = this.getListenerWrappers(string2);
        if (list != null && list.size() > 0) {
            for (MediationAdapterRouterListenerWrapper mediationAdapterRouterListenerWrapper : list) {
                if (!this.isAdShowing(mediationAdapterRouterListenerWrapper.getAdapter())) continue;
                RouterAdLoadType routerAdLoadType = mediationAdapterRouterListenerWrapper.getLoadType();
                MaxAdapterListener maxAdapterListener = mediationAdapterRouterListenerWrapper.getListener();
                if (routerAdLoadType != RouterAdLoadType.REWARDED) continue;
                this.log("Rewarded video completed");
                ((MaxRewardedAdapterListener)maxAdapterListener).onRewardedAdVideoCompleted();
            }
        }
    }

    protected void onRewardedAdVideoStarted(String string2) {
        List<MediationAdapterRouterListenerWrapper> list = this.getListenerWrappers(string2);
        if (list != null && list.size() > 0) {
            for (MediationAdapterRouterListenerWrapper mediationAdapterRouterListenerWrapper : list) {
                if (!this.isAdShowing(mediationAdapterRouterListenerWrapper.getAdapter())) continue;
                RouterAdLoadType routerAdLoadType = mediationAdapterRouterListenerWrapper.getLoadType();
                MaxAdapterListener maxAdapterListener = mediationAdapterRouterListenerWrapper.getListener();
                if (routerAdLoadType != RouterAdLoadType.REWARDED) continue;
                this.log("Rewarded video started");
                ((MaxRewardedAdapterListener)maxAdapterListener).onRewardedAdVideoStarted();
            }
        }
    }

    protected void onUserRewarded(String string2, MaxReward maxReward) {
        List<MediationAdapterRouterListenerWrapper> list = this.getListenerWrappers(string2);
        if (list != null && list.size() > 0) {
            for (MediationAdapterRouterListenerWrapper mediationAdapterRouterListenerWrapper : list) {
                if (!this.isAdShowing(mediationAdapterRouterListenerWrapper.getAdapter())) continue;
                RouterAdLoadType routerAdLoadType = mediationAdapterRouterListenerWrapper.getLoadType();
                MaxAdapterListener maxAdapterListener = mediationAdapterRouterListenerWrapper.getListener();
                if (routerAdLoadType != RouterAdLoadType.REWARDED) continue;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Rewarded user with reward: ");
                stringBuilder.append((Object)maxReward);
                this.log(stringBuilder.toString());
                ((MaxRewardedAdapterListener)maxAdapterListener).onUserRewarded(maxReward);
            }
        }
    }

    void removeAdapter(MaxAdapter maxAdapter, String string2) {
        this.removeLoadedAdapter(maxAdapter);
        this.removeShowingAdapter(maxAdapter);
        List list = (List)this.listeners.get((Object)string2);
        if (list != null && list.size() > 0) {
            MediationAdapterRouterListenerWrapper mediationAdapterRouterListenerWrapper;
            block3 : {
                MediationAdapterRouterListenerWrapper mediationAdapterRouterListenerWrapper2;
                Iterator iterator = list.iterator();
                do {
                    boolean bl = iterator.hasNext();
                    mediationAdapterRouterListenerWrapper = null;
                    if (!bl) break block3;
                } while ((mediationAdapterRouterListenerWrapper2 = (MediationAdapterRouterListenerWrapper)iterator.next()).getAdapter() != maxAdapter);
                mediationAdapterRouterListenerWrapper = mediationAdapterRouterListenerWrapper2;
            }
            if (mediationAdapterRouterListenerWrapper != null) {
                list.remove(mediationAdapterRouterListenerWrapper);
            }
        }
    }

    void updateAdView(View view, String string2) {
        List<MediationAdapterRouterListenerWrapper> list = this.getListenerWrappers(string2);
        if (list != null && list.size() > 0) {
            for (MediationAdapterRouterListenerWrapper mediationAdapterRouterListenerWrapper : list) {
                if (mediationAdapterRouterListenerWrapper.getAdView() != null) continue;
                mediationAdapterRouterListenerWrapper.setAdView(view);
                break;
            }
        }
    }

    private final class MediationAdapterRouterListenerWrapper {
        private View mAdView;
        private final MaxAdapter mAdapter;
        private final MaxAdapterListener mListener;
        private final RouterAdLoadType mLoadType;

        MediationAdapterRouterListenerWrapper(MaxAdapter maxAdapter, MaxAdapterListener maxAdapterListener, RouterAdLoadType routerAdLoadType, View view) {
            this.mAdapter = maxAdapter;
            this.mListener = maxAdapterListener;
            this.mLoadType = routerAdLoadType;
            this.mAdView = view;
        }

        View getAdView() {
            return this.mAdView;
        }

        MaxAdapter getAdapter() {
            return this.mAdapter;
        }

        MaxAdapterListener getListener() {
            return this.mListener;
        }

        RouterAdLoadType getLoadType() {
            return this.mLoadType;
        }

        void setAdView(View view) {
            this.mAdView = view;
        }
    }

    private static final class RouterAdLoadType
    extends Enum<RouterAdLoadType> {
        private static final /* synthetic */ RouterAdLoadType[] $VALUES;
        public static final /* enum */ RouterAdLoadType ADVIEW;
        public static final /* enum */ RouterAdLoadType INTERSTITIAL;
        public static final /* enum */ RouterAdLoadType REWARDED;

        static {
            INTERSTITIAL = new RouterAdLoadType();
            REWARDED = new RouterAdLoadType();
            ADVIEW = new RouterAdLoadType();
            RouterAdLoadType[] arrrouterAdLoadType = new RouterAdLoadType[]{INTERSTITIAL, REWARDED, ADVIEW};
            $VALUES = arrrouterAdLoadType;
        }

        public static RouterAdLoadType valueOf(String string2) {
            return (RouterAdLoadType)Enum.valueOf(RouterAdLoadType.class, (String)string2);
        }

        public static RouterAdLoadType[] values() {
            return (RouterAdLoadType[])$VALUES.clone();
        }
    }

}


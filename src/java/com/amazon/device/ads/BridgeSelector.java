/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.amazon.device.ads.AmazonAdSDKBridgeFactory
 *  com.amazon.device.ads.AmazonViewableAdSDKBridgeFactory
 *  com.amazon.device.ads.MraidAdSDKBridgeFactory
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.HashSet
 *  java.util.Set
 *  java.util.regex.Matcher
 *  java.util.regex.Pattern
 */
package com.amazon.device.ads;

import com.amazon.device.ads.AAXCreative;
import com.amazon.device.ads.AdSDKBridgeFactory;
import com.amazon.device.ads.AmazonAdSDKBridgeFactory;
import com.amazon.device.ads.AmazonViewableAdSDKBridgeFactory;
import com.amazon.device.ads.MraidAdSDKBridgeFactory;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class BridgeSelector {
    private static BridgeSelector instance = new BridgeSelector();
    private final AmazonViewableAdSDKBridgeFactory amazonAdSDKViewableBridgeFactory;
    private HashMap<AAXCreative, HashSet<AdSDKBridgeFactory>> bridgesForCT;
    private HashMap<String, HashSet<AdSDKBridgeFactory>> bridgesForPattern;
    private HashMap<String, HashSet<AdSDKBridgeFactory>> bridgesForResourcePattern;
    private HashMap<String, Pattern> patterns;

    BridgeSelector() {
        this(new AmazonViewableAdSDKBridgeFactory());
        this.initialize();
    }

    BridgeSelector(AmazonViewableAdSDKBridgeFactory amazonViewableAdSDKBridgeFactory) {
        this.amazonAdSDKViewableBridgeFactory = amazonViewableAdSDKBridgeFactory;
    }

    public static BridgeSelector getInstance() {
        return instance;
    }

    private Pattern getPattern(String string) {
        Pattern pattern = (Pattern)this.patterns.get((Object)string);
        if (pattern == null) {
            pattern = Pattern.compile((String)string);
            this.patterns.put((Object)string, (Object)pattern);
        }
        return pattern;
    }

    public void addBridgeFactory(AAXCreative aAXCreative, AdSDKBridgeFactory adSDKBridgeFactory) {
        HashSet hashSet = (HashSet)this.bridgesForCT.get((Object)aAXCreative);
        if (hashSet == null) {
            hashSet = new HashSet();
            this.bridgesForCT.put((Object)aAXCreative, (Object)hashSet);
        }
        hashSet.add((Object)adSDKBridgeFactory);
    }

    public void addBridgeFactoryForHtmlScriptTag(String string, AdSDKBridgeFactory adSDKBridgeFactory) {
        String string2 = String.format((String)"<[Ss][Cc][Rr][Ii][Pp][Tt](\\s[^>]*\\s|\\s)[Ss][Rr][Cc]\\s*=\\s*[\"']%s[\"']", (Object[])new Object[]{string});
        HashSet hashSet = (HashSet)this.bridgesForPattern.get((Object)string2);
        if (hashSet == null) {
            hashSet = new HashSet();
            this.bridgesForPattern.put((Object)string2, (Object)hashSet);
        }
        hashSet.add((Object)adSDKBridgeFactory);
    }

    public void addBridgeFactoryForResourceLoad(String string, AdSDKBridgeFactory adSDKBridgeFactory) {
        String string2 = String.format((String)".*\\W%s$|^%s$", (Object[])new Object[]{string, string});
        HashSet hashSet = (HashSet)this.bridgesForResourcePattern.get((Object)string2);
        if (hashSet == null) {
            hashSet = new HashSet();
            this.bridgesForResourcePattern.put((Object)string2, (Object)hashSet);
        }
        hashSet.add((Object)adSDKBridgeFactory);
        hashSet.add((Object)this.amazonAdSDKViewableBridgeFactory);
    }

    public void addBridgeFactoryForScript(String string, AdSDKBridgeFactory adSDKBridgeFactory) {
        this.addBridgeFactoryForHtmlScriptTag(string, adSDKBridgeFactory);
        this.addBridgeFactoryForResourceLoad(string, adSDKBridgeFactory);
    }

    public Set<AdSDKBridgeFactory> getBridgeFactories(AAXCreative aAXCreative) {
        Set set = (Set)this.bridgesForCT.get((Object)aAXCreative);
        if (set == null) {
            set = new HashSet();
        }
        set.add((Object)this.amazonAdSDKViewableBridgeFactory);
        return set;
    }

    public Set<AdSDKBridgeFactory> getBridgeFactories(String string) {
        HashSet hashSet = new HashSet();
        for (String string2 : this.bridgesForPattern.keySet()) {
            if (!this.getPattern(string2).matcher((CharSequence)string).find()) continue;
            hashSet.addAll((Collection)this.bridgesForPattern.get((Object)string2));
        }
        hashSet.add((Object)this.amazonAdSDKViewableBridgeFactory);
        return hashSet;
    }

    public Set<AdSDKBridgeFactory> getBridgeFactoriesForResourceLoad(String string) {
        HashSet hashSet = new HashSet();
        for (String string2 : this.bridgesForResourcePattern.keySet()) {
            if (!this.getPattern(string2).matcher((CharSequence)string).find()) continue;
            hashSet.addAll((Collection)this.bridgesForResourcePattern.get((Object)string2));
        }
        hashSet.add((Object)this.amazonAdSDKViewableBridgeFactory);
        return hashSet;
    }

    void initialize() {
        this.bridgesForCT = new HashMap();
        this.bridgesForPattern = new HashMap();
        this.patterns = new HashMap();
        this.bridgesForResourcePattern = new HashMap();
        this.addBridgeFactoryForScript("amazon.js", (AdSDKBridgeFactory)new AmazonAdSDKBridgeFactory());
        MraidAdSDKBridgeFactory mraidAdSDKBridgeFactory = new MraidAdSDKBridgeFactory();
        this.addBridgeFactory(AAXCreative.MRAID1, (AdSDKBridgeFactory)mraidAdSDKBridgeFactory);
        this.addBridgeFactory(AAXCreative.MRAID2, (AdSDKBridgeFactory)mraidAdSDKBridgeFactory);
        this.addBridgeFactory(AAXCreative.INTERSTITIAL, (AdSDKBridgeFactory)mraidAdSDKBridgeFactory);
        this.addBridgeFactoryForScript("mraid.js", (AdSDKBridgeFactory)mraidAdSDKBridgeFactory);
    }
}


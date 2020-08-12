/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.appsgeyser.multiTabApp.suggestions.RemoteSuggestionItem
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 */
package com.appsgeyser.multiTabApp.suggestions;

import com.appsgeyser.multiTabApp.suggestions.RemoteSuggestionItem;
import java.util.ArrayList;

public interface SuggestionsListener {
    public void onReceiveSuggestions(ArrayList<RemoteSuggestionItem> var1, String var2);
}


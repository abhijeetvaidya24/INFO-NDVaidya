/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.ogury.consent.manager.util.consent.cocoartf1671
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.ogury.consent.manager;

import android.content.Context;
import com.ogury.consent.manager.ConsentListener;
import com.ogury.consent.manager.rtf1;
import com.ogury.consent.manager.tx6480;
import com.ogury.consent.manager.util.consent.cocoartf1671;

public final class ConsentManager {
    public static final ConsentManager INSTANCE = new ConsentManager();
    private static rtf1 a = new rtf1();
    private static String b = "";
    private static String c = "";

    private ConsentManager() {
    }

    public static final void ask(Context context, String string2, ConsentListener consentListener) {
        tx6480.b((Object)context, "context");
        tx6480.b(string2, "assetKey");
        tx6480.b(consentListener, "consentListener");
        if (!a.a()) {
            rtf1.a(context, b);
            rtf1.a(c);
            a.a((ConsentListener)new cocoartf1671(consentListener));
            a.a(context, string2, "ask");
        }
    }

    public static final void edit(Context context, String string2, ConsentListener consentListener) {
        tx6480.b((Object)context, "context");
        tx6480.b(string2, "assetKey");
        tx6480.b(consentListener, "consentListener");
        if (!a.a()) {
            rtf1.a(context, b);
            rtf1.a(c);
            a.a((ConsentListener)new cocoartf1671(consentListener));
            a.a(context, string2, "edit");
        }
    }

    public static final String getIabString() {
        return rtf1.b();
    }

    public static final boolean isAccepted(String string2) {
        tx6480.b(string2, "vendorSlug");
        tx6480.b(string2, "$receiver");
        StringBuilder stringBuilder = new StringBuilder("\"");
        stringBuilder.append(string2);
        stringBuilder.append("\"");
        return rtf1.b(stringBuilder.toString());
    }

    public static final boolean isPurposeAccepted(int n2) {
        if (n2 >= 0 && 4 >= n2) {
            Purpose purpose = n2 == Purpose.INFORMATION.ordinal() ? Purpose.INFORMATION : (n2 == Purpose.PERSONALISATION.ordinal() ? Purpose.PERSONALISATION : (n2 == Purpose.AD.ordinal() ? Purpose.AD : (n2 == Purpose.CONTENT.ordinal() ? Purpose.CONTENT : Purpose.MEASUREMENT)));
            return rtf1.a(purpose);
        }
        return false;
    }

    public static final boolean isPurposeAccepted(Purpose purpose) {
        tx6480.b((Object)purpose, "purpose");
        return rtf1.a(purpose);
    }

    public final String getFakeBundleID() {
        return b;
    }

    public final String getFakeShowFormat() {
        return c;
    }

    public final void setClientConsentImpl(rtf1 rtf12) {
        tx6480.b(rtf12, "consentImpl");
        a = rtf12;
    }

    public static final class Answer
    extends Enum<Answer> {
        private static final /* synthetic */ Answer[] $VALUES;
        public static final /* enum */ Answer FULL_APPROVAL;
        public static final /* enum */ Answer NO_ANSWER;
        public static final /* enum */ Answer PARTIAL_APPROVAL;
        public static final /* enum */ Answer REFUSAL;

        static {
            Answer answer;
            Answer answer2;
            Answer answer3;
            Answer answer4;
            Answer[] arranswer = new Answer[4];
            FULL_APPROVAL = answer = new Answer();
            arranswer[0] = answer;
            PARTIAL_APPROVAL = answer3 = new Answer();
            arranswer[1] = answer3;
            REFUSAL = answer4 = new Answer();
            arranswer[2] = answer4;
            NO_ANSWER = answer2 = new Answer();
            arranswer[3] = answer2;
            $VALUES = arranswer;
        }

        public static Answer valueOf(String string2) {
            return (Answer)Enum.valueOf(Answer.class, (String)string2);
        }

        public static Answer[] values() {
            return (Answer[])$VALUES.clone();
        }
    }

    public static final class Purpose
    extends Enum<Purpose> {
        private static final /* synthetic */ Purpose[] $VALUES;
        public static final /* enum */ Purpose AD;
        public static final /* enum */ Purpose CONTENT;
        public static final /* enum */ Purpose INFORMATION;
        public static final /* enum */ Purpose MEASUREMENT;
        public static final /* enum */ Purpose PERSONALISATION;

        static {
            Purpose purpose;
            Purpose purpose2;
            Purpose purpose3;
            Purpose purpose4;
            Purpose purpose5;
            Purpose[] arrpurpose = new Purpose[5];
            INFORMATION = purpose2 = new Purpose();
            arrpurpose[0] = purpose2;
            PERSONALISATION = purpose4 = new Purpose();
            arrpurpose[1] = purpose4;
            AD = purpose = new Purpose();
            arrpurpose[2] = purpose;
            CONTENT = purpose5 = new Purpose();
            arrpurpose[3] = purpose5;
            MEASUREMENT = purpose3 = new Purpose();
            arrpurpose[4] = purpose3;
            $VALUES = arrpurpose;
        }

        public static Purpose valueOf(String string2) {
            return (Purpose)Enum.valueOf(Purpose.class, (String)string2);
        }

        public static Purpose[] values() {
            return (Purpose[])$VALUES.clone();
        }
    }

}


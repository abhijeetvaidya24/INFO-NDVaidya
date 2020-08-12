/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  co.ogury.crashreport.tx7200
 *  co.ogury.crashreport.tx8640
 *  co.ogury.crashreport.viewh8400
 *  co.ogury.crashreport.viewkind0
 *  java.lang.Appendable
 *  java.lang.CharSequence
 *  java.lang.Character
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package co.ogury.crashreport;

import co.ogury.crashreport.tx7200;
import co.ogury.crashreport.tx8640;
import co.ogury.crashreport.viewh8400;
import co.ogury.crashreport.viewkind0;

class pard
extends viewkind0 {
    public static <T, A extends Appendable> A a(T[] arrT, A a2, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int n2, CharSequence charSequence4, tx7200<? super T, ? extends CharSequence> tx72002) {
        tx8640.b(arrT, (String)"$receiver");
        tx8640.b(a2, (String)"buffer");
        tx8640.b((Object)charSequence, (String)"separator");
        tx8640.b((Object)charSequence2, (String)"prefix");
        tx8640.b((Object)charSequence3, (String)"postfix");
        tx8640.b((Object)charSequence4, (String)"truncated");
        a2.append(charSequence2);
        int n3 = arrT.length;
        int n4 = 0;
        for (int k = 0; k < n3; ++k) {
            T t2 = arrT[k];
            int n5 = 1;
            if (++n4 > n5) {
                a2.append(charSequence);
            }
            if (n2 >= 0 && n4 > n2) break;
            tx8640.b(a2, (String)"$receiver");
            if (tx72002 != null) {
                a2.append((CharSequence)tx72002.a());
                continue;
            }
            if (t2 != null) {
                n5 = t2 instanceof CharSequence;
            }
            if (n5 != 0) {
                a2.append((CharSequence)t2);
                continue;
            }
            if (t2 instanceof Character) {
                a2.append(((Character)t2).charValue());
                continue;
            }
            a2.append((CharSequence)String.valueOf(t2));
        }
        if (n2 >= 0 && n4 > n2) {
            a2.append(charSequence4);
        }
        a2.append(charSequence3);
        return a2;
    }

    public static /* synthetic */ String a(Object[] arrobject, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int n2, CharSequence charSequence4, tx7200 tx72002, int n3) {
        CharSequence charSequence5 = "";
        CharSequence charSequence6 = "";
        CharSequence charSequence7 = "...";
        tx8640.b((Object)arrobject, (String)"$receiver");
        tx8640.b((Object)charSequence, (String)"separator");
        tx8640.b((Object)charSequence5, (String)"prefix");
        tx8640.b((Object)charSequence6, (String)"postfix");
        tx8640.b((Object)charSequence7, (String)"truncated");
        String string = ((StringBuilder)viewh8400.a((Object[])arrobject, (Appendable)((Appendable)new StringBuilder()), (CharSequence)charSequence, (CharSequence)charSequence5, (CharSequence)charSequence6, (int)-1, (CharSequence)charSequence7, null)).toString();
        tx8640.a((Object)string, (String)"joinTo(StringBuilder(), \u2026ed, transform).toString()");
        return string;
    }
}


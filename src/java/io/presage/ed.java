/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.presage.dc
 *  java.lang.CharSequence
 *  java.lang.String
 */
package io.presage;

import io.presage.ao;
import io.presage.dc;
import io.presage.de;
import io.presage.df;
import io.presage.dp;
import io.presage.du;
import io.presage.ec;

class ed
extends ec {
    public static final int a(CharSequence charSequence) {
        return -1 + charSequence.length();
    }

    public static final int a(CharSequence charSequence, int n2) {
        if (!(charSequence instanceof String)) {
            return du.a(charSequence, new char[]{'.'}, n2);
        }
        return ((String)charSequence).indexOf(46, n2);
    }

    public static /* synthetic */ int a(CharSequence charSequence, int n2, int n3) {
        if ((n3 & 2) != 0) {
            n2 = 0;
        }
        return du.a(charSequence, n2);
    }

    private static final int a(CharSequence charSequence, CharSequence charSequence2, int n2, boolean bl2) {
        dc dc2 = new de(df.a(0), df.a(n2, charSequence.length()));
        if (charSequence instanceof String && charSequence2 instanceof String) {
            int n3 = dc2.a();
            int n4 = dc2.b();
            int n5 = dc2.c();
            if (n5 > 0 ? n3 <= n4 : n3 >= n4) {
                do {
                    if (du.a((String)charSequence2, (String)charSequence, n3, charSequence2.length(), bl2)) {
                        return n3;
                    }
                    if (n3 != n4) {
                        n3 += n5;
                        continue;
                    }
                    break;
                } while (true);
            }
        } else {
            int n6 = dc2.a();
            int n7 = dc2.b();
            int n8 = dc2.c();
            if (n8 > 0 ? n6 <= n7 : n6 >= n7) {
                do {
                    if (du.a(charSequence2, charSequence, n6, charSequence2.length(), bl2)) {
                        return n6;
                    }
                    if (n6 == n7) break;
                    n6 += n8;
                } while (true);
            }
        }
        return -1;
    }

    public static final int a(CharSequence charSequence, String string) {
        if (!(charSequence instanceof String)) {
            return ed.a(charSequence, string, charSequence.length(), false);
        }
        return ((String)charSequence).indexOf(string, 0);
    }

    public static final int a(CharSequence charSequence, char[] arrc, int n2) {
        int n3;
        if (charSequence instanceof String) {
            char c2 = ao.a(arrc);
            return ((String)charSequence).indexOf((int)c2, n2);
        }
        int n4 = df.a(n2);
        if (n4 <= (n3 = du.a(charSequence))) {
            do {
                boolean bl2;
                char c3 = charSequence.charAt(n4);
                int n5 = 0;
                do {
                    bl2 = false;
                    if (n5 > 0) break;
                    if (dp.a((char)arrc[n5], (char)c3, (boolean)false)) {
                        bl2 = true;
                        break;
                    }
                    ++n5;
                } while (true);
                if (bl2) {
                    return n4;
                }
                if (n4 == n3) break;
                ++n4;
            } while (true);
        }
        return -1;
    }

    public static final boolean a(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence2 instanceof String) {
            return du.b(charSequence, (String)charSequence2) >= 0;
        }
        return ed.a(charSequence, charSequence2, charSequence.length(), false) >= 0;
    }

    public static final boolean a(CharSequence charSequence, CharSequence charSequence2, int n2, int n3, boolean bl2) {
        if (n2 >= 0 && charSequence.length() - n3 >= 0) {
            if (n2 > charSequence2.length() - n3) {
                return false;
            }
            for (int i2 = 0; i2 < n3; ++i2) {
                if (dp.a((char)charSequence.charAt(i2 + 0), (char)charSequence2.charAt(n2 + i2), (boolean)bl2)) continue;
                return false;
            }
            return true;
        }
        return false;
    }

    public static /* synthetic */ int b(CharSequence charSequence, String string) {
        return du.a(charSequence, string);
    }

    public static /* synthetic */ boolean b(CharSequence charSequence, CharSequence charSequence2) {
        return du.a(charSequence, charSequence2);
    }
}


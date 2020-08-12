/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.regex.Matcher
 *  java.util.regex.Pattern
 *  org.jetbrains.annotations.NotNull
 */
package a.a.e;

import a.a.b.b.e;
import a.a.b.b.h;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jetbrains.annotations.NotNull;

public final class b
implements Serializable {
    public static final a a = new a(null);
    private final Pattern nativePattern;

    public b(@NotNull String string) {
        h.b(string, "pattern");
        Pattern pattern = Pattern.compile((String)string);
        h.a((Object)pattern, "Pattern.compile(pattern)");
        this(pattern);
    }

    public b(@NotNull Pattern pattern) {
        h.b((Object)pattern, "nativePattern");
        this.nativePattern = pattern;
    }

    public final boolean a(@NotNull CharSequence charSequence) {
        h.b((Object)charSequence, "input");
        return this.nativePattern.matcher(charSequence).matches();
    }

    @NotNull
    public String toString() {
        String string = this.nativePattern.toString();
        h.a((Object)string, "nativePattern.toString()");
        return string;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e e2) {
            this();
        }
    }

}


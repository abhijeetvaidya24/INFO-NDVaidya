/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.app.Activity
 *  android.content.Context
 *  android.webkit.WebSettings
 *  android.webkit.WebView
 *  android.widget.FrameLayout
 *  io.presage.AbbayedeCiteauxentiere
 *  io.presage.RaclettedeSavoie
 *  io.presage.RaclettedeSavoiefumee
 *  io.presage.StVincentauChablis$CamembertdeNormandie
 *  io.presage.Taleggio
 *  io.presage.j
 *  io.presage.k
 *  java.lang.CharSequence
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Iterator
 *  java.util.LinkedHashMap
 *  java.util.Map
 *  java.util.regex.Matcher
 *  java.util.regex.Pattern
 */
package io.presage;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import io.presage.AbbayedeCiteauxentiere;
import io.presage.Abondance;
import io.presage.Beaufort;
import io.presage.BrillatSavarin;
import io.presage.Murol;
import io.presage.RaclettedeSavoie;
import io.presage.RaclettedeSavoiefumee;
import io.presage.RegaldeBourgogne;
import io.presage.Salers;
import io.presage.StMarcellin;
import io.presage.StRomans;
import io.presage.StVincentauChablis;
import io.presage.Stilton;
import io.presage.Taleggio;
import io.presage.TommeCrayeuse;
import io.presage.TommeMarcdeRaisin;
import io.presage.TommedeSavoie;
import io.presage.TommedeYenne;
import io.presage.cl;
import io.presage.j;
import io.presage.k;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class StVincentauChablis {
    public static final CamembertauCalvados a = new CamembertauCalvados(0);
    private Taleggio b;
    private final Pattern c;
    private final BrillatSavarin d;
    private final RegaldeBourgogne e;
    private final Map<String, j> f;
    private final Map<String, TommedeSavoie> g;
    private final StMarcellin h;
    private final Stilton i;
    private final TommeMarcdeRaisin j;
    private final Abondance k;
    private final RaclettedeSavoiefumee l;
    private final TommedeYenne m;

    private StVincentauChablis(BrillatSavarin brillatSavarin, RegaldeBourgogne regaldeBourgogne, Map<String, j> map, Map<String, TommedeSavoie> map2, StMarcellin stMarcellin, Stilton stilton, TommeMarcdeRaisin tommeMarcdeRaisin, Abondance abondance, RaclettedeSavoiefumee raclettedeSavoiefumee, TommedeYenne tommedeYenne) {
        this.d = brillatSavarin;
        this.e = regaldeBourgogne;
        this.f = map;
        this.g = map2;
        this.h = stMarcellin;
        this.i = stilton;
        this.j = tommeMarcdeRaisin;
        this.k = abondance;
        this.l = raclettedeSavoiefumee;
        this.m = tommedeYenne;
        this.c = Pattern.compile((String)this.d.h());
    }

    public /* synthetic */ StVincentauChablis(BrillatSavarin brillatSavarin, RegaldeBourgogne regaldeBourgogne, Map map, Map map2, StMarcellin stMarcellin, Stilton stilton, TommeMarcdeRaisin tommeMarcdeRaisin, Abondance abondance, RaclettedeSavoiefumee raclettedeSavoiefumee, TommedeYenne tommedeYenne, byte by) {
        this(brillatSavarin, regaldeBourgogne, (Map<String, j>)map, (Map<String, TommedeSavoie>)map2, stMarcellin, stilton, tommeMarcdeRaisin, abondance, raclettedeSavoiefumee, tommedeYenne);
    }

    public static final /* synthetic */ Map a(StVincentauChablis stVincentauChablis) {
        return stVincentauChablis.g;
    }

    private final void a(WebView webView, String string2) {
        this.i.a("started", this.f(), this.e(), StRomans.b(webView), string2);
    }

    private final void a(WebView webView, String string2, String string3) {
        TommedeSavoie tommedeSavoie = (TommedeSavoie)this.g.get((Object)StRomans.b(webView));
        if (tommedeSavoie == null) {
            return;
        }
        if (tommedeSavoie.h()) {
            return;
        }
        boolean bl2 = ((CharSequence)this.d.h()).length() > 0;
        if (bl2 && this.c.matcher((CharSequence)string3).matches()) {
            BrillatSavarin brillatSavarin = this.d;
            AbbayedeCiteauxentiere abbayedeCiteauxentiere = new AbbayedeCiteauxentiere(brillatSavarin, string2, "format", brillatSavarin.h(), string3);
            Abondance.a((Beaufort)abbayedeCiteauxentiere);
            tommedeSavoie.i();
        }
    }

    public static final /* synthetic */ void a(StVincentauChablis stVincentauChablis, WebView webView, String string2) {
        stVincentauChablis.a(webView, string2);
    }

    public static final /* synthetic */ void a(StVincentauChablis stVincentauChablis, WebView webView, String string2, String string3) {
        stVincentauChablis.a(webView, string2, string3);
    }

    public static final /* synthetic */ void a(StVincentauChablis stVincentauChablis, Taleggio taleggio) {
        stVincentauChablis.b = taleggio;
    }

    private final void a(TommeCrayeuse tommeCrayeuse, WebView webView) {
        boolean bl2 = ((CharSequence)tommeCrayeuse.a()).length() > 0;
        if (bl2) {
            webView.loadUrl(tommeCrayeuse.a());
            return;
        }
        webView.loadDataWithBaseURL(this.d.g(), tommeCrayeuse.b(), "text/html", "UTF-8", null);
    }

    private final void a(j j2) {
        Salers[] arrsalers = new Salers[2];
        Taleggio taleggio = this.b;
        if (taleggio == null) {
            cl.a("multiWebViewUrlHandler");
        }
        arrsalers[0] = (Salers)taleggio;
        arrsalers[1] = (Salers)this.l;
        j2.setMraidUrlHandler((Salers)new RaclettedeSavoie(arrsalers));
        j2.setClientAdapter((k)new CamembertdeNormandie(this, j2));
    }

    public static final /* synthetic */ RegaldeBourgogne b(StVincentauChablis stVincentauChablis) {
        return stVincentauChablis.e;
    }

    private final void b(WebView webView, String string2) {
        this.i.a("finished", this.f(), this.e(), StRomans.b(webView), string2);
        TommedeSavoie tommedeSavoie = (TommedeSavoie)this.g.get((Object)StRomans.b(webView));
        if (tommedeSavoie == null) {
            return;
        }
        boolean bl2 = !tommedeSavoie.f() || true ^ cl.a((Object)tommedeSavoie.c(), (Object)string2);
        if (tommedeSavoie.a() && bl2) {
            int n2 = ((CharSequence)this.d.h()).length();
            boolean bl3 = false;
            if (n2 == 0) {
                bl3 = true;
            }
            if (bl3) {
                AbbayedeCiteauxentiere abbayedeCiteauxentiere = new AbbayedeCiteauxentiere(this.d, string2, "format", null, null);
                Abondance.a((Beaufort)abbayedeCiteauxentiere);
            }
        }
        tommedeSavoie.g();
    }

    public static final /* synthetic */ void b(StVincentauChablis stVincentauChablis, WebView webView, String string2) {
        stVincentauChablis.b(webView, string2);
    }

    private final boolean e() {
        Iterator iterator = this.f.values().iterator();
        while (iterator.hasNext()) {
            if (!((j)iterator.next()).canGoBack()) continue;
            return true;
        }
        return false;
    }

    private final boolean f() {
        Iterator iterator = this.f.values().iterator();
        while (iterator.hasNext()) {
            if (!((j)iterator.next()).canGoForward()) continue;
            return true;
        }
        return false;
    }

    public final Salers a() {
        Taleggio taleggio = this.b;
        if (taleggio == null) {
            cl.a("multiWebViewUrlHandler");
        }
        return (Salers)taleggio;
    }

    @SuppressLint(value={"ClickableViewAccessibility"})
    public final void a(TommeCrayeuse tommeCrayeuse) {
        j j2 = this.h.a(tommeCrayeuse);
        if (j2 == null) {
            return;
        }
        this.f.put((Object)tommeCrayeuse.c(), (Object)j2);
        TommedeSavoie tommedeSavoie = new TommedeSavoie(tommeCrayeuse.h(), tommeCrayeuse.i(), tommeCrayeuse.a(), false, 56);
        this.g.put((Object)tommeCrayeuse.c(), (Object)tommedeSavoie);
        this.a(j2);
        if (tommeCrayeuse.j()) {
            Murol.a((WebView)j2);
            WebSettings webSettings = j2.getSettings();
            cl.a((Object)webSettings, "webView.settings");
            webSettings.setCacheMode(1);
        }
        this.a(tommeCrayeuse, (WebView)j2);
    }

    public final void a(String string2) {
        j j2 = (j)this.f.get((Object)string2);
        if (j2 != null) {
            this.h.a((WebView)j2);
        }
        this.f.remove((Object)string2);
        this.g.remove((Object)string2);
    }

    public final void a(String string2, j j2) {
        j2.setTag((Object)string2);
        this.f.put((Object)string2, (Object)j2);
        Map<String, TommedeSavoie> map = this.g;
        TommedeSavoie tommedeSavoie = new TommedeSavoie(false, false, "", true, 48);
        map.put((Object)string2, (Object)tommedeSavoie);
    }

    public final void b(TommeCrayeuse tommeCrayeuse) {
        block4 : {
            WebView webView;
            block5 : {
                j j2 = (j)this.f.get((Object)tommeCrayeuse.c());
                if (j2 == null) break block4;
                webView = (WebView)j2;
                StMarcellin.a(webView, tommeCrayeuse);
                int n2 = ((CharSequence)tommeCrayeuse.a()).length();
                boolean bl2 = true;
                boolean bl3 = n2 > 0;
                if (bl3) break block5;
                if (((CharSequence)tommeCrayeuse.b()).length() <= 0) {
                    bl2 = false;
                }
                if (!bl2) break block4;
            }
            this.a(tommeCrayeuse, webView);
        }
    }

    public final void b(String string2) {
        j j2 = (j)this.f.get((Object)string2);
        if (j2 == null) {
            return;
        }
        if (j2.canGoBack()) {
            j2.goBack();
        }
    }

    public final boolean b() {
        boolean bl2;
        Iterable iterable = (Iterable)this.g.values();
        if (!(iterable instanceof Collection) || !((Collection)iterable).isEmpty()) {
            Iterator iterator = iterable.iterator();
            while (iterator.hasNext()) {
                if (!((TommedeSavoie)iterator.next()).b()) continue;
                bl2 = true;
                break;
            }
        } else {
            bl2 = false;
        }
        return !bl2;
    }

    public final void c() {
        for (j j2 : this.f.values()) {
            if (!j2.canGoBack()) continue;
            j2.goBack();
        }
    }

    public final void c(String string2) {
        j j2 = (j)this.f.get((Object)string2);
        if (j2 == null) {
            return;
        }
        if (j2.canGoForward()) {
            j2.goForward();
        }
    }

    public final void d() {
        this.e.c();
        this.j.a();
        this.m.a();
    }

    public static final class CamembertauCalvados {
        private CamembertauCalvados() {
        }

        public /* synthetic */ CamembertauCalvados(byte by) {
            this();
        }

        public static StVincentauChablis a(Activity activity, BrillatSavarin brillatSavarin, RegaldeBourgogne regaldeBourgogne, FrameLayout frameLayout) {
            Map map = Collections.synchronizedMap((Map)((Map)new LinkedHashMap()));
            cl.a((Object)map, "Collections.synchronizedMap(mutableMapOf())");
            Map map2 = Collections.synchronizedMap((Map)((Map)new LinkedHashMap()));
            cl.a((Object)map2, "Collections.synchronizedMap(mutableMapOf())");
            Context context = (Context)activity;
            StMarcellin stMarcellin = new StMarcellin(context, frameLayout, brillatSavarin);
            Stilton stilton = new Stilton((Map<String, j>)map, (Map<String, TommedeSavoie>)map2);
            Context context2 = activity.getApplicationContext();
            cl.a((Object)context2, "activity.applicationContext");
            TommeMarcdeRaisin tommeMarcdeRaisin = new TommeMarcdeRaisin(context2, stilton);
            RaclettedeSavoiefumee raclettedeSavoiefumee = new RaclettedeSavoiefumee(activity, regaldeBourgogne);
            TommedeYenne tommedeYenne = new TommedeYenne(context, stilton);
            StVincentauChablis stVincentauChablis = new StVincentauChablis(brillatSavarin, regaldeBourgogne, map, map2, stMarcellin, stilton, tommeMarcdeRaisin, Abondance.a, raclettedeSavoiefumee, tommedeYenne, 0);
            StVincentauChablis.a(stVincentauChablis, new Taleggio(stVincentauChablis, stilton));
            return stVincentauChablis;
        }
    }

}


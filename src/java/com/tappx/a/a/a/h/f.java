/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.tappx.a.a.a.h;

public class f {
    public static String a = "<!DOCTYPE html>\n<html>\n<head>\n    <meta name=\"viewport\"\n          content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\">\n    <style>\n         html { box-sizing: border-box; height: 100%; } body { background-color: white; box-sizing: border-box; color: #202020; font-family: sans-serif; /* Set base font size relative to viewport size for best fit to varying devices */ font-size: 4vw; margin: 0; min-height: 100%; padding: 0; -webkit-touch-callout: none; -webkit-user-select: none; } body.response { padding-bottom: 5em; position: relative; } a:link, a:visited, a:active { color: #2696dd; } .header { background-color: #fafafa; border-bottom: 1px solid #a7a7a7; padding: 1em 0 0.5em; text-align: center; width: 100%; } .title { font-size: 1.2em; font-weight: bold; line-height: 150%; } .content { line-height: 140%; margin: 0.5em 1.5em; } .button-container { font-size: 1.2em; text-align: center; width: 100%; } .primary-button:link, .primary-button:visited, .primary-button:active { background-color: #2696dd; border-radius: 1.5em; color: white; display: block; margin: 2em auto; padding: 1em 0; text-decoration: none; width: 100%; } .secondary-button { display: block; padding: 0 0 0.5em; } .explanation { text-align: center; } .footer { bottom: 0; left: 0; line-height: 130%; padding-bottom: 1.2em; position: absolute; right: 0; text-align: center; } .footer a:link, .footer a:visited, .footer a:active { color: black; display: block; text-decoration: none; width: 100%; } .starts-hidden { display: none; } \n    \n    </style>\n</head>\n<body>\n<div class=\"header\">\n    <div class=\"title\" id=\"content-title\"></div>\n</div>\n<div class=\"agreement content\">\n    <div><select id=\"language-select\"> </select></div>\n    <div id=\"content-agreement\"></div>\n    <div class=\"button-container\"><a class=\"primary-button\" href=\"tappx://privacy_accept\"\n                                     id=\"accept-button\"> <span id=\"content-agreeLabel\"></span> </a>\n    </div>\n    <div class=\"button-container\"><a class=\"secondary-button\" href=\"tappx://privacy_deny\"\n                                     id=\"deny-button\"> <span id=\"content-denyLabel\"></span> </a>\n    </div>\n    <div class=\"explanation\" id=\"content-explanation\"></div>\n</div>\n<div class=\"accepted content starts-hidden\" id=\"content-acceptedMessage\"></div>\n<div class=\"denied content starts-hidden\" id=\"content-deniedMessage\"></div>\n<div class=\"footer starts-hidden\"><a href=\"tappx://privacy_close\">\n    <svg version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"\n         x=\"0px\" y=\"0px\" width=\"1.5em\" height=\"1.5em\" viewBox=\"0 0 1024 1024\">\n        <g transform=\"scale(1 -1) translate(0 -950)\">\n            <path fill=\"#000\"\n                  d=\"M512 -11c253 0 459 206 459 459s-206 459 -459 459s-459 -206 -459 -459s206 -459 459 -459zM512 843c218 0 395 -177 395 -395s-177 -395 -395 -395s-395 177 -395 395s177 395 395 395zM557 448l120 -119c12 -13 12 -33 0 -46c-7 -6 -15 -9 -23 -9s-17 3 -23 9 l-119 120l-119 -120c-7 -6 -15 -9 -23 -9s-16 3 -23 9c-12 13 -12 33 0 46l120 119l-119 119c-13 13 -13 33 0 46c12 12 32 12 45 0l119 -120l119 119c13 13 33 13 46 0c12 -12 12 -32 0 -45z\"/>\n        </g>\n    </svg>\n    <br> <span id=\"content-closeWindowLabel\"></span> </a></div>\n</body>\n</html>\n<script>\n     var localizedContent = {\"de\":{\"acceptedMessage\":\"<p>Gro&szlig;artig! Wir hoffen, dass dir deine pers&ouml;nliche Anzeigenerfahrung gef&auml;llt, aber wenn du deine Meinung &auml;nderst, kannst du deine Zustimmung zur&uuml;ckziehen, indem du die Einstellung &ldquor;Kein Ad-Tracking&ldquo; auf deinem mobilen Ger&auml;t aktivierst und dann diese Anwendung erneut aufrufst.</p>\",\"agreeLabel\":\"Ja, ich stimme zu.\",\"agreement\":\"<p>Diese App personalisiert deine Werbeerfahrung durch <a href=\\\"https://www.mopub.com/legal/privacy/?lang=de\\\">MoPub</a>, einen Gesch&auml;ftsbereich von Twitter International. Indem du dieser verbesserten Werbeerfahrung zustimmst, siehst du Anzeigen, die MoPub und seine <a href=\\\"https://www.mopub.com/legal/partners/?lang=de\\\">Partner</a> f&uuml;r dich als relevant erachten. Abh&auml;ngig von deinen Datenschutzeinstellungen k&ouml;nnen MoPub und seine Partner personenbezogene Daten wie Ger&auml;tekennungen, Standortdaten und andere demografische Daten &uuml;ber dich sowie Informationen &uuml;ber deine Interessen sammeln und verarbeiten, um diese personalisierte Werbeerfahrung zu erm&ouml;glichen. <a href=\\\"https://www.mopub.com/legal/privacy/?lang=de\\\">Mehr erfahren.</a></p><p>Indem du zustimmst, best&auml;tigst du, dass du &uuml;ber 16 Jahre alt bist und eine personalisierte Anzeigenerfahrung w&uuml;nschst.</p>\",\"closeWindowLabel\":\"\",\"deniedMessage\":\"<p>Kein Problem. MoPub und seine Partner sammeln deine Daten nicht &uuml;ber diese App f&uuml;r personalisierte Werbung. Wenn du damit einverstanden bist, dass MoPub und seine Partner deine Werbeerfahrung in einer anderen App personalisieren, werden wir deine Daten weiterhin &uuml;ber diese App sammeln.</p>\",\"denyLabel\":\"Nein, vielen Dank.\",\"explanation\":\"Ich verstehe, dass ich Anzeigen sehen werde, aber sie sind m&ouml;glicherweise nicht so relevant f&uuml;r meine Interessen.\",\"languageName\":\"Deutsch\",\"title\":\"Personalisiere deine Erfahrung\"},\"en\":{\"acceptedMessage\":\"<p>Great! We hope you enjoy your personalized ad experience, but if you ever change your mind, you can withdraw your consent by enabling the Limit Ad Tracking setting on your mobile device and then revisiting this app.</p>\",\"agreeLabel\":\"Yes, I agree.\",\"agreement\":\"<p>This app personalizes your advertising experience through <a href=\\\"https://www.mopub.com/legal/privacy/?lang=en\\\">MoPub</a>, a division of Twitter International company. By consenting to this enhanced ad experience, you'll see ads that MoPub and its <a href=\\\"https://www.mopub.com/legal/partners/?lang=en\\\">partners</a> believe are more relevant to you. Depending on your privacy settings, MoPub and its partners may collect and process personal data such as device identifiers, location data, and other demographic and interest data about you to provide this personalized advertising experience. <a href=\\\"https://www.mopub.com/legal/privacy/?lang=en\\\">Learn more.</a></p><p>By agreeing, you are confirming that you are over the age of 16 and would like a personalized ad experience.</p>\",\"closeWindowLabel\":\"Close window\",\"deniedMessage\":\"<p>No problem. MoPub and its partners won't collect your data through this app for personalized advertising. If you consent to MoPub and its partners personalizing your ad experience in a different app, we will still collect your data through that app.</p>\",\"denyLabel\":\"No, thank you.\",\"explanation\":\"I understand that I will see ads, but they may not be as relevant to my interests.\",\"languageName\":\"English\",\"title\":\"Personalize Your Experience\"},\"es\":{\"acceptedMessage\":\"<p>&iexcl;Genial! Esperamos que disfrutes tu experiencia de anuncios personaliza, pero si cambias de opini&oacute;n, podr&aacute;s retirar tu consentimiento. Para ello, deber&aacute;s habilitar la opci&oacute;n para limitar el seguimiento de anuncios en tu dispositivo m&oacute;vil y luego volver a visitar esta aplicaci&oacute;n.</p>\",\"agreeLabel\":\"S&iacute;, de acuerdo.\",\"agreement\":\"<p>Esta aplicaci&oacute;n personaliza tu experiencia de anuncios mediante <a href=\\\"https://www.mopub.com/legal/privacy/?lang=es\\\">MoPub</a>, una divisi&oacute;n de la compa&ntilde;&iacute;a Twitter International. Si aceptas esta experiencia de anuncios mejorada, ver&aacute;s anuncios que MoPub y sus <a href=\\\"https://www.mopub.com/legal/partners/?lang=es\\\">socios</a> consideran m&aacute;s relevantes para ti. Seg&uacute;n tus ajustes de privacidad, MoPub y sus socios podr&aacute;n recopilar y procesar datos personales tales como identificadores de dispositivos, datos de ubicaci&oacute;n y otros datos demogr&aacute;ficos y de inter&eacute;s sobre ti para proporcionar esta experiencia de anuncios personaliza. <a href=\\\"https://www.mopub.com/legal/privacy/?lang=es\\\">M&aacute;s informaci&oacute;n.</a></p><p>Si est&aacute;s de acuerdo, confirmas que eres mayor de 16 a&ntilde;os y te gustar&iacute;a tener una experiencia de anuncios personalizada.</p>\",\"closeWindowLabel\":\"\",\"deniedMessage\":\"<p>No hay problema. MoPub y sus socios no recopilar&aacute;n tus datos mediante esta aplicaci&oacute;n para brindarte anuncios personalizados. Si aceptas que MoPub y sus socios personalicen tu experiencia de anuncios en una aplicaci&oacute;n diferente, seguiremos recopilando tu informaci&oacute;n mediante dicha aplicaci&oacute;n.</p>\",\"denyLabel\":\"No, gracias.\",\"explanation\":\"Comprendo que ver&eacute; anuncios, pero podr&iacute;an no ser relevantes para mis intereses.\",\"languageName\":\"Espa&ntilde;ol\",\"title\":\"Personaliza tu experiencia\"},\"fr\":{\"acceptedMessage\":\"<p>Tr&egrave;s bien ! Nous esp&eacute;rons que vous appr&eacute;cierez votre exp&eacute;rience publicitaire personnalis&eacute;e. Si vous veniez &agrave; changer d'avis, vous pouvez retirer votre consentement en activant le param&egrave;tre Suivi publicitaire limit&eacute; sur votre appareil mobile et en relan&ccedil;ant ensuite cette application.</p>\",\"agreeLabel\":\"Oui, j'accepte.\",\"agreement\":\"<p>Cette application personnalise votre exp&eacute;rience publicitaire par l'interm&eacute;diaire de <a href=\\\"https://www.mopub.com/legal/privacy/?lang=fr\\\">MoPub</a>, une division de Twitter International Company. En acceptant cette exp&eacute;rience publicitaire am&eacute;lior&eacute;e, vous verrez des publicit&eacute;s que MoPub et ses <a href=\\\"https://www.mopub.com/legal/partners/?lang=fr\\\">partenaires</a> jugent plus pertinentes pour vous. Selon vos param&egrave;tres de confidentialit&eacute;, MoPub et ses partenaires peuvent collecter et traiter des informations personnelles, telles que les identifiants d'appareils, les donn&eacute;es de localisation, ainsi que d'autres donn&eacute;es d&eacute;mographiques et d'int&eacute;r&ecirc;t vous concernant de fa&ccedil;on &agrave; vous fournir cette exp&eacute;rience publicitaire personnalis&eacute;e. <a href=\\\"https://www.mopub.com/legal/privacy/?lang=fr\\\">En savoir plus.</a></p><p>En acceptant, vous confirmez avoir plus de 16 ans et d&eacute;sirer une exp&eacute;rience publicitaire personnalis&eacute;e.</p>\",\"closeWindowLabel\":\"\",\"deniedMessage\":\"<p>Pas de probl&egrave;me. MoPub et ses partenaires ne collecteront pas vos donn&eacute;es par l'interm&eacute;diaire de cette application pour personnaliser vos publicit&eacute;s. Toutefois, si vous acceptez que MoPub et ses partenaires personnalisent votre exp&eacute;rience publicitaire dans une autre application, nous collecterons vos donn&eacute;es &agrave; travers l'application en question.</p>\",\"denyLabel\":\"Non, merci.\",\"explanation\":\"Je comprends que je verrai des publicit&eacute;s, mais il est possible qu'elles ne correspondent pas &agrave; mes int&eacute;r&ecirc;ts.\",\"languageName\":\"Fran&ccedil;ais\",\"title\":\"Personnalisez votre exp&eacute;rience\"},\"it\":{\"acceptedMessage\":\"<p>Perfetto! Goditi questa incredibileesperienza pubblicitaria personalizzata. Qualora in futuro dovessi cambiare idea, potrai revocare il tuo consenso abilitando l'impostazione \\\"Limita raccolta dati\\\" sul tuo dispositivo mobile e quindi accedendo nuovamente a questa app.</p>\",\"agreeLabel\":\"S&igrave;, accetto.\",\"agreement\":\"<p>Quest'app personalizza la tua esperienza pubblicitaria grazie a <a href=\\\"https://www.mopub.com/legal/privacy/?lang=it\\\">MoPub</a>, una divisione di Twitter International Company. Accettando questa esperienza pubblicitaria avanzata, visualizzerai gli annunci che MoPub e i suoi <a href=\\\"https://www.mopub.com/legal/partners/?lang=it\\\">partner</a> ritengono pi&ugrave; importanti per te. A seconda delle tue impostazioni sulla privacy, MoPub e i suoi partner potranno raccogliere ed elaborare dati personali, quali gli ID del dispositivo, i dati sulla posizione ed altri dati demografici e informazioni di tuo interesse, per offrirti un'esperienza pubblicitaria personalizzata. <a href=\\\"https://www.mopub.com/legal/privacy/?lang=it\\\">Scopri di pi&ugrave;.</a></p><p>Accettando confermi di avere pi&ugrave; di 16 anni e che desideri usufruire di un'esperienza pubblicitaria personalizzata.</p>\",\"closeWindowLabel\":\"\",\"deniedMessage\":\"<p>Nessun problema. MoPub e i suoi partner non raccoglieranno i tuoi dati mediante l'app per la personalizzazione della pubblicit&agrave;. Laddove accettassi che MoPub e i suoi partner possano personalizzare la tua esperienza pubblicitaria in un'altra app, raccoglieremo i tuoi dati attraverso tale app.</p>\",\"denyLabel\":\"No, grazie.\",\"explanation\":\"Sono consapevole che visualizzer&ograve; gli annunci, ma che questi potrebbero non rispecchiare i miei interessi.\",\"languageName\":\"Italiano\",\"title\":\"Personalizza la tua esperienza\"},\"nl\":{\"acceptedMessage\":\"<p>Geweldig! We hopen dat je geniet van je gepersonaliseerde advertentiebeleving. Mocht je ooit van gedachten veranderen, kun je je toestemming intrekken door op je mobiele apparaat de instelling \\\"Beperk reclametracking\\\" te kiezenen vervolgens deze app opnieuw te openen.</p>\",\"agreeLabel\":\"Ja ik ga akkoord.\",\"agreement\":\"<p>Deze app personaliseert je advertentiebeleving via <a href=\\\"https://www.mopub.com/legal/privacy/?lang=nl\\\">MoPub</a>, een afdeling van Twitter International company. Als je akkoord gaat met deze verbeterde advertentiebeleving, zie je advertenties waarvan MoPub en zijn <a href=\\\"https://www.mopub.com/legal/partners/?lang=nl\\\">partners</a> geloven dat deze beter bij je passen. Afhankelijk van je privacyinstellingen kunnen MoPub en zijn partners persoonlijke gegevens zoals apparaat-id's, locatiegegevens en andere demografische en interessegegevens over jou verzamelen en verwerken, zodat deze gepersonaliseerde advertentiebeleving kan worden aangeboden. <a href=\\\"https://www.mopub.com/legal/privacy/?lang=nl\\\">Meer informatie.</a></p><p>Door akkoord te gaan, bevestig je dat je minstens zestien jaar oud bent en een gepersonaliseerde advertentiebeleving wil ontvangen.</p>\",\"closeWindowLabel\":\"\",\"deniedMessage\":\"<p>Geen probleem. MoPub en zijn partners zullen je gegevens niet verzamelen via deze app voor gepersonaliseerde advertenties. Als je in een andere app toestaat dat MoPub en zijn partners je advertentiebeleving personaliseren, dan zullen we  via de betreffende app je gegevens nog wel blijven verzamelen.</p>\",\"denyLabel\":\"Nee bedankt.\",\"explanation\":\"Ik begrijp dat ik advertenties zal zien en dat deze mogelijk niet bij mijn interesses zullen aansluiten.\",\"languageName\":\"Nederlands\",\"title\":\"Maak jouw ervaring persoonlijker\"},\"pt\":{\"acceptedMessage\":\"<p>&Oacute;timo! Esperamos que voc&ecirc; goste de sua experi&ecirc;ncia de an&uacute;ncios personalizada. Se mudar de ideia, voc&ecirc; poder&aacute; retirar o seu consentimento a qualquer momento ativando a configura&ccedil;&atilde;o &ldquo;Limitar o Rastreamento de An&uacute;ncios&rdquo; no dispositivo m&oacute;vel e acessando novamente este aplicativo.</p>\",\"agreeLabel\":\"Sim, eu concordo.\",\"agreement\":\"<p>Este aplicativo personaliza a sua experi&ecirc;ncia por meio da <a href=\\\"https://www.mopub.com/legal/privacy/?lang=pt\\\">MoPub</a>, uma divis&atilde;o da Twitter International Company. Se voc&ecirc; consentir com essa experi&ecirc;ncia de an&uacute;ncios aprimorada, ver&aacute; an&uacute;ncios que a MoPub e seus <a href=\\\"https://www.mopub.com/legal/partners/?lang=pt\\\">parceiros</a> acreditam ser os mais relevantes para voc&ecirc;. Dependendo de suas configura&ccedil;&otilde;es de privacidade, a MoPub e seus parceiros poder&atilde;o coletar e processar dados pessoais, como identificadores de dispositivo, dados de localiza&ccedil;&atilde;o e outros dados demogr&aacute;ficos e de interesse a seu respeito com a finalidade de fornecer essa experi&ecirc;ncia de an&uacute;ncios personalizada. <a href=\\\"https://www.mopub.com/legal/privacy/?lang=pt\\\">Saiba mais.</a></p><p>Ao concordar, voc&ecirc; confirma que tem mais de 16 anos de idade e que gostaria de ter uma experi&ecirc;ncia de an&uacute;ncios personalizada.</p>\",\"closeWindowLabel\":\"\",\"deniedMessage\":\"<p>Sem problemas. A MoPub e seus parceiros n&atilde;o coletar&atilde;o dados por meio deste aplicativo para fins de an&uacute;ncios personalizados. Se voc&ecirc; consentiu com a personaliza&ccedil;&atilde;o da sua experi&ecirc;ncia de an&uacute;ncios pela MoPub e seus parceiros em um aplicativo diferente, continuaremos a coletar os seus dados naquele aplicativo.</p>\",\"denyLabel\":\"N&atilde;o, obrigado.\",\"explanation\":\"Eu entendo que verei an&uacute;ncios, mas eles poder&atilde;o n&atilde;o ser t&atilde;o relevantes para os meus interesses.\",\"languageName\":\"Portugu&ecirc;s\",\"title\":\"Personalize a sua experi&ecirc;ncia\"}}; var initialLanguage = 'en'; var q = document.querySelector.bind(document); function setLanguage(language) { var content = localizedContent[language] || localizedContent['en']; Object.keys(content).forEach(function (key) { var selector = '#content-' + key; var element = q(selector); if (element) { element.innerHTML = content[key]; } }); } function respond(accepted) { var agreement = q('.agreement'); var body = q('body'); var showContent = accepted ? q('.accepted') : q('.denied'); var footer = q('.footer'); body.classList.add('response'); agreement.style.display = 'none'; showContent.style.display = 'block'; footer.style.display = 'block'; } function init() { var languageSelect = q('#language-select'); /* Populate language select */ var languages = []; Object.keys(localizedContent).forEach(function (code) { var name = localizedContent[code]['languageName'] || code; languages.push({ code: code, name: name }); }); languages.sort(function (a, b) { if (a.name < b.name) { return -1; } if (a.name > b.name) { return 1; } return 0; }); languages.forEach(function (language) { var option = document.createElement('option'); option.setAttribute('value', language.code); option.innerHTML = language.name; languageSelect.appendChild(option); }); setLanguage(initialLanguage); languageSelect.value = initialLanguage; languageSelect.addEventListener('change', function (e) { var selectedOption = q('#language-select option:checked'); setLanguage(selectedOption.value); }); q('#accept-button').addEventListener('click', function () { respond(true); }); q('#deny-button').addEventListener('click', function () { respond(false); }); } init(); \n</script> ";
}

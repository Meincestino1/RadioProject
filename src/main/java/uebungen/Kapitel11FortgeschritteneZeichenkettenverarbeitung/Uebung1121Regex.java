package uebungen.Kapitel11FortgeschritteneZeichenkettenverarbeitung;

import java.lang.ref.SoftReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Uebung1121Regex {



    public static void main(String[] args) {

        // Eine Zeichenfolge aus exakt 10 Ziffern
        Pattern p1 = Pattern.compile("\\d{10}");
        Matcher m1 = p1.matcher("........,");
        System.out.println(m1.matches());

        // eine zeichenfolge aus 5 bis 10 Ziffern und Buchstaben (falsche Angabe im Lehrbuch)
        Pattern p2 = Pattern.compile("[a-zA-Z0-9]{5,10}");
        Matcher m2 = p2.matcher("HammeHamm1");
        System.out.println(m2.matches());

        // Eine Zeichenfolge die wie ein Satz auf ., ! oder ? endet
        Pattern p3 = Pattern.compile(".+[.!?]$");
        Matcher m3 = p3.matcher("Karl??");
        System.out.println(m3.matches());

        // eine nicht leere Zeichenfolge, die keine Ziffern enthält
        Pattern p4 = Pattern.compile("^[^\\s0-9]+$");
        Matcher m4 = p4.matcher("Sudoku ");
        System.out.println(m4.matches());

        // eine Amtsbezeichnung oder ein Namenstitel: Prof., Dr., Dr. med., Dr, h.c.
        Pattern p5 = Pattern.compile(".*(Prof\\.|Dr\\.|med\\.| Dr|h\\.c\\.).*");
        Matcher m5 = p5.matcher("Hi Prof. sie");
        System.out.println(m5.matches());

        // Übung  GPT - // eine alphanumerische Kennung: 3–5 Buchstaben + 2–4 Ziffern, optional - oder _
        Pattern p6 = Pattern.compile(".*[a-zA-Z]{3,5}\\d{2,4}[-_]?");
        Matcher m6 = p6.matcher("fooABC456- bar");
        System.out.println(m6.find());  // oder .matches() mit .* davor

        // eine gültige E-Mail-Adresse: Benutzername + @ + Domain + Top-Level-Domain
        Pattern p7 = Pattern.compile("[A-Za-z0-9._+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$");
        Matcher m7 = p7.matcher("hallo@@gmail.com");
        System.out.println(m7.find());

        // diesen kack hat gpt nicht richtig ausgegeben, aber hab jetztkeine lust mehr... schau esten codee und die letzten beiden
        // eine Telefonnummer: optionales +Landesvorwahl, dann 3–4-stellige Vorwahl in Klammern, danach 6–8 Ziffern, erlaubt Leerzeichen oder Bindestriche
        Pattern p8 = Pattern.compile("^(?:\\+[0-9]{1,3})?\\([0-9]{3,4}\\)[ -]?[0-9]{6,8}$");
        Matcher m8 = p8.matcher("(123)-4567890");
        System.out.println(m8.matches());

        // eine Postleitzahl: optionaler PLZ-Präfix "PLZ", danach 5 Ziffern, optional ein Bindestrich und 4 weitere Ziffern
        Pattern p9 = Pattern.compile("^(PLZ)?[0-9]{5}(-[0-9]{4})?$");
        Matcher m9 = p9.matcher("PLZ12345-1234");
        System.out.println(m9.matches());

        // eine Artikelnummer: 3 Buchstaben, optional ein Bindestrich, dann 4–6 Ziffern
        Pattern p10 = Pattern.compile("^[A-Z]{3}-?[0-9]{4,6}$");
        Matcher m10 = p10.matcher("ABC-123");
        System.out.println(m10.matches());

        // eine Produkt-ID: optional "ID-", danach 6–8 HEX-Zeichen (0–9, A–F)
        Pattern p11 = Pattern.compile("^(ID-)?[0-9A-Fa-f]{6,8}$");
        Matcher m11 = p11.matcher("123456");
        System.out.println(m11.matches());

        // ein Passwort:
        // mindestens 8 Zeichen,
        // muss mindestens 1 Großbuchstaben, 1 Kleinbuchstaben und 1 Zahl enthalten,
        // optional ein Sonderzeichen aus !@#$%^&*
        Pattern p12 = Pattern.compile("^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*])?.{8,}$");
        Matcher m12 = p12.matcher("1111abccC!");
        System.out.println(m12.matches());

        // eine Seriennummer:
        // optionales Präfix "SN-",
        // danach 2–4 Großbuchstaben,
        // dann ein Unterstrich "_",
        // danach 3–5 Ziffern,
        // optionaler Suffix "-END"
        Pattern p13 = Pattern.compile("^(SN-)?[A-Z]{2,4}_[0-9]{3,5}(-END)?$");
        Matcher m13 = p13.matcher("SN-AA_112-ENDYYY");
        System.out.println(m13.matches());


        // Logeintrag: Datum + Uhrzeit + optionaler Log-Level + Nachricht
        // Format:
        //   [YYYY-MM-DD HH:MM:SS] [LEVEL] Nachricht
        //   LEVEL ist optional: INFO, WARN, ERROR
        // Beispiele:
        //   [2025-11-27 23:15:42] INFO Server gestartet
        //   [2025-11-27 23:15:42] WARN Speicher fast voll
        //   [2025-11-27 23:15:42] Datenbank verbunden
        Pattern p14 = Pattern.compile(
                "^\\[(19[0-9]{2}|200[0-9]|201[0-9]|202[0-6])-" +   // Jahr 1900–2026
                        "(0[1-9]|1[0-2])-" +                                // Monat 01–12
                        "(0[1-9]|[12][0-9]|3[01]) " +                      // Tag 01–31 [12] bedeutet 1oder2, geht auch so:[1-2]
                        "(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]\\] " + // Uhrzeit
                        "(?:INFO|WARN|ERROR)? ?.+$"                          // optionaler Log-Level + Nachricht
        );
        Matcher m14 = p14.matcher("[2025-12-25 23:15:42] INFO");
        System.out.println(m14.matches());



        // eine Produkt-ID im Format: optionales Präfix "PROD-", dann 2–4 Großbuchstaben,
        // gefolgt von 3–5 Ziffern, optionales Suffix "-END"
        Pattern p15 = Pattern.compile("^(?:PROD-)?[A-Z]{2,4}[0-9]{3,5}(?:-END)?$");
        Matcher m15 = p15.matcher("PROD-AAAA123-END");
        System.out.println(m15.matches());


        // Prüfen ob VW Artikelnummer
        Pattern p16 = Pattern.compile("[0-9][0-9A-Z][0-9][0-9]{6}[A-Z](?: [0-9A-Z]{3})?$");
        Matcher m16 = p16.matcher("1H0819644B ");
        System.out.println(m16.matches());



        // Email prüfen
        Pattern p17 = Pattern.compile(
                "^(?=.{1,64}@)" +                              // Lookahead: max 64 Zeichen lokal
                        "[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+" +           // erster Block im lokalen Teil
                        "(\\.[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+)*" +     // optionale Punkt-Blöcke im lokalen Teil
                        "@" +
                        "([a-zA-Z0-9]([a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?\\.)+" + // Domain Labels
                        "[a-zA-Z]{2,63}$"                              // Top-Level-Domain
        );
        Matcher m17 = p17.matcher("");
        System.out.println(m17.matches());





        Pattern p18 = Pattern.compile("\\d{10}");
        Matcher m18 = p18.matcher("");
        System.out.println(m18.matches());

        Pattern p19 = Pattern.compile("[0-9a-zA-Z]{5,10}");
        Matcher m19 = p19.matcher("");
        System.out.println(m19.matches());

        Pattern p20 = Pattern.compile(".+[.!?]$");
        Matcher m20 = p20.matcher("Hallo?");
        System.out.println(m20.matches());

        Pattern p21 = Pattern.compile("\\D*");
        Matcher m21 = p21.matcher("Hallosddfdfas?");
        System.out.println(m21.matches());

        Pattern p22 = Pattern.compile(".*?(Prof\\.|Dr\\.|Dr\\. med\\.|Dr\\.|h\\.c\\.).*?");
        Matcher m22 = p22.matcher("jsk  29Prof. ls");
        System.out.println(m22.matches());






    }

}

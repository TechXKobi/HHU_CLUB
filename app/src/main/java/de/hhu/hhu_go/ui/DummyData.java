package de.hhu.hhu_go.ui;

import java.net.URL;
import java.time.LocalDateTime;

import de.hhu.hhu_go.R;
import de.hhu.hhu_go.domain.Article;
import de.hhu.hhu_go.domain.Contact;
import de.hhu.hhu_go.domain.Events;
import de.hhu.hhu_go.domain.Locality;
import de.hhu.hhu_go.domain.Offer;

public class DummyData {
    public static String[] categories = {"Studium", "Forschung", "Sport", "Freizeit", "Politik", "Soziales", "Ethik","Gaming","Ideen", "Alle"};
    public static String[] eventsCategories = {"Studium", "Forschung", "Wissenschaft", "Feier", "Sport", "Freizeit", "Politik", "Wettbewerb", "Musik","Gaming", "Tour", "Alle"};

    public static Article[] articles =
            {new Article("Studientipps", "Im Folgenden Artikel zeige ich euch, wie man da Studium meistert.", 0, LocalDateTime.of(2024, 6,1, 13,0), categories[0]),
             new Article("Forschung","Im Folgenden Artikel zeige ich euch, lernt ihr mehr über die Bedeutung der Forschung.", 1, LocalDateTime.of(2024, 6,1, 19,0), categories[1]),
             new Article("Freizeit muss sein!","Im Folgenden Artikel geht es um die Freizeit neben dem Studium.", 1, LocalDateTime.of(2024, 6,1, 17,53),categories[3]),
             new Article("Endlich ist es soweit.","Hi, zusammen. Ich habe meinen Bachelor-Abschluss in der Tasche.", 2, LocalDateTime.of(2024, 6,12, 9,0), categories[0]),
             new Article("Endlich ist es soweit!","Hi, zusammen. Ich habe meinen Master-Abschluss.", 3, LocalDateTime.of(2024, 6,12, 16,23), categories[0])};

    public static Article[] articles2 =
            {new Article("Studientipps", "Im Folgenden Artikel zeige ich euch, wie man da Studium meistert.", 0, LocalDateTime.of(2024, 6,1, 13,0), categories[0]),
                    new Article("Forschung","Im Folgenden Artikel zeige ich euch, lernt ihr mehr über die Bedeutung der Forschung.", 1, LocalDateTime.of(2024, 6,1, 19,0), categories[1]),
                    new Article("Freizeit muss sein!","Im Folgenden Artikel geht es um die Freizeit neben dem Studium.", 1, LocalDateTime.of(2024, 6,1, 17,53), categories[3]),
                    new Article("Endlich ist es soweit.","Hi, zusammen. Ich habe meinen Bachelor-Abschluss in der Tasche.", 2, LocalDateTime.of(2024, 6,12, 9,0), categories[0]),
                    new Article("Endlich ist es soweit!","Hi, zusammen. Ich habe meinen Master-Abschluss.", 3, LocalDateTime.of(2024, 6,12, 16,23), categories[0]),
                    new Article("Fern von der Zukunft!","Wie der Klimawandel immer aggressiver vorangetrieben wird von den Menschen.", 3, LocalDateTime.of(2024, 6,12, 16,23), categories[5]),
                    new Article("Künstliche Intelligenz spielt LoL","Ich möchte euch meine KI vorstellen, die Pro-Spieler in League of Legends outperformed hat.", 3, LocalDateTime.of(2024, 6,12, 16,23), categories[8]),
                    new Article("Time to Shine","MINT-Workshop mit KI-Einblick.", 3, LocalDateTime.of(2024, 6,12, 16,23), categories[0]),
                    new Article("Künstliche Intelligenz spielt LoL","Ich möchte euch meine KI vorstellen, die Pro-Spieler in League of Legends outperformed hat.", 3, LocalDateTime.of(2024, 6,12, 16,23), categories[8])};

    public static Events[] events = {
            new Events("Fußball-Turnier der FC Heine 97",
                    LocalDateTime.of(2024,7,1,13,0),
                    "Ein Turnier zum Fußballspielen.",
                    "Sport",
                    0, "Signal Iduna Park, Dortmund"),
            new Events("Musikkonzert von Justin Bieber",
                    LocalDateTime.of(2024,7,12,13,0),
                    "Justin Biebers Konzert zu seinem brandneuen Album.",
                    "Musik",
                    0, "Tonhalle, Düsseldorf"),
            new Events("Düsseldorfer Stadttour",
                    LocalDateTime.of(2024,7,15,13,0),
                    "Eine gründliche Tour durch Düsseldorf.",
                    "Tour",
                    0, "Düsseldorf"),
            new Events("Science-Slam",
                    LocalDateTime.of(2024,7,31,8,0),
                    "Eine humorvolle Art und Weise, Wissenschaft anzugehen.",
                    "Wissenschaft",
                    0, "HHU, Düsseldorf"),
            new Events("Rheinfestival",
                    LocalDateTime.of(2024,8,17,15,0),
                    "Feier am Rhein, um den Stress der Klausurphase abzubauen.",
                    "Feier",
                    0, "Rhein (am Landtag), Düsseldorf"),
            new Events("HHU-Olympics",
                    LocalDateTime.of(2024,8,21,8,0),
                    "Olympische Spiele an der HHU.",
                    "Sport",
                    0, "Rasenplatz der HHU, Düsseldorf"),
            new Events("HHU-KI-Hackathon",
                    LocalDateTime.of(2024,9,1,8,0),
                    "KI-Hackathon der HHU unter Studierenden aller Fakultäten.",
                    "Wettbewerb",
                    0, "HHU, Düsseldorf")};

    // state = true <=> new
    public static Offer[] offers = {
            new Offer("Introduction to Algorithms, Cormen", "3. Edition der Algorithmen-Bibel zum Tausch gegen Bücher zu fortgeschrittenen Graphenalgorithmen.", true, "Buch", 0, LocalDateTime.of(2024, 7, 12, 12, 32),0),
            new Offer("Brandneue Lederjacke", "Ich verkaufe hier eine brandneue Lederjacke, die ich kaum getragen habe.", true, "Kleidung", 0, LocalDateTime.of(2024, 7, 31, 17, 00), 30),
            new Offer("Grundwissen Mathematikstudium, Arens", "Verkaufe mein Mathe-Einführungsbuch.", true, "Buch", 0, LocalDateTime.of(2024, 7, 12, 19, 43), 30),
            new Offer("Blue-Jeans", "Ich tausche diese Jeans gegen ein T-Shirt der Marke 'Jack und Jones'.", false, "Kleidung", 0, LocalDateTime.of(2024, 7, 30, 8, 20), 0),
            new Offer("Datenbanken – Konzepte und Sprachen", "Buch zum Lernen von DB.", false, "Buch", 0, LocalDateTime.of(2024, 7, 12, 12, 34), 20),
            new Offer("Weißes Polohemd", "Zum Verkauf steht ein weißes, fast neues Polohemd.", true, "Kleidung", 0, LocalDateTime.of(2024, 7, 14, 12, 20), 25),
            new Offer("Robotics with Python and Raspberry Pi", "Lerne schnell Robotics.", true, "Buch", 0, LocalDateTime.of(2024, 7, 12, 20, 00), 20),
            new Offer("Rote Nikeschuhe", "Ich tausche meine roten, gebrauchten Nike-Sneaker gegen ein Buch zum Lernen von Java-Programmierung.", false, "Kleidung", 0, LocalDateTime.of(2024, 7, 27, 14, 30), 0),
            new Offer("Computer Networking A Top-Down Approach, 7th Edition by James Kurose, Keith Ross", "Lerne die Theorie und Praxis von Computernetzwerken kennen. Ich tausche dieses Buch gegen eine Jacke.", false, "Buch", 0, LocalDateTime.of(2024, 7, 30, 17, 00), 0),
    };

    public static Locality[] hhuLocalities = {
            new Locality("23er-Gebäude an der HHU", "Gebäude der philosophischen Fakultät der HHU", "Universitätsstraße 1, 40225 Düsseldorf", "https://www.hhu.de/die-hhu/kontakt-und-services/lageplan-und-anfahrt", "Universität", R.drawable.hhu23er),
            new Locality("Bibliothek an der HHU", "Universitäts- und Landesbibliothek Düsseldorf", "Universitätsstraße 1, 40225 Düsseldorf", "https://www.hhu.de/die-hhu/kontakt-und-services/lageplan-und-anfahrt", "Universität", R.drawable.hhu_bib),
            new Locality("Mensa an der HHU", "Zentralmensa an der HHU", "Universitätsstraße 1, 40225 Düsseldorf", "https://www.hhu.de/die-hhu/kontakt-und-services/lageplan-und-anfahrt", "Universität", R.drawable.hhu_mensa),
            new Locality("Oeconomicum", "Gebäude der wirtschaftlichen Fakultät", "Universitätsstraße 1, 40225 Düsseldorf", "https://www.hhu.de/die-hhu/kontakt-und-services/lageplan-und-anfahrt", "Universität", R.drawable.hhu_oceo),
            new Locality("SSC", "Studierenden-Service-Center der HHU", "Universitätsstraße 1, 40225 Düsseldorf", "https://www.hhu.de/die-hhu/kontakt-und-services/lageplan-und-anfahrt", "Universität", R.drawable.hhu_ssc),
            new Locality("UKD", "Universitätsklinikum Düsseldorf", "Moorenstraße 5 Universitätsklinikum, 40225 Düsseldorf", "https://www.uniklinik-duesseldorf.de/patienten-besucher/als-patient-am-ukd/anreise-anfahrt-und-lageplan", "niversität", R.drawable.hhu_ukd),
    };

    public static Locality[] localities = {
            new Locality("GALERIA Düsseldorf Königsallee", "Ein riesen Einkaufszentrum für alles","Königsallee 1-9, 40212 Düsseldorf", "https://www.galeria.de/filialen/l/dusseldorf/konigsallee-1-9/001310", "Stadtmitte", R.drawable.dus_temp2),new Locality("GALERIA Düsseldorf Königsallee", "Ein riesen Einkaufszentrum für alles","Königsallee 1-9, 40212 Düsseldorf", "https://www.galeria.de/filialen/l/dusseldorf/konigsallee-1-9/001310", "Stadtmitte", R.drawable.dus_temp2),new Locality("GALERIA Düsseldorf Königsallee", "Ein riesen Einkaufszentrum für alles","Königsallee 1-9, 40212 Düsseldorf", "https://www.galeria.de/filialen/l/dusseldorf/konigsallee-1-9/001310", "Stadtmitte", R.drawable.dus_temp2),new Locality("GALERIA Düsseldorf Königsallee", "Ein riesen Einkaufszentrum für alles","Königsallee 1-9, 40212 Düsseldorf", "https://www.galeria.de/filialen/l/dusseldorf/konigsallee-1-9/001310", "Stadtmitte", R.drawable.dus_temp2),new Locality("GALERIA Düsseldorf Königsallee", "Ein riesen Einkaufszentrum für alles","Königsallee 1-9, 40212 Düsseldorf", "https://www.galeria.de/filialen/l/dusseldorf/konigsallee-1-9/001310", "Stadtmitte", R.drawable.dus_temp2),new Locality("GALERIA Düsseldorf Königsallee", "Ein riesen Einkaufszentrum für alles","Königsallee 1-9, 40212 Düsseldorf", "https://www.galeria.de/filialen/l/dusseldorf/konigsallee-1-9/001310", "Stadtmitte", R.drawable.dus_temp2)
    };

    public static Locality[] localities2 = {
            new Locality("Rheinkniebrücke", "Die Brücke am Rhein"," Rheinkniebrücke, 40545 Düsseldorf", "https://de.wikipedia.org/wiki/Rheinkniebr%C3%BCcke", "Rhein", R.drawable.dus_rhein),
            new Locality("Rheinkniebrücke", "Die Brücke am Rhein"," Rheinkniebrücke, 40545 Düsseldorf", "https://de.wikipedia.org/wiki/Rheinkniebr%C3%BCcke", "Rhein", R.drawable.dus_rhein),
            new Locality("Rheinkniebrücke", "Die Brücke am Rhein"," Rheinkniebrücke, 40545 Düsseldorf", "https://de.wikipedia.org/wiki/Rheinkniebr%C3%BCcke", "Rhein", R.drawable.dus_rhein),
            new Locality("Rheinkniebrücke", "Die Brücke am Rhein"," Rheinkniebrücke, 40545 Düsseldorf", "https://de.wikipedia.org/wiki/Rheinkniebr%C3%BCcke", "Rhein", R.drawable.dus_rhein),
            new Locality("Rheinkniebrücke", "Die Brücke am Rhein"," Rheinkniebrücke, 40545 Düsseldorf", "https://de.wikipedia.org/wiki/Rheinkniebr%C3%BCcke", "Rhein", R.drawable.dus_rhein),
            new Locality("Rheinkniebrücke", "Die Brücke am Rhein"," Rheinkniebrücke, 40545 Düsseldorf", "https://de.wikipedia.org/wiki/Rheinkniebr%C3%BCcke", "Rhein", R.drawable.dus_rhein),
            new Locality("Rheinkniebrücke", "Die Brücke am Rhein"," Rheinkniebrücke, 40545 Düsseldorf", "https://de.wikipedia.org/wiki/Rheinkniebr%C3%BCcke", "Rhein", R.drawable.dus_rhein),
            new Locality("Rheinkniebrücke", "Die Brücke am Rhein"," Rheinkniebrücke, 40545 Düsseldorf", "https://de.wikipedia.org/wiki/Rheinkniebr%C3%BCcke", "Rhein", R.drawable.dus_rhein)};

    public static Locality[] foodLocalities = {
            new Locality("FoodBar", "Das Restaurant in Düsseldorf.","XYZ, 40545 Düsseldorf", "https://de.wikipedia.org/wiki/Pizza", "Alles", R.drawable.food),
            new Locality("Santinos Pizza", "Beste Pizza in Düsseldorf.","XYZ, 40545 Düsseldorf", "https://de.wikipedia.org/wiki/Pizza", "Alles", R.drawable.food2),
            new Locality("Düsseldorfer Döner", "Bester Döner in Düsseldorf.","XYZ, 40545 Düsseldorf", "https://de.wikipedia.org/wiki/Pizza", "Alles", R.drawable.food3),
            new Locality("Vegano", "Vegan und gesund.","XYZ, 40545 Düsseldorf", "https://de.wikipedia.org/wiki/Pizza", "Vegan", R.drawable.food4),
            new Locality("FoodBar", "Das Restaurant in Düsseldorf.","XYZ, 40545 Düsseldorf", "https://de.wikipedia.org/wiki/Pizza", "Alles", R.drawable.food),
            new Locality("Santinos Pizza", "Beste Pizza in Düsseldorf.","XYZ, 40545 Düsseldorf", "https://de.wikipedia.org/wiki/Pizza", "Alles", R.drawable.food2),
            new Locality("Düsseldorfer Döner", "Bester Döner in Düsseldorf.","XYZ, 40545 Düsseldorf", "https://de.wikipedia.org/wiki/Pizza", "Alles", R.drawable.food3),
            new Locality("Vegano", "Vegan und gesund.","XYZ, 40545 Düsseldorf", "https://de.wikipedia.org/wiki/Pizza", "Vegan", R.drawable.food4)};

        public static Contact[] contacts = {new Contact(LocalDateTime.of(2024, 7, 12, 12, 34),
            "Hi, was genau sollten wir zur digitalen Innovation machen?",
            R.drawable.profile1),
            new Contact(LocalDateTime.of(2024, 7, 14, 12, 34),
                    "Also die Abgabe ist morgen lol.",
                    R.drawable.profile2),
            new Contact(LocalDateTime.of(2024, 6, 14, 12, 34),
                    "Dange.",
                    R.drawable.profile1),
            new Contact(LocalDateTime.of(2024, 7, 9, 12, 34),
                    "Wir sehen uns dann nachher \uD83D\uDC4B.",
                    R.drawable.profile2),
            new Contact(LocalDateTime.of(2024, 7, 21, 12, 34),
                    "Nein, das geht schon so \uD83D\uDE00.",
                    R.drawable.profile1),
            new Contact(LocalDateTime.of(2024, 7, 13, 12, 34),
                    "Jo, machen wir auf jeden Fall! \uD83D\uDE01.",
                    R.drawable.profile2)};
}

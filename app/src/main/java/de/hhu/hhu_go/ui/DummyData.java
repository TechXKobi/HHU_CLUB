package de.hhu.hhu_go.ui;

import java.time.LocalDateTime;

import de.hhu.hhu_go.domain.Article;

public class DummyData {
    public static Article[] articles =
            {new Article("Studientipps", "Im Folgenden Artikel zeige ich euch, wie man da Studium meistert.", 0, LocalDateTime.of(2024, 6,1, 13,0)),
             new Article("Forschung","Im Folgenden Artikel zeige ich euch, lernt ihr mehr über die Bedeutung der Forschung.", 1, LocalDateTime.of(2024, 6,1, 19,0)),
             new Article("Freizeit muss sein!","Im Folgenden Artikel geht es um die Freizeit neben dem Studium.", 1, LocalDateTime.of(2024, 6,1, 17,53)),
             new Article("Endlich ist es soweit.","Hi, zusammen. Ich habe meinen Bachelor-Abschluss in der Tasche.", 2, LocalDateTime.of(2024, 6,12, 9,0)),
             new Article("Endlich ist es soweit!","Hi, zusammen. Ich habe meinen Master-Abschluss.", 3, LocalDateTime.of(2024, 6,12, 16,23))};

    public static Article[] articles2 =
            {new Article("Studientipps", "Im Folgenden Artikel zeige ich euch, wie man da Studium meistert.", 0, LocalDateTime.of(2024, 6,1, 13,0)),
                    new Article("Forschung","Im Folgenden Artikel zeige ich euch, lernt ihr mehr über die Bedeutung der Forschung.", 1, LocalDateTime.of(2024, 6,1, 19,0)),
                    new Article("Freizeit muss sein!","Im Folgenden Artikel geht es um die Freizeit neben dem Studium.", 1, LocalDateTime.of(2024, 6,1, 17,53)),
                    new Article("Endlich ist es soweit.","Hi, zusammen. Ich habe meinen Bachelor-Abschluss in der Tasche.", 2, LocalDateTime.of(2024, 6,12, 9,0)),
                    new Article("Endlich ist es soweit!","Hi, zusammen. Ich habe meinen Master-Abschluss.", 3, LocalDateTime.of(2024, 6,12, 16,23)),
                    new Article("Fern von der Zukunft!","Wie der Klimawandel immer aggressiver vorangetrieben wird von den Menschen.", 3, LocalDateTime.of(2024, 6,12, 16,23)),
                    new Article("Künstliche Intelligenz spielt LoL","Ich möchte euch meine KI vorstellen, die Pro-Spieler in League of Legends outperformed hat.", 3, LocalDateTime.of(2024, 6,12, 16,23)),
                    new Article("Time to Shine","MINT-Workshop mit KI-Einblick.", 3, LocalDateTime.of(2024, 6,12, 16,23)),
                    new Article("Künstliche Intelligenz spielt LoL","Ich möchte euch meine KI vorstellen, die Pro-Spieler in League of Legends outperformed hat.", 3, LocalDateTime.of(2024, 6,12, 16,23))};
}

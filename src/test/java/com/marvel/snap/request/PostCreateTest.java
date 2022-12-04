package com.marvel.snap.request;

import com.marvel.snap.repository.CardRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class PostCreateTest {

    @Autowired
    CardRepository cardRepository;

    @Test
    void test() {
        String ss = "# (1) Ant Man\n" +
                "# (1) Iceman\n" +
                "# (1) Iron Fist\n" +
                "# (1) Korg\n" +
                "# (1) Nightcrawler\n" +
                "# (2) Angela\n" +
                "# (2) Armor\n" +
                "# (3) Mister Fantastic\n" +
                "# (3) Debrii\n" +
                "# (4) Ka-Zar\n" +
                "# (5) Blue Marvel\n" +
                "# (6) Doctor Doom\n" +
                "#\n" +
                "eyJDYXJkcyI6W3siQ2FyZERlZklkIjoiSWNlbWFuIn0seyJDYXJkRGVmSWQiOiJJcm9uRmlzdCJ9LHsiQ2FyZERlZklkIjoiS29yZyJ9LHsiQ2FyZERlZklkIjoiTXJGYW50YXN0aWMifSx7IkNhcmREZWZJZCI6IkRlYnJpaSJ9LHsiQ2FyZERlZklkIjoiS2FaYXIifSx7IkNhcmREZWZJZCI6IkJsdWVNYXJ2ZWwifSx7IkNhcmREZWZJZCI6IkFudE1hbiJ9LHsiQ2FyZERlZklkIjoiTmlnaHRjcmF3bGVyIn0seyJDYXJkRGVmSWQiOiJBbmdlbGEifSx7IkNhcmREZWZJZCI6IkRyRG9vbSJ9LHsiQ2FyZERlZklkIjoiQXJtb3IifV19\n" +
                "#\n" +
                "# To use this deck, copy it to your clipboard and paste it from the deck editing menu in Snap.";

        List<String> collect = Arrays.stream(ss.split("\n")).collect(Collectors.toList());

        for (int i = 0; i < 12; i++) {
            System.out.println(i + " : " + collect.get(i));
            String collectString = collect.get(i);

            String engName = collectString.substring(6).trim();
            System.out.println(engName);

            cardRepository.findById(engName).ifPresent(h -> {
                System.out.println(h.getKorName());
            });
        }

        String deckCode = collect.get(13);
        System.out.println("deckCode = " + deckCode);
    }
}
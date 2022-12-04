package com.marvel.snap.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.marvel.snap.repository.PostRepository;
import com.marvel.snap.request.PostCreate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class PostControllerTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PostRepository postRepository;

    @BeforeEach
    void clean() {
        postRepository.deleteAll();
    }

    @Test
    @DisplayName("/posts 요청시 글을 작성한다.")
    void test() throws Exception {
        // given
        PostCreate request = PostCreate.builder()
                .writer("비비")
                .password("1234")
                .title("제목입니다.")
                .content("내용입니다.")
                .deckCode("# (1) Ant Man\n" +
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
                        "# To use this deck, copy it to your clipboard and paste it from the deck editing menu in Snap.")
                .build();

        String json = objectMapper.writeValueAsString(request);

        // expected
        mockMvc.perform(post("/posts")
                        .contentType(APPLICATION_JSON)
                        .content(json)
                )
                .andExpect(status().isOk())
                .andExpect(content().string(""))
                .andDo(print());
    }

    @Test
    @DisplayName("/posts 요청시 writer값은 필수다")
    void test2() throws Exception {
        // given
        PostCreate request = PostCreate.builder()
                .password("1234")
                .title("제목입니다.")
                .content("내용입니다.")
                .deckCode("# (1) Ant Man\n" +
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
                        "# To use this deck, copy it to your clipboard and paste it from the deck editing menu in Snap.")
                .build();

        String json = objectMapper.writeValueAsString(request);

        // expected
        mockMvc.perform(post("/posts")
                        .contentType(APPLICATION_JSON)
                        .content(json)
                )
                .andExpect(status().isBadRequest())
                .andDo(print());
    }
}
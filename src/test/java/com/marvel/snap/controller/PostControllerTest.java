package com.marvel.snap.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.marvel.snap.domain.Card;
import com.marvel.snap.domain.Post;
import com.marvel.snap.repository.CardRepository;
import com.marvel.snap.repository.PostRepository;
import com.marvel.snap.request.PostCreate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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

    @Autowired
    private CardRepository cardRepository;

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

    @Test
    @DisplayName("글 단건 조회")
    void test3() throws Exception {
        // given
        String cardList = "Ant Man,Iceman,Iron Fist,Korg,Nightcrawler,Angela,Armor,Mister Fantastic,Debrii,Ka-Zar,Blue Marvel,Doctor Doom";
        List<Card> cards = Arrays.stream(cardList.split(","))
                .map(str -> cardRepository.findById(str).orElseThrow(RuntimeException::new))
                .collect(Collectors.toList());

        Post post = Post.builder()
                .writer("비비")
                .password("1234")
                .title("제목입니다.")
                .content("내용입니다.")
                .deckCode("eyJDYXJkcyI6W3siQ2FyZERlZklkIjoiSWNlbWFuIn0seyJDYXJkRGVmSWQiOiJJcm9uRmlzdCJ9LHsiQ2FyZERlZklkIjoiS29yZyJ9LHsiQ2FyZERlZklkIjoiTXJGYW50YXN0aWMifSx7IkNhcmREZWZJZCI6IkRlYnJpaSJ9LHsiQ2FyZERlZklkIjoiS2FaYXIifSx7IkNhcmREZWZJZCI6IkJsdWVNYXJ2ZWwifSx7IkNhcmREZWZJZCI6IkFudE1hbiJ9LHsiQ2FyZERlZklkIjoiTmlnaHRjcmF3bGVyIn0seyJDYXJkRGVmSWQiOiJBbmdlbGEifSx7IkNhcmREZWZJZCI6IkRyRG9vbSJ9LHsiQ2FyZERlZklkIjoiQXJtb3IifV19")
                .hit(0)
                .likePost(0)
                .disLikePost(0)
                .cards(cards)
                .build();
        postRepository.save(post);

        // expected
        mockMvc.perform(get("/posts/{postId}", post.getId())
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(post.getId()))
                .andExpect(jsonPath("$.writer").value("비비"))
                .andExpect(jsonPath("$.title").value("제목입니다."))
                .andExpect(jsonPath("$.content").value("내용입니다."))
                .andDo(print());
    }

    @Test
    @DisplayName("글 여러개 조회")
    void test4() throws Exception {
        // given
        String cardList = "Ant Man,Iceman,Iron Fist,Korg,Nightcrawler,Angela,Armor,Mister Fantastic,Debrii,Ka-Zar,Blue Marvel,Doctor Doom";
        List<Card> cards = Arrays.stream(cardList.split(","))
                .map(str -> cardRepository.findById(str).orElseThrow(RuntimeException::new))
                .collect(Collectors.toList());

        List<Post> requestPosts = IntStream.range(0, 20)
                .mapToObj(i -> Post.builder()
                        .writer("비비" + i)
                        .password("1234")
                        .title("제목입니다." + i)
                        .content("내용입니다." + i)
                        .deckCode("eyJDYXJkcyI6W3siQ2FyZERlZklkIjoiSWNlbWFuIn0seyJDYXJkRGVmSWQiOiJJcm9uRmlzdCJ9LHsiQ2FyZERlZklkIjoiS29yZyJ9LHsiQ2FyZERlZklkIjoiTXJGYW50YXN0aWMifSx7IkNhcmREZWZJZCI6IkRlYnJpaSJ9LHsiQ2FyZERlZklkIjoiS2FaYXIifSx7IkNhcmREZWZJZCI6IkJsdWVNYXJ2ZWwifSx7IkNhcmREZWZJZCI6IkFudE1hbiJ9LHsiQ2FyZERlZklkIjoiTmlnaHRjcmF3bGVyIn0seyJDYXJkRGVmSWQiOiJBbmdlbGEifSx7IkNhcmREZWZJZCI6IkRyRG9vbSJ9LHsiQ2FyZERlZklkIjoiQXJtb3IifV19")
                        .hit(0)
                        .likePost(0)
                        .disLikePost(0)
                        .cards(cards)
                        .build())
                .collect(Collectors.toList());
        postRepository.saveAll(requestPosts);

        // expected
        mockMvc.perform(get("/posts?page=1&size=10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(10))
                .andExpect(jsonPath("$[0].writer").value("비비19"))
                .andDo(print());
    }

    @Test
    @DisplayName("페이지 0 요청시 첫 페이지를 가져옴")
    void test5() throws Exception {
        // given
        String cardList = "Ant Man,Iceman,Iron Fist,Korg,Nightcrawler,Angela,Armor,Mister Fantastic,Debrii,Ka-Zar,Blue Marvel,Doctor Doom";
        List<Card> cards = Arrays.stream(cardList.split(","))
                .map(str -> cardRepository.findById(str).orElseThrow(RuntimeException::new))
                .collect(Collectors.toList());

        List<Post> requestPosts = IntStream.range(0, 20)
                .mapToObj(i -> Post.builder()
                        .writer("비비" + i)
                        .password("1234")
                        .title("제목입니다." + i)
                        .content("내용입니다." + i)
                        .deckCode("eyJDYXJkcyI6W3siQ2FyZERlZklkIjoiSWNlbWFuIn0seyJDYXJkRGVmSWQiOiJJcm9uRmlzdCJ9LHsiQ2FyZERlZklkIjoiS29yZyJ9LHsiQ2FyZERlZklkIjoiTXJGYW50YXN0aWMifSx7IkNhcmREZWZJZCI6IkRlYnJpaSJ9LHsiQ2FyZERlZklkIjoiS2FaYXIifSx7IkNhcmREZWZJZCI6IkJsdWVNYXJ2ZWwifSx7IkNhcmREZWZJZCI6IkFudE1hbiJ9LHsiQ2FyZERlZklkIjoiTmlnaHRjcmF3bGVyIn0seyJDYXJkRGVmSWQiOiJBbmdlbGEifSx7IkNhcmREZWZJZCI6IkRyRG9vbSJ9LHsiQ2FyZERlZklkIjoiQXJtb3IifV19")
                        .hit(0)
                        .likePost(0)
                        .disLikePost(0)
                        .cards(cards)
                        .build())
                .collect(Collectors.toList());
        postRepository.saveAll(requestPosts);

        // expected
        mockMvc.perform(get("/posts?page=0&size=10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(10))
                .andExpect(jsonPath("$[0].writer").value("비비19"))
                .andDo(print());
    }
}
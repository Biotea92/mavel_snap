package com.marvel.snap.service;

import com.marvel.snap.domain.Card;
import com.marvel.snap.domain.Post;
import com.marvel.snap.repository.CardRepository;
import com.marvel.snap.repository.PostRepository;
import com.marvel.snap.request.PostCreate;
import com.marvel.snap.response.PostResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class PostServiceTest {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostService postService;

    @Autowired
    private CardRepository cardRepository;

    @BeforeEach
    void clean() {
        postRepository.deleteAll();
    }

    @Test
    @DisplayName("글 작성")
    @Transactional
    void write() {
        PostCreate postCreate = PostCreate.builder()
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

        // when
        postService.write(postCreate);

        // then
        assertEquals(1L, postRepository.count());
        Post post = postRepository.findAll().get(0);
        assertEquals("제목입니다.", post.getTitle());
        assertEquals("내용입니다.", post.getContent());
        assertEquals("비비", post.getWriter());
        assertEquals("1234", post.getPassword());
        assertEquals(12, post.getCards().size());
        assertEquals("eyJDYXJkcyI6W3siQ2FyZERlZklkIjoiSWNlbWFuIn0seyJDYXJkRGVmSWQiOiJJcm9uRmlzdCJ9LHsiQ2FyZERlZklkIjoiS29yZyJ9LHsiQ2FyZERlZklkIjoiTXJGYW50YXN0aWMifSx7IkNhcmREZWZJZCI6IkRlYnJpaSJ9LHsiQ2FyZERlZklkIjoiS2FaYXIifSx7IkNhcmREZWZJZCI6IkJsdWVNYXJ2ZWwifSx7IkNhcmREZWZJZCI6IkFudE1hbiJ9LHsiQ2FyZERlZklkIjoiTmlnaHRjcmF3bGVyIn0seyJDYXJkRGVmSWQiOiJBbmdlbGEifSx7IkNhcmREZWZJZCI6IkRyRG9vbSJ9LHsiQ2FyZERlZklkIjoiQXJtb3IifV19",
                post.getDeckCode()
        );
    }

    @Test
    @DisplayName("단건 조회")
    @Transactional
    void get() {
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

        // when
        PostResponse response = postService.get(post.getId());

        // then
        assertNotNull(response);
        assertEquals(1L, postRepository.count());
        assertEquals("비비", response.getWriter());
        assertEquals("제목입니다.", response.getTitle());
        assertEquals("내용입니다.", response.getContent());
        assertEquals("eyJDYXJkcyI6W3siQ2FyZERlZklkIjoiSWNlbWFuIn0seyJDYXJkRGVmSWQiOiJJcm9uRmlzdCJ9LHsiQ2FyZERlZklkIjoiS29yZyJ9LHsiQ2FyZERlZklkIjoiTXJGYW50YXN0aWMifSx7IkNhcmREZWZJZCI6IkRlYnJpaSJ9LHsiQ2FyZERlZklkIjoiS2FaYXIifSx7IkNhcmREZWZJZCI6IkJsdWVNYXJ2ZWwifSx7IkNhcmREZWZJZCI6IkFudE1hbiJ9LHsiQ2FyZERlZklkIjoiTmlnaHRjcmF3bGVyIn0seyJDYXJkRGVmSWQiOiJBbmdlbGEifSx7IkNhcmREZWZJZCI6IkRyRG9vbSJ9LHsiQ2FyZERlZklkIjoiQXJtb3IifV19",
                response.getDeckCode()
        );
        assertEquals(12, response.getCards().size());
        assertEquals(0, response.getLike());
        assertEquals(0, response.getDisLike());
        assertEquals(1, response.getHit());
    }
}
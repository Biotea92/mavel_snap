package com.marvel.snap.request;

import com.marvel.snap.domain.Card;
import com.marvel.snap.domain.Post;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class PostCreate {

    @NotBlank(message = "작성자를 입력해주세요.")
    private String writer;

    @NotBlank(message = "패스워드를 입력해주세요")
    private String password;

    @NotBlank(message = "제목을 입력해주세요.")
    private String title;

    @NotBlank(message = "내용을 입력해주세요.")
    private String content;

    @NotBlank(message = "덱코드를 입력해주세요.")
    private String deckCode;

    @Builder
    public PostCreate(String writer, String password, String title, String content, String deckCode) {
        this.writer = writer;
        this.password = password;
        this.title = title;
        this.content = content;
        this.deckCode = deckCode;
    }

    public Post toEntity(List<Card> cards, String deckCode) {
        return Post.builder()
                .writer(this.writer)
                .password(this.password)
                .title(this.title)
                .content(this.content)
                .hit(0)
                .likePost(0)
                .disLikePost(0)
                .deckCode(deckCode)
                .cards(cards)
                .build();
    }

    public void validate() {

    }
}

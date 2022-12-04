package com.marvel.snap.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String writer;
    private String password;

    private String title;

    @Lob
    private String content;

    @Lob
    private String deckCode;

    private int hit;
    private int likePost;
    private int disLikePost;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Card> cards = new ArrayList<>();

    @Builder
    public Post(String writer, String password, String title, String content, String deckCode, int hit, int likePost, int disLikePost, List<Card> cards) {
        this.writer = writer;
        this.password = password;
        this.title = title;
        this.content = content;
        this.deckCode = deckCode;
        this.hit = hit;
        this.likePost = likePost;
        this.disLikePost = disLikePost;
        this.cards = cards;
    }

    public void upHit() {
        this.hit = hit + 1;
    }
}

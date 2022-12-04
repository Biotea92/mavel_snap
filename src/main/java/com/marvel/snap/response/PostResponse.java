package com.marvel.snap.response;

import com.marvel.snap.domain.Card;
import com.marvel.snap.domain.Post;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class PostResponse {

    private final Long id;
    private final String writer;
    private final String title;
    private final String content;
    private final String deckCode;
    private final List<Card> cards;
    private final int hit;
    private final int like;
    private final int disLike;

    @Builder
    public PostResponse(Post post) {
        this.id = post.getId();
        this.writer = post.getWriter();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.deckCode = post.getDeckCode();
        this.cards = post.getCards();
        this.hit = post.getHit();
        this.like = post.getLikePost();
        this.disLike = post.getDisLikePost();
    }
}

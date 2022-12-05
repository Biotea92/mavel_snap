package com.marvel.snap.service;

import com.marvel.snap.domain.Card;
import com.marvel.snap.domain.Post;
import com.marvel.snap.exception.InvalidRequest;
import com.marvel.snap.exception.PostNotFound;
import com.marvel.snap.repository.CardRepository;
import com.marvel.snap.repository.PostRepository;
import com.marvel.snap.request.PostCreate;
import com.marvel.snap.request.PostsPage;
import com.marvel.snap.response.PostResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final CardRepository cardRepository;

    @Transactional
    public void write(PostCreate postCreate) {
        List<String> tmp = Arrays.stream(postCreate.getDeckCode().split("\n"))
                .collect(Collectors.toList());

        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            String tmpString = tmp.get(i);
            String engName = tmpString.substring(6).trim();
            cardRepository.findById(engName)
                    .ifPresent(cards::add);
        }
        String deckCode = tmp.get(13);

        Post post = postCreate.toEntity(cards, deckCode);
        postRepository.save(post);
    }

    public PostResponse get(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(PostNotFound::new);

        post.upHit();

        return PostResponse.builder()
                .post(post)
                .build();
    }

    public List<PostResponse> getList(PostsPage postsPage) {
        return postRepository.getList(postsPage).stream()
                .map(PostResponse::new)
                .collect(Collectors.toList());
    }

    public List<PostResponse> getRecommendationList(PostsPage postsPage) {
        return postRepository.getRecommendationList(postsPage).stream()
                .map(PostResponse::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id, String password) {
        Post post = postRepository.findById(id)
                .orElseThrow(PostNotFound::new);

        if (!post.getPassword().equals(password)) {
            throw new InvalidRequest("password" , "패스워드가 일치하지 않습니다.");
        }

        postRepository.delete(post);
    }
}

package com.marvel.snap.repository;

import com.marvel.snap.domain.Post;
import com.marvel.snap.domain.QPost;
import com.marvel.snap.request.PostsPage;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class PostRepositoryCustomImpl implements PostRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Post> getList(PostsPage postsPage) {
        return jpaQueryFactory.selectFrom(QPost.post)
                .limit(postsPage.getSize())
                .offset(postsPage.getOffset())
                .orderBy(QPost.post.id.desc())
                .fetch();
    }
}

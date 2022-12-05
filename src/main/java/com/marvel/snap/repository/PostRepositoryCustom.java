package com.marvel.snap.repository;

import com.marvel.snap.domain.Post;
import com.marvel.snap.request.PostsPage;

import java.util.List;

public interface PostRepositoryCustom {
    List<Post> getList(PostsPage postsPage);
}

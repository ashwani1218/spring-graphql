package com.ashwani.graphql.service;

import com.ashwani.graphql.entity.Post;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PostService {

    Flux<Post> getAllPost();
    Mono<Post> getPost(Long id);
    Mono<Post> createPost(String title, String category, String authorId);
    Mono<Post> findById(Long id);
}

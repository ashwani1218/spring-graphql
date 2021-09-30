package com.ashwani.graphql.service;

import com.ashwani.graphql.entity.Post;

import java.util.List;

public interface PostService {

    List<Post> getAllPost(int limit);
    Post getPost(Long id);
    Post createPost(String title, String category, String authorId);
}

package com.ashwani.graphql.service;

import com.ashwani.graphql.entity.Post;
import com.ashwani.graphql.repository.PostRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PostQuery implements GraphQLQueryResolver {

    @Autowired
    private PostService postService;

    public List<Post> getPost(final int count) {
        return postService.getAllPost(count);
    }

    public Post getPost(final Long id) {
        return postService.getPost(id);
    }
}

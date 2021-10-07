package com.ashwani.graphql.service;

import com.ashwani.graphql.entity.Post;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PostMutation implements GraphQLMutationResolver {
    @Autowired
    private PostService postService;

    public Post createVehicle(String title, String category, String authorId) {
        return postService.createPost(title,category,authorId);
    }
}

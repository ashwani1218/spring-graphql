package com.ashwani.graphql.controller;

import com.ashwani.graphql.entity.Post;
import com.ashwani.graphql.service.PostService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class PostController {

    private final PostService postService;


    public PostController(PostService postService) {
        this.postService = postService;
    }

    @QueryMapping
    Flux<Post> posts(){
        return this.postService.getAllPost();
    }

    @QueryMapping
    Mono<Post> post(@Argument Long id){
        return this.postService.getPost(id);
    }
}

package com.ashwani.graphql.controller;

import com.ashwani.graphql.entity.Post;
import com.ashwani.graphql.entity.PostEvent;
import com.ashwani.graphql.entity.PostEventType;
import com.ashwani.graphql.service.PostService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SubscriptionMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.channels.FileLock;
import java.time.Duration;
import java.util.stream.Stream;

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

    @MutationMapping
    Mono<Post> createPost(@Argument String title, @Argument String category, @Argument String authorId){
        return this.postService.createPost(title,category,authorId);
    }

    @SubscriptionMapping
    Flux<PostEvent> postEvents(@Argument Long postId ){
        return this.postService.findById(postId)
                .flatMapMany(post -> {
                    var stream= Stream.generate(
                            () -> new PostEvent(post, Math.random() > 0.5 ? PostEventType.DELETED : PostEventType.UPDATED));

                    return Flux.fromStream(stream);
                })
                .delayElements(Duration.ofSeconds(1))
                .take(10);
    }
}

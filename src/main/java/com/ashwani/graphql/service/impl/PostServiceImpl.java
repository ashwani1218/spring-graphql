package com.ashwani.graphql.service.impl;

import com.ashwani.graphql.entity.Post;
import com.ashwani.graphql.repository.PostRepository;
import com.ashwani.graphql.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public Flux<Post> getAllPost() {
        return this.postRepository.findAll();
    }

    @Override
    public Mono<Post> getPost(Long id) {
        return this.postRepository.findById(id);

    }

    @Override
    public Mono<Post> createPost(String title, String category, String authorId) {
        return this.postRepository.save(new Post(null,title,category,authorId));
    }
}

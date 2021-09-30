package com.ashwani.graphql.service.impl;

import com.ashwani.graphql.entity.Post;
import com.ashwani.graphql.repository.PostRepository;
import com.ashwani.graphql.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Post> getAllPost(int limit) {
        return this.postRepository.findAll().stream().limit(limit).collect(Collectors.toList());
    }

    @Override
    public Post getPost(Long id) {
        Optional<Post> post = postRepository.findById(id);
        return post.orElse(null);
    }

    @Override
    @Transactional
    public Post createPost(String title, String category, String authorId) {
        Post post = Post.builder().title(title).category(category).authorId(authorId).build();
        return postRepository.save(post);
    }
}

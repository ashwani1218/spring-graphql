package com.ashwani.graphql.repository;

import com.ashwani.graphql.entity.Post;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface PostRepository extends ReactiveCrudRepository<Post, Long> {
}

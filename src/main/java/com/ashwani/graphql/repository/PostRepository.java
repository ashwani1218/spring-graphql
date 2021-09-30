package com.ashwani.graphql.repository;

import com.ashwani.graphql.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}

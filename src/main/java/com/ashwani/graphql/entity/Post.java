package com.ashwani.graphql.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;

public record Post(@JsonProperty("id") @Id Long id, @JsonProperty("title") String title
        , @JsonProperty("category") String category, @JsonProperty("authorId") String authorId) {
}

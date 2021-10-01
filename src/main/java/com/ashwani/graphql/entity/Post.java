package com.ashwani.graphql.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@EqualsAndHashCode
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Post implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
            name = "title"
    )
    private String title;

    @Column(
            name = "category"
    )
    private String category;

    @Column(
            name = "authorId"
    )
    private String authorId;

}

package com.blog.articleservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long articleId;

    @Column(name = "articleTitle")
    private String articleTitle;

    @Column(name = "authorId")
    private Long authorId;

    @Column(name="articleDescription")
    private String articleDescription;

    @Column(name = "articleCategory")
    private String articleCategory;

    @Column(name = "articleImagePath")
    private String articleImagePath;
}

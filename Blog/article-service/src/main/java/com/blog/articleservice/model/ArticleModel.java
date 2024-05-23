package com.blog.articleservice.model;


import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticleModel {


    private String articleTitle;
    private String articleDescription;
    private String articleCategory;
    private String articleImagePath;
    private AuthorModel authorModel;

}

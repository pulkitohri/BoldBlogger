package com.blog.articleservice.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthorModel {
    private Long authorId;
    private String authorName;
    private String authorEmail;
    private String authorDescription;
}

package com.blog.articleservice.repository;

import com.blog.articleservice.entity.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ArticleRepository extends JpaRepository<Article,Long> {
    Page<Article> findByArticleCategory(String category, Pageable pageable);
}

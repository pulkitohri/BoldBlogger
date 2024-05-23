package com.blog.articleservice.service;

import com.blog.articleservice.client.AuthorClient;
import com.blog.articleservice.entity.Article;
import com.blog.articleservice.model.ArticleModel;
import com.blog.articleservice.model.AuthorModel;
import com.blog.articleservice.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;
    private final AuthorClient authorClient;

    public Page<Article> getAllArticles(int pageNum, int pageSize){
        Pageable pageable = PageRequest.of(pageNum,pageSize);
        return articleRepository.findAll(pageable);
    }


    public Page<Article> getByCategory(String category, int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum,pageSize);
        return articleRepository.findByArticleCategory(category,pageable);
    }

    public ArticleModel getByArticleId(Long articleId) throws Exception {
        Optional<Article> article = articleRepository.findById(articleId);
        if(article.isEmpty())
            throw new Exception("Article not found");
        AuthorModel authorModel = authorClient.getByAuthorId(article.get().getAuthorId());
        return ArticleModel.builder()
                .articleTitle(article.get().getArticleTitle())
                .articleCategory(article.get().getArticleCategory())
                .articleDescription(article.get().getArticleDescription())
                .articleImagePath(article.get().getArticleImagePath())
                .authorModel(authorModel)
                .build();


    }
}

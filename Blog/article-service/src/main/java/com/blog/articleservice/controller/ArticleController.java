package com.blog.articleservice.controller;


import com.blog.articleservice.entity.Article;
import com.blog.articleservice.model.ArticleModel;
import com.blog.articleservice.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/articles")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping
    public Page<Article> getAllArticles(
            @RequestParam("page") int pageNum,
            @RequestParam("size") int pageSize
    ){
        return articleService.getAllArticles(pageNum,pageSize);
    }

    @GetMapping("/search")
    public Page<Article> getByCategory(
            @RequestParam String category,
            @RequestParam("page") int pageNum,
            @RequestParam("size") int pageSize
    ){
        return articleService.getByCategory(category,pageNum,pageSize);
    }

    @GetMapping("/{articleId}")
    public ArticleModel getByArticleId(@PathVariable Long articleId) throws Exception {
        return articleService.getByArticleId(articleId);
    }




}

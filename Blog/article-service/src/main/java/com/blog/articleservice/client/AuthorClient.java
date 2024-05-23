package com.blog.articleservice.client;

import com.blog.articleservice.model.AuthorModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name="author-service",url="${application.config.author-url}")
public interface AuthorClient {
    @GetMapping
    public AuthorModel getByAuthorId(@RequestParam("authorId") Long authorId);
}

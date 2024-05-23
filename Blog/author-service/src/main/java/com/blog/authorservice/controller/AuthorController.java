package com.blog.authorservice.controller;


import com.blog.authorservice.entity.Author;
import com.blog.authorservice.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/author")
@RequiredArgsConstructor
@RestController
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping
    public Author getById(@RequestParam("authorId")
                              Long authorId) throws Exception {
        return authorService.getById(authorId);
    }

}

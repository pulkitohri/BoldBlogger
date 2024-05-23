package com.blog.authorservice.service;


import com.blog.authorservice.entity.Author;
import com.blog.authorservice.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;


    public Author getById(Long authorId) throws Exception {
        Optional<Author> author = authorRepository.findById(authorId);
        if(author.isEmpty()){
            throw new Exception("Not found");
        }
        return author.get();
    }

}

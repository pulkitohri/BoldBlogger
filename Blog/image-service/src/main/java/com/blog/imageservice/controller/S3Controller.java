package com.blog.imageservice.controller;


import com.blog.imageservice.service.ImageUploader;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

@RestController
@RequestMapping("/api/v1/aws/secure")
@RequiredArgsConstructor
public class S3Controller {
    private final ImageUploader imageUploader ;

    @PostMapping
    public ResponseEntity<?> uploadImage(
            @RequestParam Long articleId,
            @RequestParam MultipartFile file){
        return ResponseEntity.ok(imageUploader.uploadImage(articleId,file));
    }

    @GetMapping
    public InputStream getFile(
            @RequestParam String fileName){
        return imageUploader.getFile(fileName);
    }

}

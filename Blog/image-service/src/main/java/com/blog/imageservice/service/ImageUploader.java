package com.blog.imageservice.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

public interface ImageUploader {

    String uploadImage(Long articleId,MultipartFile image);
    InputStream getFile(String fileName);
}

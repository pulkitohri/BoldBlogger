package com.blog.imageservice.service;

import org.springframework.web.multipart.MultipartFile;

public interface ImageUploader {

    String uploadImage(MultipartFile image);



}

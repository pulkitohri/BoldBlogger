package com.blog.imageservice.service.impl;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.blog.imageservice.service.ImageUploader;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class S3Uploader implements ImageUploader {

    private final AmazonS3 client;

    @Value("${cloud.aws.S3.bucketName}")
    private String bucketName;

    @Override
    public String uploadImage(MultipartFile image) {
        PutObjectResult putObjectResult = client.putObject();
        return "";
    }
}

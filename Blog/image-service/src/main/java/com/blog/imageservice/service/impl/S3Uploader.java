package com.blog.imageservice.service.impl;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3Object;
import com.blog.imageservice.service.ImageUploader;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@Service
@RequiredArgsConstructor
public class S3Uploader implements ImageUploader {

    private final AmazonS3 client;

    @Value("${app.S3.bucketName}")
    private String bucketName;

    @Override
    public String uploadImage(Long articleId,MultipartFile image) {
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(image.getSize());
        String fileName = articleId.toString()+image.getOriginalFilename();
        try {
            PutObjectResult putObjectResult = client.
                    putObject(new PutObjectRequest(bucketName,fileName,image.getInputStream(),metadata));
            return fileName;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public InputStream getFile(String fileName){
        S3Object object =  client.getObject(bucketName,fileName);
        return object.getObjectContent();
    }
}

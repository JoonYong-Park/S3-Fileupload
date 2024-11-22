package com.joon.fileupload.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectResult;
import java.io.IOException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@Log4j2
public class FileUploadService {

    private final AmazonS3 s3Client;

    @Value("${aws.s3.bucket}")
    private String bucketName;

    public FileUploadService(AmazonS3 s3Client) {
        this.s3Client = s3Client;
    }

    public String uploadFile(String keyName, MultipartFile file) throws IOException {
        PutObjectResult putObjectResult = s3Client.putObject(bucketName, keyName, file.getInputStream(), null);
        log.info(putObjectResult.getMetadata());
        return s3Client.getUrl(bucketName, keyName).toString();
    }

}

package com.joon.fileupload.controller;

import com.joon.fileupload.service.FileUploadService;
import java.io.IOException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@Log4j2
@RequestMapping("/api")
public class FileUploadController {

  private final FileUploadService fileUploadService;

  public FileUploadController(FileUploadService fileUploadService) {
    this.fileUploadService = fileUploadService;
  }

  @GetMapping
  public String status() {
    return "OK";
  }

  @PostMapping(path = "/upload", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
  public ResponseEntity<String> uploadFile(@RequestParam("photos") MultipartFile file)
      throws IOException {
    String fileUrl = fileUploadService.uploadFile(file.getOriginalFilename(), file);
    return ResponseEntity.ok(fileUrl);
  }

}

package com.osvaldo.metaphorce.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class RequestController {
    public static final String UPLOAD_DIR = "uploads/";

    @PostMapping("/uploader")
    public ResponseEntity uploader(@RequestParam("fileName") String fileName, @RequestParam("file") MultipartFile file) {
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    

    @GetMapping("/downloader")
    public ResponseEntity downloader(@RequestParam String fileName) {
//      Response res= new Response("test_file.txt");
        return new ResponseEntity<>("test_file.txt", HttpStatus.OK);
    }
}

package com.webmister.semicolon.controller;

import com.webmister.semicolon.repository.ReportRepository;
import com.webmister.semicolon.request.UploadRequest;
import com.webmister.semicolon.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ReportController {
    @Autowired
    ReportService reportService;

    @PostMapping("/reportUpload")
    public ResponseEntity<Boolean> reportUpload(@RequestBody UploadRequest uploadRequest){
        HttpHeaders resHeaders = new HttpHeaders();
        resHeaders.add("Content-Type", "application/json;charset=UTF-8");

        try {
            reportService.reportUpload(uploadRequest);
        }catch (Exception e){
            return new ResponseEntity<>(Boolean.FALSE, resHeaders, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(Boolean.TRUE, resHeaders, HttpStatus.OK);
    }
}

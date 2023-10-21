package com.csvtojson.controller;

import com.csvtojson.util.csvtomap.CsvToMap;
import jdk.jshell.Snippet;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@CrossOrigin
@RestController
public class csvtojson {
    @PostMapping("/uploadCsv")
    public ResponseEntity loadCsv(@RequestParam(name = "file") MultipartFile file) {
        try {
            //csvToUsabale(file.getInputStream())
            CsvToMap csvToMap = new CsvToMap();
            Map<Long, Map<String, String>> map = csvToMap.csvToMap(file.getInputStream());
            return ResponseEntity.status(HttpStatus.OK).body(map);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("following problems occur");
        }
    }
}

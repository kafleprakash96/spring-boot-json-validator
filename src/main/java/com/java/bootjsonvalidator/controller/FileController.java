package com.java.bootjsonvalidator.controller;

import com.java.bootjsonvalidator.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/json")
public class FileController {

    @Autowired
    private FileService fileService;


    @PostMapping("/validate")
    public void readFile(@RequestParam String fileName, @RequestBody String jsonSample){
        fileService.readFile(jsonSample,fileName);
    }
}

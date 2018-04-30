package com.arydz.learning.analyzer.controller;

import com.arydz.learning.analyzer.model.Readable;
import com.arydz.learning.analyzer.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
public class FileController {

    @Autowired
    private FileService fileService;

    @RequestMapping("/")
    public String hello() {
        return "Hello";
    }

    @RequestMapping("/analyze")
    public List<Readable> mapFiles() {
        Path path = Paths.get(System.getProperty("user.home") + "/Pobrane/splited_files/test.csv");
        boolean skipFirstLine = true;
        List<Readable> rows = fileService.mapFile(path, skipFirstLine);
        fileService.saveFileRows(rows);
        return rows;
    }

}

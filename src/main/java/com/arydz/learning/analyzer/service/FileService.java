package com.arydz.learning.analyzer.service;

import com.arydz.learning.analyzer.mapper.TrafficViolationsMapper;
import com.arydz.learning.analyzer.utils.CSVFileReader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.Path;

@Slf4j
@Service
public class FileService {

    private TrafficViolationsMapper trafficViolationsMapper;

    @Autowired
    public FileService(TrafficViolationsMapper trafficViolationsMapper) {
        this.trafficViolationsMapper = trafficViolationsMapper;
    }

    /**
     * Map whole file line by line on java object
     * @param pathWithFileName is path to specified file
     */
    public void mapFile(Path pathWithFileName) {
        CSVFileReader.mapFile(pathWithFileName, trafficViolationsMapper);
    }
}

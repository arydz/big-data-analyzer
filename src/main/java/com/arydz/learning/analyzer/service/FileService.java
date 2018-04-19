package com.arydz.learning.analyzer.service;

import com.arydz.learning.analyzer.mapper.RowToPojoMapper;
import com.arydz.learning.analyzer.mapper.TrafficViolationsMapper;
import com.arydz.learning.analyzer.model.Readable;
import com.arydz.learning.analyzer.utils.CSVFileReader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.util.List;

@Slf4j
@Service
public class FileService {

    private RowToPojoMapper trafficViolationsMapper;

    @Autowired
    public FileService(TrafficViolationsMapper trafficViolationsMapper) {
        this.trafficViolationsMapper = trafficViolationsMapper;
    }

    /**
     * Map whole file line by line on java object
     * @param pathWithFileName is path to specified file
     */
    public <T extends Readable> List<T> mapFile(Path pathWithFileName, boolean skipFirstLine) {
        return CSVFileReader.mapFile(pathWithFileName, trafficViolationsMapper, skipFirstLine);
    }
}

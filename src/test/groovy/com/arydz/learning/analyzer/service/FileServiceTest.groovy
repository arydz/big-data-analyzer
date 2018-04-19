package com.arydz.learning.analyzer.service

import com.arydz.learning.analyzer.mapper.TrafficViolationsMapper
import spock.lang.Specification

import java.nio.file.Path
import java.nio.file.Paths

class FileServiceTest extends Specification {

    def trafficViolationsMapper = new TrafficViolationsMapper()
    private FileService fileService = new FileService(trafficViolationsMapper)

    def "test mapFile"() {
        given:
        Path path = Paths.get(System.getProperty("user.home") + "/Pobrane/splited_files/test.csv")
        when:
        fileService.mapFile(path)
        then:
        noExceptionThrown()
    }
}

package com.arydz.learning.analyzer.utils

import spock.lang.Specification
import spock.lang.Unroll

import java.nio.file.Path
import java.nio.file.Paths

class CSVFileReaderTest extends Specification {

    @Unroll
    def "test read"() {
        given:
        Path path = Paths.get(System.getProperty("user.home") + "/Pobrane/splited_files/test.csv")
        when:
        CSVFileReader.read(path)
        then:
        noExceptionThrown()
    }
}

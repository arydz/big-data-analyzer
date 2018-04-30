package com.arydz.learning.analyzer.service

import com.arydz.learning.analyzer.mapper.TrafficViolationsMapper
import com.arydz.learning.analyzer.model.Readable
import com.arydz.learning.analyzer.model.TrafficViolations
import com.arydz.learning.analyzer.repository.TrafficViolationsRepository
import ma.glasnost.orika.MapperFacade
import spock.lang.Specification

import java.nio.file.Path
import java.nio.file.Paths
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class FileServiceTest extends Specification {

    private TrafficViolationsRepository trafficViolationsRepository = Mock(TrafficViolationsRepository)
    private MapperFacade mapper = Mock(MapperFacade)

    private TrafficViolationsMapper trafficViolationsMapper = new TrafficViolationsMapper()
    private TrafficViolationsService trafficViolationsService = new TrafficViolationsService(
            trafficViolationsRepository, mapper)
    private FileService fileService = new FileService(trafficViolationsMapper, trafficViolationsService)

    def "test mapFile"() {
        given:
        Path path = Paths.get(System.getProperty("user.home") + "/Pobrane/splited_files/test.csv")
        boolean skipFirstLine = true
        when:
        List<Readable> result = fileService.mapFile(path, skipFirstLine)
        then:
        GroovyTestCase.assertTrue(result != null || result.isEmpty())
        GroovyTestCase.assertEquals(19, result.size())
        noExceptionThrown()
    }

    def "test saveFileRows"() {
        given:
        List<Readable> list = createTrafficViolationsList()
        when:
        fileService.saveFileRows(list)
        then:
        noExceptionThrown()
    }

    private List<TrafficViolations> createTrafficViolationsList() {
        List<TrafficViolations> trafficViolationsList = new LinkedList<>()
        trafficViolationsList.add(createTrafficViolations())
        return trafficViolationsList
    }

    private TrafficViolations createTrafficViolations() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy")
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss")
        LocalDateTime localDate = LocalDateTime.now()
        TrafficViolations trafficViolations = TrafficViolations.builder().dateOfStop(localDate.format(formatter)).
                timeOfStop(localDate.format(timeFormatter)).agency("MCP").subAgency("3rd district, test this").
                description("DRIVING TEST").location("8804 FLOWER AVE").propertyDamage("NO").
                alcohol("YES").state("MD").vehicleType("02 - Automobile").year("2002").
                make("FORD").model("NEW").color("GREEN").gender("F").build()
        return trafficViolations
    }
}

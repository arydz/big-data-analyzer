package com.arydz.learning.analyzer.service

import com.arydz.learning.analyzer.entity.TrafficViolationsEntity
import com.arydz.learning.analyzer.model.TrafficViolations
import com.arydz.learning.analyzer.repository.TrafficViolationsRepository
import ma.glasnost.orika.MapperFacade
import ma.glasnost.orika.MapperFactory
import ma.glasnost.orika.test.MappingUtil
import spock.lang.Specification

class TrafficViolationsServiceTest extends Specification {

    private TrafficViolationsRepository trafficViolationsRepository = Mock(TrafficViolationsRepository)
    private MapperFactory factory = MappingUtil.getMapperFactory(false)
    private MapperFacade mapper = factory.getMapperFacade()
    private TrafficViolationsService trafficViolationsService = new TrafficViolationsService(
            trafficViolationsRepository, mapper)

    def "test findAll"() {
        given:
        trafficViolationsRepository.findAll() >> createStubOfTrafficViolationsList()
        when:
        def result = trafficViolationsService.findAll()
        then:
        result != null

    }

    private List<TrafficViolationsEntity> createStubOfTrafficViolationsList() {
        List<TrafficViolationsEntity> result = new LinkedList<>()
        result.add(TrafficViolationsEntity.builder().build())
        return result
    }

    def "test save"() {
        given:
        def trafficViolations = TrafficViolations.builder().build()
        when:
        trafficViolationsService.save(trafficViolations)
        then:
        noExceptionThrown()
    }

    def "test saveAll"() {
        given:
        def violationsList = createStubOfTrafficViolationsList()
        when:
        trafficViolationsService.saveAll(violationsList)
        then:
        noExceptionThrown()
    }
}

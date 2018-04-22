package com.arydz.learning.analyzer.mapper

import spock.lang.Specification

class TrafficViolationsMapperTest extends Specification {

    TrafficViolationsMapper mapper = new TrafficViolationsMapper()

    def "test map"() {
        given:
        String[] line = ["09/24/2013", "17:11:00", "MCP", "3rd district", "Silver Spring",
                         "DRIVING VEHICLE ON HIGHWAY WITH SUSPENDED REGISTRATION", "8804 FLOWER AVE", "", "",
                         "No", "No", "No", "No", "No", "No", "No", "No", "No", "No", "MD,02 - Automobile", "2008",
                         "FORD", "4S", "BLACK", "Citation", "13-401(h)", "Transportation Article", "No", "BLACK", "M",
                         "TAKOMA PARK", "MD", "MD", "A - Marked Patrol", ""]
        when:
        def trafficViolations = mapper.map(line)
        then:
        GroovyTestCase.assertTrue(trafficViolations != null)
        GroovyTestCase.assertEquals("A - Marked Patrol", trafficViolations.getArrestType())
    }
}

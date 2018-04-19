package com.arydz.learning.analyzer.mapper;

import com.arydz.learning.analyzer.model.TrafficViolations;
import org.springframework.stereotype.Component;

@Component
public class TrafficViolationsMapper implements RowToPojoMapper<TrafficViolations> {

    /**
     * {@inheritDoc}
     * @param line is current read line
     * @return mapped object
     */
    @Override
    public TrafficViolations map(String[] line) {
        return TrafficViolations.builder()
                .dateOfStop(line[0])
                .timeOfStop(line[1])
                .agency(line[2])
                .subAgency(line[3])
                .description(line[4])
                .location(line[5])
                .latitude(line[6])
                .longitude(line[7])
                .accident(line[8])
                .belts(line[9])
                .personalInjury(line[10])
                .propertyDamage(line[11])
                .fatal(line[12])
                .commercialLicense(line[13])
                .hazmat(line[14])
                .commercialVehicle(line[15])
                .alcohol(line[16])
                .workZone(line[17])
                .state(line[18])
                .vehicleType(line[19])
                .year(line[20])
                .make(line[21])
                .model(line[22])
                .color(line[23])
                .violationType(line[24])
                .charge(line[25])
                .article(line[26])
                .contributedToAccident(line[27])
                .race(line[28])
                .gender(line[29])
                .driverCity(line[30])
                .driverState(line[31])
                .dlState(line[32])
                .arrestType(line[33])
                .geolocation(line[34])
                .build();
    }

}

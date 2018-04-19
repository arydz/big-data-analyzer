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
        return TrafficViolations.builder().dateOfStop(line[0]).timeOfStop(line[1]).agency(line[2]).build();
    }
}

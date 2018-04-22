package com.arydz.learning.analyzer.service;

import com.arydz.learning.analyzer.model.TrafficViolations;
import com.arydz.learning.analyzer.repository.TrafficViolationsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class TrafficViolationsService {

    @Autowired
    TrafficViolationsRepository trafficViolationsRepository;

    public List<TrafficViolations> findAll() {
        //return trafficViolationsRepository.findAll();
        return null;
    }

    public void save(TrafficViolations trafficViolations) {
//        trafficViolationsRepository.saveAndFlush(trafficViolations);
    }

}

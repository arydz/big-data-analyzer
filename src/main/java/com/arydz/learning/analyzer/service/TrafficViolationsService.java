package com.arydz.learning.analyzer.service;

import com.arydz.learning.analyzer.entity.TrafficViolationsEntity;
import com.arydz.learning.analyzer.model.Readable;
import com.arydz.learning.analyzer.model.TrafficViolations;
import com.arydz.learning.analyzer.repository.TrafficViolationsRepository;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class TrafficViolationsService {

    private TrafficViolationsRepository trafficViolationsRepository;
    private MapperFacade mapper;

    @Autowired
    public TrafficViolationsService(TrafficViolationsRepository trafficViolationsRepository, MapperFacade mapper) {
        this.trafficViolationsRepository = trafficViolationsRepository;
        this.mapper = mapper;
    }

    public List<TrafficViolations> findAll() {
        List<TrafficViolationsEntity> trafficViolations = trafficViolationsRepository.findAll();
        return mapper.mapAsList(trafficViolations, TrafficViolations.class);
    }

    public void save(Readable trafficViolations) {
        TrafficViolationsEntity trafficViolationsEntity = mapper.map(trafficViolations, TrafficViolationsEntity.class);
        trafficViolationsRepository.saveAndFlush(trafficViolationsEntity);
    }

    public void saveAll(List<Readable> trafficViolations) {
        List<TrafficViolationsEntity> trafficViolationsEntity = mapper.mapAsList(trafficViolations, TrafficViolationsEntity.class);
        trafficViolationsRepository.saveAll(trafficViolationsEntity);
    }

}

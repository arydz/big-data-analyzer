package com.arydz.learning.analyzer.repository;

import com.arydz.learning.analyzer.entity.TrafficViolationsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrafficViolationsRepository extends JpaRepository<TrafficViolationsEntity, Long> {

}

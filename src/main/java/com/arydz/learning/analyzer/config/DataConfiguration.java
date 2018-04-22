package com.arydz.learning.analyzer.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.arydz.learning.analyzer.repository")
@EntityScan(basePackages = "com.arydz.learning.analyzer.entity")
public class DataConfiguration {
}

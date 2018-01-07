package com.bf1stats.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.bf1stats.dao")
@EntityScan(basePackages = "com.bf1stats.domain.db.basic")
public class DatabaseConfiguration {
}

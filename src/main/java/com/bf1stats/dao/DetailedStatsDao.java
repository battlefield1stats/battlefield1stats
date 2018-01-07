package com.bf1stats.dao;

import com.bf1stats.domain.db.basic.DetailedStatsDb;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailedStatsDao extends CrudRepository<DetailedStatsDb, Long> {
}

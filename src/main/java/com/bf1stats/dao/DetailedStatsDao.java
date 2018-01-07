package com.bf1stats.dao;

import com.bf1stats.domain.db.DetailedStatsDb;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DetailedStatsDao extends CrudRepository<DetailedStatsDb, Long> {
    Optional<DetailedStatsDb> findFirstByOrderByRecordedDesc();
}

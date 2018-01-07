package com.bf1stats.client;

import org.springframework.stereotype.Repository;

@Repository
public class DetailedStatsClient extends AbstractClient {

    @Override
    String getResource() {
        return "Stats/DetailedStats";
    }
}

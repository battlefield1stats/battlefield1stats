package com.bf1stats.client;

import com.bf1stats.domain.json.basic.DetailedStatsResponseJson;
import org.springframework.stereotype.Repository;

@Repository
public class DetailedStatsClient extends AbstractClient<DetailedStatsResponseJson> {

    @Override
    String getResource() {
        return "Stats/DetailedStats";
    }

    @Override
    Class<DetailedStatsResponseJson> getTargetClass() {
        return DetailedStatsResponseJson.class;
    }
}

package com.bf1stats.client;

import org.springframework.stereotype.Repository;

@Repository
public class VehiclesStatsClient extends AbstractClient {

    @Override
    String getResource() {
        return "Progression/GetVehicles";
    }
}

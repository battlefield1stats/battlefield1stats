package com.bf1stats.client;

import com.bf1stats.domain.json.vehicles.VehiclesResponseJson;
import org.springframework.stereotype.Repository;

@Repository
public class VehiclesStatsClient extends AbstractClient<VehiclesResponseJson> {

    @Override
    String getResource() {
        return "Progression/GetVehicles";
    }

    @Override
    Class<VehiclesResponseJson> getTargetClass() {
        return VehiclesResponseJson.class;
    }
}

package com.bf1stats.api;

import com.bf1stats.client.DetailedStatsClient;
import com.bf1stats.client.VehiclesStatsClient;
import com.bf1stats.client.WeaponsStatsClient;
import com.bf1stats.domain.basic.DetailedStatsResponse;
import com.bf1stats.domain.vehicles.VehiclesResponse;
import com.bf1stats.domain.weapons.WeaponsResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api")
public class BaseStatsController {

    private static Logger LOGGER = LoggerFactory.getLogger(BaseStatsController.class);

    @Autowired
    private DetailedStatsClient detailedStatsClient;

    @Autowired
    private VehiclesStatsClient vehiclesStatsClient;

    @Autowired
    private WeaponsStatsClient weaponsStatsClient;

    @RequestMapping("baseStats")
    public String baseStats() {
        DetailedStatsResponse response = detailedStatsClient.getFromResource(DetailedStatsResponse.class);
        VehiclesResponse vehiclesResp = vehiclesStatsClient.getFromResource(VehiclesResponse.class);
        WeaponsResponse weaponsResponse = weaponsStatsClient.getFromResource(WeaponsResponse.class);
        return "Hello World!";
    }
}

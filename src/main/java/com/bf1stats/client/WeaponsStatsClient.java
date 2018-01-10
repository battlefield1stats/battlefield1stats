package com.bf1stats.client;

import com.bf1stats.domain.json.weapons.WeaponsResponseJson;
import org.springframework.stereotype.Repository;

@Repository
public class WeaponsStatsClient extends AbstractClient<WeaponsResponseJson> {

    @Override
    String getResource() {
        return "Progression/GetWeapons";
    }

    @Override
    Class<WeaponsResponseJson> getTargetClass() {
        return WeaponsResponseJson.class;
    }
}

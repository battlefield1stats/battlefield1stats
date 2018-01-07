package com.bf1stats.domain.json.weapons;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class WeaponDeserializer extends StdDeserializer<WeaponJson> {

    public WeaponDeserializer() {
        super(WeaponJson.class);
    }

    @Override
    public WeaponJson deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        JsonNode node = jp.getCodec().readTree(jp);
        WeaponJson weapon = new WeaponJson();
        weapon.setName(node.get("name").asText());
        JsonNode values = node.get("stats").get("values");
        weapon.setKills(values.get("kills") != null ? values.get("kills").asInt() : 0);
        weapon.setShots(values.get("shots") != null ? values.get("shots").asInt() : 0);
        weapon.setHits(values.get("hits") != null ? values.get("hits").asInt() : 0);
        weapon.setAccuracy(values.get("accuracy") != null ? values.get("accuracy").asDouble() : 0);
        weapon.setHeadshots(values.get("headshots") != null ? values.get("headshots").asInt() : 0);
        weapon.setTimeUsed(values.get("seconds") != null ? values.get("seconds").asDouble() : 0);
        return weapon;
    }
}

package com.bf1stats.domain.json.vehicles;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class VehicleDeserializer extends StdDeserializer<VehicleJson> {

    public VehicleDeserializer() {
        super(VehicleJson.class);
    }

    @Override
    public VehicleJson deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        JsonNode node = jp.getCodec().readTree(jp);
        VehicleJson vehicle = new VehicleJson();
        vehicle.setName(node.get("name").asText());
        JsonNode values = node.get("stats").get("values");
        vehicle.setTimeIn(values.get("seconds").asDouble());
        vehicle.setKills(values.get("kills").asInt());
        vehicle.setDestroyed(values.get("destroyed").asInt());
        return vehicle;
    }
}

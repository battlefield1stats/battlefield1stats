package com.bf1stats.domain.vehicles;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class VehicleDeserializer extends StdDeserializer<Vehicle> {

    public VehicleDeserializer() {
        super(Vehicle.class);
    }

    @Override
    public Vehicle deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        JsonNode node = jp.getCodec().readTree(jp);
        Vehicle vehicle = new Vehicle();
        vehicle.setName(node.get("name").asText());
        JsonNode values = node.get("stats").get("values");
        vehicle.setTimeIn(values.get("seconds").asDouble());
        vehicle.setKills(values.get("kills").asInt());
        vehicle.setDestroyed(values.get("destroyed").asInt());
        return vehicle;
    }
}

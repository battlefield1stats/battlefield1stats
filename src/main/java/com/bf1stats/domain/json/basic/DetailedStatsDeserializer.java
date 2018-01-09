package com.bf1stats.domain.json.basic;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DetailedStatsDeserializer extends StdDeserializer<DetailedStatsJson> {

    public DetailedStatsDeserializer() {
        super(DetailedStatsJson.class);
    }

    @Override
    public DetailedStatsJson deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        JsonNode nodeTotal = jp.getCodec().readTree(jp);
        JsonNode nodeBasic = nodeTotal.get("basicStats");
        DetailedStatsJson detailedStatsJson = new DetailedStatsJson();
        detailedStatsJson.setKills(nodeBasic.get("kills").asInt());
        detailedStatsJson.setDeaths(nodeBasic.get("deaths").asInt());
        detailedStatsJson.setKpm(nodeBasic.get("kpm").asDouble());
        detailedStatsJson.setHeadShots(nodeTotal.get("headShots").asInt());
        detailedStatsJson.setHighestKillStreak(nodeTotal.get("highestKillStreak").asInt());
        detailedStatsJson.setNemesisKills(nodeTotal.get("nemesisKills").asInt());
        detailedStatsJson.setNemesisKillStreak(nodeTotal.get("nemesisKillStreak").asInt());
        detailedStatsJson.setKillAssists(nodeTotal.get("killAssists").asInt());
        detailedStatsJson.setAvengerKills(nodeTotal.get("avengerKills").asInt());
        detailedStatsJson.setSaviorKills(nodeTotal.get("saviorKills").asInt());
        detailedStatsJson.setDogtagsTaken(nodeTotal.get("dogtagsTaken").asInt());
        detailedStatsJson.setSpm(nodeBasic.get("spm").asDouble());
        detailedStatsJson.setSkill(nodeBasic.get("skill").asDouble());
        detailedStatsJson.setHeals(nodeTotal.get("heals").asInt());
        detailedStatsJson.setRevives(nodeTotal.get("revives").asInt());
        detailedStatsJson.setRepairs(nodeTotal.get("repairs").asInt());
        detailedStatsJson.setSuppressionAssist(nodeTotal.get("suppressionAssist").asInt());
        detailedStatsJson.setFlagsDefended(nodeTotal.get("flagsDefended").asInt());
        detailedStatsJson.setFlagsCaptured(nodeTotal.get("flagsCaptured").asInt());
        detailedStatsJson.setSquadScore(nodeTotal.get("squadScore").asInt());
        detailedStatsJson.setAwardScore(nodeTotal.get("awardScore").asInt());
        detailedStatsJson.setBonusScore(nodeTotal.get("bonusScore").asInt());
        detailedStatsJson.setWins(nodeBasic.get("wins").asInt());
        detailedStatsJson.setLosses(nodeBasic.get("losses").asInt());
        detailedStatsJson.setTimePlayed(nodeBasic.get("timePlayed").asInt());
        detailedStatsJson.setRoundsPlayed(nodeTotal.get("roundsPlayed").asInt());
        detailedStatsJson.setGameModeStats(mapArray(GameModeJson.class, ctxt, nodeTotal.get("gameModeStats")));
        detailedStatsJson.setKitStats(mapArray(ClassStatsJson.class, ctxt, nodeTotal.get("kitStats")));
        detailedStatsJson.setVehicleStats(mapArray(VehicleStatsJson.class, ctxt, nodeTotal.get("vehicleStats")));
        return detailedStatsJson;
    }

    @SuppressWarnings("unchecked")
    private <T> List<T> mapArray(Class<T> clazz, DeserializationContext ctxt, JsonNode jsonNode) throws IOException {
        JavaType javaType = ctxt.getTypeFactory().constructType(clazz);
        JsonDeserializer<?> deserializer = ctxt.findRootValueDeserializer(javaType);
        List<T> results = new ArrayList<>();
        for (Iterator<JsonNode> elements = jsonNode.elements(); elements.hasNext();) {
            JsonParser parser = elements.next().traverse(ctxt.getParser().getCodec());
            parser.nextToken();
            results.add((T) deserializer.deserialize(parser, ctxt));
        }
        return results;
    }
}

package com.bf1stats.transformers;

import com.bf1stats.domain.db.basic.ClassStatsDb;
import com.bf1stats.domain.db.basic.DetailedStatsDb;
import com.bf1stats.domain.db.basic.GameModeDb;
import com.bf1stats.domain.db.basic.VehicleStatsDb;
import com.bf1stats.domain.json.basic.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Component
public class DetailedStatsTransformer {

    public DetailedStatsDb transform(DetailedStatsJson detailedStatsJson) {
        DetailedStatsDb detailedStatsDb = new DetailedStatsDb();

        detailedStatsDb.setHeadShots(detailedStatsJson.getHeadShots());
        detailedStatsDb.setHighestKillStreak(detailedStatsJson.getHighestKillStreak());
        detailedStatsDb.setKillAssists(detailedStatsJson.getKillAssists());
        detailedStatsDb.setAvengerKills(detailedStatsJson.getAvengerKills());
        detailedStatsDb.setSaviorKills(detailedStatsJson.getSaviorKills());
        detailedStatsDb.setDogtagsTaken(detailedStatsJson.getDogtagsTaken());

        detailedStatsDb.setHeals(detailedStatsJson.getHeals());
        detailedStatsDb.setRevives(detailedStatsJson.getRevives());
        detailedStatsDb.setRepairs(detailedStatsJson.getRepairs());
        detailedStatsDb.setSuppressionAssist(detailedStatsJson.getSuppressionAssist());
        detailedStatsDb.setFlagsDefended(detailedStatsJson.getFlagsDefended());
        detailedStatsDb.setFlagsCaptured(detailedStatsJson.getFlagsCaptured());
        detailedStatsDb.setAwardScore(detailedStatsJson.getAwardScore());
        detailedStatsDb.setBonusScore(detailedStatsJson.getBonusScore());

        detailedStatsDb.setRoundsPlayed(detailedStatsJson.getRoundsPlayed());
        BasicStatsJson basicStatsJson = detailedStatsJson.getBasicStats();
        detailedStatsDb.setKills(basicStatsJson.getKills());
        detailedStatsDb.setDeaths(basicStatsJson.getDeaths());
        detailedStatsDb.setWins(basicStatsJson.getWins());
        detailedStatsDb.setLosses(basicStatsJson.getLosses());
        detailedStatsDb.setSpm(basicStatsJson.getSpm());
        detailedStatsDb.setSkill(basicStatsJson.getSkill());
        detailedStatsDb.setTimePlayed(basicStatsJson.getTimePlayed());
        detailedStatsDb.setKpm(basicStatsJson.getKpm());

        detailedStatsDb.setGameModeDb(
                detailedStatsJson.getGameModeStats().stream()
                .map(this::transformGameMode)
                .collect(Collectors.toList())
        );

        detailedStatsDb.setClassStatsDb(
                detailedStatsJson.getKitStats().stream()
                .map(this::transformClassStats)
                .collect(Collectors.toList())
        );

        detailedStatsDb.setVehicleStatsDb(
                detailedStatsJson.getVehicleStats().stream()
                .map(this::transformVehicleStats)
                .collect(Collectors.toList())
        );

        detailedStatsDb.setRecorded(LocalDateTime.now());

        return detailedStatsDb;
    }

    private GameModeDb transformGameMode(GameModeJson input) {
        GameModeDb output = new GameModeDb();

        output.setName(input.getName());
        output.setWins(input.getWins());
        output.setLosses(input.getLosses());
        output.setScore(input.getScore());

        return output;
    }

    private ClassStatsDb transformClassStats(ClassStatsJson input) {
        ClassStatsDb output = new ClassStatsDb();

        output.setName(input.getName());
        output.setKills(input.getKills());
        output.setScore(input.getScore());
        output.setSecondsAs(input.getSecondsAs());

        return output;
    }

    private VehicleStatsDb transformVehicleStats(VehicleStatsJson input) {
        VehicleStatsDb output = new VehicleStatsDb();

        output.setName(input.getName());
        output.setKillsAs(input.getKillsAs());
        output.setTimeSpent(input.getTimeSpent());

        return output;
    }
}

package com.bf1stats.transformers;

import com.bf1stats.domain.db.*;
import com.bf1stats.domain.json.basic.*;
import com.bf1stats.domain.json.vehicles.VehicleJson;
import com.bf1stats.domain.json.vehicles.VehiclesJson;
import com.bf1stats.domain.json.weapons.WeaponJson;
import com.bf1stats.domain.json.weapons.WeaponsJson;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class DetailedStatsTransformer {

    public DetailedStatsDb transform(DetailedStatsJson detailedStatsJson, List<VehiclesJson> vehiclesJson, List<WeaponsJson> weaponsJsons) {
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

        detailedStatsDb.setVehicleDetailsDb(
                vehiclesJson.stream()
                .flatMap(vs -> flatMapVehicles(vs.getVehicles(), vs.getName()))
                .collect(Collectors.toList())
        );

        detailedStatsDb.setWeaponDetailsDb(
                weaponsJsons.stream()
                .flatMap(ws -> flatMapWeapons(ws.getWeapons(), ws.getName()))
                .collect(Collectors.toList())
        );

        detailedStatsDb.setRecorded(ZonedDateTime.now(ZoneId.of("UTC")).toLocalDateTime());

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

    private Stream<VehicleDetailsDb> flatMapVehicles(List<VehicleJson> vehicles, String category) {
        return vehicles.stream()
                .map(v -> {
                    VehicleDetailsDb vehicleDetailsDb = new VehicleDetailsDb();
                    vehicleDetailsDb.setCategory(category);
                    vehicleDetailsDb.setName(v.getName());
                    vehicleDetailsDb.setTimeIn(v.getTimeIn());
                    vehicleDetailsDb.setKills(v.getKills());
                    vehicleDetailsDb.setDestroyed(v.getDestroyed());
                    return vehicleDetailsDb;
                });
    }

    private Stream<WeaponDetailsDb> flatMapWeapons(List<WeaponJson> weapons, String category) {
        return weapons.stream()
                .map(w -> {
                    WeaponDetailsDb weaponDetailsDb = new WeaponDetailsDb();
                    weaponDetailsDb.setCategory(category);
                    weaponDetailsDb.setName(w.getName());
                    weaponDetailsDb.setKills(w.getKills());
                    weaponDetailsDb.setShots(w.getShots());
                    weaponDetailsDb.setHits(w.getHits());
                    weaponDetailsDb.setAccuracy(w.getAccuracy());
                    weaponDetailsDb.setHeadshots(w.getHeadshots());
                    weaponDetailsDb.setTimeUsed(w.getTimeUsed());
                    return weaponDetailsDb;
                });
    }
}

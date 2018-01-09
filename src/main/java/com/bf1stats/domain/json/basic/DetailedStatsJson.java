package com.bf1stats.domain.json.basic;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;

@JsonDeserialize(using = DetailedStatsDeserializer.class)
public class DetailedStatsJson {

    // K/D
    private int kills;
    private int deaths;
    private double kpm;
    private int headShots;
    private int highestKillStreak;
    private int nemesisKills;
    private int nemesisKillStreak;
    private int killAssists;
    private int avengerKills;
    private int saviorKills;
    private int dogtagsTaken;

    // PTFO
    private double spm;
    private double skill;
    private int heals;
    private int revives;
    private int repairs;
    private int suppressionAssist;
    private int flagsDefended;
    private int flagsCaptured;
    private int squadScore;
    private int awardScore;
    private int bonusScore;

    // General
    private int wins;
    private int losses;
    private int timePlayed;
    private int roundsPlayed;

    private List<GameModeJson> gameModeStats;
    private List<ClassStatsJson> kitStats;
    private List<VehicleStatsJson> vehicleStats;

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public double getKpm() {
        return kpm;
    }

    public void setKpm(double kpm) {
        this.kpm = kpm;
    }

    public int getHeadShots() {
        return headShots;
    }

    public void setHeadShots(int headShots) {
        this.headShots = headShots;
    }

    public int getHighestKillStreak() {
        return highestKillStreak;
    }

    public void setHighestKillStreak(int highestKillStreak) {
        this.highestKillStreak = highestKillStreak;
    }

    public int getNemesisKills() {
        return nemesisKills;
    }

    public void setNemesisKills(int nemesisKills) {
        this.nemesisKills = nemesisKills;
    }

    public int getNemesisKillStreak() {
        return nemesisKillStreak;
    }

    public void setNemesisKillStreak(int nemesisKillStreak) {
        this.nemesisKillStreak = nemesisKillStreak;
    }

    public int getKillAssists() {
        return killAssists;
    }

    public void setKillAssists(int killAssists) {
        this.killAssists = killAssists;
    }

    public int getAvengerKills() {
        return avengerKills;
    }

    public void setAvengerKills(int avengerKills) {
        this.avengerKills = avengerKills;
    }

    public int getSaviorKills() {
        return saviorKills;
    }

    public void setSaviorKills(int saviorKills) {
        this.saviorKills = saviorKills;
    }

    public int getDogtagsTaken() {
        return dogtagsTaken;
    }

    public void setDogtagsTaken(int dogtagsTaken) {
        this.dogtagsTaken = dogtagsTaken;
    }

    public double getSpm() {
        return spm;
    }

    public void setSpm(double spm) {
        this.spm = spm;
    }

    public double getSkill() {
        return skill;
    }

    public void setSkill(double skill) {
        this.skill = skill;
    }

    public int getHeals() {
        return heals;
    }

    public void setHeals(int heals) {
        this.heals = heals;
    }

    public int getRevives() {
        return revives;
    }

    public void setRevives(int revives) {
        this.revives = revives;
    }

    public int getRepairs() {
        return repairs;
    }

    public void setRepairs(int repairs) {
        this.repairs = repairs;
    }

    public int getSuppressionAssist() {
        return suppressionAssist;
    }

    public void setSuppressionAssist(int suppressionAssist) {
        this.suppressionAssist = suppressionAssist;
    }

    public int getFlagsDefended() {
        return flagsDefended;
    }

    public void setFlagsDefended(int flagsDefended) {
        this.flagsDefended = flagsDefended;
    }

    public int getFlagsCaptured() {
        return flagsCaptured;
    }

    public void setFlagsCaptured(int flagsCaptured) {
        this.flagsCaptured = flagsCaptured;
    }

    public int getSquadScore() {
        return squadScore;
    }

    public void setSquadScore(int squadScore) {
        this.squadScore = squadScore;
    }

    public int getAwardScore() {
        return awardScore;
    }

    public void setAwardScore(int awardScore) {
        this.awardScore = awardScore;
    }

    public int getBonusScore() {
        return bonusScore;
    }

    public void setBonusScore(int bonusScore) {
        this.bonusScore = bonusScore;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getTimePlayed() {
        return timePlayed;
    }

    public void setTimePlayed(int timePlayed) {
        this.timePlayed = timePlayed;
    }

    public int getRoundsPlayed() {
        return roundsPlayed;
    }

    public void setRoundsPlayed(int roundsPlayed) {
        this.roundsPlayed = roundsPlayed;
    }

    public List<GameModeJson> getGameModeStats() {
        return gameModeStats;
    }

    public void setGameModeStats(List<GameModeJson> gameModeStats) {
        this.gameModeStats = gameModeStats;
    }

    public List<ClassStatsJson> getKitStats() {
        return kitStats;
    }

    public void setKitStats(List<ClassStatsJson> kitStats) {
        this.kitStats = kitStats;
    }

    public List<VehicleStatsJson> getVehicleStats() {
        return vehicleStats;
    }

    public void setVehicleStats(List<VehicleStatsJson> vehicleStats) {
        this.vehicleStats = vehicleStats;
    }
}

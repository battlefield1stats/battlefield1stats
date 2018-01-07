package com.bf1stats.domain.basic;

import java.util.List;

public class DetailedStats {

    // K/D
    private int headShots;
    private int highestKillStreak;
    private int killAssists;
    private int avengerKills;
    private int saviorKills;
    private int dogtagsTaken;

    // PTFO
    private int heals;
    private int revives;
    private int repairs;
    private int suppressionAssist;
    private int flagsDefended;
    private int flagsCaptured;
    private double awardScore;
    private double bonusScore;

    // General
    private int roundsPlayed;
    private BasicStats basicStats;

    private List<GameMode> gameModeStats;
    private List<ClassStats> kitStats;
    private List<VehicleStats> vehicleStats;

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

    public double getAwardScore() {
        return awardScore;
    }

    public void setAwardScore(double awardScore) {
        this.awardScore = awardScore;
    }

    public double getBonusScore() {
        return bonusScore;
    }

    public void setBonusScore(double bonusScore) {
        this.bonusScore = bonusScore;
    }

    public int getRoundsPlayed() {
        return roundsPlayed;
    }

    public void setRoundsPlayed(int roundsPlayed) {
        this.roundsPlayed = roundsPlayed;
    }

    public BasicStats getBasicStats() {
        return basicStats;
    }

    public void setBasicStats(BasicStats basicStats) {
        this.basicStats = basicStats;
    }

    public List<GameMode> getGameModeStats() {
        return gameModeStats;
    }

    public void setGameModeStats(List<GameMode> gameModeStats) {
        this.gameModeStats = gameModeStats;
    }

    public List<ClassStats> getKitStats() {
        return kitStats;
    }

    public void setKitStats(List<ClassStats> kitStats) {
        this.kitStats = kitStats;
    }

    public List<VehicleStats> getVehicleStats() {
        return vehicleStats;
    }

    public void setVehicleStats(List<VehicleStats> vehicleStats) {
        this.vehicleStats = vehicleStats;
    }
}

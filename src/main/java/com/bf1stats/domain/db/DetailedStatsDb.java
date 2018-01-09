package com.bf1stats.domain.db;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "DETAILED_STATS")
public class DetailedStatsDb {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    // K/D
    @Column(name = "HEADSHOTS")
    private int headShots;

    @Column(name = "HIGHEST_KILL_STREAK")
    private int highestKillStreak;

    @Column(name = "NEMESIS_KILLS")
    private int nemesisKills;

    @Column(name = "NEMESIS_KILL_STREAK")
    private int nemesisKillStreak;

    @Column(name = "KILL_ASSISTS")
    private int killAssists;

    @Column(name = "AVENGER_KILLS")
    private int avengerKills;

    @Column(name = "SAVIOR_KILLS")
    private int saviorKills;

    @Column(name = "DOGTAGS_TAKEN")
    private int dogtagsTaken;

    // PTFO
    @Column(name = "HEALS")
    private int heals;

    @Column(name = "REVIVES")
    private int revives;

    @Column(name = "REPAIRS")
    private int repairs;

    @Column(name = "SUPPRESSION_ASSIST")
    private int suppressionAssist;

    @Column(name = "FLAGS_DEFENDED")
    private int flagsDefended;

    @Column(name = "FLAGS_CAPTURED")
    private int flagsCaptured;

    @Column(name = "AWARD_SCORE")
    private double awardScore;

    @Column(name = "BONUS_SCORE")
    private double bonusScore;

    // General
    @Column(name = "ROUNDS_PLAYED")
    private int roundsPlayed;

    @Column(name = "KILLS")
    private int kills;

    @Column(name = "DEATHS")
    private int deaths;

    @Column(name = "WINS")
    private int wins;

    @Column(name = "LOSSES")
    private int losses;

    @Column(name = "SPM")
    private double spm;

    @Column(name = "SKILL")
    private double skill;

    @Column(name = "TIME_PLAYED")
    private int timePlayed;

    @Column(name = "KPM")
    private double kpm;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<GameModeDb> gameModeDb;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<ClassStatsDb> classStatsDb;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<VehicleStatsDb> vehicleStatsDb;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<VehicleDetailsDb> vehicleDetailsDb;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<WeaponDetailsDb> weaponDetailsDb;

    @Column(name = "RECORDED")
    private LocalDateTime recorded;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public int getTimePlayed() {
        return timePlayed;
    }

    public void setTimePlayed(int timePlayed) {
        this.timePlayed = timePlayed;
    }

    public double getKpm() {
        return kpm;
    }

    public void setKpm(double kpm) {
        this.kpm = kpm;
    }

    public List<GameModeDb> getGameModeDb() {
        return gameModeDb;
    }

    public void setGameModeDb(List<GameModeDb> gameModeDb) {
        this.gameModeDb = gameModeDb;
    }

    public List<ClassStatsDb> getClassStatsDb() {
        return classStatsDb;
    }

    public void setClassStatsDb(List<ClassStatsDb> classStatsDb) {
        this.classStatsDb = classStatsDb;
    }

    public List<VehicleStatsDb> getVehicleStatsDb() {
        return vehicleStatsDb;
    }

    public void setVehicleStatsDb(List<VehicleStatsDb> vehicleStatsDb) {
        this.vehicleStatsDb = vehicleStatsDb;
    }

    public List<VehicleDetailsDb> getVehicleDetailsDb() {
        return vehicleDetailsDb;
    }

    public void setVehicleDetailsDb(List<VehicleDetailsDb> vehicleDetailsDb) {
        this.vehicleDetailsDb = vehicleDetailsDb;
    }

    public List<WeaponDetailsDb> getWeaponDetailsDb() {
        return weaponDetailsDb;
    }

    public void setWeaponDetailsDb(List<WeaponDetailsDb> weaponDetailsDb) {
        this.weaponDetailsDb = weaponDetailsDb;
    }

    public LocalDateTime getRecorded() {
        return recorded;
    }

    public void setRecorded(LocalDateTime recorded) {
        this.recorded = recorded;
    }
}

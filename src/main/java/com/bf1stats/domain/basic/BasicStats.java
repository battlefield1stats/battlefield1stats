package com.bf1stats.domain.basic;

public class BasicStats {

    private int kills;
    private int deaths;
    private int wins;
    private int losses;
    private double spm;
    private double skill;
    private int timePlayed;
    private double kpm;

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
}

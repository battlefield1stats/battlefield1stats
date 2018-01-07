package com.bf1stats.domain.json.basic;

public class ClassStatsJson {

    private String name;
    private int kills;
    private int score;
    private double secondsAs;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public double getSecondsAs() {
        return secondsAs;
    }

    public void setSecondsAs(double secondsAs) {
        this.secondsAs = secondsAs;
    }
}

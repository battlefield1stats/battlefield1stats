package com.bf1stats.domain.basic;

public class ClassStats {

    private String name;
    private String prettyName;
    private int kills;
    private int score;
    private double secondsAs;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrettyName() {
        return prettyName;
    }

    public void setPrettyName(String prettyName) {
        this.prettyName = prettyName;
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

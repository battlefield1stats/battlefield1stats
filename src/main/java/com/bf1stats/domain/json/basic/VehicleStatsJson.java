package com.bf1stats.domain.json.basic;

public class VehicleStatsJson {

    private String name;
    private int killsAs;
    private double timeSpent;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKillsAs() {
        return killsAs;
    }

    public void setKillsAs(int killsAs) {
        this.killsAs = killsAs;
    }

    public double getTimeSpent() {
        return timeSpent;
    }

    public void setTimeSpent(double timeSpent) {
        this.timeSpent = timeSpent;
    }
}

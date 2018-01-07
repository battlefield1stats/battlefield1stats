package com.bf1stats.domain.basic;

public class VehicleStats {

    private String name;
    private String prettyName;
    private int killsAs;
    private double timeSpent;

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

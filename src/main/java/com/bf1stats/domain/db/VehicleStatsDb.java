package com.bf1stats.domain.db;

import javax.persistence.*;

@Entity
@Table(name = "VEHICLE_STATS")
public class VehicleStatsDb {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "KILLS_AS")
    private int killsAs;

    @Column(name = "TIME_SPENT")
    private double timeSpent;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

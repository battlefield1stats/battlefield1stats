package com.bf1stats.domain.db.basic;

import javax.persistence.*;

@Entity
@Table(name = "CLASS_STATS")
public class ClassStatsDb {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "KILLS")
    private int kills;

    @Column(name = "SCORE")
    private int score;

    @Column(name = "SECONDS_AS")
    private double secondsAs;

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

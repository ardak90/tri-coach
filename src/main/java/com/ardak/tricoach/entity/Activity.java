package com.ardak.tricoach.entity;


import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "activities")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Sport sport;

    private Instant startTime;

    private int durationSeconds;

    private Double distanceMeters;

    private Integer avgHeartRate;

    private String fileHash;

    protected Activity(){

    }

    public Activity(Sport sport, Instant startTime, int durationSeconds, Double distanceMeters, Integer avgHeartRate, String fileHash) {
        this.sport = sport;
        this.startTime = startTime;
        this.durationSeconds = durationSeconds;
        this.distanceMeters = distanceMeters;
        this.avgHeartRate = avgHeartRate;
        this.fileHash = fileHash;
    }

    public Sport getSport() {
        return sport;
    }

    public Instant getStartTime() {
        return startTime;
    }

    public int getDurationSeconds() {
        return durationSeconds;
    }

    public Double getDistanceMeters() {
        return distanceMeters;
    }

    public Integer getAvgHeartRate() {
        return avgHeartRate;
    }

    public String getFileHash() {
        return fileHash;
    }
}

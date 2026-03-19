package com.cg.entity;

import jakarta.persistence.*;

@Entity
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int traineeId;
    private String  traineeName;
    private String traineeLocation;
    private String traineeDomain;
    public Trainer(){

    }

    public Trainer( String traineeName, String traineeLocation, String traineeDomain) {
        this.traineeName = traineeName;
        this.traineeLocation = traineeLocation;
        this.traineeDomain = traineeDomain;
    }

    public int getTraineeId() {
        return traineeId;
    }

    public void setTraineeId(int traineeId) {
        this.traineeId = traineeId;
    }

    public String getTraineeName() {
        return traineeName;
    }

    public void setTraineeName(String traineeName) {
        this.traineeName = traineeName;
    }

    public String getTraineeLocation() {
        return traineeLocation;
    }

    public void setTraineeLocation(String traineeLocation) {
        this.traineeLocation = traineeLocation;
    }

    public String getTraineeDomain() {
        return traineeDomain;
    }

    public void setTraineeDomain(String traineeDomain) {
        this.traineeDomain = traineeDomain;
    }
}

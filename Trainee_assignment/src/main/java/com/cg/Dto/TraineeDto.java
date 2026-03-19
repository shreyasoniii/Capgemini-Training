package com.cg.Dto;

public class TraineeDto {
    private int trainId;
    private String trainName;
    private String trainLocation;
    private  String trainDomain;

    public TraineeDto(int trainId, String trainName, String trainLocation, String trainDomain) {
        this.trainId = trainId;
        this.trainName = trainName;
        this.trainLocation = trainLocation;
        this.trainDomain = trainDomain;
    }

    public int getTrainId() {
        return trainId;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public String getTrainLocation() {
        return trainLocation;
    }

    public void setTrainLocation(String trainLocation) {
        this.trainLocation = trainLocation;
    }

    public String getTrainDomain() {
        return trainDomain;
    }

    public void setTrainDomain(String trainDomain) {
        this.trainDomain = trainDomain;
    }
}

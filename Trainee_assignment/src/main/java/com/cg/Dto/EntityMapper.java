package com.cg.Dto;

import com.cg.entity.Trainer;

public class EntityMapper {
    public static TraineeDto convertEntitytoDto(Trainer trainee){
        TraineeDto traineeDto=new TraineeDto(trainee.getTraineeId(), trainee.getTraineeName(), trainee.getTraineeLocation(), trainee.getTraineeDomain());
        return traineeDto;
    }

    public static Trainer convertDtoToEntity(TraineeDto traineeDto){
        Trainer trainee=new Trainer(traineeDto.getTrainName(), traineeDto.getTrainLocation(), traineeDto.getTrainDomain());
        return trainee;
    }
}

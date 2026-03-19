package com.cg.Service;

import com.cg.Dto.TraineeDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ITraineeJPAService {
    public List<TraineeDto> getAllTrainee();
    public TraineeDto createTrainee(TraineeDto traineedto);
    public TraineeDto getTrainee(int id);
    public TraineeDto updateTrainee(TraineeDto traineeDto);
    public String removeTrainee(int id);
    public List<TraineeDto> getTrainerByName(String traineeName);
}

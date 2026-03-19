package com.cg.Service;

import com.cg.Dto.EntityMapper;
import com.cg.Dto.TraineeDto;
import com.cg.entity.Trainer;
import com.cg.repo.ITraineeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TraineeService implements ITraineeJPAService{
    @Autowired
    private ITraineeRepo repo;
    @Override
    public List<TraineeDto> getAllTrainee() {
       List<Trainer>trainers=repo.findAll();
       List<TraineeDto>traineeDto=new ArrayList<>();
       for(Trainer train:trainers){
           traineeDto.add(EntityMapper.convertEntitytoDto(train));
       }
       return traineeDto;
    }

    @Override
    public TraineeDto createTrainee(TraineeDto traineedto) {
        Trainer t=repo.saveAndFlush(EntityMapper.convertDtoToEntity(traineedto));
        return EntityMapper.convertEntitytoDto(t);
    }

    @Override
    public TraineeDto updateTrainee(TraineeDto traineeDto) {
        Optional<Trainer> trainee = repo.findById(traineeDto.getTrainId());
        if(trainee.isPresent()){
            Trainer t1=EntityMapper.convertDtoToEntity(traineeDto);
            t1.setTraineeId(traineeDto.getTrainId());
            Trainer t=repo.saveAndFlush(t1);
            return EntityMapper.convertEntitytoDto(t);

        }
        else {
            return null;
        }

    }

    @Override
    public TraineeDto getTrainee(int id) {
       Optional<Trainer> trainer=repo.findById(id);
       if(trainer.isPresent()) {
           return EntityMapper.convertEntitytoDto(trainer.get());
       }
       else{
           return  null;
       }
    }

    @Override
    public String removeTrainee(int id) {
       repo.deleteById(id);
       return "Trainee Deleted";
    }

    @Override
    public List<TraineeDto> getTrainerByName(String traineeName) {
        List<Trainer>trainersList=repo.findBytraineeName(traineeName);
        List<TraineeDto>traineeDtosList=new ArrayList<>();
        for(Trainer trainer:trainersList){
            traineeDtosList.add(EntityMapper.convertEntitytoDto(trainer));
        }
       return traineeDtosList;
    }
}

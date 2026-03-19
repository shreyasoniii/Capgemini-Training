package com.cg.controller;

import com.cg.Dto.TraineeDto;
import com.cg.Service.ITraineeJPAService;
import com.cg.entity.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("trainee")
public class TraineeController {
    @Autowired
    private ITraineeJPAService service;

    @GetMapping
    public List<TraineeDto> getAllTrainee() {
        return service.getAllTrainee();
    }
    @GetMapping("/{tid}")
    public TraineeDto getTraineeById(@PathVariable int tid) {
        return service.getTrainee(tid);
    }
    @PostMapping
        public TraineeDto createTrainee(@RequestBody TraineeDto trainedto) {
            return service.createTrainee(trainedto);
        }
    @PutMapping
    public TraineeDto updateTrainee(@RequestBody TraineeDto traineeDto){
        return service.updateTrainee(traineeDto);
    }

    @DeleteMapping("/{id}")
    public String removeTrainee(@PathVariable int id){
        return service.removeTrainee(id);
    }

    @GetMapping("/name/{traineeName}")
    public List<TraineeDto> getTrainerByName(@PathVariable String traineeName){
        return service.getTrainerByName(traineeName);
    }

}

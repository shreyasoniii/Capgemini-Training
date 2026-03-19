package com.cg.repo;

import com.cg.Dto.TraineeDto;
import com.cg.entity.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITraineeRepo extends JpaRepository<Trainer,Integer> {
  //  public List<Trainer> findBytraineeName(String traineeName);

    public List<Trainer> findBytraineeName(String traineeName);
}

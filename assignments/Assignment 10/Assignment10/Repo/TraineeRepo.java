package com.example.Assignment7.Repo;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Assignment7.Entities.Trainee;


@Repository
public interface TraineeRepo  extends JpaRepository<Trainee,Integer> {
   // List<Trainee> findByTraineeName(String name);
	 Optional<Trainee> findBytraineeName(String name);
  //  Optional<Trainee> getTraineeById(int id);
}

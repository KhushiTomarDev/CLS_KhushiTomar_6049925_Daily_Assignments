package com.example.Assignment7.Repo;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Assignment7.Entities.Trainee;


@Repository
public interface TraineeRepo  extends JpaRepository<Trainee,Integer> {
	
}

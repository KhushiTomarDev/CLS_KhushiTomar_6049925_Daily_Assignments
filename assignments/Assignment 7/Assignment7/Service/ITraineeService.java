package com.example.Assignment7.Service;

import java.util.List;
import java.util.Optional;

import com.example.Assignment7.Entities.Trainee;

public interface ITraineeService {
	Trainee addTrainee(Trainee t);
    void deleteTrainee(int id);
    Trainee updateTrainee(int id, Trainee t);
    Optional<Trainee> getTrainee(int id);
    List<Trainee> getAllTrainees();
}

package com.example.Assignment7.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Trainee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int TraineeId;
	@NotEmpty(message = "Name of the employee can not be empty")
	private String traineeName;
	@NotEmpty(message = "Location of the employee can not be empty")
	private String TraineeLocation;
	private String TraineeDomain;
	
	
	public Trainee(int traineeId, @NotEmpty(message = "Name of the employee can not be empty") String traineeName,
			@NotEmpty(message = "Location of the employee can not be empty") String traineeLocation,
			String traineeDomain) {
		super();
		TraineeId = traineeId;
		this.traineeName = traineeName;
		TraineeLocation = traineeLocation;
		TraineeDomain = traineeDomain;
	}
	public String getTraineeName() {
		return traineeName;
	}
	public int getTraineeId() {
		return TraineeId;
	}
	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}
	public String getTraineeLocation() {
		return TraineeLocation;
	}
	public void setTraineeLocation(String traineeLocation) {
		TraineeLocation = traineeLocation;
	}
	public String getTraineeDomain() {
		return TraineeDomain;
	}
	public void setTraineeDomain(String traineeDomain) {
		TraineeDomain = traineeDomain;
	}
	@Override
	public String toString() {
		return "Trainee [TraineeId=" + TraineeId + ", TraineNeame=" + traineeName + ", TraineeLocation="
				+ TraineeLocation + ", TraineeDomain=" + TraineeDomain + "]";
	}
	
}

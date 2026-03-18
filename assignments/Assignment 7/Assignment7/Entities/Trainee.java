package com.example.Assignment7.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Trainee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int TraineeId;
	private String TraineeName;
	private String TraineeLocation;
	private String TraineeDomain;
	
	
	public String getTraineeName() {
		return TraineeName;
	}
	public int getTraineeId() {
		return TraineeId;
	}
	public void setTraineeName(String traineeName) {
		TraineeName = traineeName;
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
		return "Trainee [TraineeId=" + TraineeId + ", TraineNeame=" + TraineeName + ", TraineeLocation="
				+ TraineeLocation + ", TraineeDomain=" + TraineeDomain + "]";
	}
	
}
